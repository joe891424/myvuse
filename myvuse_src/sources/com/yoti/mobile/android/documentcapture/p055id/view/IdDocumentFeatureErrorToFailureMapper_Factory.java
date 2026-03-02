package com.yoti.mobile.android.documentcapture.p055id.view;

import com.yoti.mobile.android.documentcapture.view.DocumentFeatureErrorToFailureMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class IdDocumentFeatureErrorToFailureMapper_Factory implements Factory<IdDocumentFeatureErrorToFailureMapper> {
    private final Provider<DocumentFeatureErrorToFailureMapper> documentFeatureErrorToFailureMapperProvider;

    public IdDocumentFeatureErrorToFailureMapper_Factory(Provider<DocumentFeatureErrorToFailureMapper> provider) {
        this.documentFeatureErrorToFailureMapperProvider = provider;
    }

    public static IdDocumentFeatureErrorToFailureMapper_Factory create(Provider<DocumentFeatureErrorToFailureMapper> provider) {
        return new IdDocumentFeatureErrorToFailureMapper_Factory(provider);
    }

    public static IdDocumentFeatureErrorToFailureMapper newInstance(DocumentFeatureErrorToFailureMapper documentFeatureErrorToFailureMapper) {
        return new IdDocumentFeatureErrorToFailureMapper(documentFeatureErrorToFailureMapper);
    }

    @Override // javax.inject.Provider
    public IdDocumentFeatureErrorToFailureMapper get() {
        return newInstance(this.documentFeatureErrorToFailureMapperProvider.get());
    }
}
