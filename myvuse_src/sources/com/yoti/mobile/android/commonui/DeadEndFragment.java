package com.yoti.mobile.android.commonui;

import kotlin.Metadata;

/* JADX INFO: compiled from: DeadEndFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/DeadEndFragment;", "Lcom/yoti/mobile/android/commonui/GenericMessageFragment;", "()V", "navigateBack", "", "onActionButtonClicked", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DeadEndFragment extends GenericMessageFragment {
    @Override // com.yoti.mobile.android.commonui.GenericMessageFragment
    public void onActionButtonClicked() {
        super.onActionButtonClicked();
        finishSdk();
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment
    protected void navigateBack() {
        finishSdk();
    }
}
