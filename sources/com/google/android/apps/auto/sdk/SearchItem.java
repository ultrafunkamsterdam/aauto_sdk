package com.google.android.apps.auto.sdk;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SearchItem extends C0023a {
    public static final Parcelable.Creator<SearchItem> CREATOR = new C0028b(SearchItem.class);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f85a;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: b */
    public Bundle f86b;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: c */
    public CharSequence f87c;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: d */
    public CharSequence f88d;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: e */
    public CharSequence f89e;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: f */
    public CharSequence f90f;
    /* access modifiers changed from: private */
    @DrawableRes

    /* renamed from: g */
    public int f91g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Bitmap f92h;

    public static class Builder {

        /* renamed from: a */
        private SearchItem f93a = new SearchItem();

        public SearchItem build() {
            if (TextUtils.isEmpty(this.f93a.f87c)) {
                throw new IllegalArgumentException("SearchItem title must be non-empty");
            }
            boolean z = !TextUtils.isEmpty(this.f93a.f88d) || !TextUtils.isEmpty(this.f93a.f89e) || !TextUtils.isEmpty(this.f93a.f90f) || this.f93a.f91g != 0;
            if (this.f93a.f85a == 1 && z) {
                throw new IllegalArgumentException("Search suggestion can only contain title");
            } else if (this.f93a.getIconBitmap() == null || this.f93a.getIconResId() == 0) {
                return this.f93a;
            } else {
                throw new IllegalArgumentException("Cannot set both icon resId and bitmap");
            }
        }

        public Builder setDescription(CharSequence charSequence) {
            CharSequence unused = this.f93a.f89e = charSequence;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            Bundle unused = this.f93a.f86b = bundle;
            return this;
        }

        public Builder setIconBitmap(Bitmap bitmap) {
            Bitmap unused = this.f93a.f92h = bitmap;
            return this;
        }

        public Builder setIconResId(@DrawableRes int i) {
            int unused = this.f93a.f91g = i;
            return this;
        }

        public Builder setSubDescription(CharSequence charSequence) {
            CharSequence unused = this.f93a.f90f = charSequence;
            return this;
        }

        public Builder setSubtitle(CharSequence charSequence) {
            CharSequence unused = this.f93a.f88d = charSequence;
            return this;
        }

        public Builder setTitle(@NonNull CharSequence charSequence) {
            CharSequence unused = this.f93a.f87c = charSequence;
            return this;
        }

        public Builder setType(int i) {
            int unused = this.f93a.f85a = i;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
        public static final int SEARCH_RESULT = 0;
        public static final int SUGGESTION = 1;
    }

    SearchItem() {
    }

    @Nullable
    public CharSequence getDescription() {
        return this.f89e;
    }

    @Nullable
    public Bundle getExtras() {
        return this.f86b;
    }

    @Nullable
    public Bitmap getIconBitmap() {
        return this.f92h;
    }

    @DrawableRes
    public int getIconResId() {
        return this.f91g;
    }

    @Nullable
    public CharSequence getSubDescription() {
        return this.f90f;
    }

    @Nullable
    public CharSequence getSubtitle() {
        return this.f88d;
    }

    @NonNull
    public CharSequence getTitle() {
        return this.f87c;
    }

    public int getType() {
        return this.f85a;
    }

    /* access modifiers changed from: protected */
    public void readFromBundle(Bundle bundle) {
        this.f85a = bundle.getInt("type");
        this.f86b = bundle.getBundle("extras");
        this.f87c = bundle.getCharSequence("title");
        if (this.f87c != null) {
            this.f87c = this.f87c.toString();
        }
        this.f88d = bundle.getCharSequence("subtitle");
        if (this.f88d != null) {
            this.f88d = this.f88d.toString();
        }
        this.f89e = bundle.getCharSequence("description");
        this.f90f = bundle.getCharSequence("sub_description");
        this.f91g = bundle.getInt("icon_res_id");
        this.f92h = (Bitmap) bundle.getParcelable("icon_bitmap_id");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[SearchItem type ").append(this.f85a).append(", extras ").append(this.f86b).append(", title ").append(this.f87c).append(", subtitle ").append(this.f88d).append(", description ").append(this.f89e).append(", sub-description ").append(this.f90f).append(", iconResId ").append(this.f91g).append(", iconBitmap ").append(this.f92h).append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void writeToBundle(Bundle bundle) {
        bundle.putInt("type", this.f85a);
        bundle.putBundle("extras", this.f86b);
        bundle.putCharSequence("title", this.f87c);
        bundle.putCharSequence("subtitle", this.f88d);
        bundle.putCharSequence("description", this.f89e);
        bundle.putCharSequence("sub_description", this.f90f);
        bundle.putInt("icon_res_id", this.f91g);
        bundle.putParcelable("icon_bitmap_id", this.f92h);
    }
}
