package com.facebook.react.common;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class MapBuilder {
    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<>();
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> Map<K, V> m1348of() {
        return newHashMap();
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> Map<K, V> m1349of(K k, V v) {
        Map<K, V> mapM1348of = m1348of();
        mapM1348of.put(k, v);
        return mapM1348of;
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> Map<K, V> m1350of(K k, V v, K k2, V v2) {
        Map<K, V> mapM1348of = m1348of();
        mapM1348of.put(k, v);
        mapM1348of.put(k2, v2);
        return mapM1348of;
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> Map<K, V> m1351of(K k, V v, K k2, V v2, K k3, V v3) {
        Map<K, V> mapM1348of = m1348of();
        mapM1348of.put(k, v);
        mapM1348of.put(k2, v2);
        mapM1348of.put(k3, v3);
        return mapM1348of;
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> Map<K, V> m1352of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        Map<K, V> mapM1348of = m1348of();
        mapM1348of.put(k, v);
        mapM1348of.put(k2, v2);
        mapM1348of.put(k3, v3);
        mapM1348of.put(k4, v4);
        return mapM1348of;
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> Map<K, V> m1353of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Map<K, V> mapM1348of = m1348of();
        mapM1348of.put(k, v);
        mapM1348of.put(k2, v2);
        mapM1348of.put(k3, v3);
        mapM1348of.put(k4, v4);
        mapM1348of.put(k5, v5);
        return mapM1348of;
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> Map<K, V> m1354of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        Map<K, V> mapM1348of = m1348of();
        mapM1348of.put(k, v);
        mapM1348of.put(k2, v2);
        mapM1348of.put(k3, v3);
        mapM1348of.put(k4, v4);
        mapM1348of.put(k5, v5);
        mapM1348of.put(k6, v6);
        return mapM1348of;
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> Map<K, V> m1355of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        Map<K, V> mapM1348of = m1348of();
        mapM1348of.put(k, v);
        mapM1348of.put(k2, v2);
        mapM1348of.put(k3, v3);
        mapM1348of.put(k4, v4);
        mapM1348of.put(k5, v5);
        mapM1348of.put(k6, v6);
        mapM1348of.put(k7, v7);
        return mapM1348of;
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static final class Builder<K, V> {
        private Map mMap;
        private boolean mUnderConstruction;

        private Builder() {
            this.mMap = MapBuilder.newHashMap();
            this.mUnderConstruction = true;
        }

        public Builder<K, V> put(K k, V v) {
            if (!this.mUnderConstruction) {
                throw new IllegalStateException("Underlying map has already been built");
            }
            this.mMap.put(k, v);
            return this;
        }

        public Map<K, V> build() {
            if (!this.mUnderConstruction) {
                throw new IllegalStateException("Underlying map has already been built");
            }
            this.mUnderConstruction = false;
            return this.mMap;
        }
    }
}
