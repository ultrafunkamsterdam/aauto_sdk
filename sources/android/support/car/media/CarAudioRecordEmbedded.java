package android.support.car.media;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.support.annotation.RestrictTo;
import android.support.car.CarNotConnectedException;

@RestrictTo({RestrictTo.Scope.GROUP_ID})
public class CarAudioRecordEmbedded extends CarAudioRecord {
    private final AudioRecord mAudioRecord = new AudioRecord.Builder().setAudioFormat(this.mFormat).setBufferSizeInBytes(this.mBufferSize).build();
    private final int mBufferSize;
    private final AudioFormat mFormat;

    CarAudioRecordEmbedded(AudioFormat audioFormat, int i) {
        this.mFormat = audioFormat;
        this.mBufferSize = i;
    }

    public int getAudioSessionId() throws CarNotConnectedException {
        return this.mAudioRecord.getAudioSessionId();
    }

    public int getBufferSize() throws CarNotConnectedException {
        return this.mBufferSize;
    }

    public int getRecordingState() throws CarNotConnectedException {
        return this.mAudioRecord.getRecordingState();
    }

    public int getState() throws CarNotConnectedException {
        return this.mAudioRecord.getState();
    }

    public int read(byte[] bArr, int i, int i2) throws CarNotConnectedException, IllegalStateException {
        return this.mAudioRecord.read(bArr, i, i2);
    }

    public void release() {
        this.mAudioRecord.release();
    }

    public void startRecording() throws CarNotConnectedException {
        this.mAudioRecord.startRecording();
    }

    public void stop() {
        this.mAudioRecord.stop();
    }
}
