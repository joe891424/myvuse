package com.yoti.mobile.android.documentcapture.view.selection;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001d"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/CountryNotListedViewData;", "Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionOptionViewData;", "optionLabelId", "", "sectionTitle", "", "(ILjava/lang/String;)V", "getOptionLabelId", "()I", "getSectionTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "getLabel", "context", "Landroid/content/Context;", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class CountryNotListedViewData extends CountrySelectionOptionViewData {
    public static final Parcelable.Creator<CountryNotListedViewData> CREATOR = new Creator();
    private final int optionLabelId;
    private final String sectionTitle;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<CountryNotListedViewData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CountryNotListedViewData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CountryNotListedViewData(parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CountryNotListedViewData[] newArray(int i) {
            return new CountryNotListedViewData[i];
        }
    }

    public /* synthetic */ CountryNotListedViewData(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? "#" : str);
    }

    public static /* synthetic */ CountryNotListedViewData copy$default(CountryNotListedViewData countryNotListedViewData, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = countryNotListedViewData.optionLabelId;
        }
        if ((i2 & 2) != 0) {
            str = countryNotListedViewData.sectionTitle;
        }
        return countryNotListedViewData.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getOptionLabelId() {
        return this.optionLabelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSectionTitle() {
        return this.sectionTitle;
    }

    public final CountryNotListedViewData copy(int optionLabelId, String sectionTitle) {
        Intrinsics.checkNotNullParameter(sectionTitle, "sectionTitle");
        return new CountryNotListedViewData(optionLabelId, sectionTitle);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CountryNotListedViewData)) {
            return false;
        }
        CountryNotListedViewData countryNotListedViewData = (CountryNotListedViewData) other;
        return this.optionLabelId == countryNotListedViewData.optionLabelId && Intrinsics.areEqual(this.sectionTitle, countryNotListedViewData.sectionTitle);
    }

    @Override // com.yoti.mobile.android.documentcapture.view.selection.CountrySelectionOptionViewData
    public String getLabel(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(this.optionLabelId);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(optionLabelId)");
        return string;
    }

    public final int getOptionLabelId() {
        return this.optionLabelId;
    }

    public final String getSectionTitle() {
        return this.sectionTitle;
    }

    public int hashCode() {
        return (Integer.hashCode(this.optionLabelId) * 31) + this.sectionTitle.hashCode();
    }

    public String toString() {
        return "CountryNotListedViewData(optionLabelId=" + this.optionLabelId + ", sectionTitle=" + this.sectionTitle + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.optionLabelId);
        parcel.writeString(this.sectionTitle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountryNotListedViewData(int i, String sectionTitle) {
        super(null);
        Intrinsics.checkNotNullParameter(sectionTitle, "sectionTitle");
        this.optionLabelId = i;
        this.sectionTitle = sectionTitle;
    }
}
