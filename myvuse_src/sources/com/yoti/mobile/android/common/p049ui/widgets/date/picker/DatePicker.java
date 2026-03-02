package com.yoti.mobile.android.common.p049ui.widgets.date.picker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import com.google.android.material.timepicker.TimeModel;
import com.yoti.mobile.android.common.p049ui.widgets.YotiNumberPicker;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class DatePicker extends FrameLayout {

    /* JADX INFO: renamed from: a */
    private LinearLayout f6338a;

    /* JADX INFO: renamed from: b */
    private View f6339b;

    /* JADX INFO: renamed from: c */
    private View f6340c;

    /* JADX INFO: renamed from: d */
    private View f6341d;

    /* JADX INFO: renamed from: e */
    private NumberPicker f6342e;

    /* JADX INFO: renamed from: f */
    private NumberPicker f6343f;

    /* JADX INFO: renamed from: g */
    private NumberPicker f6344g;

    /* JADX INFO: renamed from: h */
    private EditText f6345h;

    /* JADX INFO: renamed from: i */
    private EditText f6346i;

    /* JADX INFO: renamed from: j */
    private EditText f6347j;

    /* JADX INFO: renamed from: k */
    private OnDateChangedListener f6348k;

    /* JADX INFO: renamed from: l */
    private String[] f6349l;

    /* JADX INFO: renamed from: m */
    private int f6350m;

    /* JADX INFO: renamed from: n */
    private Calendar f6351n;

    /* JADX INFO: renamed from: o */
    private Calendar f6352o;

    /* JADX INFO: renamed from: p */
    private Calendar f6353p;

    /* JADX INFO: renamed from: q */
    private Calendar f6354q;

    /* JADX INFO: renamed from: r */
    private boolean f6355r;

    /* JADX INFO: renamed from: s */
    private boolean f6356s;

    /* JADX INFO: renamed from: t */
    private String f6357t;

    public interface OnDateChangedListener {
        void onDateChanged(DatePicker datePicker, int i, int i2, int i3);
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.date.picker.DatePicker$a */
    class C4540a implements NumberPicker.OnValueChangeListener {
        C4540a() {
        }

        @Override // android.widget.NumberPicker.OnValueChangeListener
        public void onValueChange(NumberPicker numberPicker, int i, int i2) {
            DatePicker.this.m4627d();
            DatePicker.this.f6351n.setTimeInMillis(DatePicker.this.f6354q.getTimeInMillis());
            if (numberPicker == DatePicker.this.f6342e) {
                int actualMaximum = DatePicker.this.f6351n.getActualMaximum(5);
                if (i == actualMaximum && i2 == 1) {
                    DatePicker.this.f6351n.add(5, 1);
                } else if (i == 1 && i2 == actualMaximum) {
                    DatePicker.this.f6351n.add(5, -1);
                } else {
                    DatePicker.this.f6351n.add(5, i2 - i);
                }
            } else if (numberPicker == DatePicker.this.f6343f) {
                if (i == 11 && i2 == 0) {
                    DatePicker.this.f6351n.add(2, 1);
                } else if (i == 0 && i2 == 11) {
                    DatePicker.this.f6351n.add(2, -1);
                } else {
                    DatePicker.this.f6351n.add(2, i2 - i);
                }
            } else {
                if (numberPicker != DatePicker.this.f6344g) {
                    throw new IllegalArgumentException();
                }
                DatePicker.this.f6351n.set(1, i2);
            }
            DatePicker datePicker = DatePicker.this;
            datePicker.m4623b(datePicker.f6351n.get(1), DatePicker.this.f6351n.get(2), DatePicker.this.f6351n.get(5));
            DatePicker.this.m4629e();
            DatePicker.this.m4622b();
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.date.picker.DatePicker$b */
    class C4541b implements NumberPicker.Formatter {
        C4541b(DatePicker datePicker) {
        }

        @Override // android.widget.NumberPicker.Formatter
        public String format(int i) {
            return String.format(Locale.UK, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i));
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.date.picker.DatePicker$c */
    class ViewOnClickListenerC4542c implements View.OnClickListener {
        ViewOnClickListenerC4542c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int value = DatePicker.this.f6342e.getValue() - 1;
            DatePicker.this.updateDate(DatePicker.this.f6344g.getValue(), DatePicker.this.f6343f.getValue(), value);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.date.picker.DatePicker$d */
    class ViewOnClickListenerC4543d implements View.OnClickListener {
        ViewOnClickListenerC4543d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int value = DatePicker.this.f6342e.getValue() + 1;
            int value2 = DatePicker.this.f6343f.getValue();
            DatePicker.this.updateDate(DatePicker.this.f6344g.getValue(), value2, value);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.date.picker.DatePicker$e */
    class ViewOnClickListenerC4544e implements View.OnClickListener {
        ViewOnClickListenerC4544e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int value = DatePicker.this.f6342e.getValue();
            DatePicker.this.updateDate(DatePicker.this.f6344g.getValue(), DatePicker.this.f6343f.getValue() - 1, value);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.date.picker.DatePicker$f */
    class ViewOnClickListenerC4545f implements View.OnClickListener {
        ViewOnClickListenerC4545f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int value = DatePicker.this.f6342e.getValue();
            int value2 = DatePicker.this.f6343f.getValue() + 1;
            DatePicker.this.updateDate(DatePicker.this.f6344g.getValue(), value2, value);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.date.picker.DatePicker$g */
    class ViewOnClickListenerC4546g implements View.OnClickListener {
        ViewOnClickListenerC4546g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int value = DatePicker.this.f6342e.getValue();
            DatePicker.this.updateDate(DatePicker.this.f6344g.getValue() - 1, DatePicker.this.f6343f.getValue(), value);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.date.picker.DatePicker$h */
    class ViewOnClickListenerC4547h implements View.OnClickListener {
        ViewOnClickListenerC4547h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int value = DatePicker.this.f6342e.getValue();
            int value2 = DatePicker.this.f6343f.getValue();
            DatePicker.this.updateDate(DatePicker.this.f6344g.getValue() + 1, value2, value);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.date.picker.DatePicker$i */
    private static class C4548i extends View.BaseSavedState {
        public static final Parcelable.Creator<C4548i> CREATOR = new a();

        /* JADX INFO: renamed from: a */
        final long f6365a;

        /* JADX INFO: renamed from: b */
        final long f6366b;

        /* JADX INFO: renamed from: c */
        final long f6367c;

        /* JADX INFO: renamed from: d */
        final boolean f6368d;

        /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.date.picker.DatePicker$i$a */
        static class a implements Parcelable.Creator<C4548i> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public C4548i createFromParcel(Parcel parcel) {
                return new C4548i(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public C4548i[] newArray(int i) {
                return new C4548i[i];
            }
        }

        private C4548i(Parcel parcel) {
            super(parcel);
            this.f6365a = parcel.readLong();
            this.f6366b = parcel.readLong();
            this.f6367c = parcel.readLong();
            this.f6368d = parcel.readByte() != 0;
        }

        /* synthetic */ C4548i(Parcel parcel, C4540a c4540a) {
            this(parcel);
        }

        C4548i(Parcelable parcelable, Calendar calendar, Calendar calendar2, Calendar calendar3, boolean z) {
            super(parcelable);
            this.f6365a = calendar.getTimeInMillis();
            this.f6366b = calendar2.getTimeInMillis();
            this.f6367c = calendar3.getTimeInMillis();
            this.f6368d = z;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.f6365a);
            parcel.writeLong(this.f6366b);
            parcel.writeLong(this.f6367c);
            parcel.writeByte(this.f6368d ? (byte) 1 : (byte) 0);
        }
    }

    public DatePicker(Context context) {
        super(context);
        this.f6355r = true;
        this.f6356s = true;
    }

    public DatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6355r = true;
        this.f6356s = true;
    }

    public DatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6355r = true;
        this.f6356s = true;
    }

    public DatePicker(LinearLayout linearLayout, int i) {
        super(linearLayout.getContext());
        this.f6355r = true;
        this.f6356s = true;
        m4616a(linearLayout, i);
    }

    /* JADX INFO: renamed from: a */
    private Calendar m4615a(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance(locale);
        calendar2.setTimeInMillis(timeInMillis);
        return calendar2;
    }

    /* JADX INFO: renamed from: a */
    private void m4616a(LinearLayout linearLayout, int i) {
        setCurrentLocale(Locale.getDefault());
        this.f6338a = linearLayout;
        C4540a c4540a = new C4540a();
        LayoutInflater layoutInflater = (LayoutInflater) new ContextThemeWrapper(linearLayout.getContext(), i).getSystemService("layout_inflater");
        if (layoutInflater != null) {
            View viewInflate = layoutInflater.inflate(C4584R.layout.yoti_number_picker, (ViewGroup) this.f6338a, false);
            this.f6339b = viewInflate;
            NumberPicker numberPicker = (NumberPicker) viewInflate.findViewById(C4584R.id.uicomponent_number_picker_picker);
            this.f6342e = numberPicker;
            ((YotiNumberPicker) numberPicker).setDatePicker(this);
            this.f6342e.setId(C4584R.id.uicomponent_number_picker_day);
            this.f6342e.setFormatter(new C4541b(this));
            this.f6342e.setOnLongPressUpdateInterval(100L);
            this.f6342e.setOnValueChangedListener(c4540a);
            this.f6345h = findEditText(this.f6342e);
            View viewInflate2 = layoutInflater.inflate(C4584R.layout.yoti_number_picker, (ViewGroup) this.f6338a, false);
            this.f6340c = viewInflate2;
            NumberPicker numberPicker2 = (NumberPicker) viewInflate2.findViewById(C4584R.id.uicomponent_number_picker_picker);
            this.f6343f = numberPicker2;
            ((YotiNumberPicker) numberPicker2).setDatePicker(this);
            this.f6343f.setId(C4584R.id.uicomponent_number_picker_month);
            this.f6343f.setMinValue(0);
            this.f6343f.setMaxValue(this.f6350m - 1);
            this.f6343f.setDisplayedValues(this.f6349l);
            this.f6343f.setOnLongPressUpdateInterval(200L);
            this.f6343f.setOnValueChangedListener(c4540a);
            this.f6346i = findEditText(this.f6343f);
            View viewInflate3 = layoutInflater.inflate(C4584R.layout.yoti_number_picker, (ViewGroup) this.f6338a, false);
            this.f6341d = viewInflate3;
            NumberPicker numberPicker3 = (NumberPicker) viewInflate3.findViewById(C4584R.id.uicomponent_number_picker_picker);
            this.f6344g = numberPicker3;
            ((YotiNumberPicker) numberPicker3).setDatePicker(this);
            this.f6344g.setId(C4584R.id.uicomponent_number_picker_year);
            this.f6344g.setOnLongPressUpdateInterval(100L);
            this.f6344g.setOnValueChangedListener(c4540a);
            this.f6347j = findEditText(this.f6344g);
        }
        this.f6354q.setTimeInMillis(System.currentTimeMillis());
        m4625c();
        m4634a();
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        linearLayout.addView(this);
    }

    /* JADX INFO: renamed from: a */
    private void m4617a(NumberPicker numberPicker, int i, int i2) {
        findEditText(numberPicker).setImeOptions(i2 < i + (-1) ? 5 : 6);
    }

    /* JADX INFO: renamed from: a */
    private boolean m4620a(int i, int i2, int i3) {
        return (this.f6354q.get(1) == i && this.f6354q.get(2) == i2 && this.f6354q.get(5) == i3) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m4622b() {
        sendAccessibilityEvent(4);
        OnDateChangedListener onDateChangedListener = this.f6348k;
        if (onDateChangedListener != null) {
            onDateChangedListener.onDateChanged(this, getYear(), getMonth(), getDayOfMonth());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m4623b(int i, int i2, int i3) {
        Calendar calendar;
        Calendar calendar2;
        this.f6354q.set(i, i2, i3);
        if (this.f6354q.before(this.f6352o)) {
            calendar = this.f6354q;
            calendar2 = this.f6352o;
        } else {
            if (!this.f6354q.after(this.f6353p)) {
                return;
            }
            calendar = this.f6354q;
            calendar2 = this.f6353p;
        }
        calendar.setTimeInMillis(calendar2.getTimeInMillis());
    }

    /* JADX INFO: renamed from: c */
    private void m4625c() {
        NumberPicker numberPicker;
        this.f6338a.removeAllViews();
        String bestDateTimePattern = this.f6357t;
        if (bestDateTimePattern == null) {
            bestDateTimePattern = DateFormat.getBestDateTimePattern(Locale.getDefault(), "yyyyMMMdd");
        }
        char[] dateFormatOrder = getDateFormatOrder(bestDateTimePattern);
        int length = dateFormatOrder.length;
        for (int i = 0; i < length; i++) {
            char c = dateFormatOrder[i];
            if (c == 'M') {
                this.f6338a.addView(this.f6340c);
                numberPicker = this.f6343f;
            } else if (c == 'd') {
                this.f6338a.addView(this.f6339b);
                numberPicker = this.f6342e;
            } else {
                if (c != 'y') {
                    throw new IllegalArgumentException(Arrays.toString(dateFormatOrder));
                }
                this.f6338a.addView(this.f6341d);
                numberPicker = this.f6344g;
            }
            m4617a(numberPicker, length, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m4627d() {
        EditText editText;
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            if (inputMethodManager.isActive(this.f6347j)) {
                editText = this.f6347j;
            } else if (inputMethodManager.isActive(this.f6346i)) {
                editText = this.f6346i;
            } else if (!inputMethodManager.isActive(this.f6345h)) {
                return;
            } else {
                editText = this.f6345h;
            }
            editText.clearFocus();
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m4629e() {
        /*
            Method dump skipped, instruction units count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.common.p049ui.widgets.date.picker.DatePicker.m4629e():void");
    }

    /* JADX INFO: renamed from: f */
    private boolean m4631f() {
        return Character.isDigit(this.f6349l[0].charAt(0));
    }

    private String getOrderJellyBeanMr2() {
        java.text.DateFormat dateFormat = this.f6349l[0].startsWith("1") ? DateFormat.getDateFormat(getContext()) : DateFormat.getMediumDateFormat(getContext());
        return dateFormat instanceof SimpleDateFormat ? ((SimpleDateFormat) dateFormat).toPattern() : new String(DateFormat.getDateFormatOrder(getContext()));
    }

    /* JADX INFO: renamed from: a */
    void m4634a() {
        View viewFindViewById = this.f6339b.findViewById(C4584R.id.uicomponent_number_picker_chevron1);
        View viewFindViewById2 = this.f6339b.findViewById(C4584R.id.uicomponent_number_picker_chevron2);
        if (viewFindViewById != null && viewFindViewById2 != null) {
            viewFindViewById.setOnClickListener(new ViewOnClickListenerC4542c());
            viewFindViewById2.setOnClickListener(new ViewOnClickListenerC4543d());
        }
        View viewFindViewById3 = this.f6340c.findViewById(C4584R.id.uicomponent_number_picker_chevron1);
        View viewFindViewById4 = this.f6340c.findViewById(C4584R.id.uicomponent_number_picker_chevron2);
        if (viewFindViewById3 != null && viewFindViewById4 != null) {
            viewFindViewById3.setOnClickListener(new ViewOnClickListenerC4544e());
            viewFindViewById4.setOnClickListener(new ViewOnClickListenerC4545f());
        }
        View viewFindViewById5 = this.f6341d.findViewById(C4584R.id.uicomponent_number_picker_chevron1);
        View viewFindViewById6 = this.f6341d.findViewById(C4584R.id.uicomponent_number_picker_chevron2);
        if (viewFindViewById5 == null || viewFindViewById6 == null) {
            return;
        }
        viewFindViewById5.setOnClickListener(new ViewOnClickListenerC4546g());
        viewFindViewById6.setOnClickListener(new ViewOnClickListenerC4547h());
    }

    /* JADX INFO: renamed from: a */
    void m4635a(int i, int i2, int i3, boolean z, OnDateChangedListener onDateChangedListener) {
        this.f6356s = z;
        m4623b(i, i2, i3);
        m4629e();
        this.f6348k = onDateChangedListener;
        m4622b();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public EditText findEditText(NumberPicker numberPicker) {
        for (int i = 0; i < numberPicker.getChildCount(); i++) {
            if (numberPicker.getChildAt(i) instanceof EditText) {
                return (EditText) numberPicker.getChildAt(i);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public char[] getDateFormatOrder(java.lang.String r13) {
        /*
            r12 = this;
            r0 = 3
            char[] r0 = new char[r0]
            r1 = 0
            r2 = r1
            r3 = r2
            r4 = r3
            r5 = r4
        L8:
            int r6 = r13.length()
            if (r1 >= r6) goto Lb6
            char r6 = r13.charAt(r1)
            r7 = 76
            r8 = 121(0x79, float:1.7E-43)
            r9 = 77
            r10 = 100
            r11 = 1
            if (r6 == r10) goto L91
            if (r6 == r7) goto L91
            if (r6 == r9) goto L91
            if (r6 != r8) goto L25
            goto L91
        L25:
            r7 = 71
            if (r6 != r7) goto L2b
            goto Lb3
        L2b:
            r7 = 97
            if (r6 < r7) goto L33
            r7 = 122(0x7a, float:1.71E-43)
            if (r6 <= r7) goto L3c
        L33:
            r7 = 65
            if (r6 < r7) goto L5b
            r7 = 90
            if (r6 <= r7) goto L3c
            goto L5b
        L3c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Bad pattern character '"
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r6)
            java.lang.String r2 = "' in "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r13 = r1.append(r13)
            java.lang.String r13 = r13.toString()
            r0.<init>(r13)
            throw r0
        L5b:
            r7 = 39
            if (r6 != r7) goto Lb3
            int r6 = r13.length()
            int r6 = r6 - r11
            if (r1 >= r6) goto L70
            int r6 = r1 + 1
            char r8 = r13.charAt(r6)
            if (r8 != r7) goto L70
            r1 = r6
            goto Lb3
        L70:
            int r1 = r1 + 1
            int r1 = r13.indexOf(r7, r1)
            r6 = -1
            if (r1 == r6) goto L7c
            int r1 = r1 + 1
            goto Lb3
        L7c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Bad quoting in "
            r1.<init>(r2)
            java.lang.StringBuilder r13 = r1.append(r13)
            java.lang.String r13 = r13.toString()
            r0.<init>(r13)
            throw r0
        L91:
            if (r6 != r10) goto L9c
            if (r3 != 0) goto L9c
            int r3 = r2 + 1
            r0[r2] = r10
            r2 = r3
            r3 = r11
            goto Lb3
        L9c:
            if (r6 == r7) goto La0
            if (r6 != r9) goto La9
        La0:
            if (r4 != 0) goto La9
            int r4 = r2 + 1
            r0[r2] = r9
            r2 = r4
            r4 = r11
            goto Lb3
        La9:
            if (r6 != r8) goto Lb3
            if (r5 != 0) goto Lb3
            int r5 = r2 + 1
            r0[r2] = r8
            r2 = r5
            r5 = r11
        Lb3:
            int r1 = r1 + r11
            goto L8
        Lb6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.common.p049ui.widgets.date.picker.DatePicker.getDateFormatOrder(java.lang.String):char[]");
    }

    int getDayOfMonth() {
        return this.f6354q.get(5);
    }

    int getMonth() {
        return this.f6354q.get(2);
    }

    int getYear() {
        return this.f6354q.get(1);
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.f6355r;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        setCurrentLocale(configuration.locale);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        C4548i c4548i = (C4548i) parcelable;
        super.onRestoreInstanceState(c4548i.getSuperState());
        Calendar calendar = Calendar.getInstance();
        this.f6354q = calendar;
        calendar.setTimeInMillis(c4548i.f6365a);
        Calendar calendar2 = Calendar.getInstance();
        this.f6352o = calendar2;
        calendar2.setTimeInMillis(c4548i.f6366b);
        Calendar calendar3 = Calendar.getInstance();
        this.f6353p = calendar3;
        calendar3.setTimeInMillis(c4548i.f6367c);
        m4629e();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new C4548i(super.onSaveInstanceState(), this.f6354q, this.f6352o, this.f6353p, this.f6356s);
    }

    protected void setCurrentLocale(Locale locale) {
        this.f6351n = m4615a(this.f6351n, locale);
        this.f6352o = m4615a(this.f6352o, locale);
        this.f6353p = m4615a(this.f6353p, locale);
        this.f6354q = m4615a(this.f6354q, locale);
        this.f6350m = this.f6351n.getActualMaximum(2) + 1;
        this.f6349l = new DateFormatSymbols().getShortMonths();
        if (m4631f()) {
            this.f6349l = new String[this.f6350m];
            int i = 0;
            while (i < this.f6350m) {
                int i2 = i + 1;
                this.f6349l[i] = String.format(Locale.UK, TimeModel.NUMBER_FORMAT, Integer.valueOf(i2));
                i = i2;
            }
        }
    }

    void setDatePattern(String str) {
        this.f6357t = str;
        m4625c();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        this.f6342e.setEnabled(z);
        this.f6343f.setEnabled(z);
        this.f6344g.setEnabled(z);
        this.f6355r = z;
    }

    void setMaxDate(long j) {
        this.f6351n.setTimeInMillis(j);
        if (this.f6351n.get(1) == this.f6353p.get(1) && this.f6351n.get(6) == this.f6353p.get(6)) {
            return;
        }
        this.f6353p.setTimeInMillis(j);
        if (this.f6354q.after(this.f6353p)) {
            this.f6354q.setTimeInMillis(this.f6353p.getTimeInMillis());
        }
        m4629e();
    }

    void setMinDate(long j) {
        this.f6351n.setTimeInMillis(j);
        if (this.f6351n.get(1) == this.f6352o.get(1) && this.f6351n.get(6) == this.f6352o.get(6)) {
            return;
        }
        this.f6352o.setTimeInMillis(j);
        if (this.f6354q.before(this.f6352o)) {
            this.f6354q.setTimeInMillis(this.f6352o.getTimeInMillis());
        }
        m4629e();
    }

    public void updateDate(int i, int i2, int i3) {
        if (m4620a(i, i2, i3)) {
            m4623b(i, i2, i3);
            m4629e();
            m4622b();
        }
    }
}
