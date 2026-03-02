package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentCaptureResultToPageScanReviewViewDataMapper_Factory implements Factory<DocumentCaptureResultToPageScanReviewViewDataMapper> {
    private final Provider<DocumentCaptureConfiguration> featureConfigurationProvider;

    public DocumentCaptureResultToPageScanReviewViewDataMapper_Factory(Provider<DocumentCaptureConfiguration> provider) {
        this.featureConfigurationProvider = provider;
    }

    public static DocumentCaptureResultToPageScanReviewViewDataMapper_Factory create(Provider<DocumentCaptureConfiguration> provider) {
        return new DocumentCaptureResultToPageScanReviewViewDataMapper_Factory(provider);
    }

    public static DocumentCaptureResultToPageScanReviewViewDataMapper newInstance(DocumentCaptureConfiguration documentCaptureConfiguration) {
        return new DocumentCaptureResultToPageScanReviewViewDataMapper(documentCaptureConfiguration);
    }

    @Override // javax.inject.Provider
    public DocumentCaptureResultToPageScanReviewViewDataMapper get() {
        return newInstance(this.featureConfigurationProvider.get());
    }
}
