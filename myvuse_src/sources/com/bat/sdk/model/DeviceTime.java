package com.bat.sdk.model;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceTime.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ$\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, m5598d2 = {"Lcom/bat/sdk/model/DeviceTime;", "", "dateTime", "Ljava/util/Date;", RemoteConfigConstants.RequestFieldKey.TIME_ZONE, "", "<init>", "(Ljava/util/Date;Ljava/lang/Short;)V", "getDateTime", "()Ljava/util/Date;", "getTimeZone", "()Ljava/lang/Short;", "Ljava/lang/Short;", "toString", "", "component1", "component2", "copy", "(Ljava/util/Date;Ljava/lang/Short;)Lcom/bat/sdk/model/DeviceTime;", "equals", "", "other", "hashCode", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class DeviceTime {
    private final Date dateTime;
    private final Short timeZone;

    public static /* synthetic */ DeviceTime copy$default(DeviceTime deviceTime, Date date, Short sh, int i, Object obj) {
        if ((i & 1) != 0) {
            date = deviceTime.dateTime;
        }
        if ((i & 2) != 0) {
            sh = deviceTime.timeZone;
        }
        return deviceTime.copy(date, sh);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Date getDateTime() {
        return this.dateTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Short getTimeZone() {
        return this.timeZone;
    }

    public final DeviceTime copy(Date dateTime, Short timeZone) {
        Intrinsics.checkNotNullParameter(dateTime, "dateTime");
        return new DeviceTime(dateTime, timeZone);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceTime)) {
            return false;
        }
        DeviceTime deviceTime = (DeviceTime) other;
        return Intrinsics.areEqual(this.dateTime, deviceTime.dateTime) && Intrinsics.areEqual(this.timeZone, deviceTime.timeZone);
    }

    public int hashCode() {
        int iHashCode = this.dateTime.hashCode() * 31;
        Short sh = this.timeZone;
        return iHashCode + (sh == null ? 0 : sh.hashCode());
    }

    public DeviceTime(Date dateTime, Short sh) {
        Intrinsics.checkNotNullParameter(dateTime, "dateTime");
        this.dateTime = dateTime;
        this.timeZone = sh;
    }

    public /* synthetic */ DeviceTime(Date date, Short sh, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(date, (i & 2) != 0 ? null : sh);
    }

    public final Date getDateTime() {
        return this.dateTime;
    }

    public final Short getTimeZone() {
        return this.timeZone;
    }

    public String toString() {
        return "device time=" + this.dateTime;
    }
}
