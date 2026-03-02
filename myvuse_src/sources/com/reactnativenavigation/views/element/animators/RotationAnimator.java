package com.reactnativenavigation.views.element.animators;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.views.image.ReactImageView;
import com.reactnativenavigation.options.SharedElementTransitionOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RotationAnimator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m5598d2 = {"Lcom/reactnativenavigation/views/element/animators/RotationAnimator;", "Lcom/reactnativenavigation/views/element/animators/PropertyAnimatorCreator;", "Lcom/facebook/react/views/image/ReactImageView;", "from", "Landroid/view/View;", TypedValues.TransitionType.S_TO, "(Landroid/view/View;Landroid/view/View;)V", "fromRotation", "", "toRotation", "create", "Landroid/animation/Animator;", "options", "Lcom/reactnativenavigation/options/SharedElementTransitionOptions;", "shouldAnimateProperty", "", "fromChild", "toChild", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class RotationAnimator extends PropertyAnimatorCreator<ReactImageView> {
    private final float fromRotation;
    private final float toRotation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RotationAnimator(View from, View to) {
        super(from, to);
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        this.fromRotation = from.getRotation();
        this.toRotation = to.getRotation();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.reactnativenavigation.views.element.animators.PropertyAnimatorCreator
    public boolean shouldAnimateProperty(ReactImageView fromChild, ReactImageView toChild) {
        Intrinsics.checkNotNullParameter(fromChild, "fromChild");
        Intrinsics.checkNotNullParameter(toChild, "toChild");
        return !(this.fromRotation == this.toRotation);
    }

    @Override // com.reactnativenavigation.views.element.animators.PropertyAnimatorCreator
    public Animator create(SharedElementTransitionOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        getTo().setRotation(this.fromRotation);
        getTo().setPivotX(0.0f);
        getTo().setPivotY(0.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(getTo(), (Property<View, Float>) View.ROTATION, this.fromRotation, this.toRotation);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(...)");
        return objectAnimatorOfFloat;
    }
}
