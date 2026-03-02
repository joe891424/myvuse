package com.reactnativenavigation.views.animations;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import com.reactnativenavigation.options.AnimationOptions;
import com.reactnativenavigation.options.animations.ViewAnimationOptions;
import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.utils.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseViewAnimator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0003=>?B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0015\u0010'\u001a\u00020(2\u0006\u0010\u0006\u001a\u00028\u0000H\u0017¢\u0006\u0002\u0010%J\"\u0010)\u001a\u0004\u0018\u00010\r2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020/J\"\u00100\u001a\u0004\u0018\u00010\r2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020/J\"\u00101\u001a\u0004\u0018\u00010\r2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020/J(\u00102\u001a\u00020(2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u0010.\u001a\u00020/2\n\b\u0002\u00105\u001a\u0004\u0018\u000106H\u0016J\u0006\u00107\u001a\u00020\u0018J\u0006\u00108\u001a\u00020\u0018J\b\u00109\u001a\u00020(H\u0016J\b\u0010:\u001a\u00020(H\u0016J\u001a\u0010;\u001a\u00020(2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u0010<\u001a\u00020/R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8\u0006@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u001b\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0019R,\u0010\u001d\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8\u0006@BX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u0018\u0010!\u001a\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00028\u0000X\u0084.¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006@"}, m5598d2 = {"Lcom/reactnativenavigation/views/animations/BaseViewAnimator;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "", "hideDirection", "Lcom/reactnativenavigation/views/animations/BaseViewAnimator$HideDirection;", "view", "defaultAnimatorCreator", "Lcom/reactnativenavigation/views/animations/ViewAnimatorCreator;", "(Lcom/reactnativenavigation/views/animations/BaseViewAnimator$HideDirection;Landroid/view/View;Lcom/reactnativenavigation/views/animations/ViewAnimatorCreator;)V", "animationState", "Lcom/reactnativenavigation/views/animations/BaseViewAnimator$AnimationState;", "value", "Landroid/animation/Animator;", "hideAnimator", "getHideAnimator$annotations", "()V", "getHideAnimator", "()Landroid/animation/Animator;", "setHideAnimator", "(Landroid/animation/Animator;)V", "hideAnimatorListener", "Lcom/reactnativenavigation/views/animations/BaseViewAnimator$AnimatorListener;", "isFullyHidden", "", "()Z", "isFullyVisible", "isOrWillBeHidden", "isOrWillBeVisible", "showAnimator", "getShowAnimator$annotations", "getShowAnimator", "setShowAnimator", "showAnimatorListener", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "Landroid/view/View;", "bindView", "", "getPopAnimation", "animation", "Lcom/reactnativenavigation/options/animations/ViewAnimationOptions;", ViewProps.VISIBLE, "Lcom/reactnativenavigation/options/params/Bool;", "additionalDy", "", "getPushAnimation", "getSetStackRootAnimation", "hide", "options", "Lcom/reactnativenavigation/options/AnimationOptions;", "onAnimationEnd", "Ljava/lang/Runnable;", "isAnimatingHide", "isAnimatingShow", "onHideAnimationEnd", "onShowAnimationEnd", "show", "translationStartDy", "AnimationState", "AnimatorListener", "HideDirection", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public class BaseViewAnimator<T extends View> {
    private AnimationState animationState;
    private final ViewAnimatorCreator defaultAnimatorCreator;
    private Animator hideAnimator;
    private final BaseViewAnimator<T>.AnimatorListener hideAnimatorListener;
    private final HideDirection hideDirection;
    private Animator showAnimator;
    private final BaseViewAnimator<T>.AnimatorListener showAnimatorListener;
    protected T view;

    public static /* synthetic */ void getHideAnimator$annotations() {
    }

    public static /* synthetic */ void getShowAnimator$annotations() {
    }

    public void onHideAnimationEnd() {
    }

    public void onShowAnimationEnd() {
    }

    public BaseViewAnimator(HideDirection hideDirection, T t, ViewAnimatorCreator defaultAnimatorCreator) {
        Intrinsics.checkNotNullParameter(hideDirection, "hideDirection");
        Intrinsics.checkNotNullParameter(defaultAnimatorCreator, "defaultAnimatorCreator");
        this.hideDirection = hideDirection;
        this.defaultAnimatorCreator = defaultAnimatorCreator;
        this.showAnimator = new AnimatorSet();
        this.hideAnimator = new AnimatorSet();
        this.showAnimatorListener = new AnimatorListener(this, AnimationState.AnimatingEnter, 0);
        this.hideAnimatorListener = new AnimatorListener(this, AnimationState.AnimatingExit, 8);
        this.animationState = AnimationState.Idle;
        if (t != null) {
            setView(t);
        }
    }

    public /* synthetic */ BaseViewAnimator(HideDirection hideDirection, View view, DefaultViewAnimatorCreator defaultViewAnimatorCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(hideDirection, (i & 2) != 0 ? null : view, (i & 4) != 0 ? new DefaultViewAnimatorCreator() : defaultViewAnimatorCreator);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: BaseViewAnimator.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/reactnativenavigation/views/animations/BaseViewAnimator$HideDirection;", "", "(Ljava/lang/String;I)V", "Up", "Down", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class HideDirection {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ HideDirection[] $VALUES;

        /* JADX INFO: renamed from: Up */
        public static final HideDirection f4208Up = new HideDirection("Up", 0);
        public static final HideDirection Down = new HideDirection("Down", 1);

        private static final /* synthetic */ HideDirection[] $values() {
            return new HideDirection[]{f4208Up, Down};
        }

        public static EnumEntries<HideDirection> getEntries() {
            return $ENTRIES;
        }

        public static HideDirection valueOf(String str) {
            return (HideDirection) Enum.valueOf(HideDirection.class, str);
        }

        public static HideDirection[] values() {
            return (HideDirection[]) $VALUES.clone();
        }

        static {
            HideDirection[] hideDirectionArr$values = $values();
            $VALUES = hideDirectionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(hideDirectionArr$values);
        }

        private HideDirection(String str, int i) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: BaseViewAnimator.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m5598d2 = {"Lcom/reactnativenavigation/views/animations/BaseViewAnimator$AnimationState;", "", "(Ljava/lang/String;I)V", "Idle", "AnimatingEnter", "AnimatingExit", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    private static final class AnimationState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AnimationState[] $VALUES;
        public static final AnimationState Idle = new AnimationState("Idle", 0);
        public static final AnimationState AnimatingEnter = new AnimationState("AnimatingEnter", 1);
        public static final AnimationState AnimatingExit = new AnimationState("AnimatingExit", 2);

        private static final /* synthetic */ AnimationState[] $values() {
            return new AnimationState[]{Idle, AnimatingEnter, AnimatingExit};
        }

        public static EnumEntries<AnimationState> getEntries() {
            return $ENTRIES;
        }

        public static AnimationState valueOf(String str) {
            return (AnimationState) Enum.valueOf(AnimationState.class, str);
        }

        public static AnimationState[] values() {
            return (AnimationState[]) $VALUES.clone();
        }

        static {
            AnimationState[] animationStateArr$values = $values();
            $VALUES = animationStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(animationStateArr$values);
        }

        private AnimationState(String str, int i) {
        }
    }

    protected final T getView() {
        T t = this.view;
        if (t != null) {
            return t;
        }
        Intrinsics.throwUninitializedPropertyAccessException("view");
        return null;
    }

    protected final void setView(T t) {
        Intrinsics.checkNotNullParameter(t, "<set-?>");
        this.view = t;
    }

    public final Animator getShowAnimator() {
        return this.showAnimator;
    }

    private final void setShowAnimator(Animator animator) {
        this.showAnimator = animator;
        animator.addListener(this.showAnimatorListener);
        this.showAnimator.addListener(new Animator.AnimatorListener() { // from class: com.reactnativenavigation.views.animations.BaseViewAnimator$special$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                Intrinsics.checkNotNullParameter(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                Intrinsics.checkNotNullParameter(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                Intrinsics.checkNotNullParameter(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                Intrinsics.checkNotNullParameter(animator2, "animator");
                this.this$0.onShowAnimationEnd();
            }
        });
    }

    public final Animator getHideAnimator() {
        return this.hideAnimator;
    }

    public final void setHideAnimator(Animator value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.hideAnimator = value;
        value.addListener(this.hideAnimatorListener);
        this.hideAnimator.addListener(new Animator.AnimatorListener() { // from class: com.reactnativenavigation.views.animations.BaseViewAnimator$special$$inlined$doOnEnd$2
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
                this.this$0.onHideAnimationEnd();
            }
        });
    }

    /* JADX INFO: compiled from: BaseViewAnimator.kt */
    @Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m5598d2 = {"Lcom/reactnativenavigation/views/animations/BaseViewAnimator$AnimatorListener;", "Landroid/animation/AnimatorListenerAdapter;", "startState", "Lcom/reactnativenavigation/views/animations/BaseViewAnimator$AnimationState;", "endVisibility", "", "(Lcom/reactnativenavigation/views/animations/BaseViewAnimator;Lcom/reactnativenavigation/views/animations/BaseViewAnimator$AnimationState;I)V", "isCancelled", "", "()Z", "setCancelled", "(Z)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    private final class AnimatorListener extends AnimatorListenerAdapter {
        private final int endVisibility;
        private boolean isCancelled;
        private final AnimationState startState;
        final /* synthetic */ BaseViewAnimator<T> this$0;

        public AnimatorListener(BaseViewAnimator baseViewAnimator, AnimationState startState, int i) {
            Intrinsics.checkNotNullParameter(startState, "startState");
            this.this$0 = baseViewAnimator;
            this.startState = startState;
            this.endVisibility = i;
        }

        /* JADX INFO: renamed from: isCancelled, reason: from getter */
        public final boolean getIsCancelled() {
            return this.isCancelled;
        }

        public final void setCancelled(boolean z) {
            this.isCancelled = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            ViewExtensionsKt.resetViewProperties(this.this$0.getView());
            this.this$0.getView().setVisibility(0);
            ((BaseViewAnimator) this.this$0).animationState = this.startState;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.isCancelled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (this.isCancelled) {
                return;
            }
            ((BaseViewAnimator) this.this$0).animationState = AnimationState.Idle;
            this.this$0.getView().setVisibility(this.endVisibility);
        }
    }

    private final boolean isOrWillBeVisible() {
        return isFullyVisible() || this.animationState == AnimationState.AnimatingEnter;
    }

    private final boolean isFullyVisible() {
        return getView().getVisibility() == 0 && this.animationState == AnimationState.Idle;
    }

    public final boolean isOrWillBeHidden() {
        return isFullyHidden() || this.animationState == AnimationState.AnimatingExit;
    }

    private final boolean isFullyHidden() {
        return getView().getVisibility() == 8 && this.animationState == AnimationState.Idle;
    }

    public void bindView(T view) {
        Intrinsics.checkNotNullParameter(view, "view");
        setView(view);
    }

    public final boolean isAnimatingHide() {
        return this.hideAnimator.isRunning();
    }

    public final boolean isAnimatingShow() {
        return this.showAnimator.isRunning();
    }

    public static /* synthetic */ Animator getPushAnimation$default(BaseViewAnimator baseViewAnimator, ViewAnimationOptions viewAnimationOptions, Bool bool, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPushAnimation");
        }
        if ((i & 4) != 0) {
            f = 0.0f;
        }
        return baseViewAnimator.getPushAnimation(viewAnimationOptions, bool, f);
    }

    public final Animator getPushAnimation(ViewAnimationOptions animation, Bool visible, float additionalDy) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Intrinsics.checkNotNullParameter(visible, "visible");
        if (isOrWillBeVisible() && visible.isFalse()) {
            this.showAnimator.cancel();
            setHideAnimator(animation.exit.getAnimation(getView(), this.defaultAnimatorCreator.getHideAnimator(getView(), this.hideDirection, additionalDy)));
            return this.hideAnimator;
        }
        if (!isOrWillBeHidden() || !visible.isTrueOrUndefined()) {
            return null;
        }
        this.hideAnimator.cancel();
        setShowAnimator(animation.enter.getAnimation(getView(), this.defaultAnimatorCreator.getShowAnimator(getView(), this.hideDirection, additionalDy)));
        return this.showAnimator;
    }

    public static /* synthetic */ Animator getPopAnimation$default(BaseViewAnimator baseViewAnimator, ViewAnimationOptions viewAnimationOptions, Bool bool, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPopAnimation");
        }
        if ((i & 4) != 0) {
            f = 0.0f;
        }
        return baseViewAnimator.getPopAnimation(viewAnimationOptions, bool, f);
    }

    public final Animator getPopAnimation(ViewAnimationOptions animation, Bool visible, float additionalDy) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Intrinsics.checkNotNullParameter(visible, "visible");
        if (isOrWillBeVisible() && visible.isFalse()) {
            this.showAnimator.cancel();
            setHideAnimator(animation.exit.getAnimation(getView(), this.defaultAnimatorCreator.getHideAnimator(getView(), this.hideDirection, additionalDy)));
            return this.hideAnimator;
        }
        if (!isOrWillBeHidden() || !visible.isTrueOrUndefined()) {
            return null;
        }
        this.hideAnimator.cancel();
        setShowAnimator(animation.enter.getAnimation(getView(), this.defaultAnimatorCreator.getShowAnimator(getView(), this.hideDirection, additionalDy)));
        return this.showAnimator;
    }

    public static /* synthetic */ Animator getSetStackRootAnimation$default(BaseViewAnimator baseViewAnimator, ViewAnimationOptions viewAnimationOptions, Bool bool, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSetStackRootAnimation");
        }
        if ((i & 4) != 0) {
            f = 0.0f;
        }
        return baseViewAnimator.getSetStackRootAnimation(viewAnimationOptions, bool, f);
    }

    public final Animator getSetStackRootAnimation(ViewAnimationOptions animation, Bool visible, float additionalDy) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Intrinsics.checkNotNullParameter(visible, "visible");
        if (isOrWillBeVisible() && visible.isFalse()) {
            this.showAnimator.cancel();
            setHideAnimator(animation.exit.getAnimation(getView(), this.defaultAnimatorCreator.getHideAnimator(getView(), this.hideDirection, additionalDy)));
            return this.hideAnimator;
        }
        if (!isOrWillBeHidden() || !visible.isTrueOrUndefined()) {
            return null;
        }
        this.hideAnimator.cancel();
        setShowAnimator(animation.enter.getAnimation(getView(), this.defaultAnimatorCreator.getShowAnimator(getView(), this.hideDirection, additionalDy)));
        return this.showAnimator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void show$default(BaseViewAnimator baseViewAnimator, AnimationOptions animationOptions, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        }
        if ((i & 1) != 0) {
            animationOptions = new AnimationOptions(null, 1, 0 == true ? 1 : 0);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        baseViewAnimator.show(animationOptions, f);
    }

    public final void show(AnimationOptions options, float translationStartDy) {
        Animator showAnimator;
        Intrinsics.checkNotNullParameter(options, "options");
        if (isOrWillBeVisible()) {
            return;
        }
        if (options.hasValue()) {
            options.setValueDy(View.TRANSLATION_Y, -translationStartDy, 0.0f);
            showAnimator = options.getAnimation(getView());
        } else {
            showAnimator = this.defaultAnimatorCreator.getShowAnimator(getView(), this.hideDirection, translationStartDy);
        }
        setShowAnimator(showAnimator);
        this.hideAnimator.cancel();
        this.showAnimator.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void hide$default(BaseViewAnimator baseViewAnimator, AnimationOptions animationOptions, float f, Runnable runnable, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hide");
        }
        JSONObject jSONObject = null;
        Object[] objArr = 0;
        if ((i & 1) != 0) {
            animationOptions = new AnimationOptions(jSONObject, 1, objArr == true ? 1 : 0);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            runnable = null;
        }
        baseViewAnimator.hide(animationOptions, f, runnable);
    }

    public void hide(AnimationOptions options, float additionalDy, final Runnable onAnimationEnd) {
        Animator hideAnimator;
        Intrinsics.checkNotNullParameter(options, "options");
        if (isOrWillBeHidden()) {
            return;
        }
        if (options.hasValue()) {
            options.setValueDy(View.TRANSLATION_Y, 0.0f, -additionalDy);
            hideAnimator = options.getAnimation(getView());
        } else {
            hideAnimator = this.defaultAnimatorCreator.getHideAnimator(getView(), this.hideDirection, additionalDy);
        }
        setHideAnimator(hideAnimator);
        this.showAnimator.cancel();
        Animator animator = this.hideAnimator;
        animator.addListener(new Animator.AnimatorListener() { // from class: com.reactnativenavigation.views.animations.BaseViewAnimator$hide$lambda$4$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                Intrinsics.checkNotNullParameter(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                Intrinsics.checkNotNullParameter(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                Intrinsics.checkNotNullParameter(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                Intrinsics.checkNotNullParameter(animator2, "animator");
                Runnable runnable = onAnimationEnd;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        animator.start();
    }
}
