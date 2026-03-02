package com.yoti.mobile.android.facecapture.p070di.module;

import com.yoti.mobile.android.facecapture.p070di.FaceCaptureUploadDependenciesProvider;
import com.yoti.mobile.android.liveness.p071di.ILivenessUploadDependenciesProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.di.module.FaceCaptureModule_ProvidesLivenessCoreUploadDependenciesProviderFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4836x1141fb71 implements Factory<ILivenessUploadDependenciesProvider> {
    private final FaceCaptureModule module;
    private final Provider<FaceCaptureUploadDependenciesProvider> uploadDependenciesProvider;

    public C4836x1141fb71(FaceCaptureModule faceCaptureModule, Provider<FaceCaptureUploadDependenciesProvider> provider) {
        this.module = faceCaptureModule;
        this.uploadDependenciesProvider = provider;
    }

    public static C4836x1141fb71 create(FaceCaptureModule faceCaptureModule, Provider<FaceCaptureUploadDependenciesProvider> provider) {
        return new C4836x1141fb71(faceCaptureModule, provider);
    }

    public static ILivenessUploadDependenciesProvider providesLivenessCoreUploadDependenciesProvider(FaceCaptureModule faceCaptureModule, FaceCaptureUploadDependenciesProvider faceCaptureUploadDependenciesProvider) {
        return (ILivenessUploadDependenciesProvider) Preconditions.checkNotNullFromProvides(faceCaptureModule.providesLivenessCoreUploadDependenciesProvider(faceCaptureUploadDependenciesProvider));
    }

    @Override // javax.inject.Provider
    public ILivenessUploadDependenciesProvider get() {
        return providesLivenessCoreUploadDependenciesProvider(this.module, this.uploadDependenciesProvider.get());
    }
}
