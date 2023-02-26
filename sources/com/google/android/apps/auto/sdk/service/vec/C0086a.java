package com.google.android.apps.auto.sdk.service.vec;

import android.support.annotation.VisibleForTesting;
import android.support.car.CarNotConnectedException;
import com.google.android.apps.auto.sdk.service.vec.CarVendorExtensionManager;
import com.google.android.gms.car.CarVendorExtensionManager;
import java.io.IOException;

/* renamed from: com.google.android.apps.auto.sdk.service.vec.a */
public final class C0086a implements CarVendorExtensionManager {

    /* renamed from: a */
    private final CarVendorExtensionManager f231a;
    @VisibleForTesting

    /* renamed from: b */
    private C0087b f232b;

    public C0086a(CarVendorExtensionManager carVendorExtensionManager) {
        this.f231a = carVendorExtensionManager;
    }

    public final byte[] getServiceData() throws CarNotConnectedException {
        try {
            return this.f231a.getServiceData();
        } catch (com.google.android.gms.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public final String getServiceName() throws CarNotConnectedException {
        try {
            return this.f231a.getServiceName();
        } catch (com.google.android.gms.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public final void registerListener(CarVendorExtensionManager.CarVendorExtensionListener carVendorExtensionListener) {
        if (this.f232b == null || this.f232b.f233a != carVendorExtensionListener) {
            this.f232b = new C0087b(this, carVendorExtensionListener);
            this.f231a.registerListener(this.f232b);
        }
    }

    public final void release() {
        this.f231a.release();
        this.f232b = null;
    }

    public final void sendData(byte[] bArr) throws CarNotConnectedException, IOException {
        try {
            this.f231a.sendData(bArr);
        } catch (com.google.android.gms.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public final void sendData(byte[] bArr, int i, int i2) throws CarNotConnectedException, IOException {
        try {
            this.f231a.sendData(bArr, i, i2);
        } catch (com.google.android.gms.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public final void unregisterListener() {
        this.f231a.unregisterListener();
        this.f232b = null;
    }
}
