package com.yoti.mobile.android.facecapture.view.educational;

import com.yoti.mobile.android.facecapture.view.educational.FaceCaptureGuidelinesViewData;
import com.yoti.mobile.android.facecapture.view.upload.FaceCaptureUploadValidationFailure;
import com.yoti.mobile.android.liveness.view.educational.DefaultLivenessGuidelinesViewData;
import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/educational/FaceCaptureGuidelinesViewDataFactory;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;", "Lcom/yoti/mobile/android/facecapture/view/upload/FaceCaptureUploadValidationFailure;", "()V", "create", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData;", "failureType", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceCaptureGuidelinesViewDataFactory implements LivenessGuidelinesViewData.Factory<FaceCaptureUploadValidationFailure> {
    @Inject
    public FaceCaptureGuidelinesViewDataFactory() {
    }

    @Override // com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData.Factory
    public LivenessGuidelinesViewData create(FaceCaptureUploadValidationFailure failureType) {
        if (Intrinsics.areEqual(failureType, FaceCaptureUploadValidationFailure.FaceNotFound.INSTANCE)) {
            return FaceCaptureGuidelinesViewData.FaceNotFound.INSTANCE;
        }
        if (Intrinsics.areEqual(failureType, FaceCaptureUploadValidationFailure.MultipleFaces.INSTANCE)) {
            return FaceCaptureGuidelinesViewData.MultipleFaces.INSTANCE;
        }
        if (Intrinsics.areEqual(failureType, FaceCaptureUploadValidationFailure.FacePosition.INSTANCE)) {
            return FaceCaptureGuidelinesViewData.FacePosition.INSTANCE;
        }
        if (Intrinsics.areEqual(failureType, FaceCaptureUploadValidationFailure.ImageTooBright.INSTANCE)) {
            return FaceCaptureGuidelinesViewData.ImageTooBright.INSTANCE;
        }
        if (Intrinsics.areEqual(failureType, FaceCaptureUploadValidationFailure.ImageTooDark.INSTANCE)) {
            return FaceCaptureGuidelinesViewData.ImageTooDark.INSTANCE;
        }
        if (failureType == null) {
            return DefaultLivenessGuidelinesViewData.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
