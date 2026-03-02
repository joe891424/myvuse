package com.newrelic.agent.android.activity;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementException;
import com.newrelic.agent.android.measurement.MeasurementPool;
import com.newrelic.agent.android.measurement.ThreadInfo;
import com.newrelic.agent.android.tracing.TraceMachine;

/* JADX INFO: loaded from: classes6.dex */
public class BaseMeasuredActivity implements MeasuredActivity {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private boolean autoInstrumented;
    private long endTime;
    private Measurement endingMeasurement;
    private ThreadInfo endingThread;
    private boolean finished;
    private MeasurementPool measurementPool;
    private String name;
    private long startTime;
    private Measurement startingMeasurement;
    private ThreadInfo startingThread;

    @Override // com.newrelic.agent.android.activity.MeasuredActivity
    public String getName() {
        return this.name;
    }

    @Override // com.newrelic.agent.android.activity.MeasuredActivity
    public String getMetricName() {
        return TraceMachine.formatActivityMetricName(this.name);
    }

    @Override // com.newrelic.agent.android.activity.MeasuredActivity
    public String getBackgroundMetricName() {
        return TraceMachine.formatActivityBackgroundMetricName(this.name);
    }

    @Override // com.newrelic.agent.android.activity.MeasuredActivity
    public long getStartTime() {
        return this.startTime;
    }

    @Override // com.newrelic.agent.android.activity.MeasuredActivity
    public long getEndTime() {
        return this.endTime;
    }

    @Override // com.newrelic.agent.android.activity.MeasuredActivity
    public ThreadInfo getStartingThread() {
        return this.startingThread;
    }

    @Override // com.newrelic.agent.android.activity.MeasuredActivity
    public ThreadInfo getEndingThread() {
        return this.endingThread;
    }

    @Override // com.newrelic.agent.android.activity.MeasuredActivity
    public boolean isAutoInstrumented() {
        return this.autoInstrumented;
    }

    @Override // com.newrelic.agent.android.activity.MeasuredActivity
    public Measurement getStartingMeasurement() {
        return this.startingMeasurement;
    }

    @Override // com.newrelic.agent.android.activity.MeasuredActivity
    public Measurement getEndingMeasurement() {
        return this.endingMeasurement;
    }

    @Override // com.newrelic.agent.android.activity.MeasuredActivity
    public MeasurementPool getMeasurementPool() {
        return this.measurementPool;
    }

    @Override // com.newrelic.agent.android.activity.MeasuredActivity
    public void setName(String str) {
        if (logIfFinished()) {
            return;
        }
        this.name = str;
    }

    public void setStartTime(long j) {
        if (logIfFinished()) {
            return;
        }
        this.startTime = j;
    }

    public void setEndTime(long j) {
        if (logIfFinished()) {
            return;
        }
        this.endTime = j;
    }

    public void setStartingThread(ThreadInfo threadInfo) {
        if (logIfFinished()) {
            return;
        }
        this.startingThread = threadInfo;
    }

    public void setEndingThread(ThreadInfo threadInfo) {
        if (logIfFinished()) {
            return;
        }
        this.endingThread = threadInfo;
    }

    public void setAutoInstrumented(boolean z) {
        if (logIfFinished()) {
            return;
        }
        this.autoInstrumented = z;
    }

    public void setStartingMeasurement(Measurement measurement) {
        if (logIfFinished()) {
            return;
        }
        this.startingMeasurement = measurement;
    }

    public void setEndingMeasurement(Measurement measurement) {
        if (logIfFinished()) {
            return;
        }
        this.endingMeasurement = measurement;
    }

    public void setMeasurementPool(MeasurementPool measurementPool) {
        if (logIfFinished()) {
            return;
        }
        this.measurementPool = measurementPool;
    }

    @Override // com.newrelic.agent.android.activity.MeasuredActivity
    public void finish() {
        this.finished = true;
    }

    @Override // com.newrelic.agent.android.activity.MeasuredActivity
    public boolean isFinished() {
        return this.finished;
    }

    private void throwIfFinished() {
        if (this.finished) {
            throw new MeasurementException("Attempted to modify finished Measurement");
        }
    }

    private boolean logIfFinished() {
        if (this.finished) {
            log.warn("BaseMeasuredActivity: cannot modify finished Activity");
        }
        return this.finished;
    }
}
