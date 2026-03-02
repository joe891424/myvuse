package com.reactnativenavigation.views.element.animators;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.views.image.ReactImageView;
import com.reactnativenavigation.options.SharedElementTransitionOptions;
import com.reactnativenavigation.utils.BorderRadiusOutlineProvider;
import com.reactnativenavigation.utils.ReactImageViewKt;
import com.reactnativenavigation.utils.RoundingParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactImageCornerRadiusAnimator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0003J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0014¨\u0006\u0014"}, m5598d2 = {"Lcom/reactnativenavigation/views/element/animators/ReactImageCornerRadiusAnimator;", "Lcom/reactnativenavigation/views/element/animators/PropertyAnimatorCreator;", "Lcom/facebook/react/views/image/ReactImageView;", "from", "Landroid/view/View;", TypedValues.TransitionType.S_TO, "(Landroid/view/View;Landroid/view/View;)V", "create", "Landroid/animation/Animator;", "options", "Lcom/reactnativenavigation/options/SharedElementTransitionOptions;", "setInitialCornerRadiusAfterAnimatorIsCreated", "", "setInitialOutline", "provider", "Lcom/reactnativenavigation/utils/BorderRadiusOutlineProvider;", "shouldAnimateProperty", "", "fromChild", "toChild", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ReactImageCornerRadiusAnimator extends PropertyAnimatorCreator<ReactImageView> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactImageCornerRadiusAnimator(View from, View to) {
        super(from, to);
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.reactnativenavigation.views.element.animators.PropertyAnimatorCreator
    public boolean shouldAnimateProperty(ReactImageView fromChild, ReactImageView toChild) {
        Intrinsics.checkNotNullParameter(fromChild, "fromChild");
        Intrinsics.checkNotNullParameter(toChild, "toChild");
        return ReactImageViewKt.getCornerRadius(fromChild) != ReactImageViewKt.getCornerRadius(toChild);
    }

    @Override // com.reactnativenavigation.views.element.animators.PropertyAnimatorCreator
    public Animator create(SharedElementTransitionOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        View to = getTo();
        Intrinsics.checkNotNull(to, "null cannot be cast to non-null type com.facebook.react.views.image.ReactImageView");
        View from = getFrom();
        Intrinsics.checkNotNull(from, "null cannot be cast to non-null type com.facebook.react.views.image.ReactImageView");
        final BorderRadiusOutlineProvider borderRadiusOutlineProvider = new BorderRadiusOutlineProvider((ImageView) getTo(), ReactImageViewKt.getCornerRadius((ReactImageView) getFrom()));
        setInitialOutline((ReactImageView) getTo(), borderRadiusOutlineProvider);
        ValueAnimator valueAnimatorOfObject = ObjectAnimator.ofObject(new CornerRadiusEvaluator(new Function1<Float, Unit>() { // from class: com.reactnativenavigation.views.element.animators.ReactImageCornerRadiusAnimator.create.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                invoke(f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f) {
                borderRadiusOutlineProvider.updateRadius(f);
            }
        }), Float.valueOf(ReactImageViewKt.getCornerRadius((ReactImageView) getFrom())), Float.valueOf(ReactImageViewKt.getCornerRadius((ReactImageView) getTo())));
        setInitialCornerRadiusAfterAnimatorIsCreated((ReactImageView) getTo(), (ReactImageView) getFrom());
        Intrinsics.checkNotNull(valueAnimatorOfObject);
        ValueAnimator valueAnimator = valueAnimatorOfObject;
        valueAnimator.addListener(new Animator.AnimatorListener() { // from class: com.reactnativenavigation.views.element.animators.ReactImageCornerRadiusAnimator$create$lambda$1$$inlined$doOnEnd$1
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
                ((ReactImageView) this.this$0.getTo()).getHierarchy().setRoundingParams(RoundingParams.INSTANCE.fromCornersRadii(borderRadiusOutlineProvider.getRadius()));
            }
        });
        Intrinsics.checkNotNullExpressionValue(valueAnimatorOfObject, "apply(...)");
        return valueAnimator;
    }

    private final void setInitialOutline(ReactImageView to, BorderRadiusOutlineProvider provider) {
        to.setOutlineProvider(provider);
        to.setClipToOutline(true);
        to.invalidateOutline();
    }

    private final void setInitialCornerRadiusAfterAnimatorIsCreated(ReactImageView to, ReactImageView from) {
        to.setFadeDuration(0);
        to.setBorderRadius(Math.min(ReactImageViewKt.getCornerRadius(from), ReactImageViewKt.getCornerRadius(to)));
        to.maybeUpdateView();
    }
}
