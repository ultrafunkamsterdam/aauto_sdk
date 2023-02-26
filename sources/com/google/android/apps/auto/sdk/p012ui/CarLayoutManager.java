package com.google.android.apps.auto.sdk.p012ui;

import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import com.google.android.apps.auto.sdk.p012ui.PagedListView;
import java.util.ArrayList;

/* renamed from: com.google.android.apps.auto.sdk.ui.CarLayoutManager */
public class CarLayoutManager extends RecyclerView.LayoutManager {
    public static final int ROW_OFFSET_MODE_INDIVIDUAL = 0;
    public static final int ROW_OFFSET_MODE_PAGE = 1;

    /* renamed from: a */
    private final AccelerateInterpolator f235a = new AccelerateInterpolator(2.0f);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f236b;

    /* renamed from: c */
    private boolean f237c = false;

    /* renamed from: d */
    private int f238d = 1;

    /* renamed from: e */
    private int f239e = 0;

    /* renamed from: f */
    private C0090a f240f;

    /* renamed from: g */
    private PagedListView.OnScrollListener f241g;

    /* renamed from: h */
    private int f242h = 0;

    /* renamed from: i */
    private boolean f243i;

    /* renamed from: j */
    private int f244j = 0;

    /* renamed from: k */
    private int f245k = -1;

    /* renamed from: l */
    private int f246l = -1;

    /* renamed from: m */
    private int f247m = -1;

    /* renamed from: n */
    private int f248n = -1;

    /* renamed from: o */
    private int f249o = 1;

    /* renamed from: p */
    private int f250p = 0;

    /* renamed from: q */
    private LruCache<View, C0091b> f251q;

    /* renamed from: r */
    private int f252r = -1;

    /* renamed from: com.google.android.apps.auto.sdk.ui.CarLayoutManager$a */
    final class C0090a extends LinearSmoothScroller {

        /* renamed from: a */
        private final Interpolator f253a = new DecelerateInterpolator(1.8f);

        /* renamed from: b */
        private final boolean f254b;

        /* renamed from: c */
        private final int f255c;

        public C0090a(Context context, int i) {
            super(context);
            this.f255c = i;
            this.f254b = CarLayoutManager.this.f236b.getResources().getBoolean(R.bool.car_true_for_touch);
        }

        /* access modifiers changed from: protected */
        public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 150.0f / ((float) displayMetrics.densityDpi);
        }

        /* access modifiers changed from: protected */
        public final int calculateTimeForDeceleration(int i) {
            int ceil = (int) Math.ceil((double) (((float) calculateTimeForScrolling(i)) / 0.45f));
            return this.f254b ? ceil : Math.min(ceil, 1000);
        }

        public final PointF computeScrollVectorForPosition(int i) {
            if (getChildCount() == 0) {
                return null;
            }
            return new PointF(0.0f, (float) (this.f255c < CarLayoutManager.this.getPosition(CarLayoutManager.this.getChildAt(CarLayoutManager.this.getFirstFullyVisibleChildIndex())) ? -1 : 1));
        }

        public final int getTargetPosition() {
            return this.f255c;
        }

        /* access modifiers changed from: protected */
        public final int getVerticalSnapPreference() {
            return -1;
        }

        /* access modifiers changed from: protected */
        public final void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            int calculateDyToMakeVisible = calculateDyToMakeVisible(view, -1);
            if (calculateDyToMakeVisible != 0) {
                int calculateTimeForDeceleration = calculateTimeForDeceleration(calculateDyToMakeVisible);
                if (calculateTimeForDeceleration > 0) {
                    action.update(0, -calculateDyToMakeVisible, calculateTimeForDeceleration, this.f253a);
                }
            } else if (Log.isLoggable("CarLayoutManager", 3)) {
                Log.d("CarLayoutManager", "Scroll distance is 0");
            }
        }
    }

    /* renamed from: com.google.android.apps.auto.sdk.ui.CarLayoutManager$b */
    static final class C0091b extends Animation {

        /* renamed from: a */
        public float f257a;

        private C0091b() {
        }

        /* synthetic */ C0091b(byte b) {
            this();
        }

        /* access modifiers changed from: protected */
        public final void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            transformation.getMatrix().setTranslate(0.0f, this.f257a);
        }
    }

    public CarLayoutManager(Context context) {
        this.f236b = context;
    }

    @VisibleForTesting
    /* renamed from: a */
    private int m330a(int i) {
        if (i == -1) {
            return -1;
        }
        View findViewByPosition = findViewByPosition(i);
        int decoratedTop = getDecoratedTop(findViewByPosition);
        int i2 = findViewByPosition.getLayoutParams().topMargin;
        while (i > 0) {
            i--;
            View findViewByPosition2 = findViewByPosition(i);
            if (findViewByPosition2 == null) {
                return i + 1;
            }
            if (getDecoratedTop(findViewByPosition2) - findViewByPosition2.getLayoutParams().topMargin < (decoratedTop - i2) - getHeight()) {
                return i + 1;
            }
        }
        return 0;
    }

    /* renamed from: a */
    private final View m332a(RecyclerView.Recycler recycler, View view, int i) {
        int decoratedBottom;
        int decoratedMeasuredHeight;
        int position = getPosition(view);
        if (i == 0) {
            position--;
        } else if (i == 1) {
            position++;
        }
        View viewForPosition = recycler.getViewForPosition(position);
        measureChildWithMargins(viewForPosition, 0, 0);
        RecyclerView.LayoutParams layoutParams = viewForPosition.getLayoutParams();
        RecyclerView.LayoutParams layoutParams2 = view.getLayoutParams();
        int paddingLeft = getPaddingLeft() + layoutParams.leftMargin;
        int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
        if (i == 0) {
            decoratedMeasuredHeight = (view.getTop() - layoutParams2.topMargin) - layoutParams.bottomMargin;
            decoratedBottom = decoratedMeasuredHeight - getDecoratedMeasuredHeight(viewForPosition);
        } else {
            decoratedBottom = layoutParams2.bottomMargin + getDecoratedBottom(view) + layoutParams.topMargin;
            decoratedMeasuredHeight = decoratedBottom + getDecoratedMeasuredHeight(viewForPosition);
        }
        layoutDecorated(viewForPosition, paddingLeft, decoratedBottom, decoratedMeasuredWidth + paddingLeft, decoratedMeasuredHeight);
        if (i == 0) {
            addView(viewForPosition, 0);
        } else {
            addView(viewForPosition);
        }
        return viewForPosition;
    }

    /* renamed from: a */
    private final void m333a() {
        if (getChildCount() != 0) {
            if (Log.isLoggable("CarLayoutManager", 2)) {
                Log.v("CarLayoutManager", String.format(":: #BEFORE updatePageBreakPositions mAnchorPageBreakPosition:%s, mUpperPageBreakPosition:%s, mLowerPageBreakPosition:%s", new Object[]{Integer.valueOf(this.f244j), Integer.valueOf(this.f245k), Integer.valueOf(this.f246l)}));
            }
            this.f244j = getPosition(getFirstFullyVisibleChild());
            if (this.f244j == -1) {
                Log.w("CarLayoutManager", "Unable to update anchor positions. There is no anchor position.");
                return;
            }
            View findViewByPosition = findViewByPosition(this.f244j);
            if (findViewByPosition != null) {
                int i = findViewByPosition.getLayoutParams().topMargin;
                int decoratedTop = getDecoratedTop(findViewByPosition) - i;
                View findViewByPosition2 = findViewByPosition(this.f245k);
                int decoratedTop2 = findViewByPosition2 == null ? Integer.MIN_VALUE : getDecoratedTop(findViewByPosition2) - findViewByPosition2.getLayoutParams().topMargin;
                if (Log.isLoggable("CarLayoutManager", 2)) {
                    Log.v("CarLayoutManager", String.format(":: #MID updatePageBreakPositions topMargin:%s, anchorTop:%s mAnchorPageBreakPosition:%s, mUpperPageBreakPosition:%s, mLowerPageBreakPosition:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(decoratedTop), Integer.valueOf(this.f244j), Integer.valueOf(this.f245k), Integer.valueOf(this.f246l)}));
                }
                if (decoratedTop < getPaddingTop()) {
                    this.f245k = this.f244j;
                    this.f244j = this.f246l;
                    this.f246l = m337b(this.f244j);
                } else if (this.f244j <= 0 || decoratedTop2 < getPaddingTop()) {
                    this.f245k = m330a(this.f244j);
                    this.f246l = m337b(this.f244j);
                } else {
                    this.f246l = this.f244j;
                    this.f244j = this.f245k;
                    this.f245k = m330a(this.f244j);
                }
                if (Log.isLoggable("CarLayoutManager", 2)) {
                    Log.v("CarLayoutManager", String.format(":: #AFTER updatePageBreakPositions mAnchorPageBreakPosition:%s, mUpperPageBreakPosition:%s, mLowerPageBreakPosition:%s", new Object[]{Integer.valueOf(this.f244j), Integer.valueOf(this.f245k), Integer.valueOf(this.f246l)}));
                }
            }
        } else if (Log.isLoggable("CarLayoutManager", 3)) {
            Log.d("CarLayoutManager", ":: updatePageBreakPosition getChildCount: 0");
        }
    }

    /* renamed from: a */
    private final void m334a(View view, float f) {
        C0091b bVar = this.f251q.get(view);
        if (bVar == null) {
            bVar = new C0091b((byte) 0);
            bVar.setFillEnabled(true);
            bVar.setFillAfter(true);
            bVar.setDuration(0);
            this.f251q.put(view, bVar);
        } else if (bVar.f257a == f) {
            return;
        }
        bVar.reset();
        bVar.f257a = f;
        bVar.setStartTime(-1);
        view.setAnimation(bVar);
        bVar.startNow();
    }

    /* renamed from: a */
    private final boolean m335a(RecyclerView.State state, View view, int i) {
        int position = getPosition(view);
        if (i == 0) {
            if (position == 0) {
                return false;
            }
        } else if (i == 1 && position >= state.getItemCount() - 1) {
            return false;
        }
        if (this.f240f != null) {
            if (i == 0 && position >= this.f240f.getTargetPosition()) {
                return true;
            }
            if (i == 1 && position <= this.f240f.getTargetPosition()) {
                return true;
            }
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null) {
            int position2 = getPosition(focusedChild);
            if (i == 0 && position >= position2 - 2) {
                return true;
            }
            if (i == 1 && position <= position2 + 2) {
                return true;
            }
        }
        RecyclerView.LayoutParams layoutParams = view.getLayoutParams();
        int decoratedTop = getDecoratedTop(view);
        int i2 = layoutParams.topMargin;
        int decoratedBottom = getDecoratedBottom(view);
        int i3 = layoutParams.bottomMargin;
        if (i != 0 || decoratedTop - i2 >= getPaddingTop() - getHeight()) {
            return i != 1 || decoratedBottom - i3 <= getHeight() - getPaddingBottom();
        }
        return false;
    }

    /* renamed from: b */
    private final int m336b() {
        if (this.f248n != -1) {
            return this.f248n;
        }
        int firstFullyVisibleChildIndex = getFirstFullyVisibleChildIndex();
        View childAt = getChildAt(firstFullyVisibleChildIndex);
        View childAt2 = (getPosition(childAt) != 0 || firstFullyVisibleChildIndex >= getChildCount() + -1) ? childAt : getChildAt(firstFullyVisibleChildIndex + 1);
        RecyclerView.LayoutParams layoutParams = childAt2.getLayoutParams();
        int decoratedMeasuredHeight = layoutParams.bottomMargin + getDecoratedMeasuredHeight(childAt2) + layoutParams.topMargin;
        if (decoratedMeasuredHeight == 0) {
            Log.w("CarLayoutManager", "The sample view has a height of 0. Returning a dummy value for now that won't be cached.");
            return this.f236b.getResources().getDimensionPixelSize(R.dimen.car_sample_row_height);
        }
        this.f248n = decoratedMeasuredHeight;
        return decoratedMeasuredHeight;
    }

    @VisibleForTesting
    /* renamed from: b */
    private int m337b(int i) {
        if (i == -1) {
            return -1;
        }
        View findViewByPosition = findViewByPosition(i);
        if (findViewByPosition == null) {
            return i;
        }
        int decoratedTop = getDecoratedTop(findViewByPosition);
        int i2 = findViewByPosition.getLayoutParams().topMargin;
        int i3 = i;
        while (i3 < getItemCount() - 1) {
            int i4 = i3 + 1;
            View findViewByPosition2 = findViewByPosition(i4);
            if (findViewByPosition2 == null) {
                return i4 - 1;
            }
            if (getDecoratedTop(findViewByPosition2) - findViewByPosition2.getLayoutParams().topMargin > getHeight() + (decoratedTop - i2)) {
                return i4 + -1 == i ? i4 : i4 - 1;
            }
            i3 = i4;
        }
        return i3;
    }

    /* renamed from: c */
    private final int m338c() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public boolean canScrollVertically() {
        return true;
    }

    public int computeVerticalScrollExtent(RecyclerView.State state) {
        if (getChildCount() <= 1) {
            return 0;
        }
        int c = m338c() / m336b();
        if (state.getItemCount() <= c) {
            return 1000;
        }
        return (c * 1000) / state.getItemCount();
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        View firstFullyVisibleChild = getFirstFullyVisibleChild();
        if (firstFullyVisibleChild == null) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = firstFullyVisibleChild.getLayoutParams();
        int position = getPosition(firstFullyVisibleChild);
        float f = (float) position;
        float min = f - Math.min(((float) (getDecoratedTop(firstFullyVisibleChild) - layoutParams.topMargin)) / ((float) (layoutParams.bottomMargin + (getDecoratedMeasuredHeight(firstFullyVisibleChild) + layoutParams.topMargin))), 1.0f);
        int itemCount = state.getItemCount() - (m338c() / m336b());
        if (itemCount <= 0) {
            return 0;
        }
        if (min >= ((float) itemCount)) {
            return 1000;
        }
        return (int) ((min * 1000.0f) / ((float) itemCount));
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        return 1000;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-1, -2);
    }

    public View getFirstFullyVisibleChild() {
        int firstFullyVisibleChildIndex = getFirstFullyVisibleChildIndex();
        if (firstFullyVisibleChildIndex != -1) {
            return getChildAt(firstFullyVisibleChildIndex);
        }
        return null;
    }

    public int getFirstFullyVisibleChildIndex() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                return -1;
            }
            View childAt = getChildAt(i2);
            if (getDecoratedTop(childAt) - childAt.getLayoutParams().topMargin >= getPaddingTop()) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public int getFirstFullyVisibleChildPosition() {
        View firstFullyVisibleChild = getFirstFullyVisibleChild();
        if (firstFullyVisibleChild == null) {
            return -1;
        }
        return getPosition(firstFullyVisibleChild);
    }

    public int getLastFocusedChildIndexIfVisible() {
        if (this.f247m == -1) {
            return -1;
        }
        int i = 0;
        while (true) {
            if (i >= getChildCount()) {
                break;
            }
            View childAt = getChildAt(i);
            if (getPosition(childAt) == this.f247m) {
                if (childAt.getLayoutParams().bottomMargin + getDecoratedBottom(childAt) <= getHeight() - getPaddingBottom()) {
                    return i;
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    public View getLastFullyVisibleChild() {
        int lastFullyVisibleChildIndex = getLastFullyVisibleChildIndex();
        if (lastFullyVisibleChildIndex != -1) {
            return getChildAt(lastFullyVisibleChildIndex);
        }
        return null;
    }

    public int getLastFullyVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getLayoutParams().bottomMargin + getDecoratedBottom(childAt) <= getHeight() - getPaddingBottom()) {
                return childCount;
            }
        }
        return -1;
    }

    public int getLastFullyVisibleChildPosition() {
        View lastFullyVisibleChild = getLastFullyVisibleChild();
        if (lastFullyVisibleChild == null) {
            return -1;
        }
        return getPosition(lastFullyVisibleChild);
    }

    public int getPageDownPosition() {
        return this.f246l;
    }

    public int getPageUpPosition() {
        return this.f245k;
    }

    public boolean isAtBottom() {
        int lastFullyVisibleChildIndex = getLastFullyVisibleChildIndex();
        return lastFullyVisibleChildIndex == -1 || getPosition(getChildAt(lastFullyVisibleChildIndex)) == getItemCount() + -1;
    }

    public boolean isAtTop() {
        return getFirstFullyVisibleChildIndex() <= 0;
    }

    public void offsetRows() {
        int i;
        if (this.f237c) {
            if (this.f238d == 1) {
                View findViewByPosition = findViewByPosition(this.f244j);
                if (findViewByPosition != null) {
                    int decoratedTop = getDecoratedTop(findViewByPosition) - findViewByPosition.getLayoutParams().topMargin;
                    View findViewByPosition2 = findViewByPosition(this.f245k);
                    int decoratedTop2 = (getDecoratedTop(findViewByPosition2) - findViewByPosition2.getLayoutParams().topMargin) - decoratedTop;
                    int paddingTop = decoratedTop - getPaddingTop();
                    float abs = ((float) (Math.abs(decoratedTop2) - paddingTop)) / ((float) Math.abs(decoratedTop2));
                    if (Log.isLoggable("CarLayoutManager", 2)) {
                        Log.v("CarLayoutManager", String.format(":: offsetRowsByPage scrollDistance:%s, distanceLeft:%s, scrollPercentage:%s", new Object[]{Integer.valueOf(decoratedTop2), Integer.valueOf(paddingTop), Float.valueOf(abs)}));
                    }
                    RecyclerView parent = getChildAt(0).getParent();
                    int[] iArr = new int[2];
                    parent.getLocationInWindow(iArr);
                    int paddingTop2 = iArr[1] + parent.getPaddingTop();
                    int childCount = getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = getChildAt(i2);
                        int position = getPosition(childAt);
                        if (position < this.f245k) {
                            childAt.setAlpha(0.0f);
                            m334a(childAt, (float) (-paddingTop2));
                        } else if (position < this.f244j) {
                            RecyclerView.LayoutParams layoutParams = childAt.getLayoutParams();
                            int i3 = layoutParams.topMargin < 0 ? 0 - layoutParams.topMargin : 0;
                            if (layoutParams.bottomMargin < 0) {
                                i3 -= layoutParams.bottomMargin;
                            }
                            childAt.setAlpha(1.0f);
                            m334a(childAt, (float) (-((int) (((float) (paddingTop2 + i3)) * this.f235a.getInterpolation(abs)))));
                        } else {
                            childAt.setAlpha(1.0f);
                            m334a(childAt, 0.0f);
                        }
                    }
                } else if (Log.isLoggable("CarLayoutManager", 3)) {
                    Log.d("CarLayoutManager", ":: offsetRowsByPage anchorView null");
                }
            } else if (this.f238d != 0) {
            } else {
                if (getChildCount() != 0) {
                    int childCount2 = getChildCount() - 1;
                    while (true) {
                        if (childCount2 < 0) {
                            i = -1;
                            break;
                        }
                        View childAt2 = getChildAt(childCount2);
                        if (getDecoratedTop(childAt2) - childAt2.getLayoutParams().topMargin <= getPaddingTop()) {
                            i = childCount2;
                            break;
                        }
                        childCount2--;
                    }
                    this.f244j = i;
                    if (Log.isLoggable("CarLayoutManager", 2)) {
                        Log.v("CarLayoutManager", new StringBuilder(57).append(":: offsetRowsIndividually danglingChildIndex: ").append(i).toString());
                    }
                    RecyclerView parent2 = getChildAt(0).getParent();
                    int[] iArr2 = new int[2];
                    parent2.getLocationInWindow(iArr2);
                    int paddingTop3 = iArr2[1] + parent2.getPaddingTop();
                    int childCount3 = getChildCount();
                    for (int i4 = 0; i4 < childCount3; i4++) {
                        View childAt3 = getChildAt(i4);
                        RecyclerView.LayoutParams layoutParams2 = childAt3.getLayoutParams();
                        int i5 = layoutParams2.topMargin < 0 ? paddingTop3 - layoutParams2.topMargin : paddingTop3;
                        if (layoutParams2.bottomMargin < 0) {
                            i5 -= layoutParams2.bottomMargin;
                        }
                        if (i4 < i) {
                            childAt3.setAlpha(0.0f);
                        } else if (i4 > i) {
                            childAt3.setAlpha(1.0f);
                            m334a(childAt3, 0.0f);
                        } else {
                            float interpolation = this.f235a.getInterpolation(1.0f - (((float) ((layoutParams2.bottomMargin + getDecoratedBottom(childAt3)) - getPaddingTop())) / ((float) ((getDecoratedMeasuredHeight(childAt3) + layoutParams2.topMargin) + layoutParams2.bottomMargin))));
                            childAt3.setAlpha(1.0f);
                            m334a(childAt3, -(interpolation * ((float) i5)));
                        }
                    }
                } else if (Log.isLoggable("CarLayoutManager", 3)) {
                    Log.d("CarLayoutManager", ":: offsetRowsIndividually getChildCount=0");
                }
            }
        }
    }

    public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
        int lastFocusedChildIndexIfVisible;
        if (getFocusedChild() != null) {
            return false;
        }
        int firstFullyVisibleChildIndex = getFirstFullyVisibleChildIndex();
        if (firstFullyVisibleChildIndex == -1) {
            Log.w("CarLayoutManager", "There is a focused child but no first fully visible child.");
            return false;
        }
        if (getPosition(getChildAt(firstFullyVisibleChildIndex)) > 0 && firstFullyVisibleChildIndex + 1 < getItemCount()) {
            firstFullyVisibleChildIndex++;
        }
        if (i == 2) {
            while (firstFullyVisibleChildIndex < getChildCount()) {
                arrayList.add(getChildAt(firstFullyVisibleChildIndex));
                firstFullyVisibleChildIndex++;
            }
            return true;
        } else if (i == 1) {
            while (firstFullyVisibleChildIndex >= 0) {
                arrayList.add(getChildAt(firstFullyVisibleChildIndex));
                firstFullyVisibleChildIndex--;
            }
            return true;
        } else if (i != 130 || (lastFocusedChildIndexIfVisible = getLastFocusedChildIndexIfVisible()) == -1) {
            return false;
        } else {
            arrayList.add(getChildAt(lastFocusedChildIndexIfVisible));
            return true;
        }
    }

    public void onAttachedToWindow(RecyclerView recyclerView) {
        CarLayoutManager.super.onAttachedToWindow(recyclerView);
        m333a();
        offsetRows();
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        CarLayoutManager.super.onDetachedFromWindow(recyclerView, recycler);
    }

    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return null;
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        CarLayoutManager.super.onItemsChanged(recyclerView);
        this.f248n = -1;
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        int i2;
        if (this.f252r == -1) {
            View firstFullyVisibleChild = getFirstFullyVisibleChild();
            if (firstFullyVisibleChild != null) {
                i = getPosition(firstFullyVisibleChild);
                i2 = getDecoratedTop(firstFullyVisibleChild);
            } else {
                i2 = -1;
                i = 0;
            }
        } else {
            i = this.f252r;
            this.f252r = -1;
            this.f244j = i;
            this.f245k = -1;
            this.f246l = -1;
            i2 = -1;
        }
        if (Log.isLoggable("CarLayoutManager", 2)) {
            Log.v("CarLayoutManager", String.format(":: onLayoutChildren anchorPosition:%s, anchorTop:%s, mPendingScrollPosition: %s, mAnchorPageBreakPosition:%s, mUpperPageBreakPosition:%s, mLowerPageBreakPosition:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.f252r), Integer.valueOf(this.f244j), Integer.valueOf(this.f245k), Integer.valueOf(this.f246l)}));
        }
        detachAndScrapAttachedViews(recycler);
        int min = Math.min(i, getItemCount() - 1);
        if (min >= 0) {
            View viewForPosition = recycler.getViewForPosition(min);
            RecyclerView.LayoutParams layoutParams = viewForPosition.getLayoutParams();
            measureChildWithMargins(viewForPosition, 0, 0);
            int paddingLeft = getPaddingLeft() + layoutParams.leftMargin;
            if (i2 == -1) {
                i2 = layoutParams.topMargin;
            }
            layoutDecorated(viewForPosition, paddingLeft, i2, paddingLeft + getDecoratedMeasuredWidth(viewForPosition), i2 + getDecoratedMeasuredHeight(viewForPosition));
            addView(viewForPosition);
            View view = viewForPosition;
            while (m335a(state, view, 0)) {
                view = m332a(recycler, view, 0);
            }
            while (m335a(state, viewForPosition, 1)) {
                viewForPosition = m332a(recycler, viewForPosition, 1);
            }
        }
        m333a();
        offsetRows();
        if (Log.isLoggable("CarLayoutManager", 2) && getChildCount() > 1) {
            int childCount = getChildCount();
            Log.v("CarLayoutManager", new StringBuilder(81).append("Currently showing ").append(childCount).append(" views ").append(getPosition(getChildAt(0))).append(" to ").append(getPosition(getChildAt(getChildCount() - 1))).append(" anchor ").append(min).toString());
        }
        this.f249o = Math.max((getLastFullyVisibleChildIndex() + 1) - getFirstFullyVisibleChildIndex(), 1);
        this.f250p = getFirstFullyVisibleChildPosition() / this.f249o;
        Log.v("CarLayoutManager", new StringBuilder(24).append("viewsPerPage ").append(this.f249o).toString());
    }

    public boolean onRequestChildFocus(RecyclerView recyclerView, RecyclerView.State state, View view, View view2) {
        View childAt;
        if (view == null) {
            Log.w("CarLayoutManager", "onRequestChildFocus with a null child!");
        } else {
            if (Log.isLoggable("CarLayoutManager", 2)) {
                Log.v("CarLayoutManager", String.format(":: onRequestChildFocus child: %s, focused: %s", new Object[]{view, view2}));
            }
            int position = getPosition(view);
            if (position != this.f247m) {
                this.f247m = position;
                int c = m338c();
                int decoratedTop = getDecoratedTop(view);
                int decoratedBottom = getDecoratedBottom(view);
                int indexOfChild = recyclerView.indexOfChild(view);
                while (true) {
                    if (indexOfChild < 0) {
                        break;
                    }
                    childAt = getChildAt(indexOfChild);
                    if (childAt == null) {
                        Log.e("CarLayoutManager", new StringBuilder(34).append("Child is null at index ").append(indexOfChild).toString());
                    } else if (indexOfChild == 0) {
                        recyclerView.smoothScrollToPosition(getPosition(childAt));
                        break;
                    } else {
                        View childAt2 = getChildAt(indexOfChild - 1);
                        if (childAt2 != null) {
                            int decoratedTop2 = getDecoratedTop(childAt2);
                            int decoratedTop3 = getDecoratedTop(childAt2);
                            if (decoratedTop - decoratedTop2 > c / 2 || decoratedBottom - decoratedTop3 > c) {
                                recyclerView.smoothScrollToPosition(getPosition(childAt));
                            }
                        } else {
                            continue;
                        }
                    }
                    indexOfChild--;
                }
                recyclerView.smoothScrollToPosition(getPosition(childAt));
            }
        }
        return true;
    }

    public void onScrollStateChanged(int i) {
        if (Log.isLoggable("CarLayoutManager", 2)) {
            Log.v("CarLayoutManager", new StringBuilder(35).append(":: onScrollStateChanged ").append(i).toString());
        }
        if (i == 0) {
            View focusedChild = getFocusedChild();
            if (focusedChild != null && (getDecoratedTop(focusedChild) >= getHeight() - getPaddingBottom() || getDecoratedBottom(focusedChild) <= getPaddingTop())) {
                focusedChild.clearFocus();
                requestLayout();
            }
        } else if (i == 1) {
            this.f242h = 0;
        }
        if (i != 2) {
            this.f240f = null;
        }
        this.f239e = i;
        m333a();
    }

    public void scrollToPosition(int i) {
        this.f252r = i;
        requestLayout();
    }

    public int scrollVerticallyBy(int i, @NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state) {
        if (getItemCount() == 0) {
            return i;
        }
        if (getChildCount() <= 1 || i == 0) {
            this.f243i = true;
            return 0;
        }
        View childAt = getChildAt(0);
        if (childAt == null) {
            this.f243i = true;
            return 0;
        }
        int position = getPosition(childAt);
        int decoratedTop = getDecoratedTop(childAt) - childAt.getLayoutParams().topMargin;
        View childAt2 = getChildAt(getLastFullyVisibleChildIndex());
        if (childAt2 == null) {
            this.f243i = true;
            return 0;
        }
        boolean z = getPosition(childAt2) == getItemCount() + -1;
        View firstFullyVisibleChild = getFirstFullyVisibleChild();
        if (firstFullyVisibleChild == null) {
            this.f243i = true;
            return 0;
        }
        int position2 = getPosition(firstFullyVisibleChild);
        int decoratedTop2 = (getDecoratedTop(firstFullyVisibleChild) - firstFullyVisibleChild.getLayoutParams().topMargin) - getPaddingTop();
        if (z && position2 == this.f244j && i > decoratedTop2 && i > 0) {
            this.f243i = true;
            i = decoratedTop2;
        } else if (i >= 0 || position != 0 || Math.abs(i) + decoratedTop <= getPaddingTop()) {
            this.f243i = false;
        } else {
            i = decoratedTop - getPaddingTop();
            this.f243i = true;
        }
        if (this.f239e == 1) {
            this.f242h += i;
        }
        offsetChildrenVertical(-i);
        View childAt3 = getChildAt(getChildCount() - 1);
        if (childAt3.getTop() < 0) {
            childAt3.setTop(0);
        }
        if (i > 0) {
            int paddingTop = getPaddingTop();
            int height = getHeight();
            int i2 = Integer.MAX_VALUE;
            View focusedChild = getFocusedChild();
            if (focusedChild != null) {
                i2 = getPosition(focusedChild);
            }
            int childCount = getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (i3 < childCount) {
                View childAt4 = getChildAt(i3);
                int decoratedBottom = getDecoratedBottom(childAt4);
                int position3 = getPosition(childAt4);
                if (decoratedBottom >= paddingTop - height || position3 >= i2 - 1) {
                    break;
                }
                i3++;
                i4++;
            }
            int i5 = i4;
            while (true) {
                i5--;
                if (i5 < 0) {
                    break;
                }
                removeAndRecycleView(getChildAt(0), recycler);
            }
            View childAt5 = getChildAt(getChildCount() - 1);
            while (m335a(state, childAt5, 1)) {
                childAt5 = m332a(recycler, childAt5, 1);
            }
        } else {
            int height2 = getHeight();
            int i6 = -2147483647;
            View focusedChild2 = getFocusedChild();
            if (focusedChild2 != null) {
                i6 = getPosition(focusedChild2);
            }
            int i7 = 0;
            int i8 = 0;
            for (int childCount2 = getChildCount() - 1; childCount2 >= 0; childCount2--) {
                View childAt6 = getChildAt(childCount2);
                int decoratedTop3 = getDecoratedTop(childAt6);
                int position4 = getPosition(childAt6);
                if (decoratedTop3 <= height2 || position4 <= i6 - 1) {
                    break;
                }
                i8++;
                i7 = childCount2;
            }
            int i9 = i8;
            while (true) {
                i9--;
                if (i9 < 0) {
                    break;
                }
                removeAndRecycleView(getChildAt(i7), recycler);
            }
            View childAt7 = getChildAt(0);
            while (m335a(state, childAt7, 0)) {
                childAt7 = m332a(recycler, childAt7, 0);
            }
        }
        m333a();
        offsetRows();
        if (getChildCount() > 1 && Log.isLoggable("CarLayoutManager", 2)) {
            Log.v("CarLayoutManager", String.format("Currently showing  %d views (%d to %d)", new Object[]{Integer.valueOf(getChildCount()), Integer.valueOf(getPosition(getChildAt(0))), Integer.valueOf(getPosition(getChildAt(getChildCount() - 1)))}));
        }
        int firstFullyVisibleChildPosition = getFirstFullyVisibleChildPosition() / this.f249o;
        if (this.f241g != null) {
            if (firstFullyVisibleChildPosition > this.f250p) {
                this.f241g.onPageDown();
            } else if (firstFullyVisibleChildPosition < this.f250p) {
                this.f241g.onPageUp();
            }
        }
        this.f250p = firstFullyVisibleChildPosition;
        return i;
    }

    public void setOffsetRows(boolean z) {
        this.f237c = z;
        if (z) {
            if (this.f251q == null) {
                this.f251q = new LruCache<>(30);
            }
            offsetRows();
            return;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            m334a(getChildAt(i), 0.0f);
        }
        this.f251q = null;
    }

    public void setOnScrollListener(PagedListView.OnScrollListener onScrollListener) {
        this.f241g = onScrollListener;
    }

    public void setRowOffsetMode(int i) {
        if (i != this.f238d) {
            this.f238d = i;
            offsetRows();
        }
    }

    public boolean settleScrollForFling(RecyclerView recyclerView, int i) {
        if (getChildCount() == 0 || this.f243i) {
            return false;
        }
        if (Math.abs(i) < 0 || Math.abs(this.f242h) < 0) {
            int firstFullyVisibleChildIndex = getFirstFullyVisibleChildIndex();
            if (firstFullyVisibleChildIndex == -1) {
                return false;
            }
            recyclerView.smoothScrollToPosition(getPosition(getChildAt(firstFullyVisibleChildIndex)));
            return true;
        }
        boolean z = i > 0 || (i == 0 && this.f242h >= 0);
        boolean z2 = i < 0 || (i == 0 && this.f242h < 0);
        if (z && this.f246l != -1) {
            recyclerView.smoothScrollToPosition(this.f244j);
            if (this.f241g != null) {
                this.f241g.onGestureDown();
            }
            return true;
        } else if (!z2 || this.f245k == -1) {
            Log.e("CarLayoutManager", new StringBuilder(157).append("Error setting scroll for fling! flingVelocity: \t").append(i).append("\tlastDragDistance: ").append(this.f242h).append("\tpageUpAtStartOfDrag: ").append(this.f245k).append("\tpageDownAtStartOfDrag: ").append(this.f246l).toString());
            if (this.f240f == null) {
                return false;
            }
            recyclerView.smoothScrollToPosition(this.f240f.getTargetPosition());
            return true;
        } else {
            recyclerView.smoothScrollToPosition(this.f245k);
            if (this.f241g != null) {
                this.f241g.onGestureUp();
            }
            return true;
        }
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        this.f240f = new C0090a(this.f236b, i);
        this.f240f.setTargetPosition(i);
        startSmoothScroll(this.f240f);
    }
}
