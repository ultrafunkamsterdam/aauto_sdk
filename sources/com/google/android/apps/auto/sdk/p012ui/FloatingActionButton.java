package com.google.android.apps.auto.sdk.p012ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Checkable;
import android.widget.ImageButton;

/* renamed from: com.google.android.apps.auto.sdk.ui.FloatingActionButton */
public class FloatingActionButton extends ImageButton implements Checkable {

    /* renamed from: h */
    private static final int[] f270h = {16842912};

    /* renamed from: a */
    private Animation f271a;

    /* renamed from: b */
    private Animation f272b;

    /* renamed from: c */
    private Drawable f273c;

    /* renamed from: d */
    private C0093b f274d;

    /* renamed from: e */
    private boolean f275e;

    /* renamed from: f */
    private boolean f276f;

    /* renamed from: g */
    private OnCheckedChangeListener f277g;

    /* renamed from: com.google.android.apps.auto.sdk.ui.FloatingActionButton$OnCheckedChangeListener */
    public interface OnCheckedChangeListener {
        void onCheckedChanged(FloatingActionButton floatingActionButton, boolean z);
    }

    /* renamed from: com.google.android.apps.auto.sdk.ui.FloatingActionButton$a */
    static final class C0092a extends View.BaseSavedState {
        public static final Parcelable.Creator<C0092a> CREATOR = new C0097d();

        /* renamed from: a */
        boolean f278a;

        private C0092a(Parcel parcel) {
            super(parcel);
            this.f278a = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
        }

        /* synthetic */ C0092a(Parcel parcel, byte b) {
            this(parcel);
        }

        C0092a(Parcelable parcelable) {
            super(parcelable);
        }

        public final String toString() {
            String hexString = Integer.toHexString(System.identityHashCode(this));
            return new StringBuilder(String.valueOf(hexString).length() + 47).append("FloatingActionButton.SavedState{").append(hexString).append(" checked=").append(this.f278a).append("}").toString();
        }

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f278a));
        }
    }

    /* renamed from: com.google.android.apps.auto.sdk.ui.FloatingActionButton$b */
    enum C0093b {
        Custom(0, 0),
        Oval(1, R.drawable.car_oval_button_ripple),
        Rectangular(2, R.drawable.car_rectangular_button_ripple),
        Toggle(3, R.drawable.car_toggle_button_ripple);
        

        /* renamed from: b */
        final int f284b;

        private C0093b(int i, int i2) {
            this.f284b = i2;
        }
    }

    public FloatingActionButton(Context context) {
        this(context, (AttributeSet) null, R.attr.carButtonStyle, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.carButtonStyle, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton, i, i2);
        try {
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.FloatingActionButton_focusGainedAnimation, 0);
            if (resourceId != 0) {
                this.f271a = AnimationUtils.loadAnimation(getContext(), resourceId);
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.FloatingActionButton_focusLostAnimation, 0);
            if (resourceId2 != 0) {
                this.f272b = AnimationUtils.loadAnimation(getContext(), resourceId2);
            }
            this.f274d = C0093b.values()[obtainStyledAttributes.getInt(R.styleable.FloatingActionButton_buttonType, 0)];
            C0093b bVar = this.f274d;
            this.f273c = bVar.f284b == 0 ? null : getContext().getDrawable(bVar.f284b);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public boolean isChecked() {
        return this.f275e;
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(f270h.length + i);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f270h);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z) {
            if (this.f271a != null) {
                startAnimation(this.f271a);
            }
        } else if (this.f272b != null) {
            startAnimation(this.f272b);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        C0092a aVar = (C0092a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        setChecked(aVar.f278a);
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        C0092a aVar = new C0092a(super.onSaveInstanceState());
        aVar.f278a = isChecked();
        return aVar;
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            if (this.f272b != null) {
                startAnimation(this.f272b);
            }
            if (this.f273c != null) {
                setBackground(this.f273c);
            }
            String valueOf = String.valueOf(getResources().getResourceEntryName(getId()));
            Log.i("FloatingActionButton", valueOf.length() != 0 ? "id: ".concat(valueOf) : new String("id: "));
            String valueOf2 = String.valueOf(this.f274d);
            Log.i("FloatingActionButton", new StringBuilder(String.valueOf(valueOf2).length() + 7).append("mType: ").append(valueOf2).toString());
            String valueOf3 = String.valueOf(this.f271a);
            Log.i("FloatingActionButton", new StringBuilder(String.valueOf(valueOf3).length() + 23).append("mFocusGainedAnimation: ").append(valueOf3).toString());
            String valueOf4 = String.valueOf(this.f272b);
            Log.i("FloatingActionButton", new StringBuilder(String.valueOf(valueOf4).length() + 21).append("mFocusLostAnimation: ").append(valueOf4).toString());
            String valueOf5 = String.valueOf(this.f273c);
            Log.i("FloatingActionButton", new StringBuilder(String.valueOf(valueOf5).length() + 13).append("mBackground: ").append(valueOf5).toString());
            Log.i("FloatingActionButton", new StringBuilder(17).append("mIsChecked: ").append(this.f275e).toString());
            Log.i("FloatingActionButton", new StringBuilder(22).append("mIsBroadcasting: ").append(this.f276f).toString());
            String valueOf6 = String.valueOf(this.f277g);
            Log.i("FloatingActionButton", new StringBuilder(String.valueOf(valueOf6).length() + 26).append("mOnCheckedChangeListener: ").append(valueOf6).toString());
        }
    }

    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void setChecked(boolean z) {
        if (this.f275e != z) {
            this.f275e = z;
            refreshDrawableState();
            if (!this.f276f) {
                this.f276f = true;
                if (this.f277g != null) {
                    this.f277g.onCheckedChanged(this, this.f275e);
                }
                this.f276f = false;
            }
        }
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f277g = onCheckedChangeListener;
    }

    public void toggle() {
        if (this.f274d == C0093b.Toggle) {
            setChecked(!this.f275e);
        }
    }
}
