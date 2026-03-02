package com.google.android.gms.internal.mlkit_vision_common;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzm<E> extends zzh<E> {
    private final zzo<E> zza;

    zzm(zzo<E> zzoVar, int i) {
        super(zzoVar.size(), i);
        this.zza = zzoVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzh
    protected final E zza(int i) {
        return this.zza.get(i);
    }
}
