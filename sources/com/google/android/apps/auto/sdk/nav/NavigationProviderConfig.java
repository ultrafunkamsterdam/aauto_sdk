package com.google.android.apps.auto.sdk.nav;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.apps.auto.sdk.C0023a;
import com.google.android.apps.auto.sdk.C0028b;

public class NavigationProviderConfig extends C0023a {
    public static final Parcelable.Creator<NavigationProviderConfig> CREATOR = new C0028b(NavigationProviderConfig.class);

    /* renamed from: a */
    private int f127a;

    /* renamed from: b */
    private int f128b;

    public NavigationProviderConfig() {
    }

    public NavigationProviderConfig(int i, int i2) throws IllegalArgumentException {
        if (i > i2) {
            throw new IllegalArgumentException("Min version was greater than max version. Min version must be less than max version");
        } else if (i <= 0) {
            throw new IllegalArgumentException("Min version was <= 0. Min version must be > 0");
        } else {
            this.f127a = i;
            this.f128b = i2;
        }
    }

    public int getMaxVersion() {
        return this.f128b;
    }

    public int getMinVersion() {
        return this.f127a;
    }

    /* access modifiers changed from: protected */
    public void readFromBundle(Bundle bundle) {
        this.f127a = bundle.getInt("MIN_VERSION");
        this.f128b = bundle.getInt("MAX_VERSION");
    }

    /* access modifiers changed from: protected */
    public void writeToBundle(Bundle bundle) {
        bundle.putInt("MIN_VERSION", this.f127a);
        bundle.putInt("MAX_VERSION", this.f128b);
    }
}
