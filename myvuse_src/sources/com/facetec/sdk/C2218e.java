package com.facetec.sdk;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.Random;

/* JADX INFO: renamed from: com.facetec.sdk.e */
/* JADX INFO: loaded from: classes3.dex */
class C2218e extends View {

    /* JADX INFO: renamed from: B */
    int f3219B;

    /* JADX INFO: renamed from: C */
    private boolean f3220C;
    private V Code;

    /* JADX INFO: renamed from: D */
    private final Context f3221D;

    /* JADX INFO: renamed from: F */
    private RectF f3222F;

    /* JADX INFO: renamed from: I */
    float f3223I;

    /* JADX INFO: renamed from: L */
    private boolean f3224L;

    /* JADX INFO: renamed from: S */
    private Paint f3225S;

    /* JADX INFO: renamed from: V */
    int f3226V;

    /* JADX INFO: renamed from: b */
    private float f3227b;

    /* JADX INFO: renamed from: c */
    private Paint f3228c;

    /* JADX INFO: renamed from: d */
    private float f3229d;

    /* JADX INFO: renamed from: e */
    private float f3230e;

    /* JADX INFO: renamed from: com.facetec.sdk.e$V */
    enum V {
        DEFAULT,
        SMALL_FOR_OVERZOOMED
    }

    public C2218e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Code = V.DEFAULT;
        this.f3224L = false;
        this.f3220C = false;
        this.f3221D = context;
        post(new Runnable() { // from class: com.facetec.sdk.e.2
            @Override // java.lang.Runnable
            public final void run() {
                C2218e.this.m2083S();
            }
        });
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF;
        Paint paint;
        canvas.drawColor(C2156av.m1620B(C2156av.m1646I(this.f3221D), 255));
        if (!this.f3224L || (rectF = this.f3222F) == null || (paint = this.f3225S) == null || this.f3228c == null) {
            return;
        }
        int i = this.f3226V;
        canvas.drawRoundRect(rectF, i, i, paint);
        RectF rectF2 = this.f3222F;
        int i2 = this.f3226V;
        canvas.drawRoundRect(rectF2, i2, i2, this.f3228c);
    }

    public final RectF Code() {
        if (this.f3222F == null) {
            m2087V(false);
        }
        return this.f3222F;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: B */
    public void m2077B() {
        this.f3224L = true;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m2087V(true);
        m2077B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: S */
    public void m2083S() {
        this.f3226V = Math.round(C2188cb.m1993V(C2156av.m1776s()) * C2156av.Code());
        this.f3219B = Math.round(C2188cb.m1993V(C2156av.m1758f()) * C2156av.Code());
        m2078B(C2156av.m1675V());
        post(new Runnable() { // from class: com.facetec.sdk.e.4
            @Override // java.lang.Runnable
            public final void run() {
                C2218e.this.setLayerType(1, null);
                C2218e.this.f3225S = new Paint(1);
                C2218e.this.f3225S.setStyle(Paint.Style.FILL);
                C2218e.this.f3225S.setAlpha(0);
                C2218e.this.f3225S.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                C2218e.this.setLayerType(2, null);
                C2218e.this.f3228c = new Paint(1);
                C2218e.this.f3228c.setStyle(Paint.Style.STROKE);
                C2218e.this.f3228c.setStrokeWidth(Math.round(C2218e.this.f3219B));
                C2218e.this.f3228c.setColor(C2156av.m1621B(C2218e.this.f3221D));
            }
        });
    }

    /* JADX INFO: renamed from: V */
    private void m2087V(boolean z) {
        if (!this.f3220C || z) {
            this.f3220C = true;
            int width = getWidth();
            int height = getHeight();
            float f = width;
            float fM1675V = (f - (C2156av.m1675V() * 2.0f)) * m2082L();
            float f2 = height;
            float f3 = (f2 - (0.632f * fM1675V)) / 2.0f;
            float f4 = (f - fM1675V) / 2.0f;
            m2078B(f4);
            RectF rectF = new RectF();
            this.f3222F = rectF;
            rectF.set(f4, f3, f - f4, f2 - f3);
            AbstractC2165be.f2781V = this.f3222F.centerX();
            AbstractC2165be.f2780S = this.f3222F.centerY();
        }
    }

    /* JADX INFO: renamed from: B */
    private void m2078B(float f) {
        this.f3229d = f;
        this.f3230e = f / 1.5f;
        this.f3227b = getWidth() / 2.0f;
        this.f3223I = this.f3229d;
    }

    /* JADX INFO: renamed from: I */
    public final void m2092I(final Runnable runnable) {
        final Runnable runnable2 = new Runnable() { // from class: com.facetec.sdk.e.5
            @Override // java.lang.Runnable
            public final void run() {
                C2218e.m2080B(C2218e.this, new Runnable() { // from class: com.facetec.sdk.e.5.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                });
            }
        };
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f3223I, this.f3230e);
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facetec.sdk.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C2218e.this.f3223I = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                C2218e c2218e = C2218e.this;
                c2218e.f3222F = C2218e.m2086V(c2218e, c2218e.f3223I);
                C2218e.this.m2077B();
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.facetec.sdk.e.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Runnable runnable3 = runnable2;
                if (runnable3 != null) {
                    runnable3.run();
                }
            }
        });
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: renamed from: I */
    public final void m2091I() {
        this.f3228c.setStrokeWidth(Math.round(this.f3219B));
        this.f3226V = Math.round(C2188cb.m1993V(C2156av.m1776s()) * C2156av.Code());
        this.f3223I = this.f3229d;
        m2087V(true);
        m2077B();
    }

    /* JADX INFO: renamed from: com.facetec.sdk.e$9, reason: invalid class name */
    final class AnonymousClass9 extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: Z */
        final /* synthetic */ Runnable f3237Z;

        AnonymousClass9(Runnable runnable) {
            this.f3237Z = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(C2218e.this.f3219B, 0.0f);
            valueAnimatorOfFloat.setDuration(100L);
            valueAnimatorOfFloat.setInterpolator(new AccelerateInterpolator());
            valueAnimatorOfFloat.addUpdateListener(this);
            valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.facetec.sdk.e.9.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (AnonymousClass9.this.f3237Z != null) {
                        AnonymousClass9.this.f3237Z.run();
                    }
                }
            });
            valueAnimatorOfFloat.start();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            C2218e.this.f3228c.setStrokeWidth(((Float) valueAnimator.getAnimatedValue()).floatValue());
            C2218e.this.m2077B();
        }
    }

    /* JADX INFO: renamed from: V */
    public final void m2093V() {
        m2090Z(V.DEFAULT);
    }

    /* JADX INFO: renamed from: Z */
    public final void m2094Z() {
        m2090Z(V.SMALL_FOR_OVERZOOMED);
    }

    /* JADX INFO: renamed from: Z */
    private void m2090Z(V v) {
        this.Code = v;
        m2083S();
        m2091I();
    }

    /* JADX INFO: renamed from: L */
    private float m2082L() {
        if (this.Code != V.SMALL_FOR_OVERZOOMED) {
            return 1.0f;
        }
        return 1.0f / (((new Random().nextInt(Math.round(0.050000004f) + 1) / 100.0f) + 0.1f) + 1.0f);
    }

    /* JADX INFO: renamed from: B */
    static /* synthetic */ void m2080B(C2218e c2218e, Runnable runnable) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(c2218e.f3223I, c2218e.f3227b);
        valueAnimatorOfFloat.setDuration(400L);
        valueAnimatorOfFloat.setInterpolator(new AccelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facetec.sdk.e.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C2218e.this.f3223I = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                C2218e c2218e2 = C2218e.this;
                c2218e2.f3222F = C2218e.m2086V(c2218e2, c2218e2.f3223I);
                C2218e c2218e3 = C2218e.this;
                c2218e3.f3226V = C2218e.m2088Z(c2218e3, c2218e3.f3223I);
                C2218e.this.m2077B();
            }
        });
        valueAnimatorOfFloat.addListener(c2218e.new AnonymousClass9(runnable));
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: renamed from: V */
    static /* synthetic */ RectF m2086V(C2218e c2218e, float f) {
        float width = c2218e.getWidth();
        float height = c2218e.getHeight();
        float f2 = (height - ((width - (f * 2.0f)) * 0.632f)) / 2.0f;
        return new RectF(f, f2, width - f, height - f2);
    }

    /* JADX INFO: renamed from: Z */
    static /* synthetic */ int m2088Z(C2218e c2218e, float f) {
        return Math.min(Math.round(((c2218e.getWidth() - (f * 2.0f)) * 0.632f) / 2.0f), c2218e.f3226V);
    }
}
