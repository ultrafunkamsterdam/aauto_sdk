package com.google.android.apps.auto.sdk.p012ui;

import android.util.Log;
import com.google.android.apps.auto.sdk.p012ui.PagedScrollBarView;

/* renamed from: com.google.android.apps.auto.sdk.ui.e */
final class C0098e implements PagedScrollBarView.PaginationListener {

    /* renamed from: a */
    private /* synthetic */ PagedListView f315a;

    C0098e(PagedListView pagedListView) {
        this.f315a = pagedListView;
    }

    public final void onPaginate(int i) {
        if (i == 0) {
            this.f315a.mRecyclerView.pageUp();
            if (this.f315a.mOnScrollListener != null) {
                this.f315a.mOnScrollListener.onScrollUpButtonClicked();
            }
        } else if (i == 1) {
            this.f315a.mRecyclerView.pageDown();
            if (this.f315a.mOnScrollListener != null) {
                this.f315a.mOnScrollListener.onScrollDownButtonClicked();
            }
        } else {
            Log.e("PagedListView", new StringBuilder(42).append("Unknown pagination direction (").append(i).append(")").toString());
        }
    }
}
