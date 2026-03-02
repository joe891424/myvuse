package com.bat.sdk.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Led.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ0\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000b¨\u0006\u0019"}, m5598d2 = {"Lcom/bat/sdk/model/Led;", "", "brightnessLevel", "", "powerSaveModeBrightness", "screenSettingBrightness", "<init>", "(ILjava/lang/Integer;Ljava/lang/Integer;)V", "getBrightnessLevel", "()I", "getPowerSaveModeBrightness", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getScreenSettingBrightness", "toString", "", "component1", "component2", "component3", "copy", "(ILjava/lang/Integer;Ljava/lang/Integer;)Lcom/bat/sdk/model/Led;", "equals", "", "other", "hashCode", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class Led {
    private final int brightnessLevel;
    private final Integer powerSaveModeBrightness;
    private final Integer screenSettingBrightness;

    public Led() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ Led copy$default(Led led, int i, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = led.brightnessLevel;
        }
        if ((i2 & 2) != 0) {
            num = led.powerSaveModeBrightness;
        }
        if ((i2 & 4) != 0) {
            num2 = led.screenSettingBrightness;
        }
        return led.copy(i, num, num2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getBrightnessLevel() {
        return this.brightnessLevel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getPowerSaveModeBrightness() {
        return this.powerSaveModeBrightness;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getScreenSettingBrightness() {
        return this.screenSettingBrightness;
    }

    public final Led copy(int brightnessLevel, Integer powerSaveModeBrightness, Integer screenSettingBrightness) {
        return new Led(brightnessLevel, powerSaveModeBrightness, screenSettingBrightness);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Led)) {
            return false;
        }
        Led led = (Led) other;
        return this.brightnessLevel == led.brightnessLevel && Intrinsics.areEqual(this.powerSaveModeBrightness, led.powerSaveModeBrightness) && Intrinsics.areEqual(this.screenSettingBrightness, led.screenSettingBrightness);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.brightnessLevel) * 31;
        Integer num = this.powerSaveModeBrightness;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.screenSettingBrightness;
        return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public Led(int i, Integer num, Integer num2) {
        this.brightnessLevel = i;
        this.powerSaveModeBrightness = num;
        this.screenSettingBrightness = num2;
    }

    public /* synthetic */ Led(int i, Integer num, Integer num2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : num2);
    }

    public final int getBrightnessLevel() {
        return this.brightnessLevel;
    }

    public final Integer getPowerSaveModeBrightness() {
        return this.powerSaveModeBrightness;
    }

    public final Integer getScreenSettingBrightness() {
        return this.screenSettingBrightness;
    }

    public String toString() {
        return "Led(brightnessLevel=" + this.brightnessLevel + ", powerSaveModeBrightness=" + this.powerSaveModeBrightness + ", screenSettingBrightness=" + this.screenSettingBrightness + ')';
    }
}
