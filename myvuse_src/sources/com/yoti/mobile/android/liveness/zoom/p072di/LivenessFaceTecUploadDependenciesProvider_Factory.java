package com.yoti.mobile.android.liveness.zoom.p072di;

import com.yoti.mobile.android.liveness.view.upload.LivenessUploadErrorToFailureMapper;
import com.yoti.mobile.android.liveness.zoom.data.LivenessFaceTecCaptureRepository;
import com.yoti.mobile.android.liveness.zoom.view.navigation.LivenessFaceTecUploadNavigatorProvider;
import com.yoti.mobile.android.liveness.zoom.view.upload.LivenessFaceTecCaptureViewDataToEntityMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessFaceTecUploadDependenciesProvider_Factory implements Factory<LivenessFaceTecUploadDependenciesProvider> {
    private final Provider<LivenessFaceTecCaptureRepository> livenessFaceTecCaptureRepositoryProvider;
    private final Provider<LivenessFaceTecCaptureViewDataToEntityMapper> livenessFaceTecCaptureToEntityMapperProvider;
    private final Provider<LivenessFaceTecUploadNavigatorProvider> livenessFaceTecUploadNavigatorProvider;
    private final Provider<LivenessUploadErrorToFailureMapper> livenessUploadErrorToFailureMapperProvider;

    public LivenessFaceTecUploadDependenciesProvider_Factory(Provider<LivenessFaceTecCaptureRepository> provider, Provider<LivenessFaceTecUploadNavigatorProvider> provider2, Provider<LivenessFaceTecCaptureViewDataToEntityMapper> provider3, Provider<LivenessUploadErrorToFailureMapper> provider4) {
        this.livenessFaceTecCaptureRepositoryProvider = provider;
        this.livenessFaceTecUploadNavigatorProvider = provider2;
        this.livenessFaceTecCaptureToEntityMapperProvider = provider3;
        this.livenessUploadErrorToFailureMapperProvider = provider4;
    }

    public static LivenessFaceTecUploadDependenciesProvider_Factory create(Provider<LivenessFaceTecCaptureRepository> provider, Provider<LivenessFaceTecUploadNavigatorProvider> provider2, Provider<LivenessFaceTecCaptureViewDataToEntityMapper> provider3, Provider<LivenessUploadErrorToFailureMapper> provider4) {
        return new LivenessFaceTecUploadDependenciesProvider_Factory(provider, provider2, provider3, provider4);
    }

    public static LivenessFaceTecUploadDependenciesProvider newInstance(LivenessFaceTecCaptureRepository livenessFaceTecCaptureRepository, LivenessFaceTecUploadNavigatorProvider livenessFaceTecUploadNavigatorProvider, LivenessFaceTecCaptureViewDataToEntityMapper livenessFaceTecCaptureViewDataToEntityMapper, LivenessUploadErrorToFailureMapper livenessUploadErrorToFailureMapper) {
        return new LivenessFaceTecUploadDependenciesProvider(livenessFaceTecCaptureRepository, livenessFaceTecUploadNavigatorProvider, livenessFaceTecCaptureViewDataToEntityMapper, livenessUploadErrorToFailureMapper);
    }

    @Override // javax.inject.Provider
    public LivenessFaceTecUploadDependenciesProvider get() {
        return newInstance(this.livenessFaceTecCaptureRepositoryProvider.get(), this.livenessFaceTecUploadNavigatorProvider.get(), this.livenessFaceTecCaptureToEntityMapperProvider.get(), this.livenessUploadErrorToFailureMapperProvider.get());
    }
}
