package com.yoti.mobile.android.liveness.zoom.view.capture.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.liveness.view.capture.model.ILivenessCapture;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\t¨\u0006\""}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/model/LivenessFaceTecCaptureViewData;", "Lcom/yoti/mobile/android/liveness/view/capture/model/ILivenessCapture;", "resourceId", "", "frames", "", "faceMap", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getFaceMap", "()Ljava/lang/String;", "setFaceMap", "(Ljava/lang/String;)V", "getFrames", "()Ljava/util/List;", "setFrames", "(Ljava/util/List;)V", "getResourceId", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class LivenessFaceTecCaptureViewData implements ILivenessCapture {
    public static final Parcelable.Creator<LivenessFaceTecCaptureViewData> CREATOR = new Creator();
    private String faceMap;
    private List<String> frames;
    private final String resourceId;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<LivenessFaceTecCaptureViewData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LivenessFaceTecCaptureViewData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LivenessFaceTecCaptureViewData(parcel.readString(), parcel.createStringArrayList(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LivenessFaceTecCaptureViewData[] newArray(int i) {
            return new LivenessFaceTecCaptureViewData[i];
        }
    }

    public LivenessFaceTecCaptureViewData(String resourceId, List<String> frames, String faceMap) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(frames, "frames");
        Intrinsics.checkNotNullParameter(faceMap, "faceMap");
        this.resourceId = resourceId;
        this.frames = frames;
        this.faceMap = faceMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LivenessFaceTecCaptureViewData copy$default(LivenessFaceTecCaptureViewData livenessFaceTecCaptureViewData, String str, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = livenessFaceTecCaptureViewData.getResourceId();
        }
        if ((i & 2) != 0) {
            list = livenessFaceTecCaptureViewData.frames;
        }
        if ((i & 4) != 0) {
            str2 = livenessFaceTecCaptureViewData.faceMap;
        }
        return livenessFaceTecCaptureViewData.copy(str, list, str2);
    }

    public final String component1() {
        return getResourceId();
    }

    public final List<String> component2() {
        return this.frames;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFaceMap() {
        return this.faceMap;
    }

    public final LivenessFaceTecCaptureViewData copy(String resourceId, List<String> frames, String faceMap) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(frames, "frames");
        Intrinsics.checkNotNullParameter(faceMap, "faceMap");
        return new LivenessFaceTecCaptureViewData(resourceId, frames, faceMap);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LivenessFaceTecCaptureViewData)) {
            return false;
        }
        LivenessFaceTecCaptureViewData livenessFaceTecCaptureViewData = (LivenessFaceTecCaptureViewData) other;
        return Intrinsics.areEqual(getResourceId(), livenessFaceTecCaptureViewData.getResourceId()) && Intrinsics.areEqual(this.frames, livenessFaceTecCaptureViewData.frames) && Intrinsics.areEqual(this.faceMap, livenessFaceTecCaptureViewData.faceMap);
    }

    public final String getFaceMap() {
        return this.faceMap;
    }

    public final List<String> getFrames() {
        return this.frames;
    }

    @Override // com.yoti.mobile.android.liveness.view.capture.model.ILivenessCapture
    public String getResourceId() {
        return this.resourceId;
    }

    public int hashCode() {
        return (((getResourceId().hashCode() * 31) + this.frames.hashCode()) * 31) + this.faceMap.hashCode();
    }

    public final void setFaceMap(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.faceMap = str;
    }

    public final void setFrames(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.frames = list;
    }

    public String toString() {
        return "LivenessFaceTecCaptureViewData(resourceId=" + getResourceId() + ", frames=" + this.frames + ", faceMap=" + this.faceMap + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.resourceId);
        parcel.writeStringList(this.frames);
        parcel.writeString(this.faceMap);
    }
}
