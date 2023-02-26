package com.google.android.gms.car;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import com.google.android.gms.car.CarActivityHost;
import com.google.android.gms.car.input.InputManager;
import com.google.android.gms.common.internal.Hide;
import java.io.FileDescriptor;
import java.io.PrintWriter;

@TargetApi(21)
/* renamed from: com.google.android.gms.car.c */
public class C0112c extends ContextWrapper implements LayoutInflater.Factory, CarActivityHost.HostedCarActivity {

    /* renamed from: a */
    private CarActivityHost f360a;

    /* renamed from: b */
    private boolean f361b;

    public C0112c() {
        super((Context) null);
    }

    /* renamed from: a */
    public final InputManager mo978a() {
        return this.f360a.getInputManager();
    }

    @Nullable
    /* renamed from: a */
    public final Object mo979a(String str) throws CarNotSupportedException, CarNotConnectedException {
        return this.f360a.getCarManager(str);
    }

    @Hide
    public void attach(CarActivityHost carActivityHost) {
        if (Log.isLoggable("CAR.PROJECTION", 2)) {
            Log.v("CAR.PROJECTION", new StringBuilder(24).append("Context DPI: ").append(getResources().getConfiguration().densityDpi).toString());
        }
        this.f360a = carActivityHost;
    }

    /* renamed from: b */
    public final boolean mo980b() {
        if (this.f360a != null) {
            return this.f360a.isFinishing();
        }
        return true;
    }

    /* renamed from: c */
    public final Window mo981c() {
        return this.f360a.getWindow();
    }

    @Nullable
    /* renamed from: d */
    public final Object mo982d() {
        return this.f360a.getNonConfigurationInstance();
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public View findViewById(int i) {
        return this.f360a.findViewById(i);
    }

    public Intent getIntent() {
        return this.f360a.getIntent();
    }

    public LayoutInflater getLayoutInflater() {
        return this.f360a.getLayoutInflater();
    }

    public void onAccessibilityScanRequested(IBinder iBinder) {
    }

    public void onBackPressed() {
        this.f361b = false;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onCreate(Bundle bundle) {
    }

    @Hide
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return null;
    }

    public void onDestroy() {
    }

    public void onFrameRateChange(int i) {
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        this.f361b = true;
        onBackPressed();
        return this.f361b;
    }

    public void onLowMemory() {
    }

    public void onNewIntent(Intent intent) {
    }

    public void onPause() {
    }

    public void onPostResume() {
    }

    public void onPowerStateChange(int i) {
    }

    public void onRestoreInstanceState(Bundle bundle) {
        this.f360a.onRestoreInstanceState(bundle);
    }

    public void onResume() {
    }

    public Object onRetainNonConfigurationInstance() {
        return null;
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.f360a.onSaveInstanceState(bundle);
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void onWindowFocusChanged(boolean z, boolean z2) {
    }

    public void setContentView(int i) {
        this.f360a.setContentView(i);
    }

    public void setContentView(View view) {
        this.f360a.setContentView(view);
    }

    @Hide
    @CallSuper
    public void setContext(Context context) {
        attachBaseContext(context);
    }

    @Deprecated
    public void setIgnoreConfigChanges(int i) {
        this.f360a.setIgnoreConfigChanges(i);
    }

    public void setIntent(Intent intent) {
        this.f360a.setIntent(intent);
    }
}
