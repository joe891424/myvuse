package com.google.android.gms.internal.mlkit_vision_common;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzv extends zzs {
    private final zzu zza = new zzu();

    zzv() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzs
    public final void zza(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        this.zza.zza(th, true).add(th2);
    }
}
