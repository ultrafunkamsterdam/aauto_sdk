package com.google.android.gms.car;

import com.google.android.gms.common.internal.Hide;

public interface CarInfoManager {

    public interface CarInfo {
        String getDisplayName();

        int getDriverPosition();

        String getHeadUnitMake();

        String getHeadUnitModel();

        @Hide
        int getHeadUnitProtocolMajorVersionNumber();

        @Hide
        int getHeadUnitProtocolMinorVersionNumber();

        String getHeadUnitSoftwareBuild();

        String getHeadUnitSoftwareVersion();

        String getManufacturer();

        String getModel();

        String getModelYear();

        @Hide
        String getNickname();

        String getVehicleId();

        @Hide
        boolean isCanPlayNativeMediaDuringVr();

        boolean isHideBatteryLevel();

        boolean isHidePhoneSignal();

        boolean isHideProjectedClock();
    }

    public interface CarUiInfo {
        int[] getTouchpadDimensions();

        int getTouchscreenType();

        boolean hasDpad();

        boolean hasRotaryController();

        boolean hasSearchButton();

        boolean hasTouchpadForUiNavigation();

        boolean hasTouchscreen();

        boolean isTouchpadUiAbsolute();
    }

    CarInfo loadCarInfo() throws CarNotConnectedException;

    CarUiInfo loadCarUiInfo() throws CarNotConnectedException;
}
