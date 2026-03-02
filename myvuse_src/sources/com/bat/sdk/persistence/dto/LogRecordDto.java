package com.bat.sdk.persistence.dto;

import com.bat.sdk.model.LogRecord;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LogRecordDto.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0001.BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u001e\u001a\u00020\u001fJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\t\u0010'\u001a\u00020\u000eHÆ\u0003JY\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0005HÖ\u0001J\t\u0010-\u001a\u00020\u000eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006/"}, m5598d2 = {"Lcom/bat/sdk/persistence/dto/LogRecordDto;", "", "id", "", FirebaseAnalytics.Param.INDEX, "", "timestamp", "Ljava/util/Date;", "type", "code", "data", "", "originalData", "deviceAddress", "", "<init>", "(JILjava/util/Date;II[B[BLjava/lang/String;)V", "getId", "()J", "getIndex", "()I", "getTimestamp", "()Ljava/util/Date;", "getType", "getCode", "getData", "()[B", "getOriginalData", "getDeviceAddress", "()Ljava/lang/String;", "toLogRecord", "Lcom/bat/sdk/model/LogRecord$Data;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class LogRecordDto {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int code;
    private final byte[] data;
    private final String deviceAddress;
    private final long id;
    private final int index;
    private final byte[] originalData;
    private final Date timestamp;
    private final int type;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Date getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final byte[] getOriginalData() {
        return this.originalData;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDeviceAddress() {
        return this.deviceAddress;
    }

    public final LogRecordDto copy(long id, int index, Date timestamp, int type, int code, byte[] data, byte[] originalData, String deviceAddress) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(originalData, "originalData");
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        return new LogRecordDto(id, index, timestamp, type, code, data, originalData, deviceAddress);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogRecordDto)) {
            return false;
        }
        LogRecordDto logRecordDto = (LogRecordDto) other;
        return this.id == logRecordDto.id && this.index == logRecordDto.index && Intrinsics.areEqual(this.timestamp, logRecordDto.timestamp) && this.type == logRecordDto.type && this.code == logRecordDto.code && Intrinsics.areEqual(this.data, logRecordDto.data) && Intrinsics.areEqual(this.originalData, logRecordDto.originalData) && Intrinsics.areEqual(this.deviceAddress, logRecordDto.deviceAddress);
    }

    public int hashCode() {
        return (((((((((((((Long.hashCode(this.id) * 31) + Integer.hashCode(this.index)) * 31) + this.timestamp.hashCode()) * 31) + Integer.hashCode(this.type)) * 31) + Integer.hashCode(this.code)) * 31) + Arrays.hashCode(this.data)) * 31) + Arrays.hashCode(this.originalData)) * 31) + this.deviceAddress.hashCode();
    }

    public String toString() {
        return "LogRecordDto(id=" + this.id + ", index=" + this.index + ", timestamp=" + this.timestamp + ", type=" + this.type + ", code=" + this.code + ", data=" + Arrays.toString(this.data) + ", originalData=" + Arrays.toString(this.originalData) + ", deviceAddress=" + this.deviceAddress + ')';
    }

    public LogRecordDto(long j, int i, Date timestamp, int i2, int i3, byte[] data, byte[] originalData, String deviceAddress) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(originalData, "originalData");
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        this.id = j;
        this.index = i;
        this.timestamp = timestamp;
        this.type = i2;
        this.code = i3;
        this.data = data;
        this.originalData = originalData;
        this.deviceAddress = deviceAddress;
    }

    public /* synthetic */ LogRecordDto(long j, int i, Date date, int i2, int i3, byte[] bArr, byte[] bArr2, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0L : j, i, date, i2, i3, bArr, bArr2, str);
    }

    public final long getId() {
        return this.id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final Date getTimestamp() {
        return this.timestamp;
    }

    public final int getType() {
        return this.type;
    }

    public final int getCode() {
        return this.code;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final byte[] getOriginalData() {
        return this.originalData;
    }

    public final String getDeviceAddress() {
        return this.deviceAddress;
    }

    public final LogRecord.Data toLogRecord() {
        return new LogRecord.Data(this.index, this.timestamp, this.type, this.code, this.data, this.originalData, null, 64, null);
    }

    /* JADX INFO: compiled from: LogRecordDto.kt */
    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, m5598d2 = {"Lcom/bat/sdk/persistence/dto/LogRecordDto$Companion;", "", "<init>", "()V", "fromLogRecord", "Lcom/bat/sdk/persistence/dto/LogRecordDto;", "record", "Lcom/bat/sdk/model/LogRecord;", "deviceAddress", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LogRecordDto fromLogRecord(LogRecord record, String deviceAddress) {
            Intrinsics.checkNotNullParameter(record, "record");
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            if (!(record instanceof LogRecord.Data)) {
                return null;
            }
            LogRecord.Data data = (LogRecord.Data) record;
            return new LogRecordDto(0L, data.getIndex(), data.getTimestamp(), data.getType(), data.getCode(), data.getData(), data.getOriginalData(), deviceAddress, 1, null);
        }
    }
}
