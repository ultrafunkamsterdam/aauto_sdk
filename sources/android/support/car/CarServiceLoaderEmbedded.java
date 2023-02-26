package android.support.car;

import android.car.Car;
import android.car.CarNotConnectedException;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.support.car.CarServiceLoader;
import android.support.car.content.p000pm.CarPackageManagerEmbedded;
import android.support.car.hardware.CarSensorManagerEmbedded;
import android.support.car.media.CarAudioManagerEmbedded;
import android.support.car.navigation.CarNavigationStatusManagerEmbedded;

public class CarServiceLoaderEmbedded extends CarServiceLoader {
    private final Car mEmbeddedCar;
    private final ServiceConnection mServiceConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            CarServiceLoaderEmbedded.this.getConnectionCallback().onConnected();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            CarServiceLoaderEmbedded.this.getConnectionCallback().onDisconnected();
        }
    };

    CarServiceLoaderEmbedded(Context context, CarServiceLoader.CarConnectionCallbackProxy carConnectionCallbackProxy, Handler handler) {
        super(context, carConnectionCallbackProxy, handler);
        this.mEmbeddedCar = Car.createCar(context, this.mServiceConnection, handler);
    }

    public void connect() throws IllegalStateException {
        this.mEmbeddedCar.connect();
    }

    public void disconnect() {
        this.mEmbeddedCar.disconnect();
    }

    public int getCarConnectionType() throws CarNotConnectedException {
        return this.mEmbeddedCar.getCarConnectionType();
    }

    public Object getCarManager(String str) throws CarNotConnectedException {
        try {
            Object carManager = this.mEmbeddedCar.getCarManager(str);
            if (carManager == null) {
                return null;
            }
            char c = 65535;
            switch (str.hashCode()) {
                case -1853877803:
                    if (str.equals("car_navigation_service")) {
                        c = 5;
                        break;
                    }
                    break;
                case -905948230:
                    if (str.equals(Car.SENSOR_SERVICE)) {
                        c = 1;
                        break;
                    }
                    break;
                case -807062458:
                    if (str.equals(Car.PACKAGE_SERVICE)) {
                        c = 4;
                        break;
                    }
                    break;
                case 3237038:
                    if (str.equals(Car.INFO_SERVICE)) {
                        c = 2;
                        break;
                    }
                    break;
                case 93166550:
                    if (str.equals(Car.AUDIO_SERVICE)) {
                        c = 0;
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
                    return new CarAudioManagerEmbedded(carManager);
                case 1:
                    return new CarSensorManagerEmbedded(carManager, getContext());
                case 2:
                    return new CarInfoManagerEmbedded(carManager);
                case 3:
                    return new CarAppFocusManagerEmbedded(carManager);
                case 4:
                    return new CarPackageManagerEmbedded(carManager);
                case 5:
                    return new CarNavigationStatusManagerEmbedded(carManager);
                default:
                    return carManager;
            }
        } catch (CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public boolean isConnected() {
        return this.mEmbeddedCar.isConnected();
    }
}
