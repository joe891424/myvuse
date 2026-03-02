package com.reactnativenavigation.views.element.animators;

import android.animation.Animator;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.views.text.ReactTextView;
import com.reactnativenavigation.options.SharedElementTransitionOptions;
import com.reactnativenavigation.utils.TextViewUtils;
import com.reactnativenavigation.utils.ViewUtils;
import com.shazam.android.widget.text.reflow.BoundsCalculator;
import com.shazam.android.widget.text.reflow.ReflowTextAnimatorHelper;
import com.shazam.android.widget.text.reflow.TextColorGetter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextChangeAnimator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0014¨\u0006\u000f"}, m5598d2 = {"Lcom/reactnativenavigation/views/element/animators/TextChangeAnimator;", "Lcom/reactnativenavigation/views/element/animators/PropertyAnimatorCreator;", "Lcom/facebook/react/views/text/ReactTextView;", "from", "Landroid/view/View;", TypedValues.TransitionType.S_TO, "(Landroid/view/View;Landroid/view/View;)V", "create", "Landroid/animation/Animator;", "options", "Lcom/reactnativenavigation/options/SharedElementTransitionOptions;", "shouldAnimateProperty", "", "fromChild", "toChild", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class TextChangeAnimator extends PropertyAnimatorCreator<ReactTextView> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextChangeAnimator(View from, View to) {
        super(from, to);
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.reactnativenavigation.views.element.animators.PropertyAnimatorCreator
    public boolean shouldAnimateProperty(ReactTextView fromChild, ReactTextView toChild) {
        Intrinsics.checkNotNullParameter(fromChild, "fromChild");
        Intrinsics.checkNotNullParameter(toChild, "toChild");
        Point locationOnScreen = ViewUtils.getLocationOnScreen(getFrom());
        Point locationOnScreen2 = ViewUtils.getLocationOnScreen(getTo());
        return Intrinsics.areEqual(fromChild.getText().toString(), toChild.getText().toString()) && !(TextViewUtils.getTextSize(fromChild) == TextViewUtils.getTextSize(toChild) && locationOnScreen.equals(locationOnScreen2.x, locationOnScreen2.y));
    }

    @Override // com.reactnativenavigation.views.element.animators.PropertyAnimatorCreator
    public Animator create(SharedElementTransitionOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        View from = getFrom();
        Intrinsics.checkNotNull(from, "null cannot be cast to non-null type android.widget.TextView");
        View to = getTo();
        Intrinsics.checkNotNull(to, "null cannot be cast to non-null type android.widget.TextView");
        Animator animatorBuildAnimator = new ReflowTextAnimatorHelper.Builder((TextView) from, (TextView) to).calculateDuration(false).setBoundsCalculator(new BoundsCalculator() { // from class: com.reactnativenavigation.views.element.animators.TextChangeAnimator$$ExternalSyntheticLambda0
            @Override // com.shazam.android.widget.text.reflow.BoundsCalculator
            public final Rect calculate(View view) {
                return TextChangeAnimator.create$lambda$0(this.f$0, view);
            }
        }).setTextColorGetter(new TextColorGetter() { // from class: com.reactnativenavigation.views.element.animators.TextChangeAnimator$$ExternalSyntheticLambda1
            @Override // com.shazam.android.widget.text.reflow.TextColorGetter
            public final int get(TextView textView) {
                return TextViewUtils.getTextColor(textView);
            }
        }).buildAnimator();
        Intrinsics.checkNotNullExpressionValue(animatorBuildAnimator, "buildAnimator(...)");
        return animatorBuildAnimator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect create$lambda$0(TextChangeAnimator this$0, View view) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (Intrinsics.areEqual(view, this$0.getTo())) {
            ViewGroup.LayoutParams layoutParams = ((TextView) this$0.getTo()).getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            i = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        } else {
            i = iArr[0];
        }
        if (Intrinsics.areEqual(view, this$0.getTo())) {
            ViewGroup.LayoutParams layoutParams2 = ((TextView) this$0.getTo()).getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            i2 = ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
        } else {
            i2 = iArr[1];
        }
        return new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
    }
}
