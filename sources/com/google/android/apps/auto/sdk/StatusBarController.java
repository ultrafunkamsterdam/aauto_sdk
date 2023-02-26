package com.google.android.apps.auto.sdk;

import android.os.RemoteException;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.util.Log;
import com.google.android.gms.car.CarInfoManager;

public class StatusBarController {

    /* renamed from: a */
    private C0088t f94a;

    /* renamed from: b */
    private final CarInfoManager.CarInfo f95b;

    StatusBarController(C0088t tVar, @Nullable CarInfoManager.CarInfo carInfo) {
        this.f94a = tVar;
        this.f95b = carInfo;
        if (this.f95b != null) {
            if (this.f95b.isHideProjectedClock()) {
                hideClock();
            }
            if (this.f95b.isHideBatteryLevel()) {
                hideBatteryLevel();
            }
            if (this.f95b.isHidePhoneSignal()) {
                hideConnectivityLevel();
            }
        }
    }

    @UiThread
    public void hideAppHeader() {
        Log.d("CSL.StatusBarController", "hideAppHeader");
        hideTitle();
        hideConnectivityLevel();
        hideBatteryLevel();
        hideClock();
        hideMicButton();
    }

    @UiThread
    public void hideBatteryLevel() {
        Log.d("CSL.StatusBarController", "hideBatteryLevel");
        try {
            this.f94a.mo619g();
        } catch (RemoteException e) {
            Log.e("CSL.StatusBarController", "Error hiding battery level", e);
        }
    }

    @UiThread
    public void hideClock() {
        Log.d("CSL.StatusBarController", "hideClock");
        try {
            this.f94a.mo621i();
        } catch (RemoteException e) {
            Log.e("CSL.StatusBarController", "Error hiding clock", e);
        }
    }

    @UiThread
    public void hideConnectivityLevel() {
        Log.d("CSL.StatusBarController", "hideConnectivityLevel");
        try {
            this.f94a.mo617e();
        } catch (RemoteException e) {
            Log.e("CSL.StatusBarController", "Error hiding connectivity level", e);
        }
    }

    @UiThread
    public void hideMicButton() {
        Log.d("CSL.StatusBarController", "hideMicButton");
        try {
            this.f94a.mo623k();
        } catch (RemoteException e) {
            Log.e("CSL.StatusBarController", "Error hiding mic button", e);
        }
    }

    @UiThread
    public void hideTitle() {
        Log.d("CSL.StatusBarController", "hideTitle");
        try {
            this.f94a.mo615c();
        } catch (RemoteException e) {
            Log.e("CSL.StatusBarController", "Error hiding title", e);
        }
    }

    @UiThread
    public boolean isTitleVisible() {
        Log.d("CSL.StatusBarController", "isTitleVisible");
        try {
            return this.f94a.mo612a();
        } catch (RemoteException e) {
            Log.e("CSL.StatusBarController", "Error querying title visibility", e);
            return false;
        }
    }

    @UiThread
    public void setAppBarAlpha(float f) {
        Log.d("CSL.StatusBarController", "setAppBarAlpha");
        try {
            this.f94a.mo609a(f);
        } catch (RemoteException e) {
            Log.e("CSL.StatusBarController", "Error setting app bar alpha", e);
        }
    }

    @UiThread
    public void setAppBarBackgroundColor(@ColorInt int i) {
        Log.d("CSL.StatusBarController", "setAppBarBackgroundColor");
        try {
            this.f94a.mo614b(i);
        } catch (RemoteException e) {
            Log.e("CSL.StatusBarController", "Error setting app bar background color", e);
        }
    }

    public void setDayNightStyle(@DayNightStyle int i) {
        Log.d("CSL.StatusBarController", new StringBuilder(28).append("setDayNightStyle ").append(i).toString());
        try {
            this.f94a.mo610a(i);
        } catch (RemoteException e) {
            Log.e("CSL.StatusBarController", "Error setting day style", e);
        }
    }

    @UiThread
    public void setTitle(CharSequence charSequence) {
        String valueOf = String.valueOf(charSequence);
        Log.d("CSL.StatusBarController", new StringBuilder(String.valueOf(valueOf).length() + 9).append("setTitle ").append(valueOf).toString());
        try {
            this.f94a.mo611a(charSequence);
        } catch (RemoteException e) {
            Log.e("CSL.StatusBarController", "Error setting title", e);
        }
    }

    @UiThread
    public void showAppHeader() {
        Log.d("CSL.StatusBarController", "showAppHeader");
        showTitle();
        showConnectivityLevel();
        showBatteryLevel();
        showClock();
        showMicButton();
    }

    @UiThread
    public void showBatteryLevel() {
        if (this.f95b == null || !this.f95b.isHideBatteryLevel()) {
            Log.d("CSL.StatusBarController", "showBatteryLevel");
            try {
                this.f94a.mo618f();
            } catch (RemoteException e) {
                Log.e("CSL.StatusBarController", "Error showing battery level", e);
            }
        } else {
            Log.d("CSL.StatusBarController", "Battery level is forced to be hidden.");
        }
    }

    @UiThread
    public void showClock() {
        if (this.f95b == null || !this.f95b.isHideProjectedClock()) {
            Log.d("CSL.StatusBarController", "showClock");
            try {
                this.f94a.mo620h();
            } catch (RemoteException e) {
                Log.e("CSL.StatusBarController", "Error showing clock", e);
            }
        } else {
            Log.d("CSL.StatusBarController", "Projected clock is forced to be hidden.");
        }
    }

    @UiThread
    public void showConnectivityLevel() {
        if (this.f95b == null || !this.f95b.isHidePhoneSignal()) {
            Log.d("CSL.StatusBarController", "showConnectivityLevel");
            try {
                this.f94a.mo616d();
            } catch (RemoteException e) {
                Log.e("CSL.StatusBarController", "Error showing connectivity level", e);
            }
        } else {
            Log.d("CSL.StatusBarController", "Phone signal is forced to be hidden.");
        }
    }

    @UiThread
    public void showMicButton() {
        Log.d("CSL.StatusBarController", "showMicButton");
        try {
            this.f94a.mo622j();
        } catch (RemoteException e) {
            Log.e("CSL.StatusBarController", "Error showing mic button", e);
        }
    }

    @UiThread
    public void showTitle() {
        Log.d("CSL.StatusBarController", "showTitle");
        try {
            this.f94a.mo613b();
        } catch (RemoteException e) {
            Log.e("CSL.StatusBarController", "Error showing title", e);
        }
    }
}
