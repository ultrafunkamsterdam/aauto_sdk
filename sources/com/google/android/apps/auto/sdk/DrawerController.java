package com.google.android.apps.auto.sdk;

import android.os.RemoteException;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.util.Log;

public class DrawerController {

    /* renamed from: a */
    private final C0031e f45a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public MenuController f46b;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: c */
    public DrawerCallback f47c;

    /* renamed from: com.google.android.apps.auto.sdk.DrawerController$a */
    final class C0016a extends C0030d {
        private C0016a() {
        }

        /* synthetic */ C0016a(DrawerController drawerController, byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo228a() {
            if (DrawerController.this.f47c != null) {
                DrawerController.this.f47c.onDrawerOpened();
            }
        }

        /* renamed from: b */
        public final void mo229b() {
            DrawerController.this.f46b.mo252a();
            if (DrawerController.this.f47c != null) {
                DrawerController.this.f47c.onDrawerOpening();
            }
        }

        /* renamed from: c */
        public final void mo230c() {
            MenuController b = DrawerController.this.f46b;
            Log.d("CSL.MenuController", "onDrawerClosed");
            b.f56d.clear();
            if (b.f53a != null) {
                b.f53a.m58a(b.f54b);
            }
            if (DrawerController.this.f47c != null) {
                DrawerController.this.f47c.onDrawerClosed();
            }
        }

        /* renamed from: d */
        public final void mo231d() {
            if (DrawerController.this.f47c != null) {
                DrawerController.this.f47c.onDrawerClosing();
            }
        }
    }

    DrawerController(C0031e eVar, MenuController menuController) {
        this.f45a = eVar;
        this.f46b = menuController;
        try {
            this.f45a.mo352a((C0029c) new C0016a(this, (byte) 0));
        } catch (RemoteException e) {
            Log.e("CSL.DrawerController", "Error setting DrawerCallbacks", e);
        }
    }

    @UiThread
    public void closeDrawer() {
        Log.d("CSL.DrawerController", "closeDrawer");
        try {
            this.f45a.mo356d();
        } catch (RemoteException e) {
            Log.e("CSL.DrawerController", "Error closing title", e);
        }
    }

    @UiThread
    public boolean isDrawerOpen() {
        Log.d("CSL.DrawerController", "isDrawerOpen");
        try {
            return this.f45a.mo353a();
        } catch (RemoteException e) {
            Log.e("CSL.DrawerController", "Error querying drawer visibility", e);
            return false;
        }
    }

    @UiThread
    public boolean isDrawerVisible() {
        Log.d("CSL.DrawerController", "isDrawerVisible");
        try {
            return this.f45a.mo354b();
        } catch (RemoteException e) {
            Log.e("CSL.DrawerController", "Error querying drawer visibility state", e);
            return false;
        }
    }

    @UiThread
    public void openDrawer() {
        Log.d("CSL.DrawerController", "openDrawer");
        try {
            this.f45a.mo355c();
        } catch (RemoteException e) {
            Log.e("CSL.DrawerController", "Error opening drawer", e);
        }
    }

    public void setDrawerCallback(DrawerCallback drawerCallback) {
        this.f47c = drawerCallback;
    }

    @UiThread
    public void setScrimColor(@ColorInt int i) {
        Log.d("CSL.DrawerController", new StringBuilder(25).append("setScrimColor ").append(i).toString());
        try {
            this.f45a.mo351a(i);
        } catch (RemoteException e) {
            Log.e("CSL.DrawerController", "Error setting scrim color", e);
        }
    }
}
