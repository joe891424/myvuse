package com.yoti.mobile.android.liveness.zoom.p072di.module;

import com.yoti.mobile.android.liveness.p071di.ILivenessUploadDependenciesProvider;
import com.yoti.mobile.android.liveness.zoom.p072di.LivenessFaceTecUploadDependenciesProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.liveness.zoom.di.module.LivenessFaceTecModule_ProvidesLivenessCoreUploadDependenciesProviderFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4893x44fa237a implements Factory<ILivenessUploadDependenciesProvider> {
    private final LivenessFaceTecModule module;
    private final Provider<LivenessFaceTecUploadDependenciesProvider> uploadDependenciesProvider;

    public C4893x44fa237a(LivenessFaceTecModule livenessFaceTecModule, Provider<LivenessFaceTecUploadDependenciesProvider> provider) {
        this.module = livenessFaceTecModule;
        this.uploadDependenciesProvider = provider;
    }

    public static C4893x44fa237a create(LivenessFaceTecModule livenessFaceTecModule, Provider<LivenessFaceTecUploadDependenciesProvider> provider) {
        return new C4893x44fa237a(livenessFaceTecModule, provider);
    }

    public static ILivenessUploadDependenciesProvider providesLivenessCoreUploadDependenciesProvider(LivenessFaceTecModule livenessFaceTecModule, LivenessFaceTecUploadDependenciesProvider livenessFaceTecUploadDependenciesProvider) {
        return (ILivenessUploadDependenciesProvider) Preconditions.checkNotNullFromProvides(livenessFaceTecModule.providesLivenessCoreUploadDependenciesProvider(livenessFaceTecUploadDependenciesProvider));
    }

    @Override // javax.inject.Provider
    public ILivenessUploadDependenciesProvider get() {
        return providesLivenessCoreUploadDependenciesProvider(this.module, this.uploadDependenciesProvider.get());
    }
}
