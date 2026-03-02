package com.bat.sdk.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Battery.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, m5598d2 = {"Lcom/bat/sdk/model/Battery;", "", FirebaseAnalytics.Param.LEVEL, "", "chargingState", "<init>", "(II)V", "getLevel", "()I", "getChargingState", "toString", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class Battery {
    private final int chargingState;
    private final int level;

    /* JADX WARN: Illegal instructions before constructor call */
    public Battery() {
        int i = 0;
        this(i, i, 3, null);
    }

    public static /* synthetic */ Battery copy$default(Battery battery, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = battery.level;
        }
        if ((i3 & 2) != 0) {
            i2 = battery.chargingState;
        }
        return battery.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getLevel() {
        return this.level;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getChargingState() {
        return this.chargingState;
    }

    public final Battery copy(int level, int chargingState) {
        return new Battery(level, chargingState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Battery)) {
            return false;
        }
        Battery battery = (Battery) other;
        return this.level == battery.level && this.chargingState == battery.chargingState;
    }

    public int hashCode() {
        return (Integer.hashCode(this.level) * 31) + Integer.hashCode(this.chargingState);
    }

    public Battery(int i, int i2) {
        this.level = i;
        this.chargingState = i2;
    }

    public /* synthetic */ Battery(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getChargingState() {
        return this.chargingState;
    }

    public String toString() {
        return "battery level=" + this.level + "%, charging " + this.chargingState;
    }
}
