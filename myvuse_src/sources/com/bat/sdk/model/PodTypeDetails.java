package com.bat.sdk.model;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PodTypeDetails.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0016"}, m5598d2 = {"Lcom/bat/sdk/model/PodTypeDetails;", "", "podTypeDetailsRawData", "", "<init>", "([B)V", "getPodTypeDetailsRawData", "()[B", "restrictedMarket", "", "getRestrictedMarket", "()I", "productSeries", "getProductSeries", "toString", "", "component1", "copy", "equals", "", "other", "hashCode", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class PodTypeDetails {
    private final byte[] podTypeDetailsRawData;
    private final int productSeries;
    private final int restrictedMarket;

    public static /* synthetic */ PodTypeDetails copy$default(PodTypeDetails podTypeDetails, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = podTypeDetails.podTypeDetailsRawData;
        }
        return podTypeDetails.copy(bArr);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final byte[] getPodTypeDetailsRawData() {
        return this.podTypeDetailsRawData;
    }

    public final PodTypeDetails copy(byte[] podTypeDetailsRawData) {
        Intrinsics.checkNotNullParameter(podTypeDetailsRawData, "podTypeDetailsRawData");
        return new PodTypeDetails(podTypeDetailsRawData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PodTypeDetails) && Intrinsics.areEqual(this.podTypeDetailsRawData, ((PodTypeDetails) other).podTypeDetailsRawData);
    }

    public int hashCode() {
        return Arrays.hashCode(this.podTypeDetailsRawData);
    }

    public PodTypeDetails(byte[] podTypeDetailsRawData) {
        Intrinsics.checkNotNullParameter(podTypeDetailsRawData, "podTypeDetailsRawData");
        this.podTypeDetailsRawData = podTypeDetailsRawData;
        this.restrictedMarket = podTypeDetailsRawData[0];
        this.productSeries = podTypeDetailsRawData[1];
    }

    public final byte[] getPodTypeDetailsRawData() {
        return this.podTypeDetailsRawData;
    }

    public final int getRestrictedMarket() {
        return this.restrictedMarket;
    }

    public final int getProductSeries() {
        return this.productSeries;
    }

    public String toString() {
        return "PodTypeDetails(restrictedMarket=" + this.restrictedMarket + ", productSeries=" + this.productSeries + ')';
    }
}
