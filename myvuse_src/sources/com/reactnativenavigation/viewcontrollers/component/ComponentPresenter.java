package com.reactnativenavigation.viewcontrollers.component;

import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.views.component.ComponentLayout;

/* JADX INFO: loaded from: classes6.dex */
public class ComponentPresenter extends ComponentPresenterBase {
    public Options defaultOptions;

    public ComponentPresenter(Options options) {
        this.defaultOptions = options;
    }

    public void setDefaultOptions(Options options) {
        this.defaultOptions = options;
    }

    public void applyOptions(ComponentLayout componentLayout, Options options) {
        setBackgroundColor(componentLayout, options);
    }

    public void mergeOptions(ComponentLayout componentLayout, Options options) {
        if (options.overlayOptions.interceptTouchOutside.hasValue()) {
            componentLayout.setInterceptTouchOutside(options.overlayOptions.interceptTouchOutside);
        }
        setBackgroundColor(componentLayout, options);
    }

    private void setBackgroundColor(ComponentLayout componentLayout, Options options) {
        if (options.layout.componentBackgroundColor.hasValue()) {
            componentLayout.setBackgroundColor(options.layout.componentBackgroundColor.get());
        }
    }

    public void onConfigurationChanged(ComponentLayout componentLayout, Options options) {
        if (componentLayout == null) {
            return;
        }
        setBackgroundColor(componentLayout, options.withDefaultOptions(this.defaultOptions));
    }
}
