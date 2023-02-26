package com.google.android.apps.auto.sdk;

import com.google.android.apps.auto.sdk.MenuController;

/* renamed from: com.google.android.apps.auto.sdk.y */
final /* synthetic */ class C0108y implements Runnable {

    /* renamed from: a */
    private final MenuController.C0019c f354a;

    /* renamed from: b */
    private final MenuAdapter f355b;

    C0108y(MenuController.C0019c cVar, MenuAdapter menuAdapter) {
        this.f354a = cVar;
        this.f355b = menuAdapter;
    }

    public final void run() {
        this.f354a.mo258a(this.f355b);
    }
}
