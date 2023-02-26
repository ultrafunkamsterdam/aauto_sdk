package com.google.android.apps.auto.sdk;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.apps.auto.sdk.MenuController;

/* renamed from: com.google.android.apps.auto.sdk.z */
final /* synthetic */ class C0109z implements Runnable {

    /* renamed from: a */
    private final MenuController.C0019c f356a;

    /* renamed from: b */
    private final MenuAdapter f357b;

    /* renamed from: c */
    private final int f358c;

    C0109z(MenuController.C0019c cVar, MenuAdapter menuAdapter, int i) {
        this.f356a = cVar;
        this.f357b = menuAdapter;
        this.f358c = i;
    }

    public final void run() {
        MenuController.C0019c cVar = this.f356a;
        MenuAdapter menuAdapter = this.f357b;
        int i = this.f358c;
        String valueOf = String.valueOf(menuAdapter);
        Log.d("CSL.MenuController", new StringBuilder(String.valueOf(valueOf).length() + 48).append("notifyItemChanged ").append(valueOf).append(", displayPosition: ").append(i).toString());
        if (menuAdapter == MenuController.this.f53a.f63a) {
            try {
                MenuController.this.f58f.mo364a(i);
            } catch (RemoteException e) {
                Log.e("CSL.MenuController", "Error notifying item changed", e);
            }
        }
    }
}
