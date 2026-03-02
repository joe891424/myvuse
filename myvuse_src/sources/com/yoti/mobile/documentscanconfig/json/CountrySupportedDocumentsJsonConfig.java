package com.yoti.mobile.documentscanconfig.json;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/documentscanconfig/json/CountrySupportedDocumentsJsonConfig;", "", "codeAlpha2", "", "codeAlpha3", "documents", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "getCodeAlpha2", "()Ljava/lang/String;", "getCodeAlpha3", "getDocuments", "()[Ljava/lang/String;", "[Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Lcom/yoti/mobile/documentscanconfig/json/CountrySupportedDocumentsJsonConfig;", "equals", "", "other", "hashCode", "", "toString", "documentscanconfig_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final /* data */ class CountrySupportedDocumentsJsonConfig {

    /* JADX INFO: renamed from: a */
    @SerializedName("codeAlpha2")
    private final String f7924a;

    /* JADX INFO: renamed from: b */
    @SerializedName("codeAlpha3")
    private final String f7925b;

    /* JADX INFO: renamed from: c */
    @SerializedName("documents")
    private final String[] f7926c;

    public CountrySupportedDocumentsJsonConfig(String codeAlpha2, String codeAlpha3, String[] documents) {
        Intrinsics.checkParameterIsNotNull(codeAlpha2, "codeAlpha2");
        Intrinsics.checkParameterIsNotNull(codeAlpha3, "codeAlpha3");
        Intrinsics.checkParameterIsNotNull(documents, "documents");
        this.f7924a = codeAlpha2;
        this.f7925b = codeAlpha3;
        this.f7926c = documents;
    }

    public static /* synthetic */ CountrySupportedDocumentsJsonConfig copy$default(CountrySupportedDocumentsJsonConfig countrySupportedDocumentsJsonConfig, String str, String str2, String[] strArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = countrySupportedDocumentsJsonConfig.f7924a;
        }
        if ((i & 2) != 0) {
            str2 = countrySupportedDocumentsJsonConfig.f7925b;
        }
        if ((i & 4) != 0) {
            strArr = countrySupportedDocumentsJsonConfig.f7926c;
        }
        return countrySupportedDocumentsJsonConfig.copy(str, str2, strArr);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getF7924a() {
        return this.f7924a;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getF7925b() {
        return this.f7925b;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String[] getF7926c() {
        return this.f7926c;
    }

    public final CountrySupportedDocumentsJsonConfig copy(String codeAlpha2, String codeAlpha3, String[] documents) {
        Intrinsics.checkParameterIsNotNull(codeAlpha2, "codeAlpha2");
        Intrinsics.checkParameterIsNotNull(codeAlpha3, "codeAlpha3");
        Intrinsics.checkParameterIsNotNull(documents, "documents");
        return new CountrySupportedDocumentsJsonConfig(codeAlpha2, codeAlpha3, documents);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CountrySupportedDocumentsJsonConfig)) {
            return false;
        }
        CountrySupportedDocumentsJsonConfig countrySupportedDocumentsJsonConfig = (CountrySupportedDocumentsJsonConfig) other;
        return Intrinsics.areEqual(this.f7924a, countrySupportedDocumentsJsonConfig.f7924a) && Intrinsics.areEqual(this.f7925b, countrySupportedDocumentsJsonConfig.f7925b) && Intrinsics.areEqual(this.f7926c, countrySupportedDocumentsJsonConfig.f7926c);
    }

    public final String getCodeAlpha2() {
        return this.f7924a;
    }

    public final String getCodeAlpha3() {
        return this.f7925b;
    }

    public final String[] getDocuments() {
        return this.f7926c;
    }

    public int hashCode() {
        String str = this.f7924a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f7925b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String[] strArr = this.f7926c;
        return iHashCode2 + (strArr != null ? Arrays.hashCode(strArr) : 0);
    }

    public String toString() {
        return "CountrySupportedDocumentsJsonConfig(codeAlpha2=" + this.f7924a + ", codeAlpha3=" + this.f7925b + ", documents=" + Arrays.toString(this.f7926c) + ")";
    }
}
