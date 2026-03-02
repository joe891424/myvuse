package io.ktor.utils.p098io.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import io.ktor.utils.p098io.bits.MemoryJvmKt;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.core.internal.UnsafeKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Scanner.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a \u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0000\u001a,\u0010\t\u001a\u00020\u0001*\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0080\bø\u0001\u0000\u001a<\u0010\t\u001a\u00020\u0001*\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0080\bø\u0001\u0000\u001a\u0012\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001a\u0010\u0015\u001a\u00020\u0013*\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a\u001a\u0010\u0016\u001a\u00020\u0013*\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e\u001a.\u0010\u0016\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u0001\u001a\"\u0010\u0017\u001a\u00020\u0013*\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e\u001a6\u0010\u0017\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, m5598d2 = {"discardUntilDelimiterImplMemory", "", "buffer", "Lio/ktor/utils/io/core/Buffer;", "delimiter", "", "discardUntilDelimitersImplMemory", "delimiter1", "delimiter2", "copyUntil", "predicate", "Lkotlin/Function1;", "", C4352k.a.f5652f, "Lio/ktor/utils/io/core/Output;", "", TypedValues.CycleType.S_WAVE_OFFSET, "length", "discardUntilDelimiter", "", "Lio/ktor/utils/io/core/Input;", "discardUntilDelimiters", "readUntilDelimiter", "readUntilDelimiters", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ScannerKt {
    public static /* synthetic */ int readUntilDelimiter$default(Input input, byte b, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = bArr.length;
        }
        return readUntilDelimiter(input, b, bArr, i, i2);
    }

    public static /* synthetic */ int readUntilDelimiters$default(Input input, byte b, byte b2, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            i2 = bArr.length;
        }
        return readUntilDelimiters(input, b, b2, bArr, i4, i2);
    }

    public static final int readUntilDelimiters(Input input, byte b, byte b2, byte[] dst, int i, int i2) throws Throwable {
        int i3;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        if (b == b2) {
            return readUntilDelimiter(input, b, dst, i, i2);
        }
        boolean z = true;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        if (chunkBufferM7223prepareReadFirstHead == null) {
            i3 = i;
        } else {
            i3 = i;
            do {
                try {
                    ChunkBuffer chunkBuffer = chunkBufferM7223prepareReadFirstHead;
                    int untilDelimitersImpl = ScannerJVMKt.readUntilDelimitersImpl(chunkBuffer, b, b2, dst, i3, i2);
                    i3 += untilDelimitersImpl;
                    i2 -= untilDelimitersImpl;
                    if (chunkBuffer.getWritePosition() <= chunkBuffer.getReadPosition() && i2 > 0) {
                        try {
                            chunkBufferM7223prepareReadFirstHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } while (chunkBufferM7223prepareReadFirstHead != null);
        }
        return i3 - i;
    }

    public static final int discardUntilDelimiterImplMemory(Buffer buffer, byte b) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition();
        ByteBuffer memory = buffer.getMemory();
        int i = readPosition;
        while (i < writePosition && memory.get(i) != b) {
            i++;
        }
        buffer.discardUntilIndex$ktor_io(i);
        return i - readPosition;
    }

    public static final int discardUntilDelimitersImplMemory(Buffer buffer, byte b, byte b2) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition();
        ByteBuffer memory = buffer.getMemory();
        int i = readPosition;
        while (i < writePosition) {
            byte b3 = memory.get(i);
            if (b3 == b || b3 == b2) {
                break;
            }
            i++;
        }
        buffer.discardUntilIndex$ktor_io(i);
        return i - readPosition;
    }

    public static final int copyUntil(Buffer buffer, Function1<? super Byte, Boolean> predicate, byte[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Intrinsics.checkNotNullParameter(dst, "dst");
        int readPosition = buffer.getReadPosition();
        int iMin = Math.min(buffer.getWritePosition(), i2 + readPosition);
        ByteBuffer memory = buffer.getMemory();
        if (readPosition < iMin) {
            int i3 = readPosition;
            while (true) {
                int i4 = i3 + 1;
                if (predicate.invoke(Byte.valueOf(memory.get(i3))).booleanValue()) {
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
        MemoryJvmKt.m6968copyToFs5fovk(memory, dst, readPosition, i5, i);
        return i5;
    }

    public static final int copyUntil(Buffer buffer, Function1<? super Byte, Boolean> predicate, Output dst) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Intrinsics.checkNotNullParameter(dst, "dst");
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition();
        ByteBuffer memory = buffer.getMemory();
        while (readPosition != writePosition && !predicate.invoke(Byte.valueOf(memory.get(readPosition))).booleanValue()) {
            readPosition++;
        }
        int readPosition2 = readPosition - buffer.getReadPosition();
        OutputKt.writeFully(dst, buffer, readPosition2);
        return readPosition2;
    }

    public static final long discardUntilDelimiter(Input input, byte b) throws Throwable {
        Intrinsics.checkNotNullParameter(input, "<this>");
        boolean z = true;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        long j = 0;
        if (chunkBufferM7223prepareReadFirstHead != null) {
            do {
                try {
                    ChunkBuffer chunkBuffer = chunkBufferM7223prepareReadFirstHead;
                    int iDiscardUntilDelimiterImpl = ScannerJVMKt.discardUntilDelimiterImpl(chunkBuffer, b);
                    j += (long) iDiscardUntilDelimiterImpl;
                    if (iDiscardUntilDelimiterImpl > 0 && chunkBuffer.getWritePosition() <= chunkBuffer.getReadPosition()) {
                        try {
                            chunkBufferM7223prepareReadFirstHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } while (chunkBufferM7223prepareReadFirstHead != null);
        }
        return j;
    }

    public static final long discardUntilDelimiters(Input input, byte b, byte b2) throws Throwable {
        Intrinsics.checkNotNullParameter(input, "<this>");
        boolean z = true;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        long j = 0;
        if (chunkBufferM7223prepareReadFirstHead != null) {
            do {
                try {
                    ChunkBuffer chunkBuffer = chunkBufferM7223prepareReadFirstHead;
                    int iDiscardUntilDelimitersImpl = ScannerJVMKt.discardUntilDelimitersImpl(chunkBuffer, b, b2);
                    j += (long) iDiscardUntilDelimitersImpl;
                    if (iDiscardUntilDelimitersImpl > 0 && chunkBuffer.getWritePosition() <= chunkBuffer.getReadPosition()) {
                        try {
                            chunkBufferM7223prepareReadFirstHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } while (chunkBufferM7223prepareReadFirstHead != null);
        }
        return j;
    }

    public static final int readUntilDelimiter(Input input, byte b, byte[] dst, int i, int i2) throws Throwable {
        int i3;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        boolean z = true;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        if (chunkBufferM7223prepareReadFirstHead == null) {
            i3 = i;
        } else {
            i3 = i;
            do {
                try {
                    ChunkBuffer chunkBuffer = chunkBufferM7223prepareReadFirstHead;
                    int untilDelimiterImpl = ScannerJVMKt.readUntilDelimiterImpl(chunkBuffer, b, dst, i3, i2);
                    i3 += untilDelimiterImpl;
                    i2 -= untilDelimiterImpl;
                    if (i2 > 0 && chunkBuffer.getWritePosition() <= chunkBuffer.getReadPosition()) {
                        try {
                            chunkBufferM7223prepareReadFirstHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } while (chunkBufferM7223prepareReadFirstHead != null);
        }
        return i3 - i;
    }

    public static final long readUntilDelimiter(Input input, byte b, Output dst) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        boolean z = true;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        long untilDelimiterImpl = 0;
        if (chunkBufferM7223prepareReadFirstHead != null) {
            while (true) {
                try {
                    ChunkBuffer chunkBuffer = chunkBufferM7223prepareReadFirstHead;
                    untilDelimiterImpl += (long) ScannerJVMKt.readUntilDelimiterImpl(chunkBuffer, b, dst);
                    if (!(chunkBuffer.getWritePosition() > chunkBuffer.getReadPosition())) {
                        try {
                            chunkBufferM7223prepareReadFirstHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                            if (chunkBufferM7223prepareReadFirstHead == null) {
                                break;
                            }
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return untilDelimiterImpl;
    }

    public static final long readUntilDelimiters(Input input, byte b, byte b2, Output dst) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        boolean z = true;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        long untilDelimitersImpl = 0;
        if (chunkBufferM7223prepareReadFirstHead != null) {
            while (true) {
                try {
                    ChunkBuffer chunkBuffer = chunkBufferM7223prepareReadFirstHead;
                    untilDelimitersImpl += (long) ScannerJVMKt.readUntilDelimitersImpl(chunkBuffer, b, b2, dst);
                    if (!(chunkBuffer.getWritePosition() > chunkBuffer.getReadPosition())) {
                        try {
                            chunkBufferM7223prepareReadFirstHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                            if (chunkBufferM7223prepareReadFirstHead == null) {
                                break;
                            }
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return untilDelimitersImpl;
    }
}
