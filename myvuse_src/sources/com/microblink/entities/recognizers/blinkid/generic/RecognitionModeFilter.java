package com.microblink.entities.recognizers.blinkid.generic;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class RecognitionModeFilter implements Parcelable {
    public static final Parcelable.Creator<RecognitionModeFilter> CREATOR = new Parcelable.Creator<RecognitionModeFilter>() { // from class: com.microblink.entities.recognizers.blinkid.generic.RecognitionModeFilter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecognitionModeFilter createFromParcel(Parcel parcel) {
            return new RecognitionModeFilter(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecognitionModeFilter[] newArray(int i) {
            return new RecognitionModeFilter[i];
        }
    };
    public final boolean enableBarcodeId;
    public final boolean enableFullDocumentRecognition;
    public final boolean enableMrzId;
    public final boolean enableMrzPassport;
    public final boolean enableMrzVisa;
    public final boolean enablePhotoId;

    public RecognitionModeFilter() {
        this(true, true, true, true, true, true);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.enableMrzId ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.enableMrzVisa ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.enableMrzPassport ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.enablePhotoId ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.enableBarcodeId ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.enableFullDocumentRecognition ? (byte) 1 : (byte) 0);
    }

    public RecognitionModeFilter(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.enableMrzId = z;
        this.enableMrzPassport = z3;
        this.enableMrzVisa = z2;
        this.enablePhotoId = z4;
        this.enableBarcodeId = z5;
        this.enableFullDocumentRecognition = z6;
    }

    protected RecognitionModeFilter(Parcel parcel) {
        this.enableMrzId = parcel.readByte() != 0;
        this.enableMrzVisa = parcel.readByte() != 0;
        this.enableMrzPassport = parcel.readByte() != 0;
        this.enablePhotoId = parcel.readByte() != 0;
        this.enableBarcodeId = parcel.readByte() != 0;
        this.enableFullDocumentRecognition = parcel.readByte() != 0;
    }
}
