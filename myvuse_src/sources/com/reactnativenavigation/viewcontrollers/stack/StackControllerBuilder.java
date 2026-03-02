package com.reactnativenavigation.viewcontrollers.stack;

import android.app.Activity;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.react.events.EventEmitter;
import com.reactnativenavigation.viewcontrollers.child.ChildControllersRegistry;
import com.reactnativenavigation.viewcontrollers.stack.topbar.TopBarController;
import com.reactnativenavigation.viewcontrollers.stack.topbar.button.BackButtonHelper;
import com.reactnativenavigation.viewcontrollers.viewcontroller.Presenter;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class StackControllerBuilder {
    private Activity activity;
    private StackAnimator animator;
    private ChildControllersRegistry childRegistry;
    private EventEmitter eventEmitter;

    /* JADX INFO: renamed from: id */
    private String f4206id;
    private Presenter presenter;
    private StackPresenter stackPresenter;
    private TopBarController topBarController;
    private Options initialOptions = new Options();
    private BackButtonHelper backButtonHelper = new BackButtonHelper();
    private List<ViewController<?>> children = new ArrayList();
    private FabPresenter fabPresenter = new FabPresenter();

    public StackControllerBuilder(Activity activity, EventEmitter eventEmitter) {
        this.activity = activity;
        this.eventEmitter = eventEmitter;
        this.presenter = new Presenter(activity, new Options());
        this.animator = new StackAnimator(activity);
    }

    public StackControllerBuilder setEventEmitter(EventEmitter eventEmitter) {
        this.eventEmitter = eventEmitter;
        return this;
    }

    public StackControllerBuilder setChildren(ViewController<?>... viewControllerArr) {
        return setChildren(Arrays.asList(viewControllerArr));
    }

    public StackControllerBuilder setChildren(List<ViewController<?>> list) {
        this.children = list;
        return this;
    }

    public StackControllerBuilder setStackPresenter(StackPresenter stackPresenter) {
        this.stackPresenter = stackPresenter;
        return this;
    }

    public StackControllerBuilder setPresenter(Presenter presenter) {
        this.presenter = presenter;
        return this;
    }

    public StackControllerBuilder setChildRegistry(ChildControllersRegistry childControllersRegistry) {
        this.childRegistry = childControllersRegistry;
        return this;
    }

    public StackControllerBuilder setTopBarController(TopBarController topBarController) {
        this.topBarController = topBarController;
        return this;
    }

    public StackControllerBuilder setId(String str) {
        this.f4206id = str;
        return this;
    }

    public StackControllerBuilder setInitialOptions(Options options) {
        this.initialOptions = options;
        return this;
    }

    public StackControllerBuilder setAnimator(StackAnimator stackAnimator) {
        this.animator = stackAnimator;
        return this;
    }

    StackControllerBuilder setBackButtonHelper(BackButtonHelper backButtonHelper) {
        this.backButtonHelper = backButtonHelper;
        return this;
    }

    public StackControllerBuilder setFabPresenter(FabPresenter fabPresenter) {
        this.fabPresenter = fabPresenter;
        return this;
    }

    public StackController build() {
        return new StackController(this.activity, this.children, this.childRegistry, this.eventEmitter, this.topBarController, this.animator, this.f4206id, this.initialOptions, this.backButtonHelper, this.stackPresenter, this.presenter, this.fabPresenter);
    }
}
