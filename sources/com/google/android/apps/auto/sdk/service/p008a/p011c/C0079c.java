package com.google.android.apps.auto.sdk.service.p008a.p011c;

import android.support.annotation.VisibleForTesting;
import com.google.android.apps.auto.sdk.service.p008a.p011c.C0077a;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.apps.auto.sdk.service.a.c.c */
public final class C0079c<L, P extends C0077a<L>> {
    @VisibleForTesting

    /* renamed from: a */
    final Set<P> f221a = Collections.synchronizedSet(new HashSet());

    public C0079c(C0080d<L, P> dVar) {
    }

    /* renamed from: a */
    public final P mo594a(L l) {
        P b;
        synchronized (this.f221a) {
            b = mo596b(l);
            if (b != null) {
                this.f221a.remove(b);
            }
        }
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo595a() {
        return this.f221a.isEmpty();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final P mo596b(L l) {
        for (P p : this.f221a) {
            if (p.mo590a() == l) {
                return p;
            }
        }
        return null;
    }
}
