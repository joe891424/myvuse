package com.yoti.mobile.android.documentcapture.p055id.data.remote.model;

import com.google.gson.annotations.SerializedName;
import com.yoti.mobile.android.yotisdkcore.core.data.model.DocumentType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003JK\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001J\u0013\u0010,\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010!R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0011¨\u00061"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/ScanConfiguration;", "", "resourceId", "", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;", "issuingCountryIso3Code", "chipPresent", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/ChipPresentStatus;", "consentRequired", "", "pages", "", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/Page;", "(Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;Ljava/lang/String;Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/ChipPresentStatus;ZLjava/util/List;)V", "blinkIdKey", "getBlinkIdKey", "()Ljava/lang/String;", "setBlinkIdKey", "(Ljava/lang/String;)V", "blinkIdLicensee", "getBlinkIdLicensee", "setBlinkIdLicensee", "getChipPresent", "()Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/ChipPresentStatus;", "getConsentRequired", "()Z", "getDocumentType", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;", "getIssuingCountryIso3Code", "ocrRequired", "getOcrRequired", "setOcrRequired", "(Z)V", "getPages", "()Ljava/util/List;", "getResourceId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class ScanConfiguration {
    public String blinkIdKey;
    private String blinkIdLicensee;

    @SerializedName("chip_present")
    private final ChipPresentStatus chipPresent;

    @SerializedName("consent_required")
    private final boolean consentRequired;

    @SerializedName("document_type")
    private final DocumentType documentType;

    @SerializedName("issuing_country")
    private final String issuingCountryIso3Code;
    private boolean ocrRequired;

    @SerializedName("pages")
    private final List<Page> pages;

    @SerializedName("id")
    private final String resourceId;

    public ScanConfiguration() {
        this(null, null, null, null, false, null, 63, null);
    }

    public ScanConfiguration(String resourceId, DocumentType documentType, String issuingCountryIso3Code, ChipPresentStatus chipPresent, boolean z, List<Page> pages) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Intrinsics.checkNotNullParameter(issuingCountryIso3Code, "issuingCountryIso3Code");
        Intrinsics.checkNotNullParameter(chipPresent, "chipPresent");
        Intrinsics.checkNotNullParameter(pages, "pages");
        this.resourceId = resourceId;
        this.documentType = documentType;
        this.issuingCountryIso3Code = issuingCountryIso3Code;
        this.chipPresent = chipPresent;
        this.consentRequired = z;
        this.pages = pages;
        this.ocrRequired = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ScanConfiguration copy$default(ScanConfiguration scanConfiguration, String str, DocumentType documentType, String str2, ChipPresentStatus chipPresentStatus, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = scanConfiguration.resourceId;
        }
        if ((i & 2) != 0) {
            documentType = scanConfiguration.documentType;
        }
        DocumentType documentType2 = documentType;
        if ((i & 4) != 0) {
            str2 = scanConfiguration.issuingCountryIso3Code;
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            chipPresentStatus = scanConfiguration.chipPresent;
        }
        ChipPresentStatus chipPresentStatus2 = chipPresentStatus;
        if ((i & 16) != 0) {
            z = scanConfiguration.consentRequired;
        }
        boolean z2 = z;
        if ((i & 32) != 0) {
            list = scanConfiguration.pages;
        }
        return scanConfiguration.copy(str, documentType2, str3, chipPresentStatus2, z2, list);
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

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ChipPresentStatus getChipPresent() {
        return this.chipPresent;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getConsentRequired() {
        return this.consentRequired;
    }

    public final List<Page> component6() {
        return this.pages;
    }

    public final ScanConfiguration copy(String resourceId, DocumentType documentType, String issuingCountryIso3Code, ChipPresentStatus chipPresent, boolean consentRequired, List<Page> pages) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Intrinsics.checkNotNullParameter(issuingCountryIso3Code, "issuingCountryIso3Code");
        Intrinsics.checkNotNullParameter(chipPresent, "chipPresent");
        Intrinsics.checkNotNullParameter(pages, "pages");
        return new ScanConfiguration(resourceId, documentType, issuingCountryIso3Code, chipPresent, consentRequired, pages);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScanConfiguration)) {
            return false;
        }
        ScanConfiguration scanConfiguration = (ScanConfiguration) other;
        return Intrinsics.areEqual(this.resourceId, scanConfiguration.resourceId) && this.documentType == scanConfiguration.documentType && Intrinsics.areEqual(this.issuingCountryIso3Code, scanConfiguration.issuingCountryIso3Code) && this.chipPresent == scanConfiguration.chipPresent && this.consentRequired == scanConfiguration.consentRequired && Intrinsics.areEqual(this.pages, scanConfiguration.pages);
    }

    public final String getBlinkIdKey() {
        String str = this.blinkIdKey;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("blinkIdKey");
        return null;
    }

    public final String getBlinkIdLicensee() {
        return this.blinkIdLicensee;
    }

    public final ChipPresentStatus getChipPresent() {
        return this.chipPresent;
    }

    public final boolean getConsentRequired() {
        return this.consentRequired;
    }

    public final DocumentType getDocumentType() {
        return this.documentType;
    }

    public final String getIssuingCountryIso3Code() {
        return this.issuingCountryIso3Code;
    }

    public final boolean getOcrRequired() {
        return this.ocrRequired;
    }

    public final List<Page> getPages() {
        return this.pages;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    public int hashCode() {
        int iHashCode = ((((((this.resourceId.hashCode() * 31) + this.documentType.hashCode()) * 31) + this.issuingCountryIso3Code.hashCode()) * 31) + this.chipPresent.hashCode()) * 31;
        boolean z = this.consentRequired;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((iHashCode + r1) * 31) + this.pages.hashCode();
    }

    public final void setBlinkIdKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.blinkIdKey = str;
    }

    public final void setBlinkIdLicensee(String str) {
        this.blinkIdLicensee = str;
    }

    public final void setOcrRequired(boolean z) {
        this.ocrRequired = z;
    }

    public String toString() {
        return "ScanConfiguration(resourceId=" + this.resourceId + ", documentType=" + this.documentType + ", issuingCountryIso3Code=" + this.issuingCountryIso3Code + ", chipPresent=" + this.chipPresent + ", consentRequired=" + this.consentRequired + ", pages=" + this.pages + ')';
    }

    public /* synthetic */ ScanConfiguration(String str, DocumentType documentType, String str2, ChipPresentStatus chipPresentStatus, boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? DocumentType.UNKNOWN : documentType, (i & 4) == 0 ? str2 : "", (i & 8) != 0 ? ChipPresentStatus.UNKNOWN : chipPresentStatus, (i & 16) != 0 ? false : z, (i & 32) != 0 ? CollectionsKt.emptyList() : list);
    }
}
