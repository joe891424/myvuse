package com.yoti.mobile.android.common.p049ui.widgets.date.entry;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes5.dex */
public class YotiDateEntryView extends RelativeLayout implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: a */
    private OnManualDateEntryInteraction f6321a;

    /* JADX INFO: renamed from: b */
    private LayoutInflater f6322b;

    /* JADX INFO: renamed from: c */
    private HintSpinnerAdapter f6323c;

    /* JADX INFO: renamed from: d */
    private HintSpinnerAdapter f6324d;

    /* JADX INFO: renamed from: e */
    private HintSpinnerAdapter f6325e;

    /* JADX INFO: renamed from: f */
    private DatesArrayBuilder f6326f;

    /* JADX INFO: renamed from: g */
    private String f6327g;

    /* JADX INFO: renamed from: h */
    private TextView f6328h;

    /* JADX INFO: renamed from: i */
    private TextView f6329i;

    /* JADX INFO: renamed from: j */
    protected Spinner f6330j;

    /* JADX INFO: renamed from: k */
    protected Spinner f6331k;

    /* JADX INFO: renamed from: l */
    protected Spinner f6332l;

    /* JADX INFO: renamed from: m */
    protected String f6333m;

    /* JADX INFO: renamed from: n */
    protected String f6334n;

    /* JADX INFO: renamed from: o */
    protected String f6335o;

    /* JADX INFO: renamed from: p */
    int f6336p;

    /* JADX INFO: renamed from: q */
    int f6337q;

    public interface OnManualDateEntryInteraction {
        void onDateEntry(int i);
    }

    public YotiDateEntryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6322b = LayoutInflater.from(context);
        init(context, attributeSet);
    }

    public YotiDateEntryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6322b = LayoutInflater.from(context);
        init(context, attributeSet);
    }

    public YotiDateEntryView(Context context, String str) {
        super(context);
        this.f6322b = LayoutInflater.from(context);
        this.f6327g = str;
        init(context, null);
    }

    /* JADX INFO: renamed from: a */
    private int m4606a(int i) {
        return this.f6337q > -1 ? (i - Calendar.getInstance().get(1)) - this.f6337q : i - 1900;
    }

    /* JADX INFO: renamed from: a */
    private void m4607a() {
        m4610b();
        m4611c();
        m4614f();
    }

    /* JADX INFO: renamed from: a */
    private void m4608a(int i, int i2) {
        List<String> listBuildDaysArray = this.f6326f.buildDaysArray(i, i2);
        if (listBuildDaysArray.isEmpty()) {
            return;
        }
        listBuildDaysArray.add(this.f6333m);
        this.f6323c.clear();
        this.f6323c.addAll(listBuildDaysArray);
    }

    /* JADX INFO: renamed from: a */
    private boolean m4609a(AdapterView<?> adapterView, int i) {
        if (adapterView.getId() == C4584R.id.spinnerMonth) {
            return i < this.f6331k.getCount() && !((String) this.f6332l.getSelectedItem()).equalsIgnoreCase(this.f6335o);
        }
        if (adapterView.getId() == C4584R.id.spinnerYear) {
            return i < this.f6332l.getCount() && !((String) this.f6331k.getSelectedItem()).equalsIgnoreCase(this.f6334n);
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    private void m4610b() {
        List<String> listBuildDaysArray = this.f6326f.buildDaysArray(0, DatesArrayBuilder.MINIMUM_YEAR_DEFAULT);
        listBuildDaysArray.add(this.f6333m);
        this.f6323c = new HintSpinnerAdapter(getContext(), C4584R.layout.spinner_simple_item, listBuildDaysArray);
    }

    /* JADX INFO: renamed from: c */
    private void m4611c() {
        List<String> listBuildMonthsArray = this.f6326f.buildMonthsArray();
        listBuildMonthsArray.add(this.f6334n);
        this.f6324d = new HintSpinnerAdapter(getContext(), C4584R.layout.spinner_simple_item, listBuildMonthsArray);
    }

    /* JADX INFO: renamed from: d */
    private void m4612d() {
        Spinner spinner = (Spinner) findViewById(C4584R.id.spinnerDay);
        this.f6330j = spinner;
        spinner.setAdapter((SpinnerAdapter) this.f6323c);
        this.f6330j.setOnItemSelectedListener(this);
        this.f6330j.setSelection(this.f6323c.getCount());
        this.f6323c.setDropDownViewResource(C4584R.layout.spinner_date_item);
        Spinner spinner2 = (Spinner) findViewById(C4584R.id.spinnerMonth);
        this.f6331k = spinner2;
        spinner2.setAdapter((SpinnerAdapter) this.f6324d);
        this.f6331k.setOnItemSelectedListener(this);
        this.f6331k.setSelection(this.f6324d.getCount());
        this.f6324d.setDropDownViewResource(C4584R.layout.spinner_date_item);
        Spinner spinner3 = (Spinner) findViewById(C4584R.id.spinnerYear);
        this.f6332l = spinner3;
        spinner3.setAdapter((SpinnerAdapter) this.f6325e);
        this.f6332l.setOnItemSelectedListener(this);
        this.f6332l.setSelection(this.f6325e.getCount());
        this.f6325e.setDropDownViewResource(C4584R.layout.spinner_date_item);
    }

    /* JADX INFO: renamed from: e */
    private void m4613e() {
        TextView textView = (TextView) findViewById(C4584R.id.dob_label);
        this.f6328h = textView;
        textView.setText(this.f6327g);
    }

    /* JADX INFO: renamed from: f */
    private void m4614f() {
        List<String> listBuildYearsArray = this.f6326f.buildYearsArray();
        listBuildYearsArray.add(this.f6335o);
        this.f6325e = new HintSpinnerAdapter(getContext(), C4584R.layout.spinner_simple_item, listBuildYearsArray);
    }

    public boolean allDatesEntered() {
        return (((String) this.f6332l.getSelectedItem()).equalsIgnoreCase(this.f6335o) || ((String) this.f6331k.getSelectedItem()).equalsIgnoreCase(this.f6334n) || ((String) this.f6330j.getSelectedItem()).equalsIgnoreCase(this.f6333m)) ? false : true;
    }

    public Calendar getCurrentDateAsCalendar() {
        if (!allDatesEntered()) {
            return null;
        }
        Calendar gregorianCalendar = GregorianCalendar.getInstance();
        gregorianCalendar.set(5, Integer.valueOf((String) this.f6330j.getSelectedItem()).intValue());
        gregorianCalendar.set(2, this.f6331k.getSelectedItemPosition());
        gregorianCalendar.set(1, Integer.valueOf((String) this.f6332l.getSelectedItem()).intValue());
        return gregorianCalendar;
    }

    public Long getCurrentDateAsMillis() {
        Calendar currentDateAsCalendar = getCurrentDateAsCalendar();
        if (currentDateAsCalendar == null) {
            return null;
        }
        return Long.valueOf(currentDateAsCalendar.getTimeInMillis());
    }

    public void init(Context context, AttributeSet attributeSet) {
        this.f6322b.inflate(C4584R.layout.view_date_entry, (ViewGroup) this, true);
        this.f6336p = -1;
        this.f6337q = -1;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4584R.styleable.YotiDateEntryView, 0, 0);
            try {
                this.f6336p = typedArrayObtainStyledAttributes.getInteger(C4584R.styleable.YotiDateEntryView_maximumYearsAfterNow, -1);
                this.f6337q = typedArrayObtainStyledAttributes.getInteger(C4584R.styleable.YotiDateEntryView_maximumYearsBeforeNow, -1);
                this.f6333m = typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiDateEntryView_hintDay);
                this.f6334n = typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiDateEntryView_hintMonth);
                this.f6335o = typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiDateEntryView_hintYear);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        this.f6326f = new DatesArrayBuilder(this.f6336p);
        if (this.f6337q > -1) {
            this.f6326f.setMinimumYear(Calendar.getInstance().get(1) - this.f6337q);
        }
        this.f6329i = (TextView) findViewById(C4584R.id.error_message);
        m4613e();
        m4607a();
        m4612d();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        int iIntValue;
        OnManualDateEntryInteraction onManualDateEntryInteraction = this.f6321a;
        if (onManualDateEntryInteraction != null) {
            onManualDateEntryInteraction.onDateEntry(adapterView.getId());
        }
        if (m4609a(adapterView, i)) {
            if (adapterView.getId() == C4584R.id.spinnerMonth) {
                iIntValue = Integer.valueOf((String) this.f6332l.getSelectedItem()).intValue();
            } else if (adapterView.getId() == C4584R.id.spinnerYear) {
                iIntValue = Integer.valueOf(this.f6325e.getItem(i)).intValue();
                i = this.f6331k.getSelectedItemPosition();
            } else {
                i = 0;
                iIntValue = 0;
            }
            if (iIntValue == 0 || i == 0) {
                return;
            }
            m4608a(i, iIntValue);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setDateFromCalendar(Calendar calendar) {
        this.f6330j.setSelection(calendar.get(5) - 1);
        this.f6331k.setSelection(calendar.get(2));
        this.f6332l.setSelection(m4606a(calendar.get(1)));
    }

    public void setDateFromMillis(long j) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"), Locale.ENGLISH);
        calendar.setTimeInMillis(j);
        setDateFromCalendar(calendar);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f6328h.setEnabled(z);
        this.f6329i.setEnabled(z);
        this.f6330j.setEnabled(z);
        this.f6331k.setEnabled(z);
        this.f6332l.setEnabled(z);
    }

    public void setErrorMessage(int i, int i2) {
        this.f6329i.setId(i);
        this.f6329i.setText(i2);
    }

    public void setErrorMessage(String str) {
        this.f6329i.setText(str);
    }

    public void setHardcodedYear(int i) {
        this.f6332l.setSelection(m4606a(i));
        this.f6332l.setEnabled(false);
    }

    public void setInteractionListener(OnManualDateEntryInteraction onManualDateEntryInteraction) {
        this.f6321a = onManualDateEntryInteraction;
    }

    public void setTitle(String str) {
        TextView textView = this.f6328h;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void showErrorMessage(boolean z) {
        this.f6329i.setVisibility(z ? 0 : 4);
    }
}
