package com.google.android.apps.auto.sdk.nav.suggestion;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.p007a.agizmo;

/* renamed from: com.google.android.apps.auto.sdk.nav.suggestion.b */
public final class C0060b extends agizmo implements C0059a {
    C0060b(IBinder iBinder) {
        super(iBinder, "com.google.android.apps.auto.sdk.nav.suggestion.INavigationSuggestionCallback");
    }

    /* renamed from: a */
    public final void mo536a(NavigationSuggestion[] navigationSuggestionArr) throws RemoteException {
        Parcel a_ = mo162a_();
        a_.writeTypedArray(navigationSuggestionArr, 0);
        mo165c(1, a_);
    }
}
