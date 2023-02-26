package com.google.android.apps.auto.sdk.service.p008a.p011c;

import android.support.annotation.VisibleForTesting;
import com.google.android.apps.auto.sdk.service.p008a.p011c.C0077a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.apps.auto.sdk.service.a.c.b */
public final class C0078b<L, P extends C0077a<L>> {
    @VisibleForTesting

    /* renamed from: a */
    public final Map<L, P> f218a = new HashMap();
    @VisibleForTesting

    /* renamed from: b */
    public final Map<Object, C0079c<L, P>> f219b = Collections.synchronizedMap(new HashMap());

    /* renamed from: c */
    private final C0080d<L, P> f220c;

    public C0078b(C0080d<L, P> dVar) {
        this.f220c = dVar;
    }

    /* renamed from: a */
    public final P mo591a(L l) {
        P p;
        synchronized (this.f219b) {
            p = null;
            Iterator<C0079c<L, P>> it = this.f219b.values().iterator();
            while (it.hasNext()) {
                C0079c next = it.next();
                P a = next.mo594a(l);
                if (next.mo595a()) {
                    it.remove();
                }
                p = a;
            }
            this.f218a.remove(l);
        }
        return p;
    }

    /* renamed from: a */
    public final P mo592a(Object obj, L l) {
        C0079c cVar;
        P p;
        synchronized (this.f219b) {
            C0079c cVar2 = this.f219b.get(obj);
            if (cVar2 == null) {
                C0079c cVar3 = new C0079c(this.f220c);
                this.f219b.put(obj, cVar3);
                cVar = cVar3;
            } else {
                cVar = cVar2;
            }
            p = (C0077a) this.f218a.get(l);
            if (p == null) {
                p = this.f220c.mo597a(l);
                this.f218a.put(l, p);
            }
            cVar.f221a.add(p);
        }
        return p;
    }

    /* renamed from: b */
    public final P mo593b(Object obj, L l) {
        P p;
        C0077a aVar;
        synchronized (this.f219b) {
            C0079c cVar = this.f219b.get(obj);
            if (cVar != null) {
                p = cVar.mo594a(l);
                if (cVar.mo595a()) {
                    this.f219b.remove(obj);
                }
            } else {
                p = null;
            }
            synchronized (this.f219b) {
                Iterator<C0079c<L, P>> it = this.f219b.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        aVar = null;
                        break;
                    }
                    aVar = it.next().mo596b(l);
                    if (aVar != null) {
                        break;
                    }
                }
                if (aVar == null) {
                    this.f218a.remove(l);
                }
            }
        }
        return p;
    }
}
