package com.newrelic.agent.android.logging;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.newrelic.agent.android.Agent;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class ForwardingAgentLog implements AgentLog {
    private final AgentLog delegate;

    public ForwardingAgentLog(AgentLog agentLog) {
        this.delegate = agentLog;
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void audit(String str) {
        this.delegate.audit(str);
        if (this.delegate.getLevel() == 6 && (LogReporting.getLogger() instanceof RemoteLogger)) {
            LogReporting.getLogger().logAttributes(asAttributes(LogLevel.DEBUG, str));
        }
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void debug(String str) {
        this.delegate.debug(str);
        if (this.delegate.getLevel() < 5 || !(LogReporting.getLogger() instanceof RemoteLogger)) {
            return;
        }
        LogReporting.getLogger().logAttributes(asAttributes(LogLevel.DEBUG, str));
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void verbose(String str) {
        this.delegate.verbose(str);
        if (this.delegate.getLevel() < 4 || !(LogReporting.getLogger() instanceof RemoteLogger)) {
            return;
        }
        LogReporting.getLogger().logAttributes(asAttributes(LogLevel.VERBOSE, str));
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void info(String str) {
        this.delegate.info(str);
        if (this.delegate.getLevel() < 3 || !(LogReporting.getLogger() instanceof RemoteLogger)) {
            return;
        }
        LogReporting.getLogger().logAttributes(asAttributes(LogLevel.INFO, str));
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void warn(String str) {
        this.delegate.warn(str);
        if (this.delegate.getLevel() < 2 || !(LogReporting.getLogger() instanceof RemoteLogger)) {
            return;
        }
        LogReporting.getLogger().logAttributes(asAttributes(LogLevel.WARN, str));
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void error(String str) {
        this.delegate.error(str);
        if (this.delegate.getLevel() < 1 || !(LogReporting.getLogger() instanceof RemoteLogger)) {
            return;
        }
        LogReporting.getLogger().logAttributes(asAttributes(LogLevel.ERROR, str));
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void error(String str, Throwable th) {
        this.delegate.error(str, th);
        if (this.delegate.getLevel() < 1 || !(LogReporting.getLogger() instanceof RemoteLogger)) {
            return;
        }
        Map<String, Object> mapAsAttributes = asAttributes(LogLevel.ERROR, str);
        mapAsAttributes.put("error.message", th.toString());
        mapAsAttributes.put("error.stack", th.getStackTrace()[0].toString());
        mapAsAttributes.put("error.class", th.getClass().getSimpleName());
        LogReporting.getLogger().logAttributes(mapAsAttributes);
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public int getLevel() {
        return this.delegate.getLevel();
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void setLevel(int i) {
        this.delegate.setLevel(i);
    }

    Map<String, Object> asAttributes(LogLevel logLevel, String str) {
        HashMap map = new HashMap();
        map.put(FirebaseAnalytics.Param.LEVEL, logLevel.name());
        map.put("message", str);
        map.put("logger", "Android agent " + Agent.getVersion());
        return map;
    }
}
