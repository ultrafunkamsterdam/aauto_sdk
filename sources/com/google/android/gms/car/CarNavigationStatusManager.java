package com.google.android.gms.car;

public interface CarNavigationStatusManager {

    public interface CarNavigationStatusListener {
        void onStart(int i, int i2, int i3, int i4, int i5);

        void onStop();
    }

    void registerListener(CarNavigationStatusListener carNavigationStatusListener) throws CarNotConnectedException;

    boolean sendNavigationStatus(int i) throws CarNotConnectedException;

    boolean sendNavigationTurnDistanceEvent(int i, int i2, int i3, int i4) throws CarNotConnectedException;

    boolean sendNavigationTurnEvent(int i, String str, int i2, int i3, byte[] bArr, int i4) throws CarNotConnectedException;

    void unregisterListener();
}
