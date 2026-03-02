package com.newrelic.agent.android.logging;

import android.util.Log;

/* JADX INFO: loaded from: classes6.dex */
public class AndroidAgentLog implements AgentLog {
    protected static final String TAG = "newrelic";
    protected int level = 3;

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void audit(String str) {
        if (this.level == 6) {
            Log.d("newrelic", str);
        }
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void debug(String str) {
        if (this.level >= 5) {
            Log.d("newrelic", str);
        }
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void verbose(String str) {
        if (this.level >= 4) {
            Log.v("newrelic", str);
        }
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void info(String str) {
        if (this.level >= 3) {
            Log.i("newrelic", str);
        }
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void warn(String str) {
        if (this.level >= 2) {
            Log.w("newrelic", str);
        }
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void error(String str) {
        if (this.level >= 1) {
            Log.e("newrelic", str);
        }
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void error(String str, Throwable th) {
        if (this.level >= 1) {
            Log.e("newrelic", str, th);
        }
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public int getLevel() {
        return this.level;
    }

    @Override // com.newrelic.agent.android.logging.AgentLog
    public void setLevel(int i) {
        if (i <= 6 && i >= 1) {
            this.level = i;
            return;
        }
        throw new IllegalArgumentException("Log level is not between ERROR and AUDIT");
    }
}
