package com.microblink.entities.recognizers.blinkid.generic.barcode;

import com.microblink.entities.recognizers.blinkbarcode.BarcodeType;
import com.microblink.entities.recognizers.blinkid.generic.DriverLicenseDetailedInfo;
import com.microblink.entities.recognizers.blinkid.idbarcode.BarcodeElements;
import com.microblink.results.date.DateResult;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class BarcodeResult {
    private Object IlIllIlIIl;
    private long llIIlIlIIl;

    public BarcodeResult(long j, Object obj) {
        this.llIIlIlIIl = j;
        this.IlIllIlIIl = obj;
    }

    private static native String additionalNameInformationNativeGet(long j);

    private static native String addressNativeGet(long j);

    private static native int barcodeTypeNativeGet(long j);

    private static native String cityNativeGet(long j);

    private static native DateResult dateOfBirthNativeGet(long j);

    private static native DateResult dateOfExpiryNativeGet(long j);

    private static native DateResult dateOfIssueNativeGet(long j);

    private static native String documentAdditionalNumberNativeGet(long j);

    private static native String documentNumberNativeGet(long j);

    private static native DriverLicenseDetailedInfo driverLicenseDetailedInfoNativeGet(long j);

    private static native String employerNativeGet(long j);

    private static native boolean emptyNativeGet(long j);

    private static native long extendedElementsNativeGet(long j);

    private static native String firstNameNativeGet(long j);

    private static native String fullNameNativeGet(long j);

    private static native String issuingAuthorityNativeGet(long j);

    private static native String jurisdictionNativeGet(long j);

    private static native String lastNameNativeGet(long j);

    private static native String maritalStatusNativeGet(long j);

    private static native String middleNameNativeGet(long j);

    private static native String nationalityNativeGet(long j);

    private static native String personalIdNumberNativeGet(long j);

    private static native String placeOfBirthNativeGet(long j);

    private static native String postalCodeNativeGet(long j);

    private static native String professionNativeGet(long j);

    private static native String raceNativeGet(long j);

    private static native byte[] rawBytesNativeGet(long j);

    private static native String religionNativeGet(long j);

    private static native String residentialStatusNativeGet(long j);

    private static native String sexNativeGet(long j);

    private static native String streetNativeGet(long j);

    private static native String stringDataNativeGet(long j);

    private static native boolean uncertainNativeGet(long j);

    public String getAdditionalNameInformation() {
        return additionalNameInformationNativeGet(this.llIIlIlIIl);
    }

    public String getAddress() {
        return addressNativeGet(this.llIIlIlIIl);
    }

    public BarcodeType getBarcodeType() {
        return BarcodeType.values()[barcodeTypeNativeGet(this.llIIlIlIIl)];
    }

    public String getCity() {
        return cityNativeGet(this.llIIlIlIIl);
    }

    public DateResult getDateOfBirth() {
        return dateOfBirthNativeGet(this.llIIlIlIIl);
    }

    public DateResult getDateOfExpiry() {
        return dateOfExpiryNativeGet(this.llIIlIlIIl);
    }

    public DateResult getDateOfIssue() {
        return dateOfIssueNativeGet(this.llIIlIlIIl);
    }

    public String getDocumentAdditionalNumber() {
        return documentAdditionalNumberNativeGet(this.llIIlIlIIl);
    }

    public String getDocumentNumber() {
        return documentNumberNativeGet(this.llIIlIlIIl);
    }

    public DriverLicenseDetailedInfo getDriverLicenseDetailedInfo() {
        return driverLicenseDetailedInfoNativeGet(this.llIIlIlIIl);
    }

    public String getEmployer() {
        return employerNativeGet(this.llIIlIlIIl);
    }

    public BarcodeElements getExtendedElements() {
        long jExtendedElementsNativeGet = extendedElementsNativeGet(this.llIIlIlIIl);
        if (jExtendedElementsNativeGet != 0) {
            return new BarcodeElements(jExtendedElementsNativeGet, this);
        }
        throw new RuntimeException("Invalid native context for extendedElements");
    }

    public String getFirstName() {
        return firstNameNativeGet(this.llIIlIlIIl);
    }

    public String getFullName() {
        return fullNameNativeGet(this.llIIlIlIIl);
    }

    public String getIssuingAuthority() {
        return issuingAuthorityNativeGet(this.llIIlIlIIl);
    }

    public String getJurisdiction() {
        return jurisdictionNativeGet(this.llIIlIlIIl);
    }

    public String getLastName() {
        return lastNameNativeGet(this.llIIlIlIIl);
    }

    public String getMaritalStatus() {
        return maritalStatusNativeGet(this.llIIlIlIIl);
    }

    public String getMiddleName() {
        return middleNameNativeGet(this.llIIlIlIIl);
    }

    public String getNationality() {
        return nationalityNativeGet(this.llIIlIlIIl);
    }

    public String getPersonalIdNumber() {
        return personalIdNumberNativeGet(this.llIIlIlIIl);
    }

    public String getPlaceOfBirth() {
        return placeOfBirthNativeGet(this.llIIlIlIIl);
    }

    public String getPostalCode() {
        return postalCodeNativeGet(this.llIIlIlIIl);
    }

    public String getProfession() {
        return professionNativeGet(this.llIIlIlIIl);
    }

    public String getRace() {
        return raceNativeGet(this.llIIlIlIIl);
    }

    public byte[] getRawData() {
        return rawBytesNativeGet(this.llIIlIlIIl);
    }

    public String getReligion() {
        return religionNativeGet(this.llIIlIlIIl);
    }

    public String getResidentialStatus() {
        return residentialStatusNativeGet(this.llIIlIlIIl);
    }

    public String getSex() {
        return sexNativeGet(this.llIIlIlIIl);
    }

    public String getStreet() {
        return streetNativeGet(this.llIIlIlIIl);
    }

    public String getStringData() {
        return stringDataNativeGet(this.llIIlIlIIl);
    }

    public boolean isEmpty() {
        return emptyNativeGet(this.llIIlIlIIl);
    }

    public boolean isUncertain() {
        return uncertainNativeGet(this.llIIlIlIIl);
    }
}
