package com.microblink.entities.recognizers.blinkid.generic;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.results.date.DateResult;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class VehicleClassInfo implements Parcelable {
    public static final Parcelable.Creator<VehicleClassInfo> CREATOR = new Parcelable.Creator<VehicleClassInfo>() { // from class: com.microblink.entities.recognizers.blinkid.generic.VehicleClassInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VehicleClassInfo createFromParcel(Parcel parcel) {
            return new VehicleClassInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VehicleClassInfo[] newArray(int i) {
            return new VehicleClassInfo[i];
        }
    };
    private DateResult IlIllIlIIl;
    private String IllIIIllII;
    private String llIIIlllll;
    private DateResult llIIlIlIIl;

    private VehicleClassInfo(DateResult dateResult, DateResult dateResult2, String str, String str2) {
        this.llIIlIlIIl = dateResult;
        this.IlIllIlIIl = dateResult2;
        this.IllIIIllII = str;
        this.llIIIlllll = str2;
    }

    public static VehicleClassInfo createFromNative(DateResult dateResult, DateResult dateResult2, String str, String str2) {
        return new VehicleClassInfo(dateResult, dateResult2, str, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DateResult getEffectiveDate() {
        return this.llIIlIlIIl;
    }

    public DateResult getExpiryDate() {
        return this.IlIllIlIIl;
    }

    public String getLicenceType() {
        return this.llIIIlllll;
    }

    public String getVehicleClass() {
        return this.IllIIIllII;
    }

    public boolean isEmpty() {
        return this.llIIlIlIIl.getOriginalDateString().isEmpty() && this.IlIllIlIIl.getOriginalDateString().isEmpty() && this.IllIIIllII.isEmpty() && this.llIIIlllll.isEmpty();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.llIIlIlIIl, i);
        parcel.writeParcelable(this.IlIllIlIIl, i);
        parcel.writeString(this.IllIIIllII);
        parcel.writeString(this.llIIIlllll);
    }

    protected VehicleClassInfo(Parcel parcel) {
        this.llIIlIlIIl = (DateResult) parcel.readParcelable(DateResult.class.getClassLoader());
        this.IlIllIlIIl = (DateResult) parcel.readParcelable(DateResult.class.getClassLoader());
        this.IllIIIllII = parcel.readString();
        this.llIIIlllll = parcel.readString();
    }
}
