package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.analytics.AnalyticsEvent;
import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class HarvestData extends HarvestableArray implements HarvestConfigurable {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private double harvestTimeDelta;
    private DataToken dataToken = new DataToken();
    private HttpTransactions httpTransactions = new HttpTransactions();
    private ActivityTraces activityTraces = new ActivityTraces();
    private MachineMeasurements machineMeasurements = new MachineMeasurements();
    private DeviceInformation deviceInformation = Agent.getDeviceInformation();
    private AgentHealth agentHealth = new AgentHealth();
    private Set<AnalyticsAttribute> sessionAttributes = new HashSet();
    private Collection<AnalyticsEvent> analyticsEvents = new ArrayList();
    private boolean analyticsEnabled = false;

    @Override // com.newrelic.agent.android.harvest.type.HarvestableArray, com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(this.dataToken.asJson());
        jsonArray.add(this.deviceInformation.asJson());
        jsonArray.add(new JsonPrimitive(Double.valueOf(this.harvestTimeDelta)));
        jsonArray.add(this.httpTransactions.asJson());
        jsonArray.add(this.machineMeasurements.asJson());
        jsonArray.add(new JsonArray());
        JsonElement jsonElementAsJson = this.activityTraces.asJson();
        if (jsonElementAsJson.toString().length() < Harvest.getHarvestConfiguration().getActivity_trace_max_size() && FeatureFlag.featureEnabled(FeatureFlag.DefaultInteractions)) {
            jsonArray.add(jsonElementAsJson);
        } else {
            StatsEngine.get().sample(MetricNames.SUPPORTABILITY_TRACES_DROPPED, r2.length());
            jsonArray.add(new JsonArray());
        }
        jsonArray.add(this.agentHealth.asJson());
        if (this.analyticsEnabled) {
            JsonObject jsonObject = new JsonObject();
            for (AnalyticsAttribute analyticsAttribute : this.sessionAttributes) {
                int i = C37471.f4035x35709c72[analyticsAttribute.getAttributeDataType().ordinal()];
                if (i == 1) {
                    jsonObject.addProperty(analyticsAttribute.getName(), analyticsAttribute.getStringValue());
                } else if (i == 2) {
                    jsonObject.addProperty(analyticsAttribute.getName(), Double.valueOf(analyticsAttribute.getDoubleValue()));
                } else if (i == 3) {
                    jsonObject.addProperty(analyticsAttribute.getName(), Boolean.valueOf(analyticsAttribute.getBooleanValue()));
                }
            }
            jsonArray.add(jsonObject);
            JsonArray jsonArray2 = new JsonArray();
            Iterator<AnalyticsEvent> it2 = this.analyticsEvents.iterator();
            while (it2.hasNext()) {
                jsonArray2.add(it2.next().asJsonObject());
            }
            jsonArray.add(jsonArray2);
        }
        return jsonArray;
    }

    /* JADX INFO: renamed from: com.newrelic.agent.android.harvest.HarvestData$1 */
    static /* synthetic */ class C37471 {

        /* JADX INFO: renamed from: $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType */
        static final /* synthetic */ int[] f4035x35709c72;

        static {
            int[] iArr = new int[AnalyticsAttribute.AttributeDataType.values().length];
            f4035x35709c72 = iArr;
            try {
                iArr[AnalyticsAttribute.AttributeDataType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4035x35709c72[AnalyticsAttribute.AttributeDataType.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4035x35709c72[AnalyticsAttribute.AttributeDataType.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public boolean isValid() {
        return this.dataToken.isValid();
    }

    public void reset() {
        this.httpTransactions.clear();
        this.activityTraces.clear();
        this.machineMeasurements.clear();
        this.agentHealth.clear();
        this.sessionAttributes.clear();
        this.analyticsEvents.clear();
    }

    public void setDataToken(DataToken dataToken) {
        if (dataToken != null) {
            this.dataToken = dataToken;
        }
    }

    public void setDeviceInformation(DeviceInformation deviceInformation) {
        this.deviceInformation = deviceInformation;
    }

    public void setHarvestTimeDelta(double d) {
        this.harvestTimeDelta = d;
    }

    public void setHttpTransactions(HttpTransactions httpTransactions) {
        this.httpTransactions = httpTransactions;
    }

    public void setMachineMeasurements(MachineMeasurements machineMeasurements) {
        this.machineMeasurements = machineMeasurements;
    }

    public void setActivityTraces(ActivityTraces activityTraces) {
        this.activityTraces = activityTraces;
    }

    public Set<AnalyticsAttribute> getSessionAttributes() {
        return this.sessionAttributes;
    }

    public void setSessionAttributes(Set<AnalyticsAttribute> set) {
        log.debug("HarvestData.setSessionAttributes invoked with attribute set " + String.valueOf(set));
        this.sessionAttributes = new HashSet(set);
    }

    public Collection<AnalyticsEvent> getAnalyticsEvents() {
        return this.analyticsEvents;
    }

    public void setAnalyticsEvents(Collection<AnalyticsEvent> collection) {
        this.analyticsEvents = new ArrayList(collection);
    }

    public DeviceInformation getDeviceInformation() {
        return this.deviceInformation;
    }

    public HttpTransactions getHttpTransactions() {
        return this.httpTransactions;
    }

    public MachineMeasurements getMetrics() {
        return getMachineMeasurements();
    }

    public MachineMeasurements getMachineMeasurements() {
        return this.machineMeasurements;
    }

    public ActivityTraces getActivityTraces() {
        return this.activityTraces;
    }

    public AgentHealth getAgentHealth() {
        return this.agentHealth;
    }

    public DataToken getDataToken() {
        return this.dataToken;
    }

    public boolean isAnalyticsEnabled() {
        return this.analyticsEnabled;
    }

    public void setAnalyticsEnabled(boolean z) {
        this.analyticsEnabled = z;
    }

    public String toString() {
        return "HarvestData{dataToken=" + String.valueOf(this.dataToken) + ", deviceInformation=" + String.valueOf(this.deviceInformation) + ", harvestTimeDelta=" + this.harvestTimeDelta + ", httpTransactions=" + String.valueOf(this.httpTransactions) + ", machineMeasurements=" + String.valueOf(this.machineMeasurements) + ", activityTraces=" + String.valueOf(this.activityTraces) + ", sessionAttributes=" + String.valueOf(this.sessionAttributes) + ", analyticsAttributes=" + String.valueOf(this.analyticsEvents) + "}";
    }

    @Override // com.newrelic.agent.android.harvest.HarvestConfigurable
    public void updateConfiguration(HarvestConfiguration harvestConfiguration) {
        setDataToken(harvestConfiguration.getDataToken());
    }
}
