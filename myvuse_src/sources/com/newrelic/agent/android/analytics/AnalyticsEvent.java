package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes6.dex */
public class AnalyticsEvent extends HarvestableObject {
    public static final int EVENT_NAME_MAX_LENGTH = 255;
    public static final int EVENT_TYPE_LIMIT = 250;
    public static final String EVENT_TYPE_MOBILE = "Mobile";
    public static final String EVENT_TYPE_MOBILE_APPLICATION_EXIT = "MobileApplicationExit";
    public static final String EVENT_TYPE_MOBILE_BREADCRUMB = "MobileBreadcrumb";
    public static final String EVENT_TYPE_MOBILE_CRASH = "MobileCrash";
    public static final String EVENT_TYPE_MOBILE_REQUEST = "MobileRequest";
    public static final String EVENT_TYPE_MOBILE_REQUEST_ERROR = "MobileRequestError";
    public static final String EVENT_TYPE_MOBILE_USER_ACTION = "MobileUserAction";
    protected Set<AnalyticsAttribute> attributeSet;
    protected AnalyticsEventCategory category;
    protected String eventType;
    protected String name;
    protected long timestamp;
    protected String uuid;
    protected static final AgentLog log = AgentLogManager.getAgentLog();
    public static final String EVENT_NAME_IS_TYPE = null;
    protected static final AnalyticsValidator validator = new AnalyticsValidator();

    public AnalyticsEvent(String str) {
        this(str, AnalyticsEventCategory.Custom, null, null);
    }

    protected AnalyticsEvent(String str, AnalyticsEventCategory analyticsEventCategory) {
        this(str, analyticsEventCategory, null, null);
    }

    protected AnalyticsEvent(String str, AnalyticsEventCategory analyticsEventCategory, String str2, Set<AnalyticsAttribute> set) {
        this(str, analyticsEventCategory, str2, System.currentTimeMillis(), set);
    }

    AnalyticsEvent(AnalyticsEvent analyticsEvent) {
        this(analyticsEvent.name, analyticsEvent.category, analyticsEvent.eventType, analyticsEvent.timestamp, analyticsEvent.attributeSet);
    }

    AnalyticsEvent(String str, AnalyticsEventCategory analyticsEventCategory, String str2, long j, Set<AnalyticsAttribute> set) {
        this.attributeSet = Collections.synchronizedSet(new HashSet());
        this.uuid = UUID.randomUUID().toString();
        this.name = str;
        this.timestamp = j;
        AnalyticsValidator analyticsValidator = validator;
        this.category = analyticsValidator.toValidCategory(analyticsEventCategory);
        this.eventType = analyticsValidator.toValidEventType(str2);
        if (set != null) {
            for (AnalyticsAttribute analyticsAttribute : set) {
                if (validator.isValidKeyName(analyticsAttribute.getName())) {
                    this.attributeSet.add(new AnalyticsAttribute(analyticsAttribute));
                }
            }
        }
        if (validator.isValidEventName(str)) {
            this.attributeSet.add(new AnalyticsAttribute("name", this.name));
        }
        this.attributeSet.add(new AnalyticsAttribute("timestamp", String.valueOf(this.timestamp)));
        this.attributeSet.add(new AnalyticsAttribute(AnalyticsAttribute.EVENT_CATEGORY_ATTRIBUTE, this.category.name()));
        this.attributeSet.add(new AnalyticsAttribute(AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE, this.eventType));
        if (FeatureFlag.featureEnabled(FeatureFlag.OfflineStorage) && !Agent.hasReachableNetworkConnection(null)) {
            this.attributeSet.add(new AnalyticsAttribute(AnalyticsAttribute.OFFLINE_NAME_ATTRIBUTE, true));
            StatsEngine.notice().inc(MetricNames.OFFLINE_STORAGE_EVENT_COUNT);
        }
        if (FeatureFlag.featureEnabled(FeatureFlag.BackgroundReporting) && ApplicationStateMonitor.isAppInBackground()) {
            this.attributeSet.add(new AnalyticsAttribute("background", true));
            StatsEngine.notice().inc(MetricNames.BACKGROUND_EVENT_COUNT);
        }
    }

    public void addAttributes(Set<AnalyticsAttribute> set) {
        if (set != null) {
            for (AnalyticsAttribute analyticsAttribute : set) {
                if (!validator.isValidAttribute(analyticsAttribute) || !this.attributeSet.add(analyticsAttribute)) {
                    log.error("Failed to add attribute " + analyticsAttribute.getName() + " to event " + getName() + ": the attribute is invalid or the event already contains that attribute.");
                }
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public AnalyticsEventCategory getCategory() {
        return this.category;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getEventType() {
        return this.eventType;
    }

    public String getEventUUID() {
        return this.uuid;
    }

    public void setEventUUID(String str) {
        this.uuid = str;
    }

    @Override // com.newrelic.agent.android.harvest.type.HarvestableObject, com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public JsonObject asJsonObject() {
        JsonObject jsonObject = new JsonObject();
        synchronized (this) {
            for (AnalyticsAttribute analyticsAttribute : this.attributeSet) {
                jsonObject.add(analyticsAttribute.getName(), analyticsAttribute.asJsonElement());
            }
        }
        return jsonObject;
    }

    public Collection<AnalyticsAttribute> getAttributeSet() {
        return Collections.unmodifiableCollection(this.attributeSet);
    }

    public Collection<AnalyticsAttribute> getMutableAttributeSet() {
        return Collections.checkedSet(this.attributeSet, AnalyticsAttribute.class);
    }

    public static AnalyticsEvent newFromJson(JsonObject jsonObject) {
        HashSet hashSet = new HashSet();
        String asString = null;
        long asLong = 0;
        String asString2 = null;
        AnalyticsEventCategory analyticsEventCategoryFromString = null;
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            if (key.equalsIgnoreCase("name")) {
                asString2 = entry.getValue().getAsString();
            } else if (key.equalsIgnoreCase(AnalyticsAttribute.EVENT_CATEGORY_ATTRIBUTE)) {
                analyticsEventCategoryFromString = AnalyticsEventCategory.fromString(entry.getValue().getAsString());
            } else if (key.equalsIgnoreCase(AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE)) {
                asString = entry.getValue().getAsString();
            } else if (key.equalsIgnoreCase("timestamp")) {
                asLong = entry.getValue().getAsLong();
            } else {
                JsonPrimitive asJsonPrimitive = entry.getValue().getAsJsonPrimitive();
                if (asJsonPrimitive.isString()) {
                    hashSet.add(new AnalyticsAttribute(key, asJsonPrimitive.getAsString(), false));
                } else if (asJsonPrimitive.isBoolean()) {
                    hashSet.add(new AnalyticsAttribute(key, asJsonPrimitive.getAsBoolean(), false));
                } else if (asJsonPrimitive.isNumber()) {
                    hashSet.add(new AnalyticsAttribute(key, asJsonPrimitive.getAsFloat(), false));
                }
            }
        }
        return new AnalyticsEvent(asString2, analyticsEventCategoryFromString, asString, asLong, hashSet);
    }

    public static AnalyticsEvent eventFromJsonString(String str, String str2) {
        AnalyticsEvent analyticsEventNewFromJson = newFromJson((JsonObject) new Gson().fromJson(str2, JsonObject.class));
        analyticsEventNewFromJson.setEventUUID(str);
        return analyticsEventNewFromJson;
    }

    public static Collection<AnalyticsEvent> newFromJson(JsonArray jsonArray) {
        ArrayList arrayList = new ArrayList();
        Iterator<JsonElement> it2 = jsonArray.iterator();
        while (it2.hasNext()) {
            arrayList.add(newFromJson(it2.next().getAsJsonObject()));
        }
        return arrayList;
    }

    public boolean isValid() {
        return isValid(this.name, this.eventType);
    }

    static boolean isValid(String str, String str2) {
        AnalyticsValidator analyticsValidator = validator;
        return analyticsValidator.isValidEventName(str) && analyticsValidator.isValidEventType(str2) && !analyticsValidator.isReservedEventType(str2);
    }
}
