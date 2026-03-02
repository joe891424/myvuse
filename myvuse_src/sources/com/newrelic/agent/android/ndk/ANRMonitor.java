package com.newrelic.agent.android.ndk;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.newrelic.agent.android.agentdata.AgentDataController;
import com.newrelic.agent.android.agentdata.HexAttribute;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.stats.StatsEngine;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: compiled from: ANRMonitor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 02\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"J\u001d\u0010#\u001a\u00020$2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&H\u0002¢\u0006\u0002\u0010(J\u0006\u0010)\u001a\u00020$J\u0015\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020,H\u0000¢\u0006\u0002\b-J\u0006\u0010.\u001a\u00020 J\u0006\u0010/\u001a\u00020 R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00061"}, m5598d2 = {"Lcom/newrelic/agent/android/ndk/ANRMonitor;", "", "()V", "anrMonitorRunner", "Ljava/lang/Runnable;", "getAnrMonitorRunner", "()Ljava/lang/Runnable;", "anrSampleCnt", "Ljava/util/concurrent/atomic/AtomicInteger;", "getAnrSampleCnt", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setAnrSampleCnt", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "executor", "Ljava/util/concurrent/ExecutorService;", "getExecutor", "()Ljava/util/concurrent/ExecutorService;", "future", "Ljava/util/concurrent/Future;", "getFuture", "()Ljava/util/concurrent/Future;", "setFuture", "(Ljava/util/concurrent/Future;)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "monitorThread", "Landroid/os/HandlerThread;", "getMonitorThread", "()Landroid/os/HandlerThread;", "createANRReport", "", "anrAsJson", "", "hasNativeStackFrames", "", "stackTrace", "", "Ljava/lang/StackTraceElement;", "([Ljava/lang/StackTraceElement;)Z", "isRunning", "reportWithRetry", "exception", "Lcom/newrelic/agent/android/ndk/NativeException;", "reportWithRetry$agent_ndk_release", "startMonitor", "stopMonitor", "Companion", "agent-ndk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class ANRMonitor {
    public static final int ANR_SAMPLE_CNT = 2;
    private static volatile ANRMonitor anrMonitor;
    private final Runnable anrMonitorRunner;
    private AtomicInteger anrSampleCnt;
    private final ExecutorService executor;
    private Future<?> future;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final HandlerThread monitorThread = new HandlerThread("NR-ANR-Monitor");

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long ANR_TIMEOUT = TimeUnit.MILLISECONDS.convert(6, TimeUnit.SECONDS);

    @JvmStatic
    public static final ANRMonitor getInstance() {
        return INSTANCE.getInstance();
    }

    @JvmStatic
    public static final ActivityManager.ProcessErrorStateInfo getProcessErrorStateInfoOrNull() {
        return INSTANCE.getProcessErrorStateInfoOrNull();
    }

    public ANRMonitor() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor()");
        this.executor = executorServiceNewSingleThreadExecutor;
        this.anrSampleCnt = new AtomicInteger(2);
        this.anrMonitorRunner = new Runnable() { // from class: com.newrelic.agent.android.ndk.ANRMonitor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ANRMonitor.m6374anrMonitorRunner$lambda1(this.f$0);
            }
        };
    }

    public final Future<?> getFuture() {
        return this.future;
    }

    public final void setFuture(Future<?> future) {
        this.future = future;
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final HandlerThread getMonitorThread() {
        return this.monitorThread;
    }

    public final ExecutorService getExecutor() {
        return this.executor;
    }

    public final AtomicInteger getAnrSampleCnt() {
        return this.anrSampleCnt;
    }

    public final void setAnrSampleCnt(AtomicInteger atomicInteger) {
        Intrinsics.checkNotNullParameter(atomicInteger, "<set-?>");
        this.anrSampleCnt = atomicInteger;
    }

    public final Runnable getAnrMonitorRunner() {
        return this.anrMonitorRunner;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: anrMonitorRunner$lambda-1, reason: not valid java name */
    public static final void m6374anrMonitorRunner$lambda1(ANRMonitor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.monitorThread.start();
        Companion.WaitableRunner waitableRunner = new Companion.WaitableRunner();
        while (!Thread.interrupted()) {
            synchronized (waitableRunner) {
                try {
                    try {
                    } catch (InterruptedException e) {
                        AgentNDK.INSTANCE.getLog().error(Intrinsics.stringPlus("ANR monitor caught ", e));
                    }
                    if (!this$0.getHandler().post(waitableRunner)) {
                        AgentNDK.INSTANCE.getLog().debug("Could not post the waitable runner to the main UI handler");
                        return;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long j = ANR_TIMEOUT;
                    waitableRunner.wait(j);
                    if (waitableRunner.inANRState()) {
                        if (this$0.getAnrSampleCnt().decrementAndGet() == 0) {
                            AgentNDK.INSTANCE.getLog().debug("ANR monitor is blocked, ANR detected");
                            createANRReport$default(this$0, null, 1, null);
                            this$0.getAnrSampleCnt().set(2);
                        }
                    } else {
                        Thread.sleep(Math.max(0L, j - (System.currentTimeMillis() - jCurrentTimeMillis)));
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                    waitableRunner.reset();
                }
            }
        }
        this$0.monitorThread.quitSafely();
    }

    public static /* synthetic */ void createANRReport$default(ANRMonitor aNRMonitor, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createANRReport");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        aNRMonitor.createANRReport(str);
    }

    public final void createANRReport(String anrAsJson) {
        StatsEngine.get().inc("Supportability/AgentHealth/NativeReporting/ANR/Detected");
        NativeException nativeException = new NativeException(anrAsJson);
        nativeException.setStackTrace(Looper.getMainLooper().getThread().getStackTrace());
        reportWithRetry$agent_ndk_release(nativeException);
    }

    private final boolean hasNativeStackFrames(StackTraceElement[] stackTrace) {
        StackTraceElement stackTraceElement;
        if (stackTrace == null) {
            return false;
        }
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                stackTraceElement = null;
                break;
            }
            stackTraceElement = stackTrace[i];
            i++;
            if (stackTraceElement.isNativeMethod()) {
                break;
            }
        }
        return stackTraceElement != null;
    }

    public final void reportWithRetry$agent_ndk_release(final NativeException exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        final Handler handler = new Handler(this.monitorThread.getLooper());
        final AtomicInteger atomicInteger = new AtomicInteger(10);
        final HashMap map = new HashMap();
        HashMap map2 = map;
        map2.put("platform", "native");
        map2.put("ANR", "true");
        Throwable cause = exception.getCause();
        if (cause != null) {
            map2.put(HexAttribute.HEX_ATTR_CAUSE, cause.getMessage());
        }
        NativeStackTrace nativeStackTrace = exception.getNativeStackTrace();
        if (nativeStackTrace != null) {
            NativeThreadInfo crashedThread = nativeStackTrace.getCrashedThread();
            if (crashedThread != null) {
                map2.put(AnalyticsAttribute.NATIVE_CRASHING_THREAD_ID_ATTRIBUTE, Long.valueOf(crashedThread.getThreadId()));
            }
            map2.put(AnalyticsAttribute.NATIVE_THREADS_ATTRIBUTE, nativeStackTrace.getThreads());
            String exceptionMessage = nativeStackTrace.getExceptionMessage();
            if (exceptionMessage != null) {
                map2.put(AnalyticsAttribute.NATIVE_EXCEPTION_MESSAGE_ATTRIBUTE, exceptionMessage);
            }
        }
        handler.post(new Runnable() { // from class: com.newrelic.agent.android.ndk.ANRMonitor$reportWithRetry$3
            @Override // java.lang.Runnable
            public void run() {
                ActivityManager.ProcessErrorStateInfo processErrorStateInfoOrNull = ANRMonitor.INSTANCE.getProcessErrorStateInfoOrNull();
                if (processErrorStateInfoOrNull != null) {
                    HashMap<String, Object> map3 = map;
                    AtomicInteger atomicInteger2 = atomicInteger;
                    HashMap<String, Object> map4 = map3;
                    map4.put("pid", Integer.valueOf(processErrorStateInfoOrNull.pid));
                    map4.put(AnalyticsAttribute.APP_EXIT_PROCESS_NAME_ATTRIBUTE, processErrorStateInfoOrNull.processName);
                    map4.put("shortMsg", processErrorStateInfoOrNull.shortMsg);
                    map4.put("longMsg", processErrorStateInfoOrNull.longMsg);
                    map4.put("stackTrace", processErrorStateInfoOrNull.stackTrace);
                    map4.put(HeaderParameterNames.AUTHENTICATION_TAG, processErrorStateInfoOrNull.tag);
                    int i = processErrorStateInfoOrNull.condition;
                    if (i == 1) {
                        map4.put(AnalyticsAttribute.APP_EXIT_REASON_ATTRIBUTE, 4);
                    } else if (i == 2) {
                        map4.put(AnalyticsAttribute.APP_EXIT_REASON_ATTRIBUTE, 6);
                    }
                    atomicInteger2.set(0);
                }
                if (atomicInteger.getAndDecrement() == 0) {
                    AgentNDK.INSTANCE.getLog().debug(exception.toString());
                    AgentNDK.INSTANCE.getLog().debug("ANR monitor notified. Posting ANR report as handled exception[" + ((Object) exception.getClass().getSimpleName()) + ']');
                    if (!AgentDataController.sendAgentData(exception, map)) {
                        exception.printStackTrace();
                    }
                    AgentNDK.INSTANCE.getLog().debug("ANR report created");
                    return;
                }
                handler.postDelayed(this, 500L);
            }
        });
    }

    public final void startMonitor() throws ExecutionException, InterruptedException {
        if (isRunning()) {
            stopMonitor();
        }
        this.future = this.executor.submit(this.anrMonitorRunner);
        AgentNDK.INSTANCE.getLog().debug("ANR monitor started with [" + ANR_TIMEOUT + "] ms delay");
    }

    public final void stopMonitor() throws ExecutionException, InterruptedException {
        Future<?> future;
        Future<?> future2 = this.future;
        if (future2 != null) {
            future2.cancel(true);
        }
        Future<?> future3 = this.future;
        if (Intrinsics.areEqual((Object) (future3 == null ? null : Boolean.valueOf(future3.isDone())), (Object) false) && (future = this.future) != null) {
            future.get();
        }
        if (this.future != null) {
            setFuture(null);
        }
        AgentNDK.INSTANCE.getLog().debug("ANR monitor stopped");
    }

    public final boolean isRunning() {
        Future<?> future = this.future;
        return (future == null || future.isCancelled() || future.isDone()) ? false : true;
    }

    /* JADX INFO: compiled from: ANRMonitor.kt */
    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\nH\u0007J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, m5598d2 = {"Lcom/newrelic/agent/android/ndk/ANRMonitor$Companion;", "", "()V", "ANR_SAMPLE_CNT", "", "ANR_TIMEOUT", "", "getANR_TIMEOUT", "()J", "anrMonitor", "Lcom/newrelic/agent/android/ndk/ANRMonitor;", "getAnrMonitor", "()Lcom/newrelic/agent/android/ndk/ANRMonitor;", "setAnrMonitor", "(Lcom/newrelic/agent/android/ndk/ANRMonitor;)V", "getInstance", "getProcessErrorStateInfoOrNull", "Landroid/app/ActivityManager$ProcessErrorStateInfo;", "WaitableRunner", "agent-ndk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getANR_TIMEOUT() {
            return ANRMonitor.ANR_TIMEOUT;
        }

        public final ANRMonitor getAnrMonitor() {
            return ANRMonitor.anrMonitor;
        }

        public final void setAnrMonitor(ANRMonitor aNRMonitor) {
            ANRMonitor.anrMonitor = aNRMonitor;
        }

        @JvmStatic
        public final ANRMonitor getInstance() {
            ANRMonitor anrMonitor = getAnrMonitor();
            if (anrMonitor == null) {
                synchronized (this) {
                    anrMonitor = ANRMonitor.INSTANCE.getAnrMonitor();
                    if (anrMonitor == null) {
                        anrMonitor = new ANRMonitor();
                        ANRMonitor.INSTANCE.setAnrMonitor(anrMonitor);
                    }
                }
            }
            return anrMonitor;
        }

        @JvmStatic
        public final ActivityManager.ProcessErrorStateInfo getProcessErrorStateInfoOrNull() {
            Object objM7233constructorimpl;
            Object next;
            try {
                Result.Companion companion = Result.INSTANCE;
                Companion companion2 = this;
                ManagedContext managedContext = AgentNDK.INSTANCE.getInstance().getManagedContext();
                Context context = managedContext == null ? null : managedContext.getContext();
                Intrinsics.checkNotNull(context);
                Object systemService = context.getSystemService("activity");
                objM7233constructorimpl = Result.m7233constructorimpl(systemService instanceof ActivityManager ? (ActivityManager) systemService : null);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM7233constructorimpl = Result.m7233constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m7239isFailureimpl(objM7233constructorimpl)) {
                objM7233constructorimpl = null;
            }
            ActivityManager activityManager = (ActivityManager) objM7233constructorimpl;
            if (activityManager != null) {
                try {
                    List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                    if (processesInErrorState != null) {
                        Iterator<T> it2 = processesInErrorState.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it2.next();
                            if (((ActivityManager.ProcessErrorStateInfo) next).pid == Process.myPid()) {
                                break;
                            }
                        }
                        return (ActivityManager.ProcessErrorStateInfo) next;
                    }
                } catch (Exception e) {
                    AgentNDK.INSTANCE.getLog().error(e.toString());
                }
            }
            return null;
        }

        /* JADX INFO: compiled from: ANRMonitor.kt */
        @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000f"}, m5598d2 = {"Lcom/newrelic/agent/android/ndk/ANRMonitor$Companion$WaitableRunner;", "Ljava/lang/Object;", "Ljava/lang/Runnable;", "()V", "signaled", "", "getSignaled", "()Z", "setSignaled", "(Z)V", "blocked", "inANRState", "reset", "", "run", "agent-ndk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class WaitableRunner implements Runnable {
            private boolean signaled;

            public final boolean getSignaled() {
                return this.signaled;
            }

            public final void setSignaled(boolean z) {
                this.signaled = z;
            }

            @Override // java.lang.Runnable
            public synchronized void run() {
                this.signaled = true;
                notify();
            }

            public final synchronized boolean blocked() {
                return !this.signaled;
            }

            public final synchronized void reset() {
                this.signaled = false;
                notifyAll();
            }

            public final boolean inANRState() {
                ActivityManager.ProcessErrorStateInfo processErrorStateInfoOrNull;
                return blocked() && (processErrorStateInfoOrNull = ANRMonitor.INSTANCE.getProcessErrorStateInfoOrNull()) != null && processErrorStateInfoOrNull.condition == 2;
            }
        }
    }
}
