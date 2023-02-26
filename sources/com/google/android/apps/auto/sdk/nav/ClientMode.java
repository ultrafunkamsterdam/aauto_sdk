package com.google.android.apps.auto.sdk.nav;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.apps.auto.sdk.C0023a;
import com.google.android.apps.auto.sdk.C0028b;

public class ClientMode extends C0023a {
    public static final Parcelable.Creator<ClientMode> CREATOR = new C0028b(ClientMode.class);

    /* renamed from: a */
    private int f125a;

    public ClientMode() {
    }

    public ClientMode(int i) throws IllegalArgumentException {
        if (i == 1 || i == 2) {
            this.f125a = i;
            return;
        }
        throw new IllegalArgumentException("Invalid value for mode. Must be AndroidAutoMode.CAR or AndroidAutoMode.PHONE");
    }

    public int getMode() {
        return this.f125a;
    }

    /* access modifiers changed from: protected */
    public void readFromBundle(Bundle bundle) {
        this.f125a = bundle.getInt("mode");
    }

    /* access modifiers changed from: protected */
    public void writeToBundle(Bundle bundle) {
        bundle.putInt("mode", this.f125a);
    }
}
