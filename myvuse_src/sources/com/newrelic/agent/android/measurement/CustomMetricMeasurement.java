package com.newrelic.agent.android.measurement;

import com.newrelic.agent.android.metric.Metric;

/* JADX INFO: loaded from: classes6.dex */
public class CustomMetricMeasurement extends CategorizedMeasurement {
    private Metric customMetric;

    public CustomMetricMeasurement() {
        super(MeasurementType.Custom);
    }

    public CustomMetricMeasurement(String str, int i, double d, double d2) {
        this();
        setName(str);
        Metric metric = new Metric(str);
        this.customMetric = metric;
        metric.sample(d);
        this.customMetric.setCount(i);
        this.customMetric.setExclusive(Double.valueOf(d2));
    }

    public Metric getCustomMetric() {
        return this.customMetric;
    }
}
