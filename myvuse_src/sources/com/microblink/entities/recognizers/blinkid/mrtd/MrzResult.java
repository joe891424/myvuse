package com.microblink.entities.recognizers.blinkid.mrtd;

import com.microblink.entities.recognizers.blinkid.AgeLimitStatus;
import com.microblink.results.date.Date;
import com.microblink.results.date.DateResult;
import com.microblink.results.date.DateUtils;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class MrzResult {
    private Object IlIllIlIIl;
    private long llIIlIlIIl;

    public MrzResult(long j, Object obj) {
        this.llIIlIlIIl = j;
        this.IlIllIlIIl = obj;
    }

    private static native String alienNumberNativeGet(long j);

    private static native String applicationReceiptNumberNativeGet(long j);

    private static native DateResult dateOfBirthNativeGet(long j);

    private static native DateResult dateOfExpiryNativeGet(long j);

    private static native String documentCodeNativeGet(long j);

    private static native String documentNumberNativeGet(long j);

    private static native int documentTypeNativeGet(long j);

    private static native String genderNativeGet(long j);

    private static native String immigrantCaseNumberNativeGet(long j);

    private static native String issuerNameNativeGet(long j);

    private static native String issuerNativeGet(long j);

    private static native String nationalityNameNativeGet(long j);

    private static native String nationalityNativeGet(long j);

    private static native String opt1NativeGet(long j);

    private static native String opt2NativeGet(long j);

    private static native boolean parsedNativeGet(long j);

    private static native String primaryIDNativeGet(long j);

    private static native String rawMRZStringNativeGet(long j);

    private static native String sanitizedDocumentCodeNativeGet(long j);

    private static native String sanitizedDocumentNumberNativeGet(long j);

    private static native String sanitizedIssuerNativeGet(long j);

    private static native String sanitizedNationalityNativeGet(long j);

    private static native String sanitizedOpt1NativeGet(long j);

    private static native String sanitizedOpt2NativeGet(long j);

    private static native String secondaryIDNativeGet(long j);

    private static native boolean verifiedNativeGet(long j);

    public int getAge() {
        Date date = getDateOfBirth().getDate();
        if (date == null) {
            return -1;
        }
        return DateUtils.yearsPassedFrom(date);
    }

    public AgeLimitStatus getAgeLimitStatus(int i) {
        int age = getAge();
        return age == -1 ? AgeLimitStatus.NotAvailable : age >= i ? AgeLimitStatus.OverAgeLimit : AgeLimitStatus.BelowAgeLimit;
    }

    public String getAlienNumber() {
        return alienNumberNativeGet(this.llIIlIlIIl);
    }

    public String getApplicationReceiptNumber() {
        return applicationReceiptNumberNativeGet(this.llIIlIlIIl);
    }

    public DateResult getDateOfBirth() {
        return dateOfBirthNativeGet(this.llIIlIlIIl);
    }

    public DateResult getDateOfExpiry() {
        return dateOfExpiryNativeGet(this.llIIlIlIIl);
    }

    public String getDocumentCode() {
        return documentCodeNativeGet(this.llIIlIlIIl);
    }

    public String getDocumentNumber() {
        return documentNumberNativeGet(this.llIIlIlIIl);
    }

    public MrtdDocumentType getDocumentType() {
        return MrtdDocumentType.values()[documentTypeNativeGet(this.llIIlIlIIl)];
    }

    public String getGender() {
        return genderNativeGet(this.llIIlIlIIl);
    }

    public String getImmigrantCaseNumber() {
        return immigrantCaseNumberNativeGet(this.llIIlIlIIl);
    }

    public String getIssuer() {
        return issuerNativeGet(this.llIIlIlIIl);
    }

    public String getIssuerName() {
        return issuerNameNativeGet(this.llIIlIlIIl);
    }

    public String getMrzText() {
        return rawMRZStringNativeGet(this.llIIlIlIIl);
    }

    public String getNationality() {
        return nationalityNativeGet(this.llIIlIlIIl);
    }

    public String getNationalityName() {
        return nationalityNameNativeGet(this.llIIlIlIIl);
    }

    public String getOpt1() {
        return opt1NativeGet(this.llIIlIlIIl);
    }

    public String getOpt2() {
        return opt2NativeGet(this.llIIlIlIIl);
    }

    public String getPrimaryId() {
        return primaryIDNativeGet(this.llIIlIlIIl);
    }

    public String getSanitizedDocumentCode() {
        return sanitizedDocumentCodeNativeGet(this.llIIlIlIIl);
    }

    public String getSanitizedDocumentNumber() {
        return sanitizedDocumentNumberNativeGet(this.llIIlIlIIl);
    }

    public String getSanitizedIssuer() {
        return sanitizedIssuerNativeGet(this.llIIlIlIIl);
    }

    public String getSanitizedNationality() {
        return sanitizedNationalityNativeGet(this.llIIlIlIIl);
    }

    public String getSanitizedOpt1() {
        return sanitizedOpt1NativeGet(this.llIIlIlIIl);
    }

    public String getSanitizedOpt2() {
        return sanitizedOpt2NativeGet(this.llIIlIlIIl);
    }

    public String getSecondaryId() {
        return secondaryIDNativeGet(this.llIIlIlIIl);
    }

    public boolean isMrzParsed() {
        return parsedNativeGet(this.llIIlIlIIl);
    }

    public boolean isMrzVerified() {
        return verifiedNativeGet(this.llIIlIlIIl);
    }
}
