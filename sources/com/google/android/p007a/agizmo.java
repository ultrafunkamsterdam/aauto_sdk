package com.google.android.p007a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.a.agizmo */
public class agizmo implements IInterface {

    /* renamed from: a */
    private final IBinder f13a;

    /* renamed from: b */
    private final String f14b;

    protected agizmo(IBinder iBinder, String str) {
        this.f13a = iBinder;
        this.f14b = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo161a(int i, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f13a.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            parcel.recycle();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a_ */
    public final Parcel mo162a_() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f14b);
        return obtain;
    }

    public IBinder asBinder() {
        return this.f13a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo164b(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f13a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final void mo165c(int i, Parcel parcel) throws RemoteException {
        try {
            this.f13a.transact(i, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
