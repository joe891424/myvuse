package com.salesforce.marketingcloud.registration;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.registration.b */
/* JADX INFO: loaded from: classes6.dex */
class C4307b implements Map<String, String> {

    /* JADX INFO: renamed from: a */
    private final HashMap<String, String> f5461a;

    /* JADX INFO: renamed from: b */
    private final TreeMap<String, String> f5462b;

    C4307b() {
        this.f5461a = new HashMap<>();
        this.f5462b = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String get(Object obj) {
        String str = this.f5462b.get(obj);
        if (str != null) {
            return this.f5461a.get(str);
        }
        return null;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String remove(Object obj) {
        return this.f5461a.remove(this.f5462b.remove(obj));
    }

    @Override // java.util.Map
    public void clear() {
        this.f5461a.clear();
        this.f5462b.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f5462b.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f5461a.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, String>> entrySet() {
        return this.f5461a.entrySet();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f5461a.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.f5461a.keySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<? extends String, ? extends String> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public int size() {
        return this.f5461a.size();
    }

    @Override // java.util.Map
    public Collection<String> values() {
        return this.f5461a.values();
    }

    C4307b(Map<String, String> map) {
        this();
        if (map != null) {
            this.f5461a.putAll(map);
            for (String str : this.f5461a.keySet()) {
                this.f5462b.put(str, str);
            }
        }
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String put(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = this.f5462b.get(str);
        String strRemove = str3 != null ? this.f5461a.remove(str3) : null;
        this.f5462b.put(str, str);
        this.f5461a.put(str, str2);
        return strRemove;
    }
}
