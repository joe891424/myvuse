package com.yoti.mobile.android.documentcapture.data.remote.model;

import com.google.gson.annotations.SerializedName;
import com.yoti.mobile.android.yotisdkcore.core.data.model.DocumentType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/data/remote/model/DocumentResourceInfo;", "", "id", "", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;", "countryIso3Code", "(Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;Ljava/lang/String;)V", "getCountryIso3Code", "()Ljava/lang/String;", "getDocumentType", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;", "getId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class DocumentResourceInfo {

    @SerializedName("countryIso3Code")
    private final String countryIso3Code;

    @SerializedName("documentType")
    private final DocumentType documentType;

    @SerializedName("id")
    private final String id;

    public DocumentResourceInfo(String id, DocumentType documentType, String countryIso3Code) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
        this.id = id;
        this.documentType = documentType;
        this.countryIso3Code = countryIso3Code;
    }

    public static /* synthetic */ DocumentResourceInfo copy$default(DocumentResourceInfo documentResourceInfo, String str, DocumentType documentType, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = documentResourceInfo.id;
        }
        if ((i & 2) != 0) {
            documentType = documentResourceInfo.documentType;
        }
        if ((i & 4) != 0) {
            str2 = documentResourceInfo.countryIso3Code;
        }
        return documentResourceInfo.copy(str, documentType, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final DocumentType getDocumentType() {
        return this.documentType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCountryIso3Code() {
        return this.countryIso3Code;
    }

    public final DocumentResourceInfo copy(String id, DocumentType documentType, String countryIso3Code) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
        return new DocumentResourceInfo(id, documentType, countryIso3Code);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentResourceInfo)) {
            return false;
        }
        DocumentResourceInfo documentResourceInfo = (DocumentResourceInfo) other;
        return Intrinsics.areEqual(this.id, documentResourceInfo.id) && this.documentType == documentResourceInfo.documentType && Intrinsics.areEqual(this.countryIso3Code, documentResourceInfo.countryIso3Code);
    }

    public final String getCountryIso3Code() {
        return this.countryIso3Code;
    }

    public final DocumentType getDocumentType() {
        return this.documentType;
    }

    public final String getId() {
        return this.id;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.documentType.hashCode()) * 31) + this.countryIso3Code.hashCode();
    }

    public String toString() {
        return "DocumentResourceInfo(id=" + this.id + ", documentType=" + this.documentType + ", countryIso3Code=" + this.countryIso3Code + ')';
    }
}
