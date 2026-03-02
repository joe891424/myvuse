package com.reactnativenavigation.viewcontrollers.stack.topbar.title;

import android.app.Activity;
import com.reactnativenavigation.options.ComponentOptions;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.react.events.ComponentType;
import com.reactnativenavigation.utils.CompatUtils;
import com.reactnativenavigation.utils.Functions;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.viewcontrollers.viewcontroller.YellowBoxDelegate;
import com.reactnativenavigation.viewcontrollers.viewcontroller.overlay.ViewControllerOverlay;
import com.reactnativenavigation.views.stack.topbar.titlebar.TitleBarReactView;
import com.reactnativenavigation.views.stack.topbar.titlebar.TitleBarReactViewCreator;

/* JADX INFO: loaded from: classes6.dex */
public class TitleBarReactViewController extends ViewController<TitleBarReactView> {
    private final ComponentOptions component;
    private final TitleBarReactViewCreator reactViewCreator;

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public String getCurrentComponentName() {
        return null;
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void sendOnNavigationButtonPressed(String str) {
    }

    public ComponentOptions getComponent() {
        return this.component;
    }

    public TitleBarReactViewController(Activity activity, TitleBarReactViewCreator titleBarReactViewCreator, ComponentOptions componentOptions) {
        super(activity, CompatUtils.generateViewId() + "", new YellowBoxDelegate(activity), new Options(), new ViewControllerOverlay(activity));
        this.reactViewCreator = titleBarReactViewCreator;
        this.component = componentOptions;
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onViewWillAppear() {
        if (!isDestroyed()) {
            getView().sendComponentWillStart(ComponentType.Title);
        }
        super.onViewWillAppear();
        if (isDestroyed()) {
            return;
        }
        runOnPreDraw(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.stack.topbar.title.TitleBarReactViewController$$ExternalSyntheticLambda0
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                TitleBarReactView titleBarReactView = (TitleBarReactView) obj;
                titleBarReactView.setLayoutParams(titleBarReactView.getLayoutParams());
            }
        });
        getView().sendComponentStart(ComponentType.Title);
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onViewDisappear() {
        getView().sendComponentStop(ComponentType.Title);
        super.onViewDisappear();
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public TitleBarReactView createView() {
        return this.reactViewCreator.create(getActivity(), this.component.componentId.get(), this.component.name.get());
    }
}
