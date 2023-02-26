package com.google.android.apps.auto.sdk;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.support.annotation.IdRes;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.google.android.gms.car.CarInfoManager;
import com.google.android.gms.car.input.InputManager;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class CarUiController extends C0026ac {

    /* renamed from: b */
    private StatusBarController f25b;

    /* renamed from: c */
    private DrawerController f26c;

    /* renamed from: d */
    private MenuController f27d;

    /* renamed from: e */
    private SearchController f28e;
    @IdRes

    /* renamed from: f */
    private int f29f = ((Integer) mo344a(this.f36m, new Object[0])).intValue();

    /* renamed from: g */
    private Method f30g;

    /* renamed from: h */
    private Method f31h;

    /* renamed from: i */
    private Method f32i;

    /* renamed from: j */
    private Method f33j;

    /* renamed from: k */
    private Method f34k;

    /* renamed from: l */
    private Method f35l;

    /* renamed from: m */
    private Method f36m;

    /* renamed from: n */
    private Method f37n;

    /* renamed from: o */
    private Method f38o;

    /* renamed from: p */
    private Method f39p;

    /* renamed from: q */
    private Method f40q;

    /* renamed from: r */
    private Method f41r;

    /* renamed from: s */
    private Method f42s;

    /* renamed from: t */
    private Method f43t;

    /* renamed from: u */
    private Method f44u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CarUiController(C0027ad adVar, InputManager inputManager, LayoutInflater.Factory factory, CarInfoManager.CarInfo carInfo) {
        super(adVar, "com.google.android.gearhead.appdecor.CarUiEntry", adVar.mo347b(), adVar.mo345a(), factory);
        C0088t uVar;
        C0039m nVar;
        C0031e fVar;
        C0035i jVar;
        C0065q qVar = null;
        IBinder iBinder = (IBinder) mo344a(this.f39p, new Object[0]);
        if (iBinder == null) {
            uVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.apps.auto.sdk.IStatusBarController");
            uVar = queryLocalInterface instanceof C0088t ? (C0088t) queryLocalInterface : new C0089u(iBinder);
        }
        this.f25b = new StatusBarController(uVar, carInfo);
        IBinder iBinder2 = (IBinder) mo344a(this.f41r, new Object[0]);
        if (iBinder2 == null) {
            nVar = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.apps.auto.sdk.IMenuController");
            nVar = queryLocalInterface2 instanceof C0039m ? (C0039m) queryLocalInterface2 : new C0040n(iBinder2);
        }
        this.f27d = new MenuController(adVar.mo347b(), nVar);
        IBinder iBinder3 = (IBinder) mo344a(this.f40q, new Object[0]);
        if (iBinder3 == null) {
            fVar = null;
        } else {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.apps.auto.sdk.IDrawerController");
            fVar = queryLocalInterface3 instanceof C0031e ? (C0031e) queryLocalInterface3 : new C0032f(iBinder3);
        }
        this.f26c = new DrawerController(fVar, this.f27d);
        IBinder iBinder4 = (IBinder) mo344a(this.f42s, new Object[0]);
        if (iBinder4 == null) {
            jVar = null;
        } else {
            IInterface queryLocalInterface4 = iBinder4.queryLocalInterface("com.google.android.apps.auto.sdk.IImeController");
            jVar = queryLocalInterface4 instanceof C0035i ? (C0035i) queryLocalInterface4 : new C0036j(iBinder4);
        }
        new C0102v(jVar, inputManager, this);
        IBinder iBinder5 = (IBinder) mo344a(this.f43t, new Object[0]);
        if (iBinder5 != null) {
            IInterface queryLocalInterface5 = iBinder5.queryLocalInterface("com.google.android.apps.auto.sdk.ISearchController");
            qVar = queryLocalInterface5 instanceof C0065q ? (C0065q) queryLocalInterface5 : new C0066s(iBinder5);
        }
        this.f28e = new SearchController(qVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final InputConnection mo203a(EditorInfo editorInfo) {
        return (InputConnection) mo344a(this.f44u, editorInfo);
    }

    /* renamed from: a */
    public final void mo204a() {
        mo344a(this.f30g, new Object[0]);
    }

    /* renamed from: a */
    public final void mo205a(Intent intent) {
        mo344a(this.f38o, intent);
    }

    /* renamed from: a */
    public final void mo206a(Configuration configuration) {
        mo344a(this.f35l, configuration);
    }

    /* renamed from: a */
    public final void mo207a(Bundle bundle) {
        mo344a(this.f33j, bundle);
        this.f27d.mo253a(bundle);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo208a(IBinder iBinder) {
        mo344a(this.f32i, iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo209a(Method[] methodArr) {
        Log.d("CSL.CarUiController", String.format("Initializing %s", new Object[]{this.f101a}));
        for (Method method : methodArr) {
            if (Modifier.isPublic(method.getModifiers())) {
                String name = method.getName();
                char c = 65535;
                switch (name.hashCode()) {
                    case -2094893759:
                        if (name.equals("startCarActivity")) {
                            c = 7;
                            break;
                        }
                        break;
                    case -1491459488:
                        if (name.equals("onSaveInstanceState")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1336895037:
                        if (name.equals("onStart")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1186339443:
                        if (name.equals("onRestoreInstanceState")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1012956543:
                        if (name.equals("onStop")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -369900066:
                        if (name.equals("requestXRayScan")) {
                            c = 14;
                            break;
                        }
                        break;
                    case 727922513:
                        if (name.equals("getMenuController")) {
                            c = 10;
                            break;
                        }
                        break;
                    case 808969955:
                        if (name.equals("getDrawerController")) {
                            c = 9;
                            break;
                        }
                        break;
                    case 852203143:
                        if (name.equals("getImeController")) {
                            c = 11;
                            break;
                        }
                        break;
                    case 983415097:
                        if (name.equals("getContentContainerId")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 1272509941:
                        if (name.equals("getAppLayout")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 1321081562:
                        if (name.equals("getSearchController")) {
                            c = 12;
                            break;
                        }
                        break;
                    case 1356972381:
                        if (name.equals("onConfigurationChanged")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 1861367303:
                        if (name.equals("getStatusBarController")) {
                            c = 8;
                            break;
                        }
                        break;
                    case 2060811692:
                        if (name.equals("createInputConnection")) {
                            c = 13;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.f30g = method;
                        break;
                    case 1:
                        this.f31h = method;
                        break;
                    case 2:
                        this.f33j = method;
                        break;
                    case 3:
                        this.f34k = method;
                        break;
                    case 4:
                        this.f35l = method;
                        break;
                    case 5:
                        this.f36m = method;
                        break;
                    case 6:
                        this.f37n = method;
                        break;
                    case 7:
                        this.f38o = method;
                        break;
                    case 8:
                        this.f39p = method;
                        break;
                    case 9:
                        this.f40q = method;
                        break;
                    case 10:
                        this.f41r = method;
                        break;
                    case 11:
                        this.f42s = method;
                        break;
                    case 12:
                        this.f43t = method;
                        break;
                    case 13:
                        this.f44u = method;
                        break;
                    case 14:
                        this.f32i = method;
                        break;
                    default:
                        Log.w("CSL.CarUiController", String.format("Unmapped public method %s", new Object[]{method.getName()}));
                        Log.d("CSL.CarUiController", String.format("Annotations for %s", new Object[]{method.getName()}));
                        for (Annotation annotation : method.getAnnotations()) {
                            Log.d("CSL.CarUiController", annotation.toString());
                        }
                        break;
                }
            }
        }
    }

    /* renamed from: b */
    public final void mo210b() {
        mo344a(this.f31h, new Object[0]);
    }

    /* renamed from: b */
    public final void mo211b(Bundle bundle) {
        int i = 0;
        mo344a(this.f34k, bundle);
        MenuController menuController = this.f27d;
        int[] iArr = new int[menuController.f56d.size()];
        while (true) {
            int i2 = i;
            if (i2 < menuController.f56d.size()) {
                iArr[i2] = ((Integer) menuController.f56d.get(i2)).intValue();
                i = i2 + 1;
            } else {
                bundle.putIntArray("com.google.android.apps.auto.sdk.MenuController.KEY_SUBMENU_PATH", iArr);
                return;
            }
        }
    }

    @IdRes
    /* renamed from: c */
    public final int mo212c() {
        return this.f29f;
    }

    /* renamed from: d */
    public final View mo213d() {
        return (View) mo344a(this.f37n, new Object[0]);
    }

    public DrawerController getDrawerController() {
        return this.f26c;
    }

    public MenuController getMenuController() {
        return this.f27d;
    }

    public SearchController getSearchController() {
        return this.f28e;
    }

    public StatusBarController getStatusBarController() {
        return this.f25b;
    }
}
