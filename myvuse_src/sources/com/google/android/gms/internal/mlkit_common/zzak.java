package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzak<E> extends zzaj<E> {
    static final zzaj<Object> zza = new zzak(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzak(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzz.zzb(i, this.zzc, FirebaseAnalytics.Param.INDEX);
        return (E) this.zzb[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzaf
    final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzaf
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzaf
    final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzaj, com.google.android.gms.internal.mlkit_common.zzaf
    final int zze(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }
}
