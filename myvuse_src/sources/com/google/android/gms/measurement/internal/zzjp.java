package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzjp implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zziz zzb;

    zzjp(zziz zzizVar, long j) {
        this.zza = j;
        this.zzb = zzizVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzk().zzf.zza(this.zza);
        this.zzb.zzj().zzc().zza("Session timeout duration set", Long.valueOf(this.zza));
    }
}
