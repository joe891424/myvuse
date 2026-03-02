package com.microblink.results.ocr;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.geometry.Rectangle;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class OcrBlock implements Parcelable {
    public static final Parcelable.Creator<OcrBlock> CREATOR = new Parcelable.Creator<OcrBlock>() { // from class: com.microblink.results.ocr.OcrBlock.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OcrBlock createFromParcel(Parcel parcel) {
            return new OcrBlock(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OcrBlock[] newArray(int i) {
            return new OcrBlock[i];
        }
    };
    private OcrLine[] IlIllIlIIl;
    private OcrResult IllIIIllII;
    private long llIIIlllll;
    private Rectangle llIIlIlIIl;

    private static native int nativeGetLineCount(long j);

    private static native void nativeGetLines(long j, long[] jArr);

    private static native void nativeGetRectangle(long j, short[] sArr);

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    void dispose() {
        this.llIIIlllll = 0L;
        OcrLine[] ocrLineArr = this.IlIllIlIIl;
        if (ocrLineArr != null) {
            for (OcrLine ocrLine : ocrLineArr) {
                ocrLine.dispose();
            }
        }
        this.IlIllIlIIl = null;
    }

    public OcrLine[] getLines() {
        if (this.IlIllIlIIl == null) {
            long j = this.llIIIlllll;
            if (j != 0) {
                int iNativeGetLineCount = nativeGetLineCount(j);
                this.IlIllIlIIl = new OcrLine[iNativeGetLineCount];
                long[] jArr = new long[iNativeGetLineCount];
                nativeGetLines(this.llIIIlllll, jArr);
                for (int i = 0; i < iNativeGetLineCount; i++) {
                    this.IlIllIlIIl[i] = new OcrLine(jArr[i], this);
                }
            }
        }
        return this.IlIllIlIIl;
    }

    public Rectangle getPosition() {
        if (this.llIIlIlIIl == null) {
            long j = this.llIIIlllll;
            if (j != 0) {
                nativeGetRectangle(j, new short[4]);
                this.llIIlIlIIl = new Rectangle(r2[0], r2[1], r2[2], r2[3]);
            }
        }
        return this.llIIlIlIIl;
    }

    public String toString() {
        OcrLine[] lines = getLines();
        if (lines == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (OcrLine ocrLine : lines) {
            sb.append(ocrLine.toString());
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(getPosition(), i);
        OcrLine[] lines = getLines();
        if (lines == null || lines.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(lines.length);
            parcel.writeTypedArray(lines, i);
        }
    }

    public OcrBlock(long j, OcrResult ocrResult) {
        this.llIIlIlIIl = null;
        this.IlIllIlIIl = null;
        this.llIIIlllll = j;
        this.IllIIIllII = ocrResult;
    }

    private OcrBlock(Parcel parcel) {
        this.llIIlIlIIl = null;
        this.IlIllIlIIl = null;
        this.llIIIlllll = 0L;
        this.llIIlIlIIl = (Rectangle) parcel.readParcelable(Rectangle.class.getClassLoader());
        int i = parcel.readInt();
        if (i > 0) {
            OcrLine[] ocrLineArr = new OcrLine[i];
            this.IlIllIlIIl = ocrLineArr;
            parcel.readTypedArray(ocrLineArr, OcrLine.CREATOR);
        }
    }
}
