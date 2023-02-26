package com.google.android.gms.car;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.google.android.gms.car.input.InputManager;
import com.google.android.gms.common.internal.Hide;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public interface CarActivityHost {

    public interface HostedCarActivity {
        void attach(CarActivityHost carActivityHost);

        void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        void onAccessibilityScanRequested(IBinder iBinder);

        void onConfigurationChanged(Configuration configuration);

        void onCreate(Bundle bundle);

        void onDestroy();

        @Hide
        void onFrameRateChange(int i);

        boolean onKeyDown(int i, KeyEvent keyEvent);

        boolean onKeyLongPress(int i, KeyEvent keyEvent);

        boolean onKeyUp(int i, KeyEvent keyEvent);

        void onLowMemory();

        void onNewIntent(Intent intent);

        void onPause();

        void onPostResume();

        @Hide
        void onPowerStateChange(int i);

        void onRestoreInstanceState(Bundle bundle);

        void onResume();

        Object onRetainNonConfigurationInstance();

        void onSaveInstanceState(Bundle bundle);

        void onStart();

        void onStop();

        void onWindowFocusChanged(boolean z, boolean z2);

        void setContext(Context context);
    }

    @Hide
    void enableWindowTransparency();

    View findViewById(int i);

    void finish();

    Object getCarActivityService();

    @Nullable
    Object getCarManager(String str) throws CarNotSupportedException, CarNotConnectedException;

    InputManager getInputManager();

    Intent getIntent();

    LayoutInflater getLayoutInflater();

    @Hide
    int getMaxFrameRate();

    Object getNonConfigurationInstance();

    @Hide
    int getPowerState();

    Window getWindow();

    boolean hasWindowFocus();

    boolean isFinishing();

    @Hide
    boolean isStopped();

    void onRestoreInstanceState(Bundle bundle);

    void onSaveInstanceState(Bundle bundle);

    void setContentView(int i);

    void setContentView(View view);

    void setContentView(View view, ViewGroup.LayoutParams layoutParams);

    void setIgnoreConfigChanges(int i);

    void setIntent(Intent intent);

    void startCarProjectionActivity(Intent intent) throws CarNotConnectedException;
}
