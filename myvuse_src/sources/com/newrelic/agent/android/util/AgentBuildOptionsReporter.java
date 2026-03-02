package com.newrelic.agent.android.util;

import com.newrelic.agent.android.Agent;

/* JADX INFO: loaded from: classes6.dex */
public class AgentBuildOptionsReporter {
    public static void main(String[] strArr) {
        System.out.println("Agent version: " + Agent.getVersion());
        System.out.println("Build ID: " + Agent.getBuildId());
    }
}
