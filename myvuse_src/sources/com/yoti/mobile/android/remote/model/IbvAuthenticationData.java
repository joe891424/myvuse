package com.yoti.mobile.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthenticationData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/model/IbvAuthenticationData;", "Lcom/yoti/mobile/android/remote/model/AuthenticationData;", "fadCode", "", "keyAlias", "scheme", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFadCode", "()Ljava/lang/String;", "getKeyAlias", "getScheme", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class IbvAuthenticationData extends AuthenticationData {
    public static final Parcelable.Creator<IbvAuthenticationData> CREATOR = new Creator();
    private final String fadCode;
    private final String keyAlias;
    private final String scheme;

    /* JADX INFO: compiled from: AuthenticationData.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<IbvAuthenticationData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IbvAuthenticationData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new IbvAuthenticationData(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IbvAuthenticationData[] newArray(int i) {
            return new IbvAuthenticationData[i];
        }
    }

    public static /* synthetic */ IbvAuthenticationData copy$default(IbvAuthenticationData ibvAuthenticationData, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ibvAuthenticationData.fadCode;
        }
        if ((i & 2) != 0) {
            str2 = ibvAuthenticationData.keyAlias;
        }
        if ((i & 4) != 0) {
            str3 = ibvAuthenticationData.scheme;
        }
        return ibvAuthenticationData.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFadCode() {
        return this.fadCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getKeyAlias() {
        return this.keyAlias;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getScheme() {
        return this.scheme;
    }

    public final IbvAuthenticationData copy(String fadCode, String keyAlias, String scheme) {
        Intrinsics.checkNotNullParameter(fadCode, "fadCode");
        Intrinsics.checkNotNullParameter(keyAlias, "keyAlias");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        return new IbvAuthenticationData(fadCode, keyAlias, scheme);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IbvAuthenticationData)) {
            return false;
        }
        IbvAuthenticationData ibvAuthenticationData = (IbvAuthenticationData) other;
        return Intrinsics.areEqual(this.fadCode, ibvAuthenticationData.fadCode) && Intrinsics.areEqual(this.keyAlias, ibvAuthenticationData.keyAlias) && Intrinsics.areEqual(this.scheme, ibvAuthenticationData.scheme);
    }

    public int hashCode() {
        return (((this.fadCode.hashCode() * 31) + this.keyAlias.hashCode()) * 31) + this.scheme.hashCode();
    }

    public String toString() {
        return "IbvAuthenticationData(fadCode=" + this.fadCode + ", keyAlias=" + this.keyAlias + ", scheme=" + this.scheme + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.fadCode);
        parcel.writeString(this.keyAlias);
        parcel.writeString(this.scheme);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IbvAuthenticationData(String fadCode, String keyAlias, String scheme) {
        super(null);
        Intrinsics.checkNotNullParameter(fadCode, "fadCode");
        Intrinsics.checkNotNullParameter(keyAlias, "keyAlias");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        this.fadCode = fadCode;
        this.keyAlias = keyAlias;
        this.scheme = scheme;
    }

    public final String getFadCode() {
        return this.fadCode;
    }

    public final String getKeyAlias() {
        return this.keyAlias;
    }

    public final String getScheme() {
        return this.scheme;
    }
}
