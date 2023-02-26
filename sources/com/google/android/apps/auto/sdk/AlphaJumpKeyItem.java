package com.google.android.apps.auto.sdk;

import android.os.Bundle;
import android.os.Parcelable;

public class AlphaJumpKeyItem extends C0023a {
    public static final Parcelable.Creator<AlphaJumpKeyItem> CREATOR = new C0028b(AlphaJumpKeyItem.class);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public char f15a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f16b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f17c = -1;

    public static class Builder {

        /* renamed from: a */
        private AlphaJumpKeyItem f18a = new AlphaJumpKeyItem();

        public AlphaJumpKeyItem build() {
            if (this.f18a.f15a == 0) {
                throw new IllegalArgumentException("The character must be non-null.");
            } else if (!AlphaJumpMenuAdapter.SUPPORTED_CHARACTER_SET.contains(Character.valueOf(this.f18a.f15a))) {
                throw new IllegalArgumentException("The character is not supported.");
            } else if (!this.f18a.f16b || this.f18a.f17c != -1) {
                return this.f18a;
            } else {
                throw new IllegalArgumentException("The character is enabled but there is not a jump position.");
            }
        }

        public Builder setCharacter(char c) {
            char unused = this.f18a.f15a = c;
            return this;
        }

        public Builder setEnabled(boolean z) {
            boolean unused = this.f18a.f16b = z;
            return this;
        }

        public Builder setJumpPosition(int i) {
            int unused = this.f18a.f17c = i;
            return this;
        }
    }

    AlphaJumpKeyItem() {
    }

    public char getCharacter() {
        return this.f15a;
    }

    public int getJumpPosition() {
        return this.f17c;
    }

    public boolean isEnabled() {
        return this.f16b;
    }

    /* access modifiers changed from: protected */
    public void readFromBundle(Bundle bundle) {
        this.f15a = bundle.getChar("character");
        this.f16b = bundle.getBoolean("is_enabled");
        this.f17c = bundle.getInt("jump_position");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[AlphaJumpKeyItem , character ").append(this.f15a).append(", isEnabled ").append(this.f16b).append(", jumpPosition ").append(this.f17c).append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void writeToBundle(Bundle bundle) {
        bundle.putChar("character", this.f15a);
        bundle.putBoolean("is_enabled", this.f16b);
        bundle.putInt("jump_position", this.f17c);
    }
}
