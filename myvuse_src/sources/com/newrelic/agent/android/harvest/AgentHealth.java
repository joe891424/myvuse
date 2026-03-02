package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.com.google.gson.JsonArray;
import java.text.MessageFormat;

/* JADX INFO: loaded from: classes6.dex */
public class AgentHealth extends HarvestableArray {
    public static final String DEFAULT_KEY = "Exception";
    private static final AgentLog log = AgentLogManager.getAgentLog();
    protected final AgentHealthExceptions agentHealthExceptions = new AgentHealthExceptions();

    public static void noticeException(Exception exc) {
        noticeException(exc != null ? new AgentHealthException(exc) : null);
    }

    public static void noticeException(AgentHealthException agentHealthException) {
        noticeException(agentHealthException, DEFAULT_KEY);
    }

    public static void noticeException(AgentHealthException agentHealthException, String str) {
        if (agentHealthException != null) {
            StatsEngine statsEngine = StatsEngine.get();
            if (statsEngine != null) {
                if (str == null) {
                    log.warn("Passed metric key is null. Defaulting to Exception");
                }
                if (str == null) {
                    str = DEFAULT_KEY;
                }
                statsEngine.inc(MessageFormat.format("Supportability/AgentHealth/{0}/{1}/{2}/{3}", str, agentHealthException.getSourceClass(), agentHealthException.getSourceMethod(), agentHealthException.getExceptionClass()));
                TaskQueue.queue(agentHealthException);
                return;
            }
            log.error("StatsEngine is null. Exception not recorded.");
            return;
        }
        log.error("AgentHealthException is null. StatsEngine not updated");
    }

    public void addException(AgentHealthException agentHealthException) {
        this.agentHealthExceptions.add(agentHealthException);
    }

    public void clear() {
        this.agentHealthExceptions.clear();
    }

    @Override // com.newrelic.agent.android.harvest.type.HarvestableArray, com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        if (!this.agentHealthExceptions.isEmpty()) {
            jsonArray.add(this.agentHealthExceptions.asJsonObject());
        }
        return jsonArray;
    }
}
