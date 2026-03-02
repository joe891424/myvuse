package com.yoti.mobile.android.yotisdkcore.applicant_profile.data.model;

import androidx.autofill.HintConstants;
import com.google.gson.annotations.SerializedName;
import com.yoti.mobile.android.documentscan.domain.p059a.aadhaar.AadhaarAddressFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\bL\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001cJ\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J£\u0002\u0010P\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010T\u001a\u00020UHÖ\u0001J\t\u0010V\u001a\u00020\u0005HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u0016\u0010\u001a\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u0016\u0010\u0019\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010!R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010!R\u0016\u0010\u001b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010!R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010!R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010!R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010!R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010!R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010!R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010!R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010!R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010!¨\u0006W"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/model/StructuredPostalAddress;", "", "_addressFormat", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/model/AddressFormat;", "udprn", "", "careOf", "subBuilding", "buildingNumber", "building", AadhaarAddressFormatter.ATTR_STREET, "landmark", "addressLine1", "addressLine2", "addressLine3", "addressLine4", "addressLine5", "addressLine6", "locality", "townCity", "subdistrict", "district", "state", HintConstants.AUTOFILL_HINT_POSTAL_CODE, "postOffice", "countryIso", "country", "formattedAddress", "(Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/model/AddressFormat;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "addressFormat", "getAddressFormat", "()Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/model/AddressFormat;", "getAddressLine1", "()Ljava/lang/String;", "getAddressLine2", "getAddressLine3", "getAddressLine4", "getAddressLine5", "getAddressLine6", "getBuilding", "getBuildingNumber", "getCareOf", "getCountry", "getCountryIso", "getDistrict", "getFormattedAddress", "getLandmark", "getLocality", "getPostOffice", "getPostalCode", "getState", "getStreet", "getSubBuilding", "getSubdistrict", "getTownCity", "getUdprn", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class StructuredPostalAddress {

    @SerializedName("address_format")
    private final AddressFormat _addressFormat;

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
    private final String countryIso;

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

    public StructuredPostalAddress(AddressFormat addressFormat, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String countryIso, String country, String formattedAddress) {
        Intrinsics.checkNotNullParameter(countryIso, "countryIso");
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(formattedAddress, "formattedAddress");
        this._addressFormat = addressFormat;
        this.udprn = str;
        this.careOf = str2;
        this.subBuilding = str3;
        this.buildingNumber = str4;
        this.building = str5;
        this.street = str6;
        this.landmark = str7;
        this.addressLine1 = str8;
        this.addressLine2 = str9;
        this.addressLine3 = str10;
        this.addressLine4 = str11;
        this.addressLine5 = str12;
        this.addressLine6 = str13;
        this.locality = str14;
        this.townCity = str15;
        this.subdistrict = str16;
        this.district = str17;
        this.state = str18;
        this.postalCode = str19;
        this.postOffice = str20;
        this.countryIso = countryIso;
        this.country = country;
        this.formattedAddress = formattedAddress;
    }

    public /* synthetic */ StructuredPostalAddress(AddressFormat addressFormat, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(addressFormat, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : str10, (i & 2048) != 0 ? null : str11, (i & 4096) != 0 ? null : str12, (i & 8192) != 0 ? null : str13, (i & 16384) != 0 ? null : str14, (32768 & i) != 0 ? null : str15, (65536 & i) != 0 ? null : str16, (131072 & i) != 0 ? null : str17, (262144 & i) != 0 ? null : str18, (524288 & i) != 0 ? null : str19, (i & 1048576) != 0 ? null : str20, str21, str22, str23);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final AddressFormat get_addressFormat() {
        return this._addressFormat;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getAddressLine2() {
        return this.addressLine2;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getAddressLine3() {
        return this.addressLine3;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getAddressLine4() {
        return this.addressLine4;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getAddressLine5() {
        return this.addressLine5;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getAddressLine6() {
        return this.addressLine6;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getLocality() {
        return this.locality;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getTownCity() {
        return this.townCity;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getSubdistrict() {
        return this.subdistrict;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getDistrict() {
        return this.district;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUdprn() {
        return this.udprn;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getPostalCode() {
        return this.postalCode;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getPostOffice() {
        return this.postOffice;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getCountryIso() {
        return this.countryIso;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getFormattedAddress() {
        return this.formattedAddress;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCareOf() {
        return this.careOf;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSubBuilding() {
        return this.subBuilding;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBuildingNumber() {
        return this.buildingNumber;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getBuilding() {
        return this.building;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getStreet() {
        return this.street;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getLandmark() {
        return this.landmark;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getAddressLine1() {
        return this.addressLine1;
    }

    public final StructuredPostalAddress copy(AddressFormat _addressFormat, String udprn, String careOf, String subBuilding, String buildingNumber, String building, String street, String landmark, String addressLine1, String addressLine2, String addressLine3, String addressLine4, String addressLine5, String addressLine6, String locality, String townCity, String subdistrict, String district, String state, String postalCode, String postOffice, String countryIso, String country, String formattedAddress) {
        Intrinsics.checkNotNullParameter(countryIso, "countryIso");
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(formattedAddress, "formattedAddress");
        return new StructuredPostalAddress(_addressFormat, udprn, careOf, subBuilding, buildingNumber, building, street, landmark, addressLine1, addressLine2, addressLine3, addressLine4, addressLine5, addressLine6, locality, townCity, subdistrict, district, state, postalCode, postOffice, countryIso, country, formattedAddress);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StructuredPostalAddress)) {
            return false;
        }
        StructuredPostalAddress structuredPostalAddress = (StructuredPostalAddress) other;
        return this._addressFormat == structuredPostalAddress._addressFormat && Intrinsics.areEqual(this.udprn, structuredPostalAddress.udprn) && Intrinsics.areEqual(this.careOf, structuredPostalAddress.careOf) && Intrinsics.areEqual(this.subBuilding, structuredPostalAddress.subBuilding) && Intrinsics.areEqual(this.buildingNumber, structuredPostalAddress.buildingNumber) && Intrinsics.areEqual(this.building, structuredPostalAddress.building) && Intrinsics.areEqual(this.street, structuredPostalAddress.street) && Intrinsics.areEqual(this.landmark, structuredPostalAddress.landmark) && Intrinsics.areEqual(this.addressLine1, structuredPostalAddress.addressLine1) && Intrinsics.areEqual(this.addressLine2, structuredPostalAddress.addressLine2) && Intrinsics.areEqual(this.addressLine3, structuredPostalAddress.addressLine3) && Intrinsics.areEqual(this.addressLine4, structuredPostalAddress.addressLine4) && Intrinsics.areEqual(this.addressLine5, structuredPostalAddress.addressLine5) && Intrinsics.areEqual(this.addressLine6, structuredPostalAddress.addressLine6) && Intrinsics.areEqual(this.locality, structuredPostalAddress.locality) && Intrinsics.areEqual(this.townCity, structuredPostalAddress.townCity) && Intrinsics.areEqual(this.subdistrict, structuredPostalAddress.subdistrict) && Intrinsics.areEqual(this.district, structuredPostalAddress.district) && Intrinsics.areEqual(this.state, structuredPostalAddress.state) && Intrinsics.areEqual(this.postalCode, structuredPostalAddress.postalCode) && Intrinsics.areEqual(this.postOffice, structuredPostalAddress.postOffice) && Intrinsics.areEqual(this.countryIso, structuredPostalAddress.countryIso) && Intrinsics.areEqual(this.country, structuredPostalAddress.country) && Intrinsics.areEqual(this.formattedAddress, structuredPostalAddress.formattedAddress);
    }

    public final AddressFormat getAddressFormat() {
        AddressFormat addressFormat = this._addressFormat;
        return addressFormat == null ? AddressFormat.UNKNOWN : addressFormat;
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

    public final String getCountryIso() {
        return this.countryIso;
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
        AddressFormat addressFormat = this._addressFormat;
        int iHashCode = (addressFormat == null ? 0 : addressFormat.hashCode()) * 31;
        String str = this.udprn;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.careOf;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subBuilding;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.buildingNumber;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.building;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.street;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.landmark;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.addressLine1;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.addressLine2;
        int iHashCode10 = (iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.addressLine3;
        int iHashCode11 = (iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.addressLine4;
        int iHashCode12 = (iHashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.addressLine5;
        int iHashCode13 = (iHashCode12 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.addressLine6;
        int iHashCode14 = (iHashCode13 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.locality;
        int iHashCode15 = (iHashCode14 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.townCity;
        int iHashCode16 = (iHashCode15 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.subdistrict;
        int iHashCode17 = (iHashCode16 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.district;
        int iHashCode18 = (iHashCode17 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.state;
        int iHashCode19 = (iHashCode18 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.postalCode;
        int iHashCode20 = (iHashCode19 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.postOffice;
        return ((((((iHashCode20 + (str20 != null ? str20.hashCode() : 0)) * 31) + this.countryIso.hashCode()) * 31) + this.country.hashCode()) * 31) + this.formattedAddress.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StructuredPostalAddress(_addressFormat=");
        sb.append(this._addressFormat).append(", udprn=").append(this.udprn).append(", careOf=").append(this.careOf).append(", subBuilding=").append(this.subBuilding).append(", buildingNumber=").append(this.buildingNumber).append(", building=").append(this.building).append(", street=").append(this.street).append(", landmark=").append(this.landmark).append(", addressLine1=").append(this.addressLine1).append(", addressLine2=").append(this.addressLine2).append(", addressLine3=").append(this.addressLine3).append(", addressLine4=");
        sb.append(this.addressLine4).append(", addressLine5=").append(this.addressLine5).append(", addressLine6=").append(this.addressLine6).append(", locality=").append(this.locality).append(", townCity=").append(this.townCity).append(", subdistrict=").append(this.subdistrict).append(", district=").append(this.district).append(", state=").append(this.state).append(", postalCode=").append(this.postalCode).append(", postOffice=").append(this.postOffice).append(", countryIso=").append(this.countryIso).append(", country=").append(this.country);
        sb.append(", formattedAddress=").append(this.formattedAddress).append(')');
        return sb.toString();
    }
}
