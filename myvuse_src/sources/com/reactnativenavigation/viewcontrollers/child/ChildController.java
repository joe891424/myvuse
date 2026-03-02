package com.reactnativenavigation.viewcontrollers.child;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.utils.Functions;
import com.reactnativenavigation.viewcontrollers.navigator.Navigator;
import com.reactnativenavigation.viewcontrollers.parent.ParentController;
import com.reactnativenavigation.viewcontrollers.viewcontroller.NoOpYellowBoxDelegate;
import com.reactnativenavigation.viewcontrollers.viewcontroller.Presenter;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.viewcontrollers.viewcontroller.overlay.ViewControllerOverlay;
import com.reactnativenavigation.views.component.Component;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ChildController<T extends ViewGroup> extends ViewController<T> {
    private final ChildControllersRegistry childRegistry;
    private final Presenter presenter;

    protected WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return windowInsetsCompat;
    }

    public ChildControllersRegistry getChildRegistry() {
        return this.childRegistry;
    }

    public ChildController(Activity activity, ChildControllersRegistry childControllersRegistry, String str, Presenter presenter, Options options) {
        super(activity, str, new NoOpYellowBoxDelegate(activity), options, new ViewControllerOverlay(activity));
        this.presenter = presenter;
        this.childRegistry = childControllersRegistry;
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public T getView() {
        if (this.view == null) {
            super.getView();
            this.view.setFitsSystemWindows(true);
            ViewCompat.setOnApplyWindowInsetsListener(this.view, new OnApplyWindowInsetsListener() { // from class: com.reactnativenavigation.viewcontrollers.child.ChildController$$ExternalSyntheticLambda1
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    return this.f$0.onApplyWindowInsets(view, windowInsetsCompat);
                }
            });
        }
        return this.view;
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void setDefaultOptions(Options options) {
        this.presenter.setDefaultOptions(options);
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onViewWillAppear() {
        super.onViewWillAppear();
        this.childRegistry.onViewAppeared(this);
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onViewDisappear() {
        super.onViewDisappear();
        this.childRegistry.onViewDisappear(this);
    }

    public void onViewBroughtToFront() {
        this.presenter.onViewBroughtToFront(this, resolveCurrentOptions());
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void applyOptions(Options options) {
        super.applyOptions(options);
        this.presenter.applyOptions(this, resolveCurrentOptions());
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void mergeOptions(final Options options) {
        if (options == Options.EMPTY) {
            return;
        }
        if (isViewShown()) {
            this.presenter.mergeOptions(this, options);
        }
        super.mergeOptions(options);
        performOnParentController(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.child.ChildController$$ExternalSyntheticLambda0
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                this.f$0.lambda$mergeOptions$0(options, (ParentController) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mergeOptions$0(Options options, ParentController parentController) {
        parentController.mergeChildOptions(options, this);
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void destroy() {
        if (!isDestroyed() && (getView() instanceof Component)) {
            performOnParentController(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.child.ChildController$$ExternalSyntheticLambda2
                @Override // com.reactnativenavigation.utils.Functions.Func1
                public final void run(Object obj) {
                    this.f$0.lambda$destroy$1((ParentController) obj);
                }
            });
        }
        super.destroy();
        this.childRegistry.onChildDestroyed(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$destroy$1(ParentController parentController) {
        parentController.onChildDestroyed(this);
    }

    public boolean isRoot() {
        return (getParentController() != null || (this instanceof Navigator) || getView().getParent() == null) ? false : true;
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.presenter.onConfigurationChanged(this, this.options);
    }
}
