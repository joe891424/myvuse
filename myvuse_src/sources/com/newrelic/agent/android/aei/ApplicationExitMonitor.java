package com.newrelic.agent.android.aei;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bat.sdk.domain.device.FirmwareInstallationState;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.aei.AEISessionMapper;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.analytics.AnalyticsEvent;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.util.Streams;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes6.dex */
public class ApplicationExitMonitor {
    static final String ARTIFACT_NAME = "aei-%s.dat";
    private static final Map<Integer, String> IMPORTANCE_MAP;
    private static final Map<Integer, String> REASON_MAP;
    static final String SESSION_ID_MAPPING_STORE = "sessionMeta.map";
    private static final AgentLog log = AgentLogManager.getAgentLog();

    /* JADX INFO: renamed from: am */
    protected final ActivityManager f4029am;
    protected final String packageName;
    protected final File reportsDir;
    protected final AEISessionMapper sessionMapper;
    protected final AEITraceReporter traceReporter;

    static {
        HashMap map = new HashMap();
        REASON_MAP = map;
        HashMap map2 = new HashMap();
        IMPORTANCE_MAP = map2;
        map.put(0, "Unknown");
        map.put(1, "Exit self");
        map.put(2, "Signaled");
        map.put(3, "Low memory");
        map.put(4, "Crash");
        map.put(5, "Native crash");
        map.put(6, "ANR");
        map.put(7, "Initialization failure");
        map.put(8, "Permission change");
        map.put(9, "Excessive resource usage");
        map.put(10, "User requested");
        map.put(11, "User stopped");
        map.put(12, "Dependency died");
        map.put(13, FirmwareInstallationState.Error.ERROR_OTHER_DESC);
        map.put(14, "Freezer");
        map.put(15, "Package state changed");
        map.put(16, "Package updated");
        map2.put(100, "Foreground");
        map2.put(125, "Foreground service");
        map2.put(325, "Top sleeping");
        map2.put(200, "Visible");
        map2.put(230, "Perceptible");
        map2.put(350, "Can't save state");
        map2.put(300, "Service");
        map2.put(400, "Cached");
        map2.put(1000, "Gone");
    }

    public ApplicationExitMonitor(Context context) {
        File file = new File(context.getCacheDir(), "newrelic/applicationExitInfo");
        this.reportsDir = file;
        this.packageName = context.getPackageName();
        this.sessionMapper = new AEISessionMapper(new File(file, SESSION_ID_MAPPING_STORE));
        this.f4029am = (ActivityManager) context.getSystemService("activity");
        file.mkdirs();
        AEITraceReporter aEITraceReporter = AEITraceReporter.getInstance();
        try {
            aEITraceReporter = AEITraceReporter.initialize(file, AgentConfiguration.getInstance());
            if (aEITraceReporter != null) {
                aEITraceReporter.start();
                if (!aEITraceReporter.isStarted()) {
                    log.warn("ApplicationExitMonitor: AEI trace reporter not started. AEITrace reporting will be disabled.");
                }
            } else {
                log.warn("ApplicationExitMonitor: No AEI trace reporter. AEITrace reporting will be disabled.");
            }
        } catch (IOException e) {
            log.error("ApplicationExitMonitor: " + e);
        }
        this.traceReporter = aEITraceReporter;
    }

    int getCurrentProcessId() {
        return Process.myPid();
    }

    public void harvestApplicationExitInfo() {
        this.sessionMapper.load();
        if (Build.VERSION.SDK_INT >= 30) {
            AtomicInteger atomicInteger = new AtomicInteger(0);
            AtomicInteger atomicInteger2 = new AtomicInteger(0);
            AtomicInteger atomicInteger3 = new AtomicInteger(0);
            ActivityManager activityManager = this.f4029am;
            if (activityManager == null) {
                log.error("harvestApplicationExitInfo: ActivityManager is null! Cannot record ApplicationExitInfo data.");
                return;
            }
            List<ApplicationExitInfo> historicalProcessExitReasons = activityManager.getHistoricalProcessExitReasons(this.packageName, 0, 0);
            for (ApplicationExitInfo applicationExitInfo : historicalProcessExitReasons) {
                File file = new File(this.reportsDir, String.format(Locale.getDefault(), ARTIFACT_NAME, Integer.valueOf(applicationExitInfo.getPid())));
                if (file.exists() && file.length() > 0) {
                    log.debug("ApplicationExitMonitor: skipping exit info for pid[" + applicationExitInfo.getPid() + "]: already recorded.");
                    atomicInteger2.incrementAndGet();
                } else {
                    String sessionId = this.sessionMapper.getSessionId(applicationExitInfo.getPid());
                    if (sessionId != null && !sessionId.isEmpty() && !sessionId.equals(AgentConfiguration.getInstance().getSessionID())) {
                        log.debug("ApplicationExitMonitor: Found session id [" + sessionId + "] for AEI pid[" + applicationExitInfo.getPid() + "]");
                    }
                    String string = applicationExitInfo.toString();
                    if (file.exists() && file.length() == 0) {
                        file.delete();
                    }
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                        try {
                            if (applicationExitInfo.getTraceInputStream() != null) {
                                try {
                                    InputStream traceInputStream = applicationExitInfo.getTraceInputStream();
                                    try {
                                        string = Streams.slurpString(traceInputStream);
                                        if (traceInputStream != null) {
                                            traceInputStream.close();
                                        }
                                    } catch (Throwable th) {
                                        if (traceInputStream != null) {
                                            try {
                                                traceInputStream.close();
                                            } catch (Throwable th2) {
                                                th.addSuppressed(th2);
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (IOException e) {
                                    log.info("ApplicationExitMonitor: " + e);
                                }
                            }
                            fileOutputStream.write(string.getBytes(StandardCharsets.UTF_8));
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            file.setReadOnly();
                            atomicInteger.incrementAndGet();
                            fileOutputStream.close();
                        } finally {
                        }
                    } catch (IOException e2) {
                        log.debug("harvestApplicationExitInfo: AppExitInfo artifact error. " + e2);
                    }
                    AEISessionMapper.AEISessionMeta aEISessionMeta = this.sessionMapper.get(applicationExitInfo.getPid());
                    if (aEISessionMeta != null) {
                        log.debug("ApplicationExitMonitor: Using session meta [" + aEISessionMeta.sessionId + ", " + aEISessionMeta.realAgentId + "] for AEI pid[" + applicationExitInfo.getPid() + "]");
                    }
                    try {
                        HashMap<String, Object> eventAttributesForAEI = getEventAttributesForAEI(applicationExitInfo, aEISessionMeta, string);
                        StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_AEI_EXIT_STATUS + applicationExitInfo.getStatus());
                        StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_AEI_EXIT_BY_REASON + getReasonAsString(applicationExitInfo.getReason()));
                        StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_AEI_EXIT_BY_IMPORTANCE + getImportanceAsString(applicationExitInfo.getImportance()));
                        StatsEngine.SUPPORTABILITY.sample(MetricNames.SUPPORTABILITY_AEI_VISITED, atomicInteger.get());
                        StatsEngine.SUPPORTABILITY.sample(MetricNames.SUPPORTABILITY_AEI_SKIPPED, atomicInteger2.get());
                        this.traceReporter.reportAEITrace(new Error(AnalyticsControllerImpl.getInstance().getSessionAttributes(), eventAttributesForAEI, aEISessionMeta).asJsonObject().toString(), applicationExitInfo.getPid());
                    } catch (UnsupportedEncodingException e3) {
                        throw new RuntimeException(e3);
                    }
                }
            }
            log.debug("AEI: inspected [" + historicalProcessExitReasons.size() + "] records: new[" + atomicInteger.get() + "] existing [" + atomicInteger2.get() + "] dropped[" + atomicInteger3.get() + "]");
            this.sessionMapper.put(getCurrentProcessId(), new AEISessionMapper.AEISessionMeta(AgentConfiguration.getInstance().getSessionID(), Harvest.getHarvestConfiguration().getDataToken().getAgentId()));
            this.sessionMapper.flush();
            reconcileMetadata(historicalProcessExitReasons);
            return;
        }
        log.warn("ApplicationExitMonitor: exit info reporting was enabled, but not supported by the current OS");
        StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_AEI_UNSUPPORTED_OS + Build.VERSION.SDK_INT);
    }

    protected HashMap<String, Object> getEventAttributesForAEI(ApplicationExitInfo applicationExitInfo, AEISessionMapper.AEISessionMeta aEISessionMeta, String str) throws UnsupportedEncodingException {
        HashMap<String, Object> map = new HashMap<>();
        map.put(AnalyticsAttribute.APP_EXIT_TIMESTAMP_ATTRIBUTE, Long.valueOf(applicationExitInfo.getTimestamp()));
        map.put(AnalyticsAttribute.APP_EXIT_REASON_ATTRIBUTE, Integer.valueOf(applicationExitInfo.getReason()));
        map.put(AnalyticsAttribute.APP_EXIT_IMPORTANCE_ATTRIBUTE, Integer.valueOf(applicationExitInfo.getImportance()));
        map.put(AnalyticsAttribute.APP_EXIT_IMPORTANCE_STRING_ATTRIBUTE, getImportanceAsString(applicationExitInfo.getImportance()));
        map.put("description", toValidAttributeValue(applicationExitInfo.getDescription()));
        map.put(AnalyticsAttribute.APP_EXIT_PROCESS_NAME_ATTRIBUTE, toValidAttributeValue(applicationExitInfo.getProcessName()));
        if (aEISessionMeta != null) {
            map.put("sessionId", aEISessionMeta.sessionId);
        } else {
            StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_AEI_EXIT_STATUS);
        }
        map.put(AnalyticsAttribute.APP_EXIT_ID_ATTRIBUTE, UUID.randomUUID().toString());
        map.put("processId", Integer.valueOf(applicationExitInfo.getPid()));
        map.put(AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE, AnalyticsEvent.EVENT_TYPE_MOBILE_APPLICATION_EXIT);
        int importance = applicationExitInfo.getImportance();
        if (importance == 100 || importance == 125 || importance == 200 || importance == 230 || importance == 325) {
            map.put(AnalyticsAttribute.APP_EXIT_APP_STATE_ATTRIBUTE, "foreground");
        } else {
            map.put(AnalyticsAttribute.APP_EXIT_APP_STATE_ATTRIBUTE, "background");
        }
        if (applicationExitInfo.getReason() == 6) {
            AEITrace aEITrace = new AEITrace();
            aEITrace.decomposeFromSystemTrace(str);
            map.put(AnalyticsAttribute.APP_EXIT_THREADS_ATTRIBUTE, URLEncoder.encode(aEITrace.toString(), StandardCharsets.UTF_8.toString()));
        }
        return map;
    }

    public Set<Integer> currentPidSet(List<ApplicationExitInfo> list) {
        return (Set) list.stream().mapToInt(new ToIntFunction() { // from class: com.newrelic.agent.android.aei.ApplicationExitMonitor$$ExternalSyntheticLambda1
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ((ApplicationExitInfo) obj).getPid();
            }
        }).boxed().collect(Collectors.toSet());
    }

    void reconcileMetadata(List<ApplicationExitInfo> list) {
        List<File> artifacts = getArtifacts();
        final Pattern patternCompile = Pattern.compile(String.format(Locale.getDefault(), ARTIFACT_NAME, "(\\d+)"));
        final Set<Integer> setCurrentPidSet = currentPidSet(list);
        artifacts.forEach(new Consumer() { // from class: com.newrelic.agent.android.aei.ApplicationExitMonitor$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m2723xa4d41750(patternCompile, setCurrentPidSet, (File) obj);
            }
        });
        this.sessionMapper.flush();
    }

    /* JADX INFO: renamed from: lambda$reconcileMetadata$0$com-newrelic-agent-android-aei-ApplicationExitMonitor */
    /* synthetic */ void m2723xa4d41750(Pattern pattern, Set set, File file) {
        Matcher matcher = pattern.matcher(file.getName());
        if (matcher.matches()) {
            int i = Integer.parseInt((String) Objects.requireNonNull(matcher.group(1)));
            if (set.contains(Integer.valueOf(i))) {
                return;
            }
            file.delete();
            this.sessionMapper.erase(i);
        }
    }

    public void resetSessionMap() {
        this.sessionMapper.delete();
    }

    protected String toValidAttributeValue(String str) {
        return str == null ? "null" : str.substring(0, Math.min(str.length(), 4095));
    }

    protected String getReasonAsString(int i) {
        return REASON_MAP.getOrDefault(Integer.valueOf(i), String.valueOf(i));
    }

    protected String getImportanceAsString(int i) {
        return IMPORTANCE_MAP.getOrDefault(Integer.valueOf(i), String.valueOf(i));
    }

    List<File> getArtifacts() {
        final String str = String.format(Locale.getDefault(), ARTIFACT_NAME, "\\d+");
        return (List) Streams.list(this.reportsDir).filter(new Predicate() { // from class: com.newrelic.agent.android.aei.ApplicationExitMonitor$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ApplicationExitMonitor.lambda$getArtifacts$1(str, (File) obj);
            }
        }).collect(Collectors.toList());
    }

    static /* synthetic */ boolean lambda$getArtifacts$1(String str, File file) {
        return file.isFile() && file.getName().matches(str);
    }
}
