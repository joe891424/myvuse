package com.reactnativenavigation.views.element.animators;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.views.text.ReactTextView;
import com.facebook.react.views.view.ReactViewBackgroundDrawable;
import com.reactnativenavigation.options.SharedElementTransitionOptions;
import com.reactnativenavigation.utils.ColorUtils;
import com.reactnativenavigation.utils.ViewUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackgroundColorAnimator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\u0014J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0014¨\u0006\u0013"}, m5598d2 = {"Lcom/reactnativenavigation/views/element/animators/BackgroundColorAnimator;", "Lcom/reactnativenavigation/views/element/animators/PropertyAnimatorCreator;", "Landroid/view/ViewGroup;", "from", "Landroid/view/View;", TypedValues.TransitionType.S_TO, "(Landroid/view/View;Landroid/view/View;)V", "create", "Landroid/animation/Animator;", "options", "Lcom/reactnativenavigation/options/SharedElementTransitionOptions;", "excludedViews", "", "Ljava/lang/Class;", "Lcom/facebook/react/views/text/ReactTextView;", "shouldAnimateProperty", "", "fromChild", "toChild", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class BackgroundColorAnimator extends PropertyAnimatorCreator<ViewGroup> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundColorAnimator(View from, View to) {
        super(from, to);
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.reactnativenavigation.views.element.animators.PropertyAnimatorCreator
    public boolean shouldAnimateProperty(ViewGroup fromChild, ViewGroup toChild) {
        Intrinsics.checkNotNullParameter(fromChild, "fromChild");
        Intrinsics.checkNotNullParameter(toChild, "toChild");
        if ((fromChild.getBackground() instanceof ReactViewBackgroundDrawable) && (toChild.getBackground() instanceof ReactViewBackgroundDrawable)) {
            Drawable background = fromChild.getBackground();
            Intrinsics.checkNotNull(background, "null cannot be cast to non-null type com.facebook.react.views.view.ReactViewBackgroundDrawable");
            int color = ((ReactViewBackgroundDrawable) background).getColor();
            Drawable background2 = toChild.getBackground();
            Intrinsics.checkNotNull(background2, "null cannot be cast to non-null type com.facebook.react.views.view.ReactViewBackgroundDrawable");
            if (color != ((ReactViewBackgroundDrawable) background2).getColor()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.reactnativenavigation.views.element.animators.PropertyAnimatorCreator
    protected List<Class<ReactTextView>> excludedViews() {
        return CollectionsKt.listOf(ReactTextView.class);
    }

    @Override // com.reactnativenavigation.views.element.animators.PropertyAnimatorCreator
    public Animator create(SharedElementTransitionOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        Drawable background = getTo().getBackground();
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type com.facebook.react.views.view.ReactViewBackgroundDrawable");
        BackgroundColorEvaluator backgroundColorEvaluator = new BackgroundColorEvaluator((ReactViewBackgroundDrawable) background);
        double[] dArrColorToLAB = ColorUtils.colorToLAB(ViewUtils.getBackgroundColor(getFrom()));
        double[] dArrColorToLAB2 = ColorUtils.colorToLAB(ViewUtils.getBackgroundColor(getTo()));
        Intrinsics.checkNotNull(dArrColorToLAB);
        Intrinsics.checkNotNull(dArrColorToLAB2);
        backgroundColorEvaluator.evaluate(0.0f, dArrColorToLAB, dArrColorToLAB2);
        ValueAnimator valueAnimatorOfObject = ObjectAnimator.ofObject(backgroundColorEvaluator, dArrColorToLAB, dArrColorToLAB2);
        Intrinsics.checkNotNullExpressionValue(valueAnimatorOfObject, "ofObject(...)");
        return valueAnimatorOfObject;
    }
}
