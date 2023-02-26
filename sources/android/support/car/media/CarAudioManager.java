package android.support.car.media;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.support.annotation.RequiresPermission;
import android.support.car.CarManagerBase;
import android.support.car.CarNotConnectedException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class CarAudioManager implements CarManagerBase {
    public static final int CAR_AUDIO_USAGE_ALARM = 6;
    public static final int CAR_AUDIO_USAGE_DEFAULT = 0;
    public static final int CAR_AUDIO_USAGE_MAX = 9;
    public static final int CAR_AUDIO_USAGE_MUSIC = 1;
    public static final int CAR_AUDIO_USAGE_NAVIGATION_GUIDANCE = 3;
    public static final int CAR_AUDIO_USAGE_NOTIFICATION = 7;
    public static final int CAR_AUDIO_USAGE_RADIO = 2;
    public static final int CAR_AUDIO_USAGE_SYSTEM_SAFETY_ALERT = 9;
    public static final int CAR_AUDIO_USAGE_SYSTEM_SOUND = 8;
    public static final int CAR_AUDIO_USAGE_VOICE_CALL = 4;
    public static final int CAR_AUDIO_USAGE_VOICE_COMMAND = 5;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CarAudioUsage {
    }

    public abstract void abandonAudioFocus(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, AudioAttributes audioAttributes);

    @RequiresPermission("android.permission.RECORD_AUDIO")
    public abstract CarAudioRecord createCarAudioRecord(int i) throws SecurityException, CarNotConnectedException;

    public abstract AudioAttributes getAudioAttributesForCarUsage(int i) throws CarNotConnectedException;

    public abstract AudioFormat getAudioRecordAudioFormat() throws CarNotConnectedException;

    public abstract int getAudioRecordMaxBufferSize() throws CarNotConnectedException;

    public abstract int getAudioRecordMinBufferSize() throws CarNotConnectedException;

    public abstract boolean isAudioRecordSupported() throws CarNotConnectedException;

    public abstract boolean isMediaMuted() throws CarNotConnectedException;

    public abstract int requestAudioFocus(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, AudioAttributes audioAttributes, int i) throws CarNotConnectedException, IllegalArgumentException;

    public abstract int requestAudioFocus(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, AudioAttributes audioAttributes, int i, int i2) throws CarNotConnectedException, IllegalArgumentException;

    public abstract boolean setMediaMute(boolean z) throws CarNotConnectedException;
}
