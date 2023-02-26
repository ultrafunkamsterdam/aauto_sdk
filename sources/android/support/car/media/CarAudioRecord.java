package android.support.car.media;

import android.support.car.CarNotConnectedException;

public abstract class CarAudioRecord {
    public abstract int getAudioSessionId() throws CarNotConnectedException;

    public abstract int getBufferSize() throws CarNotConnectedException;

    public abstract int getRecordingState() throws CarNotConnectedException;

    public abstract int getState() throws CarNotConnectedException;

    public abstract int read(byte[] bArr, int i, int i2) throws IllegalStateException, CarNotConnectedException;

    public abstract void release();

    public abstract void startRecording() throws CarNotConnectedException;

    public abstract void stop();
}
