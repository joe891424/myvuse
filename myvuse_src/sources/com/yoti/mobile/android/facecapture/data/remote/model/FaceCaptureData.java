package com.yoti.mobile.android.facecapture.data.remote.model;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/data/remote/model/FaceCaptureData;", "", "resourceId", "", "capture", "Ljava/io/File;", "(Ljava/lang/String;Ljava/io/File;)V", "getCapture", "()Ljava/io/File;", "getResourceId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class FaceCaptureData {
    private final File capture;
    private final String resourceId;

    public FaceCaptureData(String resourceId, File capture) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(capture, "capture");
        this.resourceId = resourceId;
        this.capture = capture;
    }

    public static /* synthetic */ FaceCaptureData copy$default(FaceCaptureData faceCaptureData, String str, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = faceCaptureData.resourceId;
        }
        if ((i & 2) != 0) {
            file = faceCaptureData.capture;
        }
        return faceCaptureData.copy(str, file);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getResourceId() {
        return this.resourceId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final File getCapture() {
        return this.capture;
    }

    public final FaceCaptureData copy(String resourceId, File capture) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(capture, "capture");
        return new FaceCaptureData(resourceId, capture);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaceCaptureData)) {
            return false;
        }
        FaceCaptureData faceCaptureData = (FaceCaptureData) other;
        return Intrinsics.areEqual(this.resourceId, faceCaptureData.resourceId) && Intrinsics.areEqual(this.capture, faceCaptureData.capture);
    }

    public final File getCapture() {
        return this.capture;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public int hashCode() {
        return (this.resourceId.hashCode() * 31) + this.capture.hashCode();
    }

    public String toString() {
        return "FaceCaptureData(resourceId=" + this.resourceId + ", capture=" + this.capture + ')';
    }
}
