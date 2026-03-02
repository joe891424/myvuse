package com.reactnativenavigation.views.animations;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.reactnativenavigation.utils.ViewUtils;
import com.reactnativenavigation.views.animations.BaseViewAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultViewAnimatorCreator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\u000e"}, m5598d2 = {"Lcom/reactnativenavigation/views/animations/DefaultViewAnimatorCreator;", "Lcom/reactnativenavigation/views/animations/ViewAnimatorCreator;", "()V", "getHideAnimator", "Landroid/animation/Animator;", "view", "Landroid/view/View;", "hideDirection", "Lcom/reactnativenavigation/views/animations/BaseViewAnimator$HideDirection;", "additionalDy", "", "getShowAnimator", "translationStart", "Companion", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class DefaultViewAnimatorCreator implements ViewAnimatorCreator {
    private static final long DURATION = 300;
    private static final FastOutSlowInInterpolator fastOutSlowInInterpolator = new FastOutSlowInInterpolator();

    @Override // com.reactnativenavigation.views.animations.ViewAnimatorCreator
    public Animator getShowAnimator(View view, BaseViewAnimator.HideDirection hideDirection, float translationStart) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(hideDirection, "hideDirection");
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, (hideDirection == BaseViewAnimator.HideDirection.f4208Up ? 1 : -1) * ((-ViewUtils.getHeight(view)) - translationStart), 0.0f);
        objectAnimatorOfFloat.setInterpolator(fastOutSlowInInterpolator);
        objectAnimatorOfFloat.setDuration(DURATION);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "apply(...)");
        return objectAnimatorOfFloat;
    }

    @Override // com.reactnativenavigation.views.animations.ViewAnimatorCreator
    public Animator getHideAnimator(View view, BaseViewAnimator.HideDirection hideDirection, float additionalDy) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(hideDirection, "hideDirection");
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, view.getTranslationY(), (hideDirection == BaseViewAnimator.HideDirection.f4208Up ? -1 : 1) * (view.getMeasuredHeight() + additionalDy));
        objectAnimatorOfFloat.setInterpolator(fastOutSlowInInterpolator);
        objectAnimatorOfFloat.setDuration(DURATION);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "apply(...)");
        return objectAnimatorOfFloat;
    }
}
