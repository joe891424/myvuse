package com.yoti.mobile.android.facecapture.p070di;

import com.yoti.mobile.android.facecapture.data.FaceCaptureRepository;
import com.yoti.mobile.android.facecapture.view.capture.FaceCaptureToEntityMapper;
import com.yoti.mobile.android.facecapture.view.navigation.FaceCaptureUploadNavigatorProvider;
import com.yoti.mobile.android.facecapture.view.upload.FaceCaptureUploadErrorToFailureMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureUploadDependenciesProvider_Factory implements Factory<FaceCaptureUploadDependenciesProvider> {
    private final Provider<FaceCaptureRepository> faceCaptureRepositoryProvider;
    private final Provider<FaceCaptureToEntityMapper> faceCaptureToEntityMapperProvider;
    private final Provider<FaceCaptureUploadErrorToFailureMapper> faceCaptureUploadErrorToFailureMapperProvider;
    private final Provider<FaceCaptureUploadNavigatorProvider> faceCaptureUploadNavigatorProvider;

    public FaceCaptureUploadDependenciesProvider_Factory(Provider<FaceCaptureRepository> provider, Provider<FaceCaptureUploadNavigatorProvider> provider2, Provider<FaceCaptureToEntityMapper> provider3, Provider<FaceCaptureUploadErrorToFailureMapper> provider4) {
        this.faceCaptureRepositoryProvider = provider;
        this.faceCaptureUploadNavigatorProvider = provider2;
        this.faceCaptureToEntityMapperProvider = provider3;
        this.faceCaptureUploadErrorToFailureMapperProvider = provider4;
    }

    public static FaceCaptureUploadDependenciesProvider_Factory create(Provider<FaceCaptureRepository> provider, Provider<FaceCaptureUploadNavigatorProvider> provider2, Provider<FaceCaptureToEntityMapper> provider3, Provider<FaceCaptureUploadErrorToFailureMapper> provider4) {
        return new FaceCaptureUploadDependenciesProvider_Factory(provider, provider2, provider3, provider4);
    }

    public static FaceCaptureUploadDependenciesProvider newInstance(FaceCaptureRepository faceCaptureRepository, FaceCaptureUploadNavigatorProvider faceCaptureUploadNavigatorProvider, FaceCaptureToEntityMapper faceCaptureToEntityMapper, FaceCaptureUploadErrorToFailureMapper faceCaptureUploadErrorToFailureMapper) {
        return new FaceCaptureUploadDependenciesProvider(faceCaptureRepository, faceCaptureUploadNavigatorProvider, faceCaptureToEntityMapper, faceCaptureUploadErrorToFailureMapper);
    }

    @Override // javax.inject.Provider
    public FaceCaptureUploadDependenciesProvider get() {
        return newInstance(this.faceCaptureRepositoryProvider.get(), this.faceCaptureUploadNavigatorProvider.get(), this.faceCaptureToEntityMapperProvider.get(), this.faceCaptureUploadErrorToFailureMapperProvider.get());
    }
}
