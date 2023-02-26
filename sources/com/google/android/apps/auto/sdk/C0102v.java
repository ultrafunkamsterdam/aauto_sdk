package com.google.android.apps.auto.sdk;

import android.os.RemoteException;
import android.support.annotation.UiThread;
import android.util.Log;
import com.google.android.gms.car.input.InputManager;

/* renamed from: com.google.android.apps.auto.sdk.v */
final class C0102v {

    /* renamed from: a */
    private final InputManager f319a;

    /* renamed from: b */
    private final CarUiController f320b;

    /* renamed from: c */
    private final C0035i f321c;

    C0102v(C0035i iVar, InputManager inputManager, CarUiController carUiController) {
        this.f321c = iVar;
        this.f319a = inputManager;
        this.f320b = carUiController;
        try {
            this.f321c.mo361a(new C0106w(this));
        } catch (RemoteException e) {
            Log.e("CSL.ImeController", "Error setting ImeCallbacks", e);
        }
    }

    /* renamed from: a */
    public final boolean mo775a() {
        return this.f319a.isInputActive();
    }

    @UiThread
    /* renamed from: b */
    public final void mo776b() {
        this.f319a.startInput(new C0107x(this.f320b));
    }

    @UiThread
    /* renamed from: c */
    public final void mo777c() {
        this.f319a.stopInput();
    }
}
