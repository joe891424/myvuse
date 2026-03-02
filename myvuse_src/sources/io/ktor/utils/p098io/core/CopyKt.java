package io.ktor.utils.p098io.core;

import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Copy.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0006"}, m5598d2 = {"copyTo", "", "Lio/ktor/utils/io/core/Input;", "output", "Lio/ktor/utils/io/core/Output;", "copyToFallback", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class CopyKt {
    public static final long copyTo(Input input, Output output) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(output, "output");
        if (!(input instanceof AbstractInput) || !(output instanceof AbstractOutput)) {
            return copyToFallback(input, output);
        }
        long jRemainingAll = 0;
        while (true) {
            AbstractInput abstractInput = (AbstractInput) input;
            ChunkBuffer chunkBufferStealAll$ktor_io = abstractInput.stealAll$ktor_io();
            if (chunkBufferStealAll$ktor_io == null) {
                if (abstractInput.prepareRead(1) == null) {
                    return jRemainingAll;
                }
            } else {
                jRemainingAll += BuffersKt.remainingAll(chunkBufferStealAll$ktor_io);
                ((AbstractOutput) output).appendChain$ktor_io(chunkBufferStealAll$ktor_io);
            }
        }
    }

    private static final long copyToFallback(Input input, Output output) {
        ChunkBuffer chunkBufferBorrow = ChunkBuffer.INSTANCE.getPool().borrow();
        long j = 0;
        while (true) {
            try {
                chunkBufferBorrow.resetForWrite();
                int available$default = InputArraysKt.readAvailable$default(input, chunkBufferBorrow, 0, 2, null);
                if (available$default == -1) {
                    return j;
                }
                j += (long) available$default;
                OutputKt.writeFully$default(output, chunkBufferBorrow, 0, 2, (Object) null);
            } finally {
                chunkBufferBorrow.release(ChunkBuffer.INSTANCE.getPool());
            }
        }
    }
}
