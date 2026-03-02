package com.yoti.mobile.android.documentcapture.view.selection;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.common.p049ui.widgets.CompoundTextResource;
import com.yoti.mobile.android.commonui.GuidelinesViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\u000bHÆ\u0003JA\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\bHÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\bHÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006)"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentRequirementsViewData;", "Landroid/os/Parcelable;", "title", "Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;", "listItems", "", "Lcom/yoti/mobile/android/documentcapture/view/selection/RequirementListItem;", "primaryCtaText", "", "secondaryCtaText", "guidelinesViewData", "Lcom/yoti/mobile/android/commonui/GuidelinesViewData;", "(Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;Ljava/util/List;IILcom/yoti/mobile/android/commonui/GuidelinesViewData;)V", "getGuidelinesViewData", "()Lcom/yoti/mobile/android/commonui/GuidelinesViewData;", "getListItems", "()Ljava/util/List;", "getPrimaryCtaText", "()I", "getSecondaryCtaText", "getTitle", "()Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class DocumentRequirementsViewData implements Parcelable {
    public static final Parcelable.Creator<DocumentRequirementsViewData> CREATOR = new Creator();
    private final GuidelinesViewData guidelinesViewData;
    private final List<RequirementListItem> listItems;
    private final int primaryCtaText;
    private final int secondaryCtaText;
    private final CompoundTextResource title;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<DocumentRequirementsViewData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DocumentRequirementsViewData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            CompoundTextResource compoundTextResource = (CompoundTextResource) parcel.readParcelable(DocumentRequirementsViewData.class.getClassLoader());
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(RequirementListItem.CREATOR.createFromParcel(parcel));
            }
            return new DocumentRequirementsViewData(compoundTextResource, arrayList, parcel.readInt(), parcel.readInt(), (GuidelinesViewData) parcel.readParcelable(DocumentRequirementsViewData.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DocumentRequirementsViewData[] newArray(int i) {
            return new DocumentRequirementsViewData[i];
        }
    }

    public DocumentRequirementsViewData(CompoundTextResource title, List<RequirementListItem> listItems, int i, int i2, GuidelinesViewData guidelinesViewData) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(listItems, "listItems");
        Intrinsics.checkNotNullParameter(guidelinesViewData, "guidelinesViewData");
        this.title = title;
        this.listItems = listItems;
        this.primaryCtaText = i;
        this.secondaryCtaText = i2;
        this.guidelinesViewData = guidelinesViewData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DocumentRequirementsViewData copy$default(DocumentRequirementsViewData documentRequirementsViewData, CompoundTextResource compoundTextResource, List list, int i, int i2, GuidelinesViewData guidelinesViewData, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            compoundTextResource = documentRequirementsViewData.title;
        }
        if ((i3 & 2) != 0) {
            list = documentRequirementsViewData.listItems;
        }
        List list2 = list;
        if ((i3 & 4) != 0) {
            i = documentRequirementsViewData.primaryCtaText;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = documentRequirementsViewData.secondaryCtaText;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            guidelinesViewData = documentRequirementsViewData.guidelinesViewData;
        }
        return documentRequirementsViewData.copy(compoundTextResource, list2, i4, i5, guidelinesViewData);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CompoundTextResource getTitle() {
        return this.title;
    }

    public final List<RequirementListItem> component2() {
        return this.listItems;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPrimaryCtaText() {
        return this.primaryCtaText;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getSecondaryCtaText() {
        return this.secondaryCtaText;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final GuidelinesViewData getGuidelinesViewData() {
        return this.guidelinesViewData;
    }

    public final DocumentRequirementsViewData copy(CompoundTextResource title, List<RequirementListItem> listItems, int primaryCtaText, int secondaryCtaText, GuidelinesViewData guidelinesViewData) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(listItems, "listItems");
        Intrinsics.checkNotNullParameter(guidelinesViewData, "guidelinesViewData");
        return new DocumentRequirementsViewData(title, listItems, primaryCtaText, secondaryCtaText, guidelinesViewData);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentRequirementsViewData)) {
            return false;
        }
        DocumentRequirementsViewData documentRequirementsViewData = (DocumentRequirementsViewData) other;
        return Intrinsics.areEqual(this.title, documentRequirementsViewData.title) && Intrinsics.areEqual(this.listItems, documentRequirementsViewData.listItems) && this.primaryCtaText == documentRequirementsViewData.primaryCtaText && this.secondaryCtaText == documentRequirementsViewData.secondaryCtaText && Intrinsics.areEqual(this.guidelinesViewData, documentRequirementsViewData.guidelinesViewData);
    }

    public final GuidelinesViewData getGuidelinesViewData() {
        return this.guidelinesViewData;
    }

    public final List<RequirementListItem> getListItems() {
        return this.listItems;
    }

    public final int getPrimaryCtaText() {
        return this.primaryCtaText;
    }

    public final int getSecondaryCtaText() {
        return this.secondaryCtaText;
    }

    public final CompoundTextResource getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((this.title.hashCode() * 31) + this.listItems.hashCode()) * 31) + Integer.hashCode(this.primaryCtaText)) * 31) + Integer.hashCode(this.secondaryCtaText)) * 31) + this.guidelinesViewData.hashCode();
    }

    public String toString() {
        return "DocumentRequirementsViewData(title=" + this.title + ", listItems=" + this.listItems + ", primaryCtaText=" + this.primaryCtaText + ", secondaryCtaText=" + this.secondaryCtaText + ", guidelinesViewData=" + this.guidelinesViewData + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.title, flags);
        List<RequirementListItem> list = this.listItems;
        parcel.writeInt(list.size());
        Iterator<RequirementListItem> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.primaryCtaText);
        parcel.writeInt(this.secondaryCtaText);
        parcel.writeParcelable(this.guidelinesViewData, flags);
    }
}
