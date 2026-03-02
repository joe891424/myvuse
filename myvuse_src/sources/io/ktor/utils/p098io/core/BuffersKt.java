package io.ktor.utils.p098io.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.utils.p098io.bits.Memory;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.core.internal.DangerousInternalIoApi;
import io.ktor.utils.p098io.core.internal.UnsafeKt;
import io.ktor.utils.p098io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: Buffers.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000T\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\r\u0010\u0004\u001a\u00020\u0005*\u00020\u0001H\u0080\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0080\b\u001a\f\u0010\t\u001a\u00020\n*\u00020\nH\u0000\u001a\u001d\u0010\t\u001a\u00020\n*\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0082\u0010\u001a\r\u0010\r\u001a\u00020\n*\u00020\nH\u0080\u0010\u001a1\u0010\u000e\u001a\u00020\u000f*\u00020\n2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u0011H\u0080\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002\u001a\r\u0010\u0012\u001a\u00020\u0013*\u00020\nH\u0080\u0010\u001a>\u0010\u0014\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0001H\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0014\u0010\u001e\u001a\u00020\u001f*\u00020\u00152\b\b\u0002\u0010 \u001a\u00020\u0005\u001a\u001c\u0010!\u001a\u00020\u000f*\u0004\u0018\u00010\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0#H\u0000\u001a\f\u0010$\u001a\u00020\u000f*\u00020\u0003H\u0000\u001a\u001a\u0010$\u001a\u00020\u000f*\u00020\u00032\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030#H\u0001\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\nH\u0007\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\n2\u0006\u0010%\u001a\u00020\u0001H\u0082\u0010\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019¨\u0006&"}, m5598d2 = {"remainingAll", "", "buffer", "Lio/ktor/utils/io/core/IoBuffer;", "coerceAtMostMaxInt", "", "coerceAtMostMaxIntOrFail", "message", "", "copyAll", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "head", "prev", "findTail", "forEachChunk", "", "block", "Lkotlin/Function1;", "isEmpty", "", "peekTo", "Lio/ktor/utils/io/core/Buffer;", FirebaseAnalytics.Param.DESTINATION, "Lio/ktor/utils/io/bits/Memory;", "destinationOffset", TypedValues.CycleType.S_WAVE_OFFSET, "min", "max", "peekTo-xGV-KfY", "(Lio/ktor/utils/io/core/Buffer;Ljava/nio/ByteBuffer;JJJJ)J", "readBytes", "", NewHtcHomeBadger.COUNT, "releaseAll", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "releaseImpl", RsaJsonWebKey.MODULUS_MEMBER_NAME, "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class BuffersKt {
    public static final byte[] readBytes(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (i == 0) {
            return UnsafeKt.EmptyByteArray;
        }
        byte[] bArr = new byte[i];
        BufferPrimitivesKt.readFully$default(buffer, bArr, 0, 0, 6, (Object) null);
        return bArr;
    }

    public static final void releaseImpl(IoBuffer ioBuffer) {
        Intrinsics.checkNotNullParameter(ioBuffer, "<this>");
        releaseImpl(ioBuffer, IoBuffer.INSTANCE.getPool());
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "IoBuffer now contains ObjectPool reference", replaceWith = @ReplaceWith(expression = "releaseImpl()", imports = {}))
    public static final void releaseImpl(IoBuffer ioBuffer, ObjectPool<IoBuffer> pool) {
        Intrinsics.checkNotNullParameter(ioBuffer, "<this>");
        Intrinsics.checkNotNullParameter(pool, "pool");
        if (ioBuffer.release$ktor_io()) {
            ChunkBuffer origin = ioBuffer.getOrigin();
            ObjectPool<ChunkBuffer> parentPool$ktor_io = ioBuffer.getParentPool$ktor_io();
            if (parentPool$ktor_io == null) {
                parentPool$ktor_io = pool;
            }
            if (origin instanceof IoBuffer) {
                ioBuffer.unlink$ktor_io();
                ((IoBuffer) origin).release(pool);
            } else {
                parentPool$ktor_io.recycle(ioBuffer);
            }
        }
    }

    public static final void releaseAll(ChunkBuffer chunkBuffer, ObjectPool<ChunkBuffer> pool) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        while (chunkBuffer != null) {
            ChunkBuffer chunkBufferCleanNext = chunkBuffer.cleanNext();
            chunkBuffer.release(pool);
            chunkBuffer = chunkBufferCleanNext;
        }
    }

    public static final void forEachChunk(ChunkBuffer chunkBuffer, Function1<? super ChunkBuffer, Unit> block) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        do {
            block.invoke(chunkBuffer);
            chunkBuffer = chunkBuffer.getNext();
        } while (chunkBuffer != null);
    }

    public static final ChunkBuffer copyAll(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        ChunkBuffer chunkBufferMakeView = chunkBuffer.makeView();
        ChunkBuffer next = chunkBuffer.getNext();
        return next == null ? chunkBufferMakeView : copyAll(next, chunkBufferMakeView, chunkBufferMakeView);
    }

    private static final ChunkBuffer copyAll(ChunkBuffer chunkBuffer, ChunkBuffer chunkBuffer2, ChunkBuffer chunkBuffer3) {
        while (true) {
            ChunkBuffer chunkBufferMakeView = chunkBuffer.makeView();
            chunkBuffer3.setNext(chunkBufferMakeView);
            chunkBuffer = chunkBuffer.getNext();
            if (chunkBuffer == null) {
                return chunkBuffer2;
            }
            chunkBuffer3 = chunkBufferMakeView;
        }
    }

    public static final ChunkBuffer findTail(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        while (true) {
            ChunkBuffer next = chunkBuffer.getNext();
            if (next == null) {
                return chunkBuffer;
            }
            chunkBuffer = next;
        }
    }

    @DangerousInternalIoApi
    public static final long remainingAll(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return remainingAll(chunkBuffer, 0L);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ long remainingAll(IoBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        return remainingAll((ChunkBuffer) buffer);
    }

    private static final long remainingAll(ChunkBuffer chunkBuffer, long j) {
        do {
            ChunkBuffer chunkBuffer2 = chunkBuffer;
            j += (long) (chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition());
            chunkBuffer = chunkBuffer.getNext();
        } while (chunkBuffer != null);
        return j;
    }

    public static final boolean isEmpty(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        do {
            ChunkBuffer chunkBuffer2 = chunkBuffer;
            if (chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition() > 0) {
                return false;
            }
            chunkBuffer = chunkBuffer.getNext();
        } while (chunkBuffer != null);
        return true;
    }

    public static final int coerceAtMostMaxInt(long j) {
        return (int) Math.min(j, 2147483647L);
    }

    public static final int coerceAtMostMaxIntOrFail(long j, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (j <= 2147483647L) {
            return (int) j;
        }
        throw new IllegalArgumentException(message);
    }

    public static /* synthetic */ byte[] readBytes$default(Buffer buffer, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = buffer.getWritePosition() - buffer.getReadPosition();
        }
        return readBytes(buffer, i);
    }

    /* JADX INFO: renamed from: peekTo-xGV-KfY, reason: not valid java name */
    public static final long m7143peekToxGVKfY(Buffer peekTo, ByteBuffer destination, long j, long j2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(peekTo, "$this$peekTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        long jMin = Math.min(((long) destination.limit()) - j, Math.min(j4, peekTo.getWritePosition() - peekTo.getReadPosition()));
        Memory.m6953copyToiAfECsU(peekTo.getMemory(), destination, ((long) peekTo.getReadPosition()) + j2, jMin, j);
        return jMin;
    }
}
