package com.yoti.mobile.android.capture.face.util;

import android.graphics.Rect;
import android.graphics.RectF;
import com.facebook.react.uimanager.ViewProps;
import com.yoti.mobile.android.capture.face.p048ui.models.face.FaceCaptureConfiguration;
import com.yoti.mobile.android.commons.image.DirectBuffer;
import com.yoti.mobile.android.commons.image.ImageBuffer;
import com.yoti.mobile.android.core.yuvtools.YuvTools;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ImageFaceCropper.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/util/ImageFaceCropper;", "", "()V", "createCropRect", "Landroid/graphics/Rect;", "boundingBox", ViewProps.MAX_WIDTH, "", "encodeImage", "", "imageBuffer", "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "configuration", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureConfiguration;", "performCrop", "croppedBoundingBox", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
public final class ImageFaceCropper {
    public final Rect createCropRect(Rect boundingBox, int maxWidth) {
        Intrinsics.checkNotNullParameter(boundingBox, "boundingBox");
        int iRoundToInt = MathKt.roundToInt(boundingBox.height() * FaceCaptureConfiguration.INSTANCE.getCROP_MULTIPLIER_TOP());
        int iRoundToInt2 = MathKt.roundToInt(boundingBox.height() * FaceCaptureConfiguration.INSTANCE.getCROP_MULTIPLIER_BOTTOM());
        Rect rect = new Rect(boundingBox);
        rect.left = 0;
        rect.top -= iRoundToInt;
        rect.right = maxWidth;
        rect.bottom += iRoundToInt2;
        return rect;
    }

    public final ImageBuffer performCrop(Rect croppedBoundingBox, ImageBuffer imageBuffer) {
        Intrinsics.checkNotNullParameter(croppedBoundingBox, "croppedBoundingBox");
        Intrinsics.checkNotNullParameter(imageBuffer, "imageBuffer");
        DirectBuffer directBufferYuvCrop = YuvTools.yuvCrop(imageBuffer, new RectF(croppedBoundingBox));
        Intrinsics.checkNotNullExpressionValue(directBufferYuvCrop, "YuvTools.yuvCrop(imageBu…ectF(croppedBoundingBox))");
        return directBufferYuvCrop;
    }

    public final byte[] encodeImage(ImageBuffer imageBuffer, FaceCaptureConfiguration configuration) {
        Intrinsics.checkNotNullParameter(imageBuffer, "imageBuffer");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return BufferConversion.toJpeg(imageBuffer, configuration.getImageQuality());
    }
}
