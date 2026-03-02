package com.yoti.mobile.android.facecapture.p070di;

import com.yoti.mobile.android.facecapture.data.FaceCaptureResourceRepository;
import com.yoti.mobile.android.facecapture.view.educational.FaceCaptureGuidelinesViewDataFactory;
import com.yoti.mobile.android.facecapture.view.navigation.FaceCaptureEducationalNavigatorProvider;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureEducationalDependeciesProvider_Factory implements Factory<FaceCaptureEducationalDependeciesProvider> {
    private final Provider<FaceCaptureEducationalNavigatorProvider> faceCaptureEducationalNavigatorProvider;
    private final Provider<FaceCaptureResourceRepository> faceCaptureResourceRepositoryProvider;
    private final Provider<LivenessFeatureConfiguration> featureConfigurationProvider;
    private final Provider<FaceCaptureGuidelinesViewDataFactory> livenessGuidelinesViewDataFactoryProvider;

    public FaceCaptureEducationalDependeciesProvider_Factory(Provider<LivenessFeatureConfiguration> provider, Provider<FaceCaptureEducationalNavigatorProvider> provider2, Provider<FaceCaptureResourceRepository> provider3, Provider<FaceCaptureGuidelinesViewDataFactory> provider4) {
        this.featureConfigurationProvider = provider;
        this.faceCaptureEducationalNavigatorProvider = provider2;
        this.faceCaptureResourceRepositoryProvider = provider3;
        this.livenessGuidelinesViewDataFactoryProvider = provider4;
    }

    public static FaceCaptureEducationalDependeciesProvider_Factory create(Provider<LivenessFeatureConfiguration> provider, Provider<FaceCaptureEducationalNavigatorProvider> provider2, Provider<FaceCaptureResourceRepository> provider3, Provider<FaceCaptureGuidelinesViewDataFactory> provider4) {
        return new FaceCaptureEducationalDependeciesProvider_Factory(provider, provider2, provider3, provider4);
    }

    public static FaceCaptureEducationalDependeciesProvider newInstance(LivenessFeatureConfiguration livenessFeatureConfiguration, FaceCaptureEducationalNavigatorProvider faceCaptureEducationalNavigatorProvider, FaceCaptureResourceRepository faceCaptureResourceRepository, FaceCaptureGuidelinesViewDataFactory faceCaptureGuidelinesViewDataFactory) {
        return new FaceCaptureEducationalDependeciesProvider(livenessFeatureConfiguration, faceCaptureEducationalNavigatorProvider, faceCaptureResourceRepository, faceCaptureGuidelinesViewDataFactory);
    }

    @Override // javax.inject.Provider
    public FaceCaptureEducationalDependeciesProvider get() {
        return newInstance(this.featureConfigurationProvider.get(), this.faceCaptureEducationalNavigatorProvider.get(), this.faceCaptureResourceRepositoryProvider.get(), this.livenessGuidelinesViewDataFactoryProvider.get());
    }
}
