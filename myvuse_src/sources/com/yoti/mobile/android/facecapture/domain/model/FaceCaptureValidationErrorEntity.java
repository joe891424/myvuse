package com.yoti.mobile.android.facecapture.domain.model;

import com.yoti.mobile.android.liveness.domain.model.LivenessValidationError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/domain/model/FaceCaptureValidationErrorEntity;", "Lcom/yoti/mobile/android/liveness/domain/model/LivenessValidationError;", "retriesRemaining", "", "error", "", "_code", "Lcom/yoti/mobile/android/facecapture/domain/model/FaceCaptureValidationErrorCodeEntity;", "(ILjava/lang/Throwable;Lcom/yoti/mobile/android/facecapture/domain/model/FaceCaptureValidationErrorCodeEntity;)V", "code", "getCode", "()Lcom/yoti/mobile/android/facecapture/domain/model/FaceCaptureValidationErrorCodeEntity;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceCaptureValidationErrorEntity extends LivenessValidationError {
    private final FaceCaptureValidationErrorCodeEntity code;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaceCaptureValidationErrorEntity(int i, Throwable error, FaceCaptureValidationErrorCodeEntity faceCaptureValidationErrorCodeEntity) {
        super(i, error);
        Intrinsics.checkNotNullParameter(error, "error");
        this.code = faceCaptureValidationErrorCodeEntity == null ? FaceCaptureValidationErrorCodeEntity.FACE_NOT_FOUND : faceCaptureValidationErrorCodeEntity;
    }

    public final FaceCaptureValidationErrorCodeEntity getCode() {
        return this.code;
    }
}
