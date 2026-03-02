package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonPrimitive;

/* JADX INFO: loaded from: classes6.dex */
public class DataToken extends HarvestableArray {
    private int accountId;
    private int agentId;

    public DataToken() {
        clear();
    }

    public DataToken(int i, int i2) {
        this.accountId = i;
        this.agentId = i2;
    }

    @Override // com.newrelic.agent.android.harvest.type.HarvestableArray, com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(new JsonPrimitive(Integer.valueOf(this.accountId)));
        jsonArray.add(new JsonPrimitive(Integer.valueOf(this.agentId)));
        return jsonArray;
    }

    public void clear() {
        this.accountId = 0;
        this.agentId = 0;
    }

    public int getAccountId() {
        return this.accountId;
    }

    public void setAccountId(int i) {
        this.accountId = i;
    }

    public int getAgentId() {
        return this.agentId;
    }

    public void setAgentId(int i) {
        this.agentId = i;
    }

    public boolean isValid() {
        return this.accountId > 0 && this.agentId > 0;
    }

    public static DataToken newFromJson(JsonArray jsonArray) {
        DataToken dataToken = new DataToken();
        dataToken.setAccountId(jsonArray.get(0).getAsInt());
        dataToken.setAgentId(jsonArray.get(1).getAsInt());
        return dataToken;
    }

    public String toString() {
        return "DataToken{accountId=" + this.accountId + ", agentId=" + this.agentId + "}";
    }

    public int[] asIntArray() {
        return new int[]{this.accountId, this.agentId};
    }
}
