package com.reactnativenavigation.views.element.animators;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.RectF;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.views.view.ReactViewGroup;
import com.reactnativenavigation.options.SharedElementTransitionOptions;
import com.reactnativenavigation.utils.ImageUtilsKt;
import com.reactnativenavigation.utils.OutlineProvider;
import com.reactnativenavigation.utils.ReactViewGroupKt;
import com.reactnativenavigation.utils.Scale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ReactViewOutlineAnimator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0003J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0014¨\u0006\u0013"}, m5598d2 = {"Lcom/reactnativenavigation/views/element/animators/ReactViewOutlineAnimator;", "Lcom/reactnativenavigation/views/element/animators/PropertyAnimatorCreator;", "Lcom/facebook/react/views/view/ReactViewGroup;", "from", "Landroid/view/View;", TypedValues.TransitionType.S_TO, "(Landroid/view/View;Landroid/view/View;)V", "create", "Landroid/animation/Animator;", "options", "Lcom/reactnativenavigation/options/SharedElementTransitionOptions;", "setOutlineProvider", "", "provider", "Lcom/reactnativenavigation/utils/OutlineProvider;", "shouldAnimateProperty", "", "fromChild", "toChild", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ReactViewOutlineAnimator extends PropertyAnimatorCreator<ReactViewGroup> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactViewOutlineAnimator(View from, View to) {
        super(from, to);
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.reactnativenavigation.views.element.animators.PropertyAnimatorCreator
    public boolean shouldAnimateProperty(ReactViewGroup fromChild, ReactViewGroup toChild) {
        Intrinsics.checkNotNullParameter(fromChild, "fromChild");
        Intrinsics.checkNotNullParameter(toChild, "toChild");
        return !ImageUtilsKt.areDimensionsWithInheritedScaleEqual(getFrom(), getTo()) && fromChild.getChildCount() == 0 && toChild.getChildCount() == 0;
    }

    @Override // com.reactnativenavigation.views.element.animators.PropertyAnimatorCreator
    public Animator create(SharedElementTransitionOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        View from = getFrom();
        Intrinsics.checkNotNull(from, "null cannot be cast to non-null type com.facebook.react.views.view.ReactViewGroup");
        View to = getTo();
        Intrinsics.checkNotNull(to, "null cannot be cast to non-null type com.facebook.react.views.view.ReactViewGroup");
        Scale scaleComputeInheritedScale = ImageUtilsKt.computeInheritedScale(getFrom());
        float x = scaleComputeInheritedScale.getX();
        float y = scaleComputeInheritedScale.getY();
        ((ReactViewGroup) getTo()).getLayoutParams().width = Math.max(MathKt.roundToInt(((ReactViewGroup) getFrom()).getWidth() * x), ((ReactViewGroup) getTo()).getWidth());
        ((ReactViewGroup) getTo()).getLayoutParams().height = Math.max(MathKt.roundToInt(((ReactViewGroup) getFrom()).getHeight() * y), ((ReactViewGroup) getTo()).getHeight());
        RectF rectF = new RectF(((ReactViewGroup) getFrom()).getBackground().getBounds());
        RectF rectF2 = new RectF(((ReactViewGroup) getTo()).getBackground().getBounds());
        rectF.right *= x;
        rectF.bottom *= y;
        ViewOutline viewOutline = new ViewOutline(rectF.width(), rectF.height(), ReactViewGroupKt.getBorderRadius((ReactViewGroup) getFrom()));
        ViewOutline viewOutline2 = new ViewOutline(rectF2.width(), rectF2.height(), ReactViewGroupKt.getBorderRadius((ReactViewGroup) getTo()));
        ((ReactViewGroup) getTo()).setBorderRadius(0.0f);
        final OutlineProvider outlineProvider = new OutlineProvider(getTo(), new ViewOutline(viewOutline.getWidth(), viewOutline.getHeight(), viewOutline.getRadius()));
        setOutlineProvider(outlineProvider);
        ValueAnimator valueAnimatorOfObject = ObjectAnimator.ofObject(new OutlineEvaluator(new Function1<ViewOutline, Unit>() { // from class: com.reactnativenavigation.views.element.animators.ReactViewOutlineAnimator.create.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewOutline viewOutline3) {
                invoke2(viewOutline3);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ViewOutline it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                outlineProvider.update(it2);
            }
        }), viewOutline, viewOutline2);
        Intrinsics.checkNotNull(valueAnimatorOfObject);
        ValueAnimator valueAnimator = valueAnimatorOfObject;
        valueAnimator.addListener(new Animator.AnimatorListener() { // from class: com.reactnativenavigation.views.element.animators.ReactViewOutlineAnimator$create$lambda$1$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ((ReactViewGroup) this.this$0.getTo()).setBorderRadius(outlineProvider.getRadius());
                ((ReactViewGroup) this.this$0.getTo()).setOutlineProvider(null);
                ((ReactViewGroup) this.this$0.getTo()).setClipToOutline(false);
            }
        });
        Intrinsics.checkNotNullExpressionValue(valueAnimatorOfObject, "apply(...)");
        return valueAnimator;
    }

    private final void setOutlineProvider(OutlineProvider provider) {
        getTo().setOutlineProvider(provider);
        getTo().setClipToOutline(true);
        getTo().invalidateOutline();
    }
}
