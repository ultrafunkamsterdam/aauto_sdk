package com.google.android.gms.car;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.google.android.gms.car.h */
final class C0117h extends Handler {

    /* renamed from: a */
    private /* synthetic */ C0114e f372a;

    C0117h(C0114e eVar) {
        this.f372a = eVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.f372a.f365c) {
                    this.f372a.mo991a(false);
                    return;
                }
                return;
            case 2:
                this.f372a.f364b.dispatchResume();
                this.f372a.f364b.execPendingActions();
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
