package com.yoti.mobile.android.documentcapture.sup.view.scan;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.documentcapture.view.upload.IDocumentViewData;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006#"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupplementaryDocumentViewData;", "Lcom/yoti/mobile/android/documentcapture/view/upload/IDocumentViewData;", "resourceId", "", "countryIso3Code", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "filePath", "Landroid/net/Uri;", "(Ljava/lang/String;Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;Landroid/net/Uri;)V", "getCountryIso3Code", "()Ljava/lang/String;", "getDocumentType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "getFilePath", "()Landroid/net/Uri;", "getResourceId", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class SupplementaryDocumentViewData implements IDocumentViewData {
    public static final Parcelable.Creator<SupplementaryDocumentViewData> CREATOR = new Creator();
    private final String countryIso3Code;
    private final DocumentTypeViewData documentType;
    private final Uri filePath;
    private final String resourceId;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<SupplementaryDocumentViewData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SupplementaryDocumentViewData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SupplementaryDocumentViewData(parcel.readString(), parcel.readString(), (DocumentTypeViewData) parcel.readParcelable(SupplementaryDocumentViewData.class.getClassLoader()), (Uri) parcel.readParcelable(SupplementaryDocumentViewData.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SupplementaryDocumentViewData[] newArray(int i) {
            return new SupplementaryDocumentViewData[i];
        }
    }

    public SupplementaryDocumentViewData(String resourceId, String countryIso3Code, DocumentTypeViewData documentType, Uri filePath) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.resourceId = resourceId;
        this.countryIso3Code = countryIso3Code;
        this.documentType = documentType;
        this.filePath = filePath;
    }

    public static /* synthetic */ SupplementaryDocumentViewData copy$default(SupplementaryDocumentViewData supplementaryDocumentViewData, String str, String str2, DocumentTypeViewData documentTypeViewData, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            str = supplementaryDocumentViewData.getResourceId();
        }
        if ((i & 2) != 0) {
            str2 = supplementaryDocumentViewData.getCountryIso3Code();
        }
        if ((i & 4) != 0) {
            documentTypeViewData = supplementaryDocumentViewData.getDocumentType();
        }
        if ((i & 8) != 0) {
            uri = supplementaryDocumentViewData.filePath;
        }
        return supplementaryDocumentViewData.copy(str, str2, documentTypeViewData, uri);
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

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Uri getFilePath() {
        return this.filePath;
    }

    public final SupplementaryDocumentViewData copy(String resourceId, String countryIso3Code, DocumentTypeViewData documentType, Uri filePath) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return new SupplementaryDocumentViewData(resourceId, countryIso3Code, documentType, filePath);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SupplementaryDocumentViewData)) {
            return false;
        }
        SupplementaryDocumentViewData supplementaryDocumentViewData = (SupplementaryDocumentViewData) other;
        return Intrinsics.areEqual(getResourceId(), supplementaryDocumentViewData.getResourceId()) && Intrinsics.areEqual(getCountryIso3Code(), supplementaryDocumentViewData.getCountryIso3Code()) && getDocumentType() == supplementaryDocumentViewData.getDocumentType() && Intrinsics.areEqual(this.filePath, supplementaryDocumentViewData.filePath);
    }

    @Override // com.yoti.mobile.android.documentcapture.view.upload.IDocumentViewData
    public String getCountryIso3Code() {
        return this.countryIso3Code;
    }

    @Override // com.yoti.mobile.android.documentcapture.view.upload.IDocumentViewData
    public DocumentTypeViewData getDocumentType() {
        return this.documentType;
    }

    public final Uri getFilePath() {
        return this.filePath;
    }

    @Override // com.yoti.mobile.android.documentcapture.view.upload.IDocumentViewData
    public String getResourceId() {
        return this.resourceId;
    }

    public int hashCode() {
        return (((((getResourceId().hashCode() * 31) + getCountryIso3Code().hashCode()) * 31) + getDocumentType().hashCode()) * 31) + this.filePath.hashCode();
    }

    public String toString() {
        return "SupplementaryDocumentViewData(resourceId=" + getResourceId() + ", countryIso3Code=" + getCountryIso3Code() + ", documentType=" + getDocumentType() + ", filePath=" + this.filePath + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.resourceId);
        parcel.writeString(this.countryIso3Code);
        parcel.writeParcelable(this.documentType, flags);
        parcel.writeParcelable(this.filePath, flags);
    }
}
