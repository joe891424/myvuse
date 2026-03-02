package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.activity.config.ActivityTraceConfiguration;
import com.newrelic.agent.android.activity.config.ActivityTraceConfigurationDeserializer;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.harvest.HarvestResponse;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.com.google.gson.GsonBuilder;
import com.newrelic.com.google.gson.JsonSyntaxException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class Harvester implements HarvestConfigurable {
    private AgentConfiguration agentConfiguration;
    private HarvestConnection harvestConnection;
    private HarvestData harvestData;
    protected boolean stateChanged;
    private final AgentLog log = AgentLogManager.getAgentLog();
    private State state = State.UNINITIALIZED;
    private HarvestConfiguration harvestConfiguration = HarvestConfiguration.getDefaultHarvestConfiguration();
    private final Collection<HarvestLifecycleAware> harvestListeners = new ArrayList<HarvestLifecycleAware>() { // from class: com.newrelic.agent.android.harvest.Harvester.1
        {
            add(new HarvestLifecycleAware() { // from class: com.newrelic.agent.android.harvest.Harvester.1.1
                @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
                public void onHarvestConfigurationChanged() {
                    StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_CONFIGURATION_CHANGED);
                    AnalyticsControllerImpl.getInstance().recordBreadcrumb("Remote configuration changed", new HashMap());
                }
            });
        }
    };

    protected enum State {
        UNINITIALIZED,
        DISCONNECTED,
        CONNECTED,
        DISABLED
    }

    public void expireAnalyticsEvents() {
    }

    public void start() {
        fireOnHarvestStart();
    }

    public void stop() {
        fireOnHarvestStop();
    }

    protected void uninitialized() {
        if (this.agentConfiguration == null) {
            this.log.error("Agent configuration unavailable.");
            return;
        }
        if (Agent.getImpl().updateSavedConnectInformation()) {
            configureHarvester(HarvestConfiguration.getDefaultHarvestConfiguration());
            this.harvestData.getDataToken().clear();
        }
        Harvest.setHarvestConnectInformation(new ConnectInformation(Agent.getApplicationInformation(), Agent.getDeviceInformation()));
        this.harvestConnection.updateConfiguration(this.agentConfiguration);
        this.harvestConnection.updateConfiguration(this.harvestConfiguration);
        transition(State.DISCONNECTED);
        execute();
    }

    protected void disconnected() {
        if (this.harvestConfiguration == null) {
            configureHarvester(HarvestConfiguration.getDefaultHarvestConfiguration());
        }
        if (this.harvestData.isValid()) {
            this.log.verbose("Skipping connect call, saved state is available: " + String.valueOf(this.harvestData.getDataToken()));
            StatsEngine.get().sample(MetricNames.SESSION_START, 1.0f);
            fireOnHarvestConnected();
            transition(State.CONNECTED);
            execute();
            return;
        }
        this.log.info("Connecting, saved state is not available: " + String.valueOf(this.harvestData.getDataToken()));
        HarvestResponse harvestResponseSendConnect = this.harvestConnection.sendConnect();
        if (harvestResponseSendConnect == null) {
            this.log.error("Unable to connect to the Collector.");
            return;
        }
        if (harvestResponseSendConnect.isOK()) {
            HarvestConfiguration harvesterConfiguration = parseHarvesterConfiguration(harvestResponseSendConnect);
            if (harvesterConfiguration == null) {
                this.log.error("Unable to configure Harvester using Collector configuration.");
                return;
            }
            boolean zEquals = this.harvestConfiguration.equals(harvesterConfiguration);
            configureHarvester(harvesterConfiguration);
            StatsEngine.get().sampleTimeMs("Supportability/AgentHealth/Collector/Harvest", harvestResponseSendConnect.getResponseTime());
            fireOnHarvestConnected();
            transition(State.CONNECTED);
            execute();
            if (zEquals) {
                return;
            }
            fireOnHarvestConfigurationChanged();
            return;
        }
        this.log.debug("Harvest connect response: " + String.valueOf(harvestResponseSendConnect.getResponseCode()));
        StatsEngine.get().inc("Supportability/AgentHealth/Collector/Harvest/Connect/Error/" + String.valueOf(harvestResponseSendConnect.getResponseCode()));
        switch (C37502.f4038xa09b1364[harvestResponseSendConnect.getResponseCode().ordinal()]) {
            case 1:
            case 2:
                this.harvestData.getDataToken().clear();
                fireOnHarvestDisconnected();
                return;
            case 3:
                if (harvestResponseSendConnect.isDisableCommand()) {
                    this.log.error("Collector has commanded Agent to disable.");
                    fireOnHarvestDisabled();
                    transition(State.DISABLED);
                    return;
                }
                this.log.error("Unexpected Collector response: FORBIDDEN");
                break;
                break;
            case 4:
            case 5:
                this.log.error("Invalid ConnectionInformation was sent to the Collector.");
                break;
            case 6:
                this.log.warn("Harvest request has timed-out, and will retry during next harvest cycle.");
                break;
            case 7:
                this.log.warn("Harvest request has been throttled, and will retry during next harvest cycle.");
                break;
            default:
                this.log.error("An unknown error occurred when connecting to the Collector.");
                break;
        }
        fireOnHarvestError();
    }

    protected void connected() {
        if (!this.harvestData.isValid()) {
            this.log.error("Harvester: invalid data token! Agent must reconnect prior to upload.");
            StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_INVALID_DATA_TOKEN);
            this.harvestData.getDataToken().clear();
            fireOnHarvestSendFailed();
            transition(State.DISCONNECTED);
            return;
        }
        this.log.info("Harvester: connected");
        this.log.info("Harvester: Sending [" + this.harvestData.getHttpTransactions().count() + "] HTTP transactions.");
        this.log.info("Harvester: Sending [" + this.harvestData.getActivityTraces().count() + "] activity traces.");
        this.log.info("Harvester: Sending [" + this.harvestData.getSessionAttributes().size() + "] session attributes.");
        this.log.info("Harvester: Sending [" + this.harvestData.getAnalyticsEvents().size() + "] analytics events.");
        HarvestResponse harvestResponseSendData = this.harvestConnection.sendData(this.harvestData);
        if (harvestResponseSendData == null || harvestResponseSendData.isUnknown()) {
            this.log.debug("Harvest data response: " + String.valueOf(harvestResponseSendData.getResponseCode()));
            checkOfflineAndPersist();
            fireOnHarvestSendFailed();
            return;
        }
        if (FeatureFlag.featureEnabled(FeatureFlag.BackgroundReporting) && ApplicationStateMonitor.isAppInBackground()) {
            StatsEngine.get().sampleTimeMs("Supportability/AgentHealth/Collector/Harvest/Background/", harvestResponseSendData.getResponseTime());
        } else {
            StatsEngine.get().sampleTimeMs("Supportability/AgentHealth/Collector/Harvest/", harvestResponseSendData.getResponseTime());
        }
        this.log.debug("Harvest data response: " + String.valueOf(harvestResponseSendData.getResponseCode()));
        this.log.debug("Harvest data response status code: " + harvestResponseSendData.getStatusCode());
        this.log.audit("Harvest data response BODY: " + harvestResponseSendData.getResponseBody());
        if (harvestResponseSendData.isError()) {
            fireOnHarvestError();
            if (FeatureFlag.featureEnabled(FeatureFlag.BackgroundReporting) && ApplicationStateMonitor.isAppInBackground()) {
                StatsEngine.notice().inc("Supportability/AgentHealth/Collector/Harvest/Error/Background/" + String.valueOf(harvestResponseSendData.getResponseCode()));
            } else {
                StatsEngine.notice().inc("Supportability/AgentHealth/Collector/Harvest/Error/" + String.valueOf(harvestResponseSendData.getResponseCode()));
            }
            switch (C37502.f4038xa09b1364[harvestResponseSendData.getResponseCode().ordinal()]) {
                case 1:
                case 2:
                    this.harvestData.reset();
                    this.harvestData.getDataToken().clear();
                    transition(State.DISCONNECTED);
                    break;
                case 3:
                    this.harvestData.reset();
                    if (harvestResponseSendData.isDisableCommand()) {
                        this.log.error("Collector has commanded Agent to disable.");
                        transition(State.DISABLED);
                    } else {
                        this.log.error("Unexpected Collector response: FORBIDDEN");
                        transition(State.DISCONNECTED);
                    }
                    break;
                case 4:
                case 5:
                    this.harvestData.reset();
                    this.log.error("An invalid harvest payload was sent to the Collector.");
                    break;
                case 6:
                    this.log.warn("Harvest request has timed-out, and will retry during next harvest cycle.");
                    break;
                case 7:
                    this.log.warn("Harvest request has been throttled, and will retry during next harvest cycle.");
                    break;
                case 8:
                    this.log.info("Harvest configuration has changed, and will be updated during next harvest cycle.");
                    this.harvestData.getDataToken().clear();
                    transition(State.DISCONNECTED);
                    break;
                default:
                    this.log.error("An unknown error occurred when connecting to the Collector.");
                    break;
            }
            if (harvestResponseSendData.isNetworkError()) {
                checkOfflineAndPersist();
                return;
            }
            return;
        }
        try {
            if (FeatureFlag.featureEnabled(FeatureFlag.OfflineStorage)) {
                for (Map.Entry<String, String> entry : Agent.getAllOfflineData().entrySet()) {
                    HarvestResponse harvestResponseSendData2 = this.harvestConnection.sendData(entry.getValue());
                    if (harvestResponseSendData2.isOK()) {
                        new File(entry.getKey()).delete();
                    }
                    StatsEngine.get().inc("Supportability/AgentHealth/Collector/Harvest/OfflineStorage" + String.valueOf(harvestResponseSendData2.getResponseCode()));
                }
            }
        } catch (Exception e) {
            this.log.error("OfflineStorage: " + String.valueOf(e));
        }
        fireOnHarvestComplete();
        this.harvestData.reset();
    }

    protected void disabled() {
        Harvest.stop();
        fireOnHarvestDisabled();
    }

    protected void execute() {
        this.log.debug("Harvester state: " + String.valueOf(this.state));
        this.stateChanged = false;
        try {
            expireHarvestData();
            int i = C37502.$SwitchMap$com$newrelic$agent$android$harvest$Harvester$State[this.state.ordinal()];
            if (i == 1) {
                uninitialized();
                return;
            }
            if (i == 2) {
                fireOnHarvestBefore();
                disconnected();
            } else {
                if (i != 3) {
                    if (i == 4) {
                        disabled();
                        return;
                    }
                    throw new IllegalStateException();
                }
                TaskQueue.synchronousDequeue();
                fireOnHarvestBefore();
                fireOnHarvest();
                fireOnHarvestFinalize();
                connected();
            }
        } catch (Exception e) {
            this.log.error("Exception encountered while attempting to harvest", e);
            AgentHealth.noticeException(e);
        }
    }

    /* JADX INFO: renamed from: com.newrelic.agent.android.harvest.Harvester$2 */
    static /* synthetic */ class C37502 {

        /* JADX INFO: renamed from: $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code */
        static final /* synthetic */ int[] f4038xa09b1364;
        static final /* synthetic */ int[] $SwitchMap$com$newrelic$agent$android$harvest$Harvester$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$com$newrelic$agent$android$harvest$Harvester$State = iArr;
            try {
                iArr[State.UNINITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$newrelic$agent$android$harvest$Harvester$State[State.DISCONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$newrelic$agent$android$harvest$Harvester$State[State.CONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$newrelic$agent$android$harvest$Harvester$State[State.DISABLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[HarvestResponse.Code.values().length];
            f4038xa09b1364 = iArr2;
            try {
                iArr2[HarvestResponse.Code.UNAUTHORIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4038xa09b1364[HarvestResponse.Code.INVALID_AGENT_ID.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4038xa09b1364[HarvestResponse.Code.FORBIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4038xa09b1364[HarvestResponse.Code.UNSUPPORTED_MEDIA_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4038xa09b1364[HarvestResponse.Code.ENTITY_TOO_LARGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4038xa09b1364[HarvestResponse.Code.REQUEST_TIMEOUT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4038xa09b1364[HarvestResponse.Code.TOO_MANY_REQUESTS.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f4038xa09b1364[HarvestResponse.Code.CONFIGURATION_UPDATE.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    protected void transition(State state) {
        if (this.stateChanged) {
            this.log.debug("Ignoring multiple transition: " + String.valueOf(state));
            return;
        }
        if (this.state == state) {
            return;
        }
        int i = C37502.$SwitchMap$com$newrelic$agent$android$harvest$Harvester$State[this.state.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException();
                }
                if (!stateIn(state, State.DISCONNECTED, State.DISABLED)) {
                    throw new IllegalStateException();
                }
            } else if (!stateIn(state, State.UNINITIALIZED, State.CONNECTED, State.DISABLED)) {
                throw new IllegalStateException();
            }
        } else if (!stateIn(state, State.DISCONNECTED, state, State.CONNECTED, State.DISABLED)) {
            throw new IllegalStateException();
        }
        changeState(state);
    }

    HarvestConfiguration parseHarvesterConfiguration(HarvestResponse harvestResponse) {
        try {
            return (HarvestConfiguration) new GsonBuilder().registerTypeAdapter(ActivityTraceConfiguration.class, new ActivityTraceConfigurationDeserializer()).create().fromJson(harvestResponse.getResponseBody(), HarvestConfiguration.class);
        } catch (JsonSyntaxException e) {
            this.log.error("Unable to parse collector configuration: " + e.getMessage());
            AgentHealth.noticeException(e);
            return null;
        }
    }

    private void configureHarvester(HarvestConfiguration harvestConfiguration) {
        this.harvestConfiguration.updateConfiguration(harvestConfiguration);
        this.agentConfiguration.updateConfiguration(harvestConfiguration);
        this.harvestData.updateConfiguration(harvestConfiguration);
        Harvest.setHarvestConfiguration(harvestConfiguration);
    }

    private void changeState(State state) {
        this.log.debug("Harvester changing state: " + String.valueOf(this.state) + " -> " + String.valueOf(state));
        if (this.state == State.CONNECTED) {
            if (state == State.DISCONNECTED) {
                fireOnHarvestDisconnected();
            } else if (state == State.DISABLED) {
                fireOnHarvestDisabled();
            }
        }
        this.state = state;
        this.stateChanged = true;
    }

    private boolean stateIn(State state, State... stateArr) {
        for (State state2 : stateArr) {
            if (state == state2) {
                return true;
            }
        }
        return false;
    }

    public State getCurrentState() {
        return this.state;
    }

    public boolean isDisabled() {
        return State.DISABLED == this.state;
    }

    public void addHarvestListener(HarvestLifecycleAware harvestLifecycleAware) {
        if (harvestLifecycleAware == null) {
            this.log.error("Can't add null harvest listener");
            new Exception().printStackTrace();
            return;
        }
        synchronized (this.harvestListeners) {
            if (this.harvestListeners.contains(harvestLifecycleAware)) {
                return;
            }
            this.harvestListeners.add(harvestLifecycleAware);
        }
    }

    public void removeHarvestListener(HarvestLifecycleAware harvestLifecycleAware) {
        synchronized (this.harvestListeners) {
            if (this.harvestListeners.contains(harvestLifecycleAware)) {
                this.harvestListeners.remove(harvestLifecycleAware);
            }
        }
    }

    public void expireHarvestData() {
        if (this.harvestData != null) {
            expireHttpTransactions();
            expireActivityTraces();
            expireAnalyticsEvents();
        }
    }

    public void expireHttpTransactions() {
        HttpTransactions httpTransactions = this.harvestData.getHttpTransactions();
        synchronized (httpTransactions) {
            ArrayList arrayList = new ArrayList();
            long jCurrentTimeMillis = System.currentTimeMillis();
            long reportMaxTransactionAgeMilliseconds = this.harvestConfiguration.getReportMaxTransactionAgeMilliseconds();
            for (HttpTransaction httpTransaction : httpTransactions.getHttpTransactions()) {
                if (httpTransaction.getTimestamp().longValue() < jCurrentTimeMillis - reportMaxTransactionAgeMilliseconds) {
                    this.log.audit("HttpTransaction too old, purging: " + String.valueOf(httpTransaction));
                    arrayList.add(httpTransaction);
                }
            }
            if (!arrayList.isEmpty()) {
                this.log.debug("Purging [" + arrayList.size() + "] expired HttpTransactions from HarvestData");
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    httpTransactions.remove((HttpTransaction) it2.next());
                }
            }
        }
    }

    public void expireActivityTraces() {
        ActivityTraces activityTraces = this.harvestData.getActivityTraces();
        synchronized (activityTraces) {
            ArrayList arrayList = new ArrayList();
            long activity_trace_max_report_attempts = this.harvestConfiguration.getActivity_trace_max_report_attempts();
            for (ActivityTrace activityTrace : activityTraces.getActivityTraces()) {
                if (activityTrace.getReportAttemptCount() >= activity_trace_max_report_attempts) {
                    this.log.audit("ActivityTrace has had " + activityTrace.getReportAttemptCount() + " report attempts, purging: " + String.valueOf(activityTrace));
                    arrayList.add(activityTrace);
                }
            }
            if (!arrayList.isEmpty()) {
                this.log.debug("Purging [" + arrayList.size() + "] expired ActivityTraces from HarvestData");
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    activityTraces.remove((ActivityTrace) it2.next());
                }
            }
        }
    }

    public void setAgentConfiguration(AgentConfiguration agentConfiguration) {
        this.agentConfiguration = agentConfiguration;
    }

    AgentConfiguration getAgentConfiguration() {
        return this.agentConfiguration;
    }

    public void setHarvestConnection(HarvestConnection harvestConnection) {
        this.harvestConnection = harvestConnection;
    }

    public HarvestConnection getHarvestConnection() {
        return this.harvestConnection;
    }

    public void setHarvestData(HarvestData harvestData) {
        this.harvestData = harvestData;
    }

    public HarvestData getHarvestData() {
        return this.harvestData;
    }

    private void fireOnHarvestBefore() {
        try {
            Iterator<HarvestLifecycleAware> it2 = getHarvestListeners().iterator();
            while (it2.hasNext()) {
                it2.next().onHarvestBefore();
            }
        } catch (Exception e) {
            this.log.error("Error in fireOnHarvestBefore", e);
            AgentHealth.noticeException(e);
        }
    }

    private void fireOnHarvestStart() {
        try {
            Iterator<HarvestLifecycleAware> it2 = getHarvestListeners().iterator();
            while (it2.hasNext()) {
                it2.next().onHarvestStart();
            }
        } catch (Exception e) {
            this.log.error("Error in fireOnHarvestStart", e);
            AgentHealth.noticeException(e);
        }
    }

    private void fireOnHarvestStop() {
        try {
            Iterator<HarvestLifecycleAware> it2 = getHarvestListeners().iterator();
            while (it2.hasNext()) {
                it2.next().onHarvestStop();
            }
        } catch (Exception e) {
            this.log.error("Error in fireOnHarvestStop", e);
            AgentHealth.noticeException(e);
        }
    }

    private void fireOnHarvest() {
        try {
            Iterator<HarvestLifecycleAware> it2 = getHarvestListeners().iterator();
            while (it2.hasNext()) {
                it2.next().onHarvest();
            }
        } catch (Exception e) {
            this.log.error("Error in fireOnHarvest", e);
            AgentHealth.noticeException(e);
        }
    }

    private void fireOnHarvestFinalize() {
        try {
            Iterator<HarvestLifecycleAware> it2 = getHarvestListeners().iterator();
            while (it2.hasNext()) {
                it2.next().onHarvestFinalize();
            }
        } catch (Exception e) {
            this.log.error("Error in fireOnHarvestFinalize", e);
            AgentHealth.noticeException(e);
        }
    }

    private void fireOnHarvestDisabled() {
        try {
            Iterator<HarvestLifecycleAware> it2 = getHarvestListeners().iterator();
            while (it2.hasNext()) {
                it2.next().onHarvestDisabled();
            }
        } catch (Exception e) {
            this.log.error("Error in fireOnHarvestDisabled", e);
            AgentHealth.noticeException(e);
        }
    }

    private void fireOnHarvestDisconnected() {
        try {
            Iterator<HarvestLifecycleAware> it2 = getHarvestListeners().iterator();
            while (it2.hasNext()) {
                it2.next().onHarvestDisconnected();
            }
        } catch (Exception e) {
            this.log.error("Error in fireOnHarvestDisconnected", e);
            AgentHealth.noticeException(e);
        }
    }

    private void fireOnHarvestError() {
        try {
            Iterator<HarvestLifecycleAware> it2 = getHarvestListeners().iterator();
            while (it2.hasNext()) {
                it2.next().onHarvestError();
            }
        } catch (Exception e) {
            this.log.error("Error in fireOnHarvestError", e);
            AgentHealth.noticeException(e);
        }
    }

    private void fireOnHarvestSendFailed() {
        try {
            Iterator<HarvestLifecycleAware> it2 = getHarvestListeners().iterator();
            while (it2.hasNext()) {
                it2.next().onHarvestSendFailed();
            }
        } catch (Exception e) {
            this.log.error("Error in fireOnHarvestSendFailed", e);
            AgentHealth.noticeException(e);
        }
    }

    private void fireOnHarvestComplete() {
        try {
            Iterator<HarvestLifecycleAware> it2 = getHarvestListeners().iterator();
            while (it2.hasNext()) {
                it2.next().onHarvestComplete();
            }
        } catch (Exception e) {
            this.log.error("Error in fireOnHarvestComplete", e);
            AgentHealth.noticeException(e);
        }
    }

    private void fireOnHarvestConnected() {
        try {
            Iterator<HarvestLifecycleAware> it2 = getHarvestListeners().iterator();
            while (it2.hasNext()) {
                it2.next().onHarvestConnected();
            }
        } catch (Exception e) {
            this.log.error("Error in fireOnHarvestConnected", e);
            AgentHealth.noticeException(e);
        }
    }

    private void fireOnHarvestConfigurationChanged() {
        try {
            Iterator<HarvestLifecycleAware> it2 = getHarvestListeners().iterator();
            while (it2.hasNext()) {
                it2.next().onHarvestConfigurationChanged();
            }
        } catch (Exception e) {
            this.log.error("Error in fireOnHarvestConfigurationChanged", e);
            AgentHealth.noticeException(e);
        }
    }

    public void checkOfflineAndPersist() {
        try {
            if (FeatureFlag.featureEnabled(FeatureFlag.OfflineStorage)) {
                HarvestData harvestData = this.harvestData;
                if (harvestData != null && harvestData.toString().length() > 0) {
                    Agent.persistHarvestDataToDisk(this.harvestData.toJsonString());
                    this.harvestData.reset();
                    this.log.info("Harvest data was stored to disk due to network errors, will resubmit in next cycle when network is available.");
                } else {
                    this.log.info("No harvest data was stored during this cycle");
                }
            }
        } catch (Exception e) {
            this.log.error("Error in persisting data: ", e);
        }
    }

    @Override // com.newrelic.agent.android.harvest.HarvestConfigurable
    public void setConfiguration(HarvestConfiguration harvestConfiguration) {
        this.harvestConfiguration = harvestConfiguration;
    }

    @Override // com.newrelic.agent.android.harvest.HarvestConfigurable
    public void updateConfiguration(HarvestConfiguration harvestConfiguration) {
        setHarvestConfiguration(harvestConfiguration);
    }

    public void setHarvestConfiguration(HarvestConfiguration harvestConfiguration) {
        this.harvestConfiguration = harvestConfiguration;
    }

    HarvestConfiguration getHarvestConfiguration() {
        return this.harvestConfiguration;
    }

    Collection<HarvestLifecycleAware> getHarvestListeners() {
        return new ArrayList(this.harvestListeners);
    }
}
