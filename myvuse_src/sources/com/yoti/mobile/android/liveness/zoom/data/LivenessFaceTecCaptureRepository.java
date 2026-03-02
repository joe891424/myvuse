package com.yoti.mobile.android.liveness.zoom.data;

import com.yoti.mobile.android.liveness.data.LivenessExceptionToEntityMapper;
import com.yoti.mobile.android.liveness.domain.ILivenessCaptureRepository;
import com.yoti.mobile.android.liveness.zoom.data.remote.LivenessFaceTecUploadService;
import com.yoti.mobile.android.liveness.zoom.data.remote.model.LivenessFaceTecCapture;
import com.yoti.mobile.android.liveness.zoom.domain.model.LivenessFaceTecCaptureEntity;
import com.yoti.mobile.android.yotidocs.common.extension.FlowableKt;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/data/LivenessFaceTecCaptureRepository;", "Lcom/yoti/mobile/android/liveness/domain/ILivenessCaptureRepository;", "Lcom/yoti/mobile/android/liveness/zoom/domain/model/LivenessFaceTecCaptureEntity;", "uploadService", "Lcom/yoti/mobile/android/liveness/zoom/data/remote/LivenessFaceTecUploadService;", "livenessFaceTecCaptureEntityToDataMapper", "Lcom/yoti/mobile/android/liveness/zoom/data/LivenessFaceTecCaptureEntityToDataMapper;", "livenessExceptionToEntityMapper", "Lcom/yoti/mobile/android/liveness/data/LivenessExceptionToEntityMapper;", "(Lcom/yoti/mobile/android/liveness/zoom/data/remote/LivenessFaceTecUploadService;Lcom/yoti/mobile/android/liveness/zoom/data/LivenessFaceTecCaptureEntityToDataMapper;Lcom/yoti/mobile/android/liveness/data/LivenessExceptionToEntityMapper;)V", "upload", "Lio/reactivex/Flowable;", "", "livenessCapture", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LivenessFaceTecCaptureRepository implements ILivenessCaptureRepository<LivenessFaceTecCaptureEntity> {
    private final LivenessExceptionToEntityMapper livenessExceptionToEntityMapper;
    private final LivenessFaceTecCaptureEntityToDataMapper livenessFaceTecCaptureEntityToDataMapper;
    private final LivenessFaceTecUploadService uploadService;

    @Inject
    public LivenessFaceTecCaptureRepository(LivenessFaceTecUploadService uploadService, LivenessFaceTecCaptureEntityToDataMapper livenessFaceTecCaptureEntityToDataMapper, LivenessExceptionToEntityMapper livenessExceptionToEntityMapper) {
        Intrinsics.checkNotNullParameter(uploadService, "uploadService");
        Intrinsics.checkNotNullParameter(livenessFaceTecCaptureEntityToDataMapper, "livenessFaceTecCaptureEntityToDataMapper");
        Intrinsics.checkNotNullParameter(livenessExceptionToEntityMapper, "livenessExceptionToEntityMapper");
        this.uploadService = uploadService;
        this.livenessFaceTecCaptureEntityToDataMapper = livenessFaceTecCaptureEntityToDataMapper;
        this.livenessExceptionToEntityMapper = livenessExceptionToEntityMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: upload$lambda-0, reason: not valid java name */
    public static final LivenessFaceTecCapture m6876upload$lambda0(LivenessFaceTecCaptureRepository this$0, LivenessFaceTecCaptureEntity livenessCapture) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(livenessCapture, "$livenessCapture");
        return this$0.livenessFaceTecCaptureEntityToDataMapper.map(livenessCapture);
    }

    @Override // com.yoti.mobile.android.liveness.domain.ILivenessCaptureRepository
    public Flowable<Double> upload(final LivenessFaceTecCaptureEntity livenessCapture) {
        Intrinsics.checkNotNullParameter(livenessCapture, "livenessCapture");
        Single singleFromCallable = Single.fromCallable(new Callable() { // from class: com.yoti.mobile.android.liveness.zoom.data.LivenessFaceTecCaptureRepository$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LivenessFaceTecCaptureRepository.m6876upload$lambda0(this.f$0, livenessCapture);
            }
        });
        final LivenessFaceTecUploadService livenessFaceTecUploadService = this.uploadService;
        Flowable flowableFlatMapPublisher = singleFromCallable.flatMapPublisher(new Function() { // from class: com.yoti.mobile.android.liveness.zoom.data.LivenessFaceTecCaptureRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return livenessFaceTecUploadService.execute((LivenessFaceTecCapture) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flowableFlatMapPublisher, "fromCallable {\n         …r(uploadService::execute)");
        return FlowableKt.onErrorMapToErrorEntity(flowableFlatMapPublisher, this.livenessExceptionToEntityMapper);
    }
}
