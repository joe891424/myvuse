package com.newrelic.mobile.fbs.hex;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes6.dex */
public final class Frame extends Table {
    public static Frame getRootAsFrame(ByteBuffer byteBuffer) {
        return getRootAsFrame(byteBuffer, new Frame());
    }

    public static Frame getRootAsFrame(ByteBuffer byteBuffer, Frame frame) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return frame.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        this.bb_pos = i;
        this.f4047bb = byteBuffer;
        this.vtable_start = this.bb_pos - this.f4047bb.getInt(this.bb_pos);
        this.vtable_size = this.f4047bb.getShort(this.vtable_start);
    }

    public Frame __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public String value() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer valueAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer valueInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public String className() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer classNameAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer classNameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public String methodName() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer methodNameAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer methodNameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 8, 1);
    }

    public String fileName() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer fileNameAsByteBuffer() {
        return __vector_as_bytebuffer(10, 1);
    }

    public ByteBuffer fileNameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 10, 1);
    }

    public long lineNumber() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return this.f4047bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public boolean mutateLineNumber(long j) {
        int i__offset = __offset(12);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.putLong(i__offset + this.bb_pos, j);
        return true;
    }

    public long address() {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return this.f4047bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public boolean mutateAddress(long j) {
        int i__offset = __offset(14);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.putLong(i__offset + this.bb_pos, j);
        return true;
    }

    public static int createFrame(FlatBufferBuilder flatBufferBuilder, int i, int i2, int i3, int i4, long j, long j2) {
        flatBufferBuilder.startObject(6);
        addAddress(flatBufferBuilder, j2);
        addLineNumber(flatBufferBuilder, j);
        addFileName(flatBufferBuilder, i4);
        addMethodName(flatBufferBuilder, i3);
        addClassName(flatBufferBuilder, i2);
        addValue(flatBufferBuilder, i);
        return endFrame(flatBufferBuilder);
    }

    public static void startFrame(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(6);
    }

    public static void addValue(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static void addClassName(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static void addMethodName(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(2, i, 0);
    }

    public static void addFileName(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(3, i, 0);
    }

    public static void addLineNumber(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(4, j, 0L);
    }

    public static void addAddress(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(5, j, 0L);
    }

    public static int endFrame(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }
}
