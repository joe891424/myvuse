package com.yoti.mobile.android.yotisdkcore.applicant_profile.domain.model;

import com.yoti.mobile.android.remote.RemoteDefsKt;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\r\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/DateOfBirthEntity;", "", "_date", "", "(Ljava/lang/String;)V", "date", "Ljava/util/Date;", "getDate", "()Ljava/util/Date;", "patternType", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/DateOfBirthEntity$DatePatternType;", "getPatternType", "()Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/DateOfBirthEntity$DatePatternType;", "component1", "copy", "equals", "", "other", "hashCode", "", "parseDate", "dateString", "pattern", "toString", "DatePatternType", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class DateOfBirthEntity {
    private final String _date;
    private final Date date;
    private final DatePatternType patternType;

    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/DateOfBirthEntity$DatePatternType;", "", "pattern", "", "regex", "Lkotlin/text/Regex;", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/text/Regex;)V", "getPattern", "()Ljava/lang/String;", "getRegex", "()Lkotlin/text/Regex;", "PATTERN_YYYY_MM_DD", "PATTERN_YYYY_MM", "PATTERN_YYYY", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public enum DatePatternType {
        PATTERN_YYYY_MM_DD(RemoteDefsKt.DATE_FORMAT, new Regex("\\d{4}-\\d{2}-\\d{2}")),
        PATTERN_YYYY_MM("yyyy-MM", new Regex("\\d{4}-\\d{2}")),
        PATTERN_YYYY("yyyy", new Regex("\\d{4}"));

        private final String pattern;
        private final Regex regex;

        DatePatternType(String str, Regex regex) {
            this.pattern = str;
            this.regex = regex;
        }

        public final String getPattern() {
            return this.pattern;
        }

        public final Regex getRegex() {
            return this.regex;
        }
    }

    public DateOfBirthEntity(String _date) {
        DatePatternType datePatternType;
        Intrinsics.checkNotNullParameter(_date, "_date");
        this._date = _date;
        DatePatternType[] datePatternTypeArrValues = DatePatternType.values();
        int length = datePatternTypeArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                datePatternType = null;
                break;
            }
            datePatternType = datePatternTypeArrValues[i];
            if (datePatternType.getRegex().matches(this._date)) {
                break;
            } else {
                i++;
            }
        }
        if (datePatternType == null) {
            throw new IllegalArgumentException("Illegal date of birth format: " + this._date);
        }
        this.patternType = datePatternType;
        this.date = parseDate(this._date, datePatternType.getPattern());
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final String get_date() {
        return this._date;
    }

    public static /* synthetic */ DateOfBirthEntity copy$default(DateOfBirthEntity dateOfBirthEntity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dateOfBirthEntity._date;
        }
        return dateOfBirthEntity.copy(str);
    }

    private final Date parseDate(String dateString, String pattern) {
        Date date = new SimpleDateFormat(pattern, Locale.ENGLISH).parse(dateString);
        if (date != null) {
            return date;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final DateOfBirthEntity copy(String _date) {
        Intrinsics.checkNotNullParameter(_date, "_date");
        return new DateOfBirthEntity(_date);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DateOfBirthEntity) && Intrinsics.areEqual(this._date, ((DateOfBirthEntity) other)._date);
    }

    public final Date getDate() {
        return this.date;
    }

    public final DatePatternType getPatternType() {
        return this.patternType;
    }

    public int hashCode() {
        return this._date.hashCode();
    }

    public String toString() {
        return "DateOfBirthEntity(_date=" + this._date + ')';
    }
}
