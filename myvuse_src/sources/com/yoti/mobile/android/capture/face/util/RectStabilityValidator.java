package com.yoti.mobile.android.capture.face.util;

import android.graphics.Rect;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RectStabilityValidator.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/util/RectStabilityValidator;", "", "()V", "currentStableFrames", "", "lastPosition", "Lcom/yoti/mobile/android/capture/face/util/PositionInfo;", "isRectStable", "", ViewProps.POSITION, "Landroid/graphics/Rect;", "imageWidth", "imageHeight", "requiredStableFrames", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
public final class RectStabilityValidator {
    private int currentStableFrames;
    private PositionInfo lastPosition;

    public final boolean isRectStable(Rect position, int imageWidth, int imageHeight, int requiredStableFrames) {
        Intrinsics.checkNotNullParameter(position, "position");
        PositionInfo positionInfo = new PositionInfo(position, imageWidth, imageHeight);
        if (positionInfo.isStable(this.lastPosition)) {
            this.currentStableFrames++;
        } else {
            this.currentStableFrames = 1;
        }
        this.lastPosition = positionInfo;
        return this.currentStableFrames >= requiredStableFrames;
    }
}
