package io.ktor.utils.p098io.core.internal;

import io.ktor.utils.p098io.core.AbstractInput;
import io.ktor.utils.p098io.core.AbstractOutput;
import io.ktor.utils.p098io.core.Buffer;
import io.ktor.utils.p098io.core.BytePacketBuilder;
import io.ktor.utils.p098io.core.ByteReadPacket;
import io.ktor.utils.p098io.core.Input;
import io.ktor.utils.p098io.core.InputKt;
import io.ktor.utils.p098io.core.InputPeekKt;
import io.ktor.utils.p098io.core.IoBuffer;
import io.ktor.utils.p098io.core.Output;
import io.ktor.utils.p098io.core.OutputKt;
import io.ktor.utils.p098io.core.PacketJVMKt;
import io.ktor.utils.p098io.core.StringsKt;
import java.io.EOFException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Unsafe.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\u0014\u0010\t\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007\u001a\u0014\u0010\t\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u000b\u001a\u00020\rH\u0007\u001a\u0014\u0010\u000e\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u000b\u001a\u00020\rH\u0002\u001a\u0014\u0010\u000f\u001a\u00020\u0005*\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0007\u001a\u0014\u0010\u000f\u001a\u00020\u0005*\u00020\u00102\u0006\u0010\u000b\u001a\u00020\rH\u0007\u001a\u0014\u0010\u0011\u001a\u00020\u0005*\u00020\u00102\u0006\u0010\u000b\u001a\u00020\rH\u0002\u001a\u0016\u0010\u0012\u001a\u0004\u0018\u00010\r*\u00020\u00102\u0006\u0010\u000b\u001a\u00020\rH\u0002\u001a\u0016\u0010\u0013\u001a\u0004\u0018\u00010\r*\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0007\u001a\u001b\u0010\u0016\u001a\u0004\u0018\u00010\f*\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\b\u0013\u001a\u0016\u0010\u0017\u001a\u0004\u0018\u00010\r*\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a\u0016\u0010\u0018\u001a\u0004\u0018\u00010\r*\u00020\u00102\u0006\u0010\u000b\u001a\u00020\rH\u0007\u001a\u001b\u0010\u0019\u001a\u0004\u0018\u00010\f*\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\b\u0018\u001a\u001e\u0010\u001a\u001a\u00020\f*\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007\u001a\u001e\u0010\u001a\u001a\u00020\r*\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\rH\u0007\u001a\u0016\u0010\u001c\u001a\u00020\r*\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\rH\u0002\u001a\u0014\u0010\u001d\u001a\u00020\u0015*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003¨\u0006\u001e"}, m5598d2 = {"EmptyByteArray", "", "getEmptyByteArray$annotations", "()V", "$unsafeAppend$", "", "Lio/ktor/utils/io/core/ByteReadPacket;", "builder", "Lio/ktor/utils/io/core/BytePacketBuilder;", "afterHeadWrite", "Lio/ktor/utils/io/core/Output;", "current", "Lio/ktor/utils/io/core/IoBuffer;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "afterWriteHeadFallback", "completeReadHead", "Lio/ktor/utils/io/core/Input;", "completeReadHeadFallback", "prepareNextReadHeadFallback", "prepareReadFirstHead", "minSize", "", "prepareReadFirstHeadOld", "prepareReadHeadFallback", "prepareReadNextHead", "prepareReadNextHeadOld", "prepareWriteHead", "capacity", "prepareWriteHeadFallback", "unsafeAppend", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class UnsafeKt {
    public static final byte[] EmptyByteArray = new byte[0];

    public static /* synthetic */ void getEmptyByteArray$annotations() {
    }

    @DangerousInternalIoApi
    public static final void $unsafeAppend$(ByteReadPacket byteReadPacket, BytePacketBuilder builder) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        Intrinsics.checkNotNullParameter(builder, "builder");
        ChunkBuffer chunkBufferStealAll$ktor_io = builder.stealAll$ktor_io();
        if (chunkBufferStealAll$ktor_io == null) {
            return;
        }
        if (builder.getSize() <= PacketJVMKt.getPACKET_MAX_COPY_SIZE() && chunkBufferStealAll$ktor_io.getNext() == null && byteReadPacket.tryWriteAppend$ktor_io(chunkBufferStealAll$ktor_io)) {
            builder.afterBytesStolen$ktor_io();
        } else {
            byteReadPacket.append$ktor_io(chunkBufferStealAll$ktor_io);
        }
    }

    public static final int unsafeAppend(ByteReadPacket byteReadPacket, BytePacketBuilder builder) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        Intrinsics.checkNotNullParameter(builder, "builder");
        int size = builder.getSize();
        ChunkBuffer chunkBufferStealAll$ktor_io = builder.stealAll$ktor_io();
        if (chunkBufferStealAll$ktor_io == null) {
            return 0;
        }
        if (size <= PacketJVMKt.getPACKET_MAX_COPY_SIZE() && chunkBufferStealAll$ktor_io.getNext() == null && byteReadPacket.tryWriteAppend$ktor_io(chunkBufferStealAll$ktor_io)) {
            builder.afterBytesStolen$ktor_io();
            return size;
        }
        byteReadPacket.append$ktor_io(chunkBufferStealAll$ktor_io);
        return size;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ IoBuffer prepareReadFirstHead(Input input, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return (IoBuffer) m7223prepareReadFirstHead(input, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @DangerousInternalIoApi
    /* JADX INFO: renamed from: prepareReadFirstHead, reason: collision with other method in class */
    public static final ChunkBuffer m7223prepareReadFirstHead(Input input, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input instanceof AbstractInput) {
            return ((AbstractInput) input).prepareReadHead(i);
        }
        if (input instanceof ChunkBuffer) {
            Buffer buffer = (Buffer) input;
            if (buffer.getWritePosition() > buffer.getReadPosition()) {
                return (ChunkBuffer) input;
            }
            return null;
        }
        return prepareReadHeadFallback(input, i);
    }

    private static final ChunkBuffer prepareReadHeadFallback(Input input, int i) throws EOFException {
        if (input.isEmpty()) {
            return null;
        }
        ChunkBuffer chunkBufferBorrow = ChunkBuffer.INSTANCE.getPool().borrow();
        ChunkBuffer chunkBuffer = chunkBufferBorrow;
        int iMo7100peekTo1dgeIsk = (int) input.mo7100peekTo1dgeIsk(chunkBufferBorrow.getMemory(), chunkBufferBorrow.getWritePosition(), 0L, i, chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
        chunkBufferBorrow.commitWritten(iMo7100peekTo1dgeIsk);
        if (iMo7100peekTo1dgeIsk >= i) {
            return chunkBufferBorrow;
        }
        StringsKt.prematureEndOfStream(i);
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ void completeReadHead(Input input, IoBuffer current) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(current, "current");
        completeReadHead(input, (ChunkBuffer) current);
    }

    @DangerousInternalIoApi
    public static final void completeReadHead(Input input, ChunkBuffer current) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(current, "current");
        if (current == input) {
            return;
        }
        if (input instanceof AbstractInput) {
            ChunkBuffer chunkBuffer = current;
            if (chunkBuffer.getWritePosition() <= chunkBuffer.getReadPosition()) {
                ((AbstractInput) input).ensureNext(current);
                return;
            } else if (chunkBuffer.getCapacity() - chunkBuffer.getLimit() < 8) {
                ((AbstractInput) input).fixGapAfterRead(current);
                return;
            } else {
                ((AbstractInput) input).setHeadPosition(current.getReadPosition());
                return;
            }
        }
        completeReadHeadFallback(input, current);
    }

    private static final void completeReadHeadFallback(Input input, ChunkBuffer chunkBuffer) {
        ChunkBuffer chunkBuffer2 = chunkBuffer;
        InputKt.discardExact(input, (chunkBuffer.getCapacity() - (chunkBuffer2.getLimit() - chunkBuffer2.getWritePosition())) - (chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition()));
        chunkBuffer.release(ChunkBuffer.INSTANCE.getPool());
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ IoBuffer prepareReadNextHead(Input input, IoBuffer current) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(current, "current");
        return (IoBuffer) prepareReadNextHead(input, (ChunkBuffer) current);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @DangerousInternalIoApi
    public static final ChunkBuffer prepareReadNextHead(Input input, ChunkBuffer current) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(current, "current");
        if (current == input) {
            Buffer buffer = (Buffer) input;
            if (buffer.getWritePosition() > buffer.getReadPosition()) {
                return (ChunkBuffer) input;
            }
            return null;
        }
        if (input instanceof AbstractInput) {
            return ((AbstractInput) input).ensureNextHead(current);
        }
        return prepareNextReadHeadFallback(input, current);
    }

    private static final ChunkBuffer prepareNextReadHeadFallback(Input input, ChunkBuffer chunkBuffer) {
        ChunkBuffer chunkBuffer2 = chunkBuffer;
        InputKt.discardExact(input, (chunkBuffer.getCapacity() - (chunkBuffer2.getLimit() - chunkBuffer2.getWritePosition())) - (chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition()));
        chunkBuffer.resetForWrite();
        if (!input.isEmpty() && InputPeekKt.peekTo$default(input, chunkBuffer2, 0, 0, 0, 14, (Object) null) > 0) {
            return chunkBuffer;
        }
        chunkBuffer.release(ChunkBuffer.INSTANCE.getPool());
        return null;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ IoBuffer prepareWriteHead(Output output, int i, IoBuffer ioBuffer) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        return (IoBuffer) prepareWriteHead(output, i, (ChunkBuffer) ioBuffer);
    }

    @DangerousInternalIoApi
    public static final ChunkBuffer prepareWriteHead(Output output, int i, ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        if (output instanceof AbstractOutput) {
            if (chunkBuffer != null) {
                ((AbstractOutput) output).afterHeadWrite();
            }
            return ((AbstractOutput) output).prepareWriteHead(i);
        }
        return prepareWriteHeadFallback(output, chunkBuffer);
    }

    private static final ChunkBuffer prepareWriteHeadFallback(Output output, ChunkBuffer chunkBuffer) {
        if (chunkBuffer != null) {
            OutputKt.writeFully$default(output, chunkBuffer, 0, 2, (Object) null);
            chunkBuffer.resetForWrite();
            return chunkBuffer;
        }
        return ChunkBuffer.INSTANCE.getPool().borrow();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ void afterHeadWrite(Output output, IoBuffer current) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(current, "current");
        afterHeadWrite(output, (ChunkBuffer) current);
    }

    @DangerousInternalIoApi
    public static final void afterHeadWrite(Output output, ChunkBuffer current) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(current, "current");
        if (output instanceof AbstractOutput) {
            ((AbstractOutput) output).afterHeadWrite();
        } else {
            afterWriteHeadFallback(output, current);
        }
    }

    private static final void afterWriteHeadFallback(Output output, ChunkBuffer chunkBuffer) {
        OutputKt.writeFully$default(output, chunkBuffer, 0, 2, (Object) null);
        chunkBuffer.release(ChunkBuffer.INSTANCE.getPool());
    }
}
