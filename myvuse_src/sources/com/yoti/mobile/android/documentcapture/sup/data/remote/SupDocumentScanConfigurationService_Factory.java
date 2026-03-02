package com.yoti.mobile.android.documentcapture.sup.data.remote;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class SupDocumentScanConfigurationService_Factory implements Factory<SupDocumentScanConfigurationService> {
    private final Provider<SupDocumentCaptureApiService> apiServiceProvider;

    public SupDocumentScanConfigurationService_Factory(Provider<SupDocumentCaptureApiService> provider) {
        this.apiServiceProvider = provider;
    }

    public static SupDocumentScanConfigurationService_Factory create(Provider<SupDocumentCaptureApiService> provider) {
        return new SupDocumentScanConfigurationService_Factory(provider);
    }

    public static SupDocumentScanConfigurationService newInstance(SupDocumentCaptureApiService supDocumentCaptureApiService) {
        return new SupDocumentScanConfigurationService(supDocumentCaptureApiService);
    }

    @Override // javax.inject.Provider
    public SupDocumentScanConfigurationService get() {
        return newInstance(this.apiServiceProvider.get());
    }
}
