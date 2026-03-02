package com.yoti.mobile.android.documentcapture.p055id.data.remote;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class ScanConfigurationService_Factory implements Factory<ScanConfigurationService> {
    private final Provider<DocumentCaptureApiService> apiServiceProvider;

    public ScanConfigurationService_Factory(Provider<DocumentCaptureApiService> provider) {
        this.apiServiceProvider = provider;
    }

    public static ScanConfigurationService_Factory create(Provider<DocumentCaptureApiService> provider) {
        return new ScanConfigurationService_Factory(provider);
    }

    public static ScanConfigurationService newInstance(DocumentCaptureApiService documentCaptureApiService) {
        return new ScanConfigurationService(documentCaptureApiService);
    }

    @Override // javax.inject.Provider
    public ScanConfigurationService get() {
        return newInstance(this.apiServiceProvider.get());
    }
}
