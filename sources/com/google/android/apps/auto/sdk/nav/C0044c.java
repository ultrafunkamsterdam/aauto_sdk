package com.google.android.apps.auto.sdk.nav;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.apps.auto.sdk.nav.state.C0057c;
import com.google.android.apps.auto.sdk.nav.suggestion.C0061c;

/* renamed from: com.google.android.apps.auto.sdk.nav.c */
public interface C0044c extends IInterface {
    /* renamed from: a */
    NavigationProviderConfig mo451a() throws RemoteException;

    /* renamed from: a */
    void mo452a(ClientMode clientMode) throws RemoteException;

    /* renamed from: a */
    void mo453a(NavigationClientConfig navigationClientConfig) throws RemoteException;

    /* renamed from: b */
    void mo454b() throws RemoteException;

    /* renamed from: c */
    C0057c mo455c() throws RemoteException;

    /* renamed from: d */
    C0061c mo456d() throws RemoteException;
}
