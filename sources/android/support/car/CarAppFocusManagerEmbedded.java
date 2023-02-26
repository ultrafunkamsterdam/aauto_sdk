package android.support.car;

import android.car.CarAppFocusManager;
import android.car.CarNotConnectedException;
import android.support.car.CarAppFocusManager;
import java.util.HashMap;
import java.util.Map;

public class CarAppFocusManagerEmbedded extends CarAppFocusManager {
    private final Map<CarAppFocusManager.OnAppFocusChangedListener, OnAppFocusChangedListenerProxy> mChangeListeners = new HashMap();
    private final android.car.CarAppFocusManager mManager;
    private final Map<CarAppFocusManager.OnAppFocusOwnershipCallback, OnAppFocusOwnershipCallbackProxy> mOwnershipCallbacks = new HashMap();

    private static class OnAppFocusChangedListenerProxy implements CarAppFocusManager.OnAppFocusChangedListener {
        private final CarAppFocusManager.OnAppFocusChangedListener mListener;
        private final CarAppFocusManager mManager;

        OnAppFocusChangedListenerProxy(CarAppFocusManager carAppFocusManager, CarAppFocusManager.OnAppFocusChangedListener onAppFocusChangedListener) {
            this.mManager = carAppFocusManager;
            this.mListener = onAppFocusChangedListener;
        }

        public void onAppFocusChanged(int i, boolean z) {
            this.mListener.onAppFocusChanged(this.mManager, i, z);
        }
    }

    private static class OnAppFocusOwnershipCallbackProxy implements CarAppFocusManager.OnAppFocusOwnershipCallback {
        private final CarAppFocusManager.OnAppFocusOwnershipCallback mListener;
        private final CarAppFocusManager mManager;

        OnAppFocusOwnershipCallbackProxy(CarAppFocusManager carAppFocusManager, CarAppFocusManager.OnAppFocusOwnershipCallback onAppFocusOwnershipCallback) {
            this.mListener = onAppFocusOwnershipCallback;
            this.mManager = carAppFocusManager;
        }

        public void onAppFocusOwnershipGranted(int i) {
            this.mListener.onAppFocusOwnershipGranted(this.mManager, i);
        }

        public void onAppFocusOwnershipLost(int i) {
            this.mListener.onAppFocusOwnershipLost(this.mManager, i);
        }
    }

    CarAppFocusManagerEmbedded(Object obj) {
        this.mManager = (android.car.CarAppFocusManager) obj;
    }

    public void abandonAppFocus(CarAppFocusManager.OnAppFocusOwnershipCallback onAppFocusOwnershipCallback) {
        if (onAppFocusOwnershipCallback == null) {
            throw new IllegalArgumentException("null listener");
        }
        synchronized (this) {
            OnAppFocusOwnershipCallbackProxy onAppFocusOwnershipCallbackProxy = this.mOwnershipCallbacks.get(onAppFocusOwnershipCallback);
            if (onAppFocusOwnershipCallbackProxy != null) {
                this.mManager.abandonAppFocus(onAppFocusOwnershipCallbackProxy);
            }
        }
    }

    public void abandonAppFocus(CarAppFocusManager.OnAppFocusOwnershipCallback onAppFocusOwnershipCallback, int i) {
        if (onAppFocusOwnershipCallback == null) {
            throw new IllegalArgumentException("null listener");
        }
        synchronized (this) {
            OnAppFocusOwnershipCallbackProxy onAppFocusOwnershipCallbackProxy = this.mOwnershipCallbacks.get(onAppFocusOwnershipCallback);
            if (onAppFocusOwnershipCallbackProxy != null) {
                this.mManager.abandonAppFocus(onAppFocusOwnershipCallbackProxy, i);
            }
        }
    }

    public void addFocusListener(CarAppFocusManager.OnAppFocusChangedListener onAppFocusChangedListener, int i) throws CarNotConnectedException {
        OnAppFocusChangedListenerProxy onAppFocusChangedListenerProxy;
        if (onAppFocusChangedListener == null) {
            throw new IllegalArgumentException("null listener");
        }
        synchronized (this) {
            onAppFocusChangedListenerProxy = this.mChangeListeners.get(onAppFocusChangedListener);
            if (onAppFocusChangedListenerProxy == null) {
                onAppFocusChangedListenerProxy = new OnAppFocusChangedListenerProxy(this, onAppFocusChangedListener);
                this.mChangeListeners.put(onAppFocusChangedListener, onAppFocusChangedListenerProxy);
            }
        }
        try {
            this.mManager.addFocusListener(onAppFocusChangedListenerProxy, i);
        } catch (CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public boolean isOwningFocus(int i, CarAppFocusManager.OnAppFocusOwnershipCallback onAppFocusOwnershipCallback) throws CarNotConnectedException {
        synchronized (this) {
            OnAppFocusOwnershipCallbackProxy onAppFocusOwnershipCallbackProxy = this.mOwnershipCallbacks.get(onAppFocusOwnershipCallback);
            if (onAppFocusOwnershipCallbackProxy == null) {
                return false;
            }
            try {
                return this.mManager.isOwningFocus(onAppFocusOwnershipCallbackProxy, i);
            } catch (CarNotConnectedException e) {
                throw new CarNotConnectedException((Exception) e);
            }
        }
    }

    public void onCarDisconnected() {
    }

    public void removeFocusListener(CarAppFocusManager.OnAppFocusChangedListener onAppFocusChangedListener) {
        synchronized (this) {
            OnAppFocusChangedListenerProxy remove = this.mChangeListeners.remove(onAppFocusChangedListener);
            if (remove != null) {
                this.mManager.removeFocusListener(remove);
            }
        }
    }

    public void removeFocusListener(CarAppFocusManager.OnAppFocusChangedListener onAppFocusChangedListener, int i) {
        synchronized (this) {
            OnAppFocusChangedListenerProxy onAppFocusChangedListenerProxy = this.mChangeListeners.get(onAppFocusChangedListener);
            if (onAppFocusChangedListenerProxy != null) {
                this.mManager.removeFocusListener(onAppFocusChangedListenerProxy, i);
            }
        }
    }

    public int requestAppFocus(int i, CarAppFocusManager.OnAppFocusOwnershipCallback onAppFocusOwnershipCallback) throws IllegalStateException, SecurityException, CarNotConnectedException {
        OnAppFocusOwnershipCallbackProxy onAppFocusOwnershipCallbackProxy;
        if (onAppFocusOwnershipCallback == null) {
            throw new IllegalArgumentException("null listener");
        }
        synchronized (this) {
            onAppFocusOwnershipCallbackProxy = this.mOwnershipCallbacks.get(onAppFocusOwnershipCallback);
            if (onAppFocusOwnershipCallbackProxy == null) {
                onAppFocusOwnershipCallbackProxy = new OnAppFocusOwnershipCallbackProxy(this, onAppFocusOwnershipCallback);
                this.mOwnershipCallbacks.put(onAppFocusOwnershipCallback, onAppFocusOwnershipCallbackProxy);
            }
        }
        try {
            return this.mManager.requestAppFocus(i, onAppFocusOwnershipCallbackProxy);
        } catch (CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }
}
