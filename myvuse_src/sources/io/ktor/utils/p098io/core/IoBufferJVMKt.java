package io.ktor.utils.p098io.core;

import com.salesforce.marketingcloud.storage.p047db.C4352k;
import io.ktor.utils.p098io.bits.Memory;
import io.ktor.utils.p098io.bits.MemoryJvmKt;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IoBufferJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001\u001a1\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\u001a\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001\u001a;\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, m5598d2 = {"readAvailable", "", "Lio/ktor/utils/io/core/Buffer;", C4352k.a.f5652f, "Ljava/nio/ByteBuffer;", "length", "readDirect", "block", "Lkotlin/Function1;", "", "readFully", "writeDirect", "size", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class IoBufferJVMKt {
    public static /* synthetic */ int readAvailable$default(Buffer buffer, ByteBuffer byteBuffer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = byteBuffer.remaining();
        }
        return readAvailable(buffer, byteBuffer, i);
    }

    public static /* synthetic */ int writeDirect$default(Buffer buffer, int i, Function1 block, int i2, Object obj) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        ByteBuffer byteBufferM6961sliceSK3TCg8 = Memory.m6961sliceSK3TCg8(memory, writePosition, limit);
        block.invoke(byteBufferM6961sliceSK3TCg8);
        if (!(byteBufferM6961sliceSK3TCg8.limit() == limit)) {
            throw new IllegalStateException("Buffer's limit change is not allowed".toString());
        }
        int iPosition = byteBufferM6961sliceSK3TCg8.position();
        buffer.commitWritten(iPosition);
        return iPosition;
    }

    public static final void readFully(Buffer buffer, ByteBuffer dst, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i) {
            int iLimit = dst.limit();
            try {
                MemoryJvmKt.m6969copyTojqM8g04(memory, dst, readPosition);
                Unit unit = Unit.INSTANCE;
                buffer.discardExact(i);
                return;
            } catch (Throwable th) {
                throw th;
            }
        }
        new BufferPrimitivesKt$readExact$lambda56$$inlined$require$1("buffer content", i).doFail();
        throw new KotlinNothingValueException();
    }

    public static final int readAvailable(Buffer buffer, ByteBuffer dst, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        if (buffer.getWritePosition() <= buffer.getReadPosition()) {
            return -1;
        }
        int iMin = Math.min(buffer.getWritePosition() - buffer.getReadPosition(), i);
        readFully(buffer, dst, iMin);
        return iMin;
    }

    public static final int readDirect(Buffer buffer, Function1<? super ByteBuffer, Unit> block) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition() - readPosition;
        ByteBuffer byteBufferM6961sliceSK3TCg8 = Memory.m6961sliceSK3TCg8(memory, readPosition, writePosition);
        block.invoke(byteBufferM6961sliceSK3TCg8);
        if (!(byteBufferM6961sliceSK3TCg8.limit() == writePosition)) {
            throw new IllegalStateException("Buffer's limit change is not allowed".toString());
        }
        int iPosition = byteBufferM6961sliceSK3TCg8.position();
        buffer.discardExact(iPosition);
        return iPosition;
    }

    public static final int writeDirect(Buffer buffer, int i, Function1<? super ByteBuffer, Unit> block) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        ByteBuffer byteBufferM6961sliceSK3TCg8 = Memory.m6961sliceSK3TCg8(memory, writePosition, limit);
        block.invoke(byteBufferM6961sliceSK3TCg8);
        if (!(byteBufferM6961sliceSK3TCg8.limit() == limit)) {
            throw new IllegalStateException("Buffer's limit change is not allowed".toString());
        }
        int iPosition = byteBufferM6961sliceSK3TCg8.position();
        buffer.commitWritten(iPosition);
        return iPosition;
    }
}
