package com.newrelic.agent.android.measurement;

import com.newrelic.agent.android.activity.MeasuredActivity;
import com.newrelic.agent.android.activity.NamedActivity;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.consumer.MeasurementConsumer;
import com.newrelic.agent.android.measurement.producer.MeasurementProducer;
import com.newrelic.agent.android.util.NamedThreadFactory;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes6.dex */
public class MeasurementEngine {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final Map<String, MeasuredActivity> activities = new ConcurrentHashMap();
    private final MeasurementPool rootMeasurementPool = new MeasurementPool();
    protected final ExecutorService worker = Executors.newCachedThreadPool(new NamedThreadFactory("MeasurementEngine"));

    public MeasuredActivity startActivity(String str) {
        if (this.activities.containsKey(str)) {
            throw new MeasurementException("An activity with the name '" + str + "' has already started.");
        }
        final MeasurementPool measurementPool = new MeasurementPool();
        final NamedActivity namedActivity = new NamedActivity(str);
        runOnBackgroundThread(new Runnable() { // from class: com.newrelic.agent.android.measurement.MeasurementEngine$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m2741xf2c95e7d(namedActivity, measurementPool);
            }
        });
        this.activities.put(str, namedActivity);
        return namedActivity;
    }

    /* JADX INFO: renamed from: lambda$startActivity$0$com-newrelic-agent-android-measurement-MeasurementEngine */
    /* synthetic */ void m2741xf2c95e7d(NamedActivity namedActivity, MeasurementPool measurementPool) {
        namedActivity.setMeasurementPool(measurementPool);
        this.rootMeasurementPool.addMeasurementConsumer(measurementPool);
    }

    public void renameActivity(String str, String str2) {
        MeasuredActivity measuredActivityRemove = this.activities.remove(str);
        if (measuredActivityRemove == null || !(measuredActivityRemove instanceof NamedActivity)) {
            return;
        }
        this.activities.put(str2, measuredActivityRemove);
        ((NamedActivity) measuredActivityRemove).rename(str2);
    }

    public MeasuredActivity endActivity(String str) {
        MeasuredActivity measuredActivity = this.activities.get(str);
        if (measuredActivity == null) {
            throw new MeasurementException("Activity '" + str + "' has not been started.");
        }
        endActivity(measuredActivity);
        return measuredActivity;
    }

    public void endActivity(MeasuredActivity measuredActivity) {
        this.rootMeasurementPool.removeMeasurementConsumer(measuredActivity.getMeasurementPool());
        this.activities.remove(measuredActivity.getName());
        measuredActivity.finish();
    }

    public void clear() {
        this.activities.clear();
    }

    public void addMeasurementProducer(MeasurementProducer measurementProducer) {
        this.rootMeasurementPool.addMeasurementProducer(measurementProducer);
    }

    public void removeMeasurementProducer(MeasurementProducer measurementProducer) {
        this.rootMeasurementPool.removeMeasurementProducer(measurementProducer);
    }

    public void addMeasurementConsumer(MeasurementConsumer measurementConsumer) {
        this.rootMeasurementPool.addMeasurementConsumer(measurementConsumer);
    }

    public void removeMeasurementConsumer(MeasurementConsumer measurementConsumer) {
        this.rootMeasurementPool.removeMeasurementConsumer(measurementConsumer);
    }

    public void broadcastMeasurements() {
        this.rootMeasurementPool.broadcastMeasurements();
    }

    public Map<String, MeasuredActivity> getActivities() {
        return this.activities;
    }

    public MeasurementPool getRootMeasurementPool() {
        return this.rootMeasurementPool;
    }

    Future<?> runOnBackgroundThread(Runnable runnable) {
        try {
            return this.worker.submit(runnable);
        } catch (Exception e) {
            log.warn("MeasurementEngine background worker: " + String.valueOf(e));
            return null;
        }
    }
}
