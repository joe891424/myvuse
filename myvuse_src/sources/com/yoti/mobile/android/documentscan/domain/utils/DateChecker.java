package com.yoti.mobile.android.documentscan.domain.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.b.b, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/domain/utils/DateChecker;", "", "()V", "dateFormat", "Ljava/text/SimpleDateFormat;", "isDateValid", "", "day", "", "month", "year", "date", "", "df", "Ljava/text/DateFormat;", "Companion", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final class DateChecker {
    private static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";

    /* JADX INFO: renamed from: a */
    @Deprecated
    public static final a f6898a = new a(null);

    /* JADX INFO: renamed from: b */
    private final SimpleDateFormat f6899b = new SimpleDateFormat(DEFAULT_DATE_FORMAT, Locale.US);

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.b.b$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m4785a(String date, DateFormat df) {
        Intrinsics.checkParameterIsNotNull(date, "date");
        Intrinsics.checkParameterIsNotNull(df, "df");
        try {
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException unused) {
            return false;
        }
    }
}
