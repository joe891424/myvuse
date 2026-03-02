package com.microblink.uisettings.options;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public enum OcrResultDisplayMode implements Parcelable {
    NOTHING,
    ANIMATED_DOTS,
    STATIC_CHARS;

    public static final Parcelable.Creator<OcrResultDisplayMode> CREATOR = new Parcelable.Creator<OcrResultDisplayMode>() { // from class: com.microblink.uisettings.options.OcrResultDisplayMode.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OcrResultDisplayMode createFromParcel(Parcel parcel) {
            return OcrResultDisplayMode.values()[parcel.readInt()];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OcrResultDisplayMode[] newArray(int i) {
            return new OcrResultDisplayMode[i];
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
