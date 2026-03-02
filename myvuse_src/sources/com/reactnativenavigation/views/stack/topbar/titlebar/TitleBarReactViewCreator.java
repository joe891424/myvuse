package com.reactnativenavigation.views.stack.topbar.titlebar;

import android.app.Activity;
import com.facebook.react.ReactInstanceManager;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ReactViewCreator;

/* JADX INFO: loaded from: classes6.dex */
public class TitleBarReactViewCreator implements ReactViewCreator {
    protected ReactInstanceManager instanceManager;

    public TitleBarReactViewCreator(ReactInstanceManager reactInstanceManager) {
        this.instanceManager = reactInstanceManager;
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ReactViewCreator
    public TitleBarReactView create(Activity activity, String str, String str2) {
        return new TitleBarReactView(activity, this.instanceManager, str, str2);
    }
}
