package com.bat.sdk.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PowerSaveMode.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013JN\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013¨\u0006#"}, m5598d2 = {"Lcom/bat/sdk/model/PowerSaveMode;", "", "manualPowerSaveModeEnabled", "", "autoPowerSaveModeEnabled", "powerSaveModeEnable", "batteryThreshold", "", "powerSaveModeSetting", "batterySavingPowerLevel", "<init>", "(ZZZILjava/lang/Integer;Ljava/lang/Integer;)V", "getManualPowerSaveModeEnabled", "()Z", "getAutoPowerSaveModeEnabled", "getPowerSaveModeEnable", "getBatteryThreshold", "()I", "getPowerSaveModeSetting", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBatterySavingPowerLevel", "toString", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZZZILjava/lang/Integer;Ljava/lang/Integer;)Lcom/bat/sdk/model/PowerSaveMode;", "equals", "other", "hashCode", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class PowerSaveMode {
    private final boolean autoPowerSaveModeEnabled;
    private final Integer batterySavingPowerLevel;
    private final int batteryThreshold;
    private final boolean manualPowerSaveModeEnabled;
    private final boolean powerSaveModeEnable;
    private final Integer powerSaveModeSetting;

    public PowerSaveMode() {
        this(false, false, false, 0, null, null, 63, null);
    }

    public static /* synthetic */ PowerSaveMode copy$default(PowerSaveMode powerSaveMode, boolean z, boolean z2, boolean z3, int i, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = powerSaveMode.manualPowerSaveModeEnabled;
        }
        if ((i2 & 2) != 0) {
            z2 = powerSaveMode.autoPowerSaveModeEnabled;
        }
        boolean z4 = z2;
        if ((i2 & 4) != 0) {
            z3 = powerSaveMode.powerSaveModeEnable;
        }
        boolean z5 = z3;
        if ((i2 & 8) != 0) {
            i = powerSaveMode.batteryThreshold;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            num = powerSaveMode.powerSaveModeSetting;
        }
        Integer num3 = num;
        if ((i2 & 32) != 0) {
            num2 = powerSaveMode.batterySavingPowerLevel;
        }
        return powerSaveMode.copy(z, z4, z5, i3, num3, num2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getManualPowerSaveModeEnabled() {
        return this.manualPowerSaveModeEnabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getAutoPowerSaveModeEnabled() {
        return this.autoPowerSaveModeEnabled;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getPowerSaveModeEnable() {
        return this.powerSaveModeEnable;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getBatteryThreshold() {
        return this.batteryThreshold;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getPowerSaveModeSetting() {
        return this.powerSaveModeSetting;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getBatterySavingPowerLevel() {
        return this.batterySavingPowerLevel;
    }

    public final PowerSaveMode copy(boolean manualPowerSaveModeEnabled, boolean autoPowerSaveModeEnabled, boolean powerSaveModeEnable, int batteryThreshold, Integer powerSaveModeSetting, Integer batterySavingPowerLevel) {
        return new PowerSaveMode(manualPowerSaveModeEnabled, autoPowerSaveModeEnabled, powerSaveModeEnable, batteryThreshold, powerSaveModeSetting, batterySavingPowerLevel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PowerSaveMode)) {
            return false;
        }
        PowerSaveMode powerSaveMode = (PowerSaveMode) other;
        return this.manualPowerSaveModeEnabled == powerSaveMode.manualPowerSaveModeEnabled && this.autoPowerSaveModeEnabled == powerSaveMode.autoPowerSaveModeEnabled && this.powerSaveModeEnable == powerSaveMode.powerSaveModeEnable && this.batteryThreshold == powerSaveMode.batteryThreshold && Intrinsics.areEqual(this.powerSaveModeSetting, powerSaveMode.powerSaveModeSetting) && Intrinsics.areEqual(this.batterySavingPowerLevel, powerSaveMode.batterySavingPowerLevel);
    }

    public int hashCode() {
        int iHashCode = ((((((Boolean.hashCode(this.manualPowerSaveModeEnabled) * 31) + Boolean.hashCode(this.autoPowerSaveModeEnabled)) * 31) + Boolean.hashCode(this.powerSaveModeEnable)) * 31) + Integer.hashCode(this.batteryThreshold)) * 31;
        Integer num = this.powerSaveModeSetting;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.batterySavingPowerLevel;
        return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public PowerSaveMode(boolean z, boolean z2, boolean z3, int i, Integer num, Integer num2) {
        this.manualPowerSaveModeEnabled = z;
        this.autoPowerSaveModeEnabled = z2;
        this.powerSaveModeEnable = z3;
        this.batteryThreshold = i;
        this.powerSaveModeSetting = num;
        this.batterySavingPowerLevel = num2;
    }

    public /* synthetic */ PowerSaveMode(boolean z, boolean z2, boolean z3, int i, Integer num, Integer num2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) == 0 ? z3 : false, (i2 & 8) != 0 ? 20 : i, (i2 & 16) != 0 ? null : num, (i2 & 32) != 0 ? null : num2);
    }

    public final boolean getManualPowerSaveModeEnabled() {
        return this.manualPowerSaveModeEnabled;
    }

    public final boolean getAutoPowerSaveModeEnabled() {
        return this.autoPowerSaveModeEnabled;
    }

    public final boolean getPowerSaveModeEnable() {
        return this.powerSaveModeEnable;
    }

    public final int getBatteryThreshold() {
        return this.batteryThreshold;
    }

    public final Integer getPowerSaveModeSetting() {
        return this.powerSaveModeSetting;
    }

    public final Integer getBatterySavingPowerLevel() {
        return this.batterySavingPowerLevel;
    }

    public String toString() {
        return "PowerSaveMode(manualPowerSaveModeEnabled=" + this.manualPowerSaveModeEnabled + ", autoPowerSaveModeEnabled=" + this.autoPowerSaveModeEnabled + ", powerSaveModeEnable=" + this.powerSaveModeEnable + ", batteryThreshold=" + this.batteryThreshold + ')';
    }
}
