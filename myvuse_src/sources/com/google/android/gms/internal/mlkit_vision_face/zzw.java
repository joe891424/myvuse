package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
class zzw implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzx zzc;

    zzw(zzx zzxVar) {
        this.zzc = zzxVar;
        this.zzb = zzxVar.zzb;
        Collection collection = zzxVar.zzb;
        this.zza = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    zzw(zzx zzxVar, Iterator it2) {
        this.zzc = zzxVar;
        this.zzb = zzxVar.zzb;
        this.zza = it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        zza();
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zza.remove();
        zzaa.zzk(this.zzc.zze);
        this.zzc.zzb();
    }

    final void zza() {
        this.zzc.zza();
        if (this.zzc.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }
}
