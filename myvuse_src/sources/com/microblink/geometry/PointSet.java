package com.microblink.geometry;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class PointSet implements Parcelable {
    public static final Parcelable.Creator<PointSet> CREATOR = new llIIlIlIIl();
    private ArrayList<Point> llIIlIlIIl;

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements Parcelable.Creator<PointSet> {
        llIIlIlIIl() {
        }

        @Override // android.os.Parcelable.Creator
        public PointSet createFromParcel(Parcel parcel) {
            return new PointSet(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PointSet[] newArray(int i) {
            return new PointSet[i];
        }
    }

    public PointSet(List<Point> list) {
        this.llIIlIlIIl = null;
        if (list instanceof ArrayList) {
            this.llIIlIlIIl = (ArrayList) list;
            return;
        }
        ArrayList<Point> arrayList = new ArrayList<>(list.size());
        this.llIIlIlIIl = arrayList;
        arrayList.addAll(list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void draw(Canvas canvas, Paint paint, int i) {
        ArrayList<Point> arrayList = this.llIIlIlIIl;
        if (arrayList != null) {
            Iterator<Point> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().draw(canvas, paint, i);
            }
        }
    }

    public List<Point> getPoints() {
        return this.llIIlIlIIl;
    }

    public float[] toFloatArray() {
        float[] fArr = new float[this.llIIlIlIIl.size() * 2];
        for (int i = 0; i < this.llIIlIlIIl.size(); i++) {
            int i2 = i * 2;
            fArr[i2] = this.llIIlIlIIl.get(i).getX();
            fArr[i2 + 1] = this.llIIlIlIIl.get(i).getY();
        }
        return fArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.llIIlIlIIl);
    }

    public PointSet(float[] fArr) {
        this.llIIlIlIIl = null;
        this.llIIlIlIIl = new ArrayList<>(fArr.length / 2);
        for (int i = 0; i < fArr.length - 1; i += 2) {
            this.llIIlIlIIl.add(new Point(fArr[i], fArr[i + 1]));
        }
    }

    public PointSet(float[] fArr, int i, int i2, int i3, boolean z) {
        this.llIIlIlIIl = null;
        Log.m2707d(this, "Point set length: {}", Integer.valueOf(fArr.length));
        this.llIIlIlIIl = new ArrayList<>(fArr.length / 2);
        for (int i4 = 0; i4 < fArr.length - 1; i4 += 2) {
            Point point = new Point(fArr[i4], fArr[i4 + 1]);
            point = (i3 == 8 || i3 == 9) ? point.mirrorXY(1.0f, 1.0f) : point;
            point = z ? point.mirrorXY(1.0f, 1.0f) : point;
            if (i3 != 1 && i3 != 9) {
                this.llIIlIlIIl.add(new Point(point.getX() * i, point.getY() * i2));
            } else {
                this.llIIlIlIIl.add(new Point((1.0f - point.getY()) * i, point.getX() * i2));
            }
        }
    }

    protected PointSet(Parcel parcel) {
        this.llIIlIlIIl = null;
        this.llIIlIlIIl = parcel.createTypedArrayList(Point.CREATOR);
    }
}
