package com.yoti.mobile.android.capture.face.util;

import android.graphics.Bitmap;
import com.yoti.mobile.android.capture.face.p048ui.models.face.ImageQuality;
import com.yoti.mobile.android.commons.image.BufferHelper;
import com.yoti.mobile.android.commons.image.ImageBuffer;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageBufferExtension.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m5598d2 = {"toJpeg", "", "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "quality", "Lcom/yoti/mobile/android/capture/face/ui/models/face/ImageQuality;", "face_bundledRelease"}, m5599k = 2, m5600mv = {1, 4, 1})
public final class BufferConversion {
    public static final byte[] toJpeg(ImageBuffer toJpeg, ImageQuality quality) {
        Intrinsics.checkNotNullParameter(toJpeg, "$this$toJpeg");
        Intrinsics.checkNotNullParameter(quality, "quality");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap bitmap = BufferHelper.toBitmap(toJpeg);
        if (bitmap == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        bitmap.compress(Bitmap.CompressFormat.JPEG, quality.getQuality(), byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "ByteArrayOutputStream().…ty, this)\n}.toByteArray()");
        return byteArray;
    }
}
