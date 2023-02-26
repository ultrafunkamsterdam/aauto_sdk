package com.google.android.apps.auto.sdk;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.p007a.bgizmo;
import com.google.android.p007a.cgizmo;

/* renamed from: com.google.android.apps.auto.sdk.l */
public abstract class C0038l extends bgizmo implements C0037k {
    public C0038l() {
        attachInterface(this, "com.google.android.apps.auto.sdk.IMenuAdapter");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (mo166a(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                int a = mo260a();
                parcel2.writeNoException();
                parcel2.writeInt(a);
                break;
            case 2:
                MenuItem a2 = mo261a(parcel.readInt());
                parcel2.writeNoException();
                cgizmo.m18b(parcel2, a2);
                break;
            case 3:
                mo263a((MenuItem) cgizmo.m12a(parcel, MenuItem.CREATOR));
                parcel2.writeNoException();
                break;
            case 4:
                boolean b = mo264b();
                parcel2.writeNoException();
                cgizmo.m16a(parcel2, b);
                break;
            case 5:
                mo265c();
                parcel2.writeNoException();
                break;
            case 6:
                mo266d();
                parcel2.writeNoException();
                break;
            case 7:
                mo267e();
                parcel2.writeNoException();
                break;
            case 8:
                String f = mo268f();
                parcel2.writeNoException();
                parcel2.writeString(f);
                break;
            case 9:
                mo262a((Bundle) cgizmo.m12a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
