package com.google.android.gms.internal.mlkit_common;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzat extends zzaq {
    private final zzas zza = new zzas();

    zzat() {
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzaq
    public final void zza(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        this.zza.zza(th, true).add(th2);
    }
}
