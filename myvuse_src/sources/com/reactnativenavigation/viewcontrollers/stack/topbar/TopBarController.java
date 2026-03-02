package com.reactnativenavigation.viewcontrollers.stack.topbar;

import android.animation.Animator;
import android.content.Context;
import android.view.MenuItem;
import androidx.viewpager.widget.ViewPager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.reactnativenavigation.options.Alignment;
import com.reactnativenavigation.options.AnimationOptions;
import com.reactnativenavigation.options.ComponentOptions;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.options.animations.ViewAnimationOptions;
import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.utils.CollectionUtils;
import com.reactnativenavigation.utils.Functions;
import com.reactnativenavigation.utils.ViewExtensionsKt;
import com.reactnativenavigation.utils.ViewUtils;
import com.reactnativenavigation.viewcontrollers.stack.topbar.button.ButtonController;
import com.reactnativenavigation.viewcontrollers.stack.topbar.title.TitleBarReactViewController;
import com.reactnativenavigation.views.animations.BaseViewAnimator;
import com.reactnativenavigation.views.stack.StackLayout;
import com.reactnativenavigation.views.stack.topbar.TopBar;
import com.reactnativenavigation.views.stack.topbar.titlebar.ButtonBar;
import com.reactnativenavigation.views.stack.topbar.titlebar.TitleBarReactView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TopBarController.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\u0014\u0010\u001e\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cJ\u0006\u0010\u001f\u001a\u00020\u0017J\u0018\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0014J\u0016\u0010%\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010&\u001a\u00020$J\u0018\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*J\u001a\u0010,\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0006J\u001a\u00102\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010-\u001a\u00020.J\u0006\u00103\u001a\u00020\u0017J\u0016\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u0002062\u0006\u0010-\u001a\u00020.J\u0010\u00107\u001a\u00020\u00172\b\u00108\u001a\u0004\u0018\u000109J$\u0010:\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\"\u0010<\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cJ\u000e\u0010=\u001a\u00020\u00172\u0006\u0010>\u001a\u00020?J\u0006\u0010@\u001a\u00020\u0017J\u0016\u0010A\u001a\u00020\u00172\u0006\u00105\u001a\u0002062\u0006\u0010-\u001a\u00020.R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u000e\u0010\r\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\bR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006B"}, m5598d2 = {"Lcom/reactnativenavigation/viewcontrollers/stack/topbar/TopBarController;", "", "animator", "Lcom/reactnativenavigation/viewcontrollers/stack/topbar/TopBarAnimator;", "(Lcom/reactnativenavigation/viewcontrollers/stack/topbar/TopBarAnimator;)V", "height", "", "getHeight", "()I", "leftButtonBar", "Lcom/reactnativenavigation/views/stack/topbar/titlebar/ButtonBar;", "leftButtonCount", "getLeftButtonCount", "rightButtonBar", "rightButtonCount", "getRightButtonCount", "view", "Lcom/reactnativenavigation/views/stack/topbar/TopBar;", "getView", "()Lcom/reactnativenavigation/views/stack/topbar/TopBar;", "setView", "(Lcom/reactnativenavigation/views/stack/topbar/TopBar;)V", "alignTitleComponent", "", "alignment", "Lcom/reactnativenavigation/options/Alignment;", "applyLeftButtons", "toAdd", "", "Lcom/reactnativenavigation/viewcontrollers/stack/topbar/button/ButtonController;", "applyRightButtons", "clearTopTabs", "createTopBar", "context", "Landroid/content/Context;", "stackLayout", "Lcom/reactnativenavigation/views/stack/StackLayout;", "createView", "parent", "getPopAnimation", "Landroid/animation/Animator;", "appearingOptions", "Lcom/reactnativenavigation/options/Options;", "disappearingOptions", "getPushAnimation", "additionalDy", "", "getRightButton", "Landroid/view/MenuItem;", FirebaseAnalytics.Param.INDEX, "getSetStackRootAnimation", "hide", "hideAnimate", "options", "Lcom/reactnativenavigation/options/AnimationOptions;", "initTopTabs", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "mergeLeftButtons", "toRemove", "mergeRightButtons", "setTitleComponent", "component", "Lcom/reactnativenavigation/viewcontrollers/stack/topbar/title/TitleBarReactViewController;", "show", "showAnimate", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public class TopBarController {
    private final TopBarAnimator animator;
    private ButtonBar leftButtonBar;
    private ButtonBar rightButtonBar;
    public TopBar view;

    /* JADX WARN: Multi-variable type inference failed */
    public TopBarController() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public TopBarController(TopBarAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        this.animator = animator;
    }

    public /* synthetic */ TopBarController(TopBarAnimator topBarAnimator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new TopBarAnimator(null, 1, null) : topBarAnimator);
    }

    public final TopBar getView() {
        TopBar topBar = this.view;
        if (topBar != null) {
            return topBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("view");
        return null;
    }

    public final void setView(TopBar topBar) {
        Intrinsics.checkNotNullParameter(topBar, "<set-?>");
        this.view = topBar;
    }

    public final int getHeight() {
        return getView().getHeight();
    }

    public final int getRightButtonCount() {
        ButtonBar buttonBar = this.rightButtonBar;
        if (buttonBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightButtonBar");
            buttonBar = null;
        }
        return buttonBar.getButtonCount();
    }

    public final int getLeftButtonCount() {
        ButtonBar buttonBar = this.leftButtonBar;
        if (buttonBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftButtonBar");
            buttonBar = null;
        }
        return buttonBar.getButtonCount();
    }

    public final MenuItem getRightButton(int index) {
        ButtonBar buttonBar = this.rightButtonBar;
        if (buttonBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightButtonBar");
            buttonBar = null;
        }
        return buttonBar.getButton(index);
    }

    public final TopBar createView(Context context, StackLayout parent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (this.view == null) {
            setView(createTopBar(context, parent));
            ButtonBar leftButtonBar = getView().getLeftButtonBar();
            Intrinsics.checkNotNullExpressionValue(leftButtonBar, "getLeftButtonBar(...)");
            this.leftButtonBar = leftButtonBar;
            ButtonBar rightButtonBar = getView().getRightButtonBar();
            Intrinsics.checkNotNullExpressionValue(rightButtonBar, "getRightButtonBar(...)");
            this.rightButtonBar = rightButtonBar;
            this.animator.bindView(getView());
        }
        return getView();
    }

    protected TopBar createTopBar(Context context, StackLayout stackLayout) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(stackLayout, "stackLayout");
        return new TopBar(context);
    }

    public final void initTopTabs(ViewPager viewPager) {
        getView().initTopTabs(viewPager);
    }

    public final void clearTopTabs() {
        getView().clearTopTabs();
    }

    public static /* synthetic */ Animator getPushAnimation$default(TopBarController topBarController, Options options, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPushAnimation");
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return topBarController.getPushAnimation(options, f);
    }

    public final Animator getPushAnimation(Options appearingOptions, float additionalDy) {
        Intrinsics.checkNotNullParameter(appearingOptions, "appearingOptions");
        if (appearingOptions.topBar.animate.isFalse()) {
            return null;
        }
        TopBarAnimator topBarAnimator = this.animator;
        ViewAnimationOptions viewAnimationOptions = appearingOptions.animations.push.topBar;
        Bool visible = appearingOptions.topBar.visible;
        Intrinsics.checkNotNullExpressionValue(visible, "visible");
        return topBarAnimator.getPushAnimation(viewAnimationOptions, visible, additionalDy);
    }

    public final Animator getPopAnimation(Options appearingOptions, Options disappearingOptions) {
        Intrinsics.checkNotNullParameter(appearingOptions, "appearingOptions");
        Intrinsics.checkNotNullParameter(disappearingOptions, "disappearingOptions");
        if (appearingOptions.topBar.animate.isFalse()) {
            return null;
        }
        TopBarAnimator topBarAnimator = this.animator;
        ViewAnimationOptions viewAnimationOptions = disappearingOptions.animations.pop.topBar;
        Bool visible = appearingOptions.topBar.visible;
        Intrinsics.checkNotNullExpressionValue(visible, "visible");
        return BaseViewAnimator.getPopAnimation$default(topBarAnimator, viewAnimationOptions, visible, 0.0f, 4, null);
    }

    public static /* synthetic */ Animator getSetStackRootAnimation$default(TopBarController topBarController, Options options, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSetStackRootAnimation");
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return topBarController.getSetStackRootAnimation(options, f);
    }

    public final Animator getSetStackRootAnimation(Options appearingOptions, float additionalDy) {
        Intrinsics.checkNotNullParameter(appearingOptions, "appearingOptions");
        if (appearingOptions.topBar.animate.isFalse()) {
            return null;
        }
        TopBarAnimator topBarAnimator = this.animator;
        ViewAnimationOptions viewAnimationOptions = appearingOptions.animations.setStackRoot.topBar;
        Bool visible = appearingOptions.topBar.visible;
        Intrinsics.checkNotNullExpressionValue(visible, "visible");
        return topBarAnimator.getSetStackRootAnimation(viewAnimationOptions, visible, additionalDy);
    }

    public final void show() {
        if (ViewUtils.isVisible(getView()) || this.animator.isAnimatingShow()) {
            return;
        }
        ViewExtensionsKt.resetViewProperties(getView());
        getView().setVisibility(0);
    }

    public final void showAnimate(AnimationOptions options, float additionalDy) {
        Intrinsics.checkNotNullParameter(options, "options");
        if (ViewUtils.isVisible(getView()) || this.animator.isAnimatingShow()) {
            return;
        }
        this.animator.show(options, additionalDy);
    }

    public final void hide() {
        if (this.animator.isAnimatingHide()) {
            return;
        }
        getView().setVisibility(8);
    }

    public final void hideAnimate(AnimationOptions options, float additionalDy) {
        Intrinsics.checkNotNullParameter(options, "options");
        if (!ViewUtils.isVisible(getView()) || this.animator.isAnimatingHide()) {
            return;
        }
        BaseViewAnimator.hide$default(this.animator, options, additionalDy, null, 4, null);
    }

    public final void setTitleComponent(TitleBarReactViewController component) {
        Intrinsics.checkNotNullParameter(component, "component");
        TopBar view = getView();
        TitleBarReactView view2 = component.getView();
        ComponentOptions component2 = component.getComponent();
        Alignment alignment = component2 != null ? component2.alignment : null;
        if (alignment == null) {
            alignment = Alignment.Default;
        }
        view.setTitleComponent(view2, alignment);
    }

    public final void alignTitleComponent(Alignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        getView().alignTitleComponent(alignment);
    }

    public final void applyRightButtons(List<? extends ButtonController> toAdd) {
        Intrinsics.checkNotNullParameter(toAdd, "toAdd");
        getView().clearRightButtons();
        int i = 0;
        for (Object obj : CollectionsKt.reversed(toAdd)) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ButtonController buttonController = (ButtonController) obj;
            ButtonBar buttonBar = this.rightButtonBar;
            if (buttonBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightButtonBar");
                buttonBar = null;
            }
            buttonController.addToMenu(buttonBar, i * 10);
            i = i2;
        }
    }

    public final void mergeRightButtons(List<? extends ButtonController> toAdd, List<? extends ButtonController> toRemove) {
        Intrinsics.checkNotNullParameter(toAdd, "toAdd");
        Intrinsics.checkNotNullParameter(toRemove, "toRemove");
        Iterator<T> it2 = toRemove.iterator();
        while (it2.hasNext()) {
            getView().removeRightButton((ButtonController) it2.next());
        }
        int i = 0;
        for (Object obj : CollectionsKt.reversed(toAdd)) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ButtonController buttonController = (ButtonController) obj;
            ButtonBar buttonBar = this.rightButtonBar;
            if (buttonBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightButtonBar");
                buttonBar = null;
            }
            buttonController.addToMenu(buttonBar, i * 10);
            i = i2;
        }
    }

    public void applyLeftButtons(List<? extends ButtonController> toAdd) {
        Intrinsics.checkNotNullParameter(toAdd, "toAdd");
        getView().clearBackButton();
        getView().clearLeftButtons();
        CollectionUtils.forEachIndexed(toAdd, new Functions.Func2() { // from class: com.reactnativenavigation.viewcontrollers.stack.topbar.TopBarController$$ExternalSyntheticLambda0
            @Override // com.reactnativenavigation.utils.Functions.Func2
            public final void run(Object obj, Object obj2) {
                TopBarController.applyLeftButtons$lambda$3(this.f$0, (ButtonController) obj, ((Integer) obj2).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyLeftButtons$lambda$3(TopBarController this$0, ButtonController b, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(b, "b");
        ButtonBar buttonBar = this$0.leftButtonBar;
        if (buttonBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftButtonBar");
            buttonBar = null;
        }
        b.addToMenu(buttonBar, i * 10);
    }

    public void mergeLeftButtons(List<? extends ButtonController> toAdd, List<? extends ButtonController> toRemove) {
        Intrinsics.checkNotNullParameter(toAdd, "toAdd");
        Intrinsics.checkNotNullParameter(toRemove, "toRemove");
        getView().clearBackButton();
        Iterator<T> it2 = toRemove.iterator();
        while (it2.hasNext()) {
            getView().removeLeftButton((ButtonController) it2.next());
        }
        CollectionUtils.forEachIndexed(toAdd, new Functions.Func2() { // from class: com.reactnativenavigation.viewcontrollers.stack.topbar.TopBarController$$ExternalSyntheticLambda1
            @Override // com.reactnativenavigation.utils.Functions.Func2
            public final void run(Object obj, Object obj2) {
                TopBarController.mergeLeftButtons$lambda$5(this.f$0, (ButtonController) obj, ((Integer) obj2).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mergeLeftButtons$lambda$5(TopBarController this$0, ButtonController b, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(b, "b");
        ButtonBar buttonBar = this$0.leftButtonBar;
        if (buttonBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftButtonBar");
            buttonBar = null;
        }
        b.addToMenu(buttonBar, i * 10);
    }
}
