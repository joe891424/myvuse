package com.yoti.mobile.android.common.p049ui.widgets.date.entry;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class DatesArrayBuilder {
    public static final int MAXIMUM_YEARS_AFTER_NOW_DEFAULT = 11;
    public static final int MINIMUM_YEAR_DEFAULT = 1900;

    /* JADX INFO: renamed from: a */
    private int f6317a;

    /* JADX INFO: renamed from: b */
    private int f6318b;

    /* JADX INFO: renamed from: c */
    private Calendar f6319c;

    /* JADX INFO: renamed from: d */
    private Calendar f6320d;

    public DatesArrayBuilder() {
        this(11);
    }

    public DatesArrayBuilder(int i) {
        this.f6318b = i <= -1 ? 11 : i;
        this.f6317a = MINIMUM_YEAR_DEFAULT;
        this.f6319c = new GregorianCalendar();
        this.f6320d = new GregorianCalendar();
    }

    public List<String> buildDaysArray(int i, int i2) {
        this.f6320d.set(5, 1);
        this.f6320d.set(2, i);
        this.f6320d.set(1, i2);
        int actualMaximum = this.f6320d.getActualMaximum(5);
        ArrayList arrayList = new ArrayList(actualMaximum);
        int i3 = 0;
        while (i3 < actualMaximum) {
            int i4 = i3 + 1;
            arrayList.add(i3, String.valueOf(i4));
            i3 = i4;
        }
        return arrayList;
    }

    public List<String> buildMonthsArray() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(new DateFormatSymbols(Locale.getDefault()).getMonths()));
        return arrayList;
    }

    public List<String> buildYearsArray() {
        int i = (this.f6319c.get(1) - this.f6317a) + this.f6318b;
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 <= i; i2++) {
            arrayList.add(i2, String.valueOf(this.f6317a + i2));
        }
        return arrayList;
    }

    public void setMinimumYear(int i) {
        this.f6317a = i;
    }
}
