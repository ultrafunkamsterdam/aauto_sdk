package com.google.android.apps.auto.sdk;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.p007a.agizmo;
import com.google.android.p007a.cgizmo;
import java.util.List;

/* renamed from: com.google.android.apps.auto.sdk.n */
public final class C0040n extends agizmo implements C0039m {
    C0040n(IBinder iBinder) {
        super(iBinder, "com.google.android.apps.auto.sdk.IMenuController");
    }

    /* renamed from: a */
    public final void mo363a() throws RemoteException {
        mo164b(2, mo162a_());
    }

    /* renamed from: a */
    public final void mo364a(int i) throws RemoteException {
        Parcel a_ = mo162a_();
        a_.writeInt(i);
        mo164b(3, a_);
    }

    /* renamed from: a */
    public final void mo365a(C0037k kVar) throws RemoteException {
        Parcel a_ = mo162a_();
        cgizmo.m13a(a_, (IInterface) kVar);
        mo164b(1, a_);
    }

    /* renamed from: a */
    public final void mo366a(List<AlphaJumpKeyItem> list) throws RemoteException {
        Parcel a_ = mo162a_();
        a_.writeTypedList(list);
        mo164b(10, a_);
    }

    /* renamed from: b */
    public final void mo367b() throws RemoteException {
        mo164b(4, mo162a_());
    }

    /* renamed from: c */
    public final void mo368c() throws RemoteException {
        mo164b(5, mo162a_());
    }

    /* renamed from: d */
    public final void mo369d() throws RemoteException {
        mo164b(6, mo162a_());
    }

    /* renamed from: e */
    public final void mo370e() throws RemoteException {
        mo164b(7, mo162a_());
    }

    /* renamed from: f */
    public final void mo371f() throws RemoteException {
        mo164b(8, mo162a_());
    }

    /* renamed from: g */
    public final void mo372g() throws RemoteException {
        mo164b(9, mo162a_());
    }
}
