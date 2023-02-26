package com.google.android.gms.car;

public class CarNotConnectedException extends Exception {
    public CarNotConnectedException() {
    }

    public CarNotConnectedException(Exception exc) {
        super(exc);
    }

    public CarNotConnectedException(String str) {
        super(str);
    }

    public CarNotConnectedException(String str, Throwable th) {
        super(str, th);
    }
}
