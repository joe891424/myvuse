package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.activity.config.ActivityTraceConfiguration;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.analytics.SessionEvent;
import com.newrelic.agent.android.harvest.type.Harvestable;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.tracing.ActivityTrace;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class Harvest implements HarvestConfigurable {
    private static final boolean DISABLE_ACTIVITY_TRACE_LIMITS_FOR_DEBUGGING = false;
    public static final long INVALID_SESSION_DURATION = 0;
    private HarvestConfiguration harvestConfiguration = HarvestConfiguration.getDefaultHarvestConfiguration();
    private HarvestConnection harvestConnection;
    protected HarvestData harvestData;
    private HarvestDataValidator harvestDataValidator;
    private HarvestTimer harvestTimer;
    private Harvester harvester;
    private static final AgentLog log = AgentLogManager.getAgentLog();
    protected static Harvest instance = new Harvest();
    private static final Collection<HarvestLifecycleAware> unregisteredLifecycleListeners = new ArrayList();
    private static final HarvestableCache activityTraceCache = new HarvestableCache();

    public static void initialize(AgentConfiguration agentConfiguration) {
        instance.initializeHarvester(agentConfiguration);
        registerUnregisteredListeners();
        addHarvestListener(StatsEngine.get());
    }

    public void initializeHarvester(AgentConfiguration agentConfiguration) {
        createHarvester();
        this.harvester.setAgentConfiguration(agentConfiguration);
        this.harvester.setHarvestConfiguration(instance.getConfiguration());
        flushHarvestableCaches();
    }

    public static void start() {
        if (instance.getHarvestTimer() != null) {
            instance.getHarvestTimer().start();
        } else {
            log.error("Harvest timer is null");
        }
    }

    public static void stop() {
        if (instance.getHarvestTimer() != null) {
            instance.getHarvestTimer().stop();
        } else {
            log.error("Harvest timer is null");
        }
    }

    public static void harvestNow(boolean z, boolean z2) {
        if (isInitialized()) {
            if (z) {
                instance.finalizeSession();
                AnalyticsControllerImpl.getInstance().getEventManager().setTransmitRequired();
            }
            HarvestTimer harvestTimer = instance.getHarvestTimer();
            if (harvestTimer != null) {
                harvestTimer.tickNow(z2);
            }
        }
    }

    public static void setInstance(Harvest harvest) {
        if (harvest == null) {
            log.error("Attempt to set Harvest instance to null value!");
        } else {
            instance = harvest;
        }
    }

    public void createHarvester() {
        this.harvestConnection = new HarvestConnection();
        this.harvestData = new HarvestData();
        Harvester harvester = new Harvester();
        this.harvester = harvester;
        harvester.setHarvestConnection(this.harvestConnection);
        this.harvester.setHarvestData(this.harvestData);
        this.harvestTimer = new HarvestTimer(this.harvester);
        HarvestDataValidator harvestDataValidator = new HarvestDataValidator();
        this.harvestDataValidator = harvestDataValidator;
        addHarvestListener(harvestDataValidator);
    }

    public void shutdownHarvester() {
        HarvestTimer harvestTimer = this.harvestTimer;
        if (harvestTimer != null) {
            harvestTimer.shutdown();
        }
        this.harvestTimer = null;
        this.harvester = null;
        this.harvestConnection = null;
        this.harvestData = null;
    }

    public static void shutdown() {
        if (isInitialized()) {
            stop();
            instance.shutdownHarvester();
        }
    }

    public static void addHttpTransaction(HttpTransaction httpTransaction) {
        if (isDisabled()) {
            return;
        }
        HttpTransactions httpTransactions = instance.getHarvestData().getHttpTransactions();
        instance.getHarvester().expireHttpTransactions();
        int report_max_transaction_count = instance.getConfiguration().getReport_max_transaction_count();
        if (httpTransactions.count() >= report_max_transaction_count) {
            StatsEngine.get().inc(MetricNames.SUPPORTABILITY_TRANS_DROPPED);
            log.debug("Maximum number of transactions (" + report_max_transaction_count + ") reached. HTTP Transaction dropped.");
        } else {
            httpTransactions.add(httpTransaction);
            AnalyticsControllerImpl.getInstance().createNetworkRequestEvents(httpTransaction);
        }
    }

    public static void addActivityTrace(ActivityTrace activityTrace) {
        if (isDisabled()) {
            return;
        }
        if (!isInitialized()) {
            activityTraceCache.add(activityTrace);
            return;
        }
        if (activityTrace.rootTrace == null) {
            log.error("Activity trace is lacking a root trace!");
            return;
        }
        if (activityTrace.rootTrace.childExclusiveTime == 0) {
            log.error("Total trace exclusive time is zero. Ignoring trace " + activityTrace.rootTrace.displayName);
            return;
        }
        if (activityTrace.rootTrace.childExclusiveTime / activityTrace.rootTrace.getDurationAsMilliseconds() < instance.getConfiguration().getActivity_trace_min_utilization()) {
            StatsEngine.get().inc(MetricNames.SUPPORTABILITY_TRACES_IGNORED);
            log.debug("Exclusive trace time is too low (" + activityTrace.rootTrace.childExclusiveTime + "/" + activityTrace.rootTrace.getDurationAsMilliseconds() + "). Ignoring trace " + activityTrace.rootTrace.displayName);
            return;
        }
        ActivityTraces activityTraces = instance.getHarvestData().getActivityTraces();
        ActivityTraceConfiguration activityTraceConfiguration = instance.getActivityTraceConfiguration();
        instance.getHarvester().expireActivityTraces();
        if (activityTraces.count() >= activityTraceConfiguration.getMaxTotalTraceCount()) {
            log.debug("Activity trace limit of " + activityTraceConfiguration.getMaxTotalTraceCount() + " exceeded. Ignoring trace: " + activityTrace.toJsonString());
            return;
        }
        log.debug("Adding activity trace: " + activityTrace.toJsonString());
        activityTraces.add(activityTrace);
    }

    public static void addMetric(Metric metric) {
        if (isDisabled() || !isInitialized()) {
            return;
        }
        instance.getHarvestData().getMetrics().addMetric(metric);
    }

    public static void addAgentHealthException(AgentHealthException agentHealthException) {
        if (isDisabled() || !isInitialized()) {
            return;
        }
        instance.getHarvestData().getAgentHealth().addException(agentHealthException);
    }

    public static void addHarvestListener(HarvestLifecycleAware harvestLifecycleAware) {
        if (harvestLifecycleAware == null) {
            log.error("Harvest: Argument to addHarvestListener cannot be null.");
        } else {
            if (!isInitialized()) {
                if (isUnregisteredListener(harvestLifecycleAware)) {
                    return;
                }
                addUnregisteredListener(harvestLifecycleAware);
                return;
            }
            instance.getHarvester().addHarvestListener(harvestLifecycleAware);
        }
    }

    public static void removeHarvestListener(HarvestLifecycleAware harvestLifecycleAware) {
        if (harvestLifecycleAware == null) {
            log.error("Harvest: Argument to removeHarvestListener cannot be null.");
        } else {
            if (!isInitialized()) {
                if (isUnregisteredListener(harvestLifecycleAware)) {
                    removeUnregisteredListener(harvestLifecycleAware);
                    return;
                }
                return;
            }
            instance.getHarvester().removeHarvestListener(harvestLifecycleAware);
        }
    }

    public static boolean isInitialized() {
        Harvest harvest = instance;
        return (harvest == null || harvest.getHarvester() == null) ? false : true;
    }

    public static int getActivityTraceCacheSize() {
        return activityTraceCache.getSize();
    }

    public static long getMillisSinceStart() {
        Harvest harvest = getInstance();
        if (harvest == null || harvest.getHarvestTimer() == null) {
            return 0L;
        }
        long jTimeSinceStart = harvest.getHarvestTimer().timeSinceStart();
        if (jTimeSinceStart < 0) {
            return 0L;
        }
        return jTimeSinceStart;
    }

    public static boolean shouldCollectActivityTraces() {
        ActivityTraceConfiguration activityTraceConfiguration;
        if (isDisabled()) {
            return false;
        }
        return !isInitialized() || (activityTraceConfiguration = instance.getActivityTraceConfiguration()) == null || activityTraceConfiguration.getMaxTotalTraceCount() > 0;
    }

    private void flushHarvestableCaches() {
        try {
            flushActivityTraceCache();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void flushActivityTraceCache() {
        Iterator<Harvestable> it2 = activityTraceCache.flush().iterator();
        while (it2.hasNext()) {
            addActivityTrace((ActivityTrace) it2.next());
        }
    }

    private static void addUnregisteredListener(HarvestLifecycleAware harvestLifecycleAware) {
        if (harvestLifecycleAware == null) {
            return;
        }
        Collection<HarvestLifecycleAware> collection = unregisteredLifecycleListeners;
        synchronized (collection) {
            collection.add(harvestLifecycleAware);
        }
    }

    private static void removeUnregisteredListener(HarvestLifecycleAware harvestLifecycleAware) {
        if (harvestLifecycleAware == null) {
            return;
        }
        Collection<HarvestLifecycleAware> collection = unregisteredLifecycleListeners;
        synchronized (collection) {
            collection.remove(harvestLifecycleAware);
        }
    }

    private static void registerUnregisteredListeners() {
        Iterator<HarvestLifecycleAware> it2 = unregisteredLifecycleListeners.iterator();
        while (it2.hasNext()) {
            addHarvestListener(it2.next());
        }
        unregisteredLifecycleListeners.clear();
    }

    private static boolean isUnregisteredListener(HarvestLifecycleAware harvestLifecycleAware) {
        if (harvestLifecycleAware == null) {
            return false;
        }
        return unregisteredLifecycleListeners.contains(harvestLifecycleAware);
    }

    protected HarvestTimer getHarvestTimer() {
        return this.harvestTimer;
    }

    public static Harvest getInstance() {
        return instance;
    }

    protected Harvester getHarvester() {
        return this.harvester;
    }

    public HarvestData getHarvestData() {
        return this.harvestData;
    }

    @Override // com.newrelic.agent.android.harvest.HarvestConfigurable
    public HarvestConfiguration getConfiguration() {
        return this.harvestConfiguration;
    }

    public HarvestConnection getHarvestConnection() {
        return this.harvestConnection;
    }

    public void setHarvestConnection(HarvestConnection harvestConnection) {
        this.harvestConnection = harvestConnection;
    }

    @Override // com.newrelic.agent.android.harvest.HarvestConfigurable
    public void setConfiguration(HarvestConfiguration harvestConfiguration) {
        updateConfiguration(harvestConfiguration);
    }

    @Override // com.newrelic.agent.android.harvest.HarvestConfigurable
    public void updateConfiguration(HarvestConfiguration harvestConfiguration) {
        this.harvestConfiguration.updateConfiguration(harvestConfiguration);
        this.harvestTimer.updateConfiguration(harvestConfiguration);
        this.harvestConnection.updateConfiguration(harvestConfiguration);
        this.harvestData.updateConfiguration(harvestConfiguration);
        this.harvester.updateConfiguration(harvestConfiguration);
    }

    public void setConnectInformation(ConnectInformation connectInformation) {
        this.harvestConnection.setConnectInformation(connectInformation);
        this.harvestData.setDeviceInformation(connectInformation.getDeviceInformation());
    }

    public static void setHarvestConfiguration(HarvestConfiguration harvestConfiguration) {
        if (!isInitialized()) {
            log.error("Cannot configure Harvester before initialization.");
            return;
        }
        log.debug("Harvest Configuration: " + String.valueOf(harvestConfiguration));
        instance.setConfiguration(harvestConfiguration);
    }

    public static HarvestConfiguration getHarvestConfiguration() {
        if (!isInitialized()) {
            return HarvestConfiguration.getDefaultHarvestConfiguration();
        }
        return instance.getConfiguration();
    }

    public static void setHarvestConnectInformation(ConnectInformation connectInformation) {
        if (!isInitialized()) {
            log.error("Cannot configure Harvester before initialization.");
            return;
        }
        log.debug("Setting Harvest connect information: " + String.valueOf(connectInformation));
        instance.setConnectInformation(connectInformation);
    }

    public static boolean isDisabled() {
        if (isInitialized()) {
            return instance.getHarvester().isDisabled();
        }
        return false;
    }

    protected ActivityTraceConfiguration getActivityTraceConfiguration() {
        return this.harvestConfiguration.getAt_capture();
    }

    void finalizeSession() {
        long millisSinceStart = getMillisSinceStart();
        if (millisSinceStart == 0) {
            log.error("Session duration is invalid!");
            StatsEngine.get().inc(MetricNames.SUPPORTABILITY_SESSION_INVALID_DURATION);
        }
        float f = millisSinceStart / 1000.0f;
        StatsEngine.get().sample(MetricNames.SESSION_DURATION, f);
        AgentLog agentLog = log;
        agentLog.debug("Harvest: Generating sessionDuration attribute with value " + f);
        AnalyticsControllerImpl analyticsControllerImpl = AnalyticsControllerImpl.getInstance();
        analyticsControllerImpl.setAttribute(AnalyticsAttribute.SESSION_DURATION_ATTRIBUTE, f, false);
        agentLog.debug("Harvest: Generating session event.");
        analyticsControllerImpl.addEvent(new SessionEvent());
    }
}
