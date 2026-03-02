package com.newrelic.agent.android.sample;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.stats.TicToc;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.agent.android.tracing.Sample;
import com.newrelic.agent.android.tracing.TraceLifecycleAware;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.util.NamedThreadFactory;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: loaded from: classes6.dex */
public class Sampler implements TraceLifecycleAware, Runnable {
    private static final int KB_IN_MB = 1024;
    protected static final long SAMPLE_FREQ_MS = 100;
    protected static final long SAMPLE_FREQ_MS_MAX = 250;
    protected static Sampler sampler;
    private final ActivityManager activityManager;
    private RandomAccessFile appStatFile;
    protected final AtomicBoolean isRunning;
    private Long lastAppCpuTime;
    private Long lastCpuTime;
    private RandomAccessFile procStatFile;
    protected long sampleFreqMs;
    protected ScheduledFuture sampleFuture;
    private Metric samplerServiceMetric;
    private final EnumMap<Sample.SampleType, Collection<Sample>> samples;
    private static final int[] PID = {Process.myPid()};
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private static final ReentrantLock samplerLock = new ReentrantLock();
    protected static final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("Sampler"));
    protected static boolean cpuSamplingDisabled = false;

    @Override // com.newrelic.agent.android.tracing.TraceLifecycleAware
    public void onExitMethod() {
    }

    @Override // com.newrelic.agent.android.tracing.TraceLifecycleAware
    public void onTraceRename(ActivityTrace activityTrace) {
    }

    protected Sampler(Context context) {
        EnumMap<Sample.SampleType, Collection<Sample>> enumMap = new EnumMap<>(Sample.SampleType.class);
        this.samples = enumMap;
        this.isRunning = new AtomicBoolean(false);
        this.sampleFreqMs = SAMPLE_FREQ_MS;
        this.activityManager = (ActivityManager) context.getSystemService("activity");
        enumMap.put(Sample.SampleType.MEMORY, new ArrayList());
        enumMap.put(Sample.SampleType.CPU, new ArrayList());
    }

    public static void init(Context context) {
        ReentrantLock reentrantLock = samplerLock;
        reentrantLock.lock();
        try {
            try {
                if (sampler == null) {
                    Sampler samplerProvideSampler = provideSampler(context);
                    sampler = samplerProvideSampler;
                    samplerProvideSampler.sampleFreqMs = SAMPLE_FREQ_MS;
                    samplerProvideSampler.samplerServiceMetric = new Metric("samplerServiceTime");
                    TraceMachine.addTraceListener(sampler);
                    cpuSamplingDisabled = true;
                    AgentLog agentLog = log;
                    agentLog.debug("CPU sampling not supported in Android 8 and above.");
                    agentLog.debug("Sampler initialized");
                }
                reentrantLock.unlock();
            } catch (Exception e) {
                log.error("Sampler init failed: " + e.getMessage());
                shutdown();
                samplerLock.unlock();
            }
        } catch (Throwable th) {
            samplerLock.unlock();
            throw th;
        }
    }

    protected static Sampler provideSampler(Context context) {
        return new Sampler(context);
    }

    public static void start() {
        ReentrantLock reentrantLock = samplerLock;
        reentrantLock.lock();
        try {
            Sampler sampler2 = sampler;
            if (sampler2 != null) {
                sampler2.schedule();
                log.debug("Sampler started");
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            samplerLock.unlock();
            throw th;
        }
    }

    public static void stop() {
        ReentrantLock reentrantLock = samplerLock;
        reentrantLock.lock();
        try {
            Sampler sampler2 = sampler;
            if (sampler2 != null) {
                sampler2.stop(false);
                log.debug("Sampler stopped");
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            samplerLock.unlock();
            throw th;
        }
    }

    public static void stopNow() {
        ReentrantLock reentrantLock = samplerLock;
        reentrantLock.lock();
        try {
            Sampler sampler2 = sampler;
            if (sampler2 != null) {
                sampler2.stop(true);
                log.debug("Sampler hard stopped");
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            samplerLock.unlock();
            throw th;
        }
    }

    public static void shutdown() {
        ReentrantLock reentrantLock = samplerLock;
        reentrantLock.lock();
        try {
            Sampler sampler2 = sampler;
            if (sampler2 != null) {
                TraceMachine.removeTraceListener(sampler2);
                stopNow();
                sampler = null;
                log.debug("Sampler shutdown");
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            samplerLock.unlock();
            throw th;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.isRunning.get()) {
                sample();
            }
        } catch (Exception e) {
            log.error("Caught exception while running the sampler", e);
            AgentHealth.noticeException(e);
        }
    }

    protected void schedule() {
        ReentrantLock reentrantLock = samplerLock;
        reentrantLock.lock();
        try {
            try {
                if (!this.isRunning.get()) {
                    clear();
                    this.sampleFuture = scheduler.scheduleWithFixedDelay(this, 0L, this.sampleFreqMs, TimeUnit.MILLISECONDS);
                    this.isRunning.set(true);
                    log.debug(String.format("Sampler scheduler started; sampling will occur every %d ms.", Long.valueOf(this.sampleFreqMs)));
                }
                reentrantLock.unlock();
            } catch (Exception e) {
                log.error("Sampler scheduling failed: " + e.getMessage());
                AgentHealth.noticeException(e);
                samplerLock.unlock();
            }
        } catch (Throwable th) {
            samplerLock.unlock();
            throw th;
        }
    }

    protected void stop(boolean z) {
        ReentrantLock reentrantLock = samplerLock;
        reentrantLock.lock();
        try {
            try {
                if (this.isRunning.get()) {
                    this.isRunning.set(false);
                    ScheduledFuture scheduledFuture = this.sampleFuture;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(z);
                    }
                    resetCpuSampler();
                    log.debug("Sampler canceled");
                }
                reentrantLock.unlock();
            } catch (Exception e) {
                log.error("Sampler stop failed: " + e.getMessage());
                AgentHealth.noticeException(e);
                samplerLock.unlock();
            }
        } catch (Throwable th) {
            samplerLock.unlock();
            throw th;
        }
    }

    protected static boolean isRunning() {
        ScheduledFuture scheduledFuture;
        Sampler sampler2 = sampler;
        if (sampler2 == null || (scheduledFuture = sampler2.sampleFuture) == null) {
            return false;
        }
        return !scheduledFuture.isDone();
    }

    protected void monitorSamplerServiceTime(double d) {
        this.samplerServiceMetric.sample(d);
        if (Double.valueOf(this.samplerServiceMetric.getTotal() / this.samplerServiceMetric.getCount()).doubleValue() > this.sampleFreqMs) {
            AgentLog agentLog = log;
            agentLog.debug("Sampler: sample service time has been exceeded. Increase by 10%");
            this.sampleFreqMs = Math.min((long) (this.sampleFreqMs * 1.1f), SAMPLE_FREQ_MS_MAX);
            ScheduledFuture scheduledFuture = this.sampleFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.sampleFuture = scheduler.scheduleWithFixedDelay(this, 0L, this.sampleFreqMs, TimeUnit.MILLISECONDS);
            agentLog.debug(String.format("Sampler scheduler restarted; sampling will now occur every %d ms.", Long.valueOf(this.sampleFreqMs)));
            this.samplerServiceMetric.clear();
        }
    }

    protected void sample() {
        TicToc ticToc = new TicToc();
        ReentrantLock reentrantLock = samplerLock;
        reentrantLock.lock();
        try {
            try {
                ticToc.tic();
                Sample sampleSampleMemory = sampleMemory();
                if (sampleSampleMemory != null) {
                    getSampleCollection(Sample.SampleType.MEMORY).add(sampleSampleMemory);
                }
                Sample sampleSampleCpu = sampleCpu();
                if (sampleSampleCpu != null) {
                    getSampleCollection(Sample.SampleType.CPU).add(sampleSampleCpu);
                }
                reentrantLock.unlock();
            } catch (Exception e) {
                log.error("Sampling failed: " + e.getMessage());
                AgentHealth.noticeException(e);
                samplerLock.unlock();
            }
            monitorSamplerServiceTime(ticToc.toc());
        } catch (Throwable th) {
            samplerLock.unlock();
            throw th;
        }
    }

    protected void clear() {
        Iterator<Collection<Sample>> it2 = this.samples.values().iterator();
        while (it2.hasNext()) {
            it2.next().clear();
        }
    }

    public static Sample sampleMemory() {
        Sampler sampler2 = sampler;
        if (sampler2 == null) {
            return null;
        }
        return sampleMemory(sampler2.activityManager);
    }

    public static Sample sampleMemory(ActivityManager activityManager) {
        int totalPss;
        try {
            Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(PID);
            if (processMemoryInfo.length <= 0 || (totalPss = processMemoryInfo[0].getTotalPss()) < 0) {
                return null;
            }
            Sample sample = new Sample(Sample.SampleType.MEMORY);
            sample.setSampleValue(((double) totalPss) / 1024.0d);
            return sample;
        } catch (Exception e) {
            log.error("Sample memory failed: " + e.getMessage());
            AgentHealth.noticeException(e);
            return null;
        }
    }

    protected static Sample sampleCpuInstance() {
        Sampler sampler2 = sampler;
        if (sampler2 == null) {
            return null;
        }
        return sampler2.sampleCpu();
    }

    public Sample sampleCpu() {
        if (cpuSamplingDisabled) {
            return null;
        }
        try {
            RandomAccessFile randomAccessFile = this.procStatFile;
            if (randomAccessFile == null || this.appStatFile == null) {
                this.appStatFile = new RandomAccessFile("/proc/" + PID[0] + "/stat", RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME);
                this.procStatFile = new RandomAccessFile("/proc/stat", RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME);
            } else {
                randomAccessFile.seek(0L);
                this.appStatFile.seek(0L);
            }
            String line = this.procStatFile.readLine();
            String line2 = this.appStatFile.readLine();
            String[] strArrSplit = line.split(" ");
            String[] strArrSplit2 = line2.split(" ");
            long j = Long.parseLong(strArrSplit[2]) + Long.parseLong(strArrSplit[3]) + Long.parseLong(strArrSplit[4]) + Long.parseLong(strArrSplit[5]) + Long.parseLong(strArrSplit[6]) + Long.parseLong(strArrSplit[7]) + Long.parseLong(strArrSplit[8]);
            long j2 = Long.parseLong(strArrSplit2[13]) + Long.parseLong(strArrSplit2[14]);
            if (this.lastCpuTime == null && this.lastAppCpuTime == null) {
                this.lastCpuTime = Long.valueOf(j);
                this.lastAppCpuTime = Long.valueOf(j2);
                return null;
            }
            Sample sample = new Sample(Sample.SampleType.CPU);
            sample.setSampleValue(((j2 - this.lastAppCpuTime.longValue()) / (j - this.lastCpuTime.longValue())) * 100.0d);
            this.lastCpuTime = Long.valueOf(j);
            this.lastAppCpuTime = Long.valueOf(j2);
            return sample;
        } catch (Exception e) {
            cpuSamplingDisabled = true;
            log.debug("Exception hit while CPU sampling: " + e.getMessage());
            AgentHealth.noticeException(e);
            return null;
        }
    }

    private void resetCpuSampler() {
        this.lastCpuTime = null;
        this.lastAppCpuTime = null;
        RandomAccessFile randomAccessFile = this.appStatFile;
        if (randomAccessFile == null || this.procStatFile == null) {
            return;
        }
        try {
            randomAccessFile.close();
            this.procStatFile.close();
            this.appStatFile = null;
            this.procStatFile = null;
        } catch (IOException e) {
            log.debug("Exception hit while resetting CPU sampler: " + e.getMessage());
            AgentHealth.noticeException(e);
        }
    }

    public static Map<Sample.SampleType, Collection<Sample>> copySamples() {
        ReentrantLock reentrantLock = samplerLock;
        reentrantLock.lock();
        try {
            if (sampler == null) {
                reentrantLock.unlock();
                HashMap map = new HashMap();
                reentrantLock.unlock();
                return map;
            }
            EnumMap enumMap = new EnumMap((EnumMap) sampler.samples);
            for (K k : sampler.samples.keySet()) {
                enumMap.put(k, new ArrayList(sampler.samples.get(k)));
            }
            samplerLock.unlock();
            return Collections.unmodifiableMap(enumMap);
        } catch (Throwable th) {
            samplerLock.unlock();
            throw th;
        }
    }

    private Collection<Sample> getSampleCollection(Sample.SampleType sampleType) {
        return this.samples.get(sampleType);
    }

    @Override // com.newrelic.agent.android.tracing.TraceLifecycleAware
    public void onEnterMethod() {
        if (this.isRunning.get()) {
            return;
        }
        start();
    }

    @Override // com.newrelic.agent.android.tracing.TraceLifecycleAware
    public void onTraceStart(ActivityTrace activityTrace) {
        start();
    }

    @Override // com.newrelic.agent.android.tracing.TraceLifecycleAware
    public void onTraceComplete(final ActivityTrace activityTrace) {
        scheduler.execute(new Runnable() { // from class: com.newrelic.agent.android.sample.Sampler.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Sampler.this.stop(true);
                    activityTrace.setVitals(Sampler.copySamples());
                    Sampler.this.clear();
                } catch (RuntimeException e) {
                    Sampler.log.error(e.toString());
                }
            }
        });
    }
}
