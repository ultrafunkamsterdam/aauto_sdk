package com.google.android.apps.auto.sdk.nav;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.apps.auto.sdk.nav.state.C0055a;
import com.google.android.apps.auto.sdk.nav.state.C0057c;
import com.google.android.apps.auto.sdk.nav.state.CarInstrumentClusterConfig;
import com.google.android.apps.auto.sdk.nav.state.TurnEvent;
import javax.annotation.concurrent.GuardedBy;

public class NavigationStateManager extends C0046e<C0057c> {
    /* access modifiers changed from: private */
    @Nullable
    @GuardedBy("this")

    /* renamed from: a */
    public C0055a f132a;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @NonNull

    /* renamed from: b */
    public CarInstrumentClusterConfig f133b = new CarInstrumentClusterConfig();

    /* renamed from: c */
    private final C0041a f134c = new C0041a();

    /* renamed from: d */
    private final C0057c f135d = new C0049h(this);

    /* renamed from: com.google.android.apps.auto.sdk.nav.NavigationStateManager$a */
    public static final class C0041a {

        /* renamed from: a */
        private long f136a = 0;

        /* renamed from: a */
        public final boolean mo440a(@Nullable TurnEvent turnEvent, @NonNull CarInstrumentClusterConfig carInstrumentClusterConfig) {
            if (turnEvent == null) {
                return false;
            }
            if (turnEvent.getTurnImage() != null) {
                if (!carInstrumentClusterConfig.supportsImages()) {
                    Log.w("NavigationStateManager", "Dropping turn event since it contains an image but the HU does not support images.");
                    return false;
                }
                new BitmapFactory.Options().inJustDecodeBounds = true;
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(turnEvent.getTurnImage(), 0, turnEvent.getTurnImage().length);
                if (decodeByteArray == null) {
                    Log.w("NavigationStateManager", "Dropping turn event since image cannot be decoded");
                    return false;
                } else if (!(decodeByteArray.getWidth() == carInstrumentClusterConfig.getImageWidth() && decodeByteArray.getHeight() == carInstrumentClusterConfig.getImageHeight())) {
                    Log.w("NavigationStateManager", "Dropping turn event since it contains an image with dimensions that do not match the head unit's configuration");
                    return false;
                }
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - this.f136a < ((long) carInstrumentClusterConfig.getMinMessageIntervalMs())) {
                Log.w("NavigationStateManager", "Rate limiting turn event message");
                return false;
            }
            this.f136a = elapsedRealtime;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ Object mo436a() {
        return this.f135d;
    }

    @NonNull
    public CarInstrumentClusterConfig getInstrumentClusterConfig() {
        CarInstrumentClusterConfig carInstrumentClusterConfig;
        synchronized (this) {
            carInstrumentClusterConfig = this.f133b;
        }
        return carInstrumentClusterConfig;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    @android.support.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendNavigationSummary(com.google.android.apps.auto.sdk.nav.state.NavigationSummary r2) throws android.os.RemoteException {
        /*
            r1 = this;
            if (r2 != 0) goto L_0x0003
        L_0x0002:
            return
        L_0x0003:
            monitor-enter(r1)
            boolean r0 = r1.mo459b()     // Catch:{ all -> 0x000c }
            if (r0 != 0) goto L_0x000f
            monitor-exit(r1)     // Catch:{ all -> 0x000c }
            goto L_0x0002
        L_0x000c:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x000c }
            throw r0
        L_0x000f:
            com.google.android.apps.auto.sdk.nav.state.a r0 = r1.f132a     // Catch:{ all -> 0x000c }
            if (r0 == 0) goto L_0x0018
            com.google.android.apps.auto.sdk.nav.state.a r0 = r1.f132a     // Catch:{ all -> 0x000c }
            r0.mo511a((com.google.android.apps.auto.sdk.nav.state.NavigationSummary) r2)     // Catch:{ all -> 0x000c }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x000c }
            goto L_0x0002
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.apps.auto.sdk.nav.NavigationStateManager.sendNavigationSummary(com.google.android.apps.auto.sdk.nav.state.NavigationSummary):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    @android.support.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendTurnEvent(com.google.android.apps.auto.sdk.nav.state.TurnEvent r3) throws android.os.RemoteException {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
        L_0x0002:
            return
        L_0x0003:
            monitor-enter(r2)
            boolean r0 = r2.mo459b()     // Catch:{ all -> 0x000c }
            if (r0 != 0) goto L_0x000f
            monitor-exit(r2)     // Catch:{ all -> 0x000c }
            goto L_0x0002
        L_0x000c:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x000c }
            throw r0
        L_0x000f:
            com.google.android.apps.auto.sdk.nav.NavigationStateManager$a r0 = r2.f134c     // Catch:{ all -> 0x000c }
            com.google.android.apps.auto.sdk.nav.state.CarInstrumentClusterConfig r1 = r2.f133b     // Catch:{ all -> 0x000c }
            boolean r0 = r0.mo440a(r3, r1)     // Catch:{ all -> 0x000c }
            if (r0 != 0) goto L_0x001b
            monitor-exit(r2)     // Catch:{ all -> 0x000c }
            goto L_0x0002
        L_0x001b:
            com.google.android.apps.auto.sdk.nav.state.a r0 = r2.f132a     // Catch:{ all -> 0x000c }
            if (r0 == 0) goto L_0x0024
            com.google.android.apps.auto.sdk.nav.state.a r0 = r2.f132a     // Catch:{ all -> 0x000c }
            r0.mo512a((com.google.android.apps.auto.sdk.nav.state.TurnEvent) r3)     // Catch:{ all -> 0x000c }
        L_0x0024:
            monitor-exit(r2)     // Catch:{ all -> 0x000c }
            goto L_0x0002
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.apps.auto.sdk.nav.NavigationStateManager.sendTurnEvent(com.google.android.apps.auto.sdk.nav.state.TurnEvent):void");
    }
}
