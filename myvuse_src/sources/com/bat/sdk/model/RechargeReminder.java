package com.bat.sdk.model;

import androidx.core.app.FrameMetricsAggregator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RechargeReminder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\fHÆ\u0003Jn\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006,"}, m5598d2 = {"Lcom/bat/sdk/model/RechargeReminder;", "", "minBatteryThr", "", "maxBatteryThr", "ledColorMin", "ledColorMid", "ledColorMax", "alertType", "alertTrigger", "alertDuration", "alertDemo", "", "<init>", "(IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;IIIZ)V", "getMinBatteryThr", "()I", "getMaxBatteryThr", "getLedColorMin", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLedColorMid", "getLedColorMax", "getAlertType", "getAlertTrigger", "getAlertDuration", "getAlertDemo", "()Z", "toString", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;IIIZ)Lcom/bat/sdk/model/RechargeReminder;", "equals", "other", "hashCode", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class RechargeReminder {
    private final boolean alertDemo;
    private final int alertDuration;
    private final int alertTrigger;
    private final int alertType;
    private final Integer ledColorMax;
    private final Integer ledColorMid;
    private final Integer ledColorMin;
    private final int maxBatteryThr;
    private final int minBatteryThr;

    public RechargeReminder() {
        this(0, 0, null, null, null, 0, 0, 0, false, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getMinBatteryThr() {
        return this.minBatteryThr;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMaxBatteryThr() {
        return this.maxBatteryThr;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getLedColorMin() {
        return this.ledColorMin;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getLedColorMid() {
        return this.ledColorMid;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getLedColorMax() {
        return this.ledColorMax;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getAlertType() {
        return this.alertType;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getAlertTrigger() {
        return this.alertTrigger;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getAlertDuration() {
        return this.alertDuration;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getAlertDemo() {
        return this.alertDemo;
    }

    public final RechargeReminder copy(int minBatteryThr, int maxBatteryThr, Integer ledColorMin, Integer ledColorMid, Integer ledColorMax, int alertType, int alertTrigger, int alertDuration, boolean alertDemo) {
        return new RechargeReminder(minBatteryThr, maxBatteryThr, ledColorMin, ledColorMid, ledColorMax, alertType, alertTrigger, alertDuration, alertDemo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RechargeReminder)) {
            return false;
        }
        RechargeReminder rechargeReminder = (RechargeReminder) other;
        return this.minBatteryThr == rechargeReminder.minBatteryThr && this.maxBatteryThr == rechargeReminder.maxBatteryThr && Intrinsics.areEqual(this.ledColorMin, rechargeReminder.ledColorMin) && Intrinsics.areEqual(this.ledColorMid, rechargeReminder.ledColorMid) && Intrinsics.areEqual(this.ledColorMax, rechargeReminder.ledColorMax) && this.alertType == rechargeReminder.alertType && this.alertTrigger == rechargeReminder.alertTrigger && this.alertDuration == rechargeReminder.alertDuration && this.alertDemo == rechargeReminder.alertDemo;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.minBatteryThr) * 31) + Integer.hashCode(this.maxBatteryThr)) * 31;
        Integer num = this.ledColorMin;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.ledColorMid;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.ledColorMax;
        return ((((((((iHashCode3 + (num3 != null ? num3.hashCode() : 0)) * 31) + Integer.hashCode(this.alertType)) * 31) + Integer.hashCode(this.alertTrigger)) * 31) + Integer.hashCode(this.alertDuration)) * 31) + Boolean.hashCode(this.alertDemo);
    }

    public RechargeReminder(int i, int i2, Integer num, Integer num2, Integer num3, int i3, int i4, int i5, boolean z) {
        this.minBatteryThr = i;
        this.maxBatteryThr = i2;
        this.ledColorMin = num;
        this.ledColorMid = num2;
        this.ledColorMax = num3;
        this.alertType = i3;
        this.alertTrigger = i4;
        this.alertDuration = i5;
        this.alertDemo = z;
    }

    public final int getMinBatteryThr() {
        return this.minBatteryThr;
    }

    public final int getMaxBatteryThr() {
        return this.maxBatteryThr;
    }

    public /* synthetic */ RechargeReminder(int i, int i2, Integer num, Integer num2, Integer num3, int i3, int i4, int i5, boolean z, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 10 : i, (i6 & 2) != 0 ? 30 : i2, (i6 & 4) != 0 ? 4 : num, (i6 & 8) != 0 ? 3 : num2, (i6 & 16) != 0 ? 1 : num3, (i6 & 32) != 0 ? 2 : i3, (i6 & 64) == 0 ? i4 : 2, (i6 & 128) == 0 ? i5 : 10, (i6 & 256) != 0 ? false : z);
    }

    public final Integer getLedColorMin() {
        return this.ledColorMin;
    }

    public final Integer getLedColorMid() {
        return this.ledColorMid;
    }

    public final Integer getLedColorMax() {
        return this.ledColorMax;
    }

    public final int getAlertType() {
        return this.alertType;
    }

    public final int getAlertTrigger() {
        return this.alertTrigger;
    }

    public final int getAlertDuration() {
        return this.alertDuration;
    }

    public final boolean getAlertDemo() {
        return this.alertDemo;
    }

    public String toString() {
        return "RechargeReminder(minBatteryThr=" + this.minBatteryThr + ", maxBatteryThr=" + this.maxBatteryThr + ", ledColorMin=" + this.ledColorMin + ", ledColorMid=" + this.ledColorMid + ", ledColorMax=" + this.ledColorMax + ", alertType=" + this.alertType + ", alertTrigger=" + this.alertTrigger + ", alertDuration=" + this.alertDuration + ", alertDemo=" + this.alertDemo + ')';
    }
}
