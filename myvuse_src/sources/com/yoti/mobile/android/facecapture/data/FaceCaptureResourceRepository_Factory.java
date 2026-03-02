package com.yoti.mobile.android.facecapture.data;

import com.yoti.mobile.android.facecapture.data.remote.FaceCaptureResourceResponseToEntityMapper;
import com.yoti.mobile.android.facecapture.data.remote.IFaceCaptureApiService;
import com.yoti.mobile.android.remote.exception.RemoteExceptionToEntityMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureResourceRepository_Factory implements Factory<FaceCaptureResourceRepository> {
    private final Provider<RemoteExceptionToEntityMapper> exceptionToEntityMapperProvider;
    private final Provider<IFaceCaptureApiService> faceCaptureApiServiceProvider;
    private final Provider<FaceCaptureResourceResponseToEntityMapper> faceCaptureResourceResponseToEntityMapperProvider;
    private final Provider<String> requirementIdProvider;

    public FaceCaptureResourceRepository_Factory(Provider<String> provider, Provider<IFaceCaptureApiService> provider2, Provider<FaceCaptureResourceResponseToEntityMapper> provider3, Provider<RemoteExceptionToEntityMapper> provider4) {
        this.requirementIdProvider = provider;
        this.faceCaptureApiServiceProvider = provider2;
        this.faceCaptureResourceResponseToEntityMapperProvider = provider3;
        this.exceptionToEntityMapperProvider = provider4;
    }

    public static FaceCaptureResourceRepository_Factory create(Provider<String> provider, Provider<IFaceCaptureApiService> provider2, Provider<FaceCaptureResourceResponseToEntityMapper> provider3, Provider<RemoteExceptionToEntityMapper> provider4) {
        return new FaceCaptureResourceRepository_Factory(provider, provider2, provider3, provider4);
    }

    public static FaceCaptureResourceRepository newInstance(String str, IFaceCaptureApiService iFaceCaptureApiService, FaceCaptureResourceResponseToEntityMapper faceCaptureResourceResponseToEntityMapper, RemoteExceptionToEntityMapper remoteExceptionToEntityMapper) {
        return new FaceCaptureResourceRepository(str, iFaceCaptureApiService, faceCaptureResourceResponseToEntityMapper, remoteExceptionToEntityMapper);
    }

    @Override // javax.inject.Provider
    public FaceCaptureResourceRepository get() {
        return newInstance(this.requirementIdProvider.get(), this.faceCaptureApiServiceProvider.get(), this.faceCaptureResourceResponseToEntityMapperProvider.get(), this.exceptionToEntityMapperProvider.get());
    }
}
