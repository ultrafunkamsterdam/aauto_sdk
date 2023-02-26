package com.google.android.apps.auto.sdk.service.p008a;

import android.support.annotation.VisibleForTesting;
import android.support.car.CarAppFocusManager;
import android.util.ArrayMap;
import android.util.SparseArray;
import com.google.android.gms.car.CarMessageManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@VisibleForTesting
/* renamed from: com.google.android.apps.auto.sdk.service.a.b */
public final class C0073b implements CarMessageManager.CarMessageListener {

    /* renamed from: a */
    private SparseArray<List<CarAppFocusManager.OnAppFocusChangedListener>> f209a = new SparseArray<>();

    /* renamed from: b */
    private Map<Integer, CarAppFocusManager.OnAppFocusOwnershipCallback> f210b = new ArrayMap();

    /* renamed from: c */
    private C0070a f211c;

    C0073b(C0070a aVar) {
        this.f211c = aVar;
    }

    /* renamed from: a */
    public final CarAppFocusManager.OnAppFocusOwnershipCallback mo578a(int i) {
        CarAppFocusManager.OnAppFocusOwnershipCallback onAppFocusOwnershipCallback;
        synchronized (this) {
            onAppFocusOwnershipCallback = this.f210b.get(Integer.valueOf(i));
        }
        return onAppFocusOwnershipCallback;
    }

    /* renamed from: a */
    public final Set<Integer> mo579a(CarAppFocusManager.OnAppFocusOwnershipCallback onAppFocusOwnershipCallback) {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet();
            for (Integer num : new HashSet(this.f210b.keySet())) {
                if (mo585b(num.intValue(), onAppFocusOwnershipCallback)) {
                    hashSet.add(num);
                }
            }
        }
        return hashSet;
    }

    /* renamed from: a */
    public final void mo580a(int i, CarAppFocusManager.OnAppFocusChangedListener onAppFocusChangedListener) {
        synchronized (this) {
            List list = this.f209a.get(i);
            if (list != null) {
                list.remove(onAppFocusChangedListener);
            }
        }
    }

    /* renamed from: a */
    public final void mo581a(int i, CarAppFocusManager.OnAppFocusOwnershipCallback onAppFocusOwnershipCallback) {
        synchronized (this) {
            this.f210b.put(Integer.valueOf(i), onAppFocusOwnershipCallback);
        }
    }

    /* renamed from: a */
    public final void mo582a(CarAppFocusManager.OnAppFocusChangedListener onAppFocusChangedListener) {
        synchronized (this) {
            mo580a(1, onAppFocusChangedListener);
            mo580a(0, onAppFocusChangedListener);
        }
    }

    /* renamed from: a */
    public final boolean mo583a(CarAppFocusManager.OnAppFocusOwnershipCallback onAppFocusOwnershipCallback, int i) {
        boolean z;
        synchronized (this) {
            z = onAppFocusOwnershipCallback == mo578a(i);
        }
        return z;
    }

    /* renamed from: b */
    public final void mo584b(int i, CarAppFocusManager.OnAppFocusChangedListener onAppFocusChangedListener) {
        synchronized (this) {
            List list = this.f209a.get(i);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(onAppFocusChangedListener);
                this.f209a.put(i, arrayList);
            } else if (!list.contains(onAppFocusChangedListener)) {
                list.add(onAppFocusChangedListener);
            }
        }
    }

    /* renamed from: b */
    public final boolean mo585b(int i, CarAppFocusManager.OnAppFocusOwnershipCallback onAppFocusOwnershipCallback) {
        boolean z;
        synchronized (this) {
            if (this.f210b.get(Integer.valueOf(i)) == onAppFocusOwnershipCallback) {
                this.f210b.remove(Integer.valueOf(i));
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        if (r8 == 1) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        if (r8 != 1) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onIntegerMessage(int r6, int r7, int r8) {
        /*
            r5 = this;
            r2 = 1
            r1 = 0
            monitor-enter(r5)
            android.util.SparseArray<java.util.List<android.support.car.CarAppFocusManager$OnAppFocusChangedListener>> r0 = r5.f209a     // Catch:{ all -> 0x0030 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0030 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x003a
            boolean r3 = r0.isEmpty()     // Catch:{ all -> 0x0030 }
            if (r3 != 0) goto L_0x003a
            switch(r6) {
                case 0: goto L_0x0037;
                case 1: goto L_0x0033;
                default: goto L_0x0016;
            }     // Catch:{ all -> 0x0030 }
        L_0x0016:
            int r2 = com.google.android.apps.auto.sdk.service.p008a.C0070a.m276a(r6)     // Catch:{ all -> 0x0030 }
            java.util.Iterator r3 = r0.iterator()     // Catch:{ all -> 0x0030 }
        L_0x001e:
            boolean r0 = r3.hasNext()     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x003a
            java.lang.Object r0 = r3.next()     // Catch:{ all -> 0x0030 }
            android.support.car.CarAppFocusManager$OnAppFocusChangedListener r0 = (android.support.car.CarAppFocusManager.OnAppFocusChangedListener) r0     // Catch:{ all -> 0x0030 }
            com.google.android.apps.auto.sdk.service.a.a r4 = r5.f211c     // Catch:{ all -> 0x0030 }
            r0.onAppFocusChanged(r4, r2, r1)     // Catch:{ all -> 0x0030 }
            goto L_0x001e
        L_0x0030:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L_0x0033:
            if (r8 != r2) goto L_0x0016
        L_0x0035:
            r1 = r2
            goto L_0x0016
        L_0x0037:
            if (r8 == r2) goto L_0x0035
            goto L_0x0016
        L_0x003a:
            monitor-exit(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.apps.auto.sdk.service.p008a.C0073b.onIntegerMessage(int, int, int):void");
    }

    public final void onOwnershipLost(int i) {
        synchronized (this) {
            CarAppFocusManager.OnAppFocusOwnershipCallback a = mo578a(i);
            if (a != null) {
                a.onAppFocusOwnershipLost(this.f211c, C0070a.m276a(i));
                this.f210b.remove(Integer.valueOf(i));
            }
        }
    }
}
