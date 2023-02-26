package com.google.android.apps.auto.sdk.service.p008a.p009a;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.support.car.CarNotConnectedException;
import android.support.car.media.CarAudioManager;
import android.support.car.media.CarAudioRecord;
import android.util.Log;
import com.google.android.gms.car.CarNotSupportedException;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.google.android.apps.auto.sdk.service.a.a.a */
public final class C0071a extends CarAudioManager {

    /* renamed from: c */
    private static final AudioFormat f205c = new AudioFormat.Builder().setEncoding(2).setChannelMask(16).setSampleRate(16000).build();

    /* renamed from: a */
    private final AudioManager f206a;

    /* renamed from: b */
    private final com.google.android.gms.car.CarAudioManager f207b;

    public C0071a(AudioManager audioManager, com.google.android.gms.car.CarAudioManager carAudioManager) {
        this.f206a = audioManager;
        this.f207b = carAudioManager;
    }

    /* renamed from: a */
    private static AudioAttributes m279a(int i, int i2) {
        return new AudioAttributes.Builder().setContentType(i).setUsage(i2).build();
    }

    public final void abandonAudioFocus(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, AudioAttributes audioAttributes) {
        this.f206a.abandonAudioFocus(onAudioFocusChangeListener);
    }

    public final CarAudioRecord createCarAudioRecord(int i) throws SecurityException, CarNotConnectedException {
        try {
            return new C0072b(this.f207b.createCarAudioRecord(0, 0, i));
        } catch (com.google.android.gms.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        } catch (CarNotSupportedException e2) {
            throw new UnsupportedOperationException(e2);
        }
    }

    public final AudioAttributes getAudioAttributesForCarUsage(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
                return m279a(2, 1);
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return m279a(1, 12);
            case 8:
            case 9:
                return m279a(4, 13);
            default:
                Log.i("CarAudioManagerGms", new StringBuilder(64).append("An unknown audio usage was passed in.  Audio usage = ").append(i).toString());
                return m279a(0, 0);
        }
    }

    public final AudioFormat getAudioRecordAudioFormat() {
        return f205c;
    }

    public final int getAudioRecordMaxBufferSize() {
        return 524288;
    }

    public final int getAudioRecordMinBufferSize() throws CarNotConnectedException {
        try {
            return this.f207b.getAudioRecordMinBufferSize(0, 0);
        } catch (com.google.android.gms.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        } catch (CarNotSupportedException e2) {
            throw new UnsupportedOperationException(e2);
        }
    }

    public final boolean isAudioRecordSupported() throws CarNotConnectedException {
        try {
            return this.f207b.isAudioRecordStreamSupported(0);
        } catch (com.google.android.gms.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public final boolean isMediaMuted() throws CarNotConnectedException {
        return false;
    }

    public final void onCarDisconnected() {
    }

    public final int requestAudioFocus(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, AudioAttributes audioAttributes, int i) throws IllegalArgumentException {
        return requestAudioFocus(onAudioFocusChangeListener, audioAttributes, i, 0);
    }

    public final int requestAudioFocus(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, AudioAttributes audioAttributes, int i, int i2) throws IllegalArgumentException {
        try {
            return ((Integer) this.f206a.getClass().getMethod("requestAudioFocus", new Class[]{AudioManager.OnAudioFocusChangeListener.class, AudioAttributes.class, Integer.TYPE, Integer.TYPE}).invoke(this.f206a, new Object[]{onAudioFocusChangeListener, audioAttributes, Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Log.w("CarAudioManagerGms", "Audio focus request failed", e);
            return 0;
        }
    }

    public final boolean setMediaMute(boolean z) throws CarNotConnectedException {
        return false;
    }
}
