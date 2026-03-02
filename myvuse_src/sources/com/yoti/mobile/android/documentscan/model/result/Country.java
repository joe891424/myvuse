package com.yoti.mobile.android.documentscan.model.result;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u0019\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u001b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/model/result/Country;", "Landroid/os/Parcelable;", "alpha", "", "(Ljava/lang/String;)V", "alpha2", "alpha3", "(Ljava/lang/String;Ljava/lang/String;)V", "getAlpha2", "()Ljava/lang/String;", "getAlpha3", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final /* data */ class Country implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String alpha2;
    private final String alpha3;

    @Metadata(m5596bv = {1, 0, 3}, m5599k = 3, m5600mv = {1, 1, 15})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel in) {
            Intrinsics.checkParameterIsNotNull(in, "in");
            return new Country(in.readString(), in.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new Country[i];
        }
    }

    public Country(String str) {
        this((str == null || str.length() != 2) ? null : str, (str == null || str.length() != 3) ? null : str);
    }

    public Country(String str, String str2) {
        this.alpha2 = str;
        this.alpha3 = str2;
    }

    public static /* synthetic */ Country copy$default(Country country, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = country.alpha2;
        }
        if ((i & 2) != 0) {
            str2 = country.alpha3;
        }
        return country.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAlpha2() {
        return this.alpha2;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAlpha3() {
        return this.alpha3;
    }

    public final Country copy(String alpha2, String alpha3) {
        return new Country(alpha2, alpha3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Country)) {
            return false;
        }
        Country country = (Country) other;
        return Intrinsics.areEqual(this.alpha2, country.alpha2) && Intrinsics.areEqual(this.alpha3, country.alpha3);
    }

    public final String getAlpha2() {
        return this.alpha2;
    }

    public final String getAlpha3() {
        return this.alpha3;
    }

    public int hashCode() {
        String str = this.alpha2;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.alpha3;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Country(alpha2=" + this.alpha2 + ", alpha3=" + this.alpha3 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.alpha2);
        parcel.writeString(this.alpha3);
    }
}
