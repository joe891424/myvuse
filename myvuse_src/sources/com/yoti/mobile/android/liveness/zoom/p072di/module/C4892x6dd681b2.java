package com.yoti.mobile.android.liveness.zoom.p072di.module;

import com.yoti.mobile.android.liveness.p071di.ILivenessEducationalDependeciesProvider;
import com.yoti.mobile.android.liveness.zoom.p072di.LivenessFaceTecEducationalDependenciesProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.liveness.zoom.di.module.LivenessFaceTecModule_ProvidesLivenessCoreEducationalDependenciesProviderFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4892x6dd681b2 implements Factory<ILivenessEducationalDependeciesProvider> {
    private final Provider<LivenessFaceTecEducationalDependenciesProvider> educationalDependeciesProvider;
    private final LivenessFaceTecModule module;

    public C4892x6dd681b2(LivenessFaceTecModule livenessFaceTecModule, Provider<LivenessFaceTecEducationalDependenciesProvider> provider) {
        this.module = livenessFaceTecModule;
        this.educationalDependeciesProvider = provider;
    }

    public static C4892x6dd681b2 create(LivenessFaceTecModule livenessFaceTecModule, Provider<LivenessFaceTecEducationalDependenciesProvider> provider) {
        return new C4892x6dd681b2(livenessFaceTecModule, provider);
    }

    public static ILivenessEducationalDependeciesProvider providesLivenessCoreEducationalDependenciesProvider(LivenessFaceTecModule livenessFaceTecModule, LivenessFaceTecEducationalDependenciesProvider livenessFaceTecEducationalDependenciesProvider) {
        return (ILivenessEducationalDependeciesProvider) Preconditions.checkNotNullFromProvides(livenessFaceTecModule.providesLivenessCoreEducationalDependenciesProvider(livenessFaceTecEducationalDependenciesProvider));
    }

    @Override // javax.inject.Provider
    public ILivenessEducationalDependeciesProvider get() {
        return providesLivenessCoreEducationalDependenciesProvider(this.module, this.educationalDependeciesProvider.get());
    }
}
