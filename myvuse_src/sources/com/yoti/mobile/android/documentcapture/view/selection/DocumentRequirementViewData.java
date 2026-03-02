package com.yoti.mobile.android.documentcapture.view.selection;

import android.os.Parcel;
import android.os.Parcelable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentRequirementViewData;", "Landroid/os/Parcelable;", "()V", "DateFromViewData", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentRequirementViewData$DateFromViewData;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class DocumentRequirementViewData implements Parcelable {

    @Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentRequirementViewData$DateFromViewData;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentRequirementViewData;", "_date", "Ljava/util/Date;", "(Ljava/util/Date;)V", "date", "", "getDate", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class DateFromViewData extends DocumentRequirementViewData {
        public static final Parcelable.Creator<DateFromViewData> CREATOR = new Creator();
        private final Date _date;

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<DateFromViewData> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DateFromViewData createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DateFromViewData((Date) parcel.readSerializable());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DateFromViewData[] newArray(int i) {
                return new DateFromViewData[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DateFromViewData(Date _date) {
            super(null);
            Intrinsics.checkNotNullParameter(_date, "_date");
            this._date = _date;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final Date get_date() {
            return this._date;
        }

        public static /* synthetic */ DateFromViewData copy$default(DateFromViewData dateFromViewData, Date date, int i, Object obj) {
            if ((i & 1) != 0) {
                date = dateFromViewData._date;
            }
            return dateFromViewData.copy(date);
        }

        public final DateFromViewData copy(Date _date) {
            Intrinsics.checkNotNullParameter(_date, "_date");
            return new DateFromViewData(_date);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DateFromViewData) && Intrinsics.areEqual(this._date, ((DateFromViewData) other)._date);
        }

        public final String getDate() {
            String str = new SimpleDateFormat("MM / yyyy", Locale.getDefault()).format(this._date);
            Intrinsics.checkNotNullExpressionValue(str, "SimpleDateFormat(DATE_FR…tDefault()).format(_date)");
            return str;
        }

        public int hashCode() {
            return this._date.hashCode();
        }

        public String toString() {
            return "DateFromViewData(_date=" + this._date + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeSerializable(this._date);
        }
    }

    private DocumentRequirementViewData() {
    }

    public /* synthetic */ DocumentRequirementViewData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
