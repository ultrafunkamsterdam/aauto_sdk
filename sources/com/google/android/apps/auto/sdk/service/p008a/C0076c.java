package com.google.android.apps.auto.sdk.service.p008a;

import android.content.Intent;
import android.support.car.CarNotConnectedException;
import com.google.android.apps.auto.sdk.service.CarFirstPartyManager;

/* renamed from: com.google.android.apps.auto.sdk.service.a.c */
public final class C0076c implements CarFirstPartyManager {

    /* renamed from: a */
    private final com.google.android.gms.car.CarFirstPartyManager f217a;

    public C0076c(com.google.android.gms.car.CarFirstPartyManager carFirstPartyManager) {
        this.f217a = carFirstPartyManager;
    }

    public final void captureScreenshot(CarFirstPartyManager.ScreenshotResultCallback screenshotResultCallback) throws CarNotConnectedException {
        if (screenshotResultCallback != null) {
            try {
                this.f217a.captureScreenshot(new C0081d(screenshotResultCallback));
            } catch (com.google.android.gms.car.CarNotConnectedException e) {
                throw new CarNotConnectedException((Exception) e);
            }
        }
    }

    public final void startCarActivity(Intent intent) throws CarNotConnectedException {
        try {
            this.f217a.startCarActivity(intent);
        } catch (com.google.android.gms.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }
}
