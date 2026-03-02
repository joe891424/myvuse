package com.microblink.entities.recognizers.blinkid.generic;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class DriverLicenseDetailedInfo implements Parcelable {
    public static final Parcelable.Creator<DriverLicenseDetailedInfo> CREATOR = new Parcelable.Creator<DriverLicenseDetailedInfo>() { // from class: com.microblink.entities.recognizers.blinkid.generic.DriverLicenseDetailedInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DriverLicenseDetailedInfo createFromParcel(Parcel parcel) {
            return new DriverLicenseDetailedInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DriverLicenseDetailedInfo[] newArray(int i) {
            return new DriverLicenseDetailedInfo[i];
        }
    };
    private String IlIllIlIIl;
    private String IllIIIIllI;
    private String IllIIIllII;
    private VehicleClassInfo[] llIIIlllll;
    private String llIIlIlIIl;

    private DriverLicenseDetailedInfo(String str, String str2, String str3, VehicleClassInfo[] vehicleClassInfoArr, String str4) {
        this.llIIlIlIIl = str;
        this.IlIllIlIIl = str2;
        this.IllIIIllII = str3;
        this.llIIIlllll = vehicleClassInfoArr;
        this.IllIIIIllI = str4;
    }

    public static DriverLicenseDetailedInfo createFromNative(String str, String str2, String str3, String str4, VehicleClassInfo[] vehicleClassInfoArr) {
        return new DriverLicenseDetailedInfo(str, str2, str3, vehicleClassInfoArr, str4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getConditions() {
        return this.IllIIIIllI;
    }

    public String getEndorsements() {
        return this.IlIllIlIIl;
    }

    public String getRestrictions() {
        return this.llIIlIlIIl;
    }

    public String getVehicleClass() {
        return this.IllIIIllII;
    }

    public VehicleClassInfo[] getVehicleClassesInfo() {
        return this.llIIIlllll;
    }

    public boolean isEmpty() {
        return this.llIIlIlIIl.isEmpty() && this.IlIllIlIIl.isEmpty() && this.IllIIIllII.isEmpty() && this.IllIIIIllI.isEmpty() && this.llIIIlllll.length == 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.llIIlIlIIl);
        parcel.writeString(this.IlIllIlIIl);
        parcel.writeString(this.IllIIIllII);
        parcel.writeParcelableArray(this.llIIIlllll, i);
        parcel.writeString(this.IllIIIIllI);
    }

    protected DriverLicenseDetailedInfo(Parcel parcel) {
        this.llIIlIlIIl = parcel.readString();
        this.IlIllIlIIl = parcel.readString();
        this.IllIIIllII = parcel.readString();
        Parcelable[] parcelableArray = parcel.readParcelableArray(VehicleClassInfo.class.getClassLoader());
        this.llIIIlllll = new VehicleClassInfo[parcelableArray.length];
        int i = 0;
        while (true) {
            VehicleClassInfo[] vehicleClassInfoArr = this.llIIIlllll;
            if (i < vehicleClassInfoArr.length) {
                vehicleClassInfoArr[i] = (VehicleClassInfo) parcelableArray[i];
                i++;
            } else {
                this.IllIIIIllI = parcel.readString();
                return;
            }
        }
    }
}
