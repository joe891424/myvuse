package com.newrelic.agent.android.activity;

import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementPool;
import com.newrelic.agent.android.measurement.ThreadInfo;

/* JADX INFO: loaded from: classes6.dex */
public interface MeasuredActivity {
    void finish();

    String getBackgroundMetricName();

    long getEndTime();

    Measurement getEndingMeasurement();

    ThreadInfo getEndingThread();

    MeasurementPool getMeasurementPool();

    String getMetricName();

    String getName();

    long getStartTime();

    Measurement getStartingMeasurement();

    ThreadInfo getStartingThread();

    boolean isAutoInstrumented();

    boolean isFinished();

    void setName(String str);
}
