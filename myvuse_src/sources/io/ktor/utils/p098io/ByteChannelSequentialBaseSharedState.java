package io.ktor.utils.p098io;

import io.ktor.utils.p098io.core.ByteOrder;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ByteChannelSequentialBaseSharedStateJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u001a\u0010*\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 ¨\u0006-"}, m5598d2 = {"Lio/ktor/utils/io/ByteChannelSequentialBaseSharedState;", "", "()V", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "closedCause", "", "getClosedCause", "()Ljava/lang/Throwable;", "setClosedCause", "(Ljava/lang/Throwable;)V", "lastReadAvailable", "", "getLastReadAvailable", "()I", "setLastReadAvailable", "(I)V", "lastReadView", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "getLastReadView", "()Lio/ktor/utils/io/core/internal/ChunkBuffer;", "setLastReadView", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)V", "readByteOrder", "Lio/ktor/utils/io/core/ByteOrder;", "getReadByteOrder", "()Lio/ktor/utils/io/core/ByteOrder;", "setReadByteOrder", "(Lio/ktor/utils/io/core/ByteOrder;)V", "totalBytesRead", "", "getTotalBytesRead", "()J", "setTotalBytesRead", "(J)V", "totalBytesWritten", "getTotalBytesWritten", "setTotalBytesWritten", "writeByteOrder", "getWriteByteOrder", "setWriteByteOrder", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ByteChannelSequentialBaseSharedState {
    private volatile boolean closed;
    private volatile Throwable closedCause;
    private volatile int lastReadAvailable;
    private volatile long totalBytesRead;
    private volatile long totalBytesWritten;
    private volatile ByteOrder readByteOrder = ByteOrder.BIG_ENDIAN;
    private volatile ByteOrder writeByteOrder = ByteOrder.BIG_ENDIAN;
    private volatile ChunkBuffer lastReadView = ChunkBuffer.INSTANCE.getEmpty();

    public final boolean getClosed() {
        return this.closed;
    }

    public final void setClosed(boolean z) {
        this.closed = z;
    }

    public final ByteOrder getReadByteOrder() {
        return this.readByteOrder;
    }

    public final void setReadByteOrder(ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(byteOrder, "<set-?>");
        this.readByteOrder = byteOrder;
    }

    public final ByteOrder getWriteByteOrder() {
        return this.writeByteOrder;
    }

    public final void setWriteByteOrder(ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(byteOrder, "<set-?>");
        this.writeByteOrder = byteOrder;
    }

    public final long getTotalBytesRead() {
        return this.totalBytesRead;
    }

    public final void setTotalBytesRead(long j) {
        this.totalBytesRead = j;
    }

    public final long getTotalBytesWritten() {
        return this.totalBytesWritten;
    }

    public final void setTotalBytesWritten(long j) {
        this.totalBytesWritten = j;
    }

    public final Throwable getClosedCause() {
        return this.closedCause;
    }

    public final void setClosedCause(Throwable th) {
        this.closedCause = th;
    }

    public final int getLastReadAvailable() {
        return this.lastReadAvailable;
    }

    public final void setLastReadAvailable(int i) {
        this.lastReadAvailable = i;
    }

    public final ChunkBuffer getLastReadView() {
        return this.lastReadView;
    }

    public final void setLastReadView(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<set-?>");
        this.lastReadView = chunkBuffer;
    }
}
