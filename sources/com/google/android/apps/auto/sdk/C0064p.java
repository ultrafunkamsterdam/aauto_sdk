package com.google.android.apps.auto.sdk;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.p007a.bgizmo;
import com.google.android.p007a.cgizmo;

/* renamed from: com.google.android.apps.auto.sdk.p */
public abstract class C0064p extends bgizmo implements C0063o {
    public C0064p() {
        attachInterface(this, "com.google.android.apps.auto.sdk.ISearchCallback");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (mo166a(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                mo300a();
                parcel2.writeNoException();
                break;
            case 2:
                mo303b();
                parcel2.writeNoException();
                break;
            case 3:
                mo302a(parcel.readString());
                parcel2.writeNoException();
                break;
            case 4:
                boolean b = mo304b(parcel.readString());
                parcel2.writeNoException();
                cgizmo.m16a(parcel2, b);
                break;
            case 5:
                mo301a((SearchItem) cgizmo.m12a(parcel, SearchItem.CREATOR));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
