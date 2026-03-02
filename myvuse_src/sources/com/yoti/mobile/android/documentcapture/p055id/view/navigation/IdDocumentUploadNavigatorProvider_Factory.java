package com.yoti.mobile.android.documentcapture.p055id.view.navigation;

import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class IdDocumentUploadNavigatorProvider_Factory implements Factory<IdDocumentUploadNavigatorProvider> {
    private final Provider<DocumentCaptureConfiguration> documentFeatureConfigurationProvider;

    public IdDocumentUploadNavigatorProvider_Factory(Provider<DocumentCaptureConfiguration> provider) {
        this.documentFeatureConfigurationProvider = provider;
    }

    public static IdDocumentUploadNavigatorProvider_Factory create(Provider<DocumentCaptureConfiguration> provider) {
        return new IdDocumentUploadNavigatorProvider_Factory(provider);
    }

    public static IdDocumentUploadNavigatorProvider newInstance(DocumentCaptureConfiguration documentCaptureConfiguration) {
        return new IdDocumentUploadNavigatorProvider(documentCaptureConfiguration);
    }

    @Override // javax.inject.Provider
    public IdDocumentUploadNavigatorProvider get() {
        return newInstance(this.documentFeatureConfigurationProvider.get());
    }
}
