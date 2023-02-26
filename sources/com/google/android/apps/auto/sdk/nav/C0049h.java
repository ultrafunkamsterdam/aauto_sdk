package com.google.android.apps.auto.sdk.nav;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.apps.auto.sdk.nav.state.C0055a;
import com.google.android.apps.auto.sdk.nav.state.C0058d;
import com.google.android.apps.auto.sdk.nav.state.CarInstrumentClusterConfig;

/* renamed from: com.google.android.apps.auto.sdk.nav.h */
final class C0049h extends C0058d {

    /* renamed from: a */
    private /* synthetic */ NavigationStateManager f148a;

    C0049h(NavigationStateManager navigationStateManager) {
        this.f148a = navigationStateManager;
    }

    /* renamed from: a */
    public final void mo462a(C0055a aVar) throws RemoteException {
        synchronized (this.f148a) {
            C0055a unused = this.f148a.f132a = aVar;
            if (aVar != null) {
                CarInstrumentClusterConfig a = aVar.mo510a();
                if (a != null) {
                    CarInstrumentClusterConfig unused2 = this.f148a.f133b = a;
                } else {
                    Log.w("NavigationStateManager", "Received null instrument cluster config");
                }
            } else {
                Log.e("NavigationStateManager", "Received null INavigationStateCallback");
            }
        }
    }
}
