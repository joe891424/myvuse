package com.yoti.mobile.android.capture.face.p048ui.models.face;

import android.graphics.PointF;
import android.util.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FaceCaptureConfiguration.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u000bHÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureConfiguration;", "", "faceCenter", "Landroid/graphics/PointF;", "imageQuality", "Lcom/yoti/mobile/android/capture/face/ui/models/face/ImageQuality;", "requireValidAngle", "", "requireEyesOpen", "requireBrightEnvironment", "requiredStableFrames", "", "(Landroid/graphics/PointF;Lcom/yoti/mobile/android/capture/face/ui/models/face/ImageQuality;ZZZI)V", "getFaceCenter", "()Landroid/graphics/PointF;", "getImageQuality", "()Lcom/yoti/mobile/android/capture/face/ui/models/face/ImageQuality;", "getRequireBrightEnvironment", "()Z", "getRequireEyesOpen", "getRequireValidAngle", "getRequiredStableFrames", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "Defaults", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
public final /* data */ class FaceCaptureConfiguration {
    public static final double EYES_OPEN_PROBABILITY_THRESHOLD = 0.25d;
    public static final float STABILITY_SCALE_TOLERANCE = 0.015f;
    public static final float STABILITY_SHIFT_TOLERANCE = 0.025f;
    public static final int VALID_ANGLE_THRESHOLD_DEGREES = 30;
    private final PointF faceCenter;
    private final ImageQuality imageQuality;
    private final boolean requireBrightEnvironment;
    private final boolean requireEyesOpen;
    private final boolean requireValidAngle;
    private final int requiredStableFrames;

    /* JADX INFO: renamed from: Defaults, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String[] REQUIRED_PERMISSIONS = {"android.permission.CAMERA"};
    private static final PointF FACE_CENTER = new PointF(0.5f, 0.45f);
    private static final Size MIN_FACE_SIZE = new Size(400, 400);
    private static final Size MAX_FACE_SIZE = new Size(500, 500);
    private static final int MAX_CENTER_DISTANCE = 60;
    private static final float CROP_MULTIPLIER_TOP = 0.6f;
    private static final float CROP_MULTIPLIER_BOTTOM = 0.3f;

    public FaceCaptureConfiguration() {
        this(null, null, false, false, false, 0, 63, null);
    }

    public static /* synthetic */ FaceCaptureConfiguration copy$default(FaceCaptureConfiguration faceCaptureConfiguration, PointF pointF, ImageQuality imageQuality, boolean z, boolean z2, boolean z3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            pointF = faceCaptureConfiguration.faceCenter;
        }
        if ((i2 & 2) != 0) {
            imageQuality = faceCaptureConfiguration.imageQuality;
        }
        ImageQuality imageQuality2 = imageQuality;
        if ((i2 & 4) != 0) {
            z = faceCaptureConfiguration.requireValidAngle;
        }
        boolean z4 = z;
        if ((i2 & 8) != 0) {
            z2 = faceCaptureConfiguration.requireEyesOpen;
        }
        boolean z5 = z2;
        if ((i2 & 16) != 0) {
            z3 = faceCaptureConfiguration.requireBrightEnvironment;
        }
        boolean z6 = z3;
        if ((i2 & 32) != 0) {
            i = faceCaptureConfiguration.requiredStableFrames;
        }
        return faceCaptureConfiguration.copy(pointF, imageQuality2, z4, z5, z6, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PointF getFaceCenter() {
        return this.faceCenter;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ImageQuality getImageQuality() {
        return this.imageQuality;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getRequireValidAngle() {
        return this.requireValidAngle;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getRequireEyesOpen() {
        return this.requireEyesOpen;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getRequireBrightEnvironment() {
        return this.requireBrightEnvironment;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getRequiredStableFrames() {
        return this.requiredStableFrames;
    }

    public final FaceCaptureConfiguration copy(PointF faceCenter, ImageQuality imageQuality, boolean requireValidAngle, boolean requireEyesOpen, boolean requireBrightEnvironment, int requiredStableFrames) {
        Intrinsics.checkNotNullParameter(faceCenter, "faceCenter");
        Intrinsics.checkNotNullParameter(imageQuality, "imageQuality");
        return new FaceCaptureConfiguration(faceCenter, imageQuality, requireValidAngle, requireEyesOpen, requireBrightEnvironment, requiredStableFrames);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaceCaptureConfiguration)) {
            return false;
        }
        FaceCaptureConfiguration faceCaptureConfiguration = (FaceCaptureConfiguration) other;
        return Intrinsics.areEqual(this.faceCenter, faceCaptureConfiguration.faceCenter) && Intrinsics.areEqual(this.imageQuality, faceCaptureConfiguration.imageQuality) && this.requireValidAngle == faceCaptureConfiguration.requireValidAngle && this.requireEyesOpen == faceCaptureConfiguration.requireEyesOpen && this.requireBrightEnvironment == faceCaptureConfiguration.requireBrightEnvironment && this.requiredStableFrames == faceCaptureConfiguration.requiredStableFrames;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        PointF pointF = this.faceCenter;
        int iHashCode = (pointF != null ? pointF.hashCode() : 0) * 31;
        ImageQuality imageQuality = this.imageQuality;
        int iHashCode2 = (iHashCode + (imageQuality != null ? imageQuality.hashCode() : 0)) * 31;
        boolean z = this.requireValidAngle;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z2 = this.requireEyesOpen;
        ?? r12 = z2;
        if (z2) {
            r12 = 1;
        }
        int i2 = (i + r12) * 31;
        boolean z3 = this.requireBrightEnvironment;
        return ((i2 + (z3 ? 1 : z3)) * 31) + Integer.hashCode(this.requiredStableFrames);
    }

    public String toString() {
        return "FaceCaptureConfiguration(faceCenter=" + this.faceCenter + ", imageQuality=" + this.imageQuality + ", requireValidAngle=" + this.requireValidAngle + ", requireEyesOpen=" + this.requireEyesOpen + ", requireBrightEnvironment=" + this.requireBrightEnvironment + ", requiredStableFrames=" + this.requiredStableFrames + ")";
    }

    public FaceCaptureConfiguration(PointF faceCenter, ImageQuality imageQuality, boolean z, boolean z2, boolean z3, int i) {
        Intrinsics.checkNotNullParameter(faceCenter, "faceCenter");
        Intrinsics.checkNotNullParameter(imageQuality, "imageQuality");
        this.faceCenter = faceCenter;
        this.imageQuality = imageQuality;
        this.requireValidAngle = z;
        this.requireEyesOpen = z2;
        this.requireBrightEnvironment = z3;
        this.requiredStableFrames = i;
    }

    public /* synthetic */ FaceCaptureConfiguration(PointF pointF, ImageQuality imageQuality, boolean z, boolean z2, boolean z3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? FACE_CENTER : pointF, (i2 & 2) != 0 ? ImageQuality.INSTANCE.getDefault() : imageQuality, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? true : z3, (i2 & 32) == 0 ? i : 1);
    }

    public final PointF getFaceCenter() {
        return this.faceCenter;
    }

    public final ImageQuality getImageQuality() {
        return this.imageQuality;
    }

    public final boolean getRequireValidAngle() {
        return this.requireValidAngle;
    }

    public final boolean getRequireEyesOpen() {
        return this.requireEyesOpen;
    }

    public final boolean getRequireBrightEnvironment() {
        return this.requireBrightEnvironment;
    }

    public final int getRequiredStableFrames() {
        return this.requiredStableFrames;
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.capture.face.ui.models.face.FaceCaptureConfiguration$Defaults, reason: from kotlin metadata */
    /* JADX INFO: compiled from: FaceCaptureConfiguration.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0019\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000¨\u0006\""}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureConfiguration$Defaults;", "", "()V", "CROP_MULTIPLIER_BOTTOM", "", "getCROP_MULTIPLIER_BOTTOM", "()F", "CROP_MULTIPLIER_TOP", "getCROP_MULTIPLIER_TOP", "EYES_OPEN_PROBABILITY_THRESHOLD", "", "FACE_CENTER", "Landroid/graphics/PointF;", "getFACE_CENTER", "()Landroid/graphics/PointF;", "MAX_CENTER_DISTANCE", "", "getMAX_CENTER_DISTANCE", "()I", "MAX_FACE_SIZE", "Landroid/util/Size;", "getMAX_FACE_SIZE", "()Landroid/util/Size;", "MIN_FACE_SIZE", "getMIN_FACE_SIZE", "REQUIRED_PERMISSIONS", "", "", "getREQUIRED_PERMISSIONS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "STABILITY_SCALE_TOLERANCE", "STABILITY_SHIFT_TOLERANCE", "VALID_ANGLE_THRESHOLD_DEGREES", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String[] getREQUIRED_PERMISSIONS() {
            return FaceCaptureConfiguration.REQUIRED_PERMISSIONS;
        }

        public final PointF getFACE_CENTER() {
            return FaceCaptureConfiguration.FACE_CENTER;
        }

        public final Size getMIN_FACE_SIZE() {
            return FaceCaptureConfiguration.MIN_FACE_SIZE;
        }

        public final Size getMAX_FACE_SIZE() {
            return FaceCaptureConfiguration.MAX_FACE_SIZE;
        }

        public final int getMAX_CENTER_DISTANCE() {
            return FaceCaptureConfiguration.MAX_CENTER_DISTANCE;
        }

        public final float getCROP_MULTIPLIER_TOP() {
            return FaceCaptureConfiguration.CROP_MULTIPLIER_TOP;
        }

        public final float getCROP_MULTIPLIER_BOTTOM() {
            return FaceCaptureConfiguration.CROP_MULTIPLIER_BOTTOM;
        }
    }
}
