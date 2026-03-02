package com.yoti.mobile.android.documentcapture.p055id.data.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001a"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/PageScanConfiguration;", "", "type", "", "recognizer", "ocrSupported", "", "numberOfFrames", "", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "getNumberOfFrames", "()I", "getOcrSupported", "()Z", "getRecognizer", "()Ljava/lang/String;", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class PageScanConfiguration {

    @SerializedName("number_of_frames")
    private final int numberOfFrames;

    @SerializedName("ocr_supported")
    private final boolean ocrSupported;

    @SerializedName("scanner")
    private final String recognizer;

    @SerializedName("type")
    private final String type;

    public PageScanConfiguration(String type, String recognizer, boolean z, int i) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(recognizer, "recognizer");
        this.type = type;
        this.recognizer = recognizer;
        this.ocrSupported = z;
        this.numberOfFrames = i;
    }

    public static /* synthetic */ PageScanConfiguration copy$default(PageScanConfiguration pageScanConfiguration, String str, String str2, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = pageScanConfiguration.type;
        }
        if ((i2 & 2) != 0) {
            str2 = pageScanConfiguration.recognizer;
        }
        if ((i2 & 4) != 0) {
            z = pageScanConfiguration.ocrSupported;
        }
        if ((i2 & 8) != 0) {
            i = pageScanConfiguration.numberOfFrames;
        }
        return pageScanConfiguration.copy(str, str2, z, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRecognizer() {
        return this.recognizer;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getOcrSupported() {
        return this.ocrSupported;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getNumberOfFrames() {
        return this.numberOfFrames;
    }

    public final PageScanConfiguration copy(String type, String recognizer, boolean ocrSupported, int numberOfFrames) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(recognizer, "recognizer");
        return new PageScanConfiguration(type, recognizer, ocrSupported, numberOfFrames);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PageScanConfiguration)) {
            return false;
        }
        PageScanConfiguration pageScanConfiguration = (PageScanConfiguration) other;
        return Intrinsics.areEqual(this.type, pageScanConfiguration.type) && Intrinsics.areEqual(this.recognizer, pageScanConfiguration.recognizer) && this.ocrSupported == pageScanConfiguration.ocrSupported && this.numberOfFrames == pageScanConfiguration.numberOfFrames;
    }

    public final int getNumberOfFrames() {
        return this.numberOfFrames;
    }

    public final boolean getOcrSupported() {
        return this.ocrSupported;
    }

    public final String getRecognizer() {
        return this.recognizer;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = ((this.type.hashCode() * 31) + this.recognizer.hashCode()) * 31;
        boolean z = this.ocrSupported;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((iHashCode + r1) * 31) + Integer.hashCode(this.numberOfFrames);
    }

    public String toString() {
        return "PageScanConfiguration(type=" + this.type + ", recognizer=" + this.recognizer + ", ocrSupported=" + this.ocrSupported + ", numberOfFrames=" + this.numberOfFrames + ')';
    }
}
