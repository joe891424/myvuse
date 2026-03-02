package com.yoti.reactnative.facecapture;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import com.yoti.mobile.android.capture.face.p048ui.models.face.ImageQuality;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class YotiFaceCaptureModule extends ReactContextBaseJavaModule {
    YotiFaceCaptureModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "YotiFaceCaptureModule";
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put("IMAGE_QUALITY_LOW", ImageQuality.LOW.toString());
        map.put("IMAGE_QUALITY_MEDIUM", ImageQuality.MEDIUM.toString());
        map.put("IMAGE_QUALITY_HIGH", ImageQuality.HIGH.toString());
        return map;
    }

    @ReactMethod
    public void startCamera(final int i) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() { // from class: com.yoti.reactnative.facecapture.YotiFaceCaptureModule.1
            @Override // com.facebook.react.uimanager.UIBlock
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    ((YotiFaceCaptureView) nativeViewHierarchyManager.resolveView(i)).startCamera();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @ReactMethod
    public void stopCamera(final int i) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() { // from class: com.yoti.reactnative.facecapture.YotiFaceCaptureModule.2
            @Override // com.facebook.react.uimanager.UIBlock
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    ((YotiFaceCaptureView) nativeViewHierarchyManager.resolveView(i)).stopCamera();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @ReactMethod
    public void startAnalyzing(final int i) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() { // from class: com.yoti.reactnative.facecapture.YotiFaceCaptureModule.3
            @Override // com.facebook.react.uimanager.UIBlock
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    ((YotiFaceCaptureView) nativeViewHierarchyManager.resolveView(i)).startAnalyzing();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @ReactMethod
    public void stopAnalyzing(final int i) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() { // from class: com.yoti.reactnative.facecapture.YotiFaceCaptureModule.4
            @Override // com.facebook.react.uimanager.UIBlock
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    ((YotiFaceCaptureView) nativeViewHierarchyManager.resolveView(i)).stopAnalyzing();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
