package com.reactnativenavigation.views.element.animators;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.views.image.ReactImageView;
import com.google.android.material.animation.MatrixEvaluator;
import com.reactnativenavigation.options.SharedElementTransitionOptions;
import com.reactnativenavigation.utils.ImageUtilsKt;
import com.reactnativenavigation.utils.Scale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: FastImageMatrixAnimator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0014¨\u0006\u0014"}, m5598d2 = {"Lcom/reactnativenavigation/views/element/animators/FastImageMatrixAnimator;", "Lcom/reactnativenavigation/views/element/animators/PropertyAnimatorCreator;", "Landroid/widget/ImageView;", "from", "Landroid/view/View;", TypedValues.TransitionType.S_TO, "(Landroid/view/View;Landroid/view/View;)V", "centerCropMatrix", "Landroid/graphics/Matrix;", "create", "Landroid/animation/Animator;", "options", "Lcom/reactnativenavigation/options/SharedElementTransitionOptions;", "createTransformMatrix", "fitCenterMatrix", "fitXYMatrix", "shouldAnimateProperty", "", "fromChild", "toChild", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class FastImageMatrixAnimator extends PropertyAnimatorCreator<ImageView> {

    /* JADX INFO: compiled from: FastImageMatrixAnimator.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastImageMatrixAnimator(View from, View to) {
        super(from, to);
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.reactnativenavigation.views.element.animators.PropertyAnimatorCreator
    public boolean shouldAnimateProperty(ImageView fromChild, ImageView toChild) {
        Intrinsics.checkNotNullParameter(fromChild, "fromChild");
        Intrinsics.checkNotNullParameter(toChild, "toChild");
        return (ImageUtilsKt.areDimensionsWithInheritedScaleEqual(getFrom(), getTo()) || (fromChild instanceof ReactImageView) || (toChild instanceof ReactImageView)) ? false : true;
    }

    @Override // com.reactnativenavigation.views.element.animators.PropertyAnimatorCreator
    public Animator create(SharedElementTransitionOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        View from = getFrom();
        Intrinsics.checkNotNull(from, "null cannot be cast to non-null type android.widget.ImageView");
        View to = getTo();
        Intrinsics.checkNotNull(to, "null cannot be cast to non-null type android.widget.ImageView");
        final ImageView.ScaleType scaleType = ((ImageView) getTo()).getScaleType();
        final int width = ((ImageView) getTo()).getWidth();
        final int height = ((ImageView) getTo()).getHeight();
        Matrix matrixCreateTransformMatrix = createTransformMatrix((ImageView) getFrom(), (ImageView) getTo());
        Matrix matrixCreateTransformMatrix2 = createTransformMatrix((ImageView) getTo(), (ImageView) getTo());
        ((ImageView) getTo()).setScaleType(ImageView.ScaleType.MATRIX);
        ((ImageView) getTo()).getLayoutParams().width = Math.max(((ImageView) getFrom()).getWidth(), ((ImageView) getTo()).getWidth());
        ((ImageView) getTo()).getLayoutParams().height = Math.max(((ImageView) getFrom()).getHeight(), ((ImageView) getTo()).getHeight());
        ValueAnimator valueAnimatorOfObject = ObjectAnimator.ofObject(new MatrixEvaluator() { // from class: com.reactnativenavigation.views.element.animators.FastImageMatrixAnimator.create.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.material.animation.MatrixEvaluator, android.animation.TypeEvaluator
            public Matrix evaluate(float fraction, Matrix startValue, Matrix endValue) {
                Intrinsics.checkNotNullParameter(startValue, "startValue");
                Intrinsics.checkNotNullParameter(endValue, "endValue");
                Matrix matrixEvaluate = super.evaluate(fraction, startValue, endValue);
                Intrinsics.checkNotNullExpressionValue(matrixEvaluate, "evaluate(...)");
                ((ImageView) FastImageMatrixAnimator.this.getTo()).setImageMatrix(matrixEvaluate);
                return matrixEvaluate;
            }
        }, matrixCreateTransformMatrix, matrixCreateTransformMatrix2);
        Intrinsics.checkNotNull(valueAnimatorOfObject);
        ValueAnimator valueAnimator = valueAnimatorOfObject;
        valueAnimator.addListener(new Animator.AnimatorListener() { // from class: com.reactnativenavigation.views.element.animators.FastImageMatrixAnimator$create$lambda$1$$inlined$doOnEnd$1
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
                ((ImageView) this.this$0.getTo()).getLayoutParams().width = width;
                ((ImageView) this.this$0.getTo()).getLayoutParams().height = height;
                ((ImageView) this.this$0.getTo()).setScaleType(scaleType);
                this.this$0.getTo().invalidate();
            }
        });
        Intrinsics.checkNotNullExpressionValue(valueAnimatorOfObject, "apply(...)");
        return valueAnimator;
    }

    private final Matrix createTransformMatrix(ImageView from, ImageView to) {
        ImageView.ScaleType scaleType = from.getScaleType();
        int i = scaleType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[scaleType.ordinal()];
        if (i == 1) {
            return centerCropMatrix(from, to);
        }
        if (i == 2) {
            return fitXYMatrix(from, to);
        }
        if (i == 3) {
            return fitCenterMatrix(from, to);
        }
        if (i == 4) {
            return fitCenterMatrix(from, to);
        }
        throw new RuntimeException("Unsupported ScaleType " + from.getScaleType());
    }

    private final Matrix fitXYMatrix(ImageView from, ImageView to) {
        Scale scaleComputeInheritedScale = ImageUtilsKt.computeInheritedScale(from);
        float x = scaleComputeInheritedScale.getX();
        float y = scaleComputeInheritedScale.getY();
        Drawable drawable = to.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale((from.getWidth() * x) / drawable.getIntrinsicWidth(), (from.getHeight() * y) / drawable.getIntrinsicHeight());
        return matrix;
    }

    private final Matrix centerCropMatrix(ImageView from, ImageView to) {
        Scale scaleComputeInheritedScale = ImageUtilsKt.computeInheritedScale(from);
        float x = scaleComputeInheritedScale.getX();
        float y = scaleComputeInheritedScale.getY();
        Drawable drawable = to.getDrawable();
        float width = from.getWidth() * x;
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float height = from.getHeight() * y;
        float intrinsicHeight = drawable.getIntrinsicHeight();
        float fCoerceAtLeast = RangesKt.coerceAtLeast(width / intrinsicWidth, height / intrinsicHeight);
        int iRoundToInt = MathKt.roundToInt((width - (intrinsicWidth * fCoerceAtLeast)) / 2.0f);
        int iRoundToInt2 = MathKt.roundToInt((height - (intrinsicHeight * fCoerceAtLeast)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.postScale(fCoerceAtLeast, fCoerceAtLeast);
        matrix.postTranslate(iRoundToInt, iRoundToInt2);
        return matrix;
    }

    private final Matrix fitCenterMatrix(ImageView from, ImageView to) {
        Scale scaleComputeInheritedScale = ImageUtilsKt.computeInheritedScale(from);
        float x = scaleComputeInheritedScale.getX();
        float y = scaleComputeInheritedScale.getY();
        Drawable drawable = to.getDrawable();
        float width = from.getWidth() * x;
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float height = from.getHeight() * y;
        float intrinsicHeight = drawable.getIntrinsicHeight();
        float fMin = Math.min(width / intrinsicWidth, height / intrinsicHeight);
        int iRoundToInt = MathKt.roundToInt((width - (intrinsicWidth * fMin)) / 2.0f);
        int iRoundToInt2 = MathKt.roundToInt((height - (intrinsicHeight * fMin)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.postScale(fMin, fMin);
        matrix.postTranslate(iRoundToInt, iRoundToInt2);
        return matrix;
    }
}
