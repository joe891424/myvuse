package com.microblink.hardware.camera;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.capture.face.p048ui.models.camera.CameraConfiguration;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public enum VideoResolutionPreset implements Parcelable {
    VIDEO_RESOLUTION_DEFAULT(1080),
    VIDEO_RESOLUTION_480p(480),
    VIDEO_RESOLUTION_720p(CameraConfiguration.TARGET_WIDTH),
    VIDEO_RESOLUTION_1080p(1080),
    VIDEO_RESOLUTION_2160p(2160),
    VIDEO_RESOLUTION_MAX_AVAILABLE(4320);

    public static final Parcelable.Creator<VideoResolutionPreset> CREATOR = new Parcelable.Creator<VideoResolutionPreset>() { // from class: com.microblink.hardware.camera.VideoResolutionPreset.llIIlIlIIl
        @Override // android.os.Parcelable.Creator
        public VideoResolutionPreset createFromParcel(Parcel parcel) {
            return VideoResolutionPreset.values()[parcel.readInt()];
        }

        @Override // android.os.Parcelable.Creator
        public VideoResolutionPreset[] newArray(int i) {
            return new VideoResolutionPreset[i];
        }
    };
    private int llIIlIlIIl;

    VideoResolutionPreset(int i) {
        this.llIIlIlIIl = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getIdealHeight() {
        return this.llIIlIlIIl;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}
