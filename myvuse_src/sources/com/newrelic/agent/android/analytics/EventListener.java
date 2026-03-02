package com.newrelic.agent.android.analytics;

/* JADX INFO: loaded from: classes6.dex */
public interface EventListener {
    boolean onEventAdded(AnalyticsEvent analyticsEvent);

    boolean onEventEvicted(AnalyticsEvent analyticsEvent);

    void onEventFlush();

    boolean onEventOverflow(AnalyticsEvent analyticsEvent);

    void onEventQueueSizeExceeded(int i);

    void onEventQueueTimeExceeded(int i);

    void onShutdown();

    void onStart(EventManager eventManager);
}
