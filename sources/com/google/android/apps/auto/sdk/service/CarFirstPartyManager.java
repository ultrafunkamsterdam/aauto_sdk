package com.google.android.apps.auto.sdk.service;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.car.CarNotConnectedException;

public interface CarFirstPartyManager {
    public static final String SERVICE_NAME = "car_1p";

    public interface ScreenshotResultCallback {
        void onScreenshotResult(@Nullable Bitmap bitmap);
    }

    void captureScreenshot(ScreenshotResultCallback screenshotResultCallback) throws CarNotConnectedException;

    void startCarActivity(Intent intent) throws CarNotConnectedException;
}
