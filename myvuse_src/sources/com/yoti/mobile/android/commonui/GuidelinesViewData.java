package com.yoti.mobile.android.commonui;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.yoti.mobile.android.common.p049ui.widgets.CompoundTextResource;
import com.yoti.mobile.android.common.p049ui.widgets.StringTransformation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GuidelinesViewData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BY\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fBU\u0012\u0006\u0010\u0002\u001a\u00020\u0010\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0010HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jh\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00102\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\u00032\b\b\u0003\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010)J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\u0013\u0010+\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u000200HÖ\u0001J\u0019\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0014R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00066"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/GuidelinesViewData;", "Landroid/os/Parcelable;", "title", "", NotificationMessage.NOTIF_KEY_SUB_TITLE, FirebaseAnalytics.Param.ITEMS, "", "Lcom/yoti/mobile/android/commonui/GuidelinesItem;", "isListView", "", "showDragIndicator", "primaryButtonText", "primaryButtonIcon", "appBarConfig", "Lcom/yoti/mobile/android/commonui/AppBarConfig;", "(ILjava/lang/Integer;Ljava/util/List;ZZIILcom/yoti/mobile/android/commonui/AppBarConfig;)V", "Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;", "(Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;Ljava/lang/Integer;Ljava/util/List;ZZIILcom/yoti/mobile/android/commonui/AppBarConfig;)V", "getAppBarConfig", "()Lcom/yoti/mobile/android/commonui/AppBarConfig;", "()Z", "getItems", "()Ljava/util/List;", "getPrimaryButtonIcon", "()I", "getPrimaryButtonText", "getShowDragIndicator", "getSubtitle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "()Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;Ljava/lang/Integer;Ljava/util/List;ZZIILcom/yoti/mobile/android/commonui/AppBarConfig;)Lcom/yoti/mobile/android/commonui/GuidelinesViewData;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class GuidelinesViewData implements Parcelable {
    public static final Parcelable.Creator<GuidelinesViewData> CREATOR = new Creator();
    private final AppBarConfig appBarConfig;
    private final boolean isListView;
    private final List<GuidelinesItem> items;
    private final int primaryButtonIcon;
    private final int primaryButtonText;
    private final boolean showDragIndicator;
    private final Integer subtitle;
    private final CompoundTextResource title;

    /* JADX INFO: compiled from: GuidelinesViewData.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<GuidelinesViewData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GuidelinesViewData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            CompoundTextResource compoundTextResource = (CompoundTextResource) parcel.readParcelable(GuidelinesViewData.class.getClassLoader());
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(GuidelinesItem.CREATOR.createFromParcel(parcel));
            }
            return new GuidelinesViewData(compoundTextResource, numValueOf, arrayList, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? AppBarConfig.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GuidelinesViewData[] newArray(int i) {
            return new GuidelinesViewData[i];
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CompoundTextResource getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getSubtitle() {
        return this.subtitle;
    }

    public final List<GuidelinesItem> component3() {
        return this.items;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsListView() {
        return this.isListView;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getShowDragIndicator() {
        return this.showDragIndicator;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getPrimaryButtonText() {
        return this.primaryButtonText;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getPrimaryButtonIcon() {
        return this.primaryButtonIcon;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final AppBarConfig getAppBarConfig() {
        return this.appBarConfig;
    }

    public final GuidelinesViewData copy(CompoundTextResource title, Integer subtitle, List<GuidelinesItem> items, boolean isListView, boolean showDragIndicator, int primaryButtonText, int primaryButtonIcon, AppBarConfig appBarConfig) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(items, "items");
        return new GuidelinesViewData(title, subtitle, items, isListView, showDragIndicator, primaryButtonText, primaryButtonIcon, appBarConfig);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuidelinesViewData)) {
            return false;
        }
        GuidelinesViewData guidelinesViewData = (GuidelinesViewData) other;
        return Intrinsics.areEqual(this.title, guidelinesViewData.title) && Intrinsics.areEqual(this.subtitle, guidelinesViewData.subtitle) && Intrinsics.areEqual(this.items, guidelinesViewData.items) && this.isListView == guidelinesViewData.isListView && this.showDragIndicator == guidelinesViewData.showDragIndicator && this.primaryButtonText == guidelinesViewData.primaryButtonText && this.primaryButtonIcon == guidelinesViewData.primaryButtonIcon && Intrinsics.areEqual(this.appBarConfig, guidelinesViewData.appBarConfig);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int iHashCode = this.title.hashCode() * 31;
        Integer num = this.subtitle;
        int iHashCode2 = (((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.items.hashCode()) * 31;
        boolean z = this.isListView;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z2 = this.showDragIndicator;
        int iHashCode3 = (((((i + (z2 ? 1 : z2)) * 31) + Integer.hashCode(this.primaryButtonText)) * 31) + Integer.hashCode(this.primaryButtonIcon)) * 31;
        AppBarConfig appBarConfig = this.appBarConfig;
        return iHashCode3 + (appBarConfig != null ? appBarConfig.hashCode() : 0);
    }

    public String toString() {
        return "GuidelinesViewData(title=" + this.title + ", subtitle=" + this.subtitle + ", items=" + this.items + ", isListView=" + this.isListView + ", showDragIndicator=" + this.showDragIndicator + ", primaryButtonText=" + this.primaryButtonText + ", primaryButtonIcon=" + this.primaryButtonIcon + ", appBarConfig=" + this.appBarConfig + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.title, flags);
        Integer num = this.subtitle;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        List<GuidelinesItem> list = this.items;
        parcel.writeInt(list.size());
        Iterator<GuidelinesItem> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.isListView ? 1 : 0);
        parcel.writeInt(this.showDragIndicator ? 1 : 0);
        parcel.writeInt(this.primaryButtonText);
        parcel.writeInt(this.primaryButtonIcon);
        AppBarConfig appBarConfig = this.appBarConfig;
        if (appBarConfig == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            appBarConfig.writeToParcel(parcel, flags);
        }
    }

    public GuidelinesViewData(CompoundTextResource title, Integer num, List<GuidelinesItem> items, boolean z, boolean z2, int i, int i2, AppBarConfig appBarConfig) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(items, "items");
        this.title = title;
        this.subtitle = num;
        this.items = items;
        this.isListView = z;
        this.showDragIndicator = z2;
        this.primaryButtonText = i;
        this.primaryButtonIcon = i2;
        this.appBarConfig = appBarConfig;
    }

    public final CompoundTextResource getTitle() {
        return this.title;
    }

    public final Integer getSubtitle() {
        return this.subtitle;
    }

    public final List<GuidelinesItem> getItems() {
        return this.items;
    }

    public final boolean isListView() {
        return this.isListView;
    }

    public final boolean getShowDragIndicator() {
        return this.showDragIndicator;
    }

    public final int getPrimaryButtonText() {
        return this.primaryButtonText;
    }

    public final int getPrimaryButtonIcon() {
        return this.primaryButtonIcon;
    }

    public final AppBarConfig getAppBarConfig() {
        return this.appBarConfig;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuidelinesViewData(int i, Integer num, List<GuidelinesItem> items, boolean z, boolean z2, int i2, int i3, AppBarConfig appBarConfig) {
        this(new CompoundTextResource(i, (StringTransformation) null, 2, (DefaultConstructorMarker) null), num, items, z, z2, i2, i3, appBarConfig);
        Intrinsics.checkNotNullParameter(items, "items");
    }
}
