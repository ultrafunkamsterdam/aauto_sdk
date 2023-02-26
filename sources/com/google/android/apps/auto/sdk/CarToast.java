package com.google.android.apps.auto.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.support.annotation.StringRes;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CarToast {
    private CarToast() {
    }

    public static Toast makeText(Context context, @StringRes int i, int i2) throws Resources.NotFoundException {
        return makeText(context, context.getResources().getText(i), i2);
    }

    public static Toast makeText(Context context, CharSequence charSequence, int i) {
        Context context2;
        if (Log.isLoggable("CSL.CarToast", 3)) {
            String valueOf = String.valueOf(charSequence);
            Log.d("CSL.CarToast", new StringBuilder(String.valueOf(valueOf).length() + 31).append("makeText ").append(valueOf).append(", duration ").append(i).toString());
        }
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        }
        Context a = new C0027ad(context).mo345a();
        String packageName = a.getPackageName();
        if (a.getPackageName().equals(context.getPackageName())) {
            try {
                context2 = context.createPackageContext("com.google.android.gms", 2);
            } catch (PackageManager.NameNotFoundException e) {
                throw new IllegalStateException("Bad package: com.google.android.gms", e);
            }
        } else {
            context2 = a;
        }
        FrameLayout frameLayout = new FrameLayout(context2);
        frameLayout.setClipChildren(false);
        Resources resources = a.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(resources.getIdentifier("car_toast_padding", "dimen", packageName));
        frameLayout.setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        ((TextView) ((ViewGroup) LayoutInflater.from(a).inflate(resources.getIdentifier("adu_toast", "layout", packageName), frameLayout)).findViewById(16908299)).setText(charSequence);
        Toast toast = new Toast(a);
        toast.setView(frameLayout);
        toast.setDuration(i);
        toast.setGravity(87, 0, resources.getDimensionPixelOffset(resources.getIdentifier("toast_y_offset", "dimen", packageName)));
        return toast;
    }
}
