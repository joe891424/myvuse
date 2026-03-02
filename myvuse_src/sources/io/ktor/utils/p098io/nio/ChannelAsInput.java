package io.ktor.utils.p098io.nio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.utils.p098io.bits.MemoryJvmKt;
import io.ktor.utils.p098io.core.AbstractInput;
import io.ktor.utils.p098io.core.Input;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SelectableChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Input.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J*\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0014ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, m5598d2 = {"Lio/ktor/utils/io/nio/ChannelAsInput;", "Lio/ktor/utils/io/core/AbstractInput;", "Lio/ktor/utils/io/core/Input;", "channel", "Ljava/nio/channels/ReadableByteChannel;", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "(Ljava/nio/channels/ReadableByteChannel;Lio/ktor/utils/io/pool/ObjectPool;)V", "closeSource", "", "fill", "", FirebaseAnalytics.Param.DESTINATION, "Lio/ktor/utils/io/bits/Memory;", TypedValues.CycleType.S_WAVE_OFFSET, "length", "fill-5Mw_xsg", "(Ljava/nio/ByteBuffer;II)I", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
final class ChannelAsInput extends AbstractInput implements Input {
    private final ReadableByteChannel channel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelAsInput(ReadableByteChannel channel, ObjectPool<ChunkBuffer> pool) {
        super((ChunkBuffer) null, 0L, pool, 3, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.channel = channel;
        if (!(((channel instanceof SelectableChannel) && ((SelectableChannel) channel).isBlocking()) ? false : true)) {
            throw new IllegalArgumentException("Non-blocking channels are not supported".toString());
        }
    }

    @Override // io.ktor.utils.p098io.core.AbstractInput
    /* JADX INFO: renamed from: fill-5Mw_xsg */
    protected int mo7098fill5Mw_xsg(ByteBuffer destination, int offset, int length) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        return RangesKt.coerceAtLeast(this.channel.read(MemoryJvmKt.sliceSafe(destination, offset, length)), 0);
    }

    @Override // io.ktor.utils.p098io.core.AbstractInput
    protected void closeSource() {
        this.channel.close();
    }
}
