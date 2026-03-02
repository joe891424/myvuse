package com.yoti.mobile.android.documentcapture.p055id.p056di;

import com.yoti.mobile.android.documentcapture.p055id.view.scan.IScanFragmentFactoryWrapper;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.ScanFragmentFactoryWrapper;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.automation.AutomationScanFragmentFactoryWrapper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class IdDocumentCaptureModule_ProvidesScanFragmentFactoryFactory implements Factory<IScanFragmentFactoryWrapper> {
    private final Provider<AutomationScanFragmentFactoryWrapper> automationScanFragmentFactoryWrapperProvider;
    private final IdDocumentCaptureModule module;
    private final Provider<ScanFragmentFactoryWrapper> scanFragmentFactoryWrapperProvider;

    public IdDocumentCaptureModule_ProvidesScanFragmentFactoryFactory(IdDocumentCaptureModule idDocumentCaptureModule, Provider<ScanFragmentFactoryWrapper> provider, Provider<AutomationScanFragmentFactoryWrapper> provider2) {
        this.module = idDocumentCaptureModule;
        this.scanFragmentFactoryWrapperProvider = provider;
        this.automationScanFragmentFactoryWrapperProvider = provider2;
    }

    public static IdDocumentCaptureModule_ProvidesScanFragmentFactoryFactory create(IdDocumentCaptureModule idDocumentCaptureModule, Provider<ScanFragmentFactoryWrapper> provider, Provider<AutomationScanFragmentFactoryWrapper> provider2) {
        return new IdDocumentCaptureModule_ProvidesScanFragmentFactoryFactory(idDocumentCaptureModule, provider, provider2);
    }

    public static IScanFragmentFactoryWrapper providesScanFragmentFactory(IdDocumentCaptureModule idDocumentCaptureModule, ScanFragmentFactoryWrapper scanFragmentFactoryWrapper, AutomationScanFragmentFactoryWrapper automationScanFragmentFactoryWrapper) {
        return (IScanFragmentFactoryWrapper) Preconditions.checkNotNullFromProvides(idDocumentCaptureModule.providesScanFragmentFactory(scanFragmentFactoryWrapper, automationScanFragmentFactoryWrapper));
    }

    @Override // javax.inject.Provider
    public IScanFragmentFactoryWrapper get() {
        return providesScanFragmentFactory(this.module, this.scanFragmentFactoryWrapperProvider.get(), this.automationScanFragmentFactoryWrapperProvider.get());
    }
}
