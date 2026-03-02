package com.reactnativenavigation.views.element.animators;

import android.animation.TypeEvaluator;
import android.graphics.Rect;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.BaseJavaModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoundsEvaluator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J \u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m5598d2 = {"Lcom/reactnativenavigation/views/element/animators/BoundsEvaluator;", "Landroid/animation/TypeEvaluator;", "Landroid/graphics/Rect;", "onEvaluate", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "fromHeight", "", "fromWidth", "result", "toHeight", "toWidth", "evaluate", "ratio", "", "from", TypedValues.TransitionType.S_TO, BaseJavaModule.METHOD_TYPE_SYNC, "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class BoundsEvaluator implements TypeEvaluator<Rect> {
    private int fromHeight;
    private int fromWidth;
    private final Function1<Rect, Unit> onEvaluate;
    private final Rect result;
    private int toHeight;
    private int toWidth;

    /* JADX WARN: Multi-variable type inference failed */
    public BoundsEvaluator(Function1<? super Rect, Unit> onEvaluate) {
        Intrinsics.checkNotNullParameter(onEvaluate, "onEvaluate");
        this.onEvaluate = onEvaluate;
        this.result = new Rect();
    }

    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float ratio, Rect from, Rect to) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        sync(from, to);
        this.result.right = (int) (this.fromWidth + ((this.toWidth - r5) * ratio));
        this.result.bottom = (int) (this.fromHeight + ((this.toHeight - r5) * ratio));
        this.onEvaluate.invoke(this.result);
        return this.result;
    }

    private final void sync(Rect from, Rect to) {
        this.fromWidth = from.right;
        this.fromHeight = from.bottom;
        this.toWidth = to.right;
        this.toHeight = to.bottom;
    }
}
