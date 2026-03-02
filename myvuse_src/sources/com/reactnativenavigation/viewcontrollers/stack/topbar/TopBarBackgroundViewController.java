package com.reactnativenavigation.viewcontrollers.stack.topbar;

import android.app.Activity;
import com.reactnativenavigation.options.ComponentOptions;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.react.events.ComponentType;
import com.reactnativenavigation.utils.CompatUtils;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.viewcontrollers.viewcontroller.YellowBoxDelegate;
import com.reactnativenavigation.viewcontrollers.viewcontroller.overlay.ViewControllerOverlay;
import com.reactnativenavigation.views.stack.topbar.TopBarBackgroundView;
import com.reactnativenavigation.views.stack.topbar.TopBarBackgroundViewCreator;

/* JADX INFO: loaded from: classes6.dex */
public class TopBarBackgroundViewController extends ViewController<TopBarBackgroundView> {
    private ComponentOptions component;
    private TopBarBackgroundViewCreator viewCreator;

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void sendOnNavigationButtonPressed(String str) {
    }

    public TopBarBackgroundViewController(Activity activity, TopBarBackgroundViewCreator topBarBackgroundViewCreator) {
        super(activity, CompatUtils.generateViewId() + "", new YellowBoxDelegate(activity), new Options(), new ViewControllerOverlay(activity));
        this.viewCreator = topBarBackgroundViewCreator;
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public TopBarBackgroundView createView() {
        return this.viewCreator.create(getActivity(), this.component.componentId.get(), this.component.name.get());
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onViewWillAppear() {
        getView().sendComponentWillStart(ComponentType.Background);
        super.onViewWillAppear();
        getView().sendComponentStart(ComponentType.Background);
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onViewDisappear() {
        getView().sendComponentStop(ComponentType.Background);
        super.onViewDisappear();
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public String getCurrentComponentName() {
        return this.component.name.get();
    }

    public void setComponent(ComponentOptions componentOptions) {
        this.component = componentOptions;
    }

    public ComponentOptions getComponent() {
        return this.component;
    }
}
