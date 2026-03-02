package com.newrelic.agent.android;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.newrelic.agent.android.agentdata.AgentDataController;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.analytics.EventListener;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.distributedtracing.DistributedTracing;
import com.newrelic.agent.android.distributedtracing.TraceContext;
import com.newrelic.agent.android.distributedtracing.TraceListener;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.hybrid.StackTrace;
import com.newrelic.agent.android.hybrid.data.DataController;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.logging.AndroidAgentLog;
import com.newrelic.agent.android.logging.LogLevel;
import com.newrelic.agent.android.logging.LogReporting;
import com.newrelic.agent.android.logging.NullAgentLog;
import com.newrelic.agent.android.measurement.HttpTransactionMeasurement;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.metric.MetricUnit;
import com.newrelic.agent.android.rum.AppApplicationLifeCycle;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.tracing.TracingInactiveException;
import com.newrelic.agent.android.util.Constants;
import com.newrelic.agent.android.util.NetworkFailure;
import com.newrelic.agent.android.util.OfflineStorage;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class NewRelic {
    private static final String UNKNOWN_HTTP_REQUEST_TYPE = "unknown";
    private static final AgentLog log = AgentLogManager.getAgentLog();
    protected static final AgentConfiguration agentConfiguration = AgentConfiguration.getInstance();
    protected static boolean started = false;
    protected static boolean isShutdown = false;
    boolean loggingEnabled = true;
    int logLevel = 3;

    private boolean isInstrumented() {
        return true;
    }

    private NewRelic(String str) {
        agentConfiguration.setApplicationToken(str);
    }

    public static NewRelic withApplicationToken(String str) {
        return new NewRelic(str);
    }

    public NewRelic usingCollectorAddress(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "usingCollectorAddress"));
        agentConfiguration.setCollectorHost(str);
        return this;
    }

    public NewRelic usingCrashCollectorAddress(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "usingCrashCollectorAddress"));
        agentConfiguration.setCrashCollectorHost(str);
        return this;
    }

    public NewRelic withLoggingEnabled(boolean z) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "withLoggingEnabled/<state>").replace(MetricNames.TAG_STATE, Boolean.toString(z)));
        this.loggingEnabled = z;
        return this;
    }

    public NewRelic withLogLevel(int i) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "withLogLevel/<state>").replace(MetricNames.TAG_STATE, Integer.toString(i)));
        this.logLevel = i;
        return this;
    }

    public NewRelic withApplicationVersion(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "withApplicationVersion/<state>").replace(MetricNames.TAG_STATE, str));
        if (str != null) {
            agentConfiguration.setCustomApplicationVersion(str);
        }
        return this;
    }

    public NewRelic withApplicationFramework(ApplicationFramework applicationFramework, String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "withApplicationFramework").replace(MetricNames.TAG_FRAMEWORK, applicationFramework != null ? applicationFramework.name() : "<missing>").replace(MetricNames.TAG_FRAMEWORK_VERSION, str != null ? str : ""));
        if (applicationFramework != null) {
            agentConfiguration.setApplicationFramework(applicationFramework);
        }
        agentConfiguration.setApplicationFrameworkVersion(str);
        return this;
    }

    public NewRelic withCrashReportingEnabled(boolean z) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "withCrashReportingEnabled/<state>").replace(MetricNames.TAG_STATE, Boolean.toString(z)));
        agentConfiguration.setReportCrashes(z);
        return this;
    }

    public NewRelic withLaunchActivityName(String str) {
        agentConfiguration.setLaunchActivityClassName(str);
        AppApplicationLifeCycle.getAgentConfiguration().setLaunchActivityClassName(str);
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "AppLaunch/<state>").replace(MetricNames.TAG_STATE, str));
        return this;
    }

    public static void enableFeature(FeatureFlag featureFlag) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "enableFeature/<state>").replace(MetricNames.TAG_STATE, featureFlag.name()));
        log.debug("Enable feature: " + featureFlag.name());
        FeatureFlag.enableFeature(featureFlag);
    }

    public static void disableFeature(FeatureFlag featureFlag) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "disableFeature/<state>").replace(MetricNames.TAG_STATE, featureFlag.name()));
        log.debug("Disable feature: " + featureFlag.name());
        FeatureFlag.disableFeature(featureFlag);
    }

    public NewRelic withApplicationBuild(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "withApplicationBuild"));
        if (!TextUtils.isEmpty(str)) {
            agentConfiguration.setCustomBuildIdentifier(str);
        }
        return this;
    }

    public NewRelic withDistributedTraceListener(TraceListener traceListener) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "withDistributedTraceListener"));
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            DistributedTracing.setDistributedTraceListener(traceListener);
        }
        return this;
    }

    public NewRelic withDeviceID(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "withDeviceID"));
        agentConfiguration.setDeviceID(str);
        return this;
    }

    public void start(Context context) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "start"));
        if (isShutdown) {
            log.error("NewRelic agent has shut down, relaunch your application to restart the agent.");
            return;
        }
        if (started) {
            log.debug("NewRelic is already running.");
            return;
        }
        try {
            AgentLogManager.setAgentLog(this.loggingEnabled ? new AndroidAgentLog() : new NullAgentLog());
            AgentLog agentLog = log;
            agentLog.setLevel(this.logLevel);
            if (!InstantApps.isInstantApp(context) && !isInstrumented()) {
                logRecourse();
                return;
            }
            AndroidAgentImpl.init(context, agentConfiguration);
            started = true;
            if (agentLog.getLevel() >= 5) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                if (stackTrace.length > 3) {
                    StackTraceElement stackTraceElement = stackTrace[3];
                    agentLog.debug("Agent started from " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber());
                }
            }
        } catch (Throwable th) {
            log.error("Error occurred while starting the New Relic agent!", th);
            logRecourse();
        }
    }

    private void logRecourse() {
        log.error("Failed to detect New Relic instrumentation. The current runtime variant may be excluded from instrumentation, or instrumentation failed during your build process. Please visit http://support.newrelic.com.");
    }

    public static boolean isStarted() {
        return started;
    }

    public static void shutdown() {
        StatsEngine.reset();
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "shutdown"));
        if (started) {
            try {
                isShutdown = true;
                Agent.getImpl().stop();
            } finally {
                Agent.setImpl(NullAgentImpl.instance);
                started = false;
                log.warn("Agent is shut down.");
            }
        }
    }

    public static String startInteraction(String str) {
        checkNull(str, "startInteraction: actionName must be an action/method name.");
        log.debug("NewRelic.startInteraction invoked with actionName: " + str);
        TraceMachine.startTracing(str.replace("/", "."), true, FeatureFlag.featureEnabled(FeatureFlag.InteractionTracing));
        try {
            return TraceMachine.getActivityTrace().getId();
        } catch (TracingInactiveException unused) {
            return null;
        }
    }

    public static String startInteraction(Context context, String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_DEPRECATED.replace(MetricNames.TAG_NAME, "startInteraction"));
        checkNull(context, "startInteraction: context must be an Activity instance.");
        checkNull(str, "startInteraction: actionName must be an action/method name.");
        log.debug("NewRelic.startInteraction invoked with actionName: " + str);
        TraceMachine.startTracing(context.getClass().getSimpleName() + "#" + str.replace("/", "."), false, FeatureFlag.featureEnabled(FeatureFlag.InteractionTracing));
        try {
            return TraceMachine.getActivityTrace().getId();
        } catch (TracingInactiveException unused) {
            return null;
        }
    }

    public static void endInteraction(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "endInteraction"));
        log.debug("NewRelic.endInteraction invoked. id: " + str);
        TraceMachine.endTrace(str);
    }

    public static void setInteractionName(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "setInteractionName"));
        TraceMachine.setRootDisplayName(str);
    }

    public static void startMethodTrace(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "startMethodTrace"));
        checkNull(str, "startMethodTrace: actionName must be an action/method name.");
        TraceMachine.enterMethod(str);
    }

    public static void endMethodTrace() {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "endMethodTrace"));
        log.debug("NewRelic.endMethodTrace invoked.");
        TraceMachine.exitMethod();
    }

    public static void recordMetric(String str, String str2, int i, double d, double d2, MetricUnit metricUnit, MetricUnit metricUnit2) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "recordMetric"));
        AgentLog agentLog = log;
        if (agentLog.getLevel() == 6) {
            agentLog.audit("NewRelic.recordMetric invoked for name " + str + ", category: " + str2 + ", count: " + i + ", totalValue " + d + ", exclusiveValue: " + d2 + ", countUnit: " + metricUnit + ", valueUnit: " + metricUnit2);
        }
        checkNull(str2, "recordMetric: category must not be null. If no MetricCategory is applicable, use MetricCategory.NONE.");
        checkEmpty(str, "recordMetric: name must not be empty.");
        if (checkNegative(i, "recordMetric: count must not be negative.")) {
            return;
        }
        Measurements.addCustomMetric(str, str2, i, d, d2, metricUnit, metricUnit2);
    }

    public static void recordMetric(String str, String str2, double d) {
        recordMetric(str, str2, 1, d, d, null, null);
    }

    public static void recordMetric(String str, String str2) {
        recordMetric(str, str2, 1.0d);
    }

    public static void noticeHttpTransaction(Map<String, Object> map) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "noticeHttpTransaction(Map Attribute)"));
        try {
            noticeHttpTransaction((String) map.get("url"), (String) map.get("httpMethod"), Integer.parseInt((String) map.get(AnalyticsAttribute.STATUS_CODE_ATTRIBUTE)), Long.parseLong((String) map.get("startTimeMs")), Long.parseLong((String) map.get("endTimeMs")), Long.parseLong((String) map.get(AnalyticsAttribute.BYTES_SENT_ATTRIBUTE)), Long.parseLong((String) map.get(AnalyticsAttribute.BYTES_RECEIVED_ATTRIBUTE)), (String) map.get("responseBody"), null, (String) map.get("appData"), (Map) map.get("traceAttributes"));
        } catch (NumberFormatException e) {
            log.error(e.getMessage());
            recordHandledException((Exception) e);
        }
    }

    public static void noticeHttpTransaction(String str, String str2, int i, long j, long j2, long j3, long j4) {
        _noticeHttpTransaction(str, str2, i, j, j2, j3, j4, null, null, null);
    }

    public static void noticeHttpTransaction(String str, String str2, int i, long j, long j2, long j3, long j4, String str3) {
        _noticeHttpTransaction(str, str2, i, j, j2, j3, j4, str3, null, null);
    }

    public static void noticeHttpTransaction(String str, String str2, int i, long j, long j2, long j3, long j4, String str3, Map<String, String> map) {
        _noticeHttpTransaction(str, str2, i, j, j2, j3, j4, str3, map, null);
    }

    public static void noticeHttpTransaction(String str, String str2, int i, long j, long j2, long j3, long j4, String str3, Map<String, String> map, String str4) {
        _noticeHttpTransaction(str, str2, i, j, j2, j3, j4, str3, map, str4);
    }

    public static void noticeHttpTransaction(String str, String str2, int i, long j, long j2, long j3, long j4, String str3, Map<String, String> map, URLConnection uRLConnection) {
        String headerField;
        if (uRLConnection != null && (headerField = uRLConnection.getHeaderField(Constants.Network.CROSS_PROCESS_ID_HEADER)) != null && headerField.length() > 0) {
            _noticeHttpTransaction(str, str2, i, j, j2, j3, j4, str3, map, headerField);
        } else {
            _noticeHttpTransaction(str, str2, i, j, j2, j3, j4, str3, map, null);
        }
    }

    static void _noticeHttpTransaction(String str, String str2, int i, long j, long j2, long j3, long j4, String str3, Map<String, String> map, String str4) {
        noticeHttpTransaction(str, str2, i, j, j2, j3, j4, str3, map, str4, null);
    }

    public static void noticeHttpTransaction(String str, String str2, int i, long j, long j2, long j3, long j4, String str3, Map<String, String> map, String str4, Map<String, Object> map2) {
        checkEmpty(str, "noticeHttpTransaction: url must not be empty.");
        checkEmpty(str2, "noticeHttpTransaction: httpMethod must not be empty.");
        try {
            new URL(str);
            float f = j2 - j;
            if (checkNegative((int) f, "noticeHttpTransaction: the startTimeMs is later than the endTimeMs, resulting in a negative total time.")) {
                return;
            }
            TaskQueue.queue(new HttpTransactionMeasurement(new TransactionData(str, str2, Agent.getActiveNetworkCarrier(), (float) (((double) f) / 1000.0d), i, 0, j3, j4, str4, Agent.getActiveNetworkWanType(), null, str3, map, map2)));
        } catch (MalformedURLException unused) {
            throw new IllegalArgumentException("noticeHttpTransaction: URL is malformed: " + str);
        }
    }

    public static void noticeNetworkFailure(Map<String, Object> map) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "noticeNetworkFailure(Map Attribute)"));
        try {
            noticeNetworkFailure((String) map.get("url"), (String) map.get("httpMethod"), Long.parseLong((String) map.get("startTimeMs")), Long.parseLong((String) map.get("endTimeMs")), NetworkFailure.fromErrorCode(Integer.parseInt((String) map.get("errorCode"))), (String) map.get("message"), (Map) map.get("traceAttributes"));
        } catch (NumberFormatException e) {
            log.error(e.getMessage());
            recordHandledException((Exception) e);
        }
    }

    public static void noticeNetworkFailure(String str, String str2, long j, long j2, NetworkFailure networkFailure, String str3) {
        noticeNetworkFailure(str, str2, j, j2, networkFailure, str3, null);
    }

    public static void noticeNetworkFailure(String str, String str2, long j, long j2, NetworkFailure networkFailure) {
        noticeNetworkFailure(str, str2, j, j2, networkFailure, "", null);
    }

    public static void noticeNetworkFailure(String str, String str2, long j, long j2, Exception exc) {
        checkEmpty(str, "noticeHttpException: url must not be empty.");
        noticeNetworkFailure(str, str2, j, j2, NetworkFailure.exceptionToNetworkFailure(exc), exc.getMessage());
    }

    @Deprecated
    public static void noticeNetworkFailure(String str, long j, long j2, NetworkFailure networkFailure) {
        noticeNetworkFailure(str, "unknown", j, j2, networkFailure);
    }

    @Deprecated
    public static void noticeNetworkFailure(String str, long j, long j2, Exception exc) {
        noticeNetworkFailure(str, "unknown", j, j2, exc);
    }

    public static void noticeNetworkFailure(String str, String str2, long j, long j2, NetworkFailure networkFailure, String str3, Map<String, Object> map) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "_noticeNetworkFailure"));
        float f = j2 - j;
        if (checkNegative((int) f, "_noticeNetworkFailure: the startTimeMs is later than the endTimeMs, resulting in a negative total time.")) {
            return;
        }
        float f2 = f / 1000.0f;
        HashMap map2 = new HashMap();
        map2.put(Constants.Transactions.CONTENT_LENGTH, "0");
        map2.put("content_type", "text/html");
        TaskQueue.queue(new HttpTransactionMeasurement(new TransactionData(str, str2, Agent.getActiveNetworkCarrier(), f2, NetworkFailure.Unknown.getErrorCode(), networkFailure.getErrorCode(), 0L, 0L, null, Agent.getActiveNetworkWanType(), null, str3, map2, map)));
    }

    public static TraceContext noticeDistributedTrace(Map<String, String> map) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "noticeDistributedTrace"));
        return TraceContext.createTraceContext(map);
    }

    private static void checkNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    private static void checkEmpty(String str, String str2) {
        checkNull(str, str2);
        if (str.length() == 0) {
            throw new IllegalArgumentException(str2);
        }
    }

    private static boolean checkNegative(int i, String str) {
        if (i >= 0) {
            return false;
        }
        log.error(str);
        if (!FeatureFlag.featureEnabled(FeatureFlag.HandledExceptions)) {
            return true;
        }
        recordHandledException((Exception) new RuntimeException(str));
        return true;
    }

    public static void crashNow() {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "crashNow"));
        crashNow("This is a demonstration crash courtesy of New Relic");
    }

    public static void crashNow(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "crashNow(String)"));
        throw new RuntimeException(str);
    }

    public static boolean setAttribute(String str, String str2) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "setAttribute(String,String)"));
        return AnalyticsControllerImpl.getInstance().setAttribute(str, str2);
    }

    public static boolean setAttribute(String str, double d) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "setAttribute(String,double)"));
        return AnalyticsControllerImpl.getInstance().setAttribute(str, d);
    }

    public static boolean setAttribute(String str, boolean z) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "setAttribute(String,boolean)"));
        return AnalyticsControllerImpl.getInstance().setAttribute(str, z);
    }

    public static boolean incrementAttribute(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "incrementAttribute(String)"));
        return AnalyticsControllerImpl.getInstance().incrementAttribute(str, 1.0d);
    }

    public static boolean incrementAttribute(String str, double d) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "incrementAttribute(String, double)"));
        return AnalyticsControllerImpl.getInstance().incrementAttribute(str, d);
    }

    public static boolean removeAttribute(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "removeAttribute"));
        return AnalyticsControllerImpl.getInstance().removeAttribute(str);
    }

    public static boolean removeAllAttributes() {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "removeAllAttribute"));
        return AnalyticsControllerImpl.getInstance().removeAllAttributes();
    }

    public static boolean setUserId(final String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "setUserId"));
        new Runnable() { // from class: com.newrelic.agent.android.NewRelic$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                NewRelic.lambda$setUserId$0(str);
            }
        }.run();
        return true;
    }

    static /* synthetic */ void lambda$setUserId$0(String str) {
        AnalyticsControllerImpl analyticsControllerImpl = AnalyticsControllerImpl.getInstance();
        AnalyticsAttribute attribute = analyticsControllerImpl.getAttribute(AnalyticsAttribute.USER_ID_ATTRIBUTE);
        if (attribute != null && !Objects.equals(attribute.getStringValue(), str)) {
            Harvest.harvestNow(true, true);
            analyticsControllerImpl.getAttribute("sessionId").setStringValue(agentConfiguration.provideSessionId()).setPersistent(false);
            analyticsControllerImpl.removeAttribute(AnalyticsAttribute.SESSION_DURATION_ATTRIBUTE);
            if (str == null || str.isEmpty()) {
                analyticsControllerImpl.removeAttribute(AnalyticsAttribute.USER_ID_ATTRIBUTE);
            }
        }
        analyticsControllerImpl.setAttribute(AnalyticsAttribute.USER_ID_ATTRIBUTE, str);
    }

    public static boolean recordCustomEvent(String str, Map<String, Object> map) {
        HashMap map2;
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "recordCustomEvent"));
        if (map == null) {
            map2 = new HashMap();
        } else {
            map2 = new HashMap(map);
        }
        return AnalyticsControllerImpl.getInstance().recordCustomEvent(str, map2);
    }

    public static boolean recordCustomEvent(String str, String str2, Map<String, Object> map) {
        HashMap map2;
        if (map == null) {
            map2 = new HashMap();
        } else {
            map2 = new HashMap(map);
        }
        if (str2 != null && !str2.isEmpty()) {
            map2.put("name", str2);
        }
        return recordCustomEvent(str, map2);
    }

    public static boolean recordBreadcrumb(String str) {
        return recordBreadcrumb(str, null);
    }

    public static boolean recordBreadcrumb(String str, Map<String, Object> map) {
        HashMap map2;
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "recordBreadcrumb"));
        if (map == null) {
            map2 = new HashMap();
        } else {
            map2 = new HashMap(map);
        }
        if (str != null && !str.isEmpty()) {
            map2.put("name", str);
        }
        return AnalyticsControllerImpl.getInstance().recordBreadcrumb(str, map2);
    }

    public static boolean recordHandledException(Exception exc) {
        return recordHandledException(exc, (Map<String, Object>) null);
    }

    public static boolean recordHandledException(Exception exc, Map<String, Object> map) {
        HashMap map2;
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "recordHandledException"));
        if (map == null) {
            map2 = new HashMap();
        } else {
            map2 = new HashMap(map);
        }
        return recordHandledException((Throwable) exc, (Map<String, Object>) map2);
    }

    public static boolean recordHandledException(Throwable th) {
        return recordHandledException(th, (Map<String, Object>) null);
    }

    public static boolean recordHandledException(Throwable th, Map<String, Object> map) {
        HashMap map2;
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "recordThrowable"));
        if (map == null) {
            map2 = new HashMap();
        } else {
            map2 = new HashMap(map);
        }
        return AgentDataController.sendAgentData(th, map2);
    }

    public static void setMaxEventPoolSize(int i) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "setMaxEventPoolSize"));
        AnalyticsControllerImpl.getInstance().setMaxEventPoolSize(i);
    }

    public static void setMaxEventBufferTime(int i) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "setMaxEventBufferTime"));
        AnalyticsControllerImpl.getInstance().setMaxEventBufferTime(i);
    }

    public static void setEventListener(EventListener eventListener) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "setEventListener"));
        AnalyticsControllerImpl.getInstance().getEventManager().setEventListener(eventListener);
    }

    public static String currentSessionId() {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "currentSessionId"));
        return agentConfiguration.getSessionID();
    }

    public static boolean recordJSErrorException(StackTrace stackTrace) {
        return DataController.sendAgentData(stackTrace);
    }

    public static boolean addHTTPHeadersTrackingFor(List<String> list) {
        return HttpHeaders.getInstance().addHttpHeadersAsAttributes(list);
    }

    public static void logInfo(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "log/<state>").replace(MetricNames.TAG_STATE, LogLevel.INFO.name()));
        LogReporting.getLogger().log(LogLevel.INFO, str);
    }

    public static void logWarning(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "log/<state>").replace(MetricNames.TAG_STATE, LogLevel.WARN.name()));
        LogReporting.getLogger().log(LogLevel.WARN, str);
    }

    public static void logDebug(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "log/<state>").replace(MetricNames.TAG_STATE, LogLevel.DEBUG.name()));
        LogReporting.getLogger().log(LogLevel.DEBUG, str);
    }

    public static void logVerbose(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "log/<state>").replace(MetricNames.TAG_STATE, LogLevel.VERBOSE.name()));
        LogReporting.getLogger().log(LogLevel.VERBOSE, str);
    }

    public static void logError(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "log/<state>").replace(MetricNames.TAG_STATE, LogLevel.ERROR.name()));
        LogReporting.getLogger().log(LogLevel.ERROR, str);
    }

    public static void log(LogLevel logLevel, String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "log/<state>").replace(MetricNames.TAG_STATE, logLevel.name()));
        if (LogReporting.isLevelEnabled(logLevel)) {
            LogReporting.getLogger().log(logLevel, str);
        }
    }

    public static void logThrowable(LogLevel logLevel, String str, Throwable th) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "logThrowable/<state>").replace(MetricNames.TAG_STATE, logLevel.name()));
        if (LogReporting.isLevelEnabled(logLevel)) {
            LogReporting.getLogger().logThrowable(logLevel, str, th);
        }
    }

    public static void logAttributes(Map<String, Object> map) {
        Map<String, Object> mapValidate = LogReporting.validator.validate(map);
        String strValueOf = String.valueOf(mapValidate.getOrDefault(FirebaseAnalytics.Param.LEVEL, LogLevel.NONE.toString()));
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "logAttributes/<state>").replace(MetricNames.TAG_STATE, LogLevel.valueOf(strValueOf.toUpperCase()).name()));
        if (LogReporting.isLevelEnabled(LogLevel.valueOf(strValueOf.toUpperCase()))) {
            LogReporting.getLogger().logAttributes(mapValidate);
        }
    }

    public static void logAll(Throwable th, Map<String, Object> map) {
        Map<String, Object> mapValidate = LogReporting.validator.validate(map);
        LogLevel logLevelValueOf = LogLevel.valueOf(String.valueOf(mapValidate.getOrDefault(FirebaseAnalytics.Param.LEVEL, LogLevel.NONE.toString())).toUpperCase());
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "logAll/<state>").replace(MetricNames.TAG_STATE, logLevelValueOf.name()));
        if (LogReporting.isLevelEnabled(logLevelValueOf)) {
            LogReporting.getLogger().logAll(LogReporting.validator.validate(th), mapValidate);
        }
    }

    public static void setMaxOfflineStorageSize(int i) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "setMaxOfflineStorageSize"));
        OfflineStorage.setMaxOfflineStorageSize(i);
    }
}
