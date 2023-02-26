package com.google.android.apps.auto.sdk.nav.state;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.apps.auto.sdk.C0023a;
import com.google.android.apps.auto.sdk.C0028b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class NavigationSummary extends C0023a {
    public static final Parcelable.Creator<NavigationSummary> CREATOR = new C0028b(NavigationSummary.class);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f161a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CharSequence f162b = "";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f163c = -1;

    public static class Builder {

        /* renamed from: a */
        private NavigationSummary f164a = new NavigationSummary();

        public NavigationSummary build() {
            return this.f164a;
        }

        public Builder setFormattedDestinationEta(CharSequence charSequence) {
            CharSequence unused = this.f164a.f162b = charSequence;
            return this;
        }

        public Builder setNavigationStatus(int i) throws IllegalArgumentException {
            if (i == 2 || i == 1 || i == 4 || i == 3) {
                int unused = this.f164a.f161a = i;
                return this;
            }
            throw new IllegalArgumentException("Invalid navigation status value");
        }

        public Builder setSecondsToDestination(int i) {
            int unused = this.f164a.f163c = i;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NavigationStatus {
        public static final int NAVIGATING = 1;
        public static final int PAUSING = 4;
        public static final int RESUMING = 3;
        public static final int STOPPED = 2;
        public static final int UNKNOWN = 0;
    }

    public CharSequence getFormattedDestinationEta() {
        return this.f162b;
    }

    public int getNavigationStatus() {
        return this.f161a;
    }

    public int getSecondsToDestination() {
        return this.f163c;
    }

    public boolean hasSecondsToDestination() {
        return this.f163c != -1;
    }

    /* access modifiers changed from: protected */
    public void readFromBundle(Bundle bundle) {
        this.f162b = bundle.getCharSequence("formatted_eta", "");
        this.f163c = bundle.getInt("sec_to_dest", -1);
        this.f161a = bundle.getInt("nav_status");
    }

    /* access modifiers changed from: protected */
    public void writeToBundle(Bundle bundle) {
        bundle.putCharSequence("formatted_eta", this.f162b);
        bundle.putInt("sec_to_dest", this.f163c);
        bundle.putInt("nav_status", this.f161a);
    }
}
