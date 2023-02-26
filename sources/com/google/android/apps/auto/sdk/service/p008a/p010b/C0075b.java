package com.google.android.apps.auto.sdk.service.p008a.p010b;

import android.support.annotation.VisibleForTesting;
import android.support.car.navigation.CarNavigationInstrumentCluster;
import android.support.car.navigation.CarNavigationStatusManager;
import com.google.android.gms.car.CarNavigationStatusManager;

@VisibleForTesting
/* renamed from: com.google.android.apps.auto.sdk.service.a.b.b */
final class C0075b implements CarNavigationStatusManager.CarNavigationStatusListener {

    /* renamed from: a */
    CarNavigationStatusManager.CarNavigationCallback f214a;

    /* renamed from: b */
    CarNavigationInstrumentCluster f215b;

    /* renamed from: c */
    C0074a f216c;

    C0075b(C0074a aVar) {
        this.f216c = aVar;
    }

    public final void onStart(int i, int i2, int i3, int i4, int i5) {
        if (i2 == 1) {
            this.f215b = CarNavigationInstrumentCluster.createCustomImageCluster(i, i3, i4, i5);
        } else {
            this.f215b = CarNavigationInstrumentCluster.createCluster(i);
        }
        if (this.f214a != null) {
            this.f214a.onInstrumentClusterStarted(this.f216c, this.f215b);
        }
    }

    public final void onStop() {
        if (this.f214a != null) {
            this.f214a.onInstrumentClusterStopped(this.f216c);
        }
    }
}
