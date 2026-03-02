package com.reactnativenavigation.react;

import com.reactnativenavigation.react.JsDevReloadHandler;

/* JADX INFO: loaded from: classes6.dex */
public class ReloadHandler extends ReloadHandlerFacade implements JsDevReloadHandler.ReloadListener {
    private Runnable onReloadListener = new Runnable() { // from class: com.reactnativenavigation.react.ReloadHandler$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            ReloadHandler.lambda$new$0();
        }
    };

    static /* synthetic */ void lambda$new$0() {
    }

    public void setOnReloadListener(Runnable runnable) {
        this.onReloadListener = runnable;
    }

    @Override // com.reactnativenavigation.react.JsDevReloadHandler.ReloadListener
    public void onReload() {
        this.onReloadListener.run();
    }

    @Override // com.reactnativenavigation.react.ReloadHandlerFacade, com.facebook.react.devsupport.interfaces.DevBundleDownloadListener
    public void onSuccess() {
        this.onReloadListener.run();
    }

    public void destroy() {
        this.onReloadListener = null;
    }
}
