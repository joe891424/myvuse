package com.newrelic.agent.android.analytics;

import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class NetworkEventTransformer extends EventTransformAdapter {
    public NetworkEventTransformer(Map<String, String> map) {
        withAttributeTransform(AnalyticsAttribute.REQUEST_URL_ATTRIBUTE, map);
    }

    @Override // com.newrelic.agent.android.analytics.EventTransformAdapter, com.newrelic.agent.android.analytics.EventListener
    public boolean onEventAdded(AnalyticsEvent analyticsEvent) {
        String eventType = analyticsEvent.getEventType();
        eventType.hashCode();
        if (eventType.equals(AnalyticsEvent.EVENT_TYPE_MOBILE_REQUEST_ERROR) || eventType.equals(AnalyticsEvent.EVENT_TYPE_MOBILE_REQUEST)) {
            onEventTransform(analyticsEvent);
        }
        return super.onEventAdded(analyticsEvent);
    }
}
