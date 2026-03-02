package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkj implements Runnable {
    private final /* synthetic */ zzin zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzin zzd;
    private final /* synthetic */ zziz zze;

    zzkj(zziz zzizVar, zzin zzinVar, long j, boolean z, zzin zzinVar2) {
        this.zza = zzinVar;
        this.zzb = j;
        this.zzc = z;
        this.zzd = zzinVar2;
        this.zze = zzizVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zza(this.zza);
        zziz.zza(this.zze, this.zza, this.zzb, false, this.zzc);
        zziz.zza(this.zze, this.zza, this.zzd);
    }
}
