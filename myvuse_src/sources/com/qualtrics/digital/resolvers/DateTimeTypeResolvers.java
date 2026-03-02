package com.qualtrics.digital.resolvers;

import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.yoti.mobile.android.remote.RemoteDefsKt;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes6.dex */
public class DateTimeTypeResolvers {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(RemoteDefsKt.DATE_FORMAT);
    public static SimpleDateFormat dayFormat = new SimpleDateFormat("EEE");

    public static boolean evaluateDateTime(String str, String str2, String str3, String str4) {
        str.hashCode();
        switch (str) {
            case "DateTimeDate":
                return evaluateDateTime_Date(str2, str3, str4);
            case "DateTimeTime":
                return evaluateDateTime_Time(str2, str3, str4);
            case "DateTimeDay":
                return evaluateDateTime_Day(str2, str3, str4);
            default:
                return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean evaluateDateTime_Date(java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qualtrics.digital.resolvers.DateTimeTypeResolvers.evaluateDateTime_Date(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    public static boolean evaluateDateTime_Day(String str, String str2, String str3) {
        boolean zEquals = str2.equals(dayFormat.format(getCalendarTimeZone(str3 != null ? getValidTimeZone(str3) : null).getTime()));
        str.hashCode();
        if (str.equals("EQ")) {
            return zEquals;
        }
        if (str.equals("NEQ")) {
            return !zEquals;
        }
        StringBuilder sb = new StringBuilder("Error, unexpected date operator: ");
        if (str == null) {
            str = "";
        }
        LogInstrumentation.m2728e("Qualtrics", sb.append(str).toString());
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean evaluateDateTime_Time(java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "Error, unexpected date operator: "
            java.lang.String r1 = "Qualtrics"
            r2 = 0
            if (r10 == 0) goto Lc
            java.util.TimeZone r10 = getValidTimeZone(r10)     // Catch: java.lang.NumberFormatException -> L86
            goto Ld
        Lc:
            r10 = 0
        Ld:
            java.lang.String r3 = ":"
            java.lang.String[] r3 = r9.split(r3)     // Catch: java.lang.NumberFormatException -> L86
            java.util.Calendar r4 = getCalendarTimeZone(r10)     // Catch: java.lang.NumberFormatException -> L86
            java.util.Calendar r10 = getCalendarTimeZone(r10)     // Catch: java.lang.NumberFormatException -> L86
            r5 = r3[r2]     // Catch: java.lang.NumberFormatException -> L86
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.NumberFormatException -> L86
            r6 = 11
            r4.set(r6, r5)     // Catch: java.lang.NumberFormatException -> L86
            r5 = 1
            r3 = r3[r5]     // Catch: java.lang.NumberFormatException -> L86
            int r3 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.NumberFormatException -> L86
            r6 = 12
            r4.set(r6, r3)     // Catch: java.lang.NumberFormatException -> L86
            long r3 = r4.getTimeInMillis()     // Catch: java.lang.NumberFormatException -> L86
            long r6 = r10.getTimeInMillis()     // Catch: java.lang.NumberFormatException -> L86
            long r3 = r3 - r6
            int r10 = r8.hashCode()     // Catch: java.lang.NumberFormatException -> L86
            r6 = 2285(0x8ed, float:3.202E-42)
            if (r10 == r6) goto L52
            r6 = 2440(0x988, float:3.419E-42)
            if (r10 == r6) goto L48
            goto L5c
        L48:
            java.lang.String r10 = "LT"
            boolean r10 = r8.equals(r10)     // Catch: java.lang.NumberFormatException -> L86
            if (r10 == 0) goto L5c
            r10 = r2
            goto L5d
        L52:
            java.lang.String r10 = "GT"
            boolean r10 = r8.equals(r10)     // Catch: java.lang.NumberFormatException -> L86
            if (r10 == 0) goto L5c
            r10 = r5
            goto L5d
        L5c:
            r10 = -1
        L5d:
            if (r10 == 0) goto L7e
            if (r10 == r5) goto L76
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> L86
            r10.<init>(r0)     // Catch: java.lang.NumberFormatException -> L86
            if (r8 != 0) goto L6a
            java.lang.String r8 = ""
        L6a:
            java.lang.StringBuilder r8 = r10.append(r8)     // Catch: java.lang.NumberFormatException -> L86
            java.lang.String r8 = r8.toString()     // Catch: java.lang.NumberFormatException -> L86
            com.newrelic.agent.android.instrumentation.LogInstrumentation.m2728e(r1, r8)     // Catch: java.lang.NumberFormatException -> L86
            goto L98
        L76:
            r8 = -1000(0xfffffffffffffc18, double:NaN)
            int r8 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r8 >= 0) goto L7d
            r2 = r5
        L7d:
            return r2
        L7e:
            r8 = 1000(0x3e8, double:4.94E-321)
            int r8 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r8 <= 0) goto L85
            r2 = r5
        L85:
            return r2
        L86:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r10 = "Unexpected time number format: "
            r8.<init>(r10)
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r8 = r8.toString()
            com.newrelic.agent.android.instrumentation.LogInstrumentation.m2728e(r1, r8)
        L98:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qualtrics.digital.resolvers.DateTimeTypeResolvers.evaluateDateTime_Time(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    private static TimeZone getValidTimeZone(String str) {
        if (str.equals("Pacific/Samoa")) {
            str = "Pacific/Apia";
        }
        return TimeZone.getTimeZone(str);
    }

    private static Calendar getCalendarTimeZone(TimeZone timeZone) {
        if (timeZone != null) {
            return Calendar.getInstance(timeZone);
        }
        return Calendar.getInstance();
    }
}
