package com.google.android.gms.car;

public interface CarMessageManager {

    public interface CarMessageListener {
        void onIntegerMessage(int i, int i2, int i3);

        void onOwnershipLost(int i);
    }

    boolean acquireCategory(int i) throws CarNotConnectedException;

    Integer getLastIntegerMessage(int i, int i2) throws CarNotConnectedException;

    void registerMessageListener(CarMessageListener carMessageListener);

    void releaseAllCategories();

    void releaseCategory(int i);

    void sendIntegerMessage(int i, int i2, int i3) throws CarNotConnectedException;

    void unregisterMessageListener();
}
