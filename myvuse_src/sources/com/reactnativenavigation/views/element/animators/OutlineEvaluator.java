package com.reactnativenavigation.views.element.animators;

import android.animation.TypeEvaluator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OutlineEvaluator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m5598d2 = {"Lcom/reactnativenavigation/views/element/animators/OutlineEvaluator;", "Landroid/animation/TypeEvaluator;", "Lcom/reactnativenavigation/views/element/animators/ViewOutline;", "onEvaluate", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "evaluate", "ratio", "", "from", TypedValues.TransitionType.S_TO, "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class OutlineEvaluator implements TypeEvaluator<ViewOutline> {
    private final Function1<ViewOutline, Unit> onEvaluate;

    /* JADX WARN: Multi-variable type inference failed */
    public OutlineEvaluator(Function1<? super ViewOutline, Unit> onEvaluate) {
        Intrinsics.checkNotNullParameter(onEvaluate, "onEvaluate");
        this.onEvaluate = onEvaluate;
    }

    @Override // android.animation.TypeEvaluator
    public ViewOutline evaluate(float ratio, ViewOutline from, ViewOutline to) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        ViewOutline viewOutline = new ViewOutline(from.getWidth() + ((to.getWidth() - from.getWidth()) * ratio), from.getHeight() + ((to.getHeight() - from.getHeight()) * ratio), from.getRadius() + (ratio * (to.getRadius() - from.getRadius())));
        this.onEvaluate.invoke(viewOutline);
        return viewOutline;
    }
}
