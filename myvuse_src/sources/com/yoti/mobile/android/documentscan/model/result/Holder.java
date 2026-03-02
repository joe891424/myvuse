package com.yoti.mobile.android.documentscan.model.result;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.autofill.HintConstants;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008d\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020.HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001J\u0019\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020.HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015¨\u0006:"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/model/result/Holder;", "Landroid/os/Parcelable;", "prefix", "", "firstName", "givenNames", "middleNames", "familyName", "suffix", "fullName", "dateOfBirth", "Lcom/yoti/mobile/android/documentscan/model/result/DateResult;", BlinkIdCombinedRecognizer.VerificationConstants.PlaceOfBirth, HintConstants.AUTOFILL_HINT_GENDER, "Lcom/yoti/mobile/android/documentscan/model/result/Gender;", BlinkIdCombinedRecognizer.VerificationConstants.Nationality, "Lcom/yoti/mobile/android/documentscan/model/result/Country;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/yoti/mobile/android/documentscan/model/result/DateResult;Ljava/lang/String;Lcom/yoti/mobile/android/documentscan/model/result/Gender;Lcom/yoti/mobile/android/documentscan/model/result/Country;)V", "getDateOfBirth", "()Lcom/yoti/mobile/android/documentscan/model/result/DateResult;", "getFamilyName", "()Ljava/lang/String;", "getFirstName", "getFullName", "getGender", "()Lcom/yoti/mobile/android/documentscan/model/result/Gender;", "getGivenNames", "getMiddleNames", "getNationality", "()Lcom/yoti/mobile/android/documentscan/model/result/Country;", "getPlaceOfBirth", "getPrefix", "getSuffix", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final /* data */ class Holder implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final DateResult dateOfBirth;
    private final String familyName;
    private final String firstName;
    private final String fullName;
    private final Gender gender;
    private final String givenNames;
    private final String middleNames;
    private final Country nationality;
    private final String placeOfBirth;
    private final String prefix;
    private final String suffix;

    @Metadata(m5596bv = {1, 0, 3}, m5599k = 3, m5600mv = {1, 1, 15})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel in) {
            Intrinsics.checkParameterIsNotNull(in, "in");
            return new Holder(in.readString(), in.readString(), in.readString(), in.readString(), in.readString(), in.readString(), in.readString(), in.readInt() != 0 ? (DateResult) DateResult.CREATOR.createFromParcel(in) : null, in.readString(), in.readInt() != 0 ? (Gender) Enum.valueOf(Gender.class, in.readString()) : null, in.readInt() != 0 ? (Country) Country.CREATOR.createFromParcel(in) : null);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new Holder[i];
        }
    }

    public Holder(String str, String str2, String str3, String str4, String str5, String str6, String str7, DateResult dateResult, String str8, Gender gender, Country country) {
        this.prefix = str;
        this.firstName = str2;
        this.givenNames = str3;
        this.middleNames = str4;
        this.familyName = str5;
        this.suffix = str6;
        this.fullName = str7;
        this.dateOfBirth = dateResult;
        this.placeOfBirth = str8;
        this.gender = gender;
        this.nationality = country;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPrefix() {
        return this.prefix;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Gender getGender() {
        return this.gender;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Country getNationality() {
        return this.nationality;
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
    public final DateResult getDateOfBirth() {
        return this.dateOfBirth;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getPlaceOfBirth() {
        return this.placeOfBirth;
    }

    public final Holder copy(String prefix, String firstName, String givenNames, String middleNames, String familyName, String suffix, String fullName, DateResult dateOfBirth, String placeOfBirth, Gender gender, Country nationality) {
        return new Holder(prefix, firstName, givenNames, middleNames, familyName, suffix, fullName, dateOfBirth, placeOfBirth, gender, nationality);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Holder)) {
            return false;
        }
        Holder holder = (Holder) other;
        return Intrinsics.areEqual(this.prefix, holder.prefix) && Intrinsics.areEqual(this.firstName, holder.firstName) && Intrinsics.areEqual(this.givenNames, holder.givenNames) && Intrinsics.areEqual(this.middleNames, holder.middleNames) && Intrinsics.areEqual(this.familyName, holder.familyName) && Intrinsics.areEqual(this.suffix, holder.suffix) && Intrinsics.areEqual(this.fullName, holder.fullName) && Intrinsics.areEqual(this.dateOfBirth, holder.dateOfBirth) && Intrinsics.areEqual(this.placeOfBirth, holder.placeOfBirth) && Intrinsics.areEqual(this.gender, holder.gender) && Intrinsics.areEqual(this.nationality, holder.nationality);
    }

    public final DateResult getDateOfBirth() {
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

    public final Gender getGender() {
        return this.gender;
    }

    public final String getGivenNames() {
        return this.givenNames;
    }

    public final String getMiddleNames() {
        return this.middleNames;
    }

    public final Country getNationality() {
        return this.nationality;
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
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.firstName;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.givenNames;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.middleNames;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.familyName;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.suffix;
        int iHashCode6 = (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.fullName;
        int iHashCode7 = (iHashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        DateResult dateResult = this.dateOfBirth;
        int iHashCode8 = (iHashCode7 + (dateResult != null ? dateResult.hashCode() : 0)) * 31;
        String str8 = this.placeOfBirth;
        int iHashCode9 = (iHashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Gender gender = this.gender;
        int iHashCode10 = (iHashCode9 + (gender != null ? gender.hashCode() : 0)) * 31;
        Country country = this.nationality;
        return iHashCode10 + (country != null ? country.hashCode() : 0);
    }

    public String toString() {
        return "Holder(prefix=" + this.prefix + ", firstName=" + this.firstName + ", givenNames=" + this.givenNames + ", middleNames=" + this.middleNames + ", familyName=" + this.familyName + ", suffix=" + this.suffix + ", fullName=" + this.fullName + ", dateOfBirth=" + this.dateOfBirth + ", placeOfBirth=" + this.placeOfBirth + ", gender=" + this.gender + ", nationality=" + this.nationality + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.prefix);
        parcel.writeString(this.firstName);
        parcel.writeString(this.givenNames);
        parcel.writeString(this.middleNames);
        parcel.writeString(this.familyName);
        parcel.writeString(this.suffix);
        parcel.writeString(this.fullName);
        DateResult dateResult = this.dateOfBirth;
        if (dateResult != null) {
            parcel.writeInt(1);
            dateResult.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.placeOfBirth);
        Gender gender = this.gender;
        if (gender != null) {
            parcel.writeInt(1);
            parcel.writeString(gender.name());
        } else {
            parcel.writeInt(0);
        }
        Country country = this.nationality;
        if (country == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            country.writeToParcel(parcel, 0);
        }
    }
}
