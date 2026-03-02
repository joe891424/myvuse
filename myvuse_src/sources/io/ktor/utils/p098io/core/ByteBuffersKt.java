package io.ktor.utils.p098io.core;

import com.brentvatne.react.ReactVideoViewManager;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import io.ktor.utils.p098io.bits.Memory;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ByteBuffers.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0004H\u0001\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0001\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0001\u001a\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0000\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0001\u001a\u0014\u0010\f\u001a\u00020\r*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0004H\u0001\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0004H\u0001\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0001\u001a\u001d\u0010\u000f\u001a\u00020\u0004*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0004H\u0082\u0010\u001a\u0012\u0010\u0012\u001a\u00020\u0004*\u00020\u00072\u0006\u0010\u0013\u001a\u00020\r\u001a9\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u0016H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a9\u0010\u0014\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00042\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u0016H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a,\u0010\u0014\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u0016H\u0087\bø\u0001\u0000\u001a\u0012\u0010\u0017\u001a\u00020\u0004*\u00020\u00072\u0006\u0010\u0013\u001a\u00020\r\u001a\f\u0010\u0018\u001a\u00020\r*\u00020\u000bH\u0000\u001a9\u0010\u0019\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00042\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u0016H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a9\u0010\u001a\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00042\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u0016H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a\u0014\u0010\u001b\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u001c\u001a\u00020\rH\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, m5598d2 = {"afterNioBufferUsed", "", "Lio/ktor/utils/io/core/AbstractInput;", "read", "", "Lio/ktor/utils/io/core/BytePacketBuilder;", "written", "Lio/ktor/utils/io/core/ByteReadPacket;", "Lio/ktor/utils/io/core/ByteReadPacketBase;", "hasArray", "", "Lio/ktor/utils/io/core/Buffer;", "nioBuffer", "Ljava/nio/ByteBuffer;", "size", "readAsMuchAsPossible", "bb", "copied", "readAvailable", C4352k.a.f5652f, "readDirect", "block", "Lkotlin/Function1;", "readFully", "writeBuffer", "writeByteBufferDirect", "writeDirect", "writeFully", ReactVideoViewManager.PROP_SRC, "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ByteBuffersKt {
    public static final int readAvailable(ByteReadPacket byteReadPacket, ByteBuffer dst) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        return readAsMuchAsPossible(byteReadPacket, dst, 0);
    }

    public static final int readFully(ByteReadPacket byteReadPacket, ByteBuffer dst) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        int asMuchAsPossible = readAsMuchAsPossible(byteReadPacket, dst, 0);
        if (dst.hasRemaining()) {
            throw new EOFException("Not enough data in packet to fill buffer: " + dst.remaining() + " more bytes required");
        }
        return asMuchAsPossible;
    }

    private static final int readAsMuchAsPossible(ByteReadPacket byteReadPacket, ByteBuffer byteBuffer, int i) {
        ChunkBuffer chunkBufferPrepareRead;
        while (byteBuffer.hasRemaining() && (chunkBufferPrepareRead = byteReadPacket.prepareRead(1)) != null) {
            int iRemaining = byteBuffer.remaining();
            ChunkBuffer chunkBuffer = chunkBufferPrepareRead;
            int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
            if (iRemaining >= writePosition) {
                IoBufferJVMKt.readFully(chunkBuffer, byteBuffer, writePosition);
                byteReadPacket.releaseHead$ktor_io(chunkBufferPrepareRead);
                i += writePosition;
            } else {
                IoBufferJVMKt.readFully(chunkBuffer, byteBuffer, iRemaining);
                byteReadPacket.setHeadPosition(chunkBufferPrepareRead.getReadPosition());
                return i + iRemaining;
            }
        }
        return i;
    }

    public static final int writeByteBufferDirect(BytePacketBuilder bytePacketBuilder, int i, Function1<? super ByteBuffer, Unit> block) {
        Intrinsics.checkNotNullParameter(bytePacketBuilder, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        BytePacketBuilder bytePacketBuilder2 = bytePacketBuilder;
        try {
            ChunkBuffer chunkBufferPrepareWriteHead = bytePacketBuilder2.prepareWriteHead(i);
            ByteBuffer memory = chunkBufferPrepareWriteHead.getMemory();
            int writePosition = chunkBufferPrepareWriteHead.getWritePosition();
            int limit = chunkBufferPrepareWriteHead.getLimit() - writePosition;
            ByteBuffer byteBufferM6961sliceSK3TCg8 = Memory.m6961sliceSK3TCg8(memory, writePosition, limit);
            block.invoke(byteBufferM6961sliceSK3TCg8);
            if (!(byteBufferM6961sliceSK3TCg8.limit() == limit)) {
                throw new IllegalStateException("Buffer's limit change is not allowed".toString());
            }
            int iPosition = byteBufferM6961sliceSK3TCg8.position();
            chunkBufferPrepareWriteHead.commitWritten(iPosition);
            if (iPosition >= 0) {
                return iPosition;
            }
            throw new IllegalStateException("The returned value shouldn't be negative".toString());
        } finally {
            InlineMarker.finallyStart(1);
            bytePacketBuilder2.afterHeadWrite();
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void readDirect(ByteReadPacket byteReadPacket, int i, Function1<? super ByteBuffer, Unit> block) throws EOFException {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ByteReadPacket byteReadPacket2 = byteReadPacket;
        ChunkBuffer chunkBufferPrepareRead = byteReadPacket2.prepareRead(i);
        if (chunkBufferPrepareRead == null) {
            StringsKt.prematureEndOfStream(i);
            throw new KotlinNothingValueException();
        }
        int readPosition = chunkBufferPrepareRead.getReadPosition();
        try {
            ChunkBuffer chunkBuffer = chunkBufferPrepareRead;
            ByteBuffer memory = chunkBuffer.getMemory();
            int readPosition2 = chunkBuffer.getReadPosition();
            int writePosition = chunkBuffer.getWritePosition() - readPosition2;
            ByteBuffer byteBufferM6961sliceSK3TCg8 = Memory.m6961sliceSK3TCg8(memory, readPosition2, writePosition);
            block.invoke(byteBufferM6961sliceSK3TCg8);
            if (!(byteBufferM6961sliceSK3TCg8.limit() == writePosition)) {
                throw new IllegalStateException("Buffer's limit change is not allowed".toString());
            }
            chunkBuffer.discardExact(byteBufferM6961sliceSK3TCg8.position());
            InlineMarker.finallyStart(1);
            int readPosition3 = chunkBufferPrepareRead.getReadPosition();
            if (readPosition3 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition3 == chunkBufferPrepareRead.getWritePosition()) {
                byteReadPacket2.ensureNext(chunkBufferPrepareRead);
            } else {
                byteReadPacket2.setHeadPosition(readPosition3);
            }
            InlineMarker.finallyEnd(1);
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            int readPosition4 = chunkBufferPrepareRead.getReadPosition();
            if (readPosition4 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition4 == chunkBufferPrepareRead.getWritePosition()) {
                byteReadPacket2.ensureNext(chunkBufferPrepareRead);
            } else {
                byteReadPacket2.setHeadPosition(readPosition4);
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Removed")
    public static final /* synthetic */ void readDirect(ByteReadPacketBase byteReadPacketBase, int i, Function1<? super ByteBuffer, Unit> block) throws EOFException {
        Intrinsics.checkNotNullParameter(byteReadPacketBase, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ByteReadPacketBase byteReadPacketBase2 = byteReadPacketBase;
        ChunkBuffer chunkBufferPrepareRead = byteReadPacketBase2.prepareRead(i);
        if (chunkBufferPrepareRead == null) {
            StringsKt.prematureEndOfStream(i);
            throw new KotlinNothingValueException();
        }
        int readPosition = chunkBufferPrepareRead.getReadPosition();
        try {
            ChunkBuffer chunkBuffer = chunkBufferPrepareRead;
            ByteBuffer memory = chunkBuffer.getMemory();
            int readPosition2 = chunkBuffer.getReadPosition();
            int writePosition = chunkBuffer.getWritePosition() - readPosition2;
            ByteBuffer byteBufferM6961sliceSK3TCg8 = Memory.m6961sliceSK3TCg8(memory, readPosition2, writePosition);
            block.invoke(byteBufferM6961sliceSK3TCg8);
            if (!(byteBufferM6961sliceSK3TCg8.limit() == writePosition)) {
                throw new IllegalStateException("Buffer's limit change is not allowed".toString());
            }
            chunkBuffer.discardExact(byteBufferM6961sliceSK3TCg8.position());
            InlineMarker.finallyStart(1);
            int readPosition3 = chunkBufferPrepareRead.getReadPosition();
            if (readPosition3 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition3 == chunkBufferPrepareRead.getWritePosition()) {
                byteReadPacketBase2.ensureNext(chunkBufferPrepareRead);
            } else {
                byteReadPacketBase2.setHeadPosition(readPosition3);
            }
            InlineMarker.finallyEnd(1);
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            int readPosition4 = chunkBufferPrepareRead.getReadPosition();
            if (readPosition4 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition4 == chunkBufferPrepareRead.getWritePosition()) {
                byteReadPacketBase2.ensureNext(chunkBufferPrepareRead);
            } else {
                byteReadPacketBase2.setHeadPosition(readPosition4);
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Should be resolved to member function instead")
    public static final /* synthetic */ void writeFully(BytePacketBuilder bytePacketBuilder, ByteBuffer src) {
        Intrinsics.checkNotNullParameter(bytePacketBuilder, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        OutputArraysJVMKt.writeFully(bytePacketBuilder, src);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ ByteBuffer nioBuffer(BytePacketBuilder bytePacketBuilder, int i) {
        Intrinsics.checkNotNullParameter(bytePacketBuilder, "<this>");
        return writeBuffer(bytePacketBuilder.prepareWriteHead(i));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ void afterNioBufferUsed(BytePacketBuilder bytePacketBuilder, int i) {
        Intrinsics.checkNotNullParameter(bytePacketBuilder, "<this>");
        bytePacketBuilder.getHead$ktor_io().commitWritten(i);
        bytePacketBuilder.afterHeadWrite();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ ByteBuffer nioBuffer(ByteReadPacket byteReadPacket, int i) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        ChunkBuffer chunkBufferPrepareRead = byteReadPacket.prepareRead(i);
        if (chunkBufferPrepareRead == null) {
            return null;
        }
        return writeBuffer(chunkBufferPrepareRead);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ ByteBuffer nioBuffer(AbstractInput abstractInput, int i) {
        Intrinsics.checkNotNullParameter(abstractInput, "<this>");
        ChunkBuffer chunkBufferPrepareRead = abstractInput.prepareRead(i);
        if (chunkBufferPrepareRead == null) {
            return null;
        }
        return writeBuffer(chunkBufferPrepareRead);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ ByteBuffer nioBuffer(ByteReadPacketBase byteReadPacketBase, int i) {
        Intrinsics.checkNotNullParameter(byteReadPacketBase, "<this>");
        ChunkBuffer chunkBufferPrepareRead = byteReadPacketBase.prepareRead(i);
        if (chunkBufferPrepareRead == null) {
            return null;
        }
        return writeBuffer(chunkBufferPrepareRead);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ void afterNioBufferUsed(ByteReadPacket byteReadPacket, int i) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        afterNioBufferUsed((ByteReadPacketBase) byteReadPacket, i);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ void afterNioBufferUsed(AbstractInput abstractInput, int i) {
        Intrinsics.checkNotNullParameter(abstractInput, "<this>");
        afterNioBufferUsed((ByteReadPacketBase) abstractInput, i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Binary compatibility.")
    public static final void afterNioBufferUsed(ByteReadPacketBase byteReadPacketBase, int i) {
        Intrinsics.checkNotNullParameter(byteReadPacketBase, "<this>");
        ByteReadPacketBase byteReadPacketBase2 = byteReadPacketBase;
        byteReadPacketBase.setHeadRemaining((byteReadPacketBase2.getHeadEndExclusive() - byteReadPacketBase2.getHeadPosition()) - i);
    }

    public static final ByteBuffer writeBuffer(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return Memory.m6961sliceSK3TCg8(buffer.getMemory(), buffer.getWritePosition(), buffer.getLimit() - buffer.getWritePosition());
    }

    public static final boolean hasArray(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        return memory.hasArray() && !memory.isReadOnly();
    }

    public static final void writeDirect(BytePacketBuilder bytePacketBuilder, int i, Function1<? super ByteBuffer, Unit> block) {
        Intrinsics.checkNotNullParameter(bytePacketBuilder, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        BytePacketBuilder bytePacketBuilder2 = bytePacketBuilder;
        try {
            ChunkBuffer chunkBufferPrepareWriteHead = bytePacketBuilder2.prepareWriteHead(i);
            ByteBuffer memory = chunkBufferPrepareWriteHead.getMemory();
            int writePosition = chunkBufferPrepareWriteHead.getWritePosition();
            int limit = chunkBufferPrepareWriteHead.getLimit() - writePosition;
            ByteBuffer byteBufferM6961sliceSK3TCg8 = Memory.m6961sliceSK3TCg8(memory, writePosition, limit);
            block.invoke(byteBufferM6961sliceSK3TCg8);
            if (!(byteBufferM6961sliceSK3TCg8.limit() == limit)) {
                throw new IllegalStateException("Buffer's limit change is not allowed".toString());
            }
            int iPosition = byteBufferM6961sliceSK3TCg8.position();
            chunkBufferPrepareWriteHead.commitWritten(iPosition);
            if (!(iPosition >= 0)) {
                throw new IllegalStateException("The returned value shouldn't be negative".toString());
            }
        } finally {
            InlineMarker.finallyStart(1);
            bytePacketBuilder2.afterHeadWrite();
            InlineMarker.finallyEnd(1);
        }
    }

    @Deprecated(message = "Use read {} instead.")
    public static final void readDirect(AbstractInput abstractInput, int i, Function1<? super ByteBuffer, Unit> block) throws EOFException {
        Intrinsics.checkNotNullParameter(abstractInput, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ChunkBuffer chunkBufferPrepareRead = abstractInput.prepareRead(i);
        if (chunkBufferPrepareRead == null) {
            StringsKt.prematureEndOfStream(i);
            throw new KotlinNothingValueException();
        }
        int readPosition = chunkBufferPrepareRead.getReadPosition();
        try {
            ChunkBuffer chunkBuffer = chunkBufferPrepareRead;
            ByteBuffer memory = chunkBuffer.getMemory();
            int readPosition2 = chunkBuffer.getReadPosition();
            int writePosition = chunkBuffer.getWritePosition() - readPosition2;
            ByteBuffer byteBufferM6961sliceSK3TCg8 = Memory.m6961sliceSK3TCg8(memory, readPosition2, writePosition);
            block.invoke(byteBufferM6961sliceSK3TCg8);
            if (!(byteBufferM6961sliceSK3TCg8.limit() == writePosition)) {
                throw new IllegalStateException("Buffer's limit change is not allowed".toString());
            }
            chunkBuffer.discardExact(byteBufferM6961sliceSK3TCg8.position());
            InlineMarker.finallyStart(1);
            int readPosition3 = chunkBufferPrepareRead.getReadPosition();
            if (readPosition3 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition3 == chunkBufferPrepareRead.getWritePosition()) {
                abstractInput.ensureNext(chunkBufferPrepareRead);
            } else {
                abstractInput.setHeadPosition(readPosition3);
            }
            InlineMarker.finallyEnd(1);
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            int readPosition4 = chunkBufferPrepareRead.getReadPosition();
            if (readPosition4 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition4 == chunkBufferPrepareRead.getWritePosition()) {
                abstractInput.ensureNext(chunkBufferPrepareRead);
            } else {
                abstractInput.setHeadPosition(readPosition4);
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }
}
