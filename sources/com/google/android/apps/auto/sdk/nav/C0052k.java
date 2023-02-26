package com.google.android.apps.auto.sdk.nav;

import com.google.android.apps.auto.sdk.nav.suggestion.NavigationSuggestion;

/* renamed from: com.google.android.apps.auto.sdk.nav.k */
final class C0052k implements Runnable {

    /* renamed from: a */
    private /* synthetic */ NavigationSuggestion f152a;

    /* renamed from: b */
    private /* synthetic */ C0050i f153b;

    C0052k(C0050i iVar, NavigationSuggestion navigationSuggestion) {
        this.f153b = iVar;
        this.f152a = navigationSuggestion;
    }

    public final void run() {
        this.f153b.f149a.onSuggestionShown(this.f152a);
    }
}
