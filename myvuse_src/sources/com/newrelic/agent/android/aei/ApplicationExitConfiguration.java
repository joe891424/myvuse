package com.newrelic.agent.android.aei;

import com.facebook.react.uimanager.ViewProps;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class ApplicationExitConfiguration {

    @SerializedName(ViewProps.ENABLED)
    boolean enabled;

    public ApplicationExitConfiguration(boolean z) {
        this.enabled = z;
    }

    public boolean isEnabled() {
        return this.enabled && FeatureFlag.featureEnabled(FeatureFlag.ApplicationExitReporting);
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void setConfiguration(ApplicationExitConfiguration applicationExitConfiguration) {
        if (applicationExitConfiguration.equals(this)) {
            return;
        }
        boolean z = this.enabled;
        if (!z && applicationExitConfiguration.enabled) {
            StatsEngine.SUPPORTABILITY.inc("Supportability/AgentHealth/ApplicationExitInfo/remoteConfiguration/enabled");
        } else if (z && !applicationExitConfiguration.enabled) {
            StatsEngine.SUPPORTABILITY.inc("Supportability/AgentHealth/ApplicationExitInfo/remoteConfiguration/disabled");
        }
        this.enabled = applicationExitConfiguration.enabled;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ApplicationExitConfiguration) && this.enabled == ((ApplicationExitConfiguration) obj).enabled;
    }

    public String toString() {
        return "{\"enabled\"=" + this.enabled + "}";
    }
}
