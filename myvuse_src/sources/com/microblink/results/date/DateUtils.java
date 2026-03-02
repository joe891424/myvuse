package com.microblink.results.date;

import com.heanoria.library.reactnative.locationenabler.AndroidLocationEnablerModule;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class DateUtils {
    public static boolean isDatePassed(Date date) {
        Date dateLlIIlIlIIl = llIIlIlIIl();
        int[] iArr = {dateLlIIlIlIIl.getYear(), dateLlIIlIlIIl.getMonth(), dateLlIIlIlIIl.getDay()};
        int[] iArr2 = {date.getYear(), date.getMonth(), date.getDay()};
        for (int i = 0; i < 3; i++) {
            int i2 = iArr[i];
            int i3 = iArr2[i];
            if (i3 < i2) {
                return true;
            }
            if (i3 > i2) {
                return false;
            }
        }
        return false;
    }

    private static Date llIIlIlIIl() {
        Calendar calendar = Calendar.getInstance();
        return new Date(calendar.get(5), calendar.get(2) + 1, calendar.get(1));
    }

    public static int yearsPassedFrom(Date date) {
        Date dateLlIIlIlIIl = llIIlIlIIl();
        Locale locale = Locale.US;
        return (Integer.parseInt(String.format(locale, "%04d%02d%02d", Integer.valueOf(dateLlIIlIlIIl.getYear()), Integer.valueOf(dateLlIIlIlIIl.getMonth()), Integer.valueOf(dateLlIIlIlIIl.getDay()))) - Integer.parseInt(String.format(locale, "%04d%02d%02d", Integer.valueOf(date.getYear()), Integer.valueOf(date.getMonth()), Integer.valueOf(date.getDay())))) / AndroidLocationEnablerModule.DEFAULT_INTERVAL_DURATION;
    }
}
