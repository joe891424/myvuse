package com.newrelic.agent.android.measurement;

/* JADX INFO: loaded from: classes6.dex */
public class ActivityMeasurement extends BaseMeasurement {
    public ActivityMeasurement(String str, long j, long j2) {
        super(MeasurementType.Activity);
        setName(str);
        setStartTime(j);
        setEndTime(j2);
    }
}
