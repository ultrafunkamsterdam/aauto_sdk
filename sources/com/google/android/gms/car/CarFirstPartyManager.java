package com.google.android.gms.car;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Hide;
import java.util.List;
import java.util.Set;

@Hide
public interface CarFirstPartyManager {

    public interface CarActivityStartListener {
        void onActivityStarted(Intent intent);

        void onNewActivityRequest(Intent intent);
    }

    public interface ScreenshotResultCallback {
        void onScreeshotResult(@Nullable Bitmap bitmap);
    }

    void captureScreenshot(ScreenshotResultCallback screenshotResultCallback) throws CarNotConnectedException;

    boolean getBooleanCarServiceSetting(String str, boolean z) throws CarNotConnectedException;

    String getStringCarServiceSetting(String str, String str2) throws CarNotConnectedException;

    Set<String> getStringSetCarServiceSetting(String str, Set<String> set) throws CarNotConnectedException;

    void logFacetChange(int i, String str) throws CarNotConnectedException;

    List<ResolveInfo> queryAllowedProjectionServices(Intent intent);

    void registerCarActivityStartListener(CarActivityStartListener carActivityStartListener) throws CarNotConnectedException;

    void setBooleanCarServiceSetting(String str, boolean z) throws CarNotConnectedException;

    void setStringCarServiceSetting(String str, String str2) throws CarNotConnectedException;

    void setStringSetCarServiceSetting(String str, Set<String> set) throws CarNotConnectedException;

    void startCarActivity(Intent intent) throws CarNotConnectedException;

    void unregisterCarActivityStartListener(CarActivityStartListener carActivityStartListener);
}
