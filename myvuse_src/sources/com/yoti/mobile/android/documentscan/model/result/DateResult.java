package com.yoti.mobile.android.documentscan.model.result;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B3\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÂ\u0003¢\u0006\u0002\u0010\u0015J>\u0010\u001b\u001a\u00020\u00002\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\tHÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\tHÖ\u0001J\f\u0010*\u001a\u00020\u0003*\u00020\u0003H\u0002R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0012\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0016\u0010\u000f¨\u0006+"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/model/result/DateResult;", "Landroid/os/Parcelable;", "timeInMS", "", "(J)V", "calendar", "Ljava/util/Calendar;", "(Ljava/util/Calendar;)V", "day", "", "month", "year", "timeInMillis", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)V", "getDay", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMonth", "Ljava/lang/Long;", "timeStamp", "getTimeStamp", "()Ljava/lang/Long;", "getYear", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/yoti/mobile/android/documentscan/model/result/DateResult;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "toTimeStamp", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final /* data */ class DateResult implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final Integer day;
    private final Integer month;
    private final Long timeInMillis;
    private final Integer year;

    @Metadata(m5596bv = {1, 0, 3}, m5599k = 3, m5600mv = {1, 1, 15})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel in) {
            Intrinsics.checkParameterIsNotNull(in, "in");
            return new DateResult(in.readInt() != 0 ? Integer.valueOf(in.readInt()) : null, in.readInt() != 0 ? Integer.valueOf(in.readInt()) : null, in.readInt() != 0 ? Integer.valueOf(in.readInt()) : null, in.readInt() != 0 ? Long.valueOf(in.readLong()) : null);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new DateResult[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DateResult(long j) {
        Calendar calendar = Calendar.getInstance(DateResultKt.DEFAULT_TIME_ZONE, DateResultKt.DEFAULT_LOCALE);
        calendar.setTimeInMillis(j);
        Intrinsics.checkExpressionValueIsNotNull(calendar, "Calendar.getInstance(DEF…timeInMillis = timeInMS }");
        this(calendar);
    }

    public DateResult(Integer num, Integer num2, Integer num3, Long l) {
        this.day = num;
        this.month = num2;
        this.year = num3;
        this.timeInMillis = l;
    }

    private DateResult(Calendar calendar) {
        this(Integer.valueOf(calendar.get(5)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(1)), Long.valueOf(calendar.getTimeInMillis()));
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final Long getTimeInMillis() {
        return this.timeInMillis;
    }

    public static /* synthetic */ DateResult copy$default(DateResult dateResult, Integer num, Integer num2, Integer num3, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            num = dateResult.day;
        }
        if ((i & 2) != 0) {
            num2 = dateResult.month;
        }
        if ((i & 4) != 0) {
            num3 = dateResult.year;
        }
        if ((i & 8) != 0) {
            l = dateResult.timeInMillis;
        }
        return dateResult.copy(num, num2, num3, l);
    }

    private final long toTimeStamp(long j) {
        return j / 1000;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getDay() {
        return this.day;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getMonth() {
        return this.month;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getYear() {
        return this.year;
    }

    public final DateResult copy(Integer day, Integer month, Integer year, Long timeInMillis) {
        return new DateResult(day, month, year, timeInMillis);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DateResult)) {
            return false;
        }
        DateResult dateResult = (DateResult) other;
        return Intrinsics.areEqual(this.day, dateResult.day) && Intrinsics.areEqual(this.month, dateResult.month) && Intrinsics.areEqual(this.year, dateResult.year) && Intrinsics.areEqual(this.timeInMillis, dateResult.timeInMillis);
    }

    public final Integer getDay() {
        return this.day;
    }

    public final Integer getMonth() {
        return this.month;
    }

    public final Long getTimeStamp() {
        Long l = this.timeInMillis;
        if (l != null) {
            return Long.valueOf(toTimeStamp(l.longValue()));
        }
        return null;
    }

    public final Integer getYear() {
        return this.year;
    }

    public int hashCode() {
        Integer num = this.day;
        int iHashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.month;
        int iHashCode2 = (iHashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.year;
        int iHashCode3 = (iHashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Long l = this.timeInMillis;
        return iHashCode3 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "DateResult(day=" + this.day + ", month=" + this.month + ", year=" + this.year + ", timeInMillis=" + this.timeInMillis + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        Integer num = this.day;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num2 = this.month;
        if (num2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num3 = this.year;
        if (num3 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        } else {
            parcel.writeInt(0);
        }
        Long l = this.timeInMillis;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
    }
}
