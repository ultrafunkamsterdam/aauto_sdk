package com.google.android.apps.auto.sdk.vanagon;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.apps.auto.sdk.vanagon.PhoneSysUiClient;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.google.android.apps.auto.sdk.vanagon.b */
final class C0104b implements PhoneSysUiClient.ScreenshotProvider.OnCompleteListener {

    /* renamed from: a */
    private /* synthetic */ Object[] f349a;

    /* renamed from: b */
    private /* synthetic */ C0103a f350b;

    C0104b(C0103a aVar, Object[] objArr) {
        this.f350b = aVar;
        this.f349a = objArr;
    }

    public final void onScreenshotComplete(@Nullable Bitmap bitmap) {
        try {
            this.f349a[0].getClass().getMethod("onScreenshotComplete", new Class[]{Bitmap.class}).invoke(this.f349a[0], new Object[]{bitmap});
        } catch (NoSuchMethodException e) {
            Log.d("GH.PhoneSysUiClient", "Method is not loaded.");
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            RuntimeException unused = PhoneSysUiClient.m355a(e2);
        }
    }
}
