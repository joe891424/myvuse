package com.yoti.mobile.android.capture.face.p048ui.models.face;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FaceDetectionValidatorResult.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceListValidationResult;", "", "()V", "FaceDetected", "MultipleFacesDetected", "NoFaceDetected", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceListValidationResult$NoFaceDetected;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceListValidationResult$MultipleFacesDetected;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceListValidationResult$FaceDetected;", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
public abstract class FaceListValidationResult {

    /* JADX INFO: compiled from: FaceDetectionValidatorResult.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceListValidationResult$NoFaceDetected;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceListValidationResult;", "()V", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
    public static final class NoFaceDetected extends FaceListValidationResult {
        public static final NoFaceDetected INSTANCE = new NoFaceDetected();

        private NoFaceDetected() {
            super(null);
        }
    }

    private FaceListValidationResult() {
    }

    public /* synthetic */ FaceListValidationResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: FaceDetectionValidatorResult.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceListValidationResult$MultipleFacesDetected;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceListValidationResult;", "()V", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
    public static final class MultipleFacesDetected extends FaceListValidationResult {
        public static final MultipleFacesDetected INSTANCE = new MultipleFacesDetected();

        private MultipleFacesDetected() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FaceDetectionValidatorResult.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceListValidationResult$FaceDetected;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceListValidationResult;", "()V", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
    public static final class FaceDetected extends FaceListValidationResult {
        public static final FaceDetected INSTANCE = new FaceDetected();

        private FaceDetected() {
            super(null);
        }
    }
}
