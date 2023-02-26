package com.google.android.apps.auto.sdk.service.p008a;

import android.support.annotation.VisibleForTesting;
import android.support.car.CarAppFocusManager;
import android.util.Log;
import com.google.android.gms.car.CarMessageManager;
import com.google.android.gms.car.CarNotConnectedException;

/* renamed from: com.google.android.apps.auto.sdk.service.a.a */
public final class C0070a extends CarAppFocusManager {

    /* renamed from: a */
    private CarMessageManager f203a;
    @VisibleForTesting

    /* renamed from: b */
    private C0073b f204b = new C0073b(this);

    public C0070a(CarMessageManager carMessageManager) {
        this.f203a = carMessageManager;
        this.f203a.registerMessageListener(this.f204b);
    }

    /* renamed from: a */
    protected static int m276a(int i) {
        switch (i) {
            case 0:
                return 2;
            case 1:
                return 1;
            default:
                Log.d("CarAppFocusManagerGms", new StringBuilder(28).append("Unknown category ").append(i).toString());
                throw new IllegalArgumentException("invalid category type");
        }
    }

    /* renamed from: a */
    private final void m277a(int i, boolean z) throws CarNotConnectedException {
        int i2 = 1;
        CarMessageManager carMessageManager = this.f203a;
        switch (i) {
            case 0:
            case 1:
                switch (i) {
                    case 0:
                        if (!z) {
                            i2 = 2;
                            break;
                        }
                        break;
                    case 1:
                        if (!z) {
                            i2 = 0;
                            break;
                        }
                        break;
                    default:
                        Log.d("CarAppFocusManagerGms", new StringBuilder(28).append("Unknown category ").append(i).toString());
                        throw new IllegalArgumentException("invalid category");
                }
                carMessageManager.sendIntegerMessage(i, 0, i2);
                return;
            default:
                Log.d("CarAppFocusManagerGms", new StringBuilder(27).append("Unknown appType ").append(i).toString());
                throw new IllegalArgumentException("invalid category");
        }
    }

    /* renamed from: b */
    private static int m278b(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 0;
            default:
                Log.d("CarAppFocusManagerGms", new StringBuilder(27).append("Unknown appType ").append(i).toString());
                throw new IllegalArgumentException("invalid app type");
        }
    }

    public final void abandonAppFocus(CarAppFocusManager.OnAppFocusOwnershipCallback onAppFocusOwnershipCallback) {
        synchronized (this.f204b) {
            for (Integer next : this.f204b.mo579a(onAppFocusOwnershipCallback)) {
                try {
                    m277a(next.intValue(), false);
                    this.f203a.releaseCategory(next.intValue());
                } catch (CarNotConnectedException e) {
                    Log.d("CarAppFocusManagerGms", "Abandoned app focus but car is not connected", e);
                } catch (IllegalStateException e2) {
                    Log.d("CarAppFocusManagerGms", "Abandoned app focus but caller isn't the owner.  Ignoring.", e2);
                }
            }
        }
    }

    public final void abandonAppFocus(CarAppFocusManager.OnAppFocusOwnershipCallback onAppFocusOwnershipCallback, int i) {
        int b = m278b(i);
        synchronized (this.f204b) {
            if (this.f204b.mo578a(b) == onAppFocusOwnershipCallback) {
                this.f204b.mo585b(b, onAppFocusOwnershipCallback);
                try {
                    m277a(b, false);
                    this.f203a.releaseCategory(b);
                } catch (CarNotConnectedException e) {
                    Log.d("CarAppFocusManagerGms", "Abandoned app focus but car is not connected", e);
                } catch (IllegalStateException e2) {
                    Log.d("CarAppFocusManagerGms", "Abandoned app focus but caller isn't the owner.  Ignoring.", e2);
                }
            }
        }
        return;
    }

    public final void addFocusListener(CarAppFocusManager.OnAppFocusChangedListener onAppFocusChangedListener, int i) throws android.support.car.CarNotConnectedException {
        this.f204b.mo584b(m278b(i), onAppFocusChangedListener);
    }

    public final boolean isOwningFocus(int i, CarAppFocusManager.OnAppFocusOwnershipCallback onAppFocusOwnershipCallback) throws android.support.car.CarNotConnectedException {
        return this.f204b.mo583a(onAppFocusOwnershipCallback, m278b(i));
    }

    public final void onCarDisconnected() {
    }

    public final void removeFocusListener(CarAppFocusManager.OnAppFocusChangedListener onAppFocusChangedListener) {
        this.f204b.mo582a(onAppFocusChangedListener);
    }

    public final void removeFocusListener(CarAppFocusManager.OnAppFocusChangedListener onAppFocusChangedListener, int i) {
        this.f204b.mo580a(m278b(i), onAppFocusChangedListener);
    }

    public final int requestAppFocus(int i, CarAppFocusManager.OnAppFocusOwnershipCallback onAppFocusOwnershipCallback) throws IllegalStateException, SecurityException, android.support.car.CarNotConnectedException {
        int i2 = 1;
        if (onAppFocusOwnershipCallback == null) {
            throw new IllegalArgumentException("null listener");
        }
        synchronized (this.f204b) {
            int b = m278b(i);
            CarAppFocusManager.OnAppFocusOwnershipCallback a = this.f204b.mo578a(b);
            if (a != onAppFocusOwnershipCallback) {
                if (a != null) {
                    a.onAppFocusOwnershipLost(this, i);
                    this.f204b.mo581a(b, onAppFocusOwnershipCallback);
                } else {
                    try {
                        boolean acquireCategory = this.f203a.acquireCategory(b);
                        if (acquireCategory) {
                            this.f204b.mo581a(b, onAppFocusOwnershipCallback);
                            m277a(b, true);
                            onAppFocusOwnershipCallback.onAppFocusOwnershipGranted(this, i);
                        }
                        if (!acquireCategory) {
                            i2 = 0;
                        }
                    } catch (CarNotConnectedException e) {
                        throw new android.support.car.CarNotConnectedException((Exception) e);
                    }
                }
            }
        }
        return i2;
    }
}
