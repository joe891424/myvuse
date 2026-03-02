package com.yoti.mobile.android.common.p049ui.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;
import com.yoti.mobile.android.common.p049ui.widgets.date.picker.DatePicker;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;

/* JADX INFO: loaded from: classes5.dex */
public class YotiNumberPicker extends NumberPicker {

    /* JADX INFO: renamed from: a */
    private DatePicker f6157a;

    public YotiNumberPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: renamed from: a */
    private void m4516a(View view) {
        if (view instanceof EditText) {
            try {
                ((EditText) view).setTextAppearance(getContext(), C4584R.style.Yoti_v3_DatePickerSpinner_item);
            } catch (Resources.NotFoundException unused) {
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        m4516a(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        m4516a(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        m4516a(view);
    }

    public DatePicker getDatePicker() {
        return this.f6157a;
    }

    public void setDatePicker(DatePicker datePicker) {
        this.f6157a = datePicker;
    }
}
