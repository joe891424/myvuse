package com.yoti.mobile.android.documentcapture.sup.domain.model;

import android.net.Uri;
import com.yoti.mobile.android.documentcapture.domain.model.CaptureMethodTypeEntity;
import com.yoti.mobile.android.documentcapture.domain.model.DocumentResourceInfoEntity;
import com.yoti.mobile.android.documentcapture.domain.model.IDocumentEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/domain/model/SupplementaryDocumentEntity;", "Lcom/yoti/mobile/android/documentcapture/domain/model/IDocumentEntity;", "resourceInfo", "Lcom/yoti/mobile/android/documentcapture/domain/model/DocumentResourceInfoEntity;", "document", "Landroid/net/Uri;", "captureMethod", "Lcom/yoti/mobile/android/documentcapture/domain/model/CaptureMethodTypeEntity;", "(Lcom/yoti/mobile/android/documentcapture/domain/model/DocumentResourceInfoEntity;Landroid/net/Uri;Lcom/yoti/mobile/android/documentcapture/domain/model/CaptureMethodTypeEntity;)V", "getCaptureMethod", "()Lcom/yoti/mobile/android/documentcapture/domain/model/CaptureMethodTypeEntity;", "getDocument", "()Landroid/net/Uri;", "getResourceInfo", "()Lcom/yoti/mobile/android/documentcapture/domain/model/DocumentResourceInfoEntity;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class SupplementaryDocumentEntity implements IDocumentEntity {
    private final CaptureMethodTypeEntity captureMethod;
    private final Uri document;
    private final DocumentResourceInfoEntity resourceInfo;

    public SupplementaryDocumentEntity(DocumentResourceInfoEntity resourceInfo, Uri document, CaptureMethodTypeEntity captureMethod) {
        Intrinsics.checkNotNullParameter(resourceInfo, "resourceInfo");
        Intrinsics.checkNotNullParameter(document, "document");
        Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
        this.resourceInfo = resourceInfo;
        this.document = document;
        this.captureMethod = captureMethod;
    }

    public static /* synthetic */ SupplementaryDocumentEntity copy$default(SupplementaryDocumentEntity supplementaryDocumentEntity, DocumentResourceInfoEntity documentResourceInfoEntity, Uri uri, CaptureMethodTypeEntity captureMethodTypeEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            documentResourceInfoEntity = supplementaryDocumentEntity.getResourceInfo();
        }
        if ((i & 2) != 0) {
            uri = supplementaryDocumentEntity.document;
        }
        if ((i & 4) != 0) {
            captureMethodTypeEntity = supplementaryDocumentEntity.captureMethod;
        }
        return supplementaryDocumentEntity.copy(documentResourceInfoEntity, uri, captureMethodTypeEntity);
    }

    public final DocumentResourceInfoEntity component1() {
        return getResourceInfo();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Uri getDocument() {
        return this.document;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CaptureMethodTypeEntity getCaptureMethod() {
        return this.captureMethod;
    }

    public final SupplementaryDocumentEntity copy(DocumentResourceInfoEntity resourceInfo, Uri document, CaptureMethodTypeEntity captureMethod) {
        Intrinsics.checkNotNullParameter(resourceInfo, "resourceInfo");
        Intrinsics.checkNotNullParameter(document, "document");
        Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
        return new SupplementaryDocumentEntity(resourceInfo, document, captureMethod);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SupplementaryDocumentEntity)) {
            return false;
        }
        SupplementaryDocumentEntity supplementaryDocumentEntity = (SupplementaryDocumentEntity) other;
        return Intrinsics.areEqual(getResourceInfo(), supplementaryDocumentEntity.getResourceInfo()) && Intrinsics.areEqual(this.document, supplementaryDocumentEntity.document) && this.captureMethod == supplementaryDocumentEntity.captureMethod;
    }

    public final CaptureMethodTypeEntity getCaptureMethod() {
        return this.captureMethod;
    }

    public final Uri getDocument() {
        return this.document;
    }

    @Override // com.yoti.mobile.android.documentcapture.domain.model.IDocumentEntity
    public DocumentResourceInfoEntity getResourceInfo() {
        return this.resourceInfo;
    }

    public int hashCode() {
        return (((getResourceInfo().hashCode() * 31) + this.document.hashCode()) * 31) + this.captureMethod.hashCode();
    }

    public String toString() {
        return "SupplementaryDocumentEntity(resourceInfo=" + getResourceInfo() + ", document=" + this.document + ", captureMethod=" + this.captureMethod + ')';
    }
}
