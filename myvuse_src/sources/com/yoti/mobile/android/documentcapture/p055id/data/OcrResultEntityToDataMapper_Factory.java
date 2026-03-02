package com.yoti.mobile.android.documentcapture.p055id.data;

import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeEntityToDataMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class OcrResultEntityToDataMapper_Factory implements Factory<OcrResultEntityToDataMapper> {
    private final Provider<AddressEntityToDataMapper> addressEntityToDataMapperProvider;
    private final Provider<DocumentTypeEntityToDataMapper> documentTypeEntityToDataMapperProvider;

    public OcrResultEntityToDataMapper_Factory(Provider<AddressEntityToDataMapper> provider, Provider<DocumentTypeEntityToDataMapper> provider2) {
        this.addressEntityToDataMapperProvider = provider;
        this.documentTypeEntityToDataMapperProvider = provider2;
    }

    public static OcrResultEntityToDataMapper_Factory create(Provider<AddressEntityToDataMapper> provider, Provider<DocumentTypeEntityToDataMapper> provider2) {
        return new OcrResultEntityToDataMapper_Factory(provider, provider2);
    }

    public static OcrResultEntityToDataMapper newInstance(AddressEntityToDataMapper addressEntityToDataMapper, DocumentTypeEntityToDataMapper documentTypeEntityToDataMapper) {
        return new OcrResultEntityToDataMapper(addressEntityToDataMapper, documentTypeEntityToDataMapper);
    }

    @Override // javax.inject.Provider
    public OcrResultEntityToDataMapper get() {
        return newInstance(this.addressEntityToDataMapperProvider.get(), this.documentTypeEntityToDataMapperProvider.get());
    }
}
