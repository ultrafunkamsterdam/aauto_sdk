package android.support.car.navigation;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.car.CarManagerBase;
import android.support.car.CarNotConnectedException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class CarNavigationStatusManager implements CarManagerBase {
    public static final int DISTANCE_FEET = 4;
    public static final int DISTANCE_KILOMETERS = 2;
    public static final int DISTANCE_METERS = 1;
    public static final int DISTANCE_MILES = 3;
    public static final int DISTANCE_YARDS = 5;
    public static final int EVENT_TYPE_NEXT_MANEUVER_COUNTDOWN = 2;
    public static final int EVENT_TYPE_NEXT_MANEUVER_INFO = 1;
    public static final int EVENT_TYPE_VENDOR_FIRST = 1024;
    public static final int STATUS_ACTIVE = 1;
    public static final int STATUS_INACTIVE = 2;
    public static final int STATUS_UNAVAILABLE = 0;
    public static final int TURN_DEPART = 1;
    public static final int TURN_DESTINATION = 19;
    public static final int TURN_FERRY_BOAT = 16;
    public static final int TURN_FERRY_TRAIN = 17;
    public static final int TURN_FORK = 9;
    public static final int TURN_MERGE = 10;
    public static final int TURN_NAME_CHANGE = 2;
    public static final int TURN_OFF_RAMP = 8;
    public static final int TURN_ON_RAMP = 7;
    public static final int TURN_ROUNDABOUT_ENTER = 11;
    public static final int TURN_ROUNDABOUT_ENTER_AND_EXIT = 13;
    public static final int TURN_ROUNDABOUT_EXIT = 12;
    public static final int TURN_SHARP_TURN = 5;
    public static final int TURN_SIDE_LEFT = 1;
    public static final int TURN_SIDE_RIGHT = 2;
    public static final int TURN_SIDE_UNSPECIFIED = 3;
    public static final int TURN_SLIGHT_TURN = 3;
    public static final int TURN_STRAIGHT = 14;
    public static final int TURN_TURN = 4;
    public static final int TURN_UNKNOWN = 0;
    public static final int TURN_U_TURN = 6;

    public interface CarNavigationCallback {
        void onInstrumentClusterStarted(CarNavigationStatusManager carNavigationStatusManager, CarNavigationInstrumentCluster carNavigationInstrumentCluster);

        void onInstrumentClusterStopped(CarNavigationStatusManager carNavigationStatusManager);
    }

    public @interface DistanceUnit {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TurnEvent {
    }

    public @interface TurnSide {
    }

    public abstract void addListener(CarNavigationCallback carNavigationCallback) throws CarNotConnectedException;

    public abstract void removeListener();

    public abstract void sendEvent(int i, Bundle bundle) throws CarNotConnectedException;

    public abstract void sendNavigationStatus(int i) throws CarNotConnectedException;

    public abstract void sendNavigationTurnDistanceEvent(int i, int i2, int i3, int i4) throws CarNotConnectedException;

    public abstract void sendNavigationTurnEvent(int i, CharSequence charSequence, int i2, int i3, @TurnSide int i4) throws CarNotConnectedException;

    public abstract void sendNavigationTurnEvent(int i, CharSequence charSequence, int i2, int i3, Bitmap bitmap, @TurnSide int i4) throws CarNotConnectedException;
}
