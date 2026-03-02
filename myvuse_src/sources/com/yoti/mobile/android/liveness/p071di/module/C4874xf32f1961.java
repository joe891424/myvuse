package com.yoti.mobile.android.liveness.p071di.module;

import com.yoti.mobile.android.liveness.domain.model.ILivenessResourceEntity;
import com.yoti.mobile.android.liveness.view.navigation.ILivenessEducationalNavigatorProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: renamed from: com.yoti.mobile.android.liveness.di.module.LivenessCoreEducationalModule_ProvidesEducationalNavigatorProviderFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4874xf32f1961 implements Factory<ILivenessEducationalNavigatorProvider<ILivenessResourceEntity>> {
    private final LivenessCoreEducationalModule module;

    public C4874xf32f1961(LivenessCoreEducationalModule livenessCoreEducationalModule) {
        this.module = livenessCoreEducationalModule;
    }

    public static C4874xf32f1961 create(LivenessCoreEducationalModule livenessCoreEducationalModule) {
        return new C4874xf32f1961(livenessCoreEducationalModule);
    }

    public static ILivenessEducationalNavigatorProvider<ILivenessResourceEntity> providesEducationalNavigatorProvider(LivenessCoreEducationalModule livenessCoreEducationalModule) {
        return (ILivenessEducationalNavigatorProvider) Preconditions.checkNotNullFromProvides(livenessCoreEducationalModule.providesEducationalNavigatorProvider());
    }

    @Override // javax.inject.Provider
    public ILivenessEducationalNavigatorProvider<ILivenessResourceEntity> get() {
        return providesEducationalNavigatorProvider(this.module);
    }
}
