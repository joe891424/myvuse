package com.newrelic.agent.android;

import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.harvest.AgentHealthException;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestAdapter;
import com.newrelic.agent.android.measurement.HttpTransactionMeasurement;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.util.NamedThreadFactory;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class TaskQueue extends HarvestAdapter {
    private static final long DEQUEUE_PERIOD_MS = 1000;
    protected static Future dequeueFuture;
    private static final ScheduledExecutorService queueExecutor = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("TaskQueue"));
    private static final ConcurrentLinkedQueue<Object> queue = new ConcurrentLinkedQueue<>();
    private static final Runnable dequeueTask = new Runnable() { // from class: com.newrelic.agent.android.TaskQueue$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            TaskQueue.dequeue();
        }
    };

    public static void queue(Object obj) {
        queue.add(obj);
    }

    public static void backgroundDequeue() {
        queueExecutor.execute(dequeueTask);
    }

    public static void synchronousDequeue() {
        try {
            queueExecutor.submit(dequeueTask).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e2) {
            e2.printStackTrace();
        }
    }

    public static void start() {
        if (dequeueFuture == null) {
            dequeueFuture = queueExecutor.scheduleWithFixedDelay(dequeueTask, 0L, 1000L, TimeUnit.MILLISECONDS);
        }
    }

    public static void stop() {
        Future future = dequeueFuture;
        if (future != null) {
            future.cancel(true);
            dequeueFuture = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dequeue() {
        if (queue.size() == 0) {
            return;
        }
        Measurements.setBroadcastNewMeasurements(false);
        while (true) {
            ConcurrentLinkedQueue<Object> concurrentLinkedQueue = queue;
            if (!concurrentLinkedQueue.isEmpty()) {
                try {
                    Object objRemove = concurrentLinkedQueue.remove();
                    if (objRemove instanceof ActivityTrace) {
                        Harvest.addActivityTrace((ActivityTrace) objRemove);
                    } else if (objRemove instanceof Metric) {
                        Harvest.addMetric((Metric) objRemove);
                    } else if (objRemove instanceof AgentHealthException) {
                        Harvest.addAgentHealthException((AgentHealthException) objRemove);
                    } else if (objRemove instanceof Trace) {
                        Measurements.addTracedMethod((Trace) objRemove);
                    } else if (objRemove instanceof HttpTransactionMeasurement) {
                        Measurements.addHttpTransaction((HttpTransactionMeasurement) objRemove);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    AgentHealth.noticeException(e);
                }
            } else {
                Measurements.broadcast();
                Measurements.setBroadcastNewMeasurements(true);
                return;
            }
        }
    }

    public static int size() {
        return queue.size();
    }

    public static void clear() {
        queue.clear();
    }

    protected static Queue<Object> getQueue() {
        return queue;
    }
}
