package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzib implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzhn zzb;

    zzib(zzhn zzhnVar, zzn zznVar) {
        this.zza = zznVar;
        this.zzb = zzhnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzr();
        zznc zzncVar = this.zzb.zza;
        zzn zznVar = this.zza;
        zzncVar.zzl().zzt();
        zzncVar.zzs();
        Preconditions.checkNotEmpty(zznVar.zza);
        if (zzncVar.zze().zza(zzbh.zzcl)) {
            zzncVar.zzf(zznVar);
            zzncVar.zze(zznVar);
            return;
        }
        zzin zzinVarZza = zzin.zza(zznVar.zzt, zznVar.zzy);
        zzin zzinVarZzb = zzncVar.zzb(zznVar.zza);
        zzncVar.zzj().zzp().zza("Setting storage consent, package, consent", zznVar.zza, zzinVarZza);
        zzncVar.zza(zznVar.zza, zzinVarZza);
        if ((!com.google.android.gms.internal.measurement.zznh.zza() || !zzncVar.zze().zza(zzbh.zzdc)) && zzinVarZza.zzc(zzinVarZzb)) {
            zzncVar.zzd(zznVar);
        }
        zzax zzaxVarZza = zzax.zza(zznVar.zzz);
        if (zzax.zza.equals(zzaxVarZza)) {
            return;
        }
        zzncVar.zzj().zzp().zza("Setting DMA consent. package, consent", zznVar.zza, zzaxVarZza);
        zzncVar.zza(zznVar.zza, zzaxVarZza);
    }
}
