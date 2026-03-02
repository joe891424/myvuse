package com.reactnativenavigation.views.element.animators;

import android.animation.TypeEvaluator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.ColorUtils;
import com.facebook.react.views.view.ReactViewBackgroundDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackgroundColorEvaluator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m5598d2 = {"Lcom/reactnativenavigation/views/element/animators/BackgroundColorEvaluator;", "Landroid/animation/TypeEvaluator;", "", "background", "Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;", "(Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;)V", "color", "evaluate", "ratio", "", "from", TypedValues.TransitionType.S_TO, "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class BackgroundColorEvaluator implements TypeEvaluator<double[]> {
    private final ReactViewBackgroundDrawable background;
    private final double[] color;

    public BackgroundColorEvaluator(ReactViewBackgroundDrawable background) {
        Intrinsics.checkNotNullParameter(background, "background");
        this.background = background;
        this.color = new double[3];
    }

    @Override // android.animation.TypeEvaluator
    public double[] evaluate(float ratio, double[] from, double[] to) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        ColorUtils.blendLAB(from, to, ratio, this.color);
        this.background.setColor(com.reactnativenavigation.utils.ColorUtils.labToColor(this.color));
        return this.color;
    }
}
