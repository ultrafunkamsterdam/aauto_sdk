package com.google.android.apps.auto.sdk.nav;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

public class CarNavExtender implements NotificationCompat.Extender {
    public static final int TYPE_HERO = 0;
    public static final int TYPE_NORMAL = 1;

    /* renamed from: a */
    private boolean f106a;

    /* renamed from: b */
    private Long f107b;

    /* renamed from: c */
    private int f108c = 1;

    /* renamed from: d */
    private CharSequence f109d;

    /* renamed from: e */
    private CharSequence f110e;

    /* renamed from: f */
    private CharSequence f111f;

    /* renamed from: g */
    private CharSequence f112g;

    /* renamed from: h */
    private CharSequence f113h;

    /* renamed from: i */
    private CharSequence f114i;

    /* renamed from: j */
    private Bitmap f115j;
    @DrawableRes

    /* renamed from: k */
    private int f116k;
    @DrawableRes

    /* renamed from: l */
    private int f117l;

    /* renamed from: m */
    private Intent f118m;

    /* renamed from: n */
    private PendingIntent f119n;

    /* renamed from: o */
    private int f120o = 0;

    /* renamed from: p */
    private int f121p = 0;

    /* renamed from: q */
    private boolean f122q = true;

    /* renamed from: r */
    private boolean f123r;

    /* renamed from: s */
    private boolean f124s;

    public CarNavExtender() {
    }

    public CarNavExtender(@NonNull Notification notification) {
        Bundle bundle;
        Bundle extras = NotificationCompat.getExtras(notification);
        if (extras != null && (bundle = extras.getBundle("android.car.EXTENSIONS")) != null) {
            this.f106a = bundle.getBoolean("com.google.android.gms.car.support.CarNavExtender.EXTENDED");
            this.f107b = (Long) bundle.getSerializable("content_id");
            this.f108c = bundle.getInt("type", 1) == 0 ? 0 : 1;
            this.f109d = bundle.getCharSequence("android.title");
            this.f110e = bundle.getCharSequence("android.title.night");
            this.f111f = bundle.getCharSequence("android.text");
            this.f112g = bundle.getCharSequence("android.text.night");
            this.f113h = bundle.getCharSequence("sub_text");
            this.f114i = bundle.getCharSequence("sub_text.night");
            this.f115j = (Bitmap) bundle.getParcelable("android.largeIcon");
            this.f116k = bundle.getInt("action_icon");
            this.f117l = bundle.getInt("action_icon.night");
            this.f118m = (Intent) bundle.getParcelable("content_intent");
            this.f119n = (PendingIntent) bundle.getParcelable("content_pending_intent");
            this.f120o = bundle.getInt("app_color", 0);
            this.f121p = bundle.getInt("app_night_color", 0);
            this.f122q = bundle.getBoolean("stream_visibility", true);
            this.f123r = bundle.getBoolean("heads_up_visibility");
            this.f124s = bundle.getBoolean("ignore_in_stream");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r1 = r1.getBundle("android.car.EXTENSIONS");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getType(android.app.Notification r3) {
        /*
            r0 = 1
            android.os.Bundle r1 = android.support.v4.app.NotificationCompat.getExtras(r3)
            if (r1 != 0) goto L_0x0008
        L_0x0007:
            return r0
        L_0x0008:
            java.lang.String r2 = "android.car.EXTENSIONS"
            android.os.Bundle r1 = r1.getBundle(r2)
            if (r1 == 0) goto L_0x0007
            java.lang.String r2 = "type"
            int r1 = r1.getInt(r2, r0)
            if (r1 != 0) goto L_0x0007
            r0 = 0
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.apps.auto.sdk.nav.CarNavExtender.getType(android.app.Notification):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = r0.getBundle("android.car.EXTENSIONS");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isExtended(android.app.Notification r2) {
        /*
            android.os.Bundle r0 = android.support.v4.app.NotificationCompat.getExtras(r2)
            if (r0 != 0) goto L_0x0008
        L_0x0006:
            r0 = 0
        L_0x0007:
            return r0
        L_0x0008:
            java.lang.String r1 = "android.car.EXTENSIONS"
            android.os.Bundle r0 = r0.getBundle(r1)
            if (r0 == 0) goto L_0x0006
            java.lang.String r1 = "com.google.android.gms.car.support.CarNavExtender.EXTENDED"
            boolean r0 = r0.getBoolean(r1)
            if (r0 == 0) goto L_0x0006
            r0 = 1
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.apps.auto.sdk.nav.CarNavExtender.isExtended(android.app.Notification):boolean");
    }

    public NotificationCompat.Builder extend(NotificationCompat.Builder builder) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.car.support.CarNavExtender.EXTENDED", true);
        bundle.putSerializable("content_id", this.f107b);
        bundle.putInt("type", this.f108c);
        bundle.putCharSequence("android.title", this.f109d);
        bundle.putCharSequence("android.title.night", this.f110e);
        bundle.putCharSequence("android.text", this.f111f);
        bundle.putCharSequence("android.text.night", this.f112g);
        bundle.putCharSequence("sub_text", this.f113h);
        bundle.putCharSequence("sub_text.night", this.f114i);
        bundle.putParcelable("android.largeIcon", this.f115j);
        bundle.putInt("action_icon", this.f116k);
        bundle.putInt("action_icon.night", this.f117l);
        bundle.putParcelable("content_intent", this.f118m);
        bundle.putParcelable("content_pending_intent", this.f119n);
        bundle.putInt("app_color", this.f120o);
        bundle.putInt("app_night_color", this.f121p);
        bundle.putBoolean("stream_visibility", this.f122q);
        bundle.putBoolean("heads_up_visibility", this.f123r);
        bundle.putBoolean("ignore_in_stream", this.f124s);
        builder.getExtras().putBundle("android.car.EXTENSIONS", bundle);
        return builder;
    }

    @Deprecated
    @DrawableRes
    public int getActionIcon() {
        return getActionIconDay();
    }

    @DrawableRes
    public int getActionIconDay() {
        return this.f116k;
    }

    @DrawableRes
    public int getActionIconNight() {
        return this.f117l;
    }

    @Deprecated
    public int getColor() {
        return getColorDay();
    }

    public int getColorDay() {
        return this.f120o;
    }

    public int getColorNight() {
        return this.f121p;
    }

    @Nullable
    public Long getContentId() {
        return this.f107b;
    }

    public Intent getContentIntent() {
        return this.f118m;
    }

    public PendingIntent getContentPendingIntent() {
        return this.f119n;
    }

    @Nullable
    @Deprecated
    public CharSequence getContentText() {
        return getContentTextDay();
    }

    @Nullable
    public CharSequence getContentTextDay() {
        return this.f111f;
    }

    @Nullable
    public CharSequence getContentTextNight() {
        return this.f112g;
    }

    @Nullable
    @Deprecated
    public CharSequence getContentTitle() {
        return getContentTitleDay();
    }

    @Nullable
    public CharSequence getContentTitleDay() {
        return this.f109d;
    }

    @Nullable
    public CharSequence getContentTitleNight() {
        return this.f110e;
    }

    public boolean getIgnoreInStream() {
        return this.f124s;
    }

    public Bitmap getLargeIcon() {
        return this.f115j;
    }

    @Deprecated
    public int getNightColor() {
        return getColorNight();
    }

    public boolean getShowAsHeadsUp() {
        return this.f123r;
    }

    public boolean getShowInStream() {
        return this.f122q;
    }

    @Nullable
    @Deprecated
    public CharSequence getSubText() {
        return getSubTextDay();
    }

    @Nullable
    public CharSequence getSubTextDay() {
        return this.f113h;
    }

    @Nullable
    public CharSequence getSubTextNight() {
        return this.f114i;
    }

    public int getType() {
        return this.f108c;
    }

    public boolean isExtended() {
        return this.f106a;
    }

    @Deprecated
    public CarNavExtender setActionIcon(@DrawableRes int i) {
        return setActionIconDay(i);
    }

    public CarNavExtender setActionIconDay(@DrawableRes int i) {
        this.f116k = i;
        return this;
    }

    public CarNavExtender setActionIconNight(@DrawableRes int i) {
        this.f117l = i;
        return this;
    }

    @Deprecated
    public CarNavExtender setColor(int i) {
        return setColorDay(i);
    }

    public CarNavExtender setColorDay(int i) {
        this.f120o = i;
        return this;
    }

    public CarNavExtender setColorNight(int i) {
        this.f121p = i;
        return this;
    }

    public CarNavExtender setContentId(long j) {
        this.f107b = Long.valueOf(j);
        return this;
    }

    public CarNavExtender setContentIntent(Intent intent) {
        this.f118m = intent;
        return this;
    }

    public CarNavExtender setContentPendingIntent(PendingIntent pendingIntent) {
        this.f119n = pendingIntent;
        return this;
    }

    @Deprecated
    public CarNavExtender setContentText(CharSequence charSequence) {
        return setContentTextDay(charSequence);
    }

    public CarNavExtender setContentTextDay(CharSequence charSequence) {
        this.f111f = charSequence;
        return this;
    }

    public CarNavExtender setContentTextNight(CharSequence charSequence) {
        this.f112g = charSequence;
        return this;
    }

    @Deprecated
    public CarNavExtender setContentTitle(CharSequence charSequence) {
        return setContentTitleDay(charSequence);
    }

    public CarNavExtender setContentTitleDay(CharSequence charSequence) {
        this.f109d = charSequence;
        return this;
    }

    public CarNavExtender setContentTitleNight(CharSequence charSequence) {
        this.f110e = charSequence;
        return this;
    }

    public CarNavExtender setIgnoreInStream(boolean z) {
        this.f124s = z;
        return this;
    }

    public CarNavExtender setLargeIcon(Bitmap bitmap) {
        this.f115j = bitmap;
        return this;
    }

    @Deprecated
    public CarNavExtender setNightColor(int i) {
        return setColorNight(i);
    }

    public CarNavExtender setShowAsHeadsUp(boolean z) {
        this.f123r = z;
        return this;
    }

    public CarNavExtender setShowInStream(boolean z) {
        this.f122q = z;
        return this;
    }

    @Deprecated
    public CarNavExtender setSubText(CharSequence charSequence) {
        return setSubTextDay(charSequence);
    }

    public CarNavExtender setSubTextDay(CharSequence charSequence) {
        this.f113h = charSequence;
        return this;
    }

    public CarNavExtender setSubTextNight(CharSequence charSequence) {
        this.f114i = charSequence;
        return this;
    }

    public CarNavExtender setType(int i) {
        this.f108c = i;
        return this;
    }
}
