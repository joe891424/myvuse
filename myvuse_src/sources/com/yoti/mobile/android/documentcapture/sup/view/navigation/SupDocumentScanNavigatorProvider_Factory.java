package com.yoti.mobile.android.documentcapture.sup.view.navigation;

import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class SupDocumentScanNavigatorProvider_Factory implements Factory<SupDocumentScanNavigatorProvider> {
    private final Provider<DocumentCaptureConfiguration> featureConfigurationProvider;

    public SupDocumentScanNavigatorProvider_Factory(Provider<DocumentCaptureConfiguration> provider) {
        this.featureConfigurationProvider = provider;
    }

    public static SupDocumentScanNavigatorProvider_Factory create(Provider<DocumentCaptureConfiguration> provider) {
        return new SupDocumentScanNavigatorProvider_Factory(provider);
    }

    public static SupDocumentScanNavigatorProvider newInstance(DocumentCaptureConfiguration documentCaptureConfiguration) {
        return new SupDocumentScanNavigatorProvider(documentCaptureConfiguration);
    }

    @Override // javax.inject.Provider
    public SupDocumentScanNavigatorProvider get() {
        return newInstance(this.featureConfigurationProvider.get());
    }
}
