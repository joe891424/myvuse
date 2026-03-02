package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
final class zzs extends zzbf {
    final transient Map zza;
    final /* synthetic */ zzaa zzb;

    zzs(zzaa zzaaVar, Map map) {
        this.zzb = zzaaVar;
        this.zza = map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (this.zza == this.zzb.zza) {
            this.zzb.zze();
        } else {
            zzay.zza(new zzr(this));
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return zzbg.zzb(this.zza, obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(@NullableDecl Object obj) {
        return this == obj || this.zza.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        Collection collection = (Collection) zzbg.zza(this.zza, obj);
        if (collection == null) {
            return null;
        }
        return this.zzb.zza(obj, collection);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbf, java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return this.zzb.zzp();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        Collection collection = (Collection) this.zza.remove(obj);
        if (collection == null) {
            return null;
        }
        Collection collectionZzc = this.zzb.zzc();
        collectionZzc.addAll(collection);
        zzaa.zzn(this.zzb, collection.size());
        collection.clear();
        return collectionZzc;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zza.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.zza.toString();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbf
    protected final Set<Map.Entry> zza() {
        return new zzq(this);
    }
}
