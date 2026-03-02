package com.newrelic.mobile.fbs.models;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes6.dex */
public final class InteractionTraceBundle extends Table {
    public static InteractionTraceBundle getRootAsInteractionTraceBundle(ByteBuffer byteBuffer) {
        return getRootAsInteractionTraceBundle(byteBuffer, new InteractionTraceBundle());
    }

    public static InteractionTraceBundle getRootAsInteractionTraceBundle(ByteBuffer byteBuffer, InteractionTraceBundle interactionTraceBundle) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return interactionTraceBundle.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        this.bb_pos = i;
        this.f4047bb = byteBuffer;
        this.vtable_start = this.bb_pos - this.f4047bb.getInt(this.bb_pos);
        this.vtable_size = this.f4047bb.getShort(this.vtable_start);
    }

    public InteractionTraceBundle __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public int accountId() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return this.f4047bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public boolean mutateAccountId(int i) {
        int i__offset = __offset(4);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.putInt(i__offset + this.bb_pos, i);
        return true;
    }

    public long appId() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return this.f4047bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public boolean mutateAppId(long j) {
        int i__offset = __offset(6);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.putLong(i__offset + this.bb_pos, j);
        return true;
    }

    public int appVersionId() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.f4047bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public boolean mutateAppVersionId(int i) {
        int i__offset = __offset(8);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.putInt(i__offset + this.bb_pos, i);
        return true;
    }

    public String countryCode() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer countryCodeAsByteBuffer() {
        return __vector_as_bytebuffer(10, 1);
    }

    public ByteBuffer countryCodeInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 10, 1);
    }

    public String device() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer deviceAsByteBuffer() {
        return __vector_as_bytebuffer(12, 1);
    }

    public ByteBuffer deviceInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 12, 1);
    }

    /* JADX INFO: renamed from: os */
    public String m2742os() {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer osAsByteBuffer() {
        return __vector_as_bytebuffer(14, 1);
    }

    public ByteBuffer osInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 14, 1);
    }

    public String entityGuid() {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer entityGuidAsByteBuffer() {
        return __vector_as_bytebuffer(16, 1);
    }

    public ByteBuffer entityGuidInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 16, 1);
    }

    public String dispatcher() {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer dispatcherAsByteBuffer() {
        return __vector_as_bytebuffer(18, 1);
    }

    public ByteBuffer dispatcherInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 18, 1);
    }

    public InteractionTrace interactionTraces(int i) {
        return interactionTraces(new InteractionTrace(), i);
    }

    public InteractionTrace interactionTraces(InteractionTrace interactionTrace, int i) {
        int i__offset = __offset(20);
        if (i__offset != 0) {
            return interactionTrace.__assign(__indirect(__vector(i__offset) + (i * 4)), this.f4047bb);
        }
        return null;
    }

    public int interactionTracesLength() {
        int i__offset = __offset(20);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public static int createInteractionTraceBundle(FlatBufferBuilder flatBufferBuilder, int i, long j, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        flatBufferBuilder.startObject(9);
        addAppId(flatBufferBuilder, j);
        addInteractionTraces(flatBufferBuilder, i8);
        addDispatcher(flatBufferBuilder, i7);
        addEntityGuid(flatBufferBuilder, i6);
        addOs(flatBufferBuilder, i5);
        addDevice(flatBufferBuilder, i4);
        addCountryCode(flatBufferBuilder, i3);
        addAppVersionId(flatBufferBuilder, i2);
        addAccountId(flatBufferBuilder, i);
        return endInteractionTraceBundle(flatBufferBuilder);
    }

    public static void startInteractionTraceBundle(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(9);
    }

    public static void addAccountId(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addInt(0, i, 0);
    }

    public static void addAppId(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(1, j, 0L);
    }

    public static void addAppVersionId(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addInt(2, i, 0);
    }

    public static void addCountryCode(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(3, i, 0);
    }

    public static void addDevice(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(4, i, 0);
    }

    public static void addOs(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(5, i, 0);
    }

    public static void addEntityGuid(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(6, i, 0);
    }

    public static void addDispatcher(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(7, i, 0);
    }

    public static void addInteractionTraces(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(8, i, 0);
    }

    public static int createInteractionTracesVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startInteractionTracesVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static int endInteractionTraceBundle(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }

    public static void finishInteractionTraceBundleBuffer(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finish(i);
    }

    public static void finishSizePrefixedInteractionTraceBundleBuffer(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finishSizePrefixed(i);
    }
}
