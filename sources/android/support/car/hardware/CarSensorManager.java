package android.support.car.hardware;

import android.support.annotation.RequiresPermission;
import android.support.car.CarManagerBase;
import android.support.car.CarNotConnectedException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class CarSensorManager implements CarManagerBase {
    public static final int SENSOR_RATE_FAST = 1;
    public static final int SENSOR_RATE_FASTEST = 0;
    public static final int SENSOR_RATE_NORMAL = 3;
    public static final int SENSOR_RATE_UI = 2;
    public static final int SENSOR_TYPE_ABS_ACTIVE = 24;
    public static final int SENSOR_TYPE_ACCELEROMETER = 14;
    public static final int SENSOR_TYPE_CAR_SPEED = 2;
    public static final int SENSOR_TYPE_COMPASS = 1;
    public static final int SENSOR_TYPE_DRIVING_STATUS = 11;
    public static final int SENSOR_TYPE_ENVIRONMENT = 12;
    public static final int SENSOR_TYPE_FUEL_LEVEL = 5;
    public static final int SENSOR_TYPE_GEAR = 7;
    public static final int SENSOR_TYPE_GPS_SATELLITE = 17;
    public static final int SENSOR_TYPE_GYROSCOPE = 18;
    public static final int SENSOR_TYPE_LOCATION = 10;
    public static final int SENSOR_TYPE_NIGHT = 9;
    public static final int SENSOR_TYPE_ODOMETER = 4;
    public static final int SENSOR_TYPE_PARKING_BRAKE = 6;
    public static final int SENSOR_TYPE_RESERVED13 = 13;
    public static final int SENSOR_TYPE_RESERVED15 = 15;
    public static final int SENSOR_TYPE_RESERVED16 = 16;
    public static final int SENSOR_TYPE_RESERVED19 = 19;
    public static final int SENSOR_TYPE_RESERVED20 = 20;
    public static final int SENSOR_TYPE_RESERVED21 = 21;
    public static final int SENSOR_TYPE_RESERVED22 = 22;
    public static final int SENSOR_TYPE_RESERVED8 = 8;
    public static final int SENSOR_TYPE_RPM = 3;
    public static final int SENSOR_TYPE_TRACTION_CONTROL_ACTIVE = 25;
    public static final int SENSOR_TYPE_VENDOR_EXTENSION_END = 1879048191;
    public static final int SENSOR_TYPE_VENDOR_EXTENSION_START = 1610612736;
    public static final int SENSOR_TYPE_WHEEL_TICK_DISTANCE = 23;

    public interface OnSensorChangedListener {
        void onSensorChanged(CarSensorManager carSensorManager, CarSensorEvent carSensorEvent);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SensorRate {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SensorType {
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_FINE_LOCATION", "android.car.permission.CAR_SPEED", "android.car.permission.CAR_MILEAGE", "android.car.permission.CAR_FUEL", "android.car.permission.VEHICLE_DYNAMICS_STATE"}, conditional = true)
    public abstract boolean addListener(OnSensorChangedListener onSensorChangedListener, int i, int i2) throws CarNotConnectedException, IllegalArgumentException;

    public abstract CarSensorEvent getLatestSensorEvent(int i) throws CarNotConnectedException;

    public abstract CarSensorConfig getSensorConfig(int i) throws CarNotConnectedException;

    public abstract int[] getSupportedSensors() throws CarNotConnectedException;

    public abstract boolean isSensorSupported(int i) throws CarNotConnectedException;

    public abstract void removeListener(OnSensorChangedListener onSensorChangedListener);

    public abstract void removeListener(OnSensorChangedListener onSensorChangedListener, int i);
}
