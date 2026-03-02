package com.microblink.geometry;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkid.secured.IIllIllIIl;
import com.microblink.util.Log;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class Rectangle implements Parcelable {
    public static final Parcelable.Creator<Rectangle> CREATOR = new llIIlIlIIl();
    private float IlIllIlIIl;
    private float IllIIIllII;
    private float llIIIlllll;
    private float llIIlIlIIl;

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements Parcelable.Creator<Rectangle> {
        llIIlIlIIl() {
        }

        @Override // android.os.Parcelable.Creator
        public Rectangle createFromParcel(Parcel parcel) {
            return new Rectangle(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public Rectangle[] newArray(int i) {
            return new Rectangle[i];
        }
    }

    /* synthetic */ Rectangle(Parcel parcel, llIIlIlIIl lliililiil) {
        this(parcel);
    }

    public static Rectangle fromRectF(RectF rectF) {
        return new Rectangle(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    public static Rectangle getDefaultROI() {
        return new Rectangle(0.0f, 0.0f, 1.0f, 1.0f);
    }

    private boolean llIIlIlIIl(float f) {
        return f >= 0.0f && f <= 1.0f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rectangle)) {
            return false;
        }
        Rectangle rectangle = (Rectangle) obj;
        return Float.compare(rectangle.llIIlIlIIl, this.llIIlIlIIl) == 0 && Float.compare(rectangle.IlIllIlIIl, this.IlIllIlIIl) == 0 && Float.compare(rectangle.IllIIIllII, this.IllIIIllII) == 0 && Float.compare(rectangle.llIIIlllll, this.llIIIlllll) == 0;
    }

    public float getHeight() {
        return this.llIIIlllll;
    }

    public float getWidth() {
        return this.IllIIIllII;
    }

    public float getX() {
        return this.llIIlIlIIl;
    }

    public float getY() {
        return this.IlIllIlIIl;
    }

    public int hashCode() {
        float f = this.llIIlIlIIl;
        int iFloatToIntBits = (f != 0.0f ? Float.floatToIntBits(f) : 0) * 31;
        float f2 = this.IlIllIlIIl;
        int iFloatToIntBits2 = (iFloatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
        float f3 = this.IllIIIllII;
        int iFloatToIntBits3 = (iFloatToIntBits2 + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
        float f4 = this.llIIIlllll;
        return iFloatToIntBits3 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0);
    }

    public boolean isRelative() {
        return llIIlIlIIl(this.llIIlIlIIl) && llIIlIlIIl(this.IlIllIlIIl) && llIIlIlIIl(this.IllIIIllII) && llIIlIlIIl(this.llIIIlllll) && this.llIIlIlIIl + this.IllIIIllII <= 1.0f && this.IlIllIlIIl + this.llIIIlllll <= 1.0f;
    }

    public void log() {
        Log.m2707d(this, "Rectangle[{}, {}, {}, {}]", Float.valueOf(this.llIIlIlIIl), Float.valueOf(this.IlIllIlIIl), Float.valueOf(this.IllIIIllII), Float.valueOf(this.llIIIlllll));
    }

    public void normalizeToUnitRectangle() {
        if (this.llIIlIlIIl < 0.0f) {
            this.llIIlIlIIl = 0.0f;
        }
        if (this.IlIllIlIIl < 0.0f) {
            this.IlIllIlIIl = 0.0f;
        }
        if (this.IllIIIllII > 1.0f) {
            this.IllIIIllII = 1.0f;
        }
        if (this.llIIIlllll > 1.0f) {
            this.llIIIlllll = 1.0f;
        }
    }

    public RectF toRectF() {
        float f = this.llIIlIlIIl;
        float f2 = this.IlIllIlIIl;
        return new RectF(f, f2, this.IllIIIllII + f, this.llIIIlllll + f2);
    }

    public String toString() {
        return IIllIllIIl.llIIlIlIIl("Rectangle[").append(this.llIIlIlIIl).append(", ").append(this.IlIllIlIIl).append(", ").append(this.IllIIIllII).append(", ").append(this.llIIIlllll).append("]").toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.llIIlIlIIl);
        parcel.writeFloat(this.IlIllIlIIl);
        parcel.writeFloat(this.IllIIIllII);
        parcel.writeFloat(this.llIIIlllll);
    }

    public Rectangle(float f, float f2, float f3, float f4) {
        this.llIIlIlIIl = f;
        this.IlIllIlIIl = f2;
        this.IllIIIllII = f3;
        this.llIIIlllll = f4;
    }

    private Rectangle(Parcel parcel) {
        this.llIIlIlIIl = parcel.readFloat();
        this.IlIllIlIIl = parcel.readFloat();
        this.IllIIIllII = parcel.readFloat();
        this.llIIIlllll = parcel.readFloat();
    }
}
