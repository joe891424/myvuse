package com.yoti.mobile.android.documentscan.model.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010&\u001a\u00020\u000fHÆ\u0003Jl\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001¢\u0006\u0002\u0010(J\t\u0010)\u001a\u00020*HÖ\u0001J\u0013\u0010+\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020*HÖ\u0001J\t\u0010/\u001a\u00020\bHÖ\u0001J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020*HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\f\u0010\u0017R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00065"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/model/result/DocumentData;", "Landroid/os/Parcelable;", "issueDate", "Lcom/yoti/mobile/android/documentscan/model/result/DateResult;", "expiryDate", "issuingCountry", "Lcom/yoti/mobile/android/documentscan/model/result/Country;", BlinkIdCombinedRecognizer.VerificationConstants.IssuingAuthority, "", "documentNumber", "mrzData", "Lcom/yoti/mobile/android/documentscan/model/result/MrzData;", "isDocumentNumberValid", "", "documentRecognizedType", "Lcom/yoti/mobile/android/documentscan/model/result/RecognizedCoreDocumentType;", "(Lcom/yoti/mobile/android/documentscan/model/result/DateResult;Lcom/yoti/mobile/android/documentscan/model/result/DateResult;Lcom/yoti/mobile/android/documentscan/model/result/Country;Ljava/lang/String;Ljava/lang/String;Lcom/yoti/mobile/android/documentscan/model/result/MrzData;Ljava/lang/Boolean;Lcom/yoti/mobile/android/documentscan/model/result/RecognizedCoreDocumentType;)V", "getDocumentNumber", "()Ljava/lang/String;", "getDocumentRecognizedType", "()Lcom/yoti/mobile/android/documentscan/model/result/RecognizedCoreDocumentType;", "getExpiryDate", "()Lcom/yoti/mobile/android/documentscan/model/result/DateResult;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getIssueDate", "getIssuingAuthority", "getIssuingCountry", "()Lcom/yoti/mobile/android/documentscan/model/result/Country;", "getMrzData", "()Lcom/yoti/mobile/android/documentscan/model/result/MrzData;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lcom/yoti/mobile/android/documentscan/model/result/DateResult;Lcom/yoti/mobile/android/documentscan/model/result/DateResult;Lcom/yoti/mobile/android/documentscan/model/result/Country;Ljava/lang/String;Ljava/lang/String;Lcom/yoti/mobile/android/documentscan/model/result/MrzData;Ljava/lang/Boolean;Lcom/yoti/mobile/android/documentscan/model/result/RecognizedCoreDocumentType;)Lcom/yoti/mobile/android/documentscan/model/result/DocumentData;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final /* data */ class DocumentData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String documentNumber;
    private final RecognizedCoreDocumentType documentRecognizedType;
    private final DateResult expiryDate;
    private final Boolean isDocumentNumberValid;
    private final DateResult issueDate;
    private final String issuingAuthority;
    private final Country issuingCountry;
    private final MrzData mrzData;

    @Metadata(m5596bv = {1, 0, 3}, m5599k = 3, m5600mv = {1, 1, 15})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel in) {
            Boolean boolValueOf;
            Intrinsics.checkParameterIsNotNull(in, "in");
            DateResult dateResult = in.readInt() != 0 ? (DateResult) DateResult.CREATOR.createFromParcel(in) : null;
            DateResult dateResult2 = in.readInt() != 0 ? (DateResult) DateResult.CREATOR.createFromParcel(in) : null;
            Country country = in.readInt() != 0 ? (Country) Country.CREATOR.createFromParcel(in) : null;
            String string = in.readString();
            String string2 = in.readString();
            MrzData mrzData = in.readInt() != 0 ? (MrzData) MrzData.CREATOR.createFromParcel(in) : null;
            if (in.readInt() != 0) {
                boolValueOf = Boolean.valueOf(in.readInt() != 0);
            } else {
                boolValueOf = null;
            }
            return new DocumentData(dateResult, dateResult2, country, string, string2, mrzData, boolValueOf, (RecognizedCoreDocumentType) Enum.valueOf(RecognizedCoreDocumentType.class, in.readString()));
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new DocumentData[i];
        }
    }

    public DocumentData(DateResult dateResult, DateResult dateResult2, Country country, String str, String str2, MrzData mrzData, Boolean bool, RecognizedCoreDocumentType documentRecognizedType) {
        Intrinsics.checkParameterIsNotNull(documentRecognizedType, "documentRecognizedType");
        this.issueDate = dateResult;
        this.expiryDate = dateResult2;
        this.issuingCountry = country;
        this.issuingAuthority = str;
        this.documentNumber = str2;
        this.mrzData = mrzData;
        this.isDocumentNumberValid = bool;
        this.documentRecognizedType = documentRecognizedType;
    }

    public /* synthetic */ DocumentData(DateResult dateResult, DateResult dateResult2, Country country, String str, String str2, MrzData mrzData, Boolean bool, RecognizedCoreDocumentType recognizedCoreDocumentType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dateResult, dateResult2, country, str, str2, mrzData, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? RecognizedCoreDocumentType.UNDEFINED : recognizedCoreDocumentType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DateResult getIssueDate() {
        return this.issueDate;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final DateResult getExpiryDate() {
        return this.expiryDate;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Country getIssuingCountry() {
        return this.issuingCountry;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getIssuingAuthority() {
        return this.issuingAuthority;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDocumentNumber() {
        return this.documentNumber;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final MrzData getMrzData() {
        return this.mrzData;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Boolean getIsDocumentNumberValid() {
        return this.isDocumentNumberValid;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final RecognizedCoreDocumentType getDocumentRecognizedType() {
        return this.documentRecognizedType;
    }

    public final DocumentData copy(DateResult issueDate, DateResult expiryDate, Country issuingCountry, String issuingAuthority, String documentNumber, MrzData mrzData, Boolean isDocumentNumberValid, RecognizedCoreDocumentType documentRecognizedType) {
        Intrinsics.checkParameterIsNotNull(documentRecognizedType, "documentRecognizedType");
        return new DocumentData(issueDate, expiryDate, issuingCountry, issuingAuthority, documentNumber, mrzData, isDocumentNumberValid, documentRecognizedType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentData)) {
            return false;
        }
        DocumentData documentData = (DocumentData) other;
        return Intrinsics.areEqual(this.issueDate, documentData.issueDate) && Intrinsics.areEqual(this.expiryDate, documentData.expiryDate) && Intrinsics.areEqual(this.issuingCountry, documentData.issuingCountry) && Intrinsics.areEqual(this.issuingAuthority, documentData.issuingAuthority) && Intrinsics.areEqual(this.documentNumber, documentData.documentNumber) && Intrinsics.areEqual(this.mrzData, documentData.mrzData) && Intrinsics.areEqual(this.isDocumentNumberValid, documentData.isDocumentNumberValid) && Intrinsics.areEqual(this.documentRecognizedType, documentData.documentRecognizedType);
    }

    public final String getDocumentNumber() {
        return this.documentNumber;
    }

    public final RecognizedCoreDocumentType getDocumentRecognizedType() {
        return this.documentRecognizedType;
    }

    public final DateResult getExpiryDate() {
        return this.expiryDate;
    }

    public final DateResult getIssueDate() {
        return this.issueDate;
    }

    public final String getIssuingAuthority() {
        return this.issuingAuthority;
    }

    public final Country getIssuingCountry() {
        return this.issuingCountry;
    }

    public final MrzData getMrzData() {
        return this.mrzData;
    }

    public int hashCode() {
        DateResult dateResult = this.issueDate;
        int iHashCode = (dateResult != null ? dateResult.hashCode() : 0) * 31;
        DateResult dateResult2 = this.expiryDate;
        int iHashCode2 = (iHashCode + (dateResult2 != null ? dateResult2.hashCode() : 0)) * 31;
        Country country = this.issuingCountry;
        int iHashCode3 = (iHashCode2 + (country != null ? country.hashCode() : 0)) * 31;
        String str = this.issuingAuthority;
        int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.documentNumber;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        MrzData mrzData = this.mrzData;
        int iHashCode6 = (iHashCode5 + (mrzData != null ? mrzData.hashCode() : 0)) * 31;
        Boolean bool = this.isDocumentNumberValid;
        int iHashCode7 = (iHashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
        RecognizedCoreDocumentType recognizedCoreDocumentType = this.documentRecognizedType;
        return iHashCode7 + (recognizedCoreDocumentType != null ? recognizedCoreDocumentType.hashCode() : 0);
    }

    public final Boolean isDocumentNumberValid() {
        return this.isDocumentNumberValid;
    }

    public String toString() {
        return "DocumentData(issueDate=" + this.issueDate + ", expiryDate=" + this.expiryDate + ", issuingCountry=" + this.issuingCountry + ", issuingAuthority=" + this.issuingAuthority + ", documentNumber=" + this.documentNumber + ", mrzData=" + this.mrzData + ", isDocumentNumberValid=" + this.isDocumentNumberValid + ", documentRecognizedType=" + this.documentRecognizedType + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        DateResult dateResult = this.issueDate;
        if (dateResult != null) {
            parcel.writeInt(1);
            dateResult.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        DateResult dateResult2 = this.expiryDate;
        if (dateResult2 != null) {
            parcel.writeInt(1);
            dateResult2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Country country = this.issuingCountry;
        if (country != null) {
            parcel.writeInt(1);
            country.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.issuingAuthority);
        parcel.writeString(this.documentNumber);
        MrzData mrzData = this.mrzData;
        if (mrzData != null) {
            parcel.writeInt(1);
            mrzData.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool = this.isDocumentNumberValid;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.documentRecognizedType.name());
    }
}
