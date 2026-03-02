package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzac<K, V> implements zzbh<K, V> {

    @NullableDecl
    private transient Set<K> zza;

    @NullableDecl
    private transient Map<K, Collection<V>> zzb;

    zzac() {
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbh) {
            return zzq().equals(((zzbh) obj).zzq());
        }
        return false;
    }

    public final int hashCode() {
        return zzq().hashCode();
    }

    public final String toString() {
        return ((zzs) zzq()).zza.toString();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbh
    public boolean zzd(@NullableDecl K k, @NullableDecl V v) {
        throw null;
    }

    abstract Set<K> zzh();

    abstract Map<K, Collection<V>> zzi();

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbh
    public final Set<K> zzp() {
        Set<K> set = this.zza;
        if (set != null) {
            return set;
        }
        Set<K> setZzh = zzh();
        this.zza = setZzh;
        return setZzh;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbh
    public final Map<K, Collection<V>> zzq() {
        Map<K, Collection<V>> map = this.zzb;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> mapZzi = zzi();
        this.zzb = mapZzi;
        return mapZzi;
    }
}
