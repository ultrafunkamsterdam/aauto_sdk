package com.google.android.apps.auto.sdk.p012ui;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;

/* renamed from: com.google.android.apps.auto.sdk.ui.a */
public final class C0094a extends DefaultItemAnimator {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final CarLayoutManager f311a;

    /* renamed from: b */
    private final RecyclerView.ItemAnimator.ItemAnimatorFinishedListener f312b = new C0095b(this);

    public C0094a(CarLayoutManager carLayoutManager) {
        this.f311a = carLayoutManager;
    }

    public final boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        float f = 0.0f;
        if (viewHolder2 != null) {
            f = viewHolder2.itemView.getAlpha();
        }
        boolean animateChange = C0094a.super.animateChange(viewHolder, viewHolder2, i, i2, i3, i4);
        if (viewHolder2 != null) {
            viewHolder2.itemView.setAlpha(f);
        }
        return animateChange;
    }

    public final void onMoveFinished(RecyclerView.ViewHolder viewHolder) {
        isRunning(this.f312b);
    }
}
