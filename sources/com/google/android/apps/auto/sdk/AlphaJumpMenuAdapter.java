package com.google.android.apps.auto.sdk;

import android.support.annotation.VisibleForTesting;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AlphaJumpMenuAdapter extends MenuAdapter {
    protected static final List<Character> SUPPORTED_CHARACTER_LIST = Collections.unmodifiableList(Arrays.asList(new Character[]{'0', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'}));
    protected static final Set<Character> SUPPORTED_CHARACTER_SET = Collections.unmodifiableSet(new HashSet(SUPPORTED_CHARACTER_LIST));

    /* renamed from: b */
    private boolean f19b;

    /* renamed from: c */
    private boolean f20c;
    @VisibleForTesting
    protected final List<AlphaJumpKeyItem> mAlphaJumpKeyItemList = new ArrayList();

    public AlphaJumpMenuAdapter() {
        new ArrayList();
    }

    /* renamed from: b */
    private final void m25b() {
        boolean z;
        boolean z2;
        boolean z3;
        if (this.f49a != null) {
            boolean z4 = getMenuItemCount() >= 12;
            if (this.mConfig != null) {
                z = this.mConfig.getBoolean("touch_enabled", false);
                boolean z5 = getMenuItemCount() >= this.mConfig.getInt("minimum_menu_items_for_alpha_jump", 12);
                z3 = this.mConfig.getBoolean("alpha_jump_language_supported", false);
                z2 = z5;
            } else {
                if (Log.isLoggable("CSL.AlphaJumpMenuAdapte", 3)) {
                    Log.d("CSL.AlphaJumpMenuAdapte", "config was null");
                }
                z = false;
                z2 = z4;
                z3 = false;
            }
            boolean z6 = !this.f20c && z && z2 && z3;
            if (Log.isLoggable("CSL.AlphaJumpMenuAdapte", 3)) {
                Log.d("CSL.AlphaJumpMenuAdapte", String.format("touchEnabled %s, isLongList %s, isLanguageSupported %s, showAlphaJump %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z6)}));
            }
            if (z6) {
                this.f19b = true;
                this.f49a.enableAlphaJump();
            }
        }
    }

    public void hideLoadingIndicator() {
        super.hideLoadingIndicator();
        this.f20c = false;
        m25b();
    }

    public void notifyDataSetChanged() {
        if (this.f49a == null) {
            Log.w("CSL.AlphaJumpMenuAdapte", "Cannot notify dataset changed because this AlphaJumpMenuAdapter is not connected to a root menu");
            return;
        }
        if (this.f19b) {
            this.f49a.disableAlphaJump();
        }
        super.notifyDataSetChanged();
        m25b();
    }

    public void onAttach(MenuAdapterCallback menuAdapterCallback) {
        super.onAttach(menuAdapterCallback);
        m25b();
    }

    public void onDetach() {
        this.f19b = false;
        this.f20c = false;
        this.f49a.disableAlphaJump();
        super.onDetach();
    }

    public void showLoadingIndicator() {
        super.showLoadingIndicator();
        this.f20c = true;
    }
}
