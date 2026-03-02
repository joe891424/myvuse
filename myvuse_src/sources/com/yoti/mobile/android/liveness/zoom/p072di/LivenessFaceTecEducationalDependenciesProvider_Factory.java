package com.yoti.mobile.android.liveness.zoom.p072di;

import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewDataFactory;
import com.yoti.mobile.android.liveness.zoom.data.LivenessFaceTecResourceCreationRepository;
import com.yoti.mobile.android.liveness.zoom.view.navigation.LivenessFaceTecEducationalNavigatorProvider;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessFaceTecEducationalDependenciesProvider_Factory implements Factory<LivenessFaceTecEducationalDependenciesProvider> {
    private final Provider<LivenessFeatureConfiguration> featureConfigurationProvider;
    private final Provider<LivenessFaceTecEducationalNavigatorProvider> livenessFaceTecEducationalNavigatorProvider;
    private final Provider<LivenessFaceTecResourceCreationRepository> livenessFaceTecResourceRepositoryProvider;
    private final Provider<LivenessGuidelinesViewDataFactory> livenessGuidelinesViewDataFactoryProvider;

    public LivenessFaceTecEducationalDependenciesProvider_Factory(Provider<LivenessFeatureConfiguration> provider, Provider<LivenessFaceTecEducationalNavigatorProvider> provider2, Provider<LivenessFaceTecResourceCreationRepository> provider3, Provider<LivenessGuidelinesViewDataFactory> provider4) {
        this.featureConfigurationProvider = provider;
        this.livenessFaceTecEducationalNavigatorProvider = provider2;
        this.livenessFaceTecResourceRepositoryProvider = provider3;
        this.livenessGuidelinesViewDataFactoryProvider = provider4;
    }

    public static LivenessFaceTecEducationalDependenciesProvider_Factory create(Provider<LivenessFeatureConfiguration> provider, Provider<LivenessFaceTecEducationalNavigatorProvider> provider2, Provider<LivenessFaceTecResourceCreationRepository> provider3, Provider<LivenessGuidelinesViewDataFactory> provider4) {
        return new LivenessFaceTecEducationalDependenciesProvider_Factory(provider, provider2, provider3, provider4);
    }

    public static LivenessFaceTecEducationalDependenciesProvider newInstance(LivenessFeatureConfiguration livenessFeatureConfiguration, LivenessFaceTecEducationalNavigatorProvider livenessFaceTecEducationalNavigatorProvider, LivenessFaceTecResourceCreationRepository livenessFaceTecResourceCreationRepository, LivenessGuidelinesViewDataFactory livenessGuidelinesViewDataFactory) {
        return new LivenessFaceTecEducationalDependenciesProvider(livenessFeatureConfiguration, livenessFaceTecEducationalNavigatorProvider, livenessFaceTecResourceCreationRepository, livenessGuidelinesViewDataFactory);
    }

    @Override // javax.inject.Provider
    public LivenessFaceTecEducationalDependenciesProvider get() {
        return newInstance(this.featureConfigurationProvider.get(), this.livenessFaceTecEducationalNavigatorProvider.get(), this.livenessFaceTecResourceRepositoryProvider.get(), this.livenessGuidelinesViewDataFactoryProvider.get());
    }
}
