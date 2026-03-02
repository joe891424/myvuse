package com.microblink.geometry;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkid.secured.IIllIllIIl;
import com.microblink.util.Log;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class Quadrilateral implements Parcelable {
    public static final Parcelable.Creator<Quadrilateral> CREATOR = new llIIlIlIIl();
    private Point IlIllIlIIl;
    private int IllIIIIllI;
    private Point IllIIIllII;
    private boolean lIlIIIIlIl;
    private Point llIIIlllll;
    private Point llIIlIlIIl;

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements Parcelable.Creator<Quadrilateral> {
        llIIlIlIIl() {
        }

        @Override // android.os.Parcelable.Creator
        public Quadrilateral createFromParcel(Parcel parcel) {
            return new Quadrilateral(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Quadrilateral[] newArray(int i) {
            return new Quadrilateral[i];
        }
    }

    public Quadrilateral(int i, int i2, int i3, int i4, int i5) {
        this.IllIIIIllI = -1;
        this.lIlIIIIlIl = false;
        setMargins(i, i2, i3, i4, i5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getColor() {
        return this.IllIIIIllI;
    }

    public Point getLowerLeft() {
        return this.IllIIIllII;
    }

    public Point getLowerRight() {
        return this.llIIIlllll;
    }

    public Quadrilateral getSortedQuad() {
        Point point = this.llIIlIlIIl;
        Point[] pointArr = {point, this.IlIllIlIIl, this.IllIIIllII, this.llIIIlllll};
        Point[] pointArr2 = new Point[4];
        Point point2 = new Point((this.llIIIlllll.getX() + (this.IllIIIllII.getX() + (this.IlIllIlIIl.getX() + point.getX()))) / 4.0f, (this.llIIIlllll.getY() + (this.IllIIIllII.getY() + (this.IlIllIlIIl.getY() + this.llIIlIlIIl.getY()))) / 4.0f);
        double[] dArr = new double[4];
        int[] iArr = new int[4];
        for (int i = 0; i < 4; i++) {
            Point point3 = pointArr[i];
            dArr[i] = Math.atan2(point3.getY() - point2.getY(), point3.getX() - point2.getX());
            iArr[i] = i;
        }
        int i2 = 0;
        while (i2 < 4) {
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < 4; i4++) {
                double d = dArr[i2];
                double d2 = dArr[i4];
                if (d > d2) {
                    dArr[i2] = d2;
                    dArr[i4] = d;
                    int i5 = iArr[i2];
                    iArr[i2] = iArr[i4];
                    iArr[i4] = i5;
                }
            }
            i2 = i3;
        }
        float f = Float.MAX_VALUE;
        int i6 = 0;
        for (int i7 = 0; i7 < 4; i7++) {
            float fNorm = pointArr[iArr[i7]].norm();
            if (fNorm < f) {
                i6 = i7;
                f = fNorm;
            }
        }
        return new Quadrilateral(pointArr[iArr[i6 % 4]], pointArr[iArr[(i6 + 3) % 4]], pointArr[iArr[(i6 + 1) % 4]], pointArr[iArr[(i6 + 2) % 4]]);
    }

    public Point getUpperLeft() {
        return this.llIIlIlIIl;
    }

    public Point getUpperRight() {
        return this.IlIllIlIIl;
    }

    public boolean isDefaultQuad() {
        return this.lIlIIIIlIl;
    }

    public boolean isEmpty() {
        return this.llIIlIlIIl.isZero() && this.IlIllIlIIl.isZero() && this.IllIIIllII.isZero() && this.llIIIlllll.isZero();
    }

    public boolean matchesMargins(int i, int i2, int i3, int i4, int i5) {
        if (i5 != 1 && i5 != 9) {
            float f = i3;
            if (this.llIIlIlIIl.getX() != f) {
                return false;
            }
            float f2 = i;
            if (this.llIIlIlIIl.getY() != f2 || this.IlIllIlIIl.getX() != f) {
                return false;
            }
            float f3 = i2;
            if (this.IlIllIlIIl.getY() != f3) {
                return false;
            }
            float f4 = i4;
            return this.IllIIIllII.getX() == f4 && this.IllIIIllII.getY() == f2 && this.llIIIlllll.getX() == f4 && this.llIIIlllll.getY() == f3;
        }
        float f5 = i4;
        if (this.llIIlIlIIl.getX() != f5) {
            return false;
        }
        float f6 = i;
        if (this.llIIlIlIIl.getY() != f6) {
            return false;
        }
        float f7 = i3;
        if (this.IlIllIlIIl.getX() != f7 || this.IlIllIlIIl.getY() != f6 || this.IllIIIllII.getX() != f5) {
            return false;
        }
        float f8 = i2;
        return this.IllIIIllII.getY() == f8 && this.llIIIlllll.getX() == f7 && this.llIIIlllll.getY() == f8;
    }

    public void setColor(int i) {
        this.IllIIIIllI = i;
    }

    public void setIsDefaultQuad(boolean z) {
        this.lIlIIIIlIl = z;
    }

    public void setPoints(Point point, Point point2, Point point3, Point point4) {
        this.llIIlIlIIl = point;
        this.IlIllIlIIl = point2;
        this.IllIIIllII = point3;
        this.llIIIlllll = point4;
    }

    public void toFloatArray(float[] fArr) {
        fArr[0] = this.llIIlIlIIl.getX();
        fArr[1] = this.llIIlIlIIl.getY();
        fArr[2] = this.IlIllIlIIl.getX();
        fArr[3] = this.IlIllIlIIl.getY();
        fArr[4] = this.llIIIlllll.getX();
        fArr[5] = this.llIIIlllll.getY();
        fArr[6] = this.IllIIIllII.getX();
        fArr[7] = this.IllIIIllII.getY();
    }

    public String toString() {
        return IIllIllIIl.llIIlIlIIl("Quadrilateral{mUpperLeft=").append(this.llIIlIlIIl).append(", mUpperRight=").append(this.IlIllIlIIl).append(", mLowerLeft=").append(this.IllIIIllII).append(", mLowerRight=").append(this.llIIIlllll).append('}').toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.llIIlIlIIl, 0);
        parcel.writeParcelable(this.IlIllIlIIl, 0);
        parcel.writeParcelable(this.IllIIIllII, 0);
        parcel.writeParcelable(this.llIIIlllll, 0);
        parcel.writeInt(this.IllIIIIllI);
        parcel.writeByte(this.lIlIIIIlIl ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Quadrilateral m6355clone() {
        Quadrilateral quadrilateral = new Quadrilateral(this.llIIlIlIIl, this.IlIllIlIIl, this.IllIIIllII, this.llIIIlllll);
        quadrilateral.setIsDefaultQuad(this.lIlIIIIlIl);
        quadrilateral.setColor(this.IllIIIIllI);
        return quadrilateral;
    }

    public void setMargins(int i, int i2, int i3, int i4, int i5) {
        Log.m2713v(this, "Setting margins: top={}, bottom={}, left={}, right={}", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (i5 == 1 || i5 == 9) {
            float f = i4;
            float f2 = i;
            this.llIIlIlIIl = new Point(f, f2);
            float f3 = i3;
            this.IlIllIlIIl = new Point(f3, f2);
            float f4 = i2;
            this.IllIIIllII = new Point(f, f4);
            this.llIIIlllll = new Point(f3, f4);
            return;
        }
        float f5 = i3;
        float f6 = i;
        this.llIIlIlIIl = new Point(f5, f6);
        float f7 = i2;
        this.IlIllIlIIl = new Point(f5, f7);
        float f8 = i4;
        this.IllIIIllII = new Point(f8, f6);
        this.llIIIlllll = new Point(f8, f7);
    }

    public void mirror(int i, int i2, int i3) {
        Point pointMirrorY;
        Point pointMirrorY2;
        Point pointMirrorY3;
        Point pointMirrorX;
        if (i3 == 1 || i3 == 9) {
            float f = i2;
            pointMirrorY = this.llIIlIlIIl.mirrorY(f);
            pointMirrorY2 = this.IlIllIlIIl.mirrorY(f);
            Point pointMirrorY4 = this.IllIIIllII.mirrorY(f);
            pointMirrorY3 = this.llIIIlllll.mirrorY(f);
            pointMirrorX = pointMirrorY4;
        } else {
            float f2 = i;
            pointMirrorX = this.IlIllIlIIl.mirrorX(f2);
            pointMirrorY = this.llIIIlllll.mirrorX(f2);
            pointMirrorY3 = this.llIIlIlIIl.mirrorX(f2);
            pointMirrorY2 = this.IllIIIllII.mirrorX(f2);
        }
        this.llIIlIlIIl = pointMirrorX;
        this.IlIllIlIIl = pointMirrorY3;
        this.IllIIIllII = pointMirrorY;
        this.llIIIlllll = pointMirrorY2;
    }

    public Quadrilateral() {
        this.IllIIIIllI = -1;
        this.lIlIIIIlIl = false;
        setMargins(100, 100, 200, 200, 1);
    }

    public Quadrilateral(Point point, Point point2, Point point3, Point point4) {
        this.IllIIIIllI = -1;
        this.lIlIIIIlIl = false;
        setPoints(point, point2, point3, point4);
    }

    public Quadrilateral(float[] fArr) {
        this.IllIIIIllI = -1;
        this.lIlIIIIlIl = false;
        setPoints(new Point(fArr[0], fArr[1]), new Point(fArr[2], fArr[3]), new Point(fArr[6], fArr[7]), new Point(fArr[4], fArr[5]));
    }

    protected Quadrilateral(Parcel parcel) {
        this.IllIIIIllI = -1;
        this.lIlIIIIlIl = false;
        this.llIIlIlIIl = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.IlIllIlIIl = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.IllIIIllII = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.llIIIlllll = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.IllIIIIllI = parcel.readInt();
        this.lIlIIIIlIl = parcel.readByte() != 0;
    }
}
