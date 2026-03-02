package com.microblink.results.ocr;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class CharWithVariants implements Parcelable {
    public static final Parcelable.Creator<CharWithVariants> CREATOR = new Parcelable.Creator<CharWithVariants>() { // from class: com.microblink.results.ocr.CharWithVariants.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CharWithVariants createFromParcel(Parcel parcel) {
            return new CharWithVariants(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CharWithVariants[] newArray(int i) {
            return new CharWithVariants[i];
        }
    };
    private OcrChar[] IlIllIlIIl;
    private long IllIIIllII;
    private OcrChar llIIlIlIIl;

    private static native long nativeGetChar(long j);

    private static native void nativeGetRecognitionVariants(long j, long[] jArr);

    private static native int nativeGetRecognitionVariantsCount(long j);

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void dispose() {
        this.IllIIIllII = 0L;
        OcrChar ocrChar = this.llIIlIlIIl;
        if (ocrChar != null) {
            ocrChar.dispose();
        }
        OcrChar[] ocrCharArr = this.IlIllIlIIl;
        if (ocrCharArr != null) {
            for (OcrChar ocrChar2 : ocrCharArr) {
                ocrChar2.dispose();
            }
        }
    }

    public OcrChar getChar() {
        if (this.llIIlIlIIl == null) {
            this.llIIlIlIIl = new OcrChar(nativeGetChar(this.IllIIIllII), this);
        }
        return this.llIIlIlIIl;
    }

    public OcrChar[] getRecognitionVariants() {
        int iNativeGetRecognitionVariantsCount;
        if (this.IlIllIlIIl == null) {
            long j = this.IllIIIllII;
            if (j != 0 && (iNativeGetRecognitionVariantsCount = nativeGetRecognitionVariantsCount(j)) > 0) {
                long[] jArr = new long[iNativeGetRecognitionVariantsCount];
                this.IlIllIlIIl = new OcrChar[iNativeGetRecognitionVariantsCount];
                nativeGetRecognitionVariants(this.IllIIIllII, jArr);
                for (int i = 0; i < iNativeGetRecognitionVariantsCount; i++) {
                    this.IlIllIlIIl[i] = new OcrChar(jArr[i], this);
                }
            }
        }
        return this.IlIllIlIIl;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(getChar(), i);
        OcrChar[] recognitionVariants = getRecognitionVariants();
        if (recognitionVariants == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(recognitionVariants.length);
            parcel.writeTypedArray(recognitionVariants, 0);
        }
    }

    public CharWithVariants(long j, OcrLine ocrLine) {
        this.llIIlIlIIl = null;
        this.IlIllIlIIl = null;
        this.IllIIIllII = j;
    }

    private CharWithVariants(Parcel parcel) {
        this.llIIlIlIIl = null;
        this.IlIllIlIIl = null;
        this.IllIIIllII = 0L;
        this.llIIlIlIIl = (OcrChar) parcel.readParcelable(OcrChar.class.getClassLoader());
        int i = parcel.readInt();
        if (i > 0) {
            OcrChar[] ocrCharArr = new OcrChar[i];
            this.IlIllIlIIl = ocrCharArr;
            parcel.readTypedArray(ocrCharArr, OcrChar.CREATOR);
        }
    }
}
