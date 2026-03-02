package com.yoti.mobile.android.capture.face.p048ui.models.face;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FaceValidationState.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState;", "", "()V", "FaceNotCentered", "FaceNotStable", "FaceTooBig", "FaceTooSmall", "ValidFace", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState$FaceTooSmall;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState$FaceTooBig;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState$FaceNotCentered;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState$FaceNotStable;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState$ValidFace;", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
public abstract class FaceValidationState {

    /* JADX INFO: compiled from: FaceValidationState.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState$FaceTooSmall;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState;", "()V", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
    public static final class FaceTooSmall extends FaceValidationState {
        public static final FaceTooSmall INSTANCE = new FaceTooSmall();

        private FaceTooSmall() {
            super(null);
        }
    }

    private FaceValidationState() {
    }

    public /* synthetic */ FaceValidationState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: FaceValidationState.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState$FaceTooBig;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState;", "()V", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
    public static final class FaceTooBig extends FaceValidationState {
        public static final FaceTooBig INSTANCE = new FaceTooBig();

        private FaceTooBig() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FaceValidationState.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState$FaceNotCentered;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState;", "()V", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
    public static final class FaceNotCentered extends FaceValidationState {
        public static final FaceNotCentered INSTANCE = new FaceNotCentered();

        private FaceNotCentered() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FaceValidationState.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState$FaceNotStable;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState;", "()V", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
    public static final class FaceNotStable extends FaceValidationState {
        public static final FaceNotStable INSTANCE = new FaceNotStable();

        private FaceNotStable() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FaceValidationState.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState$ValidFace;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceValidationState;", "()V", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
    public static final class ValidFace extends FaceValidationState {
        public static final ValidFace INSTANCE = new ValidFace();

        private ValidFace() {
            super(null);
        }
    }
}
