package com.google.android.apps.auto.sdk.nav.suggestion;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.p007a.bgizmo;
import com.google.android.p007a.cgizmo;

/* renamed from: com.google.android.apps.auto.sdk.nav.suggestion.d */
public abstract class C0062d extends bgizmo implements C0061c {
    public C0062d() {
        attachInterface(this, "com.google.android.apps.auto.sdk.nav.suggestion.INavigationSuggestionManager");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        C0059a bVar;
        if (mo166a(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    bVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.apps.auto.sdk.nav.suggestion.INavigationSuggestionCallback");
                    bVar = queryLocalInterface instanceof C0059a ? (C0059a) queryLocalInterface : new C0060b(readStrongBinder);
                }
                mo465a(bVar);
                break;
            case 2:
                mo464a((NavigationSuggestion) cgizmo.m12a(parcel, NavigationSuggestion.CREATOR));
                break;
            case 3:
                mo463a();
                break;
            case 4:
                mo466b();
                break;
            case 5:
                mo467b((NavigationSuggestion) cgizmo.m12a(parcel, NavigationSuggestion.CREATOR));
                break;
            default:
                return false;
        }
        return true;
    }
}
