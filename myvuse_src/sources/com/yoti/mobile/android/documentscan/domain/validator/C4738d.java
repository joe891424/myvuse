package com.yoti.mobile.android.documentscan.domain.validator;

import com.yoti.mobile.android.documentscan.domain.validator.UKDrivingLicenceValidator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.domain.validator.d */
/* JADX INFO: loaded from: classes5.dex */
public final class C4738d {

    /* JADX INFO: renamed from: a */
    private final UKDrivingLicenceValidator.Issuer f6953a;

    /* JADX INFO: renamed from: b */
    private final String f6954b;

    /* JADX INFO: renamed from: c */
    private final String f6955c;

    /* JADX INFO: renamed from: d */
    private final String f6956d;

    /* JADX INFO: renamed from: e */
    private final String f6957e;

    /* JADX INFO: renamed from: f */
    private final int f6958f;

    /* JADX INFO: renamed from: g */
    private final int f6959g;

    /* JADX INFO: renamed from: h */
    private final int f6960h;

    public C4738d(UKDrivingLicenceValidator.Issuer issuer, String documentNumber, String givenNames, String familyName, String firstName, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(issuer, "issuer");
        Intrinsics.checkParameterIsNotNull(documentNumber, "documentNumber");
        Intrinsics.checkParameterIsNotNull(givenNames, "givenNames");
        Intrinsics.checkParameterIsNotNull(familyName, "familyName");
        Intrinsics.checkParameterIsNotNull(firstName, "firstName");
        this.f6953a = issuer;
        this.f6954b = documentNumber;
        this.f6955c = givenNames;
        this.f6956d = familyName;
        this.f6957e = firstName;
        this.f6958f = i;
        this.f6959g = i2;
        this.f6960h = i3;
    }

    /* JADX INFO: renamed from: a */
    public final int m4880a() {
        return this.f6960h;
    }

    /* JADX INFO: renamed from: b */
    public final String m4881b() {
        return this.f6954b;
    }

    /* JADX INFO: renamed from: c */
    public final String m4882c() {
        return this.f6956d;
    }

    /* JADX INFO: renamed from: d */
    public final String m4883d() {
        return this.f6957e;
    }

    /* JADX INFO: renamed from: e */
    public final String m4884e() {
        return this.f6955c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4738d)) {
            return false;
        }
        C4738d c4738d = (C4738d) obj;
        return Intrinsics.areEqual(this.f6953a, c4738d.f6953a) && Intrinsics.areEqual(this.f6954b, c4738d.f6954b) && Intrinsics.areEqual(this.f6955c, c4738d.f6955c) && Intrinsics.areEqual(this.f6956d, c4738d.f6956d) && Intrinsics.areEqual(this.f6957e, c4738d.f6957e) && this.f6958f == c4738d.f6958f && this.f6959g == c4738d.f6959g && this.f6960h == c4738d.f6960h;
    }

    /* JADX INFO: renamed from: f */
    public final UKDrivingLicenceValidator.Issuer m4885f() {
        return this.f6953a;
    }

    /* JADX INFO: renamed from: g */
    public final int m4886g() {
        return this.f6959g;
    }

    /* JADX INFO: renamed from: h */
    public final int m4887h() {
        return this.f6958f;
    }

    public int hashCode() {
        UKDrivingLicenceValidator.Issuer issuer = this.f6953a;
        int iHashCode = (issuer != null ? issuer.hashCode() : 0) * 31;
        String str = this.f6954b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f6955c;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f6956d;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f6957e;
        return ((((((iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + Integer.hashCode(this.f6958f)) * 31) + Integer.hashCode(this.f6959g)) * 31) + Integer.hashCode(this.f6960h);
    }

    public String toString() {
        return "UKDrivingLicence(issuer=" + this.f6953a + ", documentNumber=" + this.f6954b + ", givenNames=" + this.f6955c + ", familyName=" + this.f6956d + ", firstName=" + this.f6957e + ", yearOfBirth=" + this.f6958f + ", monthOfBirth=" + this.f6959g + ", dayOfBirth=" + this.f6960h + ")";
    }
}
