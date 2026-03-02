package com.yoti.mobile.android.liveness.p071di.module;

import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: renamed from: com.yoti.mobile.android.liveness.di.module.LivenessFeatureConfigurationModule_ProvidesLivenessFeatureConfigurationFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4885x995a0445 implements Factory<LivenessFeatureConfiguration> {
    private final LivenessFeatureConfigurationModule module;

    public C4885x995a0445(LivenessFeatureConfigurationModule livenessFeatureConfigurationModule) {
        this.module = livenessFeatureConfigurationModule;
    }

    public static C4885x995a0445 create(LivenessFeatureConfigurationModule livenessFeatureConfigurationModule) {
        return new C4885x995a0445(livenessFeatureConfigurationModule);
    }

    public static LivenessFeatureConfiguration providesLivenessFeatureConfiguration(LivenessFeatureConfigurationModule livenessFeatureConfigurationModule) {
        return (LivenessFeatureConfiguration) Preconditions.checkNotNullFromProvides(livenessFeatureConfigurationModule.getFeatureConfiguration());
    }

    @Override // javax.inject.Provider
    public LivenessFeatureConfiguration get() {
        return providesLivenessFeatureConfiguration(this.module);
    }
}
