package com.yoti.mobile.android.documentcapture.sup.view;

import com.yoti.mobile.android.documentcapture.view.DocumentFeatureErrorToFailureMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class SupDocumentFeatureErrorToFailureMapper_Factory implements Factory<SupDocumentFeatureErrorToFailureMapper> {
    private final Provider<DocumentFeatureErrorToFailureMapper> documentFeatureErrorToFailureMapperProvider;

    public SupDocumentFeatureErrorToFailureMapper_Factory(Provider<DocumentFeatureErrorToFailureMapper> provider) {
        this.documentFeatureErrorToFailureMapperProvider = provider;
    }

    public static SupDocumentFeatureErrorToFailureMapper_Factory create(Provider<DocumentFeatureErrorToFailureMapper> provider) {
        return new SupDocumentFeatureErrorToFailureMapper_Factory(provider);
    }

    public static SupDocumentFeatureErrorToFailureMapper newInstance(DocumentFeatureErrorToFailureMapper documentFeatureErrorToFailureMapper) {
        return new SupDocumentFeatureErrorToFailureMapper(documentFeatureErrorToFailureMapper);
    }

    @Override // javax.inject.Provider
    public SupDocumentFeatureErrorToFailureMapper get() {
        return newInstance(this.documentFeatureErrorToFailureMapperProvider.get());
    }
}
