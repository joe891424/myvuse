package com.yoti.mobile.android.capture.face.p048ui.models.face;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FaceDetectionValidatorResult.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationResult;", "", "()V", "FaceEyesClosed", "FaceNotStraight", "FaceValid", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationResult$FaceNotStraight;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationResult$FaceEyesClosed;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationResult$FaceValid;", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
public abstract class FaceValidationResult {

    /* JADX INFO: compiled from: FaceDetectionValidatorResult.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationResult$FaceNotStraight;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationResult;", "()V", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
    public static final class FaceNotStraight extends FaceValidationResult {
        public static final FaceNotStraight INSTANCE = new FaceNotStraight();

        private FaceNotStraight() {
            super(null);
        }
    }

    private FaceValidationResult() {
    }

    public /* synthetic */ FaceValidationResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: FaceDetectionValidatorResult.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationResult$FaceEyesClosed;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationResult;", "()V", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
    public static final class FaceEyesClosed extends FaceValidationResult {
        public static final FaceEyesClosed INSTANCE = new FaceEyesClosed();

        private FaceEyesClosed() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FaceDetectionValidatorResult.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationResult$FaceValid;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationResult;", "()V", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
    public static final class FaceValid extends FaceValidationResult {
        public static final FaceValid INSTANCE = new FaceValid();

        private FaceValid() {
            super(null);
        }
    }
}
