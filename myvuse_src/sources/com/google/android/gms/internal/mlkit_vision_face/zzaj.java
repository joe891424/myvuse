package com.google.android.gms.internal.mlkit_vision_face;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzaj<T> implements Iterator<T> {
    int zzb;
    int zzc;
    int zzd = -1;
    final /* synthetic */ zzan zze;

    /* synthetic */ zzaj(zzan zzanVar, zzaf zzafVar) {
        this.zze = zzanVar;
        this.zzb = zzanVar.zzf;
        this.zzc = zzanVar.zzf();
    }

    private final void zzb() {
        if (this.zze.zzf != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzc >= 0;
    }

    @Override // java.util.Iterator
    public final T next() {
        zzb();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.zzc;
        this.zzd = i;
        T tZza = zza(i);
        this.zzc = this.zze.zzg(this.zzc);
        return tZza;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzb();
        zzl.zza(this.zzd >= 0, "no calls to next() since the last call to remove()");
        this.zzb += 32;
        zzan zzanVar = this.zze;
        zzanVar.remove(zzanVar.zzb[this.zzd]);
        this.zzc--;
        this.zzd = -1;
    }

    abstract T zza(int i);
}
