package com.newrelic.agent.android.tracing;

/* JADX INFO: loaded from: classes6.dex */
public class SampleValue {
    private boolean isDouble;
    private Double value = Double.valueOf(0.0d);

    public SampleValue(double d) {
        setValue(d);
    }

    public SampleValue(long j) {
        setValue(j);
    }

    public Number getValue() {
        if (this.isDouble) {
            return asDouble();
        }
        return asLong();
    }

    public Double asDouble() {
        return this.value;
    }

    public Long asLong() {
        return Long.valueOf(this.value.longValue());
    }

    public void setValue(double d) {
        this.value = Double.valueOf(d);
        this.isDouble = true;
    }

    public void setValue(long j) {
        this.value = Double.valueOf(j);
        this.isDouble = false;
    }

    public boolean isDouble() {
        return this.isDouble;
    }

    public void setDouble(boolean z) {
        this.isDouble = z;
    }
}
