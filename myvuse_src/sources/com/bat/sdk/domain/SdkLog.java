package com.bat.sdk.domain;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkLog.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m5598d2 = {"Lcom/bat/sdk/domain/SdkLog;", "", "date", "Ljava/util/Date;", "message", "", "<init>", "(Ljava/util/Date;Ljava/lang/String;)V", "getDate", "()Ljava/util/Date;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class SdkLog {
    private final Date date;
    private final String message;

    public static /* synthetic */ SdkLog copy$default(SdkLog sdkLog, Date date, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            date = sdkLog.date;
        }
        if ((i & 2) != 0) {
            str = sdkLog.message;
        }
        return sdkLog.copy(date, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Date getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final SdkLog copy(Date date, String message) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(message, "message");
        return new SdkLog(date, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SdkLog)) {
            return false;
        }
        SdkLog sdkLog = (SdkLog) other;
        return Intrinsics.areEqual(this.date, sdkLog.date) && Intrinsics.areEqual(this.message, sdkLog.message);
    }

    public int hashCode() {
        return (this.date.hashCode() * 31) + this.message.hashCode();
    }

    public String toString() {
        return "SdkLog(date=" + this.date + ", message=" + this.message + ')';
    }

    public SdkLog(Date date, String message) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(message, "message");
        this.date = date;
        this.message = message;
    }

    public final Date getDate() {
        return this.date;
    }

    public final String getMessage() {
        return this.message;
    }
}
