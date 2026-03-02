package com.newrelic.mobile.fbs.jserror;

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

    public String method() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer methodAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer methodInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public String fileName() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer fileNameAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer fileNameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public int lineNumber() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.f4047bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public boolean mutateLineNumber(int i) {
        int i__offset = __offset(8);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.putInt(i__offset + this.bb_pos, i);
        return true;
    }

    public int column() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return this.f4047bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public boolean mutateColumn(int i) {
        int i__offset = __offset(10);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.putInt(i__offset + this.bb_pos, i);
        return true;
    }

    public static int createFrame(FlatBufferBuilder flatBufferBuilder, int i, int i2, int i3, int i4) {
        flatBufferBuilder.startObject(4);
        addColumn(flatBufferBuilder, i4);
        addLineNumber(flatBufferBuilder, i3);
        addFileName(flatBufferBuilder, i2);
        addMethod(flatBufferBuilder, i);
        return endFrame(flatBufferBuilder);
    }

    public static void startFrame(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(4);
    }

    public static void addMethod(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static void addFileName(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static void addLineNumber(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addInt(2, i, 0);
    }

    public static void addColumn(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addInt(3, i, 0);
    }

    public static int endFrame(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }
}
