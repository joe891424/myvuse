package com.yoti.mobile.android.mrtd.domain.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/domain/model/BacCredential;", "Landroid/os/Parcelable;", "documentNumber", "", "dateOfBirth", "dateOfExpiry", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDateOfBirth", "()Ljava/lang/String;", "getDateOfExpiry", "getDocumentNumber", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class BacCredential implements Parcelable {
    public static final Parcelable.Creator<BacCredential> CREATOR = new Creator();
    private final String dateOfBirth;
    private final String dateOfExpiry;
    private final String documentNumber;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<BacCredential> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BacCredential createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BacCredential(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BacCredential[] newArray(int i) {
            return new BacCredential[i];
        }
    }

    public BacCredential(String documentNumber, String dateOfBirth, String dateOfExpiry) {
        Intrinsics.checkNotNullParameter(documentNumber, "documentNumber");
        Intrinsics.checkNotNullParameter(dateOfBirth, "dateOfBirth");
        Intrinsics.checkNotNullParameter(dateOfExpiry, "dateOfExpiry");
        this.documentNumber = documentNumber;
        this.dateOfBirth = dateOfBirth;
        this.dateOfExpiry = dateOfExpiry;
    }

    public static /* synthetic */ BacCredential copy$default(BacCredential bacCredential, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bacCredential.documentNumber;
        }
        if ((i & 2) != 0) {
            str2 = bacCredential.dateOfBirth;
        }
        if ((i & 4) != 0) {
            str3 = bacCredential.dateOfExpiry;
        }
        return bacCredential.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDocumentNumber() {
        return this.documentNumber;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDateOfBirth() {
        return this.dateOfBirth;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDateOfExpiry() {
        return this.dateOfExpiry;
    }

    public final BacCredential copy(String documentNumber, String dateOfBirth, String dateOfExpiry) {
        Intrinsics.checkNotNullParameter(documentNumber, "documentNumber");
        Intrinsics.checkNotNullParameter(dateOfBirth, "dateOfBirth");
        Intrinsics.checkNotNullParameter(dateOfExpiry, "dateOfExpiry");
        return new BacCredential(documentNumber, dateOfBirth, dateOfExpiry);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BacCredential)) {
            return false;
        }
        BacCredential bacCredential = (BacCredential) other;
        return Intrinsics.areEqual(this.documentNumber, bacCredential.documentNumber) && Intrinsics.areEqual(this.dateOfBirth, bacCredential.dateOfBirth) && Intrinsics.areEqual(this.dateOfExpiry, bacCredential.dateOfExpiry);
    }

    public final String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public final String getDateOfExpiry() {
        return this.dateOfExpiry;
    }

    public final String getDocumentNumber() {
        return this.documentNumber;
    }

    public int hashCode() {
        return (((this.documentNumber.hashCode() * 31) + this.dateOfBirth.hashCode()) * 31) + this.dateOfExpiry.hashCode();
    }

    public String toString() {
        return "BacCredential(documentNumber=" + this.documentNumber + ", dateOfBirth=" + this.dateOfBirth + ", dateOfExpiry=" + this.dateOfExpiry + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.documentNumber);
        parcel.writeString(this.dateOfBirth);
        parcel.writeString(this.dateOfExpiry);
    }
}
