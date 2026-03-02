package com.yoti.mobile.android.documentcapture.sup.view.scan;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.documentcapture.view.scan.IScanConfigurationViewData;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001e"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanConfigurationViewData;", "Lcom/yoti/mobile/android/documentcapture/view/scan/IScanConfigurationViewData;", "resourceId", "", "countryIso3Code", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "(Ljava/lang/String;Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;)V", "getCountryIso3Code", "()Ljava/lang/String;", "getDocumentType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "getResourceId", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class SupDocumentScanConfigurationViewData implements IScanConfigurationViewData {
    public static final Parcelable.Creator<SupDocumentScanConfigurationViewData> CREATOR = new Creator();
    private final String countryIso3Code;
    private final DocumentTypeViewData documentType;
    private final String resourceId;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<SupDocumentScanConfigurationViewData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SupDocumentScanConfigurationViewData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SupDocumentScanConfigurationViewData(parcel.readString(), parcel.readString(), (DocumentTypeViewData) parcel.readParcelable(SupDocumentScanConfigurationViewData.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SupDocumentScanConfigurationViewData[] newArray(int i) {
            return new SupDocumentScanConfigurationViewData[i];
        }
    }

    public SupDocumentScanConfigurationViewData(String resourceId, String countryIso3Code, DocumentTypeViewData documentType) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        this.resourceId = resourceId;
        this.countryIso3Code = countryIso3Code;
        this.documentType = documentType;
    }

    public static /* synthetic */ SupDocumentScanConfigurationViewData copy$default(SupDocumentScanConfigurationViewData supDocumentScanConfigurationViewData, String str, String str2, DocumentTypeViewData documentTypeViewData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = supDocumentScanConfigurationViewData.getResourceId();
        }
        if ((i & 2) != 0) {
            str2 = supDocumentScanConfigurationViewData.getCountryIso3Code();
        }
        if ((i & 4) != 0) {
            documentTypeViewData = supDocumentScanConfigurationViewData.getDocumentType();
        }
        return supDocumentScanConfigurationViewData.copy(str, str2, documentTypeViewData);
    }

    public final String component1() {
        return getResourceId();
    }

    public final String component2() {
        return getCountryIso3Code();
    }

    public final DocumentTypeViewData component3() {
        return getDocumentType();
    }

    public final SupDocumentScanConfigurationViewData copy(String resourceId, String countryIso3Code, DocumentTypeViewData documentType) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        return new SupDocumentScanConfigurationViewData(resourceId, countryIso3Code, documentType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SupDocumentScanConfigurationViewData)) {
            return false;
        }
        SupDocumentScanConfigurationViewData supDocumentScanConfigurationViewData = (SupDocumentScanConfigurationViewData) other;
        return Intrinsics.areEqual(getResourceId(), supDocumentScanConfigurationViewData.getResourceId()) && Intrinsics.areEqual(getCountryIso3Code(), supDocumentScanConfigurationViewData.getCountryIso3Code()) && getDocumentType() == supDocumentScanConfigurationViewData.getDocumentType();
    }

    @Override // com.yoti.mobile.android.documentcapture.view.scan.IScanConfigurationViewData
    public String getCountryIso3Code() {
        return this.countryIso3Code;
    }

    @Override // com.yoti.mobile.android.documentcapture.view.scan.IScanConfigurationViewData
    public int getDocumentName() {
        return IScanConfigurationViewData.DefaultImpls.getDocumentName(this);
    }

    @Override // com.yoti.mobile.android.documentcapture.view.scan.IScanConfigurationViewData
    public DocumentTypeViewData getDocumentType() {
        return this.documentType;
    }

    @Override // com.yoti.mobile.android.documentcapture.view.scan.IScanConfigurationViewData
    public String getResourceId() {
        return this.resourceId;
    }

    public int hashCode() {
        return (((getResourceId().hashCode() * 31) + getCountryIso3Code().hashCode()) * 31) + getDocumentType().hashCode();
    }

    public String toString() {
        return "SupDocumentScanConfigurationViewData(resourceId=" + getResourceId() + ", countryIso3Code=" + getCountryIso3Code() + ", documentType=" + getDocumentType() + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.resourceId);
        parcel.writeString(this.countryIso3Code);
        parcel.writeParcelable(this.documentType, flags);
    }
}
