package io.ktor.utils.p098io.nio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.ktor.utils.p098io.bits.MemoryJvmKt;
import io.ktor.utils.p098io.core.AbstractOutput;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.pool.ObjectPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Output.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0014J*\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, m5598d2 = {"Lio/ktor/utils/io/nio/ChannelAsOutput;", "Lio/ktor/utils/io/core/AbstractOutput;", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "channel", "Ljava/nio/channels/WritableByteChannel;", "(Lio/ktor/utils/io/pool/ObjectPool;Ljava/nio/channels/WritableByteChannel;)V", "getChannel", "()Ljava/nio/channels/WritableByteChannel;", "closeDestination", "", "flush", "source", "Lio/ktor/utils/io/bits/Memory;", TypedValues.CycleType.S_WAVE_OFFSET, "", "length", "flush-5Mw_xsg", "(Ljava/nio/ByteBuffer;II)V", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
final class ChannelAsOutput extends AbstractOutput {
    private final WritableByteChannel channel;

    public final WritableByteChannel getChannel() {
        return this.channel;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelAsOutput(ObjectPool<ChunkBuffer> pool, WritableByteChannel channel) {
        super(pool);
        Intrinsics.checkNotNullParameter(pool, "pool");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.channel = channel;
    }

    @Override // io.ktor.utils.p098io.core.AbstractOutput
    /* JADX INFO: renamed from: flush-5Mw_xsg */
    protected void mo7104flush5Mw_xsg(ByteBuffer source, int offset, int length) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        ByteBuffer byteBufferSliceSafe = MemoryJvmKt.sliceSafe(source, offset, length);
        while (byteBufferSliceSafe.hasRemaining()) {
            this.channel.write(byteBufferSliceSafe);
        }
    }

    @Override // io.ktor.utils.p098io.core.AbstractOutput
    protected void closeDestination() {
        this.channel.close();
    }
}
