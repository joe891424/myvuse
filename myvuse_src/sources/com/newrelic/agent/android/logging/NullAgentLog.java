package com.newrelic.agent.android.logging;

/* JADX INFO: loaded from: classes6.dex */
public class NullAgentLog implements AgentLog {
    @Override // com.newrelic.agent.android.logging.AgentLog
    public void audit(String str) {
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void debug(String str) {
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void error(String str) {
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void error(String str, Throwable th) {
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public int getLevel() {
        return 5;
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void info(String str) {
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void setLevel(int i) {
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void verbose(String str) {
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void warn(String str) {
    }
}
