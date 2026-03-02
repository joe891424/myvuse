package com.newrelic.agent.android.crash;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentImpl;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.analytics.AnalyticsEvent;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.harvest.ActivityHistory;
import com.newrelic.agent.android.harvest.DataToken;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.crash.ApplicationInfo;
import com.newrelic.agent.android.harvest.crash.DeviceInfo;
import com.newrelic.agent.android.harvest.crash.ExceptionInfo;
import com.newrelic.agent.android.harvest.crash.ThreadInfo;
import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.agent.android.hybrid.data.HexAttribute;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonParser;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes6.dex */
public class Crash extends HarvestableObject {
    public static final int MAX_UPLOAD_COUNT = 3;
    public static final int PROTOCOL_VERSION = 1;
    private ActivityHistory activityHistory;
    private boolean analyticsEnabled;
    private final String appToken;
    private ApplicationInfo applicationInfo;
    protected String buildId;
    private DataToken dataToken;
    private DeviceInfo deviceInfo;
    private Collection<AnalyticsEvent> events;
    private ExceptionInfo exceptionInfo;
    private Set<AnalyticsAttribute> sessionAttributes;
    private List<ThreadInfo> threads;
    protected long timestamp;
    private int uploadCount;
    private final UUID uuid;

    public Crash(UUID uuid, String str, long j) {
        AgentImpl impl = Agent.getImpl();
        this.uuid = uuid;
        this.buildId = str;
        this.timestamp = j;
        this.appToken = getAppToken();
        this.deviceInfo = new DeviceInfo(impl.getDeviceInformation(), impl.getEnvironmentInformation());
        this.applicationInfo = new ApplicationInfo(impl.getApplicationInformation());
        this.exceptionInfo = new ExceptionInfo();
        this.threads = new ArrayList();
        this.activityHistory = new ActivityHistory(new ArrayList());
        this.sessionAttributes = new HashSet();
        this.events = new HashSet();
        this.analyticsEnabled = true;
        this.uploadCount = 0;
        this.dataToken = Harvest.getHarvestConfiguration().getDataToken();
    }

    public Crash(Throwable th) {
        this(th, new HashSet(), new HashSet(), false);
    }

    public Crash(Throwable th, Set<AnalyticsAttribute> set, Collection<AnalyticsEvent> collection, boolean z) {
        AgentImpl impl = Agent.getImpl();
        Throwable rootCause = getRootCause(th);
        this.uuid = UUID.randomUUID();
        this.buildId = getSafeBuildId();
        this.timestamp = System.currentTimeMillis();
        this.appToken = getAppToken();
        this.deviceInfo = new DeviceInfo(impl.getDeviceInformation(), impl.getEnvironmentInformation());
        this.applicationInfo = new ApplicationInfo(impl.getApplicationInformation());
        this.exceptionInfo = new ExceptionInfo(rootCause);
        this.threads = extractThreads(rootCause);
        this.activityHistory = TraceMachine.getActivityHistory();
        this.sessionAttributes = getCrashSessionAttributes(set);
        this.events = collection;
        this.analyticsEnabled = z;
        this.uploadCount = 0;
        this.dataToken = Harvest.getHarvestConfiguration().getDataToken();
    }

    protected String getAppToken() {
        if (CrashReporter.getInstance() != null) {
            return CrashReporter.getInstance().getAgentConfiguration().getApplicationToken();
        }
        return "<missing app token>";
    }

    protected DataToken getDataToken() {
        return this.dataToken;
    }

    public void setDataToken(DataToken dataToken) {
        this.dataToken = dataToken;
    }

    public static String getSafeBuildId() {
        String buildId = getBuildId();
        if (buildId == null || buildId.isEmpty()) {
            buildId = Agent.getBuildId();
            StatsEngine.get().inc(MetricNames.SUPPORTABILITY_CRASH_INVALID_BUILDID);
            if (buildId == null || buildId.isEmpty()) {
                AgentLogManager.getAgentLog().error("Invalid (null or empty) build ID detected! Crash will be ignored by collector.");
            }
        }
        return buildId;
    }

    public static String getBuildId() {
        return Agent.getBuildId();
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public ExceptionInfo getExceptionInfo() {
        return this.exceptionInfo;
    }

    public void setSessionAttributes(Set<AnalyticsAttribute> set) {
        this.sessionAttributes = getCrashSessionAttributes(set);
    }

    public Set<AnalyticsAttribute> getSessionAttributes() {
        return this.sessionAttributes;
    }

    public void setAnalyticsEvents(Collection<AnalyticsEvent> collection) {
        this.events = collection;
    }

    public boolean getIsObfuscated() {
        return Agent.getIsObfuscated();
    }

    public Set<AnalyticsAttribute> getCrashSessionAttributes(Set<AnalyticsAttribute> set) {
        if (set == null) {
            return null;
        }
        HashSet hashSet = new HashSet(set);
        hashSet.add(new AnalyticsAttribute("obfuscated", getIsObfuscated()));
        if (FeatureFlag.featureEnabled(FeatureFlag.OfflineStorage) && !Agent.hasReachableNetworkConnection(null)) {
            hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.OFFLINE_NAME_ATTRIBUTE, true));
            StatsEngine.notice().inc(MetricNames.OFFLINE_STORAGE_CRASH_COUNT);
        }
        if (FeatureFlag.featureEnabled(FeatureFlag.BackgroundReporting) && ApplicationStateMonitor.isAppInBackground()) {
            hashSet.add(new AnalyticsAttribute("background", true));
            StatsEngine.notice().inc(MetricNames.BACKGROUND_CRASH_COUNT);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // com.newrelic.agent.android.harvest.type.HarvestableObject, com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public JsonObject asJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("protocolVersion", new JsonPrimitive((Number) 1));
        jsonObject.add("platform", new JsonPrimitive("Android"));
        jsonObject.add(AnalyticsAttribute.UUID_ATTRIBUTE, SafeJsonPrimitive.factory(this.uuid.toString()));
        jsonObject.add(HexAttribute.HEX_ATTR_JSERROR_BUILDID, SafeJsonPrimitive.factory(this.buildId));
        jsonObject.add("timestamp", SafeJsonPrimitive.factory(Long.valueOf(this.timestamp)));
        jsonObject.add("appToken", SafeJsonPrimitive.factory(this.appToken));
        jsonObject.add("deviceInfo", this.deviceInfo.asJsonObject());
        jsonObject.add("appInfo", this.applicationInfo.asJsonObject());
        jsonObject.add("exception", this.exceptionInfo.asJsonObject());
        jsonObject.add(AnalyticsAttribute.APP_EXIT_THREADS_ATTRIBUTE, getThreadsAsJson());
        jsonObject.add("activityHistory", this.activityHistory.asJsonArrayWithoutDuration());
        JsonObject jsonObject2 = new JsonObject();
        Set<AnalyticsAttribute> set = this.sessionAttributes;
        if (set != null) {
            for (AnalyticsAttribute analyticsAttribute : set) {
                jsonObject2.add(analyticsAttribute.getName(), analyticsAttribute.asJsonElement());
            }
        }
        jsonObject.add("sessionAttributes", jsonObject2);
        JsonArray jsonArray = new JsonArray();
        Collection<AnalyticsEvent> collection = this.events;
        if (collection != null) {
            Iterator<AnalyticsEvent> it2 = collection.iterator();
            while (it2.hasNext()) {
                jsonArray.add(it2.next().asJsonObject());
            }
        }
        jsonObject.add("analyticsEvents", jsonArray);
        jsonObject.add("dataToken", this.dataToken.asJsonArray());
        return jsonObject;
    }

    public static Crash crashFromJsonString(String str) {
        JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
        Crash crash = new Crash(UUID.fromString(asJsonObject.get(AnalyticsAttribute.UUID_ATTRIBUTE).getAsString()), asJsonObject.get(HexAttribute.HEX_ATTR_JSERROR_BUILDID).getAsString(), asJsonObject.get("timestamp").getAsLong());
        crash.deviceInfo = DeviceInfo.newFromJson(asJsonObject.get("deviceInfo").getAsJsonObject());
        crash.applicationInfo = ApplicationInfo.newFromJson(asJsonObject.get("appInfo").getAsJsonObject());
        crash.exceptionInfo = ExceptionInfo.newFromJson(asJsonObject.get("exception").getAsJsonObject());
        crash.threads = crash.newListFromJson(asJsonObject.get(AnalyticsAttribute.APP_EXIT_THREADS_ATTRIBUTE).getAsJsonArray());
        crash.activityHistory = ActivityHistory.newFromJson(asJsonObject.get("activityHistory").getAsJsonArray());
        crash.analyticsEnabled = asJsonObject.has("sessionAttributes") || asJsonObject.has("analyticsEvents");
        if (asJsonObject.has("sessionAttributes")) {
            crash.setSessionAttributes(AnalyticsAttribute.newFromJson(asJsonObject.get("sessionAttributes").getAsJsonObject()));
        }
        if (asJsonObject.has("analyticsEvents")) {
            crash.setAnalyticsEvents(AnalyticsEvent.newFromJson(asJsonObject.get("analyticsEvents").getAsJsonArray()));
        }
        if (asJsonObject.has("uploadCount")) {
            crash.uploadCount = asJsonObject.get("uploadCount").getAsInt();
        }
        crash.dataToken = DataToken.newFromJson(asJsonObject.get("dataToken").getAsJsonArray());
        return crash;
    }

    protected Throwable getRootCause(Throwable th) {
        return th != null ? th : new Throwable("Unknown cause");
    }

    protected JsonArray getThreadsAsJson() {
        JsonArray jsonArray = new JsonArray();
        List<ThreadInfo> list = this.threads;
        if (list != null) {
            Iterator<ThreadInfo> it2 = list.iterator();
            while (it2.hasNext()) {
                jsonArray.add(it2.next().asJsonObject());
            }
        }
        return jsonArray;
    }

    public void incrementUploadCount() {
        this.uploadCount++;
    }

    public int getUploadCount() {
        return this.uploadCount;
    }

    public boolean isStale() {
        return this.uploadCount >= 3;
    }

    protected List<ThreadInfo> extractThreads(Throwable th) {
        return new ThreadInfo(th).allThreads();
    }

    protected List<ThreadInfo> newListFromJson(JsonArray jsonArray) {
        return new ThreadInfo().newListFromJson(jsonArray);
    }
}
