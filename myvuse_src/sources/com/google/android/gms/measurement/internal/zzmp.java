package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzmp implements Runnable {
    long zza;
    long zzb;
    final /* synthetic */ zzmm zzc;

    zzmp(zzmm zzmmVar, long j, long j2) {
        this.zzc = zzmmVar;
        this.zza = j;
        this.zzb = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzmo
            @Override // java.lang.Runnable
            public final void run() {
                zzmp zzmpVar = this.zza;
                zzmm zzmmVar = zzmpVar.zzc;
                long j = zzmpVar.zza;
                long j2 = zzmpVar.zzb;
                zzmmVar.zza.zzt();
                zzmmVar.zza.zzj().zzc().zza("Application going to the background");
                zzmmVar.zza.zzk().zzn.zza(true);
                zzmmVar.zza.zza(true);
                if (!zzmmVar.zza.zze().zzv()) {
                    if (zzmmVar.zza.zze().zza(zzbh.zzci)) {
                        zzmmVar.zza.zza(false, false, j2);
                        zzmmVar.zza.zzb.zzb(j2);
                    } else {
                        zzmmVar.zza.zzb.zzb(j2);
                        zzmmVar.zza.zza(false, false, j2);
                    }
                }
                zzmmVar.zza.zzj().zzn().zza("Application backgrounded at: timestamp_millis", Long.valueOf(j));
            }
        });
    }
}
