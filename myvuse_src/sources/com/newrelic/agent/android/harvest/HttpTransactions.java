package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.JsonArray;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class HttpTransactions extends HarvestableArray {
    private final Collection<HttpTransaction> httpTransactions = new CopyOnWriteArrayList();

    public synchronized void add(HttpTransaction httpTransaction) {
        this.httpTransactions.add(httpTransaction);
    }

    public synchronized void remove(HttpTransaction httpTransaction) {
        this.httpTransactions.remove(httpTransaction);
    }

    public void clear() {
        this.httpTransactions.clear();
    }

    @Override // com.newrelic.agent.android.harvest.type.HarvestableArray, com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        Iterator<HttpTransaction> it2 = this.httpTransactions.iterator();
        while (it2.hasNext()) {
            jsonArray.add(it2.next().asJson());
        }
        return jsonArray;
    }

    public Collection<HttpTransaction> getHttpTransactions() {
        return this.httpTransactions;
    }

    public int count() {
        return this.httpTransactions.size();
    }

    public String toString() {
        return "HttpTransactions{httpTransactions=" + String.valueOf(this.httpTransactions) + "}";
    }
}
