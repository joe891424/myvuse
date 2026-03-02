package com.newrelic.agent.android.ndk;

import android.content.Context;
import android.util.Log;
import com.facebook.react.uimanager.ViewProps;
import com.newrelic.agent.android.agentdata.HexAttribute;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.ConsoleAgentLog;
import com.newrelic.agent.android.stats.StatsEngine;
import com.scottyab.rootbeer.RootBeer;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetch;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p099io.FilesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AgentNDK.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0086 J\t\u0010\u000b\u001a\u00020\nH\u0086 J\u0006\u0010\f\u001a\u00020\bJ\t\u0010\r\u001a\u00020\nH\u0086 J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0011\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0003H\u0086 J\u0015\u0010\u0012\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0086 J\t\u0010\u0013\u001a\u00020\u000fH\u0086 J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0004J\u0006\u0010\u0017\u001a\u00020\u000fJ\u0006\u0010\u0018\u001a\u00020\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001b"}, m5598d2 = {"Lcom/newrelic/agent/android/ndk/AgentNDK;", "", "managedContext", "Lcom/newrelic/agent/android/ndk/ManagedContext;", "(Lcom/newrelic/agent/android/ndk/ManagedContext;)V", "getManagedContext", "()Lcom/newrelic/agent/android/ndk/ManagedContext;", "crashNow", "", HexAttribute.HEX_ATTR_CAUSE, "", "dumpStack", "flushPendingReports", "getProcessStat", "isRooted", "", "nativeSetContext", "context", "nativeStart", "nativeStop", "postReport", "report", "Ljava/io/File;", "start", BackgroundFetch.ACTION_STOP, "Builder", "Companion", "agent-ndk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class AgentNDK {
    private static volatile AgentNDK agentNdk;
    private final ManagedContext managedContext;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ReentrantLock lock = new ReentrantLock();
    private static volatile AgentLog log = new ConsoleAgentLog();

    /* JADX WARN: Multi-variable type inference failed */
    public AgentNDK() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @JvmStatic
    public static final AgentNDK getInstance() {
        return INSTANCE.getInstance();
    }

    @JvmStatic
    public static final boolean loadAgent() {
        return INSTANCE.loadAgent();
    }

    public final native void crashNow(String cause);

    public final native String dumpStack();

    public final native String getProcessStat();

    public final native void nativeSetContext(ManagedContext context);

    public final native boolean nativeStart(ManagedContext context);

    public final native boolean nativeStop();

    public AgentNDK(ManagedContext managedContext) {
        this.managedContext = managedContext;
    }

    public /* synthetic */ AgentNDK(ManagedContext managedContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ManagedContext(null, 1, null) : managedContext);
    }

    public final ManagedContext getManagedContext() {
        return this.managedContext;
    }

    public static /* synthetic */ boolean nativeStart$default(AgentNDK agentNDK, ManagedContext managedContext, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nativeStart");
        }
        if ((i & 1) != 0) {
            managedContext = null;
        }
        return agentNDK.nativeStart(managedContext);
    }

    public static /* synthetic */ void crashNow$default(AgentNDK agentNDK, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: crashNow");
        }
        if ((i & 1) != 0) {
            str = "This is a demonstration native crash courtesy of New Relic";
        }
        agentNDK.crashNow(str);
    }

    /* JADX INFO: compiled from: AgentNDK.kt */
    @Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, m5598d2 = {"Lcom/newrelic/agent/android/ndk/AgentNDK$Companion;", "", "()V", "agentNdk", "Lcom/newrelic/agent/android/ndk/AgentNDK;", "getAgentNdk", "()Lcom/newrelic/agent/android/ndk/AgentNDK;", "setAgentNdk", "(Lcom/newrelic/agent/android/ndk/AgentNDK;)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "log", "Lcom/newrelic/agent/android/logging/AgentLog;", "getLog", "()Lcom/newrelic/agent/android/logging/AgentLog;", "setLog", "(Lcom/newrelic/agent/android/logging/AgentLog;)V", "getInstance", "loadAgent", "", "AnalyticsAttribute", "MetricNames", "agent-ndk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: AgentNDK.kt */
        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b`\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/newrelic/agent/android/ndk/AgentNDK$Companion$AnalyticsAttribute;", "", "Companion", "agent-ndk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public interface AnalyticsAttribute {
            public static final String APPLICATION_NOT_RESPONDING_ATTRIBUTE = "ANR";
            public static final String APPLICATION_PLATFORM_ATTRIBUTE = "platform";

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = Companion.$$INSTANCE;

            /* JADX INFO: compiled from: AgentNDK.kt */
            @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m5598d2 = {"Lcom/newrelic/agent/android/ndk/AgentNDK$Companion$AnalyticsAttribute$Companion;", "", "()V", "APPLICATION_NOT_RESPONDING_ATTRIBUTE", "", "APPLICATION_PLATFORM_ATTRIBUTE", "agent-ndk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class Companion {
                static final /* synthetic */ Companion $$INSTANCE = new Companion();
                public static final String APPLICATION_NOT_RESPONDING_ATTRIBUTE = "ANR";
                public static final String APPLICATION_PLATFORM_ATTRIBUTE = "platform";

                private Companion() {
                }
            }
        }

        private Companion() {
        }

        /* JADX INFO: compiled from: AgentNDK.kt */
        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b`\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/newrelic/agent/android/ndk/AgentNDK$Companion$MetricNames;", "", "Companion", "agent-ndk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public interface MetricNames {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = Companion.$$INSTANCE;
            public static final String SUPPORTABILITY_ANR_DETECTED = "Supportability/AgentHealth/NativeReporting/ANR/Detected";
            public static final String SUPPORTABILITY_NATIVE_CRASH = "Supportability/AgentHealth/NativeReporting/Crash";
            public static final String SUPPORTABILITY_NATIVE_LOAD_ERR = "Supportability/AgentHealth/NativeReporting/Error/LoadLibrary";
            public static final String SUPPORTABILITY_NATIVE_ROOT = "Supportability/AgentHealth/NativeReporting";

            /* JADX INFO: compiled from: AgentNDK.kt */
            @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m5598d2 = {"Lcom/newrelic/agent/android/ndk/AgentNDK$Companion$MetricNames$Companion;", "", "()V", "SUPPORTABILITY_ANR_DETECTED", "", "SUPPORTABILITY_NATIVE_CRASH", "SUPPORTABILITY_NATIVE_LOAD_ERR", "SUPPORTABILITY_NATIVE_ROOT", "agent-ndk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class Companion {
                static final /* synthetic */ Companion $$INSTANCE = new Companion();
                public static final String SUPPORTABILITY_ANR_DETECTED = "Supportability/AgentHealth/NativeReporting/ANR/Detected";
                public static final String SUPPORTABILITY_NATIVE_CRASH = "Supportability/AgentHealth/NativeReporting/Crash";
                public static final String SUPPORTABILITY_NATIVE_LOAD_ERR = "Supportability/AgentHealth/NativeReporting/Error/LoadLibrary";
                public static final String SUPPORTABILITY_NATIVE_ROOT = "Supportability/AgentHealth/NativeReporting";

                private Companion() {
                }
            }
        }

        public final ReentrantLock getLock() {
            return AgentNDK.lock;
        }

        public final AgentLog getLog() {
            return AgentNDK.log;
        }

        public final void setLog(AgentLog agentLog) {
            Intrinsics.checkNotNullParameter(agentLog, "<set-?>");
            AgentNDK.log = agentLog;
        }

        public final AgentNDK getAgentNdk() {
            return AgentNDK.agentNdk;
        }

        public final void setAgentNdk(AgentNDK agentNDK) {
            AgentNDK.agentNdk = agentNDK;
        }

        @JvmStatic
        public final boolean loadAgent() {
            try {
                System.loadLibrary("agent-ndk");
                getLog().info("Agent NDK loaded");
                StatsEngine.get().inc("Supportability/AgentHealth/NativeReporting/Crash");
                return true;
            } catch (Exception e) {
                getLog().error(Intrinsics.stringPlus("Agent NDK load failed: ", e.getLocalizedMessage()));
                StatsEngine.get().inc("Supportability/AgentHealth/NativeReporting/Error/LoadLibrary");
                return false;
            } catch (UnsatisfiedLinkError e2) {
                getLog().error(Intrinsics.stringPlus("Agent NDK load failed: ", e2.getLocalizedMessage()));
                StatsEngine.get().inc("Supportability/AgentHealth/NativeReporting/Error/LoadLibrary");
                return false;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public final AgentNDK getInstance() {
            AgentNDK agentNdk = getAgentNdk();
            if (agentNdk == null) {
                synchronized (this) {
                    agentNdk = AgentNDK.INSTANCE.getAgentNdk();
                    if (agentNdk == null) {
                        agentNdk = new AgentNDK(null, 1, 0 == true ? 1 : 0);
                        AgentNDK.INSTANCE.setAgentNdk(agentNdk);
                    }
                }
            }
            return agentNdk;
        }
    }

    public final boolean start() throws ExecutionException, InterruptedException {
        ManagedContext managedContext = this.managedContext;
        if (managedContext != null && managedContext.getAnrMonitor()) {
            ANRMonitor.INSTANCE.getInstance().startMonitor();
            Log.d("AgentNDK", "Main thread ANR monitor started");
        }
        ManagedContext managedContext2 = this.managedContext;
        Intrinsics.checkNotNull(managedContext2);
        return nativeStart(managedContext2);
    }

    public final boolean stop() throws ExecutionException, InterruptedException {
        ManagedContext managedContext = this.managedContext;
        if (managedContext != null && managedContext.getAnrMonitor()) {
            ANRMonitor.INSTANCE.getInstance().stopMonitor();
        }
        return nativeStop();
    }

    public final void flushPendingReports() {
        File reportsDir;
        Unit unit;
        lock.lock();
        try {
            ManagedContext managedContext = this.managedContext;
            Unit unit2 = null;
            if (managedContext != null && (reportsDir = managedContext.getReportsDir()) != null) {
                log.info("Flushing native reports from [" + ((Object) reportsDir.getAbsolutePath()) + ']');
                if (reportsDir.exists() && reportsDir.canRead()) {
                    File[] fileArrListFiles = reportsDir.listFiles();
                    if (fileArrListFiles != null) {
                        int length = fileArrListFiles.length;
                        int i = 0;
                        while (i < length) {
                            File report = fileArrListFiles[i];
                            i++;
                            try {
                                Intrinsics.checkNotNullExpressionValue(report, "report");
                            } catch (Exception e) {
                                log.warn("Failed to parse/write native report [" + ((Object) report.getName()) + ": " + e);
                            }
                            if (postReport(report)) {
                                log.info("Native report [" + ((Object) report.getName()) + "] submitted to New Relic");
                            } else {
                                long jCurrentTimeMillis = System.currentTimeMillis() - TimeUnit.MILLISECONDS.convert(getManagedContext().getExpirationPeriod(), TimeUnit.SECONDS);
                                if (report.exists() && report.lastModified() < jCurrentTimeMillis) {
                                    log.info("Native report [" + ((Object) report.getName()) + "] has expired, deleting...");
                                    report.deleteOnExit();
                                }
                            }
                        }
                        unit = Unit.INSTANCE;
                    }
                } else {
                    log.warn("Native report directory [" + ((Object) reportsDir.getAbsolutePath()) + "] does not exist or not readable");
                    unit = Unit.INSTANCE;
                }
                unit2 = unit;
            }
            if (unit2 == null) {
                AgentNDK agentNDK = this;
                log.warn("Report directory has not been provided");
            }
        } finally {
            lock.unlock();
        }
    }

    protected final boolean postReport(File report) {
        AgentNDKListener nativeReportListener;
        Intrinsics.checkNotNullParameter(report, "report");
        boolean zOnApplicationNotResponding = false;
        if (!report.exists()) {
            return false;
        }
        log.info("Posting native report data from [" + ((Object) report.getAbsolutePath()) + ']');
        ManagedContext managedContext = this.managedContext;
        if (managedContext != null && (nativeReportListener = managedContext.getNativeReportListener()) != null) {
            String name = report.getName();
            Intrinsics.checkNotNullExpressionValue(name, "report.name");
            if (StringsKt.startsWith(name, "crash-", true)) {
                zOnApplicationNotResponding = nativeReportListener.onNativeCrash(FilesKt.readText(report, Charsets.UTF_8));
            } else {
                String name2 = report.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "report.name");
                if (StringsKt.startsWith(name2, "ex-", true)) {
                    zOnApplicationNotResponding = nativeReportListener.onNativeException(FilesKt.readText(report, Charsets.UTF_8));
                } else {
                    String name3 = report.getName();
                    Intrinsics.checkNotNullExpressionValue(name3, "report.name");
                    if (StringsKt.startsWith(name3, "anr-", true)) {
                        zOnApplicationNotResponding = nativeReportListener.onApplicationNotResponding(FilesKt.readText(report, Charsets.UTF_8));
                    }
                }
            }
            if (zOnApplicationNotResponding) {
                if (report.delete()) {
                    log.debug("Deleted native report data [" + ((Object) report.getAbsolutePath()) + ']');
                } else {
                    log.error("Failed to delete native report [" + ((Object) report.getAbsolutePath()) + ']');
                }
            }
        }
        return !report.exists();
    }

    public final boolean isRooted() {
        ManagedContext managedContext = this.managedContext;
        return new RootBeer(managedContext == null ? null : managedContext.getContext()).isRooted();
    }

    /* JADX INFO: compiled from: AgentNDK.kt */
    @Metadata(m5597d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0014J\u0010\u0010!\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006$"}, m5598d2 = {"Lcom/newrelic/agent/android/ndk/AgentNDK$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "managedContext", "Lcom/newrelic/agent/android/ndk/ManagedContext;", "getManagedContext", "()Lcom/newrelic/agent/android/ndk/ManagedContext;", "setManagedContext", "(Lcom/newrelic/agent/android/ndk/ManagedContext;)V", "build", "Lcom/newrelic/agent/android/ndk/AgentNDK;", "withANRMonitor", ViewProps.ENABLED, "", "withBuildId", com.newrelic.agent.android.hybrid.data.HexAttribute.HEX_ATTR_JSERROR_BUILDID, "", "withExpiration", "expirationPeriod", "", "withLogger", "agentLog", "Lcom/newrelic/agent/android/logging/AgentLog;", "withManagedContext", "withReportListener", "ndkListener", "Lcom/newrelic/agent/android/ndk/AgentNDKListener;", "withSessionId", "sessionId", "withStorageDir", "storageRootDir", "Ljava/io/File;", "agent-ndk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Builder {
        private final Context context;
        private ManagedContext managedContext;

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.managedContext = new ManagedContext(context);
            AgentNDK.INSTANCE.loadAgent();
        }

        public final Context getContext() {
            return this.context;
        }

        public final ManagedContext getManagedContext() {
            return this.managedContext;
        }

        public final void setManagedContext(ManagedContext managedContext) {
            Intrinsics.checkNotNullParameter(managedContext, "<set-?>");
            this.managedContext = managedContext;
        }

        public final Builder withBuildId(String buildId) {
            Intrinsics.checkNotNullParameter(buildId, "buildId");
            this.managedContext.setBuildId(buildId);
            return this;
        }

        public final Builder withSessionId(String sessionId) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            this.managedContext.setSessionId(sessionId);
            return this;
        }

        public final Builder withStorageDir(File storageRootDir) {
            ManagedContext managedContext = this.managedContext;
            managedContext.setReportsDir(managedContext.getNativeReportsDir(storageRootDir));
            File reportsDir = this.managedContext.getReportsDir();
            if (reportsDir != null) {
                reportsDir.mkdirs();
            }
            return this;
        }

        public final Builder withReportListener(AgentNDKListener ndkListener) {
            Intrinsics.checkNotNullParameter(ndkListener, "ndkListener");
            this.managedContext.setNativeReportListener(ndkListener);
            return this;
        }

        public final Builder withManagedContext(ManagedContext managedContext) {
            Intrinsics.checkNotNullParameter(managedContext, "managedContext");
            this.managedContext = managedContext;
            return this;
        }

        public final Builder withExpiration(long expirationPeriod) {
            this.managedContext.setExpirationPeriod(expirationPeriod);
            return this;
        }

        public final Builder withLogger(AgentLog agentLog) {
            Intrinsics.checkNotNullParameter(agentLog, "agentLog");
            AgentNDK.INSTANCE.setLog(agentLog);
            return this;
        }

        public final Builder withANRMonitor(boolean enabled) {
            this.managedContext.setAnrMonitor(enabled);
            return this;
        }

        public final AgentNDK build() {
            File reportsDir = this.managedContext.getReportsDir();
            if (reportsDir != null) {
                reportsDir.mkdirs();
            }
            AgentNDK.INSTANCE.setAgentNdk(new AgentNDK(this.managedContext));
            return AgentNDK.INSTANCE.getInstance();
        }
    }
}
