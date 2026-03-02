package com.microblink.results.ocr;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.geometry.Rectangle;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class OcrChar implements Parcelable {
    public static final Parcelable.Creator<OcrChar> CREATOR = new Parcelable.Creator<OcrChar>() { // from class: com.microblink.results.ocr.OcrChar.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OcrChar createFromParcel(Parcel parcel) {
            return new OcrChar(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OcrChar[] newArray(int i) {
            return new OcrChar[i];
        }
    };
    private long IIlIIIllIl;
    private Integer IlIllIlIIl;
    private Rectangle IllIIIIllI;
    private Boolean IllIIIllII;
    private OcrFont lIlIIIIlIl;
    private Integer llIIIlllll;
    private Object llIIlIIlll;
    private Character llIIlIlIIl;

    private static native int nativeGetFont(long j);

    private static native int nativeGetHeight(long j);

    private static native int nativeGetQuality(long j);

    private static native void nativeGetRectangle(long j, short[] sArr);

    private static native char nativeGetValue(long j);

    private static native boolean nativeIsUncertain(long j);

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    void dispose() {
        this.llIIlIlIIl = null;
        this.IlIllIlIIl = null;
        this.IllIIIllII = null;
        this.llIIIlllll = null;
        this.IllIIIIllI = null;
        this.lIlIIIIlIl = null;
        this.IIlIIIllIl = 0L;
    }

    public OcrFont getFont() {
        if (this.lIlIIIIlIl == null) {
            long j = this.IIlIIIllIl;
            if (j != 0) {
                int iNativeGetFont = nativeGetFont(j);
                if (iNativeGetFont > 0) {
                    this.lIlIIIIlIl = OcrFont.values()[iNativeGetFont];
                } else {
                    this.lIlIIIIlIl = OcrFont.OCR_FONT_ANY;
                }
            }
        }
        return this.lIlIIIIlIl;
    }

    public int getHeight() {
        if (this.IlIllIlIIl == null) {
            this.IlIllIlIIl = Integer.valueOf(nativeGetHeight(this.IIlIIIllIl));
        }
        return this.IlIllIlIIl.intValue();
    }

    public Rectangle getPosition() {
        if (this.IllIIIIllI == null) {
            long j = this.IIlIIIllIl;
            if (j != 0) {
                nativeGetRectangle(j, new short[4]);
                this.IllIIIIllI = new Rectangle(r2[0], r2[1], r2[2], r2[3]);
            }
        }
        return this.IllIIIIllI;
    }

    public int getQuality() {
        if (this.llIIIlllll == null) {
            this.llIIIlllll = Integer.valueOf(nativeGetQuality(this.IIlIIIllIl));
        }
        return this.llIIIlllll.intValue();
    }

    public char getValue() {
        if (this.llIIlIlIIl == null) {
            this.llIIlIlIIl = Character.valueOf(nativeGetValue(this.IIlIIIllIl));
        }
        return this.llIIlIlIIl.charValue();
    }

    public boolean isUncertain() {
        if (this.IllIIIllII == null) {
            this.IllIIIllII = Boolean.valueOf(nativeIsUncertain(this.IIlIIIllIl));
        }
        return this.IllIIIllII.booleanValue();
    }

    public String toString() {
        return String.valueOf(getValue());
    }

    public OcrChar(long j, Object obj) {
        this.llIIlIlIIl = null;
        this.IlIllIlIIl = null;
        this.IllIIIllII = null;
        this.llIIIlllll = null;
        this.IllIIIIllI = null;
        this.lIlIIIIlIl = null;
        this.IIlIIIllIl = j;
        this.llIIlIIlll = obj;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeCharArray(new char[]{getValue()});
        parcel.writeInt(getHeight());
        parcel.writeInt(getQuality());
        parcel.writeParcelable(getPosition(), i);
        parcel.writeByte(isUncertain() ? (byte) 1 : (byte) 0);
        OcrFont font = getFont();
        parcel.writeInt(font == null ? -1 : font.ordinal());
    }

    private OcrChar(Parcel parcel) {
        this.llIIlIlIIl = null;
        this.IlIllIlIIl = null;
        this.IllIIIllII = null;
        this.llIIIlllll = null;
        this.IllIIIIllI = null;
        this.lIlIIIIlIl = null;
        this.IIlIIIllIl = 0L;
        char[] cArr = new char[1];
        parcel.readCharArray(cArr);
        this.llIIlIlIIl = Character.valueOf(cArr[0]);
        this.IlIllIlIIl = Integer.valueOf(parcel.readInt());
        this.llIIIlllll = Integer.valueOf(parcel.readInt());
        this.IllIIIIllI = (Rectangle) parcel.readParcelable(Rectangle.class.getClassLoader());
        this.IllIIIllII = Boolean.valueOf(parcel.readByte() == 1);
        int i = parcel.readInt();
        if (i == -1) {
            this.lIlIIIIlIl = null;
        } else {
            this.lIlIIIIlIl = OcrFont.values()[i];
        }
    }
}
