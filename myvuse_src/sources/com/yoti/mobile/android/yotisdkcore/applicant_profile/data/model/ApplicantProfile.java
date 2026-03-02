package com.yoti.mobile.android.yotisdkcore.applicant_profile.data.model;

import com.google.gson.annotations.SerializedName;
import com.microblink.entities.recognizers.blinkid.usdl.UsdlCombinedRecognizer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JW\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/model/ApplicantProfile;", "", "fullName", "", "dateOfBirth", "givenNames", "firstName", UsdlCombinedRecognizer.VerificationConstants.MiddleName, "familyName", "structuredPostalAddress", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/model/StructuredPostalAddress;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/model/StructuredPostalAddress;)V", "getDateOfBirth", "()Ljava/lang/String;", "getFamilyName", "getFirstName", "getFullName", "getGivenNames", "getMiddleName", "getStructuredPostalAddress", "()Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/model/StructuredPostalAddress;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class ApplicantProfile {

    @SerializedName("date_of_birth")
    private final String dateOfBirth;

    @SerializedName("family_name")
    private final String familyName;

    @SerializedName("first_name")
    private final String firstName;

    @SerializedName("full_name")
    private final String fullName;

    @SerializedName("given_names")
    private final String givenNames;

    @SerializedName("middle_name")
    private final String middleName;

    @SerializedName("structured_postal_address")
    private final StructuredPostalAddress structuredPostalAddress;

    public ApplicantProfile(String fullName, String dateOfBirth, String str, String str2, String str3, String str4, StructuredPostalAddress structuredPostalAddress) {
        Intrinsics.checkNotNullParameter(fullName, "fullName");
        Intrinsics.checkNotNullParameter(dateOfBirth, "dateOfBirth");
        Intrinsics.checkNotNullParameter(structuredPostalAddress, "structuredPostalAddress");
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.givenNames = str;
        this.firstName = str2;
        this.middleName = str3;
        this.familyName = str4;
        this.structuredPostalAddress = structuredPostalAddress;
    }

    public /* synthetic */ ApplicantProfile(String str, String str2, String str3, String str4, String str5, String str6, StructuredPostalAddress structuredPostalAddress, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, structuredPostalAddress);
    }

    public static /* synthetic */ ApplicantProfile copy$default(ApplicantProfile applicantProfile, String str, String str2, String str3, String str4, String str5, String str6, StructuredPostalAddress structuredPostalAddress, int i, Object obj) {
        if ((i & 1) != 0) {
            str = applicantProfile.fullName;
        }
        if ((i & 2) != 0) {
            str2 = applicantProfile.dateOfBirth;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = applicantProfile.givenNames;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = applicantProfile.firstName;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = applicantProfile.middleName;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = applicantProfile.familyName;
        }
        String str11 = str6;
        if ((i & 64) != 0) {
            structuredPostalAddress = applicantProfile.structuredPostalAddress;
        }
        return applicantProfile.copy(str, str7, str8, str9, str10, str11, structuredPostalAddress);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFullName() {
        return this.fullName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDateOfBirth() {
        return this.dateOfBirth;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGivenNames() {
        return this.givenNames;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFirstName() {
        return this.firstName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMiddleName() {
        return this.middleName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getFamilyName() {
        return this.familyName;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final StructuredPostalAddress getStructuredPostalAddress() {
        return this.structuredPostalAddress;
    }

    public final ApplicantProfile copy(String fullName, String dateOfBirth, String givenNames, String firstName, String middleName, String familyName, StructuredPostalAddress structuredPostalAddress) {
        Intrinsics.checkNotNullParameter(fullName, "fullName");
        Intrinsics.checkNotNullParameter(dateOfBirth, "dateOfBirth");
        Intrinsics.checkNotNullParameter(structuredPostalAddress, "structuredPostalAddress");
        return new ApplicantProfile(fullName, dateOfBirth, givenNames, firstName, middleName, familyName, structuredPostalAddress);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicantProfile)) {
            return false;
        }
        ApplicantProfile applicantProfile = (ApplicantProfile) other;
        return Intrinsics.areEqual(this.fullName, applicantProfile.fullName) && Intrinsics.areEqual(this.dateOfBirth, applicantProfile.dateOfBirth) && Intrinsics.areEqual(this.givenNames, applicantProfile.givenNames) && Intrinsics.areEqual(this.firstName, applicantProfile.firstName) && Intrinsics.areEqual(this.middleName, applicantProfile.middleName) && Intrinsics.areEqual(this.familyName, applicantProfile.familyName) && Intrinsics.areEqual(this.structuredPostalAddress, applicantProfile.structuredPostalAddress);
    }

    public final String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public final String getFamilyName() {
        return this.familyName;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final String getGivenNames() {
        return this.givenNames;
    }

    public final String getMiddleName() {
        return this.middleName;
    }

    public final StructuredPostalAddress getStructuredPostalAddress() {
        return this.structuredPostalAddress;
    }

    public int hashCode() {
        int iHashCode = ((this.fullName.hashCode() * 31) + this.dateOfBirth.hashCode()) * 31;
        String str = this.givenNames;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.firstName;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.middleName;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.familyName;
        return ((iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.structuredPostalAddress.hashCode();
    }

    public String toString() {
        return "ApplicantProfile(fullName=" + this.fullName + ", dateOfBirth=" + this.dateOfBirth + ", givenNames=" + this.givenNames + ", firstName=" + this.firstName + ", middleName=" + this.middleName + ", familyName=" + this.familyName + ", structuredPostalAddress=" + this.structuredPostalAddress + ')';
    }
}
