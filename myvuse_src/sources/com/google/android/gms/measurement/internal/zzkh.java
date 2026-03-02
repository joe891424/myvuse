package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkh implements Runnable {
    private final /* synthetic */ zzax zza;
    private final /* synthetic */ zziz zzb;

    zzkh(zziz zzizVar, zzax zzaxVar) {
        this.zza = zzaxVar;
        this.zzb = zzizVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.zzb.zzk().zza(this.zza)) {
            this.zzb.zzj().zzn().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(this.zza.zza()));
            return;
        }
        this.zzb.zzj().zzp().zza("Setting DMA consent. consent", this.zza);
        if (this.zzb.zze().zza(zzbh.zzcl) && this.zzb.zzo().zzan()) {
            this.zzb.zzo().zzai();
        } else {
            this.zzb.zzo().zza(false);
        }
    }
}
