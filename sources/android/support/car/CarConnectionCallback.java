package android.support.car;

public abstract class CarConnectionCallback {
    public abstract void onConnected(Car car);

    public abstract void onDisconnected(Car car);
}
