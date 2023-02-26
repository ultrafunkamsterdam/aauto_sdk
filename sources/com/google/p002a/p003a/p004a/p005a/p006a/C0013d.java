package com.google.p002a.p003a.p004a.p005a.p006a;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.google.a.a.a.a.a.d */
final class C0013d extends WeakReference<Throwable> {

    /* renamed from: a */
    private final int f11a;

    public C0013d(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.f11a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        boolean z = true;
        if (obj == null || obj.getClass() != getClass()) {
            z = false;
        } else if (this != obj) {
            C0013d dVar = (C0013d) obj;
            if (!(this.f11a == dVar.f11a && get() == dVar.get())) {
                return false;
            }
        }
        return z;
    }

    public final int hashCode() {
        return this.f11a;
    }
}
