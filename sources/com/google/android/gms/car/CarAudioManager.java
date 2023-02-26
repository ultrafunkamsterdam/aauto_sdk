package com.google.android.gms.car;

import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.internal.Hide;

public interface CarAudioManager {
    @RequiresPermission("android.permission.RECORD_AUDIO")
    CarAudioRecord createCarAudioRecord(int i, int i2, int i3) throws CarNotConnectedException, CarNotSupportedException, SecurityException;

    CarAudioConfig[] getAudioRecordConfigurations(int i) throws CarNotConnectedException, CarNotSupportedException;

    int getAudioRecordMinBufferSize(int i, int i2) throws CarNotConnectedException, CarNotSupportedException;

    int[] getAudioRecordStreams() throws CarNotConnectedException;

    @Hide
    CarAudioConfig[] getAudioTrackConfigurations(int i) throws CarNotConnectedException, CarNotSupportedException;

    @Hide
    int getAudioTrackMinBufferSize(int i, int i2) throws CarNotConnectedException, CarNotSupportedException;

    @Hide
    int[] getAudioTrackStreams() throws CarNotConnectedException;

    @Hide
    @Deprecated
    CarAudioTrack getCarAudioTrack(int i, int i2, int i3) throws CarNotConnectedException, CarNotSupportedException;

    boolean isAudioRecordStreamSupported(int i) throws CarNotConnectedException;

    @Hide
    boolean isAudioTrackStreamSupported(int i) throws CarNotConnectedException;

    boolean waitForPlayback(long j) throws CarNotConnectedException;

    boolean waitForSilence(long j) throws CarNotConnectedException;
}
