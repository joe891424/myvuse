package com.reactnativenavigation.react;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import com.facebook.react.ReactNativeHost;
import com.reactnativenavigation.NavigationActivity;

/* JADX INFO: loaded from: classes6.dex */
public class ReactGateway {
    private final ReactNativeHost host;
    private final NavigationReactInitializer initializer;
    private final JsDevReloadHandler jsDevReloadHandler;

    /* JADX WARN: Multi-variable type inference failed */
    public ReactGateway(ReactNativeHost reactNativeHost) {
        this.host = reactNativeHost;
        this.initializer = new NavigationReactInitializer(reactNativeHost.getReactInstanceManager(), reactNativeHost.getUseDeveloperSupport());
        JsDevReloadHandler jsDevReloadHandler = new JsDevReloadHandler(reactNativeHost.getReactInstanceManager().getDevSupportManager());
        this.jsDevReloadHandler = jsDevReloadHandler;
        if (reactNativeHost instanceof BundleDownloadListenerProvider) {
            ((BundleDownloadListenerProvider) reactNativeHost).setBundleLoaderListener(jsDevReloadHandler);
        }
    }

    public void onActivityCreated(NavigationActivity navigationActivity) {
        this.initializer.onActivityCreated();
        this.jsDevReloadHandler.setReloadListener(navigationActivity);
    }

    public void onActivityResumed(NavigationActivity navigationActivity) {
        this.initializer.onActivityResumed(navigationActivity);
        this.jsDevReloadHandler.onActivityResumed(navigationActivity);
    }

    public boolean onNewIntent(Intent intent) {
        if (!this.host.hasInstance()) {
            return false;
        }
        this.host.getReactInstanceManager().onNewIntent(intent);
        return true;
    }

    public void onConfigurationChanged(NavigationActivity navigationActivity, Configuration configuration) {
        if (this.host.hasInstance()) {
            this.host.getReactInstanceManager().onConfigurationChanged(navigationActivity, configuration);
        }
    }

    public void onActivityPaused(NavigationActivity navigationActivity) {
        this.initializer.onActivityPaused(navigationActivity);
        this.jsDevReloadHandler.onActivityPaused(navigationActivity);
    }

    public void onActivityDestroyed(NavigationActivity navigationActivity) {
        this.jsDevReloadHandler.removeReloadListener(navigationActivity);
        this.initializer.onActivityDestroyed(navigationActivity);
    }

    public boolean onKeyUp(Activity activity, int i) {
        return this.jsDevReloadHandler.onKeyUp(activity, i);
    }

    public void onBackPressed() {
        this.host.getReactInstanceManager().onBackPressed();
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        this.host.getReactInstanceManager().onActivityResult(activity, i, i2, intent);
    }
}
