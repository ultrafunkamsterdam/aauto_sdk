package com.google.android.apps.auto.sdk.nav;

import android.os.RemoteException;
import com.google.android.apps.auto.sdk.nav.suggestion.C0059a;
import com.google.android.apps.auto.sdk.nav.suggestion.C0062d;
import com.google.android.apps.auto.sdk.nav.suggestion.NavigationSuggestion;

/* renamed from: com.google.android.apps.auto.sdk.nav.i */
final class C0050i extends C0062d {

    /* renamed from: a */
    final /* synthetic */ NavigationSuggestionManager f149a;

    C0050i(NavigationSuggestionManager navigationSuggestionManager) {
        this.f149a = navigationSuggestionManager;
    }

    /* renamed from: a */
    public final void mo463a() {
        this.f149a.f137a.mo448a(new C0053l(this));
    }

    /* renamed from: a */
    public final void mo464a(NavigationSuggestion navigationSuggestion) throws RemoteException {
        this.f149a.f137a.mo448a(new C0051j(this, navigationSuggestion));
    }

    /* renamed from: a */
    public final void mo465a(C0059a aVar) throws RemoteException {
        synchronized (this.f149a) {
            C0059a unused = this.f149a.f138b = aVar;
        }
    }

    /* renamed from: b */
    public final void mo466b() {
        this.f149a.f137a.mo448a(new C0054m(this));
    }

    /* renamed from: b */
    public final void mo467b(NavigationSuggestion navigationSuggestion) throws RemoteException {
        this.f149a.f137a.mo448a(new C0052k(this, navigationSuggestion));
    }
}
