package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkg implements Runnable {
    private final /* synthetic */ zzin zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ long zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ zzin zze;
    private final /* synthetic */ zziz zzf;

    zzkg(zziz zzizVar, zzin zzinVar, long j, long j2, boolean z, zzin zzinVar2) {
        this.zza = zzinVar;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = z;
        this.zze = zzinVar2;
        this.zzf = zzizVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzf.zza(this.zza);
        if (!com.google.android.gms.internal.measurement.zznh.zza() || !this.zzf.zze().zza(zzbh.zzdb)) {
            this.zzf.zza(this.zzb, false);
        }
        zziz.zza(this.zzf, this.zza, this.zzc, true, this.zzd);
        zziz.zza(this.zzf, this.zza, this.zze);
    }
}
