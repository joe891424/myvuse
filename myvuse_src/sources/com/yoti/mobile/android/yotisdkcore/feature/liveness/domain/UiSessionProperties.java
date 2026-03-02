package com.yoti.mobile.android.yotisdkcore.feature.liveness.domain;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/UiSessionProperties;", "", "isMoreAboutVerificationEnabled", "", "isDoNotHaveDocumentOptionEnabled", "(ZZ)V", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class UiSessionProperties {
    private final boolean isDoNotHaveDocumentOptionEnabled;
    private final boolean isMoreAboutVerificationEnabled;

    public UiSessionProperties(boolean z, boolean z2) {
        this.isMoreAboutVerificationEnabled = z;
        this.isDoNotHaveDocumentOptionEnabled = z2;
    }

    public static /* synthetic */ UiSessionProperties copy$default(UiSessionProperties uiSessionProperties, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = uiSessionProperties.isMoreAboutVerificationEnabled;
        }
        if ((i & 2) != 0) {
            z2 = uiSessionProperties.isDoNotHaveDocumentOptionEnabled;
        }
        return uiSessionProperties.copy(z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsMoreAboutVerificationEnabled() {
        return this.isMoreAboutVerificationEnabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsDoNotHaveDocumentOptionEnabled() {
        return this.isDoNotHaveDocumentOptionEnabled;
    }

    public final UiSessionProperties copy(boolean isMoreAboutVerificationEnabled, boolean isDoNotHaveDocumentOptionEnabled) {
        return new UiSessionProperties(isMoreAboutVerificationEnabled, isDoNotHaveDocumentOptionEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UiSessionProperties)) {
            return false;
        }
        UiSessionProperties uiSessionProperties = (UiSessionProperties) other;
        return this.isMoreAboutVerificationEnabled == uiSessionProperties.isMoreAboutVerificationEnabled && this.isDoNotHaveDocumentOptionEnabled == uiSessionProperties.isDoNotHaveDocumentOptionEnabled;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean z = this.isMoreAboutVerificationEnabled;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.isDoNotHaveDocumentOptionEnabled;
        return i + (z2 ? 1 : z2);
    }

    public final boolean isDoNotHaveDocumentOptionEnabled() {
        return this.isDoNotHaveDocumentOptionEnabled;
    }

    public final boolean isMoreAboutVerificationEnabled() {
        return this.isMoreAboutVerificationEnabled;
    }

    public String toString() {
        return "UiSessionProperties(isMoreAboutVerificationEnabled=" + this.isMoreAboutVerificationEnabled + ", isDoNotHaveDocumentOptionEnabled=" + this.isDoNotHaveDocumentOptionEnabled + ')';
    }
}
