package com.yoti.mobile.android.liveness.view.upload;

import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessUploadErrorToFailureMapper_Factory implements Factory<LivenessUploadErrorToFailureMapper> {
    private final Provider<ExceptionToFailureMapper> exceptionToFailureMapperProvider;

    public LivenessUploadErrorToFailureMapper_Factory(Provider<ExceptionToFailureMapper> provider) {
        this.exceptionToFailureMapperProvider = provider;
    }

    public static LivenessUploadErrorToFailureMapper_Factory create(Provider<ExceptionToFailureMapper> provider) {
        return new LivenessUploadErrorToFailureMapper_Factory(provider);
    }

    public static LivenessUploadErrorToFailureMapper newInstance(ExceptionToFailureMapper exceptionToFailureMapper) {
        return new LivenessUploadErrorToFailureMapper(exceptionToFailureMapper);
    }

    @Override // javax.inject.Provider
    public LivenessUploadErrorToFailureMapper get() {
        return newInstance(this.exceptionToFailureMapperProvider.get());
    }
}
