package android.support.car;

import android.car.CarInfoManager;
import android.car.CarNotConnectedException;

public class CarInfoManagerEmbedded extends CarInfoManager {
    private final CarInfoManager mManager;

    CarInfoManagerEmbedded(Object obj) {
        this.mManager = (CarInfoManager) obj;
    }

    public int getDriverPosition() throws CarNotConnectedException {
        return 0;
    }

    public String getHeadunitManufacturer() throws CarNotConnectedException {
        return null;
    }

    public String getHeadunitModel() throws CarNotConnectedException {
        return null;
    }

    public String getHeadunitSoftwareBuild() throws CarNotConnectedException {
        return null;
    }

    public String getHeadunitSoftwareVersion() throws CarNotConnectedException {
        return null;
    }

    public String getManufacturer() throws CarNotConnectedException {
        try {
            return this.mManager.getManufacturer();
        } catch (CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public String getModel() throws CarNotConnectedException {
        try {
            return this.mManager.getModel();
        } catch (CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public String getModelYear() throws CarNotConnectedException {
        try {
            return this.mManager.getModelYear();
        } catch (CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public String getVehicleId() throws CarNotConnectedException {
        try {
            return this.mManager.getVehicleId();
        } catch (CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public void onCarDisconnected() {
    }
}
