package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.payload.PayloadStore;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface AnalyticsEventStore extends PayloadStore<AnalyticsEvent> {
    @Override // com.newrelic.agent.android.payload.PayloadStore
    void clear();

    @Override // com.newrelic.agent.android.payload.PayloadStore
    int count();

    @Override // com.newrelic.agent.android.payload.PayloadStore
    void delete(AnalyticsEvent analyticsEvent);

    @Override // com.newrelic.agent.android.payload.PayloadStore
    List<AnalyticsEvent> fetchAll();

    @Override // com.newrelic.agent.android.payload.PayloadStore
    boolean store(AnalyticsEvent analyticsEvent);
}
