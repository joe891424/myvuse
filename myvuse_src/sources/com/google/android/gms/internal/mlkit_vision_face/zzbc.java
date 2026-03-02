package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzbc<K, V> extends zzbk<Map.Entry<K, V>> {
    zzbc() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        zza().clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object objZza = zzbg.zza(zza(), key);
        if (zzg.zza(objZza, entry.getValue())) {
            return objZza != null || zzbg.zzb(((zzs) zza()).zza, key);
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return zza().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (contains(obj)) {
            return ((zzs) zza()).zzb.zzp().remove(((Map.Entry) obj).getKey());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbk, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection<?> collection) {
        try {
            if (collection != null) {
                return zzbl.zzb(this, collection);
            }
            throw null;
        } catch (UnsupportedOperationException unused) {
            return zzbl.zza(this, collection.iterator());
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbk, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection<?> collection) {
        int i;
        try {
            if (collection != null) {
                return super.retainAll(collection);
            }
            throw null;
        } catch (UnsupportedOperationException unused) {
            int size = collection.size();
            if (size >= 3) {
                i = size < 1073741824 ? (int) ((size / 0.75f) + 1.0f) : Integer.MAX_VALUE;
            } else {
                if (size < 0) {
                    StringBuilder sb = new StringBuilder(52);
                    sb.append("expectedSize cannot be negative but was: ");
                    sb.append(size);
                    throw new IllegalArgumentException(sb.toString());
                }
                i = size + 1;
            }
            HashSet hashSet = new HashSet(i);
            for (Object obj : collection) {
                if (contains(obj)) {
                    hashSet.add(((Map.Entry) obj).getKey());
                }
            }
            return ((zzs) zza()).zzb.zzp().retainAll(hashSet);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return zza().size();
    }

    abstract Map<K, V> zza();
}
