package com.newrelic.agent.android.analytics;

import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class BreadcrumbEvent extends AnalyticsEvent {
    public BreadcrumbEvent(String str, Set<AnalyticsAttribute> set) {
        super(str, AnalyticsEventCategory.Breadcrumb, AnalyticsEvent.EVENT_TYPE_MOBILE_BREADCRUMB, set);
    }
}
