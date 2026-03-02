package com.newrelic.agent.android.harvest.type;

import com.newrelic.agent.android.harvest.type.Harvestable;
import com.newrelic.com.google.gson.JsonArray;

/* JADX INFO: loaded from: classes6.dex */
public abstract class HarvestableArray extends BaseHarvestable {
    @Override // com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public abstract JsonArray asJsonArray();

    public HarvestableArray() {
        super(Harvestable.Type.ARRAY);
    }
}
