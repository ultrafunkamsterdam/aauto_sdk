package android.support.car;

import android.support.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class CarInfoManager implements CarManagerBase {
    public static final int DRIVER_SIDE_CENTER = 3;
    public static final int DRIVER_SIDE_LEFT = 1;
    public static final int DRIVER_SIDE_RIGHT = 2;
    public static final int DRIVER_SIDE_UNKNOWN = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DriverSide {
    }

    public abstract int getDriverPosition() throws CarNotConnectedException;

    @Nullable
    public abstract String getHeadunitManufacturer() throws CarNotConnectedException;

    @Nullable
    public abstract String getHeadunitModel() throws CarNotConnectedException;

    @Nullable
    public abstract String getHeadunitSoftwareBuild() throws CarNotConnectedException;

    @Nullable
    public abstract String getHeadunitSoftwareVersion() throws CarNotConnectedException;

    @Nullable
    public abstract String getManufacturer() throws CarNotConnectedException;

    @Nullable
    public abstract String getModel() throws CarNotConnectedException;

    @Nullable
    public abstract String getModelYear() throws CarNotConnectedException;

    @Nullable
    public abstract String getVehicleId() throws CarNotConnectedException;
}
