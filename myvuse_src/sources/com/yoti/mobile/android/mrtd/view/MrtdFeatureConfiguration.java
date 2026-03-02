package com.yoti.mobile.android.mrtd.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.commonui.UiSessionConfiguration;
import com.yoti.mobile.android.mrtd.domain.model.BacCredential;
import com.yoti.mobile.android.yotisdkcore.core.view.IFeatureConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/view/MrtdFeatureConfiguration;", "Lcom/yoti/mobile/android/yotisdkcore/core/view/IFeatureConfiguration;", "authData", "Lcom/yoti/mobile/android/mrtd/domain/model/BacCredential;", "(Lcom/yoti/mobile/android/mrtd/domain/model/BacCredential;)V", "getAuthData", "()Lcom/yoti/mobile/android/mrtd/domain/model/BacCredential;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class MrtdFeatureConfiguration implements IFeatureConfiguration {
    public static final Parcelable.Creator<MrtdFeatureConfiguration> CREATOR = new Creator();
    private final BacCredential authData;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<MrtdFeatureConfiguration> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MrtdFeatureConfiguration createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MrtdFeatureConfiguration(BacCredential.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MrtdFeatureConfiguration[] newArray(int i) {
            return new MrtdFeatureConfiguration[i];
        }
    }

    public MrtdFeatureConfiguration(BacCredential authData) {
        Intrinsics.checkNotNullParameter(authData, "authData");
        this.authData = authData;
    }

    public static /* synthetic */ MrtdFeatureConfiguration copy$default(MrtdFeatureConfiguration mrtdFeatureConfiguration, BacCredential bacCredential, int i, Object obj) {
        if ((i & 1) != 0) {
            bacCredential = mrtdFeatureConfiguration.authData;
        }
        return mrtdFeatureConfiguration.copy(bacCredential);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BacCredential getAuthData() {
        return this.authData;
    }

    public final MrtdFeatureConfiguration copy(BacCredential authData) {
        Intrinsics.checkNotNullParameter(authData, "authData");
        return new MrtdFeatureConfiguration(authData);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MrtdFeatureConfiguration) && Intrinsics.areEqual(this.authData, ((MrtdFeatureConfiguration) other).authData);
    }

    public final BacCredential getAuthData() {
        return this.authData;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.view.IFeatureConfiguration
    public UiSessionConfiguration getUiSessionConfiguration() {
        return IFeatureConfiguration.DefaultImpls.getUiSessionConfiguration(this);
    }

    public int hashCode() {
        return this.authData.hashCode();
    }

    public String toString() {
        return "MrtdFeatureConfiguration(authData=" + this.authData + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.authData.writeToParcel(parcel, flags);
    }
}
