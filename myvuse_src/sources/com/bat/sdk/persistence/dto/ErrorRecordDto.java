package com.bat.sdk.persistence.dto;

import com.bat.sdk.model.ErrorRecord;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ErrorRecordDto.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, m5598d2 = {"Lcom/bat/sdk/persistence/dto/ErrorRecordDto;", "", "id", "", "code", "", "timestamp", "Ljava/util/Date;", "<init>", "(JILjava/util/Date;)V", "getId", "()J", "getCode", "()I", "getTimestamp", "()Ljava/util/Date;", "toErrorRecord", "Lcom/bat/sdk/model/ErrorRecord;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class ErrorRecordDto {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int code;
    private final long id;
    private final Date timestamp;

    public static /* synthetic */ ErrorRecordDto copy$default(ErrorRecordDto errorRecordDto, long j, int i, Date date, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = errorRecordDto.id;
        }
        if ((i2 & 2) != 0) {
            i = errorRecordDto.code;
        }
        if ((i2 & 4) != 0) {
            date = errorRecordDto.timestamp;
        }
        return errorRecordDto.copy(j, i, date);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Date getTimestamp() {
        return this.timestamp;
    }

    public final ErrorRecordDto copy(long id, int code, Date timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        return new ErrorRecordDto(id, code, timestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ErrorRecordDto)) {
            return false;
        }
        ErrorRecordDto errorRecordDto = (ErrorRecordDto) other;
        return this.id == errorRecordDto.id && this.code == errorRecordDto.code && Intrinsics.areEqual(this.timestamp, errorRecordDto.timestamp);
    }

    public int hashCode() {
        return (((Long.hashCode(this.id) * 31) + Integer.hashCode(this.code)) * 31) + this.timestamp.hashCode();
    }

    public String toString() {
        return "ErrorRecordDto(id=" + this.id + ", code=" + this.code + ", timestamp=" + this.timestamp + ')';
    }

    public ErrorRecordDto(long j, int i, Date timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        this.id = j;
        this.code = i;
        this.timestamp = timestamp;
    }

    public /* synthetic */ ErrorRecordDto(long j, int i, Date date, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, i, date);
    }

    public final long getId() {
        return this.id;
    }

    public final int getCode() {
        return this.code;
    }

    public final Date getTimestamp() {
        return this.timestamp;
    }

    public final ErrorRecord toErrorRecord() {
        return new ErrorRecord(this.code, this.timestamp, null, 4, null);
    }

    /* JADX INFO: compiled from: ErrorRecordDto.kt */
    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m5598d2 = {"Lcom/bat/sdk/persistence/dto/ErrorRecordDto$Companion;", "", "<init>", "()V", "fromErrorRecord", "Lcom/bat/sdk/persistence/dto/ErrorRecordDto;", "record", "Lcom/bat/sdk/model/ErrorRecord;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ErrorRecordDto fromErrorRecord(ErrorRecord record) {
            Intrinsics.checkNotNullParameter(record, "record");
            return new ErrorRecordDto(0L, record.getCode(), record.getTimestamp(), 1, null);
        }
    }
}
