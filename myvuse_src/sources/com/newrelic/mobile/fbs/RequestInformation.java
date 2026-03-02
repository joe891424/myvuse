package com.newrelic.mobile.fbs;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: loaded from: classes6.dex */
public final class RequestInformation extends Table {
    public static RequestInformation getRootAsRequestInformation(ByteBuffer byteBuffer) {
        return getRootAsRequestInformation(byteBuffer, new RequestInformation());
    }

    public static RequestInformation getRootAsRequestInformation(ByteBuffer byteBuffer, RequestInformation requestInformation) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return requestInformation.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        this.bb_pos = i;
        this.f4047bb = byteBuffer;
        this.vtable_start = this.bb_pos - this.f4047bb.getInt(this.bb_pos);
        this.vtable_size = this.f4047bb.getShort(this.vtable_start);
    }

    public RequestInformation __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public long requestTimestampMs() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return this.f4047bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public boolean mutateRequestTimestampMs(long j) {
        int i__offset = __offset(4);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.putLong(i__offset + this.bb_pos, j);
        return true;
    }

    public long requestAddress() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return ((long) this.f4047bb.getInt(i__offset + this.bb_pos)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        }
        return 0L;
    }

    public boolean mutateRequestAddress(long j) {
        int i__offset = __offset(6);
        if (i__offset == 0) {
            return false;
        }
        this.f4047bb.putInt(i__offset + this.bb_pos, (int) j);
        return true;
    }

    public static int createRequestInformation(FlatBufferBuilder flatBufferBuilder, long j, long j2) {
        flatBufferBuilder.startObject(2);
        addRequestTimestampMs(flatBufferBuilder, j);
        addRequestAddress(flatBufferBuilder, j2);
        return endRequestInformation(flatBufferBuilder);
    }

    public static void startRequestInformation(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(2);
    }

    public static void addRequestTimestampMs(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(0, j, 0L);
    }

    public static void addRequestAddress(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(1, (int) j, 0);
    }

    public static int endRequestInformation(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }
}
