package com.yoti.mobile.android.documentcapture.view.selection;

import com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker.AlphabeticalPickerModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\t\u0010\n\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionListItem;", "Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerModel;", "_mainText", "", "option", "Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionOptionViewData;", "(Ljava/lang/String;Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionOptionViewData;)V", "getOption", "()Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionOptionViewData;", "component1", "component2", "copy", "equals", "", "other", "", "getMainText", "hashCode", "", "toString", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class CountrySelectionListItem extends AlphabeticalPickerModel {
    private final String _mainText;
    private final CountrySelectionOptionViewData option;

    public CountrySelectionListItem(String _mainText, CountrySelectionOptionViewData option) {
        Intrinsics.checkNotNullParameter(_mainText, "_mainText");
        Intrinsics.checkNotNullParameter(option, "option");
        this._mainText = _mainText;
        this.option = option;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final String get_mainText() {
        return this._mainText;
    }

    public static /* synthetic */ CountrySelectionListItem copy$default(CountrySelectionListItem countrySelectionListItem, String str, CountrySelectionOptionViewData countrySelectionOptionViewData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = countrySelectionListItem._mainText;
        }
        if ((i & 2) != 0) {
            countrySelectionOptionViewData = countrySelectionListItem.option;
        }
        return countrySelectionListItem.copy(str, countrySelectionOptionViewData);
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CountrySelectionOptionViewData getOption() {
        return this.option;
    }

    public final CountrySelectionListItem copy(String _mainText, CountrySelectionOptionViewData option) {
        Intrinsics.checkNotNullParameter(_mainText, "_mainText");
        Intrinsics.checkNotNullParameter(option, "option");
        return new CountrySelectionListItem(_mainText, option);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CountrySelectionListItem)) {
            return false;
        }
        CountrySelectionListItem countrySelectionListItem = (CountrySelectionListItem) other;
        return Intrinsics.areEqual(this._mainText, countrySelectionListItem._mainText) && Intrinsics.areEqual(this.option, countrySelectionListItem.option);
    }

    @Override // com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker.AlphabeticalPickerModel
    /* JADX INFO: renamed from: getMainText */
    public String getLetter() {
        return this._mainText;
    }

    public final CountrySelectionOptionViewData getOption() {
        return this.option;
    }

    public int hashCode() {
        return (this._mainText.hashCode() * 31) + this.option.hashCode();
    }

    public String toString() {
        return "CountrySelectionListItem(_mainText=" + this._mainText + ", option=" + this.option + ')';
    }
}
