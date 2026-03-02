package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzmb implements Runnable {
    private final /* synthetic */ zzfp zza;
    private final /* synthetic */ zzlw zzb;

    zzmb(zzlw zzlwVar, zzfp zzfpVar) {
        this.zza = zzfpVar;
        this.zzb = zzlwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb) {
            this.zzb.zzb = false;
            if (!this.zzb.zza.zzak()) {
                this.zzb.zza.zzj().zzc().zza("Connected to remote service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}
