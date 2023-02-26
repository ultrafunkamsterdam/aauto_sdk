package com.google.android.apps.auto.sdk.service.p008a.p010b;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.car.CarNotConnectedException;
import android.support.car.navigation.CarNavigationStatusManager;
import java.io.ByteArrayOutputStream;

/* renamed from: com.google.android.apps.auto.sdk.service.a.b.a */
public final class C0074a extends CarNavigationStatusManager {

    /* renamed from: a */
    private final com.google.android.gms.car.CarNavigationStatusManager f212a;
    @VisibleForTesting

    /* renamed from: b */
    private C0075b f213b = new C0075b(this);

    public C0074a(com.google.android.gms.car.CarNavigationStatusManager carNavigationStatusManager) throws CarNotConnectedException {
        this.f212a = carNavigationStatusManager;
        try {
            this.f212a.registerListener(this.f213b);
        } catch (com.google.android.gms.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public final void addListener(CarNavigationStatusManager.CarNavigationCallback carNavigationCallback) throws CarNotConnectedException {
        C0075b bVar = this.f213b;
        bVar.f214a = carNavigationCallback;
        if (bVar.f215b != null) {
            bVar.f214a.onInstrumentClusterStarted(bVar.f216c, bVar.f215b);
        }
    }

    public final void onCarDisconnected() {
    }

    public final void removeListener() {
        this.f212a.unregisterListener();
    }

    public final void sendEvent(int i, Bundle bundle) throws CarNotConnectedException {
        throw new UnsupportedOperationException("use deprecated sendNavigationTurn*Event methods");
    }

    public final void sendNavigationStatus(int i) throws CarNotConnectedException {
        try {
            this.f212a.sendNavigationStatus(i);
        } catch (com.google.android.gms.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public final void sendNavigationTurnDistanceEvent(int i, int i2, int i3, int i4) throws CarNotConnectedException {
        int i5;
        switch (i4) {
            case 1:
                i5 = 1;
                break;
            case 2:
                i5 = 2;
                break;
            case 4:
                i5 = 4;
                break;
            case 6:
                i5 = 6;
                break;
            case 7:
                i5 = 7;
                break;
            default:
                throw new IllegalArgumentException("The units provided are not supported.");
        }
        try {
            this.f212a.sendNavigationTurnDistanceEvent(i, i2, i3, i5);
        } catch (com.google.android.gms.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public final void sendNavigationTurnEvent(int i, CharSequence charSequence, int i2, int i3, int i4) throws CarNotConnectedException {
        sendNavigationTurnEvent(i, charSequence == null ? null : charSequence.toString(), i2, i3, (Bitmap) null, i4);
    }

    public final void sendNavigationTurnEvent(int i, CharSequence charSequence, int i2, int i3, Bitmap bitmap, int i4) throws CarNotConnectedException {
        byte[] bArr;
        String str = null;
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
        } else {
            bArr = null;
        }
        if (charSequence != null) {
            str = charSequence.toString();
        }
        try {
            this.f212a.sendNavigationTurnEvent(i, str, i2, i3, bArr, i4);
        } catch (com.google.android.gms.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }
}
