package com.yoti.mobile.android.documentcapture.p055id.data.remote.model;

import com.yoti.mobile.android.documentcapture.data.remote.model.DocumentPage;
import com.yoti.mobile.android.documentcapture.data.remote.model.DocumentResourceInfo;
import com.yoti.mobile.android.documentcapture.data.remote.model.IUploadableDocument;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.proto.Chip;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/IdDocument;", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/IUploadableDocument;", "resourceInfo", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/DocumentResourceInfo;", "pages", "", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/DocumentPage;", "ocrData", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/OcrResult;", "chipData", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/proto/Chip;", "(Lcom/yoti/mobile/android/documentcapture/data/remote/model/DocumentResourceInfo;Ljava/util/List;Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/OcrResult;Lcom/yoti/mobile/android/documentcapture/id/data/remote/proto/Chip;)V", "getChipData", "()Lcom/yoti/mobile/android/documentcapture/id/data/remote/proto/Chip;", "getOcrData", "()Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/OcrResult;", "getPages", "()Ljava/util/List;", "getResourceInfo", "()Lcom/yoti/mobile/android/documentcapture/data/remote/model/DocumentResourceInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class IdDocument implements IUploadableDocument {
    private final Chip chipData;
    private final OcrResult ocrData;
    private final List<DocumentPage> pages;
    private final DocumentResourceInfo resourceInfo;

    public IdDocument(DocumentResourceInfo resourceInfo, List<DocumentPage> pages, OcrResult ocrResult, Chip chip) {
        Intrinsics.checkNotNullParameter(resourceInfo, "resourceInfo");
        Intrinsics.checkNotNullParameter(pages, "pages");
        this.resourceInfo = resourceInfo;
        this.pages = pages;
        this.ocrData = ocrResult;
        this.chipData = chip;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IdDocument copy$default(IdDocument idDocument, DocumentResourceInfo documentResourceInfo, List list, OcrResult ocrResult, Chip chip, int i, Object obj) {
        if ((i & 1) != 0) {
            documentResourceInfo = idDocument.getResourceInfo();
        }
        if ((i & 2) != 0) {
            list = idDocument.pages;
        }
        if ((i & 4) != 0) {
            ocrResult = idDocument.ocrData;
        }
        if ((i & 8) != 0) {
            chip = idDocument.chipData;
        }
        return idDocument.copy(documentResourceInfo, list, ocrResult, chip);
    }

    public final DocumentResourceInfo component1() {
        return getResourceInfo();
    }

    public final List<DocumentPage> component2() {
        return this.pages;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final OcrResult getOcrData() {
        return this.ocrData;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Chip getChipData() {
        return this.chipData;
    }

    public final IdDocument copy(DocumentResourceInfo resourceInfo, List<DocumentPage> pages, OcrResult ocrData, Chip chipData) {
        Intrinsics.checkNotNullParameter(resourceInfo, "resourceInfo");
        Intrinsics.checkNotNullParameter(pages, "pages");
        return new IdDocument(resourceInfo, pages, ocrData, chipData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdDocument)) {
            return false;
        }
        IdDocument idDocument = (IdDocument) other;
        return Intrinsics.areEqual(getResourceInfo(), idDocument.getResourceInfo()) && Intrinsics.areEqual(this.pages, idDocument.pages) && Intrinsics.areEqual(this.ocrData, idDocument.ocrData) && Intrinsics.areEqual(this.chipData, idDocument.chipData);
    }

    public final Chip getChipData() {
        return this.chipData;
    }

    public final OcrResult getOcrData() {
        return this.ocrData;
    }

    public final List<DocumentPage> getPages() {
        return this.pages;
    }

    @Override // com.yoti.mobile.android.documentcapture.data.remote.model.IUploadableDocument
    public DocumentResourceInfo getResourceInfo() {
        return this.resourceInfo;
    }

    public int hashCode() {
        int iHashCode = ((getResourceInfo().hashCode() * 31) + this.pages.hashCode()) * 31;
        OcrResult ocrResult = this.ocrData;
        int iHashCode2 = (iHashCode + (ocrResult == null ? 0 : ocrResult.hashCode())) * 31;
        Chip chip = this.chipData;
        return iHashCode2 + (chip != null ? chip.hashCode() : 0);
    }

    public String toString() {
        return "IdDocument(resourceInfo=" + getResourceInfo() + ", pages=" + this.pages + ", ocrData=" + this.ocrData + ", chipData=" + this.chipData + ')';
    }

    public /* synthetic */ IdDocument(DocumentResourceInfo documentResourceInfo, List list, OcrResult ocrResult, Chip chip, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(documentResourceInfo, list, (i & 4) != 0 ? null : ocrResult, (i & 8) != 0 ? null : chip);
    }
}
