package com.newrelic.mobile.fbs.jserror;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes6.dex */
public final class JsError extends Table {
    public static JsError getRootAsJsError(ByteBuffer byteBuffer) {
        return getRootAsJsError(byteBuffer, new JsError());
    }

    public static JsError getRootAsJsError(ByteBuffer byteBuffer, JsError jsError) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return jsError.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        this.bb_pos = i;
        this.f4047bb = byteBuffer;
        this.vtable_start = this.bb_pos - this.f4047bb.getInt(this.bb_pos);
        this.vtable_size = this.f4047bb.getShort(this.vtable_start);
    }

    public JsError __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public String name() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer nameAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer nameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public String message() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer messageAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer messageInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public boolean fatal() {
        int i__offset = __offset(8);
        return (i__offset == 0 || this.f4047bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public boolean mutateFatal(boolean z) {
        int i__offset = __offset(8);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.put(i__offset + this.bb_pos, z ? (byte) 1 : (byte) 0);
        return true;
    }

    public Thread thread() {
        return thread(new Thread());
    }

    public Thread thread(Thread thread) {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return thread.__assign(__indirect(i__offset + this.bb_pos), this.f4047bb);
        }
        return null;
    }

    public String buildId() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer buildIdAsByteBuffer() {
        return __vector_as_bytebuffer(12, 1);
    }

    public ByteBuffer buildIdInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 12, 1);
    }

    public String bundleId() {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer bundleIdAsByteBuffer() {
        return __vector_as_bytebuffer(14, 1);
    }

    public ByteBuffer bundleIdInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 14, 1);
    }

    public static int createJsError(FlatBufferBuilder flatBufferBuilder, int i, int i2, boolean z, int i3, int i4, int i5) {
        flatBufferBuilder.startObject(6);
        addBundleId(flatBufferBuilder, i5);
        addBuildId(flatBufferBuilder, i4);
        addThread(flatBufferBuilder, i3);
        addMessage(flatBufferBuilder, i2);
        addName(flatBufferBuilder, i);
        addFatal(flatBufferBuilder, z);
        return endJsError(flatBufferBuilder);
    }

    public static void startJsError(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(6);
    }

    public static void addName(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static void addMessage(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static void addFatal(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.addBoolean(2, z, false);
    }

    public static void addThread(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(3, i, 0);
    }

    public static void addBuildId(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(4, i, 0);
    }

    public static void addBundleId(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(5, i, 0);
    }

    public static int endJsError(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }

    public static void finishJsErrorBuffer(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finish(i);
    }

    public static void finishSizePrefixedJsErrorBuffer(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finishSizePrefixed(i);
    }
}
