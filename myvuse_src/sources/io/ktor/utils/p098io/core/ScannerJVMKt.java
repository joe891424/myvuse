package io.ktor.utils.p098io.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import io.ktor.utils.p098io.bits.MemoryJvmKt;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.core.internal.UnsafeKt;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScannerJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002\u001a0\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002\u001a)\u0010\u000e\u001a\u00020\u0001*\u00020\u00032\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\n\u001a\u00020\u0012H\u0082\b\u001aA\u0010\u000e\u001a\u00020\u0001*\u00020\u00132\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0082\b\u001a9\u0010\u0015\u001a\u00020\u0001*\u00020\u00132\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0083\b\u001a\u0014\u0010\u0016\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u001c\u0010\u0017\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0000\u001a\u001c\u0010\t\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0012H\u0000\u001a\u001c\u0010\u0018\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0012H\u0000\u001a,\u0010\u0018\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002\u001a\u001c\u0010\u0019\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0012H\u0000\u001a,\u0010\u0019\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0000\u001a$\u0010\u001a\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0012H\u0000\u001a4\u0010\u001a\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002\u001a$\u0010\u001b\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0012H\u0000\u001a4\u0010\u001b\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002\u001a$\u0010\u001c\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0012H\u0000\u001a4\u0010\u001c\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0000¨\u0006\u001d"}, m5598d2 = {"discardUntilDelimiterImplArrays", "", "buffer", "Lio/ktor/utils/io/core/Buffer;", "delimiter", "", "discardUntilDelimitersImplArrays", "delimiter1", "delimiter2", "readUntilDelimiterArrays", C4352k.a.f5652f, "", TypedValues.CycleType.S_WAVE_OFFSET, "length", "copyUntilArrays", "predicate", "Lkotlin/Function1;", "", "Lio/ktor/utils/io/core/Output;", "Ljava/nio/ByteBuffer;", "bufferOffset", "copyUntilDirect", "discardUntilDelimiterImpl", "discardUntilDelimitersImpl", "readUntilDelimiterDirect", "readUntilDelimiterImpl", "readUntilDelimitersArrays", "readUntilDelimitersDirect", "readUntilDelimitersImpl", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ScannerJVMKt {
    public static final int discardUntilDelimiterImpl(Buffer buffer, byte b) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return ByteBuffersKt.hasArray(buffer) ? discardUntilDelimiterImplArrays(buffer, b) : ScannerKt.discardUntilDelimiterImplMemory(buffer, b);
    }

    private static final int discardUntilDelimiterImplArrays(Buffer buffer, byte b) {
        int i;
        ByteBuffer memory = buffer.getMemory();
        byte[] bArrArray = memory.array();
        Intrinsics.checkNotNull(bArrArray);
        int iArrayOffset = memory.arrayOffset() + memory.position() + buffer.getReadPosition();
        int writePosition = (buffer.getWritePosition() - buffer.getReadPosition()) + iArrayOffset;
        if (writePosition <= bArrArray.length) {
            i = iArrayOffset;
            while (i < writePosition && bArrArray[i] != b) {
                i++;
            }
        } else {
            i = iArrayOffset;
        }
        buffer.discardUntilIndex$ktor_io(i);
        return i - iArrayOffset;
    }

    public static final int discardUntilDelimitersImpl(Buffer buffer, byte b, byte b2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return ByteBuffersKt.hasArray(buffer) ? discardUntilDelimitersImplArrays(buffer, b, b2) : ScannerKt.discardUntilDelimitersImplMemory(buffer, b, b2);
    }

    private static final int discardUntilDelimitersImplArrays(Buffer buffer, byte b, byte b2) {
        int i;
        ByteBuffer memory = buffer.getMemory();
        byte[] bArrArray = memory.array();
        Intrinsics.checkNotNull(bArrArray);
        int iArrayOffset = memory.arrayOffset() + memory.position() + buffer.getReadPosition();
        int writePosition = (buffer.getWritePosition() - buffer.getReadPosition()) + iArrayOffset;
        if (writePosition <= bArrArray.length) {
            i = iArrayOffset;
            while (i < writePosition) {
                byte b3 = bArrArray[i];
                if (b3 == b || b3 == b2) {
                    break;
                }
                i++;
            }
        } else {
            i = iArrayOffset;
        }
        buffer.discardUntilIndex$ktor_io(i);
        return i - iArrayOffset;
    }

    public static final int readUntilDelimiterImpl(Buffer buffer, byte b, byte[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        int length = dst.length;
        return ByteBuffersKt.hasArray(buffer) ? readUntilDelimiterArrays(buffer, b, dst, i, i2) : readUntilDelimiterDirect(buffer, b, dst, i, i2);
    }

    private static final int readUntilDelimiterArrays(Buffer buffer, byte b, byte[] bArr, int i, int i2) {
        int i3;
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        int iMin = Math.min(i2, buffer.getWritePosition() - buffer.getReadPosition());
        byte[] bArrArray = memory.array();
        Intrinsics.checkNotNull(bArrArray);
        int iPosition = readPosition + memory.position() + memory.arrayOffset();
        int iMin2 = Math.min(iMin, memory.remaining()) + iPosition;
        if (iMin2 <= bArrArray.length) {
            i3 = iPosition;
            while (i3 < iMin2 && bArrArray[i3] != b) {
                i3++;
            }
        } else {
            i3 = iPosition;
        }
        int i4 = i3 - iPosition;
        System.arraycopy(bArrArray, iPosition, bArr, i, i4);
        buffer.discardExact(i4);
        return i4;
    }

    public static final int readUntilDelimitersImpl(Buffer buffer, byte b, byte b2, byte[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        int length = dst.length;
        return ByteBuffersKt.hasArray(buffer) ? readUntilDelimitersArrays(buffer, b, b2, dst, i, i2) : readUntilDelimitersDirect(buffer, b, b2, dst, i, i2);
    }

    private static final int readUntilDelimitersArrays(Buffer buffer, byte b, byte b2, byte[] bArr, int i, int i2) {
        int i3;
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        int iMin = Math.min(i2, buffer.getWritePosition() - buffer.getReadPosition());
        byte[] bArrArray = memory.array();
        Intrinsics.checkNotNull(bArrArray);
        int iPosition = readPosition + memory.position() + memory.arrayOffset();
        int iMin2 = Math.min(iMin, memory.remaining()) + iPosition;
        if (iMin2 <= bArrArray.length) {
            i3 = iPosition;
            while (i3 < iMin2) {
                byte b3 = bArrArray[i3];
                if (b3 == b || b3 == b2) {
                    break;
                }
                i3++;
            }
        } else {
            i3 = iPosition;
        }
        int i4 = i3 - iPosition;
        System.arraycopy(bArrArray, iPosition, bArr, i, i4);
        buffer.discardExact(i4);
        return i4;
    }

    public static final int readUntilDelimiterImpl(Buffer buffer, byte b, Output dst) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        return ByteBuffersKt.hasArray(buffer) ? readUntilDelimiterArrays(buffer, b, dst) : readUntilDelimiterDirect(buffer, b, dst);
    }

    public static final int readUntilDelimitersImpl(Buffer buffer, byte b, byte b2, Output dst) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        return ByteBuffersKt.hasArray(buffer) ? readUntilDelimitersArrays(buffer, b, b2, dst) : readUntilDelimitersDirect(buffer, b, b2, dst);
    }

    @Deprecated(message = "Rewrite to Memory.copyTo")
    private static final int copyUntilDirect(ByteBuffer byteBuffer, Function1<? super Byte, Boolean> function1, byte[] bArr, int i, int i2) {
        int iPosition = byteBuffer.position();
        int i3 = i2 + iPosition;
        int i4 = iPosition;
        while (i4 < byteBuffer.limit() && i4 < i3 && !function1.invoke(Byte.valueOf(byteBuffer.get(i4))).booleanValue()) {
            i4++;
        }
        int i5 = i4 - iPosition;
        byteBuffer.get(bArr, i, i5);
        return i5;
    }

    private static final int copyUntilArrays(ByteBuffer byteBuffer, Function1<? super Byte, Boolean> function1, int i, byte[] bArr, int i2, int i3) {
        int i4;
        byte[] bArrArray = byteBuffer.array();
        Intrinsics.checkNotNull(bArrArray);
        int iPosition = i + byteBuffer.position() + byteBuffer.arrayOffset();
        int iMin = Math.min(i3, byteBuffer.remaining()) + iPosition;
        if (iMin <= bArrArray.length) {
            i4 = iPosition;
            while (i4 < iMin && !function1.invoke(Byte.valueOf(bArrArray[i4])).booleanValue()) {
                i4++;
            }
        } else {
            i4 = iPosition;
        }
        int i5 = i4 - iPosition;
        System.arraycopy(bArrArray, iPosition, bArr, i2, i5);
        return i5;
    }

    private static final int copyUntilArrays(Buffer buffer, Function1<? super Byte, Boolean> function1, Output output) {
        int i;
        ByteBuffer memory = buffer.getMemory();
        byte[] bArrArray = memory.array();
        Intrinsics.checkNotNull(bArrArray);
        int iPosition = memory.position() + memory.arrayOffset() + buffer.getReadPosition();
        int iPosition2 = memory.position() + memory.arrayOffset() + buffer.getWritePosition();
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, (ChunkBuffer) null);
        int i2 = 0;
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min((chunkBuffer.getLimit() - chunkBuffer.getWritePosition()) + iPosition, iPosition2);
                if (iMin <= bArrArray.length) {
                    i = iPosition;
                    while (i < iMin && !function1.invoke(Byte.valueOf(bArrArray[i])).booleanValue()) {
                        i++;
                    }
                } else {
                    i = iPosition;
                }
                int i3 = i - iPosition;
                BufferPrimitivesKt.writeFully((Buffer) chunkBuffer, bArrArray, iPosition, i3);
                i2 += i3;
                if (chunkBuffer.getLimit() > chunkBuffer.getWritePosition() || i >= iPosition2) {
                    break;
                }
                chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, chunkBufferPrepareWriteHead);
                iPosition = i;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyStart(1);
        UnsafeKt.afterHeadWrite(output, chunkBufferPrepareWriteHead);
        InlineMarker.finallyEnd(1);
        buffer.discardUntilIndex$ktor_io(i);
        return i2;
    }

    private static final int readUntilDelimiterDirect(Buffer buffer, byte b, byte[] bArr, int i, int i2) {
        int readPosition = buffer.getReadPosition();
        int iMin = Math.min(buffer.getWritePosition(), i2 + readPosition);
        ByteBuffer memory = buffer.getMemory();
        if (readPosition < iMin) {
            int i3 = readPosition;
            while (true) {
                int i4 = i3 + 1;
                if (memory.get(i3) == b) {
                    iMin = i3;
                    break;
                }
                if (i4 >= iMin) {
                    break;
                }
                i3 = i4;
            }
        }
        int i5 = iMin - readPosition;
        MemoryJvmKt.m6968copyToFs5fovk(memory, bArr, readPosition, i5, i);
        buffer.discardExact(i5);
        return i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
    
        r10 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final int readUntilDelimitersDirect(io.ktor.utils.p098io.core.Buffer r5, byte r6, byte r7, byte[] r8, int r9, int r10) {
        /*
            int r0 = r5.getReadPosition()
            int r1 = r5.getWritePosition()
            int r10 = r10 + r0
            int r10 = java.lang.Math.min(r1, r10)
            java.nio.ByteBuffer r1 = r5.getMemory()
            if (r0 >= r10) goto L25
            r2 = r0
        L14:
            int r3 = r2 + 1
            byte r4 = r1.get(r2)
            if (r4 == r6) goto L24
            if (r4 != r7) goto L1f
            goto L24
        L1f:
            if (r3 < r10) goto L22
            goto L25
        L22:
            r2 = r3
            goto L14
        L24:
            r10 = r2
        L25:
            int r10 = r10 - r0
            io.ktor.utils.p098io.bits.MemoryJvmKt.m6968copyToFs5fovk(r1, r8, r0, r10, r9)
            r5.discardExact(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.core.ScannerJVMKt.readUntilDelimitersDirect(io.ktor.utils.io.core.Buffer, byte, byte, byte[], int, int):int");
    }

    public static final int readUntilDelimiterDirect(Buffer buffer, byte b, Output dst) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition();
        ByteBuffer memory = buffer.getMemory();
        while (readPosition != writePosition && memory.get(readPosition) != b) {
            readPosition++;
        }
        int readPosition2 = readPosition - buffer.getReadPosition();
        OutputKt.writeFully(dst, buffer, readPosition2);
        return readPosition2;
    }

    public static final int readUntilDelimiterArrays(Buffer buffer, byte b, Output dst) {
        int i;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        ByteBuffer memory = buffer.getMemory();
        byte[] bArrArray = memory.array();
        Intrinsics.checkNotNull(bArrArray);
        int iPosition = memory.position() + memory.arrayOffset() + buffer.getReadPosition();
        int iPosition2 = memory.position() + memory.arrayOffset() + buffer.getWritePosition();
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(dst, 1, (ChunkBuffer) null);
        int i2 = 0;
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min((chunkBuffer.getLimit() - chunkBuffer.getWritePosition()) + iPosition, iPosition2);
                if (iMin <= bArrArray.length) {
                    i = iPosition;
                    while (i < iMin && bArrArray[i] != b) {
                        i++;
                    }
                } else {
                    i = iPosition;
                }
                int i3 = i - iPosition;
                BufferPrimitivesKt.writeFully((Buffer) chunkBuffer, bArrArray, iPosition, i3);
                i2 += i3;
                if (chunkBuffer.getLimit() > chunkBuffer.getWritePosition() || i >= iPosition2) {
                    break;
                }
                chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(dst, 1, chunkBufferPrepareWriteHead);
                iPosition = i;
            } catch (Throwable th) {
                UnsafeKt.afterHeadWrite(dst, chunkBufferPrepareWriteHead);
                throw th;
            }
        }
        UnsafeKt.afterHeadWrite(dst, chunkBufferPrepareWriteHead);
        buffer.discardUntilIndex$ktor_io(i);
        return i2;
    }

    public static final int readUntilDelimitersDirect(Buffer buffer, byte b, byte b2, Output dst) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition();
        ByteBuffer memory = buffer.getMemory();
        while (readPosition != writePosition) {
            byte b3 = memory.get(readPosition);
            if (b3 == b || b3 == b2) {
                break;
            }
            readPosition++;
        }
        int readPosition2 = readPosition - buffer.getReadPosition();
        OutputKt.writeFully(dst, buffer, readPosition2);
        return readPosition2;
    }

    public static final int readUntilDelimitersArrays(Buffer buffer, byte b, byte b2, Output dst) {
        int i;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        ByteBuffer memory = buffer.getMemory();
        byte[] bArrArray = memory.array();
        Intrinsics.checkNotNull(bArrArray);
        int iPosition = memory.position() + memory.arrayOffset() + buffer.getReadPosition();
        int iPosition2 = memory.position() + memory.arrayOffset() + buffer.getWritePosition();
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(dst, 1, (ChunkBuffer) null);
        int i2 = 0;
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min((chunkBuffer.getLimit() - chunkBuffer.getWritePosition()) + iPosition, iPosition2);
                if (iMin <= bArrArray.length) {
                    i = iPosition;
                    while (i < iMin) {
                        byte b3 = bArrArray[i];
                        if (b3 == b || b3 == b2) {
                            break;
                        }
                        i++;
                    }
                } else {
                    i = iPosition;
                }
                int i3 = i - iPosition;
                BufferPrimitivesKt.writeFully((Buffer) chunkBuffer, bArrArray, iPosition, i3);
                i2 += i3;
                if (chunkBuffer.getLimit() > chunkBuffer.getWritePosition() || i >= iPosition2) {
                    break;
                }
                chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(dst, 1, chunkBufferPrepareWriteHead);
                iPosition = i;
            } catch (Throwable th) {
                UnsafeKt.afterHeadWrite(dst, chunkBufferPrepareWriteHead);
                throw th;
            }
        }
        UnsafeKt.afterHeadWrite(dst, chunkBufferPrepareWriteHead);
        buffer.discardUntilIndex$ktor_io(i);
        return i2;
    }
}
