package com.google.android.apps.auto.sdk.p012ui;

/* renamed from: com.google.android.apps.auto.sdk.ui.g */
final class C0100g implements Runnable {

    /* renamed from: a */
    private /* synthetic */ PagedListView f317a;

    C0100g(PagedListView pagedListView) {
        this.f317a = pagedListView;
    }

    public final void run() {
        boolean isUpPressed = this.f317a.f288c.isUpPressed();
        boolean isDownPressed = this.f317a.f288c.isDownPressed();
        if (isUpPressed && isDownPressed) {
            return;
        }
        if (isUpPressed) {
            this.f317a.mRecyclerView.pageUp();
        } else if (isDownPressed) {
            this.f317a.mRecyclerView.pageDown();
        }
    }
}
