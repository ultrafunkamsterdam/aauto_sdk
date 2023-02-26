package com.google.android.apps.auto.sdk.nav.state;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.p007a.agizmo;
import com.google.android.p007a.cgizmo;

/* renamed from: com.google.android.apps.auto.sdk.nav.state.b */
public final class C0056b extends agizmo implements C0055a {
    C0056b(IBinder iBinder) {
        super(iBinder, "com.google.android.apps.auto.sdk.nav.state.INavigationStateCallback");
    }

    /* renamed from: a */
    public final CarInstrumentClusterConfig mo510a() throws RemoteException {
        Parcel a = mo161a(3, mo162a_());
        CarInstrumentClusterConfig carInstrumentClusterConfig = (CarInstrumentClusterConfig) cgizmo.m12a(a, CarInstrumentClusterConfig.CREATOR);
        a.recycle();
        return carInstrumentClusterConfig;
    }

    /* renamed from: a */
    public final void mo511a(NavigationSummary navigationSummary) throws RemoteException {
        Parcel a_ = mo162a_();
        cgizmo.m14a(a_, (Parcelable) navigationSummary);
        mo165c(1, a_);
    }

    /* renamed from: a */
    public final void mo512a(TurnEvent turnEvent) throws RemoteException {
        Parcel a_ = mo162a_();
        cgizmo.m14a(a_, (Parcelable) turnEvent);
        mo165c(2, a_);
    }
}
