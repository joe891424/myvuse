package com.surajit.rnrg;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

/* JADX INFO: loaded from: classes6.dex */
public class RadialGradientManager extends SimpleViewManager<GradientView> {
    public static final String PROP_CENTER = "center";
    public static final String PROP_COLORS = "colors";
    public static final String PROP_RADIUS = "radius";
    public static final String PROP_STOPS = "stops";
    public static final String REACT_CLASS = "SRSRadialGradient";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public GradientView createViewInstance(ThemedReactContext themedReactContext) {
        return new GradientView(themedReactContext);
    }

    @ReactProp(name = "colors")
    public void setColors(GradientView gradientView, ReadableArray readableArray) {
        gradientView.setColors(readableArray);
    }

    @ReactProp(name = PROP_CENTER)
    public void setCenter(GradientView gradientView, ReadableArray readableArray) {
        gradientView.setCenter(readableArray);
    }

    @ReactProp(name = PROP_RADIUS)
    public void setRadius(GradientView gradientView, float f) {
        gradientView.setRadius(f);
    }

    @ReactProp(name = PROP_STOPS)
    public void setStops(GradientView gradientView, ReadableArray readableArray) {
        gradientView.setStops(readableArray);
    }
}
