package com.google.android.gms.internal.mlkit_vision_face;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
final class zzak extends AbstractSet {
    final /* synthetic */ zzan zza;

    zzak(zzan zzanVar) {
        this.zza = zzanVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.zza.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzan zzanVar = this.zza;
        Map mapZzc = zzanVar.zzc();
        return mapZzc != null ? mapZzc.keySet().iterator() : new zzaf(zzanVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@NullableDecl Object obj) {
        Map mapZzc = this.zza.zzc();
        return mapZzc != null ? mapZzc.keySet().remove(obj) : this.zza.zzs(obj) != zzan.zzd;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }
}
