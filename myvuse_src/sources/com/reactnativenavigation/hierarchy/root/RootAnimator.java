package com.reactnativenavigation.hierarchy.root;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.ViewGroup;
import com.reactnativenavigation.options.AnimationOptions;
import com.reactnativenavigation.options.TransitionAnimationOptions;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RootAnimator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J8\u0010\b\u001a\u00020\u00072\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\r"}, m5598d2 = {"Lcom/reactnativenavigation/hierarchy/root/RootAnimator;", "", "()V", "createAnimator", "Landroid/animation/AnimatorSet;", "onAnimationEnd", "Lkotlin/Function0;", "", "setRoot", "appearing", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;", "disappearing", "Lcom/reactnativenavigation/options/TransitionAnimationOptions;", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public class RootAnimator {
    public void setRoot(ViewController<?> appearing, ViewController<?> disappearing, TransitionAnimationOptions setRoot, Function0<Unit> onAnimationEnd) {
        Animator animation;
        Intrinsics.checkNotNullParameter(appearing, "appearing");
        Intrinsics.checkNotNullParameter(setRoot, "setRoot");
        Intrinsics.checkNotNullParameter(onAnimationEnd, "onAnimationEnd");
        appearing.getView().setVisibility(0);
        if (!setRoot.hasValue() || (!setRoot.getEnter().hasAnimation() && !setRoot.getExit().hasAnimation())) {
            onAnimationEnd.invoke();
            return;
        }
        AnimatorSet animatorSetCreateAnimator = createAnimator(onAnimationEnd);
        Animator animation2 = null;
        if (setRoot.getEnter().hasAnimation()) {
            AnimationOptions enter = setRoot.getEnter();
            ViewGroup view = appearing.getView();
            Intrinsics.checkNotNullExpressionValue(view, "getView(...)");
            animation = enter.getAnimation(view);
        } else {
            animation = null;
        }
        if (disappearing != null && setRoot.getExit().hasAnimation()) {
            AnimationOptions exit = setRoot.getExit();
            ViewGroup view2 = disappearing.getView();
            Intrinsics.checkNotNullExpressionValue(view2, "getView(...)");
            animation2 = exit.getAnimation(view2);
        }
        if (animation != null && animation2 != null) {
            animatorSetCreateAnimator.playTogether(animation, animation2);
        } else if (animation != null) {
            animatorSetCreateAnimator.play(animation);
        } else if (animation2 != null) {
            animatorSetCreateAnimator.play(animation2);
        }
        animatorSetCreateAnimator.start();
    }

    private final AnimatorSet createAnimator(final Function0<Unit> onAnimationEnd) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.reactnativenavigation.hierarchy.root.RootAnimator.createAnimator.1
            private boolean isCancelled;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.isCancelled = true;
                onAnimationEnd.invoke();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (this.isCancelled) {
                    return;
                }
                onAnimationEnd.invoke();
            }
        });
        return animatorSet;
    }
}
