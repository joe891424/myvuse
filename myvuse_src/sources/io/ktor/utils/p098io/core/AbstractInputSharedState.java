package io.ktor.utils.p098io.core;

import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbstractInputSharedStateJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u0012X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001a\u0010\u001b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006 "}, m5598d2 = {"Lio/ktor/utils/io/core/AbstractInputSharedState;", "", "head", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "remaining", "", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;J)V", "getHead", "()Lio/ktor/utils/io/core/internal/ChunkBuffer;", "setHead", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)V", "headEndExclusive", "", "getHeadEndExclusive", "()I", "setHeadEndExclusive", "(I)V", "headMemory", "Lio/ktor/utils/io/bits/Memory;", "getHeadMemory-SK3TCg8", "()Ljava/nio/ByteBuffer;", "setHeadMemory-3GNKZMM", "(Ljava/nio/ByteBuffer;)V", "Ljava/nio/ByteBuffer;", "headPosition", "getHeadPosition", "setHeadPosition", "tailRemaining", "getTailRemaining", "()J", "setTailRemaining", "(J)V", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class AbstractInputSharedState {
    private ChunkBuffer head;
    private int headEndExclusive;
    private ByteBuffer headMemory;
    private int headPosition;
    private long tailRemaining;

    public AbstractInputSharedState(ChunkBuffer head, long j) {
        Intrinsics.checkNotNullParameter(head, "head");
        this.head = head;
        this.headMemory = head.getMemory();
        this.headPosition = this.head.getReadPosition();
        int writePosition = this.head.getWritePosition();
        this.headEndExclusive = writePosition;
        this.tailRemaining = j - ((long) (writePosition - this.headPosition));
    }

    public final ChunkBuffer getHead() {
        return this.head;
    }

    public final void setHead(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<set-?>");
        this.head = chunkBuffer;
    }

    /* JADX INFO: renamed from: getHeadMemory-SK3TCg8, reason: not valid java name and from getter */
    public final ByteBuffer getHeadMemory() {
        return this.headMemory;
    }

    /* JADX INFO: renamed from: setHeadMemory-3GNKZMM, reason: not valid java name */
    public final void m7103setHeadMemory3GNKZMM(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<set-?>");
        this.headMemory = byteBuffer;
    }

    public final int getHeadPosition() {
        return this.headPosition;
    }

    public final void setHeadPosition(int i) {
        this.headPosition = i;
    }

    public final int getHeadEndExclusive() {
        return this.headEndExclusive;
    }

    public final void setHeadEndExclusive(int i) {
        this.headEndExclusive = i;
    }

    public final long getTailRemaining() {
        return this.tailRemaining;
    }

    public final void setTailRemaining(long j) {
        this.tailRemaining = j;
    }
}
