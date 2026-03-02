package com.yoti.mobile.android.documentcapture.p055id.view.upload;

import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class UploadErrorToViewDataMapper_Factory implements Factory<UploadErrorToViewDataMapper> {
    private final Provider<DocumentCaptureConfiguration> documentCaptureConfigurationProvider;
    private final Provider<ExceptionToFailureMapper> exceptionToFailureMapperProvider;

    public UploadErrorToViewDataMapper_Factory(Provider<DocumentCaptureConfiguration> provider, Provider<ExceptionToFailureMapper> provider2) {
        this.documentCaptureConfigurationProvider = provider;
        this.exceptionToFailureMapperProvider = provider2;
    }

    public static UploadErrorToViewDataMapper_Factory create(Provider<DocumentCaptureConfiguration> provider, Provider<ExceptionToFailureMapper> provider2) {
        return new UploadErrorToViewDataMapper_Factory(provider, provider2);
    }

    public static UploadErrorToViewDataMapper newInstance(DocumentCaptureConfiguration documentCaptureConfiguration, ExceptionToFailureMapper exceptionToFailureMapper) {
        return new UploadErrorToViewDataMapper(documentCaptureConfiguration, exceptionToFailureMapper);
    }

    @Override // javax.inject.Provider
    public UploadErrorToViewDataMapper get() {
        return newInstance(this.documentCaptureConfigurationProvider.get(), this.exceptionToFailureMapperProvider.get());
    }
}
