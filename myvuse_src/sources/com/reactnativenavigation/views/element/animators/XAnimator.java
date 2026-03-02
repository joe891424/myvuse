package com.reactnativenavigation.views.element.animators;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.views.text.ReactTextView;
import com.reactnativenavigation.options.SharedElementTransitionOptions;
import com.reactnativenavigation.utils.ViewUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XAnimator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rH\u0014J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m5598d2 = {"Lcom/reactnativenavigation/views/element/animators/XAnimator;", "Lcom/reactnativenavigation/views/element/animators/PropertyAnimatorCreator;", "Landroid/view/View;", "from", TypedValues.TransitionType.S_TO, "(Landroid/view/View;Landroid/view/View;)V", "dx", "", "create", "Landroid/animation/Animator;", "options", "Lcom/reactnativenavigation/options/SharedElementTransitionOptions;", "excludedViews", "", "Ljava/lang/Class;", "Lcom/facebook/react/views/text/ReactTextView;", "shouldAnimateProperty", "", "fromChild", "toChild", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class XAnimator extends PropertyAnimatorCreator<View> {
    private final int dx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XAnimator(View from, View to) {
        super(from, to);
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        Point locationOnScreen = ViewUtils.getLocationOnScreen(from);
        ViewGroup.LayoutParams layoutParams = to.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        this.dx = locationOnScreen.x - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
    }

    @Override // com.reactnativenavigation.views.element.animators.PropertyAnimatorCreator
    protected List<Class<ReactTextView>> excludedViews() {
        return CollectionsKt.listOf(ReactTextView.class);
    }

    @Override // com.reactnativenavigation.views.element.animators.PropertyAnimatorCreator
    protected boolean shouldAnimateProperty(View fromChild, View toChild) {
        Intrinsics.checkNotNullParameter(fromChild, "fromChild");
        Intrinsics.checkNotNullParameter(toChild, "toChild");
        return this.dx != 0;
    }

    @Override // com.reactnativenavigation.views.element.animators.PropertyAnimatorCreator
    public Animator create(SharedElementTransitionOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        getTo().setTranslationX(this.dx);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(getTo(), (Property<View, Float>) View.TRANSLATION_X, this.dx, 0.0f);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(...)");
        return objectAnimatorOfFloat;
    }
}
