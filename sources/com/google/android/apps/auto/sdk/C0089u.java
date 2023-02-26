package com.google.android.apps.auto.sdk;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.p007a.agizmo;
import com.google.android.p007a.cgizmo;

/* renamed from: com.google.android.apps.auto.sdk.u */
public final class C0089u extends agizmo implements C0088t {
    C0089u(IBinder iBinder) {
        super(iBinder, "com.google.android.apps.auto.sdk.IStatusBarController");
    }

    /* renamed from: a */
    public final void mo609a(float f) throws RemoteException {
        Parcel a_ = mo162a_();
        a_.writeFloat(f);
        mo164b(17, a_);
    }

    /* renamed from: a */
    public final void mo610a(int i) throws RemoteException {
        Parcel a_ = mo162a_();
        a_.writeInt(i);
        mo164b(13, a_);
    }

    /* renamed from: a */
    public final void mo611a(CharSequence charSequence) throws RemoteException {
        Parcel a_ = mo162a_();
        cgizmo.m15a(a_, charSequence);
        mo164b(1, a_);
    }

    /* renamed from: a */
    public final boolean mo612a() throws RemoteException {
        Parcel a = mo161a(2, mo162a_());
        boolean a2 = cgizmo.m17a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: b */
    public final void mo613b() throws RemoteException {
        mo164b(3, mo162a_());
    }

    /* renamed from: b */
    public final void mo614b(int i) throws RemoteException {
        Parcel a_ = mo162a_();
        a_.writeInt(i);
        mo164b(16, a_);
    }

    /* renamed from: c */
    public final void mo615c() throws RemoteException {
        mo164b(4, mo162a_());
    }

    /* renamed from: d */
    public final void mo616d() throws RemoteException {
        mo164b(5, mo162a_());
    }

    /* renamed from: e */
    public final void mo617e() throws RemoteException {
        mo164b(6, mo162a_());
    }

    /* renamed from: f */
    public final void mo618f() throws RemoteException {
        mo164b(7, mo162a_());
    }

    /* renamed from: g */
    public final void mo619g() throws RemoteException {
        mo164b(8, mo162a_());
    }

    /* renamed from: h */
    public final void mo620h() throws RemoteException {
        mo164b(9, mo162a_());
    }

    /* renamed from: i */
    public final void mo621i() throws RemoteException {
        mo164b(10, mo162a_());
    }

    /* renamed from: j */
    public final void mo622j() throws RemoteException {
        mo164b(11, mo162a_());
    }

    /* renamed from: k */
    public final void mo623k() throws RemoteException {
        mo164b(12, mo162a_());
    }
}
