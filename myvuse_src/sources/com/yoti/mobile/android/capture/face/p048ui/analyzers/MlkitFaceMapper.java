package com.yoti.mobile.android.capture.face.p048ui.analyzers;

import android.graphics.Rect;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.face.Face;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MlkitFaceMapper.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\f\u0010\u0007\u001a\u00020\b*\u00020\u0006H\u0002J\f\u0010\t\u001a\u00020\b*\u00020\u0006H\u0002J\u0013\u0010\n\u001a\u00020\b*\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\f¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/analyzers/MlkitFaceMapper;", "", "()V", "map", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceResult;", OptionalModuleUtils.FACE, "Lcom/google/mlkit/vision/face/Face;", "areEyesClosed", "", "isAngleInvalid", "isBelowEyesOpenThreshold", "", "(Ljava/lang/Float;)Z", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
public final class MlkitFaceMapper {
    public final FaceResult map(Face face) {
        Intrinsics.checkNotNullParameter(face, "face");
        Rect boundingBox = face.getBoundingBox();
        Intrinsics.checkNotNullExpressionValue(boundingBox, "face.boundingBox");
        return new FaceResult(boundingBox, areEyesClosed(face), isAngleInvalid(face));
    }

    private final boolean isAngleInvalid(Face face) {
        float f = 30;
        return Math.abs(face.getHeadEulerAngleY()) > f || Math.abs(face.getHeadEulerAngleZ()) > f;
    }

    private final boolean areEyesClosed(Face face) {
        return isBelowEyesOpenThreshold(face.getLeftEyeOpenProbability()) || isBelowEyesOpenThreshold(face.getRightEyeOpenProbability());
    }

    private final boolean isBelowEyesOpenThreshold(Float f) {
        return f != null && ((double) f.floatValue()) < 0.25d;
    }
}
