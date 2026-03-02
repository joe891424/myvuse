package com.reactnativenavigation.views.component;

import android.app.Activity;
import com.facebook.react.ReactInstanceManager;
import com.reactnativenavigation.react.ReactComponentViewCreator;
import com.reactnativenavigation.viewcontrollers.viewcontroller.IReactView;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ReactViewCreator;

/* JADX INFO: loaded from: classes6.dex */
public class ComponentViewCreator implements ReactViewCreator {
    private ReactInstanceManager instanceManager;

    public ComponentViewCreator(ReactInstanceManager reactInstanceManager) {
        this.instanceManager = reactInstanceManager;
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ReactViewCreator
    public IReactView create(Activity activity, String str, String str2) {
        return new ComponentLayout(activity, new ReactComponentViewCreator(this.instanceManager).create(activity, str, str2));
    }
}
