package com.google.android.gms.car;

public interface CarApiConnection {

    public interface ApiConnectionCallback {
        void onConnected();

        void onConnectionFailed();

        void onConnectionSuspended();
    }

    void connect();

    void disconnect();

    CarApi getCarApi();
}
