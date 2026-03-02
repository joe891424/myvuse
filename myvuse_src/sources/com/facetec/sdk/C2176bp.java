package com.facetec.sdk;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: renamed from: com.facetec.sdk.bp */
/* JADX INFO: loaded from: classes3.dex */
class C2176bp extends C2182bv {

    /* JADX INFO: renamed from: B */
    public Paint f2912B;

    /* JADX INFO: renamed from: D */
    private final Matrix f2913D;

    /* JADX INFO: renamed from: L */
    private Drawable f2914L;

    /* JADX INFO: renamed from: S */
    private final Context f2915S;

    /* JADX INFO: renamed from: a */
    private int f2916a;

    /* JADX INFO: renamed from: b */
    private float f2917b;

    /* JADX INFO: renamed from: c */
    private final float[] f2918c;

    /* JADX INFO: renamed from: d */
    private float f2919d;

    /* JADX INFO: renamed from: e */
    private boolean f2920e;

    public C2176bp(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2913D = new Matrix();
        this.f2918c = new float[9];
        this.f2919d = 0.0f;
        this.f2917b = 0.0f;
        this.f2920e = false;
        this.f2916a = -1;
        this.f2915S = context;
        post(new Runnable() { // from class: com.facetec.sdk.bp.5
            @Override // java.lang.Runnable
            public final void run() {
                C2176bp.m1920I(C2176bp.this);
            }
        });
    }

    @Override // com.facetec.sdk.C2182bv, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = this.f2914L;
        if (drawable != null) {
            drawable.draw(canvas);
            if (!this.f2920e || this.f2961V == null || this.f2957F == null || this.f2955C == null || this.f2912B == null || this.f2958I == null || this.Code == null) {
                return;
            }
            canvas.concat(this.f2913D);
            canvas.drawOval(this.f2961V, this.f2958I);
            canvas.drawOval(this.f2955C, this.f2912B);
            canvas.drawOval(this.f2957F, this.Code);
            return;
        }
        canvas.drawColor(C2156av.m1620B(C2156av.m1753c(this.f2915S), 255));
    }

    /* JADX INFO: renamed from: com.facetec.sdk.bp$1, reason: invalid class name */
    final class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener, Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(C2176bp.this.f2912B.getColor()), Integer.valueOf(C2156av.m1757e(C2176bp.this.f2915S)));
            valueAnimatorOfObject.setDuration(1000L);
            valueAnimatorOfObject.addUpdateListener(this);
            valueAnimatorOfObject.start();
            ValueAnimator valueAnimatorOfObject2 = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(C2176bp.this.Code.getColor()), Integer.valueOf(C2156av.m1750b(C2176bp.this.f2915S)));
            valueAnimatorOfObject2.setDuration(1000L);
            valueAnimatorOfObject2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facetec.sdk.bp.1.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (C2176bp.this.Code == null) {
                        return;
                    }
                    C2176bp.this.Code.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    C2176bp.this.postInvalidateOnAnimation();
                }
            });
            valueAnimatorOfObject2.start();
            ValueAnimator valueAnimatorOfFloat = ObjectAnimator.ofFloat(0.0f, 1.0f);
            final int iM1643H = C2156av.m1643H();
            valueAnimatorOfFloat.setDuration(1000L);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facetec.sdk.bp.1.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (C2176bp.this.f2914L == null) {
                        return;
                    }
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    C2176bp.this.f2914L.setColorFilter(C2156av.m1676V(iM1643H, fFloatValue), PorterDuff.Mode.SRC_ATOP);
                    double d = fFloatValue;
                    if (d == 0.0d || d == 1.0d) {
                        if (d == 1.0d) {
                            ((GradientDrawable) C2176bp.this.f2914L).setColor(iM1643H);
                        }
                        C2176bp.this.f2914L.setColorFilter(null);
                    }
                    C2176bp.this.postInvalidateOnAnimation();
                }
            });
            valueAnimatorOfFloat.start();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (C2176bp.this.f2912B == null) {
                return;
            }
            C2176bp.this.f2912B.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            C2176bp.this.postInvalidateOnAnimation();
        }
    }

    /* JADX INFO: renamed from: Z */
    public final void m1925Z() {
        postDelayed(new AnonymousClass1(), 0L);
    }

    /* JADX INFO: renamed from: com.facetec.sdk.bp$3, reason: invalid class name */
    final class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener, Runnable {

        /* JADX INFO: renamed from: I */
        private /* synthetic */ int f2925I;

        /* JADX INFO: renamed from: V */
        private /* synthetic */ int f2926V;

        AnonymousClass3(int i, int i2) {
            this.f2925I = i;
            this.f2926V = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(255, this.f2925I);
            valueAnimatorOfInt.setDuration(this.f2926V);
            valueAnimatorOfInt.addUpdateListener(this);
            valueAnimatorOfInt.start();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (C2176bp.this.f2914L == null) {
                return;
            }
            C2176bp.this.f2914L.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            C2176bp.this.postInvalidateOnAnimation();
        }
    }

    public final void Code(int i, int i2, int i3) {
        postDelayed(new AnonymousClass3(i, i2), i3);
    }

    /* JADX INFO: renamed from: com.facetec.sdk.bp$4, reason: invalid class name */
    final class AnonymousClass4 implements ValueAnimator.AnimatorUpdateListener, Runnable {

        /* JADX INFO: renamed from: I */
        private /* synthetic */ int f2927I = 1000;

        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(255, C2156av.m1678V(C2176bp.this.f2915S, FaceTecSDK.f2235I.f2215L.readyScreenOvalFillColor));
            valueAnimatorOfInt.setDuration(this.f2927I);
            valueAnimatorOfInt.addUpdateListener(this);
            ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(255, C2156av.m1678V(C2176bp.this.f2915S, FaceTecSDK.f2235I.f2221c.strokeColor));
            valueAnimatorOfInt2.setDuration(this.f2927I);
            valueAnimatorOfInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facetec.sdk.bp.4.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (C2176bp.this.Code == null) {
                        return;
                    }
                    C2176bp.this.Code.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    C2176bp.this.postInvalidateOnAnimation();
                }
            });
            valueAnimatorOfInt.start();
            valueAnimatorOfInt2.start();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (C2176bp.this.f2912B == null) {
                return;
            }
            C2176bp.this.f2912B.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            C2176bp.this.postInvalidateOnAnimation();
        }
    }

    public final void Code() {
        postDelayed(new AnonymousClass4(), 0L);
    }

    /* JADX INFO: renamed from: B */
    public final void m1923B() {
        this.f2920e = true;
        float fCode = getResources().getDisplayMetrics().widthPixels * C2156av.Code();
        this.f2919d = fCode;
        this.f2913D.setTranslate(fCode, 0.0f);
        post(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: com.facetec.sdk.bp$2, reason: invalid class name */
    final class AnonymousClass2 implements ValueAnimator.AnimatorUpdateListener, Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ValueAnimator valueAnimatorOfFloat = ObjectAnimator.ofFloat(C2176bp.this.f2919d, 0.0f);
            valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            valueAnimatorOfFloat.setDuration(800L);
            valueAnimatorOfFloat.addUpdateListener(this);
            valueAnimatorOfFloat.start();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (C2176bp.this.f2913D == null) {
                return;
            }
            C2176bp.this.f2913D.getValues(C2176bp.this.f2918c);
            float f = C2176bp.this.f2919d - C2176bp.this.f2918c[2];
            C2176bp.this.f2917b = -((valueAnimator.getAnimatedFraction() * C2176bp.this.f2919d) - f);
            C2176bp.this.f2913D.postTranslate(C2176bp.this.f2917b, 0.0f);
            C2176bp.this.postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int width = getWidth();
        if (width != this.f2916a) {
            if (this.f2914L == null) {
                Drawable drawableM1763h = C2156av.m1763h(this.f2915S);
                this.f2914L = drawableM1763h;
                drawableM1763h.setAlpha(255);
            }
            this.f2914L.setBounds(0, 0, getWidth(), getHeight());
            if (this.f2916a != -1) {
                m1963V(true);
            }
            this.f2916a = width;
        }
    }

    /* JADX INFO: renamed from: I */
    public final void m1924I() {
        this.f2920e = true;
        postInvalidate();
    }

    /* JADX INFO: renamed from: I */
    static /* synthetic */ void m1920I(C2176bp c2176bp) {
        c2176bp.setLayerType(2, null);
        Paint paint = new Paint(1);
        c2176bp.f2912B = paint;
        paint.setStyle(Paint.Style.FILL);
        c2176bp.f2912B.setColor(C2156av.m1757e(c2176bp.f2915S));
    }
}
