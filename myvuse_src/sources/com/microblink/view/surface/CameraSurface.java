package com.microblink.view.surface;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public enum CameraSurface implements Parcelable {
    SURFACE_DEFAULT,
    SURFACE_TEXTURE_VIEW,
    SURFACE_SURFACE_VIEW;

    public static final Parcelable.Creator<CameraSurface> CREATOR = new Parcelable.Creator<CameraSurface>() { // from class: com.microblink.view.surface.CameraSurface.llIIlIlIIl
        @Override // android.os.Parcelable.Creator
        public CameraSurface createFromParcel(Parcel parcel) {
            return CameraSurface.values()[parcel.readInt()];
        }

        @Override // android.os.Parcelable.Creator
        public CameraSurface[] newArray(int i) {
            return new CameraSurface[i];
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
