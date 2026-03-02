package com.bat.sdk.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Cloud.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ`\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0014\u0010\u000fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\u000f¨\u0006%"}, m5598d2 = {"Lcom/bat/sdk/model/Cloud;", "", FirebaseAnalytics.Param.LEVEL, "", "batterySavingEnabled", "batterySavingThresholdValue", "batterySavingPowerLevel", "batterySavingOn", "heatingPowerMode", "currentLevel", "<init>", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getLevel", "()I", "getBatterySavingEnabled", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBatterySavingThresholdValue", "getBatterySavingPowerLevel", "getBatterySavingOn", "getHeatingPowerMode", "getCurrentLevel", "toString", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bat/sdk/model/Cloud;", "equals", "", "other", "hashCode", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class Cloud {
    private final Integer batterySavingEnabled;
    private final Integer batterySavingOn;
    private final Integer batterySavingPowerLevel;
    private final Integer batterySavingThresholdValue;
    private final Integer currentLevel;
    private final Integer heatingPowerMode;
    private final int level;

    public Cloud() {
        this(0, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ Cloud copy$default(Cloud cloud, int i, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = cloud.level;
        }
        if ((i2 & 2) != 0) {
            num = cloud.batterySavingEnabled;
        }
        Integer num7 = num;
        if ((i2 & 4) != 0) {
            num2 = cloud.batterySavingThresholdValue;
        }
        Integer num8 = num2;
        if ((i2 & 8) != 0) {
            num3 = cloud.batterySavingPowerLevel;
        }
        Integer num9 = num3;
        if ((i2 & 16) != 0) {
            num4 = cloud.batterySavingOn;
        }
        Integer num10 = num4;
        if ((i2 & 32) != 0) {
            num5 = cloud.heatingPowerMode;
        }
        Integer num11 = num5;
        if ((i2 & 64) != 0) {
            num6 = cloud.currentLevel;
        }
        return cloud.copy(i, num7, num8, num9, num10, num11, num6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getLevel() {
        return this.level;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getBatterySavingEnabled() {
        return this.batterySavingEnabled;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getBatterySavingThresholdValue() {
        return this.batterySavingThresholdValue;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getBatterySavingPowerLevel() {
        return this.batterySavingPowerLevel;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getBatterySavingOn() {
        return this.batterySavingOn;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getHeatingPowerMode() {
        return this.heatingPowerMode;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getCurrentLevel() {
        return this.currentLevel;
    }

    public final Cloud copy(int level, Integer batterySavingEnabled, Integer batterySavingThresholdValue, Integer batterySavingPowerLevel, Integer batterySavingOn, Integer heatingPowerMode, Integer currentLevel) {
        return new Cloud(level, batterySavingEnabled, batterySavingThresholdValue, batterySavingPowerLevel, batterySavingOn, heatingPowerMode, currentLevel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Cloud)) {
            return false;
        }
        Cloud cloud = (Cloud) other;
        return this.level == cloud.level && Intrinsics.areEqual(this.batterySavingEnabled, cloud.batterySavingEnabled) && Intrinsics.areEqual(this.batterySavingThresholdValue, cloud.batterySavingThresholdValue) && Intrinsics.areEqual(this.batterySavingPowerLevel, cloud.batterySavingPowerLevel) && Intrinsics.areEqual(this.batterySavingOn, cloud.batterySavingOn) && Intrinsics.areEqual(this.heatingPowerMode, cloud.heatingPowerMode) && Intrinsics.areEqual(this.currentLevel, cloud.currentLevel);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.level) * 31;
        Integer num = this.batterySavingEnabled;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.batterySavingThresholdValue;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.batterySavingPowerLevel;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.batterySavingOn;
        int iHashCode5 = (iHashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.heatingPowerMode;
        int iHashCode6 = (iHashCode5 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.currentLevel;
        return iHashCode6 + (num6 != null ? num6.hashCode() : 0);
    }

    public Cloud(int i, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
        this.level = i;
        this.batterySavingEnabled = num;
        this.batterySavingThresholdValue = num2;
        this.batterySavingPowerLevel = num3;
        this.batterySavingOn = num4;
        this.heatingPowerMode = num5;
        this.currentLevel = num6;
    }

    public /* synthetic */ Cloud(int i, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : num2, (i2 & 8) != 0 ? null : num3, (i2 & 16) != 0 ? null : num4, (i2 & 32) != 0 ? null : num5, (i2 & 64) == 0 ? num6 : null);
    }

    public final int getLevel() {
        return this.level;
    }

    public final Integer getBatterySavingEnabled() {
        return this.batterySavingEnabled;
    }

    public final Integer getBatterySavingThresholdValue() {
        return this.batterySavingThresholdValue;
    }

    public final Integer getBatterySavingPowerLevel() {
        return this.batterySavingPowerLevel;
    }

    public final Integer getBatterySavingOn() {
        return this.batterySavingOn;
    }

    public final Integer getHeatingPowerMode() {
        return this.heatingPowerMode;
    }

    public final Integer getCurrentLevel() {
        return this.currentLevel;
    }

    public String toString() {
        return "Cloud(level=" + this.level + ", batterySavingEnabled=" + this.batterySavingEnabled + ", batterySavingThresholdValue=" + this.batterySavingThresholdValue + ", batterySavingPowerLevel=" + this.batterySavingPowerLevel + ", batterySavingOn=" + this.batterySavingOn + ", heatingPowerMode=" + this.heatingPowerMode + ", currentLevel=" + this.currentLevel + ')';
    }
}
