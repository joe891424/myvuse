package com.microblink.entities.recognizers.blinkid.generic.viz;

import com.microblink.entities.recognizers.blinkid.generic.DriverLicenseDetailedInfo;
import com.microblink.results.date.DateResult;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class VizResult {
    private Object IlIllIlIIl;
    private long llIIlIlIIl;

    public VizResult(long j, Object obj) {
        this.llIIlIlIIl = j;
        this.IlIllIlIIl = obj;
    }

    private static native String additionalAddressInformationNativeGet(long j);

    private static native String additionalNameInformationNativeGet(long j);

    private static native String additionalOptionalAddressInformationNativeGet(long j);

    private static native String additionalPersonalIdNumberNativeGet(long j);

    private static native String addressNativeGet(long j);

    private static native DateResult dateOfBirthNativeGet(long j);

    private static native DateResult dateOfExpiryNativeGet(long j);

    private static native boolean dateOfExpiryPermanentNativeGet(long j);

    private static native DateResult dateOfIssueNativeGet(long j);

    private static native String documentAdditionalNumberNativeGet(long j);

    private static native String documentNumberNativeGet(long j);

    private static native String documentOptionalAdditionalNumberNativeGet(long j);

    private static native DriverLicenseDetailedInfo driverLicenseDetailedInfoNativeGet(long j);

    private static native String employerNativeGet(long j);

    private static native boolean emptyNativeGet(long j);

    private static native String fathersNameNativeGet(long j);

    private static native String firstNameNativeGet(long j);

    private static native String fullNameNativeGet(long j);

    private static native String issuingAuthorityNativeGet(long j);

    private static native String lastNameNativeGet(long j);

    private static native String localizedNameNativeGet(long j);

    private static native String maritalStatusNativeGet(long j);

    private static native String mothersNameNativeGet(long j);

    private static native String nationalityNativeGet(long j);

    private static native String personalIdNumberNativeGet(long j);

    private static native String placeOfBirthNativeGet(long j);

    private static native String professionNativeGet(long j);

    private static native String raceNativeGet(long j);

    private static native String religionNativeGet(long j);

    private static native String residentialStatusNativeGet(long j);

    private static native String sexNativeGet(long j);

    public String getAdditionalAddressInformation() {
        return additionalAddressInformationNativeGet(this.llIIlIlIIl);
    }

    public String getAdditionalNameInformation() {
        return additionalNameInformationNativeGet(this.llIIlIlIIl);
    }

    public String getAdditionalOptionalAddressInformation() {
        return additionalOptionalAddressInformationNativeGet(this.llIIlIlIIl);
    }

    public String getAdditionalPersonalIdNumber() {
        return additionalPersonalIdNumberNativeGet(this.llIIlIlIIl);
    }

    public String getAddress() {
        return addressNativeGet(this.llIIlIlIIl);
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

    public String getDocumentOptionalAdditionalNumber() {
        return documentOptionalAdditionalNumberNativeGet(this.llIIlIlIIl);
    }

    public DriverLicenseDetailedInfo getDriverLicenseDetailedInfo() {
        return driverLicenseDetailedInfoNativeGet(this.llIIlIlIIl);
    }

    public String getEmployer() {
        return employerNativeGet(this.llIIlIlIIl);
    }

    public String getFathersName() {
        return fathersNameNativeGet(this.llIIlIlIIl);
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

    public String getLastName() {
        return lastNameNativeGet(this.llIIlIlIIl);
    }

    public String getLocalizedName() {
        return localizedNameNativeGet(this.llIIlIlIIl);
    }

    public String getMaritalStatus() {
        return maritalStatusNativeGet(this.llIIlIlIIl);
    }

    public String getMothersName() {
        return mothersNameNativeGet(this.llIIlIlIIl);
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

    public String getProfession() {
        return professionNativeGet(this.llIIlIlIIl);
    }

    public String getRace() {
        return raceNativeGet(this.llIIlIlIIl);
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

    public boolean isDateOfExpiryPermanent() {
        return dateOfExpiryPermanentNativeGet(this.llIIlIlIIl);
    }

    public boolean isEmpty() {
        return emptyNativeGet(this.llIIlIlIIl);
    }
}
