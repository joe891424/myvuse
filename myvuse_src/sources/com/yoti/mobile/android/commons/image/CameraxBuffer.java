package com.yoti.mobile.android.commons.image;

import androidx.camera.core.ImageProxy;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraxBuffer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Landroidx/camera/core/ImageProxy;", "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "toBuffer", "(Landroidx/camera/core/ImageProxy;)Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "commons-camerax_release"}, m5599k = 2, m5600mv = {1, 1, 15}, m5601pn = "", m5602xi = 0, m5603xs = "")
public final class CameraxBuffer {
    public static final ImageBuffer toBuffer(ImageProxy toBuffer) {
        Intrinsics.checkParameterIsNotNull(toBuffer, "$this$toBuffer");
        if (toBuffer.getFormat() != 35) {
            throw new IllegalArgumentException(("Invalid image format: " + toBuffer.getFormat()).toString());
        }
        int width = toBuffer.getWidth();
        int height = toBuffer.getHeight();
        ImageProxy.PlaneProxy planeProxy = toBuffer.getPlanes()[0];
        Intrinsics.checkExpressionValueIsNotNull(planeProxy, "planes[0]");
        ByteBuffer buffer = planeProxy.getBuffer();
        Intrinsics.checkExpressionValueIsNotNull(buffer, "planes[0].buffer");
        ImageProxy.PlaneProxy planeProxy2 = toBuffer.getPlanes()[0];
        Intrinsics.checkExpressionValueIsNotNull(planeProxy2, "planes[0]");
        int rowStride = planeProxy2.getRowStride();
        ImageProxy.PlaneProxy planeProxy3 = toBuffer.getPlanes()[0];
        Intrinsics.checkExpressionValueIsNotNull(planeProxy3, "planes[0]");
        int pixelStride = planeProxy3.getPixelStride();
        ImageProxy.PlaneProxy planeProxy4 = toBuffer.getPlanes()[1];
        Intrinsics.checkExpressionValueIsNotNull(planeProxy4, "planes[1]");
        ByteBuffer buffer2 = planeProxy4.getBuffer();
        Intrinsics.checkExpressionValueIsNotNull(buffer2, "planes[1].buffer");
        ImageProxy.PlaneProxy planeProxy5 = toBuffer.getPlanes()[2];
        Intrinsics.checkExpressionValueIsNotNull(planeProxy5, "planes[2]");
        ByteBuffer buffer3 = planeProxy5.getBuffer();
        Intrinsics.checkExpressionValueIsNotNull(buffer3, "planes[2].buffer");
        ImageProxy.PlaneProxy planeProxy6 = toBuffer.getPlanes()[1];
        Intrinsics.checkExpressionValueIsNotNull(planeProxy6, "planes[1]");
        int rowStride2 = planeProxy6.getRowStride();
        ImageProxy.PlaneProxy planeProxy7 = toBuffer.getPlanes()[1];
        Intrinsics.checkExpressionValueIsNotNull(planeProxy7, "planes[1]");
        return new PlanarStrideBuffer(width, height, buffer, rowStride, pixelStride, buffer2, buffer3, rowStride2, planeProxy7.getPixelStride());
    }
}
