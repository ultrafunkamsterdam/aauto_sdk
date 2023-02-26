package com.google.android.gms.car;

public interface CarAudioRecord {
    int getBufferSize();

    int getConfigurationIndex();

    int getRecordingState();

    int getState();

    int getStreamType();

    int read(byte[] bArr, int i, int i2) throws CarNotConnectedException;

    void release();

    void startRecording() throws CarNotConnectedException;

    void stop();
}
