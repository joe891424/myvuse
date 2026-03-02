package com.yoti.mobile.android.yotisdkcore.applicant_profile.domain.model;

import androidx.autofill.HintConstants;
import com.yoti.mobile.android.documentscan.domain.p059a.aadhaar.AadhaarAddressFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J·\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0005HÆ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u000209HÖ\u0001J\t\u0010:\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017¨\u0006;"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/StructuredPostalAddressEntity;", "", "addressFormat", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/AddressFormatEntity;", "subBuilding", "", "buildingNumber", "building", AadhaarAddressFormatter.ATTR_STREET, "addressLine1", "addressLine2", "addressLine3", "addressLine4", "addressLine5", "townCity", "state", HintConstants.AUTOFILL_HINT_POSTAL_CODE, "country", "formattedAddress", "(Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/AddressFormatEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddressFormat", "()Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/AddressFormatEntity;", "getAddressLine1", "()Ljava/lang/String;", "getAddressLine2", "getAddressLine3", "getAddressLine4", "getAddressLine5", "getBuilding", "getBuildingNumber", "getCountry", "getFormattedAddress", "getPostalCode", "getState", "getStreet", "getSubBuilding", "getTownCity", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class StructuredPostalAddressEntity {
    private final AddressFormatEntity addressFormat;
    private final String addressLine1;
    private final String addressLine2;
    private final String addressLine3;
    private final String addressLine4;
    private final String addressLine5;
    private final String building;
    private final String buildingNumber;
    private final String country;
    private final String formattedAddress;
    private final String postalCode;
    private final String state;
    private final String street;
    private final String subBuilding;
    private final String townCity;

    public StructuredPostalAddressEntity(AddressFormatEntity addressFormat, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String country, String formattedAddress) {
        Intrinsics.checkNotNullParameter(addressFormat, "addressFormat");
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(formattedAddress, "formattedAddress");
        this.addressFormat = addressFormat;
        this.subBuilding = str;
        this.buildingNumber = str2;
        this.building = str3;
        this.street = str4;
        this.addressLine1 = str5;
        this.addressLine2 = str6;
        this.addressLine3 = str7;
        this.addressLine4 = str8;
        this.addressLine5 = str9;
        this.townCity = str10;
        this.state = str11;
        this.postalCode = str12;
        this.country = country;
        this.formattedAddress = formattedAddress;
    }

    public /* synthetic */ StructuredPostalAddressEntity(AddressFormatEntity addressFormatEntity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(addressFormatEntity, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : str10, (i & 2048) != 0 ? null : str11, (i & 4096) != 0 ? null : str12, str13, str14);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AddressFormatEntity getAddressFormat() {
        return this.addressFormat;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getAddressLine5() {
        return this.addressLine5;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getTownCity() {
        return this.townCity;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getPostalCode() {
        return this.postalCode;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getFormattedAddress() {
        return this.formattedAddress;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubBuilding() {
        return this.subBuilding;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBuildingNumber() {
        return this.buildingNumber;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBuilding() {
        return this.building;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStreet() {
        return this.street;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAddressLine1() {
        return this.addressLine1;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getAddressLine2() {
        return this.addressLine2;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getAddressLine3() {
        return this.addressLine3;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getAddressLine4() {
        return this.addressLine4;
    }

    public final StructuredPostalAddressEntity copy(AddressFormatEntity addressFormat, String subBuilding, String buildingNumber, String building, String street, String addressLine1, String addressLine2, String addressLine3, String addressLine4, String addressLine5, String townCity, String state, String postalCode, String country, String formattedAddress) {
        Intrinsics.checkNotNullParameter(addressFormat, "addressFormat");
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(formattedAddress, "formattedAddress");
        return new StructuredPostalAddressEntity(addressFormat, subBuilding, buildingNumber, building, street, addressLine1, addressLine2, addressLine3, addressLine4, addressLine5, townCity, state, postalCode, country, formattedAddress);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StructuredPostalAddressEntity)) {
            return false;
        }
        StructuredPostalAddressEntity structuredPostalAddressEntity = (StructuredPostalAddressEntity) other;
        return this.addressFormat == structuredPostalAddressEntity.addressFormat && Intrinsics.areEqual(this.subBuilding, structuredPostalAddressEntity.subBuilding) && Intrinsics.areEqual(this.buildingNumber, structuredPostalAddressEntity.buildingNumber) && Intrinsics.areEqual(this.building, structuredPostalAddressEntity.building) && Intrinsics.areEqual(this.street, structuredPostalAddressEntity.street) && Intrinsics.areEqual(this.addressLine1, structuredPostalAddressEntity.addressLine1) && Intrinsics.areEqual(this.addressLine2, structuredPostalAddressEntity.addressLine2) && Intrinsics.areEqual(this.addressLine3, structuredPostalAddressEntity.addressLine3) && Intrinsics.areEqual(this.addressLine4, structuredPostalAddressEntity.addressLine4) && Intrinsics.areEqual(this.addressLine5, structuredPostalAddressEntity.addressLine5) && Intrinsics.areEqual(this.townCity, structuredPostalAddressEntity.townCity) && Intrinsics.areEqual(this.state, structuredPostalAddressEntity.state) && Intrinsics.areEqual(this.postalCode, structuredPostalAddressEntity.postalCode) && Intrinsics.areEqual(this.country, structuredPostalAddressEntity.country) && Intrinsics.areEqual(this.formattedAddress, structuredPostalAddressEntity.formattedAddress);
    }

    public final AddressFormatEntity getAddressFormat() {
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

    public final String getBuilding() {
        return this.building;
    }

    public final String getBuildingNumber() {
        return this.buildingNumber;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getFormattedAddress() {
        return this.formattedAddress;
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

    public final String getTownCity() {
        return this.townCity;
    }

    public int hashCode() {
        int iHashCode = this.addressFormat.hashCode() * 31;
        String str = this.subBuilding;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.buildingNumber;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.building;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.street;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.addressLine1;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.addressLine2;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.addressLine3;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.addressLine4;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.addressLine5;
        int iHashCode10 = (iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.townCity;
        int iHashCode11 = (iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.state;
        int iHashCode12 = (iHashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.postalCode;
        return ((((iHashCode12 + (str12 != null ? str12.hashCode() : 0)) * 31) + this.country.hashCode()) * 31) + this.formattedAddress.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StructuredPostalAddressEntity(addressFormat=");
        sb.append(this.addressFormat).append(", subBuilding=").append(this.subBuilding).append(", buildingNumber=").append(this.buildingNumber).append(", building=").append(this.building).append(", street=").append(this.street).append(", addressLine1=").append(this.addressLine1).append(", addressLine2=").append(this.addressLine2).append(", addressLine3=").append(this.addressLine3).append(", addressLine4=").append(this.addressLine4).append(", addressLine5=").append(this.addressLine5).append(", townCity=").append(this.townCity).append(", state=");
        sb.append(this.state).append(", postalCode=").append(this.postalCode).append(", country=").append(this.country).append(", formattedAddress=").append(this.formattedAddress).append(')');
        return sb.toString();
    }
}
