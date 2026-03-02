package io.ktor.utils.p098io.core;

import io.ktor.utils.p098io.bits.Memory;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbstractOutputSharedStateJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u0019X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\b\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\""}, m5598d2 = {"Lio/ktor/utils/io/core/AbstractOutputSharedState;", "", "()V", "chainedSize", "", "getChainedSize", "()I", "setChainedSize", "(I)V", "head", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "getHead", "()Lio/ktor/utils/io/core/internal/ChunkBuffer;", "setHead", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)V", "tail", "getTail", "setTail", "tailEndExclusive", "getTailEndExclusive", "setTailEndExclusive", "tailInitialPosition", "getTailInitialPosition", "setTailInitialPosition", "tailMemory", "Lio/ktor/utils/io/bits/Memory;", "getTailMemory-SK3TCg8", "()Ljava/nio/ByteBuffer;", "setTailMemory-3GNKZMM", "(Ljava/nio/ByteBuffer;)V", "Ljava/nio/ByteBuffer;", "tailPosition", "getTailPosition", "setTailPosition", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class AbstractOutputSharedState {
    private int chainedSize;
    private ChunkBuffer head;
    private ChunkBuffer tail;
    private int tailEndExclusive;
    private int tailInitialPosition;
    private ByteBuffer tailMemory = Memory.INSTANCE.m6967getEmptySK3TCg8();
    private int tailPosition;

    public final ChunkBuffer getHead() {
        return this.head;
    }

    public final void setHead(ChunkBuffer chunkBuffer) {
        this.head = chunkBuffer;
    }

    public final ChunkBuffer getTail() {
        return this.tail;
    }

    public final void setTail(ChunkBuffer chunkBuffer) {
        this.tail = chunkBuffer;
    }

    /* JADX INFO: renamed from: getTailMemory-SK3TCg8, reason: not valid java name and from getter */
    public final ByteBuffer getTailMemory() {
        return this.tailMemory;
    }

    /* JADX INFO: renamed from: setTailMemory-3GNKZMM, reason: not valid java name */
    public final void m7108setTailMemory3GNKZMM(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<set-?>");
        this.tailMemory = byteBuffer;
    }

    public final int getTailPosition() {
        return this.tailPosition;
    }

    public final void setTailPosition(int i) {
        this.tailPosition = i;
    }

    public final int getTailEndExclusive() {
        return this.tailEndExclusive;
    }

    public final void setTailEndExclusive(int i) {
        this.tailEndExclusive = i;
    }

    public final int getTailInitialPosition() {
        return this.tailInitialPosition;
    }

    public final void setTailInitialPosition(int i) {
        this.tailInitialPosition = i;
    }

    public final int getChainedSize() {
        return this.chainedSize;
    }

    public final void setChainedSize(int i) {
        this.chainedSize = i;
    }
}
