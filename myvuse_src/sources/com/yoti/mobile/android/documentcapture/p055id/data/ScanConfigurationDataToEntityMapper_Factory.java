package com.yoti.mobile.android.documentcapture.p055id.data;

import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeDataToEntityMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class ScanConfigurationDataToEntityMapper_Factory implements Factory<ScanConfigurationDataToEntityMapper> {
    private final Provider<DocumentTypeDataToEntityMapper> documentTypeDataToEntityMapperProvider;

    public ScanConfigurationDataToEntityMapper_Factory(Provider<DocumentTypeDataToEntityMapper> provider) {
        this.documentTypeDataToEntityMapperProvider = provider;
    }

    public static ScanConfigurationDataToEntityMapper_Factory create(Provider<DocumentTypeDataToEntityMapper> provider) {
        return new ScanConfigurationDataToEntityMapper_Factory(provider);
    }

    public static ScanConfigurationDataToEntityMapper newInstance(DocumentTypeDataToEntityMapper documentTypeDataToEntityMapper) {
        return new ScanConfigurationDataToEntityMapper(documentTypeDataToEntityMapper);
    }

    @Override // javax.inject.Provider
    public ScanConfigurationDataToEntityMapper get() {
        return newInstance(this.documentTypeDataToEntityMapperProvider.get());
    }
}
