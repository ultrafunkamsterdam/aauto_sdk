package com.google.android.gms.car;

import java.io.IOException;

public interface CarVendorExtensionManager {

    public interface CarVendorExtensionListener {
        void onData(byte[] bArr);
    }

    byte[] getServiceData() throws CarNotConnectedException;

    String getServiceName() throws CarNotConnectedException;

    void registerListener(CarVendorExtensionListener carVendorExtensionListener);

    void release();

    void sendData(byte[] bArr) throws CarNotConnectedException, IOException;

    void sendData(byte[] bArr, int i, int i2) throws CarNotConnectedException, IOException;

    void unregisterListener();
}
