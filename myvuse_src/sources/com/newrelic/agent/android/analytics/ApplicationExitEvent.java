package com.newrelic.agent.android.analytics;

import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class ApplicationExitEvent extends AnalyticsEvent {
    public ApplicationExitEvent(String str, Set<AnalyticsAttribute> set) {
        super(str, AnalyticsEventCategory.ApplicationExit, AnalyticsEvent.EVENT_TYPE_MOBILE_APPLICATION_EXIT, set);
    }

    @Override // com.newrelic.agent.android.analytics.AnalyticsEvent
    public boolean isValid() {
        return validator.isValidEventName(this.name) && validator.isValidEventType(this.eventType);
    }
}
