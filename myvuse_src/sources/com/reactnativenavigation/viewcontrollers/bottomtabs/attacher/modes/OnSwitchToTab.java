package com.reactnativenavigation.viewcontrollers.bottomtabs.attacher.modes;

import android.view.ViewGroup;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabsPresenter;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class OnSwitchToTab extends AttachMode {
    public OnSwitchToTab(ViewGroup viewGroup, List<ViewController<?>> list, BottomTabsPresenter bottomTabsPresenter, Options options) {
        super(viewGroup, list, bottomTabsPresenter, options);
    }

    @Override // com.reactnativenavigation.viewcontrollers.bottomtabs.attacher.modes.AttachMode
    public void attach() {
        attach(this.initialTab);
    }

    @Override // com.reactnativenavigation.viewcontrollers.bottomtabs.attacher.modes.AttachMode
    public void onTabSelected(ViewController<?> viewController) {
        if (viewController == this.initialTab || !isNotAttached(viewController)) {
            return;
        }
        attach(viewController);
    }

    private boolean isNotAttached(ViewController<?> viewController) {
        return viewController.getView().getParent() == null;
    }
}
