package com.newrelic.agent.android.measurement.consumer;

import com.newrelic.agent.android.measurement.CustomMetricMeasurement;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.metric.Metric;

/* JADX INFO: loaded from: classes6.dex */
public class CustomMetricMeasurementConsumer extends MetricMeasurementConsumer {
    protected static final String METRIC_PREFIX = "Custom/";

    public CustomMetricMeasurementConsumer() {
        super(MeasurementType.Custom);
    }

    @Override // com.newrelic.agent.android.measurement.consumer.MetricMeasurementConsumer
    protected String formatMetricName(String str) {
        return METRIC_PREFIX + str;
    }

    @Override // com.newrelic.agent.android.measurement.consumer.MetricMeasurementConsumer, com.newrelic.agent.android.measurement.consumer.BaseMeasurementConsumer, com.newrelic.agent.android.measurement.consumer.MeasurementConsumer
    public void consumeMeasurement(Measurement measurement) {
        Metric customMetric = ((CustomMetricMeasurement) measurement).getCustomMetric();
        customMetric.setName(formatMetricName(customMetric.getName()));
        addMetric(customMetric);
    }
}
