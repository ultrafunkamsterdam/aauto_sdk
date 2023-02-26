package com.google.android.apps.auto.sdk.nav;

import com.google.android.apps.auto.sdk.nav.suggestion.NavigationSuggestion;

/* renamed from: com.google.android.apps.auto.sdk.nav.j */
final class C0051j implements Runnable {

    /* renamed from: a */
    private /* synthetic */ NavigationSuggestion f150a;

    /* renamed from: b */
    private /* synthetic */ C0050i f151b;

    C0051j(C0050i iVar, NavigationSuggestion navigationSuggestion) {
        this.f151b = iVar;
        this.f150a = navigationSuggestion;
    }

    public final void run() {
        this.f151b.f149a.onSuggestionDismissed(this.f150a);
    }
}
