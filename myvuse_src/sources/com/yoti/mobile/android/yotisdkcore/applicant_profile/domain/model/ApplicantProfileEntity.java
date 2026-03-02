package com.yoti.mobile.android.yotisdkcore.applicant_profile.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/ApplicantProfileEntity;", "", "fullName", "", "dateOfBirth", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/DateOfBirthEntity;", "structuredPostalAddress", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/StructuredPostalAddressEntity;", "(Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/DateOfBirthEntity;Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/StructuredPostalAddressEntity;)V", "getDateOfBirth", "()Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/DateOfBirthEntity;", "getFullName", "()Ljava/lang/String;", "getStructuredPostalAddress", "()Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/StructuredPostalAddressEntity;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class ApplicantProfileEntity {
    private final DateOfBirthEntity dateOfBirth;
    private final String fullName;
    private final StructuredPostalAddressEntity structuredPostalAddress;

    public ApplicantProfileEntity(String fullName, DateOfBirthEntity dateOfBirth, StructuredPostalAddressEntity structuredPostalAddress) {
        Intrinsics.checkNotNullParameter(fullName, "fullName");
        Intrinsics.checkNotNullParameter(dateOfBirth, "dateOfBirth");
        Intrinsics.checkNotNullParameter(structuredPostalAddress, "structuredPostalAddress");
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.structuredPostalAddress = structuredPostalAddress;
    }

    public static /* synthetic */ ApplicantProfileEntity copy$default(ApplicantProfileEntity applicantProfileEntity, String str, DateOfBirthEntity dateOfBirthEntity, StructuredPostalAddressEntity structuredPostalAddressEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            str = applicantProfileEntity.fullName;
        }
        if ((i & 2) != 0) {
            dateOfBirthEntity = applicantProfileEntity.dateOfBirth;
        }
        if ((i & 4) != 0) {
            structuredPostalAddressEntity = applicantProfileEntity.structuredPostalAddress;
        }
        return applicantProfileEntity.copy(str, dateOfBirthEntity, structuredPostalAddressEntity);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFullName() {
        return this.fullName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final DateOfBirthEntity getDateOfBirth() {
        return this.dateOfBirth;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StructuredPostalAddressEntity getStructuredPostalAddress() {
        return this.structuredPostalAddress;
    }

    public final ApplicantProfileEntity copy(String fullName, DateOfBirthEntity dateOfBirth, StructuredPostalAddressEntity structuredPostalAddress) {
        Intrinsics.checkNotNullParameter(fullName, "fullName");
        Intrinsics.checkNotNullParameter(dateOfBirth, "dateOfBirth");
        Intrinsics.checkNotNullParameter(structuredPostalAddress, "structuredPostalAddress");
        return new ApplicantProfileEntity(fullName, dateOfBirth, structuredPostalAddress);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicantProfileEntity)) {
            return false;
        }
        ApplicantProfileEntity applicantProfileEntity = (ApplicantProfileEntity) other;
        return Intrinsics.areEqual(this.fullName, applicantProfileEntity.fullName) && Intrinsics.areEqual(this.dateOfBirth, applicantProfileEntity.dateOfBirth) && Intrinsics.areEqual(this.structuredPostalAddress, applicantProfileEntity.structuredPostalAddress);
    }

    public final DateOfBirthEntity getDateOfBirth() {
        return this.dateOfBirth;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final StructuredPostalAddressEntity getStructuredPostalAddress() {
        return this.structuredPostalAddress;
    }

    public int hashCode() {
        return (((this.fullName.hashCode() * 31) + this.dateOfBirth.hashCode()) * 31) + this.structuredPostalAddress.hashCode();
    }

    public String toString() {
        return "ApplicantProfileEntity(fullName=" + this.fullName + ", dateOfBirth=" + this.dateOfBirth + ", structuredPostalAddress=" + this.structuredPostalAddress + ')';
    }
}
