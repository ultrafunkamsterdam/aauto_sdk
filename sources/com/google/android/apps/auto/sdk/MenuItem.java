package com.google.android.apps.auto.sdk;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RemoteViews;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MenuItem extends C0023a {
    public static final Parcelable.Creator<MenuItem> CREATOR = new C0028b(MenuItem.class);

    /* renamed from: a */
    private int f65a = -1;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f66b;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: c */
    public Bundle f67c;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: d */
    public CharSequence f68d;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: e */
    public CharSequence f69e;
    /* access modifiers changed from: private */
    @DrawableRes

    /* renamed from: f */
    public int f70f;
    @ColorInt

    /* renamed from: g */
    private int f71g;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: h */
    public Bitmap f72h;
    @Nullable

    /* renamed from: i */
    private Uri f73i;
    /* access modifiers changed from: private */
    @DrawableRes

    /* renamed from: j */
    public int f74j;
    @ColorInt

    /* renamed from: k */
    private int f75k;

    /* renamed from: l */
    private boolean f76l;

    /* renamed from: m */
    private boolean f77m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f78n;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: o */
    public RemoteViews f79o;

    /* renamed from: p */
    private char f80p;

    public static class Builder {

        /* renamed from: a */
        private MenuItem f81a = new MenuItem();

        public Builder() {
        }

        public Builder(MenuItem menuItem) {
            Bundle bundle = new Bundle();
            menuItem.writeToBundle(bundle);
            this.f81a.readFromBundle(bundle);
        }

        public MenuItem build() {
            int i = 0;
            if (TextUtils.isEmpty(this.f81a.f68d)) {
                Log.w("CSL.MenuItem", "MenuItem title should be non-empty");
            }
            if (this.f81a.f66b != 1 && this.f81a.f78n) {
                throw new IllegalArgumentException("MenuItem is not a checkbox type but is checked");
            } else if (this.f81a.f66b == 3 || this.f81a.f79o == null) {
                int i2 = this.f81a.getIconBitmap() != null ? 1 : 0;
                int i3 = this.f81a.getIconResId() != 0 ? 1 : 0;
                if (this.f81a.mo272b() != null) {
                    i = 1;
                }
                if (i2 + 0 + i3 + i > 1) {
                    throw new IllegalArgumentException("Cannot set multiple icon types.");
                } else if (this.f81a.f74j == 0 || this.f81a.f66b == 0) {
                    return this.f81a;
                } else {
                    throw new IllegalArgumentException("Cannot set right icon on non ITEM types.");
                }
            } else {
                throw new IllegalArgumentException("The menu is not a special view, but has remote views");
            }
        }

        public Builder setChecked(boolean z) {
            boolean unused = this.f81a.f78n = z;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            Bundle unused = this.f81a.f67c = bundle;
            return this;
        }

        public Builder setIconBitmap(Bitmap bitmap) {
            Bitmap unused = this.f81a.f72h = bitmap;
            return this;
        }

        public Builder setIconResId(@DrawableRes int i) {
            int unused = this.f81a.f70f = i;
            return this;
        }

        public Builder setSubtitle(CharSequence charSequence) {
            CharSequence unused = this.f81a.f69e = charSequence;
            return this;
        }

        public Builder setTitle(@NonNull CharSequence charSequence) {
            CharSequence unused = this.f81a.f68d = charSequence;
            return this;
        }

        public Builder setType(int i) {
            int unused = this.f81a.f66b = i;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
        public static final int CHECKBOX = 1;
        public static final int ITEM = 0;
        public static final int SUBMENU = 2;
    }

    MenuItem() {
    }

    /* renamed from: a */
    public final int mo269a() {
        return this.f65a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo270a(int i) {
        this.f65a = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo271a(boolean z) {
        if (this.f66b != 1) {
            throw new IllegalArgumentException("MenuItem is not a checkbox type");
        }
        this.f78n = z;
    }

    @Nullable
    /* renamed from: b */
    public final Uri mo272b() {
        return this.f73i;
    }

    @Nullable
    public Bundle getExtras() {
        return this.f67c;
    }

    @Nullable
    public Bitmap getIconBitmap() {
        return this.f72h;
    }

    @DrawableRes
    public int getIconResId() {
        return this.f70f;
    }

    @Nullable
    public CharSequence getSubtitle() {
        return this.f69e;
    }

    @NonNull
    public CharSequence getTitle() {
        return this.f68d;
    }

    public int getType() {
        return this.f66b;
    }

    public boolean isChecked() {
        return this.f78n;
    }

    /* access modifiers changed from: protected */
    public void readFromBundle(Bundle bundle) {
        this.f65a = bundle.getInt("position", -2);
        this.f66b = bundle.getInt("type");
        this.f67c = bundle.getBundle("extras");
        this.f68d = bundle.getCharSequence("title");
        if (this.f68d != null) {
            this.f68d = this.f68d.toString();
        }
        this.f69e = bundle.getCharSequence("subtitle");
        if (this.f69e != null) {
            this.f69e = this.f69e.toString();
        }
        this.f70f = bundle.getInt("icon_res_id");
        this.f76l = bundle.containsKey("has_icon_tint_color") ? bundle.getBoolean("has_icon_tint_color") : bundle.containsKey("icon_tint_color");
        this.f71g = bundle.getInt("icon_tint_color");
        this.f72h = (Bitmap) bundle.getParcelable("icon_bitmap_id");
        this.f73i = (Uri) bundle.getParcelable("icon_uri");
        this.f74j = bundle.getInt("right_icon_uri_res_id");
        this.f77m = bundle.containsKey("has_right_icon_tint_color") ? bundle.getBoolean("has_right_icon_tint_color") : bundle.containsKey("right_icon_tint_color");
        this.f75k = bundle.getInt("right_icon_tint_color");
        this.f78n = bundle.getBoolean("is_checked");
        this.f79o = (RemoteViews) bundle.getParcelable("remote_views");
        this.f80p = bundle.getChar("normalized_title_initial");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[MenuItem ").append(this.f65a).append(", type ").append(this.f66b).append(", extras ").append(this.f67c).append(", title ").append(this.f68d).append(", subtitle ").append(this.f69e).append(", iconResId ").append(this.f70f).append(", hasIconTintColor").append(this.f76l).append(", iconTintColor ").append(this.f71g).append(", iconBitmap ").append(this.f72h).append(", iconUri ").append(this.f73i).append(", rightIconResId ").append(this.f74j).append(", hasRightIconTintColor").append(this.f77m).append(", rightIconTintColor ").append(this.f75k).append(", isChecked ").append(this.f78n).append(", remoteViews ").append(this.f79o).append(", normalizedTitleInitial ").append(this.f80p).append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void writeToBundle(Bundle bundle) {
        bundle.putInt("position", this.f65a);
        bundle.putInt("type", this.f66b);
        bundle.putBundle("extras", this.f67c);
        bundle.putCharSequence("title", this.f68d);
        bundle.putCharSequence("subtitle", this.f69e);
        bundle.putInt("icon_res_id", this.f70f);
        bundle.putBoolean("has_icon_tint_color", this.f76l);
        bundle.putInt("icon_tint_color", this.f71g);
        bundle.putParcelable("icon_bitmap_id", this.f72h);
        bundle.putParcelable("icon_uri", this.f73i);
        bundle.putInt("right_icon_uri_res_id", this.f74j);
        bundle.putBoolean("has_right_icon_tint_color", this.f77m);
        bundle.putInt("right_icon_tint_color", this.f75k);
        bundle.putBoolean("is_checked", this.f78n);
        bundle.putParcelable("remote_views", this.f79o);
        bundle.putChar("normalized_title_initial", this.f80p);
    }
}
