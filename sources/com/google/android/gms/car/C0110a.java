package com.google.android.gms.car;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.car.CarApiConnection;

/* renamed from: com.google.android.gms.car.a */
public final class C0110a {

    /* renamed from: a */
    private static Class<?> f359a;

    public C0110a() {
        Log.i("ApiFactory", "Initialized ApiFactory to load from remote APK");
    }

    /* renamed from: b */
    private static Class<?> m365b(Context context) throws Exception {
        if (f359a == null) {
            Context b = C0116g.m379b(context.getApplicationContext());
            f359a = b.getClassLoader().loadClass("com.google.android.gms.car.DynamicApiFactory");
            f359a.getMethod("initialize", new Class[]{Context.class}).invoke((Object) null, new Object[]{b});
        }
        return f359a;
    }

    /* renamed from: a */
    public final CarActivityServiceProxy mo976a(Context context) throws C0111b {
        try {
            return (CarActivityServiceProxy) m365b(context).getMethod("newCarActivityServiceProxy", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
        } catch (Exception e) {
            throw new C0111b(e);
        }
    }

    /* renamed from: a */
    public final CarApiConnection mo977a(Context context, CarApiConnection.ApiConnectionCallback apiConnectionCallback, Looper looper) throws C0111b {
        try {
            return (CarApiConnection) m365b(context).getMethod("newCarApiConnection", new Class[]{Context.class, Object.class, Looper.class}).invoke((Object) null, new Object[]{context, apiConnectionCallback, looper});
        } catch (Exception e) {
            throw new C0111b(e);
        }
    }
}
