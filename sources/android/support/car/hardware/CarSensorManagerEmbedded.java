package android.support.car.hardware;

import android.car.hardware.CarSensorConfig;
import android.car.hardware.CarSensorEvent;
import android.car.hardware.CarSensorManager;
import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.car.CarNotConnectedException;
import android.support.car.hardware.CarSensorManager;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.GROUP_ID})
public class CarSensorManagerEmbedded extends CarSensorManager {
    private static final String TAG = "CarSensorsProxy";
    private final CarSensorsProxy mCarSensorsProxy;
    private final LinkedList<OnSensorChangedListenerProxy> mListeners = new LinkedList<>();
    private final CarSensorManager mManager;

    private static class OnSensorChangedListenerProxy implements CarSensorManager.OnSensorChangedListener {
        public final CarSensorManager.OnSensorChangedListener listener;
        public final CarSensorManager manager;
        public final Set<Integer> sensors = new HashSet();

        OnSensorChangedListenerProxy(CarSensorManager.OnSensorChangedListener onSensorChangedListener, int i, CarSensorManager carSensorManager) {
            this.listener = onSensorChangedListener;
            this.sensors.add(Integer.valueOf(i));
            this.manager = carSensorManager;
        }

        public void onSensorChanged(CarSensorEvent carSensorEvent) {
            this.listener.onSensorChanged(this.manager, CarSensorManagerEmbedded.convert(carSensorEvent));
        }
    }

    public CarSensorManagerEmbedded(Object obj, Context context) {
        this.mManager = (android.car.hardware.CarSensorManager) obj;
        this.mCarSensorsProxy = new CarSensorsProxy(this, context);
    }

    private static CarSensorConfig convert(CarSensorConfig carSensorConfig) {
        if (carSensorConfig == null) {
            return null;
        }
        return new CarSensorConfig(carSensorConfig.getType(), carSensorConfig.getBundle());
    }

    /* access modifiers changed from: private */
    public static CarSensorEvent convert(CarSensorEvent carSensorEvent) {
        if (carSensorEvent == null) {
            return null;
        }
        return new CarSensorEvent(carSensorEvent.sensorType, carSensorEvent.timestamp, carSensorEvent.floatValues, carSensorEvent.intValues, carSensorEvent.longValues);
    }

    private OnSensorChangedListenerProxy findListenerLocked(CarSensorManager.OnSensorChangedListener onSensorChangedListener) {
        Iterator it = this.mListeners.iterator();
        while (it.hasNext()) {
            OnSensorChangedListenerProxy onSensorChangedListenerProxy = (OnSensorChangedListenerProxy) it.next();
            if (onSensorChangedListenerProxy.listener == onSensorChangedListener) {
                return onSensorChangedListenerProxy;
            }
        }
        return null;
    }

    private boolean isSensorProxied(int i) throws CarNotConnectedException {
        try {
            return !this.mManager.isSensorSupported(i) && this.mCarSensorsProxy.isSensorSupported(i);
        } catch (android.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
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

    public boolean addListener(CarSensorManager.OnSensorChangedListener onSensorChangedListener, int i, int i2) throws CarNotConnectedException, IllegalArgumentException {
        if (isSensorProxied(i)) {
            return this.mCarSensorsProxy.registerSensorListener(onSensorChangedListener, i, i2);
        }
        synchronized (this) {
            try {
                OnSensorChangedListenerProxy findListenerLocked = findListenerLocked(onSensorChangedListener);
                if (findListenerLocked == null) {
                    findListenerLocked = new OnSensorChangedListenerProxy(onSensorChangedListener, i, this);
                    try {
                        this.mListeners.add(findListenerLocked);
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } else {
                    findListenerLocked.sensors.add(Integer.valueOf(i));
                }
                try {
                    return this.mManager.registerListener(findListenerLocked, i, i2);
                } catch (android.car.CarNotConnectedException e) {
                    throw new CarNotConnectedException((Exception) e);
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public CarSensorEvent getLatestSensorEvent(int i) throws CarNotConnectedException {
        if (isSensorProxied(i)) {
            return this.mCarSensorsProxy.getLatestSensorEvent(i);
        }
        try {
            return convert(this.mManager.getLatestSensorEvent(i));
        } catch (android.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public CarSensorConfig getSensorConfig(int i) throws CarNotConnectedException {
        try {
            return convert(this.mManager.getSensorConfig(i));
        } catch (android.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public int[] getSupportedSensors() throws CarNotConnectedException {
        try {
            HashSet hashSet = new HashSet();
            for (int valueOf : this.mManager.getSupportedSensors()) {
                hashSet.add(Integer.valueOf(valueOf));
            }
            for (int valueOf2 : this.mCarSensorsProxy.getSupportedSensors()) {
                hashSet.add(Integer.valueOf(valueOf2));
            }
            return toIntArray(hashSet);
        } catch (android.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public boolean isSensorSupported(int i) throws CarNotConnectedException {
        try {
            return this.mManager.isSensorSupported(i) || this.mCarSensorsProxy.isSensorSupported(i);
        } catch (android.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public void onCarDisconnected() {
    }

    public void removeListener(CarSensorManager.OnSensorChangedListener onSensorChangedListener) {
        this.mCarSensorsProxy.unregisterSensorListener(onSensorChangedListener);
        synchronized (this) {
            OnSensorChangedListenerProxy findListenerLocked = findListenerLocked(onSensorChangedListener);
            if (findListenerLocked != null) {
                this.mListeners.remove(findListenerLocked);
                this.mManager.unregisterListener(findListenerLocked);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        r3.mManager.unregisterListener(r0, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeListener(android.support.car.hardware.CarSensorManager.OnSensorChangedListener r4, int r5) {
        /*
            r3 = this;
            android.support.car.hardware.CarSensorsProxy r0 = r3.mCarSensorsProxy
            r0.unregisterSensorListener(r4, r5)
            monitor-enter(r3)
            android.support.car.hardware.CarSensorManagerEmbedded$OnSensorChangedListenerProxy r0 = r3.findListenerLocked(r4)     // Catch:{ all -> 0x002b }
            if (r0 != 0) goto L_0x000e
            monitor-exit(r3)     // Catch:{ all -> 0x002b }
        L_0x000d:
            return
        L_0x000e:
            java.util.Set<java.lang.Integer> r1 = r0.sensors     // Catch:{ all -> 0x002b }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x002b }
            r1.remove(r2)     // Catch:{ all -> 0x002b }
            java.util.Set<java.lang.Integer> r1 = r0.sensors     // Catch:{ all -> 0x002b }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x0024
            java.util.LinkedList<android.support.car.hardware.CarSensorManagerEmbedded$OnSensorChangedListenerProxy> r1 = r3.mListeners     // Catch:{ all -> 0x002b }
            r1.remove(r0)     // Catch:{ all -> 0x002b }
        L_0x0024:
            monitor-exit(r3)     // Catch:{ all -> 0x002b }
            android.car.hardware.CarSensorManager r1 = r3.mManager
            r1.unregisterListener(r0, r5)
            goto L_0x000d
        L_0x002b:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x002b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.car.hardware.CarSensorManagerEmbedded.removeListener(android.support.car.hardware.CarSensorManager$OnSensorChangedListener, int):void");
    }
}
