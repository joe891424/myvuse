package com.newrelic.agent.android.logging;

import com.newrelic.com.google.gson.annotations.SerializedName;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class LogReportingConfiguration extends LoggingConfiguration {

    @SerializedName("expiration_period")
    Long expirationPeriod;

    @SerializedName("data_report_period")
    Long harvestPeriod;

    @SerializedName("sampling_rate")
    double sampleRate;
    static Double sampleSeed = Double.valueOf(100.0d);
    static final long DEFAULT_HARVEST_PERIOD = TimeUnit.SECONDS.convert(30, TimeUnit.SECONDS);
    static final long DEFAULT_EXPIRATION_PERIOD = TimeUnit.SECONDS.convert(2, TimeUnit.DAYS);

    public LogReportingConfiguration() {
        this(false, LogLevel.NONE);
    }

    public LogReportingConfiguration(boolean z, LogLevel logLevel) {
        this(z, logLevel, DEFAULT_HARVEST_PERIOD, DEFAULT_EXPIRATION_PERIOD, sampleSeed.doubleValue());
    }

    public LogReportingConfiguration(boolean z, LogLevel logLevel, long j, long j2, double d) {
        super(z, logLevel);
        this.harvestPeriod = Long.valueOf(j);
        this.expirationPeriod = Long.valueOf(j2);
        this.sampleRate = Math.min(100.0d, Math.max(0.0d, d));
    }

    public void setConfiguration(LogReportingConfiguration logReportingConfiguration) {
        super.setConfiguration((LoggingConfiguration) logReportingConfiguration);
        this.enabled = logReportingConfiguration.enabled;
        this.level = logReportingConfiguration.level;
        this.sampleRate = logReportingConfiguration.sampleRate;
    }

    public long getHarvestPeriod() {
        return this.harvestPeriod.longValue();
    }

    public long getExpirationPeriod() {
        return this.expirationPeriod.longValue();
    }

    @Override // com.newrelic.agent.android.logging.LoggingConfiguration
    public String toString() {
        return "{\"enabled\"=" + this.enabled + ",\"level\"=\"" + String.valueOf(this.level) + "\",\"data_report_period\"=" + this.harvestPeriod + ",\"expiration_period\"=" + this.expirationPeriod + ",\"sampling_rate\"=" + this.sampleRate + "}";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LogReportingConfiguration)) {
            return false;
        }
        LogReportingConfiguration logReportingConfiguration = (LogReportingConfiguration) obj;
        return this.enabled == logReportingConfiguration.enabled && this.level.equals(logReportingConfiguration.level) && this.sampleRate == logReportingConfiguration.sampleRate;
    }

    @Override // com.newrelic.agent.android.logging.LoggingConfiguration
    public boolean getLoggingEnabled() {
        return this.enabled && isSampled();
    }

    public boolean isSampled() {
        return sampleSeed.doubleValue() <= this.sampleRate;
    }

    public static Double reseed() {
        Double dValueOf = Double.valueOf(Math.round((Math.random() * 100.0d) * 1000000.0d) / 1000000.0d);
        sampleSeed = dValueOf;
        return dValueOf;
    }
}
