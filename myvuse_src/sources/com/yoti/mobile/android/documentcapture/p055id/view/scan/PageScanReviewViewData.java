package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\t¢\u0006\u0002\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003JQ\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\tHÆ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0007HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0017R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u0006,"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewData;", "Landroid/os/Parcelable;", "imagePath", "", "cropRegion", "Landroid/graphics/RectF;", "documentName", "", "isLastPage", "", "showNfcOption", "consentViewData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/ConsentViewData;", "isGuidelinesLinkVisible", "(Ljava/lang/String;Landroid/graphics/RectF;IZZLcom/yoti/mobile/android/documentcapture/id/view/scan/ConsentViewData;Z)V", "getConsentViewData", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/ConsentViewData;", "getCropRegion", "()Landroid/graphics/RectF;", "getDocumentName", "()I", "getImagePath", "()Ljava/lang/String;", "()Z", "getShowNfcOption", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class PageScanReviewViewData implements Parcelable {
    public static final Parcelable.Creator<PageScanReviewViewData> CREATOR = new Creator();
    private final ConsentViewData consentViewData;
    private final RectF cropRegion;
    private final int documentName;
    private final String imagePath;
    private final boolean isGuidelinesLinkVisible;
    private final boolean isLastPage;
    private final boolean showNfcOption;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<PageScanReviewViewData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PageScanReviewViewData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PageScanReviewViewData(parcel.readString(), (RectF) parcel.readParcelable(PageScanReviewViewData.class.getClassLoader()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() == 0 ? null : ConsentViewData.CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PageScanReviewViewData[] newArray(int i) {
            return new PageScanReviewViewData[i];
        }
    }

    public PageScanReviewViewData(String imagePath, RectF cropRegion, int i, boolean z, boolean z2, ConsentViewData consentViewData, boolean z3) {
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        Intrinsics.checkNotNullParameter(cropRegion, "cropRegion");
        this.imagePath = imagePath;
        this.cropRegion = cropRegion;
        this.documentName = i;
        this.isLastPage = z;
        this.showNfcOption = z2;
        this.consentViewData = consentViewData;
        this.isGuidelinesLinkVisible = z3;
    }

    public static /* synthetic */ PageScanReviewViewData copy$default(PageScanReviewViewData pageScanReviewViewData, String str, RectF rectF, int i, boolean z, boolean z2, ConsentViewData consentViewData, boolean z3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = pageScanReviewViewData.imagePath;
        }
        if ((i2 & 2) != 0) {
            rectF = pageScanReviewViewData.cropRegion;
        }
        RectF rectF2 = rectF;
        if ((i2 & 4) != 0) {
            i = pageScanReviewViewData.documentName;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            z = pageScanReviewViewData.isLastPage;
        }
        boolean z4 = z;
        if ((i2 & 16) != 0) {
            z2 = pageScanReviewViewData.showNfcOption;
        }
        boolean z5 = z2;
        if ((i2 & 32) != 0) {
            consentViewData = pageScanReviewViewData.consentViewData;
        }
        ConsentViewData consentViewData2 = consentViewData;
        if ((i2 & 64) != 0) {
            z3 = pageScanReviewViewData.isGuidelinesLinkVisible;
        }
        return pageScanReviewViewData.copy(str, rectF2, i3, z4, z5, consentViewData2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getImagePath() {
        return this.imagePath;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final RectF getCropRegion() {
        return this.cropRegion;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDocumentName() {
        return this.documentName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsLastPage() {
        return this.isLastPage;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getShowNfcOption() {
        return this.showNfcOption;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ConsentViewData getConsentViewData() {
        return this.consentViewData;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsGuidelinesLinkVisible() {
        return this.isGuidelinesLinkVisible;
    }

    public final PageScanReviewViewData copy(String imagePath, RectF cropRegion, int documentName, boolean isLastPage, boolean showNfcOption, ConsentViewData consentViewData, boolean isGuidelinesLinkVisible) {
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        Intrinsics.checkNotNullParameter(cropRegion, "cropRegion");
        return new PageScanReviewViewData(imagePath, cropRegion, documentName, isLastPage, showNfcOption, consentViewData, isGuidelinesLinkVisible);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PageScanReviewViewData)) {
            return false;
        }
        PageScanReviewViewData pageScanReviewViewData = (PageScanReviewViewData) other;
        return Intrinsics.areEqual(this.imagePath, pageScanReviewViewData.imagePath) && Intrinsics.areEqual(this.cropRegion, pageScanReviewViewData.cropRegion) && this.documentName == pageScanReviewViewData.documentName && this.isLastPage == pageScanReviewViewData.isLastPage && this.showNfcOption == pageScanReviewViewData.showNfcOption && Intrinsics.areEqual(this.consentViewData, pageScanReviewViewData.consentViewData) && this.isGuidelinesLinkVisible == pageScanReviewViewData.isGuidelinesLinkVisible;
    }

    public final ConsentViewData getConsentViewData() {
        return this.consentViewData;
    }

    public final RectF getCropRegion() {
        return this.cropRegion;
    }

    public final int getDocumentName() {
        return this.documentName;
    }

    public final String getImagePath() {
        return this.imagePath;
    }

    public final boolean getShowNfcOption() {
        return this.showNfcOption;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((this.imagePath.hashCode() * 31) + this.cropRegion.hashCode()) * 31) + Integer.hashCode(this.documentName)) * 31;
        boolean z = this.isLastPage;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.showNfcOption;
        ?? r12 = z2;
        if (z2) {
            r12 = 1;
        }
        int i2 = (i + r12) * 31;
        ConsentViewData consentViewData = this.consentViewData;
        int iHashCode2 = (i2 + (consentViewData == null ? 0 : consentViewData.hashCode())) * 31;
        boolean z3 = this.isGuidelinesLinkVisible;
        return iHashCode2 + (z3 ? 1 : z3);
    }

    public final boolean isGuidelinesLinkVisible() {
        return this.isGuidelinesLinkVisible;
    }

    public final boolean isLastPage() {
        return this.isLastPage;
    }

    public String toString() {
        return "PageScanReviewViewData(imagePath=" + this.imagePath + ", cropRegion=" + this.cropRegion + ", documentName=" + this.documentName + ", isLastPage=" + this.isLastPage + ", showNfcOption=" + this.showNfcOption + ", consentViewData=" + this.consentViewData + ", isGuidelinesLinkVisible=" + this.isGuidelinesLinkVisible + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.imagePath);
        parcel.writeParcelable(this.cropRegion, flags);
        parcel.writeInt(this.documentName);
        parcel.writeInt(this.isLastPage ? 1 : 0);
        parcel.writeInt(this.showNfcOption ? 1 : 0);
        ConsentViewData consentViewData = this.consentViewData;
        if (consentViewData == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            consentViewData.writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.isGuidelinesLinkVisible ? 1 : 0);
    }

    public /* synthetic */ PageScanReviewViewData(String str, RectF rectF, int i, boolean z, boolean z2, ConsentViewData consentViewData, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, rectF, i, z, z2, consentViewData, (i2 & 64) != 0 ? true : z3);
    }
}
