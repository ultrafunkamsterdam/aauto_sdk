package com.google.android.apps.auto.sdk.nav.state;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.apps.auto.sdk.C0023a;
import com.google.android.apps.auto.sdk.C0028b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TurnEvent extends C0023a {
    public static final Parcelable.Creator<TurnEvent> CREATOR = new C0028b(TurnEvent.class);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f165a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CharSequence f166b = "";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f167c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f168d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f169e;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: f */
    public byte[] f170f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f171g = -1;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f172h = -1;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f173i = -1;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f174j;

    public static class Builder {

        /* renamed from: a */
        private TurnEvent f175a;

        public Builder() {
            this.f175a = new TurnEvent();
        }

        public Builder(TurnEvent turnEvent) {
            this.f175a = turnEvent;
        }

        public TurnEvent build() {
            return this.f175a;
        }

        public Builder setRoundaboutTurnEvent(int i, int i2) throws IllegalArgumentException {
            if (i > 360 || i <= 0) {
                throw new IllegalArgumentException("Turn angle must be in [1, 360]");
            } else if (i2 <= 0) {
                throw new IllegalArgumentException("Turn number must be > 0");
            } else {
                int unused = this.f175a.f165a = 13;
                int unused2 = this.f175a.f168d = i;
                int unused3 = this.f175a.f169e = i2;
                return this;
            }
        }

        public Builder setSecondsUntilTurnEvent(int i) throws IllegalArgumentException {
            if (i < 0) {
                throw new IllegalArgumentException("turnEtaSeconds must be >= 0");
            }
            int unused = this.f175a.f172h = i;
            return this;
        }

        public Builder setTurnDisplayDistanceE3(int i) throws IllegalArgumentException {
            if (i < 0) {
                throw new IllegalArgumentException("displayDistanceE3 must be >= 0");
            }
            int unused = this.f175a.f173i = i;
            return this;
        }

        public Builder setTurnDistanceMeters(int i) throws IllegalArgumentException {
            if (i < 0) {
                throw new IllegalArgumentException("distanceMeters must be >= 0");
            }
            int unused = this.f175a.f171g = i;
            return this;
        }

        public Builder setTurnDistanceUnit(int i) {
            int unused = this.f175a.f174j = i;
            return this;
        }

        public Builder setTurnEventRoadName(CharSequence charSequence) {
            if (charSequence == null) {
                throw new IllegalArgumentException("Road name must not be null");
            }
            CharSequence unused = this.f175a.f166b = charSequence;
            return this;
        }

        public Builder setTurnEventType(int i) throws IllegalArgumentException {
            if (i <= 0 || i > 19) {
                throw new IllegalArgumentException(new StringBuilder(33).append("turnEvent is invalid: ").append(i).toString());
            }
            int unused = this.f175a.f165a = i;
            int unused2 = this.f175a.f168d = -1;
            int unused3 = this.f175a.f169e = -1;
            return this;
        }

        public Builder setTurnImage(byte[] bArr) {
            byte[] unused = this.f175a.f170f = bArr;
            return this;
        }

        public Builder setTurnSide(int i) throws IllegalArgumentException {
            if (i < 0 || i > 2) {
                throw new IllegalArgumentException("turnSide must be one of TurnSide.LEFT, TurnSide.RIGHT or TurnSide.UNKNOWN");
            }
            int unused = this.f175a.f167c = i;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DistanceUnit {
        public static final int FEET = 6;
        public static final int KILOMETERS = 2;
        public static final int KILOMETERS_P1 = 3;
        public static final int METERS = 1;
        public static final int MILES = 4;
        public static final int MILES_P1 = 5;
        public static final int UNKNOWN = 0;
        public static final int YARDS = 7;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TurnEventType {
        public static final int DEPART = 1;
        public static final int DESTINATION = 19;
        public static final int FERRY_BOAT = 16;
        public static final int FERRY_TRAIN = 17;
        public static final int FORK = 9;
        public static final int MERGE = 10;
        public static final int NAME_CHANGE = 2;
        public static final int OFF_RAMP = 8;
        public static final int ON_RAMP = 7;
        public static final int ROUNDABOUT_ENTER = 11;
        public static final int ROUNDABOUT_ENTER_AND_EXIT = 13;
        public static final int ROUNDABOUT_EXIT = 12;
        public static final int SHARP_TURN = 5;
        public static final int SLIGHT_TURN = 3;
        public static final int STRAIGHT = 14;
        public static final int TURN = 4;
        public static final int UNKNOWN = 0;
        public static final int U_TURN = 6;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TurnSide {
        public static final int LEFT = 1;
        public static final int RIGHT = 2;
        public static final int UNKNOWN = 0;
    }

    public int getSecondsUntilTurnEvent() {
        return this.f172h;
    }

    public int getTurnAngle() {
        return this.f168d;
    }

    public int getTurnDisplayDistanceE3() {
        return this.f173i;
    }

    public int getTurnDistanceMeters() {
        return this.f171g;
    }

    public int getTurnDistanceUnit() {
        return this.f174j;
    }

    public CharSequence getTurnEventRoadName() {
        return this.f166b;
    }

    public int getTurnEventType() {
        return this.f165a;
    }

    @Nullable
    public byte[] getTurnImage() {
        return this.f170f;
    }

    public int getTurnNumber() {
        return this.f169e;
    }

    public int getTurnSide() {
        return this.f167c;
    }

    public boolean hasSecondsUntilTurnEvent() {
        return this.f172h != -1;
    }

    public boolean hasTurnAngle() {
        return this.f168d > 0;
    }

    public boolean hasTurnDisplayDistanceE3() {
        return this.f173i != -1;
    }

    public boolean hasTurnDistanceMeters() {
        return this.f171g != -1;
    }

    public boolean hasTurnNumber() {
        return this.f169e > 0;
    }

    /* access modifiers changed from: protected */
    public void readFromBundle(Bundle bundle) {
        this.f165a = bundle.getInt("turn_event");
        this.f166b = bundle.getCharSequence("turn_event_road", "");
        this.f167c = bundle.getInt("turn_event_side");
        this.f168d = bundle.getInt("turn_angle");
        this.f169e = bundle.getInt("turn_number");
        this.f170f = bundle.getByteArray("turn_image");
        this.f171g = bundle.getInt("turn_distance", -1);
        this.f172h = bundle.getInt("sec_to_turn", -1);
        this.f174j = bundle.getInt("turn_unit");
        this.f173i = bundle.getInt("turn_distance_e3", -1);
    }

    /* access modifiers changed from: protected */
    public void writeToBundle(Bundle bundle) {
        bundle.putInt("turn_event", this.f165a);
        bundle.putCharSequence("turn_event_road", this.f166b);
        bundle.putInt("turn_event_side", this.f167c);
        bundle.putInt("turn_angle", this.f168d);
        bundle.putInt("turn_number", this.f169e);
        bundle.putByteArray("turn_image", this.f170f);
        bundle.putInt("turn_distance", this.f171g);
        bundle.putInt("sec_to_turn", this.f172h);
        bundle.putInt("turn_unit", this.f174j);
        bundle.putInt("turn_distance_e3", this.f173i);
    }
}
