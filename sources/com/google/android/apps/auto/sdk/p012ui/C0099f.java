package com.google.android.apps.auto.sdk.p012ui;

import android.support.v7.widget.RecyclerView;

/* renamed from: com.google.android.apps.auto.sdk.ui.f */
final class C0099f extends RecyclerView.OnScrollListener {

    /* renamed from: a */
    private /* synthetic */ PagedListView f316a;

    C0099f(PagedListView pagedListView) {
        this.f316a = pagedListView;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (this.f316a.mOnScrollListener != null) {
            this.f316a.mOnScrollListener.onScrollStateChanged(recyclerView, i);
        }
        if (i == 0) {
            this.f316a.mHandler.postDelayed(this.f316a.mPaginationRunnable, 400);
        }
    }

    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.f316a.mOnScrollListener != null) {
            this.f316a.mOnScrollListener.onScrolled(recyclerView, i, i2);
            if (!this.f316a.mLayoutManager.isAtTop() && this.f316a.mLayoutManager.isAtBottom()) {
                this.f316a.mOnScrollListener.onReachBottom();
            } else if (this.f316a.mLayoutManager.isAtTop() || !this.f316a.mLayoutManager.isAtBottom()) {
                this.f316a.mOnScrollListener.onLeaveBottom();
            }
        }
        this.f316a.updatePaginationButtons(false);
    }
}
