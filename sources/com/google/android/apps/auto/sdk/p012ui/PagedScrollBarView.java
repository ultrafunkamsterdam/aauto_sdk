package com.google.android.apps.auto.sdk.p012ui;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* renamed from: com.google.android.apps.auto.sdk.ui.PagedScrollBarView */
public class PagedScrollBarView extends FrameLayout implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: a */
    private int f302a;

    /* renamed from: b */
    private final ImageView f303b;

    /* renamed from: c */
    private final ImageView f304c;

    /* renamed from: d */
    private final ImageView f305d;

    /* renamed from: e */
    private final View f306e;

    /* renamed from: f */
    private final Interpolator f307f;

    /* renamed from: g */
    private final int f308g;

    /* renamed from: h */
    private final int f309h;

    /* renamed from: i */
    private PaginationListener f310i;

    /* renamed from: com.google.android.apps.auto.sdk.ui.PagedScrollBarView$PaginationListener */
    public interface PaginationListener {
        public static final int PAGE_DOWN = 1;
        public static final int PAGE_UP = 0;

        void onPaginate(int i);
    }

    public PagedScrollBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
    }

    public PagedScrollBarView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PagedScrollBarView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f307f = new AccelerateDecelerateInterpolator();
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.car_paged_scrollbar_buttons, this, true);
        this.f303b = (ImageView) findViewById(R.id.page_up);
        this.f303b.setOnClickListener(this);
        this.f303b.setOnLongClickListener(this);
        this.f304c = (ImageView) findViewById(R.id.page_down);
        this.f304c.setOnClickListener(this);
        this.f304c.setOnLongClickListener(this);
        this.f305d = (ImageView) findViewById(R.id.scrollbar_thumb);
        this.f306e = findViewById(R.id.filler);
        this.f308g = getResources().getDimensionPixelSize(R.dimen.min_thumb_height);
        this.f309h = getResources().getDimensionPixelSize(R.dimen.max_thumb_height);
        if (!context.getResources().getBoolean(R.bool.car_true_for_touch)) {
            this.f303b.setVisibility(8);
            this.f304c.setVisibility(8);
        }
    }

    /* renamed from: a */
    private final void m346a(View view) {
        PaginationListener paginationListener = this.f310i;
        if (paginationListener != null) {
            paginationListener.onPaginate(view.getId() == R.id.page_up ? 0 : 1);
        }
    }

    public boolean isDownEnabled() {
        return this.f304c.isEnabled();
    }

    public boolean isDownPressed() {
        return this.f304c.isPressed();
    }

    public boolean isUpPressed() {
        return this.f303b.isPressed();
    }

    public void onClick(View view) {
        m346a(view);
    }

    public boolean onLongClick(View view) {
        m346a(view);
        return true;
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
        int color;
        int color2;
        int i2;
        this.f302a = i;
        switch (this.f302a) {
            case 0:
                color = ContextCompat.getColor(getContext(), R.color.car_tint);
                color2 = ContextCompat.getColor(getContext(), R.color.car_scrollbar_thumb);
                i2 = R.drawable.car_pagination_background;
                break;
            case 1:
                color = ContextCompat.getColor(getContext(), R.color.car_tint_inverse);
                color2 = ContextCompat.getColor(getContext(), R.color.car_scrollbar_thumb_inverse);
                i2 = R.drawable.car_pagination_background_inverse;
                break;
            case 2:
                color = ContextCompat.getColor(getContext(), R.color.car_tint_night);
                color2 = ContextCompat.getColor(getContext(), R.color.car_scrollbar_thumb_night);
                i2 = R.drawable.car_pagination_background_night;
                break;
            case 3:
                color = ContextCompat.getColor(getContext(), R.color.car_tint_day);
                color2 = ContextCompat.getColor(getContext(), R.color.car_scrollbar_thumb_day);
                i2 = R.drawable.car_pagination_background_day;
                break;
            default:
                throw new IllegalArgumentException(new StringBuilder(34).append("Unknown DayNightStyle: ").append(this.f302a).toString());
        }
        this.f305d.setBackgroundColor(color2);
        this.f303b.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        this.f303b.setBackgroundResource(i2);
        this.f304c.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        this.f304c.setBackgroundResource(i2);
    }

    public void setDownEnabled(boolean z) {
        this.f304c.setEnabled(z);
        this.f304c.setAlpha(z ? 1.0f : 0.2f);
    }

    @Deprecated
    public void setLightMode() {
        setDayNightStyle(2);
    }

    public void setPaginationListener(PaginationListener paginationListener) {
        this.f310i = paginationListener;
    }

    public void setParameters(int i, int i2, int i3, boolean z) {
        int height = (this.f306e.getHeight() - this.f306e.getPaddingTop()) - this.f306e.getPaddingBottom();
        int max = Math.max(Math.min((i3 * height) / i, this.f309h), this.f308g);
        int i4 = height - max;
        if (isDownEnabled()) {
            i4 = (i4 * i2) / i;
        }
        ViewGroup.LayoutParams layoutParams = this.f305d.getLayoutParams();
        if (layoutParams.height != max) {
            layoutParams.height = max;
            this.f305d.requestLayout();
        }
        this.f305d.animate().y((float) i4).setDuration((long) (z ? 200 : 0)).setInterpolator(this.f307f).start();
    }

    public void setUpEnabled(boolean z) {
        this.f303b.setEnabled(z);
        this.f303b.setAlpha(z ? 1.0f : 0.2f);
    }
}
