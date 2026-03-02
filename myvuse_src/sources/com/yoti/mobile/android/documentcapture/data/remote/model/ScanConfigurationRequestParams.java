package com.yoti.mobile.android.documentcapture.data.remote.model;

import com.google.gson.annotations.SerializedName;
import com.yoti.mobile.android.yotisdkcore.core.data.model.DocumentType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/data/remote/model/ScanConfigurationRequestParams;", "", "requirement_id", "", "issuing_country", "document_type", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;", "(Ljava/lang/String;Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;)V", "getDocument_type", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;", "getIssuing_country", "()Ljava/lang/String;", "getRequirement_id", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class ScanConfigurationRequestParams {

    @SerializedName("document_type")
    private final DocumentType document_type;

    @SerializedName("issuing_country")
    private final String issuing_country;

    @SerializedName("requirement_id")
    private final String requirement_id;

    public ScanConfigurationRequestParams(String requirement_id, String issuing_country, DocumentType document_type) {
        Intrinsics.checkNotNullParameter(requirement_id, "requirement_id");
        Intrinsics.checkNotNullParameter(issuing_country, "issuing_country");
        Intrinsics.checkNotNullParameter(document_type, "document_type");
        this.requirement_id = requirement_id;
        this.issuing_country = issuing_country;
        this.document_type = document_type;
    }

    public static /* synthetic */ ScanConfigurationRequestParams copy$default(ScanConfigurationRequestParams scanConfigurationRequestParams, String str, String str2, DocumentType documentType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = scanConfigurationRequestParams.requirement_id;
        }
        if ((i & 2) != 0) {
            str2 = scanConfigurationRequestParams.issuing_country;
        }
        if ((i & 4) != 0) {
            documentType = scanConfigurationRequestParams.document_type;
        }
        return scanConfigurationRequestParams.copy(str, str2, documentType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRequirement_id() {
        return this.requirement_id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getIssuing_country() {
        return this.issuing_country;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final DocumentType getDocument_type() {
        return this.document_type;
    }

    public final ScanConfigurationRequestParams copy(String requirement_id, String issuing_country, DocumentType document_type) {
        Intrinsics.checkNotNullParameter(requirement_id, "requirement_id");
        Intrinsics.checkNotNullParameter(issuing_country, "issuing_country");
        Intrinsics.checkNotNullParameter(document_type, "document_type");
        return new ScanConfigurationRequestParams(requirement_id, issuing_country, document_type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScanConfigurationRequestParams)) {
            return false;
        }
        ScanConfigurationRequestParams scanConfigurationRequestParams = (ScanConfigurationRequestParams) other;
        return Intrinsics.areEqual(this.requirement_id, scanConfigurationRequestParams.requirement_id) && Intrinsics.areEqual(this.issuing_country, scanConfigurationRequestParams.issuing_country) && this.document_type == scanConfigurationRequestParams.document_type;
    }

    public final DocumentType getDocument_type() {
        return this.document_type;
    }

    public final String getIssuing_country() {
        return this.issuing_country;
    }

    public final String getRequirement_id() {
        return this.requirement_id;
    }

    public int hashCode() {
        return (((this.requirement_id.hashCode() * 31) + this.issuing_country.hashCode()) * 31) + this.document_type.hashCode();
    }

    public String toString() {
        return "ScanConfigurationRequestParams(requirement_id=" + this.requirement_id + ", issuing_country=" + this.issuing_country + ", document_type=" + this.document_type + ')';
    }
}
