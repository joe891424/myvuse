package com.reactnativenavigation.viewcontrollers.bottomtabs.attacher;

import android.view.ViewGroup;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabsPresenter;
import com.reactnativenavigation.viewcontrollers.bottomtabs.attacher.modes.AttachMode;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class BottomTabsAttacher {
    public AttachMode attachStrategy;
    private final Options defaultOptions;
    private final BottomTabsPresenter presenter;
    private final List<ViewController<?>> tabs;

    public BottomTabsAttacher(List<ViewController<?>> list, BottomTabsPresenter bottomTabsPresenter, Options options) {
        this.tabs = list;
        this.presenter = bottomTabsPresenter;
        this.defaultOptions = options;
    }

    public void init(ViewGroup viewGroup, Options options) {
        this.attachStrategy = AttachMode.get(viewGroup, this.tabs, this.presenter, options.withDefaultOptions(this.defaultOptions));
    }

    public void attach() {
        this.attachStrategy.attach();
    }

    public void destroy() {
        this.attachStrategy.destroy();
    }

    public void onTabSelected(ViewController<?> viewController) {
        this.attachStrategy.onTabSelected(viewController);
    }
}
