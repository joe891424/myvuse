package com.newrelic.agent.android.payload;

import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.harvest.HarvestLifecycleAware;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public abstract class PayloadReporter implements HarvestLifecycleAware {
    protected static final AgentLog log = AgentLogManager.getAgentLog();
    protected final AgentConfiguration agentConfiguration;
    protected final AtomicBoolean isEnabled = new AtomicBoolean(false);
    protected final AtomicBoolean isStarted = new AtomicBoolean(false);

    @Override // com.newrelic.agent.android.harvest.HarvestLifecycleAware
    public void onHarvestConfigurationChanged() {
    }

    protected abstract void start();

    protected abstract void stop();

    public PayloadReporter(AgentConfiguration agentConfiguration) {
        this.agentConfiguration = agentConfiguration;
    }

    public boolean isEnabled() {
        return this.isEnabled.get();
    }

    public boolean isStarted() {
        return this.isStarted.get();
    }

    public void setEnabled(boolean z) {
        this.isEnabled.set(z);
    }

    public AgentConfiguration getAgentConfiguration() {
        return this.agentConfiguration;
    }

    protected boolean isPayloadStale(Payload payload) {
        return payload.isStale(this.agentConfiguration.getPayloadTTL());
    }
}
