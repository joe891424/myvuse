package com.yoti.mobile.android.common.p049ui.widgets;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;

/* JADX INFO: loaded from: classes5.dex */
public class HorizontalScrollingGradient extends View {

    /* JADX INFO: renamed from: a */
    private final boolean f5949a;

    /* JADX INFO: renamed from: b */
    private Path f5950b;

    /* JADX INFO: renamed from: c */
    private Drawable f5951c;

    /* JADX INFO: renamed from: d */
    private Rect f5952d;

    /* JADX INFO: renamed from: e */
    private int f5953e;

    /* JADX INFO: renamed from: f */
    private int f5954f;

    /* JADX INFO: renamed from: g */
    private int f5955g;

    /* JADX INFO: renamed from: h */
    private int f5956h;

    /* JADX INFO: renamed from: i */
    private ValueAnimator f5957i;

    /* JADX INFO: renamed from: j */
    private boolean f5958j;

    /* JADX INFO: renamed from: k */
    private int f5959k;

    /* JADX INFO: renamed from: l */
    private boolean f5960l;

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.HorizontalScrollingGradient$a */
    class C4477a implements ValueAnimator.AnimatorUpdateListener {
        C4477a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            HorizontalScrollingGradient.this.f5953e = ((Float) valueAnimator.getAnimatedValue()).intValue();
            HorizontalScrollingGradient.this.invalidate();
        }
    }

    public HorizontalScrollingGradient(Context context) {
        this(context, null);
    }

    public HorizontalScrollingGradient(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C4584R.styleable.HorizontalScrollingGradient, 0, 0);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(C4584R.styleable.HorizontalScrollingGradient_isCircle, false);
        this.f5949a = z;
        if (z) {
            this.f5950b = new Path();
        }
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(C4584R.styleable.HorizontalScrollingGradient_drawable);
        if (drawable == null) {
            throw new IllegalArgumentException("HorizontalScrollingGradient.drawable must be set");
        }
        this.f5951c = drawable;
        this.f5956h = typedArrayObtainStyledAttributes.getDimensionPixelSize(C4584R.styleable.HorizontalScrollingGradient_drawableWidthDp, drawable.getIntrinsicWidth());
        this.f5959k = typedArrayObtainStyledAttributes.getInt(C4584R.styleable.HorizontalScrollingGradient_durationMs, 1000);
        typedArrayObtainStyledAttributes.recycle();
        this.f5952d = new Rect();
    }

    /* JADX INFO: renamed from: a */
    private void m4396a() {
        if (this.f5957i == null) {
            ValueAnimator valueAnimatorOfFloat = m4397b() ? ValueAnimator.ofFloat(-this.f5956h, this.f5955g) : ValueAnimator.ofFloat(this.f5955g, -this.f5956h);
            this.f5957i = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setRepeatCount(-1);
            this.f5957i.setDuration(this.f5959k);
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m4397b() {
        return getLayoutDirection() == 0;
    }

    /* JADX INFO: renamed from: c */
    private void m4398c() {
        this.f5958j = false;
        ValueAnimator valueAnimator = this.f5957i;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f5957i.removeAllUpdateListeners();
            this.f5957i.end();
            invalidate();
        }
    }

    public void dismiss() {
        this.f5960l = true;
        m4398c();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m4398c();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f5958j) {
            Rect rect = this.f5952d;
            int i = this.f5953e;
            rect.left = i;
            rect.top = 0;
            rect.right = i + this.f5956h;
            rect.bottom = this.f5954f;
            this.f5951c.setBounds(rect);
            Path path = this.f5950b;
            if (path != null) {
                canvas.clipPath(path);
            }
            this.f5951c.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f5955g = getMeasuredWidth();
        this.f5954f = getMeasuredHeight();
        this.f5953e = m4397b() ? -this.f5956h : this.f5955g;
        if (this.f5949a) {
            float f = this.f5955g / 2;
            float f2 = this.f5954f / 2;
            this.f5950b.addCircle(f, f2, Math.max(f, f2), Path.Direction.CCW);
        }
        if (getVisibility() == 0) {
            startAnimation();
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            m4398c();
        } else {
            startAnimation();
        }
    }

    public void startAnimation() {
        if (this.f5958j || this.f5960l || this.f5955g == 0 || this.f5954f == 0) {
            return;
        }
        this.f5958j = true;
        m4396a();
        this.f5957i.removeAllListeners();
        this.f5957i.removeAllUpdateListeners();
        this.f5957i.addUpdateListener(new C4477a());
        this.f5957i.start();
        invalidate();
    }
}
