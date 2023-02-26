package com.google.android.apps.auto.sdk.service;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.car.Car;
import android.support.car.CarNotConnectedException;
import android.support.car.CarServiceLoader;
import android.util.Log;
import com.google.android.apps.auto.sdk.service.p008a.C0070a;
import com.google.android.apps.auto.sdk.service.p008a.C0082e;
import com.google.android.apps.auto.sdk.service.p008a.C0083f;
import com.google.android.apps.auto.sdk.service.p008a.p009a.C0071a;
import com.google.android.apps.auto.sdk.service.p008a.p010b.C0074a;
import com.google.android.gms.car.C0110a;
import com.google.android.gms.car.C0116g;
import com.google.android.gms.car.CarApi;
import com.google.android.gms.car.CarApiConnection;
import com.google.android.gms.car.CarAudioManager;
import com.google.android.gms.car.CarInfoManager;
import com.google.android.gms.car.CarMessageManager;
import com.google.android.gms.car.CarNavigationStatusManager;
import com.google.android.gms.car.CarNotSupportedException;
import com.google.android.gms.car.CarSensorManager;
import javax.annotation.concurrent.GuardedBy;

@Keep
public class CarServiceLoaderGms extends CarServiceLoader {
    private static final String TAG = "CAR.SVC.LOADER.GMS";
    @VisibleForTesting
    final C0067a mApiConnectionCallback = new C0067a(this, (byte) 0);
    private final C0110a mApiFactory = new C0110a();
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public CarApi mCarApi;
    @VisibleForTesting
    final C0068b mCarApiCallback = new C0068b(this, (byte) 0);
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public CarApiConnection mCarApiConnection;
    private final C0069a mUtil = new C0069a();

    /* renamed from: com.google.android.apps.auto.sdk.service.CarServiceLoaderGms$a */
    final class C0067a implements CarApiConnection.ApiConnectionCallback {
        private C0067a() {
        }

        /* synthetic */ C0067a(CarServiceLoaderGms carServiceLoaderGms, byte b) {
            this();
        }

        /* renamed from: a */
        private final void m274a() {
            synchronized (CarServiceLoaderGms.this) {
                CarServiceLoaderGms.this.tearDownCarApi();
            }
            CarServiceLoaderGms.this.getConnectionCallback().onDisconnected();
        }

        public final void onConnected() {
            synchronized (CarServiceLoaderGms.this) {
                if (CarServiceLoaderGms.this.mCarApiConnection != null) {
                    CarServiceLoaderGms.this.tearDownCarApi();
                    CarApi unused = CarServiceLoaderGms.this.mCarApi = CarServiceLoaderGms.this.mCarApiConnection.getCarApi();
                    if (!CarServiceLoaderGms.this.mCarApi.isConnectedToCar()) {
                        CarServiceLoaderGms.this.getConnectionCallback().onDisconnected();
                    }
                    CarServiceLoaderGms.this.mCarApi.registerCarConnectionListener(CarServiceLoaderGms.this.mCarApiCallback);
                }
            }
        }

        public final void onConnectionFailed() {
            m274a();
        }

        public final void onConnectionSuspended() {
            m274a();
        }
    }

    /* renamed from: com.google.android.apps.auto.sdk.service.CarServiceLoaderGms$b */
    final class C0068b implements CarApi.CarConnectionCallback {
        private C0068b() {
        }

        /* synthetic */ C0068b(CarServiceLoaderGms carServiceLoaderGms, byte b) {
            this();
        }

        public final void onConnected(int i) {
            CarServiceLoaderGms.this.getConnectionCallback().onConnected();
        }

        public final void onDisconnected() {
            CarServiceLoaderGms.this.getConnectionCallback().onDisconnected();
        }
    }

    public CarServiceLoaderGms(@NonNull Context context, @NonNull CarServiceLoader.CarConnectionCallbackProxy carConnectionCallbackProxy, @NonNull Handler handler) {
        super(context, carConnectionCallbackProxy, handler);
        try {
            C0116g.m377a(context);
        } catch (Exception e) {
            throw new IllegalArgumentException("A valid Android Auto package must be installed", e);
        }
    }

    private void createApiConnectionInstance() {
        synchronized (this) {
            tearDownCarApiConnection();
            try {
                this.mCarApiConnection = this.mApiFactory.mo977a(getContext(), this.mApiConnectionCallback, getEventHandler().getLooper());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Object getCarManagerInternal(String str) throws CarNotConnectedException {
        Object obj;
        synchronized (this) {
            char c = 65535;
            try {
                switch (str.hashCode()) {
                    case -1853877803:
                        if (str.equals("car_navigation_service")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -1527548130:
                        if (str.equals(CarVendorExtensionManagerLoader.VENDOR_EXTENSION_LOADER_SERVICE)) {
                            c = 5;
                            break;
                        }
                        break;
                    case -905948230:
                        if (str.equals(Car.SENSOR_SERVICE)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 3237038:
                        if (str.equals(Car.INFO_SERVICE)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 93166550:
                        if (str.equals(Car.AUDIO_SERVICE)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1830376762:
                        if (str.equals(Car.APP_FOCUS_SERVICE)) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        obj = new C0082e((CarInfoManager) this.mCarApi.getCarManager(str));
                        break;
                    case 1:
                        obj = new C0071a((AudioManager) getContext().getSystemService(Car.AUDIO_SERVICE), (CarAudioManager) this.mCarApi.getCarManager(str));
                        break;
                    case 2:
                        obj = new C0083f((CarSensorManager) this.mCarApi.getCarManager(str));
                        break;
                    case 3:
                        obj = new C0070a((CarMessageManager) this.mCarApi.getCarManager(str));
                        break;
                    case 4:
                        obj = new C0074a((CarNavigationStatusManager) this.mCarApi.getCarManager(str));
                        break;
                    case 5:
                        obj = new CarVendorExtensionManagerLoader(this.mCarApi);
                        break;
                    default:
                        obj = this.mUtil.mo577a(this.mCarApi, str);
                        break;
                }
            } catch (CarNotSupportedException e) {
                obj = null;
            } catch (com.google.android.gms.car.CarNotConnectedException e2) {
                throw new CarNotConnectedException((Exception) e2);
            }
        }
        return obj;
    }

    /* access modifiers changed from: private */
    public void tearDownCarApi() {
        synchronized (this) {
            if (!(this.mCarApi == null || this.mCarApiCallback == null)) {
                try {
                    this.mCarApi.unregisterCarConnectionListener(this.mCarApiCallback);
                } catch (IllegalArgumentException | IllegalStateException e) {
                    Log.e(TAG, "Error unregistering a listener", e);
                }
            }
            this.mCarApi = null;
        }
        return;
    }

    private void tearDownCarApiConnection() {
        synchronized (this) {
            if (this.mCarApiConnection != null) {
                this.mCarApiConnection.disconnect();
            }
            this.mCarApiConnection = null;
        }
    }

    public void connect() {
        synchronized (this) {
            if (!isConnected()) {
                createApiConnectionInstance();
                this.mCarApiConnection.connect();
            }
        }
    }

    public void disconnect() {
        synchronized (this) {
            tearDownCarApi();
            tearDownCarApiConnection();
        }
    }

    public int getCarConnectionType() throws CarNotConnectedException {
        int i;
        synchronized (this) {
            if (!isConnected()) {
                throw new CarNotConnectedException();
            }
            try {
                switch (this.mCarApi.getCarConnectionType()) {
                    case 0:
                        i = 0;
                        break;
                    case 1:
                        i = 1;
                        break;
                    case 2:
                        i = 2;
                        break;
                    case 3:
                        i = 3;
                        break;
                    case 4:
                        i = 4;
                        break;
                    default:
                        i = -1;
                        break;
                }
            } catch (com.google.android.gms.car.CarNotConnectedException e) {
                throw new CarNotConnectedException((Exception) e);
            }
        }
        return i;
    }

    public Object getCarManager(String str) throws CarNotConnectedException {
        Object carManagerInternal;
        synchronized (this) {
            if (!isConnected()) {
                throw new CarNotConnectedException();
            }
            try {
                carManagerInternal = getCarManagerInternal(str);
            } catch (CarNotConnectedException e) {
                throw new CarNotConnectedException((Exception) e);
            }
        }
        return carManagerInternal;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean isApiNull() {
        boolean z;
        synchronized (this) {
            z = this.mCarApi == null;
        }
        return z;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this) {
            z = this.mCarApi != null && this.mCarApi.isConnectedToCar();
        }
        return z;
    }
}
