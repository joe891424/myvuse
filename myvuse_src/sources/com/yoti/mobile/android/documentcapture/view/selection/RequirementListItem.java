package com.yoti.mobile.android.documentcapture.view.selection;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.common.p049ui.widgets.CompoundTextResource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006!"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/RequirementListItem;", "Landroid/os/Parcelable;", "icon", "", "header", "text", "Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;", "textSecondary", "(IILcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;)V", "getHeader", "()I", "getIcon", "getText", "()Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;", "getTextSecondary", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class RequirementListItem implements Parcelable {
    public static final Parcelable.Creator<RequirementListItem> CREATOR = new Creator();
    private final int header;
    private final int icon;
    private final CompoundTextResource text;
    private final CompoundTextResource textSecondary;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<RequirementListItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RequirementListItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RequirementListItem(parcel.readInt(), parcel.readInt(), (CompoundTextResource) parcel.readParcelable(RequirementListItem.class.getClassLoader()), (CompoundTextResource) parcel.readParcelable(RequirementListItem.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RequirementListItem[] newArray(int i) {
            return new RequirementListItem[i];
        }
    }

    public RequirementListItem(int i, int i2, CompoundTextResource compoundTextResource, CompoundTextResource compoundTextResource2) {
        this.icon = i;
        this.header = i2;
        this.text = compoundTextResource;
        this.textSecondary = compoundTextResource2;
    }

    public static /* synthetic */ RequirementListItem copy$default(RequirementListItem requirementListItem, int i, int i2, CompoundTextResource compoundTextResource, CompoundTextResource compoundTextResource2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = requirementListItem.icon;
        }
        if ((i3 & 2) != 0) {
            i2 = requirementListItem.header;
        }
        if ((i3 & 4) != 0) {
            compoundTextResource = requirementListItem.text;
        }
        if ((i3 & 8) != 0) {
            compoundTextResource2 = requirementListItem.textSecondary;
        }
        return requirementListItem.copy(i, i2, compoundTextResource, compoundTextResource2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getHeader() {
        return this.header;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CompoundTextResource getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final CompoundTextResource getTextSecondary() {
        return this.textSecondary;
    }

    public final RequirementListItem copy(int icon, int header, CompoundTextResource text, CompoundTextResource textSecondary) {
        return new RequirementListItem(icon, header, text, textSecondary);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequirementListItem)) {
            return false;
        }
        RequirementListItem requirementListItem = (RequirementListItem) other;
        return this.icon == requirementListItem.icon && this.header == requirementListItem.header && Intrinsics.areEqual(this.text, requirementListItem.text) && Intrinsics.areEqual(this.textSecondary, requirementListItem.textSecondary);
    }

    public final int getHeader() {
        return this.header;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final CompoundTextResource getText() {
        return this.text;
    }

    public final CompoundTextResource getTextSecondary() {
        return this.textSecondary;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.icon) * 31) + Integer.hashCode(this.header)) * 31;
        CompoundTextResource compoundTextResource = this.text;
        int iHashCode2 = (iHashCode + (compoundTextResource == null ? 0 : compoundTextResource.hashCode())) * 31;
        CompoundTextResource compoundTextResource2 = this.textSecondary;
        return iHashCode2 + (compoundTextResource2 != null ? compoundTextResource2.hashCode() : 0);
    }

    public String toString() {
        return "RequirementListItem(icon=" + this.icon + ", header=" + this.header + ", text=" + this.text + ", textSecondary=" + this.textSecondary + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.icon);
        parcel.writeInt(this.header);
        parcel.writeParcelable(this.text, flags);
        parcel.writeParcelable(this.textSecondary, flags);
    }

    public /* synthetic */ RequirementListItem(int i, int i2, CompoundTextResource compoundTextResource, CompoundTextResource compoundTextResource2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? null : compoundTextResource, (i3 & 8) != 0 ? null : compoundTextResource2);
    }
}
