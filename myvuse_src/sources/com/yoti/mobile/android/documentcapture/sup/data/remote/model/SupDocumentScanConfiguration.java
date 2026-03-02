package com.yoti.mobile.android.documentcapture.sup.data.remote.model;

import com.google.gson.annotations.SerializedName;
import com.yoti.mobile.android.yotisdkcore.core.data.model.DocumentType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/data/remote/model/SupDocumentScanConfiguration;", "", "resourceId", "", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;", "issuingCountryIso3Code", "(Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;Ljava/lang/String;)V", "getDocumentType", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;", "getIssuingCountryIso3Code", "()Ljava/lang/String;", "getResourceId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class SupDocumentScanConfiguration {

    @SerializedName("document_type")
    private final DocumentType documentType;

    @SerializedName("issuing_country")
    private final String issuingCountryIso3Code;

    @SerializedName("id")
    private final String resourceId;

    public SupDocumentScanConfiguration() {
        this(null, null, null, 7, null);
    }

    public SupDocumentScanConfiguration(String resourceId, DocumentType documentType, String issuingCountryIso3Code) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Intrinsics.checkNotNullParameter(issuingCountryIso3Code, "issuingCountryIso3Code");
        this.resourceId = resourceId;
        this.documentType = documentType;
        this.issuingCountryIso3Code = issuingCountryIso3Code;
    }

    public static /* synthetic */ SupDocumentScanConfiguration copy$default(SupDocumentScanConfiguration supDocumentScanConfiguration, String str, DocumentType documentType, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = supDocumentScanConfiguration.resourceId;
        }
        if ((i & 2) != 0) {
            documentType = supDocumentScanConfiguration.documentType;
        }
        if ((i & 4) != 0) {
            str2 = supDocumentScanConfiguration.issuingCountryIso3Code;
        }
        return supDocumentScanConfiguration.copy(str, documentType, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getResourceId() {
        return this.resourceId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final DocumentType getDocumentType() {
        return this.documentType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getIssuingCountryIso3Code() {
        return this.issuingCountryIso3Code;
    }

    public final SupDocumentScanConfiguration copy(String resourceId, DocumentType documentType, String issuingCountryIso3Code) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Intrinsics.checkNotNullParameter(issuingCountryIso3Code, "issuingCountryIso3Code");
        return new SupDocumentScanConfiguration(resourceId, documentType, issuingCountryIso3Code);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SupDocumentScanConfiguration)) {
            return false;
        }
        SupDocumentScanConfiguration supDocumentScanConfiguration = (SupDocumentScanConfiguration) other;
        return Intrinsics.areEqual(this.resourceId, supDocumentScanConfiguration.resourceId) && this.documentType == supDocumentScanConfiguration.documentType && Intrinsics.areEqual(this.issuingCountryIso3Code, supDocumentScanConfiguration.issuingCountryIso3Code);
    }

    public final DocumentType getDocumentType() {
        return this.documentType;
    }

    public final String getIssuingCountryIso3Code() {
        return this.issuingCountryIso3Code;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public int hashCode() {
        return (((this.resourceId.hashCode() * 31) + this.documentType.hashCode()) * 31) + this.issuingCountryIso3Code.hashCode();
    }

    public String toString() {
        return "SupDocumentScanConfiguration(resourceId=" + this.resourceId + ", documentType=" + this.documentType + ", issuingCountryIso3Code=" + this.issuingCountryIso3Code + ')';
    }

    public /* synthetic */ SupDocumentScanConfiguration(String str, DocumentType documentType, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? DocumentType.UNKNOWN : documentType, (i & 4) != 0 ? "" : str2);
    }
}
