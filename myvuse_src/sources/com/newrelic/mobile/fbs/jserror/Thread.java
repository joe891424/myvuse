package com.newrelic.mobile.fbs.jserror;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes6.dex */
public final class Thread extends Table {
    public static Thread getRootAsThread(ByteBuffer byteBuffer) {
        return getRootAsThread(byteBuffer, new Thread());
    }

    public static Thread getRootAsThread(ByteBuffer byteBuffer, Thread thread) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return thread.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        this.bb_pos = i;
        this.f4047bb = byteBuffer;
        this.vtable_start = this.bb_pos - this.f4047bb.getInt(this.bb_pos);
        this.vtable_size = this.f4047bb.getShort(this.vtable_start);
    }

    public Thread __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public Frame frames(int i) {
        return frames(new Frame(), i);
    }

    public Frame frames(Frame frame, int i) {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return frame.__assign(__indirect(__vector(i__offset) + (i * 4)), this.f4047bb);
        }
        return null;
    }

    public int framesLength() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public static int createThread(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startObject(1);
        addFrames(flatBufferBuilder, i);
        return endThread(flatBufferBuilder);
    }

    public static void startThread(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(1);
    }

    public static void addFrames(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static int createFramesVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startFramesVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static int endThread(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }
}
