package io.branch.rnbranch;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class AgingHash<KeyType, ValueType> {
    private HashMap<KeyType, AgingItem<ValueType>> mHash = new HashMap<>();
    private long mTtlMillis;

    public AgingHash(long j) {
        this.mTtlMillis = j;
    }

    public long getTtlMillis() {
        return this.mTtlMillis;
    }

    public void put(KeyType keytype, ValueType valuetype) {
        ageItems();
        this.mHash.put(keytype, new AgingItem<>(valuetype));
    }

    public ValueType get(KeyType keytype) {
        AgingItem<ValueType> agingItem = this.mHash.get(keytype);
        if (agingItem == null) {
            return null;
        }
        return agingItem.get();
    }

    public void remove(KeyType keytype) {
        this.mHash.remove(keytype);
    }

    private void ageItems() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator<Map.Entry<KeyType, AgingItem<ValueType>>> it2 = this.mHash.entrySet().iterator();
        while (it2.hasNext()) {
            if (jCurrentTimeMillis - it2.next().getValue().getAccessTime() >= this.mTtlMillis) {
                it2.remove();
            }
        }
    }
}
