package com.google.android.apps.auto.sdk.nav;

/* renamed from: com.google.android.apps.auto.sdk.nav.l */
final class C0053l implements Runnable {

    /* renamed from: a */
    private /* synthetic */ C0050i f154a;

    C0053l(C0050i iVar) {
        this.f154a = iVar;
    }

    public final void run() {
        this.f154a.f149a.onRequestSuggestionUpdates();
    }
}
