package com.yoti.mobile.android.documentscan.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/model/BlinkIDLicense;", "Landroid/os/Parcelable;", "apiKey", "", "licenseeName", "(Ljava/lang/String;Ljava/lang/String;)V", "getApiKey", "()Ljava/lang/String;", "getLicenseeName", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final /* data */ class BlinkIDLicense implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String apiKey;
    private final String licenseeName;

    @Metadata(m5596bv = {1, 0, 3}, m5599k = 3, m5600mv = {1, 1, 15})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel in) {
            Intrinsics.checkParameterIsNotNull(in, "in");
            return new BlinkIDLicense(in.readString(), in.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new BlinkIDLicense[i];
        }
    }

    public BlinkIDLicense(String apiKey, String str) {
        Intrinsics.checkParameterIsNotNull(apiKey, "apiKey");
        this.apiKey = apiKey;
        this.licenseeName = str;
    }

    public static /* synthetic */ BlinkIDLicense copy$default(BlinkIDLicense blinkIDLicense, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = blinkIDLicense.apiKey;
        }
        if ((i & 2) != 0) {
            str2 = blinkIDLicense.licenseeName;
        }
        return blinkIDLicense.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getApiKey() {
        return this.apiKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLicenseeName() {
        return this.licenseeName;
    }

    public final BlinkIDLicense copy(String apiKey, String licenseeName) {
        Intrinsics.checkParameterIsNotNull(apiKey, "apiKey");
        return new BlinkIDLicense(apiKey, licenseeName);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlinkIDLicense)) {
            return false;
        }
        BlinkIDLicense blinkIDLicense = (BlinkIDLicense) other;
        return Intrinsics.areEqual(this.apiKey, blinkIDLicense.apiKey) && Intrinsics.areEqual(this.licenseeName, blinkIDLicense.licenseeName);
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final String getLicenseeName() {
        return this.licenseeName;
    }

    public int hashCode() {
        String str = this.apiKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.licenseeName;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "BlinkIDLicense(apiKey=" + this.apiKey + ", licenseeName=" + this.licenseeName + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.apiKey);
        parcel.writeString(this.licenseeName);
    }
}
