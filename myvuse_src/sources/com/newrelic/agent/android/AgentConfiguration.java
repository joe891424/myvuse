package com.newrelic.agent.android;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.newrelic.agent.android.aei.AEITrace$$ExternalSyntheticBackport0;
import com.newrelic.agent.android.aei.ApplicationExitConfiguration;
import com.newrelic.agent.android.analytics.AnalyticsAttributeStore;
import com.newrelic.agent.android.analytics.AnalyticsEventStore;
import com.newrelic.agent.android.crash.CrashStore;
import com.newrelic.agent.android.harvest.HarvestConfigurable;
import com.newrelic.agent.android.harvest.HarvestConfiguration;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.logging.LogLevel;
import com.newrelic.agent.android.logging.LogReportingConfiguration;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.payload.NullPayloadStore;
import com.newrelic.agent.android.payload.Payload;
import com.newrelic.agent.android.payload.PayloadStore;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.util.Constants;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class AgentConfiguration implements HarvestConfigurable {
    private static final String DEFAULT_COLLECTOR_HOST = "mobile-collector.newrelic.com";
    private static final String DEFAULT_CRASH_COLLECTOR_HOST = "mobile-crash.newrelic.com";
    static final String DEFAULT_DEVICE_UUID = "0";
    public static final String DEFAULT_FED_RAMP_COLLECTOR_HOST = "gov-mobile-collector.newrelic.com";
    private static final String DEFAULT_FED_RAMP_CRASH_COLLECTOR_HOST = "gov-mobile-crash.newrelic.com";
    public static final String DEFAULT_REGION_COLLECTOR_HOST = "mobile-collector.%s.nr-data.net";
    private static final String DEFAULT_REGION_CRASH_COLLECTOR_HOST = "mobile-crash.%s.nr-data.net";
    static final int DEVICE_UUID_MAX_LEN = 40;
    private static final String HEX_COLLECTOR_PATH = "/mobile/f";
    private static final int HEX_COLLECTOR_TIMEOUT = 5000;
    private static final int NUM_IO_THREADS = 3;
    private static final int PAYLOAD_TTL = 172800000;
    private AnalyticsAttributeStore analyticsAttributeStore;
    private String applicationToken;
    private CrashStore crashStore;
    private String deviceID;
    private String entityGuid;
    private AnalyticsEventStore eventStore;
    private static final AgentLog log = AgentLogManager.getAgentLog();
    protected static AtomicReference<AgentConfiguration> instance = new AtomicReference<>(new AgentConfiguration());
    private String collectorHost = DEFAULT_COLLECTOR_HOST;
    private String crashCollectorHost = DEFAULT_CRASH_COLLECTOR_HOST;
    private boolean useSsl = true;
    private boolean reportCrashes = false;
    private boolean reportHandledExceptions = true;
    private boolean enableAnalyticsEvents = true;
    private String sessionID = provideSessionId();
    private String customApplicationVersion = null;
    private String customBuildId = null;
    private String region = null;
    private String launchActivityClassName = null;
    private PayloadStore<Payload> payloadStore = new NullPayloadStore();
    private ApplicationFramework applicationFramework = ApplicationFramework.Native;
    private String applicationFrameworkVersion = Agent.getVersion();
    private LogReportingConfiguration logReportingConfiguration = new LogReportingConfiguration(false, LogLevel.INFO);
    private ApplicationExitConfiguration applicationExitConfiguration = new ApplicationExitConfiguration(true);

    public int getHexCollectorTimeout() {
        return 5000;
    }

    public int getIOThreadSize() {
        return 3;
    }

    public int getPayloadTTL() {
        return PAYLOAD_TTL;
    }

    public String getApplicationToken() {
        return this.applicationToken;
    }

    public void setApplicationToken(String str) {
        this.applicationToken = str;
        this.region = parseRegionFromApplicationToken(str);
        if (FeatureFlag.featureEnabled(FeatureFlag.FedRampEnabled)) {
            this.collectorHost = DEFAULT_FED_RAMP_COLLECTOR_HOST;
            this.crashCollectorHost = DEFAULT_FED_RAMP_CRASH_COLLECTOR_HOST;
            return;
        }
        String str2 = this.region;
        if (str2 != null) {
            this.collectorHost = String.format(DEFAULT_REGION_COLLECTOR_HOST, str2);
            this.crashCollectorHost = String.format(DEFAULT_REGION_CRASH_COLLECTOR_HOST, this.region);
        } else {
            this.collectorHost = DEFAULT_COLLECTOR_HOST;
            this.crashCollectorHost = DEFAULT_CRASH_COLLECTOR_HOST;
        }
    }

    public String getCollectorHost() {
        return this.collectorHost;
    }

    public void setCollectorHost(String str) {
        this.collectorHost = str;
    }

    public String getCrashCollectorHost() {
        return this.crashCollectorHost;
    }

    public void setCrashCollectorHost(String str) {
        this.crashCollectorHost = str;
    }

    public boolean useSsl() {
        return this.useSsl;
    }

    public void setUseSsl(boolean z) {
        if (!z) {
            log.error("Unencrypted http requests are no longer supported");
        }
        this.useSsl = true;
    }

    public boolean getReportCrashes() {
        return this.reportCrashes;
    }

    public void setReportCrashes(boolean z) {
        this.reportCrashes = z;
    }

    public CrashStore getCrashStore() {
        return this.crashStore;
    }

    public void setCrashStore(CrashStore crashStore) {
        this.crashStore = crashStore;
    }

    public AnalyticsEventStore getEventStore() {
        return this.eventStore;
    }

    public void setEventStore(AnalyticsEventStore analyticsEventStore) {
        this.eventStore = analyticsEventStore;
    }

    public boolean getReportHandledExceptions() {
        return this.reportHandledExceptions;
    }

    public void setReportHandledExceptions(boolean z) {
        this.reportHandledExceptions = z;
    }

    public AnalyticsAttributeStore getAnalyticsAttributeStore() {
        return this.analyticsAttributeStore;
    }

    public void setAnalyticsAttributeStore(AnalyticsAttributeStore analyticsAttributeStore) {
        this.analyticsAttributeStore = analyticsAttributeStore;
    }

    public boolean getEnableAnalyticsEvents() {
        return this.enableAnalyticsEvents;
    }

    public void setEnableAnalyticsEvents(boolean z) {
        this.enableAnalyticsEvents = z;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public String getCustomApplicationVersion() {
        return this.customApplicationVersion;
    }

    public void setCustomApplicationVersion(String str) {
        this.customApplicationVersion = str;
    }

    public String getCustomBuildIdentifier() {
        return this.customBuildId;
    }

    public void setCustomBuildIdentifier(String str) {
        this.customBuildId = str;
    }

    public ApplicationFramework getApplicationFramework() {
        return this.applicationFramework;
    }

    public void setApplicationFramework(ApplicationFramework applicationFramework) {
        this.applicationFramework = applicationFramework;
    }

    public String getApplicationFrameworkVersion() {
        return this.applicationFrameworkVersion;
    }

    public void setApplicationFrameworkVersion(String str) {
        this.applicationFrameworkVersion = str;
    }

    public String provideSessionId() {
        String string = UUID.randomUUID().toString();
        this.sessionID = string;
        return string;
    }

    public String getHexCollectorPath() {
        return HEX_COLLECTOR_PATH;
    }

    public String getHexCollectorHost() {
        return getCollectorHost();
    }

    public String getAppTokenHeader() {
        return Constants.Network.APPLICATION_LICENSE_HEADER;
    }

    public String getAppVersionHeader() {
        return Constants.Network.APP_VERSION_HEADER;
    }

    public String getDeviceOsNameHeader() {
        return Constants.Network.DEVICE_OS_NAME_HEADER;
    }

    public PayloadStore<Payload> getPayloadStore() {
        return this.payloadStore;
    }

    public void setPayloadStore(PayloadStore<Payload> payloadStore) {
        this.payloadStore = payloadStore;
    }

    String getDefaultCollectorHost() {
        return DEFAULT_COLLECTOR_HOST;
    }

    String getDefaultCrashCollectorHost() {
        return DEFAULT_CRASH_COLLECTOR_HOST;
    }

    String getRegionalCollectorFromLicenseKey(String str) {
        String regionFromApplicationToken = parseRegionFromApplicationToken(str);
        if (regionFromApplicationToken != null && !"".equals(str)) {
            return String.format(DEFAULT_REGION_COLLECTOR_HOST, regionFromApplicationToken);
        }
        return DEFAULT_COLLECTOR_HOST;
    }

    String getFedRampCollectorHost() {
        return DEFAULT_FED_RAMP_COLLECTOR_HOST;
    }

    String getFedRampCrashCollectorHost() {
        return DEFAULT_FED_RAMP_CRASH_COLLECTOR_HOST;
    }

    String parseRegionFromApplicationToken(String str) {
        if (str != null && !"".equals(str)) {
            Matcher matcher = Pattern.compile("^(.+?)x{1,2}.*").matcher(str);
            if (matcher.matches()) {
                try {
                    String strGroup = matcher.group(1);
                    if (strGroup != null && !"".equals(strGroup)) {
                        return strGroup;
                    }
                    log.warn("Region prefix empty");
                } catch (Exception e) {
                    log.error("getRegionalCollectorFromLicenseKey: " + String.valueOf(e));
                }
            }
        }
        return null;
    }

    public void setDeviceID(String str) {
        if (str == null) {
            this.deviceID = DEFAULT_DEVICE_UUID;
            return;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            this.deviceID = DEFAULT_DEVICE_UUID;
            return;
        }
        if (strTrim.length() > 40) {
            StatsEngine.get().inc(MetricNames.METRIC_UUID_TRUNCATED);
        }
        this.deviceID = strTrim.substring(0, Math.min(40, strTrim.length()));
    }

    public String getDeviceID() {
        return this.deviceID;
    }

    public String getEntityGuid() {
        return this.entityGuid;
    }

    public void setEntityGuid(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.entityGuid = AEITrace$$ExternalSyntheticBackport0.m2717m(str.trim());
    }

    public String getLaunchActivityClassName() {
        return this.launchActivityClassName;
    }

    public void setLaunchActivityClassName(String str) {
        this.launchActivityClassName = str;
    }

    public LogReportingConfiguration getLogReportingConfiguration() {
        return this.logReportingConfiguration;
    }

    public ApplicationExitConfiguration getApplicationExitConfiguration() {
        return this.applicationExitConfiguration;
    }

    @Override // com.newrelic.agent.android.harvest.HarvestConfigurable
    public void updateConfiguration(HarvestConfiguration harvestConfiguration) {
        AgentConfiguration agentConfiguration;
        this.applicationExitConfiguration.setConfiguration(harvestConfiguration.getRemote_configuration().applicationExitConfiguration);
        this.logReportingConfiguration.setConfiguration(harvestConfiguration.getRemote_configuration().logReportingConfiguration);
        this.entityGuid = harvestConfiguration.getEntity_guid();
        if (instance.get() == null || (agentConfiguration = instance.get()) == null || agentConfiguration == this) {
            return;
        }
        agentConfiguration.updateConfiguration(harvestConfiguration);
    }

    public static AgentConfiguration getInstance() {
        PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m1161m(instance, null, new AgentConfiguration());
        return instance.get();
    }
}
