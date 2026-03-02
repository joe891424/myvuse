package com.newrelic.agent.android.tracing;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.Measurements;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.activity.NamedActivity;
import com.newrelic.agent.android.harvest.ActivitySighting;
import com.newrelic.agent.android.harvest.ConnectInformation;
import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.tracing.Sample;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonObject;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class ActivityTrace extends HarvestableArray {
    public static final int MAX_TRACES = 2000;
    private static final String SIZE_NORMAL = "NORMAL";
    public static final String TRACE_VERSION = "1.0";
    private boolean complete;
    public long lastUpdatedAt;
    private final AgentLog log;
    private NamedActivity measuredActivity;
    private final Set<UUID> missingChildren;
    public final Metric networkCountMetric;
    public final Metric networkTimeMetric;
    private final HashMap<String, String> params;
    public ActivitySighting previousActivity;
    private long reportAttemptCount;
    public Trace rootTrace;
    public long startedAt;
    private int traceCount;
    private final ConcurrentHashMap<UUID, Trace> traces;
    private Map<Sample.SampleType, Collection<Sample>> vitals;
    private static final HashMap<String, String> ENVIRONMENT_TYPE = new HashMap<String, String>() { // from class: com.newrelic.agent.android.tracing.ActivityTrace.1
        {
            put("type", "ENVIRONMENT");
        }
    };
    private static final HashMap<String, String> VITALS_TYPE = new HashMap<String, String>() { // from class: com.newrelic.agent.android.tracing.ActivityTrace.2
        {
            put("type", "VITALS");
        }
    };
    private static final HashMap<String, String> ACTIVITY_HISTORY_TYPE = new HashMap<String, String>() { // from class: com.newrelic.agent.android.tracing.ActivityTrace.3
        {
            put("type", "ACTIVITY_HISTORY");
        }
    };

    public ActivityTrace() {
        this.traces = new ConcurrentHashMap<>();
        this.traceCount = 0;
        this.missingChildren = Collections.synchronizedSet(new HashSet());
        this.reportAttemptCount = 0L;
        this.complete = false;
        this.params = new HashMap<>();
        this.log = AgentLogManager.getAgentLog();
        this.networkCountMetric = new Metric(MetricNames.ACTIVITY_NETWORK_METRIC_COUNT_FORMAT);
        this.networkTimeMetric = new Metric(MetricNames.ACTIVITY_NETWORK_METRIC_TIME_FORMAT);
    }

    public ActivityTrace(Trace trace) {
        this.traces = new ConcurrentHashMap<>();
        this.traceCount = 0;
        this.missingChildren = Collections.synchronizedSet(new HashSet());
        this.reportAttemptCount = 0L;
        this.complete = false;
        HashMap<String, String> map = new HashMap<>();
        this.params = map;
        this.log = AgentLogManager.getAgentLog();
        this.networkCountMetric = new Metric(MetricNames.ACTIVITY_NETWORK_METRIC_COUNT_FORMAT);
        this.networkTimeMetric = new Metric(MetricNames.ACTIVITY_NETWORK_METRIC_TIME_FORMAT);
        this.rootTrace = trace;
        long j = trace.entryTimestamp;
        this.lastUpdatedAt = j;
        this.startedAt = j;
        map.put("traceVersion", "1.0");
        map.put("type", "ACTIVITY");
        NamedActivity namedActivity = (NamedActivity) Measurements.startActivity(trace.displayName);
        this.measuredActivity = namedActivity;
        namedActivity.setStartTime(trace.entryTimestamp);
    }

    public String getId() {
        Trace trace = this.rootTrace;
        if (trace == null) {
            return null;
        }
        return trace.myUUID.toString();
    }

    public void addTrace(Trace trace) {
        this.missingChildren.add(trace.myUUID);
        this.lastUpdatedAt = System.currentTimeMillis();
    }

    public void addCompletedTrace(Trace trace) {
        if (trace.getType() == TraceType.NETWORK) {
            this.networkCountMetric.sample(1.0d);
            this.networkTimeMetric.sample(trace.getDurationAsSeconds());
            Trace trace2 = this.rootTrace;
            if (trace2 != null) {
                trace2.childExclusiveTime += trace.getDurationAsMilliseconds();
            }
        }
        trace.traceMachine = null;
        this.missingChildren.remove(trace.myUUID);
        if (this.traceCount > 2000) {
            this.log.verbose("Maximum trace limit reached, discarding trace " + String.valueOf(trace.myUUID));
            return;
        }
        this.traces.put(trace.myUUID, trace);
        this.traceCount++;
        if (trace.exitTimestamp > this.rootTrace.exitTimestamp) {
            this.rootTrace.exitTimestamp = trace.exitTimestamp;
        }
        this.log.verbose("Added trace " + trace.myUUID.toString() + " missing children: " + this.missingChildren.size());
        this.lastUpdatedAt = System.currentTimeMillis();
    }

    public boolean hasMissingChildren() {
        return !this.missingChildren.isEmpty();
    }

    public boolean isComplete() {
        return this.complete;
    }

    public void discard() {
        this.log.debug("Discarding trace of " + this.rootTrace.displayName + ":" + this.rootTrace.myUUID.toString() + "(" + this.traces.size() + " traces)");
        this.rootTrace.traceMachine = null;
        this.complete = true;
        Measurements.endActivityWithoutMeasurement(this.measuredActivity);
    }

    public void complete() {
        this.log.debug("Completing trace of " + this.rootTrace.displayName + ":" + this.rootTrace.myUUID.toString() + "(" + this.traces.size() + " traces)");
        if (this.rootTrace.exitTimestamp == 0) {
            this.rootTrace.exitTimestamp = System.currentTimeMillis();
        }
        if (this.traces.isEmpty()) {
            this.rootTrace.traceMachine = null;
            this.complete = true;
            Measurements.endActivityWithoutMeasurement(this.measuredActivity);
        } else {
            this.measuredActivity.setEndTime(this.rootTrace.exitTimestamp);
            Measurements.endActivity(this.measuredActivity);
            this.rootTrace.traceMachine = null;
            this.complete = true;
            TaskQueue.queue(this);
        }
    }

    public Map<UUID, Trace> getTraces() {
        return this.traces;
    }

    @Override // com.newrelic.agent.android.harvest.type.HarvestableArray, com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        if (!this.complete) {
            this.log.verbose("Attempted to serialize trace " + this.rootTrace.myUUID.toString() + " but it has yet to be finalized");
            return null;
        }
        jsonArray.add(new Gson().toJsonTree(this.params, GSON_STRING_MAP_TYPE));
        jsonArray.add(SafeJsonPrimitive.factory(Long.valueOf(this.rootTrace.entryTimestamp)));
        jsonArray.add(SafeJsonPrimitive.factory(Long.valueOf(this.rootTrace.exitTimestamp)));
        jsonArray.add(SafeJsonPrimitive.factory(this.rootTrace.displayName));
        JsonArray jsonArray2 = new JsonArray();
        jsonArray2.add(getEnvironment());
        jsonArray2.add(traceToTree(this.rootTrace));
        jsonArray2.add(getVitalsAsJson());
        if (this.previousActivity != null) {
            jsonArray2.add(getPreviousActivityAsJson());
        }
        jsonArray.add(jsonArray2);
        return jsonArray;
    }

    private JsonArray traceToTree(Trace trace) {
        JsonArray jsonArray = new JsonArray();
        trace.prepareForSerialization();
        jsonArray.add(new Gson().toJsonTree(trace.getParams(), GSON_STRING_MAP_TYPE));
        jsonArray.add(SafeJsonPrimitive.factory(Long.valueOf(trace.entryTimestamp)));
        jsonArray.add(SafeJsonPrimitive.factory(Long.valueOf(trace.exitTimestamp)));
        jsonArray.add(SafeJsonPrimitive.factory(trace.displayName));
        JsonArray jsonArray2 = new JsonArray();
        jsonArray2.add(SafeJsonPrimitive.factory(Long.valueOf(trace.threadId)));
        jsonArray2.add(SafeJsonPrimitive.factory(trace.threadName));
        jsonArray.add(jsonArray2);
        if (trace.getChildren().isEmpty()) {
            jsonArray.add(new JsonArray());
        } else {
            JsonArray jsonArray3 = new JsonArray();
            Iterator<UUID> it2 = trace.getChildren().iterator();
            while (it2.hasNext()) {
                Trace trace2 = this.traces.get(it2.next());
                if (trace2 != null) {
                    jsonArray3.add(traceToTree(trace2));
                }
            }
            jsonArray.add(jsonArray3);
        }
        return jsonArray;
    }

    private JsonArray getEnvironment() {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(new Gson().toJsonTree(ENVIRONMENT_TYPE, GSON_STRING_MAP_TYPE));
        jsonArray.addAll(new ConnectInformation(Agent.getApplicationInformation(), Agent.getDeviceInformation()).asJsonArray());
        HashMap map = new HashMap();
        map.put("size", SIZE_NORMAL);
        jsonArray.add(new Gson().toJsonTree(map, GSON_STRING_MAP_TYPE));
        return jsonArray;
    }

    public void setVitals(Map<Sample.SampleType, Collection<Sample>> map) {
        this.vitals = map;
    }

    private JsonArray getVitalsAsJson() {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(new Gson().toJsonTree(VITALS_TYPE, GSON_STRING_MAP_TYPE));
        JsonObject jsonObject = new JsonObject();
        Map<Sample.SampleType, Collection<Sample>> map = this.vitals;
        if (map != null) {
            for (Map.Entry<Sample.SampleType, Collection<Sample>> entry : map.entrySet()) {
                JsonArray jsonArray2 = new JsonArray();
                for (Sample sample : entry.getValue()) {
                    if (sample.getTimestamp() <= this.lastUpdatedAt) {
                        jsonArray2.add(sample.asJsonArray());
                    }
                }
                jsonObject.add(entry.getKey().toString(), jsonArray2);
            }
        }
        jsonArray.add(jsonObject);
        return jsonArray;
    }

    private JsonArray getPreviousActivityAsJson() {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(new Gson().toJsonTree(ACTIVITY_HISTORY_TYPE, GSON_STRING_MAP_TYPE));
        jsonArray.addAll(this.previousActivity.asJsonArray());
        return jsonArray;
    }

    public void setLastUpdatedAt(long j) {
        this.lastUpdatedAt = j;
    }

    public long getLastUpdatedAt() {
        return this.lastUpdatedAt;
    }

    public long getReportAttemptCount() {
        return this.reportAttemptCount;
    }

    public void incrementReportAttemptCount() {
        this.reportAttemptCount++;
    }

    public String getActivityName() {
        int iIndexOf;
        Trace trace = this.rootTrace;
        if (trace == null) {
            return "<activity>";
        }
        String str = trace.displayName;
        return (str == null || (iIndexOf = str.indexOf("#")) <= 0) ? str : str.substring(0, iIndexOf);
    }
}
