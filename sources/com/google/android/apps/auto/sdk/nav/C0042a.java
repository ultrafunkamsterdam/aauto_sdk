package com.google.android.apps.auto.sdk.nav;

import android.os.Handler;
import android.support.annotation.MainThread;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: com.google.android.apps.auto.sdk.nav.a */
final class C0042a {
    @GuardedBy("this")

    /* renamed from: a */
    private final Queue<Runnable> f140a = new ArrayDeque();
    @GuardedBy("this")

    /* renamed from: b */
    private final Handler f141b;

    C0042a(Handler handler) {
        this.f141b = handler;
    }

    /* access modifiers changed from: package-private */
    @MainThread
    /* renamed from: a */
    public final void mo447a() {
        synchronized (this) {
            while (this.f140a.size() > 0) {
                Runnable remove = this.f140a.remove();
                remove.run();
                this.f141b.removeCallbacks(remove);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo448a(Runnable runnable) {
        synchronized (this) {
            this.f140a.add(runnable);
            this.f141b.post(new C0043b(this));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo449b() {
        synchronized (this) {
            Runnable poll = this.f140a.poll();
            if (poll != null) {
                poll.run();
            }
        }
    }
}
