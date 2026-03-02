package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
final class zzr implements Iterator<Map.Entry> {
    final Iterator<Map.Entry> zza;

    @NullableDecl
    Collection zzb;
    final /* synthetic */ zzs zzc;

    zzr(zzs zzsVar) {
        this.zzc = zzsVar;
        this.zza = zzsVar.zza.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Map.Entry next() {
        Map.Entry next = this.zza.next();
        this.zzb = (Collection) next.getValue();
        zzs zzsVar = this.zzc;
        Object key = next.getKey();
        return new zzat(key, zzsVar.zzb.zza(key, (Collection) next.getValue()));
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzl.zza(this.zzb != null, "no calls to next() since the last call to remove()");
        this.zza.remove();
        zzaa.zzn(this.zzc.zzb, this.zzb.size());
        this.zzb.clear();
        this.zzb = null;
    }
}
