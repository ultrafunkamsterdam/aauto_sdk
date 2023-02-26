package com.google.android.apps.auto.sdk.service.p008a;

import android.support.car.hardware.CarSensorManager;
import com.google.android.apps.auto.sdk.service.p008a.p011c.C0077a;
import com.google.android.apps.auto.sdk.service.p008a.p011c.C0080d;

/* renamed from: com.google.android.apps.auto.sdk.service.a.g */
final class C0084g implements C0080d<CarSensorManager.OnSensorChangedListener, C0085h> {

    /* renamed from: a */
    private /* synthetic */ C0083f f228a;

    C0084g(C0083f fVar) {
        this.f228a = fVar;
    }

    /* renamed from: a */
    public final /* synthetic */ C0077a mo597a(Object obj) {
        return new C0085h(this.f228a, (CarSensorManager.OnSensorChangedListener) obj);
    }
}
