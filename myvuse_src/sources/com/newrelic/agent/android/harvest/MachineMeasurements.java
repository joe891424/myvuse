package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.metric.MetricStore;
import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.JsonArray;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public class MachineMeasurements extends HarvestableArray {
    protected final MetricStore metrics = new MetricStore();

    public void addMetric(String str, double d) {
        Metric metric = new Metric(str);
        metric.sample(d);
        addMetric(metric);
    }

    public void addMetric(Metric metric) {
        this.metrics.add(metric);
    }

    public void clear() {
        this.metrics.clear();
    }

    public boolean isEmpty() {
        return this.metrics.isEmpty();
    }

    public MetricStore getMetrics() {
        return this.metrics;
    }

    @Override // com.newrelic.agent.android.harvest.type.HarvestableArray, com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        for (Metric metric : this.metrics.getAll()) {
            JsonArray jsonArray2 = new JsonArray();
            HashMap map = new HashMap();
            map.put("name", metric.getName());
            map.put("scope", metric.getStringScope());
            jsonArray2.add(new Gson().toJsonTree(map, GSON_STRING_MAP_TYPE));
            jsonArray2.add(metric.asJsonObject());
            jsonArray.add(jsonArray2);
        }
        return jsonArray;
    }
}
