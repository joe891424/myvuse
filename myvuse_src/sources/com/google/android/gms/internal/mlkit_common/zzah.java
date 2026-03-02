package com.google.android.gms.internal.mlkit_common;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzah<E> extends zzab<E> {
    private final zzaj<E> zza;

    zzah(zzaj<E> zzajVar, int i) {
        super(zzajVar.size(), i);
        this.zza = zzajVar;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzab
    protected final E zza(int i) {
        return this.zza.get(i);
    }
}
