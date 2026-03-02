package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.payload.PayloadStore;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface AnalyticsAttributeStore extends PayloadStore<AnalyticsAttribute> {
    @Override // com.newrelic.agent.android.payload.PayloadStore
    void clear();

    @Override // com.newrelic.agent.android.payload.PayloadStore
    int count();

    @Override // com.newrelic.agent.android.payload.PayloadStore
    void delete(AnalyticsAttribute analyticsAttribute);

    @Override // com.newrelic.agent.android.payload.PayloadStore
    List<AnalyticsAttribute> fetchAll();

    @Override // com.newrelic.agent.android.payload.PayloadStore
    boolean store(AnalyticsAttribute analyticsAttribute);
}
