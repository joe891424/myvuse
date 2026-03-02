package com.yoti.mobile.android.documentcapture.p055id.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001:\u00017B£\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0012J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J©\u0001\u00100\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u00068"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/domain/model/AddressEntity;", "", "lines", "", "", "town", "locality", "county", "postcode", "country", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/AddressEntity$CountryEntity;", "careOf", "landmark", "district", "subDistrict", "postOffice", "building", "fullAddress", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/yoti/mobile/android/documentcapture/id/domain/model/AddressEntity$CountryEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBuilding", "()Ljava/lang/String;", "getCareOf", "getCountry", "()Lcom/yoti/mobile/android/documentcapture/id/domain/model/AddressEntity$CountryEntity;", "getCounty", "getDistrict", "getFullAddress", "getLandmark", "getLines", "()Ljava/util/List;", "getLocality", "getPostOffice", "getPostcode", "getSubDistrict", "getTown", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "CountryEntity", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class AddressEntity {
    private final String building;
    private final String careOf;
    private final CountryEntity country;
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

    public AddressEntity(List<String> list, String str, String str2, String str3, String str4, CountryEntity country, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        Intrinsics.checkNotNullParameter(country, "country");
        this.lines = list;
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
    public final CountryEntity getCountry() {
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

    public final AddressEntity copy(List<String> lines, String town, String locality, String county, String postcode, CountryEntity country, String careOf, String landmark, String district, String subDistrict, String postOffice, String building, String fullAddress) {
        Intrinsics.checkNotNullParameter(country, "country");
        return new AddressEntity(lines, town, locality, county, postcode, country, careOf, landmark, district, subDistrict, postOffice, building, fullAddress);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddressEntity)) {
            return false;
        }
        AddressEntity addressEntity = (AddressEntity) other;
        return Intrinsics.areEqual(this.lines, addressEntity.lines) && Intrinsics.areEqual(this.town, addressEntity.town) && Intrinsics.areEqual(this.locality, addressEntity.locality) && Intrinsics.areEqual(this.county, addressEntity.county) && Intrinsics.areEqual(this.postcode, addressEntity.postcode) && Intrinsics.areEqual(this.country, addressEntity.country) && Intrinsics.areEqual(this.careOf, addressEntity.careOf) && Intrinsics.areEqual(this.landmark, addressEntity.landmark) && Intrinsics.areEqual(this.district, addressEntity.district) && Intrinsics.areEqual(this.subDistrict, addressEntity.subDistrict) && Intrinsics.areEqual(this.postOffice, addressEntity.postOffice) && Intrinsics.areEqual(this.building, addressEntity.building) && Intrinsics.areEqual(this.fullAddress, addressEntity.fullAddress);
    }

    public final String getBuilding() {
        return this.building;
    }

    public final String getCareOf() {
        return this.careOf;
    }

    public final CountryEntity getCountry() {
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
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.town;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.locality;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.county;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.postcode;
        int iHashCode5 = (((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.country.hashCode()) * 31;
        String str5 = this.careOf;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.landmark;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.district;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.subDistrict;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.postOffice;
        int iHashCode10 = (iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.building;
        int iHashCode11 = (iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.fullAddress;
        return iHashCode11 + (str11 != null ? str11.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AddressEntity(lines=");
        sb.append(this.lines).append(", town=").append(this.town).append(", locality=").append(this.locality).append(", county=").append(this.county).append(", postcode=").append(this.postcode).append(", country=").append(this.country).append(", careOf=").append(this.careOf).append(", landmark=").append(this.landmark).append(", district=").append(this.district).append(", subDistrict=").append(this.subDistrict).append(", postOffice=").append(this.postOffice).append(", building=");
        sb.append(this.building).append(", fullAddress=").append(this.fullAddress).append(')');
        return sb.toString();
    }

    @Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/domain/model/AddressEntity$CountryEntity;", "", "name", "", "iso3Code", "iso2Code", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIso2Code", "()Ljava/lang/String;", "getIso3Code", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class CountryEntity {
        private final String iso2Code;
        private final String iso3Code;
        private final String name;

        public CountryEntity(String name, String iso3Code, String str) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(iso3Code, "iso3Code");
            this.name = name;
            this.iso3Code = iso3Code;
            this.iso2Code = str;
        }

        public static /* synthetic */ CountryEntity copy$default(CountryEntity countryEntity, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = countryEntity.name;
            }
            if ((i & 2) != 0) {
                str2 = countryEntity.iso3Code;
            }
            if ((i & 4) != 0) {
                str3 = countryEntity.iso2Code;
            }
            return countryEntity.copy(str, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getIso3Code() {
            return this.iso3Code;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getIso2Code() {
            return this.iso2Code;
        }

        public final CountryEntity copy(String name, String iso3Code, String iso2Code) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(iso3Code, "iso3Code");
            return new CountryEntity(name, iso3Code, iso2Code);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CountryEntity)) {
                return false;
            }
            CountryEntity countryEntity = (CountryEntity) other;
            return Intrinsics.areEqual(this.name, countryEntity.name) && Intrinsics.areEqual(this.iso3Code, countryEntity.iso3Code) && Intrinsics.areEqual(this.iso2Code, countryEntity.iso2Code);
        }

        public final String getIso2Code() {
            return this.iso2Code;
        }

        public final String getIso3Code() {
            return this.iso3Code;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            int iHashCode = ((this.name.hashCode() * 31) + this.iso3Code.hashCode()) * 31;
            String str = this.iso2Code;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "CountryEntity(name=" + this.name + ", iso3Code=" + this.iso3Code + ", iso2Code=" + this.iso2Code + ')';
        }

        public /* synthetic */ CountryEntity(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : str3);
        }
    }

    public /* synthetic */ AddressEntity(List list, String str, String str2, String str3, String str4, CountryEntity countryEntity, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, countryEntity, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : str9, (i & 2048) != 0 ? null : str10, (i & 4096) != 0 ? null : str11);
    }
}
