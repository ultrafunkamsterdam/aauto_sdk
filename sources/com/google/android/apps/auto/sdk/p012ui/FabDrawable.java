package com.google.android.apps.auto.sdk.p012ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.DecelerateInterpolator;

/* renamed from: com.google.android.apps.auto.sdk.ui.FabDrawable */
public class FabDrawable extends Drawable {

    /* renamed from: a */
    private final int f261a;

    /* renamed from: b */
    private final int f262b;

    /* renamed from: c */
    private final Paint f263c;

    /* renamed from: d */
    private final Paint f264d;

    /* renamed from: e */
    private final ValueAnimator f265e;

    /* renamed from: f */
    private boolean f266f;

    /* renamed from: g */
    private int f267g;

    /* renamed from: h */
    private int f268h;

    /* renamed from: i */
    private Outline f269i;

    public FabDrawable(int i, int i2, int i3) {
        this.f263c = new Paint(1);
        this.f264d = new Paint(1);
        if (i < 0) {
            throw new IllegalArgumentException("Fab growth must be >= 0.");
        } else if (i > i2) {
            throw new IllegalArgumentException("Fab growth must be <= strokeWidth.");
        } else if (i2 < 0) {
            throw new IllegalArgumentException("Stroke width must be >= 0.");
        } else {
            this.f261a = i;
            this.f262b = i2;
            this.f265e = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration((long) i3);
            this.f265e.setInterpolator(new DecelerateInterpolator());
            this.f265e.addUpdateListener(new C0096c(this));
        }
    }

    public FabDrawable(Context context) {
        this(context.getResources().getDimensionPixelSize(R.dimen.car_fab_focused_growth), context.getResources().getDimensionPixelSize(R.dimen.car_fab_focused_stroke_width), context.getResources().getInteger(R.integer.car_fab_animation_duration));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m340a() {
        int min = (Math.min(getBounds().width(), getBounds().height()) / 2) - this.f262b;
        float animatedFraction = this.f265e.getAnimatedFraction();
        this.f268h = (int) (((float) min) + (((float) this.f262b) * animatedFraction));
        this.f267g = (int) (((float) min) + (animatedFraction * ((float) this.f261a)));
        m342b();
        invalidateSelf();
    }

    /* renamed from: b */
    private final void m342b() {
        int width = getBounds().width() / 2;
        int height = getBounds().height() / 2;
        if (this.f269i != null) {
            this.f269i.setRoundRect(width - this.f268h, height - this.f268h, width + this.f268h, height + this.f268h, (float) this.f268h);
        }
    }

    public void draw(Canvas canvas) {
        int width = canvas.getWidth() / 2;
        int height = canvas.getHeight() / 2;
        canvas.drawCircle((float) width, (float) height, (float) this.f268h, this.f264d);
        canvas.drawCircle((float) width, (float) height, (float) this.f267g, this.f263c);
    }

    public int getOpacity() {
        return -1;
    }

    public void getOutline(Outline outline) {
        this.f269i = outline;
        m342b();
    }

    public boolean isStateful() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        m340a();
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        boolean z = false;
        boolean z2 = false;
        for (int i : iArr) {
            if (i == 16842908) {
                z = true;
            }
            if (i == 16842919) {
                z2 = true;
            }
        }
        if ((z || z2) && this.f266f) {
            this.f265e.start();
            this.f266f = false;
        } else if (!z && !z2 && !this.f266f) {
            this.f265e.reverse();
            this.f266f = true;
        }
        return onStateChange || z;
    }

    public void setAlpha(int i) {
        this.f263c.setAlpha(i);
        this.f264d.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f263c.setColorFilter(colorFilter);
        this.f264d.setColorFilter(colorFilter);
    }

    public void setFabAndStrokeColor(int i) {
        setFabAndStrokeColor(i, 0.9f);
    }

    public void setFabAndStrokeColor(int i, float f) {
        setFabColor(i);
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[2] = fArr[2] * f;
        setStrokeColor(Color.HSVToColor(fArr));
    }

    public void setFabColor(int i) {
        this.f263c.setColor(i);
    }

    public void setStrokeColor(int i) {
        this.f264d.setColor(i);
    }
}
