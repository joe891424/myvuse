package com.reactnativenavigation.viewcontrollers.common;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.reactnativenavigation.utils.UiUtils;

/* JADX INFO: loaded from: classes6.dex */
public class BaseAnimator {
    private static final int DURATION = 300;
    private final float translationY;
    private static final TimeInterpolator DECELERATE = new DecelerateInterpolator();
    private static final TimeInterpolator ACCELERATE_DECELERATE = new AccelerateDecelerateInterpolator();

    public BaseAnimator(Context context) {
        this.translationY = UiUtils.getWindowHeight(context);
    }

    public AnimatorSet getDefaultPushAnimation(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(DECELERATE);
        animatorSet.setDuration(300L);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, this.translationY, 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat2.setDuration(300L);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        return animatorSet;
    }

    public AnimatorSet getDefaultPopAnimation(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(ACCELERATE_DECELERATE);
        animatorSet.setDuration(300L);
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, 0.0f, this.translationY), ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f));
        return animatorSet;
    }

    public AnimatorSet getDefaultSetStackRootAnimation(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(DECELERATE);
        animatorSet.setDuration(300L);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, this.translationY, 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat2.setDuration(300L);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        return animatorSet;
    }
}
