package com.microblink.geometry;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkid.secured.IIllIllIIl;
import com.microblink.util.Log;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class Point implements Parcelable {
    public static final Parcelable.Creator<Point> CREATOR = new llIIlIlIIl();
    private float IlIllIlIIl;
    private float IllIIIllII;
    private float llIIlIlIIl;

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements Parcelable.Creator<Point> {
        llIIlIlIIl() {
        }

        @Override // android.os.Parcelable.Creator
        public Point createFromParcel(Parcel parcel) {
            return new Point(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Point[] newArray(int i) {
            return new Point[i];
        }
    }

    public Point() {
        this.IllIIIllII = -1.0f;
        this.llIIlIlIIl = 0.0f;
        this.IlIllIlIIl = 0.0f;
    }

    public Point clamp(float f) {
        return norm() > f ? normalize(f) : new Point(this.llIIlIlIIl, this.IlIllIlIIl);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float distance(Point point) {
        float f = this.llIIlIlIIl - point.llIIlIlIIl;
        float f2 = this.IlIllIlIIl - point.IlIllIlIIl;
        return (float) Math.sqrt((f2 * f2) + (f * f));
    }

    public void draw(Canvas canvas, Paint paint, int i) {
        canvas.drawCircle(this.llIIlIlIIl, this.IlIllIlIIl, i, paint);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        return this.llIIlIlIIl == point.llIIlIlIIl && this.IlIllIlIIl == point.IlIllIlIIl;
    }

    public float getX() {
        return this.llIIlIlIIl;
    }

    public float getY() {
        return this.IlIllIlIIl;
    }

    public boolean isZero() {
        return this.llIIlIlIIl == 0.0f && this.IlIllIlIIl == 0.0f;
    }

    public void log() {
        Log.m2707d(this, String.format("(%f,%f)", Float.valueOf(this.llIIlIlIIl), Float.valueOf(this.IlIllIlIIl)), new Object[0]);
    }

    public Point makeCopy() {
        return new Point(this.llIIlIlIIl, this.IlIllIlIIl);
    }

    public Point mirrorX(float f) {
        Point pointMakeCopy = makeCopy();
        pointMakeCopy.mirrorXInPlace(f);
        return pointMakeCopy;
    }

    public void mirrorXInPlace(float f) {
        this.llIIlIlIIl = f - this.llIIlIlIIl;
    }

    public Point mirrorXY(float f, float f2) {
        Point pointMakeCopy = makeCopy();
        pointMakeCopy.mirrorXYInPlace(f, f2);
        return pointMakeCopy;
    }

    public void mirrorXYInPlace(float f, float f2) {
        this.llIIlIlIIl = f - this.llIIlIlIIl;
        this.IlIllIlIIl = f2 - this.IlIllIlIIl;
    }

    public Point mirrorY(float f) {
        Point pointMakeCopy = makeCopy();
        pointMakeCopy.mirrorYInPlace(f);
        return pointMakeCopy;
    }

    public void mirrorYInPlace(float f) {
        this.IlIllIlIIl = f - this.IlIllIlIIl;
    }

    public Point negative() {
        this.llIIlIlIIl = -this.llIIlIlIIl;
        this.IlIllIlIIl = -this.IlIllIlIIl;
        return this;
    }

    public Point negativeClone() {
        return new Point(-this.llIIlIlIIl, -this.IlIllIlIIl);
    }

    public float norm() {
        if (this.IllIIIllII < 0.0f) {
            float f = this.llIIlIlIIl;
            float f2 = this.IlIllIlIIl;
            this.IllIIIllII = (float) Math.sqrt((f2 * f2) + (f * f));
        }
        return this.IllIIIllII;
    }

    public Point normalize() {
        float fNorm = norm();
        return new Point(this.llIIlIlIIl / fNorm, this.IlIllIlIIl / fNorm);
    }

    public Point operatorMinus(Point point) {
        return new Point(this.llIIlIlIIl - point.llIIlIlIIl, this.IlIllIlIIl - point.IlIllIlIIl);
    }

    public Point operatorMinusEquals(Point point) {
        this.llIIlIlIIl -= point.llIIlIlIIl;
        this.IlIllIlIIl -= point.IlIllIlIIl;
        return this;
    }

    public Point operatorMultiply(float f) {
        return new Point(this.llIIlIlIIl * f, this.IlIllIlIIl * f);
    }

    public Point operatorMultiplyEquals(float f) {
        this.llIIlIlIIl *= f;
        this.IlIllIlIIl *= f;
        return this;
    }

    public Point operatorPlus(Point point) {
        return new Point(this.llIIlIlIIl + point.llIIlIlIIl, this.IlIllIlIIl + point.IlIllIlIIl);
    }

    public void operatorPlusEquals(Point point) {
        this.llIIlIlIIl += point.llIIlIlIIl;
        this.IlIllIlIIl += point.IlIllIlIIl;
    }

    public void setX(float f) {
        this.llIIlIlIIl = f;
    }

    public void setY(float f) {
        this.IlIllIlIIl = f;
    }

    public String toString() {
        return IIllIllIIl.llIIlIlIIl("Point{mX=").append(this.llIIlIlIIl).append(", mY=").append(this.IlIllIlIIl).append('}').toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.llIIlIlIIl);
        parcel.writeFloat(this.IlIllIlIIl);
        parcel.writeFloat(this.IllIIIllII);
    }

    public Point normalize(float f) {
        float fNorm = norm();
        return new Point((this.llIIlIlIIl * f) / fNorm, (this.IlIllIlIIl * f) / fNorm);
    }

    public Point clamp(float f, float f2) {
        float fNorm = norm();
        if (fNorm > f2) {
            return normalize(f2);
        }
        if (fNorm < f) {
            return normalize(f);
        }
        return new Point(this.llIIlIlIIl, this.IlIllIlIIl);
    }

    public Point(float f, float f2) {
        this.IllIIIllII = -1.0f;
        this.llIIlIlIIl = f;
        this.IlIllIlIIl = f2;
    }

    protected Point(Parcel parcel) {
        this.IllIIIllII = -1.0f;
        this.llIIlIlIIl = parcel.readFloat();
        this.IlIllIlIIl = parcel.readFloat();
        this.IllIIIllII = parcel.readFloat();
    }
}
