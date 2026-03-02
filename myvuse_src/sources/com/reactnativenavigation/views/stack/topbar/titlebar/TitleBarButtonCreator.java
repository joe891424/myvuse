package com.reactnativenavigation.views.stack.topbar.titlebar;

import android.app.Activity;
import com.facebook.react.ReactInstanceManager;
import com.reactnativenavigation.options.ComponentOptions;

/* JADX INFO: loaded from: classes6.dex */
public class TitleBarButtonCreator {
    private ReactInstanceManager instanceManager;

    public TitleBarButtonCreator(ReactInstanceManager reactInstanceManager) {
        this.instanceManager = reactInstanceManager;
    }

    public TitleBarReactButtonView create(Activity activity, ComponentOptions componentOptions) {
        return new TitleBarReactButtonView(activity, this.instanceManager, componentOptions);
    }
}
