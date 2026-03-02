package com.microblink.entities.recognizers.blinkid.generic;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.entities.recognizers.blinkid.DataMatchResult;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class DataMatchDetailedInfo implements Parcelable {
    public static final Parcelable.Creator<DataMatchDetailedInfo> CREATOR = new Parcelable.Creator<DataMatchDetailedInfo>() { // from class: com.microblink.entities.recognizers.blinkid.generic.DataMatchDetailedInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataMatchDetailedInfo createFromParcel(Parcel parcel) {
            return new DataMatchDetailedInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataMatchDetailedInfo[] newArray(int i) {
            return new DataMatchDetailedInfo[i];
        }
    };
    private DataMatchResult IlIllIlIIl;
    private DataMatchResult IllIIIllII;
    private DataMatchResult llIIIlllll;
    private DataMatchResult llIIlIlIIl;

    public DataMatchDetailedInfo(DataMatchResult dataMatchResult, DataMatchResult dataMatchResult2, DataMatchResult dataMatchResult3, DataMatchResult dataMatchResult4) {
        this.llIIlIlIIl = dataMatchResult;
        this.IlIllIlIIl = dataMatchResult2;
        this.IllIIIllII = dataMatchResult3;
        this.llIIIlllll = dataMatchResult4;
    }

    public static DataMatchDetailedInfo createFromNative(int i, int i2, int i3, int i4) {
        return new DataMatchDetailedInfo(DataMatchResult.values()[i], DataMatchResult.values()[i2], DataMatchResult.values()[i3], DataMatchResult.values()[i4]);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DataMatchResult getDataMatchResult() {
        return this.llIIlIlIIl;
    }

    public DataMatchResult getDateOfBirth() {
        return this.IllIIIllII;
    }

    public DataMatchResult getDateOfExpiry() {
        return this.llIIIlllll;
    }

    public DataMatchResult getDocumentNumber() {
        return this.IlIllIlIIl;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.llIIlIlIIl.ordinal());
        parcel.writeInt(this.IlIllIlIIl.ordinal());
        parcel.writeInt(this.IllIIIllII.ordinal());
        parcel.writeInt(this.llIIIlllll.ordinal());
    }

    protected DataMatchDetailedInfo(Parcel parcel) {
        this.llIIlIlIIl = DataMatchResult.values()[parcel.readInt()];
        this.IlIllIlIIl = DataMatchResult.values()[parcel.readInt()];
        this.IllIIIllII = DataMatchResult.values()[parcel.readInt()];
        this.llIIIlllll = DataMatchResult.values()[parcel.readInt()];
    }
}
