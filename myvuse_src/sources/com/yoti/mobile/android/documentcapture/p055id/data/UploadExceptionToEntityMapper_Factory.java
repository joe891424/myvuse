package com.yoti.mobile.android.documentcapture.p055id.data;

import com.yoti.mobile.android.yotisdkcore.core.data.DataExceptionToEntityMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class UploadExceptionToEntityMapper_Factory implements Factory<UploadExceptionToEntityMapper> {
    private final Provider<DataExceptionToEntityMapper> dataExceptionToEntityMapperProvider;
    private final Provider<TextExtractionExceptionToEntityMapper> textExtractionExceptionToEntityMapperProvider;

    public UploadExceptionToEntityMapper_Factory(Provider<TextExtractionExceptionToEntityMapper> provider, Provider<DataExceptionToEntityMapper> provider2) {
        this.textExtractionExceptionToEntityMapperProvider = provider;
        this.dataExceptionToEntityMapperProvider = provider2;
    }

    public static UploadExceptionToEntityMapper_Factory create(Provider<TextExtractionExceptionToEntityMapper> provider, Provider<DataExceptionToEntityMapper> provider2) {
        return new UploadExceptionToEntityMapper_Factory(provider, provider2);
    }

    public static UploadExceptionToEntityMapper newInstance(TextExtractionExceptionToEntityMapper textExtractionExceptionToEntityMapper, DataExceptionToEntityMapper dataExceptionToEntityMapper) {
        return new UploadExceptionToEntityMapper(textExtractionExceptionToEntityMapper, dataExceptionToEntityMapper);
    }

    @Override // javax.inject.Provider
    public UploadExceptionToEntityMapper get() {
        return newInstance(this.textExtractionExceptionToEntityMapperProvider.get(), this.dataExceptionToEntityMapperProvider.get());
    }
}
