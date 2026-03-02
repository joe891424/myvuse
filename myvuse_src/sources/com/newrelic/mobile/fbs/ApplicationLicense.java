package com.newrelic.mobile.fbs;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes6.dex */
public final class ApplicationLicense extends Table {
    public static ApplicationLicense getRootAsApplicationLicense(ByteBuffer byteBuffer) {
        return getRootAsApplicationLicense(byteBuffer, new ApplicationLicense());
    }

    public static ApplicationLicense getRootAsApplicationLicense(ByteBuffer byteBuffer, ApplicationLicense applicationLicense) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return applicationLicense.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        this.bb_pos = i;
        this.f4047bb = byteBuffer;
        this.vtable_start = this.bb_pos - this.f4047bb.getInt(this.bb_pos);
        this.vtable_size = this.f4047bb.getShort(this.vtable_start);
    }

    public ApplicationLicense __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public String licenseKey() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer licenseKeyAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer licenseKeyInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public long accountId() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return this.f4047bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public boolean mutateAccountId(long j) {
        int i__offset = __offset(6);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.putLong(i__offset + this.bb_pos, j);
        return true;
    }

    public long clusterAgentId() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.f4047bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public boolean mutateClusterAgentId(long j) {
        int i__offset = __offset(8);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.putLong(i__offset + this.bb_pos, j);
        return true;
    }

    public static int createApplicationLicense(FlatBufferBuilder flatBufferBuilder, int i, long j, long j2) {
        flatBufferBuilder.startObject(3);
        addClusterAgentId(flatBufferBuilder, j2);
        addAccountId(flatBufferBuilder, j);
        addLicenseKey(flatBufferBuilder, i);
        return endApplicationLicense(flatBufferBuilder);
    }

    public static void startApplicationLicense(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(3);
    }

    public static void addLicenseKey(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static void addAccountId(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(1, j, 0L);
    }

    public static void addClusterAgentId(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(2, j, 0L);
    }

    public static int endApplicationLicense(FlatBufferBuilder flatBufferBuilder) {
        int iEndObject = flatBufferBuilder.endObject();
        flatBufferBuilder.required(iEndObject, 4);
        return iEndObject;
    }

    @Override // com.newrelic.com.google.flatbuffers.Table
    protected int keysCompare(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return compareStrings(__offset(4, num.intValue(), byteBuffer), __offset(4, num2.intValue(), byteBuffer), byteBuffer);
    }

    public static ApplicationLicense __lookup_by_key(ApplicationLicense applicationLicense, int i, String str, ByteBuffer byteBuffer) {
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
                    if (applicationLicense == null) {
                        applicationLicense = new ApplicationLicense();
                    }
                    return applicationLicense.__assign(i__indirect, byteBuffer);
                }
                int i5 = i4 + 1;
                i3 += i5;
                i2 -= i5;
            }
        }
        return null;
    }
}
