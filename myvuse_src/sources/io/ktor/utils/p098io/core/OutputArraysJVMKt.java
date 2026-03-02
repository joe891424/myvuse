package io.ktor.utils.p098io.core;

import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.core.internal.UnsafeKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OutputArraysJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m5598d2 = {"writeFully", "", "Lio/ktor/utils/io/core/Output;", "bb", "Ljava/nio/ByteBuffer;", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class OutputArraysJVMKt {
    public static final void writeFully(Output output, ByteBuffer bb) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(bb, "bb");
        int iLimit = bb.limit();
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, (ChunkBuffer) null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                BufferPrimitivesJvmKt.writeFully(chunkBuffer, bb);
                if (!bb.hasRemaining()) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, chunkBufferPrepareWriteHead);
                }
            } finally {
                UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
            }
        }
    }
}
