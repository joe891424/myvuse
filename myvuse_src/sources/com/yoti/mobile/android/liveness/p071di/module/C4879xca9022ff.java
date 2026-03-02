package com.yoti.mobile.android.liveness.p071di.module;

import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: renamed from: com.yoti.mobile.android.liveness.di.module.LivenessCoreUploadModule_ProvidesUploadErrorToFailureMapperFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4879xca9022ff implements Factory<Mapper<Throwable, YdsFailure>> {
    private final LivenessCoreUploadModule module;

    public C4879xca9022ff(LivenessCoreUploadModule livenessCoreUploadModule) {
        this.module = livenessCoreUploadModule;
    }

    public static C4879xca9022ff create(LivenessCoreUploadModule livenessCoreUploadModule) {
        return new C4879xca9022ff(livenessCoreUploadModule);
    }

    public static Mapper<Throwable, YdsFailure> providesUploadErrorToFailureMapper(LivenessCoreUploadModule livenessCoreUploadModule) {
        return (Mapper) Preconditions.checkNotNullFromProvides(livenessCoreUploadModule.providesUploadErrorToFailureMapper());
    }

    @Override // javax.inject.Provider
    public Mapper<Throwable, YdsFailure> get() {
        return providesUploadErrorToFailureMapper(this.module);
    }
}
