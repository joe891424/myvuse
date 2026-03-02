package com.yoti.mobile.android.documentcapture.p055id.data.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/OcrResult;", "", "result", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/OcrResultType;", "documentFields", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/DocumentFields;", "(Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/OcrResultType;Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/DocumentFields;)V", "getDocumentFields", "()Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/DocumentFields;", "getResult", "()Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/OcrResultType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class OcrResult {

    @SerializedName("document_fields")
    private final DocumentFields documentFields;

    @SerializedName("client_extraction_outcome")
    private final OcrResultType result;

    /* JADX WARN: Multi-variable type inference failed */
    public OcrResult() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public OcrResult(OcrResultType result, DocumentFields documentFields) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.result = result;
        this.documentFields = documentFields;
    }

    public static /* synthetic */ OcrResult copy$default(OcrResult ocrResult, OcrResultType ocrResultType, DocumentFields documentFields, int i, Object obj) {
        if ((i & 1) != 0) {
            ocrResultType = ocrResult.result;
        }
        if ((i & 2) != 0) {
            documentFields = ocrResult.documentFields;
        }
        return ocrResult.copy(ocrResultType, documentFields);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final OcrResultType getResult() {
        return this.result;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final DocumentFields getDocumentFields() {
        return this.documentFields;
    }

    public final OcrResult copy(OcrResultType result, DocumentFields documentFields) {
        Intrinsics.checkNotNullParameter(result, "result");
        return new OcrResult(result, documentFields);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OcrResult)) {
            return false;
        }
        OcrResult ocrResult = (OcrResult) other;
        return this.result == ocrResult.result && Intrinsics.areEqual(this.documentFields, ocrResult.documentFields);
    }

    public final DocumentFields getDocumentFields() {
        return this.documentFields;
    }

    public final OcrResultType getResult() {
        return this.result;
    }

    public int hashCode() {
        int iHashCode = this.result.hashCode() * 31;
        DocumentFields documentFields = this.documentFields;
        return iHashCode + (documentFields == null ? 0 : documentFields.hashCode());
    }

    public String toString() {
        return "OcrResult(result=" + this.result + ", documentFields=" + this.documentFields + ')';
    }

    public /* synthetic */ OcrResult(OcrResultType ocrResultType, DocumentFields documentFields, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? OcrResultType.NOT_ATTEMPTED : ocrResultType, (i & 2) != 0 ? null : documentFields);
    }
}
