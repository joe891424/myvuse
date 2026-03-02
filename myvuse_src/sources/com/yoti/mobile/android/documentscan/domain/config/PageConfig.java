package com.yoti.mobile.android.documentscan.domain.config;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015JL\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/domain/config/PageConfig;", "Ljava/io/Serializable;", "scanner", "", "numberOfHolograms", "", "captureDocumentImage", "", "allowManualCapture", "manualScanTimer", "", "ocrSupported", "(Ljava/lang/String;IZZJLjava/lang/Boolean;)V", "getAllowManualCapture", "()Z", "getCaptureDocumentImage", "getManualScanTimer", "()J", "getNumberOfHolograms", "()I", "getOcrSupported", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getScanner", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;IZZJLjava/lang/Boolean;)Lcom/yoti/mobile/android/documentscan/domain/config/PageConfig;", "equals", "other", "", "hashCode", "toString", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final /* data */ class PageConfig implements Serializable {

    @SerializedName("manualCaptureFailover")
    private final boolean allowManualCapture;

    @SerializedName("captureDocumentImage")
    private final boolean captureDocumentImage;

    @SerializedName("manualScanTimer")
    private final long manualScanTimer;

    @SerializedName("numberOfHolograms")
    private final int numberOfHolograms;

    @SerializedName("ocrSupported")
    private final Boolean ocrSupported;

    @SerializedName("scanner")
    private final String scanner;

    public PageConfig(String scanner, int i, boolean z, boolean z2, long j, Boolean bool) {
        Intrinsics.checkParameterIsNotNull(scanner, "scanner");
        this.scanner = scanner;
        this.numberOfHolograms = i;
        this.captureDocumentImage = z;
        this.allowManualCapture = z2;
        this.manualScanTimer = j;
        this.ocrSupported = bool;
    }

    public static /* synthetic */ PageConfig copy$default(PageConfig pageConfig, String str, int i, boolean z, boolean z2, long j, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = pageConfig.scanner;
        }
        if ((i2 & 2) != 0) {
            i = pageConfig.numberOfHolograms;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            z = pageConfig.captureDocumentImage;
        }
        boolean z3 = z;
        if ((i2 & 8) != 0) {
            z2 = pageConfig.allowManualCapture;
        }
        boolean z4 = z2;
        if ((i2 & 16) != 0) {
            j = pageConfig.manualScanTimer;
        }
        long j2 = j;
        if ((i2 & 32) != 0) {
            bool = pageConfig.ocrSupported;
        }
        return pageConfig.copy(str, i3, z3, z4, j2, bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getScanner() {
        return this.scanner;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getNumberOfHolograms() {
        return this.numberOfHolograms;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCaptureDocumentImage() {
        return this.captureDocumentImage;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getAllowManualCapture() {
        return this.allowManualCapture;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getManualScanTimer() {
        return this.manualScanTimer;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Boolean getOcrSupported() {
        return this.ocrSupported;
    }

    public final PageConfig copy(String scanner, int numberOfHolograms, boolean captureDocumentImage, boolean allowManualCapture, long manualScanTimer, Boolean ocrSupported) {
        Intrinsics.checkParameterIsNotNull(scanner, "scanner");
        return new PageConfig(scanner, numberOfHolograms, captureDocumentImage, allowManualCapture, manualScanTimer, ocrSupported);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PageConfig)) {
            return false;
        }
        PageConfig pageConfig = (PageConfig) other;
        return Intrinsics.areEqual(this.scanner, pageConfig.scanner) && this.numberOfHolograms == pageConfig.numberOfHolograms && this.captureDocumentImage == pageConfig.captureDocumentImage && this.allowManualCapture == pageConfig.allowManualCapture && this.manualScanTimer == pageConfig.manualScanTimer && Intrinsics.areEqual(this.ocrSupported, pageConfig.ocrSupported);
    }

    public final boolean getAllowManualCapture() {
        return this.allowManualCapture;
    }

    public final boolean getCaptureDocumentImage() {
        return this.captureDocumentImage;
    }

    public final long getManualScanTimer() {
        return this.manualScanTimer;
    }

    public final int getNumberOfHolograms() {
        return this.numberOfHolograms;
    }

    public final Boolean getOcrSupported() {
        return this.ocrSupported;
    }

    public final String getScanner() {
        return this.scanner;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String str = this.scanner;
        int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + Integer.hashCode(this.numberOfHolograms)) * 31;
        boolean z = this.captureDocumentImage;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        boolean z2 = this.allowManualCapture;
        int iHashCode2 = (((i + (z2 ? 1 : z2)) * 31) + Long.hashCode(this.manualScanTimer)) * 31;
        Boolean bool = this.ocrSupported;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "PageConfig(scanner=" + this.scanner + ", numberOfHolograms=" + this.numberOfHolograms + ", captureDocumentImage=" + this.captureDocumentImage + ", allowManualCapture=" + this.allowManualCapture + ", manualScanTimer=" + this.manualScanTimer + ", ocrSupported=" + this.ocrSupported + ")";
    }
}
