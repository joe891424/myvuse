package com.bat.sdk.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PodConnection.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b$\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010%\u001a\u00020\fH\u0016J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0082\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b \u0010\u0017R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b!\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00065"}, m5598d2 = {"Lcom/bat/sdk/model/PodConnection;", "", "connected", "", "type", "", "apiVersion", "podUid", "Lcom/bat/sdk/model/PodUid;", "liquidInformation", "Lcom/bat/sdk/model/LiquidInformation;", "skuInformation", "", "remainingVolume", "podPuffCount", "recognized", "typeDetails", "Lcom/bat/sdk/model/PodTypeDetails;", "<init>", "(ZLjava/lang/Integer;Ljava/lang/Integer;Lcom/bat/sdk/model/PodUid;Lcom/bat/sdk/model/LiquidInformation;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ZLcom/bat/sdk/model/PodTypeDetails;)V", "getConnected", "()Z", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getApiVersion", "getPodUid", "()Lcom/bat/sdk/model/PodUid;", "getLiquidInformation", "()Lcom/bat/sdk/model/LiquidInformation;", "getSkuInformation", "()Ljava/lang/String;", "getRemainingVolume", "getPodPuffCount", "getRecognized", "getTypeDetails", "()Lcom/bat/sdk/model/PodTypeDetails;", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(ZLjava/lang/Integer;Ljava/lang/Integer;Lcom/bat/sdk/model/PodUid;Lcom/bat/sdk/model/LiquidInformation;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ZLcom/bat/sdk/model/PodTypeDetails;)Lcom/bat/sdk/model/PodConnection;", "equals", "other", "hashCode", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class PodConnection {
    private final Integer apiVersion;
    private final boolean connected;
    private final LiquidInformation liquidInformation;
    private final Integer podPuffCount;
    private final PodUid podUid;
    private final boolean recognized;
    private final Integer remainingVolume;
    private final String skuInformation;
    private final Integer type;
    private final PodTypeDetails typeDetails;

    public PodConnection() {
        this(false, null, null, null, null, null, null, null, false, null, 1023, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getConnected() {
        return this.connected;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final PodTypeDetails getTypeDetails() {
        return this.typeDetails;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getApiVersion() {
        return this.apiVersion;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final PodUid getPodUid() {
        return this.podUid;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final LiquidInformation getLiquidInformation() {
        return this.liquidInformation;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSkuInformation() {
        return this.skuInformation;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getRemainingVolume() {
        return this.remainingVolume;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getPodPuffCount() {
        return this.podPuffCount;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getRecognized() {
        return this.recognized;
    }

    public final PodConnection copy(boolean connected, Integer type, Integer apiVersion, PodUid podUid, LiquidInformation liquidInformation, String skuInformation, Integer remainingVolume, Integer podPuffCount, boolean recognized, PodTypeDetails typeDetails) {
        return new PodConnection(connected, type, apiVersion, podUid, liquidInformation, skuInformation, remainingVolume, podPuffCount, recognized, typeDetails);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PodConnection)) {
            return false;
        }
        PodConnection podConnection = (PodConnection) other;
        return this.connected == podConnection.connected && Intrinsics.areEqual(this.type, podConnection.type) && Intrinsics.areEqual(this.apiVersion, podConnection.apiVersion) && Intrinsics.areEqual(this.podUid, podConnection.podUid) && Intrinsics.areEqual(this.liquidInformation, podConnection.liquidInformation) && Intrinsics.areEqual(this.skuInformation, podConnection.skuInformation) && Intrinsics.areEqual(this.remainingVolume, podConnection.remainingVolume) && Intrinsics.areEqual(this.podPuffCount, podConnection.podPuffCount) && this.recognized == podConnection.recognized && Intrinsics.areEqual(this.typeDetails, podConnection.typeDetails);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.connected) * 31;
        Integer num = this.type;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.apiVersion;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        PodUid podUid = this.podUid;
        int iHashCode4 = (iHashCode3 + (podUid == null ? 0 : podUid.hashCode())) * 31;
        LiquidInformation liquidInformation = this.liquidInformation;
        int iHashCode5 = (iHashCode4 + (liquidInformation == null ? 0 : liquidInformation.hashCode())) * 31;
        String str = this.skuInformation;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num3 = this.remainingVolume;
        int iHashCode7 = (iHashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.podPuffCount;
        int iHashCode8 = (((iHashCode7 + (num4 == null ? 0 : num4.hashCode())) * 31) + Boolean.hashCode(this.recognized)) * 31;
        PodTypeDetails podTypeDetails = this.typeDetails;
        return iHashCode8 + (podTypeDetails != null ? podTypeDetails.hashCode() : 0);
    }

    public PodConnection(boolean z, Integer num, Integer num2, PodUid podUid, LiquidInformation liquidInformation, String str, Integer num3, Integer num4, boolean z2, PodTypeDetails podTypeDetails) {
        this.connected = z;
        this.type = num;
        this.apiVersion = num2;
        this.podUid = podUid;
        this.liquidInformation = liquidInformation;
        this.skuInformation = str;
        this.remainingVolume = num3;
        this.podPuffCount = num4;
        this.recognized = z2;
        this.typeDetails = podTypeDetails;
    }

    public /* synthetic */ PodConnection(boolean z, Integer num, Integer num2, PodUid podUid, LiquidInformation liquidInformation, String str, Integer num3, Integer num4, boolean z2, PodTypeDetails podTypeDetails, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : podUid, (i & 16) != 0 ? null : liquidInformation, (i & 32) != 0 ? null : str, (i & 64) != 0 ? null : num3, (i & 128) != 0 ? null : num4, (i & 256) == 0 ? z2 : false, (i & 512) == 0 ? podTypeDetails : null);
    }

    public final boolean getConnected() {
        return this.connected;
    }

    public final Integer getType() {
        return this.type;
    }

    public final Integer getApiVersion() {
        return this.apiVersion;
    }

    public final PodUid getPodUid() {
        return this.podUid;
    }

    public final LiquidInformation getLiquidInformation() {
        return this.liquidInformation;
    }

    public final String getSkuInformation() {
        return this.skuInformation;
    }

    public final Integer getRemainingVolume() {
        return this.remainingVolume;
    }

    public final Integer getPodPuffCount() {
        return this.podPuffCount;
    }

    public final boolean getRecognized() {
        return this.recognized;
    }

    public final PodTypeDetails getTypeDetails() {
        return this.typeDetails;
    }

    public String toString() {
        return "PodConnection(connected=" + this.connected + ", type=" + this.type + ", apiVersion=" + this.apiVersion + ", podUid=" + this.podUid + ", liquidInformation=" + this.liquidInformation + ", skuInformation=" + this.skuInformation + ", remainingVolume=" + this.remainingVolume + ", podPuffCount=" + this.podPuffCount + ", recognized=" + this.recognized + ')';
    }
}
