package com.yoti.mobile.android.liveness.zoom.p072di.module;

import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: renamed from: com.yoti.mobile.android.liveness.zoom.di.module.LivenessFaceTecModule_ProvidesLivenessFeatureConfigurationFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4894x514af474 implements Factory<LivenessFeatureConfiguration> {
    private final LivenessFaceTecModule module;

    public C4894x514af474(LivenessFaceTecModule livenessFaceTecModule) {
        this.module = livenessFaceTecModule;
    }

    public static C4894x514af474 create(LivenessFaceTecModule livenessFaceTecModule) {
        return new C4894x514af474(livenessFaceTecModule);
    }

    public static LivenessFeatureConfiguration providesLivenessFeatureConfiguration(LivenessFaceTecModule livenessFaceTecModule) {
        return (LivenessFeatureConfiguration) Preconditions.checkNotNullFromProvides(livenessFaceTecModule.getFeatureConfiguration());
    }

    @Override // javax.inject.Provider
    public LivenessFeatureConfiguration get() {
        return providesLivenessFeatureConfiguration(this.module);
    }
}
