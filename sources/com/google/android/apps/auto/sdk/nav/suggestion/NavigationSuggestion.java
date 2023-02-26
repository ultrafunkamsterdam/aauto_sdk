package com.google.android.apps.auto.sdk.nav.suggestion;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.apps.auto.sdk.C0023a;
import com.google.android.apps.auto.sdk.C0028b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class NavigationSuggestion extends C0023a {
    public static final Parcelable.Creator<NavigationSuggestion> CREATOR = new C0028b(NavigationSuggestion.class);
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: a */
    public Intent f176a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CharSequence f177b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CharSequence f178c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CharSequence f179d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public CharSequence f180e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f181f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public double f182g = Double.MAX_VALUE;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public double f183h = Double.MAX_VALUE;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f184i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public LatLng[] f185j;

    public static class Builder {

        /* renamed from: a */
        private NavigationSuggestion f186a = new NavigationSuggestion();

        public NavigationSuggestion build() {
            if (this.f186a.f176a == null) {
                throw new IllegalArgumentException("Failed to provide navigation intent");
            } else if (this.f186a.f179d != null || this.f186a.f177b != null) {
                return this.f186a;
            } else {
                throw new IllegalArgumentException("Failed to provide address and destination name. Must provide either  address or name.");
            }
        }

        public Builder setAddress(CharSequence charSequence) {
            CharSequence unused = this.f186a.f179d = charSequence;
            return this;
        }

        public Builder setFormattedTimeToDestination(CharSequence charSequence) {
            CharSequence unused = this.f186a.f180e = charSequence;
            return this;
        }

        public Builder setLatLng(double d, double d2) throws IllegalArgumentException {
            if (d > 90.0d || d < -90.0d) {
                throw new IllegalArgumentException(new StringBuilder(48).append("Invalid latitude value: ").append(d).toString());
            } else if (d2 > 180.0d || d2 < -180.0d) {
                throw new IllegalArgumentException(new StringBuilder(49).append("Invalid longitude value: ").append(d2).toString());
            } else {
                double unused = this.f186a.f182g = d;
                double unused2 = this.f186a.f183h = d2;
                return this;
            }
        }

        public Builder setName(CharSequence charSequence) {
            CharSequence unused = this.f186a.f177b = charSequence;
            return this;
        }

        public Builder setNavigationIntent(Intent intent) {
            Intent unused = this.f186a.f176a = intent;
            return this;
        }

        public Builder setRoute(CharSequence charSequence) {
            CharSequence unused = this.f186a.f178c = charSequence;
            return this;
        }

        public Builder setSecondsToDestination(int i) {
            int unused = this.f186a.f181f = i;
            return this;
        }

        public Builder setTraffic(int i) throws IllegalArgumentException {
            if (i == 1 || i == 2 || i == 3 || i == 0) {
                int unused = this.f186a.f184i = i;
                return this;
            }
            throw new IllegalArgumentException("Traffic must be one of [Traffic.LIGHT, Traffic.MEDIUM, Traffic.HEAVY, Traffic.UNKNOWN]");
        }

        public Builder setWaypoints(LatLng[] latLngArr) {
            LatLng[] unused = this.f186a.f185j = latLngArr;
            return this;
        }
    }

    public static class LatLng {

        /* renamed from: a */
        private double f187a;

        /* renamed from: b */
        private double f188b;

        public LatLng(double d, double d2) {
            this.f187a = d;
            this.f188b = d2;
        }

        public double getLat() {
            return this.f187a;
        }

        public double getLng() {
            return this.f188b;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Traffic {
        public static final int HEAVY = 3;
        public static final int LIGHT = 1;
        public static final int MEDIUM = 2;
        public static final int UNKNOWN = 0;
    }

    @Nullable
    public CharSequence getAddress() {
        return this.f179d;
    }

    @Nullable
    public CharSequence getFormattedTimeToDestination() {
        return this.f180e;
    }

    @NonNull
    public LatLng getLatLng() {
        return new LatLng(this.f182g, this.f183h);
    }

    @Nullable
    public CharSequence getName() {
        return this.f177b;
    }

    @NonNull
    public Intent getNavigationIntent() {
        return this.f176a;
    }

    @Nullable
    public CharSequence getRoute() {
        return this.f178c;
    }

    public int getSecondsToDestination() {
        return this.f181f;
    }

    public int getTraffic() {
        return this.f184i;
    }

    public LatLng[] getWaypoints() {
        return this.f185j;
    }

    public boolean hasLatLng() {
        return (this.f182g == Double.MAX_VALUE || this.f183h == Double.MAX_VALUE) ? false : true;
    }

    /* access modifiers changed from: protected */
    public void readFromBundle(Bundle bundle) {
        LatLng[] latLngArr;
        this.f177b = bundle.getCharSequence("name");
        this.f178c = bundle.getCharSequence("route");
        this.f176a = (Intent) bundle.getParcelable("intent");
        this.f179d = bundle.getCharSequence("address");
        this.f182g = bundle.getDouble("lat");
        this.f183h = bundle.getDouble("lng");
        this.f181f = bundle.getInt("sec_to_dest");
        this.f180e = bundle.getCharSequence("formatted_tta");
        double[] doubleArray = bundle.getDoubleArray("waypoints");
        if (doubleArray == null) {
            latLngArr = null;
        } else {
            LatLng[] latLngArr2 = new LatLng[(doubleArray.length / 2)];
            for (int i = 0; i < doubleArray.length / 2; i++) {
                latLngArr2[i] = new LatLng(doubleArray[i * 2], doubleArray[(i * 2) + 1]);
            }
            latLngArr = latLngArr2;
        }
        this.f185j = latLngArr;
        this.f184i = bundle.getInt("traffic");
    }

    /* access modifiers changed from: protected */
    public void writeToBundle(Bundle bundle) {
        double[] dArr;
        bundle.putCharSequence("name", this.f177b);
        bundle.putCharSequence("route", this.f178c);
        bundle.putParcelable("intent", this.f176a);
        bundle.putCharSequence("address", this.f179d);
        bundle.putDouble("lat", this.f182g);
        bundle.putDouble("lng", this.f183h);
        bundle.putCharSequence("formatted_tta", this.f180e);
        bundle.putInt("sec_to_dest", this.f181f);
        LatLng[] latLngArr = this.f185j;
        if (latLngArr == null) {
            dArr = null;
        } else {
            double[] dArr2 = new double[(latLngArr.length << 1)];
            for (int i = 0; i < latLngArr.length; i++) {
                dArr2[i * 2] = latLngArr[i].getLat();
                dArr2[(i * 2) + 1] = latLngArr[i].getLng();
            }
            dArr = dArr2;
        }
        bundle.putDoubleArray("waypoints", dArr);
        bundle.putInt("traffic", this.f184i);
    }
}
