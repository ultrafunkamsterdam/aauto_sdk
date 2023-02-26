package com.google.android.apps.auto.sdk;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.p007a.agizmo;
import com.google.android.p007a.cgizmo;

/* renamed from: com.google.android.apps.auto.sdk.j */
public final class C0036j extends agizmo implements C0035i {
    C0036j(IBinder iBinder) {
        super(iBinder, "com.google.android.apps.auto.sdk.IImeController");
    }

    /* renamed from: a */
    public final void mo361a(C0033g gVar) throws RemoteException {
        Parcel a_ = mo162a_();
        cgizmo.m13a(a_, (IInterface) gVar);
        mo164b(1, a_);
    }
}
