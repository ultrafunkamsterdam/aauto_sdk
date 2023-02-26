package com.google.android.apps.auto.sdk.vanagon;

import android.util.Log;
import com.google.android.apps.auto.sdk.vanagon.PhoneSysUiClient;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* renamed from: com.google.android.apps.auto.sdk.vanagon.a */
final class C0103a implements InvocationHandler {

    /* renamed from: a */
    final /* synthetic */ PhoneSysUiClient f347a;

    /* renamed from: b */
    private /* synthetic */ PhoneSysUiClient.ScreenshotProvider f348b;

    C0103a(PhoneSysUiClient phoneSysUiClient, PhoneSysUiClient.ScreenshotProvider screenshotProvider) {
        this.f347a = phoneSysUiClient;
        this.f348b = screenshotProvider;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Class[] parameterTypes = method.getParameterTypes();
        if (method.getName().equals("getScreenshot") && parameterTypes.length == 1 && parameterTypes[0] == this.f347a.f325d) {
            this.f348b.getScreenshot(new C0104b(this, objArr));
        } else {
            String valueOf = String.valueOf(method.getName());
            Log.e("GH.PhoneSysUiClient", valueOf.length() != 0 ? "Could not invoke this method in screenshotProvider: ".concat(valueOf) : new String("Could not invoke this method in screenshotProvider: "));
        }
        return null;
    }
}
