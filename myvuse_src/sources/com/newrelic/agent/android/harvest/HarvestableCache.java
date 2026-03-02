package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.Harvestable;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class HarvestableCache {
    private static final int DEFAULT_CACHE_LIMIT = 1024;
    private int limit = 1024;
    private final Collection<Harvestable> cache = getNewCache();

    protected Collection<Harvestable> getNewCache() {
        return new CopyOnWriteArrayList();
    }

    public void add(Harvestable harvestable) {
        if (harvestable == null || this.cache.size() >= this.limit) {
            return;
        }
        this.cache.add(harvestable);
    }

    public boolean get(Object obj) {
        return this.cache.contains(obj);
    }

    public Collection<Harvestable> flush() {
        if (this.cache.size() == 0) {
            return Collections.emptyList();
        }
        Collection<Harvestable> newCache = getNewCache();
        newCache.addAll(this.cache);
        this.cache.clear();
        return newCache;
    }

    public int getSize() {
        return this.cache.size();
    }

    public void setLimit(int i) {
        this.limit = i;
    }
}
