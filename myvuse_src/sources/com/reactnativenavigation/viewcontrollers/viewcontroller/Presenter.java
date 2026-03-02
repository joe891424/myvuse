package com.reactnativenavigation.viewcontrollers.viewcontroller;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.reactnativenavigation.options.NavigationBarOptions;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.options.OrientationOptions;
import com.reactnativenavigation.options.StatusBarOptions;
import com.reactnativenavigation.options.layout.LayoutInsets;
import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.utils.SystemUiUtils;
import com.reactnativenavigation.viewcontrollers.navigator.Navigator;
import com.reactnativenavigation.viewcontrollers.parent.ParentController;

/* JADX INFO: loaded from: classes6.dex */
public class Presenter {
    private final Activity activity;
    private Options defaultOptions;

    public Presenter(Activity activity, Options options) {
        this.activity = activity;
        this.defaultOptions = options;
    }

    public void setDefaultOptions(Options options) {
        this.defaultOptions = options;
    }

    public Options getDefaultOptions() {
        return this.defaultOptions;
    }

    public void mergeOptions(ViewController<?> viewController, Options options) {
        Options optionsWithDefaultOptions = viewController.resolveCurrentOptions().copy().mergeWith(options).withDefaultOptions(this.defaultOptions);
        mergeStatusBarOptions(viewController.getView(), optionsWithDefaultOptions.statusBar);
        mergeNavigationBarOptions(optionsWithDefaultOptions.navigationBar);
        applyLayoutInsetsOnMostTopParent(viewController, optionsWithDefaultOptions.layout.getInsets());
    }

    private void applyLayoutInsetsOnMostTopParent(ViewController<?> viewController, LayoutInsets layoutInsets) {
        applyLayoutInsets(viewController.getTopMostParent().getView(), layoutInsets);
    }

    public void applyOptions(ViewController viewController, Options options) {
        Options optionsWithDefaultOptions = options.copy().withDefaultOptions(this.defaultOptions);
        applyOrientation(optionsWithDefaultOptions.layout.orientation);
        applyViewOptions(viewController, optionsWithDefaultOptions);
        applyStatusBarOptions(viewController, optionsWithDefaultOptions);
        applyNavigationBarOptions(optionsWithDefaultOptions.navigationBar);
    }

    public void onViewBroughtToFront(ViewController<?> viewController, Options options) {
        applyStatusBarOptions(viewController, options.copy().withDefaultOptions(this.defaultOptions));
    }

    private void applyOrientation(OrientationOptions orientationOptions) {
        this.activity.setRequestedOrientation(orientationOptions.getValue());
    }

    private void applyViewOptions(ViewController viewController, Options options) {
        applyBackgroundColor(viewController, options);
        applyTopMargin(viewController.getView(), options);
        applyLayoutInsetsOnMostTopParent(viewController, options.layout.getInsets());
    }

    private void applyLayoutInsets(ViewGroup viewGroup, LayoutInsets layoutInsets) {
        if (viewGroup == null || !layoutInsets.hasValue()) {
            return;
        }
        viewGroup.setPadding(layoutInsets.getLeft() == null ? viewGroup.getPaddingLeft() : layoutInsets.getLeft().intValue(), layoutInsets.getTop() == null ? viewGroup.getPaddingTop() : layoutInsets.getTop().intValue(), layoutInsets.getRight() == null ? viewGroup.getPaddingRight() : layoutInsets.getRight().intValue(), layoutInsets.getBottom() == null ? viewGroup.getPaddingBottom() : layoutInsets.getBottom().intValue());
    }

    private void applyTopMargin(View view, Options options) {
        if ((view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && options.layout.topMargin.hasValue()) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin = options.layout.topMargin.get(0).intValue();
        }
    }

    private void applyBackgroundColor(ViewController viewController, Options options) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (!options.layout.backgroundColor.hasValue() || (viewController instanceof Navigator)) {
            return;
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new ColorDrawable(options.layout.backgroundColor.get())});
        layerDrawable.setLayerInset(0, 0, ((viewController instanceof ParentController) || (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewController.getView().getLayoutParams()) == null || marginLayoutParams.topMargin == 0) ? viewController.resolveCurrentOptions().statusBar.drawBehind.isTrue() ? 0 : SystemUiUtils.getStatusBarHeight(viewController.getActivity()) : 0, 0, 0);
        viewController.getView().setBackground(layerDrawable);
    }

    private void applyStatusBarOptions(ViewController viewController, Options options) {
        StatusBarOptions statusBarOptions = options.copy().withDefaultOptions(this.defaultOptions).statusBar;
        setStatusBarBackgroundColor(statusBarOptions);
        setTextColorScheme(statusBarOptions);
        setTranslucent(statusBarOptions);
        setStatusBarVisible(viewController, statusBarOptions.visible);
    }

    private void setTranslucent(StatusBarOptions statusBarOptions) {
        Window window = this.activity.getWindow();
        if (statusBarOptions.translucent.isTrue()) {
            SystemUiUtils.setStatusBarTranslucent(window);
        } else if (SystemUiUtils.isTranslucent(window)) {
            SystemUiUtils.clearStatusBarTranslucency(window);
        }
    }

    private void setStatusBarVisible(ViewController viewController, Bool bool) {
        View decorView = viewController.view != 0 ? viewController.view : this.activity.getWindow().getDecorView();
        if (bool.isFalse()) {
            SystemUiUtils.hideStatusBar(this.activity.getWindow(), decorView);
        } else {
            SystemUiUtils.showStatusBar(this.activity.getWindow(), decorView);
        }
    }

    private void setStatusBarBackgroundColor(StatusBarOptions statusBarOptions) {
        if (statusBarOptions.backgroundColor.canApplyValue()) {
            SystemUiUtils.setStatusBarColor(this.activity.getWindow(), getStatusBarBackgroundColor(statusBarOptions), statusBarOptions.translucent.isTrue());
        }
    }

    private boolean isDarkTextColorScheme(StatusBarOptions statusBarOptions) {
        if (statusBarOptions.textColorScheme == StatusBarOptions.TextColorScheme.Dark) {
            return true;
        }
        if (statusBarOptions.textColorScheme == StatusBarOptions.TextColorScheme.Light) {
            return false;
        }
        return isColorLight(getStatusBarBackgroundColor(statusBarOptions));
    }

    private int getStatusBarBackgroundColor(StatusBarOptions statusBarOptions) {
        return statusBarOptions.backgroundColor.get(Integer.valueOf(statusBarOptions.visible.isTrueOrUndefined() ? -16777216 : 0)).intValue();
    }

    private void setTextColorScheme(final StatusBarOptions statusBarOptions) {
        final View decorView = this.activity.getWindow().getDecorView();
        decorView.post(new Runnable() { // from class: com.reactnativenavigation.viewcontrollers.viewcontroller.Presenter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setTextColorScheme$0(decorView, statusBarOptions);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setTextColorScheme$0(View view, StatusBarOptions statusBarOptions) {
        SystemUiUtils.setStatusBarColorScheme(this.activity.getWindow(), view, isDarkTextColorScheme(statusBarOptions));
    }

    private void mergeStatusBarOptions(View view, StatusBarOptions statusBarOptions) {
        mergeStatusBarBackgroundColor(statusBarOptions);
        mergeTextColorScheme(statusBarOptions);
        mergeTranslucent(statusBarOptions);
        mergeStatusBarVisible(view, statusBarOptions.visible);
    }

    private void mergeStatusBarBackgroundColor(StatusBarOptions statusBarOptions) {
        if (statusBarOptions.backgroundColor.hasValue()) {
            SystemUiUtils.setStatusBarColor(this.activity.getWindow(), getStatusBarBackgroundColor(statusBarOptions), statusBarOptions.translucent.isTrue());
        }
    }

    private void mergeTextColorScheme(StatusBarOptions statusBarOptions) {
        if (statusBarOptions.textColorScheme.hasValue()) {
            setTextColorScheme(statusBarOptions);
        }
    }

    private void mergeTranslucent(StatusBarOptions statusBarOptions) {
        Window window = this.activity.getWindow();
        if (statusBarOptions.translucent.isTrue()) {
            SystemUiUtils.setStatusBarTranslucent(window);
        } else if (statusBarOptions.translucent.isFalse() && SystemUiUtils.isTranslucent(window)) {
            SystemUiUtils.clearStatusBarTranslucency(window);
        }
    }

    private void mergeStatusBarVisible(View view, Bool bool) {
        if (bool.hasValue()) {
            if (bool.isTrue()) {
                SystemUiUtils.showStatusBar(this.activity.getWindow(), view);
            } else {
                SystemUiUtils.hideStatusBar(this.activity.getWindow(), view);
            }
        }
    }

    private void applyNavigationBarOptions(NavigationBarOptions navigationBarOptions) {
        applyNavigationBarVisibility(navigationBarOptions);
        setNavigationBarBackgroundColor(navigationBarOptions);
    }

    private void mergeNavigationBarOptions(NavigationBarOptions navigationBarOptions) {
        mergeNavigationBarVisibility(navigationBarOptions);
        setNavigationBarBackgroundColor(navigationBarOptions);
    }

    private void mergeNavigationBarVisibility(NavigationBarOptions navigationBarOptions) {
        if (navigationBarOptions.isVisible.hasValue()) {
            applyNavigationBarOptions(navigationBarOptions);
        }
    }

    private void applyNavigationBarVisibility(NavigationBarOptions navigationBarOptions) {
        View decorView = this.activity.getWindow().getDecorView();
        if (navigationBarOptions.isVisible.isTrueOrUndefined()) {
            SystemUiUtils.showNavigationBar(this.activity.getWindow(), decorView);
        } else {
            SystemUiUtils.hideNavigationBar(this.activity.getWindow(), decorView);
        }
    }

    private void setNavigationBarBackgroundColor(NavigationBarOptions navigationBarOptions) {
        int navigationBarDefaultColor = SystemUiUtils.INSTANCE.getNavigationBarDefaultColor();
        if (navigationBarDefaultColor == -1) {
            navigationBarDefaultColor = -16777216;
        }
        if (navigationBarOptions.backgroundColor.canApplyValue()) {
            int iIntValue = navigationBarOptions.backgroundColor.get(Integer.valueOf(navigationBarDefaultColor)).intValue();
            SystemUiUtils.setNavigationBarBackgroundColor(this.activity.getWindow(), iIntValue, isColorLight(iIntValue));
        } else {
            SystemUiUtils.setNavigationBarBackgroundColor(this.activity.getWindow(), navigationBarDefaultColor, isColorLight(navigationBarDefaultColor));
        }
    }

    private boolean isColorLight(int i) {
        return 1.0d - ((((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d)) / 255.0d) < 0.5d;
    }

    public void onConfigurationChanged(ViewController viewController, Options options) {
        Options optionsWithDefaultOptions = options.withDefaultOptions(this.defaultOptions);
        setNavigationBarBackgroundColor(optionsWithDefaultOptions.navigationBar);
        setStatusBarBackgroundColor(optionsWithDefaultOptions.statusBar);
        setTextColorScheme(optionsWithDefaultOptions.statusBar);
        applyBackgroundColor(viewController, optionsWithDefaultOptions);
    }
}
