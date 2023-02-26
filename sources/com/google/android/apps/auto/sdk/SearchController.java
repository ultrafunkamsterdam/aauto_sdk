package com.google.android.apps.auto.sdk;

import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import java.util.List;

public class SearchController {

    /* renamed from: a */
    private final C0065q f82a;

    /* renamed from: b */
    private C0022a f83b;

    /* renamed from: com.google.android.apps.auto.sdk.SearchController$a */
    static final class C0022a extends C0064p {
        @Nullable

        /* renamed from: a */
        private SearchCallback f84a;

        private C0022a() {
        }

        /* synthetic */ C0022a(byte b) {
            this();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public final void m87a(SearchCallback searchCallback) {
            this.f84a = searchCallback;
        }

        /* renamed from: a */
        public final void mo300a() {
            if (this.f84a != null) {
                this.f84a.onSearchStart();
            }
        }

        /* renamed from: a */
        public final void mo301a(SearchItem searchItem) {
            if (this.f84a != null) {
                this.f84a.onSearchItemSelected(searchItem);
            }
        }

        /* renamed from: a */
        public final void mo302a(String str) {
            if (this.f84a != null) {
                this.f84a.onSearchTextChanged(str);
            }
        }

        /* renamed from: b */
        public final void mo303b() {
            if (this.f84a != null) {
                this.f84a.onSearchStop();
            }
        }

        /* renamed from: b */
        public final boolean mo304b(String str) {
            if (this.f84a != null) {
                return this.f84a.onSearchSubmitted(str);
            }
            return false;
        }
    }

    SearchController(C0065q qVar) {
        this.f82a = qVar;
    }

    public void hideSearchBox() {
        Log.d("CSL.SearchController", "hideSearchBox");
        if (this.f83b == null) {
            throw new IllegalStateException("No SearchCallback is set");
        }
        try {
            this.f82a.mo565b();
        } catch (RemoteException e) {
            Log.e("CSL.SearchController", "Error disabling search box", e);
        }
    }

    public void setSearchCallback(@Nullable SearchCallback searchCallback) {
        String valueOf = String.valueOf(searchCallback);
        Log.d("CSL.SearchController", new StringBuilder(String.valueOf(valueOf).length() + 18).append("setSearchCallback ").append(valueOf).toString());
        if (this.f83b == null) {
            this.f83b = new C0022a((byte) 0);
            try {
                this.f82a.mo561a((C0063o) this.f83b);
            } catch (RemoteException e) {
                Log.e("CSL.SearchController", "Error setting SearchCallback", e);
            }
        }
        this.f83b.m87a(searchCallback);
    }

    public void setSearchHint(@Nullable CharSequence charSequence) {
        String valueOf = String.valueOf(charSequence);
        Log.d("CSL.SearchController", new StringBuilder(String.valueOf(valueOf).length() + 14).append("setSearchHint ").append(valueOf).toString());
        try {
            this.f82a.mo562a(charSequence);
        } catch (RemoteException e) {
            Log.e("CSL.SearchController", "Error setting search hint", e);
        }
    }

    public void setSearchItems(List<SearchItem> list) {
        String valueOf = String.valueOf(list);
        Log.d("CSL.SearchController", new StringBuilder(String.valueOf(valueOf).length() + 15).append("setSearchItems ").append(valueOf).toString());
        if (list == null) {
            throw new IllegalArgumentException("SearchItems cannot be null.");
        }
        try {
            this.f82a.mo564a(list);
        } catch (RemoteException e) {
            Log.e("CSL.SearchController", "Error setting search items", e);
        }
    }

    public void showSearchBox() {
        Log.d("CSL.SearchController", "showSearchBox");
        if (this.f83b == null) {
            throw new IllegalStateException("No SearchCallback is set");
        }
        try {
            this.f82a.mo560a();
        } catch (RemoteException e) {
            Log.e("CSL.SearchController", "Error enabling search box", e);
        }
    }

    public void startSearch(String str) {
        Log.d("CSL.SearchController", "startSearch");
        if (this.f83b == null) {
            throw new IllegalStateException("No SearchCallback is set");
        }
        try {
            this.f82a.mo563a(str);
        } catch (RemoteException e) {
            Log.e("CSL.SearchController", "Error start search", e);
        }
    }

    public void stopSearch() {
        Log.d("CSL.SearchController", "stopSearch");
        if (this.f83b == null) {
            throw new IllegalStateException("No SearchCallback is set");
        }
        try {
            this.f82a.mo566c();
        } catch (RemoteException e) {
            Log.e("CSL.SearchController", "Error stopping search", e);
        }
    }
}
