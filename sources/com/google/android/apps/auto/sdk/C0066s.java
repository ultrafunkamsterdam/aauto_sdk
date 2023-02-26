package com.google.android.apps.auto.sdk;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.p007a.agizmo;
import com.google.android.p007a.cgizmo;
import java.util.List;

/* renamed from: com.google.android.apps.auto.sdk.s */
public final class C0066s extends agizmo implements C0065q {
    C0066s(IBinder iBinder) {
        super(iBinder, "com.google.android.apps.auto.sdk.ISearchController");
    }

    /* renamed from: a */
    public final void mo560a() throws RemoteException {
        mo164b(1, mo162a_());
    }

    /* renamed from: a */
    public final void mo561a(C0063o oVar) throws RemoteException {
        Parcel a_ = mo162a_();
        cgizmo.m13a(a_, (IInterface) oVar);
        mo164b(5, a_);
    }

    /* renamed from: a */
    public final void mo562a(CharSequence charSequence) throws RemoteException {
        Parcel a_ = mo162a_();
        cgizmo.m15a(a_, charSequence);
        mo164b(4, a_);
    }

    /* renamed from: a */
    public final void mo563a(String str) throws RemoteException {
        Parcel a_ = mo162a_();
        a_.writeString(str);
        mo164b(7, a_);
    }

    /* renamed from: a */
    public final void mo564a(List<SearchItem> list) throws RemoteException {
        Parcel a_ = mo162a_();
        a_.writeTypedList(list);
        mo164b(3, a_);
    }

    /* renamed from: b */
    public final void mo565b() throws RemoteException {
        mo164b(2, mo162a_());
    }

    /* renamed from: c */
    public final void mo566c() throws RemoteException {
        mo164b(6, mo162a_());
    }
}
