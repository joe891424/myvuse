package com.yoti.mobile.android.facecapture.p070di.module;

import com.yoti.mobile.android.facecapture.p070di.FaceCaptureEducationalDependeciesProvider;
import com.yoti.mobile.android.liveness.p071di.ILivenessEducationalDependeciesProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.di.module.FaceCaptureModule_ProvidesLivenessCoreEducationalDependenciesProviderFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4835xbd5a0c1b implements Factory<ILivenessEducationalDependeciesProvider> {
    private final Provider<FaceCaptureEducationalDependeciesProvider> educationalDependeciesProvider;
    private final FaceCaptureModule module;

    public C4835xbd5a0c1b(FaceCaptureModule faceCaptureModule, Provider<FaceCaptureEducationalDependeciesProvider> provider) {
        this.module = faceCaptureModule;
        this.educationalDependeciesProvider = provider;
    }

    public static C4835xbd5a0c1b create(FaceCaptureModule faceCaptureModule, Provider<FaceCaptureEducationalDependeciesProvider> provider) {
        return new C4835xbd5a0c1b(faceCaptureModule, provider);
    }

    public static ILivenessEducationalDependeciesProvider providesLivenessCoreEducationalDependenciesProvider(FaceCaptureModule faceCaptureModule, FaceCaptureEducationalDependeciesProvider faceCaptureEducationalDependeciesProvider) {
        return (ILivenessEducationalDependeciesProvider) Preconditions.checkNotNullFromProvides(faceCaptureModule.providesLivenessCoreEducationalDependenciesProvider(faceCaptureEducationalDependeciesProvider));
    }

    @Override // javax.inject.Provider
    public ILivenessEducationalDependeciesProvider get() {
        return providesLivenessCoreEducationalDependenciesProvider(this.module, this.educationalDependeciesProvider.get());
    }
}
