package com.reactnativenavigation.react;

import com.facebook.react.defaults.DefaultReactNativeHost;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.reactnativenavigation.NavigationApplication;

/* JADX INFO: loaded from: classes6.dex */
public abstract class NavigationReactNativeHost extends DefaultReactNativeHost implements BundleDownloadListenerProvider {
    private NavigationDevBundleDownloadListener bundleListener;
    private final DevBundleDownloadListener bundleListenerMediator;

    public NavigationReactNativeHost(NavigationApplication navigationApplication) {
        super(navigationApplication);
        this.bundleListenerMediator = new DevBundleDownloadListenerAdapter() { // from class: com.reactnativenavigation.react.NavigationReactNativeHost.1
            @Override // com.reactnativenavigation.react.DevBundleDownloadListenerAdapter, com.facebook.react.devsupport.interfaces.DevBundleDownloadListener
            public void onSuccess() {
                if (NavigationReactNativeHost.this.bundleListener != null) {
                    NavigationReactNativeHost.this.bundleListener.onSuccess();
                }
            }
        };
    }

    @Override // com.reactnativenavigation.react.BundleDownloadListenerProvider
    public void setBundleLoaderListener(NavigationDevBundleDownloadListener navigationDevBundleDownloadListener) {
        this.bundleListener = navigationDevBundleDownloadListener;
    }

    protected DevBundleDownloadListener getDevBundleDownloadListener() {
        return this.bundleListenerMediator;
    }
}
