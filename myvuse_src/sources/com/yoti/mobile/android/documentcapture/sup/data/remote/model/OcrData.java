package com.yoti.mobile.android.documentcapture.sup.data.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001:\u0001\u0010B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/data/remote/model/OcrData;", "", "documentData", "Lcom/yoti/mobile/android/documentcapture/sup/data/remote/model/OcrData$DocumentData;", "(Lcom/yoti/mobile/android/documentcapture/sup/data/remote/model/OcrData$DocumentData;)V", "getDocumentData", "()Lcom/yoti/mobile/android/documentcapture/sup/data/remote/model/OcrData$DocumentData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "DocumentData", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class OcrData {

    @SerializedName("document_fields")
    private final DocumentData documentData;

    @Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/data/remote/model/OcrData$DocumentData;", "", "()V", "equals", "", "other", "hashCode", "", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class DocumentData {
        public boolean equals(Object other) {
            return other instanceof DocumentData;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OcrData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public OcrData(DocumentData documentData) {
        Intrinsics.checkNotNullParameter(documentData, "documentData");
        this.documentData = documentData;
    }

    public static /* synthetic */ OcrData copy$default(OcrData ocrData, DocumentData documentData, int i, Object obj) {
        if ((i & 1) != 0) {
            documentData = ocrData.documentData;
        }
        return ocrData.copy(documentData);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DocumentData getDocumentData() {
        return this.documentData;
    }

    public final OcrData copy(DocumentData documentData) {
        Intrinsics.checkNotNullParameter(documentData, "documentData");
        return new OcrData(documentData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof OcrData) && Intrinsics.areEqual(this.documentData, ((OcrData) other).documentData);
    }

    public final DocumentData getDocumentData() {
        return this.documentData;
    }

    public int hashCode() {
        return this.documentData.hashCode();
    }

    public String toString() {
        return "OcrData(documentData=" + this.documentData + ')';
    }

    public /* synthetic */ OcrData(DocumentData documentData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DocumentData() : documentData);
    }
}
