package com.yoti.mobile.android.facecapture.data.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/data/remote/model/FaceCaptureResourceResponse;", "", "resourceId", "", "frames", "", "(Ljava/lang/String;I)V", "getFrames", "()I", "getResourceId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class FaceCaptureResourceResponse {

    @SerializedName("frames")
    private final int frames;

    @SerializedName("id")
    private final String resourceId;

    public FaceCaptureResourceResponse(String resourceId, int i) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        this.resourceId = resourceId;
        this.frames = i;
    }

    public static /* synthetic */ FaceCaptureResourceResponse copy$default(FaceCaptureResourceResponse faceCaptureResourceResponse, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = faceCaptureResourceResponse.resourceId;
        }
        if ((i2 & 2) != 0) {
            i = faceCaptureResourceResponse.frames;
        }
        return faceCaptureResourceResponse.copy(str, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getResourceId() {
        return this.resourceId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getFrames() {
        return this.frames;
    }

    public final FaceCaptureResourceResponse copy(String resourceId, int frames) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        return new FaceCaptureResourceResponse(resourceId, frames);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaceCaptureResourceResponse)) {
            return false;
        }
        FaceCaptureResourceResponse faceCaptureResourceResponse = (FaceCaptureResourceResponse) other;
        return Intrinsics.areEqual(this.resourceId, faceCaptureResourceResponse.resourceId) && this.frames == faceCaptureResourceResponse.frames;
    }

    public final int getFrames() {
        return this.frames;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public int hashCode() {
        return (this.resourceId.hashCode() * 31) + Integer.hashCode(this.frames);
    }

    public String toString() {
        return "FaceCaptureResourceResponse(resourceId=" + this.resourceId + ", frames=" + this.frames + ')';
    }
}
