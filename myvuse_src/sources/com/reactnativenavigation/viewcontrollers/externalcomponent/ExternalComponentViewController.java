package com.reactnativenavigation.viewcontrollers.externalcomponent;

import android.app.Activity;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.ReactInstanceManager;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.react.events.ComponentType;
import com.reactnativenavigation.react.events.EventEmitter;
import com.reactnativenavigation.utils.CoordinatorLayoutUtils;
import com.reactnativenavigation.utils.Functions;
import com.reactnativenavigation.utils.ObjectUtils;
import com.reactnativenavigation.utils.SystemUiUtils;
import com.reactnativenavigation.viewcontrollers.child.ChildController;
import com.reactnativenavigation.viewcontrollers.child.ChildControllersRegistry;
import com.reactnativenavigation.viewcontrollers.parent.ParentController;
import com.reactnativenavigation.viewcontrollers.viewcontroller.Presenter;
import com.reactnativenavigation.views.BehaviourDelegate;
import com.reactnativenavigation.views.ExternalComponentLayout;

/* JADX INFO: loaded from: classes6.dex */
public class ExternalComponentViewController extends ChildController<ExternalComponentLayout> {
    private final ExternalComponentCreator componentCreator;
    private final EventEmitter emitter;
    private final com.reactnativenavigation.options.ExternalComponent externalComponent;
    private final ExternalComponentPresenter presenter;
    private ReactInstanceManager reactInstanceManager;

    static /* synthetic */ WindowInsetsCompat lambda$enableDrawingBehindStatusBar$1(View view, WindowInsetsCompat windowInsetsCompat) {
        return windowInsetsCompat;
    }

    public ExternalComponentViewController(Activity activity, ChildControllersRegistry childControllersRegistry, String str, Presenter presenter, com.reactnativenavigation.options.ExternalComponent externalComponent, ExternalComponentCreator externalComponentCreator, ReactInstanceManager reactInstanceManager, EventEmitter eventEmitter, ExternalComponentPresenter externalComponentPresenter, Options options) {
        super(activity, childControllersRegistry, str, presenter, options);
        this.externalComponent = externalComponent;
        this.componentCreator = externalComponentCreator;
        this.reactInstanceManager = reactInstanceManager;
        this.emitter = eventEmitter;
        this.presenter = externalComponentPresenter;
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public ExternalComponentLayout createView() {
        ExternalComponentLayout externalComponentLayout = new ExternalComponentLayout(getActivity());
        enableDrawingBehindStatusBar(externalComponentLayout);
        externalComponentLayout.addView(this.componentCreator.create(getActivity(), this.reactInstanceManager, this.externalComponent.passProps).asView(), CoordinatorLayoutUtils.matchParentWithBehaviour(new BehaviourDelegate(this)));
        return externalComponentLayout;
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void sendOnNavigationButtonPressed(String str) {
        this.emitter.emitOnNavigationButtonPressed(getId(), str);
    }

    @Override // com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onViewWillAppear() {
        this.emitter.emitComponentWillAppear(getId(), this.externalComponent.name.get(), ComponentType.Component);
        super.onViewWillAppear();
        this.emitter.emitComponentDidAppear(getId(), this.externalComponent.name.get(), ComponentType.Component);
    }

    @Override // com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onViewDisappear() {
        super.onViewDisappear();
        this.emitter.emitComponentDidDisappear(getId(), this.externalComponent.name.get(), ComponentType.Component);
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void applyTopInset() {
        if (this.view != 0) {
            this.presenter.applyTopInsets(this.view, getTopInset());
        }
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public int getTopInset() {
        return (resolveCurrentOptions().statusBar.drawBehind.isTrue() ? 0 : SystemUiUtils.getStatusBarHeight(getActivity())) + ((Integer) ObjectUtils.perform(getParentController(), 0, new Functions.FuncR1() { // from class: com.reactnativenavigation.viewcontrollers.externalcomponent.ExternalComponentViewController$$ExternalSyntheticLambda0
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

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public String getCurrentComponentName() {
        return this.externalComponent.name.get();
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public FragmentActivity getActivity() {
        return (FragmentActivity) super.getActivity();
    }

    private void enableDrawingBehindStatusBar(View view) {
        view.setFitsSystemWindows(true);
        ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: com.reactnativenavigation.viewcontrollers.externalcomponent.ExternalComponentViewController$$ExternalSyntheticLambda1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                return ExternalComponentViewController.lambda$enableDrawingBehindStatusBar$1(view2, windowInsetsCompat);
            }
        });
    }
}
