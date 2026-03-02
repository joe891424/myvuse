package com.yoti.mobile.android.capture.face.p048ui.models.camera;

import androidx.camera.core.CameraSelector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'FRONT' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: CameraConfiguration.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraFacing;", "", "selector", "Landroidx/camera/core/CameraSelector;", "defaultZoomLevel", "", "(Ljava/lang/String;ILandroidx/camera/core/CameraSelector;F)V", "getDefaultZoomLevel", "()F", "getSelector", "()Landroidx/camera/core/CameraSelector;", "FRONT", "BACK", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
public final class CameraFacing {
    private static final /* synthetic */ CameraFacing[] $VALUES;
    public static final CameraFacing BACK;
    public static final CameraFacing FRONT;
    private final float defaultZoomLevel;
    private final CameraSelector selector;

    public static CameraFacing valueOf(String str) {
        return (CameraFacing) Enum.valueOf(CameraFacing.class, str);
    }

    public static CameraFacing[] values() {
        return (CameraFacing[]) $VALUES.clone();
    }

    private CameraFacing(String str, int i, CameraSelector cameraSelector, float f) {
        this.selector = cameraSelector;
        this.defaultZoomLevel = f;
    }

    public final float getDefaultZoomLevel() {
        return this.defaultZoomLevel;
    }

    public final CameraSelector getSelector() {
        return this.selector;
    }

    static {
        CameraSelector cameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA;
        Intrinsics.checkNotNullExpressionValue(cameraSelector, "CameraSelector.DEFAULT_FRONT_CAMERA");
        CameraFacing cameraFacing = new CameraFacing("FRONT", 0, cameraSelector, 0.0f);
        FRONT = cameraFacing;
        CameraSelector cameraSelector2 = CameraSelector.DEFAULT_BACK_CAMERA;
        Intrinsics.checkNotNullExpressionValue(cameraSelector2, "CameraSelector.DEFAULT_BACK_CAMERA");
        CameraFacing cameraFacing2 = new CameraFacing("BACK", 1, cameraSelector2, 0.7f);
        BACK = cameraFacing2;
        $VALUES = new CameraFacing[]{cameraFacing, cameraFacing2};
    }
}
