package com.newrelic.mobile.fbs;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes6.dex */
public final class HexAgentDataBundle extends Table {
    public static HexAgentDataBundle getRootAsHexAgentDataBundle(ByteBuffer byteBuffer) {
        return getRootAsHexAgentDataBundle(byteBuffer, new HexAgentDataBundle());
    }

    public static HexAgentDataBundle getRootAsHexAgentDataBundle(ByteBuffer byteBuffer, HexAgentDataBundle hexAgentDataBundle) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return hexAgentDataBundle.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        this.bb_pos = i;
        this.f4047bb = byteBuffer;
        this.vtable_start = this.bb_pos - this.f4047bb.getInt(this.bb_pos);
        this.vtable_size = this.f4047bb.getShort(this.vtable_start);
    }

    public HexAgentDataBundle __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public HexAgentData hexAgentData(int i) {
        return hexAgentData(new HexAgentData(), i);
    }

    public HexAgentData hexAgentData(HexAgentData hexAgentData, int i) {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return hexAgentData.__assign(__indirect(__vector(i__offset) + (i * 4)), this.f4047bb);
        }
        return null;
    }

    public int hexAgentDataLength() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public static int createHexAgentDataBundle(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startObject(1);
        addHexAgentData(flatBufferBuilder, i);
        return endHexAgentDataBundle(flatBufferBuilder);
    }

    public static void startHexAgentDataBundle(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(1);
    }

    public static void addHexAgentData(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static int createHexAgentDataVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startHexAgentDataVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static int endHexAgentDataBundle(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }

    public static void finishHexAgentDataBundleBuffer(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finish(i);
    }

    public static void finishSizePrefixedHexAgentDataBundleBuffer(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finishSizePrefixed(i);
    }
}
