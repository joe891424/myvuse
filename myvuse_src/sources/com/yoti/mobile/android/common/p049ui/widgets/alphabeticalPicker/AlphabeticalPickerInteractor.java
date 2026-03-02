package com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J7\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerInteractor;", "", "", "shouldShowIndexLetter", "", "Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerModel;", FirebaseAnalytics.Param.ITEMS, "Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerFooterInfo;", "footerInfo", "Lio/reactivex/Single;", "Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerData;", "processPickerItems", "(ZLjava/util/List;Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerFooterInfo;)Lio/reactivex/Single;", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public interface AlphabeticalPickerInteractor {

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {}, m5598d2 = {}, m5599k = 3, m5600mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Single processPickerItems$default(AlphabeticalPickerInteractor alphabeticalPickerInteractor, boolean z, List list, AlphabeticalPickerFooterInfo alphabeticalPickerFooterInfo, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: processPickerItems");
            }
            if ((i & 4) != 0) {
                alphabeticalPickerFooterInfo = null;
            }
            return alphabeticalPickerInteractor.processPickerItems(z, list, alphabeticalPickerFooterInfo);
        }
    }

    Single<AlphabeticalPickerData> processPickerItems(boolean shouldShowIndexLetter, List<? extends AlphabeticalPickerModel> items, AlphabeticalPickerFooterInfo footerInfo);
}
