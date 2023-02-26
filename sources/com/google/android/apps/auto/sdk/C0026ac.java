package com.google.android.apps.auto.sdk;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.google.android.apps.auto.sdk.ac */
abstract class C0026ac {

    /* renamed from: a */
    protected String f101a;

    /* renamed from: b */
    private Object f102b;

    public C0026ac(C0027ad adVar, String str, Object... objArr) {
        Constructor constructor;
        int i = 0;
        try {
            int a = C0027ad.m110a(adVar.mo347b());
            int a2 = C0027ad.m110a(adVar.mo345a());
            if (a > a2) {
                String packageName = adVar.mo345a().getPackageName();
                String packageName2 = adVar.mo347b().getPackageName();
                String str2 = adVar.mo345a().getPackageManager().getPackageInfo(packageName, 0).versionName;
                Log.w("CSL.RemoteClass", new StringBuilder(String.valueOf(packageName).length() + 78 + String.valueOf(str2).length() + String.valueOf(packageName2).length()).append("Older version of Android Auto detected.").append(packageName).append("(").append(str2).append(", api=").append(a2).append(")\n").append(packageName2).append("(api=  ").append(a).append(")").toString());
            }
        } catch (Exception e) {
            Log.e("CSL.RemoteClass", "Error extracting SDK version, you may face runtime errors", e);
        }
        this.f101a = str;
        Class<?> a3 = adVar.mo346a(str);
        Constructor[] constructors = a3.getConstructors();
        int length = constructors.length;
        while (true) {
            if (i >= length) {
                constructor = null;
                break;
            }
            constructor = constructors[i];
            if (objArr.length == constructor.getParameterTypes().length) {
                break;
            }
            i++;
        }
        if (constructor == null) {
            throw new IllegalStateException("Cannot find SDK entry constructor.");
        }
        try {
            this.f102b = constructor.newInstance(objArr);
            mo209a(a3.getDeclaredMethods());
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            Log.wtf("CSL.RemoteClass", "Unable to load SDK entry class.", e2);
            throw new IllegalStateException("Unable to load SDK entry class.", e2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo344a(Method method, Object... objArr) {
        if (method == null) {
            Log.e("CSL.RemoteClass", "Error invoking a null method.  Ignored.", new Exception());
            return null;
        }
        try {
            return method.invoke(this.f102b, objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            String valueOf = String.valueOf(method.getName());
            Log.e("CSL.RemoteClass", valueOf.length() != 0 ? "Error invoking: ".concat(valueOf) : new String("Error invoking: "), e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo209a(Method[] methodArr);
}
