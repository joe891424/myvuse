package com.yoti.mobile.android.documentscan.model.result;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ2\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0004\u0010\bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/model/result/MrzData;", "Landroid/os/Parcelable;", "mrz", "", "isMrzParsed", "", "isMrzVerified", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMrz", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/yoti/mobile/android/documentscan/model/result/MrzData;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final /* data */ class MrzData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final Boolean isMrzParsed;
    private final Boolean isMrzVerified;
    private final String mrz;

    @Metadata(m5596bv = {1, 0, 3}, m5599k = 3, m5600mv = {1, 1, 15})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel in) {
            Boolean boolValueOf;
            Intrinsics.checkParameterIsNotNull(in, "in");
            String string = in.readString();
            Boolean boolValueOf2 = null;
            if (in.readInt() != 0) {
                boolValueOf = Boolean.valueOf(in.readInt() != 0);
            } else {
                boolValueOf = null;
            }
            if (in.readInt() != 0) {
                boolValueOf2 = Boolean.valueOf(in.readInt() != 0);
            }
            return new MrzData(string, boolValueOf, boolValueOf2);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new MrzData[i];
        }
    }

    public MrzData(String str, Boolean bool, Boolean bool2) {
        this.mrz = str;
        this.isMrzParsed = bool;
        this.isMrzVerified = bool2;
    }

    public static /* synthetic */ MrzData copy$default(MrzData mrzData, String str, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mrzData.mrz;
        }
        if ((i & 2) != 0) {
            bool = mrzData.isMrzParsed;
        }
        if ((i & 4) != 0) {
            bool2 = mrzData.isMrzVerified;
        }
        return mrzData.copy(str, bool, bool2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMrz() {
        return this.mrz;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getIsMrzParsed() {
        return this.isMrzParsed;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getIsMrzVerified() {
        return this.isMrzVerified;
    }

    public final MrzData copy(String mrz, Boolean isMrzParsed, Boolean isMrzVerified) {
        return new MrzData(mrz, isMrzParsed, isMrzVerified);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MrzData)) {
            return false;
        }
        MrzData mrzData = (MrzData) other;
        return Intrinsics.areEqual(this.mrz, mrzData.mrz) && Intrinsics.areEqual(this.isMrzParsed, mrzData.isMrzParsed) && Intrinsics.areEqual(this.isMrzVerified, mrzData.isMrzVerified);
    }

    public final String getMrz() {
        return this.mrz;
    }

    public int hashCode() {
        String str = this.mrz;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Boolean bool = this.isMrzParsed;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isMrzVerified;
        return iHashCode2 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final Boolean isMrzParsed() {
        return this.isMrzParsed;
    }

    public final Boolean isMrzVerified() {
        return this.isMrzVerified;
    }

    public String toString() {
        return "MrzData(mrz=" + this.mrz + ", isMrzParsed=" + this.isMrzParsed + ", isMrzVerified=" + this.isMrzVerified + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.mrz);
        Boolean bool = this.isMrzParsed;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool2 = this.isMrzVerified;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
    }
}
