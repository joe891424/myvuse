package com.newrelic.agent.android.payload;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.agentdata.AgentDataReporter;
import com.newrelic.agent.android.crash.CrashReporter;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestLifecycleAware;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.payload.PayloadSender;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.stats.TicToc;
import com.newrelic.agent.android.util.NamedThreadFactory;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes6.dex */
public class PayloadController implements HarvestLifecycleAware {
    public static final int PAYLOAD_COLLECTOR_TIMEOUT = 5000;
    public static final long PAYLOAD_REQUEUE_PERIOD_MS = 120000;
    private final AgentConfiguration agentConfiguration;
    protected static final AgentLog log = AgentLogManager.getAgentLog();
    protected static Lock payloadQueueLock = new ReentrantLock(false);
    protected static AtomicReference<PayloadController> instance = new AtomicReference<>(null);
    protected static ThrottledScheduledThreadPoolExecutor queueExecutor = null;
    protected static ScheduledFuture<?> requeueFuture = null;
    protected static ConcurrentLinkedQueue<PayloadReaper> payloadReaperQueue = null;
    protected static ConcurrentLinkedQueue<PayloadReaper> payloadReaperRetryQueue = null;
    protected static Map<String, Future> reapersInFlight = null;
    protected static boolean opportunisticUploads = false;
    protected static final Runnable dequeueRunnable = new Runnable() { // from class: com.newrelic.agent.android.payload.PayloadController$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            PayloadController.lambda$static$0();
        }
    };
    protected static final Runnable requeueRunnable = new Runnable() { // from class: com.newrelic.agent.android.payload.PayloadController$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            PayloadController.lambda$static$1();
        }
    };

    static /* synthetic */ void lambda$static$0() {
        if (isInitialized()) {
            instance.get().dequeuePayloadSenders();
        }
    }

    static /* synthetic */ void lambda$static$1() {
        if (isInitialized()) {
            instance.get().requeuePayloadSenders();
        }
    }

    public static PayloadController initialize(AgentConfiguration agentConfiguration) {
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m1161m(instance, null, new PayloadController(agentConfiguration))) {
            payloadReaperQueue = new ConcurrentLinkedQueue<>();
            payloadReaperRetryQueue = new ConcurrentLinkedQueue<>();
            ThrottledScheduledThreadPoolExecutor throttledScheduledThreadPoolExecutor = new ThrottledScheduledThreadPoolExecutor(agentConfiguration.getIOThreadSize(), new NamedThreadFactory("PayloadWorker"));
            queueExecutor = throttledScheduledThreadPoolExecutor;
            requeueFuture = throttledScheduledThreadPoolExecutor.scheduleWithFixedDelay(requeueRunnable, PAYLOAD_REQUEUE_PERIOD_MS, PAYLOAD_REQUEUE_PERIOD_MS, TimeUnit.MILLISECONDS);
            reapersInFlight = new ConcurrentHashMap();
            opportunisticUploads = false;
            CrashReporter crashReporterInitialize = CrashReporter.initialize(agentConfiguration);
            if (crashReporterInitialize != null) {
                crashReporterInitialize.start();
            } else {
                log.warn("PayloadController: No crash reporter - crash reporting will be disabled");
            }
            AgentDataReporter agentDataReporterInitialize = AgentDataReporter.initialize(agentConfiguration);
            if (agentDataReporterInitialize != null) {
                agentDataReporterInitialize.start();
            } else {
                log.warn("PayloadController: No payload reporter - payload reporting will be disabled");
            }
            Harvest.addHarvestListener(instance.get());
        }
        return instance.get();
    }

    public static void shutdown() {
        if (isInitialized()) {
            try {
                Harvest.removeHarvestListener(instance.get());
                ScheduledFuture<?> scheduledFuture = requeueFuture;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                    requeueFuture = null;
                }
                ThrottledScheduledThreadPoolExecutor throttledScheduledThreadPoolExecutor = queueExecutor;
                if (throttledScheduledThreadPoolExecutor != null) {
                    throttledScheduledThreadPoolExecutor.shutdown();
                    try {
                        if (!queueExecutor.awaitTermination(5000L, TimeUnit.MILLISECONDS)) {
                            log.warn("PayloadController: upload thread(s) timed-out before handler");
                            queueExecutor.shutdownNow();
                        }
                        AgentDataReporter.shutdown();
                        CrashReporter.shutdown();
                    } catch (InterruptedException e) {
                        log.error("PayloadController.shutdown(): " + String.valueOf(e));
                    }
                }
                instance.set(null);
            } catch (Exception e2) {
                log.error("PayloadController.shutdown(): " + String.valueOf(e2));
            }
        }
    }

    public static Future submitPayload(PayloadSender payloadSender) {
        return submitPayload(payloadSender, null);
    }

    public static Future submitPayload(PayloadSender payloadSender, PayloadSender.CompletionHandler completionHandler) {
        TicToc ticToc = new TicToc();
        if (!isInitialized()) {
            return null;
        }
        ticToc.tic();
        PayloadReaper payloadReaper = new PayloadReaper(payloadSender, completionHandler) { // from class: com.newrelic.agent.android.payload.PayloadController.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.newrelic.agent.android.payload.PayloadReaper, java.util.concurrent.Callable
            public PayloadSender call() throws Exception {
                PayloadSender payloadSenderCall = super.call();
                if (payloadSenderCall != null && !payloadSenderCall.isSuccessfulResponse() && payloadSenderCall.shouldRetry()) {
                    PayloadController.payloadReaperRetryQueue.offer(this);
                }
                PayloadController.reapersInFlight.remove(getUuid());
                return payloadSenderCall;
            }
        };
        payloadReaperQueue.remove(payloadReaper);
        payloadReaperRetryQueue.remove(payloadReaper);
        Future futureSubmit = reapersInFlight.get(payloadReaper.getUuid());
        if (futureSubmit != null) {
            log.warn("PayloadController: Upload of payload [" + payloadReaper.getUuid() + "] is already in progress.");
            return futureSubmit;
        }
        if (payloadSender.shouldUploadOpportunistically()) {
            futureSubmit = queueExecutor.submit(payloadReaper);
            reapersInFlight.put(payloadReaper.getUuid(), futureSubmit);
        } else {
            payloadReaperQueue.offer(payloadReaper);
        }
        log.debug("PayloadController: " + ticToc.toc() + "ms. waiting to submit payload [" + payloadReaper.getUuid() + "].");
        return futureSubmit;
    }

    protected static Future submitPayload(PayloadReaper payloadReaper) {
        if (!isInitialized()) {
            return null;
        }
        payloadReaperQueue.remove(payloadReaper);
        payloadReaperRetryQueue.remove(payloadReaper);
        Future future = reapersInFlight.get(payloadReaper.getUuid());
        if (future != null) {
            log.warn("PayloadController: Upload of payload [" + payloadReaper.getUuid() + "] is already in progress.");
            return future;
        }
        Future futureSubmit = queueExecutor.submit(payloadReaper);
        reapersInFlight.put(payloadReaper.getUuid(), futureSubmit);
        return futureSubmit;
    }

    public static boolean shouldUploadOpportunistically() {
        return opportunisticUploads && Agent.hasReachableNetworkConnection(null);
    }

    public static Future submitCallable(Callable<?> callable) {
        return queueExecutor.submit(callable);
    }

    public static boolean isInitialized() {
        return instance.get() != null;
    }

    protected PayloadController(AgentConfiguration agentConfiguration) {
        this.agentConfiguration = agentConfiguration;
    }

    private final void dequeuePayloadSenders() {
        if (payloadQueueLock.tryLock()) {
            while (!payloadReaperQueue.isEmpty()) {
                try {
                    PayloadReaper payloadReaperPoll = payloadReaperQueue.poll();
                    if (payloadReaperPoll != null) {
                        try {
                            submitPayload(payloadReaperPoll);
                        } catch (Exception e) {
                            log.error("PayloadController.dequeuePayloadSenders(): " + String.valueOf(e));
                        }
                    }
                } finally {
                    payloadQueueLock.unlock();
                }
            }
        }
    }

    private void requeuePayloadSenders() {
        if (payloadQueueLock.tryLock()) {
            while (!payloadReaperRetryQueue.isEmpty()) {
                try {
                    PayloadReaper payloadReaperPoll = payloadReaperRetryQueue.poll();
                    if (payloadReaperPoll != null) {
                        if (!payloadReaperPoll.sender.getPayload().isStale(this.agentConfiguration.getPayloadTTL())) {
                            submitPayload(payloadReaperPoll);
                        } else {
                            log.warn("PayloadController: Will not re-queue stale payload.");
                        }
                    }
                } finally {
                    payloadQueueLock.unlock();
                }
            }
        }
    }

    protected boolean uploadOpportunistically() {
        return opportunisticUploads;
    }

    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvest() {
        queueExecutor.submit(dequeueRunnable);
    }

    public static boolean payloadInFlight(Payload payload) {
        return reapersInFlight.containsKey(payload.getUuid());
    }

    protected static class ThrottledScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {
        protected static final int THROTTLE_LIMIT = 16;
        protected static final int THROTTLE_SLEEP = 50;

        public ThrottledScheduledThreadPoolExecutor(int i, ThreadFactory threadFactory) {
            super(i, threadFactory);
        }

        @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Callable<T> callable) {
            if (getQueue().size() >= 16) {
                StatsEngine.get().inc(MetricNames.SUPPORTABILITY_HEX_UPLOAD_THROTTLED);
            }
            return super.submit(callable);
        }
    }
}
