package com.yoti.mobile.android.yotisdkcore.core.data.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/model/Document;", "", "_type", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;", "requirements", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentRequirements;", "(Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentRequirements;)V", "getRequirements", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentRequirements;", "type", "getType", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class Document {

    @SerializedName("type")
    private final DocumentType _type;

    @SerializedName("requirements")
    private final DocumentRequirements requirements;

    /* JADX WARN: Multi-variable type inference failed */
    public Document() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public Document(DocumentType documentType, DocumentRequirements documentRequirements) {
        this._type = documentType;
        this.requirements = documentRequirements;
    }

    public /* synthetic */ Document(DocumentType documentType, DocumentRequirements documentRequirements, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DocumentType.UNKNOWN : documentType, (i & 2) != 0 ? null : documentRequirements);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final DocumentType get_type() {
        return this._type;
    }

    public static /* synthetic */ Document copy$default(Document document, DocumentType documentType, DocumentRequirements documentRequirements, int i, Object obj) {
        if ((i & 1) != 0) {
            documentType = document._type;
        }
        if ((i & 2) != 0) {
            documentRequirements = document.requirements;
        }
        return document.copy(documentType, documentRequirements);
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final DocumentRequirements getRequirements() {
        return this.requirements;
    }

    public final Document copy(DocumentType _type, DocumentRequirements requirements) {
        return new Document(_type, requirements);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Document)) {
            return false;
        }
        Document document = (Document) other;
        return this._type == document._type && Intrinsics.areEqual(this.requirements, document.requirements);
    }

    public final DocumentRequirements getRequirements() {
        return this.requirements;
    }

    public final DocumentType getType() {
        DocumentType documentType = this._type;
        return documentType == null ? DocumentType.UNKNOWN : documentType;
    }

    public int hashCode() {
        DocumentType documentType = this._type;
        int iHashCode = (documentType == null ? 0 : documentType.hashCode()) * 31;
        DocumentRequirements documentRequirements = this.requirements;
        return iHashCode + (documentRequirements != null ? documentRequirements.hashCode() : 0);
    }

    public String toString() {
        return "Document(_type=" + this._type + ", requirements=" + this.requirements + ')';
    }
}
