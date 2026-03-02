package com.newrelic.agent.android.analytics;

import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class UserActionEvent extends AnalyticsEvent {
    public UserActionEvent(String str, Set<AnalyticsAttribute> set) {
        super(str, AnalyticsEventCategory.UserAction, AnalyticsEvent.EVENT_TYPE_MOBILE_USER_ACTION, set);
    }
}
