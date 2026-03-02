package com.yoti.mobile.android.facecapture.view.capture.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.liveness.view.capture.model.ILivenessCapture;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/model/CaptureResult;", "Lcom/yoti/mobile/android/liveness/view/capture/model/ILivenessCapture;", "resourceId", "", "capture", "Ljava/io/File;", "(Ljava/lang/String;Ljava/io/File;)V", "getCapture", "()Ljava/io/File;", "getResourceId", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class CaptureResult implements ILivenessCapture {
    public static final Parcelable.Creator<CaptureResult> CREATOR = new Creator();
    private final File capture;
    private final String resourceId;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<CaptureResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CaptureResult createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CaptureResult(parcel.readString(), (File) parcel.readSerializable());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CaptureResult[] newArray(int i) {
            return new CaptureResult[i];
        }
    }

    public CaptureResult(String resourceId, File capture) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(capture, "capture");
        this.resourceId = resourceId;
        this.capture = capture;
    }

    public static /* synthetic */ CaptureResult copy$default(CaptureResult captureResult, String str, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = captureResult.getResourceId();
        }
        if ((i & 2) != 0) {
            file = captureResult.capture;
        }
        return captureResult.copy(str, file);
    }

    public final String component1() {
        return getResourceId();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final File getCapture() {
        return this.capture;
    }

    public final CaptureResult copy(String resourceId, File capture) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(capture, "capture");
        return new CaptureResult(resourceId, capture);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaptureResult)) {
            return false;
        }
        CaptureResult captureResult = (CaptureResult) other;
        return Intrinsics.areEqual(getResourceId(), captureResult.getResourceId()) && Intrinsics.areEqual(this.capture, captureResult.capture);
    }

    public final File getCapture() {
        return this.capture;
    }

    @Override // com.yoti.mobile.android.liveness.view.capture.model.ILivenessCapture
    public String getResourceId() {
        return this.resourceId;
    }

    public int hashCode() {
        return (getResourceId().hashCode() * 31) + this.capture.hashCode();
    }

    public String toString() {
        return "CaptureResult(resourceId=" + getResourceId() + ", capture=" + this.capture + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.resourceId);
        parcel.writeSerializable(this.capture);
    }
}
