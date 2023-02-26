package com.google.android.gms.car;

@Deprecated
public abstract class CarAudioTrack {
    protected final CarAudioManager mAudioManager;
    protected final int mBufferSize;
    protected final int mConfigurationIndex;
    protected final int mMinBufferSize;
    protected final int mStreamType;

    public interface PlaybackNotificationListener {
        void onPeriodicNotification(CarAudioTrack carAudioTrack);

        void onPlayError(CarAudioTrack carAudioTrack, int i);
    }

    protected CarAudioTrack(CarAudioManager carAudioManager, int i, int i2, int i3, int i4) throws CarNotConnectedException, CarNotSupportedException {
        this.mAudioManager = carAudioManager;
        this.mStreamType = i;
        this.mConfigurationIndex = i2;
        this.mBufferSize = i3;
        this.mMinBufferSize = i4;
    }

    public abstract void flush();

    public int getBufferSize() {
        return this.mBufferSize;
    }

    public int getConfigurationIndex() {
        return this.mConfigurationIndex;
    }

    public abstract int getPlayState();

    public int getStreamType() {
        return this.mStreamType;
    }

    public abstract void pause() throws CarNotConnectedException;

    public abstract void play() throws CarNotConnectedException, IllegalStateException;

    public abstract void release();

    public abstract void setPlaybackNotificationListener(PlaybackNotificationListener playbackNotificationListener);

    public abstract void setPositionNotificationPeriod(int i) throws CarNotConnectedException;

    public abstract void stop();

    public abstract int write(byte[] bArr, int i, int i2) throws CarNotConnectedException, IllegalArgumentException, IndexOutOfBoundsException;
}
