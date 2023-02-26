package android.support.car.media;

import android.car.media.CarAudioManager;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.support.annotation.RestrictTo;
import android.support.car.CarNotConnectedException;

@RestrictTo({RestrictTo.Scope.GROUP_ID})
public class CarAudioManagerEmbedded extends CarAudioManager {
    private static final AudioFormat AUDIO_RECORD_FORMAT = new AudioFormat.Builder().setEncoding(2).setChannelMask(16).setSampleRate(SAMPLING_RATE).build();
    private static final int MAX_BUFFER_SIZE_BYTE = 524288;
    private static final int SAMPLING_RATE = 16000;
    private final CarAudioManager mManager;

    public CarAudioManagerEmbedded(Object obj) {
        this.mManager = (CarAudioManager) obj;
    }

    public void abandonAudioFocus(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, AudioAttributes audioAttributes) {
        this.mManager.abandonAudioFocus(onAudioFocusChangeListener, audioAttributes);
    }

    public CarAudioRecord createCarAudioRecord(int i) throws CarNotConnectedException, SecurityException {
        if (i >= getAudioRecordMinBufferSize() && i <= getAudioRecordMaxBufferSize()) {
            return new CarAudioRecordEmbedded(AUDIO_RECORD_FORMAT, i);
        }
        throw new IllegalArgumentException("Bad bufferSize value");
    }

    public AudioAttributes getAudioAttributesForCarUsage(int i) throws CarNotConnectedException {
        try {
            return this.mManager.getAudioAttributesForCarUsage(i);
        } catch (android.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public AudioFormat getAudioRecordAudioFormat() throws CarNotConnectedException {
        return AUDIO_RECORD_FORMAT;
    }

    public int getAudioRecordMaxBufferSize() throws CarNotConnectedException {
        return Math.max(getAudioRecordMinBufferSize(), MAX_BUFFER_SIZE_BYTE);
    }

    public int getAudioRecordMinBufferSize() throws CarNotConnectedException {
        return AudioRecord.getMinBufferSize(SAMPLING_RATE, AUDIO_RECORD_FORMAT.getChannelMask(), AUDIO_RECORD_FORMAT.getEncoding());
    }

    public boolean isAudioRecordSupported() throws CarNotConnectedException {
        return true;
    }

    public boolean isMediaMuted() throws CarNotConnectedException {
        try {
            return this.mManager.isMediaMuted();
        } catch (android.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public void onCarDisconnected() {
    }

    public int requestAudioFocus(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, AudioAttributes audioAttributes, int i) throws CarNotConnectedException, IllegalArgumentException {
        try {
            return this.mManager.requestAudioFocus(onAudioFocusChangeListener, audioAttributes, i, 0);
        } catch (android.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public int requestAudioFocus(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, AudioAttributes audioAttributes, int i, int i2) throws CarNotConnectedException, IllegalArgumentException {
        try {
            return this.mManager.requestAudioFocus(onAudioFocusChangeListener, audioAttributes, i, i2);
        } catch (android.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }

    public boolean setMediaMute(boolean z) throws CarNotConnectedException {
        try {
            return this.mManager.setMediaMute(z);
        } catch (android.car.CarNotConnectedException e) {
            throw new CarNotConnectedException((Exception) e);
        }
    }
}
