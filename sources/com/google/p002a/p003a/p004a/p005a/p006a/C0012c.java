package com.google.p002a.p003a.p004a.p005a.p006a;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.a.a.a.a.a.c */
final class C0012c {

    /* renamed from: a */
    private final ConcurrentHashMap<C0013d, List<Throwable>> f9a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b */
    private final ReferenceQueue<Throwable> f10b = new ReferenceQueue<>();

    C0012c() {
    }

    /* renamed from: a */
    public final List<Throwable> mo158a(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.f10b.poll();
        while (poll != null) {
            this.f9a.remove(poll);
            poll = this.f10b.poll();
        }
        List<Throwable> list = this.f9a.get(new C0013d(th, (ReferenceQueue<Throwable>) null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f9a.putIfAbsent(new C0013d(th, this.f10b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
