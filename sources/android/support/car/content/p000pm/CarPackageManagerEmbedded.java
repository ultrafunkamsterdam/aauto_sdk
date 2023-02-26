package android.support.car.content.p000pm;

import android.car.content.pm.CarPackageManager;
import android.support.car.CarNotConnectedException;

/* renamed from: android.support.car.content.pm.CarPackageManagerEmbedded */
public class CarPackageManagerEmbedded extends CarPackageManager {
    private final CarPackageManager mManager;

    public CarPackageManagerEmbedded(Object obj) {
        this.mManager = (CarPackageManager) obj;
    }

    public CarPackageManager getManager() {
        return this.mManager;
    }

    public boolean isActivityAllowedWhileDriving(String str, String str2) throws CarNotConnectedException {
        try {
            return this.mManager.isActivityAllowedWhileDriving(str, str2);
        } catch (android.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public boolean isServiceAllowedWhileDriving(String str, String str2) throws CarNotConnectedException {
        try {
            return this.mManager.isServiceAllowedWhileDriving(str, str2);
        } catch (android.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public void onCarDisconnected() {
    }
}
