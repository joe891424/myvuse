package com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yoti.mobile.android.common.p049ui.widgets.YotiRadioButton;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;

/* JADX INFO: loaded from: classes5.dex */
public class AlphabeticalViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a */
    private TextView f6306a;

    /* JADX INFO: renamed from: b */
    private YotiRadioButton f6307b;

    AlphabeticalViewHolder(View view) {
        super(view);
        this.f6307b = (YotiRadioButton) view.findViewById(C4584R.id.rb_country_name);
        this.f6306a = (TextView) view.findViewById(C4584R.id.tv_index_letter);
    }

    /* JADX INFO: renamed from: a */
    void m4598a(int i, int i2) {
        this.f6307b.bindForAccessibility(i, i2);
    }

    /* JADX INFO: renamed from: a */
    void m4599a(AlphabeticalPickerModel alphabeticalPickerModel, boolean z, boolean z2, YotiRadioButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (alphabeticalPickerModel.isSection()) {
            this.f6307b.setVisibility(8);
            this.f6306a.setVisibility(0);
            this.f6306a.setText(alphabeticalPickerModel.getLetter());
            return;
        }
        this.f6307b.setVisibility(0);
        this.f6306a.setVisibility(8);
        this.f6307b.setText(alphabeticalPickerModel.getLetter());
        this.f6307b.setAdditionalText(z ? alphabeticalPickerModel.getSubText() : "");
        this.f6307b.setOnCheckedChangeListener(null);
        this.f6307b.setChecked(z2);
        this.f6307b.setOnCheckedChangeListener(onCheckedChangeListener);
    }
}
