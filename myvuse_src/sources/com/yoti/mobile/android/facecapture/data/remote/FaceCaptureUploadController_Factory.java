package com.yoti.mobile.android.facecapture.data.remote;

import com.yoti.mobile.android.facecapture.data.remote.model.SecurityContent;
import com.yoti.mobile.android.remote.MultiPartBodyFactory;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureUploadController_Factory implements Factory<FaceCaptureUploadController> {
    private final Provider<IFaceCaptureApiService> faceCaptureApiServiceProvider;
    private final Provider<MultiPartBodyFactory> multipartBodyFactoryProvider;
    private final Provider<SecurityContent.Factory> securityContentFactoryProvider;

    public FaceCaptureUploadController_Factory(Provider<MultiPartBodyFactory> provider, Provider<SecurityContent.Factory> provider2, Provider<IFaceCaptureApiService> provider3) {
        this.multipartBodyFactoryProvider = provider;
        this.securityContentFactoryProvider = provider2;
        this.faceCaptureApiServiceProvider = provider3;
    }

    public static FaceCaptureUploadController_Factory create(Provider<MultiPartBodyFactory> provider, Provider<SecurityContent.Factory> provider2, Provider<IFaceCaptureApiService> provider3) {
        return new FaceCaptureUploadController_Factory(provider, provider2, provider3);
    }

    public static FaceCaptureUploadController newInstance(MultiPartBodyFactory multiPartBodyFactory, SecurityContent.Factory factory, IFaceCaptureApiService iFaceCaptureApiService) {
        return new FaceCaptureUploadController(multiPartBodyFactory, factory, iFaceCaptureApiService);
    }

    @Override // javax.inject.Provider
    public FaceCaptureUploadController get() {
        return newInstance(this.multipartBodyFactoryProvider.get(), this.securityContentFactoryProvider.get(), this.faceCaptureApiServiceProvider.get());
    }
}
