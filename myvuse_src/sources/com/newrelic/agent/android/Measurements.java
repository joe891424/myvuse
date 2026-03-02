package com.newrelic.agent.android;

import com.newrelic.agent.android.activity.MeasuredActivity;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.HttpTransactionMeasurement;
import com.newrelic.agent.android.measurement.MeasurementEngine;
import com.newrelic.agent.android.measurement.consumer.ActivityMeasurementConsumer;
import com.newrelic.agent.android.measurement.consumer.CustomMetricMeasurementConsumer;
import com.newrelic.agent.android.measurement.consumer.HttpTransactionMeasurementConsumer;
import com.newrelic.agent.android.measurement.consumer.MeasurementConsumer;
import com.newrelic.agent.android.measurement.consumer.MethodMeasurementConsumer;
import com.newrelic.agent.android.measurement.consumer.SummaryMetricMeasurementConsumer;
import com.newrelic.agent.android.measurement.producer.ActivityMeasurementProducer;
import com.newrelic.agent.android.measurement.producer.CustomMetricMeasurementProducer;
import com.newrelic.agent.android.measurement.producer.MeasurementProducer;
import com.newrelic.agent.android.measurement.producer.MethodMeasurementProducer;
import com.newrelic.agent.android.measurement.producer.NetworkMeasurementProducer;
import com.newrelic.agent.android.metric.MetricUnit;
import com.newrelic.agent.android.tracing.Trace;

/* JADX INFO: loaded from: classes6.dex */
public class Measurements {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    protected static final MeasurementEngine measurementEngine = new MeasurementEngine();
    private static final NetworkMeasurementProducer networkMeasurementProducer = new NetworkMeasurementProducer();
    private static final ActivityMeasurementProducer activityMeasurementProducer = new ActivityMeasurementProducer();
    private static final MethodMeasurementProducer methodMeasurementProducer = new MethodMeasurementProducer();
    private static final CustomMetricMeasurementProducer customMetricMeasurementProducer = new CustomMetricMeasurementProducer();
    private static final HttpTransactionMeasurementConsumer httpTransactionHarvester = new HttpTransactionMeasurementConsumer();
    private static final ActivityMeasurementConsumer activityConsumer = new ActivityMeasurementConsumer();
    private static final MethodMeasurementConsumer methodMeasurementConsumer = new MethodMeasurementConsumer();
    private static final CustomMetricMeasurementConsumer customMetricMeasurementConsumer = new CustomMetricMeasurementConsumer();
    private static final SummaryMetricMeasurementConsumer summaryMetricMeasurementConsumer = new SummaryMetricMeasurementConsumer();
    private static boolean broadcastNewMeasurements = true;

    public static void initialize() {
        log.info("Measurement Engine initialized.");
        TaskQueue.start();
        addMeasurementProducer(measurementEngine.getRootMeasurementPool());
        addMeasurementProducer(networkMeasurementProducer);
        addMeasurementProducer(activityMeasurementProducer);
        addMeasurementProducer(methodMeasurementProducer);
        addMeasurementProducer(customMetricMeasurementProducer);
        addMeasurementConsumer(httpTransactionHarvester);
        addMeasurementConsumer(activityConsumer);
        addMeasurementConsumer(methodMeasurementConsumer);
        addMeasurementConsumer(customMetricMeasurementConsumer);
        addMeasurementConsumer(summaryMetricMeasurementConsumer);
    }

    public static void shutdown() {
        TaskQueue.stop();
        MeasurementEngine measurementEngine2 = measurementEngine;
        measurementEngine2.clear();
        log.info("Measurement Engine shutting down.");
        removeMeasurementProducer(measurementEngine2.getRootMeasurementPool());
        removeMeasurementProducer(networkMeasurementProducer);
        removeMeasurementProducer(activityMeasurementProducer);
        removeMeasurementProducer(methodMeasurementProducer);
        removeMeasurementProducer(customMetricMeasurementProducer);
        removeMeasurementConsumer(httpTransactionHarvester);
        removeMeasurementConsumer(activityConsumer);
        removeMeasurementConsumer(methodMeasurementConsumer);
        removeMeasurementConsumer(customMetricMeasurementConsumer);
        removeMeasurementConsumer(summaryMetricMeasurementConsumer);
    }

    public static void addHttpTransaction(HttpTransactionMeasurement httpTransactionMeasurement) {
        if (Harvest.isDisabled()) {
            return;
        }
        if (httpTransactionMeasurement == null) {
            log.error("TransactionMeasurement is null. HttpTransactionMeasurement measurement not created.");
        } else {
            networkMeasurementProducer.produceMeasurement(httpTransactionMeasurement);
            newMeasurementBroadcast();
        }
    }

    public static void addCustomMetric(String str, String str2, int i, double d, double d2, MetricUnit metricUnit, MetricUnit metricUnit2) {
        if (Harvest.isDisabled()) {
            return;
        }
        customMetricMeasurementProducer.produceMeasurement(str, str2, i, d, d2, metricUnit, metricUnit2);
        newMeasurementBroadcast();
    }

    public static void setBroadcastNewMeasurements(boolean z) {
        broadcastNewMeasurements = z;
    }

    private static void newMeasurementBroadcast() {
        if (broadcastNewMeasurements) {
            broadcast();
        }
    }

    public static void broadcast() {
        measurementEngine.broadcastMeasurements();
    }

    public static MeasuredActivity startActivity(String str) {
        if (Harvest.isDisabled()) {
            return null;
        }
        return measurementEngine.startActivity(str);
    }

    public static void renameActivity(String str, String str2) {
        measurementEngine.renameActivity(str, str2);
    }

    public static void endActivity(String str) {
        if (Harvest.isDisabled()) {
            return;
        }
        activityMeasurementProducer.produceMeasurement(measurementEngine.endActivity(str));
        newMeasurementBroadcast();
    }

    public static void endActivity(MeasuredActivity measuredActivity) {
        if (Harvest.isDisabled()) {
            return;
        }
        measurementEngine.endActivity(measuredActivity);
        activityMeasurementProducer.produceMeasurement(measuredActivity);
        newMeasurementBroadcast();
    }

    public static void endActivityWithoutMeasurement(MeasuredActivity measuredActivity) {
        if (Harvest.isDisabled()) {
            return;
        }
        measurementEngine.endActivity(measuredActivity);
    }

    public static void addTracedMethod(Trace trace) {
        if (Harvest.isDisabled()) {
            return;
        }
        methodMeasurementProducer.produceMeasurement(trace);
        newMeasurementBroadcast();
    }

    public static void addMeasurementProducer(MeasurementProducer measurementProducer) {
        measurementEngine.addMeasurementProducer(measurementProducer);
    }

    public static void removeMeasurementProducer(MeasurementProducer measurementProducer) {
        measurementProducer.drainMeasurements();
        measurementEngine.removeMeasurementProducer(measurementProducer);
    }

    public static void addMeasurementConsumer(MeasurementConsumer measurementConsumer) {
        measurementEngine.addMeasurementConsumer(measurementConsumer);
    }

    public static void removeMeasurementConsumer(MeasurementConsumer measurementConsumer) {
        measurementEngine.removeMeasurementConsumer(measurementConsumer);
    }

    public static void process() {
        measurementEngine.broadcastMeasurements();
    }
}
