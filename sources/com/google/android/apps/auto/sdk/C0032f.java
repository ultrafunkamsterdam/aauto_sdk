package com.google.android.apps.auto.sdk;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.p007a.agizmo;
import com.google.android.p007a.cgizmo;

/* renamed from: com.google.android.apps.auto.sdk.f */
public final class C0032f extends agizmo implements C0031e {
    C0032f(IBinder iBinder) {
        super(iBinder, "com.google.android.apps.auto.sdk.IDrawerController");
    }

    /* renamed from: a */
    public final void mo351a(int i) throws RemoteException {
        Parcel a_ = mo162a_();
        a_.writeInt(i);
        mo164b(6, a_);
    }

    /* renamed from: a */
    public final void mo352a(C0029c cVar) throws RemoteException {
        Parcel a_ = mo162a_();
        cgizmo.m13a(a_, (IInterface) cVar);
        mo164b(5, a_);
    }

    /* renamed from: a */
    public final boolean mo353a() throws RemoteException {
        Parcel a = mo161a(1, mo162a_());
        boolean a2 = cgizmo.m17a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: b */
    public final boolean mo354b() throws RemoteException {
        Parcel a = mo161a(2, mo162a_());
        boolean a2 = cgizmo.m17a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: c */
    public final void mo355c() throws RemoteException {
        mo164b(3, mo162a_());
    }

    /* renamed from: d */
    public final void mo356d() throws RemoteException {
        mo164b(4, mo162a_());
    }
}
