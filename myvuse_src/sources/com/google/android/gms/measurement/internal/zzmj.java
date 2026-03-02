package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzmj implements Runnable {
    private final /* synthetic */ zznc zza;
    private final /* synthetic */ Runnable zzb;

    zzmj(zzme zzmeVar, zznc zzncVar, Runnable runnable) {
        this.zza = zzncVar;
        this.zzb = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzr();
        this.zza.zza(this.zzb);
        this.zza.zzw();
    }
}
