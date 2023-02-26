package com.google.android.apps.auto.sdk.p012ui;

/* renamed from: com.google.android.apps.auto.sdk.ui.h */
final class C0101h implements Runnable {

    /* renamed from: a */
    private /* synthetic */ PagedListView f318a;

    C0101h(PagedListView pagedListView) {
        this.f318a = pagedListView;
    }

    public final void run() {
        this.f318a.updatePaginationButtons(true);
    }
}
