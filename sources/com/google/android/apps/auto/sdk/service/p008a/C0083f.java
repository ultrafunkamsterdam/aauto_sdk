package com.google.android.apps.auto.sdk.service.p008a;

import android.support.annotation.VisibleForTesting;
import android.support.car.CarNotConnectedException;
import android.support.car.hardware.CarSensorConfig;
import android.support.car.hardware.CarSensorEvent;
import android.support.car.hardware.CarSensorManager;
import android.util.Log;
import com.google.android.apps.auto.sdk.service.p008a.p011c.C0078b;
import com.google.android.gms.car.CarSensorManager;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.apps.auto.sdk.service.a.f */
public final class C0083f extends CarSensorManager {

    /* renamed from: a */
    private final com.google.android.gms.car.CarSensorManager f224a;

    /* renamed from: b */
    private ArrayList<Integer> f225b;

    /* renamed from: c */
    private int[] f226c;
    @VisibleForTesting

    /* renamed from: d */
    private C0078b<CarSensorManager.OnSensorChangedListener, C0085h> f227d = new C0078b<>(new C0084g(this));

    public C0083f(com.google.android.gms.car.CarSensorManager carSensorManager) {
        this.f224a = carSensorManager;
    }

    /* renamed from: a */
    private final List<Integer> m296a() throws CarNotConnectedException {
        if (this.f225b != null) {
            return this.f225b;
        }
        this.f225b = new ArrayList<>();
        try {
            int[] supportedSensors = this.f224a.getSupportedSensors();
            if (supportedSensors != null) {
                for (int valueOf : supportedSensors) {
                    this.f225b.add(Integer.valueOf(valueOf));
                }
            }
            return this.f225b;
        } catch (com.google.android.gms.car.CarNotConnectedException e) {
            Log.e("CSL.CarSensorManagerGms", "Car Not Connected", e);
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public final boolean addListener(CarSensorManager.OnSensorChangedListener onSensorChangedListener, int i, int i2) throws CarNotConnectedException, IllegalArgumentException {
        if (!isSensorSupported(i)) {
            return false;
        }
        try {
            return this.f224a.registerListener(this.f227d.mo592a(Integer.valueOf(i), onSensorChangedListener), i, i2);
        } catch (com.google.android.gms.car.CarNotConnectedException e) {
            this.f227d.mo593b(Integer.valueOf(i), onSensorChangedListener);
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public final CarSensorEvent getLatestSensorEvent(int i) throws CarNotConnectedException {
        try {
            CarSensorManager.RawEventData latestSensorEvent = this.f224a.getLatestSensorEvent(i);
            return new CarSensorEvent(latestSensorEvent.sensorType, latestSensorEvent.timeStamp, latestSensorEvent.floatValues, latestSensorEvent.byteValues, (long[]) null);
        } catch (com.google.android.gms.car.CarNotConnectedException e) {
            Log.e("CSL.CarSensorManagerGms", "Car Not Connected", e);
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public final CarSensorConfig getSensorConfig(int i) throws CarNotConnectedException {
        throw new UnsupportedOperationException("getSensorConfig not supported in projection");
    }

    public final int[] getSupportedSensors() throws CarNotConnectedException {
        if (this.f226c == null) {
            List<Integer> a = m296a();
            this.f226c = new int[a.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= a.size()) {
                    break;
                }
                this.f226c[i2] = a.get(i2).intValue();
                i = i2 + 1;
            }
        }
        return this.f226c;
    }

    public final boolean isSensorSupported(int i) throws CarNotConnectedException {
        return m296a().contains(Integer.valueOf(i));
    }

    public final void onCarDisconnected() {
        C0078b<CarSensorManager.OnSensorChangedListener, C0085h> bVar = this.f227d;
        synchronized (bVar.f219b) {
            bVar.f219b.clear();
            bVar.f218a.clear();
        }
    }

    public final void removeListener(CarSensorManager.OnSensorChangedListener onSensorChangedListener) {
        this.f224a.unregisterListener(this.f227d.mo591a(onSensorChangedListener));
    }

    public final void removeListener(CarSensorManager.OnSensorChangedListener onSensorChangedListener, int i) {
        this.f224a.unregisterListener(this.f227d.mo593b(Integer.valueOf(i), onSensorChangedListener), i);
    }
}
