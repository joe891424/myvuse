package com.yoti.mobile.android.capture.face.p048ui.analyzers;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IFaceDetection.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceResult;", "", "boundingBox", "Landroid/graphics/Rect;", "eyesClosed", "", "invalidAngle", "(Landroid/graphics/Rect;ZZ)V", "getBoundingBox", "()Landroid/graphics/Rect;", "getEyesClosed", "()Z", "getInvalidAngle", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
public final /* data */ class FaceResult {
    private final Rect boundingBox;
    private final boolean eyesClosed;
    private final boolean invalidAngle;

    public static /* synthetic */ FaceResult copy$default(FaceResult faceResult, Rect rect, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            rect = faceResult.boundingBox;
        }
        if ((i & 2) != 0) {
            z = faceResult.eyesClosed;
        }
        if ((i & 4) != 0) {
            z2 = faceResult.invalidAngle;
        }
        return faceResult.copy(rect, z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Rect getBoundingBox() {
        return this.boundingBox;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getEyesClosed() {
        return this.eyesClosed;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getInvalidAngle() {
        return this.invalidAngle;
    }

    public final FaceResult copy(Rect boundingBox, boolean eyesClosed, boolean invalidAngle) {
        Intrinsics.checkNotNullParameter(boundingBox, "boundingBox");
        return new FaceResult(boundingBox, eyesClosed, invalidAngle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaceResult)) {
            return false;
        }
        FaceResult faceResult = (FaceResult) other;
        return Intrinsics.areEqual(this.boundingBox, faceResult.boundingBox) && this.eyesClosed == faceResult.eyesClosed && this.invalidAngle == faceResult.invalidAngle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        Rect rect = this.boundingBox;
        int iHashCode = (rect != null ? rect.hashCode() : 0) * 31;
        boolean z = this.eyesClosed;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.invalidAngle;
        return i + (z2 ? 1 : z2);
    }

    public String toString() {
        return "FaceResult(boundingBox=" + this.boundingBox + ", eyesClosed=" + this.eyesClosed + ", invalidAngle=" + this.invalidAngle + ")";
    }

    public FaceResult(Rect boundingBox, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(boundingBox, "boundingBox");
        this.boundingBox = boundingBox;
        this.eyesClosed = z;
        this.invalidAngle = z2;
    }

    public final Rect getBoundingBox() {
        return this.boundingBox;
    }

    public final boolean getEyesClosed() {
        return this.eyesClosed;
    }

    public final boolean getInvalidAngle() {
        return this.invalidAngle;
    }
}
