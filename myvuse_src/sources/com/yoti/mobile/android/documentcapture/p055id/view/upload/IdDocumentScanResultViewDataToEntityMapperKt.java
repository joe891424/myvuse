package com.yoti.mobile.android.documentcapture.p055id.view.upload;

import com.yoti.mobile.android.documentcapture.p055id.domain.model.AddressEntity;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.DocumentFieldsEntity;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.GenderTypeEntity;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.HolderEntity;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0002\u001a\u00020\u0003*\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001a\u0016\u0010\u0002\u001a\u00020\u0005*\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\u0016\u0010\u0002\u001a\u00020\u0007*\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"LOCALE_LANGUAGE", "", "merge", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/AddressEntity;", "addressEntity", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/DocumentFieldsEntity;", "documentFieldsEntity", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/HolderEntity;", "holderEntity", "documentcapture-id_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IdDocumentScanResultViewDataToEntityMapperKt {
    private static final String LOCALE_LANGUAGE = "en";

    public static final AddressEntity merge(AddressEntity addressEntity, AddressEntity addressEntity2) {
        Intrinsics.checkNotNullParameter(addressEntity2, "addressEntity");
        if (addressEntity == null) {
            return addressEntity2;
        }
        List<String> lines = addressEntity2.getLines();
        if (lines == null) {
            lines = addressEntity.getLines();
        }
        List<String> list = lines;
        String town = addressEntity2.getTown();
        if (town == null) {
            town = addressEntity.getTown();
        }
        String str = town;
        String locality = addressEntity2.getLocality();
        if (locality == null) {
            locality = addressEntity.getLocality();
        }
        String str2 = locality;
        String county = addressEntity2.getCounty();
        if (county == null) {
            county = addressEntity.getCounty();
        }
        String str3 = county;
        String postcode = addressEntity2.getPostcode();
        if (postcode == null) {
            postcode = addressEntity.getPostcode();
        }
        String str4 = postcode;
        AddressEntity.CountryEntity country = addressEntity2.getCountry();
        String careOf = addressEntity2.getCareOf();
        if (careOf == null) {
            careOf = addressEntity.getCareOf();
        }
        String str5 = careOf;
        String landmark = addressEntity2.getLandmark();
        if (landmark == null) {
            landmark = addressEntity.getLandmark();
        }
        String str6 = landmark;
        String district = addressEntity2.getDistrict();
        if (district == null) {
            district = addressEntity.getDistrict();
        }
        String str7 = district;
        String subDistrict = addressEntity2.getSubDistrict();
        if (subDistrict == null) {
            subDistrict = addressEntity.getSubDistrict();
        }
        String str8 = subDistrict;
        String postOffice = addressEntity2.getPostOffice();
        if (postOffice == null) {
            postOffice = addressEntity.getPostOffice();
        }
        String str9 = postOffice;
        String building = addressEntity2.getBuilding();
        if (building == null) {
            building = addressEntity.getBuilding();
        }
        String str10 = building;
        String fullAddress = addressEntity2.getFullAddress();
        if (fullAddress == null) {
            fullAddress = addressEntity.getFullAddress();
        }
        return addressEntity.copy(list, str, str2, str3, str4, country, str5, str6, str7, str8, str9, str10, fullAddress);
    }

    public static final HolderEntity merge(HolderEntity holderEntity, HolderEntity holderEntity2) {
        Intrinsics.checkNotNullParameter(holderEntity2, "holderEntity");
        if (holderEntity == null) {
            return holderEntity2;
        }
        String prefix = holderEntity2.getPrefix();
        if (prefix == null) {
            prefix = holderEntity.getPrefix();
        }
        String str = prefix;
        String firstName = holderEntity2.getFirstName();
        if (firstName == null) {
            firstName = holderEntity.getFirstName();
        }
        String str2 = firstName;
        String givenNames = holderEntity2.getGivenNames();
        if (givenNames == null) {
            givenNames = holderEntity.getGivenNames();
        }
        String str3 = givenNames;
        String middleNames = holderEntity2.getMiddleNames();
        if (middleNames == null) {
            middleNames = holderEntity.getMiddleNames();
        }
        String str4 = middleNames;
        String familyName = holderEntity2.getFamilyName();
        if (familyName == null) {
            familyName = holderEntity.getFamilyName();
        }
        String str5 = familyName;
        String suffix = holderEntity2.getSuffix();
        if (suffix == null) {
            suffix = holderEntity.getSuffix();
        }
        String str6 = suffix;
        String fullName = holderEntity2.getFullName();
        if (fullName == null) {
            fullName = holderEntity.getFullName();
        }
        String str7 = fullName;
        Date dateOfBirth = holderEntity2.getDateOfBirth();
        if (dateOfBirth == null) {
            dateOfBirth = holderEntity.getDateOfBirth();
        }
        Date date = dateOfBirth;
        String placeOfBirth = holderEntity2.getPlaceOfBirth();
        if (placeOfBirth == null) {
            placeOfBirth = holderEntity.getPlaceOfBirth();
        }
        String str8 = placeOfBirth;
        GenderTypeEntity gender = holderEntity2.getGender();
        if (gender == null) {
            gender = holderEntity.getGender();
        }
        GenderTypeEntity genderTypeEntity = gender;
        String nationalityIso3Code = holderEntity2.getNationalityIso3Code();
        if (nationalityIso3Code == null) {
            nationalityIso3Code = holderEntity.getNationalityIso3Code();
        }
        return holderEntity.copy(str, str2, str3, str4, str5, str6, str7, date, str8, genderTypeEntity, nationalityIso3Code);
    }

    public static final DocumentFieldsEntity merge(DocumentFieldsEntity documentFieldsEntity, DocumentFieldsEntity documentFieldsEntity2) {
        Intrinsics.checkNotNullParameter(documentFieldsEntity2, "documentFieldsEntity");
        if (documentFieldsEntity == null) {
            return documentFieldsEntity2;
        }
        HolderEntity holder = documentFieldsEntity2.getHolder();
        if (holder == null) {
            holder = documentFieldsEntity.getHolder();
        }
        HolderEntity holderEntity = holder;
        HolderEntity holderAlias = documentFieldsEntity2.getHolderAlias();
        if (holderAlias == null) {
            holderAlias = documentFieldsEntity.getHolderAlias();
        }
        HolderEntity holderEntity2 = holderAlias;
        AddressEntity address = documentFieldsEntity2.getAddress();
        if (address == null) {
            address = documentFieldsEntity.getAddress();
        }
        AddressEntity addressEntity = address;
        Date issueDate = documentFieldsEntity2.getIssueDate();
        if (issueDate == null) {
            issueDate = documentFieldsEntity.getIssueDate();
        }
        Date date = issueDate;
        Date expiryDate = documentFieldsEntity2.getExpiryDate();
        if (expiryDate == null) {
            expiryDate = documentFieldsEntity.getExpiryDate();
        }
        Date date2 = expiryDate;
        String issuingCountryIso3Code = documentFieldsEntity2.getIssuingCountryIso3Code();
        if (issuingCountryIso3Code == null) {
            issuingCountryIso3Code = documentFieldsEntity.getIssuingCountryIso3Code();
        }
        String str = issuingCountryIso3Code;
        String issuingAuthority = documentFieldsEntity2.getIssuingAuthority();
        if (issuingAuthority == null) {
            issuingAuthority = documentFieldsEntity.getIssuingAuthority();
        }
        String str2 = issuingAuthority;
        String documentNumber = documentFieldsEntity2.getDocumentNumber();
        if (documentNumber == null) {
            documentNumber = documentFieldsEntity.getDocumentNumber();
        }
        String str3 = documentNumber;
        String mrz = documentFieldsEntity2.getMrz();
        if (mrz == null) {
            mrz = documentFieldsEntity.getMrz();
        }
        return documentFieldsEntity.copy(holderEntity, holderEntity2, addressEntity, date, date2, str, str2, str3, mrz);
    }
}
