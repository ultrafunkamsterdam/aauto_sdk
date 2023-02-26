package com.google.p002a.p003a.p004a.p005a.p006a;

/* renamed from: com.google.a.a.a.a.a.e */
final class C0014e extends C0011b {

    /* renamed from: a */
    private final C0012c f12a = new C0012c();

    C0014e() {
    }

    /* renamed from: a */
    public final void mo157a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        } else if (th2 == null) {
            throw new NullPointerException("The suppressed exception cannot be null.");
        } else {
            this.f12a.mo158a(th, true).add(th2);
        }
    }
}
