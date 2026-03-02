package com.newrelic.mobile.fbs.ios;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes6.dex */
public final class Library extends Table {
    public static Library getRootAsLibrary(ByteBuffer byteBuffer) {
        return getRootAsLibrary(byteBuffer, new Library());
    }

    public static Library getRootAsLibrary(ByteBuffer byteBuffer, Library library) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return library.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        this.bb_pos = i;
        this.f4047bb = byteBuffer;
        this.vtable_start = this.bb_pos - this.f4047bb.getInt(this.bb_pos);
        this.vtable_size = this.f4047bb.getShort(this.vtable_start);
    }

    public Library __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public long uuidLow() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return this.f4047bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public boolean mutateUuidLow(long j) {
        int i__offset = __offset(4);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.putLong(i__offset + this.bb_pos, j);
        return true;
    }

    public long uuidHigh() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return this.f4047bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public boolean mutateUuidHigh(long j) {
        int i__offset = __offset(6);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.putLong(i__offset + this.bb_pos, j);
        return true;
    }

    public long address() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.f4047bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public boolean mutateAddress(long j) {
        int i__offset = __offset(8);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.putLong(i__offset + this.bb_pos, j);
        return true;
    }

    public boolean userLibrary() {
        int i__offset = __offset(10);
        return (i__offset == 0 || this.f4047bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public boolean mutateUserLibrary(boolean z) {
        int i__offset = __offset(10);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.put(i__offset + this.bb_pos, z ? (byte) 1 : (byte) 0);
        return true;
    }

    public int arch() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return this.f4047bb.get(i__offset + this.bb_pos) & 255;
        }
        return 0;
    }

    public boolean mutateArch(int i) {
        int i__offset = __offset(12);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.put(i__offset + this.bb_pos, (byte) i);
        return true;
    }

    public long size() {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return this.f4047bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public boolean mutateSize(long j) {
        int i__offset = __offset(14);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.putLong(i__offset + this.bb_pos, j);
        return true;
    }

    public String path() {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer pathAsByteBuffer() {
        return __vector_as_bytebuffer(16, 1);
    }

    public ByteBuffer pathInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 16, 1);
    }

    public static int createLibrary(FlatBufferBuilder flatBufferBuilder, long j, long j2, long j3, boolean z, int i, long j4, int i2) {
        flatBufferBuilder.startObject(7);
        addSize(flatBufferBuilder, j4);
        addAddress(flatBufferBuilder, j3);
        addUuidHigh(flatBufferBuilder, j2);
        addUuidLow(flatBufferBuilder, j);
        addPath(flatBufferBuilder, i2);
        addArch(flatBufferBuilder, i);
        addUserLibrary(flatBufferBuilder, z);
        return endLibrary(flatBufferBuilder);
    }

    public static void startLibrary(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(7);
    }

    public static void addUuidLow(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(0, j, 0L);
    }

    public static void addUuidHigh(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(1, j, 0L);
    }

    public static void addAddress(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(2, j, 0L);
    }

    public static void addUserLibrary(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.addBoolean(3, z, false);
    }

    public static void addArch(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addByte(4, (byte) i, 0);
    }

    public static void addSize(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(5, j, 0L);
    }

    public static void addPath(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(6, i, 0);
    }

    public static int endLibrary(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }

    public static void finishLibraryBuffer(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finish(i);
    }

    public static void finishSizePrefixedLibraryBuffer(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finishSizePrefixed(i);
    }
}
