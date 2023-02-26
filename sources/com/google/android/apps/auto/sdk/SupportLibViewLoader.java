package com.google.android.apps.auto.sdk;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class SupportLibViewLoader implements LayoutInflater.Factory {

    /* renamed from: a */
    private static final HashMap<String, Constructor<? extends View>> f96a = new HashMap<>();

    /* renamed from: b */
    private static final ClassLoader f97b = LayoutInflater.class.getClassLoader();

    /* renamed from: c */
    private static final Class<?>[] f98c = {Context.class, AttributeSet.class};

    @Nullable
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        boolean z = true;
        if (!(str.startsWith("com.google.android.gms.car.support") || str.startsWith("android.support") || str.startsWith("com.google.android.apps.auto.sdk.ui"))) {
            return null;
        }
        if (Log.isLoggable("CSL.SupportLibViewLoade", 2)) {
            Log.v("CSL.SupportLibViewLoade", String.format("createView %s with context %s", new Object[]{str, context}));
        }
        Constructor<? extends U> constructor = f96a.get(str);
        if (constructor != null) {
            ClassLoader classLoader = constructor.getDeclaringClass().getClassLoader();
            if (classLoader != f97b) {
                ClassLoader classLoader2 = context.getClassLoader();
                while (true) {
                    if (classLoader != classLoader2) {
                        classLoader2 = classLoader2.getParent();
                        if (classLoader2 == null) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (!z) {
                f96a.remove(str);
                constructor = null;
            }
        }
        if (constructor == null) {
            if (Log.isLoggable("CSL.SupportLibViewLoade", 2)) {
                Log.v("CSL.SupportLibViewLoade", "No cached constructor");
            }
            try {
                constructor = context.getClassLoader().loadClass(str).asSubclass(View.class).getConstructor(f98c);
                constructor.setAccessible(true);
                f96a.put(str, constructor);
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                Log.w("CSL.SupportLibViewLoade", "Error creating view", e);
                return null;
            }
        }
        try {
            return (View) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            String valueOf = String.valueOf(e2);
            Log.w("CSL.SupportLibViewLoade", new StringBuilder(String.valueOf(valueOf).length() + 21).append("Error creating view: ").append(valueOf).toString());
            return null;
        }
    }
}
