package com.newrelic.agent.android.metric;

/* JADX INFO: loaded from: classes6.dex */
public enum MetricUnit {
    PERCENT("%"),
    BYTES("bytes"),
    SECONDS("sec"),
    BYTES_PER_SECOND("bytes/second"),
    OPERATIONS("op");

    private String label;

    MetricUnit(String str) {
        this.label = str;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }
}
