package com.google.android.apps.auto.sdk.nav.state;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.p007a.bgizmo;

/* renamed from: com.google.android.apps.auto.sdk.nav.state.d */
public abstract class C0058d extends bgizmo implements C0057c {
    public C0058d() {
        attachInterface(this, "com.google.android.apps.auto.sdk.nav.state.INavigationStateManager");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        C0055a bVar;
        if (mo166a(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            bVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.apps.auto.sdk.nav.state.INavigationStateCallback");
            bVar = queryLocalInterface instanceof C0055a ? (C0055a) queryLocalInterface : new C0056b(readStrongBinder);
        }
        mo462a(bVar);
        return true;
    }
}
