package com.yoti.mobile.android.capture.face.p048ui.analyzers;

import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import com.yoti.mobile.android.commons.image.DirectBuffer;
import com.yoti.mobile.android.commons.image.ImageBuffer;
import com.yoti.mobile.android.commons.image.PlanarStrideBuffer;
import com.yoti.mobile.android.core.image.RotationBufferKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FaceAnalyzer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m5598d2 = {"TAG", "", "toBufferInternal", "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "Landroidx/camera/core/ImageProxy;", "face_bundledRelease"}, m5599k = 2, m5600mv = {1, 4, 1})
public final class FaceAnalyzerKt {
    private static final String TAG = "FaceAnalyzer";

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageBuffer toBufferInternal(ImageProxy imageProxy) {
        if (!(imageProxy.getFormat() == 35)) {
            throw new IllegalArgumentException(("Invalid image format: " + imageProxy.getFormat()).toString());
        }
        DirectBuffer.Companion companion = DirectBuffer.INSTANCE;
        int width = imageProxy.getWidth();
        int height = imageProxy.getHeight();
        ImageProxy.PlaneProxy planeProxy = imageProxy.getPlanes()[0];
        Intrinsics.checkNotNullExpressionValue(planeProxy, "planes[0]");
        ByteBuffer buffer = planeProxy.getBuffer();
        Intrinsics.checkNotNullExpressionValue(buffer, "planes[0].buffer");
        ImageProxy.PlaneProxy planeProxy2 = imageProxy.getPlanes()[0];
        Intrinsics.checkNotNullExpressionValue(planeProxy2, "planes[0]");
        int rowStride = planeProxy2.getRowStride();
        ImageProxy.PlaneProxy planeProxy3 = imageProxy.getPlanes()[0];
        Intrinsics.checkNotNullExpressionValue(planeProxy3, "planes[0]");
        int pixelStride = planeProxy3.getPixelStride();
        ImageProxy.PlaneProxy planeProxy4 = imageProxy.getPlanes()[1];
        Intrinsics.checkNotNullExpressionValue(planeProxy4, "planes[1]");
        ByteBuffer buffer2 = planeProxy4.getBuffer();
        Intrinsics.checkNotNullExpressionValue(buffer2, "planes[1].buffer");
        ImageProxy.PlaneProxy planeProxy5 = imageProxy.getPlanes()[2];
        Intrinsics.checkNotNullExpressionValue(planeProxy5, "planes[2]");
        ByteBuffer buffer3 = planeProxy5.getBuffer();
        Intrinsics.checkNotNullExpressionValue(buffer3, "planes[2].buffer");
        ImageProxy.PlaneProxy planeProxy6 = imageProxy.getPlanes()[1];
        Intrinsics.checkNotNullExpressionValue(planeProxy6, "planes[1]");
        int rowStride2 = planeProxy6.getRowStride();
        ImageProxy.PlaneProxy planeProxy7 = imageProxy.getPlanes()[1];
        Intrinsics.checkNotNullExpressionValue(planeProxy7, "planes[1]");
        PlanarStrideBuffer planarStrideBuffer = new PlanarStrideBuffer(width, height, buffer, rowStride, pixelStride, buffer2, buffer3, rowStride2, planeProxy7.getPixelStride());
        ImageInfo imageInfo = imageProxy.getImageInfo();
        Intrinsics.checkNotNullExpressionValue(imageInfo, "imageInfo");
        return companion.convert(RotationBufferKt.rotateBy(planarStrideBuffer, imageInfo.getRotationDegrees()));
    }
}
