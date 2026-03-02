package com.newrelic.agent.android;

import com.newrelic.agent.android.aei.ApplicationExitConfiguration;
import com.newrelic.agent.android.harvest.HarvestConfigurable;
import com.newrelic.agent.android.harvest.HarvestLifecycleAware;
import com.newrelic.agent.android.logging.LogLevel;
import com.newrelic.agent.android.logging.LogReportingConfiguration;
import com.newrelic.com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class RemoteConfiguration implements HarvestLifecycleAware, HarvestConfigurable {

    @SerializedName("application_exit_info")
    protected ApplicationExitConfiguration applicationExitConfiguration = new ApplicationExitConfiguration(true);

    @SerializedName("logs")
    protected LogReportingConfiguration logReportingConfiguration = new LogReportingConfiguration(false, LogLevel.INFO);

    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvestConfigurationChanged() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RemoteConfiguration)) {
            return false;
        }
        RemoteConfiguration remoteConfiguration = (RemoteConfiguration) obj;
        return this.applicationExitConfiguration.equals(remoteConfiguration.applicationExitConfiguration) && this.logReportingConfiguration.equals(remoteConfiguration.logReportingConfiguration);
    }

    public LogReportingConfiguration getLogReportingConfiguration() {
        return this.logReportingConfiguration;
    }

    public void setLogReportingConfiguration(LogReportingConfiguration logReportingConfiguration) {
        this.logReportingConfiguration = logReportingConfiguration;
    }

    public ApplicationExitConfiguration getApplicationExitConfiguration() {
        return this.applicationExitConfiguration;
    }

    public void setApplicationExitConfiguration(ApplicationExitConfiguration applicationExitConfiguration) {
        this.applicationExitConfiguration = applicationExitConfiguration;
    }
}
