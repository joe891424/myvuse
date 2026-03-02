package com.bat.myvuse.mobile.rncomponents.p036ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bat.myvuse.mobile.C1410R;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

/* JADX INFO: loaded from: classes.dex */
public class LoadingViewManager extends ViewGroupManager<FrameLayout> {
    public static final String REACT_NAME = "LoadingView";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public FrameLayout createViewInstance(ThemedReactContext themedReactContext) {
        return (FrameLayout) ((LayoutInflater) themedReactContext.getSystemService("layout_inflater")).inflate(C1410R.layout.fragment_loading_view, (ViewGroup) null);
    }
}
