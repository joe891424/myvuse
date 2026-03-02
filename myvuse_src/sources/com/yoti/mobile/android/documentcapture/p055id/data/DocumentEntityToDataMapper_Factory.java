package com.yoti.mobile.android.documentcapture.p055id.data;

import com.yoti.mobile.android.documentcapture.data.PageInfoEntityToDataMapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeEntityToDataMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentEntityToDataMapper_Factory implements Factory<DocumentEntityToDataMapper> {
    private final Provider<DocumentTypeEntityToDataMapper> documentTypeMapperProvider;
    private final Provider<NfcEntityToDataMapper> mrtdEntityToDataMapperProvider;
    private final Provider<OcrResultEntityToDataMapper> ocrResultEntityToDataMapperProvider;
    private final Provider<PageInfoEntityToDataMapper> pageInfoEntityToDataMapperProvider;

    public DocumentEntityToDataMapper_Factory(Provider<PageInfoEntityToDataMapper> provider, Provider<OcrResultEntityToDataMapper> provider2, Provider<DocumentTypeEntityToDataMapper> provider3, Provider<NfcEntityToDataMapper> provider4) {
        this.pageInfoEntityToDataMapperProvider = provider;
        this.ocrResultEntityToDataMapperProvider = provider2;
        this.documentTypeMapperProvider = provider3;
        this.mrtdEntityToDataMapperProvider = provider4;
    }

    public static DocumentEntityToDataMapper_Factory create(Provider<PageInfoEntityToDataMapper> provider, Provider<OcrResultEntityToDataMapper> provider2, Provider<DocumentTypeEntityToDataMapper> provider3, Provider<NfcEntityToDataMapper> provider4) {
        return new DocumentEntityToDataMapper_Factory(provider, provider2, provider3, provider4);
    }

    public static DocumentEntityToDataMapper newInstance(PageInfoEntityToDataMapper pageInfoEntityToDataMapper, OcrResultEntityToDataMapper ocrResultEntityToDataMapper, DocumentTypeEntityToDataMapper documentTypeEntityToDataMapper, NfcEntityToDataMapper nfcEntityToDataMapper) {
        return new DocumentEntityToDataMapper(pageInfoEntityToDataMapper, ocrResultEntityToDataMapper, documentTypeEntityToDataMapper, nfcEntityToDataMapper);
    }

    @Override // javax.inject.Provider
    public DocumentEntityToDataMapper get() {
        return newInstance(this.pageInfoEntityToDataMapperProvider.get(), this.ocrResultEntityToDataMapperProvider.get(), this.documentTypeMapperProvider.get(), this.mrtdEntityToDataMapperProvider.get());
    }
}
