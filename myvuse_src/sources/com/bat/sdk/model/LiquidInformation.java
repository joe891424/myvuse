package com.bat.sdk.model;

import com.google.common.base.Ascii;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LiquidInformation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0016\u0010\u0012\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006 "}, m5598d2 = {"Lcom/bat/sdk/model/LiquidInformation;", "", "podLiquidInformationRawData", "", "<init>", "([B)V", "getPodLiquidInformationRawData", "()[B", "fillCapacity", "", "getFillCapacity", "()D", "flavorGroup", "", "getFlavorGroup", "()I", "flavorBase", "getFlavorBase", "flavorName", "getFlavorName", "nicotineStrength", "getNicotineStrength", "heatingPower", "getHeatingPower", "equals", "", "other", "toString", "", "hashCode", "component1", "copy", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class LiquidInformation {
    private final double fillCapacity;

    @SerializedName("flavourBase")
    private final double flavorBase;

    @SerializedName("flavourGroup")
    private final int flavorGroup;

    @SerializedName("flavourName")
    private final int flavorName;

    @SerializedName("recommendedHeatingPower")
    private final int heatingPower;
    private final int nicotineStrength;
    private final transient byte[] podLiquidInformationRawData;

    public static /* synthetic */ LiquidInformation copy$default(LiquidInformation liquidInformation, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = liquidInformation.podLiquidInformationRawData;
        }
        return liquidInformation.copy(bArr);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final byte[] getPodLiquidInformationRawData() {
        return this.podLiquidInformationRawData;
    }

    public final LiquidInformation copy(byte[] podLiquidInformationRawData) {
        Intrinsics.checkNotNullParameter(podLiquidInformationRawData, "podLiquidInformationRawData");
        return new LiquidInformation(podLiquidInformationRawData);
    }

    public LiquidInformation(byte[] podLiquidInformationRawData) {
        Intrinsics.checkNotNullParameter(podLiquidInformationRawData, "podLiquidInformationRawData");
        this.podLiquidInformationRawData = podLiquidInformationRawData;
        byte b = podLiquidInformationRawData[0];
        this.fillCapacity = ((double) ((b >> 1) & 127)) / 10.0d;
        byte b2 = podLiquidInformationRawData[1];
        this.flavorGroup = ((b & 1) << 4) | ((b2 >> 4) & 15);
        this.flavorBase = ((double) (b2 & Ascii.f3756SI)) / 10.0d;
        this.flavorName = podLiquidInformationRawData[2];
        this.nicotineStrength = podLiquidInformationRawData[3];
        this.heatingPower = podLiquidInformationRawData.length >= 5 ? podLiquidInformationRawData[4] : (byte) -1;
    }

    public final byte[] getPodLiquidInformationRawData() {
        return this.podLiquidInformationRawData;
    }

    public final double getFillCapacity() {
        return this.fillCapacity;
    }

    public final int getFlavorGroup() {
        return this.flavorGroup;
    }

    public final double getFlavorBase() {
        return this.flavorBase;
    }

    public final int getFlavorName() {
        return this.flavorName;
    }

    public final int getNicotineStrength() {
        return this.nicotineStrength;
    }

    public final int getHeatingPower() {
        return this.heatingPower;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.bat.sdk.model.LiquidInformation");
        LiquidInformation liquidInformation = (LiquidInformation) other;
        return this.fillCapacity == liquidInformation.fillCapacity && this.flavorGroup == liquidInformation.flavorGroup && this.flavorBase == liquidInformation.flavorBase && this.flavorName == liquidInformation.flavorName && this.nicotineStrength == liquidInformation.nicotineStrength && this.heatingPower == liquidInformation.heatingPower;
    }

    public String toString() {
        return "LiquidInformation(fillCapacity=" + this.fillCapacity + ", flavorGroup=" + this.flavorGroup + ", flavorBase=" + this.flavorBase + ", flavorName=" + this.flavorName + ", nicotineStrength=" + this.nicotineStrength + ", heatingPower=" + this.heatingPower + ')';
    }

    public int hashCode() {
        return (((((((((((Arrays.hashCode(this.podLiquidInformationRawData) * 31) + Double.hashCode(this.fillCapacity)) * 31) + this.flavorGroup) * 31) + Double.hashCode(this.flavorBase)) * 31) + this.flavorName) * 31) + this.nicotineStrength) * 31) + this.heatingPower;
    }
}
