package com.google.android.gms.car;

public class CarNotSupportedException extends Exception {
    public CarNotSupportedException() {
    }

    public CarNotSupportedException(Exception exc) {
        super(exc);
    }

    public CarNotSupportedException(String str) {
        super(str);
    }

    public CarNotSupportedException(String str, Throwable th) {
        super(str, th);
    }
}
