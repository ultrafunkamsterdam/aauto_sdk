package com.google.android.apps.auto.sdk.vanagon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.google.android.apps.auto.sdk.vanagon.c */
final class C0105c extends BroadcastReceiver {

    /* renamed from: a */
    private /* synthetic */ PhoneSysUiClient f351a;

    C0105c(PhoneSysUiClient phoneSysUiClient) {
        this.f351a = phoneSysUiClient;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.f351a.f345x == null) {
            return;
        }
        if (PhoneSysUiClient.isAndroidAutoRunning(context)) {
            this.f351a.f345x.onEnterPhoneMode();
        } else {
            this.f351a.f345x.onExitPhoneMode();
        }
    }
}
