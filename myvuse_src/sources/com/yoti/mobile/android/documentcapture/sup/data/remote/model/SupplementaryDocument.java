package com.yoti.mobile.android.documentcapture.sup.data.remote.model;

import android.net.Uri;
import com.yoti.mobile.android.documentcapture.data.remote.model.DocumentResourceInfo;
import com.yoti.mobile.android.documentcapture.data.remote.model.IUploadableDocument;
import com.yoti.mobile.android.documentcapture.data.remote.model.PageInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/data/remote/model/SupplementaryDocument;", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/IUploadableDocument;", "resourceInfo", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/DocumentResourceInfo;", "fileUri", "Landroid/net/Uri;", "pageInfo", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/PageInfo;", "ocrData", "Lcom/yoti/mobile/android/documentcapture/sup/data/remote/model/OcrData;", "(Lcom/yoti/mobile/android/documentcapture/data/remote/model/DocumentResourceInfo;Landroid/net/Uri;Lcom/yoti/mobile/android/documentcapture/data/remote/model/PageInfo;Lcom/yoti/mobile/android/documentcapture/sup/data/remote/model/OcrData;)V", "getFileUri", "()Landroid/net/Uri;", "getOcrData", "()Lcom/yoti/mobile/android/documentcapture/sup/data/remote/model/OcrData;", "getPageInfo", "()Lcom/yoti/mobile/android/documentcapture/data/remote/model/PageInfo;", "getResourceInfo", "()Lcom/yoti/mobile/android/documentcapture/data/remote/model/DocumentResourceInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class SupplementaryDocument implements IUploadableDocument {
    private final Uri fileUri;
    private final OcrData ocrData;
    private final PageInfo pageInfo;
    private final DocumentResourceInfo resourceInfo;

    public SupplementaryDocument(DocumentResourceInfo resourceInfo, Uri fileUri, PageInfo pageInfo, OcrData ocrData) {
        Intrinsics.checkNotNullParameter(resourceInfo, "resourceInfo");
        Intrinsics.checkNotNullParameter(fileUri, "fileUri");
        Intrinsics.checkNotNullParameter(pageInfo, "pageInfo");
        this.resourceInfo = resourceInfo;
        this.fileUri = fileUri;
        this.pageInfo = pageInfo;
        this.ocrData = ocrData;
    }

    public static /* synthetic */ SupplementaryDocument copy$default(SupplementaryDocument supplementaryDocument, DocumentResourceInfo documentResourceInfo, Uri uri, PageInfo pageInfo, OcrData ocrData, int i, Object obj) {
        if ((i & 1) != 0) {
            documentResourceInfo = supplementaryDocument.getResourceInfo();
        }
        if ((i & 2) != 0) {
            uri = supplementaryDocument.fileUri;
        }
        if ((i & 4) != 0) {
            pageInfo = supplementaryDocument.pageInfo;
        }
        if ((i & 8) != 0) {
            ocrData = supplementaryDocument.ocrData;
        }
        return supplementaryDocument.copy(documentResourceInfo, uri, pageInfo, ocrData);
    }

    public final DocumentResourceInfo component1() {
        return getResourceInfo();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Uri getFileUri() {
        return this.fileUri;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PageInfo getPageInfo() {
        return this.pageInfo;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final OcrData getOcrData() {
        return this.ocrData;
    }

    public final SupplementaryDocument copy(DocumentResourceInfo resourceInfo, Uri fileUri, PageInfo pageInfo, OcrData ocrData) {
        Intrinsics.checkNotNullParameter(resourceInfo, "resourceInfo");
        Intrinsics.checkNotNullParameter(fileUri, "fileUri");
        Intrinsics.checkNotNullParameter(pageInfo, "pageInfo");
        return new SupplementaryDocument(resourceInfo, fileUri, pageInfo, ocrData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SupplementaryDocument)) {
            return false;
        }
        SupplementaryDocument supplementaryDocument = (SupplementaryDocument) other;
        return Intrinsics.areEqual(getResourceInfo(), supplementaryDocument.getResourceInfo()) && Intrinsics.areEqual(this.fileUri, supplementaryDocument.fileUri) && Intrinsics.areEqual(this.pageInfo, supplementaryDocument.pageInfo) && Intrinsics.areEqual(this.ocrData, supplementaryDocument.ocrData);
    }

    public final Uri getFileUri() {
        return this.fileUri;
    }

    public final OcrData getOcrData() {
        return this.ocrData;
    }

    public final PageInfo getPageInfo() {
        return this.pageInfo;
    }

    @Override // com.yoti.mobile.android.documentcapture.data.remote.model.IUploadableDocument
    public DocumentResourceInfo getResourceInfo() {
        return this.resourceInfo;
    }

    public int hashCode() {
        int iHashCode = ((((getResourceInfo().hashCode() * 31) + this.fileUri.hashCode()) * 31) + this.pageInfo.hashCode()) * 31;
        OcrData ocrData = this.ocrData;
        return iHashCode + (ocrData == null ? 0 : ocrData.hashCode());
    }

    public String toString() {
        return "SupplementaryDocument(resourceInfo=" + getResourceInfo() + ", fileUri=" + this.fileUri + ", pageInfo=" + this.pageInfo + ", ocrData=" + this.ocrData + ')';
    }

    public /* synthetic */ SupplementaryDocument(DocumentResourceInfo documentResourceInfo, Uri uri, PageInfo pageInfo, OcrData ocrData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(documentResourceInfo, uri, pageInfo, (i & 8) != 0 ? null : ocrData);
    }
}
