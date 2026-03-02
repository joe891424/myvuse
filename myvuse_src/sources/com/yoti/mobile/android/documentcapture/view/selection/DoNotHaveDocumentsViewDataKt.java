package com.yoti.mobile.android.documentcapture.view.selection;

import com.yoti.mobile.android.documentcapture.C4597R;
import com.yoti.mobile.android.documentcapture.view.DocumentScreen;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¨\u0006\u0005"}, m5598d2 = {"getLabel", "", "screen", "Lcom/yoti/mobile/android/documentcapture/view/DocumentScreen;", "numDocuments", "documentcapture-core_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DoNotHaveDocumentsViewDataKt {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DocumentScreen.values().length];
            iArr[DocumentScreen.DOCUMENT_SELECTION.ordinal()] = 1;
            iArr[DocumentScreen.DOCUMENT_EDUCATIONAL.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getLabel(DocumentScreen documentScreen, int i) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[documentScreen.ordinal()];
        if (i2 == 1) {
            return i > 1 ? C4597R.string.yds_document_selection_dont_have_any_documents : C4597R.string.yds_document_selection_dont_have_document;
        }
        if (i2 == 2) {
            return C4597R.string.ios_android_yds_document_education_dont_own_one;
        }
        throw new NoWhenBranchMatchedException();
    }
}
