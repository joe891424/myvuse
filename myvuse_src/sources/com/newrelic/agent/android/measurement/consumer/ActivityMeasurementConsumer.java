package com.newrelic.agent.android.measurement.consumer;

import com.newrelic.agent.android.measurement.MeasurementType;

/* JADX INFO: loaded from: classes6.dex */
public class ActivityMeasurementConsumer extends MetricMeasurementConsumer {
    @Override // com.newrelic.agent.android.measurement.consumer.MetricMeasurementConsumer
    protected String formatMetricName(String str) {
        return str;
    }

    public ActivityMeasurementConsumer() {
        super(MeasurementType.Activity);
    }
}
