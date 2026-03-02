package com.newrelic.agent.android.analytics;

import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class SessionEvent extends AnalyticsEvent {
    public SessionEvent() {
        super(null, AnalyticsEventCategory.Session);
    }

    public SessionEvent(Set<AnalyticsAttribute> set) {
        super(null, AnalyticsEventCategory.Session, AnalyticsEvent.EVENT_TYPE_MOBILE, set);
    }
}
