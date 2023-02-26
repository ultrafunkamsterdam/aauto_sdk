package com.google.android.apps.auto.sdk.p012ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/* renamed from: com.google.android.apps.auto.sdk.ui.PagedListView */
public class PagedListView extends FrameLayout {
    public static final int DEFAULT_MAX_CLICKS = 6;
    protected static final int PAGINATION_HOLD_DELAY_MS = 400;

    /* renamed from: a */
    private final boolean f286a;

    /* renamed from: b */
    private final boolean f287b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final PagedScrollBarView f288c;

    /* renamed from: d */
    private int f289d;

    /* renamed from: e */
    private int f290e;

    /* renamed from: f */
    private Decoration f291f;

    /* renamed from: g */
    private int f292g;

    /* renamed from: h */
    private int f293h;

    /* renamed from: i */
    private boolean f294i;

    /* renamed from: j */
    private float f295j;

    /* renamed from: k */
    private float f296k;

    /* renamed from: l */
    private boolean f297l;

    /* renamed from: m */
    private boolean f298m;
    protected RecyclerView.Adapter<? extends RecyclerView.ViewHolder> mAdapter;
    protected final Handler mHandler;
    protected final CarLayoutManager mLayoutManager;
    protected OnScrollListener mOnScrollListener;
    protected final Runnable mPaginationRunnable;
    protected final CarRecyclerView mRecyclerView;

    /* renamed from: n */
    private final RecyclerView.OnScrollListener f299n;

    /* renamed from: o */
    private final Runnable f300o;

    /* renamed from: com.google.android.apps.auto.sdk.ui.PagedListView$Decoration */
    public static class Decoration extends RecyclerView.ItemDecoration {

        /* renamed from: a */
        private final boolean f301a;
        protected final Context mContext;
        protected final int mDividerHeight;
        protected final Paint mPaint;

        public Decoration(Context context) {
            this(context, true);
        }

        public Decoration(Context context, boolean z) {
            this.mContext = context;
            this.f301a = z;
            this.mPaint = new Paint();
            updateDividerColor();
            this.mDividerHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.car_divider_height);
        }

        /* renamed from: a */
        private final TextView m345a(View view) {
            if (view == null) {
                return null;
            }
            if (view instanceof TextView) {
                return (TextView) view;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    TextView a = m345a(viewGroup.getChildAt(i));
                    if (a != null) {
                        return a;
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public int getLeft(View view) {
            if (view == null) {
                return 0;
            }
            TextView a = m345a(view);
            TextView textView = a == null ? view : a;
            int i = 0;
            while (textView != null && textView != view) {
                i += textView.getLeft();
                textView = (View) textView.getParent();
            }
            return i;
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            int left = getLeft(recyclerView.getChildAt(0));
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            if (this.f301a) {
                canvas.drawRect((float) left, 0.0f, (float) width, (float) this.mDividerHeight, this.mPaint);
            }
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                int bottom = childAt.getBottom() - childAt.getLayoutParams().bottomMargin;
                int i2 = bottom - this.mDividerHeight;
                if (i2 > 0) {
                    canvas.drawRect((float) left, (float) i2, (float) width, (float) bottom, this.mPaint);
                }
            }
        }

        public void updateDividerColor() {
            this.mPaint.setColor(this.mContext.getResources().getColor(R.color.car_list_divider));
        }
    }

    /* renamed from: com.google.android.apps.auto.sdk.ui.PagedListView$ItemCap */
    public interface ItemCap {
        void setMaxItems(int i);
    }

    /* renamed from: com.google.android.apps.auto.sdk.ui.PagedListView$ItemPositionOffset */
    public interface ItemPositionOffset {
        void setPositionOffset(int i);
    }

    /* renamed from: com.google.android.apps.auto.sdk.ui.PagedListView$OnScrollListener */
    public static class OnScrollListener {
        public void onGestureDown() {
        }

        public void onGestureUp() {
        }

        public void onLeaveBottom() {
        }

        public void onPageDown() {
        }

        public void onPageUp() {
        }

        public void onReachBottom() {
        }

        public void onScrollDownButtonClicked() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        }

        public void onScrollUpButtonClicked() {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public PagedListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
    }

    public PagedListView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PagedListView(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, 0);
    }

    public PagedListView(Context context, AttributeSet attributeSet, int i, int i2, int i3) {
        super(context, attributeSet, i, i2);
        this.mHandler = new Handler();
        this.f289d = -1;
        this.f290e = -1;
        this.f291f = new Decoration(getContext());
        this.f292g = 6;
        this.f293h = 0;
        this.f299n = new C0099f(this);
        this.mPaginationRunnable = new C0100g(this);
        this.f300o = new C0101h(this);
        LayoutInflater.from(context).inflate(i3 == 0 ? R.layout.car_paged_recycler_view : i3, this, true);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.max_width_layout);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PagedListView, i, i2);
        this.mRecyclerView = (CarRecyclerView) findViewById(R.id.recycler_view);
        this.mRecyclerView.setFadeLastItem(obtainStyledAttributes.getBoolean(R.styleable.PagedListView_fadeLastItem, false));
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.PagedListView_offsetRows, false);
        this.f290e = getDefaultMaxPages();
        this.mLayoutManager = new CarLayoutManager(context);
        this.mLayoutManager.setOffsetRows(z);
        this.mRecyclerView.setLayoutManager(this.mLayoutManager);
        this.mRecyclerView.addItemDecoration(this.f291f);
        this.mRecyclerView.setOnScrollListener(this.f299n);
        this.mRecyclerView.getRecycledViewPool().setMaxRecycledViews(0, 12);
        this.mRecyclerView.setItemAnimator(new C0094a(this.mLayoutManager));
        setClickable(true);
        setFocusable(false);
        this.f286a = obtainStyledAttributes.getBoolean(R.styleable.PagedListView_scrollBarEnabled, true);
        this.f288c = (PagedScrollBarView) findViewById(R.id.paged_scroll_view);
        this.f288c.setPaginationListener(new C0098e(this));
        this.f288c.setVisibility(this.f286a ? 0 : 8);
        this.f287b = obtainStyledAttributes.getBoolean(R.styleable.PagedListView_rightGutterEnabled, false);
        if (this.f287b || !this.f286a) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            if (this.f287b) {
                layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.car_card_margin);
            }
            if (!this.f286a) {
                layoutParams.setMarginStart(0);
            }
            frameLayout.setLayoutParams(layoutParams);
        }
        setDayNightStyle(0);
        obtainStyledAttributes.recycle();
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.mRecyclerView.addItemDecoration(itemDecoration);
    }

    public void addOnItemTouchListener(@NonNull RecyclerView.OnItemTouchListener onItemTouchListener) {
        this.mRecyclerView.addOnItemTouchListener(onItemTouchListener);
    }

    /* access modifiers changed from: protected */
    public int calculateMaxItemCount() {
        View childAt = this.mLayoutManager.getChildAt(0);
        if (childAt == null || childAt.getHeight() == 0 || this.f290e < 0) {
            return -1;
        }
        return this.f289d * this.f290e;
    }

    public View findViewByPosition(int i) {
        return this.mLayoutManager.findViewByPosition(i);
    }

    @Nullable
    public RecyclerView.Adapter<? extends RecyclerView.ViewHolder> getAdapter() {
        return this.mRecyclerView.getAdapter();
    }

    /* access modifiers changed from: protected */
    public int getDefaultMaxPages() {
        return this.f292g - 1;
    }

    public int getFirstFullyVisibleChildPosition() {
        return this.mLayoutManager.getFirstFullyVisibleChildPosition();
    }

    public int getLastFullyVisibleChildPosition() {
        return this.mLayoutManager.getLastFullyVisibleChildPosition();
    }

    @Nullable
    public RecyclerView.ViewHolder getLastViewHolder() {
        View lastFullyVisibleChild = this.mLayoutManager.getLastFullyVisibleChild();
        if (lastFullyVisibleChild == null) {
            return null;
        }
        int position = this.mLayoutManager.getPosition(lastFullyVisibleChild);
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = getRecyclerView().findViewHolderForAdapterPosition(position + 1);
        return findViewHolderForAdapterPosition == null ? getRecyclerView().findViewHolderForAdapterPosition(position) : findViewHolderForAdapterPosition;
    }

    public int getMaxPages() {
        return this.f290e;
    }

    public int getPage(int i) {
        if (this.f289d == -1) {
            return -1;
        }
        if (this.f289d == 0) {
            return 0;
        }
        return i / this.f289d;
    }

    @NonNull
    public CarRecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    public int getRowsPerPage() {
        return this.f289d;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeCallbacks(this.f300o);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onGenericMotionEvent(android.view.MotionEvent r13) {
        /*
            r12 = this;
            r11 = 1112014848(0x42480000, float:50.0)
            r10 = 0
            r3 = 1
            r1 = 0
            java.lang.String r0 = "PagedListView"
            java.lang.String r2 = "onGenericMotionEvent"
            android.util.Log.v(r0, r2)
            android.content.res.Resources r0 = r12.getResources()
            int r2 = com.google.android.apps.auto.sdk.ui.R.bool.car_true_for_touch
            boolean r0 = r0.getBoolean(r2)
            if (r0 != 0) goto L_0x0024
            android.content.res.Resources r0 = r12.getResources()
            int r2 = com.google.android.apps.auto.sdk.ui.R.bool.has_wheel
            boolean r0 = r0.getBoolean(r2)
            if (r0 == 0) goto L_0x0027
        L_0x0024:
            r0 = r1
        L_0x0025:
            r1 = r0
        L_0x0026:
            return r1
        L_0x0027:
            int r4 = r13.getAction()
            r0 = 2
            if (r4 != r0) goto L_0x0107
            float r0 = r13.getY()
            float r2 = r12.f295j
            float r2 = r0 - r2
            float r0 = r13.getY()
            float r5 = r12.f296k
            float r5 = r0 - r5
            boolean r0 = r12.f297l
            if (r0 == 0) goto L_0x0076
            double r6 = (double) r2
            r8 = 0
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x0076
            float r0 = java.lang.Math.signum(r2)
            int r0 = (int) r0
            com.google.android.apps.auto.sdk.ui.CarRecyclerView r6 = r12.mRecyclerView
            android.view.View r6 = r6.getFocusedChild()
            if (r6 == 0) goto L_0x00fe
            com.google.android.apps.auto.sdk.ui.CarLayoutManager r7 = r12.mLayoutManager
            int r6 = r7.getPosition(r6)
            int r0 = r0 + r6
            com.google.android.apps.auto.sdk.ui.CarLayoutManager r7 = r12.mLayoutManager
            int r7 = r7.getItemCount()
            int r7 = r7 + -1
            int r0 = java.lang.Math.min(r0, r7)
            int r0 = java.lang.Math.max(r0, r1)
            if (r0 == r6) goto L_0x00fe
            r0 = r3
        L_0x0070:
            if (r0 == 0) goto L_0x0074
            r12.f298m = r3
        L_0x0074:
            r12.f297l = r1
        L_0x0076:
            boolean r0 = r12.f298m
            if (r0 == 0) goto L_0x0101
            float r0 = java.lang.Math.abs(r2)
            r6 = 1097859072(0x41700000, float:15.0)
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x0101
            r0 = r3
        L_0x0085:
            int r6 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r6 < 0) goto L_0x008d
            int r6 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r6 >= 0) goto L_0x0095
        L_0x008d:
            int r6 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r6 > 0) goto L_0x0103
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 > 0) goto L_0x0103
        L_0x0095:
            float r5 = r12.f296k
            float r6 = r12.f295j
            float r5 = r5 - r6
            float r5 = r5 / r11
            int r5 = (int) r5
            float r6 = r2 / r11
            int r6 = (int) r6
            if (r6 == r5) goto L_0x0105
            float r2 = java.lang.Math.signum(r2)
            int r2 = (int) r2
            com.google.android.apps.auto.sdk.ui.CarRecyclerView r5 = r12.mRecyclerView
            android.view.View r5 = r5.getFocusedChild()
            if (r5 == 0) goto L_0x0105
            com.google.android.apps.auto.sdk.ui.CarLayoutManager r6 = r12.mLayoutManager
            int r5 = r6.getPosition(r5)
            int r2 = r2 + r5
            com.google.android.apps.auto.sdk.ui.CarLayoutManager r6 = r12.mLayoutManager
            int r6 = r6.getItemCount()
            int r6 = r6 + -1
            int r2 = java.lang.Math.min(r2, r6)
            int r2 = java.lang.Math.max(r2, r1)
            if (r2 == r5) goto L_0x0105
            com.google.android.apps.auto.sdk.ui.CarRecyclerView r5 = r12.mRecyclerView
            com.google.android.apps.auto.sdk.ui.CarLayoutManager r6 = r12.mLayoutManager
            com.google.android.apps.auto.sdk.ui.CarLayoutManager r7 = r12.mLayoutManager
            android.view.View r7 = r7.getChildAt(r1)
            int r6 = r6.getPosition(r7)
            int r2 = r2 - r6
            android.view.View r2 = r5.getChildAt(r2)
            if (r2 == 0) goto L_0x0105
            r2.requestFocus()
            r2 = r1
        L_0x00e0:
            float r5 = r13.getY()
            r12.f296k = r5
        L_0x00e6:
            if (r2 != 0) goto L_0x00ea
            if (r4 != 0) goto L_0x0025
        L_0x00ea:
            float r2 = r13.getY()
            r12.f295j = r2
            float r2 = r13.getY()
            r12.f296k = r2
            r12.f297l = r3
            r12.f298m = r1
            if (r4 != 0) goto L_0x0025
            goto L_0x0026
        L_0x00fe:
            r0 = r1
            goto L_0x0070
        L_0x0101:
            r0 = r1
            goto L_0x0085
        L_0x0103:
            r2 = r3
            goto L_0x00e0
        L_0x0105:
            r2 = r1
            goto L_0x00e0
        L_0x0107:
            r0 = r1
            r2 = r1
            goto L_0x00e6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.apps.auto.sdk.p012ui.PagedListView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mLayoutManager.setRowOffsetMode(1);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View focusedChild = this.mLayoutManager.getFocusedChild();
        View childAt = this.mLayoutManager.getChildAt(0);
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            int itemCount = this.mAdapter.getItemCount();
            if (Log.isLoggable("PagedListView", 3)) {
                Log.d("PagedListView", String.format("onLayout hasFocus: %s, mLastItemCount: %s, itemCount: %s, focusedChild: %s, firstBorn: %s, isInTouchMode: %s, mNeedsFocus: %s", new Object[]{Boolean.valueOf(hasFocus()), Integer.valueOf(this.f293h), Integer.valueOf(itemCount), focusedChild, childAt, Boolean.valueOf(isInTouchMode()), Boolean.valueOf(this.f294i)}));
            }
            updateMaxItems();
            if (this.f294i && itemCount > 0) {
                if (focusedChild == null) {
                    requestFocus();
                }
                this.f294i = false;
            }
            if (itemCount > this.f293h && focusedChild == childAt && getContext().getResources().getBoolean(R.bool.has_wheel)) {
                requestFocus();
            }
            this.f293h = itemCount;
        }
        updatePaginationButtons(false);
    }

    public int positionOf(@Nullable View view) {
        if (view == null || view.getParent() != this.mRecyclerView) {
            return -1;
        }
        return this.mLayoutManager.getPosition(view);
    }

    public void removeDefaultItemDecoration() {
        this.mRecyclerView.removeItemDecoration(this.f291f);
    }

    public void removeItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.mRecyclerView.removeItemDecoration(itemDecoration);
    }

    public void removeOnItemTouchListener(@NonNull RecyclerView.OnItemTouchListener onItemTouchListener) {
        this.mRecyclerView.removeOnItemTouchListener(onItemTouchListener);
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        this.mLayoutManager.setRowOffsetMode(0);
    }

    public boolean requestFocus(int i, Rect rect) {
        if (getContext().getResources().getBoolean(R.bool.has_wheel)) {
            this.f294i = true;
        }
        return super.requestFocus(i, rect);
    }

    public void resetMaxPages() {
        this.f290e = getDefaultMaxPages();
        updateMaxItems();
    }

    public void scrollToPosition(int i) {
        this.mLayoutManager.scrollToPosition(i);
        this.mHandler.post(this.f300o);
    }

    public void setAdapter(@NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        if (!(adapter instanceof ItemCap)) {
            String canonicalName = adapter.getClass().getCanonicalName();
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(canonicalName).length() + 40).append("ERROR: adapter [").append(canonicalName).append("] MUST implement ItemCap").toString());
        }
        this.mAdapter = adapter;
        this.mRecyclerView.setAdapter(adapter);
        updateMaxItems();
    }

    @Deprecated
    public void setAutoDayNightMode() {
        setDayNightStyle(0);
    }

    @Deprecated
    public void setDarkMode() {
        setDayNightStyle(3);
    }

    public void setDayNightStyle(int i) {
        this.f288c.setDayNightStyle(i);
        this.f291f.updateDividerColor();
    }

    public void setDefaultItemDecoration(Decoration decoration) {
        removeDefaultItemDecoration();
        this.f291f = decoration;
        addItemDecoration(this.f291f);
    }

    public void setDefaultMaxPages(int i) {
        this.f292g = i;
    }

    @Deprecated
    public void setLightMode() {
        setDayNightStyle(2);
    }

    public void setListViewStartEndPadding(@Px int i, @Px int i2) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.car_card_margin);
        int max = Math.max(i - (this.f286a ? dimensionPixelSize : 0), 0);
        if (!this.f287b) {
            dimensionPixelSize = 0;
        }
        this.mRecyclerView.setPaddingRelative(max, this.mRecyclerView.getPaddingTop(), Math.max(i2 - dimensionPixelSize, 0), this.mRecyclerView.getPaddingBottom());
        this.mRecyclerView.setClipToPadding(this.mRecyclerView.getClipChildren());
    }

    public void setMaxPages(int i) {
        this.f290e = i;
        updateMaxItems();
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
        this.mLayoutManager.setOnScrollListener(this.mOnScrollListener);
    }

    /* access modifiers changed from: protected */
    public boolean shouldEnablePageDownButton() {
        return !this.mLayoutManager.isAtBottom();
    }

    /* access modifiers changed from: protected */
    public boolean shouldEnablePageUpButton() {
        return !this.mLayoutManager.isAtTop();
    }

    /* access modifiers changed from: protected */
    @UiThread
    public void updateMaxItems() {
        if (this.mAdapter != null) {
            int itemCount = this.mAdapter.getItemCount();
            updateRowsPerPage();
            this.mAdapter.setMaxItems(calculateMaxItemCount());
            int itemCount2 = this.mAdapter.getItemCount();
            if (itemCount2 == itemCount) {
                return;
            }
            if (itemCount2 < itemCount) {
                this.mAdapter.notifyItemRangeRemoved(itemCount2, itemCount - itemCount2);
            } else {
                this.mAdapter.notifyItemRangeInserted(itemCount, itemCount2 - itemCount);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void updatePaginationButtons(boolean z) {
        if (this.f286a) {
            if ((!this.mLayoutManager.isAtTop() || !this.mLayoutManager.isAtBottom()) && this.mLayoutManager.getItemCount() != 0) {
                this.f288c.setVisibility(0);
            } else {
                this.f288c.setVisibility(4);
            }
            this.f288c.setUpEnabled(shouldEnablePageUpButton());
            this.f288c.setDownEnabled(shouldEnablePageDownButton());
            this.f288c.setParameters(this.mRecyclerView.computeVerticalScrollRange(), this.mRecyclerView.computeVerticalScrollOffset(), this.mRecyclerView.computeVerticalScrollExtent(), z);
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void updateRowsPerPage() {
        View childAt = this.mLayoutManager.getChildAt(0);
        if (childAt == null || childAt.getHeight() == 0) {
            this.f289d = 1;
        } else {
            this.f289d = Math.max(1, (getHeight() - getPaddingTop()) / childAt.getHeight());
        }
    }
}
