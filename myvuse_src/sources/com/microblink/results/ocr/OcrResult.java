package com.microblink.results.ocr;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class OcrResult implements Parcelable {
    public static final Parcelable.Creator<OcrResult> CREATOR = new Parcelable.Creator<OcrResult>() { // from class: com.microblink.results.ocr.OcrResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OcrResult createFromParcel(Parcel parcel) {
            return new OcrResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OcrResult[] newArray(int i) {
            return new OcrResult[i];
        }
    };
    private long IlIllIlIIl;
    private Object IllIIIllII;
    private boolean llIIIlllll;
    private OcrBlock[] llIIlIlIIl;

    private static native long nativeClone(long j);

    private static native void nativeDestruct(long j);

    private static native int nativeGetBlockCount(long j);

    private static native void nativeGetBlocks(long j, long[] jArr);

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void dispose() {
        long j = this.IlIllIlIIl;
        if (j != 0 && this.IllIIIllII == null) {
            nativeDestruct(j);
            OcrBlock[] ocrBlockArr = this.llIIlIlIIl;
            if (ocrBlockArr != null) {
                for (OcrBlock ocrBlock : ocrBlockArr) {
                    ocrBlock.dispose();
                }
            }
        }
        this.llIIlIlIIl = null;
        this.llIIIlllll = true;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        dispose();
    }

    public OcrBlock[] getBlocks() {
        if (this.llIIIlllll) {
            throw new IllegalStateException("Cannot use OcrResult that has been disposed!");
        }
        if (this.llIIlIlIIl == null) {
            long j = this.IlIllIlIIl;
            if (j != 0) {
                int iNativeGetBlockCount = nativeGetBlockCount(j);
                this.llIIlIlIIl = new OcrBlock[iNativeGetBlockCount];
                long[] jArr = new long[iNativeGetBlockCount];
                nativeGetBlocks(this.IlIllIlIIl, jArr);
                for (int i = 0; i < iNativeGetBlockCount; i++) {
                    this.llIIlIlIIl[i] = new OcrBlock(jArr[i], this);
                }
            }
        }
        return this.llIIlIlIIl;
    }

    public String toString() {
        OcrBlock[] blocks = getBlocks();
        if (blocks == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (OcrBlock ocrBlock : blocks) {
            sb.append(ocrBlock.toString());
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        OcrBlock[] blocks = getBlocks();
        if (blocks == null || blocks.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(blocks.length);
            parcel.writeTypedArray(blocks, i);
        }
    }

    public OcrResult(long j, Object obj) {
        this.llIIlIlIIl = null;
        this.llIIIlllll = false;
        this.IlIllIlIIl = j;
        this.IllIIIllII = obj;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public OcrResult m6357clone() {
        if (this.llIIIlllll) {
            throw new IllegalStateException("Cannot clone OcrResult that has been disposed!");
        }
        return new OcrResult(nativeClone(this.IlIllIlIIl), (Object) null);
    }

    private OcrResult(Parcel parcel) {
        this.llIIlIlIIl = null;
        this.IllIIIllII = null;
        this.llIIIlllll = false;
        this.IlIllIlIIl = 0L;
        int i = parcel.readInt();
        if (i > 0) {
            OcrBlock[] ocrBlockArr = new OcrBlock[i];
            this.llIIlIlIIl = ocrBlockArr;
            parcel.readTypedArray(ocrBlockArr, OcrBlock.CREATOR);
        }
    }
}
