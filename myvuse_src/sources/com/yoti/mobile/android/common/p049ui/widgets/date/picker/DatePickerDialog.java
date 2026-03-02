package com.yoti.mobile.android.common.p049ui.widgets.date.picker;

import android.R;
import android.app.AlertDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yoti.mobile.android.common.p049ui.widgets.date.picker.DatePicker;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.text.DateFormat;
import java.util.Calendar;

/* JADX INFO: loaded from: classes5.dex */
public class DatePickerDialog extends AlertDialog implements DatePicker.OnDateChangedListener {
    public static final int TITLE_DATE = 1;
    public static final int TITLE_HIDDEN = 3;
    public static final int TITLE_TEXT = 2;

    /* JADX INFO: renamed from: a */
    private final TextView f6385a;

    /* JADX INFO: renamed from: b */
    private final DatePicker f6386b;

    /* JADX INFO: renamed from: c */
    private final OnDateSetListener f6387c;

    /* JADX INFO: renamed from: d */
    private final DateFormat f6388d;

    /* JADX INFO: renamed from: e */
    private final String f6389e;

    /* JADX INFO: renamed from: f */
    private int f6390f;

    /* JADX INFO: renamed from: g */
    private String f6391g;

    public interface OnDateSetListener {
        void onDateSet(DatePicker datePicker, int i, int i2, int i3);
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.date.picker.DatePickerDialog$a */
    class ViewOnClickListenerC4552a implements View.OnClickListener {
        ViewOnClickListenerC4552a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DatePickerDialog.this.f6387c != null) {
                DatePickerDialog.this.f6386b.clearFocus();
                DatePickerDialog.this.f6387c.onDateSet(DatePickerDialog.this.f6386b, DatePickerDialog.this.f6386b.getYear(), DatePickerDialog.this.f6386b.getMonth(), DatePickerDialog.this.f6386b.getDayOfMonth());
            }
            DatePickerDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.date.picker.DatePickerDialog$b */
    class ViewOnClickListenerC4553b implements View.OnClickListener {
        ViewOnClickListenerC4553b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DatePickerDialog.this.dismiss();
        }
    }

    DatePickerDialog(ViewGroup viewGroup, int i, OnDateSetListener onDateSetListener, Calendar calendar, Calendar calendar2, Calendar calendar3, int i2, String str, String str2) {
        super(viewGroup.getContext());
        this.f6389e = str2;
        this.f6387c = onDateSetListener;
        this.f6388d = DateFormat.getDateInstance(1);
        this.f6390f = i2;
        this.f6391g = str;
        View viewInflate = LayoutInflater.from(getContext()).inflate(C4584R.layout.yoti_dialog, viewGroup, false);
        this.f6385a = (TextView) viewInflate.findViewById(C4584R.id.uicomponent_dialog_title);
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(1);
        DatePicker datePicker = new DatePicker(linearLayout, i);
        this.f6386b = datePicker;
        datePicker.setDatePattern(str2);
        datePicker.setMinDate(calendar2.getTimeInMillis());
        datePicker.setMaxDate(calendar3.getTimeInMillis());
        datePicker.m4635a(calendar.get(1), calendar.get(2), calendar.get(5), true, this);
        ((FrameLayout) viewInflate.findViewById(C4584R.id.uicomponent_dialog_container)).addView(linearLayout);
        setView(viewInflate);
        m4652a(viewInflate);
        m4651a();
        m4653a(calendar);
    }

    /* JADX INFO: renamed from: a */
    private void m4651a() {
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4652a(View view) {
        Button button = (Button) view.findViewById(C4584R.id.uicomponent_dialog_button_positive);
        if (button != null) {
            button.setText(R.string.ok);
            button.setOnClickListener(new ViewOnClickListenerC4552a());
        }
        Button button2 = (Button) view.findViewById(C4584R.id.uicomponent_dialog_button_negative);
        if (button2 != null) {
            button2.setText(R.string.cancel);
            button2.setOnClickListener(new ViewOnClickListenerC4553b());
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4653a(Calendar calendar) {
        int i = this.f6390f;
        this.f6385a.setText(i != 1 ? i != 2 ? i != 3 ? "" : " " : this.f6391g : this.f6388d.format(calendar.getTime()));
    }

    @Override // com.yoti.mobile.android.common.ui.widgets.date.picker.DatePicker.OnDateChangedListener
    public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i);
        calendar.set(2, i2);
        calendar.set(5, i3);
        m4653a(calendar);
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        int i = bundle.getInt("year");
        int i2 = bundle.getInt("month");
        int i3 = bundle.getInt("day");
        this.f6390f = bundle.getInt("type_title");
        this.f6391g = bundle.getString("text_title");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i);
        calendar.set(2, i2);
        calendar.set(5, i3);
        m4653a(calendar);
        this.f6386b.m4635a(i, i2, i3, this.f6390f == 1, this);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        bundleOnSaveInstanceState.putInt("year", this.f6386b.getYear());
        bundleOnSaveInstanceState.putInt("month", this.f6386b.getMonth());
        bundleOnSaveInstanceState.putInt("day", this.f6386b.getDayOfMonth());
        bundleOnSaveInstanceState.putInt("type_title", this.f6390f);
        bundleOnSaveInstanceState.putString("text_title", this.f6391g);
        return bundleOnSaveInstanceState;
    }
}
