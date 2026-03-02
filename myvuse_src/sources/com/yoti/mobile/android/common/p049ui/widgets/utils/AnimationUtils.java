package com.yoti.mobile.android.common.p049ui.widgets.utils;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.provider.Settings;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import androidx.transition.Transition;
import com.airbnb.lottie.LottieAnimationView;

/* JADX INFO: loaded from: classes5.dex */
public class AnimationUtils {
    public static final float ANIMATION_PLAY_SPEED = 1.0f;
    public static final float ANIMATION_REVERSE_PLAY_SPEED = -1.0f;

    public interface AnimateToTransparentListener {
        void onAnimationEnd();
    }

    public static abstract class AnimationListenerAdapter implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public static abstract class OnAnimationEnd implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public abstract void onAnimationEnd(Animator animator);

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public static abstract class OnAnimationLoop implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public abstract void onAnimationRepeat(Animator animator);

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public static abstract class OnAnimationStart implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public abstract void onAnimationStart(Animator animator);
    }

    public static abstract class OnTransitionStart implements Transition.TransitionListener {
        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public abstract void onTransitionStart(Transition transition);
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.utils.AnimationUtils$a */
    static class RunnableC4562a implements Runnable {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ LottieAnimationView f6480a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ boolean f6481b;

        RunnableC4562a(LottieAnimationView lottieAnimationView, boolean z) {
            this.f6480a = lottieAnimationView;
            this.f6481b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            AnimationUtils.m4679b(this.f6480a, this.f6481b);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.utils.AnimationUtils$b */
    static class C4563b extends OnAnimationEnd {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ View f6482a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ int f6483b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ AnimateToTransparentListener f6484c;

        C4563b(View view, int i, AnimateToTransparentListener animateToTransparentListener) {
            this.f6482a = view;
            this.f6483b = i;
            this.f6484c = animateToTransparentListener;
        }

        @Override // com.yoti.mobile.android.common.ui.widgets.utils.AnimationUtils.OnAnimationEnd, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6482a.setVisibility(this.f6483b);
            AnimateToTransparentListener animateToTransparentListener = this.f6484c;
            if (animateToTransparentListener != null) {
                animateToTransparentListener.onAnimationEnd();
            }
        }
    }

    public static void animateAlpha(View view, float f, float f2, long j) {
        animateAlpha(view, f, f2, j, null);
    }

    public static void animateAlpha(View view, float f, float f2, long j, Animator.AnimatorListener animatorListener) {
        if (view == null) {
            return;
        }
        if (view.getVisibility() != 0) {
            view.setVisibility(0);
        }
        if (view.getAlpha() != f) {
            view.setAlpha(f);
        }
        view.animate().alpha(f2).setDuration(j).setListener(animatorListener).start();
    }

    public static Runnable animateFromJson(LottieAnimationView lottieAnimationView, String str) {
        return animateFromJson(lottieAnimationView, str, 0L, false);
    }

    public static Runnable animateFromJson(LottieAnimationView lottieAnimationView, String str, long j) {
        return animateFromJson(lottieAnimationView, str, j, false);
    }

    public static Runnable animateFromJson(LottieAnimationView lottieAnimationView, String str, long j, boolean z) {
        if (lottieAnimationView == null || lottieAnimationView.getContext() == null) {
            return null;
        }
        lottieAnimationView.setAnimation(str);
        RunnableC4562a runnableC4562a = new RunnableC4562a(lottieAnimationView, z);
        lottieAnimationView.postDelayed(runnableC4562a, j);
        return runnableC4562a;
    }

    public static Runnable animateFromJson(LottieAnimationView lottieAnimationView, String str, boolean z) {
        return animateFromJson(lottieAnimationView, str, 0L, z);
    }

    public static void animateTextSize(TextView textView, int i, int i2, long j) {
        if (textView == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, "textSize", i, i2);
        objectAnimatorOfFloat.setDuration(j);
        objectAnimatorOfFloat.start();
    }

    public static void animateToTransparent(View view, long j, int i) {
        animateToTransparent(view, j, i, null);
    }

    public static void animateToTransparent(View view, long j, int i, AnimateToTransparentListener animateToTransparentListener) {
        animateAlpha(view, 1.0f, 0.0f, j, new C4563b(view, i, animateToTransparentListener));
    }

    public static boolean areSystemAnimationsEnabled(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f) != 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static void m4679b(LottieAnimationView lottieAnimationView, boolean z) {
        lottieAnimationView.cancelAnimation();
        lottieAnimationView.setSpeed(z ? -1.0f : 1.0f);
        lottieAnimationView.playAnimation();
    }
}
