package com.google.android.apps.auto.sdk.vanagon;

import android.app.Activity;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.car.C0116g;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PhoneSysUiClient {
    public static final int FACET_HOME = 1;
    public static final int FACET_MAPS = 4;
    public static final int FACET_MEDIA = 2;
    public static final int FACET_OTHER = 5;
    public static final int FACET_PHONE = 3;
    public static final int FACET_UNKNOWN = 0;
    public static String sTestOnlyPackageNameOverride = null;
    public static String sTestOnlySystemUIClassName = null;
    public static boolean sTestOnlyUseThreadClassLoader = false;

    /* renamed from: a */
    private Activity f322a;

    /* renamed from: b */
    private Object f323b;

    /* renamed from: c */
    private Class<?> f324c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Class<?> f325d;

    /* renamed from: e */
    private Method f326e;

    /* renamed from: f */
    private Method f327f;

    /* renamed from: g */
    private Method f328g;

    /* renamed from: h */
    private Method f329h;

    /* renamed from: i */
    private Method f330i;

    /* renamed from: j */
    private Method f331j;

    /* renamed from: k */
    private Method f332k;

    /* renamed from: l */
    private Method f333l;

    /* renamed from: m */
    private Method f334m;

    /* renamed from: n */
    private Method f335n;

    /* renamed from: o */
    private Method f336o;

    /* renamed from: p */
    private Method f337p;

    /* renamed from: q */
    private Method f338q;

    /* renamed from: r */
    private Method f339r;

    /* renamed from: s */
    private Method f340s;

    /* renamed from: t */
    private Method f341t;

    /* renamed from: u */
    private Method f342u;

    /* renamed from: v */
    private Method f343v;

    /* renamed from: w */
    private Method f344w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public AndroidAutoStateCallback f345x;

    /* renamed from: y */
    private final BroadcastReceiver f346y = new C0105c(this);

    public interface AndroidAutoStateCallback {
        void onEnterPhoneMode();

        void onExitPhoneMode();
    }

    public interface ScreenshotProvider {

        public interface OnCompleteListener {
            void onScreenshotComplete(@Nullable Bitmap bitmap);
        }

        void getScreenshot(OnCompleteListener onCompleteListener);
    }

    public PhoneSysUiClient(Activity activity) {
        this.f322a = activity;
    }

    /* renamed from: a */
    private final ViewGroup m351a() {
        ViewGroup activityRootView = getActivityRootView();
        if (this.f323b != null) {
            throw new IllegalStateException("Install can only be called once.");
        }
        this.f323b = m359b();
        if (this.f323b == null) {
            m357a("CarModeSysUI could not be created. fallback to regular Android system UI");
            return activityRootView;
        }
        m353a(this.f326e, true);
        return (ViewGroup) m353a(this.f336o, new Object[0]);
    }

    /* renamed from: a */
    private final Object m353a(Method method, Object... objArr) {
        if (method == null) {
            Log.d("GH.PhoneSysUiClient", "Method is not loaded. no op and return null.");
            return null;
        }
        if (m361c()) {
            try {
                return method.invoke(this.f323b, objArr);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                m355a(e);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static RuntimeException m355a(Exception exc) {
        String valueOf = String.valueOf(exc.toString());
        Log.e("GH.PhoneSysUiClient", valueOf.length() != 0 ? "PhoneSysUiClient failure: ".concat(valueOf) : new String("PhoneSysUiClient failure: "));
        if (exc instanceof InvocationTargetException) {
            String valueOf2 = String.valueOf(((InvocationTargetException) exc).getCause());
            Log.e("GH.PhoneSysUiClient", new StringBuilder(String.valueOf(valueOf2).length() + 32).append("Invocation exception caused by: ").append(valueOf2).toString());
        }
        String valueOf3 = String.valueOf(exc.toString());
        throw new IllegalStateException(valueOf3.length() != 0 ? "Fatal failure interacting with VnClient: ".concat(valueOf3) : new String("Fatal failure interacting with VnClient: "));
    }

    /* renamed from: a */
    private static String m356a(Context context) {
        return sTestOnlyPackageNameOverride != null ? sTestOnlyPackageNameOverride : C0116g.m377a(context);
    }

    /* renamed from: a */
    private static void m357a(String str) {
        if (Log.isLoggable("GH.PhoneSysUiClient", 2)) {
            Log.v("GH.PhoneSysUiClient", str);
        }
    }

    /* renamed from: b */
    private final Object m359b() {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 21) {
            z = true;
        }
        if (!z) {
            m357a("OS not supported.");
            return null;
        }
        try {
            Context createPackageContext = this.f322a.createPackageContext(m356a((Context) this.f322a), 3);
            ClassLoader contextClassLoader = sTestOnlyUseThreadClassLoader ? Thread.currentThread().getContextClassLoader() : createPackageContext.getClassLoader();
            try {
                Class<?> loadClass = contextClassLoader.loadClass(sTestOnlySystemUIClassName != null ? sTestOnlySystemUIClassName : "com.google.android.gearhead.vanagon.thirdparty.CarModeSysUI");
                try {
                    this.f326e = loadClass.getMethod("onCreate", new Class[]{Boolean.TYPE});
                    this.f327f = loadClass.getMethod("onDestroy", new Class[0]);
                    this.f328g = loadClass.getMethod("onStart", new Class[0]);
                    this.f329h = loadClass.getMethod("onStop", new Class[0]);
                    this.f330i = loadClass.getMethod("onResume", new Class[0]);
                    this.f333l = loadClass.getMethod("onWindowFocusChanged", new Class[]{Boolean.TYPE});
                    this.f332k = loadClass.getMethod("onConfigurationChanged", new Class[]{Configuration.class});
                    this.f331j = loadClass.getMethod("onPause", new Class[0]);
                    this.f335n = loadClass.getMethod("getSystemUIView", new Class[0]);
                    this.f336o = loadClass.getMethod("getAppRootViewGroup", new Class[0]);
                    this.f334m = loadClass.getMethod("setEnabled", new Class[]{Boolean.TYPE});
                    this.f337p = loadClass.getMethod("setSystemUiVisibility", new Class[]{Integer.TYPE});
                    this.f338q = loadClass.getMethod("showDownButton", new Class[]{Boolean.TYPE});
                    this.f340s = loadClass.getMethod("showFacetNavigation", new Class[]{Boolean.TYPE});
                    this.f341t = loadClass.getMethod("showFacetNavigation", new Class[]{Boolean.TYPE, Integer.TYPE, Integer.TYPE});
                    this.f339r = loadClass.getMethod("setSystemUiFlagLightStatusBar", new Class[]{Boolean.TYPE});
                    this.f342u = loadClass.getMethod("setPrettyImmersiveStickyTransitions", new Class[]{Boolean.TYPE});
                    try {
                        this.f343v = loadClass.getMethod("suppressHomeButtonExit", new Class[]{Boolean.TYPE});
                        this.f324c = contextClassLoader.loadClass("com.google.android.apps.auto.sdk.vanagon.PhoneSysUiClient$ScreenshotProvider");
                        this.f325d = contextClassLoader.loadClass("com.google.android.apps.auto.sdk.vanagon.PhoneSysUiClient$ScreenshotProvider$OnCompleteListener");
                        this.f344w = loadClass.getMethod("setScreenshotProvider", new Class[]{this.f324c});
                    } catch (ClassNotFoundException | NoSuchMethodException e) {
                        Log.w("GH.PhoneSysUiClient", "Optional method is not loaded.", e);
                    }
                    try {
                        return loadClass.getDeclaredConstructor(new Class[]{Context.class, Context.class}).newInstance(new Object[]{this.f322a, createPackageContext});
                    } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
                        Log.e("GH.PhoneSysUiClient", "Could not construct control.");
                        throw m355a(e2);
                    }
                } catch (Exception e3) {
                    Log.e("GH.PhoneSysUiClient", "Could not retrieve all required methods.");
                    throw m355a(e3);
                }
            } catch (ClassNotFoundException e4) {
                Log.e("GH.PhoneSysUiClient", "Could not find CarModeSysUI. Extremely old Android Auto?");
                return null;
            }
        } catch (PackageManager.NameNotFoundException | IllegalStateException e5) {
            m357a("Android Auto package not found.");
            return null;
        }
    }

    /* renamed from: b */
    private static void m360b(String str) {
        if (Log.isLoggable("GH.PhoneSysUiClient", 3)) {
            Log.d("GH.PhoneSysUiClient", str);
        }
    }

    /* renamed from: c */
    private final boolean m361c() {
        if (this.f323b == null) {
            m357a("SystemUI not installed");
        }
        return this.f323b != null;
    }

    public static boolean isAndroidAutoRunning(Context context) {
        boolean z;
        if (((UiModeManager) context.getSystemService("uimode")).getCurrentModeType() == 3) {
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(new Intent("android.intent.action.MAIN").addCategory("android.intent.category.CAR_DOCK"), 0);
            if (resolveActivity == null || resolveActivity.activityInfo == null) {
                m360b("No car dock app installed.");
                z = false;
            } else {
                String valueOf = String.valueOf(resolveActivity.activityInfo.toString());
                m360b(valueOf.length() != 0 ? "activityInfo: ".concat(valueOf) : new String("activityInfo: "));
                String valueOf2 = String.valueOf(resolveActivity.activityInfo.packageName);
                m360b(valueOf2.length() != 0 ? "packageName: ".concat(valueOf2) : new String("packageName: "));
                if (m356a(context).equals(resolveActivity.activityInfo.packageName)) {
                    z = true;
                } else {
                    m360b("Non-vanagon car dock app installed.");
                    z = false;
                }
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public ViewGroup getActivityRootView() {
        return (ViewGroup) this.f322a.findViewById(16908290);
    }

    public View getSystemRoot() {
        m357a("getSystemRoot()");
        return (View) m353a(this.f335n, new Object[0]);
    }

    public void onConfigurationChanged(Configuration configuration) {
        m357a("onConfigurationChanged");
        m353a(this.f332k, configuration);
    }

    public ViewGroup onCreate(boolean z) {
        m357a("onCreate");
        return !z ? getActivityRootView() : m351a();
    }

    public void onDestroy() {
        m357a("onDestroy");
        m353a(this.f327f, new Object[0]);
    }

    public void onPause() {
        m357a("onPause");
        m353a(this.f331j, new Object[0]);
    }

    public void onResume() {
        m357a("onResume");
        m353a(this.f330i, new Object[0]);
    }

    public void onStart() {
        m357a("onStart");
        m353a(this.f328g, new Object[0]);
    }

    public void onStop() {
        m357a("onStop");
        m353a(this.f329h, new Object[0]);
    }

    public void onWindowFocusChanged(boolean z) {
        m357a(new StringBuilder(27).append("onWindowFocusChanged: ").append(z).toString());
        m353a(this.f333l, Boolean.valueOf(z));
    }

    public void setAndroidAutoStateListener(@Nullable AndroidAutoStateCallback androidAutoStateCallback) {
        if (this.f345x == null && androidAutoStateCallback != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(UiModeManager.ACTION_ENTER_CAR_MODE);
            intentFilter.addAction(UiModeManager.ACTION_EXIT_CAR_MODE);
            this.f322a.registerReceiver(this.f346y, intentFilter);
        }
        if (this.f345x != null && androidAutoStateCallback == null) {
            this.f322a.unregisterReceiver(this.f346y);
        }
        this.f345x = androidAutoStateCallback;
    }

    public void setEnabled(boolean z) {
        m357a(new StringBuilder(17).append("setEnabled: ").append(z).toString());
        if (!m361c() && z) {
            m351a();
        }
        if (m361c()) {
            m353a(this.f334m, Boolean.valueOf(z));
        }
    }

    public void setPrettyImmersiveStickyTransitions(boolean z) {
        m357a(new StringBuilder(42).append("setPrettyImmersiveStickyTransitions: ").append(z).toString());
        m353a(this.f342u, Boolean.valueOf(z));
    }

    public void setScreenshotProvider(ScreenshotProvider screenshotProvider) {
        String valueOf = String.valueOf(screenshotProvider);
        m357a(new StringBuilder(String.valueOf(valueOf).length() + 23).append("setScreenshotProvider: ").append(valueOf).toString());
        if (this.f324c == null || this.f325d == null) {
            Log.d("GH.PhoneSysUiClient", "Method is not loaded. no op and return.");
            return;
        }
        Method method = this.f344w;
        ClassLoader classLoader = this.f324c.getClassLoader();
        Class<?> cls = this.f324c;
        Class[] clsArr = {cls};
        m353a(method, Proxy.newProxyInstance(classLoader, clsArr, new C0103a(this, screenshotProvider)));
    }

    public void setSystemUiVisibility(int i) {
        m357a(new StringBuilder(34).append("setSystemUiVisibility: ").append(i).toString());
        m353a(this.f337p, Integer.valueOf(i));
    }

    public void setTintStatusBarIcons(boolean z) {
        m357a(new StringBuilder(28).append("setTintStatusBarIcons: ").append(z).toString());
        m353a(this.f339r, Boolean.valueOf(z));
    }

    @Deprecated
    public void showDownButton(boolean z) {
        m357a("showDownButton()");
        m353a(this.f338q, Boolean.valueOf(z));
    }

    @Deprecated
    public void showFacetNavigation(boolean z) {
        m357a("showFacetNavigation()");
        m353a(this.f340s, Boolean.valueOf(z));
    }

    @Deprecated
    public void showFacetNavigation(boolean z, int i, int i2) {
        m357a("showFacetNavigation()");
        m353a(this.f341t, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void suppressHomeButtonExit(boolean z) {
        m357a(new StringBuilder(29).append("suppressHomeButtonExit: ").append(z).toString());
        m353a(this.f343v, Boolean.valueOf(z));
    }
}
