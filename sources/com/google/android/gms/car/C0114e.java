package com.google.android.gms.car;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentController;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.util.SimpleArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* renamed from: com.google.android.gms.car.e */
public class C0114e extends C0112c {

    /* renamed from: a */
    final Handler f363a = new C0117h(this);

    /* renamed from: b */
    FragmentController f364b;

    /* renamed from: c */
    boolean f365c;

    /* renamed from: d */
    private boolean f366d;

    /* renamed from: e */
    private boolean f367e;

    /* renamed from: f */
    private boolean f368f;

    /* renamed from: g */
    private boolean f369g;

    static {
        FragmentManager.enableDebugLogging(Log.isLoggable("CAR.PROJECTION", 2));
    }

    /* renamed from: a */
    private static String m373a(View view) {
        String str;
        char c = 'F';
        char c2 = '.';
        StringBuilder sb = new StringBuilder(128);
        sb.append(view.getClass().getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(view)));
        sb.append(' ');
        switch (view.getVisibility()) {
            case 0:
                sb.append('V');
                break;
            case 4:
                sb.append('I');
                break;
            case 8:
                sb.append('G');
                break;
            default:
                sb.append('.');
                break;
        }
        sb.append(view.isFocusable() ? 'F' : '.');
        sb.append(view.isEnabled() ? 'E' : '.');
        sb.append(view.willNotDraw() ? '.' : 'D');
        sb.append(view.isHorizontalScrollBarEnabled() ? 'H' : '.');
        sb.append(view.isVerticalScrollBarEnabled() ? 'V' : '.');
        sb.append(view.isClickable() ? 'C' : '.');
        sb.append(view.isLongClickable() ? 'L' : '.');
        sb.append(' ');
        if (!view.isFocused()) {
            c = '.';
        }
        sb.append(c);
        sb.append(view.isSelected() ? 'S' : '.');
        if (view.isPressed()) {
            c2 = 'P';
        }
        sb.append(c2);
        sb.append(' ');
        sb.append(view.getLeft());
        sb.append(',');
        sb.append(view.getTop());
        sb.append('-');
        sb.append(view.getRight());
        sb.append(',');
        sb.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            sb.append(" #");
            sb.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                switch (-16777216 & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (Resources.NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                sb.append(" ");
                sb.append(str);
                sb.append(":");
                sb.append(resourceTypeName);
                sb.append("/");
                sb.append(resourceEntryName);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0016, code lost:
        r7 = (android.view.ViewGroup) r7;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m374a(java.lang.String r5, java.io.PrintWriter r6, android.view.View r7) {
        /*
            r4 = this;
            r6.print(r5)
            if (r7 != 0) goto L_0x000b
            java.lang.String r0 = "null"
            r6.println(r0)
        L_0x000a:
            return
        L_0x000b:
            java.lang.String r0 = m373a((android.view.View) r7)
            r6.println(r0)
            boolean r0 = r7 instanceof android.view.ViewGroup
            if (r0 == 0) goto L_0x000a
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            int r1 = r7.getChildCount()
            if (r1 <= 0) goto L_0x000a
            java.lang.String r0 = java.lang.String.valueOf(r5)
            java.lang.String r2 = "  "
            java.lang.String r2 = r0.concat(r2)
            r0 = 0
        L_0x0029:
            if (r0 >= r1) goto L_0x000a
            android.view.View r3 = r7.getChildAt(r0)
            r4.m374a(r2, r6, r3)
            int r0 = r0 + 1
            goto L_0x0029
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.car.C0114e.m374a(java.lang.String, java.io.PrintWriter, android.view.View):void");
    }

    /* renamed from: a */
    public final void mo990a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String concat = String.valueOf(str).concat("  ");
        printWriter.print(concat);
        printWriter.print("mCreated=");
        printWriter.print(this.f366d);
        printWriter.print(" mResumed=");
        printWriter.print(this.f367e);
        printWriter.print(" mStopped=");
        printWriter.print(this.f365c);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.f368f);
        this.f364b.dumpLoaders(concat, fileDescriptor, printWriter, strArr);
        this.f364b.getSupportFragmentManager().dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        m374a(String.valueOf(str).concat("  "), printWriter, mo981c().getDecorView());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo991a(boolean z) {
        if (!this.f368f) {
            this.f368f = true;
            this.f369g = z;
            this.f363a.removeMessages(1);
            this.f364b.doLoaderStop(this.f369g);
            this.f364b.dispatchReallyStop();
        }
    }

    public FragmentManager getSupportFragmentManager() {
        return this.f364b.getSupportFragmentManager();
    }

    public void onBackPressed() {
        if (!this.f364b.getSupportFragmentManager().popBackStackImmediate()) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f364b.dispatchConfigurationChanged(configuration);
    }

    public void onCreate(@Nullable Bundle bundle) {
        if (getBaseContext() == null) {
            throw new IllegalStateException("Context not attached to CarActivity");
        }
        this.f364b.attachHost((Fragment) null);
        if (getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
        C0118i iVar = (C0118i) mo982d();
        if (iVar != null) {
            this.f364b.restoreLoaderNonConfig(iVar.f374b);
        }
        if (bundle != null) {
            this.f364b.restoreAllState(bundle.getParcelable("android:support:fragments"), iVar != null ? iVar.f373a : null);
        }
        this.f364b.dispatchCreate();
    }

    @Nullable
    public View onCreateView(String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return super.onCreateView(str, context, attributeSet);
        }
        View onCreateView = this.f364b.onCreateView((View) null, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(str, context, attributeSet) : onCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
        mo991a(false);
        this.f364b.dispatchDestroy();
        this.f364b.doLoaderDestroy();
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f364b.dispatchLowMemory();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f364b.noteStateNotSaved();
    }

    public void onPause() {
        super.onPause();
        this.f367e = false;
        if (this.f363a.hasMessages(2)) {
            this.f363a.removeMessages(2);
            this.f364b.dispatchResume();
        }
        this.f364b.dispatchPause();
    }

    public void onPostResume() {
        super.onPostResume();
        this.f363a.removeMessages(2);
        this.f364b.dispatchResume();
        this.f364b.execPendingActions();
    }

    public void onResume() {
        super.onResume();
        this.f363a.sendEmptyMessage(2);
        this.f367e = true;
        this.f364b.execPendingActions();
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.f365c) {
            mo991a(true);
        }
        List<Fragment> retainNonConfig = this.f364b.retainNonConfig();
        SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig = this.f364b.retainLoaderNonConfig();
        if (retainNonConfig == null && retainLoaderNonConfig == null) {
            return null;
        }
        C0118i iVar = new C0118i();
        iVar.f373a = retainNonConfig;
        iVar.f374b = retainLoaderNonConfig;
        return iVar;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable saveAllState = this.f364b.saveAllState();
        if (saveAllState != null) {
            bundle.putParcelable("android:support:fragments", saveAllState);
        }
    }

    public void onStart() {
        super.onStart();
        this.f365c = false;
        this.f368f = false;
        this.f363a.removeMessages(1);
        if (!this.f366d) {
            this.f366d = true;
            this.f364b.dispatchActivityCreated();
        }
        this.f364b.noteStateNotSaved();
        this.f364b.execPendingActions();
        this.f364b.doLoaderStart();
        this.f364b.dispatchStart();
        this.f364b.reportLoaderStart();
    }

    public void onStop() {
        super.onStop();
        this.f365c = true;
        this.f363a.sendEmptyMessage(1);
        this.f364b.dispatchStop();
    }

    @Hide
    @VisibleForTesting
    public void setContext(Context context) {
        super.setContext(context);
        this.f364b = FragmentController.createController(new C0115f(this, this));
    }
}
