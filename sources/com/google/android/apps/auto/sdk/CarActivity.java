package com.google.android.apps.auto.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.car.Car;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.car.C0114e;
import com.google.android.gms.car.CarInfoManager;
import com.google.android.gms.car.CarNotConnectedException;
import com.google.android.gms.car.CarNotSupportedException;

public class CarActivity extends C0114e {
    @VisibleForTesting

    /* renamed from: d */
    private CarUiController f21d;

    /* renamed from: e */
    private C0027ad f22e;

    /* renamed from: f */
    private SupportLibViewLoader f23f;

    /* renamed from: g */
    private ViewGroup f24g;

    public View findViewById(int i) {
        return super.findViewById(i);
    }

    @CallSuper
    public CarUiController getCarUiController() {
        return this.f21d;
    }

    @CallSuper
    public Intent getIntent() {
        return super.getIntent();
    }

    public LayoutInflater getLayoutInflater() {
        return super.getLayoutInflater();
    }

    public FragmentManager getSupportFragmentManager() {
        return super.getSupportFragmentManager();
    }

    public void onAccessibilityScanRequested(IBinder iBinder) {
        this.f21d.mo208a(iBinder);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    @CallSuper
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        String valueOf = String.valueOf(configuration);
        Log.d("CSL.CarActivity", new StringBuilder(String.valueOf(valueOf).length() + 23).append("onConfigurationChanged ").append(valueOf).toString());
        getResources().getConfiguration().updateFrom(configuration);
        this.f21d.mo206a(getResources().getConfiguration());
    }

    @CallSuper
    public void onCreate(Bundle bundle) {
        CarInfoManager.CarInfo carInfo;
        super.onCreate(bundle);
        this.f22e = new C0027ad(getBaseContext());
        this.f23f = new SupportLibViewLoader();
        try {
            carInfo = ((CarInfoManager) mo979a(Car.INFO_SERVICE)).loadCarInfo();
        } catch (CarNotConnectedException | CarNotSupportedException e) {
            Log.w("CSL.CarActivity", "Unable to get car info", e);
            carInfo = null;
        }
        this.f21d = new CarUiController(this.f22e, mo978a(), this.f23f, carInfo);
        super.setContentView(this.f21d.mo213d());
        this.f24g = (ViewGroup) findViewById(this.f21d.mo212c());
    }

    @Nullable
    @CallSuper
    public View onCreateView(String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        View onCreateView = this.f23f.onCreateView(str, context, attributeSet);
        return onCreateView != null ? onCreateView : super.onCreateView(str, context, attributeSet);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("android:viewHierarchyState");
        if (bundle2 != null) {
            bundle2.setClassLoader(this.f22e.mo345a().getClassLoader());
        }
        super.onRestoreInstanceState(bundle);
        this.f21d.mo207a(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f21d.mo211b(bundle);
    }

    @CallSuper
    public void onStart() {
        super.onStart();
        this.f21d.mo204a();
    }

    @CallSuper
    public void onStop() {
        super.onStop();
        this.f21d.mo210b();
    }

    @CallSuper
    public void setContentView(@LayoutRes int i) {
        this.f24g.removeAllViews();
        getLayoutInflater().inflate(i, this.f24g, true);
    }

    @CallSuper
    public void setContentView(View view) {
        this.f24g.removeAllViews();
        this.f24g.addView(view);
    }

    public void setIgnoreConfigChanges(int i) {
        super.setIgnoreConfigChanges(i);
    }

    @CallSuper
    public void setIntent(Intent intent) {
        super.setIntent(intent);
    }

    @CallSuper
    public void startCarActivity(Intent intent) {
        intent.putExtra("android.intent.extra.PACKAGE_NAME", getBaseContext().getPackageName());
        this.f21d.mo205a(intent);
    }
}
