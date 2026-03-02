package com.yoti.mobile.android.commonui;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UiSessionConfiguration.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J0\u0010\u0013\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/UiSessionConfiguration;", "Landroid/os/Parcelable;", "logo", "", "privacyPolicyUrl", "", "showIdentityCheck", "", "(Ljava/lang/Integer;Ljava/lang/String;Z)V", "getLogo", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPrivacyPolicyUrl", "()Ljava/lang/String;", "getShowIdentityCheck", "()Z", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Z)Lcom/yoti/mobile/android/commonui/UiSessionConfiguration;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class UiSessionConfiguration implements Parcelable {
    public static final Parcelable.Creator<UiSessionConfiguration> CREATOR = new Creator();
    private final Integer logo;
    private final String privacyPolicyUrl;
    private final boolean showIdentityCheck;

    /* JADX INFO: compiled from: UiSessionConfiguration.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<UiSessionConfiguration> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UiSessionConfiguration createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UiSessionConfiguration(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UiSessionConfiguration[] newArray(int i) {
            return new UiSessionConfiguration[i];
        }
    }

    public UiSessionConfiguration() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ UiSessionConfiguration copy$default(UiSessionConfiguration uiSessionConfiguration, Integer num, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            num = uiSessionConfiguration.logo;
        }
        if ((i & 2) != 0) {
            str = uiSessionConfiguration.privacyPolicyUrl;
        }
        if ((i & 4) != 0) {
            z = uiSessionConfiguration.showIdentityCheck;
        }
        return uiSessionConfiguration.copy(num, str, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getLogo() {
        return this.logo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPrivacyPolicyUrl() {
        return this.privacyPolicyUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShowIdentityCheck() {
        return this.showIdentityCheck;
    }

    public final UiSessionConfiguration copy(Integer logo, String privacyPolicyUrl, boolean showIdentityCheck) {
        return new UiSessionConfiguration(logo, privacyPolicyUrl, showIdentityCheck);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UiSessionConfiguration)) {
            return false;
        }
        UiSessionConfiguration uiSessionConfiguration = (UiSessionConfiguration) other;
        return Intrinsics.areEqual(this.logo, uiSessionConfiguration.logo) && Intrinsics.areEqual(this.privacyPolicyUrl, uiSessionConfiguration.privacyPolicyUrl) && this.showIdentityCheck == uiSessionConfiguration.showIdentityCheck;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        Integer num = this.logo;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.privacyPolicyUrl;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        boolean z = this.showIdentityCheck;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public String toString() {
        return "UiSessionConfiguration(logo=" + this.logo + ", privacyPolicyUrl=" + this.privacyPolicyUrl + ", showIdentityCheck=" + this.showIdentityCheck + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(parcel, "out");
        Integer num = this.logo;
        if (num == null) {
            iIntValue = 0;
        } else {
            parcel.writeInt(1);
            iIntValue = num.intValue();
        }
        parcel.writeInt(iIntValue);
        parcel.writeString(this.privacyPolicyUrl);
        parcel.writeInt(this.showIdentityCheck ? 1 : 0);
    }

    public UiSessionConfiguration(Integer num, String str, boolean z) {
        this.logo = num;
        this.privacyPolicyUrl = str;
        this.showIdentityCheck = z;
    }

    public /* synthetic */ UiSessionConfiguration(Integer num, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Integer.valueOf(C4590R.drawable.yds_ic_powered_by) : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z);
    }

    public final Integer getLogo() {
        return this.logo;
    }

    public final String getPrivacyPolicyUrl() {
        return this.privacyPolicyUrl;
    }

    public final boolean getShowIdentityCheck() {
        return this.showIdentityCheck;
    }
}
