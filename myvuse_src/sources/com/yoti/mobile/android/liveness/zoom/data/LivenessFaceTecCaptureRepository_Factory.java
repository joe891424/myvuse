package com.yoti.mobile.android.liveness.zoom.data;

import com.yoti.mobile.android.liveness.data.LivenessExceptionToEntityMapper;
import com.yoti.mobile.android.liveness.zoom.data.remote.LivenessFaceTecUploadService;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessFaceTecCaptureRepository_Factory implements Factory<LivenessFaceTecCaptureRepository> {
    private final Provider<LivenessExceptionToEntityMapper> livenessExceptionToEntityMapperProvider;
    private final Provider<LivenessFaceTecCaptureEntityToDataMapper> livenessFaceTecCaptureEntityToDataMapperProvider;
    private final Provider<LivenessFaceTecUploadService> uploadServiceProvider;

    public LivenessFaceTecCaptureRepository_Factory(Provider<LivenessFaceTecUploadService> provider, Provider<LivenessFaceTecCaptureEntityToDataMapper> provider2, Provider<LivenessExceptionToEntityMapper> provider3) {
        this.uploadServiceProvider = provider;
        this.livenessFaceTecCaptureEntityToDataMapperProvider = provider2;
        this.livenessExceptionToEntityMapperProvider = provider3;
    }

    public static LivenessFaceTecCaptureRepository_Factory create(Provider<LivenessFaceTecUploadService> provider, Provider<LivenessFaceTecCaptureEntityToDataMapper> provider2, Provider<LivenessExceptionToEntityMapper> provider3) {
        return new LivenessFaceTecCaptureRepository_Factory(provider, provider2, provider3);
    }

    public static LivenessFaceTecCaptureRepository newInstance(LivenessFaceTecUploadService livenessFaceTecUploadService, LivenessFaceTecCaptureEntityToDataMapper livenessFaceTecCaptureEntityToDataMapper, LivenessExceptionToEntityMapper livenessExceptionToEntityMapper) {
        return new LivenessFaceTecCaptureRepository(livenessFaceTecUploadService, livenessFaceTecCaptureEntityToDataMapper, livenessExceptionToEntityMapper);
    }

    @Override // javax.inject.Provider
    public LivenessFaceTecCaptureRepository get() {
        return newInstance(this.uploadServiceProvider.get(), this.livenessFaceTecCaptureEntityToDataMapperProvider.get(), this.livenessExceptionToEntityMapperProvider.get());
    }
}
