package com.yoti.mobile.android.documentcapture.sup.view.upload;

import com.yoti.mobile.android.documentcapture.sup.view.scan.SupDocumentFileProvider;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentTypeViewDataToEntityMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class SupDocumentViewDataToEntityMapper_Factory implements Factory<SupDocumentViewDataToEntityMapper> {
    private final Provider<DocumentTypeViewDataToEntityMapper> documentTypeViewDataToEntityMapperProvider;
    private final Provider<SupDocumentFileProvider> fileProvider;

    public SupDocumentViewDataToEntityMapper_Factory(Provider<DocumentTypeViewDataToEntityMapper> provider, Provider<SupDocumentFileProvider> provider2) {
        this.documentTypeViewDataToEntityMapperProvider = provider;
        this.fileProvider = provider2;
    }

    public static SupDocumentViewDataToEntityMapper_Factory create(Provider<DocumentTypeViewDataToEntityMapper> provider, Provider<SupDocumentFileProvider> provider2) {
        return new SupDocumentViewDataToEntityMapper_Factory(provider, provider2);
    }

    public static SupDocumentViewDataToEntityMapper newInstance(DocumentTypeViewDataToEntityMapper documentTypeViewDataToEntityMapper, SupDocumentFileProvider supDocumentFileProvider) {
        return new SupDocumentViewDataToEntityMapper(documentTypeViewDataToEntityMapper, supDocumentFileProvider);
    }

    @Override // javax.inject.Provider
    public SupDocumentViewDataToEntityMapper get() {
        return newInstance(this.documentTypeViewDataToEntityMapperProvider.get(), this.fileProvider.get());
    }
}
