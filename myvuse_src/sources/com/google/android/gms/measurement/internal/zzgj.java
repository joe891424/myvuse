package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgj implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzgg zzb;

    zzgj(zzgg zzggVar, boolean z) {
        this.zza = z;
        this.zzb = zzggVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zza(this.zza);
    }
}
