package com.newrelic.agent.android.sample;

import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.consumer.MetricMeasurementConsumer;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.tracing.Sample;

/* JADX INFO: loaded from: classes6.dex */
public class MachineMeasurementConsumer extends MetricMeasurementConsumer {
    @Override // com.newrelic.agent.android.measurement.consumer.MetricMeasurementConsumer, com.newrelic.agent.android.measurement.consumer.BaseMeasurementConsumer, com.newrelic.agent.android.measurement.consumer.MeasurementConsumer
    public void consumeMeasurement(Measurement measurement) {
    }

    @Override // com.newrelic.agent.android.measurement.consumer.MetricMeasurementConsumer
    protected String formatMetricName(String str) {
        return str;
    }

    public MachineMeasurementConsumer() {
        super(MeasurementType.Machine);
    }

    @Override // com.newrelic.agent.android.measurement.consumer.MetricMeasurementConsumer, com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvest() {
        Sample sampleSampleMemory = Sampler.sampleMemory();
        if (sampleSampleMemory != null) {
            Metric metric = new Metric("Memory/Used");
            metric.sample(sampleSampleMemory.getValue().doubleValue());
            addMetric(metric);
        }
        super.onHarvest();
    }
}
