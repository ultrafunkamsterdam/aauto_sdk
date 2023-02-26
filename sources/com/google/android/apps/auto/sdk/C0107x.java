package com.google.android.apps.auto.sdk;

import android.support.annotation.VisibleForTesting;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.google.android.gms.car.input.CarEditable;
import com.google.android.gms.car.input.CarEditableListener;

@VisibleForTesting
/* renamed from: com.google.android.apps.auto.sdk.x */
final class C0107x implements CarEditable {

    /* renamed from: a */
    private final CarUiController f353a;

    public C0107x(CarUiController carUiController) {
        this.f353a = carUiController;
    }

    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.f353a.mo203a(editorInfo);
    }

    public final void setCarEditableListener(CarEditableListener carEditableListener) {
    }

    public final void setInputEnabled(boolean z) {
    }
}
