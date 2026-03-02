package com.newrelic.agent.android.stores;

import android.content.Context;
import android.content.SharedPreferences;
import com.newrelic.agent.android.crash.Crash;
import com.newrelic.agent.android.crash.CrashStore;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class SharedPrefsCrashStore extends SharedPrefsStore implements CrashStore {
    private static final String STORE_FILE = "NRCrashStore";

    public SharedPrefsCrashStore(Context context) {
        this(context, STORE_FILE);
    }

    public SharedPrefsCrashStore(Context context, String str) {
        super(context, str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.newrelic.agent.android.crash.CrashStore, com.newrelic.agent.android.payload.PayloadStore
    public boolean store(Crash crash) {
        boolean zCommit;
        synchronized (this) {
            try {
                try {
                    JsonObject jsonObjectAsJsonObject = crash.asJsonObject();
                    jsonObjectAsJsonObject.add("uploadCount", SafeJsonPrimitive.factory(Integer.valueOf(crash.getUploadCount())));
                    String string = jsonObjectAsJsonObject.toString();
                    SharedPreferences.Editor editorEdit = this.sharedPrefs.edit();
                    editorEdit.putString(crash.getUuid().toString(), string);
                    StatsEngine.get().inc(MetricNames.SUPPORTABILITY_CRASH_SIZE_UNCOMPRESSED, string.length());
                    zCommit = editorEdit.commit();
                } catch (Exception e) {
                    log.error("SharedPrefsStore.store(String, String): ", e);
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zCommit;
    }

    @Override // com.newrelic.agent.android.stores.SharedPrefsStore, com.newrelic.agent.android.analytics.AnalyticsAttributeStore, com.newrelic.agent.android.payload.PayloadStore
    public List<Crash> fetchAll() {
        ArrayList arrayList = new ArrayList();
        for (Object obj : super.fetchAll()) {
            if (obj instanceof String) {
                try {
                    arrayList.add(Crash.crashFromJsonString((String) obj));
                } catch (Exception e) {
                    log.error("Exception encountered while deserializing crash", e);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.newrelic.agent.android.crash.CrashStore, com.newrelic.agent.android.payload.PayloadStore
    public void delete(Crash crash) {
        try {
            synchronized (this) {
                this.sharedPrefs.edit().remove(crash.getUuid().toString()).commit();
            }
        } catch (Exception e) {
            log.error("SharedPrefsCrashStore.delete(): ", e);
        }
    }
}
