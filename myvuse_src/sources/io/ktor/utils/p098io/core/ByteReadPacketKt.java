package io.ktor.utils.p098io.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ByteReadPacket.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0086\b¨\u0006\u0007"}, m5598d2 = {"ByteReadPacket", "Lio/ktor/utils/io/core/ByteReadPacket;", "array", "", TypedValues.CycleType.S_WAVE_OFFSET, "", "length", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ByteReadPacketKt {
    public static /* synthetic */ ByteReadPacket ByteReadPacket$default(byte[] array, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = array.length;
        }
        Intrinsics.checkNotNullParameter(array, "array");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(array, i, i2);
        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(array, offset, length)");
        return ByteReadPacketExtensionsKt.ByteReadPacket(byteBufferWrap, new ByteReadPacketKt$ByteReadPacket$$inlined$ByteReadPacket$1(array));
    }

    public static final ByteReadPacket ByteReadPacket(byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(array, i, i2);
        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(array, offset, length)");
        return ByteReadPacketExtensionsKt.ByteReadPacket(byteBufferWrap, new ByteReadPacketKt$ByteReadPacket$$inlined$ByteReadPacket$1(array));
    }
}
