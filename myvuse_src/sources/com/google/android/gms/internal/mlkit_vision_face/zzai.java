package com.google.android.gms.internal.mlkit_vision_face;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
final class zzai extends AbstractSet<Map.Entry> {
    final /* synthetic */ zzan zza;

    zzai(zzan zzanVar) {
        this.zza = zzanVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@NullableDecl Object obj) {
        Map mapZzc = this.zza.zzc();
        if (mapZzc != null) {
            return mapZzc.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int iZzr = this.zza.zzr(entry.getKey());
            if (iZzr != -1 && zzg.zza(this.zza.zzc[iZzr], entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry> iterator() {
        zzan zzanVar = this.zza;
        Map mapZzc = zzanVar.zzc();
        return mapZzc != null ? mapZzc.entrySet().iterator() : new zzag(zzanVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@NullableDecl Object obj) {
        Map mapZzc = this.zza.zzc();
        if (mapZzc != null) {
            return mapZzc.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (this.zza.zzb()) {
            return false;
        }
        int iZzp = this.zza.zzp();
        Object key = entry.getKey();
        Object value = entry.getValue();
        Object obj2 = this.zza.zze;
        zzan zzanVar = this.zza;
        int iZze = zzao.zze(key, value, iZzp, obj2, zzanVar.zza, zzanVar.zzb, zzanVar.zzc);
        if (iZze == -1) {
            return false;
        }
        this.zza.zze(iZze, iZzp);
        zzan.zzn(this.zza);
        this.zza.zzd();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }
}
