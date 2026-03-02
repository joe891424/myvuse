package com.microblink.view.viewfinder.managers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.microblink.view.viewfinder.ViewfinderShapeView;
import java.util.ArrayList;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class ViewfinderAnimationUtil {
    public static final float MAX_VIEWFINDER_ALPHA = 0.67f;

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl extends AnimatorListenerAdapter {
        final /* synthetic */ Runnable llIIlIlIIl;

        llIIlIlIIl(Runnable runnable) {
            this.llIIlIlIIl = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Runnable runnable = this.llIIlIlIIl;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public static AnimatorSet createSplashAnimation(long j, Runnable runnable, ViewfinderShapeView viewfinderShapeView, View... viewArr) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewfinderShapeView, "innerAlpha", 0.67f, 0.0f);
        objectAnimatorOfFloat.setDuration(j);
        arrayList.add(objectAnimatorOfFloat);
        for (View view : viewArr) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat2.setDuration(j);
            arrayList.add(objectAnimatorOfFloat2);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.addListener(new llIIlIlIIl(runnable));
        return animatorSet;
    }
}
