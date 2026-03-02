package com.bat.sdk.model;

import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ErrorRecord.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ.\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, m5598d2 = {"Lcom/bat/sdk/model/ErrorRecord;", "", "code", "", "timestamp", "Ljava/util/Date;", "timestampSyncIndication", "<init>", "(ILjava/util/Date;Ljava/lang/Integer;)V", "getCode", "()I", "getTimestamp", "()Ljava/util/Date;", "getTimestampSyncIndication", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "description", "", "getDescription", "()Ljava/lang/String;", "description$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "copy", "(ILjava/util/Date;Ljava/lang/Integer;)Lcom/bat/sdk/model/ErrorRecord;", "equals", "", "other", "hashCode", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class ErrorRecord {
    private final int code;

    /* JADX INFO: renamed from: description$delegate, reason: from kotlin metadata */
    private final Lazy description;
    private final Date timestamp;
    private final Integer timestampSyncIndication;

    public ErrorRecord() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ ErrorRecord copy$default(ErrorRecord errorRecord, int i, Date date, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = errorRecord.code;
        }
        if ((i2 & 2) != 0) {
            date = errorRecord.timestamp;
        }
        if ((i2 & 4) != 0) {
            num = errorRecord.timestampSyncIndication;
        }
        return errorRecord.copy(i, date, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Date getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getTimestampSyncIndication() {
        return this.timestampSyncIndication;
    }

    public final ErrorRecord copy(int code, Date timestamp, Integer timestampSyncIndication) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        return new ErrorRecord(code, timestamp, timestampSyncIndication);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ErrorRecord)) {
            return false;
        }
        ErrorRecord errorRecord = (ErrorRecord) other;
        return this.code == errorRecord.code && Intrinsics.areEqual(this.timestamp, errorRecord.timestamp) && Intrinsics.areEqual(this.timestampSyncIndication, errorRecord.timestampSyncIndication);
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.code) * 31) + this.timestamp.hashCode()) * 31;
        Integer num = this.timestampSyncIndication;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "ErrorRecord(code=" + this.code + ", timestamp=" + this.timestamp + ", timestampSyncIndication=" + this.timestampSyncIndication + ')';
    }

    public ErrorRecord(int i, Date timestamp, Integer num) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        this.code = i;
        this.timestamp = timestamp;
        this.timestampSyncIndication = num;
        this.description = LazyKt.lazy(new Function0() { // from class: com.bat.sdk.model.ErrorRecord$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ErrorRecord.description_delegate$lambda$0(this.f$0);
            }
        });
    }

    public final int getCode() {
        return this.code;
    }

    public /* synthetic */ ErrorRecord(int i, Date date, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? new Date() : date, (i2 & 4) != 0 ? null : num);
    }

    public final Date getTimestamp() {
        return this.timestamp;
    }

    public final Integer getTimestampSyncIndication() {
        return this.timestampSyncIndication;
    }

    public final String getDescription() {
        return (String) this.description.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String description_delegate$lambda$0(ErrorRecord this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        switch (this$0.code) {
            case 0:
                return "No error";
            case 1:
                return "Error: bad state";
            case 2:
                return "Battery voltage off-load is too low";
            case 3:
                return "Battery voltage off-load is too high";
            case 4:
                return "Battery voltage on-load is too low";
            case 5:
                return "USB voltage is too high";
            case 6:
                return "USB voltage is too low";
            case 7:
                return "Over-temperature whilst puffing";
            case 8:
                return "Boost Converter voltage is too low";
            case 9:
                return "Boost Converter voltage is too high";
            case 10:
                return "Cartomiser current is too low";
            case 11:
                return "Cartomiser current is too high";
            case 12:
                return "Internal temperature is too low";
            case 13:
                return "Over-temperature whilst charging";
            case 14:
                return "Failed to charge";
            case 15:
                return "Vape abuse for 1st instance ";
            case 16:
                return "Vape abuse for 2nd instance";
            case 17:
                return "Vape too long";
            case 18:
                return "External flash failed";
            case 19:
                return "Charge IC Failed";
            case 20:
                return "Fuel gauge failed";
            case 21:
                return "Pressure sensor failed";
            case 22:
                return "FOTA Failed due to Low Battery";
            case 23:
                return "Reserved";
            case 24:
                return "Pod high resistance";
            case 25:
                return "Smart Pod Authentication Process Error";
            case 26:
                return "Smart Pod Read Data Process Error";
            case 27:
                return "UI Resource Update Failed";
            case 28:
                return "Heating Components Failure";
            default:
                return "Unknown error";
        }
    }
}
