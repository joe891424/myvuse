package com.yoti.mobile.android.documentcapture.p055id.domain.model;

import com.yoti.mobile.android.documentcapture.domain.model.IScanConfigurationEntity;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\rHÆ\u0003Jk\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\rHÆ\u0001J\u0013\u0010*\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013¨\u00060"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/domain/model/IdDocumentScanConfigurationEntity;", "Lcom/yoti/mobile/android/documentcapture/domain/model/IScanConfigurationEntity;", "resourceId", "", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "countryIso3Code", "nfcConfigType", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/NfcConfigTypeEntity;", "pages", "", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/PageScanConfigurationEntity;", "consentRequired", "", "blinkIdKey", "blinkIdLicensee", "ocrRequired", "(Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;Ljava/lang/String;Lcom/yoti/mobile/android/documentcapture/id/domain/model/NfcConfigTypeEntity;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Z)V", "getBlinkIdKey", "()Ljava/lang/String;", "getBlinkIdLicensee", "getConsentRequired", "()Z", "getCountryIso3Code", "getDocumentType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "getNfcConfigType", "()Lcom/yoti/mobile/android/documentcapture/id/domain/model/NfcConfigTypeEntity;", "getOcrRequired", "getPages", "()Ljava/util/List;", "getResourceId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class IdDocumentScanConfigurationEntity implements IScanConfigurationEntity {
    private final String blinkIdKey;
    private final String blinkIdLicensee;
    private final boolean consentRequired;
    private final String countryIso3Code;
    private final DocumentResourceConfigEntity.DocumentTypeEntity documentType;
    private final NfcConfigTypeEntity nfcConfigType;
    private final boolean ocrRequired;
    private final List<PageScanConfigurationEntity> pages;
    private final String resourceId;

    public IdDocumentScanConfigurationEntity(String resourceId, DocumentResourceConfigEntity.DocumentTypeEntity documentType, String countryIso3Code, NfcConfigTypeEntity nfcConfigType, List<PageScanConfigurationEntity> pages, boolean z, String blinkIdKey, String str, boolean z2) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
        Intrinsics.checkNotNullParameter(nfcConfigType, "nfcConfigType");
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(blinkIdKey, "blinkIdKey");
        this.resourceId = resourceId;
        this.documentType = documentType;
        this.countryIso3Code = countryIso3Code;
        this.nfcConfigType = nfcConfigType;
        this.pages = pages;
        this.consentRequired = z;
        this.blinkIdKey = blinkIdKey;
        this.blinkIdLicensee = str;
        this.ocrRequired = z2;
    }

    public final String component1() {
        return getResourceId();
    }

    public final DocumentResourceConfigEntity.DocumentTypeEntity component2() {
        return getDocumentType();
    }

    public final String component3() {
        return getCountryIso3Code();
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final NfcConfigTypeEntity getNfcConfigType() {
        return this.nfcConfigType;
    }

    public final List<PageScanConfigurationEntity> component5() {
        return this.pages;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getConsentRequired() {
        return this.consentRequired;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getBlinkIdKey() {
        return this.blinkIdKey;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getBlinkIdLicensee() {
        return this.blinkIdLicensee;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getOcrRequired() {
        return this.ocrRequired;
    }

    public final IdDocumentScanConfigurationEntity copy(String resourceId, DocumentResourceConfigEntity.DocumentTypeEntity documentType, String countryIso3Code, NfcConfigTypeEntity nfcConfigType, List<PageScanConfigurationEntity> pages, boolean consentRequired, String blinkIdKey, String blinkIdLicensee, boolean ocrRequired) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
        Intrinsics.checkNotNullParameter(nfcConfigType, "nfcConfigType");
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(blinkIdKey, "blinkIdKey");
        return new IdDocumentScanConfigurationEntity(resourceId, documentType, countryIso3Code, nfcConfigType, pages, consentRequired, blinkIdKey, blinkIdLicensee, ocrRequired);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdDocumentScanConfigurationEntity)) {
            return false;
        }
        IdDocumentScanConfigurationEntity idDocumentScanConfigurationEntity = (IdDocumentScanConfigurationEntity) other;
        return Intrinsics.areEqual(getResourceId(), idDocumentScanConfigurationEntity.getResourceId()) && getDocumentType() == idDocumentScanConfigurationEntity.getDocumentType() && Intrinsics.areEqual(getCountryIso3Code(), idDocumentScanConfigurationEntity.getCountryIso3Code()) && this.nfcConfigType == idDocumentScanConfigurationEntity.nfcConfigType && Intrinsics.areEqual(this.pages, idDocumentScanConfigurationEntity.pages) && this.consentRequired == idDocumentScanConfigurationEntity.consentRequired && Intrinsics.areEqual(this.blinkIdKey, idDocumentScanConfigurationEntity.blinkIdKey) && Intrinsics.areEqual(this.blinkIdLicensee, idDocumentScanConfigurationEntity.blinkIdLicensee) && this.ocrRequired == idDocumentScanConfigurationEntity.ocrRequired;
    }

    public final String getBlinkIdKey() {
        return this.blinkIdKey;
    }

    public final String getBlinkIdLicensee() {
        return this.blinkIdLicensee;
    }

    public final boolean getConsentRequired() {
        return this.consentRequired;
    }

    @Override // com.yoti.mobile.android.documentcapture.domain.model.IScanConfigurationEntity
    public String getCountryIso3Code() {
        return this.countryIso3Code;
    }

    @Override // com.yoti.mobile.android.documentcapture.domain.model.IScanConfigurationEntity
    public DocumentResourceConfigEntity.DocumentTypeEntity getDocumentType() {
        return this.documentType;
    }

    public final NfcConfigTypeEntity getNfcConfigType() {
        return this.nfcConfigType;
    }

    public final boolean getOcrRequired() {
        return this.ocrRequired;
    }

    public final List<PageScanConfigurationEntity> getPages() {
        return this.pages;
    }

    @Override // com.yoti.mobile.android.documentcapture.domain.model.IScanConfigurationEntity
    public String getResourceId() {
        return this.resourceId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((getResourceId().hashCode() * 31) + getDocumentType().hashCode()) * 31) + getCountryIso3Code().hashCode()) * 31) + this.nfcConfigType.hashCode()) * 31) + this.pages.hashCode()) * 31;
        boolean z = this.consentRequired;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((iHashCode + r1) * 31) + this.blinkIdKey.hashCode()) * 31;
        String str = this.blinkIdLicensee;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        boolean z2 = this.ocrRequired;
        return iHashCode3 + (z2 ? 1 : z2);
    }

    public String toString() {
        return "IdDocumentScanConfigurationEntity(resourceId=" + getResourceId() + ", documentType=" + getDocumentType() + ", countryIso3Code=" + getCountryIso3Code() + ", nfcConfigType=" + this.nfcConfigType + ", pages=" + this.pages + ", consentRequired=" + this.consentRequired + ", blinkIdKey=" + this.blinkIdKey + ", blinkIdLicensee=" + this.blinkIdLicensee + ", ocrRequired=" + this.ocrRequired + ')';
    }

    public /* synthetic */ IdDocumentScanConfigurationEntity(String str, DocumentResourceConfigEntity.DocumentTypeEntity documentTypeEntity, String str2, NfcConfigTypeEntity nfcConfigTypeEntity, List list, boolean z, String str3, String str4, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, documentTypeEntity, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? NfcConfigTypeEntity.UNKNOWN : nfcConfigTypeEntity, (i & 16) != 0 ? CollectionsKt.emptyList() : list, (i & 32) != 0 ? false : z, str3, str4, z2);
    }
}
