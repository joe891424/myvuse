package com.reactnativenavigation.viewcontrollers.stack;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.reactnativenavigation.options.Alignment;
import com.reactnativenavigation.options.AnimationOptions;
import com.reactnativenavigation.options.ButtonOptions;
import com.reactnativenavigation.options.ComponentOptions;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.options.OrientationOptions;
import com.reactnativenavigation.options.TopBarButtons;
import com.reactnativenavigation.options.TopBarOptions;
import com.reactnativenavigation.options.TopTabOptions;
import com.reactnativenavigation.options.TopTabsOptions;
import com.reactnativenavigation.options.params.ThemeColour;
import com.reactnativenavigation.options.parsers.TypefaceLoader;
import com.reactnativenavigation.utils.CollectionUtils;
import com.reactnativenavigation.utils.Functions;
import com.reactnativenavigation.utils.ObjectUtils;
import com.reactnativenavigation.utils.RenderChecker;
import com.reactnativenavigation.utils.SystemUiUtils;
import com.reactnativenavigation.utils.UiUtils;
import com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabsController;
import com.reactnativenavigation.viewcontrollers.stack.topbar.TopBarBackgroundViewController;
import com.reactnativenavigation.viewcontrollers.stack.topbar.TopBarController;
import com.reactnativenavigation.viewcontrollers.stack.topbar.button.ButtonController;
import com.reactnativenavigation.viewcontrollers.stack.topbar.button.ButtonPresenter;
import com.reactnativenavigation.viewcontrollers.stack.topbar.button.IconResolver;
import com.reactnativenavigation.viewcontrollers.stack.topbar.title.TitleBarReactViewController;
import com.reactnativenavigation.viewcontrollers.viewcontroller.IReactView;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.views.stack.topbar.TopBar;
import com.reactnativenavigation.views.stack.topbar.TopBarBackgroundViewCreator;
import com.reactnativenavigation.views.stack.topbar.titlebar.TitleBarButtonCreator;
import com.reactnativenavigation.views.stack.topbar.titlebar.TitleBarReactViewCreator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class StackPresenter {
    private static final int DEFAULT_BORDER_COLOR = -16777216;
    private static final double DEFAULT_ELEVATION = 4.0d;
    private final Activity activity;
    private BottomTabsController bottomTabsController;
    private final TitleBarButtonCreator buttonCreator;
    private Options defaultOptions;
    private final IconResolver iconResolver;
    private ButtonController.OnClickListener onClickListener;
    private final RenderChecker renderChecker;
    private final TitleBarReactViewCreator titleViewCreator;
    private TopBar topBar;
    private final TopBarBackgroundViewCreator topBarBackgroundViewCreator;
    private TopBarController topBarController;
    private final TypefaceLoader typefaceLoader;
    private List<ButtonController> currentRightButtons = new ArrayList();
    private List<ButtonController> currentLeftButtons = new ArrayList();
    private final Map<View, TitleBarReactViewController> titleControllers = new HashMap();
    private final Map<View, TopBarBackgroundViewController> backgroundControllers = new HashMap();
    private final Map<View, Map<String, ButtonController>> componentRightButtons = new HashMap();
    private final Map<View, Map<String, ButtonController>> componentLeftButtons = new HashMap();

    public StackPresenter(Activity activity, TitleBarReactViewCreator titleBarReactViewCreator, TopBarBackgroundViewCreator topBarBackgroundViewCreator, TitleBarButtonCreator titleBarButtonCreator, IconResolver iconResolver, TypefaceLoader typefaceLoader, RenderChecker renderChecker, Options options) {
        this.activity = activity;
        this.titleViewCreator = titleBarReactViewCreator;
        this.topBarBackgroundViewCreator = topBarBackgroundViewCreator;
        this.buttonCreator = titleBarButtonCreator;
        this.iconResolver = iconResolver;
        this.typefaceLoader = typefaceLoader;
        this.renderChecker = renderChecker;
        this.defaultOptions = options;
    }

    public void setDefaultOptions(Options options) {
        this.defaultOptions = options;
    }

    public void setButtonOnClickListener(ButtonController.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public Options getDefaultOptions() {
        return this.defaultOptions;
    }

    public void bindView(TopBarController topBarController, BottomTabsController bottomTabsController) {
        this.topBarController = topBarController;
        this.bottomTabsController = bottomTabsController;
        this.topBar = topBarController.getView();
    }

    public boolean isRendered(View view) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll((Collection) ObjectUtils.perform(this.componentRightButtons.get(view), new ArrayList(), new StackPresenter$$ExternalSyntheticLambda4()));
        arrayList.addAll((Collection) ObjectUtils.perform(this.componentLeftButtons.get(view), new ArrayList(), new StackPresenter$$ExternalSyntheticLambda4()));
        arrayList.add(this.backgroundControllers.get(view));
        arrayList.add(this.titleControllers.get(view));
        return this.renderChecker.areRendered(CollectionUtils.filter(arrayList, new CollectionUtils.Filter() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackPresenter$$ExternalSyntheticLambda7
            @Override // com.reactnativenavigation.utils.CollectionUtils.Filter
            public final boolean filter(Object obj) {
                return ObjectUtils.notNull((ViewController) obj);
            }
        }));
    }

    public void mergeOptions(Options options, StackController stackController, ViewController<?> viewController) {
        TopBarOptions topBarOptionsMergeWithDefault = options.topBar.copy().mergeWithDefault(stackController.resolveChildOptions(viewController).topBar).mergeWithDefault(this.defaultOptions.topBar);
        mergeOrientation(options.layout.orientation);
        mergeTopBarOptions(topBarOptionsMergeWithDefault, options, stackController, viewController);
        mergeTopTabsOptions(options.topTabs);
        mergeTopTabOptions(options.topTabOptions);
    }

    public void onConfigurationChanged(Options options) {
        if (this.topBar == null) {
            return;
        }
        Options optionsWithDefaultOptions = options.copy().withDefaultOptions(this.defaultOptions);
        List<ButtonController> list = this.currentRightButtons;
        if (list != null && !list.isEmpty()) {
            this.topBarController.applyRightButtons(this.currentRightButtons);
        }
        List<ButtonController> list2 = this.currentLeftButtons;
        if (list2 != null && !list2.isEmpty()) {
            this.topBarController.applyLeftButtons(this.currentLeftButtons);
        }
        if (optionsWithDefaultOptions.topBar.buttons.back.visible.isTrue()) {
            this.topBar.setBackButton(lambda$getOrCreateButtonControllersByInstanceId$0(optionsWithDefaultOptions.topBar.buttons.back));
        }
        this.topBar.setOverflowButtonColor(optionsWithDefaultOptions.topBar.rightButtonColor.get(-16777216).intValue());
        this.topBar.applyTopTabsColors(optionsWithDefaultOptions.topTabs.selectedTabColor, optionsWithDefaultOptions.topTabs.unselectedTabColor);
        this.topBar.setBorderColor(optionsWithDefaultOptions.topBar.borderColor.get(-16777216).intValue());
        this.topBar.setBackgroundColor(optionsWithDefaultOptions.topBar.background.color.get(-1).intValue());
        this.topBar.setTitleTextColor(optionsWithDefaultOptions.topBar.title.color.get(-16777216).intValue());
        this.topBar.setSubtitleColor(optionsWithDefaultOptions.topBar.subtitle.color.get(-16777216).intValue());
    }

    public void applyInitialChildLayoutOptions(Options options) {
        applyTopBarVisibility(options.copy().withDefaultOptions(this.defaultOptions).topBar);
    }

    public void applyChildOptions(Options options, StackController stackController, ViewController<?> viewController) {
        Options optionsWithDefaultOptions = options.copy().withDefaultOptions(this.defaultOptions);
        applyOrientation(optionsWithDefaultOptions.layout.orientation);
        applyButtons(optionsWithDefaultOptions.topBar, viewController);
        applyTopBarOptions(optionsWithDefaultOptions, stackController, viewController);
        applyTopTabsOptions(optionsWithDefaultOptions.topTabs);
        applyTopTabOptions(optionsWithDefaultOptions.topTabOptions);
    }

    public void applyOrientation(OrientationOptions orientationOptions) {
        ((Activity) this.topBar.getContext()).setRequestedOrientation(orientationOptions.copy().mergeWithDefault(this.defaultOptions.layout.orientation).getValue());
    }

    public void onChildDestroyed(ViewController<?> viewController) {
        ObjectUtils.perform(this.titleControllers.remove(viewController.getView()), new StackPresenter$$ExternalSyntheticLambda0());
        ObjectUtils.perform(this.backgroundControllers.remove(viewController.getView()), new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackPresenter$$ExternalSyntheticLambda10
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                ((TopBarBackgroundViewController) obj).destroy();
            }
        });
        destroyButtons(this.componentRightButtons.get(viewController.getView()));
        destroyButtons(this.componentLeftButtons.get(viewController.getView()));
        this.componentRightButtons.remove(viewController.getView());
        this.componentLeftButtons.remove(viewController.getView());
    }

    private void destroyButtons(Map<String, ButtonController> map) {
        if (map != null) {
            CollectionUtils.forEach(map.values(), new StackPresenter$$ExternalSyntheticLambda12());
        }
    }

    private void applyTopBarOptions(Options options, StackController stackController, ViewController<?> viewController) {
        KeyEvent.Callback view = viewController.getView();
        TopBarOptions topBarOptions = options.topBar;
        Options optionsWithDefaultOptions = stackController.resolveChildOptions(viewController).withDefaultOptions(this.defaultOptions);
        this.topBar.setTestId(topBarOptions.testId.get(""));
        this.topBar.setLayoutDirection(options.layout.direction);
        applyStatusBarDrawBehindOptions(topBarOptions, optionsWithDefaultOptions);
        this.topBar.setElevation(topBarOptions.elevation.get(Double.valueOf(DEFAULT_ELEVATION)));
        if (topBarOptions.topMargin.hasValue() && (this.topBar.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.topBar.getLayoutParams()).topMargin = UiUtils.dpToPx((Context) this.activity, topBarOptions.topMargin.get(0).intValue());
        }
        this.topBar.setTitleHeight(topBarOptions.title.height.get(Integer.valueOf(UiUtils.getTopBarHeightDp(this.activity))).intValue());
        this.topBar.setTitleTopMargin(topBarOptions.title.topMargin.get(0).intValue());
        if (topBarOptions.title.component.hasValue()) {
            if (this.titleControllers.containsKey(view)) {
                this.topBarController.setTitleComponent((TitleBarReactViewController) Objects.requireNonNull(this.titleControllers.get(view)));
            } else {
                TitleBarReactViewController titleBarReactViewController = new TitleBarReactViewController(this.activity, this.titleViewCreator, topBarOptions.title.component);
                titleBarReactViewController.setWaitForRender(topBarOptions.title.component.waitForRender);
                this.titleControllers.put((View) view, titleBarReactViewController);
                this.topBarController.setTitleComponent(titleBarReactViewController);
            }
            this.topBarController.alignTitleComponent(topBarOptions.title.component.alignment);
        } else {
            this.topBar.applyTitleOptions(topBarOptions.title, this.typefaceLoader);
            this.topBar.applySubtitleOptions(topBarOptions.subtitle, this.typefaceLoader);
            this.topBarController.alignTitleComponent(topBarOptions.title.alignment);
        }
        this.topBar.setBorderHeight(topBarOptions.borderHeight.get(Double.valueOf(0.0d)).doubleValue());
        this.topBar.setBorderColor(topBarOptions.borderColor.get(-16777216).intValue());
        this.topBar.setBackgroundColor(topBarOptions.background.color.get(-1).intValue());
        if (topBarOptions.background.component.hasValue()) {
            View viewFindBackgroundComponent = findBackgroundComponent(topBarOptions.background.component);
            if (viewFindBackgroundComponent != null) {
                this.topBar.setBackgroundComponent(viewFindBackgroundComponent);
            } else {
                TopBarBackgroundViewController topBarBackgroundViewController = new TopBarBackgroundViewController(this.activity, this.topBarBackgroundViewCreator);
                topBarBackgroundViewController.setWaitForRender(topBarOptions.background.waitForRender);
                this.backgroundControllers.put((View) view, topBarBackgroundViewController);
                topBarBackgroundViewController.setComponent(topBarOptions.background.component);
                topBarBackgroundViewController.getView().setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                this.topBar.setBackgroundComponent(topBarBackgroundViewController.getView());
            }
        } else {
            this.topBar.clearBackgroundComponent();
        }
        applyTopBarVisibilityIfChildIsNotBeingAnimated(topBarOptions, stackController, viewController);
        if (topBarOptions.hideOnScroll.isTrue()) {
            if (view instanceof IReactView) {
                this.topBar.enableCollapse(((IReactView) view).getScrollEventListener());
            }
        } else if (topBarOptions.hideOnScroll.isFalseOrUndefined()) {
            this.topBar.disableCollapse();
        }
    }

    private void applyStatusBarDrawBehindOptions(TopBarOptions topBarOptions, Options options) {
        if (options.statusBar.visible.isTrueOrUndefined() && options.statusBar.drawBehind.isTrue()) {
            this.topBar.setTopPadding(SystemUiUtils.getStatusBarHeight(this.activity));
            this.topBar.setHeight(topBarOptions.height.get(Integer.valueOf(UiUtils.getTopBarHeightDp(this.activity))).intValue() + SystemUiUtils.getStatusBarHeightDp(this.activity));
        } else {
            this.topBar.setTopPadding(0);
            this.topBar.setHeight(topBarOptions.height.get(Integer.valueOf(UiUtils.getTopBarHeightDp(this.activity))).intValue());
        }
    }

    private void mergeStatusBarDrawBehindOptions(TopBarOptions topBarOptions, Options options) {
        if (options.statusBar.visible.isTrueOrUndefined()) {
            if (options.statusBar.drawBehind.hasValue()) {
                if (options.statusBar.drawBehind.isTrue()) {
                    this.topBar.setTopPadding(SystemUiUtils.getStatusBarHeight(this.activity));
                    this.topBar.setHeight(topBarOptions.height.get(Integer.valueOf(UiUtils.getTopBarHeightDp(this.activity))).intValue() + SystemUiUtils.getStatusBarHeightDp(this.activity));
                    return;
                } else {
                    this.topBar.setTopPadding(0);
                    this.topBar.setHeight(topBarOptions.height.get(Integer.valueOf(UiUtils.getTopBarHeightDp(this.activity))).intValue());
                    return;
                }
            }
            return;
        }
        if (options.statusBar.drawBehind.hasValue()) {
            if (options.statusBar.drawBehind.isFalseOrUndefined()) {
                this.topBar.setTopPadding(SystemUiUtils.getStatusBarHeight(this.activity));
                this.topBar.setHeight(topBarOptions.height.get(Integer.valueOf(UiUtils.getTopBarHeightDp(this.activity))).intValue() + SystemUiUtils.getStatusBarHeightDp(this.activity));
            } else {
                this.topBar.setTopPadding(0);
                this.topBar.setHeight(topBarOptions.height.get(Integer.valueOf(UiUtils.getTopBarHeightDp(this.activity))).intValue());
            }
        }
    }

    private View findBackgroundComponent(ComponentOptions componentOptions) {
        for (TopBarBackgroundViewController topBarBackgroundViewController : this.backgroundControllers.values()) {
            if (ObjectUtils.equalsNotNull(topBarBackgroundViewController.getComponent().name.get(null), componentOptions.name.get(null)) && ObjectUtils.equalsNotNull(topBarBackgroundViewController.getComponent().componentId.get(null), componentOptions.componentId.get(null))) {
                return topBarBackgroundViewController.getView();
            }
        }
        return null;
    }

    private void applyTopBarVisibilityIfChildIsNotBeingAnimated(TopBarOptions topBarOptions, StackController stackController, ViewController<?> viewController) {
        if (!stackController.isChildInTransition(viewController) || topBarOptions.animate.isFalse()) {
            applyTopBarVisibility(topBarOptions);
        }
    }

    private void applyTopBarVisibility(TopBarOptions topBarOptions) {
        if (topBarOptions.visible.isFalse()) {
            this.topBarController.hide();
        }
        if (topBarOptions.visible.isTrueOrUndefined()) {
            this.topBarController.show();
        }
    }

    private void applyButtons(TopBarOptions topBarOptions, ViewController<?> viewController) {
        if (topBarOptions.buttons.right != null) {
            List<ButtonController> orCreateButtonControllersByInstanceId = getOrCreateButtonControllersByInstanceId(this.componentRightButtons.get(viewController.getView()), mergeButtonsWithColor(topBarOptions.buttons.right, topBarOptions.rightButtonColor, topBarOptions.rightButtonDisabledColor));
            this.componentRightButtons.put(viewController.getView(), CollectionUtils.keyBy(orCreateButtonControllersByInstanceId, new StackPresenter$$ExternalSyntheticLambda16()));
            if (!CollectionUtils.equals(this.currentRightButtons, orCreateButtonControllersByInstanceId)) {
                this.currentRightButtons = orCreateButtonControllersByInstanceId;
                this.topBarController.applyRightButtons(orCreateButtonControllersByInstanceId);
            }
        } else {
            this.currentRightButtons = null;
            this.topBar.clearRightButtons();
        }
        if (topBarOptions.buttons.left != null) {
            List<ButtonController> orCreateButtonControllersByInstanceId2 = getOrCreateButtonControllersByInstanceId(this.componentLeftButtons.get(viewController.getView()), mergeButtonsWithColor(topBarOptions.buttons.left, topBarOptions.leftButtonColor, topBarOptions.leftButtonDisabledColor));
            this.componentLeftButtons.put(viewController.getView(), CollectionUtils.keyBy(orCreateButtonControllersByInstanceId2, new StackPresenter$$ExternalSyntheticLambda16()));
            if (!CollectionUtils.equals(this.currentLeftButtons, orCreateButtonControllersByInstanceId2)) {
                this.currentLeftButtons = orCreateButtonControllersByInstanceId2;
                this.topBarController.applyLeftButtons(orCreateButtonControllersByInstanceId2);
            }
        } else {
            this.currentLeftButtons = null;
            this.topBar.clearLeftButtons();
        }
        if (topBarOptions.buttons.back.visible.isTrue() && !topBarOptions.buttons.hasLeftButtons()) {
            this.topBar.setBackButton(lambda$getOrCreateButtonControllersByInstanceId$0(topBarOptions.buttons.back));
        }
        if (topBarOptions.animateRightButtons.hasValue()) {
            this.topBar.animateRightButtons(topBarOptions.animateRightButtons.isTrue());
        }
        if (topBarOptions.animateLeftButtons.hasValue()) {
            this.topBar.animateLeftButtons(topBarOptions.animateLeftButtons.isTrue());
        }
        this.topBar.setOverflowButtonColor(topBarOptions.rightButtonColor.get(-16777216).intValue());
    }

    private List<ButtonController> getOrCreateButtonControllersByInstanceId(final Map<String, ButtonController> map, List<ButtonOptions> list) {
        if (list == null) {
            return null;
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        CollectionUtils.forEach((List) list, new CollectionUtils.Apply() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackPresenter$$ExternalSyntheticLambda11
            @Override // com.reactnativenavigation.utils.CollectionUtils.Apply
            /* JADX INFO: renamed from: on */
            public final void mo2796on(Object obj) {
                this.f$0.lambda$getOrCreateButtonControllersByInstanceId$1(linkedHashMap, map, (ButtonOptions) obj);
            }
        });
        return new ArrayList(linkedHashMap.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getOrCreateButtonControllersByInstanceId$1(Map map, Map map2, final ButtonOptions buttonOptions) {
        map.put(buttonOptions.instanceId, (ButtonController) CollectionUtils.getOrDefault(map2, buttonOptions.instanceId, new Functions.FuncR() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackPresenter$$ExternalSyntheticLambda1
            @Override // com.reactnativenavigation.utils.Functions.FuncR
            public final Object run() {
                return this.f$0.lambda$getOrCreateButtonControllersByInstanceId$0(buttonOptions);
            }
        }));
    }

    private List<ButtonController> getOrCreateButtonControllers(Map<String, ButtonController> map, List<ButtonOptions> list) {
        ArrayList arrayList = new ArrayList();
        for (final ButtonOptions buttonOptions : list) {
            arrayList.add((ButtonController) ObjectUtils.take((ButtonController) CollectionUtils.first((Collection) ObjectUtils.perform(map, null, new StackPresenter$$ExternalSyntheticLambda4()), new CollectionUtils.Filter() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackPresenter$$ExternalSyntheticLambda5
                @Override // com.reactnativenavigation.utils.CollectionUtils.Filter
                public final boolean filter(Object obj) {
                    return ((ButtonController) obj).getButton().equals(buttonOptions);
                }
            }), lambda$getOrCreateButtonControllersByInstanceId$0(buttonOptions)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createButtonController, reason: merged with bridge method [inline-methods] */
    public ButtonController lambda$getOrCreateButtonControllersByInstanceId$0(ButtonOptions buttonOptions) {
        ButtonController buttonController = new ButtonController(this.activity, new ButtonPresenter(this.activity, buttonOptions, this.iconResolver), buttonOptions, this.buttonCreator, this.onClickListener);
        buttonController.setWaitForRender(buttonOptions.component.waitForRender);
        return buttonController;
    }

    private void applyTopTabsOptions(TopTabsOptions topTabsOptions) {
        this.topBar.applyTopTabsColors(topTabsOptions.selectedTabColor, topTabsOptions.unselectedTabColor);
        this.topBar.applyTopTabsFontSize(topTabsOptions.fontSize);
        this.topBar.setTopTabsVisible(topTabsOptions.visible.isTrueOrUndefined());
        this.topBar.setTopTabsHeight(topTabsOptions.height.get(-2).intValue());
    }

    private void applyTopTabOptions(TopTabOptions topTabOptions) {
        if (topTabOptions.fontFamily != null) {
            this.topBar.setTopTabFontFamily(topTabOptions.tabIndex, topTabOptions.fontFamily);
        }
    }

    public List<Animator> getAdditionalPushAnimations(StackController stackController, ViewController<?> viewController, final Options options) {
        return CollectionUtils.asList(this.topBarController.getPushAnimation(options, getTopBarTranslationAnimationDelta(stackController, viewController)), (Animator) ObjectUtils.perform(this.bottomTabsController, null, new Functions.FuncR1() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackPresenter$$ExternalSyntheticLambda14
            @Override // com.reactnativenavigation.utils.Functions.FuncR1
            public final Object run(Object obj) {
                return ((BottomTabsController) obj).getPushAnimation(options);
            }
        }));
    }

    public List<Animator> getAdditionalPopAnimations(final Options options, final Options options2) {
        return CollectionUtils.asList(this.topBarController.getPopAnimation(options, options2), (Animator) ObjectUtils.perform(this.bottomTabsController, null, new Functions.FuncR1() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackPresenter$$ExternalSyntheticLambda3
            @Override // com.reactnativenavigation.utils.Functions.FuncR1
            public final Object run(Object obj) {
                return ((BottomTabsController) obj).getPopAnimation(options, options2);
            }
        }));
    }

    public List<Animator> getAdditionalSetRootAnimations(StackController stackController, ViewController<?> viewController, final Options options) {
        return CollectionUtils.asList(this.topBarController.getSetStackRootAnimation(options, getTopBarTranslationAnimationDelta(stackController, viewController)), (Animator) ObjectUtils.perform(this.bottomTabsController, null, new Functions.FuncR1() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackPresenter$$ExternalSyntheticLambda6
            @Override // com.reactnativenavigation.utils.Functions.FuncR1
            public final Object run(Object obj) {
                return ((BottomTabsController) obj).getSetStackRootAnimation(options);
            }
        }));
    }

    public void mergeChildOptions(Options options, Options options2, StackController stackController, ViewController<?> viewController) {
        TopBarOptions topBarOptionsMergeWithDefault = options.copy().topBar.mergeWithDefault(options2.topBar).mergeWithDefault(this.defaultOptions.topBar);
        mergeOrientation(options.layout.orientation);
        mergeButtons(topBarOptionsMergeWithDefault, options.topBar, viewController.getView(), stackController);
        mergeTopBarOptions(topBarOptionsMergeWithDefault, options, stackController, viewController);
        mergeTopTabsOptions(options.topTabs);
        mergeTopTabOptions(options.topTabOptions);
    }

    private void mergeOrientation(OrientationOptions orientationOptions) {
        if (orientationOptions.hasValue()) {
            applyOrientation(orientationOptions);
        }
    }

    private void mergeButtons(TopBarOptions topBarOptions, TopBarOptions topBarOptions2, View view, StackController stackController) {
        mergeRightButtons(topBarOptions, topBarOptions2.buttons, view);
        mergeLeftButton(topBarOptions, topBarOptions2.buttons, view);
        mergeLeftButtonsColor(view, topBarOptions2.leftButtonColor, topBarOptions2.leftButtonDisabledColor, topBarOptions2.leftButtonBackgroundColor);
        mergeRightButtonsColor(view, topBarOptions2.rightButtonColor, topBarOptions2.rightButtonDisabledColor, topBarOptions2.rightButtonBackgroundColor);
        mergeBackButton(topBarOptions2.buttons, stackController);
    }

    private void mergeLeftButtonsColor(View view, final ThemeColour themeColour, final ThemeColour themeColour2, final ThemeColour themeColour3) {
        Map<String, ButtonController> map;
        if ((themeColour.hasValue() || themeColour2.hasValue()) && (map = this.componentLeftButtons.get(view)) != null) {
            CollectionUtils.forEach(map.values(), new CollectionUtils.Apply() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackPresenter$$ExternalSyntheticLambda2
                @Override // com.reactnativenavigation.utils.CollectionUtils.Apply
                /* JADX INFO: renamed from: on */
                public final void mo2796on(Object obj) {
                    this.f$0.lambda$mergeLeftButtonsColor$6(themeColour, themeColour2, themeColour3, (ButtonController) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mergeLeftButtonsColor$6(ThemeColour themeColour, ThemeColour themeColour2, ThemeColour themeColour3, ButtonController buttonController) {
        if (themeColour.hasValue()) {
            buttonController.applyColor(this.topBarController.getView().getLeftButtonBar(), themeColour);
        }
        if (themeColour2.hasValue()) {
            buttonController.applyDisabledColor(this.topBarController.getView().getLeftButtonBar(), themeColour2);
        }
        if (themeColour3.hasValue()) {
            buttonController.applyBackgroundColor(this.topBarController.getView().getLeftButtonBar(), themeColour3);
        }
    }

    private void mergeRightButtonsColor(View view, final ThemeColour themeColour, final ThemeColour themeColour2, final ThemeColour themeColour3) {
        Map<String, ButtonController> map;
        if ((themeColour.hasValue() || themeColour2.hasValue()) && (map = this.componentRightButtons.get(view)) != null) {
            CollectionUtils.forEach(map.values(), new CollectionUtils.Apply() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackPresenter$$ExternalSyntheticLambda13
                @Override // com.reactnativenavigation.utils.CollectionUtils.Apply
                /* JADX INFO: renamed from: on */
                public final void mo2796on(Object obj) {
                    this.f$0.lambda$mergeRightButtonsColor$7(themeColour, themeColour2, themeColour3, (ButtonController) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mergeRightButtonsColor$7(ThemeColour themeColour, ThemeColour themeColour2, ThemeColour themeColour3, ButtonController buttonController) {
        if (themeColour.hasValue()) {
            buttonController.applyColor(this.topBarController.getView().getRightButtonBar(), themeColour);
        }
        if (themeColour2.hasValue()) {
            buttonController.applyDisabledColor(this.topBarController.getView().getRightButtonBar(), themeColour2);
        }
        if (themeColour3.hasValue()) {
            buttonController.applyBackgroundColor(this.topBarController.getView().getRightButtonBar(), themeColour3);
        }
    }

    private void mergeRightButtons(TopBarOptions topBarOptions, TopBarButtons topBarButtons, View view) {
        if (topBarButtons.right == null) {
            return;
        }
        List<ButtonController> orCreateButtonControllers = getOrCreateButtonControllers(this.componentRightButtons.get(view), mergeButtonsWithColor(topBarButtons.right, topBarOptions.rightButtonColor, topBarOptions.rightButtonDisabledColor));
        List<? extends ButtonController> listDifference = CollectionUtils.difference(this.currentRightButtons, orCreateButtonControllers, new StackPresenter$$ExternalSyntheticLambda15());
        CollectionUtils.forEach((List) listDifference, (CollectionUtils.Apply) new StackPresenter$$ExternalSyntheticLambda12());
        if (!CollectionUtils.equals(this.currentRightButtons, orCreateButtonControllers)) {
            this.componentRightButtons.put(view, CollectionUtils.keyBy(orCreateButtonControllers, new StackPresenter$$ExternalSyntheticLambda16()));
            this.topBarController.mergeRightButtons(orCreateButtonControllers, listDifference);
            this.currentRightButtons = orCreateButtonControllers;
        }
        if (topBarOptions.rightButtonColor.hasValue()) {
            this.topBar.setOverflowButtonColor(topBarOptions.rightButtonColor.get());
        }
    }

    private void mergeLeftButton(TopBarOptions topBarOptions, TopBarButtons topBarButtons, View view) {
        if (topBarButtons.left == null) {
            return;
        }
        List<ButtonController> orCreateButtonControllers = getOrCreateButtonControllers(this.componentLeftButtons.get(view), mergeButtonsWithColor(topBarButtons.left, topBarOptions.leftButtonColor, topBarOptions.leftButtonDisabledColor));
        List<? extends ButtonController> listDifference = CollectionUtils.difference(this.currentLeftButtons, orCreateButtonControllers, new StackPresenter$$ExternalSyntheticLambda15());
        CollectionUtils.forEach((List) listDifference, (CollectionUtils.Apply) new StackPresenter$$ExternalSyntheticLambda12());
        if (CollectionUtils.equals(this.currentLeftButtons, orCreateButtonControllers)) {
            return;
        }
        this.componentLeftButtons.put(view, CollectionUtils.keyBy(orCreateButtonControllers, new StackPresenter$$ExternalSyntheticLambda16()));
        this.topBarController.mergeLeftButtons(orCreateButtonControllers, listDifference);
        this.currentLeftButtons = orCreateButtonControllers;
    }

    private void mergeBackButton(TopBarButtons topBarButtons, StackController stackController) {
        if (topBarButtons.back.hasValue() && CollectionUtils.isNullOrEmpty(topBarButtons.left)) {
            if (topBarButtons.back.visible.isFalse()) {
                this.topBar.clearBackButton();
            } else if (stackController.size() > 1) {
                this.topBar.setBackButton(lambda$getOrCreateButtonControllersByInstanceId$0(topBarButtons.back));
            }
        }
    }

    private List<ButtonOptions> mergeButtonsWithColor(List<ButtonOptions> list, ThemeColour themeColour, ThemeColour themeColour2) {
        ArrayList arrayList = new ArrayList();
        for (ButtonOptions buttonOptions : list) {
            ButtonOptions buttonOptionsCopy = buttonOptions.copy();
            if (!buttonOptions.color.hasValue()) {
                buttonOptionsCopy.color = themeColour;
            }
            if (!buttonOptions.disabledColor.hasValue()) {
                buttonOptionsCopy.disabledColor = themeColour2;
            }
            arrayList.add(buttonOptionsCopy);
        }
        return arrayList;
    }

    private void mergeTopBarOptions(TopBarOptions topBarOptions, Options options, StackController stackController, ViewController<?> viewController) {
        TopBarOptions topBarOptions2 = options.topBar;
        KeyEvent.Callback view = viewController.getView();
        if (options.layout.direction.hasValue()) {
            this.topBar.setLayoutDirection(options.layout.direction);
        }
        if (topBarOptions2.height.hasValue()) {
            this.topBar.setHeight(topBarOptions2.height.get().intValue());
        }
        if (topBarOptions2.elevation.hasValue()) {
            this.topBar.setElevation(topBarOptions2.elevation.get());
        }
        if (topBarOptions2.topMargin.hasValue() && (this.topBar.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.topBar.getLayoutParams()).topMargin = UiUtils.dpToPx((Context) this.activity, topBarOptions2.topMargin.get().intValue());
        }
        mergeStatusBarDrawBehindOptions(topBarOptions, stackController.resolveChildOptions(viewController).mergeWith(options).withDefaultOptions(this.defaultOptions));
        if (topBarOptions2.title.height.hasValue()) {
            this.topBar.setTitleHeight(topBarOptions2.title.height.get().intValue());
        }
        if (topBarOptions2.title.topMargin.hasValue()) {
            this.topBar.setTitleTopMargin(topBarOptions2.title.topMargin.get().intValue());
        }
        if (topBarOptions2.animateLeftButtons.hasValue()) {
            this.topBar.animateLeftButtons(topBarOptions2.animateLeftButtons.isTrue());
        }
        if (topBarOptions2.animateRightButtons.hasValue()) {
            this.topBar.animateRightButtons(topBarOptions2.animateRightButtons.isTrue());
        }
        if (topBarOptions2.title.component.hasValue()) {
            TitleBarReactViewController titleBarReactViewControllerFindTitleComponent = findTitleComponent(topBarOptions2.title.component);
            if (titleBarReactViewControllerFindTitleComponent == null) {
                titleBarReactViewControllerFindTitleComponent = new TitleBarReactViewController(this.activity, this.titleViewCreator, topBarOptions2.title.component);
                ObjectUtils.perform(this.titleControllers.put((View) view, titleBarReactViewControllerFindTitleComponent), new StackPresenter$$ExternalSyntheticLambda0());
            }
            this.topBarController.setTitleComponent(titleBarReactViewControllerFindTitleComponent);
            this.topBarController.alignTitleComponent(topBarOptions2.title.component.alignment);
        } else if (topBarOptions2.title.text.hasValue()) {
            ObjectUtils.perform(this.titleControllers.remove(view), new StackPresenter$$ExternalSyntheticLambda0());
            this.topBar.setTitle(topBarOptions2.title.text.get());
            this.topBarController.alignTitleComponent(topBarOptions2.title.alignment);
        }
        if (topBarOptions.title.alignment != Alignment.Default) {
            this.topBarController.alignTitleComponent(topBarOptions.title.alignment);
        }
        if (topBarOptions.title.color.hasValue()) {
            this.topBar.setTitleTextColor(topBarOptions.title.color.get());
        }
        if (topBarOptions.title.fontSize.hasValue()) {
            this.topBar.setTitleFontSize(topBarOptions.title.fontSize.get().doubleValue());
        }
        if (topBarOptions.title.font.hasValue()) {
            this.topBar.setTitleTypeface(this.typefaceLoader, topBarOptions.title.font);
        }
        if (topBarOptions.subtitle.text.hasValue()) {
            this.topBar.setSubtitle(topBarOptions.subtitle.text.get());
            this.topBar.setSubtitleAlignment(topBarOptions.subtitle.alignment);
        }
        if (topBarOptions.subtitle.color.hasValue()) {
            this.topBar.setSubtitleColor(topBarOptions.subtitle.color.get());
        }
        if (topBarOptions.subtitle.fontSize.hasValue()) {
            this.topBar.setSubtitleFontSize(topBarOptions.subtitle.fontSize.get().doubleValue());
        }
        if (topBarOptions.subtitle.font.hasValue()) {
            this.topBar.setSubtitleTypeface(this.typefaceLoader, topBarOptions.subtitle.font);
        }
        if (topBarOptions2.background.color.hasValue()) {
            this.topBar.setBackgroundColor(topBarOptions2.background.color.get());
        }
        if (topBarOptions2.background.component.hasValue()) {
            if (this.backgroundControllers.containsKey(view)) {
                this.topBar.setBackgroundComponent(((TopBarBackgroundViewController) Objects.requireNonNull(this.backgroundControllers.get(view))).getView());
            } else {
                TopBarBackgroundViewController topBarBackgroundViewController = new TopBarBackgroundViewController(this.activity, this.topBarBackgroundViewCreator);
                this.backgroundControllers.put((View) view, topBarBackgroundViewController);
                topBarBackgroundViewController.setComponent(topBarOptions2.background.component);
                topBarBackgroundViewController.getView().setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                this.topBar.setBackgroundComponent(topBarBackgroundViewController.getView());
            }
        }
        if (topBarOptions2.testId.hasValue()) {
            this.topBar.setTestId(topBarOptions2.testId.get());
        }
        if (topBarOptions2.visible.isFalse()) {
            if (topBarOptions2.animate.isTrueOrUndefined()) {
                this.topBarController.hideAnimate(new AnimationOptions(), getTopBarTranslationAnimationDelta(stackController, viewController));
            } else {
                this.topBarController.hide();
            }
        }
        if (topBarOptions2.visible.isTrue()) {
            if (topBarOptions2.animate.isTrueOrUndefined()) {
                this.topBarController.showAnimate(new AnimationOptions(), getTopBarTranslationAnimationDelta(stackController, viewController));
            } else {
                this.topBarController.show();
            }
        }
        if (topBarOptions2.hideOnScroll.isTrue() && (view instanceof IReactView)) {
            this.topBar.enableCollapse(((IReactView) view).getScrollEventListener());
        }
        if (topBarOptions2.hideOnScroll.isFalse()) {
            this.topBar.disableCollapse();
        }
    }

    private TitleBarReactViewController findTitleComponent(ComponentOptions componentOptions) {
        for (TitleBarReactViewController titleBarReactViewController : this.titleControllers.values()) {
            if (ObjectUtils.equalsNotNull(titleBarReactViewController.getComponent().name.get(null), componentOptions.name.get(null)) && ObjectUtils.equalsNotNull(titleBarReactViewController.getComponent().componentId.get(null), componentOptions.componentId.get(null))) {
                return titleBarReactViewController;
            }
        }
        return null;
    }

    private void mergeTopTabsOptions(TopTabsOptions topTabsOptions) {
        if (topTabsOptions.selectedTabColor.hasValue() && topTabsOptions.unselectedTabColor.hasValue()) {
            this.topBar.applyTopTabsColors(topTabsOptions.selectedTabColor, topTabsOptions.unselectedTabColor);
        }
        if (topTabsOptions.fontSize.hasValue()) {
            this.topBar.applyTopTabsFontSize(topTabsOptions.fontSize);
        }
        if (topTabsOptions.visible.hasValue()) {
            this.topBar.setTopTabsVisible(topTabsOptions.visible.isTrue());
        }
        if (topTabsOptions.height.hasValue()) {
            this.topBar.setTopTabsHeight(topTabsOptions.height.get(-2).intValue());
        }
    }

    private void mergeTopTabOptions(TopTabOptions topTabOptions) {
        if (topTabOptions.fontFamily != null) {
            this.topBar.setTopTabFontFamily(topTabOptions.tabIndex, topTabOptions.fontFamily);
        }
    }

    public boolean shouldPopOnHardwareButtonPress(ViewController<?> viewController) {
        return viewController.resolveCurrentOptions().hardwareBack.popStackOnPress.get(true).booleanValue();
    }

    public Map<View, TitleBarReactViewController> getTitleComponents() {
        return this.titleControllers;
    }

    public Map<View, TopBarBackgroundViewController> getBackgroundComponents() {
        return this.backgroundControllers;
    }

    public List<ButtonController> getComponentButtons(View view) {
        return CollectionUtils.merge(getRightButtons(view), getLeftButtons(view), Collections.EMPTY_LIST);
    }

    public List<ButtonController> getComponentButtons(View view, List<ButtonController> list) {
        return CollectionUtils.merge(getRightButtons(view), getLeftButtons(view), list);
    }

    public void setComponentsButtonController(final View view, final ButtonController buttonController, final ButtonController buttonController2) {
        CollectionUtils.forEach(this.componentLeftButtons.get(view).keySet(), new CollectionUtils.Apply() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackPresenter$$ExternalSyntheticLambda8
            @Override // com.reactnativenavigation.utils.CollectionUtils.Apply
            /* JADX INFO: renamed from: on */
            public final void mo2796on(Object obj) {
                this.f$0.lambda$setComponentsButtonController$8(view, buttonController2, (String) obj);
            }
        });
        CollectionUtils.forEach(this.componentRightButtons.get(view).keySet(), new CollectionUtils.Apply() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackPresenter$$ExternalSyntheticLambda9
            @Override // com.reactnativenavigation.utils.CollectionUtils.Apply
            /* JADX INFO: renamed from: on */
            public final void mo2796on(Object obj) {
                this.f$0.lambda$setComponentsButtonController$9(view, buttonController, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setComponentsButtonController$8(View view, ButtonController buttonController, String str) {
        this.componentLeftButtons.get(view).put(str, buttonController);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setComponentsButtonController$9(View view, ButtonController buttonController, String str) {
        this.componentRightButtons.get(view).put(str, buttonController);
    }

    public void applyTopInsets(StackController stackController, ViewController<?> viewController) {
        if (stackController.isCurrentChild(viewController)) {
            applyStatusBarInsets(stackController, viewController);
        }
        viewController.applyTopInset();
    }

    private List<ButtonController> getRightButtons(View view) {
        if (this.componentRightButtons.containsKey(view)) {
            return new ArrayList(this.componentRightButtons.get(view).values());
        }
        return null;
    }

    private List<ButtonController> getLeftButtons(View view) {
        if (this.componentLeftButtons.containsKey(view)) {
            return new ArrayList(this.componentLeftButtons.get(view).values());
        }
        return null;
    }

    private void applyStatusBarInsets(StackController stackController, ViewController<?> viewController) {
        ((ViewGroup.MarginLayoutParams) this.topBar.getLayoutParams()).topMargin = getTopBarTopMargin(stackController, viewController);
        this.topBar.requestLayout();
    }

    private int getTopBarTranslationAnimationDelta(StackController stackController, ViewController<?> viewController) {
        if (stackController.resolveChildOptions(viewController).withDefaultOptions(this.defaultOptions).statusBar.hasTransparency()) {
            return getTopBarTopMargin(stackController, viewController);
        }
        return 0;
    }

    private int getTopBarTopMargin(StackController stackController, ViewController<?> viewController) {
        Options optionsWithDefaultOptions = stackController.resolveChildOptions(viewController).withDefaultOptions(this.defaultOptions);
        int statusBarHeight = 0;
        int iDpToPx = UiUtils.dpToPx((Context) this.activity, optionsWithDefaultOptions.topBar.topMargin.get(0).intValue());
        if (optionsWithDefaultOptions.statusBar.visible.isTrueOrUndefined() && !optionsWithDefaultOptions.statusBar.drawBehind.isTrue()) {
            statusBarHeight = SystemUiUtils.getStatusBarHeight(viewController.getActivity());
        }
        return iDpToPx + statusBarHeight;
    }

    public int getTopInset(Options options) {
        if (options.withDefaultOptions(this.defaultOptions).topBar.isHiddenOrDrawBehind()) {
            return 0;
        }
        return this.topBarController.getHeight();
    }
}
