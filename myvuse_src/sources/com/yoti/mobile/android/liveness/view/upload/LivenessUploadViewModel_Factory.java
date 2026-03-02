package com.yoti.mobile.android.liveness.view.upload;

import com.yoti.mobile.android.liveness.domain.UploadLivenessCaptureInteractor;
import com.yoti.mobile.android.liveness.domain.model.ILivenessCaptureEntity;
import com.yoti.mobile.android.liveness.view.capture.model.ILivenessCapture;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessUploadViewModel_Factory implements Factory<LivenessUploadViewModel> {
    private final Provider<Mapper<Throwable, YdsFailure>> errorToFailureMapperProvider;
    private final Provider<LivenessUploadErrorToSessionStatusMapper> errorToSessionStatusTypeMapperProvider;
    private final Provider<Mapper<ILivenessCapture, ILivenessCaptureEntity>> livenessViewDataToEntityMapperProvider;
    private final Provider<SessionStatus> sessionStatusProvider;
    private final Provider<UploadLivenessCaptureInteractor> uploadLivenessCaptureInteractorProvider;

    public LivenessUploadViewModel_Factory(Provider<UploadLivenessCaptureInteractor> provider, Provider<Mapper<ILivenessCapture, ILivenessCaptureEntity>> provider2, Provider<SessionStatus> provider3, Provider<LivenessUploadErrorToSessionStatusMapper> provider4, Provider<Mapper<Throwable, YdsFailure>> provider5) {
        this.uploadLivenessCaptureInteractorProvider = provider;
        this.livenessViewDataToEntityMapperProvider = provider2;
        this.sessionStatusProvider = provider3;
        this.errorToSessionStatusTypeMapperProvider = provider4;
        this.errorToFailureMapperProvider = provider5;
    }

    public static LivenessUploadViewModel_Factory create(Provider<UploadLivenessCaptureInteractor> provider, Provider<Mapper<ILivenessCapture, ILivenessCaptureEntity>> provider2, Provider<SessionStatus> provider3, Provider<LivenessUploadErrorToSessionStatusMapper> provider4, Provider<Mapper<Throwable, YdsFailure>> provider5) {
        return new LivenessUploadViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static LivenessUploadViewModel newInstance(UploadLivenessCaptureInteractor uploadLivenessCaptureInteractor, Mapper<ILivenessCapture, ILivenessCaptureEntity> mapper, SessionStatus sessionStatus, LivenessUploadErrorToSessionStatusMapper livenessUploadErrorToSessionStatusMapper, Mapper<Throwable, YdsFailure> mapper2) {
        return new LivenessUploadViewModel(uploadLivenessCaptureInteractor, mapper, sessionStatus, livenessUploadErrorToSessionStatusMapper, mapper2);
    }

    @Override // javax.inject.Provider
    public LivenessUploadViewModel get() {
        return newInstance(this.uploadLivenessCaptureInteractorProvider.get(), this.livenessViewDataToEntityMapperProvider.get(), this.sessionStatusProvider.get(), this.errorToSessionStatusTypeMapperProvider.get(), this.errorToFailureMapperProvider.get());
    }
}
