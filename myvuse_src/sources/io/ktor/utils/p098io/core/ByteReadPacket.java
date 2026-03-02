package io.ktor.utils.p098io.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.core.internal.DangerousInternalIoApi;
import io.ktor.utils.p098io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ByteReadPacket.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\u0010\u0007B\u001d\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\b\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\u0010\tB%\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0004J\u0006\u0010\u000f\u001a\u00020\u0000J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0004J*\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0004ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, m5598d2 = {"Lio/ktor/utils/io/core/ByteReadPacket;", "Lio/ktor/utils/io/core/ByteReadPacketPlatformBase;", "Lio/ktor/utils/io/core/Input;", "head", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;Lio/ktor/utils/io/pool/ObjectPool;)V", "Lio/ktor/utils/io/core/IoBuffer;", "(Lio/ktor/utils/io/core/IoBuffer;Lio/ktor/utils/io/pool/ObjectPool;)V", "remaining", "", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;JLio/ktor/utils/io/pool/ObjectPool;)V", "closeSource", "", "copy", "fill", "", FirebaseAnalytics.Param.DESTINATION, "Lio/ktor/utils/io/bits/Memory;", TypedValues.CycleType.S_WAVE_OFFSET, "length", "fill-5Mw_xsg", "(Ljava/nio/ByteBuffer;II)I", "toString", "", "Companion", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ByteReadPacket extends ByteReadPacketPlatformBase implements Input {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ByteReadPacket Empty = new ByteReadPacket(ChunkBuffer.INSTANCE.getEmpty(), 0, ChunkBuffer.INSTANCE.getEmptyPool());

    @Override // io.ktor.utils.p098io.core.AbstractInput
    protected final void closeSource() {
    }

    @Override // io.ktor.utils.p098io.core.AbstractInput
    protected final ChunkBuffer fill() {
        return null;
    }

    @Override // io.ktor.utils.p098io.core.AbstractInput
    /* JADX INFO: renamed from: fill-5Mw_xsg */
    protected final int mo7098fill5Mw_xsg(ByteBuffer destination, int offset, int length) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        return 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteReadPacket(ChunkBuffer head, long j, ObjectPool<ChunkBuffer> pool) {
        super(head, j, pool);
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(pool, "pool");
        markNoMoreChunksAvailable();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ByteReadPacket(ChunkBuffer head, ObjectPool<ChunkBuffer> pool) {
        this(head, BuffersKt.remainingAll(head), pool);
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(pool, "pool");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ ByteReadPacket(IoBuffer head, ObjectPool pool) {
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(pool, "pool");
        IoBuffer ioBuffer = head;
        this(ioBuffer, BuffersKt.remainingAll((ChunkBuffer) ioBuffer), pool);
    }

    public final ByteReadPacket copy() {
        return new ByteReadPacket(BuffersKt.copyAll(getHead()), getRemaining(), getPool());
    }

    public String toString() {
        return "ByteReadPacket(" + getRemaining() + " bytes remaining)";
    }

    /* JADX INFO: compiled from: ByteReadPacket.kt */
    @Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m5598d2 = {"Lio/ktor/utils/io/core/ByteReadPacket$Companion;", "", "()V", "Empty", "Lio/ktor/utils/io/core/ByteReadPacket;", "getEmpty", "()Lio/ktor/utils/io/core/ByteReadPacket;", "ReservedSize", "", "getReservedSize$annotations", "getReservedSize", "()I", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @DangerousInternalIoApi
        public static /* synthetic */ void getReservedSize$annotations() {
        }

        public final int getReservedSize() {
            return 8;
        }

        private Companion() {
        }

        public final ByteReadPacket getEmpty() {
            return ByteReadPacket.Empty;
        }
    }
}
