package android.support.car.navigation;

import android.car.navigation.CarNavigationInstrumentCluster;
import android.car.navigation.CarNavigationStatusManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.car.CarNotConnectedException;
import android.support.car.navigation.CarNavigationStatusManager;

public class CarNavigationStatusManagerEmbedded extends CarNavigationStatusManager {
    private final CarNavigationStatusManager mManager;

    public CarNavigationStatusManagerEmbedded(Object obj) {
        this.mManager = (CarNavigationStatusManager) obj;
    }

    private static CarNavigationInstrumentCluster convert(CarNavigationInstrumentCluster carNavigationInstrumentCluster) {
        if (carNavigationInstrumentCluster == null) {
            return null;
        }
        return new CarNavigationInstrumentCluster(carNavigationInstrumentCluster.getMinIntervalMillis(), carNavigationInstrumentCluster.getType(), carNavigationInstrumentCluster.getImageWidth(), carNavigationInstrumentCluster.getImageHeight(), carNavigationInstrumentCluster.getImageColorDepthBits(), carNavigationInstrumentCluster.getExtra());
    }

    public void addListener(CarNavigationStatusManager.CarNavigationCallback carNavigationCallback) throws CarNotConnectedException {
        try {
            carNavigationCallback.onInstrumentClusterStarted(this, convert(this.mManager.getInstrumentClusterInfo()));
        } catch (android.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public void onCarDisconnected() {
    }

    public void removeListener() {
    }

    public void sendEvent(int i, Bundle bundle) throws CarNotConnectedException {
        try {
            this.mManager.sendEvent(i, bundle);
        } catch (android.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public void sendNavigationStatus(int i) throws CarNotConnectedException {
        try {
            this.mManager.sendNavigationStatus(i);
        } catch (android.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public void sendNavigationTurnDistanceEvent(int i, int i2, int i3, int i4) throws CarNotConnectedException {
        try {
            this.mManager.sendNavigationTurnDistanceEvent(i, i2, i3, i4);
        } catch (android.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public void sendNavigationTurnEvent(int i, CharSequence charSequence, int i2, int i3, int i4) throws CarNotConnectedException {
        sendNavigationTurnEvent(i, charSequence, i2, i3, (Bitmap) null, i4);
    }

    public void sendNavigationTurnEvent(int i, CharSequence charSequence, int i2, int i3, Bitmap bitmap, int i4) throws CarNotConnectedException {
        try {
            this.mManager.sendNavigationTurnEvent(i, charSequence, i2, i3, bitmap, i4);
        } catch (android.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }
}
