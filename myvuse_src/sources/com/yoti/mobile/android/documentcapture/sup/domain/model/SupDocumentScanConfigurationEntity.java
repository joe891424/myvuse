package com.yoti.mobile.android.documentcapture.sup.domain.model;

import com.yoti.mobile.android.documentcapture.domain.model.IScanConfigurationEntity;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/domain/model/SupDocumentScanConfigurationEntity;", "Lcom/yoti/mobile/android/documentcapture/domain/model/IScanConfigurationEntity;", "resourceId", "", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "countryIso3Code", "(Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;Ljava/lang/String;)V", "getCountryIso3Code", "()Ljava/lang/String;", "getDocumentType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "getResourceId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class SupDocumentScanConfigurationEntity implements IScanConfigurationEntity {
    private final String countryIso3Code;
    private final DocumentResourceConfigEntity.DocumentTypeEntity documentType;
    private final String resourceId;

    public SupDocumentScanConfigurationEntity(String resourceId, DocumentResourceConfigEntity.DocumentTypeEntity documentType, String countryIso3Code) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
        this.resourceId = resourceId;
        this.documentType = documentType;
        this.countryIso3Code = countryIso3Code;
        if (getDocumentType().getDocumentCaptureType() != DocumentResourceConfigEntity.DocumentCaptureTypeEntity.SUPPLEMENTARY_DOCUMENT) {
            throw new IllegalStateException(("Id Document type " + getDocumentType().name() + " is not a SUPPLEMENTARY DOCUMENT and cannot be managed by Supplementary document scan configuration").toString());
        }
    }

    public static /* synthetic */ SupDocumentScanConfigurationEntity copy$default(SupDocumentScanConfigurationEntity supDocumentScanConfigurationEntity, String str, DocumentResourceConfigEntity.DocumentTypeEntity documentTypeEntity, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = supDocumentScanConfigurationEntity.getResourceId();
        }
        if ((i & 2) != 0) {
            documentTypeEntity = supDocumentScanConfigurationEntity.getDocumentType();
        }
        if ((i & 4) != 0) {
            str2 = supDocumentScanConfigurationEntity.getCountryIso3Code();
        }
        return supDocumentScanConfigurationEntity.copy(str, documentTypeEntity, str2);
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

    public final SupDocumentScanConfigurationEntity copy(String resourceId, DocumentResourceConfigEntity.DocumentTypeEntity documentType, String countryIso3Code) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
        return new SupDocumentScanConfigurationEntity(resourceId, documentType, countryIso3Code);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SupDocumentScanConfigurationEntity)) {
            return false;
        }
        SupDocumentScanConfigurationEntity supDocumentScanConfigurationEntity = (SupDocumentScanConfigurationEntity) other;
        return Intrinsics.areEqual(getResourceId(), supDocumentScanConfigurationEntity.getResourceId()) && getDocumentType() == supDocumentScanConfigurationEntity.getDocumentType() && Intrinsics.areEqual(getCountryIso3Code(), supDocumentScanConfigurationEntity.getCountryIso3Code());
    }

    @Override // com.yoti.mobile.android.documentcapture.domain.model.IScanConfigurationEntity
    public String getCountryIso3Code() {
        return this.countryIso3Code;
    }

    @Override // com.yoti.mobile.android.documentcapture.domain.model.IScanConfigurationEntity
    public DocumentResourceConfigEntity.DocumentTypeEntity getDocumentType() {
        return this.documentType;
    }

    @Override // com.yoti.mobile.android.documentcapture.domain.model.IScanConfigurationEntity
    public String getResourceId() {
        return this.resourceId;
    }

    public int hashCode() {
        return (((getResourceId().hashCode() * 31) + getDocumentType().hashCode()) * 31) + getCountryIso3Code().hashCode();
    }

    public String toString() {
        return "SupDocumentScanConfigurationEntity(resourceId=" + getResourceId() + ", documentType=" + getDocumentType() + ", countryIso3Code=" + getCountryIso3Code() + ')';
    }
}
