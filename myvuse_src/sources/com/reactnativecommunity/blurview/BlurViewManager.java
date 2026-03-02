package com.reactnativecommunity.blurview;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import eightbitlab.com.blurview.BlurView;

/* JADX INFO: loaded from: classes6.dex */
class BlurViewManager extends ViewGroupManager<BlurView> {
    ReactApplicationContext mCallerContext;

    @ReactProp(defaultInt = 10, name = "downsampleFactor")
    public void setDownsampleFactor(BlurView blurView, int i) {
    }

    public BlurViewManager(ReactApplicationContext reactApplicationContext) {
        this.mCallerContext = reactApplicationContext;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public BlurView createViewInstance(ThemedReactContext themedReactContext) {
        return BlurViewManagerImpl.createViewInstance(themedReactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return BlurViewManagerImpl.REACT_CLASS;
    }

    @ReactProp(defaultInt = 10, name = "blurRadius")
    public void setRadius(BlurView blurView, int i) {
        BlurViewManagerImpl.setRadius(blurView, i);
    }

    @ReactProp(customType = "Color", name = "overlayColor")
    public void setColor(BlurView blurView, int i) {
        BlurViewManagerImpl.setColor(blurView, i);
    }

    @ReactProp(defaultBoolean = true, name = "autoUpdate")
    public void setAutoUpdate(BlurView blurView, boolean z) {
        BlurViewManagerImpl.setAutoUpdate(blurView, z);
    }

    @ReactProp(defaultBoolean = true, name = ViewProps.ENABLED)
    public void setBlurEnabled(BlurView blurView, boolean z) {
        BlurViewManagerImpl.setBlurEnabled(blurView, z);
    }
}
