package com.newrelic.mobile.fbs.models;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes6.dex */
public final class InteractionTrace extends Table {
    public static InteractionTrace getRootAsInteractionTrace(ByteBuffer byteBuffer) {
        return getRootAsInteractionTrace(byteBuffer, new InteractionTrace());
    }

    public static InteractionTrace getRootAsInteractionTrace(ByteBuffer byteBuffer, InteractionTrace interactionTrace) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return interactionTrace.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        this.bb_pos = i;
        this.f4047bb = byteBuffer;
        this.vtable_start = this.bb_pos - this.f4047bb.getInt(this.bb_pos);
        this.vtable_size = this.f4047bb.getShort(this.vtable_start);
    }

    public InteractionTrace __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public long start() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return this.f4047bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public boolean mutateStart(long j) {
        int i__offset = __offset(4);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.putLong(i__offset + this.bb_pos, j);
        return true;
    }

    public long end() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return this.f4047bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public boolean mutateEnd(long j) {
        int i__offset = __offset(6);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.putLong(i__offset + this.bb_pos, j);
        return true;
    }

    public String name() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer nameAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer nameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 8, 1);
    }

    public float duration() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return this.f4047bb.getFloat(i__offset + this.bb_pos);
        }
        return 0.0f;
    }

    public boolean mutateDuration(float f) {
        int i__offset = __offset(10);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.putFloat(i__offset + this.bb_pos, f);
        return true;
    }

    public String protocolVersion() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer protocolVersionAsByteBuffer() {
        return __vector_as_bytebuffer(12, 1);
    }

    public ByteBuffer protocolVersionInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 12, 1);
    }

    public String content() {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer contentAsByteBuffer() {
        return __vector_as_bytebuffer(14, 1);
    }

    public ByteBuffer contentInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 14, 1);
    }

    public static int createInteractionTrace(FlatBufferBuilder flatBufferBuilder, long j, long j2, int i, float f, int i2, int i3) {
        flatBufferBuilder.startObject(6);
        addEnd(flatBufferBuilder, j2);
        addStart(flatBufferBuilder, j);
        addContent(flatBufferBuilder, i3);
        addProtocolVersion(flatBufferBuilder, i2);
        addDuration(flatBufferBuilder, f);
        addName(flatBufferBuilder, i);
        return endInteractionTrace(flatBufferBuilder);
    }

    public static void startInteractionTrace(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(6);
    }

    public static void addStart(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(0, j, 0L);
    }

    public static void addEnd(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(1, j, 0L);
    }

    public static void addName(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(2, i, 0);
    }

    public static void addDuration(FlatBufferBuilder flatBufferBuilder, float f) {
        flatBufferBuilder.addFloat(3, f, 0.0d);
    }

    public static void addProtocolVersion(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(4, i, 0);
    }

    public static void addContent(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(5, i, 0);
    }

    public static int endInteractionTrace(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }
}
