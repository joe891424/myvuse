package com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.yoti.mobile.android.common.p049ui.widgets.YotiRadioButton;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class AlphabeticalPickerAdapter extends RecyclerView.Adapter<AlphabeticalViewHolder> {

    /* JADX INFO: renamed from: a */
    private List<AlphabeticalPickerModel> f6271a;

    /* JADX INFO: renamed from: b */
    private boolean f6272b;

    /* JADX INFO: renamed from: c */
    private Listener f6273c;

    /* JADX INFO: renamed from: d */
    private int f6274d = -1;

    public interface Listener {
        void onItemTicked(AlphabeticalPickerModel alphabeticalPickerModel);
    }

    AlphabeticalPickerAdapter(List<AlphabeticalPickerModel> list, boolean z, Listener listener) {
        this.f6271a = list;
        this.f6272b = z;
        this.f6273c = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void m4585a(AlphabeticalPickerModel alphabeticalPickerModel, AlphabeticalViewHolder alphabeticalViewHolder, YotiRadioButton yotiRadioButton, boolean z) {
        if (z) {
            this.f6273c.onItemTicked(alphabeticalPickerModel);
        }
        m4586a(alphabeticalViewHolder.getAdapterPosition());
    }

    /* JADX INFO: renamed from: a */
    void m4586a(int i) {
        int i2 = this.f6274d;
        this.f6274d = i;
        notifyItemChanged(i2);
        notifyItemChanged(this.f6274d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f6271a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final AlphabeticalViewHolder alphabeticalViewHolder, int i) {
        final AlphabeticalPickerModel alphabeticalPickerModel = this.f6271a.get(i);
        alphabeticalViewHolder.m4599a(alphabeticalPickerModel, this.f6272b, i == this.f6274d, new YotiRadioButton.OnCheckedChangeListener() { // from class: com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerAdapter$$ExternalSyntheticLambda0
            @Override // com.yoti.mobile.android.common.ui.widgets.YotiRadioButton.OnCheckedChangeListener
            public final void onCheckedChanged(YotiRadioButton yotiRadioButton, boolean z) {
                this.f$0.m4585a(alphabeticalPickerModel, alphabeticalViewHolder, yotiRadioButton, z);
            }
        });
        alphabeticalViewHolder.m4598a(i + 1, this.f6271a.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public AlphabeticalViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new AlphabeticalViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C4584R.layout.alphabetical_picker_cell, viewGroup, false));
    }
}
