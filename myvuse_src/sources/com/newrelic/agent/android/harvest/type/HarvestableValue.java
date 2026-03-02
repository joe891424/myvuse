package com.newrelic.agent.android.harvest.type;

import com.newrelic.agent.android.harvest.type.Harvestable;
import com.newrelic.com.google.gson.JsonPrimitive;

/* JADX INFO: loaded from: classes6.dex */
public abstract class HarvestableValue extends BaseHarvestable {
    @Override // com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public abstract JsonPrimitive asJsonPrimitive();

    public HarvestableValue() {
        super(Harvestable.Type.VALUE);
    }
}
