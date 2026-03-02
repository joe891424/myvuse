package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzp<E> extends zzo<E> {
    static final zzo<Object> zza = new zzp(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzp(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzf.zza(i, this.zzc, FirebaseAnalytics.Param.INDEX);
        return (E) this.zzb[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzk
    final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzk
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzk
    final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzo, com.google.android.gms.internal.mlkit_vision_common.zzk
    final int zze(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }
}
