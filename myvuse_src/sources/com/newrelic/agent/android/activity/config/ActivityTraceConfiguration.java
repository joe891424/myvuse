package com.newrelic.agent.android.activity.config;

/* JADX INFO: loaded from: classes6.dex */
public class ActivityTraceConfiguration {
    private int maxTotalTraceCount;

    public static ActivityTraceConfiguration defaultActivityTraceConfiguration() {
        ActivityTraceConfiguration activityTraceConfiguration = new ActivityTraceConfiguration();
        activityTraceConfiguration.setMaxTotalTraceCount(1);
        return activityTraceConfiguration;
    }

    public int getMaxTotalTraceCount() {
        return this.maxTotalTraceCount;
    }

    public void setMaxTotalTraceCount(int i) {
        this.maxTotalTraceCount = i;
    }

    public String toString() {
        return "ActivityTraceConfiguration{maxTotalTraceCount=" + this.maxTotalTraceCount + "}";
    }
}
