package com.google.android.apps.auto.sdk.nav;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.BinderThread;
import android.support.annotation.CallSuper;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public abstract class NavigationProviderService extends Service {
    public static final String NAV_PROVIDER_CATEGORY = "com.google.android.car.category.NAVIGATION_PROVIDER";
    /* access modifiers changed from: private */
    @Nullable
    @GuardedBy("this")

    /* renamed from: a */
    public NavigationClientConfig f129a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C0042a f130b = new C0042a(new Handler(Looper.getMainLooper()));

    /* renamed from: c */
    private final C0045d f131c = new C0045d(this);

    public NavigationClientConfig getClientConfig() {
        NavigationClientConfig navigationClientConfig;
        synchronized (this) {
            navigationClientConfig = this.f129a;
        }
        return navigationClientConfig;
    }

    /* access modifiers changed from: protected */
    @BinderThread
    public abstract int getMaxSupportedVersion();

    /* access modifiers changed from: protected */
    @BinderThread
    public abstract int getMinSupportedVersion();

    /* access modifiers changed from: protected */
    @BinderThread
    public NavigationStateManager getNavigationStateManager() {
        return null;
    }

    /* access modifiers changed from: protected */
    @BinderThread
    public NavigationSuggestionManager getNavigationSuggestionManager() {
        return null;
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void onAndroidAutoStart(ClientMode clientMode) {
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void onAndroidAutoStop() {
    }

    public IBinder onBind(Intent intent) {
        return this.f131c;
    }

    @CallSuper
    public void onDestroy() {
        super.onDestroy();
        if (getNavigationSuggestionManager() != null) {
            getNavigationSuggestionManager().mo441c();
        }
        this.f130b.mo447a();
    }
}
