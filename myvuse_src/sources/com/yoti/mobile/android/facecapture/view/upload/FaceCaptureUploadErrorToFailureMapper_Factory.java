package com.yoti.mobile.android.facecapture.view.upload;

import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureUploadErrorToFailureMapper_Factory implements Factory<FaceCaptureUploadErrorToFailureMapper> {
    private final Provider<ExceptionToFailureMapper> exceptionToFailureMapperProvider;

    public FaceCaptureUploadErrorToFailureMapper_Factory(Provider<ExceptionToFailureMapper> provider) {
        this.exceptionToFailureMapperProvider = provider;
    }

    public static FaceCaptureUploadErrorToFailureMapper_Factory create(Provider<ExceptionToFailureMapper> provider) {
        return new FaceCaptureUploadErrorToFailureMapper_Factory(provider);
    }

    public static FaceCaptureUploadErrorToFailureMapper newInstance(ExceptionToFailureMapper exceptionToFailureMapper) {
        return new FaceCaptureUploadErrorToFailureMapper(exceptionToFailureMapper);
    }

    @Override // javax.inject.Provider
    public FaceCaptureUploadErrorToFailureMapper get() {
        return newInstance(this.exceptionToFailureMapperProvider.get());
    }
}
