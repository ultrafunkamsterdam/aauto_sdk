package com.google.android.apps.auto.sdk.nav;

/* renamed from: com.google.android.apps.auto.sdk.nav.f */
final class C0047f implements Runnable {

    /* renamed from: a */
    private /* synthetic */ ClientMode f145a;

    /* renamed from: b */
    private /* synthetic */ C0045d f146b;

    C0047f(C0045d dVar, ClientMode clientMode) {
        this.f146b = dVar;
        this.f145a = clientMode;
    }

    public final void run() {
        this.f146b.f143a.onAndroidAutoStart(this.f145a);
    }
}
