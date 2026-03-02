package com.yoti.mobile.android.documentcapture.p055id.domain.model;

import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/domain/model/OcrOriginEntity;", "", "documentTypeEntity", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "countryIso3Code", "", "(Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;Ljava/lang/String;)V", "getCountryIso3Code", "()Ljava/lang/String;", "getDocumentTypeEntity", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class OcrOriginEntity {
    private final String countryIso3Code;
    private final DocumentResourceConfigEntity.DocumentTypeEntity documentTypeEntity;

    public OcrOriginEntity(DocumentResourceConfigEntity.DocumentTypeEntity documentTypeEntity, String countryIso3Code) {
        Intrinsics.checkNotNullParameter(documentTypeEntity, "documentTypeEntity");
        Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
        this.documentTypeEntity = documentTypeEntity;
        this.countryIso3Code = countryIso3Code;
    }

    public static /* synthetic */ OcrOriginEntity copy$default(OcrOriginEntity ocrOriginEntity, DocumentResourceConfigEntity.DocumentTypeEntity documentTypeEntity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            documentTypeEntity = ocrOriginEntity.documentTypeEntity;
        }
        if ((i & 2) != 0) {
            str = ocrOriginEntity.countryIso3Code;
        }
        return ocrOriginEntity.copy(documentTypeEntity, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DocumentResourceConfigEntity.DocumentTypeEntity getDocumentTypeEntity() {
        return this.documentTypeEntity;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCountryIso3Code() {
        return this.countryIso3Code;
    }

    public final OcrOriginEntity copy(DocumentResourceConfigEntity.DocumentTypeEntity documentTypeEntity, String countryIso3Code) {
        Intrinsics.checkNotNullParameter(documentTypeEntity, "documentTypeEntity");
        Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
        return new OcrOriginEntity(documentTypeEntity, countryIso3Code);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OcrOriginEntity)) {
            return false;
        }
        OcrOriginEntity ocrOriginEntity = (OcrOriginEntity) other;
        return this.documentTypeEntity == ocrOriginEntity.documentTypeEntity && Intrinsics.areEqual(this.countryIso3Code, ocrOriginEntity.countryIso3Code);
    }

    public final String getCountryIso3Code() {
        return this.countryIso3Code;
    }

    public final DocumentResourceConfigEntity.DocumentTypeEntity getDocumentTypeEntity() {
        return this.documentTypeEntity;
    }

    public int hashCode() {
        return (this.documentTypeEntity.hashCode() * 31) + this.countryIso3Code.hashCode();
    }

    public String toString() {
        return "OcrOriginEntity(documentTypeEntity=" + this.documentTypeEntity + ", countryIso3Code=" + this.countryIso3Code + ')';
    }
}
