package com.yoti.mobile.android.documentcapture.sup.data;

import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeDataToEntityMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class SupDocumentScanConfigDataToEntityMapper_Factory implements Factory<SupDocumentScanConfigDataToEntityMapper> {
    private final Provider<DocumentTypeDataToEntityMapper> documentTypeDataToEntityMapperProvider;

    public SupDocumentScanConfigDataToEntityMapper_Factory(Provider<DocumentTypeDataToEntityMapper> provider) {
        this.documentTypeDataToEntityMapperProvider = provider;
    }

    public static SupDocumentScanConfigDataToEntityMapper_Factory create(Provider<DocumentTypeDataToEntityMapper> provider) {
        return new SupDocumentScanConfigDataToEntityMapper_Factory(provider);
    }

    public static SupDocumentScanConfigDataToEntityMapper newInstance(DocumentTypeDataToEntityMapper documentTypeDataToEntityMapper) {
        return new SupDocumentScanConfigDataToEntityMapper(documentTypeDataToEntityMapper);
    }

    @Override // javax.inject.Provider
    public SupDocumentScanConfigDataToEntityMapper get() {
        return newInstance(this.documentTypeDataToEntityMapperProvider.get());
    }
}
