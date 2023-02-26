package com.google.android.apps.auto.sdk.service.vec;

import android.support.annotation.VisibleForTesting;
import com.google.android.apps.auto.sdk.service.p008a.p011c.C0077a;
import com.google.android.apps.auto.sdk.service.vec.CarVendorExtensionManager;
import com.google.android.gms.car.CarVendorExtensionManager;

@VisibleForTesting
/* renamed from: com.google.android.apps.auto.sdk.service.vec.b */
final class C0087b implements C0077a<CarVendorExtensionManager.CarVendorExtensionListener>, CarVendorExtensionManager.CarVendorExtensionListener {

    /* renamed from: a */
    CarVendorExtensionManager.CarVendorExtensionListener f233a;

    /* renamed from: b */
    private C0086a f234b;

    public C0087b(C0086a aVar, CarVendorExtensionManager.CarVendorExtensionListener carVendorExtensionListener) {
        this.f233a = carVendorExtensionListener;
        this.f234b = aVar;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo590a() {
        return this.f233a;
    }

    public final void onData(byte[] bArr) {
        this.f233a.onData(this.f234b, bArr);
    }
}
