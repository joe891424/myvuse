package com.reactnativenavigation.views.element;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.reactnativenavigation.options.SharedElementTransitionOptions;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.views.element.animators.BackgroundColorAnimator;
import com.reactnativenavigation.views.element.animators.FastImageBorderRadiusAnimator;
import com.reactnativenavigation.views.element.animators.FastImageBoundsAnimator;
import com.reactnativenavigation.views.element.animators.FastImageMatrixAnimator;
import com.reactnativenavigation.views.element.animators.PropertyAnimatorCreator;
import com.reactnativenavigation.views.element.animators.ReactImageBoundsAnimator;
import com.reactnativenavigation.views.element.animators.ReactImageMatrixAnimator;
import com.reactnativenavigation.views.element.animators.ReactViewOutlineAnimator;
import com.reactnativenavigation.views.element.animators.ReactViewRotationAnimator;
import com.reactnativenavigation.views.element.animators.RotationAnimator;
import com.reactnativenavigation.views.element.animators.TextChangeAnimator;
import com.reactnativenavigation.views.element.animators.XAnimator;
import com.reactnativenavigation.views.element.animators.YAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedElementTransition.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010!\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030#0\"H\u0002J\b\u0010$\u001a\u00020%H\u0016J\u0006\u0010&\u001a\u00020'R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR\u0011\u0010\u0014\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\nR\u001e\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006("}, m5598d2 = {"Lcom/reactnativenavigation/views/element/SharedElementTransition;", "Lcom/reactnativenavigation/views/element/Transition;", "appearing", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;", "options", "Lcom/reactnativenavigation/options/SharedElementTransitionOptions;", "(Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;Lcom/reactnativenavigation/options/SharedElementTransitionOptions;)V", "from", "Landroid/view/View;", "getFrom", "()Landroid/view/View;", "setFrom", "(Landroid/view/View;)V", "fromId", "", "getFromId", "()Ljava/lang/String;", TypedValues.TransitionType.S_TO, "getTo", "setTo", "toId", "getToId", "topInset", "", "getTopInset", "()I", "view", "getView", "viewController", "getViewController", "()Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;", "setViewController", "(Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;)V", "animators", "", "Lcom/reactnativenavigation/views/element/animators/PropertyAnimatorCreator;", "createAnimators", "Landroid/animation/AnimatorSet;", "isValid", "", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class SharedElementTransition extends Transition {
    public View from;
    private final String fromId;
    private final SharedElementTransitionOptions options;
    public View to;
    private final String toId;
    private ViewController<?> viewController;

    public SharedElementTransition(ViewController<?> appearing, SharedElementTransitionOptions options) {
        Intrinsics.checkNotNullParameter(appearing, "appearing");
        Intrinsics.checkNotNullParameter(options, "options");
        this.options = options;
        String str = options.getFromId().get();
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        this.fromId = str;
        String str2 = options.getToId().get();
        Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
        this.toId = str2;
        this.viewController = appearing;
    }

    public final String getFromId() {
        return this.fromId;
    }

    public final String getToId() {
        return this.toId;
    }

    public final View getFrom() {
        View view = this.from;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("from");
        return null;
    }

    public final void setFrom(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.from = view;
    }

    public final View getTo() {
        View view = this.to;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException(TypedValues.TransitionType.S_TO);
        return null;
    }

    public final void setTo(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.to = view;
    }

    @Override // com.reactnativenavigation.views.element.Transition
    public ViewController<?> getViewController() {
        return this.viewController;
    }

    @Override // com.reactnativenavigation.views.element.Transition
    public void setViewController(ViewController<?> viewController) {
        Intrinsics.checkNotNullParameter(viewController, "<set-?>");
        this.viewController = viewController;
    }

    @Override // com.reactnativenavigation.views.element.Transition
    public View getView() {
        return getTo();
    }

    @Override // com.reactnativenavigation.views.element.Transition
    public int getTopInset() {
        return getViewController().getTopInset();
    }

    public final boolean isValid() {
        return (this.from == null || this.to == null) ? false : true;
    }

    @Override // com.reactnativenavigation.views.element.Transition
    public AnimatorSet createAnimators() {
        List<PropertyAnimatorCreator<?>> listAnimators = animators();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listAnimators) {
            if (((PropertyAnimatorCreator) obj).shouldAnimateProperty()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            Animator animatorCreate = ((PropertyAnimatorCreator) it2.next()).create(this.options);
            animatorCreate.setDuration(this.options.getDuration());
            animatorCreate.setStartDelay(this.options.getStartDelay());
            animatorCreate.setInterpolator(this.options.getInterpolator());
            arrayList3.add(animatorCreate);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList3);
        return animatorSet;
    }

    private final List<PropertyAnimatorCreator<?>> animators() {
        return CollectionsKt.listOf((Object[]) new PropertyAnimatorCreator[]{new ReactImageMatrixAnimator(getFrom(), getTo()), new FastImageMatrixAnimator(getFrom(), getTo()), new ReactImageBoundsAnimator(getFrom(), getTo()), new FastImageBoundsAnimator(getFrom(), getTo()), new FastImageBorderRadiusAnimator(getFrom(), getTo()), new XAnimator(getFrom(), getTo()), new YAnimator(getFrom(), getTo()), new RotationAnimator(getFrom(), getTo()), new ReactViewRotationAnimator(getFrom(), getTo()), new BackgroundColorAnimator(getFrom(), getTo()), new ReactViewOutlineAnimator(getFrom(), getTo()), new TextChangeAnimator(getFrom(), getTo())});
    }
}
