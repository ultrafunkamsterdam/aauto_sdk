package com.google.android.apps.auto.sdk.nav.state;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.apps.auto.sdk.C0023a;
import com.google.android.apps.auto.sdk.C0028b;

public class CarInstrumentClusterConfig extends C0023a {
    public static final Parcelable.Creator<CarInstrumentClusterConfig> CREATOR = new C0028b(CarInstrumentClusterConfig.class);

    /* renamed from: a */
    private int f156a;

    /* renamed from: b */
    private int f157b;

    /* renamed from: c */
    private int f158c;

    /* renamed from: d */
    private int f159d;

    /* renamed from: e */
    private boolean f160e;

    public int getImageDepthBits() {
        return this.f159d;
    }

    public int getImageHeight() {
        return this.f158c;
    }

    public int getImageWidth() {
        return this.f157b;
    }

    public int getMinMessageIntervalMs() {
        return this.f156a;
    }

    /* access modifiers changed from: protected */
    public void readFromBundle(Bundle bundle) {
        this.f156a = bundle.getInt("min_interval");
        this.f157b = bundle.getInt("img_width");
        this.f158c = bundle.getInt("img_height");
        this.f159d = bundle.getInt("img_depth");
        this.f160e = bundle.getBoolean("supports_images");
    }

    public boolean supportsImages() {
        return this.f160e;
    }

    /* access modifiers changed from: protected */
    public void writeToBundle(Bundle bundle) {
        bundle.putInt("min_interval", this.f156a);
        bundle.putInt("img_width", this.f157b);
        bundle.putInt("img_height", this.f158c);
        bundle.putInt("img_depth", this.f159d);
        bundle.putBoolean("supports_images", this.f160e);
    }
}
