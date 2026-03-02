package com.facetec.sdk;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.facetec.sdk.m */
/* JADX INFO: loaded from: classes3.dex */
class C2223m extends View {

    /* JADX INFO: renamed from: B */
    private ArrayList<B> f3509B;
    private boolean Code;

    /* JADX INFO: renamed from: I */
    private int f3510I;

    /* JADX INFO: renamed from: V */
    private int f3511V;

    /* JADX INFO: renamed from: com.facetec.sdk.m$I */
    static class I {
        float Code = 0.0f;

        /* JADX INFO: renamed from: I */
        float f3521I;

        /* JADX INFO: renamed from: Z */
        float f3522Z;

        public I(float f, float f2) {
            this.f3522Z = f;
            this.f3521I = f2;
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.m$B */
    class B {

        /* JADX INFO: renamed from: B */
        Paint f3517B;

        /* JADX INFO: renamed from: I */
        I f3518I;

        /* JADX INFO: renamed from: Z */
        float f3520Z = 0.0f;

        /* JADX INFO: renamed from: V */
        private int f3519V = -1;
        ArrayList<Animator> Code = new ArrayList<>();

        public B(C2223m c2223m, float f, float f2) {
            this.f3518I = new I(f, f2);
            c2223m.setLayerType(2, null);
            Paint paint = new Paint(1);
            this.f3517B = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.f3517B.setStrokeWidth(this.f3520Z);
            this.f3517B.setColor(this.f3519V);
        }
    }

    public C2223m(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Code = false;
        post(new Runnable() { // from class: com.facetec.sdk.m.5
            @Override // java.lang.Runnable
            public final void run() {
                C2223m.m2266I(C2223m.this);
            }
        });
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        ArrayList<B> arrayList;
        if (!this.Code || (arrayList = this.f3509B) == null || arrayList.size() <= 0) {
            return;
        }
        for (B b : this.f3509B) {
            I i = b.f3518I;
            canvas.drawCircle(i.f3522Z, i.f3521I, i.Code, b.f3517B);
        }
        this.Code = false;
    }

    /* JADX INFO: renamed from: I */
    public final void m2269I(float f, float f2, final Runnable runnable) {
        if (this.f3509B.size() > 5) {
            return;
        }
        final B b = new B(this, f, f2);
        final ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(b.f3518I.Code, this.f3510I);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facetec.sdk.m.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.f3518I.Code = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                B b2 = b;
                b2.f3520Z = Math.min(C2223m.this.f3511V, b.f3518I.Code);
                if (b2.f3517B != null) {
                    b2.f3517B.setStrokeWidth(b2.f3520Z);
                }
                b.f3517B.setAlpha(Math.round((1.0f - valueAnimator.getAnimatedFraction()) * 255.0f));
                C2223m.m2268Z(C2223m.this);
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.facetec.sdk.m.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.f3517B.setAlpha(0);
                C2223m.m2268Z(C2223m.this);
                b.Code.remove(valueAnimatorOfFloat);
                C2223m.this.f3509B.remove(b);
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        });
        valueAnimatorOfFloat.start();
        b.Code.add(valueAnimatorOfFloat);
        this.f3509B.add(b);
    }

    /* JADX INFO: renamed from: I */
    static /* synthetic */ void m2266I(C2223m c2223m) {
        c2223m.f3509B = new ArrayList<>();
        c2223m.f3510I = Math.round(C2188cb.m1993V(50) * C2156av.Code() * C2156av.m1644I());
        c2223m.f3511V = Math.round(C2188cb.m1993V(3) * C2156av.Code() * C2156av.m1644I());
    }

    /* JADX INFO: renamed from: Z */
    static /* synthetic */ void m2268Z(C2223m c2223m) {
        c2223m.Code = true;
        c2223m.postInvalidate();
    }
}
