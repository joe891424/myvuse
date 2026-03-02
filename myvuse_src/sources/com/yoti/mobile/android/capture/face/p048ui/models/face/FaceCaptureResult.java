package com.yoti.mobile.android.capture.face.p048ui.models.face;

import com.yoti.mobile.android.commons.image.ImageBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FaceCaptureResult.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureResult;", "", "originalImage", "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "state", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureState;", "(Lcom/yoti/mobile/android/commons/image/ImageBuffer;Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureState;)V", "getOriginalImage", "()Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "getState", "()Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureState;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
public final /* data */ class FaceCaptureResult {
    private final ImageBuffer originalImage;
    private final FaceCaptureState state;

    public static /* synthetic */ FaceCaptureResult copy$default(FaceCaptureResult faceCaptureResult, ImageBuffer imageBuffer, FaceCaptureState faceCaptureState, int i, Object obj) {
        if ((i & 1) != 0) {
            imageBuffer = faceCaptureResult.originalImage;
        }
        if ((i & 2) != 0) {
            faceCaptureState = faceCaptureResult.state;
        }
        return faceCaptureResult.copy(imageBuffer, faceCaptureState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ImageBuffer getOriginalImage() {
        return this.originalImage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FaceCaptureState getState() {
        return this.state;
    }

    public final FaceCaptureResult copy(ImageBuffer originalImage, FaceCaptureState state) {
        Intrinsics.checkNotNullParameter(originalImage, "originalImage");
        Intrinsics.checkNotNullParameter(state, "state");
        return new FaceCaptureResult(originalImage, state);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaceCaptureResult)) {
            return false;
        }
        FaceCaptureResult faceCaptureResult = (FaceCaptureResult) other;
        return Intrinsics.areEqual(this.originalImage, faceCaptureResult.originalImage) && Intrinsics.areEqual(this.state, faceCaptureResult.state);
    }

    public int hashCode() {
        ImageBuffer imageBuffer = this.originalImage;
        int iHashCode = (imageBuffer != null ? imageBuffer.hashCode() : 0) * 31;
        FaceCaptureState faceCaptureState = this.state;
        return iHashCode + (faceCaptureState != null ? faceCaptureState.hashCode() : 0);
    }

    public String toString() {
        return "FaceCaptureResult(originalImage=" + this.originalImage + ", state=" + this.state + ")";
    }

    public FaceCaptureResult(ImageBuffer originalImage, FaceCaptureState state) {
        Intrinsics.checkNotNullParameter(originalImage, "originalImage");
        Intrinsics.checkNotNullParameter(state, "state");
        this.originalImage = originalImage;
        this.state = state;
    }

    public final ImageBuffer getOriginalImage() {
        return this.originalImage;
    }

    public final FaceCaptureState getState() {
        return this.state;
    }
}
