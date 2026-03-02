package com.yoti.mobile.android.documentscan.model.result;

import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m5598d2 = {"DEFAULT_LOCALE", "Ljava/util/Locale;", "kotlin.jvm.PlatformType", "DEFAULT_TIME_ZONE", "Ljava/util/TimeZone;", "documentscan_release"}, m5599k = 2, m5600mv = {1, 1, 15})
public final class DateResultKt {
    private static final Locale DEFAULT_LOCALE = Locale.US;
    private static final TimeZone DEFAULT_TIME_ZONE;

    static {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        Intrinsics.checkExpressionValueIsNotNull(timeZone, "TimeZone.getTimeZone(\"UTC\")");
        DEFAULT_TIME_ZONE = timeZone;
    }
}
