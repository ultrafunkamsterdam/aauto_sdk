package com.google.android.gms.car;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.google.android.gms.car.CarActivityHost;
import com.google.android.gms.common.internal.Hide;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public interface CarActivityServiceProxy {

    public interface ServiceCallbacks {
        Class<? extends CarActivityHost.HostedCarActivity> getCarActivity();

        int getHandledConfigChanges();
    }

    void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    Object getActivityInstance();

    IBinder onBind(Intent intent);

    void onConfigurationChanged(Configuration configuration);

    void onCreate(Service service, ServiceCallbacks serviceCallbacks);

    void onDestroy();

    void onLowMemory();

    boolean onUnbind(Intent intent);

    @Hide
    void relinquishVideoFocus();

    @Hide
    void requestVideoFocus();

    @Hide
    void setCrashReportingEnabled(boolean z);
}
