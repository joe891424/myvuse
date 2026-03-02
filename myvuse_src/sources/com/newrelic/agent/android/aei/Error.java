package com.newrelic.agent.android.aei;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentImpl;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.aei.AEISessionMapper;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.crash.CrashReporter;
import com.newrelic.agent.android.harvest.DataToken;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.crash.ApplicationInfo;
import com.newrelic.agent.android.harvest.crash.DeviceInfo;
import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.agent.android.hybrid.data.HexAttribute;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.GsonBuilder;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonParser;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class Error extends HarvestableObject {
    public static final int MAX_UPLOAD_COUNT = 3;
    public static final int PROTOCOL_VERSION = 1;
    private static final Gson gson = new GsonBuilder().create();
    private final String agentName;
    private final String agentVersion;
    private ApplicationInfo applicationInfo;
    protected String buildId;
    private DataToken dataToken;
    private DeviceInfo deviceInfo;
    private HashMap<String, Object> event;
    private Set<AnalyticsAttribute> sessionAttributes;
    protected long timestamp;

    public Error(String str, long j) {
        AgentImpl impl = Agent.getImpl();
        this.agentVersion = Agent.getVersion();
        this.buildId = str;
        this.timestamp = j;
        this.deviceInfo = new DeviceInfo(impl.getDeviceInformation(), impl.getEnvironmentInformation());
        this.applicationInfo = new ApplicationInfo(impl.getApplicationInformation());
        this.sessionAttributes = new HashSet();
        this.event = new HashMap<>();
        this.agentName = impl.getDeviceInformation().getAgentName();
        this.dataToken = Harvest.getHarvestConfiguration().getDataToken();
    }

    public Error(Set<AnalyticsAttribute> set, HashMap<String, Object> map) {
        this(set, map, null);
    }

    public Error(Set<AnalyticsAttribute> set, HashMap<String, Object> map, AEISessionMapper.AEISessionMeta aEISessionMeta) {
        AgentImpl impl = Agent.getImpl();
        this.agentVersion = Agent.getVersion();
        this.buildId = getSafeBuildId();
        this.timestamp = System.currentTimeMillis();
        this.deviceInfo = new DeviceInfo(impl.getDeviceInformation(), impl.getEnvironmentInformation());
        this.applicationInfo = new ApplicationInfo(impl.getApplicationInformation());
        this.sessionAttributes = getErrorSessionAttributes(set);
        this.agentName = impl.getDeviceInformation().getAgentName();
        this.event = map;
        DataToken dataToken = Harvest.getHarvestConfiguration().getDataToken();
        this.dataToken = dataToken;
        if (aEISessionMeta != null) {
            dataToken.setAgentId(aEISessionMeta.realAgentId);
        }
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

    public void setSessionAttributes(Set<AnalyticsAttribute> set) {
        this.sessionAttributes = getErrorSessionAttributes(set);
    }

    public Set<AnalyticsAttribute> getSessionAttributes() {
        return this.sessionAttributes;
    }

    public void setAnalyticsEvents(HashMap<String, Object> map) {
        this.event = map;
    }

    public boolean getIsObfuscated() {
        return Agent.getIsObfuscated();
    }

    public Set<AnalyticsAttribute> getErrorSessionAttributes(Set<AnalyticsAttribute> set) {
        if (set == null) {
            return null;
        }
        HashSet hashSet = new HashSet(set);
        if (FeatureFlag.featureEnabled(FeatureFlag.OfflineStorage) && !Agent.hasReachableNetworkConnection(null)) {
            hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.OFFLINE_NAME_ATTRIBUTE, true));
            StatsEngine.notice().inc(MetricNames.OFFLINE_STORAGE_CRASH_COUNT);
        }
        if (FeatureFlag.featureEnabled(FeatureFlag.BackgroundReporting) && ApplicationStateMonitor.isAppInBackground()) {
            hashSet.add(new AnalyticsAttribute("background", true));
            StatsEngine.notice().inc(MetricNames.BACKGROUND_CRASH_COUNT);
        }
        hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.HARVEST_ACCOUNT_ID_ATTRIBUTE, Harvest.getHarvestConfiguration().getAccount_id()));
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // com.newrelic.agent.android.harvest.type.HarvestableObject, com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public JsonObject asJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("agentName", new JsonPrimitive(this.agentName));
        jsonObject.add("agentVersion", new JsonPrimitive(this.agentVersion));
        jsonObject.add("protocolVersion", new JsonPrimitive((Number) 1));
        jsonObject.add("platform", new JsonPrimitive("Android"));
        jsonObject.add(HexAttribute.HEX_ATTR_JSERROR_BUILDID, SafeJsonPrimitive.factory(this.buildId));
        jsonObject.add("timestamp", SafeJsonPrimitive.factory(Long.valueOf(this.timestamp)));
        jsonObject.add("deviceInfo", this.deviceInfo.asJsonObject());
        jsonObject.add("appInfo", this.applicationInfo.asJsonObject());
        JsonObject jsonObject2 = new JsonObject();
        Set<AnalyticsAttribute> set = this.sessionAttributes;
        if (set != null) {
            for (AnalyticsAttribute analyticsAttribute : set) {
                jsonObject2.add(analyticsAttribute.getName(), analyticsAttribute.asJsonElement());
            }
        }
        jsonObject.add("sessionAttributes", jsonObject2);
        JsonArray jsonArray = new JsonArray();
        HashMap<String, Object> map = this.event;
        if (map != null) {
            jsonArray.add(gson.toJsonTree(map));
        }
        jsonObject.add("analyticsEvents", jsonArray);
        jsonObject.add("dataToken", this.dataToken.asJsonArray());
        return jsonObject;
    }

    public static Error ErrorFromJsonString(String str) {
        JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
        Error error = new Error(asJsonObject.get(HexAttribute.HEX_ATTR_JSERROR_BUILDID).getAsString(), asJsonObject.get("timestamp").getAsLong());
        error.deviceInfo = DeviceInfo.newFromJson(asJsonObject.get("deviceInfo").getAsJsonObject());
        error.applicationInfo = ApplicationInfo.newFromJson(asJsonObject.get("appInfo").getAsJsonObject());
        if (asJsonObject.has("sessionAttributes")) {
            error.setSessionAttributes(AnalyticsAttribute.newFromJson(asJsonObject.get("sessionAttributes").getAsJsonObject()));
        }
        if (asJsonObject.has("analyticsEvents")) {
            ArrayList arrayList = new ArrayList();
            Iterator<JsonElement> it2 = asJsonObject.get("analyticsEvents").getAsJsonArray().iterator();
            while (it2.hasNext()) {
                arrayList.add((HashMap) gson.fromJson(it2.next(), HashMap.class));
            }
            if (!arrayList.isEmpty()) {
                error.setAnalyticsEvents((HashMap) arrayList.get(0));
            }
        }
        error.dataToken = DataToken.newFromJson(asJsonObject.get("dataToken").getAsJsonArray());
        return error;
    }
}
