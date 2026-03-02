package com.yoti.mobile.android.documentcapture.sup.view.navigation;

import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class SupDocumentUploadNavigatorProvider_Factory implements Factory<SupDocumentUploadNavigatorProvider> {
    private final Provider<DocumentCaptureConfiguration> featureConfigurationProvider;

    public SupDocumentUploadNavigatorProvider_Factory(Provider<DocumentCaptureConfiguration> provider) {
        this.featureConfigurationProvider = provider;
    }

    public static SupDocumentUploadNavigatorProvider_Factory create(Provider<DocumentCaptureConfiguration> provider) {
        return new SupDocumentUploadNavigatorProvider_Factory(provider);
    }

    public static SupDocumentUploadNavigatorProvider newInstance(DocumentCaptureConfiguration documentCaptureConfiguration) {
        return new SupDocumentUploadNavigatorProvider(documentCaptureConfiguration);
    }

    @Override // javax.inject.Provider
    public SupDocumentUploadNavigatorProvider get() {
        return newInstance(this.featureConfigurationProvider.get());
    }
}
