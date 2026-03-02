package com.reactnativenavigation.react;

import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class JsDevReloadHandlerFacade implements DevBundleDownloadListener, NavigationDevBundleDownloadListener {
    @Override // com.facebook.react.devsupport.interfaces.DevBundleDownloadListener
    public void onFailure(Exception exc) {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevBundleDownloadListener
    public void onProgress(@Nullable String str, @Nullable Integer num, @Nullable Integer num2) {
    }

    @Override // com.facebook.react.devsupport.interfaces.DevBundleDownloadListener
    public void onSuccess() {
        onSuccess();
    }
}
