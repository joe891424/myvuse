package com.yoti.mobile.android.documentcapture.domain.model;

import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/domain/model/ScanConfigurationRequestParams;", "", "iso3Code", "", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "(Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;)V", "getDocumentType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "getIso3Code", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class ScanConfigurationRequestParams {
    private final DocumentResourceConfigEntity.DocumentTypeEntity documentType;
    private final String iso3Code;

    public ScanConfigurationRequestParams(String iso3Code, DocumentResourceConfigEntity.DocumentTypeEntity documentType) {
        Intrinsics.checkNotNullParameter(iso3Code, "iso3Code");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        this.iso3Code = iso3Code;
        this.documentType = documentType;
    }

    public static /* synthetic */ ScanConfigurationRequestParams copy$default(ScanConfigurationRequestParams scanConfigurationRequestParams, String str, DocumentResourceConfigEntity.DocumentTypeEntity documentTypeEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            str = scanConfigurationRequestParams.iso3Code;
        }
        if ((i & 2) != 0) {
            documentTypeEntity = scanConfigurationRequestParams.documentType;
        }
        return scanConfigurationRequestParams.copy(str, documentTypeEntity);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getIso3Code() {
        return this.iso3Code;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final DocumentResourceConfigEntity.DocumentTypeEntity getDocumentType() {
        return this.documentType;
    }

    public final ScanConfigurationRequestParams copy(String iso3Code, DocumentResourceConfigEntity.DocumentTypeEntity documentType) {
        Intrinsics.checkNotNullParameter(iso3Code, "iso3Code");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        return new ScanConfigurationRequestParams(iso3Code, documentType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScanConfigurationRequestParams)) {
            return false;
        }
        ScanConfigurationRequestParams scanConfigurationRequestParams = (ScanConfigurationRequestParams) other;
        return Intrinsics.areEqual(this.iso3Code, scanConfigurationRequestParams.iso3Code) && this.documentType == scanConfigurationRequestParams.documentType;
    }

    public final DocumentResourceConfigEntity.DocumentTypeEntity getDocumentType() {
        return this.documentType;
    }

    public final String getIso3Code() {
        return this.iso3Code;
    }

    public int hashCode() {
        return (this.iso3Code.hashCode() * 31) + this.documentType.hashCode();
    }

    public String toString() {
        return "ScanConfigurationRequestParams(iso3Code=" + this.iso3Code + ", documentType=" + this.documentType + ')';
    }

    public /* synthetic */ ScanConfigurationRequestParams(String str, DocumentResourceConfigEntity.DocumentTypeEntity documentTypeEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, documentTypeEntity);
    }
}
