package com.yoti.mobile.android.documentcapture.sup.view.scan;

import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeEntityToViewDataMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class SupDocumentScanConfigEntityToViewDataMapper_Factory implements Factory<SupDocumentScanConfigEntityToViewDataMapper> {
    private final Provider<DocumentTypeEntityToViewDataMapper> documentEntityToViewDataMapperProvider;

    public SupDocumentScanConfigEntityToViewDataMapper_Factory(Provider<DocumentTypeEntityToViewDataMapper> provider) {
        this.documentEntityToViewDataMapperProvider = provider;
    }

    public static SupDocumentScanConfigEntityToViewDataMapper_Factory create(Provider<DocumentTypeEntityToViewDataMapper> provider) {
        return new SupDocumentScanConfigEntityToViewDataMapper_Factory(provider);
    }

    public static SupDocumentScanConfigEntityToViewDataMapper newInstance(DocumentTypeEntityToViewDataMapper documentTypeEntityToViewDataMapper) {
        return new SupDocumentScanConfigEntityToViewDataMapper(documentTypeEntityToViewDataMapper);
    }

    @Override // javax.inject.Provider
    public SupDocumentScanConfigEntityToViewDataMapper get() {
        return newInstance(this.documentEntityToViewDataMapperProvider.get());
    }
}
