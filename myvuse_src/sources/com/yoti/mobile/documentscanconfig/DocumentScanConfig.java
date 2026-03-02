package com.yoti.mobile.documentscanconfig;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/documentscanconfig/DocumentScanConfig;", "", "country", "Lcom/yoti/mobile/documentscanconfig/CountryCode;", "documentConfigKey", "", "(Lcom/yoti/mobile/documentscanconfig/CountryCode;Ljava/lang/String;)V", "getCountry", "()Lcom/yoti/mobile/documentscanconfig/CountryCode;", "getDocumentConfigKey", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "documentscanconfig_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final /* data */ class DocumentScanConfig {

    /* JADX INFO: renamed from: a */
    private final CountryCode f7905a;

    /* JADX INFO: renamed from: b */
    private final String f7906b;

    public DocumentScanConfig(CountryCode country, String documentConfigKey) {
        Intrinsics.checkParameterIsNotNull(country, "country");
        Intrinsics.checkParameterIsNotNull(documentConfigKey, "documentConfigKey");
        this.f7905a = country;
        this.f7906b = documentConfigKey;
    }

    public static /* synthetic */ DocumentScanConfig copy$default(DocumentScanConfig documentScanConfig, CountryCode countryCode, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            countryCode = documentScanConfig.f7905a;
        }
        if ((i & 2) != 0) {
            str = documentScanConfig.f7906b;
        }
        return documentScanConfig.copy(countryCode, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CountryCode getF7905a() {
        return this.f7905a;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getF7906b() {
        return this.f7906b;
    }

    public final DocumentScanConfig copy(CountryCode country, String documentConfigKey) {
        Intrinsics.checkParameterIsNotNull(country, "country");
        Intrinsics.checkParameterIsNotNull(documentConfigKey, "documentConfigKey");
        return new DocumentScanConfig(country, documentConfigKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentScanConfig)) {
            return false;
        }
        DocumentScanConfig documentScanConfig = (DocumentScanConfig) other;
        return Intrinsics.areEqual(this.f7905a, documentScanConfig.f7905a) && Intrinsics.areEqual(this.f7906b, documentScanConfig.f7906b);
    }

    public final CountryCode getCountry() {
        return this.f7905a;
    }

    public final String getDocumentConfigKey() {
        return this.f7906b;
    }

    public int hashCode() {
        CountryCode countryCode = this.f7905a;
        int iHashCode = (countryCode != null ? countryCode.hashCode() : 0) * 31;
        String str = this.f7906b;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "DocumentScanConfig(country=" + this.f7905a + ", documentConfigKey=" + this.f7906b + ")";
    }
}
