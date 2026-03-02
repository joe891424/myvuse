package com.yoti.mobile.android.facecapture.view.capture.mapper;

import com.yoti.mobile.android.capture.face.p048ui.models.face.FaceCaptureInvalid;
import com.yoti.mobile.android.capture.face.p048ui.models.face.FaceCaptureResult;
import com.yoti.mobile.android.capture.face.p048ui.models.face.FaceCaptureState;
import com.yoti.mobile.android.commons.image.ImageBuffer;
import com.yoti.mobile.android.facecapture.view.capture.model.Event;
import com.yoti.mobile.android.facecapture.view.capture.model.ScanFeedbackType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u001c\u0010\u0003\u001a\u00020\u0004*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u001c\u0010\u0003\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\f"}, m5598d2 = {"toInvalidFrameReason", "Lcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedbackType;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid;", "toStateMachineEvent", "Lcom/yoti/mobile/android/facecapture/view/capture/model/Event;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureResult;", "lightLevel", "", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureState$InvalidFace;", "original", "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureState$ValidFace;", "facecapture_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ViewEventToStateMachineMapperKt {
    private static final ScanFeedbackType toInvalidFrameReason(FaceCaptureInvalid faceCaptureInvalid) {
        if (Intrinsics.areEqual(faceCaptureInvalid, FaceCaptureInvalid.AnalysisError.INSTANCE)) {
            return ScanFeedbackType.ANALYSIS_ERROR;
        }
        if (Intrinsics.areEqual(faceCaptureInvalid, FaceCaptureInvalid.MultipleFacesDetected.INSTANCE)) {
            return ScanFeedbackType.MULTIPLE_FACES;
        }
        if (Intrinsics.areEqual(faceCaptureInvalid, FaceCaptureInvalid.NoFaceDetected.INSTANCE)) {
            return ScanFeedbackType.NO_FACE;
        }
        if (Intrinsics.areEqual(faceCaptureInvalid, FaceCaptureInvalid.FaceTooSmall.INSTANCE)) {
            return ScanFeedbackType.FACE_TOO_SMALL;
        }
        if (Intrinsics.areEqual(faceCaptureInvalid, FaceCaptureInvalid.FaceTooBig.INSTANCE)) {
            return ScanFeedbackType.FACE_TOO_BIG;
        }
        if (Intrinsics.areEqual(faceCaptureInvalid, FaceCaptureInvalid.FaceNotCentered.INSTANCE)) {
            return ScanFeedbackType.FACE_NOT_CENTERED;
        }
        if (Intrinsics.areEqual(faceCaptureInvalid, FaceCaptureInvalid.FaceNotStraight.INSTANCE)) {
            return ScanFeedbackType.FACE_NOT_STRAIGHT;
        }
        if (Intrinsics.areEqual(faceCaptureInvalid, FaceCaptureInvalid.FaceNotStable.INSTANCE)) {
            return ScanFeedbackType.FACE_NOT_STABLE;
        }
        if (Intrinsics.areEqual(faceCaptureInvalid, FaceCaptureInvalid.EyesClosed.INSTANCE)) {
            return ScanFeedbackType.EYES_NOT_OPEN;
        }
        if (Intrinsics.areEqual(faceCaptureInvalid, FaceCaptureInvalid.EnvironmentTooDark.INSTANCE)) {
            return ScanFeedbackType.ENVIRONMENT_TOO_DARK;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Event toStateMachineEvent(FaceCaptureResult faceCaptureResult, float f) {
        FaceCaptureState state = faceCaptureResult.getState();
        if (state instanceof FaceCaptureState.ValidFace) {
            return toStateMachineEvent((FaceCaptureState.ValidFace) faceCaptureResult.getState(), faceCaptureResult.getOriginalImage(), f);
        }
        if (state instanceof FaceCaptureState.InvalidFace) {
            return toStateMachineEvent((FaceCaptureState.InvalidFace) faceCaptureResult.getState(), faceCaptureResult.getOriginalImage(), f);
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final Event toStateMachineEvent(FaceCaptureState.ValidFace validFace, ImageBuffer imageBuffer, float f) {
        return new Event.OnValidFrame(validFace.getCroppedImage(), imageBuffer, f);
    }

    private static final Event toStateMachineEvent(FaceCaptureState.InvalidFace invalidFace, ImageBuffer imageBuffer, float f) {
        return new Event.OnInvalidFrame(toInvalidFrameReason(invalidFace.getCause()), imageBuffer, f);
    }
}
