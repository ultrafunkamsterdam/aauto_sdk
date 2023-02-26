package com.google.android.apps.auto.sdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.support.annotation.AnyThread;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import java.util.List;
import java.util.Stack;

public class MenuController {
    @Nullable
    @VisibleForTesting

    /* renamed from: a */
    C0020d f53a;
    @VisibleForTesting

    /* renamed from: b */
    MenuAdapter f54b;
    @VisibleForTesting

    /* renamed from: c */
    Bundle f55c;
    @VisibleForTesting

    /* renamed from: d */
    Stack<Integer> f56d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Context f57e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final C0039m f58f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final MenuAdapterCallback f59g;

    /* renamed from: h */
    private MenuAdapter f60h;

    /* renamed from: com.google.android.apps.auto.sdk.MenuController$a */
    abstract class C0017a implements MenuAdapterCallback {
        private C0017a() {
        }

        /* synthetic */ C0017a(MenuController menuController, byte b) {
            this();
        }

        /* access modifiers changed from: package-private */
        @MainThread
        /* renamed from: a */
        public final void mo257a() {
            try {
                MenuController.this.f58f.mo369d();
            } catch (RemoteException e) {
                Log.e("CSL.MenuController", "Error showing loading indication", e);
            }
        }

        /* access modifiers changed from: package-private */
        @MainThread
        /* renamed from: a */
        public final void mo258a(MenuAdapter menuAdapter) {
            String valueOf = String.valueOf(menuAdapter);
            Log.d("CSL.MenuController", new StringBuilder(String.valueOf(valueOf).length() + 21).append("notifyDataSetChanged ").append(valueOf).toString());
            if (menuAdapter == MenuController.this.f53a.f63a) {
                try {
                    MenuController.this.f58f.mo363a();
                } catch (RemoteException e) {
                    Log.e("CSL.MenuController", "Error notifying data set changed", e);
                }
            }
        }

        public void activateAlphaJumpKeyboard(List<AlphaJumpKeyItem> list) {
            try {
                MenuController.this.f58f.mo366a(list);
            } catch (RemoteException e) {
                Log.e("CSL.MenuController", "Error activating AlphaJumpKeyboard.", e);
            }
        }

        /* access modifiers changed from: package-private */
        @MainThread
        /* renamed from: b */
        public final void mo259b() {
            try {
                MenuController.this.f58f.mo370e();
            } catch (RemoteException e) {
                Log.e("CSL.MenuController", "Error hiding loading indicator", e);
            }
        }

        public void disableAlphaJump() {
            try {
                MenuController.this.f58f.mo372g();
            } catch (RemoteException e) {
                Log.e("CSL.MenuController", "Error disabling AlphaJump.", e);
            }
        }

        public void enableAlphaJump() {
            try {
                MenuController.this.f58f.mo371f();
            } catch (RemoteException e) {
                Log.e("CSL.MenuController", "Error enabling AlphaJump.", e);
            }
        }
    }

    /* renamed from: com.google.android.apps.auto.sdk.MenuController$b */
    static final class C0018b extends MenuAdapter {
        private C0018b() {
        }

        /* synthetic */ C0018b(byte b) {
            this();
        }

        public final MenuItem getMenuItem(int i) {
            return null;
        }

        public final int getMenuItemCount() {
            return 0;
        }
    }

    /* renamed from: com.google.android.apps.auto.sdk.MenuController$c */
    final class C0019c extends C0017a {

        /* renamed from: b */
        private final Handler f62b;

        private C0019c(MenuController menuController) {
            super(menuController, (byte) 0);
            this.f62b = new Handler();
        }

        /* synthetic */ C0019c(MenuController menuController, byte b) {
            this(menuController);
        }

        @AnyThread
        public final void hideLoadingIndicator() {
            this.f62b.post(new C0025ab(this));
        }

        @AnyThread
        public final void notifyDataSetChanged(MenuAdapter menuAdapter) {
            this.f62b.post(new C0108y(this, menuAdapter));
        }

        @AnyThread
        public final void notifyItemChanged(MenuAdapter menuAdapter, int i) {
            this.f62b.post(new C0109z(this, menuAdapter, i));
        }

        @AnyThread
        public final void showLoadingIndicator() {
            this.f62b.post(new C0024aa(this));
        }
    }

    @VisibleForTesting
    /* renamed from: com.google.android.apps.auto.sdk.MenuController$d */
    final class C0020d extends C0038l {
        @VisibleForTesting
        @NonNull

        /* renamed from: a */
        MenuAdapter f63a;

        public C0020d(MenuAdapter menuAdapter) {
            this.f63a = menuAdapter;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public final void m58a(@NonNull MenuAdapter menuAdapter) {
            this.f63a.onDetach();
            boolean z = this.f63a != menuAdapter;
            this.f63a = menuAdapter;
            this.f63a.mo235a(MenuController.this.f55c);
            this.f63a.onAttach(MenuController.this.f59g);
            if (z) {
                this.f63a.notifyDataSetChanged();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public final void m61b(int i) {
            if (((long) MenuController.this.f56d.size()) >= MenuController.this.m49b()) {
                CarToast.makeText(MenuController.this.f57e, (CharSequence) String.format("Cannot have more than %s levels of submenu", new Object[]{Long.valueOf(MenuController.this.m49b())}), 1).show();
                return;
            }
            if (this.f63a.mo233a(i) == null) {
                MenuAdapter onLoadSubmenu = this.f63a.onLoadSubmenu(i);
                if (onLoadSubmenu == null) {
                    String valueOf = String.valueOf(this.f63a);
                    Log.w("CSL.MenuController", new StringBuilder(String.valueOf(valueOf).length() + 52).append(valueOf).append(" onLoadSubmenu returns null for position ").append(i).toString());
                    return;
                }
                this.f63a.mo234a(i, onLoadSubmenu);
            }
            MenuAdapter a = this.f63a.mo233a(i);
            a.mo236a(this.f63a);
            MenuAdapter menuAdapter = this.f63a;
            MenuController.this.f56d.add(Integer.valueOf(i));
            m58a(a);
        }

        /* renamed from: a */
        public final int mo260a() {
            return this.f63a.getMenuItemCount();
        }

        /* renamed from: a */
        public final MenuItem mo261a(int i) {
            MenuItem menuItem = this.f63a.getMenuItem(i);
            menuItem.mo270a(i);
            return menuItem;
        }

        /* renamed from: a */
        public final void mo262a(Bundle bundle) {
            MenuController.this.f55c = bundle;
            this.f63a.mo235a(MenuController.this.f55c);
        }

        /* renamed from: a */
        public final void mo263a(MenuItem menuItem) {
            String valueOf = String.valueOf(menuItem);
            Log.d("CSL.MenuController", new StringBuilder(String.valueOf(valueOf).length() + 14).append("onItemClicked ").append(valueOf).toString());
            int a = menuItem.mo269a();
            if (menuItem.getType() == 2) {
                m61b(a);
                return;
            }
            if (menuItem.getType() == 1) {
                mo261a(a).mo271a(menuItem.isChecked());
            }
            this.f63a.onMenuItemClicked(a);
        }

        /* renamed from: b */
        public final boolean mo264b() {
            Log.d("CSL.MenuController", "hasParent");
            return this.f63a.mo232a() != null;
        }

        /* renamed from: c */
        public final void mo265c() {
            String valueOf = String.valueOf(this.f63a.mo232a());
            Log.d("CSL.MenuController", new StringBuilder(String.valueOf(valueOf).length() + 21).append("onBackClicked parent=").append(valueOf).toString());
            if (this.f63a.mo232a() == null) {
                throw new IllegalStateException("onBackClicked when there is no parent submenu");
            }
            MenuController.this.f56d.pop();
            m58a(this.f63a.mo232a());
        }

        /* renamed from: d */
        public final void mo266d() {
        }

        /* renamed from: e */
        public final void mo267e() {
        }

        /* renamed from: f */
        public final String mo268f() {
            return this.f63a.getTitle();
        }
    }

    @VisibleForTesting
    public MenuController(Context context, C0039m mVar) {
        this(context, mVar, true);
    }

    private MenuController(Context context, C0039m mVar, boolean z) {
        this.f55c = null;
        this.f56d = new Stack<>();
        this.f57e = context;
        this.f58f = mVar;
        this.f54b = new C0018b((byte) 0);
        this.f59g = new C0019c(this, (byte) 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final long m49b() {
        if (this.f55c != null) {
            return this.f55c.getLong("max_submenu_levels", 1000);
        }
        return 1000;
    }

    @VisibleForTesting
    /* renamed from: a */
    public final void mo252a() {
        Log.d("CSL.MenuController", "onDrawerOpening");
        this.f56d.clear();
        if (this.f53a != null) {
            this.f53a.m58a(this.f60h);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo253a(Bundle bundle) {
        Log.d("CSL.MenuController", "onRestoreInstanceState");
        if (this.f53a == null) {
            Log.w("CSL.MenuController", "Root MenuAdapter is null after day/night mode Activity recreate.");
            return;
        }
        if (bundle.containsKey("com.google.android.apps.auto.sdk.MenuController.KEY_SUBMENU_PATH")) {
            int[] intArray = bundle.getIntArray("com.google.android.apps.auto.sdk.MenuController.KEY_SUBMENU_PATH");
            for (int a : intArray) {
                this.f53a.m61b(a);
            }
        }
        this.f59g.notifyDataSetChanged(this.f53a.f63a);
    }

    @UiThread
    public void hideMenuButton() {
        try {
            this.f58f.mo368c();
        } catch (RemoteException e) {
            Log.e("CSL.MenuController", "Error hide menu button", e);
        }
    }

    @UiThread
    public void setRootMenuAdapter(@Nullable MenuAdapter menuAdapter) {
        String valueOf = String.valueOf(menuAdapter);
        Log.d("CSL.MenuController", new StringBuilder(String.valueOf(valueOf).length() + 19).append("setRootMenuAdapter ").append(valueOf).toString());
        if (menuAdapter == null) {
            this.f60h = this.f54b;
        } else {
            menuAdapter.mo236a((MenuAdapter) null);
            this.f60h = menuAdapter;
        }
        if (this.f55c != null) {
            this.f60h.mo235a(this.f55c);
        }
        if (this.f53a == null) {
            this.f53a = new C0020d(this.f54b);
            try {
                this.f58f.mo365a((C0037k) this.f53a);
            } catch (RemoteException e) {
                Log.e("CSL.MenuController", "Error setting menu callbacks", e);
            }
        }
    }

    @UiThread
    public void showMenuButton() {
        try {
            this.f58f.mo367b();
        } catch (RemoteException e) {
            Log.e("CSL.MenuController", "Error showing menu button", e);
        }
    }
}
