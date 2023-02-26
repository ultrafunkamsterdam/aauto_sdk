package com.google.android.apps.auto.sdk.nav;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.apps.auto.sdk.C0023a;
import com.google.android.apps.auto.sdk.C0028b;

public class NavigationClientConfig extends C0023a {
    public static final Parcelable.Creator<NavigationClientConfig> CREATOR = new C0028b(NavigationClientConfig.class);

    /* renamed from: a */
    private int f126a;

    public NavigationClientConfig() {
    }

    public NavigationClientConfig(int i) throws IllegalArgumentException {
        if (i <= 0) {
            throw new IllegalArgumentException(new StringBuilder(51).append("Invalid version. Must be > 0. Version = ").append(i).toString());
        }
        this.f126a = i;
    }

    public int getClientVersion() {
        return this.f126a;
    }

    /* access modifiers changed from: protected */
    public void readFromBundle(Bundle bundle) {
        this.f126a = bundle.getInt("version");
    }

    /* access modifiers changed from: protected */
    public void writeToBundle(Bundle bundle) {
        bundle.putInt("version", this.f126a);
    }
}
