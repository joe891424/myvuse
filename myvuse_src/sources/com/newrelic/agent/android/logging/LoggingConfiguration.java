package com.newrelic.agent.android.logging;

import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class LoggingConfiguration {

    @SerializedName(ViewProps.ENABLED)
    boolean enabled;

    @SerializedName(FirebaseAnalytics.Param.LEVEL)
    LogLevel level;

    public LoggingConfiguration() {
        this(false, LogLevel.NONE);
    }

    public LoggingConfiguration(boolean z, LogLevel logLevel) {
        this.enabled = z;
        this.level = logLevel;
    }

    public void setConfiguration(AgentConfiguration agentConfiguration) {
        setConfiguration(agentConfiguration.getLogReportingConfiguration());
    }

    public void setConfiguration(LoggingConfiguration loggingConfiguration) {
        this.enabled = loggingConfiguration.enabled;
        this.level = loggingConfiguration.level;
    }

    public boolean getLoggingEnabled() {
        return this.enabled;
    }

    public boolean setLoggingEnabled(boolean z) {
        this.enabled = z;
        return z;
    }

    public LogLevel getLogLevel() {
        return this.level;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.level = logLevel;
    }

    public String toString() {
        return "\"LoggingConfiguration\" {\"enabled\"=" + this.enabled + ", \"level\"=\"" + String.valueOf(this.level) + "\"}";
    }
}
