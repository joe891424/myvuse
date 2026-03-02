package com.yoti.mobile.android.documentscan.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\fHÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\u000fHÆ\u0003Jc\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\u0013\u0010*\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0006HÖ\u0001J\u0006\u0010.\u001a\u00020\tJ\t\u0010/\u001a\u00020\u0003HÖ\u0001J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001c¨\u00065"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/model/DocumentScanDetailedPageConfig;", "Landroid/os/Parcelable;", "documentConfigKey", "", "blinkRecognizerId", "pageNumber", "", "wantedNbOfHolograms", "shouldCaptureDocumentImage", "", "allowManualCapture", "manualScanTimerMs", "", "ocrSupported", "documentRatio", "", "(Ljava/lang/String;Ljava/lang/String;IIZZJZF)V", "getAllowManualCapture", "()Z", "getBlinkRecognizerId", "()Ljava/lang/String;", "getDocumentConfigKey", "getDocumentRatio", "()F", "getManualScanTimerMs", "()J", "getOcrSupported", "getPageNumber", "()I", "getShouldCaptureDocumentImage", "getWantedNbOfHolograms", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "shouldCaptureHologramsFrame", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final /* data */ class DocumentScanDetailedPageConfig implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final boolean allowManualCapture;
    private final String blinkRecognizerId;
    private final String documentConfigKey;
    private final float documentRatio;
    private final long manualScanTimerMs;
    private final boolean ocrSupported;
    private final int pageNumber;
    private final boolean shouldCaptureDocumentImage;
    private final int wantedNbOfHolograms;

    @Metadata(m5596bv = {1, 0, 3}, m5599k = 3, m5600mv = {1, 1, 15})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel in) {
            Intrinsics.checkParameterIsNotNull(in, "in");
            return new DocumentScanDetailedPageConfig(in.readString(), in.readString(), in.readInt(), in.readInt(), in.readInt() != 0, in.readInt() != 0, in.readLong(), in.readInt() != 0, in.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new DocumentScanDetailedPageConfig[i];
        }
    }

    public DocumentScanDetailedPageConfig(String documentConfigKey, String blinkRecognizerId, int i, int i2, boolean z, boolean z2, long j, boolean z3, float f) {
        Intrinsics.checkParameterIsNotNull(documentConfigKey, "documentConfigKey");
        Intrinsics.checkParameterIsNotNull(blinkRecognizerId, "blinkRecognizerId");
        this.documentConfigKey = documentConfigKey;
        this.blinkRecognizerId = blinkRecognizerId;
        this.pageNumber = i;
        this.wantedNbOfHolograms = i2;
        this.shouldCaptureDocumentImage = z;
        this.allowManualCapture = z2;
        this.manualScanTimerMs = j;
        this.ocrSupported = z3;
        this.documentRatio = f;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDocumentConfigKey() {
        return this.documentConfigKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBlinkRecognizerId() {
        return this.blinkRecognizerId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPageNumber() {
        return this.pageNumber;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getWantedNbOfHolograms() {
        return this.wantedNbOfHolograms;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getShouldCaptureDocumentImage() {
        return this.shouldCaptureDocumentImage;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getAllowManualCapture() {
        return this.allowManualCapture;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getManualScanTimerMs() {
        return this.manualScanTimerMs;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getOcrSupported() {
        return this.ocrSupported;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final float getDocumentRatio() {
        return this.documentRatio;
    }

    public final DocumentScanDetailedPageConfig copy(String documentConfigKey, String blinkRecognizerId, int pageNumber, int wantedNbOfHolograms, boolean shouldCaptureDocumentImage, boolean allowManualCapture, long manualScanTimerMs, boolean ocrSupported, float documentRatio) {
        Intrinsics.checkParameterIsNotNull(documentConfigKey, "documentConfigKey");
        Intrinsics.checkParameterIsNotNull(blinkRecognizerId, "blinkRecognizerId");
        return new DocumentScanDetailedPageConfig(documentConfigKey, blinkRecognizerId, pageNumber, wantedNbOfHolograms, shouldCaptureDocumentImage, allowManualCapture, manualScanTimerMs, ocrSupported, documentRatio);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentScanDetailedPageConfig)) {
            return false;
        }
        DocumentScanDetailedPageConfig documentScanDetailedPageConfig = (DocumentScanDetailedPageConfig) other;
        return Intrinsics.areEqual(this.documentConfigKey, documentScanDetailedPageConfig.documentConfigKey) && Intrinsics.areEqual(this.blinkRecognizerId, documentScanDetailedPageConfig.blinkRecognizerId) && this.pageNumber == documentScanDetailedPageConfig.pageNumber && this.wantedNbOfHolograms == documentScanDetailedPageConfig.wantedNbOfHolograms && this.shouldCaptureDocumentImage == documentScanDetailedPageConfig.shouldCaptureDocumentImage && this.allowManualCapture == documentScanDetailedPageConfig.allowManualCapture && this.manualScanTimerMs == documentScanDetailedPageConfig.manualScanTimerMs && this.ocrSupported == documentScanDetailedPageConfig.ocrSupported && Float.compare(this.documentRatio, documentScanDetailedPageConfig.documentRatio) == 0;
    }

    public final boolean getAllowManualCapture() {
        return this.allowManualCapture;
    }

    public final String getBlinkRecognizerId() {
        return this.blinkRecognizerId;
    }

    public final String getDocumentConfigKey() {
        return this.documentConfigKey;
    }

    public final float getDocumentRatio() {
        return this.documentRatio;
    }

    public final long getManualScanTimerMs() {
        return this.manualScanTimerMs;
    }

    public final boolean getOcrSupported() {
        return this.ocrSupported;
    }

    public final int getPageNumber() {
        return this.pageNumber;
    }

    public final boolean getShouldCaptureDocumentImage() {
        return this.shouldCaptureDocumentImage;
    }

    public final int getWantedNbOfHolograms() {
        return this.wantedNbOfHolograms;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        String str = this.documentConfigKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.blinkRecognizerId;
        int iHashCode2 = (((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Integer.hashCode(this.pageNumber)) * 31) + Integer.hashCode(this.wantedNbOfHolograms)) * 31;
        boolean z = this.shouldCaptureDocumentImage;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z2 = this.allowManualCapture;
        ?? r12 = z2;
        if (z2) {
            r12 = 1;
        }
        int iHashCode3 = (((i + r12) * 31) + Long.hashCode(this.manualScanTimerMs)) * 31;
        boolean z3 = this.ocrSupported;
        return ((iHashCode3 + (z3 ? 1 : z3)) * 31) + Float.hashCode(this.documentRatio);
    }

    public final boolean shouldCaptureHologramsFrame() {
        return this.wantedNbOfHolograms > 0;
    }

    public String toString() {
        return "DocumentScanDetailedPageConfig(documentConfigKey=" + this.documentConfigKey + ", blinkRecognizerId=" + this.blinkRecognizerId + ", pageNumber=" + this.pageNumber + ", wantedNbOfHolograms=" + this.wantedNbOfHolograms + ", shouldCaptureDocumentImage=" + this.shouldCaptureDocumentImage + ", allowManualCapture=" + this.allowManualCapture + ", manualScanTimerMs=" + this.manualScanTimerMs + ", ocrSupported=" + this.ocrSupported + ", documentRatio=" + this.documentRatio + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.documentConfigKey);
        parcel.writeString(this.blinkRecognizerId);
        parcel.writeInt(this.pageNumber);
        parcel.writeInt(this.wantedNbOfHolograms);
        parcel.writeInt(this.shouldCaptureDocumentImage ? 1 : 0);
        parcel.writeInt(this.allowManualCapture ? 1 : 0);
        parcel.writeLong(this.manualScanTimerMs);
        parcel.writeInt(this.ocrSupported ? 1 : 0);
        parcel.writeFloat(this.documentRatio);
    }
}
