package com.google.android.apps.auto.sdk.nav;

import android.support.annotation.Nullable;
import android.util.Log;

/* renamed from: com.google.android.apps.auto.sdk.nav.e */
abstract class C0046e<T> {
    @Nullable

    /* renamed from: a */
    private NavigationClientConfig f144a;

    C0046e() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract T mo436a();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo458a(NavigationClientConfig navigationClientConfig) {
        this.f144a = navigationClientConfig;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final boolean mo459b() {
        if (this.f144a != null) {
            return true;
        }
        if (Log.isLoggable("GH.NavManager", 5)) {
            Log.w("GH.NavManager", "Navigation client is not yet registered. Call registerClient() first");
        }
        return false;
    }
}
