package com.newrelic.mobile.fbs.hex;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import com.newrelic.mobile.fbs.ios.Library;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes6.dex */
public final class HandledException extends Table {
    public static HandledException getRootAsHandledException(ByteBuffer byteBuffer) {
        return getRootAsHandledException(byteBuffer, new HandledException());
    }

    public static HandledException getRootAsHandledException(ByteBuffer byteBuffer, HandledException handledException) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return handledException.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        this.bb_pos = i;
        this.f4047bb = byteBuffer;
        this.vtable_start = this.bb_pos - this.f4047bb.getInt(this.bb_pos);
        this.vtable_size = this.f4047bb.getShort(this.vtable_start);
    }

    public HandledException __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public long appUuidLow() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return this.f4047bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public boolean mutateAppUuidLow(long j) {
        int i__offset = __offset(4);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.putLong(i__offset + this.bb_pos, j);
        return true;
    }

    public long appUuidHigh() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return this.f4047bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public boolean mutateAppUuidHigh(long j) {
        int i__offset = __offset(6);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.putLong(i__offset + this.bb_pos, j);
        return true;
    }

    public String sessionId() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer sessionIdAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer sessionIdInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 8, 1);
    }

    public long timestampMs() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return this.f4047bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public boolean mutateTimestampMs(long j) {
        int i__offset = __offset(10);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.putLong(i__offset + this.bb_pos, j);
        return true;
    }

    public String name() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer nameAsByteBuffer() {
        return __vector_as_bytebuffer(12, 1);
    }

    public ByteBuffer nameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 12, 1);
    }

    public String message() {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer messageAsByteBuffer() {
        return __vector_as_bytebuffer(14, 1);
    }

    public ByteBuffer messageInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 14, 1);
    }

    public String cause() {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer causeAsByteBuffer() {
        return __vector_as_bytebuffer(16, 1);
    }

    public ByteBuffer causeInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 16, 1);
    }

    public Thread threads(int i) {
        return threads(new Thread(), i);
    }

    public Thread threads(Thread thread, int i) {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return thread.__assign(__indirect(__vector(i__offset) + (i * 4)), this.f4047bb);
        }
        return null;
    }

    public int threadsLength() {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public Library libraries(int i) {
        return libraries(new Library(), i);
    }

    public Library libraries(Library library, int i) {
        int i__offset = __offset(20);
        if (i__offset != 0) {
            return library.__assign(__indirect(__vector(i__offset) + (i * 4)), this.f4047bb);
        }
        return null;
    }

    public int librariesLength() {
        int i__offset = __offset(20);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public static int createHandledException(FlatBufferBuilder flatBufferBuilder, long j, long j2, int i, long j3, int i2, int i3, int i4, int i5, int i6) {
        flatBufferBuilder.startObject(9);
        addTimestampMs(flatBufferBuilder, j3);
        addAppUuidHigh(flatBufferBuilder, j2);
        addAppUuidLow(flatBufferBuilder, j);
        addLibraries(flatBufferBuilder, i6);
        addThreads(flatBufferBuilder, i5);
        addCause(flatBufferBuilder, i4);
        addMessage(flatBufferBuilder, i3);
        addName(flatBufferBuilder, i2);
        addSessionId(flatBufferBuilder, i);
        return endHandledException(flatBufferBuilder);
    }

    public static void startHandledException(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(9);
    }

    public static void addAppUuidLow(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(0, j, 0L);
    }

    public static void addAppUuidHigh(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(1, j, 0L);
    }

    public static void addSessionId(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(2, i, 0);
    }

    public static void addTimestampMs(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(3, j, 0L);
    }

    public static void addName(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(4, i, 0);
    }

    public static void addMessage(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(5, i, 0);
    }

    public static void addCause(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(6, i, 0);
    }

    public static void addThreads(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(7, i, 0);
    }

    public static int createThreadsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startThreadsVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addLibraries(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(8, i, 0);
    }

    public static int createLibrariesVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startLibrariesVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static int endHandledException(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }

    public static void finishHandledExceptionBuffer(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finish(i);
    }

    public static void finishSizePrefixedHandledExceptionBuffer(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finishSizePrefixed(i);
    }
}
