package com.newrelic.agent.android.measurement.consumer;

import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestLifecycleAware;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.metric.MetricStore;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MetricMeasurementConsumer extends BaseMeasurementConsumer implements HarvestLifecycleAware {
    protected MetricStore metrics;
    protected boolean recordUnscopedMetrics;

    protected abstract String formatMetricName(String str);

    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvestError() {
    }

    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvestSendFailed() {
    }

    public MetricMeasurementConsumer(MeasurementType measurementType) {
        super(measurementType);
        this.recordUnscopedMetrics = true;
        this.metrics = new MetricStore();
        Harvest.addHarvestListener(this);
    }

    @Override // com.newrelic.agent.android.measurement.consumer.BaseMeasurementConsumer, com.newrelic.agent.android.measurement.consumer.MeasurementConsumer
    public void consumeMeasurement(Measurement measurement) {
        String metricName = formatMetricName(measurement.getName());
        String scope = measurement.getScope();
        double endTimeInSeconds = measurement.getEndTimeInSeconds() - measurement.getStartTimeInSeconds();
        if (endTimeInSeconds < 0.0d) {
            log.error("consumeMeasurement: measurement duration value[" + measurement.getName() + "] is negative!");
            return;
        }
        if (scope != null) {
            Metric metric = this.metrics.get(metricName, scope);
            if (metric == null) {
                metric = new Metric(metricName, scope);
                this.metrics.add(metric);
            }
            metric.sample(endTimeInSeconds);
            metric.addExclusive(measurement.getExclusiveTimeInSeconds());
        }
        if (this.recordUnscopedMetrics) {
            Metric metric2 = this.metrics.get(metricName);
            if (metric2 == null) {
                metric2 = new Metric(metricName);
                this.metrics.add(metric2);
            }
            metric2.sample(endTimeInSeconds);
            metric2.addExclusive(measurement.getExclusiveTimeInSeconds());
        }
    }

    protected void addMetric(Metric metric) {
        Metric metric2;
        if (metric.getScope() != null) {
            metric2 = this.metrics.get(metric.getName(), metric.getScope());
        } else {
            metric2 = this.metrics.get(metric.getName());
        }
        if (metric2 != null) {
            metric2.aggregate(metric);
        } else {
            this.metrics.add(metric);
        }
    }

    public MetricStore getMetrics() {
        return this.metrics;
    }

    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvest() {
        Iterator<Metric> it2 = this.metrics.getAll().iterator();
        while (it2.hasNext()) {
            Harvest.addMetric(it2.next());
        }
    }

    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvestComplete() {
        this.metrics.clear();
    }
}
