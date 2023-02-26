package android.support.car.hardware;

import android.os.Bundle;
import android.support.annotation.RestrictTo;

public class CarSensorConfig {
    private static final int RAW_BUNDLE_SIZE = 4;
    private static final int WHEEL_TICK_DISTANCE_BUNDLE_SIZE = 6;
    public static final String WHEEL_TICK_DISTANCE_FRONT_LEFT_UM_PER_TICK = "android.car.wheelTickDistanceFrontLeftUmPerTick";
    public static final String WHEEL_TICK_DISTANCE_FRONT_RIGHT_UM_PER_TICK = "android.car.wheelTickDistanceFrontRightUmPerTick";
    public static final String WHEEL_TICK_DISTANCE_REAR_LEFT_UM_PER_TICK = "android.car.wheelTickDistanceRearLeftUmPerTick";
    public static final String WHEEL_TICK_DISTANCE_REAR_RIGHT_UM_PER_TICK = "android.car.wheelTickDistanceRearRightUmPerTick";
    public static final String WHEEL_TICK_DISTANCE_SUPPORTED_WHEELS = "android.car.wheelTickDistanceSupportedWhheels";
    private final Bundle mConfig;
    private final int mType;

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    public CarSensorConfig(int i, Bundle bundle) {
        this.mType = i;
        this.mConfig = bundle.deepCopy();
    }

    private void checkType(int i) {
        if (this.mType != i) {
            throw new UnsupportedOperationException(String.format("Invalid sensor type: expected %d, got %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mType)}));
        }
    }

    public int getInt(String str) {
        if (this.mConfig.containsKey(str)) {
            return this.mConfig.getInt(str);
        }
        throw new IllegalArgumentException("SensorType " + this.mType + " does not contain key: " + str);
    }

    public int getType() {
        return this.mType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName() + "[");
        sb.append("mConfig: " + this.mConfig.toString());
        sb.append("mType: " + this.mType);
        sb.append("]");
        return sb.toString();
    }
}
