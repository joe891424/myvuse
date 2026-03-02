package com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerLetter;", "Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerModel;", "", "getMainText", "()Ljava/lang/String;", "", "isSection", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "letter", "<init>", "(Ljava/lang/String;)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class AlphabeticalPickerLetter extends AlphabeticalPickerModel {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String letter;

    public AlphabeticalPickerLetter(String letter) {
        Intrinsics.checkNotNullParameter(letter, "letter");
        this.letter = letter;
    }

    public boolean equals(Object other) {
        if (!(other instanceof AlphabeticalPickerLetter)) {
            other = null;
        }
        AlphabeticalPickerLetter alphabeticalPickerLetter = (AlphabeticalPickerLetter) other;
        return alphabeticalPickerLetter != null && compareTo((AlphabeticalPickerModel) alphabeticalPickerLetter) == 0;
    }

    @Override // com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker.AlphabeticalPickerModel
    /* JADX INFO: renamed from: getMainText, reason: from getter */
    public String getLetter() {
        return this.letter;
    }

    @Override // com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker.AlphabeticalPickerModel
    public boolean isSection() {
        return true;
    }
}
