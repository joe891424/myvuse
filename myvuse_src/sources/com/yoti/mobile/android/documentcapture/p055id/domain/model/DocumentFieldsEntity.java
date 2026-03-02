package com.yoti.mobile.android.documentcapture.p055id.domain.model;

import androidx.core.app.FrameMetricsAggregator;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003Ju\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u000bHÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013¨\u0006-"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/domain/model/DocumentFieldsEntity;", "", "holder", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/HolderEntity;", "holderAlias", "address", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/AddressEntity;", "issueDate", "Ljava/util/Date;", "expiryDate", "issuingCountryIso3Code", "", BlinkIdCombinedRecognizer.VerificationConstants.IssuingAuthority, "documentNumber", "mrz", "(Lcom/yoti/mobile/android/documentcapture/id/domain/model/HolderEntity;Lcom/yoti/mobile/android/documentcapture/id/domain/model/HolderEntity;Lcom/yoti/mobile/android/documentcapture/id/domain/model/AddressEntity;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Lcom/yoti/mobile/android/documentcapture/id/domain/model/AddressEntity;", "getDocumentNumber", "()Ljava/lang/String;", "getExpiryDate", "()Ljava/util/Date;", "getHolder", "()Lcom/yoti/mobile/android/documentcapture/id/domain/model/HolderEntity;", "getHolderAlias", "getIssueDate", "getIssuingAuthority", "getIssuingCountryIso3Code", "getMrz", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class DocumentFieldsEntity {
    private final AddressEntity address;
    private final String documentNumber;
    private final Date expiryDate;
    private final HolderEntity holder;
    private final HolderEntity holderAlias;
    private final Date issueDate;
    private final String issuingAuthority;
    private final String issuingCountryIso3Code;
    private final String mrz;

    public DocumentFieldsEntity() {
        this(null, null, null, null, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public DocumentFieldsEntity(HolderEntity holderEntity, HolderEntity holderEntity2, AddressEntity addressEntity, Date date, Date date2, String str, String str2, String str3, String str4) {
        this.holder = holderEntity;
        this.holderAlias = holderEntity2;
        this.address = addressEntity;
        this.issueDate = date;
        this.expiryDate = date2;
        this.issuingCountryIso3Code = str;
        this.issuingAuthority = str2;
        this.documentNumber = str3;
        this.mrz = str4;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final HolderEntity getHolder() {
        return this.holder;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final HolderEntity getHolderAlias() {
        return this.holderAlias;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AddressEntity getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Date getIssueDate() {
        return this.issueDate;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Date getExpiryDate() {
        return this.expiryDate;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getIssuingCountryIso3Code() {
        return this.issuingCountryIso3Code;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getIssuingAuthority() {
        return this.issuingAuthority;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDocumentNumber() {
        return this.documentNumber;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getMrz() {
        return this.mrz;
    }

    public final DocumentFieldsEntity copy(HolderEntity holder, HolderEntity holderAlias, AddressEntity address, Date issueDate, Date expiryDate, String issuingCountryIso3Code, String issuingAuthority, String documentNumber, String mrz) {
        return new DocumentFieldsEntity(holder, holderAlias, address, issueDate, expiryDate, issuingCountryIso3Code, issuingAuthority, documentNumber, mrz);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentFieldsEntity)) {
            return false;
        }
        DocumentFieldsEntity documentFieldsEntity = (DocumentFieldsEntity) other;
        return Intrinsics.areEqual(this.holder, documentFieldsEntity.holder) && Intrinsics.areEqual(this.holderAlias, documentFieldsEntity.holderAlias) && Intrinsics.areEqual(this.address, documentFieldsEntity.address) && Intrinsics.areEqual(this.issueDate, documentFieldsEntity.issueDate) && Intrinsics.areEqual(this.expiryDate, documentFieldsEntity.expiryDate) && Intrinsics.areEqual(this.issuingCountryIso3Code, documentFieldsEntity.issuingCountryIso3Code) && Intrinsics.areEqual(this.issuingAuthority, documentFieldsEntity.issuingAuthority) && Intrinsics.areEqual(this.documentNumber, documentFieldsEntity.documentNumber) && Intrinsics.areEqual(this.mrz, documentFieldsEntity.mrz);
    }

    public final AddressEntity getAddress() {
        return this.address;
    }

    public final String getDocumentNumber() {
        return this.documentNumber;
    }

    public final Date getExpiryDate() {
        return this.expiryDate;
    }

    public final HolderEntity getHolder() {
        return this.holder;
    }

    public final HolderEntity getHolderAlias() {
        return this.holderAlias;
    }

    public final Date getIssueDate() {
        return this.issueDate;
    }

    public final String getIssuingAuthority() {
        return this.issuingAuthority;
    }

    public final String getIssuingCountryIso3Code() {
        return this.issuingCountryIso3Code;
    }

    public final String getMrz() {
        return this.mrz;
    }

    public int hashCode() {
        HolderEntity holderEntity = this.holder;
        int iHashCode = (holderEntity == null ? 0 : holderEntity.hashCode()) * 31;
        HolderEntity holderEntity2 = this.holderAlias;
        int iHashCode2 = (iHashCode + (holderEntity2 == null ? 0 : holderEntity2.hashCode())) * 31;
        AddressEntity addressEntity = this.address;
        int iHashCode3 = (iHashCode2 + (addressEntity == null ? 0 : addressEntity.hashCode())) * 31;
        Date date = this.issueDate;
        int iHashCode4 = (iHashCode3 + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.expiryDate;
        int iHashCode5 = (iHashCode4 + (date2 == null ? 0 : date2.hashCode())) * 31;
        String str = this.issuingCountryIso3Code;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.issuingAuthority;
        int iHashCode7 = (iHashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.documentNumber;
        int iHashCode8 = (iHashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.mrz;
        return iHashCode8 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "DocumentFieldsEntity(holder=" + this.holder + ", holderAlias=" + this.holderAlias + ", address=" + this.address + ", issueDate=" + this.issueDate + ", expiryDate=" + this.expiryDate + ", issuingCountryIso3Code=" + this.issuingCountryIso3Code + ", issuingAuthority=" + this.issuingAuthority + ", documentNumber=" + this.documentNumber + ", mrz=" + this.mrz + ')';
    }

    public /* synthetic */ DocumentFieldsEntity(HolderEntity holderEntity, HolderEntity holderEntity2, AddressEntity addressEntity, Date date, Date date2, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : holderEntity, (i & 2) != 0 ? null : holderEntity2, (i & 4) != 0 ? null : addressEntity, (i & 8) != 0 ? null : date, (i & 16) != 0 ? null : date2, (i & 32) != 0 ? null : str, (i & 64) != 0 ? null : str2, (i & 128) != 0 ? null : str3, (i & 256) == 0 ? str4 : null);
    }
}
