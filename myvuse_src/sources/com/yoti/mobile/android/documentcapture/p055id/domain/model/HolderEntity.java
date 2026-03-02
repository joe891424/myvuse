package com.yoti.mobile.android.documentcapture.p055id.domain.model;

import androidx.autofill.HintConstants;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008d\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014¨\u00061"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/domain/model/HolderEntity;", "", "prefix", "", "firstName", "givenNames", "middleNames", "familyName", "suffix", "fullName", "dateOfBirth", "Ljava/util/Date;", BlinkIdCombinedRecognizer.VerificationConstants.PlaceOfBirth, HintConstants.AUTOFILL_HINT_GENDER, "Lcom/yoti/mobile/android/documentcapture/id/domain/model/GenderTypeEntity;", "nationalityIso3Code", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Lcom/yoti/mobile/android/documentcapture/id/domain/model/GenderTypeEntity;Ljava/lang/String;)V", "getDateOfBirth", "()Ljava/util/Date;", "getFamilyName", "()Ljava/lang/String;", "getFirstName", "getFullName", "getGender", "()Lcom/yoti/mobile/android/documentcapture/id/domain/model/GenderTypeEntity;", "getGivenNames", "getMiddleNames", "getNationalityIso3Code", "getPlaceOfBirth", "getPrefix", "getSuffix", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class HolderEntity {
    private final Date dateOfBirth;
    private final String familyName;
    private final String firstName;
    private final String fullName;
    private final GenderTypeEntity gender;
    private final String givenNames;
    private final String middleNames;
    private final String nationalityIso3Code;
    private final String placeOfBirth;
    private final String prefix;
    private final String suffix;

    public HolderEntity() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public HolderEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, Date date, String str8, GenderTypeEntity genderTypeEntity, String str9) {
        this.prefix = str;
        this.firstName = str2;
        this.givenNames = str3;
        this.middleNames = str4;
        this.familyName = str5;
        this.suffix = str6;
        this.fullName = str7;
        this.dateOfBirth = date;
        this.placeOfBirth = str8;
        this.gender = genderTypeEntity;
        this.nationalityIso3Code = str9;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPrefix() {
        return this.prefix;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final GenderTypeEntity getGender() {
        return this.gender;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getNationalityIso3Code() {
        return this.nationalityIso3Code;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFirstName() {
        return this.firstName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGivenNames() {
        return this.givenNames;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMiddleNames() {
        return this.middleNames;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFamilyName() {
        return this.familyName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSuffix() {
        return this.suffix;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getFullName() {
        return this.fullName;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getPlaceOfBirth() {
        return this.placeOfBirth;
    }

    public final HolderEntity copy(String prefix, String firstName, String givenNames, String middleNames, String familyName, String suffix, String fullName, Date dateOfBirth, String placeOfBirth, GenderTypeEntity gender, String nationalityIso3Code) {
        return new HolderEntity(prefix, firstName, givenNames, middleNames, familyName, suffix, fullName, dateOfBirth, placeOfBirth, gender, nationalityIso3Code);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HolderEntity)) {
            return false;
        }
        HolderEntity holderEntity = (HolderEntity) other;
        return Intrinsics.areEqual(this.prefix, holderEntity.prefix) && Intrinsics.areEqual(this.firstName, holderEntity.firstName) && Intrinsics.areEqual(this.givenNames, holderEntity.givenNames) && Intrinsics.areEqual(this.middleNames, holderEntity.middleNames) && Intrinsics.areEqual(this.familyName, holderEntity.familyName) && Intrinsics.areEqual(this.suffix, holderEntity.suffix) && Intrinsics.areEqual(this.fullName, holderEntity.fullName) && Intrinsics.areEqual(this.dateOfBirth, holderEntity.dateOfBirth) && Intrinsics.areEqual(this.placeOfBirth, holderEntity.placeOfBirth) && this.gender == holderEntity.gender && Intrinsics.areEqual(this.nationalityIso3Code, holderEntity.nationalityIso3Code);
    }

    public final Date getDateOfBirth() {
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

    public final GenderTypeEntity getGender() {
        return this.gender;
    }

    public final String getGivenNames() {
        return this.givenNames;
    }

    public final String getMiddleNames() {
        return this.middleNames;
    }

    public final String getNationalityIso3Code() {
        return this.nationalityIso3Code;
    }

    public final String getPlaceOfBirth() {
        return this.placeOfBirth;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public final String getSuffix() {
        return this.suffix;
    }

    public int hashCode() {
        String str = this.prefix;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.firstName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.givenNames;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.middleNames;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.familyName;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.suffix;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.fullName;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Date date = this.dateOfBirth;
        int iHashCode8 = (iHashCode7 + (date == null ? 0 : date.hashCode())) * 31;
        String str8 = this.placeOfBirth;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        GenderTypeEntity genderTypeEntity = this.gender;
        int iHashCode10 = (iHashCode9 + (genderTypeEntity == null ? 0 : genderTypeEntity.hashCode())) * 31;
        String str9 = this.nationalityIso3Code;
        return iHashCode10 + (str9 != null ? str9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HolderEntity(prefix=");
        sb.append(this.prefix).append(", firstName=").append(this.firstName).append(", givenNames=").append(this.givenNames).append(", middleNames=").append(this.middleNames).append(", familyName=").append(this.familyName).append(", suffix=").append(this.suffix).append(", fullName=").append(this.fullName).append(", dateOfBirth=").append(this.dateOfBirth).append(", placeOfBirth=").append(this.placeOfBirth).append(", gender=").append(this.gender).append(", nationalityIso3Code=").append(this.nationalityIso3Code).append(')');
        return sb.toString();
    }

    public /* synthetic */ HolderEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, Date date, String str8, GenderTypeEntity genderTypeEntity, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : date, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : genderTypeEntity, (i & 1024) == 0 ? str9 : null);
    }
}
