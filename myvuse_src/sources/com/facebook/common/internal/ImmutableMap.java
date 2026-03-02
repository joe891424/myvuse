package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ImmutableMap<K, V> extends HashMap<K, V> {
    private ImmutableMap(Map<? extends K, ? extends V> map) {
        super(map);
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> Map<K, V> m1248of() {
        return Collections.unmodifiableMap(new HashMap());
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> Map<K, V> m1249of(K k, V v) {
        HashMap map = new HashMap(1);
        map.put(k, v);
        return Collections.unmodifiableMap(map);
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> Map<K, V> m1250of(K k, V v, K k2, V v2) {
        HashMap map = new HashMap(2);
        map.put(k, v);
        map.put(k2, v2);
        return Collections.unmodifiableMap(map);
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> Map<K, V> m1251of(K k, V v, K k2, V v2, K k3, V v3) {
        HashMap map = new HashMap(3);
        map.put(k, v);
        map.put(k2, v2);
        map.put(k3, v3);
        return Collections.unmodifiableMap(map);
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> Map<K, V> m1252of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        HashMap map = new HashMap(4);
        map.put(k, v);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        return Collections.unmodifiableMap(map);
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> Map<K, V> m1253of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        HashMap map = new HashMap(5);
        map.put(k, v);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        return Collections.unmodifiableMap(map);
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> Map<K, V> m1254of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        HashMap map = new HashMap(6);
        map.put(k, v);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        return Collections.unmodifiableMap(map);
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        return new ImmutableMap<>(map);
    }
}
