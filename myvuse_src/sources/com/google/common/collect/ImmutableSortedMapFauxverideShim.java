package com.google.common.collect;

import com.google.common.collect.ImmutableSortedMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@ElementTypesAreNonnullByDefault
abstract class ImmutableSortedMapFauxverideShim<K, V> extends ImmutableMap<K, V> {
    ImmutableSortedMapFauxverideShim() {
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap.Builder<K, V> builder() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap.Builder<K, V> builderWithExpectedSize(int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableSortedMap<K, V> m2507of(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableSortedMap<K, V> m2508of(K k, V v, K k2, V v2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableSortedMap<K, V> m2509of(K k, V v, K k2, V v2, K k3, V v3) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableSortedMap<K, V> m2510of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableSortedMap<K, V> m2511of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableSortedMap<K, V> m2512of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableSortedMap<K, V> m2513of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableSortedMap<K, V> m2514of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableSortedMap<K, V> m2515of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableSortedMap<K, V> m2516of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entryArr) {
        throw new UnsupportedOperationException();
    }
}
