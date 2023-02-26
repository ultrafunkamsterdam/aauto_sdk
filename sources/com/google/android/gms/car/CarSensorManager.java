package com.google.android.gms.car;

import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.internal.Hide;

public interface CarSensorManager {

    public interface CarSensorEventListener {
        void onSensorChanged(int i, long j, float[] fArr, byte[] bArr);
    }

    public static class RawEventData {
        public final byte[] byteValues;
        public final float[] floatValues;
        public final int sensorType;
        public final long timeStamp;

        public RawEventData(int i, long j, float[] fArr, byte[] bArr) {
            this.sensorType = i;
            this.timeStamp = j;
            this.floatValues = fArr;
            this.byteValues = bArr;
        }
    }

    @Nullable
    @Hide
    int[] getEvConnectorTypes() throws CarNotConnectedException;

    @Nullable
    @Hide
    int[] getFuelTypes() throws CarNotConnectedException;

    RawEventData getLatestSensorEvent(int i) throws CarNotConnectedException;

    @Hide
    int getLocationCharacterization() throws CarNotConnectedException;

    int[] getSupportedSensors() throws CarNotConnectedException;

    boolean isSensorSupported(int i) throws CarNotConnectedException;

    @RequiresPermission(anyOf = {"android.permission.ACCESS_FINE_LOCATION", "com.google.android.gms.permission.CAR_SPEED", "android.car.permission.CAR_SPEED", "com.google.android.gms.permission.CAR_MILEAGE", "android.car.permission.CAR_MILEAGE", "com.google.android.gms.permission.CAR_FUEL", "android.car.permission.CAR_FUEL"}, conditional = true)
    boolean registerListener(CarSensorEventListener carSensorEventListener, int i, int i2) throws CarNotConnectedException;

    void unregisterListener(CarSensorEventListener carSensorEventListener);

    void unregisterListener(CarSensorEventListener carSensorEventListener, int i);
}
