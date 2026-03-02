package com.newrelic.agent.android.aei;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.payload.PayloadController;
import com.newrelic.agent.android.payload.PayloadReporter;
import com.newrelic.agent.android.payload.PayloadSender;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.util.Constants;
import com.newrelic.agent.android.util.Streams;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes6.dex */
public class AEITraceReporter extends PayloadReporter {
    static final String FILE_MASK = "threads-%s.dat";
    static final String TRACE_DATA_DIR = "aeitrace/";
    protected static AtomicReference<AEITraceReporter> instance = new AtomicReference<>(null);
    static long reportTTL = TimeUnit.SECONDS.convert(2, TimeUnit.DAYS);
    protected final Callable reportCachedAgentDataCallable;
    File traceStore;

    public static AEITraceReporter getInstance() {
        return instance.get();
    }

    /* JADX INFO: renamed from: lambda$new$0$com-newrelic-agent-android-aei-AEITraceReporter, reason: not valid java name */
    /* synthetic */ Object m6361lambda$new$0$comnewrelicagentandroidaeiAEITraceReporter() throws Exception {
        postCachedAgentData();
        if (!getCachedTraces().isEmpty()) {
            return null;
        }
        shutdown();
        return null;
    }

    public static AEITraceReporter initialize(File file, AgentConfiguration agentConfiguration) throws IOException {
        if (!file.isDirectory() || !file.exists() || !file.canWrite()) {
            throw new IOException("Trace reports directory [" + file.getAbsolutePath() + "] must exist and be writable!");
        }
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m1161m(instance, null, new AEITraceReporter(agentConfiguration))) {
            AEITraceReporter aEITraceReporter = getInstance();
            File file2 = new File(file, TRACE_DATA_DIR);
            aEITraceReporter.traceStore = file2;
            file2.mkdirs();
            if (!aEITraceReporter.traceStore.exists() || !aEITraceReporter.traceStore.canWrite()) {
                throw new IOException("AEI: Threads directory [" + file.getAbsolutePath() + "] must exist and be writable!");
            }
            log.debug("AEI: saving AEI trace data to " + aEITraceReporter.traceStore.getAbsolutePath());
            log.debug("AEI: reporter instance initialized");
        }
        return instance.get();
    }

    protected static boolean isInitialized() {
        return instance.get() != null;
    }

    protected AEITraceReporter(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
        this.traceStore = new File(System.getProperty("java.io.tmpdir", "/tmp"), TRACE_DATA_DIR).getAbsoluteFile();
        this.reportCachedAgentDataCallable = new Callable() { // from class: com.newrelic.agent.android.aei.AEITraceReporter$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m6361lambda$new$0$comnewrelicagentandroidaeiAEITraceReporter();
            }
        };
        setEnabled(agentConfiguration.getApplicationExitConfiguration().isEnabled());
    }

    @Override // com.newrelic.agent.android.payload.PayloadReporter
    public void start() {
        if (isInitialized()) {
            if (this.isStarted.compareAndSet(false, true)) {
                Harvest.addHarvestListener(instance.get());
                this.isStarted.set(true);
            } else {
                log.error("AEITraceReporter: failed to initialize.");
            }
        }
    }

    @Override // com.newrelic.agent.android.payload.PayloadReporter
    protected void stop() {
        if (isStarted()) {
            Harvest.removeHarvestListener(instance.get());
            this.isStarted.set(false);
        }
    }

    public static void shutdown() {
        if (isInitialized()) {
            instance.get().stop();
            instance.set(null);
        }
    }

    public void reportAEITrace(String str, int i) {
        reportAEITrace(str, generateUniqueDataFilename(i));
    }

    public void reportAEITrace(String str, File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            try {
                fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
                fileOutputStream.flush();
                fileOutputStream.close();
                file.setReadOnly();
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException e) {
            log.debug("AEITraceReporter: AppExitInfo artifact error. " + String.valueOf(e));
        }
    }

    protected void postCachedAgentData() {
        if (isInitialized() && Agent.hasReachableNetworkConnection(null)) {
            getCachedTraces().forEach(new Consumer() { // from class: com.newrelic.agent.android.aei.AEITraceReporter$$ExternalSyntheticLambda2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f$0.m2722x2247bd16((File) obj);
                }
            });
        }
        expire(Math.toIntExact(reportTTL));
    }

    /* JADX INFO: renamed from: lambda$postCachedAgentData$1$com-newrelic-agent-android-aei-AEITraceReporter */
    /* synthetic */ void m2722x2247bd16(File file) {
        if (postAEITrace(file)) {
            log.info("AEI: Uploaded trace data [" + file.getAbsolutePath() + "]");
            if (safeDelete(file)) {
                log.debug("AEI: Trace data artifact[" + file.getName() + "] removed from device");
                return;
            }
            return;
        }
        log.error("AEITraceReporter: upload failed for trace data [" + file.getAbsolutePath() + "]");
    }

    boolean postAEITrace(File file) {
        if (Harvest.getHarvestConfiguration().getDataToken().isValid()) {
            try {
                if (file.exists()) {
                    AEITraceSender aEITraceSender = new AEITraceSender(file, this.agentConfiguration);
                    aEITraceSender.call().getResponseCode();
                    return aEITraceSender.isSuccessfulResponse();
                }
                log.warn("AEI: Trace [" + file.getName() + "] vanished before it could be uploaded.");
                return false;
            } catch (Exception e) {
                AgentLogManager.getAgentLog().error("AEI: Trace upload failed: " + String.valueOf(e));
                return false;
            }
        }
        log.warn("AEITraceReporter: agent has not successfully connected and cannot report AEITrace. Will retry later");
        return false;
    }

    protected Future postAEITrace(String str) {
        if (!Harvest.getHarvestConfiguration().getDataToken().isValid()) {
            log.error("AEITraceReporter: agent has not successfully connected and cannot report AEITrace.");
        } else {
            if (str != null) {
                AEITrace aEITraceDecomposeFromSystemTrace = new AEITrace().decomposeFromSystemTrace(str);
                if (aEITraceDecomposeFromSystemTrace.toString().getBytes().length > Constants.Network.MAX_PAYLOAD_SIZE) {
                    StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_MAXPAYLOADSIZELIMIT_ENDPOINT.replace(MetricNames.TAG_FRAMEWORK, Agent.getDeviceInformation().getApplicationFramework().name()).replace(MetricNames.TAG_DESTINATION, MetricNames.METRIC_DATA_USAGE_COLLECTOR).replace(MetricNames.TAG_SUBDESTINATION, "errors"));
                    return null;
                }
                PayloadSender.CompletionHandler completionHandler = new PayloadSender.CompletionHandler() { // from class: com.newrelic.agent.android.aei.AEITraceReporter.1
                    @Override // com.newrelic.agent.android.payload.PayloadSender.CompletionHandler
                    public void onResponse(PayloadSender payloadSender) {
                        if (payloadSender.isSuccessfulResponse()) {
                            StatsEngine.get().sampleMetricDataUsage(MetricNames.SUPPORTABILITY_SUBDESTINATION_OUTPUT_BYTES.replace(MetricNames.TAG_FRAMEWORK, Agent.getDeviceInformation().getApplicationFramework().name()).replace(MetricNames.TAG_DESTINATION, MetricNames.METRIC_DATA_USAGE_COLLECTOR).replace(MetricNames.TAG_SUBDESTINATION, "mobile_crash"), payloadSender.getPayloadSize(), 0.0f);
                        }
                    }

                    @Override // com.newrelic.agent.android.payload.PayloadSender.CompletionHandler
                    public void onException(PayloadSender payloadSender, Exception exc) {
                        AEITraceReporter.log.error("AEITraceReporter: AEITrace upload failed: " + String.valueOf(exc));
                    }
                };
                AEITraceSender aEITraceSender = new AEITraceSender(aEITraceDecomposeFromSystemTrace.toString(), this.agentConfiguration);
                if (!aEITraceSender.shouldUploadOpportunistically()) {
                    log.warn("AEITraceReporter: network is unreachable. AEITrace will be uploaded on next app launch");
                }
                return PayloadController.submitPayload(aEITraceSender, completionHandler);
            }
            log.warn("AEITraceReporter: attempted to report null AEITrace.");
        }
        return null;
    }

    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvest() {
        postCachedAgentData();
        if (getCachedTraces().isEmpty()) {
            shutdown();
        }
    }

    protected Set<File> getCachedTraces() {
        HashSet hashSet = new HashSet();
        try {
            final String str = String.format(Locale.getDefault(), FILE_MASK, "\\d+");
            return (Set) Streams.list(this.traceStore).filter(new Predicate() { // from class: com.newrelic.agent.android.aei.AEITraceReporter$$ExternalSyntheticLambda3
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return AEITraceReporter.lambda$getCachedTraces$2(str, (File) obj);
                }
            }).collect(Collectors.toSet());
        } catch (Exception e) {
            log.error("AEI:Can't query cached log reports: " + String.valueOf(e));
            return hashSet;
        }
    }

    static /* synthetic */ boolean lambda$getCachedTraces$2(String str, File file) {
        return file.isFile() && file.getName().matches(str);
    }

    static /* synthetic */ boolean lambda$expire$3(long j, File file) {
        return file.exists() && file.lastModified() + j < System.currentTimeMillis();
    }

    Set<File> expire(final long j) {
        Set<File> set = (Set) Streams.list(this.traceStore, new FileFilter() { // from class: com.newrelic.agent.android.aei.AEITraceReporter$$ExternalSyntheticLambda0
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                return AEITraceReporter.lambda$expire$3(j, file);
            }
        }).collect(Collectors.toSet());
        set.forEach(new Consumer() { // from class: com.newrelic.agent.android.aei.AEITraceReporter$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m6360lambda$expire$4$comnewrelicagentandroidaeiAEITraceReporter((File) obj);
            }
        });
        return set;
    }

    /* JADX INFO: renamed from: lambda$expire$4$com-newrelic-agent-android-aei-AEITraceReporter, reason: not valid java name */
    /* synthetic */ void m6360lambda$expire$4$comnewrelicagentandroidaeiAEITraceReporter(File file) {
        log.debug("AEI:Thread data [" + file.getName() + "] has expired and will be removed.");
        safeDelete(file);
    }

    boolean safeDelete(File file) {
        file.setReadOnly();
        file.delete();
        return !file.exists();
    }

    File generateUniqueDataFilename(int i) {
        File file;
        int i2 = 5;
        while (true) {
            file = new File(this.traceStore, String.format(Locale.getDefault(), FILE_MASK, Integer.valueOf(i)));
            if (!file.exists() || 0 >= file.length()) {
                break;
            }
            int i3 = i2 - 1;
            if (i2 <= 0) {
                break;
            }
            i2 = i3;
        }
        if (file.exists()) {
            return null;
        }
        return file;
    }
}
