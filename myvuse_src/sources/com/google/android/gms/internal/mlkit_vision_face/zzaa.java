package com.google.android.gms.internal.mlkit_vision_face;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzaa<K, V> extends zzac<K, V> implements Serializable {
    private transient Map<K, Collection<V>> zza;
    private transient int zzb;

    protected zzaa(Map<K, Collection<V>> map) {
        if (!map.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.zza = map;
    }

    static /* synthetic */ int zzk(zzaa zzaaVar) {
        int i = zzaaVar.zzb;
        zzaaVar.zzb = i - 1;
        return i;
    }

    static /* synthetic */ int zzl(zzaa zzaaVar) {
        int i = zzaaVar.zzb;
        zzaaVar.zzb = i + 1;
        return i;
    }

    static /* synthetic */ int zzm(zzaa zzaaVar, int i) {
        int i2 = zzaaVar.zzb + i;
        zzaaVar.zzb = i2;
        return i2;
    }

    static /* synthetic */ int zzn(zzaa zzaaVar, int i) {
        int i2 = zzaaVar.zzb - i;
        zzaaVar.zzb = i2;
        return i2;
    }

    static /* synthetic */ void zzo(zzaa zzaaVar, Object obj) {
        Collection<V> collectionRemove;
        Map<K, Collection<V>> map = zzaaVar.zza;
        map.getClass();
        try {
            collectionRemove = map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            collectionRemove = null;
        }
        Collection<V> collection = collectionRemove;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            zzaaVar.zzb -= size;
        }
    }

    Collection<V> zza(@NullableDecl K k, Collection<V> collection) {
        throw null;
    }

    abstract Collection<V> zzc();

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzac, com.google.android.gms.internal.mlkit_vision_face.zzbh
    public final boolean zzd(@NullableDecl K k, @NullableDecl V v) {
        Collection<V> collection = this.zza.get(k);
        if (collection != null) {
            if (!collection.add(v)) {
                return false;
            }
            this.zzb++;
            return true;
        }
        Collection<V> collectionZzc = zzc();
        if (!collectionZzc.add(v)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.zzb++;
        this.zza.put(k, collectionZzc);
        return true;
    }

    public final void zze() {
        Iterator<Collection<V>> it2 = this.zza.values().iterator();
        while (it2.hasNext()) {
            it2.next().clear();
        }
        this.zza.clear();
        this.zzb = 0;
    }

    public final Collection<V> zzf(@NullableDecl K k) {
        Collection<V> collectionZzc = this.zza.get(k);
        if (collectionZzc == null) {
            collectionZzc = zzc();
        }
        return zza(k, collectionZzc);
    }

    final List<V> zzg(@NullableDecl K k, List<V> list, @NullableDecl zzx zzxVar) {
        return list instanceof RandomAccess ? new zzv(this, k, list, zzxVar) : new zzz(this, k, list, zzxVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzac
    final Set<K> zzh() {
        return new zzu(this, this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzac
    final Map<K, Collection<V>> zzi() {
        return new zzs(this, this.zza);
    }
}
