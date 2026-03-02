package kotlinx.atomicfu;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.util.Constants;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.LockSupport;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: LockFreedomTestEnvironment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002@AB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\"\u001a\u00020\u00052\n\u0010#\u001a\u00060\u001bR\u00020\u0000H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J\b\u0010%\u001a\u00020\u0013H\u0002J\u0012\u0010&\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0003H\u0002J\b\u0010+\u001a\u00020\u0005H\u0002J\u0014\u0010\u0010\u001a\u00020\u00132\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u001e\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u00052\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u0014\u00100\u001a\u00020\u00132\n\u0010#\u001a\u00060\u001bR\u00020\u0000H\u0002J\b\u00101\u001a\u00020\u0013H\u0002J\b\u00102\u001a\u00020\u0003H\u0002J\u0010\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u000205H\u0002J\r\u00106\u001a\u00020\u0013H\u0000¢\u0006\u0002\b7JK\u00108\u001a\u00060\u001bR\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032+\u00109\u001a'\b\u0001\u0012\b\u0012\u00060\u001bR\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130;\u0012\u0006\u0012\u0004\u0018\u00010\u00010:¢\u0006\u0002\b<ø\u0001\u0000¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020\u00132\u0006\u0010?\u001a\u000205H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00060\fR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u001bR\u00020\u00000\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\f\u0012\b\u0012\u00060\u001bR\u00020\u00000\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0 X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, m5598d2 = {"Lkotlinx/atomicfu/LockFreedomTestEnvironment;", "", "name", "", "allowSuspendedThreads", "", "(Ljava/lang/String;I)V", "completed", "", "globalPauseProgress", "Ljava/util/concurrent/atomic/AtomicInteger;", "interceptor", "Lkotlinx/atomicfu/LockFreedomTestEnvironment$Interceptor;", "isActive", "isCompleted", "()Z", "onCompletion", "", "Lkotlin/Function0;", "", "performedOps", "Ljava/util/concurrent/atomic/LongAdder;", "performedResumes", "started", "status", "suspendedThreads", "Ljava/util/ArrayList;", "Lkotlinx/atomicfu/LockFreedomTestEnvironment$TestThread;", AnalyticsAttribute.APP_EXIT_THREADS_ATTRIBUTE, "ueh", "Ljava/lang/Thread$UncaughtExceptionHandler;", "uncaughtException", "Ljava/util/concurrent/atomic/AtomicReference;", "", "addSuspended", "thread", "checkStalled", "complete", "composeThreadName", "threadName", "dumpThreadsError", "", "message", "getPausedEpoch", "block", "performTest", "seconds", "progress", "removeSuspended", "resumeImpl", "resumeStr", "shutdown", "shutdownDeadline", "", "step", "step$atomicfu", "testThread", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)Lkotlinx/atomicfu/LockFreedomTestEnvironment$TestThread;", "waitUntil", "nextTime", "Interceptor", "TestThread", "atomicfu"}, m5599k = 1, m5600mv = {1, 4, 3})
public class LockFreedomTestEnvironment {
    private final int allowSuspendedThreads;
    private volatile boolean completed;
    private final AtomicInteger globalPauseProgress;
    private final Interceptor interceptor;
    private volatile boolean isActive;
    private final String name;
    private final List<Function0<Unit>> onCompletion;
    private final LongAdder performedOps;
    private int performedResumes;
    private boolean started;
    private final AtomicInteger status;
    private final ArrayList<TestThread> suspendedThreads;
    private final List<TestThread> threads;
    private final Thread.UncaughtExceptionHandler ueh;
    private final AtomicReference<Throwable> uncaughtException;

    public LockFreedomTestEnvironment(String name, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.allowSuspendedThreads = i;
        this.interceptor = new Interceptor();
        this.threads = new ArrayList();
        this.performedOps = new LongAdder();
        this.uncaughtException = new AtomicReference<>();
        this.onCompletion = new ArrayList();
        this.ueh = new Thread.UncaughtExceptionHandler() { // from class: kotlinx.atomicfu.LockFreedomTestEnvironment$ueh$1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th) {
                PrintStream printStream = System.out;
                Intrinsics.checkNotNullExpressionValue(printStream, "System.out");
                synchronized (printStream) {
                    System.out.println((Object) ("Uncaught exception in thread " + thread));
                    th.printStackTrace(System.out);
                    PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m1161m(this.this$0.uncaughtException, null, th);
                    Unit unit = Unit.INSTANCE;
                }
            }
        };
        this.status = new AtomicInteger();
        this.globalPauseProgress = new AtomicInteger();
        this.suspendedThreads = new ArrayList<>();
        this.isActive = true;
    }

    public /* synthetic */ LockFreedomTestEnvironment(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 0 : i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void performTest$default(LockFreedomTestEnvironment lockFreedomTestEnvironment, int i, Function0 function0, int i2, Object obj) throws Throwable {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: performTest");
        }
        if ((i2 & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: kotlinx.atomicfu.LockFreedomTestEnvironment.performTest.1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        lockFreedomTestEnvironment.performTest(i, function0);
    }

    public final void performTest(int seconds, Function0<Unit> progress) throws Throwable {
        Intrinsics.checkNotNullParameter(progress, "progress");
        if (!this.isActive) {
            throw new IllegalStateException("Can perform test at most once on this instance".toString());
        }
        System.out.println((Object) ("=== " + this.name));
        int i = this.allowSuspendedThreads + 2;
        int i2 = 0;
        if (!(this.threads.size() >= i)) {
            throw new IllegalStateException(("Must define at least " + i + " test threads").toString());
        }
        InterceptorKt.lockAndSetInterceptor(this.interceptor);
        this.started = true;
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (TestThread testThread : this.threads) {
            testThread.setUncaughtExceptionHandler(this.ueh);
            testThread.setLastOpTime$atomicfu(jCurrentTimeMillis);
            testThread.start();
        }
        while (this.uncaughtException.get() == null) {
            try {
                waitUntil(jCurrentTimeMillis);
                System.out.println((Object) ("--- " + i2 + ": Performed " + this.performedOps.sum() + " operations" + resumeStr()));
                progress.invoke();
                checkStalled();
                i2++;
                if (i2 > seconds) {
                    break;
                } else {
                    jCurrentTimeMillis += 1000;
                }
            } catch (Throwable th) {
                complete();
                throw th;
            }
        }
        complete();
        System.out.println((Object) ("------ Done with " + this.performedOps.sum() + " operations" + resumeStr()));
        progress.invoke();
    }

    private final void complete() throws Throwable {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long jCurrentTimeMillis = System.currentTimeMillis() + 15000;
        try {
            this.completed = true;
            Iterator<T> it2 = this.onCompletion.iterator();
            while (it2.hasNext()) {
                ((Function0) it2.next()).invoke();
            }
            this.isActive = false;
            while (System.currentTimeMillis() < jCurrentTimeMillis) {
                linkedHashMap.clear();
                for (TestThread testThread : this.threads) {
                    if (!testThread.isAlive()) {
                        testThread.makeProgress$atomicfu(getPausedEpoch());
                    } else if ((~testThread.getIndex()) != this.status.get()) {
                        StackTraceElement[] stackTrace = testThread.getStackTrace();
                        if (testThread.isAlive()) {
                            Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
                            linkedHashMap.put(testThread, stackTrace);
                        }
                    }
                }
                if (linkedHashMap.isEmpty()) {
                    break;
                }
                checkStalled();
                Thread.sleep(10L);
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                TestThread testThread2 = (TestThread) entry.getKey();
                StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) entry.getValue();
                System.out.println((Object) ("=== " + testThread2 + " had failed to shutdown in time"));
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    System.out.println((Object) ("\tat " + stackTraceElement));
                }
            }
            shutdown(jCurrentTimeMillis);
            if (!linkedHashMap.isEmpty()) {
                throw new IllegalStateException("Some threads had failed to shutdown in time".toString());
            }
        } catch (Throwable th) {
            shutdown(jCurrentTimeMillis);
            throw th;
        }
    }

    private final void shutdown(long shutdownDeadline) throws Throwable {
        Object next;
        int andSet = this.status.getAndSet(Integer.MAX_VALUE);
        if (andSet < 0) {
            LockSupport.unpark(this.threads.get(~andSet));
        }
        for (TestThread testThread : this.threads) {
            long jCurrentTimeMillis = shutdownDeadline - System.currentTimeMillis();
            if (jCurrentTimeMillis > 0) {
                testThread.join(jCurrentTimeMillis);
            }
        }
        Iterator<T> it2 = this.threads.iterator();
        while (it2.hasNext()) {
            ((TestThread) it2.next()).abortWait();
        }
        InterceptorKt.unlockAndResetInterceptor(this.interceptor);
        Throwable th = this.uncaughtException.get();
        if (th != null) {
            throw th;
        }
        Iterator<T> it3 = this.threads.iterator();
        while (true) {
            if (it3.hasNext()) {
                next = it3.next();
                if (((TestThread) next).isAlive()) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        TestThread testThread2 = (TestThread) next;
        if (testThread2 == null) {
            return;
        }
        dumpThreadsError("A thread is still alive: " + testThread2);
        throw new KotlinNothingValueException();
    }

    private final void checkStalled() {
        long jCurrentTimeMillis = System.currentTimeMillis() - 15000;
        List<TestThread> list = this.threads;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((TestThread) obj).getLastOpTime() < jCurrentTimeMillis) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder("Progress stalled in threads ");
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((TestThread) it2.next()).getName());
        }
        dumpThreadsError(sb.append(arrayList4).toString());
        throw new KotlinNothingValueException();
    }

    private final String resumeStr() {
        int i = this.performedResumes;
        return i == 0 ? "" : " (pause/resumes " + i + ')';
    }

    private final void waitUntil(long nextTime) throws InterruptedException {
        while (true) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis >= nextTime) {
                return;
            } else {
                Thread.sleep(nextTime - jCurrentTimeMillis);
            }
        }
    }

    private final Void dumpThreadsError(String message) {
        List<TestThread> list = this.threads;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (TestThread testThread : list) {
            Pair pairM5605to = TuplesKt.m5605to(testThread, testThread.getStackTrace());
            linkedHashMap.put(pairM5605to.getFirst(), pairM5605to.getSecond());
        }
        System.out.println((Object) ("!!! " + message));
        System.out.println((Object) "=== Dumping live thread stack traces");
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            TestThread testThread2 = (TestThread) entry.getKey();
            StackTraceElement[] trace = (StackTraceElement[]) entry.getValue();
            Intrinsics.checkNotNullExpressionValue(trace, "trace");
            if (trace.length != 0) {
                System.out.println((Object) ("Thread \"" + testThread2.getName() + "\" " + testThread2.getState()));
                for (StackTraceElement t : trace) {
                    StringBuilder sb = new StringBuilder("\tat ");
                    Intrinsics.checkNotNullExpressionValue(t, "t");
                    System.out.println((Object) sb.append(t.getClassName()).append('.').append(t.getMethodName()).append('(').append(t.getFileName()).append(':').append(t.getLineNumber()).append(')').toString());
                }
                System.out.println();
            }
        }
        System.out.println((Object) "===");
        throw new IllegalStateException(message.toString());
    }

    /* JADX INFO: renamed from: isCompleted, reason: from getter */
    public final boolean getCompleted() {
        return this.completed;
    }

    public final void onCompletion(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.onCompletion.add(block);
    }

    public static /* synthetic */ TestThread testThread$default(LockFreedomTestEnvironment lockFreedomTestEnvironment, String str, Function2 function2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: testThread");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return lockFreedomTestEnvironment.testThread(str, function2);
    }

    public final TestThread testThread(String name, Function2<? super TestThread, ? super Continuation<? super Unit>, ? extends Object> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return new TestThread(this, name, operation);
    }

    /* JADX INFO: compiled from: LockFreedomTestEnvironment.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0004\u0018\u00002\u00020\u0001BA\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012+\u0010\u0004\u001a'\b\u0001\u0012\b\u0012\u00060\u0000R\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\b\nø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0006\u0010(\u001a\u00020\bJ\b\u0010)\u001a\u00020\bH\u0001J\b\u0010*\u001a\u00020\bH\u0001J\b\u0010+\u001a\u00020\bH\u0002J\b\u0010,\u001a\u00020\bH\u0002J\b\u0010-\u001a\u00020\bH\u0002J%\u0010.\u001a\u0002H/\"\u0004\b\u0000\u0010/2\f\u00100\u001a\b\u0012\u0004\u0012\u0002H/01H\u0086\bø\u0001\u0003¢\u0006\u0002\u00102J\u0015\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\u000fH\u0000¢\u0006\u0002\b5J\r\u00106\u001a\u00020\bH\u0000¢\u0006\u0002\b7J\u0006\u00108\u001a\u00020\bJ2\u00109\u001a\u00020\b2\u000e\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0$2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007H\u0002ø\u0001\u0000¢\u0006\u0002\u0010:J\b\u0010;\u001a\u00020\bH\u0016J\r\u0010<\u001a\u00020\bH\u0000¢\u0006\u0002\b=J\u0012\u0010>\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007H\u0002J \u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0$H\u0002ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b@\u0010AJ\b\u0010B\u001a\u00020\bH\u0002R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R8\u0010\u0004\u001a'\b\u0001\u0012\b\u0012\u00060\u0000R\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\b\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010$X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0016\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006C"}, m5598d2 = {"Lkotlinx/atomicfu/LockFreedomTestEnvironment$TestThread;", "Ljava/lang/Thread;", "name", "", "operation", "Lkotlin/Function2;", "Lkotlinx/atomicfu/LockFreedomTestEnvironment;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/atomicfu/LockFreedomTestEnvironment;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "completion", "continuation", FirebaseAnalytics.Param.INDEX, "", "getIndex$atomicfu", "()I", "interceptor", "Lkotlin/coroutines/CoroutineContext;", "lastOpTime", "", "getLastOpTime$atomicfu", "()J", "setLastOpTime$atomicfu", "(J)V", "Lkotlin/jvm/functions/Function2;", "operationEpoch", "pausedEpoch", "getPausedEpoch$atomicfu", "setPausedEpoch$atomicfu", "(I)V", "progressEpoch", "random", "Ljava/util/Random;", "result", "Lkotlin/Result;", "runningOperation", "", "sink", "abortWait", "afterLockFreeOperation", "beforeLockFreeOperation", "beginRunningOperation", "callOperation", "doneRunningOperation", "intermission", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "makeProgress", "epoch", "makeProgress$atomicfu", "pauseImpl", "pauseImpl$atomicfu", "randomSpinWaitIntermission", "resumeWith", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "run", "stepImpl", "stepImpl$atomicfu", "takeContinuation", "waitForResult", "waitForResult-d1pmJ48", "()Ljava/lang/Object;", "waitUntilCompletion", "atomicfu"}, m5599k = 1, m5600mv = {1, 4, 3})
    public final class TestThread extends Thread {
        private final Continuation<Unit> completion;
        private Continuation<Object> continuation;
        private final int index;
        private final CoroutineContext interceptor;
        private volatile long lastOpTime;
        private final Function2<TestThread, Continuation<? super Unit>, Object> operation;
        private int operationEpoch;
        private volatile int pausedEpoch;
        private int progressEpoch;
        private final Random random;
        private Result<? extends Object> result;
        private boolean runningOperation;
        private int sink;
        final /* synthetic */ LockFreedomTestEnvironment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public TestThread(LockFreedomTestEnvironment lockFreedomTestEnvironment, String str, Function2<? super TestThread, ? super Continuation<? super Unit>, ? extends Object> operation) {
            super(lockFreedomTestEnvironment.composeThreadName(str));
            Intrinsics.checkNotNullParameter(operation, "operation");
            this.this$0 = lockFreedomTestEnvironment;
            this.operation = operation;
            this.pausedEpoch = -1;
            this.random = new Random();
            this.operationEpoch = -1;
            this.progressEpoch = -1;
            if (!lockFreedomTestEnvironment.started) {
                this.index = lockFreedomTestEnvironment.threads.size();
                lockFreedomTestEnvironment.threads.add(this);
                final LockFreedomTestEnvironment$TestThread$interceptor$1 lockFreedomTestEnvironment$TestThread$interceptor$1 = new LockFreedomTestEnvironment$TestThread$interceptor$1(this, ContinuationInterceptor.INSTANCE);
                this.interceptor = lockFreedomTestEnvironment$TestThread$interceptor$1;
                this.completion = new Continuation<Unit>() { // from class: kotlinx.atomicfu.LockFreedomTestEnvironment$TestThread$$special$$inlined$Continuation$1
                    @Override // kotlin.coroutines.Continuation
                    /* JADX INFO: renamed from: getContext, reason: from getter */
                    public CoroutineContext get$context() {
                        return lockFreedomTestEnvironment$TestThread$interceptor$1;
                    }

                    @Override // kotlin.coroutines.Continuation
                    public void resumeWith(Object result) {
                        this.resumeWith(result, null);
                    }
                };
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }

        /* JADX INFO: renamed from: getIndex$atomicfu, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* JADX INFO: renamed from: getLastOpTime$atomicfu, reason: from getter */
        public final long getLastOpTime() {
            return this.lastOpTime;
        }

        public final void setLastOpTime$atomicfu(long j) {
            this.lastOpTime = j;
        }

        /* JADX INFO: renamed from: getPausedEpoch$atomicfu, reason: from getter */
        public final int getPausedEpoch() {
            return this.pausedEpoch;
        }

        public final void setPausedEpoch$atomicfu(int i) {
            this.pausedEpoch = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.this$0.isActive) {
                callOperation();
            }
        }

        public final <T> T intermission(Function0<? extends T> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            afterLockFreeOperation();
            try {
                return block.invoke();
            } finally {
                InlineMarker.finallyStart(1);
                beforeLockFreeOperation();
                InlineMarker.finallyEnd(1);
            }
        }

        public final void beforeLockFreeOperation() {
            this.operationEpoch = this.this$0.getPausedEpoch();
        }

        public final void afterLockFreeOperation() {
            makeProgress$atomicfu(this.operationEpoch);
            this.lastOpTime = System.currentTimeMillis();
            this.this$0.performedOps.add(1L);
        }

        public final void makeProgress$atomicfu(int epoch) {
            if (epoch <= this.progressEpoch) {
                return;
            }
            this.progressEpoch = epoch;
            int iIncrementAndGet = this.this$0.globalPauseProgress.incrementAndGet();
            if (iIncrementAndGet >= this.this$0.threads.size() - 1) {
                if (iIncrementAndGet == this.this$0.threads.size() - 1) {
                    if (this.this$0.globalPauseProgress.compareAndSet(this.this$0.threads.size() - 1, 0)) {
                        this.this$0.resumeImpl();
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        public final void stepImpl$atomicfu() {
            if (this.random.nextInt(1000) == 0) {
                pauseImpl$atomicfu();
            }
        }

        public final void pauseImpl$atomicfu() {
            int i;
            int i2;
            do {
                i = this.this$0.status.get();
                if (i < 0 || i == Integer.MAX_VALUE) {
                    return;
                }
                this.pausedEpoch = i + 1;
                i2 = ~this.index;
            } while (!this.this$0.status.compareAndSet(i, i2));
            while (this.this$0.status.get() == i2) {
                LockSupport.parkNanos(Constants.Network.MAX_PAYLOAD_SIZE);
            }
        }

        private final void callOperation() {
            beforeLockFreeOperation();
            beginRunningOperation();
            Function2<TestThread, Continuation<? super Unit>, Object> function2 = this.operation;
            Continuation<Unit> continuation = this.completion;
            if (function2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            }
            Object objInvoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(this, continuation);
            if (objInvoke == Unit.INSTANCE) {
                afterLockFreeOperation();
            } else {
                if (objInvoke != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    throw new IllegalStateException(("Unexpected result of operation: " + objInvoke).toString());
                }
                waitUntilCompletion();
            }
            try {
                doneRunningOperation();
            } catch (IllegalStateException e) {
                throw new IllegalStateException(e.getMessage() + "; original start result=" + objInvoke, e);
            }
        }

        private final void waitUntilCompletion() {
            Object objM8722waitForResultd1pmJ48;
            while (true) {
                try {
                    afterLockFreeOperation();
                    objM8722waitForResultd1pmJ48 = m8722waitForResultd1pmJ48();
                    Continuation<Object> continuationTakeContinuation = takeContinuation();
                    if (continuationTakeContinuation == null) {
                        break;
                    }
                    this.this$0.removeSuspended(this);
                    beforeLockFreeOperation();
                    continuationTakeContinuation.resumeWith(objM8722waitForResultd1pmJ48);
                } finally {
                    this.this$0.removeSuspended(this);
                }
            }
            ResultKt.throwOnFailure(objM8722waitForResultd1pmJ48);
            if (objM8722waitForResultd1pmJ48 == Unit.INSTANCE) {
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        private final void beginRunningOperation() {
            this.runningOperation = true;
            this.result = null;
            this.continuation = null;
        }

        private final synchronized void doneRunningOperation() {
            if (!this.runningOperation) {
                throw new IllegalStateException("Should be running operation".toString());
            }
            if (!(this.result == null && this.continuation == null)) {
                throw new IllegalStateException(("Callback invoked with result=" + this.result + ", continuation=" + this.continuation).toString());
            }
            this.runningOperation = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized void resumeWith(Object result, Continuation<Object> continuation) {
            if (!this.runningOperation) {
                throw new IllegalStateException("Should be running operation".toString());
            }
            if (!(this.result == null && this.continuation == null)) {
                throw new IllegalStateException(("Resumed again with result=" + Result.m7241toStringimpl(result) + ", continuation=" + continuation + ", when this: result=" + this.result + ", continuation=" + this.continuation).toString());
            }
            this.result = Result.m7232boximpl(result);
            this.continuation = continuation;
            notifyAll();
        }

        /* JADX INFO: renamed from: waitForResult-d1pmJ48, reason: not valid java name */
        private final synchronized Object m8722waitForResultd1pmJ48() {
            Result<? extends Object> result;
            while (true) {
                result = this.result;
                if (result == null) {
                    if (this.this$0.addSuspended(this) < this.this$0.allowSuspendedThreads) {
                        makeProgress$atomicfu(this.this$0.getPausedEpoch());
                    }
                    wait(10L);
                }
            }
            return result.getValue();
        }

        private final synchronized Continuation<Object> takeContinuation() {
            Continuation<Object> continuation;
            continuation = this.continuation;
            this.result = null;
            this.continuation = null;
            return continuation;
        }

        public final synchronized void abortWait() {
            Result.Companion companion = Result.INSTANCE;
            this.result = Result.m7232boximpl(Result.m7233constructorimpl(ResultKt.createFailure(new IllegalStateException("Aborted at the end of test"))));
            notifyAll();
        }

        public final void randomSpinWaitIntermission() {
            int iNextInt;
            afterLockFreeOperation();
            try {
                if (this.random.nextInt(100) < 95) {
                    return;
                }
                do {
                    iNextInt = this.random.nextInt(100);
                    for (int i = 0; i < iNextInt; i++) {
                        this.sink += i;
                    }
                } while (iNextInt >= 90);
                Unit unit = Unit.INSTANCE;
            } finally {
                beforeLockFreeOperation();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized int addSuspended(TestThread thread) {
        int iIndexOf = this.suspendedThreads.indexOf(thread);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        this.suspendedThreads.add(thread);
        return this.suspendedThreads.size() - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void removeSuspended(TestThread thread) {
        this.suspendedThreads.remove(thread);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getPausedEpoch() {
        int i;
        int pausedEpoch;
        do {
            i = this.status.get();
            if (i >= 0) {
                return -1;
            }
            pausedEpoch = this.threads.get(~i).getPausedEpoch();
        } while (i != this.status.get());
        return pausedEpoch;
    }

    public final void step$atomicfu() {
        Thread threadCurrentThread = Thread.currentThread();
        if (!(threadCurrentThread instanceof TestThread)) {
            threadCurrentThread = null;
        }
        TestThread testThread = (TestThread) threadCurrentThread;
        if (testThread != null) {
            testThread.stepImpl$atomicfu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resumeImpl() {
        int i;
        TestThread testThread;
        do {
            i = this.status.get();
            if (i == Integer.MAX_VALUE) {
                return;
            }
            if (!(i < 0)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            testThread = this.threads.get(~i);
            this.performedResumes = testThread.getPausedEpoch();
        } while (!this.status.compareAndSet(i, testThread.getPausedEpoch()));
        LockSupport.unpark(testThread);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String composeThreadName(String threadName) {
        if (threadName != null) {
            return this.name + '-' + threadName;
        }
        return this.name + '-' + (this.threads.size() + 1);
    }

    /* JADX INFO: compiled from: LockFreedomTestEnvironment.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u000bH\u0016J1\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\f0\r2\u0006\u0010\u0007\u001a\u0002H\f2\u0006\u0010\t\u001a\u0002H\fH\u0016¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u000bH\u0016J)\u0010\u000f\u001a\u00020\u0004\"\u0004\b\u0000\u0010\f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\f0\r2\u0006\u0010\t\u001a\u0002H\fH\u0016¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nH\u0016J\u001c\u0010\u0011\u001a\u00020\u0004\"\u0004\b\u0000\u0010\f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\f0\rH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, m5598d2 = {"Lkotlinx/atomicfu/LockFreedomTestEnvironment$Interceptor;", "Lkotlinx/atomicfu/AtomicOperationInterceptor;", "(Lkotlinx/atomicfu/LockFreedomTestEnvironment;)V", "afterRMW", "", "ref", "Lkotlinx/atomicfu/AtomicInt;", "oldValue", "", "newValue", "Lkotlinx/atomicfu/AtomicLong;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/atomicfu/AtomicRef;", "(Lkotlinx/atomicfu/AtomicRef;Ljava/lang/Object;Ljava/lang/Object;)V", "afterSet", "(Lkotlinx/atomicfu/AtomicRef;Ljava/lang/Object;)V", "beforeUpdate", "toString", "", "atomicfu"}, m5599k = 1, m5600mv = {1, 4, 3})
    private final class Interceptor extends AtomicOperationInterceptor {
        public Interceptor() {
        }

        @Override // kotlinx.atomicfu.AtomicOperationInterceptor
        public <T> void beforeUpdate(AtomicRef<T> ref) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            LockFreedomTestEnvironment.this.step$atomicfu();
        }

        @Override // kotlinx.atomicfu.AtomicOperationInterceptor
        public void beforeUpdate(AtomicInt ref) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            LockFreedomTestEnvironment.this.step$atomicfu();
        }

        @Override // kotlinx.atomicfu.AtomicOperationInterceptor
        public void beforeUpdate(AtomicLong ref) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            LockFreedomTestEnvironment.this.step$atomicfu();
        }

        @Override // kotlinx.atomicfu.AtomicOperationInterceptor
        public <T> void afterSet(AtomicRef<T> ref, T newValue) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            LockFreedomTestEnvironment.this.step$atomicfu();
        }

        @Override // kotlinx.atomicfu.AtomicOperationInterceptor
        public void afterSet(AtomicInt ref, int newValue) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            LockFreedomTestEnvironment.this.step$atomicfu();
        }

        @Override // kotlinx.atomicfu.AtomicOperationInterceptor
        public void afterSet(AtomicLong ref, long newValue) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            LockFreedomTestEnvironment.this.step$atomicfu();
        }

        @Override // kotlinx.atomicfu.AtomicOperationInterceptor
        public <T> void afterRMW(AtomicRef<T> ref, T oldValue, T newValue) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            LockFreedomTestEnvironment.this.step$atomicfu();
        }

        @Override // kotlinx.atomicfu.AtomicOperationInterceptor
        public void afterRMW(AtomicInt ref, int oldValue, int newValue) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            LockFreedomTestEnvironment.this.step$atomicfu();
        }

        @Override // kotlinx.atomicfu.AtomicOperationInterceptor
        public void afterRMW(AtomicLong ref, long oldValue, long newValue) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            LockFreedomTestEnvironment.this.step$atomicfu();
        }

        public String toString() {
            return "LockFreedomTestEnvironment(" + LockFreedomTestEnvironment.this.name + ')';
        }
    }
}
