package com.yoti.mobile.android.facecapture.data;

import com.yoti.mobile.android.facecapture.data.remote.FaceCaptureUploadController;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureRepository_Factory implements Factory<FaceCaptureRepository> {
    private final Provider<FaceCaptureUploadController> faceCaptureUploadControllerProvider;
    private final Provider<FaceCaptureValidationExceptionToEntityMapper> faceCaptureValidationExceptionToEntityMapperProvider;

    public FaceCaptureRepository_Factory(Provider<FaceCaptureUploadController> provider, Provider<FaceCaptureValidationExceptionToEntityMapper> provider2) {
        this.faceCaptureUploadControllerProvider = provider;
        this.faceCaptureValidationExceptionToEntityMapperProvider = provider2;
    }

    public static FaceCaptureRepository_Factory create(Provider<FaceCaptureUploadController> provider, Provider<FaceCaptureValidationExceptionToEntityMapper> provider2) {
        return new FaceCaptureRepository_Factory(provider, provider2);
    }

    public static FaceCaptureRepository newInstance(FaceCaptureUploadController faceCaptureUploadController, FaceCaptureValidationExceptionToEntityMapper faceCaptureValidationExceptionToEntityMapper) {
        return new FaceCaptureRepository(faceCaptureUploadController, faceCaptureValidationExceptionToEntityMapper);
    }

    @Override // javax.inject.Provider
    public FaceCaptureRepository get() {
        return newInstance(this.faceCaptureUploadControllerProvider.get(), this.faceCaptureValidationExceptionToEntityMapperProvider.get());
    }
}
