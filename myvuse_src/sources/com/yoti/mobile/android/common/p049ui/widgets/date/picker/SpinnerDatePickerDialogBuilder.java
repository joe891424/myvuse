package com.yoti.mobile.android.common.p049ui.widgets.date.picker;

import android.view.ViewGroup;
import com.yoti.mobile.android.common.p049ui.widgets.date.entry.DatesArrayBuilder;
import com.yoti.mobile.android.common.p049ui.widgets.date.picker.DatePickerDialog;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes5.dex */
public class SpinnerDatePickerDialogBuilder {
    public static final int NO_SPINNER_THEME = -1;

    /* JADX INFO: renamed from: a */
    private ViewGroup f6394a;

    /* JADX INFO: renamed from: b */
    private DatePickerDialog.OnDateSetListener f6395b;

    /* JADX INFO: renamed from: c */
    private int f6396c = 1;

    /* JADX INFO: renamed from: d */
    private String f6397d = null;

    /* JADX INFO: renamed from: e */
    private int f6398e = -1;

    /* JADX INFO: renamed from: f */
    private Calendar f6399f = new GregorianCalendar(1980, 0, 1);

    /* JADX INFO: renamed from: g */
    private Calendar f6400g = new GregorianCalendar(DatesArrayBuilder.MINIMUM_YEAR_DEFAULT, 0, 1);

    /* JADX INFO: renamed from: h */
    private Calendar f6401h = new GregorianCalendar(2100, 0, 1);

    /* JADX INFO: renamed from: i */
    private String f6402i = null;

    public DatePickerDialog build() {
        if (this.f6394a == null) {
            throw new IllegalArgumentException("Root must not be null");
        }
        if (this.f6401h.getTime().getTime() > this.f6400g.getTime().getTime()) {
            return new DatePickerDialog(this.f6394a, this.f6398e, this.f6395b, this.f6399f, this.f6400g, this.f6401h, this.f6396c, this.f6397d, this.f6402i);
        }
        throw new IllegalArgumentException("Max date is not after Min date");
    }

    public SpinnerDatePickerDialogBuilder defaultDate(int i, int i2, int i3) {
        this.f6399f = new GregorianCalendar(i, i2, i3);
        return this;
    }

    public SpinnerDatePickerDialogBuilder maxDate(int i, int i2, int i3) {
        this.f6401h = new GregorianCalendar(i, i2, i3);
        return this;
    }

    public SpinnerDatePickerDialogBuilder minDate(int i, int i2, int i3) {
        this.f6400g = new GregorianCalendar(i, i2, i3);
        return this;
    }

    public SpinnerDatePickerDialogBuilder setDatePattern(String str) {
        this.f6402i = str;
        return this;
    }

    public SpinnerDatePickerDialogBuilder setDateSetListener(DatePickerDialog.OnDateSetListener onDateSetListener) {
        this.f6395b = onDateSetListener;
        return this;
    }

    public SpinnerDatePickerDialogBuilder setParent(ViewGroup viewGroup) {
        this.f6394a = viewGroup;
        return this;
    }

    public SpinnerDatePickerDialogBuilder setTitle(String str) {
        this.f6397d = str;
        this.f6396c = 2;
        return this;
    }

    public SpinnerDatePickerDialogBuilder setTitleType(int i) {
        this.f6396c = i;
        return this;
    }

    public SpinnerDatePickerDialogBuilder spinnerTheme(int i) {
        this.f6398e = i;
        return this;
    }
}
