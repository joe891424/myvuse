package com.yoti.mobile.android.core.image;

import com.yoti.mobile.android.commons.image.ImageBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m5598d2 = {"rotateBy", "Lcom/yoti/mobile/android/core/image/RotationBuffer;", "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "degrees", "", "lib_release"}, m5599k = 2, m5600mv = {1, 1, 15})
public final class RotationBufferKt {
    public static final RotationBuffer rotateBy(ImageBuffer rotateBy, int i) {
        Intrinsics.checkParameterIsNotNull(rotateBy, "$this$rotateBy");
        if (!(rotateBy instanceof RotationBuffer)) {
            return new RotationBuffer(rotateBy, i);
        }
        RotationBuffer rotationBuffer = (RotationBuffer) rotateBy;
        return new RotationBuffer(rotationBuffer.getF6627d(), rotationBuffer.getF6628e() + i);
    }
}
