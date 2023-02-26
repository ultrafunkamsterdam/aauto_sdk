package com.google.android.p007a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.a.bgizmo */
public class bgizmo extends Binder implements IInterface {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo166a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i > 16777215) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        parcel.enforceInterface(getInterfaceDescriptor());
        return false;
    }

    public IBinder asBinder() {
        return this;
    }
}
