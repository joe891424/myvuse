package com.yoti.mobile.android.liveness.zoom.p072di;

import com.yoti.mobile.android.liveness.domain.ILivenessCaptureRepository;
import com.yoti.mobile.android.liveness.domain.model.ILivenessCaptureEntity;
import com.yoti.mobile.android.liveness.p071di.ILivenessUploadDependenciesProvider;
import com.yoti.mobile.android.liveness.view.capture.model.ILivenessCapture;
import com.yoti.mobile.android.liveness.view.navigation.ILivenessUploadNavigatorProvider;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadErrorToFailureMapper;
import com.yoti.mobile.android.liveness.zoom.data.LivenessFaceTecCaptureRepository;
import com.yoti.mobile.android.liveness.zoom.view.navigation.LivenessFaceTecUploadNavigatorProvider;
import com.yoti.mobile.android.liveness.zoom.view.upload.LivenessFaceTecCaptureViewDataToEntityMapper;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/di/LivenessFaceTecUploadDependenciesProvider;", "Lcom/yoti/mobile/android/liveness/di/ILivenessUploadDependenciesProvider;", "livenessFaceTecCaptureRepository", "Lcom/yoti/mobile/android/liveness/zoom/data/LivenessFaceTecCaptureRepository;", "livenessFaceTecUploadNavigatorProvider", "Lcom/yoti/mobile/android/liveness/zoom/view/navigation/LivenessFaceTecUploadNavigatorProvider;", "livenessFaceTecCaptureToEntityMapper", "Lcom/yoti/mobile/android/liveness/zoom/view/upload/LivenessFaceTecCaptureViewDataToEntityMapper;", "livenessUploadErrorToFailureMapper", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorToFailureMapper;", "(Lcom/yoti/mobile/android/liveness/zoom/data/LivenessFaceTecCaptureRepository;Lcom/yoti/mobile/android/liveness/zoom/view/navigation/LivenessFaceTecUploadNavigatorProvider;Lcom/yoti/mobile/android/liveness/zoom/view/upload/LivenessFaceTecCaptureViewDataToEntityMapper;Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorToFailureMapper;)V", "captureToEntityMapper", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/liveness/view/capture/model/ILivenessCapture;", "Lcom/yoti/mobile/android/liveness/domain/model/ILivenessCaptureEntity;", "getCaptureToEntityMapper", "()Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "livenessCaptureRepository", "Lcom/yoti/mobile/android/liveness/domain/ILivenessCaptureRepository;", "getLivenessCaptureRepository", "()Lcom/yoti/mobile/android/liveness/domain/ILivenessCaptureRepository;", "uploadErrorToFailureMapper", "", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "getUploadErrorToFailureMapper", "uploadNavigatorProvider", "Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessUploadNavigatorProvider;", "getUploadNavigatorProvider", "()Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessUploadNavigatorProvider;", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LivenessFaceTecUploadDependenciesProvider implements ILivenessUploadDependenciesProvider {
    private final Mapper<ILivenessCapture, ILivenessCaptureEntity> captureToEntityMapper;
    private final ILivenessCaptureRepository<ILivenessCaptureEntity> livenessCaptureRepository;
    private final Mapper<Throwable, YdsFailure> uploadErrorToFailureMapper;
    private final ILivenessUploadNavigatorProvider uploadNavigatorProvider;

    @Inject
    public LivenessFaceTecUploadDependenciesProvider(LivenessFaceTecCaptureRepository livenessFaceTecCaptureRepository, LivenessFaceTecUploadNavigatorProvider livenessFaceTecUploadNavigatorProvider, LivenessFaceTecCaptureViewDataToEntityMapper livenessFaceTecCaptureToEntityMapper, LivenessUploadErrorToFailureMapper livenessUploadErrorToFailureMapper) {
        Intrinsics.checkNotNullParameter(livenessFaceTecCaptureRepository, "livenessFaceTecCaptureRepository");
        Intrinsics.checkNotNullParameter(livenessFaceTecUploadNavigatorProvider, "livenessFaceTecUploadNavigatorProvider");
        Intrinsics.checkNotNullParameter(livenessFaceTecCaptureToEntityMapper, "livenessFaceTecCaptureToEntityMapper");
        Intrinsics.checkNotNullParameter(livenessUploadErrorToFailureMapper, "livenessUploadErrorToFailureMapper");
        this.captureToEntityMapper = livenessFaceTecCaptureToEntityMapper;
        this.uploadNavigatorProvider = livenessFaceTecUploadNavigatorProvider;
        this.livenessCaptureRepository = livenessFaceTecCaptureRepository;
        this.uploadErrorToFailureMapper = livenessUploadErrorToFailureMapper;
    }

    @Override // com.yoti.mobile.android.liveness.p071di.ILivenessUploadDependenciesProvider
    public Mapper<ILivenessCapture, ILivenessCaptureEntity> getCaptureToEntityMapper() {
        return this.captureToEntityMapper;
    }

    @Override // com.yoti.mobile.android.liveness.p071di.ILivenessUploadDependenciesProvider
    public ILivenessCaptureRepository<ILivenessCaptureEntity> getLivenessCaptureRepository() {
        return this.livenessCaptureRepository;
    }

    @Override // com.yoti.mobile.android.liveness.p071di.ILivenessUploadDependenciesProvider
    public Mapper<Throwable, YdsFailure> getUploadErrorToFailureMapper() {
        return this.uploadErrorToFailureMapper;
    }

    @Override // com.yoti.mobile.android.liveness.p071di.ILivenessUploadDependenciesProvider
    public ILivenessUploadNavigatorProvider getUploadNavigatorProvider() {
        return this.uploadNavigatorProvider;
    }
}
