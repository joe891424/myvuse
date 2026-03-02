package com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface AlphabeticalPickerContract {

    public interface Presenter {
        void hideIndexLayout();

        void hideIndexLetters();

        void onConfirmClick();

        void onIndexLetterClick(String str);

        void onItemTick(AlphabeticalPickerModel alphabeticalPickerModel);

        void onSetItemAsTicked(AlphabeticalPickerModel alphabeticalPickerModel);

        void onSetItems(List<AlphabeticalPickerModel> list, AlphabeticalPickerFooterInfo alphabeticalPickerFooterInfo);

        void onViewClear();

        void showIndexLayout();

        void showIndexLetters();
    }

    public interface View {
        void displayIndexLetters(String[] strArr);

        void displayItems(List<AlphabeticalPickerModel> list);

        void enableConfirmButton();

        void hideConfirmButton();

        void scrollTo(int i, boolean z);

        void selectItem(AlphabeticalPickerModel alphabeticalPickerModel);

        void showConfirmButton();

        void tickItemAtPosition(int i);
    }
}
