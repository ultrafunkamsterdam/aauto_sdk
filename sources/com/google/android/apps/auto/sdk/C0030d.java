package com.google.android.apps.auto.sdk;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.p007a.bgizmo;

/* renamed from: com.google.android.apps.auto.sdk.d */
public abstract class C0030d extends bgizmo implements C0029c {
    public C0030d() {
        attachInterface(this, "com.google.android.apps.auto.sdk.IDrawerCallback");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (mo166a(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                mo228a();
                break;
            case 2:
                mo229b();
                break;
            case 3:
                mo230c();
                break;
            case 4:
                mo231d();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
