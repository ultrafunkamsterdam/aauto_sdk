package com.google.android.apps.auto.sdk.nav;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.apps.auto.sdk.nav.state.C0057c;
import com.google.android.apps.auto.sdk.nav.suggestion.C0061c;
import com.google.android.p007a.bgizmo;
import com.google.android.p007a.cgizmo;
import java.util.ArrayList;

/* renamed from: com.google.android.apps.auto.sdk.nav.d */
public class C0045d extends bgizmo implements C0044c {

    /* renamed from: a */
    final /* synthetic */ NavigationProviderService f143a;

    public C0045d() {
        attachInterface(this, "com.google.android.apps.auto.sdk.nav.INavigationProvider");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    C0045d(NavigationProviderService navigationProviderService) {
        this();
        this.f143a = navigationProviderService;
    }

    /* renamed from: a */
    private <T> T m185a(C0046e<T> eVar) {
        if (eVar != null && m186e()) {
            return eVar.mo436a();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        return false;
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m186e() {
        /*
            r3 = this;
            com.google.android.apps.auto.sdk.nav.NavigationProviderService r1 = r3.f143a
            monitor-enter(r1)
            com.google.android.apps.auto.sdk.nav.NavigationProviderService r0 = r3.f143a     // Catch:{ all -> 0x0021 }
            com.google.android.apps.auto.sdk.nav.NavigationClientConfig r0 = r0.f129a     // Catch:{ all -> 0x0021 }
            if (r0 != 0) goto L_0x001e
            java.lang.String r0 = "GH.NavProviderService"
            r2 = 5
            boolean r0 = android.util.Log.isLoggable(r0, r2)     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x001b
            java.lang.String r0 = "GH.NavProviderService"
            java.lang.String r2 = "Navigation client is not yet registered. Call registerClient() first"
            android.util.Log.w(r0, r2)     // Catch:{ all -> 0x0021 }
        L_0x001b:
            monitor-exit(r1)     // Catch:{ all -> 0x0021 }
            r0 = 0
        L_0x001d:
            return r0
        L_0x001e:
            monitor-exit(r1)     // Catch:{ all -> 0x0021 }
            r0 = 1
            goto L_0x001d
        L_0x0021:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0021 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.apps.auto.sdk.nav.C0045d.m186e():boolean");
    }

    /* renamed from: a */
    public NavigationProviderConfig mo451a() throws RemoteException {
        return new NavigationProviderConfig(this.f143a.getMinSupportedVersion(), this.f143a.getMaxSupportedVersion());
    }

    /* renamed from: a */
    public void mo452a(ClientMode clientMode) throws RemoteException {
        if (m186e()) {
            this.f143a.f130b.mo448a(new C0047f(this, clientMode));
        }
    }

    /* renamed from: a */
    public void mo453a(NavigationClientConfig navigationClientConfig) throws RemoteException {
        synchronized (this.f143a) {
            NavigationClientConfig unused = this.f143a.f129a = navigationClientConfig;
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f143a.getNavigationStateManager());
            arrayList.add(this.f143a.getNavigationSuggestionManager());
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                C0046e eVar = (C0046e) obj;
                if (eVar != null) {
                    eVar.mo458a(navigationClientConfig);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo454b() throws RemoteException {
        if (m186e()) {
            this.f143a.f130b.mo448a(new C0048g(this));
        }
    }

    /* renamed from: c */
    public C0057c mo455c() throws RemoteException {
        return (C0057c) m185a(this.f143a.getNavigationStateManager());
    }

    /* renamed from: d */
    public C0061c mo456d() throws RemoteException {
        return (C0061c) m185a(this.f143a.getNavigationSuggestionManager());
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (mo166a(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                NavigationProviderConfig a = mo451a();
                parcel2.writeNoException();
                cgizmo.m18b(parcel2, a);
                break;
            case 2:
                mo453a((NavigationClientConfig) cgizmo.m12a(parcel, NavigationClientConfig.CREATOR));
                parcel2.writeNoException();
                break;
            case 3:
                mo452a((ClientMode) cgizmo.m12a(parcel, ClientMode.CREATOR));
                break;
            case 4:
                mo454b();
                parcel2.writeNoException();
                break;
            case 5:
                C0057c c = mo455c();
                parcel2.writeNoException();
                cgizmo.m13a(parcel2, (IInterface) c);
                break;
            case 6:
                C0061c d = mo456d();
                parcel2.writeNoException();
                cgizmo.m13a(parcel2, (IInterface) d);
                break;
            default:
                return false;
        }
        return true;
    }
}
