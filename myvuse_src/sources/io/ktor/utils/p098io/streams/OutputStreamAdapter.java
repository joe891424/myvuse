package io.ktor.utils.p098io.streams;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.ktor.utils.p098io.bits.MemoryJvmKt;
import io.ktor.utils.p098io.core.AbstractOutput;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.pool.ObjectPool;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Output.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014J*\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, m5598d2 = {"Lio/ktor/utils/io/streams/OutputStreamAdapter;", "Lio/ktor/utils/io/core/AbstractOutput;", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "stream", "Ljava/io/OutputStream;", "(Lio/ktor/utils/io/pool/ObjectPool;Ljava/io/OutputStream;)V", "closeDestination", "", "flush", "source", "Lio/ktor/utils/io/bits/Memory;", TypedValues.CycleType.S_WAVE_OFFSET, "", "length", "flush-5Mw_xsg", "(Ljava/nio/ByteBuffer;II)V", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
final class OutputStreamAdapter extends AbstractOutput {
    private final OutputStream stream;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutputStreamAdapter(ObjectPool<ChunkBuffer> pool, OutputStream stream) {
        super(pool);
        Intrinsics.checkNotNullParameter(pool, "pool");
        Intrinsics.checkNotNullParameter(stream, "stream");
        this.stream = stream;
    }

    @Override // io.ktor.utils.p098io.core.AbstractOutput
    /* JADX INFO: renamed from: flush-5Mw_xsg */
    protected void mo7104flush5Mw_xsg(ByteBuffer source, int offset, int length) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        if (source.hasArray() && !source.isReadOnly()) {
            this.stream.write(source.array(), source.arrayOffset() + offset, length);
            return;
        }
        byte[] bArrBorrow = ByteArraysKt.getByteArrayPool().borrow();
        ByteBuffer byteBufferSliceSafe = MemoryJvmKt.sliceSafe(source, offset, length);
        while (true) {
            try {
                int iMin = Math.min(byteBufferSliceSafe.remaining(), bArrBorrow.length);
                if (iMin == 0) {
                    return;
                }
                byteBufferSliceSafe.get(bArrBorrow, 0, iMin);
                this.stream.write(bArrBorrow, 0, iMin);
            } finally {
                ByteArraysKt.getByteArrayPool().recycle(bArrBorrow);
            }
        }
    }

    @Override // io.ktor.utils.p098io.core.AbstractOutput
    protected void closeDestination() throws IOException {
        this.stream.close();
    }
}
