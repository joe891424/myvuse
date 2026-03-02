package com.yoti.mobile.android.liveness.zoom.view.capture;

import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessFaceTecCaptureViewModel_Factory implements Factory<LivenessFaceTecCaptureViewModel> {
    private final Provider<FaceTecErrorToFailureMapper> errorToFailureMapperProvider;
    private final Provider<FaceTecErrorToSessionStatusTypeMapper> errorToSessionStatusTypeMapperProvider;
    private final Provider<IFaceTecResultProcessor> faceTecResultProcessorProvider;
    private final Provider<SessionStatus> sessionStatusProvider;

    public LivenessFaceTecCaptureViewModel_Factory(Provider<SessionStatus> provider, Provider<IFaceTecResultProcessor> provider2, Provider<FaceTecErrorToFailureMapper> provider3, Provider<FaceTecErrorToSessionStatusTypeMapper> provider4) {
        this.sessionStatusProvider = provider;
        this.faceTecResultProcessorProvider = provider2;
        this.errorToFailureMapperProvider = provider3;
        this.errorToSessionStatusTypeMapperProvider = provider4;
    }

    public static LivenessFaceTecCaptureViewModel_Factory create(Provider<SessionStatus> provider, Provider<IFaceTecResultProcessor> provider2, Provider<FaceTecErrorToFailureMapper> provider3, Provider<FaceTecErrorToSessionStatusTypeMapper> provider4) {
        return new LivenessFaceTecCaptureViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static LivenessFaceTecCaptureViewModel newInstance(SessionStatus sessionStatus, IFaceTecResultProcessor iFaceTecResultProcessor, FaceTecErrorToFailureMapper faceTecErrorToFailureMapper, FaceTecErrorToSessionStatusTypeMapper faceTecErrorToSessionStatusTypeMapper) {
        return new LivenessFaceTecCaptureViewModel(sessionStatus, iFaceTecResultProcessor, faceTecErrorToFailureMapper, faceTecErrorToSessionStatusTypeMapper);
    }

    @Override // javax.inject.Provider
    public LivenessFaceTecCaptureViewModel get() {
        return newInstance(this.sessionStatusProvider.get(), this.faceTecResultProcessorProvider.get(), this.errorToFailureMapperProvider.get(), this.errorToSessionStatusTypeMapperProvider.get());
    }
}
