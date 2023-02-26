package com.google.android.gms.car;

public interface CarApi {

    public interface CarConnectionCallback {
        void onConnected(int i);

        void onDisconnected();
    }

    int getCarConnectionType() throws CarNotConnectedException;

    Object getCarManager(String str) throws CarNotSupportedException, CarNotConnectedException;

    CarVendorExtensionManager getVendorExtensionManager(String str) throws CarNotSupportedException, CarNotConnectedException;

    boolean isConnectedToCar();

    void registerCarConnectionListener(CarConnectionCallback carConnectionCallback);

    void unregisterCarConnectionListener(CarConnectionCallback carConnectionCallback);
}
