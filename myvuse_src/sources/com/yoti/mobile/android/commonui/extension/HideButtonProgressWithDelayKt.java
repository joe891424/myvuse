package com.yoti.mobile.android.commonui.extension;

import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HideButtonProgressWithDelay.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m5598d2 = {"DELAY_HIDE_PROGRESS", "", "hideProgressWithDelay", "", "Lcom/yoti/mobile/android/common/ui/widgets/YotiButton;", "commonUI_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class HideButtonProgressWithDelayKt {
    private static final long DELAY_HIDE_PROGRESS = 400;

    public static final void hideProgressWithDelay(final YotiButton yotiButton) {
        Intrinsics.checkNotNullParameter(yotiButton, "<this>");
        yotiButton.postDelayed(new Runnable() { // from class: com.yoti.mobile.android.commonui.extension.HideButtonProgressWithDelayKt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                HideButtonProgressWithDelayKt.m6796hideProgressWithDelay$lambda0(yotiButton);
            }
        }, 400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: hideProgressWithDelay$lambda-0, reason: not valid java name */
    public static final void m6796hideProgressWithDelay$lambda0(YotiButton this_hideProgressWithDelay) {
        Intrinsics.checkNotNullParameter(this_hideProgressWithDelay, "$this_hideProgressWithDelay");
        this_hideProgressWithDelay.hideProgress();
    }
}
