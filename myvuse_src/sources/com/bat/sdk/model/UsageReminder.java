package com.bat.sdk.model;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UsageReminder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010%\u001a\u00020&H\u0016J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u008e\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u00020\n2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001fR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\"\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0014R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0014¨\u00068"}, m5598d2 = {"Lcom/bat/sdk/model/UsageReminder;", "", "usageGoal", "", "runCycle", RemoteConfigConstants.RequestFieldKey.TIME_ZONE, "", "alertType", "alertDuration", "alertDemo", "", "soundPattern", "ledColor", "ledOnDuration", "ledOffDuration", "hapticOnDuration", "hapticOffDuration", "<init>", "(IILjava/lang/Short;IIZILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;II)V", "getUsageGoal", "()I", "getRunCycle", "getTimeZone", "()Ljava/lang/Short;", "Ljava/lang/Short;", "getAlertType", "getAlertDuration", "getAlertDemo", "()Z", "getSoundPattern", "getLedColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLedOnDuration", "getLedOffDuration", "getHapticOnDuration", "getHapticOffDuration", "toString", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(IILjava/lang/Short;IIZILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;II)Lcom/bat/sdk/model/UsageReminder;", "equals", "other", "hashCode", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class UsageReminder {
    private final boolean alertDemo;
    private final int alertDuration;
    private final int alertType;
    private final int hapticOffDuration;
    private final int hapticOnDuration;
    private final Integer ledColor;
    private final Integer ledOffDuration;
    private final Integer ledOnDuration;
    private final int runCycle;
    private final int soundPattern;
    private final Short timeZone;
    private final int usageGoal;

    public UsageReminder() {
        this(0, 0, null, 0, 0, false, 0, null, null, null, 0, 0, 4095, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getUsageGoal() {
        return this.usageGoal;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Integer getLedOffDuration() {
        return this.ledOffDuration;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getHapticOnDuration() {
        return this.hapticOnDuration;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getHapticOffDuration() {
        return this.hapticOffDuration;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getRunCycle() {
        return this.runCycle;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Short getTimeZone() {
        return this.timeZone;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getAlertType() {
        return this.alertType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getAlertDuration() {
        return this.alertDuration;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getAlertDemo() {
        return this.alertDemo;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getSoundPattern() {
        return this.soundPattern;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getLedColor() {
        return this.ledColor;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getLedOnDuration() {
        return this.ledOnDuration;
    }

    public final UsageReminder copy(int usageGoal, int runCycle, Short timeZone, int alertType, int alertDuration, boolean alertDemo, int soundPattern, Integer ledColor, Integer ledOnDuration, Integer ledOffDuration, int hapticOnDuration, int hapticOffDuration) {
        return new UsageReminder(usageGoal, runCycle, timeZone, alertType, alertDuration, alertDemo, soundPattern, ledColor, ledOnDuration, ledOffDuration, hapticOnDuration, hapticOffDuration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UsageReminder)) {
            return false;
        }
        UsageReminder usageReminder = (UsageReminder) other;
        return this.usageGoal == usageReminder.usageGoal && this.runCycle == usageReminder.runCycle && Intrinsics.areEqual(this.timeZone, usageReminder.timeZone) && this.alertType == usageReminder.alertType && this.alertDuration == usageReminder.alertDuration && this.alertDemo == usageReminder.alertDemo && this.soundPattern == usageReminder.soundPattern && Intrinsics.areEqual(this.ledColor, usageReminder.ledColor) && Intrinsics.areEqual(this.ledOnDuration, usageReminder.ledOnDuration) && Intrinsics.areEqual(this.ledOffDuration, usageReminder.ledOffDuration) && this.hapticOnDuration == usageReminder.hapticOnDuration && this.hapticOffDuration == usageReminder.hapticOffDuration;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.usageGoal) * 31) + Integer.hashCode(this.runCycle)) * 31;
        Short sh = this.timeZone;
        int iHashCode2 = (((((((((iHashCode + (sh == null ? 0 : sh.hashCode())) * 31) + Integer.hashCode(this.alertType)) * 31) + Integer.hashCode(this.alertDuration)) * 31) + Boolean.hashCode(this.alertDemo)) * 31) + Integer.hashCode(this.soundPattern)) * 31;
        Integer num = this.ledColor;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.ledOnDuration;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.ledOffDuration;
        return ((((iHashCode4 + (num3 != null ? num3.hashCode() : 0)) * 31) + Integer.hashCode(this.hapticOnDuration)) * 31) + Integer.hashCode(this.hapticOffDuration);
    }

    public UsageReminder(int i, int i2, Short sh, int i3, int i4, boolean z, int i5, Integer num, Integer num2, Integer num3, int i6, int i7) {
        this.usageGoal = i;
        this.runCycle = i2;
        this.timeZone = sh;
        this.alertType = i3;
        this.alertDuration = i4;
        this.alertDemo = z;
        this.soundPattern = i5;
        this.ledColor = num;
        this.ledOnDuration = num2;
        this.ledOffDuration = num3;
        this.hapticOnDuration = i6;
        this.hapticOffDuration = i7;
    }

    public final int getUsageGoal() {
        return this.usageGoal;
    }

    public final int getRunCycle() {
        return this.runCycle;
    }

    public /* synthetic */ UsageReminder(int i, int i2, Short sh, int i3, int i4, boolean z, int i5, Integer num, Integer num2, Integer num3, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? 100 : i, (i8 & 2) != 0 ? 0 : i2, (i8 & 4) != 0 ? (short) 0 : sh, (i8 & 8) != 0 ? 3 : i3, (i8 & 16) != 0 ? 30 : i4, (i8 & 32) != 0 ? false : z, (i8 & 64) == 0 ? i5 : 3, (i8 & 128) != 0 ? 0 : num, (i8 & 256) != 0 ? 5 : num2, (i8 & 512) != 0 ? 5 : num3, (i8 & 1024) != 0 ? 5 : i6, (i8 & 2048) == 0 ? i7 : 5);
    }

    public final Short getTimeZone() {
        return this.timeZone;
    }

    public final int getAlertType() {
        return this.alertType;
    }

    public final int getAlertDuration() {
        return this.alertDuration;
    }

    public final boolean getAlertDemo() {
        return this.alertDemo;
    }

    public final int getSoundPattern() {
        return this.soundPattern;
    }

    public final Integer getLedColor() {
        return this.ledColor;
    }

    public final Integer getLedOnDuration() {
        return this.ledOnDuration;
    }

    public final Integer getLedOffDuration() {
        return this.ledOffDuration;
    }

    public final int getHapticOnDuration() {
        return this.hapticOnDuration;
    }

    public final int getHapticOffDuration() {
        return this.hapticOffDuration;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UsageReminder(usageGoal=");
        sb.append(this.usageGoal).append(", runCycle=").append(this.runCycle).append(", alertType=").append(this.alertType).append(", alertDuration=").append(this.alertDuration).append(", alertDemo=").append(this.alertDemo).append(", soundPattern=").append(this.soundPattern).append(", timeZone=").append(this.timeZone).append(",ledColor=").append(this.ledColor).append(", ledOnDuration=").append(this.ledOnDuration).append(", ledOffDuration=").append(this.ledOffDuration).append(", hapticOnDuration=").append(this.hapticOnDuration).append(", hapticOffDuration=");
        sb.append(this.hapticOffDuration).append(')');
        return sb.toString();
    }
}
