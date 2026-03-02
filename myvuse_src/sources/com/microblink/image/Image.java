package com.microblink.image;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.hardware.orientation.Orientation;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class Image implements Parcelable {
    public static final Parcelable.Creator<Image> CREATOR = new llIIlIlIIl();
    private ByteBuffer IIlIIIllIl;
    private Integer IlIllIlIIl;
    private boolean IlIllIlllI;
    private String IllIIIIllI;
    private ImageType IllIIIllII;
    private Integer lIIIIIllll;
    private Rect lIlIIIIlIl;
    private ImageFormat llIIIlllll;
    private Orientation llIIlIIlll;
    private Integer llIIlIlIIl;
    long lllIIIlIlI;
    Object lllIlIlIIl;

    /* JADX INFO: compiled from: line */
    static /* synthetic */ class IlIllIlIIl {
        static final /* synthetic */ int[] llIIlIlIIl;

        static {
            int[] iArr = new int[Orientation.values().length];
            llIIlIlIIl = iArr;
            try {
                iArr[Orientation.ORIENTATION_LANDSCAPE_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                llIIlIlIIl[Orientation.ORIENTATION_PORTRAIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                llIIlIlIIl[Orientation.ORIENTATION_PORTRAIT_UPSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                llIIlIlIIl[Orientation.ORIENTATION_LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements Parcelable.Creator<Image> {
        llIIlIlIIl() {
        }

        @Override // android.os.Parcelable.Creator
        public Image createFromParcel(Parcel parcel) {
            return new Image(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Image[] newArray(int i) {
            return new Image[i];
        }
    }

    Image(long j, boolean z) {
        this.lllIIIlIlI = j;
        this.IlIllIlllI = z;
    }

    private static native long deserialize(byte[] bArr);

    private static native long nativeClone(long j);

    private static native boolean nativeCopyPixelsToBitmap(long j, Bitmap bitmap);

    private static native void nativeDestruct(long j);

    private static native int nativeGetHeight(long j);

    private static native int nativeGetImageFormat(long j);

    private static native String nativeGetImageName(long j);

    private static native int nativeGetImageOrientation(long j);

    private static native int nativeGetImageType(long j);

    private static native ByteBuffer nativeGetPixelBuffer(long j);

    private static native void nativeGetRoi(long j, int[] iArr);

    private static native int nativeGetRowStride(long j);

    private static native int nativeGetWidth(long j);

    private static native void nativeSetImageOrientation(long j, int i);

    private static native void nativeSetRoi(long j, int i, int i2, int i3, int i4);

    private static native byte[] serialize(long j);

    public Bitmap convertToBitmap() {
        if (this.lllIIIlIlI == 0) {
            throw new IllegalStateException("Cannot use disposed image!");
        }
        Rect rawROI = getRawROI();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(rawROI.width(), rawROI.height(), Bitmap.Config.ARGB_8888);
        if (nativeCopyPixelsToBitmap(this.lllIIIlIlI, bitmapCreateBitmap)) {
            return bitmapCreateBitmap;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void dispose() {
        long j = this.lllIIIlIlI;
        if (j != 0 && this.IlIllIlllI) {
            nativeDestruct(j);
        }
        this.lllIIIlIlI = 0L;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        dispose();
    }

    public ByteBuffer getBuffer() {
        long j = this.lllIIIlIlI;
        if (j == 0) {
            throw new IllegalStateException("Cannot use disposed image!");
        }
        if (this.IIlIIIllIl == null) {
            this.IIlIIIllIl = nativeGetPixelBuffer(j);
        }
        return this.IIlIIIllIl;
    }

    public int getHeight() {
        return getImageOrientation().isHorizontal() ? getRawHeight() : getRawWidth();
    }

    public ImageFormat getImageFormat() {
        if (this.lllIIIlIlI == 0) {
            throw new IllegalStateException("Cannot use disposed image!");
        }
        if (this.llIIIlllll == null) {
            this.llIIIlllll = ImageFormat.values()[nativeGetImageFormat(this.lllIIIlIlI)];
        }
        return this.llIIIlllll;
    }

    @Deprecated
    public String getImageName() {
        long j = this.lllIIIlIlI;
        if (j == 0) {
            throw new IllegalStateException("Cannot use disposed image!");
        }
        if (this.IllIIIIllI == null) {
            this.IllIIIIllI = nativeGetImageName(j);
        }
        return this.IllIIIIllI;
    }

    public Orientation getImageOrientation() {
        long j = this.lllIIIlIlI;
        if (j == 0) {
            throw new IllegalStateException("Cannot use disposed image!");
        }
        if (this.llIIlIIlll == null) {
            this.llIIlIIlll = Orientation.fromInt(nativeGetImageOrientation(j));
        }
        return this.llIIlIIlll;
    }

    public ImageType getImageType() {
        if (this.lllIIIlIlI == 0) {
            throw new IllegalStateException("Cannot use disposed image!");
        }
        if (this.IllIIIllII == null) {
            this.IllIIIllII = ImageType.values()[nativeGetImageType(this.lllIIIlIlI)];
        }
        return this.IllIIIllII;
    }

    public int getPixelStride() {
        if (this.lllIIIlIlI != 0) {
            return 1;
        }
        throw new IllegalStateException("Cannot use disposed image!");
    }

    public Rect getROI() {
        Rect rawROI = getRawROI();
        int i = IlIllIlIIl.llIIlIlIIl[getImageOrientation().ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? rawROI : new Rect(rawROI.top, getRawWidth() - rawROI.right, rawROI.bottom, getRawWidth() - rawROI.left) : new Rect(getRawHeight() - rawROI.bottom, rawROI.left, getRawHeight() - rawROI.top, rawROI.right) : new Rect(getRawWidth() - rawROI.right, getRawHeight() - rawROI.bottom, getRawWidth() - rawROI.left, getRawHeight() - rawROI.top);
    }

    public int getRawHeight() {
        long j = this.lllIIIlIlI;
        if (j == 0) {
            throw new IllegalStateException("Cannot use disposed image!");
        }
        if (this.IlIllIlIIl == null) {
            this.IlIllIlIIl = Integer.valueOf(nativeGetHeight(j));
        }
        return this.IlIllIlIIl.intValue();
    }

    public Rect getRawROI() {
        long j = this.lllIIIlIlI;
        if (j == 0) {
            throw new IllegalStateException("Cannot use disposed image!");
        }
        if (this.lIlIIIIlIl == null) {
            int[] iArr = new int[4];
            nativeGetRoi(j, iArr);
            this.lIlIIIIlIl = new Rect(iArr[0], iArr[1], iArr[2], iArr[3]);
        }
        return this.lIlIIIIlIl;
    }

    public int getRawWidth() {
        long j = this.lllIIIlIlI;
        if (j == 0) {
            throw new IllegalStateException("Cannot use disposed image!");
        }
        if (this.llIIlIlIIl == null) {
            this.llIIlIlIIl = Integer.valueOf(nativeGetWidth(j));
        }
        return this.llIIlIlIIl.intValue();
    }

    public int getRowStride() {
        long j = this.lllIIIlIlI;
        if (j == 0) {
            throw new IllegalStateException("Cannot use disposed image!");
        }
        if (this.lIIIIIllll == null) {
            this.lIIIIIllll = Integer.valueOf(nativeGetRowStride(j));
        }
        return this.lIIIIIllll.intValue();
    }

    public int getWidth() {
        return getImageOrientation().isHorizontal() ? getRawWidth() : getRawHeight();
    }

    public boolean isDisposed() {
        return this.lllIIIlIlI == 0;
    }

    public void setImageOrientation(Orientation orientation) {
        long j = this.lllIIIlIlI;
        if (j == 0) {
            throw new IllegalStateException("Cannot use disposed image!");
        }
        this.llIIlIIlll = orientation;
        nativeSetImageOrientation(j, orientation.intValue());
    }

    public void setROI(Rect rect) {
        Rect rect2;
        if (this.lllIIIlIlI == 0) {
            throw new IllegalStateException("Cannot use disposed image!");
        }
        if (rect.left < 0 || rect.right > getWidth() || rect.top < 0 || rect.bottom > getHeight()) {
            throw new IllegalArgumentException("Given ROI is not inside image!");
        }
        int i = IlIllIlIIl.llIIlIlIIl[getImageOrientation().ordinal()];
        if (i == 1) {
            rect2 = new Rect(getRawWidth() - rect.right, getRawHeight() - rect.bottom, getRawWidth() - rect.left, getRawHeight() - rect.top);
        } else {
            if (i != 2) {
                if (i == 3) {
                    rect2 = new Rect(getRawWidth() - rect.bottom, rect.left, getRawWidth() - rect.top, rect.right);
                }
                this.lIlIIIIlIl = rect;
                nativeSetRoi(this.lllIIIlIlI, rect.left, rect.top, rect.right, rect.bottom);
            }
            rect2 = new Rect(rect.top, getRawHeight() - rect.right, rect.bottom, getRawHeight() - rect.left);
        }
        rect = rect2;
        this.lIlIIIIlIl = rect;
        nativeSetRoi(this.lllIIIlIlI, rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        long j = this.lllIIIlIlI;
        if (j == 0) {
            throw new IllegalStateException("Cannot use disposed image!");
        }
        byte[] bArrSerialize = serialize(j);
        parcel.writeInt(bArrSerialize.length);
        parcel.writeByteArray(bArrSerialize);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Image m6356clone() {
        long j = this.lllIIIlIlI;
        if (j != 0) {
            return new Image(nativeClone(j), true);
        }
        throw new IllegalStateException("Cannot clone disposed image!");
    }

    protected Image(Parcel parcel) {
        this.lllIIIlIlI = 0L;
        this.IlIllIlllI = false;
        byte[] bArr = new byte[parcel.readInt()];
        parcel.readByteArray(bArr);
        this.lllIIIlIlI = deserialize(bArr);
        this.IlIllIlllI = true;
    }
}
