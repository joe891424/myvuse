package io.ktor.utils.p098io.nio;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.utils.p098io.bits.Memory;
import io.ktor.utils.p098io.bits.MemoryJvmKt;
import io.ktor.utils.p098io.core.Buffer;
import io.ktor.utils.p098io.core.BytePacketBuilder;
import io.ktor.utils.p098io.core.ByteReadPacket;
import io.ktor.utils.p098io.core.IoBuffer;
import io.ktor.utils.p098io.core.PacketJVMKt;
import io.ktor.utils.p098io.core.StringsKt;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: Channels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000L\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\u000bH\u0007\u001a\u0012\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u0012\u0010\u0010\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u0012\u0010\u0011\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u001c\u0010\u0012\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002\u001a0\u0010\u0015\u001a\u00020\u0001*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0014\u0010\u0015\u001a\u00020\u0001*\u00020\u00162\u0006\u0010\t\u001a\u00020\nH\u0007\u001a\u0014\u0010\u0015\u001a\u00020\u0001*\u00020\u00162\u0006\u0010\t\u001a\u00020\u000bH\u0007\u001a%\u0010\u001b\u001a\u0004\u0018\u00010\r*\u00020\u00162\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\u0002\b \u001a\u0012\u0010\u001b\u001a\u00020!*\u00020\u00162\u0006\u0010\"\u001a\u00020\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, m5598d2 = {"read", "", "Ljava/nio/channels/ReadableByteChannel;", FirebaseAnalytics.Param.DESTINATION, "Lio/ktor/utils/io/bits/Memory;", "destinationOffset", "maxLength", "read-r2lQqvc", "(Ljava/nio/channels/ReadableByteChannel;Ljava/nio/ByteBuffer;II)I", "buffer", "Lio/ktor/utils/io/core/Buffer;", "Lio/ktor/utils/io/core/IoBuffer;", "readPacketAtLeast", "Lio/ktor/utils/io/core/ByteReadPacket;", RsaJsonWebKey.MODULUS_MEMBER_NAME, "", "readPacketAtMost", "readPacketExact", "readPacketImpl", "min", "max", "write", "Ljava/nio/channels/WritableByteChannel;", "source", "sourceOffset", "write-XQjEsr4", "(Ljava/nio/channels/WritableByteChannel;Ljava/nio/ByteBuffer;II)I", "writePacket", "builder", "Lkotlin/Function1;", "Lio/ktor/utils/io/core/BytePacketBuilder;", "", "Lkotlin/ExtensionFunctionType;", "", "p", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ChannelsKt {
    public static final boolean writePacket(WritableByteChannel writableByteChannel, ByteReadPacket p) {
        int iWrite;
        Intrinsics.checkNotNullParameter(writableByteChannel, "<this>");
        Intrinsics.checkNotNullParameter(p, "p");
        do {
            try {
                ByteReadPacket byteReadPacket = p;
                ChunkBuffer chunkBufferPrepareRead = byteReadPacket.prepareRead(1);
                if (chunkBufferPrepareRead == null) {
                    StringsKt.prematureEndOfStream(1);
                    throw new KotlinNothingValueException();
                }
                int readPosition = chunkBufferPrepareRead.getReadPosition();
                try {
                    ChunkBuffer chunkBuffer = chunkBufferPrepareRead;
                    ByteBuffer memory = chunkBuffer.getMemory();
                    int readPosition2 = chunkBuffer.getReadPosition();
                    int writePosition = chunkBuffer.getWritePosition() - readPosition2;
                    ByteBuffer byteBufferM6961sliceSK3TCg8 = Memory.m6961sliceSK3TCg8(memory, readPosition2, writePosition);
                    iWrite = writableByteChannel.write(byteBufferM6961sliceSK3TCg8);
                    if (!(byteBufferM6961sliceSK3TCg8.limit() == writePosition)) {
                        throw new IllegalStateException("Buffer's limit change is not allowed".toString());
                    }
                    chunkBuffer.discardExact(byteBufferM6961sliceSK3TCg8.position());
                    int readPosition3 = chunkBufferPrepareRead.getReadPosition();
                    if (readPosition3 < readPosition) {
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                    if (readPosition3 == chunkBufferPrepareRead.getWritePosition()) {
                        byteReadPacket.ensureNext(chunkBufferPrepareRead);
                    } else {
                        byteReadPacket.setHeadPosition(readPosition3);
                    }
                    if (p.isEmpty()) {
                        return true;
                    }
                } catch (Throwable th) {
                    int readPosition4 = chunkBufferPrepareRead.getReadPosition();
                    if (readPosition4 < readPosition) {
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                    if (readPosition4 == chunkBufferPrepareRead.getWritePosition()) {
                        byteReadPacket.ensureNext(chunkBufferPrepareRead);
                    } else {
                        byteReadPacket.setHeadPosition(readPosition4);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                p.release();
                throw th2;
            }
        } while (iWrite != 0);
        return false;
    }

    public static final ByteReadPacket readPacketExact(ReadableByteChannel readableByteChannel, long j) {
        Intrinsics.checkNotNullParameter(readableByteChannel, "<this>");
        return readPacketImpl(readableByteChannel, j, j);
    }

    public static final ByteReadPacket readPacketAtLeast(ReadableByteChannel readableByteChannel, long j) {
        Intrinsics.checkNotNullParameter(readableByteChannel, "<this>");
        return readPacketImpl(readableByteChannel, j, Long.MAX_VALUE);
    }

    public static final ByteReadPacket readPacketAtMost(ReadableByteChannel readableByteChannel, long j) {
        Intrinsics.checkNotNullParameter(readableByteChannel, "<this>");
        return readPacketImpl(readableByteChannel, 1L, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
    
        return new io.ktor.utils.p098io.core.ByteReadPacket(r11, r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final io.ktor.utils.p098io.core.ByteReadPacket readPacketImpl(java.nio.channels.ReadableByteChannel r17, long r18, long r20) {
        /*
            Method dump skipped, instruction units count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.nio.ChannelsKt.readPacketImpl(java.nio.channels.ReadableByteChannel, long, long):io.ktor.utils.io.core.ByteReadPacket");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ int read(ReadableByteChannel readableByteChannel, IoBuffer buffer) {
        Intrinsics.checkNotNullParameter(readableByteChannel, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        IoBuffer ioBuffer = buffer;
        if (ioBuffer.getLimit() - ioBuffer.getWritePosition() == 0) {
            return 0;
        }
        return readableByteChannel.read(buffer.getWriteBuffer());
    }

    /* JADX INFO: renamed from: read-r2lQqvc, reason: not valid java name */
    public static final int m7225readr2lQqvc(ReadableByteChannel read, ByteBuffer destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(read, "$this$read");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return read.read(MemoryJvmKt.sliceSafe(destination, i, i2));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ int write(WritableByteChannel writableByteChannel, IoBuffer buffer) {
        Intrinsics.checkNotNullParameter(writableByteChannel, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        return writableByteChannel.write(buffer.getReadBuffer());
    }

    /* JADX INFO: renamed from: write-XQjEsr4, reason: not valid java name */
    public static final int m7227writeXQjEsr4(WritableByteChannel write, ByteBuffer source, int i, int i2) {
        Intrinsics.checkNotNullParameter(write, "$this$write");
        Intrinsics.checkNotNullParameter(source, "source");
        return write.write(MemoryJvmKt.sliceSafe(source, i, i2));
    }

    public static final ByteReadPacket writePacket(WritableByteChannel writableByteChannel, Function1<? super BytePacketBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(writableByteChannel, "<this>");
        Intrinsics.checkNotNullParameter(builder, "builder");
        BytePacketBuilder BytePacketBuilder = PacketJVMKt.BytePacketBuilder(0);
        try {
            builder.invoke(BytePacketBuilder);
            ByteReadPacket byteReadPacketBuild = BytePacketBuilder.build();
            try {
                if (writePacket(writableByteChannel, byteReadPacketBuild)) {
                    return null;
                }
                return byteReadPacketBuild;
            } catch (Throwable th) {
                byteReadPacketBuild.release();
                throw th;
            }
        } catch (Throwable th2) {
            BytePacketBuilder.release();
            throw th2;
        }
    }

    @Deprecated(message = "Use read(Memory) instead.")
    public static final int read(ReadableByteChannel readableByteChannel, Buffer buffer) throws IOException {
        Intrinsics.checkNotNullParameter(readableByteChannel, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (buffer.getLimit() - buffer.getWritePosition() == 0) {
            return 0;
        }
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int i = readableByteChannel.read(MemoryJvmKt.sliceSafe(memory, writePosition, buffer.getLimit() - writePosition));
        if (i == -1) {
            return -1;
        }
        buffer.commitWritten(i);
        return i;
    }

    /* JADX INFO: renamed from: read-r2lQqvc$default, reason: not valid java name */
    public static /* synthetic */ int m7226readr2lQqvc$default(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = byteBuffer.limit() - i;
        }
        return m7225readr2lQqvc(readableByteChannel, byteBuffer, i, i2);
    }

    @Deprecated(message = "Use write(Memory) instead.")
    public static final int write(WritableByteChannel writableByteChannel, Buffer buffer) throws IOException {
        Intrinsics.checkNotNullParameter(writableByteChannel, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        int iWrite = writableByteChannel.write(MemoryJvmKt.sliceSafe(memory, readPosition, buffer.getWritePosition() - readPosition));
        buffer.discardExact(iWrite);
        return iWrite;
    }

    /* JADX INFO: renamed from: write-XQjEsr4$default, reason: not valid java name */
    public static /* synthetic */ int m7228writeXQjEsr4$default(WritableByteChannel writableByteChannel, ByteBuffer byteBuffer, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = byteBuffer.limit() - i;
        }
        return m7227writeXQjEsr4(writableByteChannel, byteBuffer, i, i2);
    }
}
