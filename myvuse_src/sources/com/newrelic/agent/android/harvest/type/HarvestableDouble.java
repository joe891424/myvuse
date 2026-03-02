package com.newrelic.agent.android.harvest.type;

import com.newrelic.com.google.gson.JsonPrimitive;

/* JADX INFO: loaded from: classes6.dex */
public class HarvestableDouble extends HarvestableValue {
    private double value;

    public HarvestableDouble() {
    }

    public HarvestableDouble(double d) {
        this();
        this.value = d;
    }

    @Override // com.newrelic.agent.android.harvest.type.HarvestableValue, com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public JsonPrimitive asJsonPrimitive() {
        return new JsonPrimitive(Double.valueOf(this.value));
    }
}
