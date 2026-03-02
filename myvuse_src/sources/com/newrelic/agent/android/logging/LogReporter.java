package com.newrelic.agent.android.logging;

import com.facebook.hermes.intl.Constants;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.ApplicationFramework;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestLifecycleAware;
import com.newrelic.agent.android.logging.LogReporter;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.payload.PayloadReporter;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.util.Streams;
import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.GsonBuilder;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonSyntaxException;
import com.newrelic.com.google.gson.reflect.TypeToken;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class LogReporter extends PayloadReporter {
    static final long LOG_ENDPOINT_TIMEOUT = 10;
    static final String LOG_FILE_MASK = "logdata%s.%s";
    protected int payloadBudget;
    protected long reportTTL;
    protected File workingLogfile;
    protected AtomicReference<BufferedWriter> workingLogfileWriter;
    protected static final Type gtype = new TypeToken<Map<String, Object>>() { // from class: com.newrelic.agent.android.logging.LogReporter.1
    }.getType();
    protected static final Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
    static int VORTEX_PAYLOAD_LIMIT = 1024000;
    static int MIN_PAYLOAD_THRESHOLD = -1;
    static final Pattern LOG_FILE_REGEX = Pattern.compile("^(.*\\/newrelic/logReporting)\\/(logdata.*)\\.(.*)$");
    static final AtomicReference<LogReporter> instance = new AtomicReference<>(null);
    static final ReentrantLock workingFileLock = new ReentrantLock();
    static final String LOG_REPORTS_DIR = "newrelic/logReporting";
    static File logDataStore = new File(System.getProperty("java.io.tmpdir", "/tmp"), LOG_REPORTS_DIR).getAbsoluteFile();

    enum LogReportState {
        WORKING("tmp"),
        CLOSED("dat"),
        ROLLUP("rollup"),
        EXPIRED("bak"),
        ALL(".*");

        final String extension;

        LogReportState(String str) {
            this.extension = str;
        }

        public String asExtension() {
            return String.format(Locale.getDefault(), ".%s", this.extension);
        }
    }

    public static LogReporter initialize(File file, AgentConfiguration agentConfiguration) throws IOException {
        if (!file.isDirectory() || !file.exists() || !file.canWrite()) {
            throw new IOException("Reports directory [" + file.getAbsolutePath() + "] must exist and be writable!");
        }
        File file2 = new File(file, LOG_REPORTS_DIR);
        logDataStore = file2;
        file2.mkdirs();
        if (!logDataStore.exists() || !logDataStore.canWrite()) {
            throw new IOException("LogReporter: Reports directory [" + file.getAbsolutePath() + "] must exist and be writable!");
        }
        log.debug("LogReporting: saving log reports to " + logDataStore.getAbsolutePath());
        AtomicReference<LogReporter> atomicReference = instance;
        atomicReference.set(new LogReporter(agentConfiguration));
        log.debug("LogReporting: reporter instance initialized");
        LogReporting.setLogger(new RemoteLogger());
        log.debug("LogReporting: logger has been set to " + LogReporting.getLogger().getClass().getSimpleName());
        StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_LOG_REPORTING_INIT);
        StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_LOG_SAMPLED.concat(agentConfiguration.getLogReportingConfiguration().isSampled() ? "true" : Constants.CASEFIRST_FALSE));
        return atomicReference.get();
    }

    public static LogReporter getInstance() {
        return instance.get();
    }

    public LogReporter(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
        this.payloadBudget = VORTEX_PAYLOAD_LIMIT;
        this.reportTTL = LogReportingConfiguration.DEFAULT_EXPIRATION_PERIOD;
        this.workingLogfileWriter = new AtomicReference<>(null);
        setEnabled(agentConfiguration.getLogReportingConfiguration().getLoggingEnabled());
        try {
            resetWorkingLogfile();
        } catch (IOException e) {
            log.error("LogReporter error: " + String.valueOf(e));
            setEnabled(false);
        }
    }

    @Override // com.newrelic.agent.android.payload.PayloadReporter
    protected void start() {
        if (isEnabled()) {
            Harvest.addHarvestListener(instance.get());
            this.isStarted.set(true);
        } else {
            log.error("Attempted to start the log reported when disabled.");
        }
    }

    @Override // com.newrelic.agent.android.payload.PayloadReporter
    protected void stop() {
        Harvest.removeHarvestListener(instance.get());
        this.isStarted.set(false);
        if (isEnabled()) {
            onHarvestStop();
        }
        this.workingLogfileWriter.set(null);
    }

    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvestStart() {
        Logger logger = LogReporting.getLogger();
        if (logger instanceof HarvestLifecycleAware) {
            ((HarvestLifecycleAware) logger).onHarvestStart();
        }
        cleanup();
    }

    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvestStop() {
        try {
            Logger logger = LogReporting.getLogger();
            if (logger instanceof HarvestLifecycleAware) {
                ((HarvestLifecycleAware) logger).onHarvestStop();
            }
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvestConnected() {
        processLogs();
    }

    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvest() {
        processLogs();
    }

    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvestComplete() {
        Logger logger = LogReporting.getLogger();
        if (logger instanceof HarvestLifecycleAware) {
            ((HarvestLifecycleAware) logger).onHarvestComplete();
        }
        getCachedLogReports(LogReportState.ROLLUP).forEach(new Consumer() { // from class: com.newrelic.agent.android.logging.LogReporter$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m2738xb3f58175((File) obj);
            }
        });
        cleanup();
    }

    /* JADX INFO: renamed from: lambda$onHarvestComplete$0$com-newrelic-agent-android-logging-LogReporter */
    /* synthetic */ void m2738xb3f58175(File file) {
        if (postLogReport(file)) {
            log.info("LogReporter: Uploaded remote log data [" + file.getAbsolutePath() + "]");
            m2739x29b3205a(file);
            return;
        }
        log.error("LogReporter: Upload failed for remote log data [" + file.getAbsolutePath() + "]");
    }

    @Override // com.newrelic.agent.android.payload.PayloadReporter, com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvestConfigurationChanged() {
        setEnabled(this.agentConfiguration.getLogReportingConfiguration().getLoggingEnabled());
        if (this.agentConfiguration.getLogReportingConfiguration().getExpirationPeriod() != this.reportTTL) {
            this.reportTTL = Math.max(this.agentConfiguration.getLogReportingConfiguration().getExpirationPeriod(), TimeUnit.MILLISECONDS.convert(30L, TimeUnit.SECONDS));
            log.debug("LogReporter: logging configuration changed [" + this.agentConfiguration.getLogReportingConfiguration().toString() + "]");
        }
    }

    protected Set<File> getCachedLogReports(LogReportState logReportState) {
        return getCachedLogReports(logReportState.extension);
    }

    protected Set<File> getCachedLogReports(String str) {
        HashSet hashSet = new HashSet();
        try {
            final String str2 = String.format(Locale.getDefault(), LOG_FILE_MASK, ".*", str);
            return (Set) Streams.list(logDataStore).filter(new Predicate() { // from class: com.newrelic.agent.android.logging.LogReporter$$ExternalSyntheticLambda3
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return LogReporter.lambda$getCachedLogReports$1(str2, (File) obj);
                }
            }).collect(Collectors.toSet());
        } catch (Exception e) {
            log.error("LogReporter: Can't query cached log reports: " + String.valueOf(e));
            return hashSet;
        }
    }

    static /* synthetic */ boolean lambda$getCachedLogReports$1(String str, File file) {
        return file.isFile() && file.getName().matches(str);
    }

    protected File rollupLogDataFiles() {
        Set<File> cachedLogReports = getCachedLogReports(LogReportState.CLOSED);
        int iSum = cachedLogReports.stream().mapToInt(new ToIntFunction() { // from class: com.newrelic.agent.android.logging.LogReporter$$ExternalSyntheticLambda4
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return Math.toIntExact(((File) obj).length());
            }
        }).sum();
        if (MIN_PAYLOAD_THRESHOLD > iSum) {
            if (!cachedLogReports.isEmpty()) {
                log.debug("LogReporter: buffering log data until the minimum threshold: " + iSum + "/" + MIN_PAYLOAD_THRESHOLD + " bytes");
            }
            return null;
        }
        HashSet hashSet = new HashSet();
        try {
            try {
                workingFileLock.lock();
                JsonArray jsonArray = new JsonArray();
                for (File file : cachedLogReports) {
                    if (file != null && file.exists() && file.length() > 0) {
                        try {
                            logfileToJsonArray(file, jsonArray);
                            hashSet.add(file);
                        } catch (Exception e) {
                            log.error("LogReporter: " + e.toString());
                        }
                    }
                }
                if (jsonArray.size() > 0) {
                    File fileGenerateUniqueLogfile = generateUniqueLogfile(LogReportState.ROLLUP);
                    fileGenerateUniqueLogfile.mkdirs();
                    fileGenerateUniqueLogfile.delete();
                    fileGenerateUniqueLogfile.createNewFile();
                    try {
                        jsonArrayToLogfile(jsonArray, fileGenerateUniqueLogfile);
                    } catch (Exception e2) {
                        log.error("Log file rollup failed: " + String.valueOf(e2));
                    }
                    hashSet.forEach(new Consumer() { // from class: com.newrelic.agent.android.logging.LogReporter$$ExternalSyntheticLambda5
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            this.f$0.m2739x29b3205a((File) obj);
                        }
                    });
                    return fileGenerateUniqueLogfile;
                }
            } catch (IOException e3) {
                log.error(e3.toString());
            }
            return null;
        } finally {
            workingFileLock.unlock();
        }
    }

    void processLogs() {
        File fileRollupLogDataFiles;
        try {
            try {
                Logger logger = LogReporting.getLogger();
                if (logger instanceof HarvestLifecycleAware) {
                    ((HarvestLifecycleAware) logger).onHarvest();
                }
                ReentrantLock reentrantLock = workingFileLock;
                reentrantLock.lock();
                this.workingLogfileWriter.get().flush();
                finalizeWorkingLogfile();
                rollWorkingLogfile();
                reentrantLock.unlock();
            } catch (IOException e) {
                log.error("LogReporter: " + String.valueOf(e));
                workingFileLock.unlock();
            }
            if (isEnabled() && (fileRollupLogDataFiles = rollupLogDataFiles()) != null && fileRollupLogDataFiles.isFile()) {
                if (postLogReport(fileRollupLogDataFiles)) {
                    log.info("LogReporter: Uploaded remote log data [" + fileRollupLogDataFiles.getName() + "]");
                    m2739x29b3205a(fileRollupLogDataFiles);
                } else {
                    log.error("LogReporter: Upload failed for remote log data [" + String.valueOf(fileRollupLogDataFiles.getAbsoluteFile()) + "]");
                }
            }
        } catch (Throwable th) {
            workingFileLock.unlock();
            throw th;
        }
    }

    boolean postLogReport(File file) {
        try {
            if (file.exists()) {
                if (!isLogfileTypeOf(file, LogReportState.ROLLUP)) {
                    file = rollupLogDataFiles();
                }
                if (!file.exists() || !isLogfileTypeOf(file, LogReportState.ROLLUP)) {
                    return false;
                }
                LogForwarder logForwarder = new LogForwarder(file, this.agentConfiguration);
                logForwarder.call().getResponseCode();
                return logForwarder.isSuccessfulResponse();
            }
            log.warn("LogReporter: Logfile [" + file.getName() + "] vanished before it could be uploaded.");
            return false;
        } catch (Exception e) {
            AgentLogManager.getAgentLog().error("LogReporter: Log upload failed: " + String.valueOf(e));
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: safeDelete, reason: merged with bridge method [inline-methods] */
    public boolean m2739x29b3205a(File file) {
        if (!isLogfileTypeOf(file, LogReportState.EXPIRED)) {
            file.delete();
        }
        return !file.exists();
    }

    File getWorkingLogfile() throws IOException {
        File file = new File(logDataStore, String.format(Locale.getDefault(), LOG_FILE_MASK, "", LogReportState.WORKING.extension));
        file.getParentFile().mkdirs();
        if (!file.exists()) {
            file.createNewFile();
        }
        file.setLastModified(System.currentTimeMillis());
        return file;
    }

    static File generateUniqueLogfile(LogReportState logReportState) {
        File file;
        int i = 5;
        while (true) {
            file = new File(logDataStore, String.format(Locale.getDefault(), LOG_FILE_MASK, UUID.randomUUID(), logReportState.extension));
            if (!file.exists() || 0 >= file.length()) {
                break;
            }
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            i = i2;
        }
        return file;
    }

    File rollLogfile(File file) {
        File fileGenerateUniqueLogfile = generateUniqueLogfile(LogReportState.CLOSED);
        file.renameTo(fileGenerateUniqueLogfile);
        fileGenerateUniqueLogfile.setLastModified(System.currentTimeMillis());
        return fileGenerateUniqueLogfile;
    }

    File compress(File file, boolean z) throws IOException {
        File file2 = new File(file.getAbsolutePath() + ".gz");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(fileOutputStream, 65536, true);
                try {
                    Streams.copy(fileInputStream, gZIPOutputStream);
                    gZIPOutputStream.flush();
                    if (z) {
                        file.delete();
                    }
                    gZIPOutputStream.close();
                    fileOutputStream.close();
                    fileInputStream.close();
                    return file2;
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    Set<File> cleanup() {
        Set<File> cachedLogReports = getCachedLogReports(LogReportState.EXPIRED);
        cachedLogReports.addAll(getCachedLogReports(LogReportState.CLOSED));
        cachedLogReports.forEach(new Consumer() { // from class: com.newrelic.agent.android.logging.LogReporter$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                LogReporter.lambda$cleanup$4((File) obj);
            }
        });
        return cachedLogReports;
    }

    static /* synthetic */ void lambda$cleanup$4(File file) {
        if (file.delete()) {
            log.debug("LogReporter: Log data [" + file.getName() + "] removed.");
        } else {
            log.warn("LogReporter: Log data [" + file.getName() + "] not removed!");
        }
    }

    void finalizeWorkingLogfile() {
        ReentrantLock reentrantLock;
        try {
            try {
                reentrantLock = workingFileLock;
                reentrantLock.lock();
                this.workingLogfileWriter.get().flush();
                this.workingLogfileWriter.get().close();
                this.workingLogfileWriter.set(null);
            } catch (Exception e) {
                log.error(e.toString());
                reentrantLock = workingFileLock;
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            workingFileLock.unlock();
            throw th;
        }
    }

    File rollWorkingLogfile() throws IOException {
        try {
            ReentrantLock reentrantLock = workingFileLock;
            reentrantLock.lock();
            File fileRollLogfile = rollLogfile(this.workingLogfile);
            this.workingLogfile = getWorkingLogfile();
            resetWorkingLogfile();
            if (AgentConfiguration.getInstance().getLogReportingConfiguration().isSampled()) {
                fileRollLogfile.setReadOnly();
            } else {
                fileRollLogfile.delete();
            }
            log.debug("LogReporter: Finalized log data to [" + fileRollLogfile.getAbsolutePath() + "]");
            reentrantLock.unlock();
            return fileRollLogfile;
        } catch (Throwable th) {
            workingFileLock.unlock();
            throw th;
        }
    }

    BufferedWriter resetWorkingLogfile() throws IOException {
        this.workingLogfile = getWorkingLogfile();
        this.workingLogfileWriter.set(new BufferedWriter(new FileWriter(this.workingLogfile, true)));
        return this.workingLogfileWriter.get();
    }

    static Map<String, Object> getCommonBlockAttributes() {
        HashMap map = new HashMap();
        map.put("entity.guid", AgentConfiguration.getInstance().getEntityGuid());
        map.put("sessionId", AgentConfiguration.getInstance().getSessionID());
        map.put("instrumentation.provider", "mobile");
        map.put("instrumentation.name", AgentConfiguration.getInstance().getApplicationFramework().equals(ApplicationFramework.Native) ? "AndroidAgent" : AgentConfiguration.getInstance().getApplicationFramework().name());
        map.put("instrumentation.version", AgentConfiguration.getInstance().getApplicationFrameworkVersion());
        map.put("collector.name", "AndroidAgent");
        AnalyticsControllerImpl analyticsControllerImpl = AnalyticsControllerImpl.getInstance();
        HashMap map2 = new HashMap();
        for (AnalyticsAttribute analyticsAttribute : analyticsControllerImpl.getSessionAttributes()) {
            map2.put(analyticsAttribute.getName(), analyticsAttribute.asJsonElement());
        }
        map.putAll(map2);
        return map;
    }

    public void appendToWorkingLogfile(Map<String, Object> map) throws IOException {
        try {
            try {
                ReentrantLock reentrantLock = workingFileLock;
                reentrantLock.lock();
                String json = gson.toJson(map, gtype);
                if (this.workingLogfileWriter.get() != null) {
                    this.workingLogfileWriter.get().append((CharSequence) json);
                    this.workingLogfileWriter.get().newLine();
                }
                reentrantLock.unlock();
            } catch (Exception e) {
                e.printStackTrace();
                workingFileLock.unlock();
            }
        } catch (Throwable th) {
            workingFileLock.unlock();
            throw th;
        }
    }

    void shutdown() {
        if (this.isStarted.get()) {
            stop();
        }
        log.info("LogReporting: reporter instance has been shutdown");
    }

    Map<String, String> logFileNameAsParts(File file) {
        HashMap map = new HashMap();
        Matcher matcher = LOG_FILE_REGEX.matcher(file.getAbsolutePath());
        if (matcher.matches()) {
            if (3 > matcher.groupCount()) {
                log.error("LogReporter: Couldn't determine log filename components. " + file.getAbsolutePath());
            } else {
                map.put("path", matcher.group(1));
                map.put("file", matcher.group(2));
                map.put("extension", matcher.group(3));
            }
        }
        return map;
    }

    boolean isLogfileTypeOf(File file, LogReportState logReportState) {
        return logFileNameAsParts(file).getOrDefault("extension", "").equals(logReportState.extension);
    }

    LogReportState typeOfLogfile(File file) throws IOException {
        final String orDefault = logFileNameAsParts(file).getOrDefault("extension", "");
        if (orDefault == null || orDefault.isEmpty()) {
            throw new IOException("LogReporter:  Could not parse the log file name. " + file.getAbsolutePath());
        }
        return (LogReportState) Arrays.stream(LogReportState.values()).filter(new Predicate() { // from class: com.newrelic.agent.android.logging.LogReporter$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((LogReporter.LogReportState) obj).extension.equals(orDefault);
            }
        }).findFirst().get();
    }

    static JsonArray logfileToJsonArray(File file) throws IOException {
        return logfileToJsonArray(file, new JsonArray());
    }

    static JsonArray logfileToJsonArray(File file, JsonArray jsonArray) throws IOException {
        final JsonArray jsonArray2 = new JsonArray();
        JsonObject jsonObject = new JsonObject();
        JsonObject asJsonObject = gson.toJsonTree(getCommonBlockAttributes()).getAsJsonObject();
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.add(C4352k.a.f5654h, asJsonObject);
        jsonObject.add("common", jsonObject2);
        BufferedReader bufferedReaderNewBufferedFileReader = Streams.newBufferedFileReader(file);
        try {
            bufferedReaderNewBufferedFileReader.lines().forEach(new Consumer() { // from class: com.newrelic.agent.android.logging.LogReporter$$ExternalSyntheticLambda6
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    LogReporter.lambda$logfileToJsonArray$6(jsonArray2, (String) obj);
                }
            });
            if (bufferedReaderNewBufferedFileReader != null) {
                bufferedReaderNewBufferedFileReader.close();
            }
            jsonObject.add("logs", jsonArray2);
            jsonArray.add(jsonObject);
            return jsonArray;
        } catch (Throwable th) {
            if (bufferedReaderNewBufferedFileReader != null) {
                try {
                    bufferedReaderNewBufferedFileReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    static /* synthetic */ void lambda$logfileToJsonArray$6(JsonArray jsonArray, String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        try {
            jsonArray.add((JsonObject) gson.fromJson(str, JsonObject.class));
        } catch (JsonSyntaxException unused) {
            log.error("Invalid Json entry skipped [" + str + "]");
        }
    }

    static File jsonArrayToLogfile(JsonArray jsonArray, File file) throws IOException {
        if (file == null) {
            file = generateUniqueLogfile(LogReportState.CLOSED);
        }
        BufferedWriter bufferedWriterNewBufferedFileWriter = Streams.newBufferedFileWriter(file);
        try {
            bufferedWriterNewBufferedFileWriter.write(jsonArray.toString());
            bufferedWriterNewBufferedFileWriter.flush();
            bufferedWriterNewBufferedFileWriter.close();
            file.setReadOnly();
            if (bufferedWriterNewBufferedFileWriter != null) {
                bufferedWriterNewBufferedFileWriter.close();
            }
            return file;
        } catch (Throwable th) {
            if (bufferedWriterNewBufferedFileWriter != null) {
                try {
                    bufferedWriterNewBufferedFileWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
