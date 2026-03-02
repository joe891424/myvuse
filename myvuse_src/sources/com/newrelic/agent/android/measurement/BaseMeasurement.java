package com.newrelic.agent.android.measurement;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;

/* JADX INFO: loaded from: classes6.dex */
public class BaseMeasurement implements Measurement {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private long endTime;
    private long exclusiveTime;
    private boolean finished;
    private String name;
    private String scope;
    private long startTime;
    private ThreadInfo threadInfo;
    private MeasurementType type;

    public BaseMeasurement(MeasurementType measurementType) {
        setType(measurementType);
    }

    public BaseMeasurement(Measurement measurement) {
        setType(measurement.getType());
        setName(measurement.getName());
        setScope(measurement.getScope());
        setStartTime(measurement.getStartTime());
        setEndTime(measurement.getEndTime());
        setExclusiveTime(measurement.getExclusiveTime());
        setThreadInfo(measurement.getThreadInfo());
        this.finished = measurement.isFinished();
    }

    void setType(MeasurementType measurementType) {
        if (logIfFinished()) {
            return;
        }
        this.type = measurementType;
    }

    public void setName(String str) {
        if (logIfFinished()) {
            return;
        }
        this.name = str;
    }

    public void setScope(String str) {
        if (logIfFinished()) {
            return;
        }
        this.scope = str;
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
        long j2 = this.startTime;
        if (j < j2) {
            log.error("Measurement end time must not precede start time - startTime: " + j2 + " endTime: " + j);
        } else {
            this.endTime = j;
        }
    }

    public void setExclusiveTime(long j) {
        if (logIfFinished()) {
            return;
        }
        this.exclusiveTime = j;
    }

    @Override // com.newrelic.agent.android.measurement.Measurement
    public MeasurementType getType() {
        return this.type;
    }

    @Override // com.newrelic.agent.android.measurement.Measurement
    public String getName() {
        return this.name;
    }

    @Override // com.newrelic.agent.android.measurement.Measurement
    public String getScope() {
        return this.scope;
    }

    @Override // com.newrelic.agent.android.measurement.Measurement
    public long getStartTime() {
        return this.startTime;
    }

    @Override // com.newrelic.agent.android.measurement.Measurement
    public double getStartTimeInSeconds() {
        return this.startTime / 1000.0d;
    }

    @Override // com.newrelic.agent.android.measurement.Measurement
    public long getEndTime() {
        return this.endTime;
    }

    @Override // com.newrelic.agent.android.measurement.Measurement
    public double getEndTimeInSeconds() {
        return this.endTime / 1000.0d;
    }

    @Override // com.newrelic.agent.android.measurement.Measurement
    public long getExclusiveTime() {
        return this.exclusiveTime;
    }

    @Override // com.newrelic.agent.android.measurement.Measurement
    public double getExclusiveTimeInSeconds() {
        return this.exclusiveTime / 1000.0d;
    }

    @Override // com.newrelic.agent.android.measurement.Measurement
    public double asDouble() {
        throw new UnsupportedOperationException();
    }

    @Override // com.newrelic.agent.android.measurement.Measurement
    public ThreadInfo getThreadInfo() {
        return this.threadInfo;
    }

    public void setThreadInfo(ThreadInfo threadInfo) {
        this.threadInfo = threadInfo;
    }

    @Override // com.newrelic.agent.android.measurement.Measurement
    public boolean isInstantaneous() {
        return this.endTime == 0;
    }

    @Override // com.newrelic.agent.android.measurement.Measurement
    public void finish() {
        if (this.finished) {
            throw new MeasurementException("Finish called on already finished Measurement");
        }
        this.finished = true;
    }

    @Override // com.newrelic.agent.android.measurement.Measurement
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

    public String toString() {
        return "BaseMeasurement{type=" + String.valueOf(this.type) + ", name='" + this.name + "', scope='" + this.scope + "', startTime=" + this.startTime + ", endTime=" + this.endTime + ", exclusiveTime=" + this.exclusiveTime + ", threadInfo=" + String.valueOf(this.threadInfo) + ", finished=" + this.finished + "}";
    }
}
