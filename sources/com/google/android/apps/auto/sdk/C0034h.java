package com.google.android.apps.auto.sdk;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.p007a.bgizmo;
import com.google.android.p007a.cgizmo;

/* renamed from: com.google.android.apps.auto.sdk.h */
public abstract class C0034h extends bgizmo implements C0033g {
    public C0034h() {
        attachInterface(this, "com.google.android.apps.auto.sdk.IImeCallback");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (mo166a(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                boolean a = mo357a();
                parcel2.writeNoException();
                cgizmo.m16a(parcel2, a);
                return true;
            case 2:
                mo358b();
                parcel2.writeNoException();
                return true;
            case 3:
                mo359c();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
