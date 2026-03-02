package com.yoti.mobile.android.documentcapture.sup.data;

import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeEntityToDataMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class SupDocumentEntityToDataMapper_Factory implements Factory<SupDocumentEntityToDataMapper> {
    private final Provider<DocumentTypeEntityToDataMapper> documentTypeMapperProvider;

    public SupDocumentEntityToDataMapper_Factory(Provider<DocumentTypeEntityToDataMapper> provider) {
        this.documentTypeMapperProvider = provider;
    }

    public static SupDocumentEntityToDataMapper_Factory create(Provider<DocumentTypeEntityToDataMapper> provider) {
        return new SupDocumentEntityToDataMapper_Factory(provider);
    }

    public static SupDocumentEntityToDataMapper newInstance(DocumentTypeEntityToDataMapper documentTypeEntityToDataMapper) {
        return new SupDocumentEntityToDataMapper(documentTypeEntityToDataMapper);
    }

    @Override // javax.inject.Provider
    public SupDocumentEntityToDataMapper get() {
        return newInstance(this.documentTypeMapperProvider.get());
    }
}
