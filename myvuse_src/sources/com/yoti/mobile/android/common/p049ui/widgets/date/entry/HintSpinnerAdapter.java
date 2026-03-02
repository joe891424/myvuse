package com.yoti.mobile.android.common.p049ui.widgets.date.entry;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class HintSpinnerAdapter extends ArrayAdapter<String> {
    public HintSpinnerAdapter(Context context, int i, List<String> list) {
        super(context, i, list);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return super.getCount() - 1;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (i == getCount()) {
            ((TextView) view2.findViewById(C4584R.id.spinnerText1)).setText("");
            ((TextView) view2.findViewById(C4584R.id.spinnerText1)).setHint(getItem(getCount()));
        }
        return view2;
    }
}
