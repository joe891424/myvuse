package com.yoti.mobile.android.capture.face.p048ui.models.face;

import android.graphics.Rect;
import com.newrelic.agent.android.agentdata.HexAttribute;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FaceCaptureResult.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureState;", "", "()V", "InvalidFace", "ValidFace", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureState$InvalidFace;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureState$ValidFace;", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
public abstract class FaceCaptureState {

    /* JADX INFO: compiled from: FaceCaptureResult.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureState$InvalidFace;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureState;", HexAttribute.HEX_ATTR_CAUSE, "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid;", "(Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid;)V", "getCause", "()Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureInvalid;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
    public static final /* data */ class InvalidFace extends FaceCaptureState {
        private final FaceCaptureInvalid cause;

        public static /* synthetic */ InvalidFace copy$default(InvalidFace invalidFace, FaceCaptureInvalid faceCaptureInvalid, int i, Object obj) {
            if ((i & 1) != 0) {
                faceCaptureInvalid = invalidFace.cause;
            }
            return invalidFace.copy(faceCaptureInvalid);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FaceCaptureInvalid getCause() {
            return this.cause;
        }

        public final InvalidFace copy(FaceCaptureInvalid cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            return new InvalidFace(cause);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof InvalidFace) && Intrinsics.areEqual(this.cause, ((InvalidFace) other).cause);
            }
            return true;
        }

        public int hashCode() {
            FaceCaptureInvalid faceCaptureInvalid = this.cause;
            if (faceCaptureInvalid != null) {
                return faceCaptureInvalid.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "InvalidFace(cause=" + this.cause + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidFace(FaceCaptureInvalid cause) {
            super(null);
            Intrinsics.checkNotNullParameter(cause, "cause");
            this.cause = cause;
        }

        public final FaceCaptureInvalid getCause() {
            return this.cause;
        }
    }

    private FaceCaptureState() {
    }

    public /* synthetic */ FaceCaptureState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: FaceCaptureResult.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureState$ValidFace;", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureState;", "croppedImage", "", "croppedFaceBoundingBox", "Landroid/graphics/Rect;", "faceBoundingBox", "([BLandroid/graphics/Rect;Landroid/graphics/Rect;)V", "getCroppedFaceBoundingBox", "()Landroid/graphics/Rect;", "getCroppedImage", "()[B", "getFaceBoundingBox", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
    public static final /* data */ class ValidFace extends FaceCaptureState {
        private final Rect croppedFaceBoundingBox;
        private final byte[] croppedImage;
        private final Rect faceBoundingBox;

        public static /* synthetic */ ValidFace copy$default(ValidFace validFace, byte[] bArr, Rect rect, Rect rect2, int i, Object obj) {
            if ((i & 1) != 0) {
                bArr = validFace.croppedImage;
            }
            if ((i & 2) != 0) {
                rect = validFace.croppedFaceBoundingBox;
            }
            if ((i & 4) != 0) {
                rect2 = validFace.faceBoundingBox;
            }
            return validFace.copy(bArr, rect, rect2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final byte[] getCroppedImage() {
            return this.croppedImage;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Rect getCroppedFaceBoundingBox() {
            return this.croppedFaceBoundingBox;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Rect getFaceBoundingBox() {
            return this.faceBoundingBox;
        }

        public final ValidFace copy(byte[] croppedImage, Rect croppedFaceBoundingBox, Rect faceBoundingBox) {
            Intrinsics.checkNotNullParameter(croppedImage, "croppedImage");
            Intrinsics.checkNotNullParameter(croppedFaceBoundingBox, "croppedFaceBoundingBox");
            Intrinsics.checkNotNullParameter(faceBoundingBox, "faceBoundingBox");
            return new ValidFace(croppedImage, croppedFaceBoundingBox, faceBoundingBox);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ValidFace)) {
                return false;
            }
            ValidFace validFace = (ValidFace) other;
            return Intrinsics.areEqual(this.croppedImage, validFace.croppedImage) && Intrinsics.areEqual(this.croppedFaceBoundingBox, validFace.croppedFaceBoundingBox) && Intrinsics.areEqual(this.faceBoundingBox, validFace.faceBoundingBox);
        }

        public int hashCode() {
            byte[] bArr = this.croppedImage;
            int iHashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
            Rect rect = this.croppedFaceBoundingBox;
            int iHashCode2 = (iHashCode + (rect != null ? rect.hashCode() : 0)) * 31;
            Rect rect2 = this.faceBoundingBox;
            return iHashCode2 + (rect2 != null ? rect2.hashCode() : 0);
        }

        public String toString() {
            return "ValidFace(croppedImage=" + Arrays.toString(this.croppedImage) + ", croppedFaceBoundingBox=" + this.croppedFaceBoundingBox + ", faceBoundingBox=" + this.faceBoundingBox + ")";
        }

        public final byte[] getCroppedImage() {
            return this.croppedImage;
        }

        public final Rect getCroppedFaceBoundingBox() {
            return this.croppedFaceBoundingBox;
        }

        public final Rect getFaceBoundingBox() {
            return this.faceBoundingBox;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ValidFace(byte[] croppedImage, Rect croppedFaceBoundingBox, Rect faceBoundingBox) {
            super(null);
            Intrinsics.checkNotNullParameter(croppedImage, "croppedImage");
            Intrinsics.checkNotNullParameter(croppedFaceBoundingBox, "croppedFaceBoundingBox");
            Intrinsics.checkNotNullParameter(faceBoundingBox, "faceBoundingBox");
            this.croppedImage = croppedImage;
            this.croppedFaceBoundingBox = croppedFaceBoundingBox;
            this.faceBoundingBox = faceBoundingBox;
        }
    }
}
