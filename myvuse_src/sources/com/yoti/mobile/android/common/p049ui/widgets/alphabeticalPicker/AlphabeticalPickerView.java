package com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker.AlphabeticalPickerAdapter;
import com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker.AlphabeticalPickerContract;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class AlphabeticalPickerView extends ConstraintLayout implements AlphabeticalPickerContract.View {

    /* JADX INFO: renamed from: a */
    private AlphabeticalPickerAdapter f6297a;

    /* JADX INFO: renamed from: b */
    protected AlphabeticalPickerContract.Presenter f6298b;

    /* JADX INFO: renamed from: c */
    private PickerViewListener f6299c;

    /* JADX INFO: renamed from: d */
    protected RecyclerView f6300d;

    /* JADX INFO: renamed from: e */
    private Button f6301e;

    /* JADX INFO: renamed from: f */
    private View f6302f;

    /* JADX INFO: renamed from: g */
    private ViewGroup f6303g;

    /* JADX INFO: renamed from: h */
    private int f6304h;

    /* JADX INFO: renamed from: i */
    private Boolean f6305i;

    public interface PickerViewListener<T extends AlphabeticalPickerModel> {
        void onItemSelected(T t);

        void onItemsLoaded();
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerView$a */
    class C4537a extends DividerItemDecoration {
        C4537a(AlphabeticalPickerView alphabeticalPickerView, Context context, int i) {
            super(context, i);
        }

        @Override // androidx.recyclerview.widget.DividerItemDecoration, androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            onDraw(canvas, recyclerView, state);
        }
    }

    public AlphabeticalPickerView(Context context) {
        this(context, null);
    }

    public AlphabeticalPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlphabeticalPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6305i = Boolean.FALSE;
        m4596a(context);
    }

    public AlphabeticalPickerView(Context context, ViewGroup viewGroup, boolean z, boolean z2, int i) {
        super(context, null, 0);
        this.f6305i = Boolean.FALSE;
        this.f6298b = new AlphabeticalPickerPresenterImpl(this, z);
        this.f6304h = i;
        this.f6305i = Boolean.valueOf(z2);
        m4597a(context, viewGroup);
    }

    public AlphabeticalPickerView(Context context, ViewGroup viewGroup, boolean z, boolean z2, boolean z3, int i) {
        super(context, null, 0);
        this.f6305i = Boolean.FALSE;
        this.f6298b = new AlphabeticalPickerPresenterImpl(this, z, z3, true);
        this.f6304h = i;
        this.f6305i = Boolean.valueOf(z2);
        m4597a(context, viewGroup);
    }

    public AlphabeticalPickerView(Context context, ViewGroup viewGroup, boolean z, boolean z2, boolean z3, boolean z4, int i) {
        super(context, null, 0);
        this.f6305i = Boolean.FALSE;
        this.f6298b = new AlphabeticalPickerPresenterImpl(this, z, z3, z4);
        this.f6304h = i;
        this.f6305i = Boolean.valueOf(z2);
        m4597a(context, viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void m4593a(View view) {
        this.f6298b.onConfirmClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void m4594a(AlphabeticalPickerModel alphabeticalPickerModel) {
        this.f6298b.onItemTick(alphabeticalPickerModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void m4595a(String str, View view) {
        this.f6298b.onIndexLetterClick(str);
    }

    /* JADX INFO: renamed from: a */
    void m4596a(Context context) {
        m4597a(context, (ViewGroup) null);
    }

    /* JADX INFO: renamed from: a */
    void m4597a(Context context, ViewGroup viewGroup) {
        int layoutResourceId = getLayoutResourceId();
        if (viewGroup == null) {
            viewGroup = this;
        }
        View viewInflate = ConstraintLayout.inflate(context, layoutResourceId, viewGroup);
        this.f6300d = (RecyclerView) viewInflate.findViewById(C4584R.id.items_recyclerView);
        this.f6303g = (ViewGroup) viewInflate.findViewById(C4584R.id.side_index);
        this.f6301e = (Button) viewInflate.findViewById(C4584R.id.button_confirm);
        this.f6302f = viewInflate.findViewById(C4584R.id.button_section);
        int i = this.f6304h;
        if (i != -1) {
            this.f6301e.setText(i);
        }
        this.f6301e.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m4593a(view);
            }
        });
    }

    public void clear() {
        this.f6298b.onViewClear();
    }

    @Override // com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerContract.View
    public void displayIndexLetters(String[] strArr) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        this.f6303g.removeAllViews();
        for (final String str : strArr) {
            TextView textView = (TextView) layoutInflaterFrom.inflate(getAlphabetLayoutResourceId(), this.f6303g, false);
            textView.setText(str);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m4595a(str, view);
                }
            });
            this.f6303g.addView(textView);
        }
    }

    @Override // com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerContract.View
    public void displayItems(List<AlphabeticalPickerModel> list) {
        this.f6297a = new AlphabeticalPickerAdapter(list, this.f6305i.booleanValue(), new AlphabeticalPickerAdapter.Listener() { // from class: com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerView$$ExternalSyntheticLambda0
            @Override // com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerAdapter.Listener
            public final void onItemTicked(AlphabeticalPickerModel alphabeticalPickerModel) {
                this.f$0.m4594a(alphabeticalPickerModel);
            }
        });
        C4537a c4537a = new C4537a(this, getContext(), 1);
        c4537a.setDrawable(ContextCompat.getDrawable(getContext(), C4584R.drawable.radiobutton_list_divider));
        this.f6300d.addItemDecoration(c4537a);
        this.f6300d.setVisibility(0);
        this.f6300d.setAdapter(this.f6297a);
        PickerViewListener pickerViewListener = this.f6299c;
        if (pickerViewListener != null) {
            pickerViewListener.onItemsLoaded();
        }
    }

    @Override // com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerContract.View
    public void enableConfirmButton() {
        Button button = this.f6301e;
        if (button != null) {
            button.setEnabled(true);
        }
    }

    protected int getAlphabetLayoutResourceId() {
        return C4584R.layout.view_alphabetical_letter;
    }

    protected int getLayoutResourceId() {
        return C4584R.layout.view_alphabetical_picker;
    }

    @Override // com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerContract.View
    public void hideConfirmButton() {
        this.f6302f.setVisibility(8);
    }

    public void hideIndexLayout() {
        this.f6298b.hideIndexLayout();
    }

    public void hideIndexLetters() {
        this.f6298b.hideIndexLetters();
    }

    @Override // com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerContract.View
    public void scrollTo(int i, boolean z) {
        ((LinearLayoutManager) this.f6300d.getLayoutManager()).scrollToPositionWithOffset(i, z ? this.f6300d.getHeight() / 2 : 0);
    }

    @Override // com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerContract.View
    public void selectItem(AlphabeticalPickerModel alphabeticalPickerModel) {
        PickerViewListener pickerViewListener = this.f6299c;
        if (pickerViewListener != null) {
            pickerViewListener.onItemSelected(alphabeticalPickerModel);
        }
    }

    public void setItemAsSelected(AlphabeticalPickerModel alphabeticalPickerModel) {
        this.f6298b.onSetItemAsTicked(alphabeticalPickerModel);
    }

    public void setItems(List<AlphabeticalPickerModel> list) {
        setItems(list, null);
    }

    public void setItems(List<AlphabeticalPickerModel> list, AlphabeticalPickerFooterInfo alphabeticalPickerFooterInfo) {
        this.f6298b.onSetItems(list, alphabeticalPickerFooterInfo);
    }

    public void setListener(PickerViewListener pickerViewListener) {
        this.f6299c = pickerViewListener;
    }

    @Override // com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerContract.View
    public void showConfirmButton() {
        this.f6302f.setVisibility(0);
    }

    public void showIndexLayout() {
        this.f6298b.showIndexLayout();
    }

    public void showIndexLetters() {
        this.f6298b.showIndexLetters();
    }

    @Override // com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerContract.View
    public void tickItemAtPosition(int i) {
        this.f6297a.m4586a(i);
    }
}
