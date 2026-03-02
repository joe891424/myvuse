package com.yoti.mobile.android.documentcapture.p055id.view.upload;

import com.yoti.mobile.android.common.p049ui.components.utils.CountryCodeHelper;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentTypeViewDataToEntityMapper;
import com.yoti.mobile.android.yotidocs.common.ImageDimensionsReader;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public final class IdDocumentScanResultViewDataToEntityMapper_Factory implements Factory<IdDocumentScanResultViewDataToEntityMapper> {
    private final Provider<CoroutineContext> computationContextProvider;
    private final Provider<CountryCodeHelper> countryCodeHelperProvider;
    private final Provider<DocumentTypeViewDataToEntityMapper> documentTypeViewDataToEntityMapperProvider;
    private final Provider<ImageDimensionsReader> imageDimensionsReaderProvider;

    public IdDocumentScanResultViewDataToEntityMapper_Factory(Provider<DocumentTypeViewDataToEntityMapper> provider, Provider<CountryCodeHelper> provider2, Provider<ImageDimensionsReader> provider3, Provider<CoroutineContext> provider4) {
        this.documentTypeViewDataToEntityMapperProvider = provider;
        this.countryCodeHelperProvider = provider2;
        this.imageDimensionsReaderProvider = provider3;
        this.computationContextProvider = provider4;
    }

    public static IdDocumentScanResultViewDataToEntityMapper_Factory create(Provider<DocumentTypeViewDataToEntityMapper> provider, Provider<CountryCodeHelper> provider2, Provider<ImageDimensionsReader> provider3, Provider<CoroutineContext> provider4) {
        return new IdDocumentScanResultViewDataToEntityMapper_Factory(provider, provider2, provider3, provider4);
    }

    public static IdDocumentScanResultViewDataToEntityMapper newInstance(DocumentTypeViewDataToEntityMapper documentTypeViewDataToEntityMapper, CountryCodeHelper countryCodeHelper, ImageDimensionsReader imageDimensionsReader, CoroutineContext coroutineContext) {
        return new IdDocumentScanResultViewDataToEntityMapper(documentTypeViewDataToEntityMapper, countryCodeHelper, imageDimensionsReader, coroutineContext);
    }

    @Override // javax.inject.Provider
    public IdDocumentScanResultViewDataToEntityMapper get() {
        return newInstance(this.documentTypeViewDataToEntityMapperProvider.get(), this.countryCodeHelperProvider.get(), this.imageDimensionsReaderProvider.get(), this.computationContextProvider.get());
    }
}
