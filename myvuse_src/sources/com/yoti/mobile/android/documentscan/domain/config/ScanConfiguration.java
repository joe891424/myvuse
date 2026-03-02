package com.yoti.mobile.android.documentscan.domain.config;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/domain/config/ScanConfiguration;", "Ljava/io/Serializable;", "pageConfig", "", "Lcom/yoti/mobile/android/documentscan/domain/config/PageConfig;", "([Lcom/yoti/mobile/android/documentscan/domain/config/PageConfig;)V", "getPageConfig", "()[Lcom/yoti/mobile/android/documentscan/domain/config/PageConfig;", "[Lcom/yoti/mobile/android/documentscan/domain/config/PageConfig;", "component1", "copy", "([Lcom/yoti/mobile/android/documentscan/domain/config/PageConfig;)Lcom/yoti/mobile/android/documentscan/domain/config/ScanConfiguration;", "equals", "", "other", "", "hashCode", "", "toString", "", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final /* data */ class ScanConfiguration implements Serializable {

    @SerializedName("pageConfig")
    private final PageConfig[] pageConfig;

    public ScanConfiguration(PageConfig[] pageConfig) {
        Intrinsics.checkParameterIsNotNull(pageConfig, "pageConfig");
        this.pageConfig = pageConfig;
    }

    public static /* synthetic */ ScanConfiguration copy$default(ScanConfiguration scanConfiguration, PageConfig[] pageConfigArr, int i, Object obj) {
        if ((i & 1) != 0) {
            pageConfigArr = scanConfiguration.pageConfig;
        }
        return scanConfiguration.copy(pageConfigArr);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PageConfig[] getPageConfig() {
        return this.pageConfig;
    }

    public final ScanConfiguration copy(PageConfig[] pageConfig) {
        Intrinsics.checkParameterIsNotNull(pageConfig, "pageConfig");
        return new ScanConfiguration(pageConfig);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(ScanConfiguration.class, other != null ? other.getClass() : null)) {
            return false;
        }
        if (other != null) {
            return Arrays.equals(this.pageConfig, ((ScanConfiguration) other).pageConfig);
        }
        throw new TypeCastException("null cannot be cast to non-null type com.yoti.mobile.android.documentscan.domain.config.ScanConfiguration");
    }

    public final PageConfig[] getPageConfig() {
        return this.pageConfig;
    }

    public int hashCode() {
        return Arrays.hashCode(this.pageConfig);
    }

    public String toString() {
        return "ScanConfiguration(pageConfig=" + Arrays.toString(this.pageConfig) + ")";
    }
}
