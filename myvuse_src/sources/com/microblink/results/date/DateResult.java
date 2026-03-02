package com.microblink.results.date;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.results.Result;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class DateResult implements Parcelable, Result {
    public static final Parcelable.Creator<DateResult> CREATOR = new Parcelable.Creator<DateResult>() { // from class: com.microblink.results.date.DateResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DateResult createFromParcel(Parcel parcel) {
            return new DateResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DateResult[] newArray(int i) {
            return new DateResult[i];
        }
    };
    private String IlIllIlIIl;
    private Date llIIlIlIIl;

    public static DateResult createFromDMY(int i, int i2, int i3, String str) {
        return new DateResult(new Date(i, i2, i3), str);
    }

    public static DateResult createUnparsed(String str) {
        return new DateResult((Date) null, str);
    }

    private void llIIlIlIIl(Parcel parcel) {
        if (parcel.readByte() == 1) {
            this.llIIlIlIIl = new Date(parcel.readInt(), parcel.readInt(), parcel.readInt());
        } else {
            this.llIIlIlIIl = null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Date getDate() {
        return this.llIIlIlIIl;
    }

    @Override // com.microblink.results.Result
    public Object getNativeResult() {
        return getDate();
    }

    public String getOriginalDateString() {
        return this.IlIllIlIIl;
    }

    @Override // com.microblink.results.Result
    public String getStringResult() {
        return getOriginalDateString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.llIIlIlIIl != null) {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.llIIlIlIIl.getDay());
            parcel.writeInt(this.llIIlIlIIl.getMonth());
            parcel.writeInt(this.llIIlIlIIl.getYear());
        } else {
            parcel.writeByte((byte) 0);
        }
        parcel.writeString(this.IlIllIlIIl);
    }

    private DateResult(Date date, String str) {
        this.llIIlIlIIl = date;
        this.IlIllIlIIl = str;
    }

    public String toString() {
        Date date = this.llIIlIlIIl;
        return String.format("Date: %s, original string: %s", date == null ? "null" : date.toString(), this.IlIllIlIIl);
    }

    private DateResult(Parcel parcel) {
        llIIlIlIIl(parcel);
        this.IlIllIlIIl = parcel.readString();
    }
}
