package com.newrelic.agent.android;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.newrelic.agent.android.aei.ApplicationExitMonitor;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.analytics.AnalyticsEvent;
import com.newrelic.agent.android.analytics.EventManager;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.api.p043v1.ConnectionEvent;
import com.newrelic.agent.android.api.p043v1.ConnectionListener;
import com.newrelic.agent.android.api.p043v1.DeviceForm;
import com.newrelic.agent.android.api.p044v2.TraceMachineInterface;
import com.newrelic.agent.android.background.ApplicationStateEvent;
import com.newrelic.agent.android.background.ApplicationStateListener;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.distributedtracing.UserActionFacade;
import com.newrelic.agent.android.distributedtracing.UserActionType;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.harvest.ApplicationInformation;
import com.newrelic.agent.android.harvest.ConnectInformation;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.harvest.EnvironmentInformation;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestData;
import com.newrelic.agent.android.harvest.HarvestLifecycleAware;
import com.newrelic.agent.android.harvest.MachineMeasurements;
import com.newrelic.agent.android.instrumentation.MetricCategory;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.logging.AndroidAgentLog;
import com.newrelic.agent.android.logging.ForwardingAgentLog;
import com.newrelic.agent.android.logging.LogLevel;
import com.newrelic.agent.android.logging.LogReporting;
import com.newrelic.agent.android.logging.LogReportingConfiguration;
import com.newrelic.agent.android.measurement.MeasurementEngine;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.metric.MetricUnit;
import com.newrelic.agent.android.ndk.NativeReporting;
import com.newrelic.agent.android.payload.PayloadController;
import com.newrelic.agent.android.sample.MachineMeasurementConsumer;
import com.newrelic.agent.android.sample.Sampler;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.stores.SharedPrefsAnalyticsAttributeStore;
import com.newrelic.agent.android.stores.SharedPrefsCrashStore;
import com.newrelic.agent.android.stores.SharedPrefsEventStore;
import com.newrelic.agent.android.stores.SharedPrefsPayloadStore;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.util.ActivityLifecycleBackgroundListener;
import com.newrelic.agent.android.util.AndroidEncoder;
import com.newrelic.agent.android.util.ComposeChecker;
import com.newrelic.agent.android.util.Connectivity;
import com.newrelic.agent.android.util.Encoder;
import com.newrelic.agent.android.util.OfflineStorage;
import com.newrelic.agent.android.util.PersistentUUID;
import com.newrelic.agent.android.util.Reachability;
import com.newrelic.agent.android.util.UiBackgroundListener;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes6.dex */
public class AndroidAgentImpl implements AgentImpl, ConnectionListener, ApplicationStateListener, TraceMachineInterface, HarvestLifecycleAware {
    private final AgentConfiguration agentConfiguration;
    private ApplicationInformation applicationInformation;
    private final Context context;
    DeviceInformation deviceInformation;
    private MachineMeasurementConsumer machineMeasurementConsumer;
    private OfflineStorage offlineStorageInstance;
    private SavedState savedState;
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private static final Comparator<TransactionData> cmp = new Comparator<TransactionData>() { // from class: com.newrelic.agent.android.AndroidAgentImpl.1
        @Override // java.util.Comparator
        public int compare(TransactionData transactionData, TransactionData transactionData2) {
            if (transactionData.getTimestamp() > transactionData2.getTimestamp()) {
                return -1;
            }
            return transactionData.getTimestamp() < transactionData2.getTimestamp() ? 1 : 0;
        }
    };
    private final Lock lock = new ReentrantLock();
    private final Encoder encoder = new AndroidEncoder();

    @Override // com.newrelic.agent.android.AgentImpl
    @Deprecated
    public void addTransactionData(TransactionData transactionData) {
    }

    protected void finalizeSession() {
    }

    @Override // com.newrelic.agent.android.AgentImpl
    @Deprecated
    public List<TransactionData> getAndClearTransactionData() {
        return null;
    }

    @Override // com.newrelic.agent.android.AgentImpl
    @Deprecated
    public void mergeTransactionData(List<TransactionData> list) {
    }

    public AndroidAgentImpl(Context context, AgentConfiguration agentConfiguration) throws AgentInitializationException {
        ComponentCallbacks uiBackgroundListener;
        Context contextAppContext = appContext(context);
        this.context = contextAppContext;
        this.agentConfiguration = agentConfiguration;
        this.savedState = new SavedState(contextAppContext);
        this.offlineStorageInstance = new OfflineStorage(context);
        if (isDisabled()) {
            throw new AgentInitializationException("This version of the agent has been disabled");
        }
        agentConfiguration.updateConfiguration(this.savedState.getHarvestConfiguration());
        initApplicationInformation();
        TraceMachine.setTraceMachineInterface(this);
        agentConfiguration.setCrashStore(new SharedPrefsCrashStore(context));
        agentConfiguration.setPayloadStore(new SharedPrefsPayloadStore(context));
        agentConfiguration.setAnalyticsAttributeStore(new SharedPrefsAnalyticsAttributeStore(context));
        agentConfiguration.setEventStore(new SharedPrefsEventStore(context));
        ApplicationStateMonitor.getInstance().addApplicationStateListener(this);
        startLogReporter(context, agentConfiguration);
        if (Agent.getMonoInstrumentationFlag().equals("YES")) {
            uiBackgroundListener = new ActivityLifecycleBackgroundListener();
            if (uiBackgroundListener instanceof Application.ActivityLifecycleCallbacks) {
                try {
                    if (context.getApplicationContext() instanceof Application) {
                        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks) uiBackgroundListener);
                        if (agentConfiguration.getApplicationFramework() == ApplicationFramework.Xamarin || agentConfiguration.getApplicationFramework() == ApplicationFramework.MAUI) {
                            ApplicationStateMonitor.getInstance().activityStarted();
                        }
                    }
                } catch (Exception unused) {
                }
            }
        } else {
            uiBackgroundListener = new UiBackgroundListener();
        }
        context.registerComponentCallbacks(uiBackgroundListener);
        setupSession();
    }

    private static void startLogReporter(Context context, AgentConfiguration agentConfiguration) {
        if (FeatureFlag.featureEnabled(FeatureFlag.LogReporting)) {
            LogReportingConfiguration.reseed();
            LogReportingConfiguration logReportingConfiguration = agentConfiguration.getLogReportingConfiguration();
            if (logReportingConfiguration.getLoggingEnabled()) {
                try {
                    LogReporting.initialize(context.getCacheDir(), agentConfiguration);
                } catch (IOException e) {
                    AgentLogManager.getAgentLog().error("Log reporting failed to initialize: " + e);
                }
                if (logReportingConfiguration.getLogLevel().ordinal() >= LogLevel.DEBUG.ordinal()) {
                    AgentLogManager.setAgentLog(new ForwardingAgentLog(new AndroidAgentLog()));
                    log.warn("Agent log data will be forwarded with remote logs.");
                }
            }
        }
    }

    protected void initialize() {
        setupSession();
        AnalyticsControllerImpl.initialize(this.agentConfiguration, this);
        Harvest.addHarvestListener(this.savedState);
        Harvest.initialize(this.agentConfiguration);
        Harvest.setHarvestConfiguration(this.savedState.getHarvestConfiguration());
        Harvest.setHarvestConnectInformation(this.savedState.getConnectInformation());
        Harvest.addHarvestListener(this);
        startLogReporter(this.context, this.agentConfiguration);
        Measurements.initialize();
        AgentLog agentLog = log;
        agentLog.info(MessageFormat.format("New Relic Agent v{0}", Agent.getVersion()));
        agentLog.verbose(MessageFormat.format("Application token: {0}", this.agentConfiguration.getApplicationToken()));
        MachineMeasurementConsumer machineMeasurementConsumer = new MachineMeasurementConsumer();
        this.machineMeasurementConsumer = machineMeasurementConsumer;
        Measurements.addMeasurementConsumer(machineMeasurementConsumer);
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_CRASH_UNCAUGHT_HANDLER.replace(MetricNames.TAG_NAME, getUnhandledExceptionHandlerName()));
        PayloadController.initialize(this.agentConfiguration);
        Sampler.init(this.context);
        if (isInstantApp()) {
            agentLog.info("This appears to be an Instant App");
            AnalyticsControllerImpl.getInstance().addAttributeUnchecked(new AnalyticsAttribute(AnalyticsAttribute.INSTANT_APP_ATTRIBUTE, true), false);
        }
        if (FeatureFlag.featureEnabled(FeatureFlag.NativeReporting)) {
            try {
                NativeReporting.initialize(this.context, this.agentConfiguration);
            } catch (NoClassDefFoundError unused) {
                AgentLog agentLog2 = log;
                agentLog2.error("NativeReporting feature is enabled, but agent-ndk was not found (probably missing as a dependency).");
                agentLog2.error("Native reporting will not be enabled");
            }
        }
    }

    protected void setupSession() {
        TraceMachine.clearActivityHistory();
        this.agentConfiguration.provideSessionId();
    }

    @Override // com.newrelic.agent.android.AgentImpl
    public boolean updateSavedConnectInformation() {
        ConnectInformation connectInformation = this.savedState.getConnectInformation();
        ConnectInformation connectInformation2 = new ConnectInformation(getApplicationInformation(), getDeviceInformation());
        if (connectInformation2.equals(connectInformation) && this.savedState.hasConnectionToken(this.agentConfiguration.getApplicationToken())) {
            return false;
        }
        if (connectInformation2.getApplicationInformation().isAppUpgrade(connectInformation.getApplicationInformation())) {
            StatsEngine.get().inc(MetricNames.MOBILE_APP_UPGRADE);
            AnalyticsControllerImpl.getInstance().addAttributeUnchecked(new AnalyticsAttribute(AnalyticsAttribute.APP_UPGRADE_ATTRIBUTE, connectInformation.getApplicationInformation().getAppVersion()), false);
        }
        this.savedState.clear();
        this.savedState.saveConnectInformation(connectInformation2);
        this.savedState.saveConnectionToken(this.agentConfiguration.getApplicationToken());
        return true;
    }

    @Override // com.newrelic.agent.android.AgentImpl
    public DeviceInformation getDeviceInformation() {
        if (this.deviceInformation == null) {
            DeviceInformation deviceInformation = new DeviceInformation();
            deviceInformation.setOsName("Android");
            deviceInformation.setOsVersion(Build.VERSION.RELEASE);
            deviceInformation.setOsBuild(Build.VERSION.INCREMENTAL);
            deviceInformation.setModel(Build.MODEL);
            deviceInformation.setAgentName("AndroidAgent");
            deviceInformation.setAgentVersion(Agent.getVersion());
            deviceInformation.setManufacturer(Build.MANUFACTURER);
            deviceInformation.setDeviceId(getUUID());
            deviceInformation.setArchitecture(System.getProperty("os.arch"));
            deviceInformation.setRunTime(System.getProperty("java.vm.version"));
            deviceInformation.setSize(deviceForm(this.context).name().toLowerCase(Locale.getDefault()));
            deviceInformation.setApplicationFramework(this.agentConfiguration.getApplicationFramework());
            deviceInformation.setApplicationFrameworkVersion(this.agentConfiguration.getApplicationFrameworkVersion());
            this.deviceInformation = deviceInformation;
        }
        return this.deviceInformation;
    }

    @Override // com.newrelic.agent.android.AgentImpl
    public EnvironmentInformation getEnvironmentInformation() {
        EnvironmentInformation environmentInformation = new EnvironmentInformation();
        ActivityManager activityManager = (ActivityManager) this.context.getSystemService("activity");
        long[] jArr = new long[2];
        int i = 0;
        try {
            try {
                StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
                StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
                jArr[0] = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
                long availableBlocksLong = statFs2.getAvailableBlocksLong() * statFs.getBlockSizeLong();
                jArr[1] = availableBlocksLong;
                if (jArr[0] < 0) {
                    jArr[0] = 0;
                }
                i = (availableBlocksLong > 0L ? 1 : (availableBlocksLong == 0L ? 0 : -1));
                if (i < 0) {
                    jArr[1] = 0;
                }
            } catch (Exception e) {
                AgentHealth.noticeException(e);
                if (jArr[0] < 0) {
                    jArr[0] = 0;
                }
                i = (jArr[1] > 0L ? 1 : (jArr[1] == 0L ? 0 : -1));
                if (i < 0) {
                    jArr[1] = 0;
                }
            }
            environmentInformation.setDiskAvailable(jArr);
            environmentInformation.setMemoryUsage(Sampler.sampleMemory(activityManager).getSampleValue().asLong().longValue());
            environmentInformation.setOrientation(this.context.getResources().getConfiguration().orientation);
            environmentInformation.setNetworkStatus(getNetworkCarrier());
            environmentInformation.setNetworkWanType(getNetworkWanType());
            return environmentInformation;
        } catch (Throwable th) {
            if (jArr[i] < 0) {
                jArr[i] = 0;
            }
            if (jArr[1] < 0) {
                jArr[1] = 0;
            }
            environmentInformation.setDiskAvailable(jArr);
            throw th;
        }
    }

    public void initApplicationInformation() throws AgentInitializationException {
        ApplicationInfo applicationInfo;
        if (this.applicationInformation != null) {
            log.debug("attempted to reinitialize ApplicationInformation.");
            return;
        }
        String packageName = this.context.getPackageName();
        PackageManager packageManager = this.context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String customApplicationVersion = this.agentConfiguration.getCustomApplicationVersion();
            if (TextUtils.isEmpty(customApplicationVersion)) {
                if (packageInfo != null && packageInfo.versionName != null && packageInfo.versionName.length() > 0) {
                    customApplicationVersion = packageInfo.versionName;
                } else {
                    throw new AgentInitializationException("Your app doesn't appear to have a version defined. Ensure you have defined 'versionName' in your manifest.");
                }
            }
            log.debug("Using application version " + customApplicationVersion);
            try {
                applicationInfo = packageManager.getApplicationInfo(packageName, 0);
            } catch (PackageManager.NameNotFoundException e) {
                log.warn(e.toString());
            } catch (SecurityException e2) {
                log.warn(e2.toString());
            }
            String string = applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : packageName;
            AgentLog agentLog = log;
            agentLog.debug("Using application name " + string);
            String customBuildIdentifier = this.agentConfiguration.getCustomBuildIdentifier();
            if (TextUtils.isEmpty(customBuildIdentifier)) {
                if (packageInfo != null) {
                    customBuildIdentifier = String.valueOf(packageInfo.versionCode);
                } else {
                    agentLog.warn("Your app doesn't appear to have a version code defined. Ensure you have defined 'versionCode' in your manifest.");
                    customBuildIdentifier = "";
                }
            }
            agentLog.debug("Using build " + customBuildIdentifier);
            ApplicationInformation applicationInformation = new ApplicationInformation(string, customApplicationVersion, packageName, customBuildIdentifier);
            this.applicationInformation = applicationInformation;
            applicationInformation.setVersionCode(packageInfo.versionCode);
        } catch (PackageManager.NameNotFoundException e3) {
            throw new AgentInitializationException("Could not determine package version: " + e3.getMessage());
        }
    }

    @Override // com.newrelic.agent.android.AgentImpl
    public ApplicationInformation getApplicationInformation() {
        return this.applicationInformation;
    }

    @Override // com.newrelic.agent.android.AgentImpl
    public long getSessionDurationMillis() {
        return Harvest.getMillisSinceStart();
    }

    private static DeviceForm deviceForm(Context context) {
        int i = context.getResources().getConfiguration().screenLayout & 15;
        if (i == 1) {
            return DeviceForm.SMALL;
        }
        if (i == 2) {
            return DeviceForm.NORMAL;
        }
        if (i == 3) {
            return DeviceForm.LARGE;
        }
        if (i > 3) {
            return DeviceForm.XLARGE;
        }
        return DeviceForm.UNKNOWN;
    }

    private static Context appContext(Context context) {
        return !(context instanceof Application) ? context.getApplicationContext() : context;
    }

    @Override // com.newrelic.agent.android.AgentImpl
    public String getCrossProcessId() {
        this.lock.lock();
        try {
            return this.savedState.getCrossProcessId();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.newrelic.agent.android.AgentImpl
    public int getCurrentProcessId() {
        return Process.myPid();
    }

    @Override // com.newrelic.agent.android.AgentImpl
    public int getStackTraceLimit() {
        this.lock.lock();
        try {
            return this.savedState.getStackTraceLimit();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.newrelic.agent.android.AgentImpl
    public int getResponseBodyLimit() {
        this.lock.lock();
        try {
            return this.savedState.getHarvestConfiguration().getResponse_body_limit();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.newrelic.agent.android.AgentImpl
    public void start() {
        if (!isDisabled()) {
            initialize();
            Harvest.start();
            if (FeatureFlag.featureEnabled(FeatureFlag.NativeReporting)) {
                try {
                    if (NativeReporting.isInitialized()) {
                        NativeReporting.getInstance().start();
                    }
                } catch (NoClassDefFoundError unused) {
                    log.error("Native reporting is not enabled");
                }
            }
            if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
                UserActionFacade.getInstance().recordUserAction(UserActionType.AppLaunch);
            }
            if (ComposeChecker.isComposeUsed(this.context)) {
                StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_MOBILE_ANDROID_JETPACK_COMPOSE);
                return;
            }
            return;
        }
        stop(false);
    }

    @Override // com.newrelic.agent.android.AgentImpl
    public void stop() {
        stop(true);
    }

    void stop(boolean z) {
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            UserActionFacade.getInstance().recordUserAction(UserActionType.AppBackground);
        }
        finalizeSession();
        Sampler.shutdown();
        TraceMachine.haltTracing();
        EventManager eventManager = AnalyticsControllerImpl.getInstance().getEventManager();
        if (!NewRelic.isShutdown) {
            int eventsRecorded = eventManager.getEventsRecorded();
            double eventsEjected = eventManager.getEventsEjected();
            Measurements.addCustomMetric(MetricNames.SUPPORTABILITY_EVENT_RECORDED, MetricCategory.NONE.name(), eventsRecorded, eventsEjected, eventsEjected, MetricUnit.OPERATIONS, MetricUnit.OPERATIONS);
        }
        if (z) {
            if (isUIThread()) {
                StatsEngine.get().inc(MetricNames.SUPPORTABILITY_HARVEST_ON_MAIN_THREAD);
            }
            try {
                if (NewRelic.isStarted() && NewRelic.isShutdown) {
                    clearExistingData();
                    HarvestData harvestData = Harvest.getInstance().getHarvestData();
                    if (harvestData != null && harvestData.getMetrics() != null) {
                        MachineMeasurements metrics = Harvest.getInstance().getHarvestData().getMetrics();
                        Iterator<Map.Entry<String, Metric>> it2 = StatsEngine.notice().getStatsMap().entrySet().iterator();
                        while (it2.hasNext()) {
                            metrics.addMetric(it2.next().getValue());
                        }
                    }
                }
            } catch (Exception e) {
                log.error("There is an error during shutdown process: " + e.getLocalizedMessage());
            }
            Harvest.harvestNow(true, true);
            HarvestData harvestData2 = Harvest.getInstance().getHarvestData();
            AgentLog agentLog = log;
            agentLog.debug("EventManager: recorded[" + eventManager.getEventsRecorded() + "] ejected[" + eventManager.getEventsEjected() + "]");
            if (harvestData2 != null && harvestData2.isValid()) {
                Collection<AnalyticsEvent> analyticsEvents = harvestData2.getAnalyticsEvents();
                if (!analyticsEvents.isEmpty()) {
                    agentLog.warn("Agent stopped with " + analyticsEvents.size() + " events dropped from failed harvest.");
                }
                if (eventManager.size() > 0) {
                    agentLog.warn("Agent stopped with " + eventManager.size() + " events left in event pool.");
                }
            }
        }
        if (FeatureFlag.featureEnabled(FeatureFlag.NativeReporting)) {
            try {
                NativeReporting.shutdown();
            } catch (NoClassDefFoundError unused) {
            }
        }
        AnalyticsControllerImpl.shutdown();
        TraceMachine.clearActivityHistory();
        Harvest.shutdown();
        Measurements.shutdown();
        PayloadController.shutdown();
    }

    @Override // com.newrelic.agent.android.AgentImpl
    public void disable() {
        log.warn("PERMANENTLY DISABLING AGENT v" + Agent.getVersion());
        try {
            this.savedState.saveDisabledVersion(Agent.getVersion());
            try {
                stop(false);
            } finally {
            }
        } catch (Throwable th) {
            try {
                stop(false);
                throw th;
            } finally {
            }
        }
    }

    @Override // com.newrelic.agent.android.AgentImpl
    public boolean isDisabled() {
        return Agent.getVersion().equals(this.savedState.getDisabledVersion());
    }

    @Override // com.newrelic.agent.android.AgentImpl
    public String getNetworkCarrier() {
        return Connectivity.carrierNameFromContext(this.context);
    }

    @Override // com.newrelic.agent.android.AgentImpl
    public String getNetworkWanType() {
        return Connectivity.wanType(this.context);
    }

    public static void init(Context context, AgentConfiguration agentConfiguration) {
        try {
            Agent.setImpl(new AndroidAgentImpl(context, agentConfiguration));
            Agent.start();
            startLogReporter(context, agentConfiguration);
        } catch (AgentInitializationException e) {
            log.error("Failed to initialize the agent: " + e.toString());
        }
    }

    @Override // com.newrelic.agent.android.api.p043v1.ConnectionListener
    @Deprecated
    public void connected(ConnectionEvent connectionEvent) {
        log.error("AndroidAgentImpl: connected ");
    }

    @Override // com.newrelic.agent.android.api.p043v1.ConnectionListener
    @Deprecated
    public void disconnected(ConnectionEvent connectionEvent) {
        this.savedState.clear();
    }

    @Override // com.newrelic.agent.android.background.ApplicationStateListener
    public void applicationForegrounded(ApplicationStateEvent applicationStateEvent) {
        log.info("AndroidAgentImpl: application foregrounded");
        if (FeatureFlag.featureEnabled(FeatureFlag.BackgroundReporting) && NewRelic.isStarted()) {
            stop();
        }
        if (NewRelic.isShutdown) {
            return;
        }
        start();
        startLogReporter(this.context, this.agentConfiguration);
        AnalyticsControllerImpl.getInstance().removeAttribute("background");
    }

    @Override // com.newrelic.agent.android.background.ApplicationStateListener
    public void applicationBackgrounded(ApplicationStateEvent applicationStateEvent) {
        log.info("AndroidAgentImpl: application backgrounded");
        stop();
        if (FeatureFlag.featureEnabled(FeatureFlag.BackgroundReporting)) {
            start();
            startLogReporter(this.context, this.agentConfiguration);
            AnalyticsControllerImpl.getInstance().addAttributeUnchecked(new AnalyticsAttribute("background", true), false);
        }
    }

    @Override // com.newrelic.agent.android.AgentImpl
    public void setLocation(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("Country code and administrative region are required.");
        }
    }

    public void setLocation(Location location) {
        List<Address> fromLocation;
        Address address;
        if (location == null) {
            throw new IllegalArgumentException("Location must not be null.");
        }
        try {
            fromLocation = new Geocoder(this.context).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
        } catch (IOException e) {
            log.error("Unable to geocode location: " + e.toString());
            fromLocation = null;
        }
        if (fromLocation == null || fromLocation.size() == 0 || (address = fromLocation.get(0)) == null) {
            return;
        }
        String countryCode = address.getCountryCode();
        String adminArea = address.getAdminArea();
        if (countryCode == null || adminArea == null) {
            return;
        }
        setLocation(countryCode, adminArea);
    }

    String getUUID() {
        String deviceId = this.savedState.getConnectInformation().getDeviceInformation().getDeviceId();
        if (TextUtils.isEmpty(deviceId)) {
            deviceId = new PersistentUUID(this.context).getPersistentUUID();
            this.savedState.saveDeviceId(deviceId);
            StatsEngine.get().inc(MetricNames.METRIC_UUID_CREATED);
        }
        String deviceID = this.agentConfiguration.getDeviceID();
        if (deviceID == null) {
            return deviceId;
        }
        StatsEngine.get().inc(MetricNames.METRIC_UUID_OVERRIDDEN);
        return deviceID;
    }

    private String getUnhandledExceptionHandlerName() {
        try {
            return Thread.getDefaultUncaughtExceptionHandler().getClass().getName();
        } catch (Exception unused) {
            return "unknown";
        }
    }

    private void clearExistingData() {
        try {
            if (Harvest.getInstance() != null && Harvest.getInstance().getHarvestData() != null) {
                Harvest.getInstance().getHarvestData().reset();
            }
            TraceMachine.clearActivityHistory();
            AnalyticsControllerImpl analyticsControllerImpl = AnalyticsControllerImpl.getInstance();
            if (analyticsControllerImpl != null) {
                analyticsControllerImpl.clear();
            }
            new MeasurementEngine().clear();
        } catch (Exception e) {
            log.error("There is an error while clean data during shutdown process: " + e.getLocalizedMessage());
        }
    }

    @Override // com.newrelic.agent.android.AgentImpl
    public Encoder getEncoder() {
        return this.encoder;
    }

    @Override // com.newrelic.agent.android.api.p044v2.TraceMachineInterface
    public long getCurrentThreadId() {
        return Thread.currentThread().getId();
    }

    @Override // com.newrelic.agent.android.api.p044v2.TraceMachineInterface
    public boolean isUIThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    @Override // com.newrelic.agent.android.api.p044v2.TraceMachineInterface
    public String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }

    protected SavedState getSavedState() {
        return this.savedState;
    }

    protected void setSavedState(SavedState savedState) {
        this.savedState = savedState;
    }

    @Override // com.newrelic.agent.android.AgentImpl
    public boolean hasReachableNetworkConnection(String str) {
        return Reachability.hasReachableNetworkConnection(this.context, str);
    }

    @Override // com.newrelic.agent.android.AgentImpl
    public boolean isInstantApp() {
        return InstantApps.isInstantApp(this.context);
    }

    @Override // com.newrelic.agent.android.AgentImpl
    public void persistHarvestDataToDisk(String str) {
        this.offlineStorageInstance.persistHarvestDataToDisk(str);
    }

    @Override // com.newrelic.agent.android.AgentImpl
    public Map<String, String> getAllOfflineData() {
        return this.offlineStorageInstance.getAllOfflineData();
    }

    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvestConnected() {
        if (FeatureFlag.featureEnabled(FeatureFlag.ApplicationExitReporting)) {
            if (this.agentConfiguration.getApplicationExitConfiguration().isEnabled()) {
                new ApplicationExitMonitor(this.context).harvestApplicationExitInfo();
            } else {
                new ApplicationExitMonitor(this.context).resetSessionMap();
                log.debug("ApplicationExitReporting feature is enabled locally, but disabled in remote configuration.");
            }
        }
        if (FeatureFlag.featureEnabled(FeatureFlag.LogReporting) && LogReporting.isRemoteLoggingEnabled()) {
            startLogReporter(this.context, this.agentConfiguration);
            StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_LOG_SAMPLED + this.agentConfiguration.getLogReportingConfiguration().isSampled());
        }
        this.agentConfiguration.updateConfiguration(this.savedState.getHarvestConfiguration());
    }

    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvestConfigurationChanged() {
        this.agentConfiguration.updateConfiguration(this.savedState.getHarvestConfiguration());
    }
}
