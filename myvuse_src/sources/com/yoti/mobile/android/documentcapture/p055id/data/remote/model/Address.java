package com.yoti.mobile.android.documentcapture.p055id.data.remote.model;

import androidx.autofill.HintConstants;
import com.google.gson.annotations.SerializedName;
import com.yoti.mobile.android.documentscan.domain.p059a.aadhaar.AadhaarAddressFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\bK\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B¥\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001cJ\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J©\u0002\u0010O\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010S\u001a\u00020THÖ\u0001J\t\u0010U\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010 R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010 R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010 R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010 R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010 ¨\u0006V"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/Address;", "", "addressFormat", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/AddressFormatType;", "careOf", "", "subBuilding", "buildingNumber", "building", AadhaarAddressFormatter.ATTR_STREET, "landmark", "addressLine1", "addressLine2", "addressLine3", "addressLine4", "addressLine5", "addressLine6", "locality", "townCity", "subdistrict", "district", "state", HintConstants.AUTOFILL_HINT_POSTAL_CODE, "postOffice", "countryIso3Code", "country", "udprn", "formattedAddress", "(Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/AddressFormatType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddressFormat", "()Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/AddressFormatType;", "getAddressLine1", "()Ljava/lang/String;", "getAddressLine2", "getAddressLine3", "getAddressLine4", "getAddressLine5", "getAddressLine6", "getBuilding", "getBuildingNumber", "getCareOf", "getCountry", "getCountryIso3Code", "getDistrict", "getFormattedAddress", "getLandmark", "getLocality", "getPostOffice", "getPostalCode", "getState", "getStreet", "getSubBuilding", "getSubdistrict", "getTownCity", "getUdprn", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class Address {

    @SerializedName("address_format")
    private final AddressFormatType addressFormat;

    @SerializedName("address_line1")
    private final String addressLine1;

    @SerializedName("address_line2")
    private final String addressLine2;

    @SerializedName("address_line3")
    private final String addressLine3;

    @SerializedName("address_line4")
    private final String addressLine4;

    @SerializedName("address_line5")
    private final String addressLine5;

    @SerializedName("address_line6")
    private final String addressLine6;

    @SerializedName("building")
    private final String building;

    @SerializedName("building_number")
    private final String buildingNumber;

    @SerializedName("care_of")
    private final String careOf;

    @SerializedName("country")
    private final String country;

    @SerializedName("country_iso")
    private final String countryIso3Code;

    @SerializedName("district")
    private final String district;

    @SerializedName("formatted_address")
    private final String formattedAddress;

    @SerializedName("landmark")
    private final String landmark;

    @SerializedName("locality")
    private final String locality;

    @SerializedName("post_office")
    private final String postOffice;

    @SerializedName("postal_code")
    private final String postalCode;

    @SerializedName("state")
    private final String state;

    @SerializedName(AadhaarAddressFormatter.ATTR_STREET)
    private final String street;

    @SerializedName("sub_building")
    private final String subBuilding;

    @SerializedName("subdistrict")
    private final String subdistrict;

    @SerializedName("town_city")
    private final String townCity;

    @SerializedName("udprn")
    private final String udprn;

    public Address() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16777215, null);
    }

    public Address(AddressFormatType addressFormatType, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23) {
        this.addressFormat = addressFormatType;
        this.careOf = str;
        this.subBuilding = str2;
        this.buildingNumber = str3;
        this.building = str4;
        this.street = str5;
        this.landmark = str6;
        this.addressLine1 = str7;
        this.addressLine2 = str8;
        this.addressLine3 = str9;
        this.addressLine4 = str10;
        this.addressLine5 = str11;
        this.addressLine6 = str12;
        this.locality = str13;
        this.townCity = str14;
        this.subdistrict = str15;
        this.district = str16;
        this.state = str17;
        this.postalCode = str18;
        this.postOffice = str19;
        this.countryIso3Code = str20;
        this.country = str21;
        this.udprn = str22;
        this.formattedAddress = str23;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AddressFormatType getAddressFormat() {
        return this.addressFormat;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getAddressLine3() {
        return this.addressLine3;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getAddressLine4() {
        return this.addressLine4;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getAddressLine5() {
        return this.addressLine5;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getAddressLine6() {
        return this.addressLine6;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getLocality() {
        return this.locality;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getTownCity() {
        return this.townCity;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getSubdistrict() {
        return this.subdistrict;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getDistrict() {
        return this.district;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getPostalCode() {
        return this.postalCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCareOf() {
        return this.careOf;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getPostOffice() {
        return this.postOffice;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getCountryIso3Code() {
        return this.countryIso3Code;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getUdprn() {
        return this.udprn;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getFormattedAddress() {
        return this.formattedAddress;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSubBuilding() {
        return this.subBuilding;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBuildingNumber() {
        return this.buildingNumber;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBuilding() {
        return this.building;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getStreet() {
        return this.street;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getLandmark() {
        return this.landmark;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getAddressLine1() {
        return this.addressLine1;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getAddressLine2() {
        return this.addressLine2;
    }

    public final Address copy(AddressFormatType addressFormat, String careOf, String subBuilding, String buildingNumber, String building, String street, String landmark, String addressLine1, String addressLine2, String addressLine3, String addressLine4, String addressLine5, String addressLine6, String locality, String townCity, String subdistrict, String district, String state, String postalCode, String postOffice, String countryIso3Code, String country, String udprn, String formattedAddress) {
        return new Address(addressFormat, careOf, subBuilding, buildingNumber, building, street, landmark, addressLine1, addressLine2, addressLine3, addressLine4, addressLine5, addressLine6, locality, townCity, subdistrict, district, state, postalCode, postOffice, countryIso3Code, country, udprn, formattedAddress);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Address)) {
            return false;
        }
        Address address = (Address) other;
        return this.addressFormat == address.addressFormat && Intrinsics.areEqual(this.careOf, address.careOf) && Intrinsics.areEqual(this.subBuilding, address.subBuilding) && Intrinsics.areEqual(this.buildingNumber, address.buildingNumber) && Intrinsics.areEqual(this.building, address.building) && Intrinsics.areEqual(this.street, address.street) && Intrinsics.areEqual(this.landmark, address.landmark) && Intrinsics.areEqual(this.addressLine1, address.addressLine1) && Intrinsics.areEqual(this.addressLine2, address.addressLine2) && Intrinsics.areEqual(this.addressLine3, address.addressLine3) && Intrinsics.areEqual(this.addressLine4, address.addressLine4) && Intrinsics.areEqual(this.addressLine5, address.addressLine5) && Intrinsics.areEqual(this.addressLine6, address.addressLine6) && Intrinsics.areEqual(this.locality, address.locality) && Intrinsics.areEqual(this.townCity, address.townCity) && Intrinsics.areEqual(this.subdistrict, address.subdistrict) && Intrinsics.areEqual(this.district, address.district) && Intrinsics.areEqual(this.state, address.state) && Intrinsics.areEqual(this.postalCode, address.postalCode) && Intrinsics.areEqual(this.postOffice, address.postOffice) && Intrinsics.areEqual(this.countryIso3Code, address.countryIso3Code) && Intrinsics.areEqual(this.country, address.country) && Intrinsics.areEqual(this.udprn, address.udprn) && Intrinsics.areEqual(this.formattedAddress, address.formattedAddress);
    }

    public final AddressFormatType getAddressFormat() {
        return this.addressFormat;
    }

    public final String getAddressLine1() {
        return this.addressLine1;
    }

    public final String getAddressLine2() {
        return this.addressLine2;
    }

    public final String getAddressLine3() {
        return this.addressLine3;
    }

    public final String getAddressLine4() {
        return this.addressLine4;
    }

    public final String getAddressLine5() {
        return this.addressLine5;
    }

    public final String getAddressLine6() {
        return this.addressLine6;
    }

    public final String getBuilding() {
        return this.building;
    }

    public final String getBuildingNumber() {
        return this.buildingNumber;
    }

    public final String getCareOf() {
        return this.careOf;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getCountryIso3Code() {
        return this.countryIso3Code;
    }

    public final String getDistrict() {
        return this.district;
    }

    public final String getFormattedAddress() {
        return this.formattedAddress;
    }

    public final String getLandmark() {
        return this.landmark;
    }

    public final String getLocality() {
        return this.locality;
    }

    public final String getPostOffice() {
        return this.postOffice;
    }

    public final String getPostalCode() {
        return this.postalCode;
    }

    public final String getState() {
        return this.state;
    }

    public final String getStreet() {
        return this.street;
    }

    public final String getSubBuilding() {
        return this.subBuilding;
    }

    public final String getSubdistrict() {
        return this.subdistrict;
    }

    public final String getTownCity() {
        return this.townCity;
    }

    public final String getUdprn() {
        return this.udprn;
    }

    public int hashCode() {
        AddressFormatType addressFormatType = this.addressFormat;
        int iHashCode = (addressFormatType == null ? 0 : addressFormatType.hashCode()) * 31;
        String str = this.careOf;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.subBuilding;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.buildingNumber;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.building;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.street;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.landmark;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.addressLine1;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.addressLine2;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.addressLine3;
        int iHashCode10 = (iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.addressLine4;
        int iHashCode11 = (iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.addressLine5;
        int iHashCode12 = (iHashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.addressLine6;
        int iHashCode13 = (iHashCode12 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.locality;
        int iHashCode14 = (iHashCode13 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.townCity;
        int iHashCode15 = (iHashCode14 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.subdistrict;
        int iHashCode16 = (iHashCode15 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.district;
        int iHashCode17 = (iHashCode16 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.state;
        int iHashCode18 = (iHashCode17 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.postalCode;
        int iHashCode19 = (iHashCode18 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.postOffice;
        int iHashCode20 = (iHashCode19 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.countryIso3Code;
        int iHashCode21 = (iHashCode20 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.country;
        int iHashCode22 = (iHashCode21 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.udprn;
        int iHashCode23 = (iHashCode22 + (str22 == null ? 0 : str22.hashCode())) * 31;
        String str23 = this.formattedAddress;
        return iHashCode23 + (str23 != null ? str23.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Address(addressFormat=");
        sb.append(this.addressFormat).append(", careOf=").append(this.careOf).append(", subBuilding=").append(this.subBuilding).append(", buildingNumber=").append(this.buildingNumber).append(", building=").append(this.building).append(", street=").append(this.street).append(", landmark=").append(this.landmark).append(", addressLine1=").append(this.addressLine1).append(", addressLine2=").append(this.addressLine2).append(", addressLine3=").append(this.addressLine3).append(", addressLine4=").append(this.addressLine4).append(", addressLine5=");
        sb.append(this.addressLine5).append(", addressLine6=").append(this.addressLine6).append(", locality=").append(this.locality).append(", townCity=").append(this.townCity).append(", subdistrict=").append(this.subdistrict).append(", district=").append(this.district).append(", state=").append(this.state).append(", postalCode=").append(this.postalCode).append(", postOffice=").append(this.postOffice).append(", countryIso3Code=").append(this.countryIso3Code).append(", country=").append(this.country).append(", udprn=").append(this.udprn);
        sb.append(", formattedAddress=").append(this.formattedAddress).append(')');
        return sb.toString();
    }

    public /* synthetic */ Address(AddressFormatType addressFormatType, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : addressFormatType, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : str10, (i & 2048) != 0 ? null : str11, (i & 4096) != 0 ? null : str12, (i & 8192) != 0 ? null : str13, (i & 16384) != 0 ? null : str14, (i & 32768) != 0 ? null : str15, (i & 65536) != 0 ? null : str16, (i & 131072) != 0 ? null : str17, (i & 262144) != 0 ? null : str18, (i & 524288) != 0 ? null : str19, (i & 1048576) != 0 ? null : str20, (i & 2097152) != 0 ? null : str21, (i & 4194304) != 0 ? null : str22, (i & 8388608) != 0 ? null : str23);
    }
}
