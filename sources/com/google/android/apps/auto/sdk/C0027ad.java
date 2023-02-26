package com.google.android.apps.auto.sdk;

import android.content.Context;
import com.google.android.gms.car.C0116g;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.google.android.apps.auto.sdk.ad */
public final class C0027ad {

    /* renamed from: a */
    private Context f103a;

    /* renamed from: b */
    private Context f104b;

    public C0027ad(Context context) {
        this.f103a = context;
        this.f104b = C0116g.m379b(context);
    }

    /* renamed from: a */
    public static int m110a(Context context) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return ((Integer) context.getClassLoader().loadClass("com.google.android.apps.auto.sdk.SdkVersion").getDeclaredMethod("getVersion", new Class[0]).invoke((Object) null, new Object[0])).intValue();
    }

    /* renamed from: a */
    public final Context mo345a() {
        return this.f104b;
    }

    /* renamed from: a */
    public final Class<?> mo346a(String str) {
        try {
            return this.f104b.getClassLoader().loadClass(str);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            String valueOf = String.valueOf(str);
            throw new IllegalStateException(valueOf.length() != 0 ? "Unable to load SDK class ".concat(valueOf) : new String("Unable to load SDK class "), classNotFoundException);
        }
    }

    /* renamed from: b */
    public final Context mo347b() {
        return this.f103a;
    }
}
