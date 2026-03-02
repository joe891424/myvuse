package com.yoti.mobile.android.facecapture.data;

import com.yoti.mobile.android.facecapture.data.remote.FaceCaptureUploadController;
import com.yoti.mobile.android.facecapture.data.remote.model.FaceCaptureData;
import com.yoti.mobile.android.facecapture.domain.model.FaceCaptureEntity;
import com.yoti.mobile.android.liveness.domain.ILivenessCaptureRepository;
import com.yoti.mobile.android.yotidocs.common.extension.FlowableKt;
import io.reactivex.Flowable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/data/FaceCaptureRepository;", "Lcom/yoti/mobile/android/liveness/domain/ILivenessCaptureRepository;", "Lcom/yoti/mobile/android/facecapture/domain/model/FaceCaptureEntity;", "faceCaptureUploadController", "Lcom/yoti/mobile/android/facecapture/data/remote/FaceCaptureUploadController;", "faceCaptureValidationExceptionToEntityMapper", "Lcom/yoti/mobile/android/facecapture/data/FaceCaptureValidationExceptionToEntityMapper;", "(Lcom/yoti/mobile/android/facecapture/data/remote/FaceCaptureUploadController;Lcom/yoti/mobile/android/facecapture/data/FaceCaptureValidationExceptionToEntityMapper;)V", "upload", "Lio/reactivex/Flowable;", "", "livenessCapture", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceCaptureRepository implements ILivenessCaptureRepository<FaceCaptureEntity> {
    private final FaceCaptureUploadController faceCaptureUploadController;
    private final FaceCaptureValidationExceptionToEntityMapper faceCaptureValidationExceptionToEntityMapper;

    @Inject
    public FaceCaptureRepository(FaceCaptureUploadController faceCaptureUploadController, FaceCaptureValidationExceptionToEntityMapper faceCaptureValidationExceptionToEntityMapper) {
        Intrinsics.checkNotNullParameter(faceCaptureUploadController, "faceCaptureUploadController");
        Intrinsics.checkNotNullParameter(faceCaptureValidationExceptionToEntityMapper, "faceCaptureValidationExceptionToEntityMapper");
        this.faceCaptureUploadController = faceCaptureUploadController;
        this.faceCaptureValidationExceptionToEntityMapper = faceCaptureValidationExceptionToEntityMapper;
    }

    @Override // com.yoti.mobile.android.liveness.domain.ILivenessCaptureRepository
    public Flowable<Double> upload(FaceCaptureEntity livenessCapture) {
        Intrinsics.checkNotNullParameter(livenessCapture, "livenessCapture");
        return FlowableKt.onErrorMapToErrorEntity(this.faceCaptureUploadController.execute(new FaceCaptureData(livenessCapture.getResourceId(), livenessCapture.getCapture())), this.faceCaptureValidationExceptionToEntityMapper);
    }
}
