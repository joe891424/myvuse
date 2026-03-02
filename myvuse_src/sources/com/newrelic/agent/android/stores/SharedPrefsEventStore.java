package com.newrelic.agent.android.stores;

import android.content.Context;
import android.content.SharedPreferences;
import com.newrelic.agent.android.analytics.AnalyticsEvent;
import com.newrelic.agent.android.analytics.AnalyticsEventStore;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class SharedPrefsEventStore extends SharedPrefsStore implements AnalyticsEventStore {
    private static final String STORE_FILE = "NREventStore";
    private static final AgentLog log = AgentLogManager.getAgentLog();

    public SharedPrefsEventStore(Context context) {
        this(context, STORE_FILE);
    }

    public SharedPrefsEventStore(Context context, String str) {
        super(context, str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.newrelic.agent.android.analytics.AnalyticsEventStore, com.newrelic.agent.android.payload.PayloadStore
    public boolean store(AnalyticsEvent analyticsEvent) {
        boolean zApplyOrCommitEditor;
        synchronized (this) {
            try {
                try {
                    String string = analyticsEvent.asJsonObject().toString();
                    SharedPreferences.Editor editorEdit = this.sharedPrefs.edit();
                    editorEdit.putString(analyticsEvent.getEventUUID(), string);
                    StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_EVENT_SIZE_UNCOMPRESSED, string.length());
                    zApplyOrCommitEditor = applyOrCommitEditor(editorEdit);
                } catch (Exception e) {
                    log.error("SharedPrefsStore.store(String, String): ", e);
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zApplyOrCommitEditor;
    }

    @Override // com.newrelic.agent.android.stores.SharedPrefsStore, com.newrelic.agent.android.analytics.AnalyticsAttributeStore, com.newrelic.agent.android.payload.PayloadStore
    public List<AnalyticsEvent> fetchAll() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : this.sharedPrefs.getAll().entrySet()) {
            if (entry.getValue() instanceof String) {
                try {
                    arrayList.add(AnalyticsEvent.eventFromJsonString(entry.getKey(), (String) entry.getValue()));
                } catch (Exception e) {
                    log.error("Exception encountered while deserializing event", e);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.newrelic.agent.android.analytics.AnalyticsEventStore, com.newrelic.agent.android.payload.PayloadStore
    public void delete(AnalyticsEvent analyticsEvent) {
        try {
            synchronized (this) {
                this.sharedPrefs.edit().remove(analyticsEvent.getEventUUID()).apply();
            }
        } catch (Exception e) {
            log.error("SharedPrefsEventStore.delete(): ", e);
        }
    }
}
