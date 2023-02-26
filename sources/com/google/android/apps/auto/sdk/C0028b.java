package com.google.android.apps.auto.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.apps.auto.sdk.C0023a;
import java.lang.reflect.Array;

/* renamed from: com.google.android.apps.auto.sdk.b */
public final class C0028b<T extends C0023a> implements Parcelable.Creator<T> {

    /* renamed from: a */
    private Class<T> f105a;

    public C0028b(Class<T> cls) {
        this.f105a = cls;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public T createFromParcel(Parcel parcel) {
        Exception e;
        T t = null;
        try {
            T t2 = (C0023a) this.f105a.newInstance();
            try {
                t2.readFromBundle(parcel.readBundle(this.f105a.getClassLoader()));
                return t2;
            } catch (Exception e2) {
                e = e2;
                t = t2;
            }
        } catch (Exception e3) {
            e = e3;
            String valueOf = String.valueOf(this.f105a.getSimpleName());
            Log.e("CSL.AbstractBundleable", valueOf.length() != 0 ? "Failed to instantiate ".concat(valueOf) : new String("Failed to instantiate "), e);
            return t;
        }
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return (C0023a[]) Array.newInstance(this.f105a, i);
    }
}
