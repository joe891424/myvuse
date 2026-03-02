package com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker;

import com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker.AlphabeticalPickerContract;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class AlphabeticalPickerPresenterImpl implements AlphabeticalPickerContract.Presenter {

    /* JADX INFO: renamed from: a */
    boolean f6289a;

    /* JADX INFO: renamed from: b */
    private final AlphabeticalPickerContract.View f6290b;

    /* JADX INFO: renamed from: c */
    private final AlphabeticalPickerInteractor f6291c;

    /* JADX INFO: renamed from: d */
    private AlphabeticalPickerData f6292d;

    /* JADX INFO: renamed from: e */
    private AlphabeticalPickerModel f6293e;

    /* JADX INFO: renamed from: f */
    private Boolean f6294f;

    /* JADX INFO: renamed from: g */
    private Boolean f6295g;

    /* JADX INFO: renamed from: h */
    private final CompositeDisposable f6296h;

    AlphabeticalPickerPresenterImpl(AlphabeticalPickerContract.View view, AlphabeticalPickerInteractor alphabeticalPickerInteractor, boolean z) {
        Boolean bool = Boolean.TRUE;
        this.f6294f = bool;
        this.f6295g = bool;
        this.f6296h = new CompositeDisposable();
        this.f6289a = z;
        this.f6291c = alphabeticalPickerInteractor;
        this.f6290b = view;
    }

    public AlphabeticalPickerPresenterImpl(AlphabeticalPickerContract.View view, boolean z) {
        this(view, new AlphabeticalPickerInteractorImpl(), z);
    }

    public AlphabeticalPickerPresenterImpl(AlphabeticalPickerContract.View view, boolean z, boolean z2, boolean z3) {
        this(view, z);
        this.f6294f = Boolean.valueOf(z2);
        this.f6295g = Boolean.valueOf(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m4591a(AlphabeticalPickerData alphabeticalPickerData) {
        this.f6292d = alphabeticalPickerData;
        this.f6290b.displayItems(alphabeticalPickerData.getItems());
        String[] strArr = new String[0];
        if (this.f6295g.booleanValue()) {
            Set<String> setKeySet = this.f6292d.getIndexMap().keySet();
            strArr = (String[]) setKeySet.toArray(new String[setKeySet.size()]);
        }
        this.f6290b.displayIndexLetters(strArr);
    }

    /* JADX INFO: renamed from: a */
    private void m4592a(List<AlphabeticalPickerModel> list, AlphabeticalPickerFooterInfo alphabeticalPickerFooterInfo) {
        this.f6296h.add(this.f6291c.processPickerItems(this.f6294f.booleanValue(), list, alphabeticalPickerFooterInfo).subscribeOn(Schedulers.m5595io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerPresenterImpl$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.m4591a((AlphabeticalPickerData) obj);
            }
        }));
    }

    @Override // com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerContract.Presenter
    public void hideIndexLayout() {
        this.f6295g = Boolean.FALSE;
    }

    @Override // com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerContract.Presenter
    public void hideIndexLetters() {
        this.f6294f = Boolean.FALSE;
    }

    @Override // com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerContract.Presenter
    public void onConfirmClick() {
        this.f6290b.selectItem(this.f6293e);
    }

    @Override // com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerContract.Presenter
    public void onIndexLetterClick(String str) {
        Integer num = this.f6292d.getIndexMap().get(str);
        if (num != null) {
            this.f6290b.scrollTo(num.intValue(), false);
        }
    }

    @Override // com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerContract.Presenter
    public void onItemTick(AlphabeticalPickerModel alphabeticalPickerModel) {
        this.f6293e = alphabeticalPickerModel;
        if (this.f6289a) {
            this.f6290b.enableConfirmButton();
        } else {
            this.f6290b.selectItem(alphabeticalPickerModel);
        }
    }

    @Override // com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerContract.Presenter
    public void onSetItemAsTicked(AlphabeticalPickerModel alphabeticalPickerModel) {
        int iBinarySearch = Collections.binarySearch(this.f6292d.getMainItems(), alphabeticalPickerModel);
        if (iBinarySearch < 0) {
            iBinarySearch = this.f6292d.getFooterItems().indexOf(alphabeticalPickerModel) + this.f6292d.getMainItems().size();
        }
        onItemTick(alphabeticalPickerModel);
        this.f6290b.tickItemAtPosition(iBinarySearch);
        this.f6290b.scrollTo(iBinarySearch, true);
    }

    @Override // com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerContract.Presenter
    public void onSetItems(List<AlphabeticalPickerModel> list, AlphabeticalPickerFooterInfo alphabeticalPickerFooterInfo) {
        m4592a(list, alphabeticalPickerFooterInfo);
        if (this.f6289a) {
            this.f6290b.showConfirmButton();
        } else {
            this.f6290b.hideConfirmButton();
        }
    }

    @Override // com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerContract.Presenter
    public void onViewClear() {
        this.f6296h.clear();
    }

    @Override // com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerContract.Presenter
    public void showIndexLayout() {
        this.f6295g = Boolean.TRUE;
    }

    @Override // com.yoti.mobile.android.common.ui.widgets.alphabeticalPicker.AlphabeticalPickerContract.Presenter
    public void showIndexLetters() {
        this.f6294f = Boolean.TRUE;
    }
}
