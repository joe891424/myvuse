package com.yoti.mobile.android.documentcapture.p055id.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/domain/model/OcrResultEntity;", "", "origin", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/OcrOriginEntity;", "documentFields", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/DocumentFieldsEntity;", "(Lcom/yoti/mobile/android/documentcapture/id/domain/model/OcrOriginEntity;Lcom/yoti/mobile/android/documentcapture/id/domain/model/DocumentFieldsEntity;)V", "getDocumentFields", "()Lcom/yoti/mobile/android/documentcapture/id/domain/model/DocumentFieldsEntity;", "getOrigin", "()Lcom/yoti/mobile/android/documentcapture/id/domain/model/OcrOriginEntity;", "result", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/OcrResultTypeEntity;", "getResult", "()Lcom/yoti/mobile/android/documentcapture/id/domain/model/OcrResultTypeEntity;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class OcrResultEntity {
    private final DocumentFieldsEntity documentFields;
    private final OcrOriginEntity origin;
    private final OcrResultTypeEntity result;

    public OcrResultEntity(OcrOriginEntity origin, DocumentFieldsEntity documentFieldsEntity) {
        OcrResultTypeEntity ocrResultTypeEntity;
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.origin = origin;
        this.documentFields = documentFieldsEntity;
        this.result = (documentFieldsEntity == null || (ocrResultTypeEntity = OcrResultTypeEntity.SUCCESS) == null) ? OcrResultTypeEntity.FAILURE : ocrResultTypeEntity;
    }

    public static /* synthetic */ OcrResultEntity copy$default(OcrResultEntity ocrResultEntity, OcrOriginEntity ocrOriginEntity, DocumentFieldsEntity documentFieldsEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            ocrOriginEntity = ocrResultEntity.origin;
        }
        if ((i & 2) != 0) {
            documentFieldsEntity = ocrResultEntity.documentFields;
        }
        return ocrResultEntity.copy(ocrOriginEntity, documentFieldsEntity);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final OcrOriginEntity getOrigin() {
        return this.origin;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final DocumentFieldsEntity getDocumentFields() {
        return this.documentFields;
    }

    public final OcrResultEntity copy(OcrOriginEntity origin, DocumentFieldsEntity documentFields) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        return new OcrResultEntity(origin, documentFields);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OcrResultEntity)) {
            return false;
        }
        OcrResultEntity ocrResultEntity = (OcrResultEntity) other;
        return Intrinsics.areEqual(this.origin, ocrResultEntity.origin) && Intrinsics.areEqual(this.documentFields, ocrResultEntity.documentFields);
    }

    public final DocumentFieldsEntity getDocumentFields() {
        return this.documentFields;
    }

    public final OcrOriginEntity getOrigin() {
        return this.origin;
    }

    public final OcrResultTypeEntity getResult() {
        return this.result;
    }

    public int hashCode() {
        int iHashCode = this.origin.hashCode() * 31;
        DocumentFieldsEntity documentFieldsEntity = this.documentFields;
        return iHashCode + (documentFieldsEntity == null ? 0 : documentFieldsEntity.hashCode());
    }

    public String toString() {
        return "OcrResultEntity(origin=" + this.origin + ", documentFields=" + this.documentFields + ')';
    }

    public /* synthetic */ OcrResultEntity(OcrOriginEntity ocrOriginEntity, DocumentFieldsEntity documentFieldsEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ocrOriginEntity, (i & 2) != 0 ? null : documentFieldsEntity);
    }
}
