package com.google.android.apps.auto.sdk.service.p008a.p009a;

import android.support.car.CarNotConnectedException;
import android.support.car.media.CarAudioRecord;

/* renamed from: com.google.android.apps.auto.sdk.service.a.a.b */
public final class C0072b extends CarAudioRecord {

    /* renamed from: a */
    private com.google.android.gms.car.CarAudioRecord f208a;

    C0072b(com.google.android.gms.car.CarAudioRecord carAudioRecord) {
        this.f208a = carAudioRecord;
    }

    public final int getAudioSessionId() {
        return 0;
    }

    public final int getBufferSize() {
        return this.f208a.getBufferSize();
    }

    public final int getRecordingState() {
        return this.f208a.getRecordingState();
    }

    public final int getState() {
        return this.f208a.getState();
    }

    public final int read(byte[] bArr, int i, int i2) throws IllegalStateException, CarNotConnectedException {
        try {
            return this.f208a.read(bArr, i, i2);
        } catch (com.google.android.gms.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public final void release() {
        this.f208a.release();
    }

    public final void startRecording() throws CarNotConnectedException {
        try {
            this.f208a.startRecording();
        } catch (com.google.android.gms.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public final void stop() {
        this.f208a.stop();
    }
}
