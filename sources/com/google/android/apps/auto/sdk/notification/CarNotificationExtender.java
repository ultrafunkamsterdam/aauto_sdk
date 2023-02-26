package com.google.android.apps.auto.sdk.notification;

import android.app.Notification;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;

public class CarNotificationExtender implements NotificationCompat.Extender {

    /* renamed from: a */
    private boolean f189a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Long f190b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CharSequence f191c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CharSequence f192d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Bitmap f193e;
    /* access modifiers changed from: private */
    @DrawableRes

    /* renamed from: f */
    public int f194f;
    /* access modifiers changed from: private */
    @DrawableRes

    /* renamed from: g */
    public Intent f195g;
    /* access modifiers changed from: private */
    @ColorInt

    /* renamed from: h */
    public int f196h;
    /* access modifiers changed from: private */
    @ColorInt

    /* renamed from: i */
    public int f197i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f198j;

    public static class Builder {
        @NonNull

        /* renamed from: a */
        private final CarNotificationExtender f199a = new CarNotificationExtender((byte) 0);

        public CarNotificationExtender build() {
            if (TextUtils.isEmpty(this.f199a.f191c)) {
                throw new IllegalArgumentException("A title is required.");
            } else if (this.f199a.f194f == 0) {
                throw new IllegalArgumentException("An action icon is required");
            } else if (!this.f199a.f198j || this.f199a.f193e != null) {
                return this.f199a;
            } else {
                throw new IllegalArgumentException("A thumbnail icon is required for heads up notification.");
            }
        }

        public Builder setActionIconResId(@DrawableRes int i) {
            int unused = this.f199a.f194f = i;
            return this;
        }

        public Builder setActionIntent(Intent intent) {
            Intent unused = this.f199a.f195g = intent;
            return this;
        }

        public Builder setBackgroundColor(@ColorInt int i) {
            int unused = this.f199a.f196h = i;
            return this;
        }

        public Builder setContentId(long j) {
            Long unused = this.f199a.f190b = Long.valueOf(j);
            return this;
        }

        public Builder setNightBackgroundColor(@ColorInt int i) {
            int unused = this.f199a.f197i = i;
            return this;
        }

        public Builder setShouldShowAsHeadsUp(boolean z) {
            boolean unused = this.f199a.f198j = z;
            return this;
        }

        public Builder setSubtitle(CharSequence charSequence) {
            CharSequence unused = this.f199a.f192d = charSequence;
            return this;
        }

        public Builder setThumbnail(Bitmap bitmap) {
            Bitmap unused = this.f199a.f193e = bitmap;
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            CharSequence unused = this.f199a.f191c = charSequence;
            return this;
        }
    }

    private CarNotificationExtender() {
        this.f196h = 0;
        this.f197i = 0;
    }

    /* synthetic */ CarNotificationExtender(byte b) {
        this();
    }

    public CarNotificationExtender(@NonNull Notification notification) {
        this.f196h = 0;
        this.f197i = 0;
        Bundle bundle = NotificationCompat.getExtras(notification) == null ? null : NotificationCompat.getExtras(notification).getBundle("android.car.EXTENSIONS");
        if (bundle != null) {
            this.f189a = bundle.getBoolean("com.google.android.gms.car.support.CarNotificationExtender.EXTENDED");
            this.f190b = (Long) bundle.getSerializable("content_id");
            this.f191c = bundle.getCharSequence("android.title");
            this.f192d = bundle.getCharSequence("subtitle");
            this.f193e = (Bitmap) bundle.getParcelable("thumbnail");
            this.f194f = bundle.getInt("action_icon");
            this.f195g = (Intent) bundle.getParcelable("content_intent");
            this.f196h = bundle.getInt("app_color", 0);
            this.f197i = bundle.getInt("app_night_color", 0);
            this.f198j = bundle.getBoolean("heads_up_visibility");
        }
    }

    public NotificationCompat.Builder extend(NotificationCompat.Builder builder) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.car.support.CarNotificationExtender.EXTENDED", true);
        bundle.putSerializable("content_id", this.f190b);
        bundle.putCharSequence("android.title", this.f191c);
        bundle.putCharSequence("subtitle", this.f192d);
        bundle.putParcelable("thumbnail", this.f193e);
        bundle.putInt("action_icon", this.f194f);
        bundle.putParcelable("content_intent", this.f195g);
        bundle.putInt("app_color", this.f196h);
        bundle.putInt("app_night_color", this.f197i);
        bundle.putBoolean("heads_up_visibility", this.f198j);
        builder.getExtras().putBundle("android.car.EXTENSIONS", bundle);
        return builder;
    }

    @DrawableRes
    public int getActionIconResId() {
        return this.f194f;
    }

    @Nullable
    public Intent getActionIntent() {
        return this.f195g;
    }

    @ColorInt
    public int getBackgroundColor() {
        return this.f196h;
    }

    @Nullable
    public Long getContentId() {
        return this.f190b;
    }

    @ColorInt
    public int getNightBackgroundColor() {
        return this.f197i;
    }

    public boolean getShouldShowAsHeadsUp() {
        return this.f198j;
    }

    @Nullable
    public CharSequence getSubtitle() {
        return this.f192d;
    }

    public Bitmap getThumbnail() {
        return this.f193e;
    }

    @Nullable
    public CharSequence getTitle() {
        return this.f191c;
    }

    public boolean isExtended() {
        return this.f189a;
    }
}
