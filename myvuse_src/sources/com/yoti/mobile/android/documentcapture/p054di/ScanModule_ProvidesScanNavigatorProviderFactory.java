package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.documentcapture.view.navigation.IScanNavigatorProvider;
import com.yoti.mobile.android.documentcapture.view.scan.IScanConfigurationViewData;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes5.dex */
public final class ScanModule_ProvidesScanNavigatorProviderFactory implements Factory<IScanNavigatorProvider<IScanConfigurationViewData>> {
    private final ScanModule module;

    public ScanModule_ProvidesScanNavigatorProviderFactory(ScanModule scanModule) {
        this.module = scanModule;
    }

    public static ScanModule_ProvidesScanNavigatorProviderFactory create(ScanModule scanModule) {
        return new ScanModule_ProvidesScanNavigatorProviderFactory(scanModule);
    }

    public static IScanNavigatorProvider<IScanConfigurationViewData> providesScanNavigatorProvider(ScanModule scanModule) {
        return (IScanNavigatorProvider) Preconditions.checkNotNullFromProvides(scanModule.providesScanNavigatorProvider());
    }

    @Override // javax.inject.Provider
    public IScanNavigatorProvider<IScanConfigurationViewData> get() {
        return providesScanNavigatorProvider(this.module);
    }
}
