package com.yoti.mobile.android.liveness.p071di.module;

import com.yoti.mobile.android.liveness.domain.ILivenessResourceCreationRepository;
import com.yoti.mobile.android.liveness.domain.model.ILivenessResourceEntity;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: renamed from: com.yoti.mobile.android.liveness.di.module.LivenessCoreEducationalModule_ProvidesResourceCreationRepositoryFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4877x599c81bf implements Factory<ILivenessResourceCreationRepository<ILivenessResourceEntity>> {
    private final LivenessCoreEducationalModule module;

    public C4877x599c81bf(LivenessCoreEducationalModule livenessCoreEducationalModule) {
        this.module = livenessCoreEducationalModule;
    }

    public static C4877x599c81bf create(LivenessCoreEducationalModule livenessCoreEducationalModule) {
        return new C4877x599c81bf(livenessCoreEducationalModule);
    }

    public static ILivenessResourceCreationRepository<ILivenessResourceEntity> providesResourceCreationRepository(LivenessCoreEducationalModule livenessCoreEducationalModule) {
        return (ILivenessResourceCreationRepository) Preconditions.checkNotNullFromProvides(livenessCoreEducationalModule.providesResourceCreationRepository());
    }

    @Override // javax.inject.Provider
    public ILivenessResourceCreationRepository<ILivenessResourceEntity> get() {
        return providesResourceCreationRepository(this.module);
    }
}
