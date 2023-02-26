package com.google.android.apps.auto.sdk.p012ui;

import android.support.v7.widget.RecyclerView;

/* renamed from: com.google.android.apps.auto.sdk.ui.b */
final class C0095b implements RecyclerView.ItemAnimator.ItemAnimatorFinishedListener {

    /* renamed from: a */
    private /* synthetic */ C0094a f313a;

    C0095b(C0094a aVar) {
        this.f313a = aVar;
    }

    public final void onAnimationsFinished() {
        this.f313a.f311a.offsetRows();
    }
}
