package com.yoti.mobile.android.liveness.p071di.module;

import com.yoti.mobile.android.liveness.view.navigation.ILivenessUploadNavigatorProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessCoreUploadModule_ProvidesUploadNavigatorProviderFactory implements Factory<ILivenessUploadNavigatorProvider> {
    private final LivenessCoreUploadModule module;

    public LivenessCoreUploadModule_ProvidesUploadNavigatorProviderFactory(LivenessCoreUploadModule livenessCoreUploadModule) {
        this.module = livenessCoreUploadModule;
    }

    public static LivenessCoreUploadModule_ProvidesUploadNavigatorProviderFactory create(LivenessCoreUploadModule livenessCoreUploadModule) {
        return new LivenessCoreUploadModule_ProvidesUploadNavigatorProviderFactory(livenessCoreUploadModule);
    }

    public static ILivenessUploadNavigatorProvider providesUploadNavigatorProvider(LivenessCoreUploadModule livenessCoreUploadModule) {
        return (ILivenessUploadNavigatorProvider) Preconditions.checkNotNullFromProvides(livenessCoreUploadModule.providesUploadNavigatorProvider());
    }

    @Override // javax.inject.Provider
    public ILivenessUploadNavigatorProvider get() {
        return providesUploadNavigatorProvider(this.module);
    }
}
