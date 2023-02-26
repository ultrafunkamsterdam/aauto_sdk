package android.support.car.content.p000pm;

import android.support.car.CarManagerBase;
import android.support.car.CarNotConnectedException;

/* renamed from: android.support.car.content.pm.CarPackageManager */
public abstract class CarPackageManager implements CarManagerBase {
    public abstract boolean isActivityAllowedWhileDriving(String str, String str2) throws CarNotConnectedException;

    public abstract boolean isServiceAllowedWhileDriving(String str, String str2) throws CarNotConnectedException;
}
