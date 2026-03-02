package com.yoti.mobile.android.commonui;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.common.p049ui.widgets.CompoundTextResource;
import com.yoti.mobile.android.common.p049ui.widgets.StringTransformation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GuidelinesViewData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006B'\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J0\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/GuidelinesItem;", "Landroid/os/Parcelable;", "icon", "", "header", "text", "(ILjava/lang/Integer;Ljava/lang/Integer;)V", "Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;", "(ILjava/lang/Integer;Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;)V", "getHeader", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIcon", "()I", "getText", "()Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;", "component1", "component2", "component3", "copy", "(ILjava/lang/Integer;Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;)Lcom/yoti/mobile/android/commonui/GuidelinesItem;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class GuidelinesItem implements Parcelable {
    public static final Parcelable.Creator<GuidelinesItem> CREATOR = new Creator();
    private final Integer header;
    private final int icon;
    private final CompoundTextResource text;

    /* JADX INFO: compiled from: GuidelinesViewData.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<GuidelinesItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GuidelinesItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GuidelinesItem(parcel.readInt(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), (CompoundTextResource) parcel.readParcelable(GuidelinesItem.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GuidelinesItem[] newArray(int i) {
            return new GuidelinesItem[i];
        }
    }

    public static /* synthetic */ GuidelinesItem copy$default(GuidelinesItem guidelinesItem, int i, Integer num, CompoundTextResource compoundTextResource, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = guidelinesItem.icon;
        }
        if ((i2 & 2) != 0) {
            num = guidelinesItem.header;
        }
        if ((i2 & 4) != 0) {
            compoundTextResource = guidelinesItem.text;
        }
        return guidelinesItem.copy(i, num, compoundTextResource);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getHeader() {
        return this.header;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CompoundTextResource getText() {
        return this.text;
    }

    public final GuidelinesItem copy(int icon, Integer header, CompoundTextResource text) {
        return new GuidelinesItem(icon, header, text);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuidelinesItem)) {
            return false;
        }
        GuidelinesItem guidelinesItem = (GuidelinesItem) other;
        return this.icon == guidelinesItem.icon && Intrinsics.areEqual(this.header, guidelinesItem.header) && Intrinsics.areEqual(this.text, guidelinesItem.text);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.icon) * 31;
        Integer num = this.header;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        CompoundTextResource compoundTextResource = this.text;
        return iHashCode2 + (compoundTextResource != null ? compoundTextResource.hashCode() : 0);
    }

    public String toString() {
        return "GuidelinesItem(icon=" + this.icon + ", header=" + this.header + ", text=" + this.text + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.icon);
        Integer num = this.header;
        if (num == null) {
            iIntValue = 0;
        } else {
            parcel.writeInt(1);
            iIntValue = num.intValue();
        }
        parcel.writeInt(iIntValue);
        parcel.writeParcelable(this.text, flags);
    }

    public GuidelinesItem(int i, Integer num, CompoundTextResource compoundTextResource) {
        this.icon = i;
        this.header = num;
        this.text = compoundTextResource;
    }

    public /* synthetic */ GuidelinesItem(int i, Integer num, CompoundTextResource compoundTextResource, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : compoundTextResource);
    }

    public final int getIcon() {
        return this.icon;
    }

    public final Integer getHeader() {
        return this.header;
    }

    public final CompoundTextResource getText() {
        return this.text;
    }

    public /* synthetic */ GuidelinesItem(int i, Integer num, Integer num2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : num2);
    }

    public GuidelinesItem(int i, Integer num, Integer num2) {
        this(i, num, num2 != null ? new CompoundTextResource(num2.intValue(), (StringTransformation) null, 2, (DefaultConstructorMarker) null) : null);
    }
}
