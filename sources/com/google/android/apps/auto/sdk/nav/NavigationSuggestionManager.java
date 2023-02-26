package com.google.android.apps.auto.sdk.nav;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import com.google.android.apps.auto.sdk.nav.suggestion.C0059a;
import com.google.android.apps.auto.sdk.nav.suggestion.C0061c;
import com.google.android.apps.auto.sdk.nav.suggestion.NavigationSuggestion;
import javax.annotation.concurrent.GuardedBy;

public class NavigationSuggestionManager extends C0046e<C0061c> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C0042a f137a = new C0042a(new Handler(Looper.getMainLooper()));
    /* access modifiers changed from: private */
    @Nullable
    @GuardedBy("this")

    /* renamed from: b */
    public C0059a f138b;

    /* renamed from: c */
    private final C0061c f139c = new C0050i(this);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ Object mo436a() {
        return this.f139c;
    }

    /* access modifiers changed from: package-private */
    @MainThread
    /* renamed from: c */
    public final void mo441c() {
        this.f137a.mo447a();
    }

    @MainThread
    public void onRequestSuggestionUpdates() {
    }

    @MainThread
    public void onStopSuggestionUpdates() {
    }

    @MainThread
    public void onSuggestionDismissed(NavigationSuggestion navigationSuggestion) {
    }

    @MainThread
    public void onSuggestionShown(NavigationSuggestion navigationSuggestion) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    @android.support.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendNavigationSuggestions(com.google.android.apps.auto.sdk.nav.suggestion.NavigationSuggestion[] r2) throws android.os.RemoteException {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.mo459b()     // Catch:{ all -> 0x0014 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r1)     // Catch:{ all -> 0x0014 }
        L_0x0008:
            return
        L_0x0009:
            com.google.android.apps.auto.sdk.nav.suggestion.a r0 = r1.f138b     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x0012
            com.google.android.apps.auto.sdk.nav.suggestion.a r0 = r1.f138b     // Catch:{ all -> 0x0014 }
            r0.mo536a(r2)     // Catch:{ all -> 0x0014 }
        L_0x0012:
            monitor-exit(r1)     // Catch:{ all -> 0x0014 }
            goto L_0x0008
        L_0x0014:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0014 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.apps.auto.sdk.nav.NavigationSuggestionManager.sendNavigationSuggestions(com.google.android.apps.auto.sdk.nav.suggestion.NavigationSuggestion[]):void");
    }
}
