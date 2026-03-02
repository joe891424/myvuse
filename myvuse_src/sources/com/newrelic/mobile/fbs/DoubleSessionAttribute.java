package com.newrelic.mobile.fbs;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes6.dex */
public final class DoubleSessionAttribute extends Table {
    public static DoubleSessionAttribute getRootAsDoubleSessionAttribute(ByteBuffer byteBuffer) {
        return getRootAsDoubleSessionAttribute(byteBuffer, new DoubleSessionAttribute());
    }

    public static DoubleSessionAttribute getRootAsDoubleSessionAttribute(ByteBuffer byteBuffer, DoubleSessionAttribute doubleSessionAttribute) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return doubleSessionAttribute.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        this.bb_pos = i;
        this.f4047bb = byteBuffer;
        this.vtable_start = this.bb_pos - this.f4047bb.getInt(this.bb_pos);
        this.vtable_size = this.f4047bb.getShort(this.vtable_start);
    }

    public DoubleSessionAttribute __assign(int i, ByteBuffer byteBuffer) {
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

    public double value() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return this.f4047bb.getDouble(i__offset + this.bb_pos);
        }
        return 0.0d;
    }

    public boolean mutateValue(double d) {
        int i__offset = __offset(6);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.putDouble(i__offset + this.bb_pos, d);
        return true;
    }

    public static int createDoubleSessionAttribute(FlatBufferBuilder flatBufferBuilder, int i, double d) {
        flatBufferBuilder.startObject(2);
        addValue(flatBufferBuilder, d);
        addName(flatBufferBuilder, i);
        return endDoubleSessionAttribute(flatBufferBuilder);
    }

    public static void startDoubleSessionAttribute(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(2);
    }

    public static void addName(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static void addValue(FlatBufferBuilder flatBufferBuilder, double d) {
        flatBufferBuilder.addDouble(1, d, 0.0d);
    }

    public static int endDoubleSessionAttribute(FlatBufferBuilder flatBufferBuilder) {
        int iEndObject = flatBufferBuilder.endObject();
        flatBufferBuilder.required(iEndObject, 4);
        return iEndObject;
    }

    @Override // com.newrelic.com.google.flatbuffers.Table
    protected int keysCompare(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return compareStrings(__offset(4, num.intValue(), byteBuffer), __offset(4, num2.intValue(), byteBuffer), byteBuffer);
    }

    public static DoubleSessionAttribute __lookup_by_key(DoubleSessionAttribute doubleSessionAttribute, int i, String str, ByteBuffer byteBuffer) {
        byte[] bytes = str.getBytes(Table.UTF8_CHARSET.get());
        int i2 = byteBuffer.getInt(i - 4);
        int i3 = 0;
        while (i2 != 0) {
            int i4 = i2 / 2;
            int i__indirect = __indirect(((i3 + i4) * 4) + i, byteBuffer);
            int iCompareStrings = compareStrings(__offset(4, byteBuffer.capacity() - i__indirect, byteBuffer), bytes, byteBuffer);
            if (iCompareStrings > 0) {
                i2 = i4;
            } else {
                if (iCompareStrings >= 0) {
                    if (doubleSessionAttribute == null) {
                        doubleSessionAttribute = new DoubleSessionAttribute();
                    }
                    return doubleSessionAttribute.__assign(i__indirect, byteBuffer);
                }
                int i5 = i4 + 1;
                i3 += i5;
                i2 -= i5;
            }
        }
        return null;
    }
}
