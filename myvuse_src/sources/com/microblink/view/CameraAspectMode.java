package com.microblink.view;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public enum CameraAspectMode implements Parcelable {
    ASPECT_FIT,
    ASPECT_FILL;

    public static final Parcelable.Creator<CameraAspectMode> CREATOR = new Parcelable.Creator<CameraAspectMode>() { // from class: com.microblink.view.CameraAspectMode.llIIlIlIIl
        @Override // android.os.Parcelable.Creator
        public CameraAspectMode createFromParcel(Parcel parcel) {
            return CameraAspectMode.values()[parcel.readInt()];
        }

        @Override // android.os.Parcelable.Creator
        public CameraAspectMode[] newArray(int i) {
            return new CameraAspectMode[i];
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
