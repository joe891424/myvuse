package com.reactnativenavigation.viewcontrollers.bottomtabs;

import android.animation.Animator;
import android.view.ViewGroup;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.reactnativenavigation.options.BottomTabsOptions;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.options.animations.ViewAnimationOptions;
import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.options.params.Fraction;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.views.animations.BaseViewAnimator;
import com.reactnativenavigation.views.bottomtabs.BottomTabs;
import com.reactnativenavigation.views.bottomtabs.BottomTabsContainer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: BottomTabsPresenter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B'\u0012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J\u001a\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00062\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u0004J\u0012\u0010 \u001a\u00020\u00192\b\b\u0001\u0010!\u001a\u00020\u001bH\u0002J\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0006J\u0016\u0010#\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010$\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010&J\u000e\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u0006J\u0018\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006J\u0010\u0010-\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u0006J\u0010\u0010.\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u0006J\u001c\u0010/\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00062\n\u00100\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002J\u001a\u00101\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00062\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u0004J\u0010\u00102\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u001bH\u0002J\u001a\u00103\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00062\n\u00100\u001a\u0006\u0012\u0002\b\u00030\u0004J\u000e\u00104\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0006J\u000e\u00105\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, m5598d2 = {"Lcom/reactnativenavigation/viewcontrollers/bottomtabs/BottomTabsPresenter;", "", "tabs", "", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;", "defaultOptions", "Lcom/reactnativenavigation/options/Options;", "animator", "Lcom/reactnativenavigation/viewcontrollers/bottomtabs/BottomTabsAnimator;", "(Ljava/util/List;Lcom/reactnativenavigation/options/Options;Lcom/reactnativenavigation/viewcontrollers/bottomtabs/BottomTabsAnimator;)V", "getAnimator", "()Lcom/reactnativenavigation/viewcontrollers/bottomtabs/BottomTabsAnimator;", "bottomTabFinder", "Lcom/reactnativenavigation/viewcontrollers/bottomtabs/BottomTabFinder;", "bottomTabs", "Lcom/reactnativenavigation/views/bottomtabs/BottomTabs;", "bottomTabsContainer", "Lcom/reactnativenavigation/views/bottomtabs/BottomTabsContainer;", "defaultTitleState", "Lcom/aurelhubert/ahbottomnavigation/AHBottomNavigation$TitleState;", "getDefaultTitleState", "()Lcom/aurelhubert/ahbottomnavigation/AHBottomNavigation$TitleState;", "tabSelector", "Lcom/reactnativenavigation/viewcontrollers/bottomtabs/TabSelector;", "applyBottomInset", "", "bottomInset", "", "applyBottomTabsOptions", "options", "applyChildOptions", "child", "applyDrawBehind", "tabIndex", "applyOptions", "bindView", "findTabIndexByTabId", "id", "", "getBottomInset", "resolvedOptions", "getPopAnimation", "Landroid/animation/Animator;", "appearingOptions", "disappearingOptions", "getPushAnimation", "getSetStackRootAnimation", "mergeBottomTabsOptions", "view", "mergeChildOptions", "mergeDrawBehind", "mergeOptions", "onConfigurationChanged", "setDefaultOptions", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class BottomTabsPresenter {
    private final BottomTabsAnimator animator;
    private final BottomTabFinder bottomTabFinder;
    private BottomTabs bottomTabs;
    private BottomTabsContainer bottomTabsContainer;
    private Options defaultOptions;
    private TabSelector tabSelector;
    private final List<ViewController<?>> tabs;

    /* JADX WARN: Multi-variable type inference failed */
    public BottomTabsPresenter(List<? extends ViewController<?>> tabs, Options defaultOptions, BottomTabsAnimator animator) {
        Intrinsics.checkNotNullParameter(tabs, "tabs");
        Intrinsics.checkNotNullParameter(defaultOptions, "defaultOptions");
        Intrinsics.checkNotNullParameter(animator, "animator");
        this.tabs = tabs;
        this.defaultOptions = defaultOptions;
        this.animator = animator;
        this.bottomTabFinder = new BottomTabFinder(tabs);
    }

    public final BottomTabsAnimator getAnimator() {
        return this.animator;
    }

    private final AHBottomNavigation.TitleState getDefaultTitleState() {
        BottomTabs bottomTabs = this.bottomTabs;
        if (bottomTabs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomTabs");
            bottomTabs = null;
        }
        int itemsCount = bottomTabs.getItemsCount();
        for (int i = 0; i < itemsCount; i++) {
            BottomTabs bottomTabs2 = this.bottomTabs;
            if (bottomTabs2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabs");
                bottomTabs2 = null;
            }
            if (bottomTabs2.getItem(i).hasIcon()) {
                return AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE;
            }
        }
        return AHBottomNavigation.TitleState.ALWAYS_SHOW;
    }

    public final void setDefaultOptions(Options defaultOptions) {
        Intrinsics.checkNotNullParameter(defaultOptions, "defaultOptions");
        this.defaultOptions = defaultOptions;
    }

    public final void bindView(BottomTabsContainer bottomTabsContainer, TabSelector tabSelector) {
        Intrinsics.checkNotNullParameter(bottomTabsContainer, "bottomTabsContainer");
        Intrinsics.checkNotNullParameter(tabSelector, "tabSelector");
        this.bottomTabsContainer = bottomTabsContainer;
        BottomTabs bottomTabs = bottomTabsContainer.getBottomTabs();
        this.bottomTabs = bottomTabs;
        this.tabSelector = tabSelector;
        BottomTabsAnimator bottomTabsAnimator = this.animator;
        if (bottomTabs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomTabs");
            bottomTabs = null;
        }
        bottomTabsAnimator.bindView(bottomTabs);
    }

    public final void mergeOptions(Options options, ViewController<?> view) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(view, "view");
        mergeBottomTabsOptions(options, view);
    }

    public final void applyOptions(Options options) {
        Intrinsics.checkNotNullParameter(options, "options");
        Options optionsWithDefaultOptions = options.copy().withDefaultOptions(this.defaultOptions);
        Intrinsics.checkNotNullExpressionValue(optionsWithDefaultOptions, "withDefaultOptions(...)");
        applyBottomTabsOptions(optionsWithDefaultOptions);
    }

    public final void applyChildOptions(Options options, ViewController<?> child) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(child, "child");
        int iFindByControllerId = this.bottomTabFinder.findByControllerId(child.getId());
        if (iFindByControllerId >= 0) {
            Options optionsWithDefaultOptions = options.copy().withDefaultOptions(this.defaultOptions);
            Intrinsics.checkNotNullExpressionValue(optionsWithDefaultOptions, "withDefaultOptions(...)");
            applyBottomTabsOptions(optionsWithDefaultOptions);
            applyDrawBehind(iFindByControllerId);
        }
    }

    public final void mergeChildOptions(Options options, ViewController<?> child) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(child, "child");
        mergeBottomTabsOptions(options, child);
        int iFindByControllerId = this.bottomTabFinder.findByControllerId(child.getId());
        if (iFindByControllerId >= 0) {
            mergeDrawBehind(iFindByControllerId);
        }
    }

    private final void mergeBottomTabsOptions(Options options, ViewController<?> view) {
        int iFindByControllerId;
        BottomTabsOptions bottomTabsOptions = options.bottomTabsOptions;
        Intrinsics.checkNotNullExpressionValue(bottomTabsOptions, "bottomTabsOptions");
        BottomTabsContainer bottomTabsContainer = null;
        if (options.layout.direction.hasValue()) {
            BottomTabs bottomTabs = this.bottomTabs;
            if (bottomTabs == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabs");
                bottomTabs = null;
            }
            bottomTabs.setLayoutDirection(options.layout.direction);
        }
        if (bottomTabsOptions.preferLargeIcons.hasValue()) {
            BottomTabs bottomTabs2 = this.bottomTabs;
            if (bottomTabs2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabs");
                bottomTabs2 = null;
            }
            Boolean bool = bottomTabsOptions.preferLargeIcons.get();
            Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
            bottomTabs2.setPreferLargeIcons(bool.booleanValue());
        }
        if (bottomTabsOptions.titleDisplayMode.hasValue()) {
            BottomTabs bottomTabs3 = this.bottomTabs;
            if (bottomTabs3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabs");
                bottomTabs3 = null;
            }
            bottomTabs3.setTitleState(bottomTabsOptions.titleDisplayMode.toState());
        }
        if (bottomTabsOptions.backgroundColor.hasValue()) {
            BottomTabsContainer bottomTabsContainer2 = this.bottomTabsContainer;
            if (bottomTabsContainer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                bottomTabsContainer2 = null;
            }
            bottomTabsContainer2.setBackgroundColor(bottomTabsOptions.backgroundColor.get());
        }
        if (bottomTabsOptions.animateTabSelection.hasValue()) {
            BottomTabs bottomTabs4 = this.bottomTabs;
            if (bottomTabs4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabs");
                bottomTabs4 = null;
            }
            Boolean bool2 = bottomTabsOptions.animateTabSelection.get();
            Intrinsics.checkNotNullExpressionValue(bool2, "get(...)");
            bottomTabs4.setAnimateTabSelection(bool2.booleanValue());
        }
        if (bottomTabsOptions.currentTabIndex.hasValue()) {
            Integer num = bottomTabsOptions.currentTabIndex.get();
            Intrinsics.checkNotNull(num);
            if (num.intValue() >= 0) {
                TabSelector tabSelector = this.tabSelector;
                if (tabSelector == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tabSelector");
                    tabSelector = null;
                }
                tabSelector.selectTab(num.intValue());
            }
        }
        if (bottomTabsOptions.testId.hasValue()) {
            BottomTabs bottomTabs5 = this.bottomTabs;
            if (bottomTabs5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabs");
                bottomTabs5 = null;
            }
            bottomTabs5.setTag(bottomTabsOptions.testId.get());
        }
        if (bottomTabsOptions.currentTabId.hasValue() && (iFindByControllerId = this.bottomTabFinder.findByControllerId(bottomTabsOptions.currentTabId.get())) >= 0) {
            TabSelector tabSelector2 = this.tabSelector;
            if (tabSelector2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabSelector");
                tabSelector2 = null;
            }
            tabSelector2.selectTab(iFindByControllerId);
        }
        if (bottomTabsOptions.hideOnScroll.hasValue()) {
            BottomTabs bottomTabs6 = this.bottomTabs;
            if (bottomTabs6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabs");
                bottomTabs6 = null;
            }
            Boolean bool3 = bottomTabsOptions.hideOnScroll.get();
            Intrinsics.checkNotNullExpressionValue(bool3, "get(...)");
            bottomTabs6.setBehaviorTranslationEnabled(bool3.booleanValue());
        }
        if (bottomTabsOptions.borderColor.hasValue()) {
            BottomTabsContainer bottomTabsContainer3 = this.bottomTabsContainer;
            if (bottomTabsContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                bottomTabsContainer3 = null;
            }
            bottomTabsContainer3.setTopOutLineColor(bottomTabsOptions.borderColor.get());
            BottomTabsContainer bottomTabsContainer4 = this.bottomTabsContainer;
            if (bottomTabsContainer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                bottomTabsContainer4 = null;
            }
            bottomTabsContainer4.showTopLine();
        }
        if (bottomTabsOptions.borderWidth.hasValue()) {
            BottomTabsContainer bottomTabsContainer5 = this.bottomTabsContainer;
            if (bottomTabsContainer5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                bottomTabsContainer5 = null;
            }
            Double d = bottomTabsOptions.borderWidth.get();
            Intrinsics.checkNotNullExpressionValue(d, "get(...)");
            bottomTabsContainer5.setTopOutlineWidth(MathKt.roundToInt(d.doubleValue()));
            BottomTabsContainer bottomTabsContainer6 = this.bottomTabsContainer;
            if (bottomTabsContainer6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                bottomTabsContainer6 = null;
            }
            bottomTabsContainer6.showTopLine();
        }
        if (bottomTabsOptions.shadowOptions.hasValue()) {
            if (bottomTabsOptions.shadowOptions.getColor().hasValue()) {
                BottomTabsContainer bottomTabsContainer7 = this.bottomTabsContainer;
                if (bottomTabsContainer7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                    bottomTabsContainer7 = null;
                }
                bottomTabsContainer7.setShadowColor(bottomTabsOptions.shadowOptions.getColor().get());
            }
            if (bottomTabsOptions.shadowOptions.getRadius().hasValue()) {
                BottomTabsContainer bottomTabsContainer8 = this.bottomTabsContainer;
                if (bottomTabsContainer8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                    bottomTabsContainer8 = null;
                }
                bottomTabsContainer8.setShadowRadius((float) bottomTabsOptions.shadowOptions.getRadius().get().doubleValue());
            }
            if (bottomTabsOptions.shadowOptions.getOpacity().hasValue()) {
                BottomTabsContainer bottomTabsContainer9 = this.bottomTabsContainer;
                if (bottomTabsContainer9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                    bottomTabsContainer9 = null;
                }
                bottomTabsContainer9.setShadowOpacity((float) bottomTabsOptions.shadowOptions.getOpacity().get().doubleValue());
            }
            BottomTabsContainer bottomTabsContainer10 = this.bottomTabsContainer;
            if (bottomTabsContainer10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                bottomTabsContainer10 = null;
            }
            bottomTabsContainer10.showShadow();
        }
        if (view.isViewShown()) {
            if (bottomTabsOptions.visible.isTrue()) {
                if (bottomTabsOptions.animate.isTrueOrUndefined()) {
                    BaseViewAnimator.show$default(this.animator, null, 0.0f, 3, null);
                } else {
                    BottomTabs bottomTabs7 = this.bottomTabs;
                    if (bottomTabs7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bottomTabs");
                        bottomTabs7 = null;
                    }
                    bottomTabs7.restoreBottomNavigation(false);
                }
                BottomTabsContainer bottomTabsContainer11 = this.bottomTabsContainer;
                if (bottomTabsContainer11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                    bottomTabsContainer11 = null;
                }
                bottomTabsContainer11.revealTopOutline();
            }
            if (bottomTabsOptions.visible.isFalse()) {
                if (bottomTabsOptions.animate.isTrueOrUndefined()) {
                    BaseViewAnimator.hide$default(this.animator, null, 0.0f, null, 7, null);
                } else {
                    BottomTabs bottomTabs8 = this.bottomTabs;
                    if (bottomTabs8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bottomTabs");
                        bottomTabs8 = null;
                    }
                    bottomTabs8.hideBottomNavigation(false);
                }
                BottomTabsContainer bottomTabsContainer12 = this.bottomTabsContainer;
                if (bottomTabsContainer12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                } else {
                    bottomTabsContainer = bottomTabsContainer12;
                }
                bottomTabsContainer.hideTopOutLine();
            }
        }
    }

    private final void applyDrawBehind(int tabIndex) {
        this.tabs.get(tabIndex).applyBottomInset();
    }

    private final void mergeDrawBehind(int tabIndex) {
        this.tabs.get(tabIndex).applyBottomInset();
    }

    private final void applyBottomTabsOptions(Options options) {
        int iFindByControllerId;
        BottomTabsOptions bottomTabsOptions = options.bottomTabsOptions;
        Intrinsics.checkNotNullExpressionValue(bottomTabsOptions, "bottomTabsOptions");
        BottomTabs bottomTabs = this.bottomTabs;
        BottomTabs bottomTabs2 = null;
        if (bottomTabs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomTabs");
            bottomTabs = null;
        }
        bottomTabs.setLayoutDirection(options.layout.direction);
        BottomTabs bottomTabs3 = this.bottomTabs;
        if (bottomTabs3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomTabs");
            bottomTabs3 = null;
        }
        Boolean bool = options.bottomTabsOptions.preferLargeIcons.get(false);
        Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        bottomTabs3.setPreferLargeIcons(bool.booleanValue());
        BottomTabs bottomTabs4 = this.bottomTabs;
        if (bottomTabs4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomTabs");
            bottomTabs4 = null;
        }
        bottomTabs4.setTitleState(bottomTabsOptions.titleDisplayMode.get(getDefaultTitleState()));
        BottomTabsContainer bottomTabsContainer = this.bottomTabsContainer;
        if (bottomTabsContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
            bottomTabsContainer = null;
        }
        Integer num = bottomTabsOptions.backgroundColor.get(-1);
        Intrinsics.checkNotNull(num);
        bottomTabsContainer.setBackgroundColor(num.intValue());
        BottomTabs bottomTabs5 = this.bottomTabs;
        if (bottomTabs5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomTabs");
            bottomTabs5 = null;
        }
        Boolean bool2 = bottomTabsOptions.animateTabSelection.get(true);
        Intrinsics.checkNotNullExpressionValue(bool2, "get(...)");
        bottomTabs5.setAnimateTabSelection(bool2.booleanValue());
        if (bottomTabsOptions.currentTabIndex.hasValue()) {
            Integer num2 = bottomTabsOptions.currentTabIndex.get();
            Intrinsics.checkNotNull(num2);
            if (num2.intValue() >= 0) {
                bottomTabsOptions.currentTabIndex.consume();
                TabSelector tabSelector = this.tabSelector;
                if (tabSelector == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tabSelector");
                    tabSelector = null;
                }
                tabSelector.selectTab(num2.intValue());
            }
        }
        if (bottomTabsOptions.testId.hasValue()) {
            BottomTabs bottomTabs6 = this.bottomTabs;
            if (bottomTabs6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabs");
                bottomTabs6 = null;
            }
            bottomTabs6.setTag(bottomTabsOptions.testId.get());
        }
        if (bottomTabsOptions.currentTabId.hasValue() && (iFindByControllerId = this.bottomTabFinder.findByControllerId(bottomTabsOptions.currentTabId.get())) >= 0) {
            bottomTabsOptions.currentTabId.consume();
            TabSelector tabSelector2 = this.tabSelector;
            if (tabSelector2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabSelector");
                tabSelector2 = null;
            }
            tabSelector2.selectTab(iFindByControllerId);
        }
        if (bottomTabsOptions.visible.isTrueOrUndefined()) {
            if (bottomTabsOptions.animate.isTrueOrUndefined()) {
                BaseViewAnimator.show$default(this.animator, null, 0.0f, 3, null);
            } else {
                BottomTabs bottomTabs7 = this.bottomTabs;
                if (bottomTabs7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomTabs");
                    bottomTabs7 = null;
                }
                bottomTabs7.restoreBottomNavigation(false);
            }
        }
        if (bottomTabsOptions.visible.isFalse()) {
            if (bottomTabsOptions.animate.isTrueOrUndefined()) {
                BaseViewAnimator.hide$default(this.animator, null, 0.0f, null, 7, null);
            } else {
                BottomTabs bottomTabs8 = this.bottomTabs;
                if (bottomTabs8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomTabs");
                    bottomTabs8 = null;
                }
                bottomTabs8.hideBottomNavigation(false);
            }
        }
        if (bottomTabsOptions.elevation.hasValue()) {
            BottomTabsContainer bottomTabsContainer2 = this.bottomTabsContainer;
            if (bottomTabsContainer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                bottomTabsContainer2 = null;
            }
            Fraction elevation = bottomTabsOptions.elevation;
            Intrinsics.checkNotNullExpressionValue(elevation, "elevation");
            bottomTabsContainer2.setElevation(elevation);
        }
        if (bottomTabsOptions.borderColor.hasValue()) {
            BottomTabsContainer bottomTabsContainer3 = this.bottomTabsContainer;
            if (bottomTabsContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                bottomTabsContainer3 = null;
            }
            bottomTabsContainer3.setTopOutLineColor(bottomTabsOptions.borderColor.get());
            BottomTabsContainer bottomTabsContainer4 = this.bottomTabsContainer;
            if (bottomTabsContainer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                bottomTabsContainer4 = null;
            }
            bottomTabsContainer4.showTopLine();
        } else if (bottomTabsOptions.borderWidth.hasValue()) {
            BottomTabsContainer bottomTabsContainer5 = this.bottomTabsContainer;
            if (bottomTabsContainer5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                bottomTabsContainer5 = null;
            }
            Double d = bottomTabsOptions.borderWidth.get();
            Intrinsics.checkNotNullExpressionValue(d, "get(...)");
            bottomTabsContainer5.setTopOutlineWidth(MathKt.roundToInt(d.doubleValue()));
            BottomTabsContainer bottomTabsContainer6 = this.bottomTabsContainer;
            if (bottomTabsContainer6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                bottomTabsContainer6 = null;
            }
            bottomTabsContainer6.showTopLine();
        } else {
            BottomTabsContainer bottomTabsContainer7 = this.bottomTabsContainer;
            if (bottomTabsContainer7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                bottomTabsContainer7 = null;
            }
            bottomTabsContainer7.clearTopOutline();
        }
        if (bottomTabsOptions.shadowOptions.hasValue()) {
            if (bottomTabsOptions.shadowOptions.getColor().hasValue()) {
                BottomTabsContainer bottomTabsContainer8 = this.bottomTabsContainer;
                if (bottomTabsContainer8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                    bottomTabsContainer8 = null;
                }
                bottomTabsContainer8.setShadowColor(bottomTabsOptions.shadowOptions.getColor().get());
            }
            if (bottomTabsOptions.shadowOptions.getRadius().hasValue()) {
                BottomTabsContainer bottomTabsContainer9 = this.bottomTabsContainer;
                if (bottomTabsContainer9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                    bottomTabsContainer9 = null;
                }
                bottomTabsContainer9.setShadowRadius((float) bottomTabsOptions.shadowOptions.getRadius().get().doubleValue());
            }
            if (bottomTabsOptions.shadowOptions.getOpacity().hasValue()) {
                BottomTabsContainer bottomTabsContainer10 = this.bottomTabsContainer;
                if (bottomTabsContainer10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                    bottomTabsContainer10 = null;
                }
                bottomTabsContainer10.setShadowOpacity((float) bottomTabsOptions.shadowOptions.getOpacity().get().doubleValue());
            }
            BottomTabsContainer bottomTabsContainer11 = this.bottomTabsContainer;
            if (bottomTabsContainer11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                bottomTabsContainer11 = null;
            }
            bottomTabsContainer11.showShadow();
        } else {
            BottomTabsContainer bottomTabsContainer12 = this.bottomTabsContainer;
            if (bottomTabsContainer12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                bottomTabsContainer12 = null;
            }
            bottomTabsContainer12.clearShadow();
        }
        BottomTabs bottomTabs9 = this.bottomTabs;
        if (bottomTabs9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomTabs");
        } else {
            bottomTabs2 = bottomTabs9;
        }
        Boolean bool3 = bottomTabsOptions.hideOnScroll.get(false);
        Intrinsics.checkNotNullExpressionValue(bool3, "get(...)");
        bottomTabs2.setBehaviorTranslationEnabled(bool3.booleanValue());
    }

    public final void applyBottomInset(int bottomInset) {
        BottomTabsContainer bottomTabsContainer = this.bottomTabsContainer;
        BottomTabsContainer bottomTabsContainer2 = null;
        if (bottomTabsContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
            bottomTabsContainer = null;
        }
        ViewGroup.LayoutParams layoutParams = bottomTabsContainer.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, bottomInset);
        BottomTabsContainer bottomTabsContainer3 = this.bottomTabsContainer;
        if (bottomTabsContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
        } else {
            bottomTabsContainer2 = bottomTabsContainer3;
        }
        bottomTabsContainer2.requestLayout();
    }

    public final int getBottomInset(Options resolvedOptions) {
        Intrinsics.checkNotNullParameter(resolvedOptions, "resolvedOptions");
        if (resolvedOptions.withDefaultOptions(this.defaultOptions).bottomTabsOptions.isHiddenOrDrawBehind()) {
            return 0;
        }
        BottomTabs bottomTabs = this.bottomTabs;
        if (bottomTabs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomTabs");
            bottomTabs = null;
        }
        return bottomTabs.getHeight();
    }

    public final Animator getPushAnimation(Options appearingOptions) {
        Intrinsics.checkNotNullParameter(appearingOptions, "appearingOptions");
        if (appearingOptions.bottomTabsOptions.animate.isFalse()) {
            return null;
        }
        BottomTabsAnimator bottomTabsAnimator = this.animator;
        ViewAnimationOptions viewAnimationOptions = appearingOptions.animations.push.bottomTabs;
        Bool visible = appearingOptions.bottomTabsOptions.visible;
        Intrinsics.checkNotNullExpressionValue(visible, "visible");
        return BaseViewAnimator.getPushAnimation$default(bottomTabsAnimator, viewAnimationOptions, visible, 0.0f, 4, null);
    }

    public final Animator getPopAnimation(Options appearingOptions, Options disappearingOptions) {
        Intrinsics.checkNotNullParameter(appearingOptions, "appearingOptions");
        Intrinsics.checkNotNullParameter(disappearingOptions, "disappearingOptions");
        if (appearingOptions.bottomTabsOptions.animate.isFalse()) {
            return null;
        }
        BottomTabsAnimator bottomTabsAnimator = this.animator;
        ViewAnimationOptions viewAnimationOptions = disappearingOptions.animations.pop.bottomTabs;
        Bool visible = appearingOptions.bottomTabsOptions.visible;
        Intrinsics.checkNotNullExpressionValue(visible, "visible");
        return BaseViewAnimator.getPopAnimation$default(bottomTabsAnimator, viewAnimationOptions, visible, 0.0f, 4, null);
    }

    public final Animator getSetStackRootAnimation(Options appearingOptions) {
        Intrinsics.checkNotNullParameter(appearingOptions, "appearingOptions");
        if (appearingOptions.bottomTabsOptions.animate.isFalse()) {
            return null;
        }
        BottomTabsAnimator bottomTabsAnimator = this.animator;
        ViewAnimationOptions viewAnimationOptions = appearingOptions.animations.setStackRoot.bottomTabs;
        Bool visible = appearingOptions.bottomTabsOptions.visible;
        Intrinsics.checkNotNullExpressionValue(visible, "visible");
        return BaseViewAnimator.getSetStackRootAnimation$default(bottomTabsAnimator, viewAnimationOptions, visible, 0.0f, 4, null);
    }

    public final int findTabIndexByTabId(String id) {
        return Math.max(this.bottomTabFinder.findByControllerId(id), 0);
    }

    public final void onConfigurationChanged(Options options) {
        Intrinsics.checkNotNullParameter(options, "options");
        BottomTabsOptions bottomTabsOptions = options.withDefaultOptions(this.defaultOptions).bottomTabsOptions;
        Intrinsics.checkNotNullExpressionValue(bottomTabsOptions, "bottomTabsOptions");
        BottomTabs bottomTabs = this.bottomTabs;
        BottomTabsContainer bottomTabsContainer = null;
        if (bottomTabs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomTabs");
            bottomTabs = null;
        }
        Integer num = bottomTabsOptions.backgroundColor.get(-1);
        Intrinsics.checkNotNull(num);
        bottomTabs.setBackgroundColor(num.intValue());
        if (bottomTabsOptions.shadowOptions.hasValue() && bottomTabsOptions.shadowOptions.getColor().hasValue()) {
            BottomTabsContainer bottomTabsContainer2 = this.bottomTabsContainer;
            if (bottomTabsContainer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                bottomTabsContainer2 = null;
            }
            bottomTabsContainer2.setShadowColor(bottomTabsOptions.shadowOptions.getColor().get());
        }
        if (bottomTabsOptions.borderColor.hasValue()) {
            BottomTabsContainer bottomTabsContainer3 = this.bottomTabsContainer;
            if (bottomTabsContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
                bottomTabsContainer3 = null;
            }
            bottomTabsContainer3.setTopOutLineColor(bottomTabsOptions.borderColor.get());
            BottomTabsContainer bottomTabsContainer4 = this.bottomTabsContainer;
            if (bottomTabsContainer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTabsContainer");
            } else {
                bottomTabsContainer = bottomTabsContainer4;
            }
            bottomTabsContainer.showTopLine();
        }
    }
}
