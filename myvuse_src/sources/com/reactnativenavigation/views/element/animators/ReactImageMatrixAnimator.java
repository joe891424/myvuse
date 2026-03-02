package com.reactnativenavigation.views.element.animators;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.react.views.image.ImageResizeMode;
import com.facebook.react.views.image.ReactImageView;
import com.reactnativenavigation.options.SharedElementTransitionOptions;
import com.reactnativenavigation.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ReactImageMatrixAnimator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0014¨\u0006\u0019"}, m5598d2 = {"Lcom/reactnativenavigation/views/element/animators/ReactImageMatrixAnimator;", "Lcom/reactnativenavigation/views/element/animators/PropertyAnimatorCreator;", "Lcom/facebook/react/views/image/ReactImageView;", "from", "Landroid/view/View;", TypedValues.TransitionType.S_TO, "(Landroid/view/View;Landroid/view/View;)V", "calculateBounds", "Landroid/graphics/Rect;", "view", "parentScaleX", "", "parentScaleY", "create", "Landroid/animation/Animator;", "options", "Lcom/reactnativenavigation/options/SharedElementTransitionOptions;", "getScaleType", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "child", "scaleType", "shouldAnimateProperty", "", "fromChild", "toChild", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ReactImageMatrixAnimator extends PropertyAnimatorCreator<ReactImageView> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactImageMatrixAnimator(View from, View to) {
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
        View from = getFrom();
        Intrinsics.checkNotNull(from, "null cannot be cast to non-null type com.facebook.react.views.image.ReactImageView");
        View to = getTo();
        Intrinsics.checkNotNull(to, "null cannot be cast to non-null type com.facebook.react.views.image.ReactImageView");
        final ReactImageView reactImageView = (ReactImageView) to;
        ((ReactImageView) getTo()).getHierarchy().setFadeDuration(0);
        Object parent = ((ReactImageView) getFrom()).getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        float scaleX = ((View) parent).getScaleX();
        Object parent2 = ((ReactImageView) getFrom()).getParent();
        Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.View");
        float scaleY = ((View) parent2).getScaleY();
        reactImageView.getHierarchy().setActualImageScaleType(new ScalingUtils.InterpolatingScaleType(getScaleType(getFrom()), getScaleType(getTo()), calculateBounds(getFrom(), scaleX, scaleY), calculateBounds$default(this, getTo(), 0.0f, 0.0f, 6, null), new PointF((((ReactImageView) getFrom()).getWidth() * scaleX) / 2.0f, (((ReactImageView) getFrom()).getHeight() * scaleY) / 2.0f), new PointF(((ReactImageView) getTo()).getWidth() / 2.0f, ((ReactImageView) getTo()).getHeight() / 2.0f)));
        ((ReactImageView) getTo()).getLayoutParams().width = Math.max(((ReactImageView) getFrom()).getWidth(), ((ReactImageView) getTo()).getWidth());
        ((ReactImageView) getTo()).getLayoutParams().height = Math.max(((ReactImageView) getFrom()).getHeight(), ((ReactImageView) getTo()).getHeight());
        ValueAnimator valueAnimatorOfObject = ObjectAnimator.ofObject(new TypeEvaluator() { // from class: com.reactnativenavigation.views.element.animators.ReactImageMatrixAnimator$$ExternalSyntheticLambda0
            @Override // android.animation.TypeEvaluator
            public final Object evaluate(float f, Object obj, Object obj2) {
                return ReactImageMatrixAnimator.create$lambda$3$lambda$2(reactImageView, this, f, obj, obj2);
            }
        }, Float.valueOf(0.0f), Float.valueOf(1.0f));
        Intrinsics.checkNotNullExpressionValue(valueAnimatorOfObject, "ofObject(...)");
        return valueAnimatorOfObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object create$lambda$3$lambda$2(ReactImageView this_with, ReactImageMatrixAnimator this$0, float f, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(obj, "<anonymous parameter 1>");
        Intrinsics.checkNotNullParameter(obj2, "<anonymous parameter 2>");
        if (this_with.getHierarchy().getActualImageScaleType() != null) {
            ScalingUtils.ScaleType actualImageScaleType = this_with.getHierarchy().getActualImageScaleType();
            ScalingUtils.InterpolatingScaleType interpolatingScaleType = actualImageScaleType instanceof ScalingUtils.InterpolatingScaleType ? (ScalingUtils.InterpolatingScaleType) actualImageScaleType : null;
            if (interpolatingScaleType != null) {
                interpolatingScaleType.setValue(f);
                this$0.getTo().invalidate();
            }
        }
        return null;
    }

    private final ScalingUtils.ScaleType getScaleType(View child) {
        Intrinsics.checkNotNull(child, "null cannot be cast to non-null type com.facebook.react.views.image.ReactImageView");
        ReactImageView reactImageView = (ReactImageView) child;
        ScalingUtils.ScaleType actualImageScaleType = reactImageView.getHierarchy().getActualImageScaleType();
        if (actualImageScaleType == null) {
            actualImageScaleType = ImageResizeMode.defaultValue();
        }
        Intrinsics.checkNotNull(actualImageScaleType);
        return getScaleType(reactImageView, actualImageScaleType);
    }

    private final ScalingUtils.ScaleType getScaleType(ReactImageView child, ScalingUtils.ScaleType scaleType) {
        if (!(scaleType instanceof ScalingUtils.InterpolatingScaleType)) {
            return scaleType;
        }
        ScalingUtils.ScaleType scaleTypeTo = ((ScalingUtils.InterpolatingScaleType) scaleType).getScaleTypeTo();
        Intrinsics.checkNotNullExpressionValue(scaleTypeTo, "getScaleTypeTo(...)");
        return getScaleType(child, scaleTypeTo);
    }

    static /* synthetic */ Rect calculateBounds$default(ReactImageMatrixAnimator reactImageMatrixAnimator, View view, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 1.0f;
        }
        if ((i & 4) != 0) {
            f2 = 1.0f;
        }
        return reactImageMatrixAnimator.calculateBounds(view, f, f2);
    }

    private final Rect calculateBounds(View view, float parentScaleX, float parentScaleY) {
        return new Rect(0, 0, MathKt.roundToInt(view.getWidth() * parentScaleX), MathKt.roundToInt(view.getHeight() * parentScaleY));
    }
}
