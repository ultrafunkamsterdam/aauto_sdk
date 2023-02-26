package android.support.car.hardware;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.car.Car;
import android.support.car.hardware.CarSensorManager;
import android.util.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class CarSensorsProxy {
    private static final int MSG_SENSORT_EVENT = 1;
    private static final String TAG = "CarSensorsProxy";
    private final Sensor mAccelerometerSensor;
    /* access modifiers changed from: private */
    public final CarSensorManager mCarSensorManager;
    private final GpsStatus.Listener mGpsStatusListener = new GpsStatus.Listener() {
        public void onGpsStatusChanged(int i) {
            if (i == 4) {
                synchronized (CarSensorsProxy.this) {
                    GpsStatus unused = CarSensorsProxy.this.mLastGpsStatus = CarSensorsProxy.this.mLocationManager.getGpsStatus(CarSensorsProxy.this.mLastGpsStatus);
                    long unused2 = CarSensorsProxy.this.mLastGpsStatusTime = System.nanoTime();
                }
                CarSensorsProxy.this.pushSensorChanges(17);
            }
        }
    };
    private final Sensor mGyroscopeSensor;
    private final Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            Collection<CarSensorManager.OnSensorChangedListener> collection;
            switch (message.what) {
                case 1:
                    int i = message.arg1;
                    synchronized (CarSensorsProxy.this) {
                        collection = (Collection) CarSensorsProxy.this.mListenersMultiMap.get(Integer.valueOf(i));
                    }
                    CarSensorEvent carSensorEvent = (CarSensorEvent) message.obj;
                    if (carSensorEvent != null) {
                        for (CarSensorManager.OnSensorChangedListener onSensorChanged : collection) {
                            onSensorChanged.onSensorChanged(CarSensorsProxy.this.mCarSensorManager, carSensorEvent);
                        }
                        return;
                    }
                    return;
                default:
                    Log.w(CarSensorsProxy.TAG, "Unexpected msg dispatched. msg: " + message);
                    super.handleMessage(message);
                    return;
            }
        }
    };

    /* renamed from: mI */
    private float[] f6mI = new float[16];
    /* access modifiers changed from: private */
    public float[] mLastAccelerometerData = new float[3];
    /* access modifiers changed from: private */
    public long mLastAccelerometerDataTime;
    /* access modifiers changed from: private */
    public GpsStatus mLastGpsStatus;
    /* access modifiers changed from: private */
    public long mLastGpsStatusTime;
    /* access modifiers changed from: private */
    public float[] mLastGyroscopeData = new float[3];
    /* access modifiers changed from: private */
    public long mLastGyroscopeDataTime;
    /* access modifiers changed from: private */
    public Location mLastLocation;
    /* access modifiers changed from: private */
    public long mLastLocationTime;
    /* access modifiers changed from: private */
    public float[] mLastMagneticFieldData = new float[3];
    /* access modifiers changed from: private */
    public long mLastMagneticFieldDataTime;
    /* access modifiers changed from: private */
    public final Map<Integer, Set<CarSensorManager.OnSensorChangedListener>> mListenersMultiMap;
    private final LocationListener mLocationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            synchronized (CarSensorsProxy.this) {
                Location unused = CarSensorsProxy.this.mLastLocation = location;
                long unused2 = CarSensorsProxy.this.mLastLocationTime = System.nanoTime();
            }
            CarSensorsProxy.this.pushSensorChanges(10);
        }

        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    };
    /* access modifiers changed from: private */
    public final LocationManager mLocationManager;
    private final Sensor mMagneticFieldSensor;
    private float[] mOrientation = new float[3];

    /* renamed from: mR */
    private float[] f7mR = new float[16];
    private final SensorEventListener mSensorListener = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onSensorChanged(android.hardware.SensorEvent r7) {
            /*
                r6 = this;
                android.hardware.Sensor r0 = r7.sensor
                int r0 = r0.getType()
                android.support.car.hardware.CarSensorsProxy r1 = android.support.car.hardware.CarSensorsProxy.this
                monitor-enter(r1)
                switch(r0) {
                    case 1: goto L_0x0067;
                    case 2: goto L_0x0049;
                    case 3: goto L_0x000c;
                    case 4: goto L_0x0026;
                    default: goto L_0x000c;
                }
            L_0x000c:
                java.lang.String r2 = "CarSensorsProxy"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
                r3.<init>()     // Catch:{ all -> 0x0046 }
                java.lang.String r4 = "Unexpected sensor event type: "
                java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x0046 }
                java.lang.StringBuilder r0 = r3.append(r0)     // Catch:{ all -> 0x0046 }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0046 }
                android.util.Log.w(r2, r0)     // Catch:{ all -> 0x0046 }
                monitor-exit(r1)     // Catch:{ all -> 0x0046 }
            L_0x0025:
                return
            L_0x0026:
                float[] r0 = r7.values     // Catch:{ all -> 0x0046 }
                r2 = 0
                android.support.car.hardware.CarSensorsProxy r3 = android.support.car.hardware.CarSensorsProxy.this     // Catch:{ all -> 0x0046 }
                float[] r3 = r3.mLastGyroscopeData     // Catch:{ all -> 0x0046 }
                r4 = 0
                r5 = 3
                java.lang.System.arraycopy(r0, r2, r3, r4, r5)     // Catch:{ all -> 0x0046 }
                android.support.car.hardware.CarSensorsProxy r0 = android.support.car.hardware.CarSensorsProxy.this     // Catch:{ all -> 0x0046 }
                long r2 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0046 }
                long unused = r0.mLastGyroscopeDataTime = r2     // Catch:{ all -> 0x0046 }
                android.support.car.hardware.CarSensorsProxy r0 = android.support.car.hardware.CarSensorsProxy.this     // Catch:{ all -> 0x0046 }
                r2 = 18
                r0.pushSensorChanges(r2)     // Catch:{ all -> 0x0046 }
            L_0x0044:
                monitor-exit(r1)     // Catch:{ all -> 0x0046 }
                goto L_0x0025
            L_0x0046:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0046 }
                throw r0
            L_0x0049:
                float[] r0 = r7.values     // Catch:{ all -> 0x0046 }
                r2 = 0
                android.support.car.hardware.CarSensorsProxy r3 = android.support.car.hardware.CarSensorsProxy.this     // Catch:{ all -> 0x0046 }
                float[] r3 = r3.mLastMagneticFieldData     // Catch:{ all -> 0x0046 }
                r4 = 0
                r5 = 3
                java.lang.System.arraycopy(r0, r2, r3, r4, r5)     // Catch:{ all -> 0x0046 }
                android.support.car.hardware.CarSensorsProxy r0 = android.support.car.hardware.CarSensorsProxy.this     // Catch:{ all -> 0x0046 }
                long r2 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0046 }
                long unused = r0.mLastMagneticFieldDataTime = r2     // Catch:{ all -> 0x0046 }
                android.support.car.hardware.CarSensorsProxy r0 = android.support.car.hardware.CarSensorsProxy.this     // Catch:{ all -> 0x0046 }
                r2 = 1
                r0.pushSensorChanges(r2)     // Catch:{ all -> 0x0046 }
                goto L_0x0044
            L_0x0067:
                float[] r0 = r7.values     // Catch:{ all -> 0x0046 }
                r2 = 0
                android.support.car.hardware.CarSensorsProxy r3 = android.support.car.hardware.CarSensorsProxy.this     // Catch:{ all -> 0x0046 }
                float[] r3 = r3.mLastAccelerometerData     // Catch:{ all -> 0x0046 }
                r4 = 0
                r5 = 3
                java.lang.System.arraycopy(r0, r2, r3, r4, r5)     // Catch:{ all -> 0x0046 }
                android.support.car.hardware.CarSensorsProxy r0 = android.support.car.hardware.CarSensorsProxy.this     // Catch:{ all -> 0x0046 }
                long r2 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0046 }
                long unused = r0.mLastAccelerometerDataTime = r2     // Catch:{ all -> 0x0046 }
                android.support.car.hardware.CarSensorsProxy r0 = android.support.car.hardware.CarSensorsProxy.this     // Catch:{ all -> 0x0046 }
                r2 = 14
                r0.pushSensorChanges(r2)     // Catch:{ all -> 0x0046 }
                android.support.car.hardware.CarSensorsProxy r0 = android.support.car.hardware.CarSensorsProxy.this     // Catch:{ all -> 0x0046 }
                r2 = 1
                r0.pushSensorChanges(r2)     // Catch:{ all -> 0x0046 }
                goto L_0x0044
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.car.hardware.CarSensorsProxy.C00043.onSensorChanged(android.hardware.SensorEvent):void");
        }
    };
    private final SensorManager mSensorManager;
    private final int[] mSupportedSensors;

    CarSensorsProxy(CarSensorManager carSensorManager, Context context) {
        this.mLocationManager = (LocationManager) context.getSystemService("location");
        this.mSensorManager = (SensorManager) context.getSystemService(Car.SENSOR_SERVICE);
        this.mAccelerometerSensor = this.mSensorManager.getDefaultSensor(1);
        this.mMagneticFieldSensor = this.mSensorManager.getDefaultSensor(2);
        this.mGyroscopeSensor = this.mSensorManager.getDefaultSensor(4);
        this.mListenersMultiMap = new HashMap();
        this.mSupportedSensors = initSupportedSensors(context);
        this.mCarSensorManager = carSensorManager;
    }

    private CarSensorEvent createGpsStatusCarSensorEvent(GpsStatus gpsStatus) {
        if (gpsStatus == null) {
            return null;
        }
        int i = 0;
        int i2 = 0;
        for (GpsSatellite usedInFix : gpsStatus.getSatellites()) {
            int i3 = i2 + 1;
            if (usedInFix.usedInFix()) {
                i++;
                i2 = i3;
            } else {
                i2 = i3;
            }
        }
        CarSensorEvent carSensorEvent = new CarSensorEvent(17, this.mLastGpsStatusTime, (i2 * 4) + 0, (i2 * 1) + 2, 0);
        carSensorEvent.intValues[0] = i;
        carSensorEvent.intValues[1] = i2;
        int i4 = 0;
        for (GpsSatellite next : gpsStatus.getSatellites()) {
            int i5 = (i4 * 4) + 0;
            carSensorEvent.floatValues[i5 + 0] = (float) next.getPrn();
            carSensorEvent.floatValues[i5 + 1] = next.getSnr();
            carSensorEvent.floatValues[i5 + 2] = next.getAzimuth();
            carSensorEvent.floatValues[i5 + 3] = next.getElevation();
            carSensorEvent.intValues[(i4 * 1) + 2] = next.usedInFix() ? 1 : 0;
            i4++;
        }
        return carSensorEvent;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.support.car.hardware.CarSensorEvent getSensorEvent(int r8) {
        /*
            r7 = this;
            r2 = 0
            monitor-enter(r7)
            switch(r8) {
                case 1: goto L_0x0021;
                case 10: goto L_0x0085;
                case 14: goto L_0x009c;
                case 17: goto L_0x00cc;
                case 18: goto L_0x00d9;
                default: goto L_0x0006;
            }
        L_0x0006:
            java.lang.String r0 = "CarSensorsProxy"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x010d }
            r1.<init>()     // Catch:{ all -> 0x010d }
            java.lang.String r2 = "[getSensorEvent]: Unsupported sensor type:"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x010d }
            java.lang.StringBuilder r1 = r1.append(r8)     // Catch:{ all -> 0x010d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x010d }
            android.util.Log.w(r0, r1)     // Catch:{ all -> 0x010d }
            monitor-exit(r7)     // Catch:{ all -> 0x010d }
            r0 = 0
        L_0x0020:
            return r0
        L_0x0021:
            long r0 = r7.mLastMagneticFieldDataTime     // Catch:{ all -> 0x010d }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x010a
            long r0 = r7.mLastAccelerometerDataTime     // Catch:{ all -> 0x010d }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x010a
            android.support.car.hardware.CarSensorEvent r0 = new android.support.car.hardware.CarSensorEvent     // Catch:{ all -> 0x010d }
            long r2 = r7.mLastMagneticFieldDataTime     // Catch:{ all -> 0x010d }
            long r4 = r7.mLastAccelerometerDataTime     // Catch:{ all -> 0x010d }
            long r2 = java.lang.Math.max(r2, r4)     // Catch:{ all -> 0x010d }
            r4 = 3
            r5 = 0
            r6 = 0
            r1 = r8
            r0.<init>((int) r1, (long) r2, (int) r4, (int) r5, (int) r6)     // Catch:{ all -> 0x010d }
            float[] r1 = r7.f7mR     // Catch:{ all -> 0x0082 }
            float[] r2 = r7.f6mI     // Catch:{ all -> 0x0082 }
            float[] r3 = r7.mLastAccelerometerData     // Catch:{ all -> 0x0082 }
            float[] r4 = r7.mLastMagneticFieldData     // Catch:{ all -> 0x0082 }
            android.hardware.SensorManager.getRotationMatrix(r1, r2, r3, r4)     // Catch:{ all -> 0x0082 }
            float[] r1 = r7.f7mR     // Catch:{ all -> 0x0082 }
            float[] r2 = r7.mOrientation     // Catch:{ all -> 0x0082 }
            android.hardware.SensorManager.getOrientation(r1, r2)     // Catch:{ all -> 0x0082 }
            float[] r1 = r0.floatValues     // Catch:{ all -> 0x0082 }
            r2 = 0
            float[] r3 = r7.mOrientation     // Catch:{ all -> 0x0082 }
            r4 = 0
            r3 = r3[r4]     // Catch:{ all -> 0x0082 }
            double r4 = (double) r3     // Catch:{ all -> 0x0082 }
            double r4 = java.lang.Math.toDegrees(r4)     // Catch:{ all -> 0x0082 }
            float r3 = (float) r4     // Catch:{ all -> 0x0082 }
            r1[r2] = r3     // Catch:{ all -> 0x0082 }
            float[] r1 = r0.floatValues     // Catch:{ all -> 0x0082 }
            r2 = 1
            float[] r3 = r7.mOrientation     // Catch:{ all -> 0x0082 }
            r4 = 1
            r3 = r3[r4]     // Catch:{ all -> 0x0082 }
            double r4 = (double) r3     // Catch:{ all -> 0x0082 }
            double r4 = java.lang.Math.toDegrees(r4)     // Catch:{ all -> 0x0082 }
            float r3 = (float) r4     // Catch:{ all -> 0x0082 }
            r1[r2] = r3     // Catch:{ all -> 0x0082 }
            float[] r1 = r0.floatValues     // Catch:{ all -> 0x0082 }
            r2 = 2
            float[] r3 = r7.mOrientation     // Catch:{ all -> 0x0082 }
            r4 = 2
            r3 = r3[r4]     // Catch:{ all -> 0x0082 }
            double r4 = (double) r3     // Catch:{ all -> 0x0082 }
            double r4 = java.lang.Math.toDegrees(r4)     // Catch:{ all -> 0x0082 }
            float r3 = (float) r4     // Catch:{ all -> 0x0082 }
            r1[r2] = r3     // Catch:{ all -> 0x0082 }
        L_0x0080:
            monitor-exit(r7)     // Catch:{ all -> 0x0082 }
            goto L_0x0020
        L_0x0082:
            r0 = move-exception
        L_0x0083:
            monitor-exit(r7)     // Catch:{ all -> 0x0082 }
            throw r0
        L_0x0085:
            long r0 = r7.mLastLocationTime     // Catch:{ all -> 0x010d }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x010a
            android.support.car.hardware.CarSensorEvent r0 = new android.support.car.hardware.CarSensorEvent     // Catch:{ all -> 0x010d }
            long r2 = r7.mLastLocationTime     // Catch:{ all -> 0x010d }
            r4 = 6
            r5 = 3
            r6 = 0
            r1 = r8
            r0.<init>((int) r1, (long) r2, (int) r4, (int) r5, (int) r6)     // Catch:{ all -> 0x010d }
            android.location.Location r1 = r7.mLastLocation     // Catch:{ all -> 0x0082 }
            r7.populateLocationCarSensorEvent(r0, r1)     // Catch:{ all -> 0x0082 }
            goto L_0x0080
        L_0x009c:
            long r0 = r7.mLastAccelerometerDataTime     // Catch:{ all -> 0x010d }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x010a
            android.support.car.hardware.CarSensorEvent r0 = new android.support.car.hardware.CarSensorEvent     // Catch:{ all -> 0x010d }
            long r2 = r7.mLastAccelerometerDataTime     // Catch:{ all -> 0x010d }
            r4 = 3
            r5 = 0
            r6 = 0
            r1 = r8
            r0.<init>((int) r1, (long) r2, (int) r4, (int) r5, (int) r6)     // Catch:{ all -> 0x010d }
            float[] r1 = r0.floatValues     // Catch:{ all -> 0x0082 }
            r2 = 0
            float[] r3 = r7.mLastAccelerometerData     // Catch:{ all -> 0x0082 }
            r4 = 0
            r3 = r3[r4]     // Catch:{ all -> 0x0082 }
            r1[r2] = r3     // Catch:{ all -> 0x0082 }
            float[] r1 = r0.floatValues     // Catch:{ all -> 0x0082 }
            r2 = 1
            float[] r3 = r7.mLastAccelerometerData     // Catch:{ all -> 0x0082 }
            r4 = 1
            r3 = r3[r4]     // Catch:{ all -> 0x0082 }
            r1[r2] = r3     // Catch:{ all -> 0x0082 }
            float[] r1 = r0.floatValues     // Catch:{ all -> 0x0082 }
            r2 = 2
            float[] r3 = r7.mLastAccelerometerData     // Catch:{ all -> 0x0082 }
            r4 = 2
            r3 = r3[r4]     // Catch:{ all -> 0x0082 }
            r1[r2] = r3     // Catch:{ all -> 0x0082 }
            goto L_0x0080
        L_0x00cc:
            long r0 = r7.mLastGpsStatusTime     // Catch:{ all -> 0x010d }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x010a
            android.location.GpsStatus r0 = r7.mLastGpsStatus     // Catch:{ all -> 0x010d }
            android.support.car.hardware.CarSensorEvent r0 = r7.createGpsStatusCarSensorEvent(r0)     // Catch:{ all -> 0x010d }
            goto L_0x0080
        L_0x00d9:
            long r0 = r7.mLastGyroscopeDataTime     // Catch:{ all -> 0x010d }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x010a
            android.support.car.hardware.CarSensorEvent r0 = new android.support.car.hardware.CarSensorEvent     // Catch:{ all -> 0x010d }
            long r2 = r7.mLastGyroscopeDataTime     // Catch:{ all -> 0x010d }
            r4 = 3
            r5 = 0
            r6 = 0
            r1 = r8
            r0.<init>((int) r1, (long) r2, (int) r4, (int) r5, (int) r6)     // Catch:{ all -> 0x010d }
            float[] r1 = r0.floatValues     // Catch:{ all -> 0x0082 }
            r2 = 0
            float[] r3 = r7.mLastGyroscopeData     // Catch:{ all -> 0x0082 }
            r4 = 0
            r3 = r3[r4]     // Catch:{ all -> 0x0082 }
            r1[r2] = r3     // Catch:{ all -> 0x0082 }
            float[] r1 = r0.floatValues     // Catch:{ all -> 0x0082 }
            r2 = 1
            float[] r3 = r7.mLastGyroscopeData     // Catch:{ all -> 0x0082 }
            r4 = 1
            r3 = r3[r4]     // Catch:{ all -> 0x0082 }
            r1[r2] = r3     // Catch:{ all -> 0x0082 }
            float[] r1 = r0.floatValues     // Catch:{ all -> 0x0082 }
            r2 = 2
            float[] r3 = r7.mLastGyroscopeData     // Catch:{ all -> 0x0082 }
            r4 = 2
            r3 = r3[r4]     // Catch:{ all -> 0x0082 }
            r1[r2] = r3     // Catch:{ all -> 0x0082 }
            goto L_0x0080
        L_0x010a:
            r0 = 0
            goto L_0x0080
        L_0x010d:
            r0 = move-exception
            goto L_0x0083
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.car.hardware.CarSensorsProxy.getSensorEvent(int):android.support.car.hardware.CarSensorEvent");
    }

    private int[] initSupportedSensors(Context context) {
        HashSet hashSet = new HashSet();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager.hasSystemFeature("android.hardware.sensor.compass") && packageManager.hasSystemFeature("android.hardware.sensor.accelerometer")) {
            hashSet.add(1);
        }
        if (packageManager.hasSystemFeature("android.hardware.sensor.accelerometer")) {
            hashSet.add(14);
        }
        if (packageManager.hasSystemFeature("android.hardware.sensor.gyroscope")) {
            hashSet.add(18);
        }
        if (packageManager.hasSystemFeature("android.hardware.location")) {
            hashSet.add(10);
            hashSet.add(17);
        }
        return toIntArray(hashSet);
    }

    private void populateLocationCarSensorEvent(CarSensorEvent carSensorEvent, Location location) {
        int i;
        if (location != null) {
            carSensorEvent.intValues[1] = (int) (location.getLongitude() * 1.0E7d);
            carSensorEvent.intValues[1] = (int) (location.getLatitude() * 1.0E7d);
            if (location.hasAccuracy()) {
                i = 7;
                carSensorEvent.floatValues[2] = location.getAccuracy();
            } else {
                i = 3;
            }
            if (location.hasAltitude()) {
                i |= 8;
                carSensorEvent.floatValues[3] = (float) location.getAltitude();
            }
            if (location.hasSpeed()) {
                i |= 16;
                carSensorEvent.floatValues[4] = location.getSpeed();
            }
            if (location.hasBearing()) {
                i |= 32;
                carSensorEvent.floatValues[5] = location.getBearing();
            }
            carSensorEvent.intValues[0] = i;
        }
    }

    /* access modifiers changed from: private */
    public void pushSensorChanges(int i) {
        CarSensorEvent sensorEvent = getSensorEvent(i);
        if (sensorEvent != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i, 0, sensorEvent));
        }
    }

    private static int[] toIntArray(Collection<Integer> collection) {
        int[] iArr = new int[collection.size()];
        int i = 0;
        Iterator<Integer> it = collection.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return iArr;
            }
            iArr[i2] = it.next().intValue();
            i = i2 + 1;
        }
    }

    private void updateSensorListeners() {
        Set<Integer> keySet;
        synchronized (this) {
            keySet = this.mListenersMultiMap.keySet();
        }
        if (!keySet.contains(10) || !this.mLocationManager.isProviderEnabled("gps")) {
            this.mLocationManager.removeUpdates(this.mLocationListener);
        } else {
            this.mLocationManager.requestLocationUpdates("gps", 0, 0.0f, this.mLocationListener);
        }
        if (keySet.contains(17)) {
            this.mLocationManager.addGpsStatusListener(this.mGpsStatusListener);
        } else {
            this.mLocationManager.removeGpsStatusListener(this.mGpsStatusListener);
        }
        if (keySet.contains(14) || keySet.contains(1)) {
            this.mSensorManager.registerListener(this.mSensorListener, this.mAccelerometerSensor, 0);
        } else {
            this.mSensorManager.unregisterListener(this.mSensorListener, this.mAccelerometerSensor);
        }
        if (keySet.contains(1)) {
            this.mSensorManager.registerListener(this.mSensorListener, this.mMagneticFieldSensor, 0);
        } else {
            this.mSensorManager.unregisterListener(this.mSensorListener, this.mMagneticFieldSensor);
        }
        if (keySet.contains(18)) {
            this.mSensorManager.registerListener(this.mSensorListener, this.mGyroscopeSensor, 0);
        } else {
            this.mSensorManager.unregisterListener(this.mSensorListener, this.mGyroscopeSensor);
        }
    }

    public CarSensorEvent getLatestSensorEvent(int i) {
        return getSensorEvent(i);
    }

    public int[] getSupportedSensors() {
        return this.mSupportedSensors;
    }

    public boolean isSensorSupported(int i) {
        for (int i2 : this.mSupportedSensors) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public boolean registerSensorListener(CarSensorManager.OnSensorChangedListener onSensorChangedListener, int i, int i2) {
        boolean z;
        synchronized (this) {
            if (this.mListenersMultiMap.get(Integer.valueOf(i)) == null) {
                this.mListenersMultiMap.put(Integer.valueOf(i), new HashSet());
                z = true;
            } else {
                z = false;
            }
            this.mListenersMultiMap.get(Integer.valueOf(i)).add(onSensorChangedListener);
        }
        pushSensorChanges(i);
        if (z) {
            updateSensorListeners();
        }
        return true;
    }

    public void unregisterSensorListener(CarSensorManager.OnSensorChangedListener onSensorChangedListener) {
        if (onSensorChangedListener != null) {
            HashSet<Integer> hashSet = new HashSet<>();
            synchronized (this) {
                for (Map.Entry next : this.mListenersMultiMap.entrySet()) {
                    if (((Set) next.getValue()).contains(onSensorChangedListener)) {
                        ((Set) next.getValue()).remove(onSensorChangedListener);
                    }
                    if (((Set) next.getValue()).isEmpty()) {
                        hashSet.add(next.getKey());
                    }
                }
            }
            if (!hashSet.isEmpty()) {
                for (Integer remove : hashSet) {
                    this.mListenersMultiMap.remove(remove);
                }
                updateSensorListeners();
            }
        }
    }

    public void unregisterSensorListener(CarSensorManager.OnSensorChangedListener onSensorChangedListener, int i) {
        boolean z;
        if (onSensorChangedListener != null) {
            synchronized (this) {
                Set set = this.mListenersMultiMap.get(Integer.valueOf(i));
                if (set != null) {
                    set.remove(onSensorChangedListener);
                    if (set.isEmpty()) {
                        this.mListenersMultiMap.remove(Integer.valueOf(i));
                        z = true;
                    }
                }
                z = false;
            }
            if (z) {
                updateSensorListeners();
            }
        }
    }
}
