package com.microblink.fragment.overlay.components.feedback.view;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class SuccessFlashView extends View {
    private Paint IlIllIlIIl;
    private int IllIIIllII;
    PointF llIIIlllll;
    Animator llIIlIlIIl;

    /* JADX INFO: compiled from: line */
    class Animator {
        private final AnimatorSet IllIIIllII;
        private float llIIlIlIIl = 0.0f;
        private float IlIllIlIIl = 0.0f;

        Animator(SuccessFlashView successFlashView, View view) {
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(400L);
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(successFlashView, view) { // from class: com.microblink.fragment.overlay.components.feedback.view.SuccessFlashView.Animator.1
                final /* synthetic */ View llIIlIlIIl;

                {
                    this.llIIlIlIIl = view;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Animator.this.llIIlIlIIl = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.llIIlIlIIl.postInvalidate();
                }
            });
            ValueAnimator duration2 = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(600L);
            duration2.setStartDelay(400L);
            duration2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(successFlashView, view) { // from class: com.microblink.fragment.overlay.components.feedback.view.SuccessFlashView.Animator.2
                final /* synthetic */ View llIIlIlIIl;

                {
                    this.llIIlIlIIl = view;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Animator.this.llIIlIlIIl = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.llIIlIlIIl.postInvalidate();
                }
            });
            ValueAnimator duration3 = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(1000L);
            duration3.setInterpolator(new FastOutSlowInInterpolator());
            duration3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(successFlashView, view) { // from class: com.microblink.fragment.overlay.components.feedback.view.SuccessFlashView.Animator.3
                final /* synthetic */ View llIIlIlIIl;

                {
                    this.llIIlIlIIl = view;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Animator.this.IlIllIlIIl = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.llIIlIlIIl.postInvalidate();
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            this.IllIIIllII = animatorSet;
            animatorSet.playTogether(duration, duration2, duration3);
        }

        float IllIIIllII() {
            return this.IlIllIlIIl;
        }

        void llIIIlllll() {
            if (this.IllIIIllII.isRunning()) {
                return;
            }
            this.IllIIIllII.start();
        }

        float IlIllIlIIl() {
            return this.llIIlIlIIl;
        }

        void llIIlIlIIl() {
            this.IllIIIllII.cancel();
            this.llIIlIlIIl = 0.0f;
            this.IlIllIlIIl = 0.0f;
        }
    }

    public SuccessFlashView(Context context) {
        this(context, null, 0);
    }

    public void cancelAnimation() {
        this.llIIlIlIIl.llIIlIlIIl();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r8) {
        /*
            r7 = this;
            super.draw(r8)
            int r0 = r8.getWidth()
            int r1 = r8.getHeight()
            android.graphics.PointF r2 = r7.llIIIlllll
            if (r2 == 0) goto L2b
            float r3 = r2.x
            r4 = 0
            int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r5 < 0) goto L2b
            r5 = 1065353216(0x3f800000, float:1.0)
            int r6 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r6 > 0) goto L2b
            float r2 = r2.y
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 < 0) goto L2b
            int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r4 > 0) goto L2b
            float r0 = (float) r0
            float r0 = r0 * r3
            float r1 = (float) r1
            float r1 = r1 * r2
            goto L31
        L2b:
            float r0 = (float) r0
            r2 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r2
            float r1 = (float) r1
            float r1 = r1 / r2
        L31:
            android.graphics.Paint r2 = r7.IlIllIlIIl
            int r3 = r7.IllIIIllII
            float r3 = (float) r3
            com.microblink.fragment.overlay.components.feedback.view.SuccessFlashView$Animator r4 = r7.llIIlIlIIl
            float r4 = r4.IlIllIlIIl()
            float r3 = r3 * r4
            r4 = 1082130432(0x40800000, float:4.0)
            float r3 = r3 / r4
            int r3 = (int) r3
            r2.setAlpha(r3)
            int r2 = r8.getHeight()
            float r2 = (float) r2
            com.microblink.fragment.overlay.components.feedback.view.SuccessFlashView$Animator r3 = r7.llIIlIlIIl
            float r3 = r3.IllIIIllII()
            float r2 = r2 * r3
            android.graphics.Paint r3 = r7.IlIllIlIIl
            r8.drawCircle(r0, r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.fragment.overlay.components.feedback.view.SuccessFlashView.draw(android.graphics.Canvas):void");
    }

    public void setRelativeCenter(PointF pointF) {
        this.llIIIlllll = pointF;
    }

    public void setup(int i) {
        Paint paint = new Paint();
        this.IlIllIlIIl = paint;
        paint.setStyle(Paint.Style.FILL);
        this.IlIllIlIIl.setColor(i);
        this.IlIllIlIIl.setAntiAlias(true);
        this.IllIIIllII = this.IlIllIlIIl.getAlpha();
        this.llIIlIlIIl = new Animator(this, this);
    }

    public void startAnimation() {
        this.llIIlIlIIl.llIIIlllll();
    }

    public SuccessFlashView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SuccessFlashView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
