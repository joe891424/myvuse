package com.yoti.mobile.android.liveness.p071di;

import android.content.Context;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessCoreSession_Factory implements Factory<LivenessCoreSession> {
    private final Provider<Context> appContextProvider;
    private final Provider<ILivenessEducationalDependeciesProvider> educationalDependeciesProvider;
    private final Provider<LivenessFeatureConfiguration> featureConfigurationProvider;
    private final Provider<ILivenessUploadDependenciesProvider> uploadDependenciesProvider;

    public LivenessCoreSession_Factory(Provider<Context> provider, Provider<ILivenessEducationalDependeciesProvider> provider2, Provider<ILivenessUploadDependenciesProvider> provider3, Provider<LivenessFeatureConfiguration> provider4) {
        this.appContextProvider = provider;
        this.educationalDependeciesProvider = provider2;
        this.uploadDependenciesProvider = provider3;
        this.featureConfigurationProvider = provider4;
    }

    public static LivenessCoreSession_Factory create(Provider<Context> provider, Provider<ILivenessEducationalDependeciesProvider> provider2, Provider<ILivenessUploadDependenciesProvider> provider3, Provider<LivenessFeatureConfiguration> provider4) {
        return new LivenessCoreSession_Factory(provider, provider2, provider3, provider4);
    }

    public static LivenessCoreSession newInstance(Context context, ILivenessEducationalDependeciesProvider iLivenessEducationalDependeciesProvider, ILivenessUploadDependenciesProvider iLivenessUploadDependenciesProvider, LivenessFeatureConfiguration livenessFeatureConfiguration) {
        return new LivenessCoreSession(context, iLivenessEducationalDependeciesProvider, iLivenessUploadDependenciesProvider, livenessFeatureConfiguration);
    }

    @Override // javax.inject.Provider
    public LivenessCoreSession get() {
        return newInstance(this.appContextProvider.get(), this.educationalDependeciesProvider.get(), this.uploadDependenciesProvider.get(), this.featureConfigurationProvider.get());
    }
}
