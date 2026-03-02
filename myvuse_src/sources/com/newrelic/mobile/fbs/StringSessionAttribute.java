package com.newrelic.mobile.fbs;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes6.dex */
public final class StringSessionAttribute extends Table {
    public static StringSessionAttribute getRootAsStringSessionAttribute(ByteBuffer byteBuffer) {
        return getRootAsStringSessionAttribute(byteBuffer, new StringSessionAttribute());
    }

    public static StringSessionAttribute getRootAsStringSessionAttribute(ByteBuffer byteBuffer, StringSessionAttribute stringSessionAttribute) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return stringSessionAttribute.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        this.bb_pos = i;
        this.f4047bb = byteBuffer;
        this.vtable_start = this.bb_pos - this.f4047bb.getInt(this.bb_pos);
        this.vtable_size = this.f4047bb.getShort(this.vtable_start);
    }

    public StringSessionAttribute __assign(int i, ByteBuffer byteBuffer) {
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

    public String value() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer valueAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer valueInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public static int createStringSessionAttribute(FlatBufferBuilder flatBufferBuilder, int i, int i2) {
        flatBufferBuilder.startObject(2);
        addValue(flatBufferBuilder, i2);
        addName(flatBufferBuilder, i);
        return endStringSessionAttribute(flatBufferBuilder);
    }

    public static void startStringSessionAttribute(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(2);
    }

    public static void addName(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static void addValue(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static int endStringSessionAttribute(FlatBufferBuilder flatBufferBuilder) {
        int iEndObject = flatBufferBuilder.endObject();
        flatBufferBuilder.required(iEndObject, 4);
        return iEndObject;
    }

    @Override // com.newrelic.com.google.flatbuffers.Table
    protected int keysCompare(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return compareStrings(__offset(4, num.intValue(), byteBuffer), __offset(4, num2.intValue(), byteBuffer), byteBuffer);
    }

    public static StringSessionAttribute __lookup_by_key(StringSessionAttribute stringSessionAttribute, int i, String str, ByteBuffer byteBuffer) {
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
                    if (stringSessionAttribute == null) {
                        stringSessionAttribute = new StringSessionAttribute();
                    }
                    return stringSessionAttribute.__assign(i__indirect, byteBuffer);
                }
                int i5 = i4 + 1;
                i3 += i5;
                i2 -= i5;
            }
        }
        return null;
    }
}
