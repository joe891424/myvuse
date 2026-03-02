package com.yoti.mobile.android.documentcapture.sup.view.review;

import android.os.Bundle;
import android.view.View;
import com.yoti.mobile.android.common.p049ui.widgets.CommonYotiAppBar;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.GenericMessageFragment;
import com.yoti.mobile.android.documentcapture.sup.C4653R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001a\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/FileOpenErrorFragment;", "Lcom/yoti/mobile/android/commonui/GenericMessageFragment;", "()V", "onActionButtonClicked", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FileOpenErrorFragment extends GenericMessageFragment {
    @Override // com.yoti.mobile.android.commonui.GenericMessageFragment
    public void onActionButtonClicked() {
        navigateBack();
    }

    @Override // com.yoti.mobile.android.commonui.GenericMessageFragment, com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(C4653R.id.appBar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "view.findViewById(R.id.appBar)");
        BaseFragment.configureAppBar$default(this, (CommonYotiAppBar) viewFindViewById, NavigationIcon.BACK_BLUE, false, 0, 0, 0, 60, null);
    }
}
