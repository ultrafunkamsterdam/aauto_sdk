package com.google.android.gms.car;

public class CarAudioConfig {
    public final int audioFormat;
    public final int channelConfig;
    public final int sampleRate;

    public CarAudioConfig(int i, int i2, int i3) {
        this.sampleRate = i;
        this.channelConfig = i2;
        this.audioFormat = i3;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof CarAudioConfig)) {
                return false;
            }
            CarAudioConfig carAudioConfig = (CarAudioConfig) obj;
            if (!(this.sampleRate == carAudioConfig.sampleRate && this.channelConfig == carAudioConfig.channelConfig && this.audioFormat == carAudioConfig.audioFormat)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return (((this.sampleRate * 31) + this.channelConfig) * 31) + this.audioFormat;
    }

    public String toString() {
        String name = getClass().getName();
        int i = this.sampleRate;
        int i2 = this.channelConfig;
        return new StringBuilder(String.valueOf(name).length() + 74).append(name).append("[sampleRate=").append(i).append(",channelConfig=").append(i2).append(",audioFormat=").append(this.audioFormat).append("]").toString();
    }
}
