package com.microblink.results.ocr;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.geometry.Rectangle;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class OcrLine implements Parcelable {
    public static final Parcelable.Creator<OcrLine> CREATOR = new Parcelable.Creator<OcrLine>() { // from class: com.microblink.results.ocr.OcrLine.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OcrLine createFromParcel(Parcel parcel) {
            return new OcrLine(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OcrLine[] newArray(int i) {
            return new OcrLine[i];
        }
    };
    private CharWithVariants[] IlIllIlIIl;
    private long IllIIIllII;
    private Rectangle llIIlIlIIl;

    private static native int nativeGetCharCount(long j);

    private static native void nativeGetChars(long j, long[] jArr);

    private static native void nativeGetRectangle(long j, short[] sArr);

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    void dispose() {
        this.IllIIIllII = 0L;
        CharWithVariants[] charWithVariantsArr = this.IlIllIlIIl;
        if (charWithVariantsArr != null) {
            for (CharWithVariants charWithVariants : charWithVariantsArr) {
                charWithVariants.dispose();
            }
        }
        this.IlIllIlIIl = null;
    }

    public CharWithVariants[] getChars() {
        if (this.IlIllIlIIl == null) {
            long j = this.IllIIIllII;
            if (j != 0) {
                int iNativeGetCharCount = nativeGetCharCount(j);
                this.IlIllIlIIl = new CharWithVariants[iNativeGetCharCount];
                long[] jArr = new long[iNativeGetCharCount];
                nativeGetChars(this.IllIIIllII, jArr);
                for (int i = 0; i < iNativeGetCharCount; i++) {
                    this.IlIllIlIIl[i] = new CharWithVariants(jArr[i], this);
                }
            }
        }
        return this.IlIllIlIIl;
    }

    public Rectangle getPosition() {
        if (this.llIIlIlIIl == null) {
            long j = this.IllIIIllII;
            if (j != 0) {
                nativeGetRectangle(j, new short[4]);
                this.llIIlIlIIl = new Rectangle(r2[0], r2[1], r2[2], r2[3]);
            }
        }
        return this.llIIlIlIIl;
    }

    public String toString() {
        CharWithVariants[] chars = getChars();
        if (chars == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(chars.length);
        for (CharWithVariants charWithVariants : chars) {
            sb.append(charWithVariants.getChar().getValue());
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(getPosition(), i);
        CharWithVariants[] chars = getChars();
        if (chars == null || chars.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(chars.length);
            parcel.writeTypedArray(chars, i);
        }
    }

    public OcrLine(long j, OcrBlock ocrBlock) {
        this.llIIlIlIIl = null;
        this.IlIllIlIIl = null;
        this.IllIIIllII = j;
    }

    private OcrLine(Parcel parcel) {
        this.llIIlIlIIl = null;
        this.IlIllIlIIl = null;
        this.IllIIIllII = 0L;
        this.llIIlIlIIl = (Rectangle) parcel.readParcelable(Rectangle.class.getClassLoader());
        int i = parcel.readInt();
        if (i > 0) {
            CharWithVariants[] charWithVariantsArr = new CharWithVariants[i];
            this.IlIllIlIIl = charWithVariantsArr;
            parcel.readTypedArray(charWithVariantsArr, CharWithVariants.CREATOR);
        }
    }
}
