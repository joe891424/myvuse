package com.newrelic.agent.android.measurement.consumer;

import com.newrelic.agent.android.measurement.MeasurementType;

/* JADX INFO: loaded from: classes6.dex */
public class MethodMeasurementConsumer extends MetricMeasurementConsumer {
    private static final String METRIC_PREFIX = "Method/";

    public MethodMeasurementConsumer() {
        super(MeasurementType.Method);
    }

    @Override // com.newrelic.agent.android.measurement.consumer.MetricMeasurementConsumer
    protected String formatMetricName(String str) {
        return METRIC_PREFIX + str.replace("#", "/");
    }
}
