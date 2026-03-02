package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class AgentHealthExceptions extends HarvestableObject {
    private static final JsonArray keyArray = new JsonArray();
    private final Map<String, AgentHealthException> agentHealthExceptions = new ConcurrentHashMap();

    public AgentHealthExceptions() {
        JsonArray jsonArray = keyArray;
        jsonArray.add(new JsonPrimitive("ExceptionClass"));
        jsonArray.add(new JsonPrimitive("Message"));
        jsonArray.add(new JsonPrimitive("ThreadName"));
        jsonArray.add(new JsonPrimitive("CallStack"));
        jsonArray.add(new JsonPrimitive("Count"));
        jsonArray.add(new JsonPrimitive("Extras"));
    }

    public void add(AgentHealthException agentHealthException) {
        String key = getKey(agentHealthException);
        synchronized (this.agentHealthExceptions) {
            AgentHealthException agentHealthException2 = this.agentHealthExceptions.get(key);
            if (agentHealthException2 == null) {
                this.agentHealthExceptions.put(key, agentHealthException);
            } else {
                agentHealthException2.increment();
            }
        }
    }

    public void clear() {
        synchronized (this.agentHealthExceptions) {
            this.agentHealthExceptions.clear();
        }
    }

    public boolean isEmpty() {
        return this.agentHealthExceptions.isEmpty();
    }

    public Map<String, AgentHealthException> getAgentHealthExceptions() {
        return this.agentHealthExceptions;
    }

    public final String getKey(AgentHealthException agentHealthException) {
        String name = getClass().getName();
        if (agentHealthException == null) {
            return name;
        }
        return agentHealthException.getExceptionClass() + agentHealthException.getStackTrace()[0].toString();
    }

    @Override // com.newrelic.agent.android.harvest.type.HarvestableObject, com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public JsonObject asJsonObject() {
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        Iterator<AgentHealthException> it2 = this.agentHealthExceptions.values().iterator();
        while (it2.hasNext()) {
            jsonArray.add(it2.next().asJsonArray());
        }
        jsonObject.add("Type", new JsonPrimitive("AgentErrors"));
        jsonObject.add("Keys", keyArray);
        jsonObject.add("Data", jsonArray);
        return jsonObject;
    }
}
