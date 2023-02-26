package com.google.android.apps.auto.sdk.service.p008a;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import com.google.android.apps.auto.sdk.service.CarFirstPartyManager;
import com.google.android.gms.car.CarFirstPartyManager;

/* renamed from: com.google.android.apps.auto.sdk.service.a.d */
final class C0081d implements CarFirstPartyManager.ScreenshotResultCallback {

    /* renamed from: a */
    private /* synthetic */ CarFirstPartyManager.ScreenshotResultCallback f222a;

    C0081d(CarFirstPartyManager.ScreenshotResultCallback screenshotResultCallback) {
        this.f222a = screenshotResultCallback;
    }

    public final void onScreeshotResult(@Nullable Bitmap bitmap) {
        this.f222a.onScreenshotResult(bitmap);
    }
}
