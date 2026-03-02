package com.yoti.mobile.android.yotisdkcore.core.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.commonui.UiSessionConfiguration;
import com.yoti.mobile.android.remote.model.Session;
import com.yoti.mobile.android.yotisdkcore.core.view.IFeatureConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/view/YotiSdkConfiguration;", "Lcom/yoti/mobile/android/yotisdkcore/core/view/IFeatureConfiguration;", "session", "Lcom/yoti/mobile/android/remote/model/Session;", "(Lcom/yoti/mobile/android/remote/model/Session;)V", "getSession", "()Lcom/yoti/mobile/android/remote/model/Session;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class YotiSdkConfiguration implements IFeatureConfiguration {
    public static final Parcelable.Creator<YotiSdkConfiguration> CREATOR = new Creator();
    private final Session session;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<YotiSdkConfiguration> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final YotiSdkConfiguration createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new YotiSdkConfiguration((Session) parcel.readParcelable(YotiSdkConfiguration.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final YotiSdkConfiguration[] newArray(int i) {
            return new YotiSdkConfiguration[i];
        }
    }

    public YotiSdkConfiguration(Session session) {
        Intrinsics.checkNotNullParameter(session, "session");
        this.session = session;
    }

    public static /* synthetic */ YotiSdkConfiguration copy$default(YotiSdkConfiguration yotiSdkConfiguration, Session session, int i, Object obj) {
        if ((i & 1) != 0) {
            session = yotiSdkConfiguration.session;
        }
        return yotiSdkConfiguration.copy(session);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Session getSession() {
        return this.session;
    }

    public final YotiSdkConfiguration copy(Session session) {
        Intrinsics.checkNotNullParameter(session, "session");
        return new YotiSdkConfiguration(session);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof YotiSdkConfiguration) && Intrinsics.areEqual(this.session, ((YotiSdkConfiguration) other).session);
    }

    public final Session getSession() {
        return this.session;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.view.IFeatureConfiguration
    public UiSessionConfiguration getUiSessionConfiguration() {
        return IFeatureConfiguration.DefaultImpls.getUiSessionConfiguration(this);
    }

    public int hashCode() {
        return this.session.hashCode();
    }

    public String toString() {
        return "YotiSdkConfiguration(session=" + this.session + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.session, flags);
    }
}
