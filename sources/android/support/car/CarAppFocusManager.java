package android.support.car;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class CarAppFocusManager implements CarManagerBase {
    public static final int APP_FOCUS_REQUEST_FAILED = 0;
    public static final int APP_FOCUS_REQUEST_SUCCEEDED = 1;
    public static final int APP_FOCUS_TYPE_MAX = 2;
    public static final int APP_FOCUS_TYPE_NAVIGATION = 1;
    public static final int APP_FOCUS_TYPE_VOICE_COMMAND = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AppFocusRequestResult {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AppFocusType {
    }

    public interface OnAppFocusChangedListener {
        void onAppFocusChanged(CarAppFocusManager carAppFocusManager, int i, boolean z);
    }

    public interface OnAppFocusOwnershipCallback {
        void onAppFocusOwnershipGranted(CarAppFocusManager carAppFocusManager, int i);

        void onAppFocusOwnershipLost(CarAppFocusManager carAppFocusManager, int i);
    }

    public abstract void abandonAppFocus(OnAppFocusOwnershipCallback onAppFocusOwnershipCallback);

    public abstract void abandonAppFocus(OnAppFocusOwnershipCallback onAppFocusOwnershipCallback, int i);

    public abstract void addFocusListener(OnAppFocusChangedListener onAppFocusChangedListener, int i) throws CarNotConnectedException;

    public abstract boolean isOwningFocus(int i, OnAppFocusOwnershipCallback onAppFocusOwnershipCallback) throws CarNotConnectedException;

    public abstract void removeFocusListener(OnAppFocusChangedListener onAppFocusChangedListener);

    public abstract void removeFocusListener(OnAppFocusChangedListener onAppFocusChangedListener, int i);

    public abstract int requestAppFocus(int i, OnAppFocusOwnershipCallback onAppFocusOwnershipCallback) throws SecurityException, CarNotConnectedException;
}
