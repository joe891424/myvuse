package com.yoti.mobile.android.common.p049ui.widgets;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/OnFeedbackInteraction;", "", "", AnalyticsAttribute.UUID_ATTRIBUTE, "", "onPrimaryClicked", "(Ljava/lang/String;)V", "onSecondaryClicked", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public interface OnFeedbackInteraction {
    void onPrimaryClicked(String uuid);

    void onSecondaryClicked(String uuid);
}
