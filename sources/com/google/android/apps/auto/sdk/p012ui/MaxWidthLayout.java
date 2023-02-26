package com.google.android.apps.auto.sdk.p012ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* renamed from: com.google.android.apps.auto.sdk.ui.MaxWidthLayout */
public class MaxWidthLayout extends FrameLayout {

    /* renamed from: a */
    private int f285a;

    public MaxWidthLayout(Context context) {
        super(context);
        m343a(context.obtainStyledAttributes(R.styleable.MaxWidthLayout));
    }

    public MaxWidthLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m343a(context.obtainStyledAttributes(attributeSet, R.styleable.MaxWidthLayout));
    }

    public MaxWidthLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m343a(context.obtainStyledAttributes(attributeSet, R.styleable.MaxWidthLayout, i, 0));
    }

    /* renamed from: a */
    private final void m343a(TypedArray typedArray) {
        this.f285a = typedArray.getDimensionPixelSize(R.styleable.MaxWidthLayout_carMaxWidth, 0);
        typedArray.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f285a != 0) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                if (childAt.getVisibility() != 8) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.width == -1 && childAt.getMeasuredWidth() > this.f285a) {
                        childAt.measure(View.MeasureSpec.makeMeasureSpec((this.f285a - layoutParams.leftMargin) - layoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                    }
                }
            }
        }
    }
}
