package com.newrelic.agent.android.logging;

import com.yoti.mobile.android.remote.debug.RemoteDebugPreferencesKt;

/* JADX INFO: loaded from: classes6.dex */
public class ConsoleAgentLog implements AgentLog {
    private int level = 3;

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void audit(String str) {
        if (this.level == 6) {
            print("AUDIT", str);
        }
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void debug(String str) {
        if (this.level >= 5) {
            print("DEBUG", str);
        }
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void verbose(String str) {
        if (this.level >= 4) {
            print("VERBOSE", str);
        }
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void info(String str) {
        if (this.level >= 3) {
            print("INFO", str);
        }
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void warn(String str) {
        if (this.level >= 2) {
            print("WARN", str);
        }
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void error(String str, Throwable th) {
        if (this.level >= 1) {
            print(RemoteDebugPreferencesKt.DEBUG_OPTIONS_REMOTE_BEHAVIOUR_ERROR, str + " " + th.getMessage());
        }
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void error(String str) {
        if (this.level >= 1) {
            print(RemoteDebugPreferencesKt.DEBUG_OPTIONS_REMOTE_BEHAVIOUR_ERROR, str);
        }
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public int getLevel() {
        return this.level;
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void setLevel(int i) {
        this.level = i;
    }

    private static void print(String str, String str2) {
        System.out.println("[" + str + "][newrelic] " + str2);
    }
}
