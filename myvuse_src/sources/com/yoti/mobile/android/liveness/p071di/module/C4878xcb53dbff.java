package com.yoti.mobile.android.liveness.p071di.module;

import com.yoti.mobile.android.liveness.domain.ILivenessCaptureRepository;
import com.yoti.mobile.android.liveness.domain.model.ILivenessCaptureEntity;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: renamed from: com.yoti.mobile.android.liveness.di.module.LivenessCoreUploadModule_ProvidesLivenessCaptureRepositoryFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4878xcb53dbff implements Factory<ILivenessCaptureRepository<ILivenessCaptureEntity>> {
    private final LivenessCoreUploadModule module;

    public C4878xcb53dbff(LivenessCoreUploadModule livenessCoreUploadModule) {
        this.module = livenessCoreUploadModule;
    }

    public static C4878xcb53dbff create(LivenessCoreUploadModule livenessCoreUploadModule) {
        return new C4878xcb53dbff(livenessCoreUploadModule);
    }

    public static ILivenessCaptureRepository<ILivenessCaptureEntity> providesLivenessCaptureRepository(LivenessCoreUploadModule livenessCoreUploadModule) {
        return (ILivenessCaptureRepository) Preconditions.checkNotNullFromProvides(livenessCoreUploadModule.providesLivenessCaptureRepository());
    }

    @Override // javax.inject.Provider
    public ILivenessCaptureRepository<ILivenessCaptureEntity> get() {
        return providesLivenessCaptureRepository(this.module);
    }
}
