package com.yoti.mobile.android.common.p049ui.widgets.date.picker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.yoti.mobile.android.common.p049ui.widgets.YotiEditText;
import com.yoti.mobile.android.common.p049ui.widgets.date.picker.DatePickerDialog;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class DatePickerComponent extends ConstraintLayout {

    /* JADX INFO: renamed from: a */
    private DateParts f6369a;

    /* JADX INFO: renamed from: b */
    private DateParts f6370b;

    /* JADX INFO: renamed from: c */
    private DateParts f6371c;

    /* JADX INFO: renamed from: d */
    private DateParts f6372d;

    /* JADX INFO: renamed from: e */
    private DatePickerListener f6373e;

    /* JADX INFO: renamed from: f */
    private String f6374f;

    /* JADX INFO: renamed from: g */
    private ViewGroup f6375g;

    /* JADX INFO: renamed from: h */
    private SimpleDateFormat f6376h;

    /* JADX INFO: renamed from: i */
    private String f6377i;

    /* JADX INFO: renamed from: j */
    private YotiEditText f6378j;

    /* JADX INFO: renamed from: k */
    private int f6379k;

    public static class DateParts implements Parcelable {
        public static final Parcelable.Creator<DateParts> CREATOR = new C4549a();

        /* JADX INFO: renamed from: a */
        private int f6380a;

        /* JADX INFO: renamed from: b */
        private int f6381b;

        /* JADX INFO: renamed from: c */
        private int f6382c;

        /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.date.picker.DatePickerComponent$DateParts$a */
        static class C4549a implements Parcelable.Creator<DateParts> {
            C4549a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public DateParts createFromParcel(Parcel parcel) {
                return new DateParts(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public DateParts[] newArray(int i) {
                return new DateParts[i];
            }
        }

        public DateParts(int i, int i2, int i3) {
            this.f6380a = i;
            this.f6381b = i2;
            this.f6382c = i3;
        }

        protected DateParts(Parcel parcel) {
            this.f6380a = parcel.readInt();
            this.f6381b = parcel.readInt();
            this.f6382c = parcel.readInt();
        }

        public static DateParts from(DateParts dateParts) {
            return new DateParts(dateParts.getYear(), dateParts.getMonth(), dateParts.getDayOfMonth());
        }

        public static DateParts from(Calendar calendar) {
            return new DateParts(calendar.get(1), calendar.get(2), calendar.get(5));
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            DateParts dateParts = (DateParts) obj;
            return this.f6380a == dateParts.getYear() && this.f6381b == dateParts.getMonth() && this.f6382c == dateParts.getDayOfMonth();
        }

        public int getDayOfMonth() {
            return this.f6382c;
        }

        public int getMonth() {
            return this.f6381b;
        }

        public int getYear() {
            return this.f6380a;
        }

        public int hashCode() {
            return ((((this.f6380a + 31) * 31) + this.f6381b) * 31) + this.f6382c;
        }

        public void setDayOfMonth(int i) {
            this.f6382c = i;
        }

        public void setMonth(int i) {
            this.f6381b = i;
        }

        public void setYear(int i) {
            this.f6380a = i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f6380a);
            parcel.writeInt(this.f6381b);
            parcel.writeInt(this.f6382c);
        }
    }

    public interface DatePickerListener {
        void onDateSelected(DateParts dateParts);
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.date.picker.DatePickerComponent$a */
    class ViewOnClickListenerC4550a implements View.OnClickListener {
        ViewOnClickListenerC4550a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DatePickerComponent.this.m4644b();
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.date.picker.DatePickerComponent$b */
    class C4551b implements DatePickerDialog.OnDateSetListener {
        C4551b() {
        }

        @Override // com.yoti.mobile.android.common.ui.widgets.date.picker.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            DatePickerComponent.this.f6369a = new DateParts(i, i2, i3);
            DatePickerComponent.this.f6378j.setText(DatePickerComponent.this.f6376h.format(new GregorianCalendar(i, i2, i3).getTime()));
            if (DatePickerComponent.this.f6373e != null) {
                DatePickerComponent.this.f6373e.onDateSelected(DatePickerComponent.this.f6369a);
            }
        }
    }

    public DatePickerComponent(Context context) {
        this(context, null);
    }

    public DatePickerComponent(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DatePickerComponent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C4584R.styleable.DatePickerComponent);
        try {
            String string = typedArrayObtainStyledAttributes.getString(C4584R.styleable.DatePickerComponent_date_picker_selected_date_format);
            this.f6376h = string == null ? new SimpleDateFormat("dd MMMM yyyy", Locale.UK) : new SimpleDateFormat(string, Locale.UK);
            String string2 = typedArrayObtainStyledAttributes.getString(C4584R.styleable.DatePickerComponent_date_picker_dialog_date_pattern);
            this.f6377i = string2;
            if (string2 == null) {
                this.f6377i = "dd MMM yyyy";
            }
            this.f6379k = typedArrayObtainStyledAttributes.getResourceId(C4584R.styleable.DatePickerComponent_date_picker_spinner_theme, C4584R.style.Yoti_v3_DatePickerSpinner);
            String string3 = typedArrayObtainStyledAttributes.getString(C4584R.styleable.DatePickerComponent_date_picker_label);
            String string4 = typedArrayObtainStyledAttributes.getString(C4584R.styleable.DatePickerComponent_date_picker_error);
            String string5 = typedArrayObtainStyledAttributes.getString(C4584R.styleable.DatePickerComponent_date_picker_hint);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(C4584R.styleable.DatePickerComponent_date_picker_icon);
            typedArrayObtainStyledAttributes.recycle();
            m4640a(context, string3, string4, string5, drawable);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4639a() {
        this.f6378j = (YotiEditText) findViewById(C4584R.id.date_picker_input_field);
    }

    /* JADX INFO: renamed from: a */
    private void m4640a(Context context, String str, String str2, String str3, Drawable drawable) {
        LayoutInflater.from(context).inflate(C4584R.layout.date_picker_component, (ViewGroup) this, true);
        m4639a();
        m4642a(str, str2, str3, drawable);
        setOnClickListener(new ViewOnClickListenerC4550a());
        this.f6378j.setCursorVisible(false);
        this.f6378j.setInputType(524288);
    }

    /* JADX INFO: renamed from: a */
    private void m4642a(String str, String str2, String str3, Drawable drawable) {
        this.f6378j.setLabelText(str);
        this.f6378j.setErrorText(str2);
        this.f6378j.setHintText(str3);
        this.f6378j.setEndIcon(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007c  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m4644b() {
        /*
            r4 = this;
            com.yoti.mobile.android.common.ui.widgets.date.picker.SpinnerDatePickerDialogBuilder r0 = new com.yoti.mobile.android.common.ui.widgets.date.picker.SpinnerDatePickerDialogBuilder
            r0.<init>()
            android.view.ViewGroup r1 = r4.f6375g
            com.yoti.mobile.android.common.ui.widgets.date.picker.SpinnerDatePickerDialogBuilder r0 = r0.setParent(r1)
            com.yoti.mobile.android.common.ui.widgets.date.picker.DatePickerComponent$b r1 = new com.yoti.mobile.android.common.ui.widgets.date.picker.DatePickerComponent$b
            r1.<init>()
            com.yoti.mobile.android.common.ui.widgets.date.picker.SpinnerDatePickerDialogBuilder r0 = r0.setDateSetListener(r1)
            java.lang.String r1 = r4.f6377i
            r0.setDatePattern(r1)
            int r1 = r4.f6379k
            r2 = -1
            if (r1 == r2) goto L21
            r0.spinnerTheme(r1)
        L21:
            com.yoti.mobile.android.common.ui.widgets.date.picker.DatePickerComponent$DateParts r1 = r4.f6371c
            if (r1 == 0) goto L38
            int r1 = r1.getYear()
            com.yoti.mobile.android.common.ui.widgets.date.picker.DatePickerComponent$DateParts r2 = r4.f6371c
            int r2 = r2.getMonth()
            com.yoti.mobile.android.common.ui.widgets.date.picker.DatePickerComponent$DateParts r3 = r4.f6371c
            int r3 = r3.getDayOfMonth()
            r0.minDate(r1, r2, r3)
        L38:
            com.yoti.mobile.android.common.ui.widgets.date.picker.DatePickerComponent$DateParts r1 = r4.f6372d
            if (r1 == 0) goto L4f
            int r1 = r1.getYear()
            com.yoti.mobile.android.common.ui.widgets.date.picker.DatePickerComponent$DateParts r2 = r4.f6372d
            int r2 = r2.getMonth()
            com.yoti.mobile.android.common.ui.widgets.date.picker.DatePickerComponent$DateParts r3 = r4.f6372d
            int r3 = r3.getDayOfMonth()
            r0.maxDate(r1, r2, r3)
        L4f:
            com.yoti.mobile.android.common.ui.widgets.date.picker.DatePickerComponent$DateParts r1 = r4.f6369a
            if (r1 == 0) goto L67
            int r1 = r1.getYear()
            com.yoti.mobile.android.common.ui.widgets.date.picker.DatePickerComponent$DateParts r2 = r4.f6369a
            int r2 = r2.getMonth()
            com.yoti.mobile.android.common.ui.widgets.date.picker.DatePickerComponent$DateParts r3 = r4.f6369a
        L5f:
            int r3 = r3.getDayOfMonth()
            r0.defaultDate(r1, r2, r3)
            goto L78
        L67:
            com.yoti.mobile.android.common.ui.widgets.date.picker.DatePickerComponent$DateParts r1 = r4.f6370b
            if (r1 == 0) goto L78
            int r1 = r1.getYear()
            com.yoti.mobile.android.common.ui.widgets.date.picker.DatePickerComponent$DateParts r2 = r4.f6370b
            int r2 = r2.getMonth()
            com.yoti.mobile.android.common.ui.widgets.date.picker.DatePickerComponent$DateParts r3 = r4.f6370b
            goto L5f
        L78:
            java.lang.String r1 = r4.f6374f
            if (r1 == 0) goto L7f
            r0.setTitle(r1)
        L7f:
            com.yoti.mobile.android.common.ui.widgets.date.picker.DatePickerDialog r0 = r0.build()
            r0.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.common.p049ui.widgets.date.picker.DatePickerComponent.m4644b():void");
    }

    public void clear() {
        this.f6369a = null;
        this.f6378j.setText("");
    }

    public String getLabelText() {
        return this.f6378j.getLabelText();
    }

    public String getText() {
        return this.f6378j.getText();
    }

    public void setAsEmptyInvalid() {
        this.f6378j.setAsEmptyInvalid();
    }

    public void setAsInFocus() {
        this.f6378j.setAsInFocus();
    }

    public void setAsInvalid() {
        this.f6378j.setAsInvalid();
    }

    public void setAsNeutral() {
        this.f6378j.setAsNeutral();
    }

    public void setAsValid() {
        this.f6378j.setAsValid();
    }

    public void setDate(DateParts dateParts) {
        this.f6369a = DateParts.from(dateParts);
        this.f6378j.setText(this.f6376h.format(new GregorianCalendar(this.f6369a.getYear(), this.f6369a.getMonth(), this.f6369a.getDayOfMonth()).getTime()));
    }

    public void setDatePickerListener(DatePickerListener datePickerListener) {
        this.f6373e = datePickerListener;
    }

    public void setDefaultDate(DateParts dateParts) {
        this.f6370b = DateParts.from(dateParts);
    }

    public void setDefaultDate(Calendar calendar) {
        this.f6370b = DateParts.from(calendar);
    }

    public void setDialogPickerDatePattern(String str) {
        this.f6377i = str;
    }

    public void setMaxDate(DateParts dateParts) {
        this.f6372d = DateParts.from(dateParts);
    }

    public void setMaxDate(Calendar calendar) {
        this.f6372d = DateParts.from(calendar);
    }

    public void setMinDate(DateParts dateParts) {
        this.f6371c = DateParts.from(dateParts);
    }

    public void setMinDate(Calendar calendar) {
        this.f6371c = DateParts.from(calendar);
    }

    public void setParent(ViewGroup viewGroup) {
        this.f6375g = viewGroup;
    }

    public void setSpinnerTheme(int i) {
        this.f6379k = i;
    }

    public void setTitle(String str) {
        this.f6374f = str;
    }
}
