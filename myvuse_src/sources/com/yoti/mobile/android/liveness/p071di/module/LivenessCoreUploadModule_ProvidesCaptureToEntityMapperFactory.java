package com.yoti.mobile.android.liveness.p071di.module;

import com.yoti.mobile.android.liveness.domain.model.ILivenessCaptureEntity;
import com.yoti.mobile.android.liveness.view.capture.model.ILivenessCapture;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessCoreUploadModule_ProvidesCaptureToEntityMapperFactory implements Factory<Mapper<ILivenessCapture, ILivenessCaptureEntity>> {
    private final LivenessCoreUploadModule module;

    public LivenessCoreUploadModule_ProvidesCaptureToEntityMapperFactory(LivenessCoreUploadModule livenessCoreUploadModule) {
        this.module = livenessCoreUploadModule;
    }

    public static LivenessCoreUploadModule_ProvidesCaptureToEntityMapperFactory create(LivenessCoreUploadModule livenessCoreUploadModule) {
        return new LivenessCoreUploadModule_ProvidesCaptureToEntityMapperFactory(livenessCoreUploadModule);
    }

    public static Mapper<ILivenessCapture, ILivenessCaptureEntity> providesCaptureToEntityMapper(LivenessCoreUploadModule livenessCoreUploadModule) {
        return (Mapper) Preconditions.checkNotNullFromProvides(livenessCoreUploadModule.providesCaptureToEntityMapper());
    }

    @Override // javax.inject.Provider
    public Mapper<ILivenessCapture, ILivenessCaptureEntity> get() {
        return providesCaptureToEntityMapper(this.module);
    }
}
