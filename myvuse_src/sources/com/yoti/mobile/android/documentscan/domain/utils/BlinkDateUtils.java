package com.yoti.mobile.android.documentscan.domain.utils;

import com.microblink.results.date.Date;
import com.yoti.mobile.android.documentscan.model.result.DateResult;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.b.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bJ\u0012\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\bH\u0002J\"\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/domain/utils/BlinkDateUtils;", "", "dateChecker", "Lcom/yoti/mobile/android/documentscan/domain/utils/DateChecker;", "(Lcom/yoti/mobile/android/documentscan/domain/utils/DateChecker;)V", "getTimeStamp", "", "date", "Lcom/microblink/results/date/Date;", "parseBlinkDate", "Ljava/util/Calendar;", "blinkDate", "parseDateWith", "Lcom/yoti/mobile/android/documentscan/model/result/DateResult;", "dateOfBirth", "", "pattern", "Ljava/util/regex/Pattern;", "dateFormat", "Ljava/text/SimpleDateFormat;", "parseStringDate", "parseUSDLDateFormat", "blinkUSDLDate", "Companion", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final class BlinkDateUtils {
    private static final String REGEX_DDMMYYYY = "(\\d{2})[\\.|\\-|\\/| ](\\d{2})[\\.|\\-|\\/| ](\\d{4})";
    private static final String REGEX_MMDDYYYY = "(\\d{2})(\\d{2})(\\d{4})";
    private static final String REGEX_YYYYMMDD = "(\\d{4})[\\.|\\-|\\/| ](\\d{2})[\\.|\\-|\\/| ](\\d{2})";

    /* JADX INFO: renamed from: a */
    private static final Locale f6888a;

    /* JADX INFO: renamed from: b */
    private static final TimeZone f6889b;

    /* JADX INFO: renamed from: c */
    private static final SimpleDateFormat f6890c;

    /* JADX INFO: renamed from: d */
    private static final SimpleDateFormat f6891d;

    /* JADX INFO: renamed from: e */
    private static final SimpleDateFormat f6892e;

    /* JADX INFO: renamed from: f */
    private static final Pattern f6893f;

    /* JADX INFO: renamed from: g */
    private static final Pattern f6894g;

    /* JADX INFO: renamed from: h */
    private static final Pattern f6895h;

    /* JADX INFO: renamed from: i */
    public static final a f6896i = new a(null);

    /* JADX INFO: renamed from: j */
    private final DateChecker f6897j;

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.b.a$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Locale locale = Locale.US;
        f6888a = locale;
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        f6889b = timeZone;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", locale);
        simpleDateFormat.setTimeZone(timeZone);
        f6890c = simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd", locale);
        simpleDateFormat2.setTimeZone(timeZone);
        f6891d = simpleDateFormat2;
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("MM/dd/yyyy", locale);
        simpleDateFormat3.setTimeZone(timeZone);
        f6892e = simpleDateFormat3;
        f6893f = Pattern.compile(REGEX_DDMMYYYY);
        f6894g = Pattern.compile(REGEX_YYYYMMDD);
        f6895h = Pattern.compile(REGEX_MMDDYYYY);
    }

    public BlinkDateUtils(DateChecker dateChecker) {
        Intrinsics.checkParameterIsNotNull(dateChecker, "dateChecker");
        this.f6897j = dateChecker;
    }

    /* JADX INFO: renamed from: a */
    private final DateResult m4780a(String str, Pattern pattern, SimpleDateFormat simpleDateFormat) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return null;
        }
        String str2 = matcher.group(1) + '/' + matcher.group(2) + '/' + matcher.group(3);
        if (!this.f6897j.m4785a(str2, simpleDateFormat)) {
            return null;
        }
        Calendar calendar = Calendar.getInstance(f6889b, f6888a);
        calendar.setTime(simpleDateFormat.parse(str2));
        return new DateResult(calendar.getTimeInMillis());
    }

    /* JADX INFO: renamed from: b */
    private final Calendar m4781b(Date date) {
        Calendar dateBuilder = Calendar.getInstance(f6889b, f6888a);
        dateBuilder.clear();
        dateBuilder.set(date.getYear(), date.getMonth() - 1, date.getDay());
        Intrinsics.checkExpressionValueIsNotNull(dateBuilder, "dateBuilder");
        return dateBuilder;
    }

    /* JADX INFO: renamed from: a */
    public final long m4782a(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "date");
        return m4781b(date).getTimeInMillis();
    }

    /* JADX INFO: renamed from: a */
    public final DateResult m4783a(String str) {
        if (str == null) {
            return null;
        }
        Pattern PATTERN_CANDIDATE_1 = f6893f;
        Intrinsics.checkExpressionValueIsNotNull(PATTERN_CANDIDATE_1, "PATTERN_CANDIDATE_1");
        DateResult dateResultM4780a = m4780a(str, PATTERN_CANDIDATE_1, f6890c);
        if (dateResultM4780a != null) {
            return dateResultM4780a;
        }
        Pattern PATTERN_CANDIDATE_2 = f6894g;
        Intrinsics.checkExpressionValueIsNotNull(PATTERN_CANDIDATE_2, "PATTERN_CANDIDATE_2");
        DateResult dateResultM4780a2 = m4780a(str, PATTERN_CANDIDATE_2, f6891d);
        if (dateResultM4780a2 != null) {
            return dateResultM4780a2;
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public final DateResult m4784b(String blinkUSDLDate) {
        Intrinsics.checkParameterIsNotNull(blinkUSDLDate, "blinkUSDLDate");
        Pattern PATTERN_CANDIDATE_US = f6895h;
        Intrinsics.checkExpressionValueIsNotNull(PATTERN_CANDIDATE_US, "PATTERN_CANDIDATE_US");
        return m4780a(blinkUSDLDate, PATTERN_CANDIDATE_US, f6892e);
    }
}
