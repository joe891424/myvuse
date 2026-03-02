package com.microblink.fragment.overlay.blinkid.reticleui;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class PulseAnimator {
    private final AnimatorSet llIIIlllll;
    private float llIIlIlIIl = 0.0f;
    private float IlIllIlIIl = 0.0f;
    private float IllIIIllII = 1.0f;

    PulseAnimator(final View view) {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(333L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.microblink.fragment.overlay.blinkid.reticleui.PulseAnimator.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PulseAnimator.this.llIIlIlIIl = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                view.postInvalidate();
            }
        });
        ValueAnimator duration2 = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(500L);
        duration2.setStartDelay(667L);
        duration2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.microblink.fragment.overlay.blinkid.reticleui.PulseAnimator.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PulseAnimator.this.llIIlIlIIl = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                view.postInvalidate();
            }
        });
        ValueAnimator duration3 = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(833L);
        duration3.setStartDelay(333L);
        duration3.setInterpolator(new FastOutSlowInInterpolator());
        duration3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.microblink.fragment.overlay.blinkid.reticleui.PulseAnimator.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PulseAnimator.this.IlIllIlIIl = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                view.postInvalidate();
            }
        });
        ValueAnimator duration4 = ValueAnimator.ofFloat(1.0f, 0.5f).setDuration(833L);
        duration4.setStartDelay(333L);
        duration4.setInterpolator(new FastOutSlowInInterpolator());
        duration4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.microblink.fragment.overlay.blinkid.reticleui.PulseAnimator.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PulseAnimator.this.IllIIIllII = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                view.postInvalidate();
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.llIIIlllll = animatorSet;
        animatorSet.playTogether(duration, duration2, duration3, duration4);
    }

    boolean IllIIIIllI() {
        return this.llIIIlllll.isStarted();
    }

    void lIlIIIIlIl() {
        this.llIIlIlIIl = 0.0f;
        this.IlIllIlIIl = 0.0f;
        this.IllIIIllII = 1.0f;
    }

    float llIIIlllll() {
        return this.IllIIIllII;
    }

    void llIIlIIlll() {
        if (this.llIIIlllll.isRunning()) {
            return;
        }
        this.llIIIlllll.start();
    }

    float IlIllIlIIl() {
        return this.llIIlIlIIl;
    }

    float IllIIIllII() {
        return this.IlIllIlIIl;
    }

    void llIIlIlIIl() {
        this.llIIIlllll.cancel();
        this.llIIlIlIIl = 0.0f;
        this.IlIllIlIIl = 0.0f;
        this.IllIIIllII = 1.0f;
    }

    void llIIlIlIIl(AnimationEndListener animationEndListener) {
        this.llIIIlllll.addListener(animationEndListener);
    }
}
