package com.google.android.gms.car;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.car.CarActivityServiceProxy;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: com.google.android.gms.car.d */
public abstract class C0113d extends Service implements CarActivityServiceProxy.ServiceCallbacks {

    /* renamed from: a */
    private CarActivityServiceProxy f362a;

    /* access modifiers changed from: protected */
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f362a.dump(fileDescriptor, printWriter, strArr);
    }

    public abstract Class<? extends C0112c> getCarActivity();

    public int getHandledConfigChanges() {
        return 0;
    }

    public IBinder onBind(Intent intent) {
        return this.f362a.onBind(intent);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f362a.onConfigurationChanged(configuration);
    }

    public void onCreate() {
        super.onCreate();
        if (this.f362a == null) {
            try {
                this.f362a = new C0110a().mo976a(this);
            } catch (C0111b e) {
                Log.e("CAR.PROJECTION", "Error loading car activity host", e);
                throw new RuntimeException(e);
            }
        }
        this.f362a.onCreate(this, this);
    }

    public void onDestroy() {
        this.f362a.onDestroy();
        super.onDestroy();
    }

    public void onLowMemory() {
        this.f362a.onLowMemory();
    }

    public boolean onUnbind(Intent intent) {
        return this.f362a.onUnbind(intent);
    }
}
