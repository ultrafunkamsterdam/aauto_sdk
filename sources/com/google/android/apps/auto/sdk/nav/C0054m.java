package com.google.android.apps.auto.sdk.nav;

/* renamed from: com.google.android.apps.auto.sdk.nav.m */
final class C0054m implements Runnable {

    /* renamed from: a */
    private /* synthetic */ C0050i f155a;

    C0054m(C0050i iVar) {
        this.f155a = iVar;
    }

    public final void run() {
        this.f155a.f149a.onStopSuggestionUpdates();
    }
}
