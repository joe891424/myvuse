package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.JsonArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class Events extends HarvestableArray {
    private final Collection<Event> events = new ArrayList();

    @Override // com.newrelic.agent.android.harvest.type.HarvestableArray, com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        Iterator<Event> it2 = this.events.iterator();
        while (it2.hasNext()) {
            jsonArray.add(it2.next().asJson());
        }
        return jsonArray;
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }
}
