package com.reactnativenavigation.views.animations;

import android.animation.Animator;
import android.view.View;
import com.reactnativenavigation.views.animations.BaseViewAnimator;
import kotlin.Metadata;

/* JADX INFO: compiled from: ViewAnimatorCreator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tH&¨\u0006\f"}, m5598d2 = {"Lcom/reactnativenavigation/views/animations/ViewAnimatorCreator;", "", "getHideAnimator", "Landroid/animation/Animator;", "view", "Landroid/view/View;", "hideDirection", "Lcom/reactnativenavigation/views/animations/BaseViewAnimator$HideDirection;", "additionalDy", "", "getShowAnimator", "translationStart", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public interface ViewAnimatorCreator {
    Animator getHideAnimator(View view, BaseViewAnimator.HideDirection hideDirection, float additionalDy);

    Animator getShowAnimator(View view, BaseViewAnimator.HideDirection hideDirection, float translationStart);
}
