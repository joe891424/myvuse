package com.yoti.mobile.android.facecapture.view.capture.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/CaptureConfig;", "Landroid/os/Parcelable;", "resourceId", "", "frames", "", "(Ljava/lang/String;I)V", "getFrames", "()I", "getResourceId", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class CaptureConfig implements Parcelable {
    public static final Parcelable.Creator<CaptureConfig> CREATOR = new Creator();
    private final int frames;
    private final String resourceId;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<CaptureConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CaptureConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CaptureConfig(parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CaptureConfig[] newArray(int i) {
            return new CaptureConfig[i];
        }
    }

    public CaptureConfig(String resourceId, int i) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        this.resourceId = resourceId;
        this.frames = i;
    }

    public static /* synthetic */ CaptureConfig copy$default(CaptureConfig captureConfig, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = captureConfig.resourceId;
        }
        if ((i2 & 2) != 0) {
            i = captureConfig.frames;
        }
        return captureConfig.copy(str, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getResourceId() {
        return this.resourceId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getFrames() {
        return this.frames;
    }

    public final CaptureConfig copy(String resourceId, int frames) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        return new CaptureConfig(resourceId, frames);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaptureConfig)) {
            return false;
        }
        CaptureConfig captureConfig = (CaptureConfig) other;
        return Intrinsics.areEqual(this.resourceId, captureConfig.resourceId) && this.frames == captureConfig.frames;
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
        return "CaptureConfig(resourceId=" + this.resourceId + ", frames=" + this.frames + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.resourceId);
        parcel.writeInt(this.frames);
    }
}
