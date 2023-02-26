package com.google.android.apps.auto.sdk;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.android.apps.auto.sdk.a */
public abstract class C0023a implements Parcelable {
    public final int describeContents() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public abstract void readFromBundle(Bundle bundle);

    public String toString() {
        Bundle bundle = new Bundle();
        writeToBundle(bundle);
        return bundle.toString();
    }

    /* access modifiers changed from: protected */
    public abstract void writeToBundle(Bundle bundle);

    public final void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        writeToBundle(bundle);
        parcel.writeBundle(bundle);
    }
}
