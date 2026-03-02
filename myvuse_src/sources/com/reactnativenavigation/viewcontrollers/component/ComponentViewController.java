package com.reactnativenavigation.viewcontrollers.component;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.utils.Functions;
import com.reactnativenavigation.utils.ObjectUtils;
import com.reactnativenavigation.utils.SystemUiUtils;
import com.reactnativenavigation.viewcontrollers.child.ChildController;
import com.reactnativenavigation.viewcontrollers.child.ChildControllersRegistry;
import com.reactnativenavigation.viewcontrollers.parent.ParentController;
import com.reactnativenavigation.viewcontrollers.viewcontroller.Presenter;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ReactViewCreator;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ScrollEventListener;
import com.reactnativenavigation.views.component.ComponentLayout;

/* JADX INFO: loaded from: classes6.dex */
public class ComponentViewController extends ChildController<ComponentLayout> {
    private final String componentName;
    private VisibilityState lastVisibilityState;
    private final ComponentPresenter presenter;
    private final ReactViewCreator viewCreator;

    private enum VisibilityState {
        Appear,
        Disappear
    }

    public ComponentViewController(Activity activity, ChildControllersRegistry childControllersRegistry, String str, String str2, ReactViewCreator reactViewCreator, Options options, Presenter presenter, ComponentPresenter componentPresenter) {
        super(activity, childControllersRegistry, str, presenter, options);
        this.lastVisibilityState = VisibilityState.Disappear;
        this.componentName = str2;
        this.viewCreator = reactViewCreator;
        this.presenter = componentPresenter;
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void start() {
        if (isDestroyed()) {
            return;
        }
        getView().start();
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public String getCurrentComponentName() {
        return this.componentName;
    }

    @Override // com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void setDefaultOptions(Options options) {
        super.setDefaultOptions(options);
        this.presenter.setDefaultOptions(options);
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public ScrollEventListener getScrollEventListener() {
        return (ScrollEventListener) ObjectUtils.perform((ComponentLayout) this.view, null, new Functions.FuncR1() { // from class: com.reactnativenavigation.viewcontrollers.component.ComponentViewController$$ExternalSyntheticLambda1
            @Override // com.reactnativenavigation.utils.Functions.FuncR1
            public final Object run(Object obj) {
                return ((ComponentLayout) obj).getScrollEventListener();
            }
        });
    }

    @Override // com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onViewWillAppear() {
        super.onViewWillAppear();
        if (this.view != 0) {
            ((ComponentLayout) this.view).sendComponentWillStart();
        }
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onViewDidAppear() {
        if (this.view != 0) {
            ((ComponentLayout) this.view).sendComponentWillStart();
        }
        super.onViewDidAppear();
        if (this.view != 0) {
            ((ComponentLayout) this.view).requestApplyInsets();
        }
        if (this.view != 0 && this.lastVisibilityState == VisibilityState.Disappear) {
            ((ComponentLayout) this.view).sendComponentStart();
        }
        this.lastVisibilityState = VisibilityState.Appear;
    }

    @Override // com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onViewDisappear() {
        if (this.lastVisibilityState == VisibilityState.Disappear) {
            return;
        }
        this.lastVisibilityState = VisibilityState.Disappear;
        if (this.view != 0) {
            ((ComponentLayout) this.view).sendComponentStop();
        }
        super.onViewDisappear();
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void sendOnNavigationButtonPressed(String str) {
        getView().sendOnNavigationButtonPressed(str);
    }

    @Override // com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void applyOptions(Options options) {
        if (isRoot()) {
            applyTopInset();
        }
        super.applyOptions(options);
        getView().applyOptions(options);
        this.presenter.applyOptions(getView(), resolveCurrentOptions(this.presenter.defaultOptions));
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public boolean isViewShown() {
        return super.isViewShown() && this.view != 0 && ((ComponentLayout) this.view).isReady();
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public ComponentLayout createView() {
        return (ComponentLayout) ((ComponentLayout) this.viewCreator.create(getActivity(), getId(), this.componentName)).asView();
    }

    @Override // com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void mergeOptions(Options options) {
        if (options == Options.EMPTY) {
            return;
        }
        if (isViewShown()) {
            this.presenter.mergeOptions(getView(), options);
        }
        super.mergeOptions(options);
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void applyTopInset() {
        if (this.view != 0) {
            this.presenter.applyTopInsets(this.view, getTopInset());
        }
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public int getTopInset() {
        return (resolveCurrentOptions(this.presenter.defaultOptions).statusBar.isHiddenOrDrawBehind() ? 0 : SystemUiUtils.getStatusBarHeight(getActivity())) + ((Integer) ObjectUtils.perform(getParentController(), 0, new Functions.FuncR1() { // from class: com.reactnativenavigation.viewcontrollers.component.ComponentViewController$$ExternalSyntheticLambda0
            @Override // com.reactnativenavigation.utils.Functions.FuncR1
            public final Object run(Object obj) {
                return this.f$0.lambda$getTopInset$0((ParentController) obj);
            }
        })).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer lambda$getTopInset$0(ParentController parentController) {
        return Integer.valueOf(parentController.getTopInset(this));
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void applyBottomInset() {
        if (this.view != 0) {
            this.presenter.applyBottomInset(this.view, getBottomInset());
        }
    }

    @Override // com.reactnativenavigation.viewcontrollers.child.ChildController
    protected WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        ViewCompat.onApplyWindowInsets(view, new WindowInsetsCompat.Builder().setInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.ime(), Insets.m1175of(insets.left, (windowInsetsCompat.getInsets(WindowInsetsCompat.Type.statusBars()).top + windowInsetsCompat.getInsets(WindowInsetsCompat.Type.navigationBars()).top) - insets.top, insets.right, Math.max(((windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime()).bottom + windowInsetsCompat.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom) - insets.bottom) - getBottomInset(), 0))).build());
        return windowInsetsCompat;
    }

    @Override // com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void destroy() {
        if (this.options != null && this.options.modal.blurOnUnmount.isTrue()) {
            blurActivityFocus();
        }
        super.destroy();
    }

    private void blurActivityFocus() {
        Activity activity = getActivity();
        View currentFocus = activity != null ? activity.getCurrentFocus() : null;
        if (currentFocus != null) {
            currentFocus.clearFocus();
        }
    }

    @Override // com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.presenter.onConfigurationChanged((ComponentLayout) this.view, this.options);
    }
}
