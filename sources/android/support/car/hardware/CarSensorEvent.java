package android.support.car.hardware;

import android.location.Location;
import android.os.SystemClock;
import android.support.annotation.RestrictTo;

public class CarSensorEvent {
    public static final int DRIVE_STATUS_FULLY_RESTRICTED = 31;
    public static final int DRIVE_STATUS_LIMIT_MESSAGE_LEN = 16;
    public static final int DRIVE_STATUS_NO_CONFIG = 8;
    public static final int DRIVE_STATUS_NO_KEYBOARD_INPUT = 2;
    public static final int DRIVE_STATUS_NO_VIDEO = 1;
    public static final int DRIVE_STATUS_NO_VOICE_INPUT = 4;
    public static final int DRIVE_STATUS_UNRESTRICTED = 0;
    private static final float[] EMPTY_FLOAT_ARRAY = new float[0];
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final long[] EMPTY_LONG_ARRAY = new long[0];
    public static final int GEAR_DRIVE = 100;
    public static final int GEAR_EIGHTH = 8;
    public static final int GEAR_FIFTH = 5;
    public static final int GEAR_FIRST = 1;
    public static final int GEAR_FOURTH = 4;
    public static final int GEAR_NEUTRAL = 0;
    public static final int GEAR_NINTH = 9;
    public static final int GEAR_PARK = 101;
    public static final int GEAR_REVERSE = 102;
    public static final int GEAR_SECOND = 2;
    public static final int GEAR_SEVENTH = 7;
    public static final int GEAR_SIXTH = 6;
    public static final int GEAR_TENTH = 10;
    public static final int GEAR_THIRD = 3;
    public static final int INDEX_ACCELEROMETER_X = 0;
    public static final int INDEX_ACCELEROMETER_Y = 1;
    public static final int INDEX_ACCELEROMETER_Z = 2;
    public static final int INDEX_COMPASS_BEARING = 0;
    public static final int INDEX_COMPASS_PITCH = 1;
    public static final int INDEX_COMPASS_ROLL = 2;
    public static final int INDEX_ENVIRONMENT_PRESSURE = 1;
    public static final int INDEX_ENVIRONMENT_TEMPERATURE = 0;
    public static final int INDEX_FUEL_LEVEL_IN_DISTANCE = 1;
    public static final int INDEX_FUEL_LEVEL_IN_PERCENTILE = 0;
    public static final int INDEX_FUEL_LOW_WARNING = 0;
    public static final int INDEX_GPS_SATELLITE_ARRAY_FLOAT_INTERVAL = 4;
    public static final int INDEX_GPS_SATELLITE_ARRAY_FLOAT_OFFSET = 0;
    public static final int INDEX_GPS_SATELLITE_ARRAY_INT_INTERVAL = 1;
    public static final int INDEX_GPS_SATELLITE_ARRAY_INT_OFFSET = 2;
    public static final int INDEX_GPS_SATELLITE_AZIMUTH_OFFSET = 2;
    public static final int INDEX_GPS_SATELLITE_ELEVATION_OFFSET = 3;
    public static final int INDEX_GPS_SATELLITE_NUMBER_IN_USE = 0;
    public static final int INDEX_GPS_SATELLITE_NUMBER_IN_VIEW = 1;
    public static final int INDEX_GPS_SATELLITE_PRN_OFFSET = 0;
    public static final int INDEX_GPS_SATELLITE_SNR_OFFSET = 1;
    public static final int INDEX_GYROSCOPE_X = 0;
    public static final int INDEX_GYROSCOPE_Y = 1;
    public static final int INDEX_GYROSCOPE_Z = 2;
    public static final int INDEX_LOCATION_ACCURACY = 2;
    public static final int INDEX_LOCATION_ALTITUDE = 3;
    public static final int INDEX_LOCATION_BEARING = 5;
    public static final int INDEX_LOCATION_LATITUDE = 0;
    public static final int INDEX_LOCATION_LATITUDE_INTS = 1;
    public static final int INDEX_LOCATION_LONGITUDE = 1;
    public static final int INDEX_LOCATION_LONGITUDE_INTS = 2;
    public static final int INDEX_LOCATION_MAX = 5;
    public static final int INDEX_LOCATION_SPEED = 4;
    public static final int INDEX_WHEEL_DISTANCE_FRONT_LEFT = 1;
    public static final int INDEX_WHEEL_DISTANCE_FRONT_RIGHT = 2;
    public static final int INDEX_WHEEL_DISTANCE_REAR_LEFT = 4;
    public static final int INDEX_WHEEL_DISTANCE_REAR_RIGHT = 3;
    public static final int INDEX_WHEEL_DISTANCE_RESET_COUNT = 0;
    private static final long MILLI_IN_NANOS = 1000000;
    private final int floatInterval = 4;
    private final int floatOffset = 0;
    public final float[] floatValues;
    private final int intInterval = 1;
    private final int intOffset = 2;
    public final int[] intValues;
    public final long[] longValues;
    public final int sensorType;
    public final long timestamp;

    public static class AccelerometerData {
        public final long timestamp;

        /* renamed from: x */
        public final float f0x;

        /* renamed from: y */
        public final float f1y;

        /* renamed from: z */
        public final float f2z;

        @RestrictTo({RestrictTo.Scope.GROUP_ID})
        public AccelerometerData(long j, float f, float f2, float f3) {
            this.timestamp = j;
            this.f0x = f;
            this.f1y = f2;
            this.f2z = f3;
        }
    }

    public static class CarAbsActiveData {
        public final boolean absIsActive;
        public final long timestamp;

        @RestrictTo({RestrictTo.Scope.GROUP_ID})
        public CarAbsActiveData(long j, boolean z) {
            this.timestamp = j;
            this.absIsActive = z;
        }
    }

    public static class CarSpeedData {
        public final float carSpeed;
        public final long timestamp;

        @RestrictTo({RestrictTo.Scope.GROUP_ID})
        public CarSpeedData(long j, float f) {
            this.timestamp = j;
            this.carSpeed = f;
        }
    }

    public static class CarTractionControlActiveData {
        public final long timestamp;
        public final boolean tractionControlIsActive;

        @RestrictTo({RestrictTo.Scope.GROUP_ID})
        public CarTractionControlActiveData(long j, boolean z) {
            this.timestamp = j;
            this.tractionControlIsActive = z;
        }
    }

    public static class CarWheelTickDistanceData {
        public final long frontLeftWheelDistanceMm;
        public final long frontRightWheelDistanceMm;
        public final long rearLeftWheelDistanceMm;
        public final long rearRightWheelDistanceMm;
        public final long sensorResetCount;
        public final long timestamp;

        @RestrictTo({RestrictTo.Scope.GROUP_ID})
        public CarWheelTickDistanceData(long j, long j2, long j3, long j4, long j5, long j6) {
            this.timestamp = j;
            this.sensorResetCount = j2;
            this.frontLeftWheelDistanceMm = j3;
            this.frontRightWheelDistanceMm = j4;
            this.rearRightWheelDistanceMm = j5;
            this.rearLeftWheelDistanceMm = j6;
        }
    }

    public static class CompassData {
        public final float bearing;
        public final float pitch;
        public final float roll;
        public final long timestamp;

        @RestrictTo({RestrictTo.Scope.GROUP_ID})
        public CompassData(long j, float f, float f2, float f3) {
            this.timestamp = j;
            this.bearing = f;
            this.pitch = f2;
            this.roll = f3;
        }
    }

    public static class DrivingStatusData {
        public final int status;
        public final long timestamp;

        @RestrictTo({RestrictTo.Scope.GROUP_ID})
        public DrivingStatusData(long j, int i) {
            this.timestamp = j;
            this.status = i;
        }

        public boolean isConfigurationRestricted() {
            return 8 == (this.status & 8);
        }

        public boolean isFullyRestricted() {
            return 31 == (this.status & 31);
        }

        public boolean isKeyboardRestricted() {
            return 2 == (this.status & 2);
        }

        public boolean isMessageLengthRestricted() {
            return 16 == (this.status & 16);
        }

        public boolean isVideoRestricted() {
            return 1 == (this.status & 1);
        }

        public boolean isVoiceRestricted() {
            return 4 == (this.status & 4);
        }
    }

    public static class EnvironmentData {
        public final float pressure;
        public final float temperature;
        public final long timestamp;

        @RestrictTo({RestrictTo.Scope.GROUP_ID})
        public EnvironmentData(long j, float f, float f2) {
            this.timestamp = j;
            this.temperature = f;
            this.pressure = f2;
        }
    }

    public static class FuelLevelData {
        public final int level;
        public final boolean lowFuelWarning;
        public final float range;
        public final long timestamp;

        @RestrictTo({RestrictTo.Scope.GROUP_ID})
        public FuelLevelData(long j, int i, float f, boolean z) {
            this.timestamp = j;
            this.level = i;
            this.range = f;
            this.lowFuelWarning = z;
        }
    }

    public static class GearData {
        public final int gear;
        public final long timestamp;

        @RestrictTo({RestrictTo.Scope.GROUP_ID})
        public GearData(long j, int i) {
            this.timestamp = j;
            this.gear = i;
        }
    }

    public static class GpsSatelliteData {
        public final float[] azimuth;
        public final float[] elevation;
        public final int numberInUse;
        public final int numberInView;
        public final int[] prn;
        public final float[] snr;
        public final long timestamp;
        public final boolean[] usedInFix;

        @RestrictTo({RestrictTo.Scope.GROUP_ID})
        public GpsSatelliteData(long j, int i, int i2, boolean[] zArr, int[] iArr, float[] fArr, float[] fArr2, float[] fArr3) {
            this.timestamp = j;
            this.numberInUse = i;
            this.numberInView = i2;
            this.usedInFix = zArr;
            this.prn = iArr;
            this.snr = fArr;
            this.azimuth = fArr2;
            this.elevation = fArr3;
        }
    }

    public static class GyroscopeData {
        public final long timestamp;

        /* renamed from: x */
        public final float f3x;

        /* renamed from: y */
        public final float f4y;

        /* renamed from: z */
        public final float f5z;

        @RestrictTo({RestrictTo.Scope.GROUP_ID})
        public GyroscopeData(long j, float f, float f2, float f3) {
            this.timestamp = j;
            this.f3x = f;
            this.f4y = f2;
            this.f5z = f3;
        }
    }

    public static class NightData {
        public final boolean isNightMode;
        public final long timestamp;

        @RestrictTo({RestrictTo.Scope.GROUP_ID})
        public NightData(long j, boolean z) {
            this.timestamp = j;
            this.isNightMode = z;
        }
    }

    public static class OdometerData {
        public final float kms;
        public final long timestamp;

        @RestrictTo({RestrictTo.Scope.GROUP_ID})
        public OdometerData(long j, float f) {
            this.timestamp = j;
            this.kms = f;
        }
    }

    public static class ParkingBrakeData {
        public final boolean isEngaged;
        public final long timestamp;

        @RestrictTo({RestrictTo.Scope.GROUP_ID})
        public ParkingBrakeData(long j, boolean z) {
            this.timestamp = j;
            this.isEngaged = z;
        }
    }

    public static class RpmData {
        public final float rpm;
        public final long timestamp;

        @RestrictTo({RestrictTo.Scope.GROUP_ID})
        public RpmData(long j, float f) {
            this.timestamp = j;
            this.rpm = f;
        }
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    public CarSensorEvent(int i, long j, int i2, int i3, int i4) {
        this.sensorType = i;
        this.timestamp = j;
        this.floatValues = new float[i2];
        this.intValues = new int[i3];
        this.longValues = new long[i4];
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    public CarSensorEvent(int i, long j, float[] fArr, byte[] bArr, long[] jArr) {
        this.sensorType = i;
        this.timestamp = j;
        this.floatValues = fArr == null ? EMPTY_FLOAT_ARRAY : fArr;
        if (bArr == 0) {
            this.intValues = EMPTY_INT_ARRAY;
        } else {
            this.intValues = new int[bArr.length];
            for (int i2 = 0; i2 < bArr.length; i2++) {
                this.intValues[i2] = bArr[i2];
            }
        }
        this.longValues = jArr == null ? EMPTY_LONG_ARRAY : jArr;
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    public CarSensorEvent(int i, long j, float[] fArr, int[] iArr, long[] jArr) {
        this.sensorType = i;
        this.timestamp = j;
        this.floatValues = fArr == null ? EMPTY_FLOAT_ARRAY : fArr;
        this.intValues = iArr == null ? EMPTY_INT_ARRAY : iArr;
        this.longValues = jArr == null ? EMPTY_LONG_ARRAY : jArr;
    }

    private void checkType(int i) {
        if (this.sensorType != i) {
            throw new UnsupportedOperationException(String.format("Invalid sensor type: expected %d, got %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.sensorType)}));
        }
    }

    public AccelerometerData getAccelerometerData() {
        checkType(14);
        return new AccelerometerData(this.timestamp, this.floatValues[0], this.floatValues[1], this.floatValues[2]);
    }

    public CarAbsActiveData getCarAbsActiveData() {
        boolean z = false;
        checkType(24);
        if (this.intValues[0] == 1) {
            z = true;
        }
        return new CarAbsActiveData(this.timestamp, z);
    }

    public CarSpeedData getCarSpeedData() {
        checkType(2);
        return new CarSpeedData(this.timestamp, this.floatValues[0]);
    }

    public CarTractionControlActiveData getCarTractionControlActiveData() {
        boolean z = false;
        checkType(25);
        if (this.intValues[0] == 1) {
            z = true;
        }
        return new CarTractionControlActiveData(this.timestamp, z);
    }

    public CarWheelTickDistanceData getCarWheelTickDistanceData() {
        checkType(23);
        return new CarWheelTickDistanceData(this.timestamp, this.longValues[0], this.longValues[1], this.longValues[2], this.longValues[3], this.longValues[4]);
    }

    public CompassData getCompassData() {
        checkType(1);
        return new CompassData(0, this.floatValues[0], this.floatValues[1], this.floatValues[2]);
    }

    public DrivingStatusData getDrivingStatusData() {
        checkType(11);
        return new DrivingStatusData(this.timestamp, this.intValues[0]);
    }

    public EnvironmentData getEnvironmentData() {
        checkType(12);
        return new EnvironmentData(this.timestamp, this.floatValues[0], this.floatValues[1]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.support.car.hardware.CarSensorEvent.FuelLevelData getFuelLevelData() {
        /*
            r7 = this;
            r3 = 0
            r1 = 1
            r6 = 0
            r0 = 5
            r7.checkType(r0)
            r0 = -1
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            float[] r2 = r7.floatValues
            if (r2 == 0) goto L_0x0037
            float[] r2 = r7.floatValues
            r2 = r2[r6]
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x001b
            float[] r0 = r7.floatValues
            r0 = r0[r6]
            int r0 = (int) r0
        L_0x001b:
            float[] r2 = r7.floatValues
            r2 = r2[r1]
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x0037
            float[] r2 = r7.floatValues
            r5 = r2[r1]
            r4 = r0
        L_0x0028:
            int[] r0 = r7.intValues
            r0 = r0[r6]
            if (r0 != r1) goto L_0x002f
            r6 = r1
        L_0x002f:
            android.support.car.hardware.CarSensorEvent$FuelLevelData r1 = new android.support.car.hardware.CarSensorEvent$FuelLevelData
            long r2 = r7.timestamp
            r1.<init>(r2, r4, r5, r6)
            return r1
        L_0x0037:
            r4 = r0
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.car.hardware.CarSensorEvent.getFuelLevelData():android.support.car.hardware.CarSensorEvent$FuelLevelData");
    }

    public GearData getGearData() {
        checkType(7);
        return new GearData(this.timestamp, this.intValues[0]);
    }

    public GpsSatelliteData getGpsSatelliteData(boolean z) {
        float[] fArr;
        float[] fArr2;
        float[] fArr3;
        int[] iArr;
        boolean[] zArr;
        checkType(17);
        int i = this.intValues[0];
        int i2 = this.intValues[1];
        if (!z || i2 < 0) {
            fArr = null;
            fArr2 = null;
            fArr3 = null;
            iArr = null;
            zArr = null;
        } else {
            int length = (this.floatValues.length + 0) / 4;
            zArr = new boolean[length];
            iArr = new int[length];
            fArr3 = new float[length];
            fArr2 = new float[length];
            fArr = new float[length];
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = (i3 * 4) + 0;
                zArr[i3] = this.intValues[(i3 * 1) + 2] != 0;
                iArr[i3] = Math.round(this.floatValues[i4 + 0]);
                fArr3[i3] = this.floatValues[i4 + 1];
                fArr2[i3] = this.floatValues[i4 + 2];
                fArr[i3] = this.floatValues[i4 + 3];
            }
        }
        return new GpsSatelliteData(this.timestamp, i, i2, zArr, iArr, fArr3, fArr2, fArr);
    }

    public GyroscopeData getGyroscopeData() {
        checkType(18);
        return new GyroscopeData(this.timestamp, this.floatValues[0], this.floatValues[1], this.floatValues[2]);
    }

    public Location getLocation(Location location) {
        checkType(10);
        if (location == null) {
            location = new Location("Car-GPS");
        }
        int i = this.intValues[0];
        if ((i & 1) != 0) {
            location.setLatitude(((double) this.intValues[1]) * 1.0E-7d);
        }
        if ((i & 2) != 0) {
            location.setLongitude(((double) this.intValues[2]) * 1.0E-7d);
        }
        if ((i & 4) != 0) {
            location.setAccuracy(this.floatValues[2]);
        }
        if ((i & 8) != 0) {
            location.setAltitude((double) this.floatValues[3]);
        }
        if ((i & 16) != 0) {
            location.setSpeed(this.floatValues[4]);
        }
        if ((i & 32) != 0) {
            location.setBearing(this.floatValues[5]);
        }
        location.setElapsedRealtimeNanos(this.timestamp);
        location.setTime(System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - this.timestamp) / MILLI_IN_NANOS));
        return location;
    }

    public NightData getNightData() {
        boolean z = false;
        checkType(9);
        long j = this.timestamp;
        if (this.intValues[0] == 1) {
            z = true;
        }
        return new NightData(j, z);
    }

    public OdometerData getOdometerData() {
        checkType(4);
        return new OdometerData(this.timestamp, this.floatValues[0]);
    }

    public ParkingBrakeData getParkingBrakeData() {
        boolean z = false;
        checkType(6);
        long j = this.timestamp;
        if (this.intValues[0] == 1) {
            z = true;
        }
        return new ParkingBrakeData(j, z);
    }

    public RpmData getRpmData() {
        checkType(3);
        return new RpmData(this.timestamp, this.floatValues[0]);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName() + "[");
        sb.append("type:" + Integer.toHexString(this.sensorType));
        if (this.floatValues != null && this.floatValues.length > 0) {
            sb.append(" float values:");
            float[] fArr = this.floatValues;
            int length = fArr.length;
            for (int i = 0; i < length; i++) {
                sb.append(" " + fArr[i]);
            }
        }
        if (this.intValues != null && this.intValues.length > 0) {
            sb.append(" int values:");
            int[] iArr = this.intValues;
            int length2 = iArr.length;
            for (int i2 = 0; i2 < length2; i2++) {
                sb.append(" " + iArr[i2]);
            }
        }
        if (this.longValues != null && this.longValues.length > 0) {
            sb.append(" long values:");
            long[] jArr = this.longValues;
            int length3 = jArr.length;
            for (int i3 = 0; i3 < length3; i3++) {
                sb.append(" " + jArr[i3]);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
