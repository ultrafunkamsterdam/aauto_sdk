package android.support.car.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CarNavigationInstrumentCluster {
    public static final int CLUSTER_TYPE_CUSTOM_IMAGES_SUPPORTED = 1;
    public static final int CLUSTER_TYPE_IMAGE_CODES_ONLY = 2;
    private final Bundle mExtra;
    private final int mImageColorDepthBits;
    private final int mImageHeight;
    private final int mImageWidth;
    private int mMinIntervalMillis;
    private final int mType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ClusterType {
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    CarNavigationInstrumentCluster(int i, int i2, int i3, int i4, int i5) {
        this(i, i2, i3, i4, i5, (Bundle) null);
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    CarNavigationInstrumentCluster(int i, int i2, int i3, int i4, int i5, @Nullable Bundle bundle) {
        this.mMinIntervalMillis = i;
        this.mType = i2;
        this.mImageWidth = i3;
        this.mImageHeight = i4;
        this.mImageColorDepthBits = i5;
        this.mExtra = bundle == null ? new Bundle() : new Bundle(bundle);
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    public CarNavigationInstrumentCluster(CarNavigationInstrumentCluster carNavigationInstrumentCluster) {
        this(carNavigationInstrumentCluster.mMinIntervalMillis, carNavigationInstrumentCluster.mType, carNavigationInstrumentCluster.mImageWidth, carNavigationInstrumentCluster.mImageHeight, carNavigationInstrumentCluster.mImageColorDepthBits);
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    public static CarNavigationInstrumentCluster createCluster(int i) {
        return new CarNavigationInstrumentCluster(i, 2, 0, 0, 0);
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    public static CarNavigationInstrumentCluster createCustomImageCluster(int i, int i2, int i3, int i4) {
        return new CarNavigationInstrumentCluster(i, 1, i2, i3, i4);
    }

    public Bundle getExtra() {
        return this.mExtra;
    }

    public int getImageColorDepthBits() {
        return this.mImageColorDepthBits;
    }

    public int getImageHeight() {
        return this.mImageHeight;
    }

    public int getImageWidth() {
        return this.mImageWidth;
    }

    public int getMinIntervalMillis() {
        return this.mMinIntervalMillis;
    }

    public int getType() {
        return this.mType;
    }

    public boolean supportsCustomImages() {
        return this.mType == 1;
    }

    public String toString() {
        return CarNavigationInstrumentCluster.class.getSimpleName() + "{ minIntervalMillis: " + this.mMinIntervalMillis + ", type: " + this.mType + ", imageWidth: " + this.mImageWidth + ", imageHeight: " + this.mImageHeight + ", imageColourDepthBits: " + this.mImageColorDepthBits + ", extra: " + this.mExtra + " }";
    }
}
