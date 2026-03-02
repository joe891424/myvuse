package com.microblink.hardware.camera;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public enum CameraType implements Parcelable {
    CAMERA_DEFAULT,
    CAMERA_BACKFACE,
    CAMERA_FRONTFACE;

    public static final Parcelable.Creator<CameraType> CREATOR = new Parcelable.Creator<CameraType>() { // from class: com.microblink.hardware.camera.CameraType.llIIlIlIIl
        @Override // android.os.Parcelable.Creator
        public CameraType createFromParcel(Parcel parcel) {
            return CameraType.values()[parcel.readInt()];
        }

        @Override // android.os.Parcelable.Creator
        public CameraType[] newArray(int i) {
            return new CameraType[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}
