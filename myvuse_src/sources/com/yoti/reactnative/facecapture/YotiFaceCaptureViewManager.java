package com.yoti.reactnative.facecapture;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class YotiFaceCaptureViewManager extends SimpleViewManager<YotiFaceCaptureView> {
    public static final String REACT_CLASS = "YotiFaceCaptureView";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public YotiFaceCaptureView createViewInstance(ThemedReactContext themedReactContext) {
        return new YotiFaceCaptureView(themedReactContext);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder().put("onCameraStateChange", MapBuilder.m1349of("phasedRegistrationNames", MapBuilder.m1349of("bubbled", "onCameraStateChange"))).put("onFaceCaptureResult", MapBuilder.m1349of("phasedRegistrationNames", MapBuilder.m1349of("bubbled", "onFaceCaptureResult"))).build();
    }

    @ReactProp(name = "faceCenter")
    public void setFaceCenter(YotiFaceCaptureView yotiFaceCaptureView, ReadableArray readableArray) throws Exception {
        yotiFaceCaptureView.setFaceCenter(readableArray);
    }

    @ReactProp(name = "imageQuality")
    public void setImageQuality(YotiFaceCaptureView yotiFaceCaptureView, String str) throws Exception {
        yotiFaceCaptureView.setImageQuality(str);
    }

    @ReactProp(defaultBoolean = true, name = "requireValidAngle")
    public void setRequireValidAngle(YotiFaceCaptureView yotiFaceCaptureView, boolean z) {
        yotiFaceCaptureView.setRequireValidAngle(Boolean.valueOf(z));
    }

    @ReactProp(defaultBoolean = true, name = "requireEyesOpen")
    public void setRequireEyesOpen(YotiFaceCaptureView yotiFaceCaptureView, boolean z) {
        yotiFaceCaptureView.setRequireEyesOpen(Boolean.valueOf(z));
    }

    @ReactProp(defaultInt = 3, name = "requiredStableFrames")
    public void setRequiredStableFrames(YotiFaceCaptureView yotiFaceCaptureView, int i) {
        yotiFaceCaptureView.setRequiredStableFrames(i);
    }

    @ReactProp(defaultBoolean = true, name = "requireBrightEnvironment")
    public void setRequireBrightEnvironment(YotiFaceCaptureView yotiFaceCaptureView, boolean z) {
        yotiFaceCaptureView.setRequireBrightEnvironment(Boolean.valueOf(z));
    }
}
