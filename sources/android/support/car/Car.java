package android.support.car;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.car.CarServiceLoader;
import android.support.car.content.p000pm.CarPackageManager;
import android.support.car.hardware.CarSensorManager;
import android.support.car.media.CarAudioManager;
import android.support.car.navigation.CarNavigationStatusManager;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Car {
    public static final String APP_FOCUS_SERVICE = "app_focus";
    public static final String AUDIO_SERVICE = "audio";
    public static final String CAR_NAVIGATION_SERVICE = "car_navigation_service";
    private static final Map<Class, String> CLASS_TO_SERVICE_NAME;
    private static final Set<Integer> CONNECTION_TYPES = new HashSet();
    public static final int CONNECTION_TYPE_ADB_EMULATOR = 4;
    public static final int CONNECTION_TYPE_EMBEDDED = 5;
    public static final int CONNECTION_TYPE_EMULATOR = 0;
    public static final int CONNECTION_TYPE_ON_DEVICE_EMULATOR = 3;
    public static final int CONNECTION_TYPE_UNKNOWN = -1;
    public static final int CONNECTION_TYPE_USB = 1;
    public static final int CONNECTION_TYPE_WIFI = 2;
    private static final String FEATURE_AUTOMOTIVE = "android.hardware.type.automotive";
    public static final String INFO_SERVICE = "info";
    public static final String NAVIGATION_STATUS_SERVICE = "car_navigation_service";
    public static final String PACKAGE_SERVICE = "package";
    public static final String PERMISSION_CAR_CONTROL_AUDIO_VOLUME = "android.car.permission.CAR_CONTROL_AUDIO_VOLUME";
    public static final String PERMISSION_CAR_NAVIGATION_MANAGER = "android.car.permission.PERMISSION_CAR_NAVIGATION_MANAGER";
    public static final String PERMISSION_FUEL = "android.car.permission.CAR_FUEL";
    public static final String PERMISSION_MILEAGE = "android.car.permission.CAR_MILEAGE";
    public static final String PERMISSION_SPEED = "android.car.permission.CAR_SPEED";
    public static final String PERMISSION_VEHICLE_DYNAMICS_STATE = "android.car.permission.VEHICLE_DYNAMICS_STATE";
    public static final String PERMISSION_VENDOR_EXTENSION = "android.car.permission.CAR_VENDOR_EXTENSION";
    private static final String PROJECTED_CAR_SERVICE_LOADER = "com.google.android.apps.auto.sdk.service.CarServiceLoaderGms";
    public static final String SENSOR_SERVICE = "sensor";
    private static final int STATE_CONNECTED = 2;
    private static final int STATE_CONNECTING = 1;
    private static final int STATE_DISCONNECTED = 0;
    private static final String TAG = "CAR.SUPPORT.LIB.CAR";
    /* access modifiers changed from: private */
    public final CarConnectionCallback mCarConnectionCallback;
    private final CarServiceLoader.CarConnectionCallbackProxy mCarConnectionCallbackProxy = new CarServiceLoader.CarConnectionCallbackProxy() {
        public void onConnected() {
            synchronized (Car.this) {
                int unused = Car.this.mConnectionState = 2;
            }
            Car.this.mCarConnectionCallback.onConnected(Car.this);
        }

        public void onDisconnected() {
            synchronized (Car.this) {
                if (Car.this.mConnectionState != 0) {
                    Car.this.tearDownCarManagers();
                    int unused = Car.this.mConnectionState = 0;
                    Car.this.mCarConnectionCallback.onDisconnected(Car.this);
                }
            }
        }
    };
    private final Object mCarManagerLock = new Object();
    private final CarServiceLoader mCarServiceLoader;
    /* access modifiers changed from: private */
    public int mConnectionState;
    private final Context mContext;
    private final Handler mEventHandler;
    private final HashMap<String, CarManagerBase> mServiceMap = new HashMap<>();

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConnectionType {
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(CarSensorManager.class, SENSOR_SERVICE);
        hashMap.put(CarInfoManager.class, INFO_SERVICE);
        hashMap.put(CarAppFocusManager.class, APP_FOCUS_SERVICE);
        hashMap.put(CarPackageManager.class, PACKAGE_SERVICE);
        hashMap.put(CarAudioManager.class, AUDIO_SERVICE);
        hashMap.put(CarNavigationStatusManager.class, "car_navigation_service");
        CLASS_TO_SERVICE_NAME = Collections.unmodifiableMap(hashMap);
        CONNECTION_TYPES.add(4);
        CONNECTION_TYPES.add(1);
        CONNECTION_TYPES.add(2);
        CONNECTION_TYPES.add(3);
        CONNECTION_TYPES.add(4);
        CONNECTION_TYPES.add(5);
    }

    private Car(Context context, CarConnectionCallback carConnectionCallback, @Nullable Handler handler) {
        this.mContext = context;
        this.mCarConnectionCallback = carConnectionCallback;
        this.mEventHandler = handler == null ? new Handler(Looper.getMainLooper()) : handler;
        if (this.mContext.getPackageManager().hasSystemFeature(FEATURE_AUTOMOTIVE)) {
            this.mCarServiceLoader = new CarServiceLoaderEmbedded(context, this.mCarConnectionCallbackProxy, this.mEventHandler);
        } else {
            this.mCarServiceLoader = loadCarServiceLoader(PROJECTED_CAR_SERVICE_LOADER, context, this.mCarConnectionCallbackProxy, this.mEventHandler);
        }
    }

    public Car(@NonNull CarServiceLoader carServiceLoader) throws CarNotConnectedException {
        if (!carServiceLoader.isConnected()) {
            throw new CarNotConnectedException();
        }
        this.mCarServiceLoader = carServiceLoader;
        this.mEventHandler = carServiceLoader.getEventHandler();
        this.mContext = carServiceLoader.getContext();
        this.mConnectionState = 2;
        this.mCarConnectionCallback = null;
    }

    public static Car createCar(Context context, CarConnectionCallback carConnectionCallback) {
        return createCar(context, carConnectionCallback, (Handler) null);
    }

    public static Car createCar(Context context, CarConnectionCallback carConnectionCallback, @Nullable Handler handler) {
        try {
            return new Car(context, carConnectionCallback, handler);
        } catch (IllegalArgumentException e) {
            Log.w(TAG, "Car failed to be created", e);
            return null;
        }
    }

    private CarServiceLoader loadCarServiceLoader(String str, Context context, CarServiceLoader.CarConnectionCallbackProxy carConnectionCallbackProxy, Handler handler) throws IllegalArgumentException {
        try {
            Class<? extends U> asSubclass = Class.forName(str).asSubclass(CarServiceLoader.class);
            try {
                try {
                    return (CarServiceLoader) asSubclass.getDeclaredConstructor(new Class[]{Context.class, CarServiceLoader.CarConnectionCallbackProxy.class, Handler.class}).newInstance(new Object[]{context, carConnectionCallbackProxy, handler});
                } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException e) {
                    throw new IllegalArgumentException("Cannot construct CarServiceLoader, constructor failed for " + asSubclass.getName(), e);
                }
            } catch (NoSuchMethodException e2) {
                throw new IllegalArgumentException("Cannot construct CarServiceLoader, no constructor: " + str, e2);
            }
        } catch (ClassNotFoundException e3) {
            throw new IllegalArgumentException("Cannot find CarServiceLoader implementation:" + str, e3);
        }
    }

    /* access modifiers changed from: private */
    public void tearDownCarManagers() {
        synchronized (this.mCarManagerLock) {
            for (CarManagerBase onCarDisconnected : this.mServiceMap.values()) {
                onCarDisconnected.onCarDisconnected();
            }
            this.mServiceMap.clear();
        }
    }

    public void connect() throws IllegalStateException {
        synchronized (this) {
            if (this.mConnectionState != 0) {
                throw new IllegalStateException("already connected or connecting");
            }
            this.mConnectionState = 1;
            this.mCarServiceLoader.connect();
        }
    }

    public void disconnect() {
        synchronized (this) {
            tearDownCarManagers();
            this.mConnectionState = 0;
            this.mCarServiceLoader.disconnect();
        }
    }

    public int getCarConnectionType() throws CarNotConnectedException {
        int carConnectionType = this.mCarServiceLoader.getCarConnectionType();
        if (!CONNECTION_TYPES.contains(Integer.valueOf(carConnectionType))) {
            return -1;
        }
        return carConnectionType;
    }

    public <T> T getCarManager(Class<T> cls) throws CarNotConnectedException {
        String str = CLASS_TO_SERVICE_NAME.get(cls);
        if (str == null) {
            return null;
        }
        return getCarManager(str);
    }

    public Object getCarManager(String str) throws CarNotConnectedException {
        Object obj;
        synchronized (this.mCarManagerLock) {
            obj = this.mServiceMap.get(str);
            if (obj == null) {
                obj = this.mCarServiceLoader.getCarManager(str);
            }
            if (obj != null && (obj instanceof CarManagerBase)) {
                this.mServiceMap.put(str, (CarManagerBase) obj);
            }
        }
        return obj;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this) {
            z = this.mConnectionState == 2;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z = true;
        synchronized (this) {
            if (this.mConnectionState != 1) {
                z = false;
            }
        }
        return z;
    }
}
