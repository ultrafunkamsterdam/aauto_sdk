package com.google.android.apps.auto.sdk.service;

import android.support.annotation.VisibleForTesting;
import android.support.car.CarNotConnectedException;
import com.google.android.apps.auto.sdk.service.vec.C0086a;
import com.google.android.apps.auto.sdk.service.vec.CarVendorExtensionManager;
import com.google.android.gms.car.CarApi;
import com.google.android.gms.car.CarNotSupportedException;

public class CarVendorExtensionManagerLoader {
    public static final String VENDOR_EXTENSION_LOADER_SERVICE = "vec_loader";
    @VisibleForTesting

    /* renamed from: a */
    private CarApi f202a;

    protected CarVendorExtensionManagerLoader(CarApi carApi) {
        this.f202a = carApi;
    }

    public CarVendorExtensionManager getManager(String str) throws CarNotConnectedException, SecurityException {
        try {
            return new C0086a(this.f202a.getVendorExtensionManager(str));
        } catch (CarNotSupportedException e) {
            return null;
        } catch (com.google.android.gms.car.CarNotConnectedException e2) {
            throw new CarNotConnectedException((Exception) e2);
        }
    }
}
