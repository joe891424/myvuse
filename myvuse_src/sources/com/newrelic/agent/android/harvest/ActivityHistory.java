package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ActivityHistory extends HarvestableArray {
    private final List<ActivitySighting> activityHistory;

    public ActivityHistory(List<ActivitySighting> list) {
        this.activityHistory = list;
    }

    public int size() {
        return this.activityHistory.size();
    }

    @Override // com.newrelic.agent.android.harvest.type.HarvestableArray, com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        Iterator<ActivitySighting> it2 = this.activityHistory.iterator();
        while (it2.hasNext()) {
            jsonArray.add(it2.next().asJsonArray());
        }
        return jsonArray;
    }

    public JsonArray asJsonArrayWithoutDuration() {
        JsonArray jsonArray = new JsonArray();
        Iterator<ActivitySighting> it2 = this.activityHistory.iterator();
        while (it2.hasNext()) {
            jsonArray.add(it2.next().asJsonArrayWithoutDuration());
        }
        return jsonArray;
    }

    public static ActivityHistory newFromJson(JsonArray jsonArray) {
        ArrayList arrayList = new ArrayList();
        Iterator<JsonElement> it2 = jsonArray.iterator();
        while (it2.hasNext()) {
            arrayList.add(ActivitySighting.newFromJson(it2.next().getAsJsonArray()));
        }
        return new ActivityHistory(arrayList);
    }
}
