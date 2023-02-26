package com.google.android.apps.auto.sdk.service.p008a;

import android.support.annotation.VisibleForTesting;
import android.support.car.hardware.CarSensorEvent;
import android.support.car.hardware.CarSensorManager;
import com.google.android.apps.auto.sdk.service.p008a.p011c.C0077a;
import com.google.android.gms.car.CarSensorManager;

@VisibleForTesting
/* renamed from: com.google.android.apps.auto.sdk.service.a.h */
final class C0085h implements C0077a<CarSensorManager.OnSensorChangedListener>, CarSensorManager.CarSensorEventListener {

    /* renamed from: a */
    private CarSensorManager.OnSensorChangedListener f229a;

    /* renamed from: b */
    private C0083f f230b;

    public C0085h(C0083f fVar, CarSensorManager.OnSensorChangedListener onSensorChangedListener) {
        this.f229a = onSensorChangedListener;
        this.f230b = fVar;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo590a() {
        return this.f229a;
    }

    public final void onSensorChanged(int i, long j, float[] fArr, byte[] bArr) {
        this.f229a.onSensorChanged(this.f230b, new CarSensorEvent(i, j, fArr, bArr, (long[]) null));
    }
}
