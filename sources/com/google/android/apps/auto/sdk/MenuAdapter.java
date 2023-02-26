package com.google.android.apps.auto.sdk;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import android.util.SparseArray;

public abstract class MenuAdapter {
    @Nullable
    @VisibleForTesting

    /* renamed from: a */
    MenuAdapterCallback f49a;

    /* renamed from: b */
    private final SparseArray<MenuAdapter> f50b = new SparseArray<>();
    @Nullable

    /* renamed from: c */
    private MenuAdapter f51c;
    @VisibleForTesting

    /* renamed from: d */
    private boolean f52d;
    protected Bundle mConfig;

    @Nullable
    @VisibleForTesting
    /* renamed from: a */
    public final MenuAdapter mo232a() {
        return this.f51c;
    }

    @VisibleForTesting
    @NonNull
    /* renamed from: a */
    public final MenuAdapter mo233a(int i) {
        return this.f50b.get(i);
    }

    @VisibleForTesting
    /* renamed from: a */
    public final void mo234a(int i, MenuAdapter menuAdapter) {
        this.f50b.put(i, menuAdapter);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo235a(Bundle bundle) {
        this.mConfig = bundle;
        if (Log.isLoggable("CSL.MenuAdapter", 3)) {
            String valueOf = String.valueOf(bundle);
            String valueOf2 = String.valueOf(this);
            Log.d("CSL.MenuAdapter", new StringBuilder(String.valueOf(valueOf).length() + 38 + String.valueOf(valueOf2).length()).append("recieved new config bundle ").append(valueOf).append(" in object ").append(valueOf2).toString());
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    public final void mo236a(MenuAdapter menuAdapter) {
        this.f51c = menuAdapter;
    }

    public abstract MenuItem getMenuItem(int i);

    public abstract int getMenuItemCount();

    public String getTitle() {
        return null;
    }

    @CallSuper
    public void hideLoadingIndicator() {
        if (this.f52d) {
            this.f52d = false;
            if (this.f49a != null) {
                this.f49a.hideLoadingIndicator();
            }
        }
    }

    @CallSuper
    public void notifyDataSetChanged() {
        if (this.f49a == null) {
            Log.w("CSL.MenuAdapter", "Cannot notify dataset changed because this MenuAdapter is not connected to a root menu");
            return;
        }
        this.f50b.clear();
        this.f49a.notifyDataSetChanged(this);
    }

    @CallSuper
    public void notifyItemChanged(int i) {
        if (this.f49a == null) {
            Log.w("CSL.MenuAdapter", "Cannot notify item changed because this MenuAdapter is not connected to a root menu");
            return;
        }
        this.f50b.put(i, (Object) null);
        this.f49a.notifyItemChanged(this, i);
    }

    @VisibleForTesting
    public void onAttach(MenuAdapterCallback menuAdapterCallback) {
        this.f49a = menuAdapterCallback;
        if (this.f52d) {
            showLoadingIndicator();
        }
        onEnter();
    }

    @VisibleForTesting
    public void onDetach() {
        onExit();
        if (this.f52d) {
            hideLoadingIndicator();
        }
        this.f49a = null;
    }

    public void onEnter() {
    }

    public void onExit() {
    }

    @Nullable
    public MenuAdapter onLoadSubmenu(int i) {
        return null;
    }

    public void onMenuItemClicked(int i) {
    }

    @CallSuper
    public void showLoadingIndicator() {
        if (!this.f52d) {
            this.f52d = true;
            if (this.f49a != null) {
                this.f49a.showLoadingIndicator();
            }
        }
    }
}
