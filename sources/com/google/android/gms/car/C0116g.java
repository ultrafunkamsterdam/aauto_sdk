package com.google.android.gms.car;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.p002a.p003a.p004a.p005a.p006a.C0009a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.car.g */
public final class C0116g {

    /* renamed from: a */
    private static final List<String> f371a = Collections.unmodifiableList(Arrays.asList(new String[]{"com.google.android.projection.bumblebee", "com.google.android.projection.gearhead"}));

    /* renamed from: a */
    public static String m377a(Context context) {
        return m378a(context, !"user".equals(Build.TYPE));
    }

    /* renamed from: a */
    private static String m378a(Context context, boolean z) {
        ArrayList arrayList = null;
        if (f371a.contains(context.getPackageName())) {
            return context.getPackageName();
        }
        ComponentName resolveActivity = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.CAR_DOCK").resolveActivity(context.getPackageManager());
        if (resolveActivity != null && f371a.contains(resolveActivity.getPackageName())) {
            try {
                String packageName = resolveActivity.getPackageName();
                C0118i.m381a(context, packageName, z);
                return packageName;
            } catch (PackageManager.NameNotFoundException | SecurityException e) {
            }
        }
        for (String next : f371a) {
            try {
                C0118i.m381a(context, next, z);
                return next;
            } catch (PackageManager.NameNotFoundException e2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(e2);
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("Android Auto is not installed!");
        if (arrayList != null && !arrayList.isEmpty()) {
            if (Build.VERSION.SDK_INT >= 19) {
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    C0009a.m1a(illegalStateException, (Exception) obj);
                }
            } else {
                illegalStateException.initCause((Throwable) arrayList.get(arrayList.size() - 1));
            }
        }
        throw illegalStateException;
    }

    /* renamed from: b */
    public static Context m379b(Context context) {
        return m380b(context, !"user".equals(Build.TYPE));
    }

    /* renamed from: b */
    private static Context m380b(Context context, boolean z) {
        String a = m378a(context, z);
        if (context.getPackageName().equals(a)) {
            return context;
        }
        try {
            return context.createPackageContext(a, 3);
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(a);
            throw new IllegalStateException(valueOf.length() != 0 ? "NameNotFoundException looking up ".concat(valueOf) : new String("NameNotFoundException looking up "), e);
        }
    }
}
