package com.yoti.mobile.android.commonui.moreabout;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.commonui.C4590R;
import com.yoti.mobile.android.commonui.moreabout.MoreAboutItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MoreAboutFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0003\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003J\t\u0010 \u001a\u00020\u000eHÆ\u0003JS\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\t\u0010\"\u001a\u00020\fHÖ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\fHÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\fHÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006/"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutFragmentContent;", "Landroid/os/Parcelable;", "titleItem", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem$MoreAboutTitleItem;", "descriptionItems", "", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem$MoreAboutDescItem;", "accordionItems", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem$MoreAboutAccordionItem;", "logoItem", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem$MoreAboutLogoItem;", "buttonResId", "", "navigationIcon", "Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "(Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem$MoreAboutTitleItem;Ljava/util/List;Ljava/util/List;Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem$MoreAboutLogoItem;ILcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;)V", "getAccordionItems", "()Ljava/util/List;", "getButtonResId", "()I", "getDescriptionItems", "getLogoItem", "()Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem$MoreAboutLogoItem;", "getNavigationIcon", "()Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "getTitleItem", "()Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutItem$MoreAboutTitleItem;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class MoreAboutFragmentContent implements Parcelable {
    public static final Parcelable.Creator<MoreAboutFragmentContent> CREATOR = new Creator();
    private final List<MoreAboutItem.MoreAboutAccordionItem> accordionItems;
    private final int buttonResId;
    private final List<MoreAboutItem.MoreAboutDescItem> descriptionItems;
    private final MoreAboutItem.MoreAboutLogoItem logoItem;
    private final NavigationIcon navigationIcon;
    private final MoreAboutItem.MoreAboutTitleItem titleItem;

    /* JADX INFO: compiled from: MoreAboutFragment.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<MoreAboutFragmentContent> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MoreAboutFragmentContent createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            MoreAboutItem.MoreAboutTitleItem moreAboutTitleItemCreateFromParcel = MoreAboutItem.MoreAboutTitleItem.CREATOR.createFromParcel(parcel);
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(MoreAboutItem.MoreAboutDescItem.CREATOR.createFromParcel(parcel));
            }
            ArrayList arrayList2 = arrayList;
            int i3 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(i3);
            for (int i4 = 0; i4 != i3; i4++) {
                arrayList3.add(MoreAboutItem.MoreAboutAccordionItem.CREATOR.createFromParcel(parcel));
            }
            return new MoreAboutFragmentContent(moreAboutTitleItemCreateFromParcel, arrayList2, arrayList3, parcel.readInt() == 0 ? null : MoreAboutItem.MoreAboutLogoItem.CREATOR.createFromParcel(parcel), parcel.readInt(), NavigationIcon.valueOf(parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MoreAboutFragmentContent[] newArray(int i) {
            return new MoreAboutFragmentContent[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MoreAboutFragmentContent copy$default(MoreAboutFragmentContent moreAboutFragmentContent, MoreAboutItem.MoreAboutTitleItem moreAboutTitleItem, List list, List list2, MoreAboutItem.MoreAboutLogoItem moreAboutLogoItem, int i, NavigationIcon navigationIcon, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            moreAboutTitleItem = moreAboutFragmentContent.titleItem;
        }
        if ((i2 & 2) != 0) {
            list = moreAboutFragmentContent.descriptionItems;
        }
        List list3 = list;
        if ((i2 & 4) != 0) {
            list2 = moreAboutFragmentContent.accordionItems;
        }
        List list4 = list2;
        if ((i2 & 8) != 0) {
            moreAboutLogoItem = moreAboutFragmentContent.logoItem;
        }
        MoreAboutItem.MoreAboutLogoItem moreAboutLogoItem2 = moreAboutLogoItem;
        if ((i2 & 16) != 0) {
            i = moreAboutFragmentContent.buttonResId;
        }
        int i3 = i;
        if ((i2 & 32) != 0) {
            navigationIcon = moreAboutFragmentContent.navigationIcon;
        }
        return moreAboutFragmentContent.copy(moreAboutTitleItem, list3, list4, moreAboutLogoItem2, i3, navigationIcon);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MoreAboutItem.MoreAboutTitleItem getTitleItem() {
        return this.titleItem;
    }

    public final List<MoreAboutItem.MoreAboutDescItem> component2() {
        return this.descriptionItems;
    }

    public final List<MoreAboutItem.MoreAboutAccordionItem> component3() {
        return this.accordionItems;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MoreAboutItem.MoreAboutLogoItem getLogoItem() {
        return this.logoItem;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getButtonResId() {
        return this.buttonResId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final NavigationIcon getNavigationIcon() {
        return this.navigationIcon;
    }

    public final MoreAboutFragmentContent copy(MoreAboutItem.MoreAboutTitleItem titleItem, List<MoreAboutItem.MoreAboutDescItem> descriptionItems, List<MoreAboutItem.MoreAboutAccordionItem> accordionItems, MoreAboutItem.MoreAboutLogoItem logoItem, int buttonResId, NavigationIcon navigationIcon) {
        Intrinsics.checkNotNullParameter(titleItem, "titleItem");
        Intrinsics.checkNotNullParameter(descriptionItems, "descriptionItems");
        Intrinsics.checkNotNullParameter(accordionItems, "accordionItems");
        Intrinsics.checkNotNullParameter(navigationIcon, "navigationIcon");
        return new MoreAboutFragmentContent(titleItem, descriptionItems, accordionItems, logoItem, buttonResId, navigationIcon);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MoreAboutFragmentContent)) {
            return false;
        }
        MoreAboutFragmentContent moreAboutFragmentContent = (MoreAboutFragmentContent) other;
        return Intrinsics.areEqual(this.titleItem, moreAboutFragmentContent.titleItem) && Intrinsics.areEqual(this.descriptionItems, moreAboutFragmentContent.descriptionItems) && Intrinsics.areEqual(this.accordionItems, moreAboutFragmentContent.accordionItems) && Intrinsics.areEqual(this.logoItem, moreAboutFragmentContent.logoItem) && this.buttonResId == moreAboutFragmentContent.buttonResId && this.navigationIcon == moreAboutFragmentContent.navigationIcon;
    }

    public int hashCode() {
        int iHashCode = ((((this.titleItem.hashCode() * 31) + this.descriptionItems.hashCode()) * 31) + this.accordionItems.hashCode()) * 31;
        MoreAboutItem.MoreAboutLogoItem moreAboutLogoItem = this.logoItem;
        return ((((iHashCode + (moreAboutLogoItem == null ? 0 : moreAboutLogoItem.hashCode())) * 31) + Integer.hashCode(this.buttonResId)) * 31) + this.navigationIcon.hashCode();
    }

    public String toString() {
        return "MoreAboutFragmentContent(titleItem=" + this.titleItem + ", descriptionItems=" + this.descriptionItems + ", accordionItems=" + this.accordionItems + ", logoItem=" + this.logoItem + ", buttonResId=" + this.buttonResId + ", navigationIcon=" + this.navigationIcon + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.titleItem.writeToParcel(parcel, flags);
        List<MoreAboutItem.MoreAboutDescItem> list = this.descriptionItems;
        parcel.writeInt(list.size());
        Iterator<MoreAboutItem.MoreAboutDescItem> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
        List<MoreAboutItem.MoreAboutAccordionItem> list2 = this.accordionItems;
        parcel.writeInt(list2.size());
        Iterator<MoreAboutItem.MoreAboutAccordionItem> it3 = list2.iterator();
        while (it3.hasNext()) {
            it3.next().writeToParcel(parcel, flags);
        }
        MoreAboutItem.MoreAboutLogoItem moreAboutLogoItem = this.logoItem;
        if (moreAboutLogoItem == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            moreAboutLogoItem.writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.buttonResId);
        parcel.writeString(this.navigationIcon.name());
    }

    public MoreAboutFragmentContent(MoreAboutItem.MoreAboutTitleItem titleItem, List<MoreAboutItem.MoreAboutDescItem> descriptionItems, List<MoreAboutItem.MoreAboutAccordionItem> accordionItems, MoreAboutItem.MoreAboutLogoItem moreAboutLogoItem, int i, NavigationIcon navigationIcon) {
        Intrinsics.checkNotNullParameter(titleItem, "titleItem");
        Intrinsics.checkNotNullParameter(descriptionItems, "descriptionItems");
        Intrinsics.checkNotNullParameter(accordionItems, "accordionItems");
        Intrinsics.checkNotNullParameter(navigationIcon, "navigationIcon");
        this.titleItem = titleItem;
        this.descriptionItems = descriptionItems;
        this.accordionItems = accordionItems;
        this.logoItem = moreAboutLogoItem;
        this.buttonResId = i;
        this.navigationIcon = navigationIcon;
    }

    public final MoreAboutItem.MoreAboutTitleItem getTitleItem() {
        return this.titleItem;
    }

    public /* synthetic */ MoreAboutFragmentContent(MoreAboutItem.MoreAboutTitleItem moreAboutTitleItem, List list, List list2, MoreAboutItem.MoreAboutLogoItem moreAboutLogoItem, int i, NavigationIcon navigationIcon, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(moreAboutTitleItem, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 8) != 0 ? null : moreAboutLogoItem, (i2 & 16) != 0 ? C4590R.string.yds_common_got_it : i, (i2 & 32) != 0 ? NavigationIcon.CLOSE_BLUE : navigationIcon);
    }

    public final List<MoreAboutItem.MoreAboutDescItem> getDescriptionItems() {
        return this.descriptionItems;
    }

    public final List<MoreAboutItem.MoreAboutAccordionItem> getAccordionItems() {
        return this.accordionItems;
    }

    public final MoreAboutItem.MoreAboutLogoItem getLogoItem() {
        return this.logoItem;
    }

    public final int getButtonResId() {
        return this.buttonResId;
    }

    public final NavigationIcon getNavigationIcon() {
        return this.navigationIcon;
    }
}
