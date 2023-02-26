package com.google.android.apps.auto.sdk;

import java.util.List;

public interface MenuAdapterCallback {
    void activateAlphaJumpKeyboard(List<AlphaJumpKeyItem> list);

    void disableAlphaJump();

    void enableAlphaJump();

    void hideLoadingIndicator();

    void notifyDataSetChanged(MenuAdapter menuAdapter);

    void notifyItemChanged(MenuAdapter menuAdapter, int i);

    void showLoadingIndicator();
}
