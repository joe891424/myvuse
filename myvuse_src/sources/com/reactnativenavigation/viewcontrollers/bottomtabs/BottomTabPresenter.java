package com.reactnativenavigation.viewcontrollers.bottomtabs;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;
import com.reactnativenavigation.options.BottomTabOptions;
import com.reactnativenavigation.options.DotIndicatorOptions;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.options.params.ThemeColour;
import com.reactnativenavigation.options.parsers.TypefaceLoader;
import com.reactnativenavigation.utils.CollectionUtils;
import com.reactnativenavigation.utils.Functions;
import com.reactnativenavigation.utils.ImageLoader;
import com.reactnativenavigation.utils.ImageLoadingListenerAdapter;
import com.reactnativenavigation.utils.LateInit;
import com.reactnativenavigation.utils.UiUtils;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.views.bottomtabs.BottomTabs;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class BottomTabPresenter {
    private final BottomTabFinder bottomTabFinder;
    private final LateInit<BottomTabs> bottomTabs = new LateInit<>();
    private final Context context;
    private final int defaultDotIndicatorSize;
    private Options defaultOptions;
    private final Typeface defaultTypeface;
    private final ImageLoader imageLoader;
    private final List<ViewController<?>> tabs;
    private final TypefaceLoader typefaceLoader;

    public BottomTabPresenter(Context context, List<ViewController<?>> list, ImageLoader imageLoader, TypefaceLoader typefaceLoader, Options options) {
        this.tabs = list;
        this.context = context;
        this.bottomTabFinder = new BottomTabFinder(list);
        this.imageLoader = imageLoader;
        this.typefaceLoader = typefaceLoader;
        this.defaultTypeface = typefaceLoader.getDefaultTypeFace();
        this.defaultOptions = options;
        this.defaultDotIndicatorSize = UiUtils.dpToPx(context, 6);
    }

    public void setDefaultOptions(Options options) {
        this.defaultOptions = options;
    }

    public void bindView(BottomTabs bottomTabs) {
        this.bottomTabs.set(bottomTabs);
    }

    public void applyOptions() {
        this.bottomTabs.perform(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabPresenter$$ExternalSyntheticLambda1
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                this.f$0.lambda$applyOptions$0((BottomTabs) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyOptions$0(BottomTabs bottomTabs) {
        for (int i = 0; i < this.tabs.size(); i++) {
            BottomTabOptions bottomTabOptions = this.tabs.get(i).resolveCurrentOptions(this.defaultOptions).bottomTabOptions;
            bottomTabs.setIconWidth(i, bottomTabOptions.iconWidth.get(null));
            bottomTabs.setIconHeight(i, bottomTabOptions.iconHeight.get(null));
            bottomTabs.setTitleTypeface(i, bottomTabOptions.font.getTypeface(this.typefaceLoader, this.defaultTypeface));
            if (bottomTabOptions.selectedIconColor.canApplyValue()) {
                bottomTabs.setIconActiveColor(i, bottomTabOptions.selectedIconColor.get(null));
            }
            if (bottomTabOptions.iconColor.canApplyValue()) {
                bottomTabs.setIconInactiveColor(i, bottomTabOptions.iconColor.get(null));
            }
            bottomTabs.setTitleActiveColor(i, bottomTabOptions.selectedTextColor.get(null));
            bottomTabs.setTitleInactiveColor(i, bottomTabOptions.textColor.get(null));
            if (bottomTabOptions.fontSize.hasValue()) {
                bottomTabs.setTitleInactiveTextSizeInSp(i, Float.valueOf(bottomTabOptions.fontSize.get().intValue()));
            }
            if (bottomTabOptions.selectedFontSize.hasValue()) {
                bottomTabs.setTitleActiveTextSizeInSp(i, Float.valueOf(bottomTabOptions.selectedFontSize.get().intValue()));
            }
            if (bottomTabOptions.testId.hasValue()) {
                bottomTabs.setTag(i, bottomTabOptions.testId.get());
            }
            if (shouldApplyDot(bottomTabOptions)) {
                applyDotIndicator(i, bottomTabOptions.dotIndicator);
            }
            if (bottomTabOptions.badge.hasValue()) {
                applyBadge(i, bottomTabOptions);
            }
        }
    }

    public void mergeOptions(final Options options) {
        this.bottomTabs.perform(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabPresenter$$ExternalSyntheticLambda2
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                this.f$0.lambda$mergeOptions$2(options, (BottomTabs) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mergeOptions$2(final Options options, BottomTabs bottomTabs) {
        bottomTabs.disableItemsCreation();
        CollectionUtils.forEach((List) this.tabs, new CollectionUtils.Apply() { // from class: com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabPresenter$$ExternalSyntheticLambda0
            @Override // com.reactnativenavigation.utils.CollectionUtils.Apply
            /* JADX INFO: renamed from: on */
            public final void mo2796on(Object obj) {
                this.f$0.lambda$mergeOptions$1(options, (ViewController) obj);
            }
        });
        bottomTabs.enableItemsCreation();
    }

    /* JADX INFO: renamed from: mergeChildOptions, reason: merged with bridge method [inline-methods] */
    public void lambda$mergeOptions$1(final Options options, final ViewController<?> viewController) {
        this.bottomTabs.perform(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabPresenter$$ExternalSyntheticLambda4
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                this.f$0.lambda$mergeChildOptions$3(viewController, options, (BottomTabs) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mergeChildOptions$3(ViewController viewController, Options options, final BottomTabs bottomTabs) {
        final int iFindByControllerId = this.bottomTabFinder.findByControllerId(viewController.getId());
        if (iFindByControllerId >= 0) {
            BottomTabOptions bottomTabOptions = options.bottomTabOptions;
            if (bottomTabOptions.iconWidth.hasValue()) {
                bottomTabs.setIconWidth(iFindByControllerId, bottomTabOptions.iconWidth.get(null));
            }
            if (bottomTabOptions.iconHeight.hasValue()) {
                bottomTabs.setIconHeight(iFindByControllerId, bottomTabOptions.iconHeight.get(null));
            }
            if (bottomTabOptions.font.hasValue()) {
                bottomTabs.setTitleTypeface(iFindByControllerId, bottomTabOptions.font.getTypeface(this.typefaceLoader, this.defaultTypeface));
            }
            if (canMergeColor(bottomTabOptions.selectedIconColor)) {
                bottomTabs.setIconActiveColor(iFindByControllerId, Integer.valueOf(bottomTabOptions.selectedIconColor.get()));
            }
            if (canMergeColor(bottomTabOptions.iconColor)) {
                bottomTabs.setIconInactiveColor(iFindByControllerId, Integer.valueOf(bottomTabOptions.iconColor.get()));
            }
            if (bottomTabOptions.selectedTextColor.hasValue()) {
                bottomTabs.setTitleActiveColor(iFindByControllerId, Integer.valueOf(bottomTabOptions.selectedTextColor.get()));
            }
            if (bottomTabOptions.textColor.hasValue()) {
                bottomTabs.setTitleInactiveColor(iFindByControllerId, Integer.valueOf(bottomTabOptions.textColor.get()));
            }
            if (bottomTabOptions.text.hasValue()) {
                bottomTabs.setText(iFindByControllerId, bottomTabOptions.text.get());
            }
            if (bottomTabOptions.icon.hasValue()) {
                this.imageLoader.loadIcon(this.context, bottomTabOptions.icon.get(), new ImageLoadingListenerAdapter() { // from class: com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabPresenter.1
                    @Override // com.reactnativenavigation.utils.ImageLoadingListenerAdapter, com.reactnativenavigation.utils.ImageLoader.ImagesLoadingListener
                    public void onComplete(Drawable drawable) {
                        bottomTabs.setIcon(iFindByControllerId, drawable);
                    }
                });
            }
            if (bottomTabOptions.selectedIcon.hasValue()) {
                this.imageLoader.loadIcon(this.context, bottomTabOptions.selectedIcon.get(), new ImageLoadingListenerAdapter() { // from class: com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabPresenter.2
                    @Override // com.reactnativenavigation.utils.ImageLoadingListenerAdapter, com.reactnativenavigation.utils.ImageLoader.ImagesLoadingListener
                    public void onComplete(Drawable drawable) {
                        bottomTabs.setSelectedIcon(iFindByControllerId, drawable);
                    }
                });
            }
            if (bottomTabOptions.testId.hasValue()) {
                bottomTabs.setTag(iFindByControllerId, bottomTabOptions.testId.get());
            }
            if (shouldApplyDot(bottomTabOptions)) {
                mergeDotIndicator(iFindByControllerId, bottomTabOptions.dotIndicator);
            } else {
                mergeBadge(iFindByControllerId, bottomTabOptions);
            }
        }
    }

    private void applyDotIndicator(final int i, DotIndicatorOptions dotIndicatorOptions) {
        if (dotIndicatorOptions.visible.isFalse()) {
            return;
        }
        final AHNotification.Builder builderAnimate = new AHNotification.Builder().setText("").setBackgroundColor(dotIndicatorOptions.color.get(null)).setSize(dotIndicatorOptions.size.get(Integer.valueOf(this.defaultDotIndicatorSize)).intValue()).animate(dotIndicatorOptions.animate.get(false).booleanValue());
        this.bottomTabs.perform(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabPresenter$$ExternalSyntheticLambda3
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                BottomTabs bottomTabs = (BottomTabs) obj;
                bottomTabs.setNotification(builderAnimate.build(), i);
            }
        });
    }

    private void applyBadge(final int i, BottomTabOptions bottomTabOptions) {
        if (this.bottomTabs == null) {
            return;
        }
        final AHNotification.Builder builderAnimate = new AHNotification.Builder().setText(bottomTabOptions.badge.get("")).setBackgroundColor(bottomTabOptions.badgeColor.get(null)).animate(bottomTabOptions.animateBadge.get(false).booleanValue());
        this.bottomTabs.perform(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabPresenter$$ExternalSyntheticLambda7
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                BottomTabs bottomTabs = (BottomTabs) obj;
                bottomTabs.setNotification(builderAnimate.build(), i);
            }
        });
    }

    private void mergeBadge(final int i, BottomTabOptions bottomTabOptions) {
        if (this.bottomTabs == null || !bottomTabOptions.badge.hasValue()) {
            return;
        }
        final AHNotification.Builder builder = new AHNotification.Builder();
        if (bottomTabOptions.badge.hasValue()) {
            builder.setText(bottomTabOptions.badge.get());
        }
        if (bottomTabOptions.badgeColor.hasValue()) {
            builder.setBackgroundColor(Integer.valueOf(bottomTabOptions.badgeColor.get()));
        }
        if (bottomTabOptions.animateBadge.hasValue()) {
            builder.animate(bottomTabOptions.animateBadge.get().booleanValue());
        }
        this.bottomTabs.perform(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabPresenter$$ExternalSyntheticLambda5
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                BottomTabs bottomTabs = (BottomTabs) obj;
                bottomTabs.setNotification(builder.build(), i);
            }
        });
    }

    private void mergeDotIndicator(final int i, DotIndicatorOptions dotIndicatorOptions) {
        if (this.bottomTabs == null) {
            return;
        }
        AHNotification.Builder builder = new AHNotification.Builder();
        if (dotIndicatorOptions.color.hasValue()) {
            builder.setBackgroundColor(Integer.valueOf(dotIndicatorOptions.color.get()));
        }
        builder.setSize(dotIndicatorOptions.visible.isFalse() ? 0 : dotIndicatorOptions.size.get(Integer.valueOf(this.defaultDotIndicatorSize)).intValue());
        if (dotIndicatorOptions.animate.hasValue()) {
            builder.animate(dotIndicatorOptions.animate.get().booleanValue());
        }
        final AHNotification aHNotificationBuild = builder.build();
        if (aHNotificationBuild.hasValue()) {
            this.bottomTabs.perform(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabPresenter$$ExternalSyntheticLambda8
                @Override // com.reactnativenavigation.utils.Functions.Func1
                public final void run(Object obj) {
                    ((BottomTabs) obj).setNotification(aHNotificationBuild, i);
                }
            });
        }
    }

    private boolean shouldApplyDot(BottomTabOptions bottomTabOptions) {
        return bottomTabOptions.dotIndicator.visible.hasValue() && !bottomTabOptions.badge.hasValue();
    }

    private boolean canMergeColor(ThemeColour themeColour) {
        return themeColour.hasValue() && themeColour.canApplyValue();
    }

    public void onConfigurationChanged(Options options) {
        this.bottomTabs.perform(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabPresenter$$ExternalSyntheticLambda6
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                this.f$0.lambda$onConfigurationChanged$8((BottomTabs) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConfigurationChanged$8(BottomTabs bottomTabs) {
        for (int i = 0; i < this.tabs.size(); i++) {
            BottomTabOptions bottomTabOptions = this.tabs.get(i).resolveCurrentOptions(this.defaultOptions).bottomTabOptions;
            if (bottomTabOptions.selectedIconColor.canApplyValue()) {
                bottomTabs.setIconActiveColor(i, bottomTabOptions.selectedIconColor.get(null));
            }
            if (bottomTabOptions.iconColor.canApplyValue()) {
                bottomTabs.setIconInactiveColor(i, bottomTabOptions.iconColor.get(null));
            }
            bottomTabs.setTitleActiveColor(i, bottomTabOptions.selectedTextColor.get(null));
            bottomTabs.setTitleInactiveColor(i, bottomTabOptions.textColor.get(null));
            if (shouldApplyDot(bottomTabOptions)) {
                applyDotIndicator(i, bottomTabOptions.dotIndicator);
            }
            if (bottomTabOptions.badge.hasValue()) {
                applyBadge(i, bottomTabOptions);
            }
        }
    }
}
