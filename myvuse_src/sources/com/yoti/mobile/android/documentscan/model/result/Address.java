package com.yoti.mobile.android.documentscan.model.result;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0012J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J©\u0001\u00100\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u00101\u001a\u000202HÖ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u000202HÖ\u0001J\t\u00108\u001a\u00020\u0004HÖ\u0001J\u0019\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u000202HÖ\u0001R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u0006>"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/model/result/Address;", "Landroid/os/Parcelable;", "lines", "", "", "town", "locality", "county", "postcode", "country", "Lcom/yoti/mobile/android/documentscan/model/result/Country;", "careOf", "landmark", "district", "subDistrict", "postOffice", "building", "fullAddress", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/yoti/mobile/android/documentscan/model/result/Country;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBuilding", "()Ljava/lang/String;", "getCareOf", "getCountry", "()Lcom/yoti/mobile/android/documentscan/model/result/Country;", "getCounty", "getDistrict", "getFullAddress", "getLandmark", "getLines", "()Ljava/util/List;", "getLocality", "getPostOffice", "getPostcode", "getSubDistrict", "getTown", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final /* data */ class Address implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String building;
    private final String careOf;
    private final Country country;
    private final String county;
    private final String district;
    private final String fullAddress;
    private final String landmark;
    private final List<String> lines;
    private final String locality;
    private final String postOffice;
    private final String postcode;
    private final String subDistrict;
    private final String town;

    @Metadata(m5596bv = {1, 0, 3}, m5599k = 3, m5600mv = {1, 1, 15})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel in) {
            Intrinsics.checkParameterIsNotNull(in, "in");
            return new Address(in.createStringArrayList(), in.readString(), in.readString(), in.readString(), in.readString(), in.readInt() != 0 ? (Country) Country.CREATOR.createFromParcel(in) : null, in.readString(), in.readString(), in.readString(), in.readString(), in.readString(), in.readString(), in.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new Address[i];
        }
    }

    public Address(List<String> lines, String str, String str2, String str3, String str4, Country country, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        Intrinsics.checkParameterIsNotNull(lines, "lines");
        this.lines = lines;
        this.town = str;
        this.locality = str2;
        this.county = str3;
        this.postcode = str4;
        this.country = country;
        this.careOf = str5;
        this.landmark = str6;
        this.district = str7;
        this.subDistrict = str8;
        this.postOffice = str9;
        this.building = str10;
        this.fullAddress = str11;
    }

    public final List<String> component1() {
        return this.lines;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getSubDistrict() {
        return this.subDistrict;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getPostOffice() {
        return this.postOffice;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getBuilding() {
        return this.building;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getFullAddress() {
        return this.fullAddress;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTown() {
        return this.town;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLocality() {
        return this.locality;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCounty() {
        return this.county;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPostcode() {
        return this.postcode;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Country getCountry() {
        return this.country;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCareOf() {
        return this.careOf;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getLandmark() {
        return this.landmark;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDistrict() {
        return this.district;
    }

    public final Address copy(List<String> lines, String town, String locality, String county, String postcode, Country country, String careOf, String landmark, String district, String subDistrict, String postOffice, String building, String fullAddress) {
        Intrinsics.checkParameterIsNotNull(lines, "lines");
        return new Address(lines, town, locality, county, postcode, country, careOf, landmark, district, subDistrict, postOffice, building, fullAddress);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Address)) {
            return false;
        }
        Address address = (Address) other;
        return Intrinsics.areEqual(this.lines, address.lines) && Intrinsics.areEqual(this.town, address.town) && Intrinsics.areEqual(this.locality, address.locality) && Intrinsics.areEqual(this.county, address.county) && Intrinsics.areEqual(this.postcode, address.postcode) && Intrinsics.areEqual(this.country, address.country) && Intrinsics.areEqual(this.careOf, address.careOf) && Intrinsics.areEqual(this.landmark, address.landmark) && Intrinsics.areEqual(this.district, address.district) && Intrinsics.areEqual(this.subDistrict, address.subDistrict) && Intrinsics.areEqual(this.postOffice, address.postOffice) && Intrinsics.areEqual(this.building, address.building) && Intrinsics.areEqual(this.fullAddress, address.fullAddress);
    }

    public final String getBuilding() {
        return this.building;
    }

    public final String getCareOf() {
        return this.careOf;
    }

    public final Country getCountry() {
        return this.country;
    }

    public final String getCounty() {
        return this.county;
    }

    public final String getDistrict() {
        return this.district;
    }

    public final String getFullAddress() {
        return this.fullAddress;
    }

    public final String getLandmark() {
        return this.landmark;
    }

    public final List<String> getLines() {
        return this.lines;
    }

    public final String getLocality() {
        return this.locality;
    }

    public final String getPostOffice() {
        return this.postOffice;
    }

    public final String getPostcode() {
        return this.postcode;
    }

    public final String getSubDistrict() {
        return this.subDistrict;
    }

    public final String getTown() {
        return this.town;
    }

    public int hashCode() {
        List<String> list = this.lines;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.town;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.locality;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.county;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.postcode;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Country country = this.country;
        int iHashCode6 = (iHashCode5 + (country != null ? country.hashCode() : 0)) * 31;
        String str5 = this.careOf;
        int iHashCode7 = (iHashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.landmark;
        int iHashCode8 = (iHashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.district;
        int iHashCode9 = (iHashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.subDistrict;
        int iHashCode10 = (iHashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.postOffice;
        int iHashCode11 = (iHashCode10 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.building;
        int iHashCode12 = (iHashCode11 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.fullAddress;
        return iHashCode12 + (str11 != null ? str11.hashCode() : 0);
    }

    public String toString() {
        return "Address(lines=" + this.lines + ", town=" + this.town + ", locality=" + this.locality + ", county=" + this.county + ", postcode=" + this.postcode + ", country=" + this.country + ", careOf=" + this.careOf + ", landmark=" + this.landmark + ", district=" + this.district + ", subDistrict=" + this.subDistrict + ", postOffice=" + this.postOffice + ", building=" + this.building + ", fullAddress=" + this.fullAddress + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeStringList(this.lines);
        parcel.writeString(this.town);
        parcel.writeString(this.locality);
        parcel.writeString(this.county);
        parcel.writeString(this.postcode);
        Country country = this.country;
        if (country != null) {
            parcel.writeInt(1);
            country.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.careOf);
        parcel.writeString(this.landmark);
        parcel.writeString(this.district);
        parcel.writeString(this.subDistrict);
        parcel.writeString(this.postOffice);
        parcel.writeString(this.building);
        parcel.writeString(this.fullAddress);
    }
}
