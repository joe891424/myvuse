package com.yoti.mobile.android.documentcapture.view.navigation;

import com.yoti.mobile.android.documentcapture.view.scan.IScanConfigurationViewData;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentNavigationCoordinatorHelper_Factory implements Factory<DocumentNavigationCoordinatorHelper> {
    private final Provider<IScanNavigatorProvider<IScanConfigurationViewData>> scanNavigatorProvider;

    public DocumentNavigationCoordinatorHelper_Factory(Provider<IScanNavigatorProvider<IScanConfigurationViewData>> provider) {
        this.scanNavigatorProvider = provider;
    }

    public static DocumentNavigationCoordinatorHelper_Factory create(Provider<IScanNavigatorProvider<IScanConfigurationViewData>> provider) {
        return new DocumentNavigationCoordinatorHelper_Factory(provider);
    }

    public static DocumentNavigationCoordinatorHelper newInstance(IScanNavigatorProvider<IScanConfigurationViewData> iScanNavigatorProvider) {
        return new DocumentNavigationCoordinatorHelper(iScanNavigatorProvider);
    }

    @Override // javax.inject.Provider
    public DocumentNavigationCoordinatorHelper get() {
        return newInstance(this.scanNavigatorProvider.get());
    }
}
