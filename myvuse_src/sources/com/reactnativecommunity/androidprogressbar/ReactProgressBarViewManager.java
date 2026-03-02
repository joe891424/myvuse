package com.reactnativecommunity.androidprogressbar;

import android.content.Context;
import android.widget.ProgressBar;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
@ReactModule(name = ReactProgressBarViewManager.REACT_CLASS)
public class ReactProgressBarViewManager extends BaseViewManager<ProgressBarContainerView, ProgressBarShadowNode> {
    static final String DEFAULT_STYLE = "Normal";
    static final String PROP_ANIMATING = "animating";
    static final String PROP_INDETERMINATE = "indeterminate";
    static final String PROP_PROGRESS = "progress";
    static final String PROP_STYLE = "styleAttr";
    public static final String REACT_CLASS = "RNCProgressBar";
    private static Object sProgressBarCtorLock = new Object();

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateExtraData(ProgressBarContainerView progressBarContainerView, Object obj) {
    }

    public static ProgressBar createProgressBar(Context context, int i) {
        ProgressBar progressBar;
        synchronized (sProgressBarCtorLock) {
            progressBar = new ProgressBar(context, null, i);
        }
        return progressBar;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ProgressBarContainerView createViewInstance(ThemedReactContext themedReactContext) {
        return new ProgressBarContainerView(themedReactContext);
    }

    @ReactProp(name = PROP_STYLE)
    public void setStyle(ProgressBarContainerView progressBarContainerView, @Nullable String str) {
        progressBarContainerView.setStyle(str);
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(ProgressBarContainerView progressBarContainerView, @Nullable Integer num) {
        progressBarContainerView.setColor(num);
    }

    @ReactProp(name = PROP_INDETERMINATE)
    public void setIndeterminate(ProgressBarContainerView progressBarContainerView, boolean z) {
        progressBarContainerView.setIndeterminate(z);
    }

    @ReactProp(name = "progress")
    public void setProgress(ProgressBarContainerView progressBarContainerView, double d) {
        progressBarContainerView.setProgress(d);
    }

    @ReactProp(name = PROP_ANIMATING)
    public void setAnimating(ProgressBarContainerView progressBarContainerView, boolean z) {
        progressBarContainerView.setAnimating(z);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ProgressBarShadowNode createShadowNodeInstance() {
        return new ProgressBarShadowNode();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Class<ProgressBarShadowNode> getShadowNodeClass() {
        return ProgressBarShadowNode.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(ProgressBarContainerView progressBarContainerView) {
        progressBarContainerView.apply();
    }

    static int getStyleFromString(@Nullable String str) {
        if (str == null) {
            throw new JSApplicationIllegalArgumentException("ProgressBar needs to have a style, null received");
        }
        if (str.equals("Horizontal")) {
            return android.R.attr.progressBarStyleHorizontal;
        }
        if (str.equals("Small")) {
            return android.R.attr.progressBarStyleSmall;
        }
        if (str.equals("Large")) {
            return android.R.attr.progressBarStyleLarge;
        }
        if (str.equals("Inverse")) {
            return android.R.attr.progressBarStyleInverse;
        }
        if (str.equals("SmallInverse")) {
            return android.R.attr.progressBarStyleSmallInverse;
        }
        if (str.equals("LargeInverse")) {
            return android.R.attr.progressBarStyleLargeInverse;
        }
        if (str.equals(DEFAULT_STYLE)) {
            return android.R.attr.progressBarStyle;
        }
        throw new JSApplicationIllegalArgumentException("Unknown ProgressBar style: " + str);
    }
}
