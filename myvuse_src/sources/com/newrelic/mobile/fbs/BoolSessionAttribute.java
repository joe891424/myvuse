package com.newrelic.mobile.fbs;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes6.dex */
public final class BoolSessionAttribute extends Table {
    public static BoolSessionAttribute getRootAsBoolSessionAttribute(ByteBuffer byteBuffer) {
        return getRootAsBoolSessionAttribute(byteBuffer, new BoolSessionAttribute());
    }

    public static BoolSessionAttribute getRootAsBoolSessionAttribute(ByteBuffer byteBuffer, BoolSessionAttribute boolSessionAttribute) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return boolSessionAttribute.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        this.bb_pos = i;
        this.f4047bb = byteBuffer;
        this.vtable_start = this.bb_pos - this.f4047bb.getInt(this.bb_pos);
        this.vtable_size = this.f4047bb.getShort(this.vtable_start);
    }

    public BoolSessionAttribute __assign(int i, ByteBuffer byteBuffer) {
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

    public boolean value() {
        int i__offset = __offset(6);
        return (i__offset == 0 || this.f4047bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public boolean mutateValue(boolean z) {
        int i__offset = __offset(6);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.put(i__offset + this.bb_pos, z ? (byte) 1 : (byte) 0);
        return true;
    }

    public static int createBoolSessionAttribute(FlatBufferBuilder flatBufferBuilder, int i, boolean z) {
        flatBufferBuilder.startObject(2);
        addName(flatBufferBuilder, i);
        addValue(flatBufferBuilder, z);
        return endBoolSessionAttribute(flatBufferBuilder);
    }

    public static void startBoolSessionAttribute(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(2);
    }

    public static void addName(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static void addValue(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.addBoolean(1, z, false);
    }

    public static int endBoolSessionAttribute(FlatBufferBuilder flatBufferBuilder) {
        int iEndObject = flatBufferBuilder.endObject();
        flatBufferBuilder.required(iEndObject, 4);
        return iEndObject;
    }

    @Override // com.newrelic.com.google.flatbuffers.Table
    protected int keysCompare(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return compareStrings(__offset(4, num.intValue(), byteBuffer), __offset(4, num2.intValue(), byteBuffer), byteBuffer);
    }

    public static BoolSessionAttribute __lookup_by_key(BoolSessionAttribute boolSessionAttribute, int i, String str, ByteBuffer byteBuffer) {
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
                    if (boolSessionAttribute == null) {
                        boolSessionAttribute = new BoolSessionAttribute();
                    }
                    return boolSessionAttribute.__assign(i__indirect, byteBuffer);
                }
                int i5 = i4 + 1;
                i3 += i5;
                i2 -= i5;
            }
        }
        return null;
    }
}
