package com.google.android.apps.auto.sdk.service.vec;

import android.support.car.CarNotConnectedException;
import java.io.IOException;

public interface CarVendorExtensionManager {
    public static final String PERMISSION_VENDOR_EXTENSION = "com.google.android.gms.permission.CAR_VENDOR_EXTENSION";

    public interface CarVendorExtensionListener {
        void onData(CarVendorExtensionManager carVendorExtensionManager, byte[] bArr);
    }

    byte[] getServiceData() throws CarNotConnectedException;

    String getServiceName() throws CarNotConnectedException;

    void registerListener(CarVendorExtensionListener carVendorExtensionListener);

    void release();

    void sendData(byte[] bArr) throws CarNotConnectedException, IOException;

    void sendData(byte[] bArr, int i, int i2) throws CarNotConnectedException, IOException;

    void unregisterListener();
}
