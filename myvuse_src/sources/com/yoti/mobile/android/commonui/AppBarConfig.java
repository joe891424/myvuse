package com.yoti.mobile.android.commonui;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GuidelinesViewData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/AppBarConfig;", "Landroid/os/Parcelable;", "navigationIcon", "Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "logoRes", "", "(Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;I)V", "getLogoRes", "()I", "getNavigationIcon", "()Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class AppBarConfig implements Parcelable {
    public static final Parcelable.Creator<AppBarConfig> CREATOR = new Creator();
    private final int logoRes;
    private final NavigationIcon navigationIcon;

    /* JADX INFO: compiled from: GuidelinesViewData.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<AppBarConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AppBarConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AppBarConfig(NavigationIcon.valueOf(parcel.readString()), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AppBarConfig[] newArray(int i) {
            return new AppBarConfig[i];
        }
    }

    public static /* synthetic */ AppBarConfig copy$default(AppBarConfig appBarConfig, NavigationIcon navigationIcon, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            navigationIcon = appBarConfig.navigationIcon;
        }
        if ((i2 & 2) != 0) {
            i = appBarConfig.logoRes;
        }
        return appBarConfig.copy(navigationIcon, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final NavigationIcon getNavigationIcon() {
        return this.navigationIcon;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getLogoRes() {
        return this.logoRes;
    }

    public final AppBarConfig copy(NavigationIcon navigationIcon, int logoRes) {
        Intrinsics.checkNotNullParameter(navigationIcon, "navigationIcon");
        return new AppBarConfig(navigationIcon, logoRes);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppBarConfig)) {
            return false;
        }
        AppBarConfig appBarConfig = (AppBarConfig) other;
        return this.navigationIcon == appBarConfig.navigationIcon && this.logoRes == appBarConfig.logoRes;
    }

    public int hashCode() {
        return (this.navigationIcon.hashCode() * 31) + Integer.hashCode(this.logoRes);
    }

    public String toString() {
        return "AppBarConfig(navigationIcon=" + this.navigationIcon + ", logoRes=" + this.logoRes + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.navigationIcon.name());
        parcel.writeInt(this.logoRes);
    }

    public AppBarConfig(NavigationIcon navigationIcon, int i) {
        Intrinsics.checkNotNullParameter(navigationIcon, "navigationIcon");
        this.navigationIcon = navigationIcon;
        this.logoRes = i;
    }

    public /* synthetic */ AppBarConfig(NavigationIcon navigationIcon, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(navigationIcon, (i2 & 2) != 0 ? 0 : i);
    }

    public final NavigationIcon getNavigationIcon() {
        return this.navigationIcon;
    }

    public final int getLogoRes() {
        return this.logoRes;
    }
}
