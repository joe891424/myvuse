package com.reactnativenavigation.views.element.animators;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.views.image.ReactImageView;
import com.reactnativenavigation.options.SharedElementTransitionOptions;
import com.reactnativenavigation.utils.ImageUtilsKt;
import com.reactnativenavigation.utils.Scale;
import com.reactnativenavigation.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ReactImageBoundsAnimator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0014¨\u0006\u000f"}, m5598d2 = {"Lcom/reactnativenavigation/views/element/animators/ReactImageBoundsAnimator;", "Lcom/reactnativenavigation/views/element/animators/PropertyAnimatorCreator;", "Lcom/facebook/react/views/image/ReactImageView;", "from", "Landroid/view/View;", TypedValues.TransitionType.S_TO, "(Landroid/view/View;Landroid/view/View;)V", "create", "Landroid/animation/Animator;", "options", "Lcom/reactnativenavigation/options/SharedElementTransitionOptions;", "shouldAnimateProperty", "", "fromChild", "toChild", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ReactImageBoundsAnimator extends PropertyAnimatorCreator<ReactImageView> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactImageBoundsAnimator(View from, View to) {
        super(from, to);
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.reactnativenavigation.views.element.animators.PropertyAnimatorCreator
    public boolean shouldAnimateProperty(ReactImageView fromChild, ReactImageView toChild) {
        Intrinsics.checkNotNullParameter(fromChild, "fromChild");
        Intrinsics.checkNotNullParameter(toChild, "toChild");
        return !ViewUtils.areDimensionsEqual(getFrom(), getTo());
    }

    @Override // com.reactnativenavigation.views.element.animators.PropertyAnimatorCreator
    public Animator create(SharedElementTransitionOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        Rect rect = new Rect();
        getFrom().getDrawingRect(rect);
        Rect rect2 = new Rect();
        getTo().getDrawingRect(rect2);
        Scale scaleComputeInheritedScale = ImageUtilsKt.computeInheritedScale(getFrom());
        float x = scaleComputeInheritedScale.getX();
        float y = scaleComputeInheritedScale.getY();
        rect.right = MathKt.roundToInt(rect.right * x);
        rect.bottom = MathKt.roundToInt(rect.bottom * y);
        ValueAnimator valueAnimatorOfObject = ObjectAnimator.ofObject(new BoundsEvaluator(new Function1<Rect, Unit>() { // from class: com.reactnativenavigation.views.element.animators.ReactImageBoundsAnimator.create.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Rect rect3) {
                invoke2(rect3);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Rect it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                View to = ReactImageBoundsAnimator.this.getTo();
                Intrinsics.checkNotNull(to, "null cannot be cast to non-null type com.facebook.react.views.image.ReactImageView");
                ReactImageView reactImageView = (ReactImageView) to;
                ReactImageBoundsAnimator reactImageBoundsAnimator = ReactImageBoundsAnimator.this;
                reactImageView.getDrawable().setBounds(it2);
                reactImageView.getDrawable().getCurrent().setBounds(it2);
                ((ReactImageView) reactImageBoundsAnimator.getTo()).setClipBounds(it2);
                reactImageView.invalidate();
            }
        }), rect, rect2);
        Intrinsics.checkNotNullExpressionValue(valueAnimatorOfObject, "ofObject(...)");
        return valueAnimatorOfObject;
    }
}
