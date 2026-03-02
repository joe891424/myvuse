package com.newrelic.mobile.fbs;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes6.dex */
public final class ApplicationInfo extends Table {
    public static ApplicationInfo getRootAsApplicationInfo(ByteBuffer byteBuffer) {
        return getRootAsApplicationInfo(byteBuffer, new ApplicationInfo());
    }

    public static ApplicationInfo getRootAsApplicationInfo(ByteBuffer byteBuffer, ApplicationInfo applicationInfo) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return applicationInfo.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        this.bb_pos = i;
        this.f4047bb = byteBuffer;
        this.vtable_start = this.bb_pos - this.f4047bb.getInt(this.bb_pos);
        this.vtable_size = this.f4047bb.getShort(this.vtable_start);
    }

    public ApplicationInfo __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public ApplicationLicense applicationLicense() {
        return applicationLicense(new ApplicationLicense());
    }

    public ApplicationLicense applicationLicense(ApplicationLicense applicationLicense) {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return applicationLicense.__assign(__indirect(i__offset + this.bb_pos), this.f4047bb);
        }
        return null;
    }

    public int platform() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return this.f4047bb.get(i__offset + this.bb_pos) & 255;
        }
        return 0;
    }

    public boolean mutatePlatform(int i) {
        int i__offset = __offset(6);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.put(i__offset + this.bb_pos, (byte) i);
        return true;
    }

    public String appVersion() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer appVersionAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer appVersionInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 8, 1);
    }

    public long appVersionId() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return this.f4047bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public boolean mutateAppVersionId(long j) {
        int i__offset = __offset(10);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.putLong(i__offset + this.bb_pos, j);
        return true;
    }

    public int framework() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return this.f4047bb.get(i__offset + this.bb_pos) & 255;
        }
        return 0;
    }

    public boolean mutateFramework(int i) {
        int i__offset = __offset(12);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.put(i__offset + this.bb_pos, (byte) i);
        return true;
    }

    public static int createApplicationInfo(FlatBufferBuilder flatBufferBuilder, int i, int i2, int i3, long j, int i4) {
        flatBufferBuilder.startObject(5);
        addAppVersionId(flatBufferBuilder, j);
        addAppVersion(flatBufferBuilder, i3);
        addApplicationLicense(flatBufferBuilder, i);
        addFramework(flatBufferBuilder, i4);
        addPlatform(flatBufferBuilder, i2);
        return endApplicationInfo(flatBufferBuilder);
    }

    public static void startApplicationInfo(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(5);
    }

    public static void addApplicationLicense(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static void addPlatform(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addByte(1, (byte) i, 0);
    }

    public static void addAppVersion(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(2, i, 0);
    }

    public static void addAppVersionId(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(3, j, 0L);
    }

    public static void addFramework(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addByte(4, (byte) i, 0);
    }

    public static int endApplicationInfo(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }
}
