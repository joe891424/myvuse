package com.microblink.entities.recognizers.blinkid.generic.imageanalysis;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class ImageAnalysisResult implements Parcelable {
    public static final Parcelable.Creator<ImageAnalysisResult> CREATOR = new Parcelable.Creator<ImageAnalysisResult>() { // from class: com.microblink.entities.recognizers.blinkid.generic.imageanalysis.ImageAnalysisResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageAnalysisResult createFromParcel(Parcel parcel) {
            return new ImageAnalysisResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageAnalysisResult[] newArray(int i) {
            return new ImageAnalysisResult[i];
        }
    };
    private DocumentImageColorStatus IlIllIlIIl;
    private ImageAnalysisDetectionStatus IllIIIIllI;
    private ImageAnalysisDetectionStatus IllIIIllII;
    private ImageAnalysisDetectionStatus lIlIIIIlIl;
    private ImageAnalysisDetectionStatus llIIIlllll;
    private boolean llIIlIlIIl;

    private ImageAnalysisResult(boolean z, DocumentImageColorStatus documentImageColorStatus, ImageAnalysisDetectionStatus imageAnalysisDetectionStatus, ImageAnalysisDetectionStatus imageAnalysisDetectionStatus2, ImageAnalysisDetectionStatus imageAnalysisDetectionStatus3, ImageAnalysisDetectionStatus imageAnalysisDetectionStatus4) {
        this.llIIlIlIIl = z;
        this.IlIllIlIIl = documentImageColorStatus;
        this.IllIIIllII = imageAnalysisDetectionStatus;
        this.llIIIlllll = imageAnalysisDetectionStatus2;
        this.IllIIIIllI = imageAnalysisDetectionStatus3;
        this.lIlIIIIlIl = imageAnalysisDetectionStatus4;
    }

    public static ImageAnalysisResult createFromNative(boolean z, int i, int i2, int i3, int i4, int i5) {
        return new ImageAnalysisResult(z, DocumentImageColorStatus.values()[i], ImageAnalysisDetectionStatus.values()[i2], ImageAnalysisDetectionStatus.values()[i3], ImageAnalysisDetectionStatus.values()[i4], ImageAnalysisDetectionStatus.values()[i5]);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ImageAnalysisDetectionStatus getBarcodeDetectionStatus() {
        return this.lIlIIIIlIl;
    }

    public DocumentImageColorStatus getDocumentImageColorStatus() {
        return this.IlIllIlIIl;
    }

    public ImageAnalysisDetectionStatus getDocumentImageMoireStatus() {
        return this.IllIIIllII;
    }

    public ImageAnalysisDetectionStatus getFaceDetectionStatus() {
        return this.llIIIlllll;
    }

    public ImageAnalysisDetectionStatus getMrzDetectionStatus() {
        return this.IllIIIIllI;
    }

    public boolean isBlurred() {
        return this.llIIlIlIIl;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.llIIlIlIIl ? (byte) 1 : (byte) 0);
        parcel.writeSerializable(this.IlIllIlIIl);
        parcel.writeSerializable(this.IllIIIllII);
        parcel.writeSerializable(this.llIIIlllll);
        parcel.writeSerializable(this.IllIIIIllI);
        parcel.writeSerializable(this.lIlIIIIlIl);
    }

    protected ImageAnalysisResult(Parcel parcel) {
        this.llIIlIlIIl = parcel.readByte() == 1;
        this.IlIllIlIIl = (DocumentImageColorStatus) parcel.readSerializable();
        this.IllIIIllII = (ImageAnalysisDetectionStatus) parcel.readSerializable();
        this.llIIIlllll = (ImageAnalysisDetectionStatus) parcel.readSerializable();
        this.IllIIIIllI = (ImageAnalysisDetectionStatus) parcel.readSerializable();
        this.lIlIIIIlIl = (ImageAnalysisDetectionStatus) parcel.readSerializable();
    }
}
